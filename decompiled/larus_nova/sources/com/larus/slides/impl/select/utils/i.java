package com.larus.slides.impl.select.utils;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class i extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f369688a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function1<? super Boolean, Unit> r100) {
        this.f369688a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
        Function1<Boolean, Unit> r102 = this.f369688a;
        if (r102 == null) goto L6;
        r102.invoke(Boolean.FALSE);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, (ImageInfo) r101, r102);
        Function1<Boolean, Unit> r103 = this.f369688a;
        if (r103 == null) goto L6;
        r103.invoke(Boolean.TRUE);
        return;
    }
}
