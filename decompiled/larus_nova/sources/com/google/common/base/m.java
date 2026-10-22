package com.google.common.base;

import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class m {
    public static void b(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void o(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static void c(boolean r100, @CheckForNull Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static void j(int r100, int r101) {
        if (r100 < 0) goto L7;
        if (r100 >= r101) goto L7;
        return;
    L7:
        if (r100 < 0) goto L12;
        if (r101 < 0) goto L11;
        String r102 = s.a("%s (%s) must be less than size (%s)", new Object[]{"index", Integer.valueOf(r100), Integer.valueOf(r101)});
    L14:
        throw new IndexOutOfBoundsException(r102);
    L11:
        throw new IllegalArgumentException("negative size: " + r101);
    L12:
        r102 = s.a("%s (%s) must not be negative", new Object[]{"index", Integer.valueOf(r100)});
        goto L14
    }

    public static void l(@CheckForNull Object r100, @CheckForNull Object r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }

    public static void m(int r100, int r101) {
        if (r100 < 0) goto L6;
        if (r100 > r101) goto L6;
        return;
    L6:
        throw new IndexOutOfBoundsException(a(r100, r101, "index"));
    }

    public static void p(boolean r100, @CheckForNull Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r101));
    }

    public static String a(int r100, int r101, String r102) {
        if (r100 < 0) goto L5;
        if (r101 < 0) goto L10;
        return s.a("%s (%s) must not be greater than size (%s)", new Object[]{r102, Integer.valueOf(r100), Integer.valueOf(r101)});
    L10:
        throw new IllegalArgumentException("negative size: " + r101);
    L5:
        return s.a("%s (%s) must not be negative", new Object[]{r102, Integer.valueOf(r100)});
    }

    public static void d(boolean r100, String r101, int r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(s.a(r101, new Object[]{Integer.valueOf(r102)}));
    }

    public static void f(boolean r100, String r101, long r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(s.a(r101, new Object[]{Long.valueOf(r102)}));
    }

    public static void h(boolean r100, String r101, @CheckForNull Object r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(s.a(r101, new Object[]{r102}));
    }

    public static void k(@CheckForNull ListenableFuture r100, String r101, @CheckForNull Object r102) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(s.a(r101, new Object[]{r102}));
    }

    public static void n(int r100, int r101, int r102) {
        if (r100 < 0) goto L8;
        if (r101 < r100) goto L8;
        if (r101 > r102) goto L8;
        return;
    L8:
        if (r100 < 0) goto L15;
        if (r100 > r102) goto L15;
        if (r101 < 0) goto L14;
        if (r101 > r102) goto L14;
        String r103 = s.a("end index (%s) must not be less than start index (%s)", new Object[]{Integer.valueOf(r101), Integer.valueOf(r100)});
    L17:
        throw new IndexOutOfBoundsException(r103);
    L14:
        r103 = a(r101, r102, "end index");
    L15:
        r103 = a(r100, r102, "start index");
        goto L17
    }

    public static void q(boolean r100, String r101, int r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(s.a(r101, new Object[]{Integer.valueOf(r102)}));
    }

    public static void r(boolean r100, String r101, long r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(s.a(r101, new Object[]{Long.valueOf(r102)}));
    }

    public static void s(boolean r100, String r101, @CheckForNull Object r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(s.a(r101, new Object[]{r102}));
    }

    public static void e(boolean r100, String r101, int r102, int r103) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(s.a(r101, new Object[]{Integer.valueOf(r102), Integer.valueOf(r103)}));
    }

    public static void g(boolean r100, String r101, long r102, @CheckForNull Object r103) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(s.a(r101, new Object[]{Long.valueOf(r102), r103}));
    }

    public static void i(boolean r100, String r101, @CheckForNull Object r102, @CheckForNull Object r103) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(s.a(r101, new Object[]{r102, r103}));
    }

    public static void t(boolean r100, String r101, @CheckForNull Object r102, @CheckForNull Object r103) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(s.a(r101, new Object[]{r102, r103}));
    }
}
