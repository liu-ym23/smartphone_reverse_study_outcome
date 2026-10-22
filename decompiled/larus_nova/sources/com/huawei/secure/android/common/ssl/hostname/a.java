package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f278151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f278152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f278153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f278154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f278155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f278156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char[] f278157g;

    private String a() {
        int r100 = this.f278153c;
        this.f278154d = r100;
        this.f278155e = r100;
    L3:
        int r101 = this.f278153c;
        if (r101 >= this.f278152b) goto L5;
        char[] r102 = this.f278157g;
        char r103 = r102[r101];
        if (r103 != ' ') goto L9;
        int r104 = this.f278155e;
        this.f278156f = r104;
        this.f278153c = r101 + 1;
        this.f278155e = r104 + 1;
        r102[r104] = ' ';
    L19:
        int r105 = this.f278153c;
        int r106 = this.f278152b;
        if (r105 >= r106) goto L24;
        char[] r107 = this.f278157g;
        if (r107[r105] != ' ') goto L24;
        int r108 = this.f278155e;
        this.f278155e = r108 + 1;
        r107[r108] = ' ';
        this.f278153c = r105 + 1;
    L24:
        if (r105 == r106) goto L29;
        char r109 = this.f278157g[r105];
        if (r109 == ',') goto L29;
        if (r109 == '+') goto L29;
        if (r109 != ';') goto L3;
    L29:
        char[] r110 = this.f278157g;
        int r111 = this.f278154d;
        return new String(r110, r111, this.f278156f - r111);
    L9:
        if (r103 == ';') goto L16;
        if (r103 != '\\') goto L12;
        int r112 = this.f278155e;
        this.f278155e = r112 + 1;
        r102[r112] = b();
        this.f278153c++;
        goto L3
    L12:
        if (r103 == '+') goto L16;
        if (r103 == ',') goto L16;
        int r113 = this.f278155e;
        this.f278155e = r113 + 1;
        r102[r113] = r103;
        this.f278153c = r101 + 1;
    L16:
        int r114 = this.f278154d;
        return new String(r102, r114, this.f278155e - r114);
    L5:
        char[] r115 = this.f278157g;
        int r116 = this.f278154d;
        return new String(r115, r116, this.f278155e - r116);
    }

    private char b() {
        int r100 = this.f278153c + 1;
        this.f278153c = r100;
        if (r100 == this.f278152b) goto L21;
        char r101 = this.f278157g[r100];
        if (r101 != ' ') goto L7;
        return r101;
    L7:
        if (r101 != '%') goto L9;
        return r101;
    L9:
        if (r101 != '\\') goto L11;
        return r101;
    L11:
        if (r101 != '_') goto L13;
        return r101;
    L13:
        if (r101 != '\"') goto L15;
        return r101;
    L15:
        if (r101 == '#') goto L27;
        switch(r101) {
            case 42: goto L28;
            case 43: goto L28;
            case 44: goto L28;
            default: goto L17;
        };
    L17:
        switch(r101) {
            case 59: goto L29;
            case 60: goto L29;
            case 61: goto L29;
            case 62: goto L29;
            default: goto L19;
        };
    L29:
        return r101;
    L19:
        return c();
    L28:
        return r101;
    L27:
        return r101;
    L21:
        throw new IllegalStateException("Unexpected end of DN: " + this.f278151a);
    }

    private char c() {
        int r100 = a(this.f278153c);
        this.f278153c++;
        if (r100 >= 128) goto L7;
        return (char) r100;
    L7:
        if (r100 >= 192) goto L9;
    L31:
        return '?';
    L9:
        if (r100 > 247) goto L31;
        if (r100 > 223) goto L14;
        int r101 = r100 & 31;
        int r102 = 1;
    L17:
        int r103 = 0;
    L18:
        if (r103 >= r102) goto L30;
        int r104 = this.f278153c + 1;
        this.f278153c = r104;
        if (r104 == this.f278152b) goto L28;
        if (this.f278157g[r104] != '\\') goto L28;
        int r105 = r104 + 1;
        this.f278153c = r105;
        int r106 = a(r105);
        this.f278153c++;
        if ((r106 & 192) != 128) goto L26;
        r101 = (r101 << 6) + (r106 & 63);
        r103 = r103 + 1;
        goto L18
    L26:
        return '?';
    L28:
        return '?';
    L30:
        return (char) r101;
    L14:
        if (r100 > 239) goto L16;
        r101 = r100 & 15;
        r102 = 2;
        goto L17
    L16:
        r101 = r100 & 7;
        r102 = 3;
        goto L17
    }

    private String d() {
        int r100 = this.f278153c;
        if ((r100 + 4) >= this.f278152b) goto L41;
        this.f278154d = r100;
        this.f278153c = r100 + 1;
    L5:
        int r101 = this.f278153c;
        if (r101 == this.f278152b) goto L28;
        char[] r102 = this.f278157g;
        char r103 = r102[r101];
        if (r103 == '+') goto L28;
        if (r103 == ',') goto L28;
        if (r103 == ';') goto L28;
        if (r103 == ' ') goto L16;
        if (r103 < 'A') goto L27;
        if (r103 > 'F') goto L27;
        r102[r101] = (char) (r103 + ' ');
    L27:
        this.f278153c = r101 + 1;
        goto L5
    L16:
        this.f278155e = r101;
        this.f278153c = r101 + 1;
    L17:
        int r104 = this.f278153c;
        if (r104 >= this.f278152b) goto L29;
        if (this.f278157g[r104] != ' ') goto L29;
        this.f278153c = r104 + 1;
    L29:
        int r105 = this.f278155e;
        int r106 = this.f278154d;
        int r107 = r105 - r106;
        if (r107 < 5) goto L39;
        if ((r107 & 1) == 0) goto L39;
        int r108 = r107 / 2;
        byte[] r109 = new byte[r108];
        int r110 = r106 + 1;
        int r111 = 0;
    L34:
        if (r111 >= r108) goto L37;
        r109[r111] = (byte) a(r110);
        r110 = r110 + 2;
        r111 = r111 + 1;
        goto L34
    L37:
        return new String(this.f278157g, this.f278154d, r107);
    L39:
        throw new IllegalStateException("Unexpected end of DN: " + this.f278151a);
    L28:
        this.f278155e = r101;
        goto L29
    L41:
        throw new IllegalStateException("Unexpected end of DN: " + this.f278151a);
    }

    private String e() {
    L2:
        int r100 = this.f278153c;
        int r101 = this.f278152b;
        if (r100 >= r101) goto L7;
        if (this.f278157g[r100] != ' ') goto L7;
        this.f278153c = r100 + 1;
    L7:
        if (r100 != r101) goto L10;
        return null;
    L10:
        this.f278154d = r100;
        this.f278153c = r100 + 1;
    L11:
        int r102 = this.f278153c;
        int r103 = this.f278152b;
        if (r102 >= r103) goto L18;
        char r104 = this.f278157g[r102];
        if (r104 == '=') goto L18;
        if (r104 == ' ') goto L18;
        this.f278153c = r102 + 1;
    L18:
        if (r102 >= r103) goto L59;
        this.f278155e = r102;
        if (this.f278157g[r102] != ' ') goto L33;
    L21:
        int r105 = this.f278153c;
        int r106 = this.f278152b;
        if (r105 >= r106) goto L28;
        char r107 = this.f278157g[r105];
        if (r107 == '=') goto L28;
        if (r107 != ' ') goto L28;
        this.f278153c = r105 + 1;
    L28:
        if (this.f278157g[r105] != '=') goto L32;
        if (r105 != r106) goto L33;
    L32:
        throw new IllegalStateException("Unexpected end of DN: " + this.f278151a);
    L33:
        this.f278153c++;
    L34:
        int r108 = this.f278153c;
        if (r108 >= this.f278152b) goto L39;
        if (this.f278157g[r108] != ' ') goto L39;
        this.f278153c = r108 + 1;
    L39:
        int r109 = this.f278155e;
        int r110 = this.f278154d;
        if ((r109 - r110) <= 4) goto L56;
        char[] r111 = this.f278157g;
        if (r111[r110 + 3] != '.') goto L56;
        char r112 = r111[r110];
        if (r112 != 'O') goto L46;
    L47:
        char r113 = r111[r110 + 1];
        if (r113 != 'I') goto L50;
    L51:
        char r114 = r111[r110 + 2];
        if (r114 != 'D') goto L54;
    L55:
        this.f278154d = r110 + 4;
        goto L56
    L54:
        if (r114 != 'd') goto L56;
    L50:
        if (r113 != 'i') goto L56;
    L46:
        if (r112 == 'o') goto L47;
    L56:
        char[] r115 = this.f278157g;
        int r116 = this.f278154d;
        return new String(r115, r116, r109 - r116);
    L59:
        throw new IllegalStateException("Unexpected end of DN: " + this.f278151a);
    }

    private String f() {
        int r100 = this.f278153c + 1;
        this.f278153c = r100;
        this.f278154d = r100;
        this.f278155e = r100;
    L3:
        int r101 = this.f278153c;
        if (r101 == this.f278152b) goto L21;
        char[] r102 = this.f278157g;
        char r103 = r102[r101];
        if (r103 == '\"') goto L7;
        if (r103 != '\\') goto L18;
        r102[this.f278155e] = b();
    L19:
        this.f278153c++;
        this.f278155e++;
        goto L3
    L18:
        r102[this.f278155e] = r103;
        goto L19
    L7:
        this.f278153c = r101 + 1;
    L8:
        int r104 = this.f278153c;
        if (r104 >= this.f278152b) goto L13;
        if (this.f278157g[r104] != ' ') goto L13;
        this.f278153c = r104 + 1;
    L13:
        char[] r105 = this.f278157g;
        int r106 = this.f278154d;
        return new String(r105, r106, this.f278155e - r106);
    L21:
        throw new IllegalStateException("Unexpected end of DN: " + this.f278151a);
    }

    public a(X500Principal r100) {
        String r101 = r100.getName("RFC2253");
        this.f278151a = r101;
        this.f278152b = r101.length();
    }

    public String a(String r100) {
        this.f278153c = 0;
        this.f278154d = 0;
        this.f278155e = 0;
        this.f278156f = 0;
        this.f278157g = this.f278151a.toCharArray();
        String r101 = e();
        if (r101 != null) goto L5;
        return null;
    L5:
        int r102 = this.f278153c;
        if (r102 == this.f278152b) goto L7;
        char r103 = this.f278157g[r102];
        if (r103 != '\"') goto L11;
        String r104 = f();
    L20:
        if (r100.equalsIgnoreCase(r101) == true) goto L21;
        int r105 = this.f278153c;
        if (r105 >= this.f278152b) goto L24;
        char r106 = this.f278157g[r105];
        if (r106 == ',') goto L33;
        if (r106 == ';') goto L33;
        if (r106 == '+') goto L33;
        throw new IllegalStateException("Malformed DN: " + this.f278151a);
    L33:
        this.f278153c = r105 + 1;
        r101 = e();
        if (r101 != null) goto L5;
        throw new IllegalStateException("Malformed DN: " + this.f278151a);
    L24:
        return null;
    L21:
        return r104;
    L11:
        if (r103 == '#') goto L17;
        if (r103 == '+') goto L16;
        if (r103 == ',') goto L16;
        if (r103 == ';') goto L16;
        r104 = a();
    L16:
        r104 = "";
        goto L20
    L17:
        r104 = d();
        goto L20
    L7:
        return null;
    }

    public List<String> b(String r100) {
        this.f278153c = 0;
        this.f278154d = 0;
        this.f278155e = 0;
        this.f278156f = 0;
        this.f278157g = this.f278151a.toCharArray();
        List<String> r101 = Collections.emptyList();
        String r102 = e();
        if (r102 != null) goto L5;
        return r101;
    L5:
        int r103 = this.f278153c;
        if (r103 >= this.f278152b) goto L40;
        char r104 = this.f278157g[r103];
        if (r104 != '\"') goto L10;
        String r105 = f();
    L19:
        if (r100.equalsIgnoreCase(r102) == true) goto L21;
    L24:
        int r106 = this.f278153c;
        if (r106 >= this.f278152b) goto L40;
        char r107 = this.f278157g[r106];
        if (r107 == ',') goto L35;
        if (r107 == ';') goto L35;
        if (r107 == '+') goto L35;
        throw new IllegalStateException("Malformed DN: " + this.f278151a);
    L35:
        this.f278153c = r106 + 1;
        r102 = e();
        if (r102 != null) goto L5;
        throw new IllegalStateException("Malformed DN: " + this.f278151a);
    L21:
        if (r101.isEmpty() == false) goto L23;
        r101 = new ArrayList();
    L23:
        r101.add(r105);
        goto L24
    L10:
        if (r104 == '#') goto L16;
        if (r104 == '+') goto L15;
        if (r104 == ',') goto L15;
        if (r104 == ';') goto L15;
        r105 = a();
    L15:
        r105 = "";
        goto L19
    L16:
        r105 = d();
    L40:
        return r101;
    }

    private int a(int r110) {
        int r100 = r110 + 1;
        if (r100 >= this.f278152b) goto L31;
        char[] r101 = this.f278157g;
        char r111 = r101[r110];
        if (r111 < '0') goto L8;
        if (r111 > '9') goto L8;
        int r112 = r111 - '0';
    L14:
        char r102 = r101[r100];
        if (r102 < '0') goto L18;
        if (r102 > '9') goto L18;
        int r103 = r102 - '0';
    L25:
        return (r112 << 4) + r103;
    L18:
        if (r102 < 'a') goto L21;
        if (r102 > 'f') goto L21;
        r103 = r102 - 'W';
    L21:
        if (r102 < 'A') goto L27;
        if (r102 > 'F') goto L27;
        r103 = r102 - '7';
    L27:
        throw new IllegalStateException("Malformed DN: " + this.f278151a);
    L8:
        if (r111 < 'a') goto L11;
        if (r111 > 'f') goto L11;
        r112 = r111 - 'W';
    L11:
        if (r111 < 'A') goto L29;
        if (r111 > 'F') goto L29;
        r112 = r111 - '7';
    L29:
        throw new IllegalStateException("Malformed DN: " + this.f278151a);
    L31:
        throw new IllegalStateException("Malformed DN: " + this.f278151a);
    }
}
