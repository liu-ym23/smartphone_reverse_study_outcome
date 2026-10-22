package com.facebook.fresco.animation.frame;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.imageformat.ImageFormat;

/* JADX INFO: loaded from: classes23.dex */
public interface FrameSchedulerFactory {
    FrameScheduler build(AnimationBackend r100, Object r101, ImageFormat r102, int r103);
}
