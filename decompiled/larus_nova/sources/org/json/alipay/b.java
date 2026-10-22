package org.json.alipay;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes42.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f525883a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f525884b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(byte r100) {
            this();
        }

        public final Object clone() {
            return this;
        }

        public final boolean equals(Object r100) {
            if (r100 == null) goto L7;
            if (r100 == this) goto L9;
            return false;
        L9:
            return true;
        L7:
            return true;
        }

        public final String toString() {
            return "null";
        }
    }

    static {
        f525883a = new a(0);
    }

    public b() {
        this.f525884b = new HashMap();
    }

    public b(String r100) {
        this(new c(r100));
    }

    public b(Map r100) {
        if (r100 != null) goto L5;
        r100 = new HashMap();
    L5:
        this.f525884b = r100;
    }

    public b(c r100) {
        this();
        if (r100.c() != '{') goto L40;
    L4:
        char r101 = r100.c();
        if (r101 == 0) goto L38;
        if (r101 == '}') goto L36;
        r100.a();
        String r102 = r100.d().toString();
        char r103 = r100.c();
        if (r103 != '=') goto L14;
        if (r100.b() == '>') goto L15;
        r100.a();
    L15:
        Object r104 = r100.d();
        if (r102 == null) goto L33;
        if (r104 == null) goto L19;
        b(r104);
        this.f525884b.put(r102, r104);
    L20:
        char r105 = r100.c();
        if (r105 == ',') goto L29;
        if (r105 == ';') goto L29;
        if (r105 != '}') goto L27;
        return;
    L27:
        throw r100.a("Expected a ',' or '}'");
    L29:
        if (r100.c() == '}') goto L30;
        r100.a();
        goto L4
    L30:
        return;
    L19:
        this.f525884b.remove(r102);
        goto L20
    L33:
        throw new JSONException("Null key.");
    L14:
        if (r103 == ':') goto L15;
        throw r100.a("Expected a ':' after a key");
    L36:
        return;
    L38:
        throw r100.a("A JSONObject text must end with '}'");
    L40:
        throw r100.a("A JSONObject text must begin with '{'");
    }

    public static String a(Object r100) {
        if (r100 != null) goto L4;
        return "null";
    L4:
        if (r100.equals(null) == false) goto L7;
        return "null";
    L7:
        if ((r100 instanceof Number) == false) goto L22;
        Number r101 = (Number) r100;
        b(r101);
        String r102 = r101.toString();
        if (r102.indexOf(46) > 0) goto L11;
        return r102;
    L11:
        if (r102.indexOf(101) < 0) goto L13;
        return r102;
    L13:
        if (r102.indexOf(69) < 0) goto L15;
        return r102;
    L15:
        if (r102.endsWith("0") == false) goto L18;
        r102 = r102.substring(0, r102.length() - 1);
        goto L15
    L18:
        if (r102.endsWith(".") == true) goto L20;
        return r102;
    L20:
        return r102.substring(0, r102.length() - 1);
    L22:
        if ((r100 instanceof Boolean) == true) goto L43;
        if ((r100 instanceof b) == true) goto L43;
        if ((r100 instanceof org.json.alipay.a) == true) goto L43;
        if ((r100 instanceof Map) == false) goto L33;
        return new b((Map) r100).toString();
    L33:
        if ((r100 instanceof Collection) == false) goto L37;
        return new org.json.alipay.a((Collection) r100).toString();
    L37:
        if (r100.getClass().isArray() == false) goto L41;
        return new org.json.alipay.a(r100).toString();
    L41:
        return c(r100.toString());
    L43:
        return r100.toString();
    }

    public static void b(Object r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof Double) == false) goto L13;
        Double r101 = (Double) r100;
        if (r101.isInfinite() == true) goto L11;
        if (r101.isNaN() == true) goto L11;
        return;
    L11:
        throw new JSONException("JSON does not allow non-finite numbers.");
    L13:
        if ((r100 instanceof Float) == false) goto L22;
        Float r102 = (Float) r100;
        if (r102.isInfinite() == true) goto L20;
        if (r102.isNaN() == true) goto L20;
        return;
    L20:
        throw new JSONException("JSON does not allow non-finite numbers.");
    }

    public static String c(String r100) {
        if (r100 != null) goto L4;
        return "\"\"";
    L4:
        if (r100.length() == 0) goto L47;
        int r101 = r100.length();
        StringBuffer r102 = new StringBuffer(r101 + 4);
        r102.append(Typography.quote);
        int r103 = 0;
        char r104 = 0;
    L7:
        if (r103 >= r101) goto L40;
        char r105 = r100.charAt(r103);
        if (r105 != '\f') goto L11;
        String r106 = "\\f";
    L32:
        r102.append(r106);
    L39:
        r103 = r103 + 1;
        r104 = r105;
        goto L7
    L11:
        if (r105 != '\r') goto L13;
        r106 = "\\r";
        goto L32
    L13:
        if (r105 != '\"') goto L15;
    L35:
        r102.append('\\');
    L36:
        r102.append(r105);
        goto L39
    L15:
        if (r105 == '/') goto L34;
        if (r105 == '\\') goto L35;
        switch(r105) {
            case 8: goto L31;
            case 9: goto L30;
            case 10: goto L29;
            default: goto L19;
        };
    L29:
        r106 = "\\n";
        goto L32
    L30:
        r106 = "\\t";
        goto L32
    L31:
        r106 = "\\b";
        goto L32
    L19:
        if (r105 >= ' ') goto L21;
    L28:
        String r107 = "000" + Integer.toHexString(r105);
        r106 = "\\u" + r107.substring(r107.length() - 4);
        goto L32
    L21:
        if (r105 < 128) goto L25;
        if (r105 < 160) goto L28;
    L25:
        if (r105 < 8192) goto L36;
        if (r105 >= 8448) goto L36;
    L34:
        if (r104 != '<') goto L36;
    L40:
        r102.append(Typography.quote);
        return r102.toString();
    L47:
        return "\"\"";
    }

    public final Object a(String r100) {
        if (r100 != null) goto L4;
        Object r101 = null;
    L5:
        if (r101 == null) goto L8;
        return r101;
    L8:
        throw new JSONException("JSONObject[" + c(r100) + "] not found.");
    L4:
        r101 = this.f525884b.get(r100);
        goto L5
    }

    public final Iterator a() {
        return this.f525884b.keySet().iterator();
    }

    public final boolean b(String r100) {
        return this.f525884b.containsKey(r100);
    }

    public String toString() {
        Iterator r100 = a();     // Catch: Exception -> L11
        StringBuffer r101 = new StringBuffer("{");     // Catch: Exception -> L11
    L4:
        if (r100.hasNext() == false) goto L9;
        if (r101.length() <= 1) goto L8;
        r101.append(',');     // Catch: Exception -> L11
    L8:
        Object r102 = r100.next();     // Catch: Exception -> L11
        r101.append(c(r102.toString()));     // Catch: Exception -> L11
        r101.append(':');     // Catch: Exception -> L11
        r101.append(a(this.f525884b.get(r102)));     // Catch: Exception -> L11
        goto L4
    L9:
        r101.append('}');     // Catch: Exception -> L11
        return r101.toString();
    L11:
        return null;
    }
}
