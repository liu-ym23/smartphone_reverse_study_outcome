package org.jsoup.parser;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.annotation.Nullable;
import kotlin.jvm.internal.CharCompanionObject;
import org.jsoup.UncheckedIOException;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f525990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Reader f525991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f525992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f525993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f525994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f525995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f525996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f525997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public ArrayList<Integer> f525998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f525999j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f526000k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public String f526001l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f526002m;

    public final void a() {
        this.f525994e++;
    }

    public final void b() {
        if (this.f526000k == true) goto L35;
        int r100 = this.f525994e;
        if (r100 < this.f525993d) goto L40;
        int r101 = this.f525996g;
        if (r101 == (-1)) goto L10;
        int r102 = r100 - r101;
        r100 = r101;
    L36:
        long r103 = r100;
        long r104 = this.f525991b.skip(r103);     // Catch: IOException -> L32
        this.f525991b.mark(32768);     // Catch: IOException -> L32
        int r105 = 0;
    L12:
        boolean r110 = true;
        if (r105 > 1024) goto L20;
        Reader r106 = this.f525991b;     // Catch: IOException -> L32
        char[] r111 = this.f525990a;     // Catch: IOException -> L32
        int r107 = r106.read(r111, r105, r111.length - r105);     // Catch: IOException -> L32
        if (r107 != (-1)) goto L17;
        this.f526000k = true;     // Catch: IOException -> L32
    L17:
        if (r107 <= 0) goto L20;
        r105 = r105 + r107;     // Catch: IOException -> L32
    L20:
        this.f525991b.reset();     // Catch: IOException -> L32
        if (r105 > 0) goto L23;
    L30:
        x();
        this.f526001l = null;
        return;
    L23:
        if (r104 == r103) goto L26;
        r110 = false;
    L26:
        ewc.b.a(r110);     // Catch: IOException -> L32
        this.f525992c = r105;     // Catch: IOException -> L32
        this.f525995f += r100;     // Catch: IOException -> L32
        this.f525994e = r102;     // Catch: IOException -> L32
        if (this.f525996g == (-1)) goto L29;
        this.f525996g = 0;     // Catch: IOException -> L32
    L29:
        this.f525993d = Math.min(r105, 24576);     // Catch: IOException -> L32
    L32:
        e = move-exception;
        throw new UncheckedIOException(e);
    L10:
        r102 = 0;
        goto L36
    L40:
        return;
    }

    public final void d() {
        Reader r100 = this.f525991b;
        if (r100 != null) goto L14;
        return;
    L14:
        r100.close();     // Catch: Throwable -> L8 IOException -> L13
    L8:
        th = move-exception;
        this.f525991b = null;
        this.f525990a = null;
        this.f525997h = null;
        throw th;
    L11:
        this.f525991b = null;
        this.f525990a = null;
        this.f525997h = null;
    }

    public final String g() {
        int r100 = this.f525994e;
        int r101 = this.f525992c;
        char[] r102 = this.f525990a;
        int r103 = r100;
    L3:
        if (r103 >= r101) goto L11;
        char r104 = r102[r103];
        if (r104 == 0) goto L11;
        if (r104 == '&') goto L11;
        if (r104 == '<') goto L11;
        r103 = r103 + 1;
    L11:
        this.f525994e = r103;
        if (r103 > r100) goto L20;
        return "";
    L20:
        return c(this.f525990a, this.f525997h, r100, r103 - r100);
    }

    public final String m() {
        StringBuilder r100 = new StringBuilder();
        int r101 = this.f525995f + this.f525994e;
        boolean r102 = false;
        if (this.f525998i == null) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
        int r104 = 1;
    L13:
        r100.append(r104);
        r100.append(":");
        int r105 = this.f525995f + this.f525994e;
        if (this.f525998i == null) goto L16;
        r102 = true;
    L16:
        if (r102 == false) goto L22;
        int r106 = o(r105);
        if (r106 == (-1)) goto L22;
        r105 = r105 - ((Integer) ListProtector.get(this.f525998i, r106)).intValue();
    L22:
        r100.append(r105 + 1);
        return r100.toString();
    L9:
        int r107 = o(r101);
        if (r107 != (-1)) goto L12;
        r104 = this.f525999j;
        goto L13
    L12:
        r104 = (r107 + this.f525999j) + 1;
        goto L13
    L5:
        r103 = false;
        goto L7
    }

    public final String toString() {
        int r100 = this.f525992c;
        int r101 = this.f525994e;
        if ((r100 - r101) >= 0) goto L7;
        return "";
    L7:
        return new String(this.f525990a, r101, r100 - r101);
    }

    public final void w() {
        int r100 = this.f525996g;
        if (r100 == (-1)) goto L7;
        this.f525994e = r100;
        this.f525996g = -1;
        return;
    L7:
        throw new UncheckedIOException(new IOException("Mark invalid"));
    }

    public final void x() {
        ArrayList<Integer> r100 = this.f525998i;
        int r101 = 0;
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        return;
    L9:
        if (r100.size() <= 0) goto L15;
        int r103 = o(this.f525995f);
        if (r103 == (-1)) goto L14;
        r101 = r103;
    L14:
        int r104 = ((Integer) ListProtector.get(this.f525998i, r101)).intValue();
        this.f525999j += r101;
        this.f525998i.clear();
        this.f525998i.add(Integer.valueOf(r104));
    L15:
        int r105 = this.f525994e;
    L17:
        if (r105 >= this.f525992c) goto L22;
        if (this.f525990a[r105] != '\n') goto L21;
        this.f525998i.add(Integer.valueOf((this.f525995f + 1) + r105));
    L21:
        r105 = r105 + 1;
        goto L17
    L22:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void y() {
        int r100 = this.f525994e;
        if (r100 < 1) goto L7;
        this.f525994e = r100 - 1;
        return;
    L7:
        throw new UncheckedIOException(new IOException("WTF: No buffer left to unconsume."));
    }

    public final char e() {
        b();
        int r100 = this.f525994e;
        if (r100 < this.f525992c) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        char r102 = CharCompanionObject.MAX_VALUE;
    L9:
        this.f525994e = r100 + 1;
        return r102;
    L8:
        r102 = this.f525990a[r100];
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    public final String h() {
        b();
        int r100 = this.f525994e;
    L3:
        int r101 = this.f525994e;
        if (r101 >= this.f525992c) goto L17;
        char r102 = this.f525990a[r101];
        if (r102 < 'A') goto L10;
        if (r102 > 'Z') goto L10;
    L15:
        this.f525994e++;
    L10:
        if (r102 < 'a') goto L14;
        if (r102 <= 'z') goto L15;
    L14:
        if (Character.isLetter(r102) == true) goto L15;
    L17:
        return c(this.f525990a, this.f525997h, r100, this.f525994e - r100);
    }

    public final char l() {
        b();
        int r100 = this.f525994e;
        if (r100 < this.f525992c) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return CharCompanionObject.MAX_VALUE;
    L9:
        return this.f525990a[r100];
    L5:
        r101 = false;
        goto L6
    }

    public final boolean n() {
        b();
        if (this.f525994e < this.f525992c) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean t() {
        if (n() == false) goto L5;
        return false;
    L5:
        char r100 = this.f525990a[this.f525994e];
        if (r100 < 'A') goto L10;
        if (r100 > 'Z') goto L10;
    L13:
        return true;
    L10:
        if (r100 >= 'a') goto L12;
        return false;
    L12:
        if (r100 <= 'z') goto L13;
        return false;
    }

    public final boolean u() {
        if (n() == false) goto L5;
        return false;
    L5:
        char r100 = this.f525990a[this.f525994e];
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

    public final String f(boolean r100) {
        int r101 = this.f525994e;
        int r102 = this.f525992c;
        char[] r103 = this.f525990a;
        int r104 = r101;
    L3:
        if (r104 >= r102) goto L18;
        char r105 = r103[r104];
        if (r105 == 0) goto L18;
        if (r105 != '\"') goto L9;
    L15:
        if (r100 == false) goto L18;
    L17:
        r104 = r104 + 1;
        goto L3
    L9:
        if (r105 == '&') goto L18;
        if (r105 != '\'') goto L17;
        if (r100 == false) goto L15;
    L18:
        this.f525994e = r104;
        if (r104 > r101) goto L30;
        return "";
    L30:
        return c(this.f525990a, this.f525997h, r101, r104 - r101);
    }

    public final String i(char r100) {
        b();
        int r101 = this.f525994e;
    L4:
        if (r101 >= this.f525992c) goto L9;
        if (r100 == this.f525990a[r101]) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        int r102 = r101 - this.f525994e;
    L10:
        if (r102 == (-1)) goto L13;
        String r103 = c(this.f525990a, this.f525997h, this.f525994e, r102);
        this.f525994e += r102;
        return r103;
    L13:
        b();
        char[] r104 = this.f525990a;
        String[] r105 = this.f525997h;
        int r106 = this.f525994e;
        String r107 = c(r104, r105, r106, this.f525992c - r106);
        this.f525994e = this.f525992c;
        return r107;
    L9:
        r102 = -1;
        goto L10
    }

    public final String j(char... r100) {
        b();
        int r101 = this.f525994e;
        int r102 = this.f525992c;
        char[] r103 = this.f525990a;
        int r104 = r100.length;
        int r105 = r101;
    L3:
        if (r105 >= r102) goto L11;
        int r106 = 0;
    L5:
        if (r106 >= r104) goto L10;
        if (r103[r105] == r100[r106]) goto L11;
        r106 = r106 + 1;
        goto L5
    L10:
        r105 = r105 + 1;
    L11:
        this.f525994e = r105;
        if (r105 > r101) goto L19;
        return "";
    L19:
        return c(this.f525990a, this.f525997h, r101, r105 - r101);
    }

    public final String k(char... r100) {
        b();
        int r101 = this.f525994e;
        int r102 = this.f525992c;
        char[] r103 = this.f525990a;
        int r104 = r101;
    L3:
        if (r104 >= r102) goto L8;
        if (Arrays.binarySearch(r100, r103[r104]) >= 0) goto L8;
        r104 = r104 + 1;
    L8:
        this.f525994e = r104;
        if (r104 > r101) goto L15;
        return "";
    L15:
        return c(this.f525990a, this.f525997h, r101, r104 - r101);
    }

    public final int o(int r100) {
        ArrayList<Integer> r101 = this.f525998i;
        if (r101 == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return 0;
    L8:
        int r103 = Collections.binarySearch(r101, Integer.valueOf(r100));
        if (r103 < (-1)) goto L11;
        return r103;
    L11:
        return Math.abs(r103) - 2;
    L5:
        r102 = false;
        goto L6
    }

    public final boolean p(String r100) {
        b();
        b();
        int r101 = r100.length();
        if (r101 > (this.f525992c - this.f525994e)) goto L9;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (r100.charAt(r102) != this.f525990a[this.f525994e + r102]) goto L9;
        r102 = r102 + 1;
        goto L6
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        this.f525994e += r100.length();
        return true;
    L15:
        return false;
    L9:
        r103 = false;
        goto L12
    }

    public final boolean q(String r100) {
        b();
        int r101 = r100.length();
        if (r101 > (this.f525992c - this.f525994e)) goto L9;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        if (Character.toUpperCase(r100.charAt(r102)) != Character.toUpperCase(this.f525990a[this.f525994e + r102])) goto L9;
        r102 = r102 + 1;
        goto L6
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        this.f525994e += r100.length();
        return true;
    L15:
        return false;
    L9:
        r103 = false;
        goto L12
    }

    public final boolean r(char r100) {
        if (n() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f525990a[this.f525994e] != r100) goto L7;
        return true;
    }

    public final boolean s(char... r100) {
        if (n() == false) goto L5;
        return false;
    L5:
        b();
        char r101 = this.f525990a[this.f525994e];
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

    public final int v(CharSequence r100) {
        b();
        String r101 = (String) r100;
        char r102 = r101.charAt(0);
        int r103 = this.f525994e;
    L4:
        if (r103 >= this.f525992c) goto L24;
        int r104 = 1;
        if (r102 == this.f525990a[r103]) goto L12;
    L7:
        r103 = r103 + 1;
        if (r103 >= this.f525992c) goto L12;
        if (r102 != this.f525990a[r103]) goto L7;
    L12:
        int r105 = r103 + 1;
        int r106 = (r101.length() + r105) - 1;
        int r107 = this.f525992c;
        if (r103 >= r107) goto L23;
        if (r106 > r107) goto L23;
        int r108 = r105;
    L16:
        if (r108 >= r106) goto L20;
        if (r101.charAt(r104) != this.f525990a[r108]) goto L20;
        r108 = r108 + 1;
        r104 = r104 + 1;
    L20:
        if (r108 != r106) goto L23;
        return r103 - this.f525994e;
    L23:
        r103 = r105;
        goto L4
    L24:
        return -1;
    }

    public a(Reader r100, int r101) {
        this.f525996g = -1;
        this.f525997h = new String[512];
        this.f525998i = null;
        this.f525999j = 1;
        ewc.b.a(r100.markSupported());
        this.f525991b = r100;
        this.f525990a = new char[Math.min(r101, 32768)];
        b();
    }

    public static String c(char[] r100, String[] r110, int r111, int r112) {
        if (r112 > 12) goto L5;
        boolean r101 = true;
        if (r112 >= 1) goto L10;
        return "";
    L10:
        int r102 = 0;
        int r103 = 0;
    L11:
        if (r102 >= r112) goto L13;
        r103 = (r103 * 31) + r100[r111 + r102];
        r102 = r102 + 1;
        goto L11
    L13:
        int r104 = r103 & 511;
        String r105 = r110[r104];
        if (r105 != null) goto L16;
    L27:
        String r106 = new String(r100, r111, r112);
        r110[r104] = r106;
        return r106;
    L16:
        if (r112 != r105.length()) goto L24;
        int r107 = r111;
        int r108 = r112;
        int r109 = 0;
    L18:
        int r113 = r108 - 1;
        if (r108 == 0) goto L25;
        int r114 = r107 + 1;
        int r115 = r109 + 1;
        if (r100[r107] != r105.charAt(r109)) goto L24;
        r107 = r114;
        r108 = r113;
        r109 = r115;
    L25:
        if (r101 == false) goto L27;
        return r105;
    L24:
        r101 = false;
        goto L25
    L5:
        return new String(r100, r111, r112);
    }
}
