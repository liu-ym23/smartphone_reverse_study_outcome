package com.bytedance.mira.util;

import android.util.Xml;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.UByte;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes21.dex */
public class XmlUtils {
    public XmlUtils() {
    }

    public static final void nextElement(XmlPullParser r100) throws XmlPullParserException, IOException {
    L2:
        int r101 = r100.next();
        if (r101 == 2) goto L7;
        if (r101 != 1) goto L2;
        return;
    }

    public static int parseUnsignedIntAttribute(CharSequence r100) {
        String r101 = r100.toString();
        int r102 = r101.length();
        int r103 = 0;
        int r104 = 16;
        if ('0' != r101.charAt(0)) goto L15;
        if ((r102 - 1) != 0) goto L7;
        return 0;
    L7:
        char r105 = r101.charAt(1);
        if ('x' != r105) goto L10;
    L13:
        r103 = 2;
    L19:
        return (int) CastLongProtector.parseLong(r101.substring(r103), r104);
    L10:
        if ('X' == r105) goto L13;
        r103 = 1;
        r104 = 8;
        goto L19
    L15:
        if ('#' != r101.charAt(0)) goto L17;
        r103 = 1;
        goto L19
    L17:
        r104 = 10;
        goto L19
    }

    public static final ArrayList readListXml(InputStream r100) throws XmlPullParserException, IOException {
        XmlPullParser r101 = Xml.newPullParser();
        r101.setInput(r100, null);
        return (ArrayList) readValueXml(r101, new String[1]);
    }

    public static final HashMap readMapXml(InputStream r100) throws XmlPullParserException, IOException {
        XmlPullParser r101 = Xml.newPullParser();
        r101.setInput(r100, null);
        return (HashMap) readValueXml(r101, new String[1]);
    }

    public static final HashSet readSetXml(InputStream r100) throws XmlPullParserException, IOException {
        XmlPullParser r101 = Xml.newPullParser();
        r101.setInput(r100, null);
        return (HashSet) readValueXml(r101, new String[1]);
    }

    public static void skipCurrentTag(XmlPullParser r100) throws XmlPullParserException, IOException {
        int r101 = r100.getDepth();
    L3:
        int r102 = r100.next();
        if (r102 == 1) goto L10;
        if (r102 != 3) goto L3;
        if (r100.getDepth() > r101) goto L3;
        return;
    }

    public static final void beginDocument(XmlPullParser r100, String r101) throws XmlPullParserException, IOException {
    L2:
        int r102 = r100.next();
        if (r102 == 2) goto L7;
        if (r102 != 1) goto L2;
    L7:
        if (r102 != 2) goto L14;
        if (r100.getName().equals(r101) == false) goto L12;
        return;
    L12:
        throw new XmlPullParserException("Unexpected start tag: found " + r100.getName() + ", expected " + r101);
    L14:
        throw new XmlPullParserException("No start tag found");
    }

    public static final boolean convertValueToBoolean(CharSequence r100, boolean r101) {
        if (r100 != null) goto L5;
        return r101;
    L5:
        if (r100.equals("1") == false) goto L7;
    L12:
        return true;
    L7:
        if (r100.equals("true") == true) goto L12;
        if (r100.equals("TRUE") == true) goto L12;
        return false;
    }

    public static final int convertValueToInt(CharSequence r100, int r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        String r102 = r100.toString();
        int r103 = r102.length();
        if ('-' != r102.charAt(0)) goto L7;
        int r104 = -1;
        int r105 = 1;
    L8:
        int r106 = 16;
        if ('0' != r102.charAt(r105)) goto L21;
        if (r105 != (r103 - 1)) goto L13;
        return 0;
    L13:
        int r107 = r105 + 1;
        char r108 = r102.charAt(r107);
        if ('x' != r108) goto L16;
    L19:
        r105 = r105 + 2;
    L25:
        return CastIntegerProtector.parseInt(r102.substring(r105), r106) * r104;
    L16:
        if ('X' == r108) goto L19;
        r105 = r107;
        r106 = 8;
        goto L25
    L21:
        if ('#' != r102.charAt(r105)) goto L23;
        r105 = r105 + 1;
        goto L25
    L23:
        r106 = 10;
        goto L25
    L7:
        r104 = 1;
        r105 = 0;
        goto L8
    }

