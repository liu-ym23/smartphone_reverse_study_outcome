package com.ss.android.socialbase.appdownloader.util.package_info;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: loaded from: classes38.dex */
class AXmlResourceParser implements XmlResourceParser {
    private int[] m_attributes;
    private int m_classAttribute;
    private boolean m_decreaseDepth;
    private int m_event;
    private int m_idAttribute;
    private int m_lineNumber;
    private int m_name;
    private int m_namespaceUri;
    private NamespaceStack m_namespaces;
    private boolean m_operational;
    private IntReader m_reader;
    private int[] m_resourceIDs;
    private StringBlock m_strings;
    private int m_styleAttribute;

    public static final class NamespaceStack {
        private int[] m_data;
        private int m_dataLength;
        private int m_depth;

        public final void increaseDepth() {
            ensureDataCapacity(2);
            int r100 = this.m_dataLength;
            int[] r101 = this.m_data;
            r101[r100] = 0;
            r101[r100 + 1] = 0;
            this.m_dataLength = r100 + 2;
            this.m_depth++;
        }

        public final void reset() {
            this.m_dataLength = 0;
            this.m_depth = 0;
        }

        public final void decreaseDepth() {
            int r100 = this.m_dataLength;
            if (r100 == 0) goto L8;
            int r101 = r100 - 1;
            int r102 = this.m_data[r101] * 2;
            if (((r101 - 1) - r102) == 0) goto L9;
            this.m_dataLength = r100 - (r102 + 2);
            this.m_depth--;
            return;
        L9:
            return;
        }

        public final int getCurrentCount() {
            int r100 = this.m_dataLength;
            if (r100 != 0) goto L7;
            return 0;
        L7:
            return this.m_data[r100 - 1];
        }

