package com.larus.voicecall.impl.utils;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f379544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f379545b;

    public i(boolean r100, View r101) {
        this.f379544a = r100;
        this.f379545b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        Intrinsics.checkNotNullParameter(r100, "id");
        if (this.f379544a == true) goto L5;
        e1.o(this.f379545b);
    L5:
        if (r102 == null) goto L8;
        r102.start();
        return;
    }
}
