package com.bytedance.locallife.groupon.struct;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB/\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0005HÆ\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001b\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/groupon/struct/AnimationConfig;", "Ljava/io/Serializable;", "", "component1", "component2", "", "component3", "component4", "containerAnimType", "targetAnimType", "containerScale", "targetScale", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getContainerAnimType", "()I", "getTargetAnimType", FaceService.girlLabel, "getContainerScale", "()F", "getTargetScale", "<init>", "(IIFF)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class AnimationConfig implements Serializable {
    public static final int ANIM_DISABLE = -1;
    public static final int ANIM_ENABLE = 0;
    public static final int CONTAINER_TYPE_SCALE_MOVE = 1;
    public static final int CONTAINER_TYPE_SCALE_MOVE_MASK = 2;
    public static final a Companion = null;
    public static final int TARGET_TYPE_SCALE = 1;
    public static final int TARGET_TYPE_SCALE_ALPHA = 2;

    @SerializedName(KtvSubElement.CONTAINER)
    private final int containerAnimType;

    @SerializedName("container_scale")
    private final float containerScale;

    @SerializedName(PickerReporterConstants.KEY.TARGET)
    private final int targetAnimType;

    @SerializedName("target_scale")
    private final float targetScale;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AnimationConfig() {
        this(0, 0, 0.0f, 0.0f, 15, null);
    }

    public static /* synthetic */ AnimationConfig copy$default(AnimationConfig r100, int r101, int r102, float r103, float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.containerAnimType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.targetAnimType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.containerScale;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.targetScale;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.containerAnimType;
    }

    public final int component2() {
        return this.targetAnimType;
    }

    public final float component3() {
        return this.containerScale;
    }

    public final float component4() {
        return this.targetScale;
    }

    public final AnimationConfig copy(int r100, int r101, float r102, float r103) {
        return new AnimationConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AnimationConfig) == true) goto L8;
        return false;
    L8:
        AnimationConfig r101 = (AnimationConfig) r100;
        if (this.containerAnimType == r101.containerAnimType) goto L12;
        return false;
    L12:
        if (this.targetAnimType == r101.targetAnimType) goto L15;
        return false;
    L15:
        if (Float.compare(this.containerScale, r101.containerScale) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.targetScale, r101.targetScale) == 0) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.containerAnimType * 31) + this.targetAnimType) * 31) + Float.floatToIntBits(this.containerScale)) * 31) + Float.floatToIntBits(this.targetScale);
    }

    public String toString() {
        return "AnimationConfig(containerAnimType=" + this.containerAnimType + ", targetAnimType=" + this.targetAnimType + ", containerScale=" + this.containerScale + ", targetScale=" + this.targetScale + ')';
    }

    public final int getContainerAnimType() {
        return this.containerAnimType;
    }

    public final float getContainerScale() {
        return this.containerScale;
    }

    public final int getTargetAnimType() {
        return this.targetAnimType;
    }

    public final float getTargetScale() {
        return this.targetScale;
    }

    public AnimationConfig(int r100, int r101, float r102, float r103) {
        this.containerAnimType = r100;
        this.targetAnimType = r101;
        this.containerScale = r102;
        this.targetScale = r103;
    }

    public /* synthetic */ AnimationConfig(int r100, int r101, float r102, float r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0.0f;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0.0f;
    L14:
        this(r100, r101, r102, r103);
    }
}
