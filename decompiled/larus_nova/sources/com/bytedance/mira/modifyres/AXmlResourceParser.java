package com.bytedance.mira.modifyres;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes21.dex */
public class AXmlResourceParser {
    public static final int ATTRIBUTE_IX_NAME = 1;
    public static final int ATTRIBUTE_IX_NAMESPACE_URI = 0;
    public static final int ATTRIBUTE_IX_VALUE_DATA = 4;
    public static final int ATTRIBUTE_IX_VALUE_STRING = 2;
    public static final int ATTRIBUTE_IX_VALUE_TYPE = 3;
    public static final int ATTRIBUTE_LENGTH = 5;
    private static final int CHUNK_AXML_FILE = 524291;
    private static final int CHUNK_AXML_FILE_BROKEN = 524289;
    private static final int CHUNK_RESOURCEIDS = 524672;
    private static final int CHUNK_XML_END_NAMESPACE = 1048833;
    private static final int CHUNK_XML_END_TAG = 1048835;
    private static final int CHUNK_XML_FIRST = 1048832;
    private static final int CHUNK_XML_LAST = 1048836;
    private static final int CHUNK_XML_START_NAMESPACE = 1048832;
    private static final int CHUNK_XML_START_TAG = 1048834;
    private static final int CHUNK_XML_TEXT = 1048836;
    public static final int INT_COUNT = 4;
    int END_DOCUMENT;
    int END_TAG;
    int START_DOCUMENT;
    int START_TAG;
    int TEXT;
    private final byte[] bytes;
    HashMap<Integer, Integer> hostIx2NewResId;
    private int[] m_attributes;
    private int m_classAttribute;
    private boolean m_decreaseDepth;
    private int m_event;
    private final NamespaceStack m_namespaces;
    private boolean m_operational;
    private ExtDataInput m_reader;
    private int[] m_resourceIDs;
    private final IResIdMapper mapper;
    boolean needReorderXmlAttr;

    public static final class NamespaceStack {
        private int[] m_data;
        private int m_dataLength;
        private int m_depth;

        public void increaseDepth() {
            ensureDataCapacity(2);
            int r100 = this.m_dataLength;
            int[] r101 = this.m_data;
            r101[r100] = 0;
            r101[r100 + 1] = 0;
            this.m_dataLength = r100 + 2;
            this.m_depth++;
        }

        public void reset() {
            this.m_dataLength = 0;
            this.m_depth = 0;
        }

        public void decreaseDepth() {
            int r100 = this.m_dataLength;
            if (r100 != 0) goto L5;
            return;
        L5:
            int r101 = r100 - 1;
            int r102 = this.m_data[r101] * 2;
            if (((r101 - 1) - r102) != 0) goto L8;
            return;
        L8:
            this.m_dataLength = r100 - (r102 + 2);
            this.m_depth--;
        }

        public int getCurrentCount() {
            int r100 = this.m_dataLength;
            if (r100 != 0) goto L7;
            return 0;
        L7:
            return this.m_data[r100 - 1];
        }

        public boolean pop() {
            int r100 = this.m_dataLength;
            if (r100 != 0) goto L5;
            return false;
        L5:
            int r101 = r100 - 1;
            int[] r102 = this.m_data;
            int r103 = r102[r101];
            if (r103 != 0) goto L8;
            return false;
        L8:
            int r104 = r103 - 1;
            int r105 = r101 - 2;
            r102[r105] = r104;
            r102[r105 - ((r104 * 2) + 1)] = r104;
            this.m_dataLength = r100 - 2;
            return true;
        }

        public NamespaceStack() {
            this.m_data = new int[32];
        }

        public int getDepth() {
            return this.m_depth;
        }

        private void ensureDataCapacity(int r100) {
            int[] r101 = this.m_data;
            int r102 = r101.length;
            int r103 = this.m_dataLength;
            int r104 = r102 - r103;
            if (r104 <= r100) goto L5;
            return;
        L5:
            int[] r105 = new int[(r101.length + r104) * 2];
            System.arraycopy(r101, 0, r105, 0, r103);
            this.m_data = r105;
        }

