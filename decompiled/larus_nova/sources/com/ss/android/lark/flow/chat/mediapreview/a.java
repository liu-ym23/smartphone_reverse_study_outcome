package com.ss.android.lark.flow.chat.mediapreview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;
import kotlin.Result;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends SimpleTarget<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f422224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i<Bitmap> f422225b;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        if (this.f422225b.isActive() == false) goto L6;
        this.f422225b.resumeWith(Result.m9449constructorimpl(null));
        return;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        Log.i("FlowPreviewImageView", "get preview resource success, costTime: " + (System.currentTimeMillis() - this.f422224a));
        if (this.f422225b.isActive() == false) goto L6;
        this.f422225b.resumeWith(Result.m9449constructorimpl(r101));
        return;
    }

    public a(long r100, j r101) {
        this.f422224a = r100;
        this.f422225b = r101;
    }
}
