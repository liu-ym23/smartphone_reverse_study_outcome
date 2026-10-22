package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g1 extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ Function0 a;

    public g1(Function0 r1) {
        this.a = r1;
    }

    public final void onFinalImageSet(String r2, Object r3, Animatable r4) {
        ImageInfo r5 = (ImageInfo) r3;
        if ((r4 instanceof AnimatedDrawable2) == true) goto L5;
        Animatable r6 = null;
    L6:
        AnimatedDrawable2 r7 = (AnimatedDrawable2) r6;
        if (r7 == null) goto L10;
        r7.setAnimationBackend(new f1(r7.getAnimationBackend()));
        r7.setPrivateFrameScheduler(new DropFramesFrameScheduler(((AnimatedDrawable2) r4).getAnimationBackend()));
        r7.setAnimationListener(new e1(this, r4));
        r7.start();
        return;
    L10:
        return;
    L5:
        r6 = r4;
        goto L6
    }
}
