package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m extends BaseControllerListener<ImageInfo> {
    public m() {
    }

    public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
        super.onFinalImageSet(r1, (ImageInfo) r2, r3);
        if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
        Animatable r4 = null;
    L6:
        AnimatedDrawable2 r5 = (AnimatedDrawable2) r4;
        if (r5 == null) goto L10;
        r5.setPrivateFrameScheduler(new DropFramesFrameScheduler(((AnimatedDrawable2) r3).getAnimationBackend()));
        return;
    L10:
        return;
    L5:
        r4 = r3;
        goto L6
    }
}