    public static int convertValueToUnsignedInt(String r100, int r101) {
        if (r100 != null) goto L5;
        return r101;
    L5:
        return parseUnsignedIntAttribute(r100);
    }

    public static boolean nextElementWithin(XmlPullParser r100, int r101) throws IOException, XmlPullParserException {
    L2:
        int r102 = r100.next();
        if (r102 == 1) goto L14;
        if (r102 != 3) goto L10;
        if (r100.getDepth() != r101) goto L10;
        return false;
    L10:
        if (r102 != 2) goto L2;
        if (r100.getDepth() != (r101 + 1)) goto L2;
        return true;
    L14:
        return false;
    }

    public static boolean readBooleanAttribute(XmlPullParser r100, String r101) {
        return Boolean.parseBoolean(r100.getAttributeValue(null, r101));
    }

    public static int readIntAttribute(XmlPullParser r100, String r101) {
        return CastIntegerProtector.parseInt(r100.getAttributeValue(null, r101));
    L5:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static long readLongAttribute(XmlPullParser r100, String r101) {
        return CastLongProtector.parseLong(r100.getAttributeValue(null, r101));
    L5:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    private static final Object readThisPrimitiveValueXml(XmlPullParser r100, String r101) throws XmlPullParserException, IOException {
        if (r101.equals("int") == false) goto L9;
        return Integer.valueOf(CastIntegerProtector.parseInt(r100.getAttributeValue(null, "value")));
    L9:
        if (r101.equals("long") == false) goto L13;
        return CastLongProtector.valueOf(r100.getAttributeValue(null, "value"));
    L13:
        if (r101.equals("float") == false) goto L17;
        return new Float(r100.getAttributeValue(null, "value"));
    L17:
        if (r101.equals(ItemStyle.ITEM_STYLE_DOUBLE) == false) goto L21;
        return new Double(r100.getAttributeValue(null, "value"));
    L21:
        if (r101.equals("boolean") == true) goto L23;
        return null;
    L23:
        return Boolean.valueOf(r100.getAttributeValue(null, "value"));
    L28:
        throw new XmlPullParserException("Need value attribute in <" + r101 + ">");
    L26:
        throw new XmlPullParserException("Not a number in value attribute in <" + r101 + ">");
    }

    private static final Object readThisValueXml(XmlPullParser r110, String[] r111) throws XmlPullParserException, IOException {
        Object r100 = null;
        String r101 = r110.getAttributeValue(null, "name");
        String r102 = r110.getName();
        if (r102.equals("null") == true) goto L27;
        if (r102.equals("string") == false) goto L25;
        String r103 = "";
    L8:
        int r104 = r110.next();
        if (r104 == 1) goto L24;
        if (r104 == 3) goto L12;
        if (r104 == 4) goto L18;
        if (r104 != 2) goto L8;
        throw new XmlPullParserException("Unexpected start tag in <string>: " + r110.getName());
    L18:
        r103 = r103 + r110.getText();
        goto L8
    L12:
        if (r110.getName().equals("string") == false) goto L16;
        r111[0] = r101;
        return r103;
    L16:
        throw new XmlPullParserException("Unexpected end tag in <string>: " + r110.getName());
    L24:
        throw new XmlPullParserException("Unexpected end of document in <string>");
    L25:
        r100 = readThisPrimitiveValueXml(r110, r102);
        if (r100 != null) goto L27;
        if (r102.equals("int-array") == false) goto L51;
        r110.next();
        int[] r112 = readThisIntArrayXml(r110, "int-array", r111);
        r111[0] = r101;
        return r112;
    L51:
        if (r102.equals("map") == false) goto L55;
        r110.next();
        HashMap r113 = readThisMapXml(r110, "map", r111);
        r111[0] = r101;
        return r113;
    L55:
        if (r102.equals("list") == false) goto L59;
        r110.next();
        ArrayList r114 = readThisListXml(r110, "list", r111);
        r111[0] = r101;
        return r114;
    L59:
        if (r102.equals("set") == false) goto L63;
        r110.next();
        HashSet r115 = readThisSetXml(r110, "set", r111);
        r111[0] = r101;
        return r115;
    L63:
        throw new XmlPullParserException("Unknown tag: ".concat(r102));
    L27:
        int r105 = r110.next();
        if (r105 == 1) goto L45;
        if (r105 == 3) goto L32;
        if (r105 == 4) goto L43;
        if (r105 != 2) goto L27;
        throw new XmlPullParserException("Unexpected start tag in <" + r102 + ">: " + r110.getName());
    L43:
        throw new XmlPullParserException("Unexpected text in <" + r102 + ">: " + r110.getName());
    L32:
        if (r110.getName().equals(r102) == false) goto L36;
        r111[0] = r101;
        return r100;
    L36:
        throw new XmlPullParserException("Unexpected end tag in <" + r102 + ">: " + r110.getName());
    L45:
        throw new XmlPullParserException("Unexpected end of document in <" + r102 + ">");
    }

    public static final Object readValueXml(XmlPullParser r100, String[] r101) throws XmlPullParserException, IOException {
        int r102 = r100.getEventType();
    L4:
        if (r102 == 2) goto L6;
        if (r102 == 3) goto L19;
        if (r102 == 4) goto L17;
        r102 = r100.next();
        if (r102 != 1) goto L4;
        throw new XmlPullParserException("Unexpected end of document");
    L17:
        throw new XmlPullParserException("Unexpected text: " + r100.getText());
    L19:
        throw new XmlPullParserException("Unexpected end tag at: " + r100.getName());
    L6:
        return readThisValueXml(r100, r101);
    }

    public static final void writeListXml(List r100, OutputStream r101) throws XmlPullParserException, IOException {
        XmlSerializer r102 = Xml.newSerializer();
        r102.setOutput(r101, XML.CHARSET_UTF8);
        r102.startDocument(null, Boolean.TRUE);
        r102.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeListXml(r100, null, r102);
        r102.endDocument();
    }

    public static final void writeMapXml(Map r100, OutputStream r101) throws XmlPullParserException, IOException {
        XmlSerializer r102 = Xml.newSerializer();
        r102.setOutput(r101, XML.CHARSET_UTF8);
        r102.startDocument(null, Boolean.TRUE);
        r102.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeMapXml(r100, null, r102);
        r102.endDocument();
    }

    public static final int convertValueToList(CharSequence r100, String[] r101, int r102) {
        if (r100 == null) goto L10;
        int r103 = 0;
    L5:
        if (r103 >= r101.length) goto L10;
        if (r100.equals(r101[r103]) == true) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        return r103;
    L10:
        return r102;
    }

    public static long readLongAttribute(XmlPullParser r100, String r101, long r102) {
        return CastLongProtector.parseLong(r100.getAttributeValue(null, r101));
    L5:
        return r102;
    }

    public static final int[] readThisIntArrayXml(XmlPullParser r100, String r101, String[] r102) throws XmlPullParserException, IOException {
        int[] r103 = new int[CastIntegerProtector.parseInt(r100.getAttributeValue(null, "num"))];
        int r104 = r100.getEventType();
        int r105 = 0;
    L5:
        if (r104 != 2) goto L17;
        if (r100.getName().equals(MapController.ITEM_LAYER_TAG) == false) goto L15;
        r103[r105] = CastIntegerProtector.parseInt(r100.getAttributeValue(null, "value"));     // Catch: NumberFormatException -> L10 NullPointerException -> L12
    L26:
        r104 = r100.next();
        if (r104 != 1) goto L5;
        throw new XmlPullParserException("Document ended before " + r101 + " end tag");
    L13:
        throw new XmlPullParserException("Need value attribute in item");
    L11:
        throw new XmlPullParserException("Not a number in value attribute in item");
    L15:
        throw new XmlPullParserException("Expected item tag at: " + r100.getName());
    L17:
        if (r104 != 3) goto L26;
        if (r100.getName().equals(r101) == true) goto L20;
        if (r100.getName().equals(MapController.ITEM_LAYER_TAG) == false) goto L25;
        r105 = r105 + 1;
        goto L26
    L25:
        throw new XmlPullParserException("Expected " + r101 + " end tag at: " + r100.getName());
    L20:
        return r103;
    L34:
        throw new XmlPullParserException("Need num attribute in byte-array");
    L32:
        throw new XmlPullParserException("Not a number in num attribute in byte-array");
    }

    public static final ArrayList readThisListXml(XmlPullParser r100, String r101, String[] r102) throws XmlPullParserException, IOException {
        ArrayList r103 = new ArrayList();
        int r104 = r100.getEventType();
    L4:
        if (r104 != 2) goto L7;
        r103.add(readThisValueXml(r100, r102));
    L13:
        r104 = r100.next();
        if (r104 != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + r101 + " end tag");
    L7:
        if (r104 != 3) goto L13;
        if (r100.getName().equals(r101) == false) goto L12;
        return r103;
    L12:
        throw new XmlPullParserException("Expected " + r101 + " end tag at: " + r100.getName());
    }

    public static final HashMap readThisMapXml(XmlPullParser r100, String r101, String[] r102) throws XmlPullParserException, IOException {
        HashMap r103 = new HashMap();
        int r104 = r100.getEventType();
    L4:
        if (r104 != 2) goto L11;
        Object r105 = readThisValueXml(r100, r102);
        String r106 = r102[0];
        if (r106 == null) goto L9;
        r103.put(r106, r105);
    L17:
        r104 = r100.next();
        if (r104 != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + r101 + " end tag");
    L9:
        throw new XmlPullParserException("Map value without name attribute: " + r100.getName());
    L11:
        if (r104 != 3) goto L17;
        if (r100.getName().equals(r101) == false) goto L16;
        return r103;
    L16:
        throw new XmlPullParserException("Expected " + r101 + " end tag at: " + r100.getName());
    }

    public static final HashSet readThisSetXml(XmlPullParser r100, String r101, String[] r102) throws XmlPullParserException, IOException {
        HashSet r103 = new HashSet();
        int r104 = r100.getEventType();
    L4:
        if (r104 != 2) goto L7;
        r103.add(readThisValueXml(r100, r102));
    L13:
        r104 = r100.next();
        if (r104 != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + r101 + " end tag");
    L7:
        if (r104 != 3) goto L13;
        if (r100.getName().equals(r101) == false) goto L12;
        return r103;
    L12:
        throw new XmlPullParserException("Expected " + r101 + " end tag at: " + r100.getName());
    }

    public static void writeBooleanAttribute(XmlSerializer r100, String r101, boolean r102) throws IOException {
        r100.attribute(null, r101, Boolean.toString(r102));
    }

    public static final void writeByteArrayXml(byte[] r100, String r101, XmlSerializer r102) throws XmlPullParserException, IOException {
        if (r100 != null) goto L6;
        r102.startTag(null, "null");
        r102.endTag(null, "null");
        return;
    L6:
        r102.startTag(null, "byte-array");
        if (r101 == null) goto L9;
        r102.attribute(null, "name", r101);
    L9:
        int r103 = r100.length;
        r102.attribute(null, "num", Integer.toString(r103));
        StringBuilder r104 = new StringBuilder(r100.length * 2);
        int r105 = 0;
    L10:
        if (r105 >= r103) goto L20;
        byte r106 = r100[r105];
        int r107 = r106 >> 4;
        if (r107 < 10) goto L14;
        int r108 = (r107 + 97) - 10;
    L15:
        r104.append(r108);
        int r109 = r106 & UByte.MAX_VALUE;
        if (r109 < 10) goto L18;
        int r110 = (r109 + 97) - 10;
    L19:
        r104.append(r110);
        r105 = r105 + 1;
        goto L10
    L18:
        r110 = r109 + 48;
        goto L19
    L14:
        r108 = r107 + 48;
        goto L15
    L20:
        r102.text(r104.toString());
        r102.endTag(null, "byte-array");
    }

    public static final void writeIntArrayXml(int[] r100, String r101, XmlSerializer r102) throws XmlPullParserException, IOException {
        if (r100 != null) goto L6;
        r102.startTag(null, "null");
        r102.endTag(null, "null");
        return;
    L6:
        r102.startTag(null, "int-array");
        if (r101 == null) goto L9;
        r102.attribute(null, "name", r101);
    L9:
        int r103 = r100.length;
        r102.attribute(null, "num", Integer.toString(r103));
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L12;
        r102.startTag(null, MapController.ITEM_LAYER_TAG);
        r102.attribute(null, "value", Integer.toString(r100[r104]));
        r102.endTag(null, MapController.ITEM_LAYER_TAG);
        r104 = r104 + 1;
        goto L10
    L12:
        r102.endTag(null, "int-array");
    }

    public static void writeIntAttribute(XmlSerializer r100, String r101, int r102) throws IOException {
        r100.attribute(null, r101, Integer.toString(r102));
    }

    public static final void writeListXml(List r100, String r101, XmlSerializer r102) throws XmlPullParserException, IOException {
        if (r100 != null) goto L6;
        r102.startTag(null, "null");
        r102.endTag(null, "null");
        return;
    L6:
        r102.startTag(null, "list");
        if (r101 == null) goto L9;
        r102.attribute(null, "name", r101);
    L9:
        int r103 = r100.size();
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L12;
        writeValueXml(ListProtector.get(r100, r104), null, r102);
        r104 = r104 + 1;
        goto L10
    L12:
        r102.endTag(null, "list");
    }

    public static void writeLongAttribute(XmlSerializer r100, String r101, long r102) throws IOException {
        r100.attribute(null, r101, Long.toString(r102));
    }

    public static final void writeMapXml(Map r100, String r101, XmlSerializer r102) throws XmlPullParserException, IOException {
        if (r100 != null) goto L6;
        r102.startTag(null, "null");
        r102.endTag(null, "null");
        return;
    L6:
        Iterator r103 = r100.entrySet().iterator();
        r102.startTag(null, "map");
        if (r101 == null) goto L10;
        r102.attribute(null, "name", r101);
    L10:
        if (r103.hasNext() == false) goto L12;
        Map.Entry r104 = (Map.Entry) r103.next();
        writeValueXml(r104.getValue(), (String) r104.getKey(), r102);
        goto L10
    L12:
        r102.endTag(null, "map");
    }

    public static final void writeSetXml(Set r100, String r101, XmlSerializer r102) throws XmlPullParserException, IOException {
        if (r100 != null) goto L6;
        r102.startTag(null, "null");
        r102.endTag(null, "null");
        return;
    L6:
        r102.startTag(null, "set");
        if (r101 == null) goto L9;
        r102.attribute(null, "name", r101);
    L9:
        Iterator r103 = r100.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        writeValueXml(r103.next(), null, r102);
        goto L11
    L13:
        r102.endTag(null, "set");
    }

    public static final void writeValueXml(Object r100, String r101, XmlSerializer r102) throws XmlPullParserException, IOException {
        if (r100 != null) goto L10;
        r102.startTag(null, "null");
        if (r101 == null) goto L7;
        r102.attribute(null, "name", r101);
    L7:
        r102.endTag(null, "null");
        return;
    L10:
        if ((r100 instanceof String) == false) goto L17;
        r102.startTag(null, "string");
        if (r101 == null) goto L14;
        r102.attribute(null, "name", r101);
    L14:
        r102.text(r100.toString());
        r102.endTag(null, "string");
        return;
    L17:
        if ((r100 instanceof Integer) == false) goto L20;
        String r103 = "int";
    L31:
        r102.startTag(null, r103);
        if (r101 == null) goto L34;
        r102.attribute(null, "name", r101);
    L34:
        r102.attribute(null, "value", r100.toString());
        r102.endTag(null, r103);
        return;
    L20:
        if ((r100 instanceof Long) == false) goto L23;
        r103 = "long";
        goto L31
    L23:
        if ((r100 instanceof Float) == false) goto L26;
        r103 = "float";
        goto L31
    L26:
        if ((r100 instanceof Double) == false) goto L29;
        r103 = ItemStyle.ITEM_STYLE_DOUBLE;
        goto L31
    L29:
        if ((r100 instanceof Boolean) == false) goto L37;
        r103 = "boolean";
        goto L31
    L37:
        if ((r100 instanceof byte[]) == false) goto L41;
        writeByteArrayXml((byte[]) r100, r101, r102);
        return;
    L41:
        if ((r100 instanceof int[]) == false) goto L45;
        writeIntArrayXml((int[]) r100, r101, r102);
        return;
    L45:
        if ((r100 instanceof Map) == false) goto L49;
        writeMapXml((Map) r100, r101, r102);
        return;
    L49:
        if ((r100 instanceof List) == false) goto L53;
        writeListXml((List) r100, r101, r102);
        return;
    L53:
        if ((r100 instanceof Set) == false) goto L57;
        writeSetXml((Set) r100, r101, r102);
        return;
    L57:
        if ((r100 instanceof CharSequence) == false) goto L64;
        r102.startTag(null, "string");
        if (r101 == null) goto L61;
        r102.attribute(null, "name", r101);
    L61:
        r102.text(r100.toString());
        r102.endTag(null, "string");
        return;
    L64:
        throw new RuntimeException("writeValueXml: unable to write value " + r100);
    }
}
