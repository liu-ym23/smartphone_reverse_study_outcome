package mt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/model/CameraInitOptConfig;", "", "veInit", "", "launchInitDelayMs", "", "execInitTimeoutMs", "<init>", "(ZJJ)V", "getVeInit", "()Z", "getLaunchInitDelayMs", "()J", "getExecInitTimeoutMs", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("exec_init_timeout_ms")
    private final long execInitTimeoutMs;

    @SerializedName("launch_init_delay_ms")
    private final long launchInitDelayMs;

    @SerializedName("ve_init")
    private final boolean veInit;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.veInit == r101.veInit) goto L12;
        return false;
    L12:
        if (this.launchInitDelayMs == r101.launchInitDelayMs) goto L15;
        return false;
    L15:
        if (this.execInitTimeoutMs == r101.execInitTimeoutMs) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.veInit == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.launchInitDelayMs;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.execInitTimeoutMs;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "CameraInitOptConfig(veInit=" + this.veInit + ", launchInitDelayMs=" + this.launchInitDelayMs + ", execInitTimeoutMs=" + this.execInitTimeoutMs + ')';
    }

    public final long a() {
        return this.execInitTimeoutMs;
    }

    public final long b() {
        return this.launchInitDelayMs;
    }

    public final boolean c() {
        return this.veInit;
    }

    public a(int r100) {
        this.veInit = false;
        this.launchInitDelayMs = 0;
        this.execInitTimeoutMs = 5000;
    }
}
