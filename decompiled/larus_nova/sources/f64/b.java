package f64;

import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.UByte;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static final void a(Map r100, PolarisFileOutputStreamWrapper r101) throws XmlPullParserException, IOException {
        a r102 = new a();
        r102.setOutput(r101, XML.CHARSET_UTF8);
        r102.startDocument(null, Boolean.TRUE);
        r102.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        b(r100, null, r102);
        r102.flush();
    }

    public static final void b(Map r100, String r101, a r102) throws XmlPullParserException, IOException {
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
        c(r104.getValue(), (String) r104.getKey(), r102);
        goto L10
    L12:
        r102.endTag(null, "map");
    }

    public static final void c(Object r100, String r101, a r102) throws XmlPullParserException, IOException {
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
        if ((r100 instanceof Boolean) == false) goto L36;
        r103 = "boolean";
        goto L31
    L36:
        int r104 = 0;
        if ((r100 instanceof byte[]) == false) goto L55;
        byte[] r105 = (byte[]) r100;
        r102.startTag(null, "byte-array");
        if (r101 == null) goto L41;
        r102.attribute(null, "name", r101);
    L41:
        int r106 = r105.length;
        r102.attribute(null, "num", Integer.toString(r106));
        StringBuilder r107 = new StringBuilder(r105.length * 2);
    L42:
        if (r104 >= r106) goto L52;
        byte r108 = r105[r104];
        int r109 = r108 >> 4;
        if (r109 < 10) goto L46;
        int r110 = (r109 + 97) - 10;
    L47:
        r107.append(r110);
        int r111 = r108 & UByte.MAX_VALUE;
        if (r111 < 10) goto L50;
        int r112 = (r111 + 97) - 10;
    L51:
        r107.append(r112);
        r104 = r104 + 1;
        goto L42
    L50:
        r112 = r111 + 48;
        goto L51
    L46:
        r110 = r109 + 48;
        goto L47
    L52:
        r102.text(r107.toString());
        r102.endTag(null, "byte-array");
        return;
    L55:
        if ((r100 instanceof int[]) == false) goto L65;
        int[] r113 = (int[]) r100;
        r102.startTag(null, "int-array");
        if (r101 == null) goto L59;
        r102.attribute(null, "name", r101);
    L59:
        int r114 = r113.length;
        r102.attribute(null, "num", Integer.toString(r114));
    L60:
        if (r104 >= r114) goto L62;
        r102.startTag(null, MapController.ITEM_LAYER_TAG);
        r102.attribute(null, "value", Integer.toString(r113[r104]));
        r102.endTag(null, MapController.ITEM_LAYER_TAG);
        r104 = r104 + 1;
        goto L60
    L62:
        r102.endTag(null, "int-array");
        return;
    L65:
        if ((r100 instanceof Map) == false) goto L69;
        b((Map) r100, r101, r102);
        return;
    L69:
        if ((r100 instanceof List) == false) goto L79;
        List r115 = (List) r100;
        r102.startTag(null, "list");
        if (r101 == null) goto L73;
        r102.attribute(null, "name", r101);
    L73:
        int r116 = r115.size();
    L74:
        if (r104 >= r116) goto L76;
        c(ListProtector.get(r115, r104), null, r102);
        r104 = r104 + 1;
        goto L74
    L76:
        r102.endTag(null, "list");
        return;
    L79:
        if ((r100 instanceof Set) == false) goto L90;
        Set r117 = (Set) r100;
        r102.startTag(null, "set");
        if (r101 == null) goto L83;
        r102.attribute(null, "name", r101);
    L83:
        Iterator r118 = r117.iterator();
    L85:
        if (r118.hasNext() == false) goto L87;
        c(r118.next(), null, r102);
        goto L85
    L87:
        r102.endTag(null, "set");
        return;
    L90:
        if ((r100 instanceof CharSequence) == false) goto L97;
        r102.startTag(null, "string");
        if (r101 == null) goto L94;
        r102.attribute(null, "name", r101);
    L94:
        r102.text(r100.toString());
        r102.endTag(null, "string");
        return;
    L97:
        throw new RuntimeException("writeValueXml: unable to write " + r101 + ", class " + r100.getClass() + ", value " + r100);
    }
}
