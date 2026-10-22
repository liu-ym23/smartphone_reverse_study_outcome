package com.ss.android.lark.image.uploader.upload;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.image.uploader.entity.ImageUploadTask;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends com.ss.android.lark.utils.rxjava.d<com.ss.android.lark.image.uploader.entity.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageUploadTask f426418a;

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        int r100 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "Upload end");
        dlb.a r101 = this.f426418a.f426380f;
        if (r101 == null) goto L6;
        r101.h();
        return;
    }

    public g(ImageUploadTask r100) {
        this.f426418a = r100;
    }

    @Override // com.ss.android.lark.utils.rxjava.d
    public final void a(Throwable r100) {
        if ((r100 instanceof ErrorResult) == false) goto L7;
        dlb.a r101 = this.f426418a.f426380f;
        if (r101 == null) goto L11;
        ErrorResult r102 = (ErrorResult) r100;
        r101.i(r102.getCode(), r102.getDisplayMsg());
        return;
    L11:
        return;
    L7:
        int r103 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.b("ImageUploadManager", "pass upload error event, th:" + r100, null, false);
        dlb.a r104 = this.f426418a.f426380f;
        if (r104 == null) goto L13;
        r104.i(-10006, "");
        return;
    }

    @Override // io.reactivex.Observer
    public final void onNext(Object r100) {
        com.ss.android.lark.image.uploader.entity.b r101 = (com.ss.android.lark.image.uploader.entity.b) r100;
        Intrinsics.checkNotNullParameter(r101, "uploadImage");
        int r102 = com.ss.android.lark.image.uploader.utils.c.f426438a;
        com.ss.android.lark.image.uploader.utils.c.c("ImageUploadManager", "pass upload success event, image:" + r101);
        dlb.a r103 = this.f426418a.f426380f;
        if (r103 == null) goto L6;
        r103.k(r101, r101.f426398l);
        return;
    }
}
