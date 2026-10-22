package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnieXCommonUIViewModel f268206a;

    public final void a() {
        AnnieXCommonUIViewModel r100 = this.f268206a;
        if (r100 == null) goto L5;
        r100.c(AnnieXLoadStatus.LOAD_FAILED);
    L5:
        AnnieXCommonUIViewModel r101 = this.f268206a;
        if (r101 == null) goto L8;
        r101.b(false);
    L8:
        AnnieXCommonUIViewModel r102 = this.f268206a;
        if (r102 == null) goto L14;
        AnnieXLoadingViewModel r103 = r102.f267817k;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("_loadingViewModel");
        r103 = null;
    L13:
        r103.a(null, false, false);
    L14:
        AnnieXCommonUIViewModel r104 = this.f268206a;
        if (r104 == null) goto L17;
        r104.s(true);
    L17:
        AnnieXCommonUIViewModel r105 = this.f268206a;
        if (r105 == null) goto L21;
        r105.k();
        return;
    }

    public final void b() {
        AnnieXCommonUIViewModel r100 = this.f268206a;
        if (r100 == null) goto L5;
        r100.c(AnnieXLoadStatus.LOAD_START);
    L5:
        AnnieXCommonUIViewModel r101 = this.f268206a;
        if (r101 == null) goto L8;
        r101.s(false);
    L8:
        AnnieXCommonUIViewModel r102 = this.f268206a;
        if (r102 == null) goto L14;
        AnnieXLoadingViewModel r103 = r102.f267817k;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("_loadingViewModel");
        r103 = null;
    L13:
        r103.a(null, true, false);
    L14:
        AnnieXCommonUIViewModel r104 = this.f268206a;
        if (r104 == null) goto L18;
        r104.k();
        return;
    }

    public final void c() {
        AnnieXCommonUIViewModel r100 = this.f268206a;
        if (r100 == null) goto L5;
        r100.c(AnnieXLoadStatus.LOAD_SUCCESS);
    L5:
        AnnieXCommonUIViewModel r101 = this.f268206a;
        if (r101 == null) goto L8;
        r101.b(true);
    L8:
        AnnieXCommonUIViewModel r102 = this.f268206a;
        if (r102 == null) goto L14;
        AnnieXLoadingViewModel r103 = r102.f267817k;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("_loadingViewModel");
        r103 = null;
    L13:
        r103.a(null, false, false);
    L14:
        AnnieXCommonUIViewModel r104 = this.f268206a;
        if (r104 == null) goto L18;
        r104.k();
        return;
    }

    public l(AnnieXCommonUIViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "commonUIViewModel");
        this.f268206a = r100;
    }
}
