package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.Objects;

/* JADX INFO: loaded from: classes40.dex */
public class VEDisplaySettings implements Parcelable {
    public static final Parcelable.Creator<VEDisplaySettings> CREATOR = null;
    private long mBgColor;
    private VESize mCamOutSize;
    private VESize mCanvasSize;
    private float mDisplayRatio;
    private VEPreviewRadio mDisplayRatioMode;
    private int mDisplayRotation;
    private VEDisPlayEffect mEffect;
    private float mEffectIntensity;
    private int mEffectRotation;
    private VEDisplayFitMode mFitMode;
    private boolean mFlipX;
    private boolean mFlipY;
    private boolean mForceAdaptSurfaceSize;
    private VESize mLayoutSize;
    private VESize mRenderSize;
    private int mRotation;
    private int mTranslateX;
    private int mTranslateY;

    public static final class Builder {
        private final VEDisplaySettings mVEPreviewRaidoSettings;

        public Builder() {
            this.mVEPreviewRaidoSettings = new VEDisplaySettings(null);
        }

        public VEDisplaySettings build() {
            return this.mVEPreviewRaidoSettings;
        }

        public Builder(VEDisplaySettings r100) {
            this.mVEPreviewRaidoSettings = r100;
        }

        public Builder setBackgroundColor(long r100) {
            VEDisplaySettings.access$702(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setCamOutSize(VESize r100) {
            VEDisplaySettings.access$1402(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setCanvasSize(VESize r100) {
            VEDisplaySettings.access$1802(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setDisplayEffect(VEDisPlayEffect r100) {
            VEDisplaySettings.access$1102(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setDisplayEffectIntensity(float r100) {
            VEDisplaySettings.access$1202(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setDisplayLayoutSize(VESize r100) {
            VEDisplaySettings.access$1302(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setDisplayRatio(float r100) {
            VEDisplaySettings.access$802(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setDisplayRatioMode(VEPreviewRadio r100) {
            VEDisplaySettings.access$902(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setDisplayRotation(int r100) {
            VEDisplaySettings.access$1602(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setEffectRotation(int r100) {
            VEDisplaySettings.access$1502(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setFitMode(VEDisplayFitMode r100) {
            VEDisplaySettings.access$102(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setFlipX(boolean r100) {
            VEDisplaySettings.access$402(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setFlipY(boolean r100) {
            VEDisplaySettings.access$502(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setForceAdaptSurfaceSize(boolean r100) {
            VEDisplaySettings.access$1702(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setRenderSize(VESize r100) {
            VEDisplaySettings.access$1002(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setRotation(int r100) {
            VEDisplaySettings.access$602(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setTranslateX(int r100) {
            VEDisplaySettings.access$202(this.mVEPreviewRaidoSettings, r100);
            return this;
        }

        public Builder setTranslateY(int r100) {
            VEDisplaySettings.access$302(this.mVEPreviewRaidoSettings, r100);
            return this;
        }
    }

    public static final enum VEDisPlayEffect extends Enum<VEDisPlayEffect> {
        private static final /* synthetic */ VEDisPlayEffect[] $VALUES = null;
        public static final VEDisPlayEffect GAUSSIAN_BLUR = null;
        public static final VEDisPlayEffect NONE = null;

        private static /* synthetic */ VEDisPlayEffect[] $values() {
            return new VEDisPlayEffect[]{NONE, GAUSSIAN_BLUR};
        }

        static {
            NONE = new VEDisPlayEffect(UserProfileEvent.POSITION_NONE, 0);
            GAUSSIAN_BLUR = new VEDisPlayEffect("GAUSSIAN_BLUR", 1);
            $VALUES = $values();
        }

        public static VEDisPlayEffect[] values() {
            return (VEDisPlayEffect[]) $VALUES.clone();
        }

        public static VEDisPlayEffect valueOf(String r100) {
            return (VEDisPlayEffect) r27.a.a(VEDisPlayEffect.class, r100);
        }

        private VEDisPlayEffect(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum VEDisplayFitMode extends Enum<VEDisplayFitMode> {
        public static final VEDisplayFitMode SCALE_MODE_CENTER_CROP = null;
        public static final VEDisplayFitMode SCALE_MODE_CENTER_INSIDE = null;
        public static final VEDisplayFitMode SCALE_MODE_FIT_FULL = null;
        public static final VEDisplayFitMode SCALE_MODE_USER_DEF = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VEDisplayFitMode[] f455536a = null;

        static {
            VEDisplayFitMode r100 = new VEDisplayFitMode("SCALE_MODE_CENTER_CROP", 0);
            SCALE_MODE_CENTER_CROP = r100;
            VEDisplayFitMode r101 = new VEDisplayFitMode("SCALE_MODE_CENTER_INSIDE", 1);
            SCALE_MODE_CENTER_INSIDE = r101;
            VEDisplayFitMode r102 = new VEDisplayFitMode("SCALE_MODE_FIT_FULL", 2);
            SCALE_MODE_FIT_FULL = r102;
            VEDisplayFitMode r103 = new VEDisplayFitMode("SCALE_MODE_USER_DEF", 3);
            SCALE_MODE_USER_DEF = r103;
            f455536a = new VEDisplayFitMode[]{r100, r101, r102, r103};
        }

        public static VEDisplayFitMode[] values() {
            return (VEDisplayFitMode[]) f455536a.clone();
        }

        public static VEDisplayFitMode valueOf(String r100) {
            return (VEDisplayFitMode) r27.a.a(VEDisplayFitMode.class, r100);
        }

        public VEDisplayFitMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<VEDisplaySettings> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEDisplaySettings createFromParcel(Parcel r100) {
            return new VEDisplaySettings(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEDisplaySettings[] newArray(int r100) {
            return new VEDisplaySettings[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mTranslateX), Integer.valueOf(this.mTranslateY), Boolean.valueOf(this.mFlipX), Boolean.valueOf(this.mFlipY), this.mFitMode, Integer.valueOf(this.mRotation), Integer.valueOf(this.mEffectRotation), Integer.valueOf(this.mDisplayRotation), Long.valueOf(this.mBgColor), Float.valueOf(this.mDisplayRatio), this.mDisplayRatioMode, this.mRenderSize, this.mLayoutSize, this.mCamOutSize, Boolean.valueOf(this.mForceAdaptSurfaceSize), this.mEffect, Float.valueOf(this.mEffectIntensity)});
    }

    public String toString() {
        return "VEDisplaySettings{mTranslateX=" + this.mTranslateX + ", mTranslateY=" + this.mTranslateY + ", mFlipX=" + this.mFlipX + ", mFlipY=" + this.mFlipY + ", mFitMode=" + this.mFitMode + ", mRotation=" + this.mRotation + ", mBgColor=" + this.mBgColor + ", mDisplayRatio=" + this.mDisplayRatio + ", mDisplayRatioMode=" + this.mDisplayRatioMode + ", mRenderSize=" + this.mRenderSize + ", mLayoutSize=" + this.mLayoutSize + ", mEffect=" + this.mEffect + ", mEffectIntensity=" + this.mEffectIntensity + '}';
    }

    private VEDisplaySettings() {
        this.mTranslateX = 0;
        this.mTranslateY = 0;
        this.mFlipX = false;
        this.mFlipY = false;
        this.mFitMode = VEDisplayFitMode.SCALE_MODE_CENTER_INSIDE;
        this.mRotation = 0;
        this.mEffectRotation = 0;
        this.mDisplayRotation = 0;
        this.mDisplayRatioMode = null;
        this.mRenderSize = null;
        this.mLayoutSize = new VESize(0, 0);
        this.mCamOutSize = new VESize(0, 0);
        this.mForceAdaptSurfaceSize = false;
        this.mCanvasSize = new VESize(0, 0);
        this.mEffect = VEDisPlayEffect.NONE;
        this.mEffectIntensity = 0.0f;
    }

    public long getBackgroundColor() {
        return this.mBgColor;
    }

    public VESize getCamOutSize() {
        return this.mCamOutSize;
    }

    public VESize getCanvasSize() {
        return this.mCanvasSize;
    }

    public VEDisPlayEffect getDisplayEffect() {
        return this.mEffect;
    }

    public float getDisplayRatio() {
        return this.mDisplayRatio;
    }

    public VEPreviewRadio getDisplayRatioMode() {
        return this.mDisplayRatioMode;
    }

    public int getDisplayRotation() {
        return this.mDisplayRotation;
    }

    public float getEffectIntensity() {
        return this.mEffectIntensity;
    }

    public int getEffectRotation() {
        return this.mEffectRotation;
    }

    public VEDisplayFitMode getFitMode() {
        return this.mFitMode;
    }

    public boolean getFlipX() {
        return this.mFlipX;
    }

    public boolean getFlipY() {
        return this.mFlipY;
    }

    public VESize getLayoutSize() {
        return this.mLayoutSize;
    }

    public VESize getRenderSize() {
        return this.mRenderSize;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getTranslateX() {
        return this.mTranslateX;
    }

    public int getTranslateY() {
        return this.mTranslateY;
    }

    public boolean isForceAdaptSurfaceSize() {
        return this.mForceAdaptSurfaceSize;
    }

    public VEDisplaySettings(Parcel r100) {
        this.mTranslateX = 0;
        this.mTranslateY = 0;
        this.mFlipX = false;
        this.mFlipY = false;
        this.mFitMode = VEDisplayFitMode.SCALE_MODE_CENTER_INSIDE;
        this.mRotation = 0;
        this.mEffectRotation = 0;
        this.mDisplayRotation = 0;
        VEPreviewRadio r101 = null;
        this.mDisplayRatioMode = null;
        this.mRenderSize = null;
        this.mLayoutSize = new VESize(0, 0);
        this.mCamOutSize = new VESize(0, 0);
        this.mForceAdaptSurfaceSize = false;
        this.mCanvasSize = new VESize(0, 0);
        this.mEffect = VEDisPlayEffect.NONE;
        this.mEffectIntensity = 0.0f;
        this.mTranslateX = r100.readInt();
        this.mTranslateY = r100.readInt();
        this.mFlipX = r100.readBoolean();
        this.mFlipY = r100.readBoolean();
        int r102 = r100.readInt();
        if (r102 != (-1)) goto L5;
        VEDisplayFitMode r103 = null;
    L6:
        this.mFitMode = r103;
        this.mRotation = r100.readInt();
        this.mEffectRotation = r100.readInt();
        this.mDisplayRotation = r100.readInt();
        this.mBgColor = r100.readInt();
        this.mDisplayRatio = r100.readFloat();
        int r104 = r100.readInt();
        if (r104 == (-1)) goto L10;
        r101 = VEPreviewRadio.values()[r104];
    L10:
        this.mDisplayRatioMode = r101;
        return;
    L5:
        r103 = VEDisplayFitMode.values()[r102];
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L47:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L47;
        VEDisplaySettings r101 = (VEDisplaySettings) r100;
        if (this.mTranslateX == r101.mTranslateX) goto L13;
    L45:
        return false;
    L13:
        if (this.mTranslateY != r101.mTranslateY) goto L45;
        if (this.mFlipX != r101.mFlipX) goto L45;
        if (this.mFlipY != r101.mFlipY) goto L45;
        if (this.mRotation != r101.mRotation) goto L45;
        if (this.mEffectRotation != r101.mEffectRotation) goto L45;
        if (this.mDisplayRotation != r101.mDisplayRotation) goto L45;
        if (this.mBgColor != r101.mBgColor) goto L45;
        if (Float.compare(r101.mDisplayRatio, this.mDisplayRatio) != 0) goto L45;
        if (this.mForceAdaptSurfaceSize != r101.mForceAdaptSurfaceSize) goto L45;
        if (Float.compare(r101.mEffectIntensity, this.mEffectIntensity) != 0) goto L45;
        if (this.mFitMode != r101.mFitMode) goto L45;
        if (this.mDisplayRatioMode != r101.mDisplayRatioMode) goto L45;
        if (this.mRenderSize.equals(r101.mRenderSize) == false) goto L45;
        if (this.mLayoutSize.equals(r101.mLayoutSize) == false) goto L45;
        if (this.mCamOutSize.equals(r101.mCamOutSize) == false) goto L45;
        if (this.mEffect != r101.mEffect) goto L45;
        return true;
    }

    public /* synthetic */ VEDisplaySettings(a r100) {
        this();
    }

    public static /* synthetic */ VESize access$1002(VEDisplaySettings r100, VESize r101) {
        r100.mRenderSize = r101;
        return r101;
    }

    public static /* synthetic */ VEDisplayFitMode access$102(VEDisplaySettings r100, VEDisplayFitMode r101) {
        r100.mFitMode = r101;
        return r101;
    }

    public static /* synthetic */ VEDisPlayEffect access$1102(VEDisplaySettings r100, VEDisPlayEffect r101) {
        r100.mEffect = r101;
        return r101;
    }

    public static /* synthetic */ float access$1202(VEDisplaySettings r100, float r101) {
        r100.mEffectIntensity = r101;
        return r101;
    }

    public static /* synthetic */ VESize access$1302(VEDisplaySettings r100, VESize r101) {
        r100.mLayoutSize = r101;
        return r101;
    }

    public static /* synthetic */ VESize access$1402(VEDisplaySettings r100, VESize r101) {
        r100.mCamOutSize = r101;
        return r101;
    }

    public static /* synthetic */ int access$1502(VEDisplaySettings r100, int r101) {
        r100.mEffectRotation = r101;
        return r101;
    }

    public static /* synthetic */ int access$1602(VEDisplaySettings r100, int r101) {
        r100.mDisplayRotation = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1702(VEDisplaySettings r100, boolean r101) {
        r100.mForceAdaptSurfaceSize = r101;
        return r101;
    }

    public static /* synthetic */ VESize access$1802(VEDisplaySettings r100, VESize r101) {
        r100.mCanvasSize = r101;
        return r101;
    }

    public static /* synthetic */ int access$202(VEDisplaySettings r100, int r101) {
        r100.mTranslateX = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(VEDisplaySettings r100, int r101) {
        r100.mTranslateY = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(VEDisplaySettings r100, boolean r101) {
        r100.mFlipX = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(VEDisplaySettings r100, boolean r101) {
        r100.mFlipY = r101;
        return r101;
    }

    public static /* synthetic */ int access$602(VEDisplaySettings r100, int r101) {
        r100.mRotation = r101;
        return r101;
    }

    public static /* synthetic */ long access$702(VEDisplaySettings r100, long r101) {
        r100.mBgColor = r101;
        return r101;
    }

    public static /* synthetic */ float access$802(VEDisplaySettings r100, float r101) {
        r100.mDisplayRatio = r101;
        return r101;
    }

    public static /* synthetic */ VEPreviewRadio access$902(VEDisplaySettings r100, VEPreviewRadio r101) {
        r100.mDisplayRatioMode = r101;
        return r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mTranslateX);
        r100.writeInt(this.mTranslateY);
        r100.writeBoolean(this.mFlipX);
        r100.writeBoolean(this.mFlipY);
        VEDisplayFitMode r102 = this.mFitMode;
        int r103 = -1;
        if (r102 != null) goto L5;
        int r104 = -1;
    L6:
        r100.writeInt(r104);
        r100.writeInt(this.mRotation);
        r100.writeInt(this.mEffectRotation);
        r100.writeInt(this.mDisplayRotation);
        r100.writeLong(this.mBgColor);
        r100.writeFloat(this.mDisplayRatio);
        VEPreviewRadio r105 = this.mDisplayRatioMode;
        if (r105 == null) goto L10;
        r103 = r105.ordinal();
    L10:
        r100.writeInt(r103);
        return;
    L5:
        r104 = r102.ordinal();
        goto L6
    }
}
