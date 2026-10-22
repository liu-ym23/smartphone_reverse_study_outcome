package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Logger;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes38.dex */
public class AXmlResourceParser implements XmlResourceParser {
    private static final String ANDROID_RES_NS = "http://schemas.android.com/apk/res/android";
    private static final String ANDROID_RES_NS_AUTO = "http://schemas.android.com/apk/res-auto";
    private static final int ATTRIBUTE_IX_NAME = 1;
    private static final int ATTRIBUTE_IX_NAMESPACE_URI = 0;
    private static final int ATTRIBUTE_IX_VALUE_DATA = 4;
    private static final int ATTRIBUTE_IX_VALUE_STRING = 2;
    private static final int ATTRIBUTE_IX_VALUE_TYPE = 3;
    private static final int ATTRIBUTE_LENGTH = 5;
    private static final String E_NOT_SUPPORTED = "Method is not supported.";
    private static final Logger LOGGER = null;
    private static final int PRIVATE_PKG_ID = 127;
    private boolean isOperational;
    private int[] mAttributes;
    private int mClassIndex;
    private int mEvent;
    private int mIdIndex;
    private ExtCountingDataInput mIn;
    private int mLineNumber;
    private int mNameIndex;
    private int mNamespaceIndex;
    private final NamespaceStack mNamespaces;
    private int[] mResourceIds;
    private StringBlock mStringBlock;
    private int mStyleIndex;
    private boolean m_decreaseDepth;