        public final boolean pop() {
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

        public final int getDepth() {
            return this.m_depth;
        }

        private void ensureDataCapacity(int r100) {
            int[] r101 = this.m_data;
            int r102 = r101.length;
            int r103 = this.m_dataLength;
            int r104 = r102 - r103;
            if (r104 > r100) goto L6;
            int[] r105 = new int[(r101.length + r104) * 2];
            System.arraycopy(r101, 0, r105, 0, r103);
            this.m_data = r105;
            return;
        }

        public final int findPrefix(int r100) {
            return find(r100, false);
        }

        public final int getAccumulatedCount(int r100) {
            int r101 = 0;
            if (this.m_dataLength == 0) goto L11;
            if (r100 < 0) goto L11;
            int r102 = this.m_depth;
            if (r100 <= r102) goto L8;
            r100 = r102;
        L8:
            int r103 = 0;
        L9:
            if (r100 == 0) goto L11;
            int r104 = this.m_data[r103];
            r101 = r101 + r104;
            r103 = r103 + ((r104 * 2) + 2);
            r100 = r100 - 1;
        L11:
            return r101;
        }

        public final int getPrefix(int r100) {
            return get(r100, true);
        }

        public final int getUri(int r100) {
            return get(r100, false);
        }

        private final int find(int r100, boolean r101) {
            int r102 = this.m_dataLength;
            if (r102 != 0) goto L5;
            return -1;
        L5:
            int r103 = r102 - 1;
            int r104 = this.m_depth;
        L6:
            if (r104 == 0) goto L20;
            int r105 = this.m_data[r103];
            r103 = r103 - 2;
        L8:
            if (r105 == 0) goto L19;
            if (r101 == false) goto L14;
            int[] r106 = this.m_data;
            if (r106[r103] != r100) goto L18;
            return r106[r103 + 1];
        L18:
            r103 = r103 - 2;
            r105 = r105 - 1;
            goto L8
        L14:
            int[] r107 = this.m_data;
            if (r107[r103 + 1] != r100) goto L18;
            return r107[r103];
        L19:
            r104 = r104 - 1;
            goto L6
        L20:
            return -1;
        }

        private final int get(int r100, boolean r101) {
            if (this.m_dataLength == 0) goto L15;
            if (r100 < 0) goto L15;
            int r102 = this.m_depth;
            int r103 = 0;
        L6:
            if (r102 == 0) goto L15;
            int[] r104 = this.m_data;
            int r105 = r104[r103];
            if (r100 < r105) goto L9;
            r100 = r100 - r105;
            r103 = r103 + ((r105 * 2) + 2);
            r102 = r102 - 1;
            goto L6
        L9:
            int r106 = r103 + ((r100 * 2) + 1);
            if (r101 == true) goto L13;
            r106 = r106 + 1;
        L13:
            return r104[r106];
        L15:
            return -1;
        }

        public final void push(int r100, int r101) {
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

    private final void resetEventInfo() {
        this.m_event = -1;
        this.m_lineNumber = -1;
        this.m_name = -1;
        this.m_namespaceUri = -1;
        this.m_attributes = null;
        this.m_idAttribute = -1;
        this.m_classAttribute = -1;
        this.m_styleAttribute = -1;
    }

    public int getAttributeListValue(int r100, String[] r101, int r102) {
        return 0;
    }

    public int getAttributeListValue(String r100, String r101, String[] r102, int r103) {
        return 0;
    }

    public String getAttributeType(int r100) {
        return "CDATA";
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public int getColumnNumber() {
        return -1;
    }

    public boolean getFeature(String r100) {
        return false;
    }

    public String getInputEncoding() {
        return null;
    }

    public Object getProperty(String r100) {
        return null;
    }

    public boolean isAttributeDefault(int r100) {
        return false;
    }

    public boolean isEmptyElementTag() throws XmlPullParserException {
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public boolean isWhitespace() throws XmlPullParserException {
        return false;
    }

    private final void doNext() throws IOException {
        if (this.m_strings != null) goto L5;
        ChunkUtil.readCheckType(this.m_reader, 524291);
        this.m_reader.skipInt();
        this.m_strings = StringBlock.read(this.m_reader);
        this.m_namespaces.increaseDepth();
        this.m_operational = true;
    L5:
        int r100 = this.m_event;
        if (r100 == 1) goto L63;
        resetEventInfo();
    L9:
        if (this.m_decreaseDepth == false) goto L11;
        this.m_decreaseDepth = false;
        this.m_namespaces.decreaseDepth();
    L11:
        int r101 = 3;
        if (r100 != 3) goto L19;
        if (this.m_namespaces.getDepth() != 1) goto L19;
        if (this.m_namespaces.getCurrentCount() != 0) goto L19;
        this.m_event = 1;
        return;
    L19:
        if (r100 != 0) goto L21;
        int r102 = 1048834;
    L23:
        if (r102 == 524672) goto L24;
        if (r102 < 1048832) goto L62;
        if (r102 > 1048836) goto L62;
        if (r102 == 1048834) goto L37;
    L39:
        this.m_reader.skipInt();
        int r103 = this.m_reader.readInt();
        this.m_reader.skipInt();
        if (r102 == 1048832) goto L58;
        if (r102 == 1048833) goto L58;
        this.m_lineNumber = r103;
        if (r102 == 1048834) goto L46;
        if (r102 == 1048835) goto L53;
        if (r102 != 1048836) goto L9;
        this.m_name = this.m_reader.readInt();
        this.m_reader.skipInt();
        this.m_reader.skipInt();
        this.m_event = 4;
        return;
    L53:
        this.m_namespaceUri = this.m_reader.readInt();
        this.m_name = this.m_reader.readInt();
        this.m_event = 3;
        this.m_decreaseDepth = true;
        return;
    L46:
        this.m_namespaceUri = this.m_reader.readInt();
        this.m_name = this.m_reader.readInt();
        this.m_reader.skipInt();
        int r104 = this.m_reader.readInt();
        this.m_idAttribute = (r104 >>> 16) - 1;
        int r105 = this.m_reader.readInt();
        this.m_styleAttribute = (r105 >>> 16) - 1;
        this.m_classAttribute = (65535 & r105) - 1;
        this.m_attributes = this.m_reader.readIntArray((r104 & 65535) * 5);
    L47:
        int[] r106 = this.m_attributes;
        if (r101 >= r106.length) goto L50;
        r106[r101] = r106[r101] >>> 24;
        r101 = r101 + 5;
        goto L47
    L50:
        this.m_namespaces.increaseDepth();
        this.m_event = 2;
        return;
    L58:
        if (r102 == 1048832) goto L59;
        this.m_reader.skipInt();
        this.m_reader.skipInt();
        this.m_namespaces.pop();
        goto L9
    L59:
        this.m_namespaces.push(this.m_reader.readInt(), this.m_reader.readInt());
        goto L9
    L37:
        if (r100 != (-1)) goto L39;
        this.m_event = 0;
        return;
    L62:
        throw new IOException("Invalid chunk type (" + r102 + ").");
    L24:
        int r107 = this.m_reader.readInt();
        if (r107 < 8) goto L30;
        if ((r107 % 4) != 0) goto L30;
        this.m_resourceIDs = this.m_reader.readIntArray((r107 / 4) - 2);
    L30:
        throw new IOException("Invalid resource ids size (" + r107 + ").");
    L21:
        r102 = this.m_reader.readInt();
        goto L23
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlResourceParser
    public void close() {
        if (this.m_operational == false) goto L6;
        this.m_operational = false;
        this.m_reader.close();
        this.m_reader = null;
        this.m_strings = null;
        this.m_resourceIDs = null;
        this.m_namespaces.reset();
        resetEventInfo();
        return;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser, com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeCount() {
        if (this.m_event == 2) goto L6;
        return -1;
    L6:
        return this.m_attributes.length / 5;
    }

    public String getClassAttribute() {
        int r100 = this.m_classAttribute;
        if (r100 != (-1)) goto L6;
        return null;
    L6:
        int r101 = getAttributeOffset(r100);
        int r102 = this.m_attributes[r101 + 2];
        return this.m_strings.getString(r102);
    }

    public int getDepth() {
        return this.m_namespaces.getDepth() - 1;
    }

    public String getIdAttribute() {
        int r100 = this.m_idAttribute;
        if (r100 != (-1)) goto L6;
        return null;
    L6:
        int r101 = getAttributeOffset(r100);
        int r102 = this.m_attributes[r101 + 2];
        return this.m_strings.getString(r102);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public String getName() {
        int r100 = this.m_name;
        if (r100 == (-1)) goto L9;
        int r101 = this.m_event;
        if (r101 == 2) goto L11;
        if (r101 != 3) goto L9;
    L11:
        return this.m_strings.getString(r100);
    L9:
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public String getNamespace() {
        return this.m_strings.getString(this.m_namespaceUri);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public String getPositionDescription() {
        return "XML line #" + getLineNumber();
    }

    public String getPrefix() {
        int r100 = this.m_namespaces.findPrefix(this.m_namespaceUri);
        return this.m_strings.getString(r100);
    }

    public int getStyleAttribute() {
        int r100 = this.m_styleAttribute;
        if (r100 != (-1)) goto L6;
        return 0;
    L6:
        int r101 = getAttributeOffset(r100);
        return this.m_attributes[r101 + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public String getText() {
        int r100 = this.m_name;
        if (r100 != (-1)) goto L5;
    L7:
        return null;
    L5:
        if (this.m_event != 4) goto L7;
        return this.m_strings.getString(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public int next() throws XmlPullParserException, IOException {
        if (this.m_reader == null) goto L10;
        doNext();     // Catch: IOException -> L6
        return this.m_event;
    L6:
        e = move-exception;
        close();
        throw e;
    L10:
        throw new XmlPullParserException("Parser is not opened.", this, null);
    }

    public AXmlResourceParser() {
        this.m_operational = false;
        this.m_namespaces = new NamespaceStack();
        resetEventInfo();
    }

    public int nextTag() throws XmlPullParserException, IOException {
        int r100 = next();
        if (r100 != 4) goto L8;
        if (isWhitespace() == false) goto L8;
        r100 = next();
    L8:
        if (r100 != 2) goto L10;
    L14:
        return r100;
    L10:
        if (r100 == 3) goto L14;
        throw new XmlPullParserException("Expected start or end tag.", this, null);
    }

    public String nextText() throws XmlPullParserException, IOException {
        if (getEventType() != 2) goto L17;
        int r100 = next();
        if (r100 != 4) goto L11;
        String r101 = getText();
        if (next() != 3) goto L10;
        return r101;
    L10:
        throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
    L11:
        if (r100 != 3) goto L15;
        return "";
    L15:
        throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
    L17:
        throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
    }

    public int nextToken() throws XmlPullParserException, IOException {
        return next();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public int getEventType() throws XmlPullParserException {
        return this.m_event;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser
    public int getLineNumber() {
        return this.m_lineNumber;
    }

    public final StringBlock getStrings() {
        return this.m_strings;
    }

    private final int getAttributeOffset(int r100) {
        if (this.m_event != 2) goto L10;
        int r101 = r100 * 5;
        if (r101 >= this.m_attributes.length) goto L8;
        return r101;
    L8:
        throw new IndexOutOfBoundsException("Invalid attribute index (" + r100 + ").");
    L10:
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser, com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public String getAttributeName(int r100) {
        int r101 = getAttributeOffset(r100);
        int r102 = this.m_attributes[r101 + 1];
        if (r102 != (-1)) goto L6;
        return "";
    L6:
        return this.m_strings.getString(r102);
    }

    public int getAttributeNameResource(int r100) {
        int r101 = getAttributeOffset(r100);
        int r102 = this.m_attributes[r101 + 1];
        int[] r103 = this.m_resourceIDs;
        if (r103 == null) goto L8;
        if (r102 < 0) goto L8;
        if (r102 >= r103.length) goto L8;
        return r103[r102];
    L8:
        return 0;
    }

    public String getAttributeNamespace(int r100) {
        int r101 = getAttributeOffset(r100);
        int r102 = this.m_attributes[r101 + 0];
        if (r102 != (-1)) goto L6;
        return "";
    L6:
        return this.m_strings.getString(r102);
    }

    public String getAttributePrefix(int r100) {
        int r101 = getAttributeOffset(r100);
        int r102 = this.m_attributes[r101 + 0];
        int r103 = this.m_namespaces.findPrefix(r102);
        if (r103 != (-1)) goto L6;
        return "";
    L6:
        return this.m_strings.getString(r103);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.XmlPullParser, com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public String getAttributeValue(int r100) {
        int r101 = getAttributeOffset(r100);
        int[] r102 = this.m_attributes;
        if (r102[r101 + 3] != 3) goto L6;
        int r103 = r102[r101 + 2];
        return this.m_strings.getString(r103);
    L6:
        int r104 = r102[r101 + 4];
        return "";
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeValueData(int r100) {
        int r101 = getAttributeOffset(r100);
        return this.m_attributes[r101 + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeValueType(int r100) {
        int r101 = getAttributeOffset(r100);
        return this.m_attributes[r101 + 3];
    }

    public int getIdAttributeResourceValue(int r100) {
        int r101 = this.m_idAttribute;
        if (r101 != (-1)) goto L5;
        return r100;
    L5:
        int r102 = getAttributeOffset(r101);
        int[] r103 = this.m_attributes;
        if (r103[r102 + 3] == 1) goto L9;
        return r100;
    L9:
        return r103[r102 + 4];
    }

    public String getNamespace(String r100) {
        throw new RuntimeException("Method is not supported.");
    }

    public int getNamespaceCount(int r100) throws XmlPullParserException {
        return this.m_namespaces.getAccumulatedCount(r100);
    }

    public String getNamespacePrefix(int r100) throws XmlPullParserException {
        int r101 = this.m_namespaces.getPrefix(r100);
        return this.m_strings.getString(r101);
    }

    public String getNamespaceUri(int r100) throws XmlPullParserException {
        int r101 = this.m_namespaces.getUri(r100);
        return this.m_strings.getString(r101);
    }

    public char[] getTextCharacters(int[] r100) {
        String r101 = getText();
        if (r101 != null) goto L6;
        return null;
    L6:
        r100[0] = 0;
        r100[1] = r101.length();
        char[] r102 = new char[r101.length()];
        r101.getChars(0, r101.length(), r102, 0);
        return r102;
    }

    public void open(InputStream r100) {
        close();
        if (r100 == null) goto L6;
        this.m_reader = new IntReader(r100, false);
        return;
    }

    public void setInput(Reader r100) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    private final int findAttribute(String r100, String r101) {
        StringBlock r102 = this.m_strings;
        if (r102 == null) goto L22;
        if (r101 == null) goto L22;
        int r103 = r102.find(r101);
        if (r103 != (-1)) goto L8;
        return -1;
    L8:
        if (r100 == null) goto L10;
        int r104 = this.m_strings.find(r100);
    L11:
        int r105 = 0;
    L12:
        int[] r106 = this.m_attributes;
        if (r105 == r106.length) goto L22;
        int r107 = r105 + 1;
        if (r103 != r106[r107]) goto L21;
        if (r104 == (-1)) goto L20;
        if (r104 != r106[r105 + 0]) goto L21;
    L20:
        return r105 / 5;
    L21:
        r105 = r107;
        goto L12
    L10:
        r104 = -1;
    L22:
        return -1;
    }

    public void defineEntityReplacementText(String r100, String r101) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public boolean getAttributeBooleanValue(int r100, boolean r101) {
        if (getAttributeIntValue(r100, r101 ? 1 : 0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public float getAttributeFloatValue(int r100, float r101) {
        int r102 = getAttributeOffset(r100);
        int[] r103 = this.m_attributes;
        if (r103[r102 + 3] == 4) goto L5;
        return r101;
    L5:
        return Float.intBitsToFloat(r103[r102 + 4]);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeIntValue(int r100, int r101) {
        int r102 = getAttributeOffset(r100);
        int[] r103 = this.m_attributes;
        int r104 = r103[r102 + 3];
        if (r104 >= 16) goto L5;
        return r101;
    L5:
        if (r104 <= 31) goto L7;
        return r101;
    L7:
        return r103[r102 + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeResourceValue(int r100, int r101) {
        int r102 = getAttributeOffset(r100);
        int[] r103 = this.m_attributes;
        if (r103[r102 + 3] == 1) goto L5;
        return r101;
    L5:
        return r103[r102 + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.package_info.AttributeSet
    public int getAttributeUnsignedIntValue(int r100, int r101) {
        return getAttributeIntValue(r100, r101);
    }

    public String getAttributeValue(String r100, String r101) {
        int r102 = findAttribute(r100, r101);
        if (r102 != (-1)) goto L6;
        return null;
    L6:
        return getAttributeValue(r102);
    }

    public void setFeature(String r100, boolean r101) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    public void setInput(InputStream r100, String r101) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    public void setProperty(String r100, Object r101) throws XmlPullParserException {
        throw new XmlPullParserException("Method is not supported.");
    }

    public boolean getAttributeBooleanValue(String r100, String r101, boolean r102) {
        int r103 = findAttribute(r100, r101);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return getAttributeBooleanValue(r103, r102);
    }

    public float getAttributeFloatValue(String r100, String r101, float r102) {
        int r103 = findAttribute(r100, r101);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return getAttributeFloatValue(r103, r102);
    }

    public int getAttributeIntValue(String r100, String r101, int r102) {
        int r103 = findAttribute(r100, r101);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return getAttributeIntValue(r103, r102);
    }

    public int getAttributeResourceValue(String r100, String r101, int r102) {
        int r103 = findAttribute(r100, r101);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return getAttributeResourceValue(r103, r102);
    }

    public int getAttributeUnsignedIntValue(String r100, String r101, int r102) {
        int r103 = findAttribute(r100, r101);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return getAttributeUnsignedIntValue(r103, r102);
    }

    public void require(int r100, String r101, String r102) throws XmlPullParserException, IOException {
        if (r100 != getEventType()) goto L12;
        if (r101 != null) goto L6;
    L7:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.equals(getName()) == false) goto L12;
        return;
    L6:
        if (r101.equals(getNamespace()) == true) goto L7;
    L12:
        throw new XmlPullParserException(XmlPullParser.TYPES[r100] + " is expected.", this, null);
    }
}
