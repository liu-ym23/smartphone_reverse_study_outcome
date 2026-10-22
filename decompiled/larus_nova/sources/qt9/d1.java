package qt9;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.pia.core.metrics.ErrorType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/provider/FlowImagePreDrawConfig;", "", "enable", "", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, ErrorType.PREFETCH, "<init>", "(ZIIZ)V", "getEnable", "()Z", "getMin", "()I", "getMax", "getPrefetch", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d1 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
    private final int max;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
    private final int min;

    @SerializedName(ErrorType.PREFETCH)
    private final boolean prefetch;

    public d1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r101 = (d1) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.min == r101.min) goto L15;
        return false;
    L15:
        if (this.max == r101.max) goto L18;
        return false;
    L18:
        if (this.prefetch == r101.prefetch) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.min) * 31) + this.max) * 31;
        if (this.prefetch == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowImagePreDrawConfig(enable=" + this.enable + ", min=" + this.min + ", max=" + this.max + ", prefetch=" + this.prefetch + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.max;
    }

    public final int c() {
        return this.min;
    }

    public final boolean d() {
        return this.prefetch;
    }

    public d1(int r100) {
        this.enable = false;
        this.min = 0;
        this.max = BmLocated.ALIGN_RIGHT_BOTTOM;
        this.prefetch = false;
    }
}
