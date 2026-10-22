package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/audio/GuideConfig;", "", "guideX", "", "guideY", "", "guideM", "guideN", "<init>", "(FIFF)V", "getGuideX", "()F", "getGuideY", "()I", "getGuideM", "getGuideN", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GuideConfig {

    @SerializedName("open_tts_guide_m")
    private final float guideM;

    @SerializedName("open_tts_guide_n")
    private final float guideN;

    @SerializedName("open_tts_guide_x")
    private final float guideX;

    @SerializedName("open_tts_guide_y")
    private final int guideY;

    public GuideConfig() {
        this(0.0f, 0, 0.0f, 0.0f, 15, null);
    }

    public static /* synthetic */ GuideConfig copy$default(GuideConfig r100, float r101, int r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.guideX;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.guideY;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.guideM;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.guideN;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final float component1() {
        return this.guideX;
    }

    public final int component2() {
        return this.guideY;
    }

    public final float component3() {
        return this.guideM;
    }

    public final float component4() {
        return this.guideN;
    }

    public final GuideConfig copy(float r100, int r101, float r102, float r103) {
        return new GuideConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GuideConfig) == true) goto L8;
        return false;
    L8:
        GuideConfig r101 = (GuideConfig) r100;
        if (Float.compare(this.guideX, r101.guideX) == 0) goto L12;
        return false;
    L12:
        if (this.guideY == r101.guideY) goto L15;
        return false;
    L15:
        if (Float.compare(this.guideM, r101.guideM) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.guideN, r101.guideN) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.guideX) * 31) + this.guideY) * 31) + Float.floatToIntBits(this.guideM)) * 31) + Float.floatToIntBits(this.guideN);
    }

    public String toString() {
        return "GuideConfig(guideX=" + this.guideX + ", guideY=" + this.guideY + ", guideM=" + this.guideM + ", guideN=" + this.guideN + ')';
    }

    public final float getGuideM() {
        return this.guideM;
    }

    public final float getGuideN() {
        return this.guideN;
    }

    public final float getGuideX() {
        return this.guideX;
    }

    public final int getGuideY() {
        return this.guideY;
    }

    public GuideConfig(float r100, int r101, float r102, float r103) {
        this.guideX = r100;
        this.guideY = r101;
        this.guideM = r102;
        this.guideN = r103;
    }

    public /* synthetic */ GuideConfig(float r100, int r101, float r102, float r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = -1.0f;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = -1.0f;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = -1.0f;
    L14:
        this(r100, r101, r102, r103);
    }
}
