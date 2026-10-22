package com.ss.android.lark.keyboard.edittext2.edittors.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends SimpleTarget<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UrlImageSpanView f429068a;

    public c(UrlImageSpanView r100) {
        this.f429068a = r100;
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        Resources r102 = this.f429068a.getResources();
        b r103 = new b(r101, this.f429068a, r102);
        r103.setBounds(0, 0, r103.getIntrinsicWidth(), r103.getIntrinsicHeight());
        UrlImageSpanView.a(this.f429068a).setImageDrawable(r103);
        Log.d("UrlImageSpanView", "onResourceReady: imageView.setImageDrawable called");
    }
}
