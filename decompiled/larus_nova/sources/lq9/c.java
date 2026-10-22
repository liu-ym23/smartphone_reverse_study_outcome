package lq9;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/audio/AsrSnrStrategy;", "", "enable", "", "snrThreshold", "", "cutoffLength", "<init>", "(ZFF)V", "getEnable", "()Z", "getSnrThreshold", "()F", "getCutoffLength", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("cutoff_length")
    private final float cutoffLength;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("snr_threshold")
    private final float snrThreshold;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (Float.compare(this.snrThreshold, r101.snrThreshold) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.cutoffLength, r101.cutoffLength) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + Float.floatToIntBits(this.snrThreshold)) * 31) + Float.floatToIntBits(this.cutoffLength);
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "AsrSnrStrategy(enable=" + this.enable + ", snrThreshold=" + this.snrThreshold + ", cutoffLength=" + this.cutoffLength + ')';
    }

    public final float a() {
        return this.cutoffLength;
    }

    public final boolean b() {
        return this.enable;
    }

    public final float c() {
        return this.snrThreshold;
    }

    public c(int r100) {
        if (AppHost.f326268a.isOversea() == false) goto L5;
        float r101 = 0.0f;
    L6:
        this.enable = true;
        this.snrThreshold = r101;
        this.cutoffLength = 0.3f;
        return;
    L5:
        r101 = 15.0f;
        goto L6
    }
}
