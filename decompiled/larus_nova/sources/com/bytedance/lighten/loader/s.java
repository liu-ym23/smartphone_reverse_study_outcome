package com.bytedance.lighten.loader;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.fresco.animation.frame.FrameSchedulerFactory;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import java.util.HashMap;

/* JADX INFO: loaded from: classes20.dex */
public final class s implements FrameSchedulerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ df6.r f254781a;

    public s(df6.r r100) {
        this.f254781a = r100;
    }

    @Override // com.facebook.fresco.animation.frame.FrameSchedulerFactory
    public final FrameScheduler build(AnimationBackend r100, Object r101, ImageFormat r102, int r103) {
        if ((r101 instanceof HashMap) == false) goto L7;
        this.f254781a.getClass();
    L7:
        if (r102 != DefaultImageFormats.WEBP_ANIMATED) goto L11;
        this.f254781a.getClass();
        return null;
    L11:
        return null;
    }
}
