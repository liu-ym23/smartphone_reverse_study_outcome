package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.UncheckedIOException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f492600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Reader f492601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f492602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f492603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f492604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f492605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f492606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String[] f492607h;

    public final void a() {
        this.f492604e++;
    }

    public final void b() {
        int r100 = this.f492604e;
        if (r100 >= this.f492603d) goto L15;
        return;
    L15:
        this.f492601b.skip(r100);     // Catch: IOException -> L12
        this.f492601b.mark(4096);     // Catch: IOException -> L12
        int r101 = this.f492601b.read(this.f492600a);     // Catch: IOException -> L12
        this.f492601b.reset();     // Catch: IOException -> L12
        if (r101 == (-1)) goto L17;
        this.f492602c = r101;     // Catch: IOException -> L12
        this.f492605f += this.f492604e;     // Catch: IOException -> L12
        this.f492604e = 0;     // Catch: IOException -> L12
        this.f492606g = 0;     // Catch: IOException -> L12
        if (r101 <= 3072) goto L10;
        r101 = 3072;
    L10:
        this.f492603d = r101;     // Catch: IOException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        throw new UncheckedIOException(e);
    }

    public final void q() {
        this.f492604e--;
    }

    public final String toString() {
        char[] r100 = this.f492600a;
        int r101 = this.f492604e;
        return new String(r100, r101, this.f492602c - r101);
    }

    public final char d() {
        b();
        int r100 = this.f492604e;
        if (r100 < this.f492602c) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        char r102 = CharCompanionObject.MAX_VALUE;
    L9:
        this.f492604e = r100 + 1;
        return r102;
    L8:
        r102 = this.f492600a[r100];
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    public final String e() {
        b();
        int r100 = this.f492604e;
    L3:
        int r101 = this.f492604e;
        if (r101 >= this.f492602c) goto L17;
        char r102 = this.f492600a[r101];
        if (r102 < 'A') goto L10;
        if (r102 > 'Z') goto L10;
    L15:
        this.f492604e++;
    L10:
        if (r102 < 'a') goto L14;
        if (r102 <= 'z') goto L15;
    L14:
        if (Character.isLetter(r102) == true) goto L15;
    L17:
        return c(this.f492600a, this.f492607h, r100, this.f492604e - r100);
    }

    public final char i() {
        b();
        int r100 = this.f492604e;
        if (r100 < this.f492602c) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return CharCompanionObject.MAX_VALUE;
    L9:
        return this.f492600a[r100];
    L5:
        r101 = false;
        goto L6
    }

    public final boolean j() {
        b();
        if (this.f492604e < this.f492602c) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean o() {
        if (j() == false) goto L5;
        return false;
    L5:
        char r100 = this.f492600a[this.f492604e];
        if (r100 < 'A') goto L10;
        if (r100 > 'Z') goto L10;
    L15:
        return true;
    L10:
        if (r100 < 'a') goto L14;
        if (r100 <= 'z') goto L15;
    L14:
        if (Character.isLetter(r100) == true) goto L15;
        return false;
    }

    public a(String r100) {
        StringReader r101 = new StringReader(r100);
        r100.getClass();
        this.f492607h = new String[128];
        if (r101.markSupported() == false) goto L7;
        this.f492601b = r101;
        this.f492600a = new char[4096];
        b();
        return;
    L7:
        throw new IllegalArgumentException("Must be true");
    }

    public final String f(char r100) {
        b();
        int r101 = this.f492604e;
    L4:
        if (r101 >= this.f492602c) goto L9;
        if (r100 == this.f492600a[r101]) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        int r102 = r101 - this.f492604e;
    L10:
        if (r102 == (-1)) goto L13;
        String r103 = c(this.f492600a, this.f492607h, this.f492604e, r102);
        this.f492604e += r102;
        return r103;
    L13:
        b();
        char[] r104 = this.f492600a;
        String[] r105 = this.f492607h;
        int r106 = this.f492604e;
        String r107 = c(r104, r105, r106, this.f492602c - r106);
        this.f492604e = this.f492602c;
        return r107;
    L9:
        r102 = -1;
        goto L10
    }

    public final String g(char... r100) {
        b();
        int r101 = this.f492604e;
        int r102 = this.f492602c;
        char[] r103 = this.f492600a;
    L4:
        if (this.f492604e >= r102) goto L12;
        int r104 = r100.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L11;
        if (r103[this.f492604e] == r100[r105]) goto L12;
        r105 = r105 + 1;
        goto L6
    L11:
        this.f492604e++;
    L12:
        int r106 = this.f492604e;
        if (r106 > r101) goto L20;
        return "";
    L20:
        return c(this.f492600a, this.f492607h, r101, r106 - r101);
    }

    public final String h(char... r100) {
        b();
        int r101 = this.f492604e;
        int r102 = this.f492602c;
        char[] r103 = this.f492600a;
    L3:
        int r104 = this.f492604e;
        if (r104 >= r102) goto L9;
        if (Arrays.binarySearch(r100, r103[r104]) >= 0) goto L9;
        this.f492604e++;
    L9:
        int r105 = this.f492604e;
        if (r105 > r101) goto L16;
        return "";
    L16:
        return c(this.f492600a, this.f492607h, r101, r105 - r101);
    }

    public final boolean k(String r100) {
        b();
        b();
        int r101 = r100.length();
        if (r101 > (this.f492602c - this.f492604e)) goto L9;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (r100.charAt(r102) != this.f492600a[this.f492604e + r102]) goto L9;
        r102 = r102 + 1;
        goto L6
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        this.f492604e += r100.length();
        return true;
    L15:
        return false;
    L9:
        r103 = false;
        goto L12
    }

    public final boolean l(String r100) {
        b();
        int r101 = r100.length();
        if (r101 > (this.f492602c - this.f492604e)) goto L9;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (Character.toUpperCase(r100.charAt(r102)) != Character.toUpperCase(this.f492600a[this.f492604e + r102])) goto L9;
        r102 = r102 + 1;
        goto L6
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        this.f492604e += r100.length();
        return true;
    L15:
        return false;
    L9:
        r103 = false;
        goto L12
    }

    public final boolean m(char r100) {
        if (j() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f492600a[this.f492604e] != r100) goto L7;
        return true;
    }

    public final boolean n(char... r100) {
        if (j() == false) goto L5;
        return false;
    L5:
        b();
        char r101 = this.f492600a[this.f492604e];
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r100[r103] == r101) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public final int p(CharSequence r100) {
        b();
        String r101 = (String) r100;
        char r102 = r101.charAt(0);
        int r103 = this.f492604e;
    L4:
        if (r103 >= this.f492602c) goto L24;
        int r104 = 1;
        if (r102 == this.f492600a[r103]) goto L12;
    L7:
        r103 = r103 + 1;
        if (r103 >= this.f492602c) goto L12;
        if (r102 != this.f492600a[r103]) goto L7;
    L12:
        int r105 = r103 + 1;
        int r106 = (r101.length() + r105) - 1;
        int r107 = this.f492602c;
        if (r103 >= r107) goto L23;
        if (r106 > r107) goto L23;
        int r108 = r105;
    L16:
        if (r108 >= r106) goto L20;
        if (r101.charAt(r104) != this.f492600a[r108]) goto L20;
        r108 = r108 + 1;
        r104 = r104 + 1;
    L20:
        if (r108 != r106) goto L23;
        return r103 - this.f492604e;
    L23:
        r103 = r105;
        goto L4
    L24:
        return -1;
    }

    public static String c(char[] r100, String[] r110, int r111, int r112) {
        if (r112 > 12) goto L5;
        boolean r101 = true;
        if (r112 >= 1) goto L10;
        return "";
    L10:
        int r102 = r111;
        int r103 = 0;
        int r104 = 0;
    L11:
        if (r103 >= r112) goto L13;
        r104 = (r104 * 31) + r100[r102];
        r103 = r103 + 1;
        r102 = r102 + 1;
        goto L11
    L13:
        int r105 = (r110.length - 1) & r104;
        String r106 = r110[r105];
        if (r106 != null) goto L17;
        String r107 = new String(r100, r111, r112);
        r110[r105] = r107;
        return r107;
    L17:
        if (r112 != r106.length()) goto L25;
        int r108 = r111;
        int r109 = r112;
        int r113 = 0;
    L19:
        int r114 = r109 - 1;
        if (r109 == 0) goto L26;
        int r115 = r108 + 1;
        int r116 = r113 + 1;
        if (r100[r108] != r106.charAt(r113)) goto L25;
        r108 = r115;
        r109 = r114;
        r113 = r116;
    L26:
        if (r101 == false) goto L28;
        return r106;
    L28:
        String r117 = new String(r100, r111, r112);
        r110[r105] = r117;
        return r117;
    L25:
        r101 = false;
        goto L26
    L5:
        return new String(r100, r111, r112);
    }
}