    private void resetEventInfo() {
        this.mEvent = -1;
        this.mLineNumber = -1;
        this.mNameIndex = -1;
        this.mNamespaceIndex = -1;
        this.mAttributes = null;
        this.mIdIndex = -1;
        this.mClassIndex = -1;
        this.mStyleIndex = -1;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeListValue(int r100, String[] r101, int r102) {
        return 0;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeListValue(String r100, String r101, String[] r102, int r103) {
        return 0;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getAttributeType(int r100) {
        return "CDATA";
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public int getColumnNumber() {
        return -1;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public boolean getFeature(String r100) {
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getInputEncoding() {
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public Object getProperty(String r100) {
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public boolean isAttributeDefault(int r100) {
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public boolean isEmptyElementTag() {
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public boolean isWhitespace() {
        return false;
    }

    static {
        LOGGER = Logger.getLogger(AXmlResourceParser.class.getName());
    }

    private void doNext() throws IOException {
        if (this.mStringBlock != null) goto L5;
        this.mIn.skipInt();
        this.mIn.skipInt();
        this.mStringBlock = StringBlock.readWithChunk(this.mIn);
        this.mNamespaces.increaseDepth();
        this.isOperational = true;
    L5:
        int r100 = this.mEvent;
        if (r100 != 1) goto L8;
        return;
    L8:
        resetEventInfo();
    L10:
        if (this.m_decreaseDepth == false) goto L12;
        this.m_decreaseDepth = false;
        this.mNamespaces.decreaseDepth();
    L12:
        int r101 = 3;
        if (r100 != 3) goto L20;
        if (this.mNamespaces.getDepth() != 1) goto L20;
        if (this.mNamespaces.getCurrentCount() != 0) goto L20;
        this.mEvent = 1;
        return;
    L20:
        if (r100 != 0) goto L22;
        short r102 = ARSCHeader.RES_XML_START_ELEMENT_TYPE;
        short r103 = 0;
    L24:
        if (r102 == 384) goto L25;
        if (r102 < 256) goto L68;
        if (r102 > 383) goto L68;
        if (r102 == 258) goto L39;
    L41:
        this.mIn.skipInt();
        this.mLineNumber = this.mIn.readInt();
        this.mIn.skipInt();
        if (r102 == 256) goto L62;
        if (r102 == 257) goto L62;
        if (r102 == 258) goto L48;
        if (r102 == 259) goto L58;
        if (r102 != 260) goto L10;
        this.mNameIndex = this.mIn.readInt();
        this.mIn.skipInt();
        this.mIn.skipInt();
        this.mEvent = 4;
        return;
    L58:
        this.mNamespaceIndex = this.mIn.readInt();
        this.mNameIndex = this.mIn.readInt();
        this.mEvent = 3;
        this.m_decreaseDepth = true;
        return;
    L48:
        this.mNamespaceIndex = this.mIn.readInt();
        this.mNameIndex = this.mIn.readInt();
        this.mIn.skipShort();
        short r104 = this.mIn.readShort();
        short r105 = this.mIn.readShort();
        this.mIdIndex = this.mIn.readShort();
        this.mClassIndex = this.mIn.readShort();
        this.mStyleIndex = this.mIn.readShort();
        int r106 = r105 * 5;
        this.mAttributes = this.mIn.readIntArray(r106);
    L49:
        int[] r107 = this.mAttributes;
        if (r101 >= r107.length) goto L52;
        r107[r101] = r107[r101] >>> 24;
        r101 = r101 + 5;
        goto L49
    L52:
        int r108 = r106 * 4;
        int r109 = r104 * r105;
        if (r108 >= r109) goto L55;
        int r110 = r109 - r108;
        this.mIn.skipBytes(r110);
        LOGGER.fine("Skipping " + r110 + " unknown bytes in attributes area.");
    L55:
        this.mNamespaces.increaseDepth();
        this.mEvent = 2;
        return;
    L62:
        if (r102 != 256) goto L64;
        this.mNamespaces.push(this.mIn.readInt(), this.mIn.readInt());
    L66:
        if (r103 <= 16) goto L10;
        int r111 = r103 - 16;
        LOGGER.warning(String.format("AXML header larger than 0x10 bytes, skipping %d bytes.", new Object[]{Integer.valueOf(r111)}));
        this.mIn.skipBytes(r111);
        goto L10
    L64:
        this.mIn.skipInt();
        this.mIn.skipInt();
        this.mNamespaces.pop();
        goto L66
    L39:
        if (r100 != (-1)) goto L41;
        this.mEvent = 0;
        return;
    L68:
        this.mIn.skipBytes(this.mIn.readInt() - 8);
        LOGGER.warning(String.format("Unknown chunk type at: (0x%08x) skipping...", new Object[]{Integer.valueOf(this.mIn.position())}));
        return;
    L25:
        int r112 = this.mIn.readInt();
        if (r112 < 8) goto L31;
        if ((r112 % 4) != 0) goto L31;
        this.mResourceIds = this.mIn.readIntArray((r112 / 4) - 2);
    L31:
        throw new IOException("Invalid resource ids size (" + r112 + ").");
    L22:
        r102 = this.mIn.readShort();
        r103 = this.mIn.readShort();
        goto L24
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser
    public void close() {
        if (this.isOperational == true) goto L5;
        return;
    L5:
        this.isOperational = false;
        this.mIn = null;
        this.mStringBlock = null;
        this.mResourceIds = null;
        this.mNamespaces.reset();
        resetEventInfo();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeCount() {
        if (this.mEvent == 2) goto L7;
        return -1;
    L7:
        return this.mAttributes.length / 5;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getClassAttribute() {
        int r100 = this.mClassIndex;
        if (r100 != (-1)) goto L6;
        return null;
    L6:
        int r101 = getAttributeOffset(r100);
        int r102 = this.mAttributes[r101 + 2];
        return this.mStringBlock.getString(r102);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public int getDepth() {
        return this.mNamespaces.getDepth() - 1;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getIdAttribute() {
        int r100 = this.mIdIndex;
        if (r100 != (-1)) goto L6;
        return null;
    L6:
        int r101 = getAttributeOffset(r100);
        int r102 = this.mAttributes[r101 + 2];
        return this.mStringBlock.getString(r102);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getName() {
        int r100 = this.mNameIndex;
        if (r100 == (-1)) goto L11;
        int r101 = this.mEvent;
        if (r101 == 2) goto L10;
        if (r101 == 3) goto L10;
        return null;
    L10:
        return this.mStringBlock.getString(r100);
    L11:
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getNamespace() {
        return this.mStringBlock.getString(this.mNamespaceIndex);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getPositionDescription() {
        return "XML line #" + getLineNumber();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getPrefix() {
        int r100 = this.mNamespaces.findPrefix(this.mNamespaceIndex);
        return this.mStringBlock.getString(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getStyleAttribute() {
        int r100 = this.mStyleIndex;
        if (r100 != (-1)) goto L6;
        return 0;
    L6:
        int r101 = getAttributeOffset(r100);
        return this.mAttributes[r101 + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getText() {
        int r100 = this.mNameIndex;
        if (r100 != (-1)) goto L5;
        return null;
    L5:
        if (this.mEvent == 4) goto L8;
        return null;
    L8:
        return this.mStringBlock.getString(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public int next() throws XmlPullParserException, IOException {
        if (this.mIn == null) goto L10;
        doNext();     // Catch: IOException -> L6
        return this.mEvent;
    L6:
        e = move-exception;
        close();
        throw e;
    L10:
        throw new XmlPullParserException("Parser is not opened.", this, null);
    }

    public AXmlResourceParser() {
        this.isOperational = false;
        this.mNamespaces = new NamespaceStack();
        resetEventInfo();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
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

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
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

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public int nextToken() throws XmlPullParserException, IOException {
        return next();
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public int getEventType() {
        return this.mEvent;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public int getLineNumber() {
        return this.mLineNumber;
    }

    private String escapeXmlChars(String r100) {
        return r100.replace("&", "&amp;").replace("<", "&lt;");
    }

    private int getAttributeOffset(int r100) {
        if (this.mEvent != 2) goto L10;
        int r101 = r100 * 5;
        if (r101 >= this.mAttributes.length) goto L8;
        return r101;
    L8:
        throw new IndexOutOfBoundsException("Invalid attribute index (" + r100 + ").");
    L10:
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    private String getNonDefaultNamespaceUri(int r100) {
        if (this.mStringBlock.getString(this.mNamespaces.getPrefix(r100)) != null) goto L5;
        return ANDROID_RES_NS_AUTO;
    L5:
        return this.mStringBlock.getString(this.mNamespaces.getUri(r100));
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getAttributeName(int r100) {
        int r101 = this.mAttributes[getAttributeOffset(r100) + 1];
        if (r101 != (-1)) goto L6;
        return "";
    L6:
        String r102 = this.mStringBlock.getString(r101);
        int r103 = getAttributeNameResource(r100);
        if (r102 == null) goto L10;
        return r102;
    L10:
        return "APKTOOL_MISSING_" + Integer.toHexString(r103);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeNameResource(int r100) {
        int r101 = getAttributeOffset(r100);
        int r102 = this.mAttributes[r101 + 1];
        int[] r103 = this.mResourceIds;
        if (r103 == null) goto L10;
        if (r102 >= 0) goto L6;
        return 0;
    L6:
        if (r102 < r103.length) goto L9;
        return 0;
    L9:
        return r103[r102];
    L10:
        return 0;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getAttributeNamespace(int r100) {
        int r101 = getAttributeOffset(r100);
        int r102 = this.mAttributes[r101 + 0];
        ResID r103 = new ResID(getAttributeNameResource(r100));
        if (r102 == (-1)) goto L5;
    L7:
        if (r102 != (-1)) goto L10;
        return "";
    L10:
        String r104 = this.mStringBlock.getString(r102);
        if (r104 == null) goto L17;
        if (r104.isEmpty() == true) goto L17;
        return r104;
    L17:
        if (r103.pkgId == 127) goto L19;
        return ANDROID_RES_NS;
    L19:
        return getNonDefaultNamespaceUri(r101);
    L5:
        if (r103.pkgId != 1) goto L7;
        return ANDROID_RES_NS;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getAttributePrefix(int r100) {
        int r101 = getAttributeOffset(r100);
        int r102 = this.mAttributes[r101 + 0];
        int r103 = this.mNamespaces.findPrefix(r102);
        if (r103 != (-1)) goto L7;
        return "";
    L7:
        return this.mStringBlock.getString(r103);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getAttributeValue(int r100) {
        int r101 = getAttributeOffset(r100);
        int[] r102 = this.mAttributes;
        int r103 = r102[r101 + 3];
        int r104 = r102[r101 + 4];
        int r105 = r102[r101 + 2];
        if (r103 != 3) goto L7;
        return escapeXmlChars(this.mStringBlock.getString(r105));
    L7:
        if (r103 < 16) goto L13;
        if (r103 > 31) goto L13;
        return Integer.toString(r104);
    L13:
        return TypedValue.coerceToString(r103, r104);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeValueData(int r100) {
        int r101 = getAttributeOffset(r100);
        return this.mAttributes[r101 + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeValueType(int r100) {
        int r101 = getAttributeOffset(r100);
        return this.mAttributes[r101 + 3];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getIdAttributeResourceValue(int r100) {
        int r101 = this.mIdIndex;
        if (r101 != (-1)) goto L5;
        return r100;
    L5:
        int r102 = getAttributeOffset(r101);
        int[] r103 = this.mAttributes;
        if (r103[r102 + 3] == 1) goto L9;
        return r100;
    L9:
        return r103[r102 + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getNamespace(String r100) {
        throw new RuntimeException(E_NOT_SUPPORTED);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public int getNamespaceCount(int r100) {
        return this.mNamespaces.getAccumulatedCount(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getNamespacePrefix(int r100) {
        int r101 = this.mNamespaces.getPrefix(r100);
        return this.mStringBlock.getString(r101);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public String getNamespaceUri(int r100) {
        int r101 = this.mNamespaces.getUri(r100);
        return this.mStringBlock.getString(r101);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
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
        this.mIn = new ExtCountingDataInput(new LittleEndianDataInputStream(r100));
        return;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public void setInput(Reader r100) throws XmlPullParserException {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    private int findAttribute(String r100, String r101) {
        StringBlock r102 = this.mStringBlock;
        if (r102 == null) goto L23;
        if (r101 == null) goto L23;
        int r103 = r102.find(r101);
        if (r103 != (-1)) goto L9;
        return -1;
    L9:
        if (r100 == null) goto L11;
        int r104 = this.mStringBlock.find(r100);
    L12:
        int r105 = 0;
    L13:
        int[] r106 = this.mAttributes;
        if (r105 == r106.length) goto L23;
        if (r103 != r106[r105 + 1]) goto L22;
        if (r104 == (-1)) goto L21;
        if (r104 != r106[r105 + 0]) goto L22;
    L21:
        return r105 / 5;
    L22:
        r105 = r105 + 5;
        goto L13
    L11:
        r104 = -1;
    L23:
        return -1;
    }

    private static String getPreferredString(String r100, String r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        int r102 = r100.lastIndexOf(HTTP.URL_DEFAULT);
        int r103 = r100.lastIndexOf(":");
        if (r102 == (-1)) goto L9;
        if (r103 == (-1)) goto L15;
        return r100;
    L15:
        return r100.substring(0, r102) + HTTP.URL_DEFAULT + r101;
    L9:
        if (r100.equals(r101) == false) goto L11;
        return r100;
    L11:
        return r101;
    L13:
        return r100;
    L12:
        return r100;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public void defineEntityReplacementText(String r100, String r101) throws XmlPullParserException {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public boolean getAttributeBooleanValue(int r100, boolean r101) {
        if (getAttributeIntValue(r100, r101 ? 1 : 0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public float getAttributeFloatValue(int r100, float r101) {
        int r102 = getAttributeOffset(r100);
        int[] r103 = this.mAttributes;
        if (r103[r102 + 3] == 4) goto L5;
        return r101;
    L5:
        return Float.intBitsToFloat(r103[r102 + 4]);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeIntValue(int r100, int r101) {
        int r102 = getAttributeOffset(r100);
        int[] r103 = this.mAttributes;
        int r104 = r103[r102 + 3];
        if (r104 >= 16) goto L5;
    L8:
        return r101;
    L5:
        if (r104 > 31) goto L8;
        return r103[r102 + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeResourceValue(int r100, int r101) {
        int r102 = getAttributeOffset(r100);
        int[] r103 = this.mAttributes;
        if (r103[r102 + 3] == 1) goto L5;
        return r101;
    L5:
        return r103[r102 + 4];
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeUnsignedIntValue(int r100, int r101) {
        return getAttributeIntValue(r100, r101);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser, com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public String getAttributeValue(String r100, String r101) {
        int r102 = findAttribute(r100, r101);
        if (r102 != (-1)) goto L7;
        return "";
    L7:
        return getAttributeValue(r102);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public void setFeature(String r100, boolean r101) throws XmlPullParserException {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public void setInput(InputStream r100, String r101) {
        open(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public void setProperty(String r100, Object r101) throws XmlPullParserException {
        throw new XmlPullParserException(E_NOT_SUPPORTED);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public boolean getAttributeBooleanValue(String r100, String r101, boolean r102) {
        int r103 = findAttribute(r100, r101);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return getAttributeBooleanValue(r103, r102);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public float getAttributeFloatValue(String r100, String r101, float r102) {
        int r103 = findAttribute(r100, r101);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return getAttributeFloatValue(r103, r102);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeIntValue(String r100, String r101, int r102) {
        int r103 = findAttribute(r100, r101);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return getAttributeIntValue(r103, r102);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeResourceValue(String r100, String r101, int r102) {
        int r103 = findAttribute(r100, r101);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return getAttributeResourceValue(r103, r102);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.AttributeSet
    public int getAttributeUnsignedIntValue(String r100, String r101, int r102) {
        int r103 = findAttribute(r100, r101);
        if (r103 != (-1)) goto L6;
        return r102;
    L6:
        return getAttributeUnsignedIntValue(r103, r102);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.XmlResourceParser, org.xmlpull.v1.XmlPullParser
    public void require(int r100, String r101, String r102) throws XmlPullParserException {
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
