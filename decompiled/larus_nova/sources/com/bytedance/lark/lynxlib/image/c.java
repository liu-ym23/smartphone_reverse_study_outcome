package com.bytedance.lark.lynxlib.image;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f253266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxBackgroundLayerDrawable f253267b;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        Log.e("CardBackgroundLayerDrawable", "load failed:error" + this.f253266a);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        Log.i("CardBackgroundLayerDrawable", "load success:resource-ready" + this.f253266a);
        LynxBackgroundLayerDrawable r102 = this.f253267b;
        r102.f253262b = r101;
        r101.setBounds(r102.getBounds());
        r102.f253262b.setCallback(r102);
        r102.invalidateSelf();
        Log.i("CardBackgroundLayerDrawable", "drawable ready:size:w=" + r101.getIntrinsicWidth() + ",h=" + r101.getIntrinsicHeight());
    }

    public c(LynxBackgroundLayerDrawable r100, String r101) {
        this.f253267b = r100;
        this.f253266a = r101;
    }
}
