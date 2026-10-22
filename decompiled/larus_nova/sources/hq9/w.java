package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006*"}, d2 = {"Lcom/larus/platform/model/BachAvatarSettingsConfig;", "", "minSharpnessThreshold", "", "maxSharpnessThreshold", "faceScoreThreshold", "pitchLimitBottom", "", "pitchLimitTop", "yawLimitBottom", "yawLimitTop", "similarityThreshold", "faceShieldThreshold", "<init>", "(FFFIIIIFF)V", "getMinSharpnessThreshold", "()F", "getMaxSharpnessThreshold", "getFaceScoreThreshold", "getPitchLimitBottom", "()I", "getPitchLimitTop", "getYawLimitBottom", "getYawLimitTop", "getSimilarityThreshold", "getFaceShieldThreshold", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class w {

    @SerializedName("face_score_threshold")
    private final float faceScoreThreshold;

    @SerializedName("face_shield_threshold")
    private final float faceShieldThreshold;

    @SerializedName("max_sharpness_threshold")
    private final float maxSharpnessThreshold;

    @SerializedName("min_sharpness_threshold")
    private final float minSharpnessThreshold;

    @SerializedName("pitch_limit_bottom")
    private final int pitchLimitBottom;

    @SerializedName("pitch_limit_top")
    private final int pitchLimitTop;

    @SerializedName("similarity_threshold")
    private final float similarityThreshold;

    @SerializedName("yaw_limit_bottom")
    private final int yawLimitBottom;

    @SerializedName("yaw_limit_top")
    private final int yawLimitTop;

    public w() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Float.compare(this.minSharpnessThreshold, r101.minSharpnessThreshold) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.maxSharpnessThreshold, r101.maxSharpnessThreshold) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.faceScoreThreshold, r101.faceScoreThreshold) == 0) goto L18;
        return false;
    L18:
        if (this.pitchLimitBottom == r101.pitchLimitBottom) goto L21;
        return false;
    L21:
        if (this.pitchLimitTop == r101.pitchLimitTop) goto L24;
        return false;
    L24:
        if (this.yawLimitBottom == r101.yawLimitBottom) goto L27;
        return false;
    L27:
        if (this.yawLimitTop == r101.yawLimitTop) goto L30;
        return false;
    L30:
        if (Float.compare(this.similarityThreshold, r101.similarityThreshold) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(this.faceShieldThreshold, r101.faceShieldThreshold) == 0) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((Float.floatToIntBits(this.minSharpnessThreshold) * 31) + Float.floatToIntBits(this.maxSharpnessThreshold)) * 31) + Float.floatToIntBits(this.faceScoreThreshold)) * 31) + this.pitchLimitBottom) * 31) + this.pitchLimitTop) * 31) + this.yawLimitBottom) * 31) + this.yawLimitTop) * 31) + Float.floatToIntBits(this.similarityThreshold)) * 31) + Float.floatToIntBits(this.faceShieldThreshold);
    }

    public final String toString() {
        return "BachAvatarSettingsConfig(minSharpnessThreshold=" + this.minSharpnessThreshold + ", maxSharpnessThreshold=" + this.maxSharpnessThreshold + ", faceScoreThreshold=" + this.faceScoreThreshold + ", pitchLimitBottom=" + this.pitchLimitBottom + ", pitchLimitTop=" + this.pitchLimitTop + ", yawLimitBottom=" + this.yawLimitBottom + ", yawLimitTop=" + this.yawLimitTop + ", similarityThreshold=" + this.similarityThreshold + ", faceShieldThreshold=" + this.faceShieldThreshold + ')';
    }

    public final float a() {
        return this.faceScoreThreshold;
    }

    public final float b() {
        return this.faceShieldThreshold;
    }

    public final float c() {
        return this.maxSharpnessThreshold;
    }

    public final float d() {
        return this.minSharpnessThreshold;
    }

    public final int e() {
        return this.pitchLimitBottom;
    }

    public final int f() {
        return this.pitchLimitTop;
    }

    public final float g() {
        return this.similarityThreshold;
    }

    public final int h() {
        return this.yawLimitBottom;
    }

    public final int i() {
        return this.yawLimitTop;
    }

    public w(int r100) {
        this.minSharpnessThreshold = 0.6f;
        this.maxSharpnessThreshold = 0.73f;
        this.faceScoreThreshold = 1.24f;
        this.pitchLimitBottom = -30;
        this.pitchLimitTop = 30;
        this.yawLimitBottom = -30;
        this.yawLimitTop = 30;
        this.similarityThreshold = 0.5f;
        this.faceShieldThreshold = 0.3f;
    }
}
