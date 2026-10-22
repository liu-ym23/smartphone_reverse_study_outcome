package px5;

import com.bytedance.frameworks.baselib.network.http.parser.MimeTypeParseException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Hashtable f530933a;

    public final String toString() {
        StringBuffer r100 = new StringBuffer();
        r100.ensureCapacity(this.f530933a.size() * 16);
        Enumeration r101 = this.f530933a.keys();
    L4:
        if (r101.hasMoreElements() == false) goto L20;
        String r102 = (String) r101.nextElement();
        r100.append("; ");
        r100.append(r102);
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        String r103 = (String) this.f530933a.get(r102);
        int r104 = r103.length();
        int r105 = 0;
        int r106 = 0;
        boolean r107 = false;
    L6:
        if (r106 >= r104) goto L9;
        if (r107 == true) goto L9;
        r107 = !a(r103.charAt(r106));
        r106 = r106 + 1;
    L9:
        if (r107 == false) goto L18;
        StringBuffer r108 = new StringBuffer();
        r108.ensureCapacity((int) (((double) r104) * 1.5d));
        r108.append(Typography.quote);
    L11:
        if (r105 >= r104) goto L17;
        char r109 = r103.charAt(r105);
        if (r109 == '\\') goto L15;
        if (r109 == '\"') goto L15;
    L16:
        r108.append(r109);
        r105 = r105 + 1;
    L15:
        r108.append('\\');
        goto L16
    L17:
        r108.append(Typography.quote);
        r103 = r108.toString();
    L18:
        r100.append(r103);
        goto L4
    L20:
        return r100.toString();
    }

    public b() {
        this.f530933a = new Hashtable();
    }

    public b(String r110) throws MimeTypeParseException {
        this.f530933a = new Hashtable();
        if (r110 == null) goto L97;
        int r100 = r110.length();
        if (r100 <= 0) goto L98;
        int r101 = b(r110, 0);
    L9:
        if (r101 >= r100) goto L70;
        if (r110.charAt(r101) != ';') goto L70;
        int r102 = b(r110, r101 + 1);
        if (r102 >= r100) goto L99;
        int r103 = r102;
    L16:
        if (r103 >= r100) goto L20;
        if (a(r110.charAt(r103)) == false) goto L20;
        r103 = r103 + 1;
    L20:
        String r104 = r110.substring(r102, r103).toLowerCase(Locale.ENGLISH);
        int r105 = b(r110, r103);
        if (r105 >= r100) goto L69;
        if (r110.charAt(r105) != '=') goto L69;
        int r106 = b(r110, r105 + 1);
        if (r106 >= r100) goto L67;
        char r107 = r110.charAt(r106);
        if (r107 != '\"') goto L56;
        int r108 = r106 + 1;
        if (r108 >= r100) goto L54;
        int r109 = r108;
    L32:
        if (r109 >= r100) goto L39;
        r107 = r110.charAt(r109);
        if (r107 == '\"') goto L39;
        if (r107 != '\\') goto L38;
        r109 = r109 + 1;
    L38:
        r109 = r109 + 1;
    L39:
        if (r107 != '\"') goto L52;
        String r111 = r110.substring(r108, r109);
        int r112 = r111.length();
        StringBuffer r113 = new StringBuffer();
        r113.ensureCapacity(r112);
        int r114 = 0;
        boolean r115 = false;
    L41:
        if (r114 >= r112) goto L50;
        char r116 = r111.charAt(r114);
        if (r115 == true) goto L46;
        if (r116 == '\\') goto L46;
        r113.append(r116);
    L49:
        r114 = r114 + 1;
    L46:
        if (r115 == false) goto L48;
        r113.append(r116);
        r115 = false;
        goto L49
    L48:
        r115 = true;
        goto L49
    L50:
        String r117 = r113.toString();
        int r118 = r109 + 1;
    L63:
        this.f530933a.put(r104, r117);
        r101 = b(r110, r118);
        goto L9
    L52:
        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
    L54:
        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
    L56:
        if (a(r107) == false) goto L65;
        r118 = r106;
    L58:
        if (r118 >= r100) goto L62;
        if (a(r110.charAt(r118)) == false) goto L62;
        r118 = r118 + 1;
    L62:
        r117 = r110.substring(r106, r118);
        goto L63
    L65:
        throw new MimeTypeParseException("Unexpected character encountered at index " + r106);
    L67:
        throw new MimeTypeParseException("Couldn't find a value for parameter named " + r104);
    L69:
        throw new MimeTypeParseException("Couldn't find the '=' that separates a parameter name from its value.");
    L99:
        return;
    L70:
        if (r101 < r100) goto L73;
        return;
    L73:
        throw new MimeTypeParseException("More characters encountered in input than expected.");
    L98:
        return;
    }

    public static boolean a(char r100) {
        if (r100 > ' ') goto L5;
    L9:
        return false;
    L5:
        if (r100 >= 127) goto L9;
        if ("()<>@,;:/[]?=\\\"".indexOf(r100) >= 0) goto L9;
        return true;
    }

    public static int b(String r100, int r101) {
        int r102 = r100.length();
    L3:
        if (r101 >= r102) goto L7;
        if (Character.isWhitespace(r100.charAt(r101)) == false) goto L7;
        r101 = r101 + 1;
    L7:
        return r101;
    }
}
