package com.bytedance.locallife.biz.base.cube;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class r implements fp6.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f256550a = null;

    static {
        f256550a = new r();
    }

    public r() {
    }

    @Override // fp6.j
    public final void a(Object r100) {
        Intrinsics.checkNotNullParameter("Cube", "tag");
        qs6.b r101 = HostServiceUtilsKt.k();
        if (r100 == null) goto L5;
        String r102 = r100.toString();
    L6:
        r101.i("Cube", r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // fp6.j
    public final void b(Object r100) {
        Intrinsics.checkNotNullParameter("Cube", "tag");
        qs6.b r101 = HostServiceUtilsKt.k();
        if (r100 == null) goto L5;
        String r102 = r100.toString();
    L6:
        r101.e("Cube", r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // fp6.j
    public final void c(Object r100) {
        Intrinsics.checkNotNullParameter("Cube", "tag");
        qs6.b r101 = HostServiceUtilsKt.k();
        if (r100 == null) goto L5;
        String r102 = r100.toString();
    L6:
        r101.d("Cube", r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // fp6.j
    public final void d(Object r100) {
        Intrinsics.checkNotNullParameter("Cube", "tag");
        qs6.b r101 = HostServiceUtilsKt.k();
        if (r100 == null) goto L5;
        String r102 = r100.toString();
    L6:
        r101.w("Cube", r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // fp6.j
    public final void e(Object r100, Throwable r101) {
        Intrinsics.checkNotNullParameter("Cube", "tag");
        String r102 = null;
        if (r101 == null) goto L8;
        qs6.b r103 = HostServiceUtilsKt.k();
        if (r100 == null) goto L7;
        r102 = r100.toString();
    L7:
        r103.e("Cube", r102, r101);
        return;
    L8:
        qs6.b r104 = HostServiceUtilsKt.k();
        if (r100 == null) goto L11;
        r102 = r100.toString();
    L11:
        r104.e("Cube", r102);
    }
}
