package com.ss.android.ainote;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
public final class a0 extends dlb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AINoteImageUploadCoordinator.a f406679a;

    @Override // dlb.b
    public final void d() {
        this.f406679a.a(false, "upload params invalid");
    }

    public a0(AINoteImageUploadCoordinator$startPendingUploads$1 r100) {
        this.f406679a = r100;
    }

    @Override // dlb.b
    public final void i(int r100, String r101) {
        AINoteImageUploadCoordinator.a r102 = this.f406679a;
        if (r101 != null) goto L5;
        r101 = "upload failed:" + r100;
    L5:
        r102.a(true, r101);
    }

    @Override // dlb.b
    public final void k(com.ss.android.lark.image.uploader.entity.b r100, com.ss.android.lark.image.uploader.entity.c r101) {
        Intrinsics.checkNotNullParameter(r100, "image");
        if (r101 == null) goto L5;
        String r102 = r101.f426410a;
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        if (StringsKt.isBlank(r102) == false) goto L12;
        this.f406679a.a(true, "empty upload token");
        return;
    L12:
        this.f406679a.onSuccess(r102, r102);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
