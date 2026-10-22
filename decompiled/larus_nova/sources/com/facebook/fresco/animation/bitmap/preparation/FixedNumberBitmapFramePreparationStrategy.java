package com.facebook.fresco.animation.bitmap.preparation;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;

/* JADX INFO: loaded from: classes23.dex */
public class FixedNumberBitmapFramePreparationStrategy implements BitmapFramePreparationStrategy {
    private static final int DEFAULT_FRAMES_TO_PREPARE = 3;
    private static final Class<?> TAG = null;
    private final int mFramesToPrepare;

    public FixedNumberBitmapFramePreparationStrategy() {
        this(3);
    }

    static {
        TAG = FixedNumberBitmapFramePreparationStrategy.class;
    }

    public FixedNumberBitmapFramePreparationStrategy(int r100) {
        this.mFramesToPrepare = r100;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy
    public void prepareFrames(BitmapFramePreparer r100, BitmapFrameCache r101, AnimationBackend r102, int r110) {
        int r103 = 1;
    L4:
        if (r103 > this.mFramesToPrepare) goto L12;
        int r104 = (r110 + r103) % r102.getFrameCount();
        if (FLog.isLoggable(2) == false) goto L9;
        FLog.v(TAG, "Preparing frame %d, last drawn: %d", Integer.valueOf(r104), Integer.valueOf(r110));
    L9:
        if (r100.prepareFrame(r101, r102, r104) == false) goto L10;
        r103 = r103 + 1;
        goto L4
    L10:
        return;
    }
}