        public void push(int r100, int r101) {
            if (this.m_depth != 0) goto L5;
            increaseDepth();
        L5:
            ensureDataCapacity(2);
            int r102 = this.m_dataLength;
            int r103 = r102 - 1;
            int[] r104 = this.m_data;
            int r105 = r104[r103];
            int r106 = (r103 - 1) - (r105 * 2);
            int r107 = r105 + 1;
            r104[r106] = r107;
            r104[r103] = r100;
            r104[r103 + 1] = r101;
            r104[r103 + 2] = r107;
            this.m_dataLength = r102 + 2;
        }
    }

    private void resetEventInfo() {
        this.m_event = -1;
        this.m_attributes = null;
        this.m_classAttribute = -1;
    }

    public String getName() {
        return "";
    }

    public String getText() {
        return "";
    }

    private void doNext() throws IOException {
        if (this.m_operational == true) goto L5;
        this.m_reader.skipCheckInt(CHUNK_AXML_FILE, CHUNK_AXML_FILE_BROKEN);
        this.m_reader.skipInt();
        StringBlock.read(this.m_reader);
        this.m_namespaces.increaseDepth();
        this.m_operational = true;
    L5:
        int r100 = this.m_event;
        if (r100 != this.END_DOCUMENT) goto L8;
        return;
    L8:
        resetEventInfo();
    L9:
        int r101 = 0;
        if (this.m_decreaseDepth == false) goto L13;
        this.m_decreaseDepth = false;
        this.m_namespaces.decreaseDepth();
    L13:
        if (r100 != this.END_TAG) goto L20;
        if (this.m_namespaces.getDepth() != 1) goto L20;
        if (this.m_namespaces.getCurrentCount() != 0) goto L20;
        this.m_event = this.END_DOCUMENT;
        return;
    L20:
        if (r100 != this.START_DOCUMENT) goto L22;
        int r102 = CHUNK_XML_START_TAG;
    L24:
        if (r102 == CHUNK_RESOURCEIDS) goto L25;
        if (r102 < 1048832) goto L88;
        if (r102 > 1048836) goto L88;
        if (r102 == CHUNK_XML_START_TAG) goto L47;
    L49:
        this.m_reader.skipInt();
        this.m_reader.readInt();
        this.m_reader.skipInt();
        if (r102 == 1048832) goto L84;
        if (r102 == CHUNK_XML_END_NAMESPACE) goto L84;
        if (r102 == CHUNK_XML_START_TAG) goto L55;
        if (r102 == CHUNK_XML_END_TAG) goto L80;
        if (r102 != 1048836) goto L9;
        this.m_reader.readInt();
        this.m_reader.skipInt();
        this.m_reader.skipInt();
        this.m_event = this.TEXT;
        return;
    L80:
        this.m_reader.readInt();
        this.m_reader.readInt();
        this.m_event = this.END_TAG;
        this.m_decreaseDepth = true;
        return;
    L55:
        this.m_reader.readInt();
        this.m_reader.readInt();
        this.m_reader.skipInt();
        int r103 = this.m_reader.readInt() & 65535;
        this.m_classAttribute = (65535 & this.m_reader.readInt()) - 1;
        int r104 = ResReplaceUtils.getCount(this.m_reader);
        int r105 = r103 * 5;
        this.m_attributes = this.m_reader.readIntArray(r105);
        int r106 = 3;
    L56:
        int[] r107 = this.m_attributes;
        if (r106 >= r107.length) goto L60;
        r107[r106] = r107[r106] >>> 24;
        r106 = r106 + 5;
        goto L56
    L60:
        if (r107.length != r105) goto L77;
        boolean r108 = false;
    L62:
        if (r101 >= r103) goto L71;
        int r109 = r101 * 5;
        if (this.hostIx2NewResId.containsKey(Integer.valueOf(this.m_attributes[r109 + 1])) == false) goto L66;
        r108 = true;
    L66:
        int[] r110 = this.m_attributes;
        int r111 = r110[r109 + 3];
        if (r111 == 1) goto L69;
        if (r111 == 2) goto L69;
    L70:
        r101 = r101 + 1;
    L69:
        int r112 = r109 + 4;
        ResReplaceUtils.replaceResId(this.bytes, r110[r112], (r112 * 4) + r104, this.mapper);
        goto L70
    L71:
        if (r108 == true) goto L73;
    L75:
        this.m_namespaces.increaseDepth();
        this.m_event = this.START_TAG;
        return;
    L73:
        if (this.needReorderXmlAttr == false) goto L75;
        ResReplaceUtils.reorderAttributeForNode(r104, this.bytes, this.m_attributes, r103, this.hostIx2NewResId);
        goto L75
    L77:
        throw new RuntimeException();
    L84:
        if (r102 == 1048832) goto L85;
        this.m_reader.skipInt();
        this.m_reader.skipInt();
        this.m_namespaces.pop();
        goto L9
    L85:
        this.m_namespaces.push(this.m_reader.readInt(), this.m_reader.readInt());
        goto L9
    L47:
        if (r100 != (-1)) goto L49;
        this.m_event = this.START_DOCUMENT;
        return;
    L88:
        throw new IOException("Invalid chunk type (" + r102 + ").");
    L25:
        this.hostIx2NewResId.clear();
        int r113 = this.m_reader.readInt();
        if (r113 < 8) goto L40;
        if ((r113 % 4) != 0) goto L40;
        int r114 = ResReplaceUtils.getCount(this.m_reader);
        this.m_resourceIDs = this.m_reader.readIntArray((r113 / 4) - 2);
        ArrayList r115 = new ArrayList();
    L30:
        int[] r116 = this.m_resourceIDs;
        if (r101 >= r116.length) goto L36;
        int r117 = ResReplaceUtils.replaceResId(this.bytes, r116[r101], (r101 * 4) + r114, this.mapper);
        if (r117 < 2130706432) goto L35;
        this.hostIx2NewResId.put(Integer.valueOf(r101), Integer.valueOf(r117));
        r115.add(Integer.valueOf(r117));
    L35:
        r101 = r101 + 1;
        goto L30
    L36:
        ArrayList r118 = new ArrayList(r115);
        Collections.sort(r118);
        if (r115.equals(r118) == true) goto L9;
        this.needReorderXmlAttr = true;
    L40:
        throw new IOException("Invalid resource ids size (" + r113 + ").");
    L22:
        r102 = this.m_reader.readInt();
        goto L24
    }

