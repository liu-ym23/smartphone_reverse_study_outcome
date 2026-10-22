package nv2;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lnv2/f;", "", "", "enableClose", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "enableSaveResolution", "b", "enableTips", "c", "", "showTime", "J", "e", "()J", "showTimeMin", "f", "stallTime", ce.f26391f, "safeInterval", "d", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("enable_close")
    private final boolean enableClose;

    @SerializedName("enable_save_resolution")
    private final boolean enableSaveResolution;

    @SerializedName("enable_tips")
    private final boolean enableTips;

    @SerializedName("safe_interval")
    private final long safeInterval;

    @SerializedName("show_time")
    private final long showTime;

    @SerializedName("show_time_min")
    private final long showTimeMin;

    @SerializedName("stall_time")
    private final long stallTime;

    public f() {
        this(0);
    }

    public final boolean h() {
        if (this.showTime > 0) goto L5;
    L9:
        return false;
    L5:
        if (this.stallTime <= 0) goto L9;
        if (this.safeInterval <= 0) goto L9;
        return true;
    }

    public final String toString() {
        return "StallTipsConfig(enableClose=" + this.enableClose + ", enableSaveResolution=" + this.enableSaveResolution + ", enableTips=" + this.enableTips + ", showTime=" + this.showTime + ", showTimeMin=" + this.showTimeMin + ", stallTime=" + this.stallTime + ", safe_interval=" + this.safeInterval + ", )";
    }

    public final boolean a() {
        return this.enableClose;
    }

    public final boolean b() {
        return this.enableSaveResolution;
    }

    public final boolean c() {
        return this.enableTips;
    }

    public final long d() {
        return this.safeInterval;
    }

    public final long e() {
        return this.showTime;
    }

    public final long f() {
        return this.showTimeMin;
    }

    public final long g() {
        return this.stallTime;
    }

    public f(int r100) {
        this.enableClose = false;
        this.enableSaveResolution = false;
        this.enableTips = false;
        this.showTime = 0;
        this.showTimeMin = 0;
        this.stallTime = 0;
        this.safeInterval = 0;
    }
}
