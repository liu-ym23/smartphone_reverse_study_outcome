package com.facebook.keyframes.model;

import com.facebook.keyframes.util.ArgCheckUtil;

/* JADX INFO: loaded from: classes23.dex */
public class KFAnimationFrame implements HasKeyFrame {
    public static final String DATA_JSON_FIELD = "data";
    public static final String START_FRAME_JSON_FIELD = "start_frame";
    private final float[] mData;
    private final int mStartFrame;

    /* JADX INFO: renamed from: com.facebook.keyframes.model.KFAnimationFrame$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        public float[] data;
        public int startFrame;

        public Builder() {
        }

        public KFAnimationFrame build() {
            return new KFAnimationFrame(this.startFrame, this.data, null);
        }
    }

    public float[] getData() {
        return this.mData;
    }

    @Override // com.facebook.keyframes.model.HasKeyFrame
    public int getKeyFrame() {
        return this.mStartFrame;
    }

    private KFAnimationFrame(int r100, float[] r101) {
        this.mStartFrame = r100;
        if (r101.length <= 0) goto L5;
        boolean r102 = true;
    L6:
        this.mData = (float[]) ArgCheckUtil.checkArg(r101, r102, "data");
        return;
    L5:
        r102 = false;
        goto L6
    }

    public /* synthetic */ KFAnimationFrame(int r100, float[] r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
