package zw;

import com.bytedance.android.jsonopt.JsonToken;
import com.bytedance.android.jsonopt.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Closeable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final char[] f573776q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f573777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f573778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char[] f573779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f573780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f573781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f573782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f573783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f573784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f573785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f573786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f573787k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f573788l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f573789m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f573790n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String[] f573791o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f573792p;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f573793a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f573793a = r100;
            r100[JsonToken.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L26:
            f573793a[JsonToken.NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L32:
            f573793a[JsonToken.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L42:
            f573793a[JsonToken.NULL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L28:
            f573793a[JsonToken.BEGIN_ARRAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L34:
            f573793a[JsonToken.BEGIN_OBJECT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L36:
            f573793a[JsonToken.END_DOCUMENT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L38:
            f573793a[JsonToken.NAME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L24:
            f573793a[JsonToken.END_OBJECT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L30:
            f573793a[JsonToken.END_ARRAY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
            return;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f573784h = 0;
        this.f573789m[0] = 8;
        this.f573790n = 1;
        this.f573777a.close();
    }

    public final void n() throws IOException {
        int r100 = 0;
    L3:
        int r101 = this.f573784h;
        if (r101 != 0) goto L7;
        r101 = b();
    L7:
        if (r101 != 3) goto L10;
        j(1);
    L9:
        r100 = r100 + 1;
    L67:
        this.f573784h = 0;
        if (r100 != 0) goto L3;
        int[] r102 = this.f573792p;
        int r103 = this.f573790n;
        int r104 = r103 - 1;
        r102[r104] = r102[r104] + 1;
        this.f573791o[r103 - 1] = "null";
        return;
    L10:
        if (r101 != 1) goto L13;
        j(3);
        goto L9
    L13:
        if (r101 != 4) goto L17;
        this.f573790n--;
    L15:
        r100 = r100 - 1;
        goto L67
    L17:
        if (r101 != 2) goto L20;
        this.f573790n--;
        goto L15
    L20:
        if (r101 == 14) goto L35;
        if (r101 == 10) goto L35;
        if (r101 == 8) goto L34;
        if (r101 == 12) goto L34;
        if (r101 == 9) goto L33;
        if (r101 == 13) goto L33;
        if (r101 != 16) goto L67;
        this.f573780d += this.f573788l;
    L33:
        l(Typography.quote);
    L34:
        l('\'');
    L35:
        int r105 = 0;
    L36:
        int r106 = this.f573780d + r105;
        if (r106 >= this.f573781e) goto L65;
        char r107 = this.f573779c[r106];
        if (r107 == '\t') goto L64;
        if (r107 == '\n') goto L64;
        if (r107 == '\f') goto L64;
        if (r107 == '\r') goto L64;
        if (r107 == ' ') goto L64;
        if (r107 == '#') goto L63;
        if (r107 == ',') goto L64;
        if (r107 == '/') goto L63;
        if (r107 == '=') goto L63;
        if (r107 == '{') goto L64;
        if (r107 == '}') goto L64;
        if (r107 == ':') goto L64;
        if (r107 == ';') goto L63;
        switch(r107) {
            case 91: goto L64;
            case 92: goto L63;
            case 93: goto L64;
            default: goto L62;
        };
    L62:
        r105 = r105 + 1;
    L63:
        a();
    L64:
        this.f573780d += r105;
        goto L67
    L65:
        this.f573780d = r106;
        if (c(1) == true) goto L35;
        goto L67
    }

    static {
        f573776q = ")]}'\n".toCharArray();
    }

    public final void a() throws IOException {
        if (this.f573778b == false) goto L5;
        return;
    L5:
        p("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final int b() throws IOException {
        int[] r100 = this.f573789m;
        int r101 = this.f573790n;
        int r102 = r100[r101 - 1];
        if (r102 != 1) goto L5;
        r100[r101 - 1] = 2;
    L57:
        int r103 = g(true);
        if (r103 != 34) goto L60;
        this.f573784h = 9;
        return 9;
    L60:
        if (r103 == 39) goto L213;
        if (r103 == 44) goto L206;
        if (r103 == 59) goto L206;
        if (r103 == 91) goto L204;
        if (r103 != 93) goto L67;
        if (r102 != 1) goto L206;
        this.f573784h = 4;
        return 4;
    L67:
        if (r103 == 123) goto L199;
        int r104 = this.f573780d - 1;
        this.f573780d = r104;
        char r105 = this.f573779c[r104];
        if (r105 != 't') goto L71;
    L84:
        String r106 = "true";
        String r107 = "TRUE";
        int r108 = 5;
    L85:
        int r109 = r106.length();
        int r110 = 1;
    L86:
        if (r110 >= r109) goto L99;
        if ((this.f573780d + r110) >= this.f573781e) goto L90;
    L92:
        char r111 = this.f573779c[this.f573780d + r110];
        if (r111 == r106.charAt(r110)) goto L97;
        if (r111 == r107.charAt(r110)) goto L97;
    L104:
        r108 = 0;
    L106:
        if (r108 == 0) goto L108;
        return r108;
    L108:
        char[] r112 = this.f573779c;
        int r113 = this.f573780d;
        int r114 = this.f573781e;
        long r115 = 0;
        long r116 = 0;
        int r117 = 0;
        char r118 = 0;
        boolean r119 = false;
        boolean r120 = true;
    L110:
        if ((r113 + r117) == r114) goto L112;
    L118:
        char r121 = r112[r113 + r117];
        if (r121 != '+') goto L121;
        long r122 = r115;
        if (r118 != 5) goto L190;
    L188:
        r118 = 6;
    L189:
        r117 = r117 + 1;
        r115 = r122;
    L190:
        int r123 = 0;
    L191:
        if (r123 == 0) goto L194;
        return r123;
    L194:
        if (d(this.f573779c[this.f573780d]) == false) goto L197;
        a();
        this.f573784h = 10;
        return 10;
    L197:
        p("Expected value");
        throw null;
    L121:
        if (r121 != 'E') goto L123;
    L181:
        r122 = r115;
        if (r118 != 2) goto L184;
    L185:
        r118 = 5;
        goto L189
    L184:
        if (r118 != 4) goto L190;
    L123:
        if (r121 == 'e') goto L181;
        if (r121 != '-') goto L127;
        r122 = r115;
        if (r118 != 0) goto L179;
        r118 = 1;
        r119 = true;
        goto L189
    L179:
        if (r118 != 5) goto L190;
    L127:
        if (r121 != '.') goto L129;
        r122 = r115;
        if (r118 != 2) goto L190;
        r118 = 3;
        goto L189
    L129:
        if (r121 < '0') goto L157;
        if (r121 > '9') goto L157;
        if (r118 == 1) goto L154;
        if (r118 == 0) goto L154;
        if (r118 == 2) goto L138;
        if (r118 != 3) goto L151;
        r118 = 4;
    L155:
        r122 = 0;
        goto L189
    L151:
        if (r118 == 5) goto L153;
        if (r118 != 6) goto L155;
    L153:
        r118 = 7;
        goto L155
    L138:
        if (r116 == r115) goto L190;
        long r124 = (10 * r116) - ((long) (r121 - '0'));
        if (r116 > (-922337203685477580L)) goto L147;
        if (r116 == (-922337203685477580L)) goto L144;
    L146:
        boolean r125 = false;
    L148:
        r120 = r120 & r125;
        r116 = r124;
        goto L155
    L144:
        if (r124 >= r116) goto L146;
    L147:
        r125 = true;
    L154:
        r116 = -(r121 - '0');
        r118 = 2;
    L157:
        if (d(r121) == true) goto L190;
    L158:
        if (r118 != 2) goto L167;
        if (r120 == false) goto L167;
        if (r116 != Long.MIN_VALUE) goto L164;
        if (r119 == false) goto L167;
    L164:
        if (r116 != 0) goto L166;
        if (r119 == true) goto L167;
    L166:
        this.f573780d += r117;
        r123 = 15;
        this.f573784h = 15;
    L167:
        if (r118 != 2) goto L169;
    L172:
        this.f573788l = r117;
        r123 = 16;
        this.f573784h = 16;
        goto L191
    L169:
        if (r118 == 4) goto L172;
        if (r118 != 7) goto L190;
    L112:
        if (r117 == r112.length) goto L190;
        if (c(r117 + 1) == false) goto L158;
        r113 = this.f573780d;
        r114 = this.f573781e;
    L97:
        r110 = r110 + 1;
        goto L86
    L90:
        if (c(r110 + 1) == true) goto L92;
    L99:
        if ((this.f573780d + r109) < this.f573781e) goto L103;
        if (c(r109 + 1) == true) goto L103;
    L105:
        this.f573780d += r109;
        this.f573784h = r108;
    L103:
        if (d(this.f573779c[this.f573780d + r109]) == false) goto L105;
    L71:
        if (r105 == 'T') goto L84;
        if (r105 != 'f') goto L76;
    L83:
        r106 = "false";
        r107 = "FALSE";
        r108 = 6;
        goto L85
    L76:
        if (r105 == 'F') goto L83;
        if (r105 != 'n') goto L81;
    L82:
        r106 = "null";
        r107 = "NULL";
        r108 = 7;
        goto L85
    L81:
        if (r105 != 'N') goto L104;
    L199:
        this.f573784h = 1;
        return 1;
    L204:
        this.f573784h = 3;
        return 3;
    L206:
        if (r102 == 1) goto L211;
        if (r102 == 2) goto L211;
        p("Unexpected value");
        throw null;
    L211:
        a();
        this.f573780d--;
        this.f573784h = 7;
        return 7;
    L213:
        a();
        this.f573784h = 8;
        return 8;
    L5:
        if (r102 != 2) goto L15;
        int r126 = g(true);
        if (r126 == 44) goto L57;
        if (r126 == 59) goto L14;
        if (r126 != 93) goto L12;
        this.f573784h = 4;
        return 4;
    L12:
        p("Unterminated array");
        throw null;
    L14:
        a();
        goto L57
    L15:
        if (r102 == 3) goto L219;
        if (r102 == 5) goto L219;
        if (r102 != 4) goto L32;
        r100[r101 - 1] = 5;
        int r127 = g(true);
        if (r127 == 58) goto L57;
        if (r127 != 61) goto L30;
        a();
        if (this.f573780d >= this.f573781e) goto L26;
    L27:
        char[] r128 = this.f573779c;
        int r129 = this.f573780d;
        if (r128[r129] != '>') goto L57;
        this.f573780d = r129 + 1;
        goto L57
    L26:
        if (c(1) == false) goto L57;
    L30:
        p("Expected ':'");
        throw null;
    L32:
        if (r102 == 6) goto L34;
        if (r102 != 7) goto L56;
        if (g(false) != (-1)) goto L54;
        this.f573784h = 17;
        return 17;
    L54:
        a();
        this.f573780d--;
        goto L57
    L56:
        if (r102 != 8) goto L57;
        throw new IllegalStateException("JsonReader is closed");
    L34:
        if (this.f573778b == false) goto L48;
        g(true);
        int r130 = this.f573780d - 1;
        this.f573780d = r130;
        char[] r131 = f573776q;
        if ((r130 + r131.length) > this.f573781e) goto L38;
    L40:
        int r132 = 0;
    L41:
        char[] r133 = f573776q;
        if (r132 >= r133.length) goto L47;
        if (this.f573779c[this.f573780d + r132] != r133[r132]) goto L48;
        r132 = r132 + 1;
        goto L41
    L47:
        this.f573780d += r133.length;
        goto L48
    L38:
        if (c(r131.length) == true) goto L40;
    L48:
        this.f573789m[this.f573790n - 1] = 7;
    L219:
        r100[r101 - 1] = 4;
        if (r102 != 5) goto L230;
        int r134 = g(true);
        if (r134 == 44) goto L230;
        if (r134 == 59) goto L229;
        if (r134 != 125) goto L227;
        this.f573784h = 2;
        return 2;
    L227:
        p("Unterminated object");
        throw null;
    L229:
        a();
    L230:
        int r135 = g(true);
        if (r135 != 34) goto L233;
        this.f573784h = 13;
        return 13;
    L233:
        if (r135 != 39) goto L235;
        a();
        this.f573784h = 12;
        return 12;
    L235:
        if (r135 == 125) goto L243;
        a();
        this.f573780d--;
        if (d((char) r135) == false) goto L240;
        this.f573784h = 14;
        return 14;
    L240:
        p("Expected name");
        throw null;
    L243:
        if (r102 == 5) goto L246;
        this.f573784h = 2;
        return 2;
    L246:
        p("Expected name");
        throw null;
    }

    public final String e() {
        int r100 = this.f573782f + 1;
        int r101 = (this.f573780d - this.f573783g) + 1;
        StringBuilder r102 = new StringBuilder(" at line ");
        r102.append(r100);
        r102.append(" column ");
        r102.append(r101);
        r102.append(" path ");
        StringBuilder r103 = new StringBuilder("$");
        int r104 = this.f573790n;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L20;
        int r106 = this.f573789m[r105];
        if (r106 != 1) goto L7;
    L18:
        r103.append('[');
        r103.append(this.f573792p[r105]);
        r103.append(']');
    L19:
        r105 = r105 + 1;
        goto L3
    L7:
        if (r106 == 2) goto L18;
        if (r106 != 3) goto L11;
    L15:
        r103.append('.');
        String r107 = this.f573791o[r105];
        if (r107 == null) goto L19;
        r103.append(r107);
        goto L19
    L11:
        if (r106 == 4) goto L15;
        if (r106 == 5) goto L15;
    L20:
        r102.append(r103.toString());
        return r102.toString();
    }

    public final JsonToken i() throws IOException {
        int r100 = this.f573784h;
        if (r100 != 0) goto L5;
        r100 = b();
    L5:
        switch(r100) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L11;
            case 16: goto L11;
            case 17: goto L9;
            default: goto L7;
        };
    L7:
        throw new AssertionError();
    L9:
        return JsonToken.END_DOCUMENT;
    L11:
        return JsonToken.NUMBER;
    L13:
        return JsonToken.NAME;
    L15:
        return JsonToken.STRING;
    L17:
        return JsonToken.NULL;
    L19:
        return JsonToken.BOOLEAN;
    L21:
        return JsonToken.END_ARRAY;
    L23:
        return JsonToken.BEGIN_ARRAY;
    L25:
        return JsonToken.END_OBJECT;
    L27:
        return JsonToken.BEGIN_OBJECT;
    }

    public final char k() throws IOException {
        if (this.f573780d == this.f573781e) goto L5;
    L9:
        char[] r100 = this.f573779c;
        int r101 = this.f573780d;
        int r102 = r101 + 1;
        this.f573780d = r102;
        char r103 = r100[r101];
        if (r103 != '\n') goto L12;
        this.f573782f++;
        this.f573783g = r102;
    L72:
        return r103;
    L12:
        if (r103 == '\"') goto L72;
        if (r103 == '\'') goto L72;
        if (r103 == '/') goto L72;
        if (r103 == '\\') goto L72;
        if (r103 != 'b') goto L22;
        return '\b';
    L22:
        if (r103 != 'f') goto L24;
        return '\f';
    L24:
        if (r103 != 'n') goto L26;
        return '\n';
    L26:
        if (r103 != 'r') goto L28;
        return '\r';
    L28:
        if (r103 != 't') goto L30;
        return '\t';
    L30:
        if (r103 == 'u') goto L32;
        p("Invalid escape sequence");
        throw null;
    L32:
        if ((r102 + 4) > this.f573781e) goto L34;
    L38:
        int r104 = this.f573780d;
        int r105 = r104 + 4;
        char r106 = 0;
    L39:
        if (r104 >= r105) goto L58;
        char r107 = this.f573779c[r104];
        char r108 = (char) (r106 << 4);
        if (r107 < '0') goto L46;
        if (r107 > '9') goto L46;
        int r109 = r107 - '0';
    L55:
        r106 = (char) (r108 + r109);
        r104 = r104 + 1;
    L46:
        if (r107 < 'a') goto L50;
        if (r107 > 'f') goto L50;
        int r110 = r107 - 'a';
    L54:
        r109 = r110 + 10;
    L50:
        if (r107 < 'A') goto L57;
        if (r107 > 'F') goto L57;
        r110 = r107 - 'A';
    L57:
        throw new NumberFormatException("\\u".concat(new String(this.f573779c, this.f573780d, 4)));
    L58:
        this.f573780d += 4;
        return r106;
    L34:
        if (c(4) == true) goto L38;
        p("Unterminated escape sequence");
        throw null;
    L5:
        if (c(1) == true) goto L9;
        p("Unterminated escape sequence");
        throw null;
    }

    public final void m() throws IOException {
    L3:
        if (this.f573780d >= this.f573781e) goto L5;
    L6:
        char[] r100 = this.f573779c;
        int r101 = this.f573780d;
        int r102 = r101 + 1;
        this.f573780d = r102;
        char r103 = r100[r101];
        if (r103 == '\n') goto L8;
        if (r103 != '\r') goto L3;
        return;
    L8:
        this.f573782f++;
        this.f573783g = r102;
        return;
    L5:
        if (c(1) == true) goto L6;
    }

    public final String toString() {
        return b.class.getSimpleName() + e();
    }

    public b(Reader r100) {
        this.f573778b = false;
        this.f573779c = new char[1024];
        this.f573780d = 0;
        this.f573781e = 0;
        this.f573782f = 0;
        this.f573783g = 0;
        this.f573784h = 0;
        this.f573785i = -1;
        this.f573786j = -1;
        this.f573787k = 0;
        int[] r101 = new int[32];
        this.f573789m = r101;
        this.f573790n = 1;
        r101[0] = 6;
        this.f573791o = new String[32];
        this.f573792p = new int[32];
        this.f573777a = r100;
    }

    public final boolean c(int r100) throws IOException {
        char[] r101 = this.f573779c;
        int r102 = this.f573783g;
        int r103 = this.f573780d;
        this.f573783g = r102 - r103;
        int r104 = this.f573781e;
        if (r104 == r103) goto L5;
        int r105 = r104 - r103;
        this.f573781e = r105;
        System.arraycopy(r101, r103, r101, 0, r105);
    L6:
        this.f573787k += this.f573780d;
        this.f573780d = 0;
    L7:
        Reader r106 = this.f573777a;
        int r107 = this.f573781e;
        int r108 = r106.read(r101, r107, r101.length - r107);
        if (r108 == (-1)) goto L19;
        int r109 = this.f573781e + r108;
        this.f573781e = r109;
        if (this.f573782f != 0) goto L17;
        int r110 = this.f573783g;
        if (r110 != 0) goto L17;
        if (r109 <= 0) goto L17;
        if (r101[0] != 65279) goto L17;
        this.f573780d++;
        this.f573783g = r110 + 1;
        r100 = r100 + 1;
    L17:
        if (r109 < r100) goto L7;
        return true;
    L19:
        return false;
    L5:
        this.f573781e = 0;
        goto L6
    }

    public final boolean d(char r100) throws IOException {
        if (r100 != '\t') goto L5;
        return false;
    L5:
        if (r100 != '\n') goto L7;
        return false;
    L7:
        if (r100 != '\f') goto L9;
        return false;
    L9:
        if (r100 != '\r') goto L11;
        return false;
    L11:
        if (r100 != ' ') goto L13;
        return false;
    L13:
        if (r100 != '#') goto L15;
    L31:
        a();
        return false;
    L15:
        if (r100 != ',') goto L17;
        return false;
    L17:
        if (r100 == '/') goto L31;
        if (r100 == '=') goto L31;
        if (r100 != '{') goto L23;
        return false;
    L23:
        if (r100 != '}') goto L25;
        return false;
    L25:
        if (r100 != ':') goto L27;
        return false;
    L27:
        if (r100 == ';') goto L31;
        switch(r100) {
            case 91: goto L43;
            case 92: goto L31;
            case 93: goto L43;
            default: goto L29;
        };
    L29:
        return true;
    L43:
        return false;
    }

    public final int g(boolean r110) throws IOException {
        char[] r100 = this.f573779c;
        int r101 = this.f573780d;
        int r102 = this.f573781e;
    L3:
        boolean r103 = true;
        if (r101 != r102) goto L13;
        this.f573780d = r101;
        if (c(1) == false) goto L7;
        r101 = this.f573780d;
        r102 = this.f573781e;
        goto L13
    L7:
        if (r110 == true) goto L11;
        return -1;
    L11:
        throw new EOFException("End of input" + e());
    L13:
        int r104 = r101 + 1;
        char r105 = r100[r101];
        if (r105 == '\n') goto L15;
        if (r105 == ' ') goto L59;
        if (r105 == '\r') goto L59;
        if (r105 == '\t') goto L59;
        if (r105 == '/') goto L25;
        if (r105 != '#') goto L57;
        this.f573780d = r104;
        a();
        m();
        r101 = this.f573780d;
        r102 = this.f573781e;
        goto L3
    L57:
        this.f573780d = r104;
        return r105;
    L25:
        this.f573780d = r104;
        if (r104 != r102) goto L30;
        this.f573780d = r104 - 1;
        boolean r106 = c(2);
        this.f573780d++;
        if (r106 == true) goto L30;
        return r105;
    L30:
        a();
        int r107 = this.f573780d;
        char r108 = r100[r107];
        if (r108 != '*') goto L32;
        this.f573780d = r107 + 1;
    L36:
        int r109 = 0;
        if ((this.f573780d + 2) > this.f573781e) goto L39;
    L42:
        char[] r111 = this.f573779c;
        int r112 = this.f573780d;
        if (r111[r112] != '\n') goto L45;
        this.f573782f++;
        this.f573783g = r112 + 1;
    L48:
        this.f573780d++;
    L45:
        if (r109 >= 2) goto L50;
        if (this.f573779c[this.f573780d + r109] != "*/".charAt(r109)) goto L48;
        r109 = r109 + 1;
    L50:
        if (r103 == false) goto L52;
        r101 = this.f573780d + 2;
        r102 = this.f573781e;
        goto L3
    L52:
        p("Unterminated comment");
        throw null;
    L39:
        if (c(2) == true) goto L42;
        r103 = false;
        goto L50
    L32:
        if (r108 != '/') goto L33;
        this.f573780d = r107 + 1;
        m();
        r101 = this.f573780d;
        r102 = this.f573781e;
        goto L3
    L33:
        return r105;
    L59:
        r101 = r104;
        goto L3
    L15:
        this.f573782f++;
        this.f573783g = r104;
        goto L59
    }

    public final String h(char r110) throws IOException {
        char[] r100 = this.f573779c;
        StringBuilder r101 = null;
    L3:
        int r102 = this.f573780d;
        int r103 = this.f573781e;
    L4:
        int r104 = r102;
    L6:
        if (r104 >= r103) goto L25;
        int r105 = r104 + 1;
        char r106 = r100[r104];
        if (r106 == r110) goto L9;
        if (r106 == '\\') goto L17;
        if (r106 != '\n') goto L24;
        this.f573782f++;
        this.f573783g = r105;
    L24:
        r104 = r105;
        goto L6
    L17:
        this.f573780d = r105;
        int r107 = (r105 - r102) - 1;
        if (r101 != null) goto L20;
        r101 = new StringBuilder(Math.max((r107 + 1) * 2, 16));
    L20:
        r101.append(r100, r102, r107);
        r101.append(k());
        r102 = this.f573780d;
        r103 = this.f573781e;
        goto L4
    L9:
        this.f573780d = r105;
        int r108 = (r105 - r102) - 1;
        if (r101 == null) goto L12;
        r101.append(r100, r102, r108);
        return r101.toString();
    L12:
        return new String(r100, r102, r108);
    L25:
        if (r101 != null) goto L27;
        r101 = new StringBuilder(Math.max((r104 - r102) * 2, 16));
    L27:
        r101.append(r100, r102, r104 - r102);
        this.f573780d = r104;
        if (c(1) == true) goto L3;
        p("Unterminated string");
        throw null;
    }

    public final void j(int r100) {
        int r101 = this.f573790n;
        int[] r102 = this.f573789m;
        if (r101 != r102.length) goto L5;
        int[] r103 = new int[r101 * 2];
        int[] r104 = new int[r101 * 2];
        String[] r105 = new String[r101 * 2];
        System.arraycopy(r102, 0, r103, 0, r101);
        System.arraycopy(this.f573792p, 0, r104, 0, this.f573790n);
        System.arraycopy(this.f573791o, 0, r105, 0, this.f573790n);
        this.f573789m = r103;
        this.f573792p = r104;
        this.f573791o = r105;
    L5:
        int[] r106 = this.f573789m;
        int r107 = this.f573790n;
        this.f573790n = r107 + 1;
        r106[r107] = r100;
    }

    public final void l(char r100) throws IOException {
        char[] r101 = this.f573779c;
    L3:
        int r102 = this.f573780d;
        int r103 = this.f573781e;
    L5:
        if (r102 >= r103) goto L17;
        int r104 = r102 + 1;
        char r105 = r101[r102];
        if (r105 == r100) goto L8;
        if (r105 == '\\') goto L12;
        if (r105 != '\n') goto L16;
        this.f573782f++;
        this.f573783g = r104;
    L16:
        r102 = r104;
        goto L5
    L12:
        this.f573780d = r104;
        k();
        r102 = this.f573780d;
        r103 = this.f573781e;
        goto L5
    L8:
        this.f573780d = r104;
        return;
    L17:
        this.f573780d = r102;
        if (c(1) == true) goto L3;
        p("Unterminated string");
        throw null;
    }

    public final void p(String r100) throws IOException {
        throw new MalformedJsonException(r100 + e());
    }

    public final void f(String[] r100, int r110) throws IOException {
        switch(a.f573793a[i().ordinal()]) {
            case 1: goto L95;
            case 2: goto L95;
            case 3: goto L95;
            case 4: goto L95;
            case 5: goto L95;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        int r101 = this.f573784h;
        if (r101 != 0) goto L10;
        r101 = b();
    L10:
        if (r101 != 1) goto L94;
        j(3);
        this.f573784h = 0;
    L12:
        int r102 = this.f573784h;
        if (r102 != 0) goto L16;
        r102 = b();
    L16:
        if (r102 != 2) goto L18;
    L20:
        boolean r103 = false;
    L21:
        StringBuilder r104 = null;
        if (r103 == false) goto L86;
        int r105 = this.f573784h;
        if (r105 != 0) goto L27;
        r105 = b();
    L27:
        if (r105 != 14) goto L72;
    L28:
        int r106 = 0;
    L29:
        int r107 = this.f573780d + r106;
        if (r107 < this.f573781e) goto L31;
        if (r106 >= this.f573779c.length) goto L63;
        if (c(r106 + 1) == true) goto L29;
    L68:
        if (r104 != null) goto L70;
        String r108 = new String(this.f573779c, this.f573780d, r106);
    L71:
        this.f573780d += r106;
    L76:
        this.f573784h = 0;
        this.f573791o[this.f573790n - 1] = r108;
        if (r108.equals(r100[r110]) == true) goto L80;
        n();
        goto L12
    L80:
        if (r110 != (r100.length - 1)) goto L82;
        i();
        this.f573785i = (this.f573780d + this.f573787k) - 1;
        n();
        this.f573786j = this.f573780d + this.f573787k;
        return;
    L82:
        f(r100, r110 + 1);
        return;
    L70:
        r104.append(this.f573779c, this.f573780d, r106);
        r108 = r104.toString();
        goto L71
    L63:
        if (r104 != null) goto L65;
        r104 = new StringBuilder(Math.max(r106, 16));
    L65:
        r104.append(this.f573779c, this.f573780d, r106);
        this.f573780d += r106;
        if (c(1) == true) goto L28;
        r106 = 0;
        goto L68
    L31:
        char r109 = this.f573779c[r107];
        if (r109 == '\t') goto L68;
        if (r109 == '\n') goto L68;
        if (r109 == '\f') goto L68;
        if (r109 == '\r') goto L68;
        if (r109 == ' ') goto L68;
        if (r109 == '#') goto L57;
        if (r109 == ',') goto L68;
        if (r109 == '/') goto L57;
        if (r109 == '=') goto L57;
        if (r109 == '{') goto L68;
        if (r109 == '}') goto L68;
        if (r109 == ':') goto L68;
        if (r109 == ';') goto L57;
        switch(r109) {
            case 91: goto L68;
            case 92: goto L57;
            case 93: goto L68;
            default: goto L56;
        };
    L56:
        r106 = r106 + 1;
    L57:
        a();
        goto L68
    L72:
        if (r105 != 12) goto L74;
        r108 = h('\'');
        goto L76
    L74:
        if (r105 != 13) goto L85;
        r108 = h(Typography.quote);
        goto L76
    L85:
        throw new IllegalStateException("Expected a name but was " + i() + e());
    L86:
        System.err.println("there is no key of " + r100[r110]);
        int r111 = this.f573784h;
        if (r111 != 0) goto L89;
        r111 = b();
    L89:
        if (r111 != 2) goto L92;
        int r112 = this.f573790n - 1;
        this.f573790n = r112;
        this.f573791o[r112] = null;
        int[] r113 = this.f573792p;
        int r114 = r112 - 1;
        r113[r114] = r113[r114] + 1;
        this.f573784h = 0;
        return;
    L92:
        throw new IllegalStateException("Expected END_OBJECT but was " + i() + e());
    L18:
        if (r102 == 4) goto L20;
        r103 = true;
        goto L21
    L94:
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + i() + e());
    L95:
        n();
        return;
    L5:
        throw new IllegalArgumentException();
    }
}
