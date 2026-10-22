package com.ss.lark.android.avatar.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c extends dlb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<String> f456658a;

    @Override // dlb.b
    public final void d() {
        this.f456658a.onError(new ErrorResult(-1));
    }

    public c(IGetDataCallback<String> r100) {
        this.f456658a = r100;
    }

    @Override // dlb.b
    public final void i(int r100, String r101) {
        this.f456658a.onError(new ErrorResult(r100, r101));
    }

    @Override // dlb.b
    public final void k(com.ss.android.lark.image.uploader.entity.b r100, com.ss.android.lark.image.uploader.entity.c r101) {
        Intrinsics.checkNotNullParameter(r100, "image");
        if (r101 == null) goto L6;
        String r102 = r101.f426410a;
        this.f456658a.onSuccess(r102);
        return;
    }

    @Override // dlb.b
    public final void j(int r100, com.ss.android.lark.image.uploader.entity.b r101, long r102, int r103, int r104) {
        this.f456658a.onError(new ErrorResult(r100));
    }
}
