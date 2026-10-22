package kotlinx.serialization.json.internal;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f505376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f505377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f505378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StringBuilder f505379d;

    public abstract boolean b();

    public abstract String d();

    public abstract byte e();

    public abstract void g(char r100);

    public abstract CharSequence p();

    public abstract String q(String r100, boolean r101);

    public abstract int t(int r100);

    public abstract int u();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public final long h() {
        int r100 = t(u());
        String r101 = "EOF";
        ?? r102 = 0;
        if (r100 < p().length()) goto L5;
    L116:
        m(this, "EOF", 0, null, 6);
        throw null;
    L5:
        if (r100 == (-1)) goto L116;
        if (p().charAt(r100) != '\"') goto L13;
        r100 = r100 + 1;
        if (r100 == p().length()) goto L11;
        boolean r103 = true;
    L14:
        int r110 = r100;
        long r104 = 0;
        long r105 = 0;
        boolean r111 = false;
        boolean r112 = false;
    L15:
        boolean r113 = false;
    L17:
        if (r110 == p().length()) goto L65;
        char r114 = p().charAt(r110);
        if (r114 != 'e') goto L21;
    L22:
        if (r111 == false) goto L23;
    L28:
        boolean r115 = r113;
        if (r114 != '-') goto L36;
        if (r111 == false) goto L36;
        if (r110 == r100) goto L33;
        r110 = r110 + 1;
        r102 = 0;
        goto L15
    L33:
        m(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
        throw null;
    L36:
        if (r114 != '+') goto L42;
        if (r111 == false) goto L42;
        if (r110 == r100) goto L40;
        r110 = r110 + 1;
        r102 = 0;
    L25:
        r113 = true;
        goto L17
    L40:
        m(this, "Unexpected symbol '+' in numeric literal", 0, null, 6);
        throw null;
    L42:
        String r116 = r101;
        if (r114 == '-') goto L44;
        if (b.a(r114) != 0) goto L66;
        r110 = r110 + 1;
        int r106 = r114 - '0';
        if (r106 < 0) goto L54;
        if (r106 >= 10) goto L54;
        boolean r107 = true;
    L55:
        if (r107 == false) goto L63;
        if (r111 == false) goto L58;
        r105 = (r105 * ((long) 10)) + ((long) r106);
    L60:
        r113 = r115;
        r101 = r116;
        r102 = 0;
        goto L17
    L58:
        r104 = (r104 * ((long) 10)) - ((long) r106);
        if (r104 <= 0) goto L60;
        m(this, "Numeric value overflow", 0, null, 6);
        throw null;
    L63:
        m(this, "Unexpected symbol '" + r114 + "' in numeric literal", 0, null, 6);
        throw null;
    L54:
        r107 = false;
    L66:
        if (r110 == r100) goto L68;
        boolean r108 = true;
    L69:
        if (r100 == r110) goto L114;
        if (r112 == true) goto L72;
    L73:
        if (r103 == false) goto L82;
        if (r108 == true) goto L76;
        m(this, r116, 0, null, 6);
        throw null;
    L76:
        if (p().charAt(r110) != '\"') goto L78;
        r110 = r110 + 1;
        goto L82
    L78:
        m(this, "Expected closing quotation mark", 0, null, 6);
        throw null;
    L82:
        this.f505376a = r110;
        if (r111 == false) goto L106;
        double r109 = r104;
        if (r115 == true) goto L88;
        double r117 = Math.pow(10.0d, -r105);
    L90:
        double r118 = r109 * r117;
        if (r118 <= 9.223372036854776E18d) goto L93;
    L102:
        m(this, "Numeric value overflow", 0, null, 6);
        throw null;
    L93:
        if (r118 < (-9.223372036854776E18d)) goto L102;
        if (Math.floor(r118) != r118) goto L97;
        boolean r119 = true;
    L98:
        if (r119 == false) goto L100;
        r104 = (long) r118;
        goto L106
    L100:
        m(this, "Can't convert " + r118 + " to Long", 0, null, 6);
        throw null;
    L97:
        r119 = false;
        goto L98
    L88:
        if (r115 != true) goto L105;
        r117 = Math.pow(10.0d, r105);
        goto L90
    L105:
        throw new NoWhenBranchMatchedException();
    L106:
        if (r112 == false) goto L109;
        return r104;
    L109:
        if (r104 != Long.MIN_VALUE) goto L111;
        m(this, "Numeric value overflow", 0, null, 6);
        throw null;
    L111:
        return -r104;
    L72:
        if (r100 != (r110 - 1)) goto L73;
    L114:
        m(this, "Expected numeric literal", 0, null, 6);
        throw null;
    L68:
        r108 = false;
        goto L69
    L44:
        if (r110 != r100) goto L46;
        r110 = r110 + 1;
        r102 = 0;
        r113 = r115;
        r101 = r116;
        r112 = true;
        goto L17
    L46:
        m(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
        throw null;
    L23:
        if (r110 == r100) goto L26;
        r110 = r110 + 1;
        r111 = true;
        r102 = r102;
        goto L25
    L26:
        m(this, "Unexpected symbol " + r114 + " in numeric literal", 0, r102, 6);
        throw r102;
    L21:
        if (r114 != 'E') goto L28;
    L65:
        r116 = r101;
        r115 = r113;
        goto L66
    L11:
        m(this, "EOF", 0, null, 6);
        throw null;
    L13:
        r103 = false;
        goto L14
    }

    public final String i() {
        String r100 = this.f505378c;
        if (r100 == null) goto L7;
        Intrinsics.checkNotNull(r100);
        this.f505378c = null;
        return r100;
    L7:
        return d();
    }

    public final String j() {
        String r100 = this.f505378c;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        this.f505378c = null;
        return r100;
    L6:
        int r101 = u();
        if (r101 < p().length()) goto L9;
    L33:
        m(this, "EOF", r101, null, 4);
        throw null;
    L9:
        if (r101 == (-1)) goto L33;
        byte r102 = b.a(p().charAt(r101));
        if (r102 != 1) goto L15;
        return i();
    L15:
        if (r102 != 0) goto L31;
        boolean r103 = false;
    L18:
        if (b.a(p().charAt(r101)) != 0) goto L26;
        r101 = r101 + 1;
        if (r101 < p().length()) goto L18;
        this.f505379d.append(p(), this.f505376a, r101);
        int r104 = t(r101);
        if (r104 == (-1)) goto L23;
        r101 = r104;
        r103 = true;
        goto L18
    L23:
        this.f505376a = r101;
        this.f505379d.append(p(), 0, 0);
        String r105 = this.f505379d.toString();
        this.f505379d.setLength(0);
        return r105;
    L26:
        if (r103 == true) goto L28;
        String r106 = p().subSequence(this.f505376a, r101).toString();
    L29:
        this.f505376a = r101;
        return r106;
    L28:
        this.f505379d.append(p(), this.f505376a, r101);
        r106 = this.f505379d.toString();
        this.f505379d.setLength(0);
        goto L29
    L31:
        m(this, "Expected beginning of the string, but got " + p().charAt(r101), 0, null, 6);
        throw null;
    }

    public final String toString() {
        return "JsonReader(source='" + p() + "', currentPosition=" + this.f505376a + ')';
    }

    public a() {
        this.f505377b = new v();
        this.f505379d = new StringBuilder();
    }

    public final String k() {
        String r100 = j();
        if (Intrinsics.areEqual(r100, "null") == false) goto L12;
        boolean r101 = true;
        if (p().charAt(this.f505376a - 1) != '\"') goto L8;
        r101 = false;
    L8:
        if (r101 == false) goto L12;
        m(this, "Unexpected 'null' value instead of string literal", 0, null, 6);
        throw null;
    L12:
        return r100;
    }

    public byte r() {
        CharSequence r100 = p();
        int r101 = this.f505376a;
    L3:
        int r102 = t(r101);
        if (r102 == (-1)) goto L16;
        char r103 = r100.charAt(r102);
        if (r103 == ' ') goto L15;
        if (r103 == '\n') goto L15;
        if (r103 == '\r') goto L15;
        if (r103 == '\t') goto L15;
        this.f505376a = r102;
        return b.a(r103);
    L15:
        r101 = r102 + 1;
        goto L3
    L16:
        this.f505376a = r102;
        return 10;
    }

    public final boolean v() {
        int r100 = u();
        CharSequence r101 = p();
        if (r100 < r101.length()) goto L5;
        return false;
    L5:
        if (r100 != (-1)) goto L8;
        return false;
    L8:
        if (r101.charAt(r100) != ',') goto L13;
        this.f505376a++;
        return true;
    L13:
        return false;
    }

    public final byte f(byte r100) {
        byte r101 = e();
        if (r101 != r100) goto L5;
        return r101;
    L5:
        n(r100, true);
        throw null;
    }

    public final String s(boolean r100) {
        byte r101 = r();
        if (r100 == false) goto L8;
        if (r101 == 1) goto L7;
        if (r101 == 0) goto L7;
        return null;
    L7:
        String r102 = j();
    L11:
        this.f505378c = r102;
        return r102;
    L8:
        if (r101 == 1) goto L10;
        return null;
    L10:
        r102 = i();
        goto L11
    }

    public final boolean w(boolean r100) {
        int r101 = t(u());
        int r102 = p().length() - r101;
        if (r102 >= 4) goto L5;
    L21:
        return false;
    L5:
        if (r101 == (-1)) goto L21;
        int r103 = 0;
    L8:
        if (r103 >= 4) goto L13;
        if ("null".charAt(r103) != p().charAt(r101 + r103)) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return false;
    L13:
        if (r102 > 4) goto L15;
    L17:
        if (r100 == false) goto L24;
        this.f505376a = r101 + 4;
        return true;
    L24:
        return true;
    L15:
        if (b.a(p().charAt(r101 + 4)) != 0) goto L17;
        return false;
    }

    public final void x(char r100) {
        int r101 = this.f505376a;
        if (r101 > 0) goto L5;
    L15:
        n(b.a(r100), true);
        throw null;
    L5:
        if (r100 != '\"') goto L15;
        this.f505376a = r101 - 1;     // Catch: Throwable -> L12
        String r102 = j();     // Catch: Throwable -> L12
        this.f505376a = r101;
        if (Intrinsics.areEqual(r102, "null") == false) goto L15;
        l("Expected string literal but 'null' literal was found", this.f505376a - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
        throw null;
    L12:
        th = move-exception;
        this.f505376a = r101;
        throw th;
    }

    public final int a(CharSequence r100, int r101) {
        int r102 = r101 + 4;
        if (r102 < r100.length()) goto L10;
        this.f505376a = r101;
        if (r102 < r100.length()) goto L7;
        m(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    L7:
        return a(r100, this.f505376a);
    L10:
        this.f505379d.append((char) ((((o(r100, r101) << 12) + (o(r100, r101 + 1) << 8)) + (o(r100, r101 + 2) << 4)) + o(r100, r101 + 3)));
        return r102;
    }

    public final void c(String r100, int r110) {
        if ((p().length() - r110) < r100.length()) goto L13;
        int r101 = r100.length();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L11;
        if (r100.charAt(r102) != (p().charAt(r110 + r102) | ' ')) goto L9;
        r102 = r102 + 1;
        goto L5
    L9:
        m(this, "Expected valid boolean literal prefix, but had '" + j() + '\'', 0, null, 6);
        throw null;
    L11:
        this.f505376a = r110 + r100.length();
        return;
    L13:
        m(this, "Unexpected end of boolean literal", 0, null, 6);
        throw null;
    }

    public final void n(byte r100, boolean r101) {
        String r102 = b.b(r100);
        if (r101 == false) goto L5;
        int r103 = this.f505376a - 1;
    L7:
        if (this.f505376a == p().length()) goto L11;
        if (r103 < 0) goto L11;
        String r104 = String.valueOf(p().charAt(r103));
    L12:
        m(this, "Expected " + r102 + ", but had '" + r104 + "' instead", r103, null, 4);
        throw null;
    L11:
        r104 = "EOF";
        goto L12
    L5:
        r103 = this.f505376a;
        goto L7
    }

    public final int o(CharSequence r100, int r101) {
        char r102 = r100.charAt(r101);
        boolean r103 = true;
        if ('0' <= r102) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L29;
        char r105 = 'a';
        if ('a' <= r102) goto L13;
    L15:
        boolean r106 = false;
    L16:
        if (r106 == true) goto L26;
        r105 = 'A';
        if ('A' <= r102) goto L21;
    L23:
        r103 = false;
    L24:
        if (r103 == true) goto L26;
        m(this, "Invalid toHexChar char '" + r102 + "' in unicode escape", 0, null, 6);
        throw null;
    L21:
        if (r102 >= 'G') goto L23;
    L26:
        return (r102 - r105) + 10;
    L13:
        if (r102 >= 'g') goto L15;
        r106 = true;
        goto L16
    L29:
        return r102 - '0';
    L5:
        if (r102 >= ':') goto L7;
        r104 = true;
        goto L8
    }

    public final void l(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r102, "hint");
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        String r104 = "";
    L10:
        throw s.d(r101, r100 + " at path: " + this.f505377b.a() + r104, p());
    L8:
        r104 = "\n".concat(r102);
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public static /* synthetic */ void m(a r100, String r101, int r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = r100.f505376a;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = "";
    L8:
        r100.l(r101, r102, r103);
        throw null;
    }
}
