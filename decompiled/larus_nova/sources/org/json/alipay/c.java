package org.json.alipay;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes42.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f525885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Reader f525886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f525887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f525888d;

    public c(Reader r100) {
        if (r100.markSupported() == true) goto L6;
        r100 = new BufferedReader(r100);
    L6:
        this.f525886b = r100;
        this.f525888d = false;
        this.f525885a = 0;
    }

    public c(String r100) {
        this(new StringReader(r100));
    }

    private String a(int r100) {
        if (r100 != 0) goto L5;
        return "";
    L5:
        char[] r101 = new char[r100];
        int r102 = 0;
        if (this.f525888d == false) goto L8;
        this.f525888d = false;
        r101[0] = this.f525887c;
        r102 = 1;
    L8:
        if (r102 >= r100) goto L16;
        int r103 = this.f525886b.read(r101, r102, r100 - r102);     // Catch: IOException -> L13
        if (r103 == (-1)) goto L16;
        r102 = r102 + r103;
    L13:
        e = move-exception;
        throw new JSONException(e);
    L16:
        this.f525885a += r102;
        if (r102 < r100) goto L21;
        this.f525887c = r101[r100 - 1];
        return new String(r101);
    L21:
        throw a("Substring bounds error");
    }

    public final JSONException a(String r100) {
        return new JSONException(r100 + toString());
    }

    public final void a() {
        if (this.f525888d == true) goto L9;
        int r100 = this.f525885a;
        if (r100 <= 0) goto L9;
        this.f525885a = r100 - 1;
        this.f525888d = true;
        return;
    L9:
        throw new JSONException("Stepping back two steps is not supported");
    }

    public final char b() {
        if (this.f525888d == false) goto L17;
        this.f525888d = false;
        char r100 = this.f525887c;
        if (r100 == 0) goto L7;
        this.f525885a++;
    L7:
        return r100;
    L17:
        int r101 = this.f525886b.read();     // Catch: IOException -> L14
        if (r101 > 0) goto L12;
        this.f525887c = 0;
        return 0;
    L12:
        this.f525885a++;
        char r102 = (char) r101;
        this.f525887c = r102;
        return r102;
    L14:
        e = move-exception;
        throw new JSONException(e);
    }

    public final char c() {
    L2:
        char r100 = b();
        if (r100 == '/') goto L4;
        if (r100 == '#') goto L24;
        if (r100 == 0) goto L32;
        if (r100 <= ' ') goto L2;
    L32:
        return r100;
    L24:
        char r101 = b();
        if (r101 == '\n') goto L2;
        if (r101 == '\r') goto L2;
        if (r101 != 0) goto L24;
    L4:
        char r102 = b();
        if (r102 != '*') goto L6;
    L14:
        char r103 = b();
        if (r103 == 0) goto L21;
        if (r103 != '*') goto L14;
        if (b() == '/') goto L2;
        a();
        goto L14
    L21:
        throw a("Unclosed comment");
    L6:
        if (r102 != '/') goto L7;
    L9:
        char r104 = b();
        if (r104 == '\n') goto L2;
        if (r104 == '\r') goto L2;
        if (r104 != 0) goto L9;
    L7:
        a();
        return '/';
    }

    public final Object d() {
        char r100 = c();
        if (r100 != '\"') goto L5;
    L68:
        StringBuffer r101 = new StringBuffer();
    L69:
        char r102 = b();
        if (r102 == 0) goto L103;
        if (r102 == '\n') goto L103;
        if (r102 == '\r') goto L103;
        if (r102 != '\\') goto L77;
        r102 = b();
        if (r102 != 'b') goto L83;
        r101.append('\b');
        goto L69
    L83:
        if (r102 == 'f') goto L100;
        if (r102 != 'n') goto L87;
        r101.append('\n');
        goto L69
    L87:
        if (r102 != 'r') goto L88;
        r101.append('\r');
        goto L69
    L88:
        if (r102 != 'x') goto L90;
        String r103 = a(2);
    L97:
        r102 = (char) CastIntegerProtector.parseInt(r103, 16);
    L93:
        r101.append(r102);
        goto L69
    L90:
        if (r102 != 't') goto L92;
        r102 = '\t';
        goto L93
    L92:
        if (r102 != 'u') goto L93;
        r103 = a(4);
        goto L97
    L100:
        r102 = '\f';
        goto L93
    L77:
        if (r102 != r100) goto L93;
        return r101.toString();
    L103:
        throw a("Unterminated string");
    L5:
        if (r100 != '[') goto L7;
    L66:
        a();
        return new a(this);
    L7:
        if (r100 != '{') goto L9;
        a();
        return new b(this);
    L9:
        if (r100 == '\'') goto L68;
        if (r100 == '(') goto L66;
        StringBuffer r104 = new StringBuffer();
        char r105 = r100;
    L14:
        if (r105 < ' ') goto L18;
        if (",:]}/\\\"[{;=#".indexOf(r105) >= 0) goto L18;
        r104.append(r105);
        r105 = b();
    L18:
        a();
        String r106 = r104.toString().trim();
        if (r106.equals("") == true) goto L63;
        if (r106.equalsIgnoreCase("true") == false) goto L25;
        return Boolean.TRUE;
    L25:
        if (r106.equalsIgnoreCase("false") == false) goto L29;
        return Boolean.FALSE;
    L29:
        if (r106.equalsIgnoreCase("null") == false) goto L33;
        return b.f525883a;
    L33:
        if (r100 < '0') goto L37;
        if (r100 > '9') goto L37;
    L44:
        if (r100 == '0') goto L107;
    L105:
        return new Integer(r106);
    L57:
        return new Long(r106);
    L59:
        return new Double(r106);
    L61:
        return r106;
    L107:
        if (r106.length() <= 2) goto L54;
        if (r106.charAt(1) == 'x') goto L52;
        if (r106.charAt(1) != 'X') goto L54;
    L52:
        return new Integer(CastIntegerProtector.parseInt(r106.substring(2), 16));
    L54:
        return new Integer(CastIntegerProtector.parseInt(r106, 8));
    L37:
        if (r100 == '.') goto L44;
        if (r100 == '-') goto L44;
        if (r100 == '+') goto L44;
        return r106;
    L63:
        throw a("Missing value");
    }

    public final String toString() {
        return " at character " + this.f525885a;
    }
}