    public void close() {
        if (this.m_operational == true) goto L5;
        return;
    L5:
        this.m_operational = false;
        this.m_reader = null;
        this.m_resourceIDs = null;
        this.m_namespaces.reset();
        resetEventInfo();
    }

    public int next() throws IOException {
        if (this.m_reader == null) goto L10;
        doNext();     // Catch: IOException -> L6
        return this.m_event;
    L6:
        e = move-exception;
        close();
        throw e;
    L10:
        throw new RuntimeException("Parser is not opened.");
    }

    public int nextToken() throws IOException {
        return next();
    }

    public void open(InputStream r100) {
        close();
        if (r100 == null) goto L6;
        this.m_reader = new ExtDataInput(new LittleEndianDataInputStream(new CountingInputStream(r100)));
        return;
    }

    public void setInput(InputStream r100) {
        open(r100);
    }

    public AXmlResourceParser(byte[] r100, IResIdMapper r101) {
        this.hostIx2NewResId = new HashMap();
        this.needReorderXmlAttr = false;
        this.m_operational = false;
        this.m_namespaces = new NamespaceStack();
        this.START_DOCUMENT = 0;
        this.END_DOCUMENT = 1;
        this.START_TAG = 2;
        this.END_TAG = 3;
        this.TEXT = 4;
        this.mapper = r101;
        this.bytes = r100;
        resetEventInfo();
    }
}
