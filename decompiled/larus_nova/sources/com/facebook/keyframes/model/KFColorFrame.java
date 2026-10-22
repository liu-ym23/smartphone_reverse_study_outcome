package com.facebook.keyframes.model;

/* JADX INFO: loaded from: classes23.dex */
public class KFColorFrame implements HasKeyFrame {
    public static final String COLOR_JSON_FIELD = "data";
    public static final String START_FRAME_JSON_FIELD = "start_frame";
    private final int mColor;
    private final int mStartFrame;

    /* JADX INFO: renamed from: com.facebook.keyframes.model.KFColorFrame$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        public int color;
        public int startFrame;

        public Builder() {
        }

        public KFColorFrame build() {
            return new KFColorFrame(this.startFrame, this.color, null);
        }
    }

    public int getColor() {
        return this.mColor;
    }

    @Override // com.facebook.keyframes.model.HasKeyFrame
    public int getKeyFrame() {
        return this.mStartFrame;
    }

    private KFColorFrame(int r100, int r101) {
        this.mStartFrame = r100;
        this.mColor = r101;
    }

    public /* synthetic */ KFColorFrame(int r100, int r101, AnonymousClass1 r102) {
        this(r100, r101);
    }
}
