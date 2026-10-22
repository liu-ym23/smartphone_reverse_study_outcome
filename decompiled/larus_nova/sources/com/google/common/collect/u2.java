package com.google.common.collect;

import java.util.Comparator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class u2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f275514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Comparator<? super T> f275515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T[] f275516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f275517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @CheckForNull
    public T f275518e;

    public u2(Comparator<? super T> r100, int r110) {
        com.google.common.base.m.l(r100, "comparator");
        this.f275515b = r100;
        this.f275514a = r110;
        boolean r101 = true;
        if (r110 < 0) goto L5;
        boolean r102 = true;
    L6:
        com.google.common.base.m.d(r102, "k (%s) must be >= 0", r110);
        if (r110 > 1073741823) goto L9;
        boolean r103 = true;
    L10:
        com.google.common.base.m.d(r103, "k (%s) must be <= Integer.MAX_VALUE / 2", r110);
        long r104 = ((long) r110) * ((long) 2);
        int r105 = (int) r104;
        if (r104 == r105) goto L14;
        r101 = false;
    L14:
        com.google.common.math.e.a(r101, "checkedMultiply", r110, 2);
        this.f275516c = (T[]) new Object[r105];
        this.f275517d = 0;
        this.f275518e = null;
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }
}
