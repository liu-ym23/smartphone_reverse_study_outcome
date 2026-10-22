package hq9;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006#"}, d2 = {"Lcom/larus/platform/model/FloatWindowConfig;", "", "enableAutoShrink", "", "autoShrinkBlackList", "", "", "immediateAutoShrink", "autoShrinkDelayTime", "", "enableNewMiniStyle", "controlAutoShrinkFrequency", "<init>", "(ZLjava/util/List;ZJZZ)V", "getEnableAutoShrink", "()Z", "getAutoShrinkBlackList", "()Ljava/util/List;", "getImmediateAutoShrink", "getAutoShrinkDelayTime", "()J", "getEnableNewMiniStyle", "getControlAutoShrinkFrequency", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f1 {

    @SerializedName("auto_shrink_black_list")
    private final List<String> autoShrinkBlackList;

    @SerializedName("auto_shrink_delay_time")
    private final long autoShrinkDelayTime;

    @SerializedName("control_auto_shrink_frequency")
    private final boolean controlAutoShrinkFrequency;

    @SerializedName("enable_auto_shrink")
    private final boolean enableAutoShrink;

    @SerializedName("enable_new_mini_style")
    private final boolean enableNewMiniStyle;

    @SerializedName("immediate_auto_shrink")
    private final boolean immediateAutoShrink;

    public f1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r101 = (f1) r100;
        if (this.enableAutoShrink == r101.enableAutoShrink) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.autoShrinkBlackList, r101.autoShrinkBlackList) == true) goto L15;
        return false;
    L15:
        if (this.immediateAutoShrink == r101.immediateAutoShrink) goto L18;
        return false;
    L18:
        if (this.autoShrinkDelayTime == r101.autoShrinkDelayTime) goto L21;
        return false;
    L21:
        if (this.enableNewMiniStyle == r101.enableNewMiniStyle) goto L24;
        return false;
    L24:
        if (this.controlAutoShrinkFrequency == r101.controlAutoShrinkFrequency) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableAutoShrink == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        List<String> r103 = this.autoShrinkBlackList;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.immediateAutoShrink == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        long r108 = this.autoShrinkDelayTime;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        if (this.enableNewMiniStyle == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.controlAutoShrinkFrequency == true) goto L23;
        r100 = 1237;
    L23:
        return r111 + r100;
    L17:
        r110 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FloatWindowConfig(enableAutoShrink=" + this.enableAutoShrink + ", autoShrinkBlackList=" + this.autoShrinkBlackList + ", immediateAutoShrink=" + this.immediateAutoShrink + ", autoShrinkDelayTime=" + this.autoShrinkDelayTime + ", enableNewMiniStyle=" + this.enableNewMiniStyle + ", controlAutoShrinkFrequency=" + this.controlAutoShrinkFrequency + ')';
    }

    public final List<String> a() {
        return this.autoShrinkBlackList;
    }

    public final long b() {
        return this.autoShrinkDelayTime;
    }

    public final boolean c() {
        return this.controlAutoShrinkFrequency;
    }

    public final boolean d() {
        return this.enableAutoShrink;
    }

    public final boolean e() {
        return this.enableNewMiniStyle;
    }

    public final boolean f() {
        return this.immediateAutoShrink;
    }

    public f1(Object r100) {
        ArrayList r101 = new ArrayList();
        this.enableAutoShrink = true;
        this.autoShrinkBlackList = r101;
        this.immediateAutoShrink = true;
        this.autoShrinkDelayTime = 2000;
        this.enableNewMiniStyle = true;
        this.controlAutoShrinkFrequency = false;
    }
}
