package com.larus.image.loader;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.larus.utils.z0;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 extends BaseBitmapDataSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Bitmap> f350964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f350965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap.Config f350966c;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
        if (this.f350964a.isActive() == false) goto L6;
        this.f350964a.resumeWith(Result.m9449constructorimpl(null));
        return;
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void onNewResultImpl(Bitmap r100) {
        Object r101 = null;
        if (r100 == null) goto L23;
        boolean r102 = this.f350965b;
        Bitmap.Config r103 = this.f350966c;
        if (r102 == true) goto L7;
    L21:
        r101 = r100;
        goto L23
    L7:
        if (r100.isRecycled() == false) goto L26;
        r100 = null;
        goto L21
    L26:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        if (r103 != null) goto L11;
        r103 = z0.b(r100.getConfig());     // Catch: Throwable -> L13
    L11:
        Object r105 = Result.m9449constructorimpl(r100.copy(r103, true));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r105) == true) goto L19;
        r101 = r105;
    L19:
        r100 = (Bitmap) r101;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L23:
        if (this.f350964a.isActive() == false) goto L28;
        this.f350964a.resumeWith(Result.m9449constructorimpl(r101));
        return;
    }

    public a0(kotlinx.coroutines.j r100, boolean r101, Bitmap.Config r102) {
        this.f350964a = r100;
        this.f350965b = r101;
        this.f350966c = r102;
    }
}
