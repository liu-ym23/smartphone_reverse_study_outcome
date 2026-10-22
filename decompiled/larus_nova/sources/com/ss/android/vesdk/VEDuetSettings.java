package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public final class VEDuetSettings {
    private boolean enableV2;
    private float mAlpha;
    private String mDuetAudioPath;
    private VEDuetLayout mDuetLayout;
    private String mDuetVideoPath;
    private int mImageDuration;
    private boolean mIsFitMode;
    private boolean mIsLoop;
    private kPlayMode mPlayMode;
    private float mXInPercent;
    private float mYInPercent;

    public static final enum kPlayMode extends Enum<kPlayMode> {
        public static final kPlayMode ATTACH = null;
        public static final kPlayMode DETACH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ kPlayMode[] f455538a = null;

        static {
            kPlayMode r100 = new kPlayMode("ATTACH", 0);
            ATTACH = r100;
            kPlayMode r101 = new kPlayMode("DETACH", 1);
            DETACH = r101;
            f455538a = new kPlayMode[]{r100, r101};
        }

        public static kPlayMode[] values() {
            return (kPlayMode[]) f455538a.clone();
        }

        public static kPlayMode valueOf(String r100) {
            return (kPlayMode) r27.a.a(kPlayMode.class, r100);
        }

        public kPlayMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String toString() {
        return "{\"mDuetVideoPath\":\"" + this.mDuetVideoPath + "\",\"mDuetAudioPath\":\"" + this.mDuetAudioPath + "\",\"mXInPercent\":" + this.mXInPercent + ",\"mYInPercent\":" + this.mYInPercent + ",\"mAlpha\":" + this.mAlpha + ",\"mIsFitMode\":" + this.mIsFitMode + ",\"enableV2\":" + this.enableV2 + ",\"DuetLayout\":" + this.mDuetLayout.ordinal() + '}';
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public String getDuetAudioPath() {
        return this.mDuetAudioPath;
    }

    public VEDuetLayout getDuetLayout() {
        return this.mDuetLayout;
    }

    public String getDuetVideoPath() {
        return this.mDuetVideoPath;
    }

    public boolean getEnableV2() {
        return this.enableV2;
    }

    public int getImageDuration() {
        return this.mImageDuration;
    }

    public boolean getIsFitMode() {
        return this.mIsFitMode;
    }

    public boolean getIsLoop() {
        return this.mIsLoop;
    }

    public kPlayMode getPlayMode() {
        return this.mPlayMode;
    }

    public float getXInPercent() {
        return this.mXInPercent;
    }

    public float getYInPercent() {
        return this.mYInPercent;
    }

    public void setDuetLayout(VEDuetLayout r100) {
        this.mDuetLayout = r100;
    }

    public void setEnableV2(boolean r100) {
        this.enableV2 = r100;
    }

    public void setImageDuration(int r100) {
        this.mImageDuration = r100;
    }

    public void setLoop(boolean r100) {
        this.mIsLoop = r100;
    }

    public void setPlayMode(kPlayMode r100) {
        this.mPlayMode = r100;
    }

    public VEDuetSettings(String r100, String r101, float r102, float r103, float r104, boolean r105) {
        this.enableV2 = false;
        this.mPlayMode = kPlayMode.ATTACH;
        this.mDuetLayout = VEDuetLayout.VEDuetLayoutHorizontal;
        this.mIsLoop = false;
        this.mImageDuration = -1;
        this.mDuetVideoPath = r100;
        this.mDuetAudioPath = r101;
        this.mXInPercent = r102;
        this.mYInPercent = r103;
        this.mAlpha = r104;
        this.mIsFitMode = r105;
    }
}
