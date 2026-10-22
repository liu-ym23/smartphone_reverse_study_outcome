package org.jsoup.parser;

import org.jsoup.helper.ValidationException;

/* JADX INFO: loaded from: classes42.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f526043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f526044b;

    public final boolean f() {
        boolean r100 = false;
    L4:
        if (g() == false) goto L6;
    L8:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L11;
        this.f526044b++;
        r100 = true;
        goto L4
    L11:
        return r100;
    L6:
        if (fwc.b.e(this.f526043a.charAt(this.f526044b)) == false) goto L8;
        r101 = true;
        goto L9
    }

    public final String b() {
        int r100 = this.f526043a.indexOf(")", this.f526044b);
        if (r100 == (-1)) goto L5;
        String r101 = this.f526043a.substring(this.f526044b, r100);
        this.f526044b += r101.length();
    L6:
        h(")");
        return r101;
    L5:
        r101 = l();
        goto L6
    }

    public final char c() {
        String r100 = this.f526043a;
        int r101 = this.f526044b;
        this.f526044b = r101 + 1;
        return r100.charAt(r101);
    }

    public final String e() {
        int r100 = this.f526044b;
    L4:
        if (g() == true) goto L19;
        if (k() == true) goto L17;
        char[] r101 = {'-', '_'};
        boolean r102 = false;
        if (g() == true) goto L16;
        int r103 = 0;
    L11:
        if (r103 >= 2) goto L16;
        if (this.f526043a.charAt(this.f526044b) == r101[r103]) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        r102 = true;
    L16:
        if (r102 == false) goto L19;
    L17:
        this.f526044b++;
    L19:
        return this.f526043a.substring(r100, this.f526044b);
    }

    public final boolean g() {
        if ((this.f526043a.length() - this.f526044b) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String l() {
        String r100 = this.f526043a.substring(this.f526044b);
        this.f526044b = this.f526043a.length();
        return r100;
    }

    public final String toString() {
        return this.f526043a.substring(this.f526044b);
    }

    public final boolean k() {
        if (g() == false) goto L5;
    L7:
        return false;
    L5:
        if (Character.isLetterOrDigit(this.f526043a.charAt(this.f526044b)) == false) goto L7;
        return true;
    }

    public g(String r100) {
        this.f526044b = 0;
        ewc.b.d(r100);
        this.f526043a = r100;
    }

    public static String m(String r100) {
        StringBuilder r101 = fwc.b.b();
        char[] r102 = r100.toCharArray();
        int r103 = r102.length;
        int r104 = 0;
        char r105 = 0;
    L3:
        if (r104 >= r103) goto L11;
        char r106 = r102[r104];
        if (r106 != '\\') goto L8;
        if (r105 != '\\') goto L9;
        r101.append(r106);
    L9:
        r104 = r104 + 1;
        r105 = r106;
        goto L3
    L8:
        r101.append(r106);
        goto L9
    L11:
        return fwc.b.g(r101);
    }

    public final void d(String r100) {
        if (i(r100) == false) goto L11;
        int r101 = r100.length();
        int r102 = this.f526043a.length();
        int r103 = this.f526044b;
        if (r101 > (r102 - r103)) goto L9;
        this.f526044b = r103 + r101;
        return;
    L9:
        throw new IllegalStateException("Queue not long enough to consume sequence");
    L11:
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public final boolean h(String r100) {
        if (i(r100) == false) goto L6;
        this.f526044b += r100.length();
        return true;
    L6:
        return false;
    }

    public final boolean i(String r100) {
        return this.f526043a.regionMatches(true, this.f526044b, r100, 0, r100.length());
    }

    public final boolean j(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (i(r100[r102]) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final String a(char r110, char r111) {
        char r100 = 0;
        boolean r101 = false;
        boolean r102 = false;
        int r103 = -1;
        int r104 = -1;
        int r105 = 0;
        boolean r106 = false;
    L4:
        if (g() == true) goto L38;
        char r107 = c();
        if (r100 == '\\') goto L29;
        if (r107 != '\'') goto L14;
        if (r107 == r110) goto L14;
        if (r101 == true) goto L14;
        r102 = !r102;
    L18:
        if (r102 == true) goto L37;
        if (r101 == true) goto L37;
        if (r106 == true) goto L37;
        if (r107 != r110) goto L26;
        r105 = r105 + 1;
        if (r103 != (-1)) goto L34;
        r103 = this.f526044b;
    L34:
        if (r105 <= 0) goto L37;
        if (r100 == 0) goto L37;
        r104 = this.f526044b;
        goto L37
    L26:
        if (r107 != r111) goto L34;
        r105 = r105 - 1;
    L37:
        if (r105 <= 0) goto L38;
        r100 = r107;
    L14:
        if (r107 != '\"') goto L18;
        if (r107 == r110) goto L18;
        if (r102 == true) goto L18;
        r101 = !r101;
        goto L18
    L29:
        if (r107 != 'Q') goto L32;
        r106 = true;
        goto L34
    L32:
        if (r107 != 'E') goto L34;
        r106 = false;
    L38:
        if (r104 < 0) goto L40;
        String r112 = this.f526043a.substring(r103, r104);
    L41:
        if (r105 > 0) goto L44;
        return r112;
    L44:
        throw new ValidationException("Did not find balanced marker at '" + r112 + "'");
    L40:
        r112 = "";
        goto L41
    }
}
