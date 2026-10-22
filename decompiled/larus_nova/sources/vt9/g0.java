package vt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/larus/settings/provider/audio/RTCEnginePerfOpt;", "", "enableDestroyEngine", "", "enableDestroyEngineForDora", "engineDestroyDelayTime", "", "<init>", "(ZZJ)V", "getEnableDestroyEngine", "()Z", "setEnableDestroyEngine", "(Z)V", "getEnableDestroyEngineForDora", "setEnableDestroyEngineForDora", "getEngineDestroyDelayTime", "()J", "setEngineDestroyDelayTime", "(J)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g0 {

    @SerializedName("enable_destroy_engine")
    private boolean enableDestroyEngine;

    @SerializedName("enable_destroy_engine_for_dora")
    private boolean enableDestroyEngineForDora;

    @SerializedName("engine_destroy_delay_ms")
    private long engineDestroyDelayTime;

    public g0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (this.enableDestroyEngine == r101.enableDestroyEngine) goto L12;
        return false;
    L12:
        if (this.enableDestroyEngineForDora == r101.enableDestroyEngineForDora) goto L15;
        return false;
    L15:
        if (this.engineDestroyDelayTime == r101.engineDestroyDelayTime) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableDestroyEngine == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableDestroyEngineForDora == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        long r104 = this.engineDestroyDelayTime;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "RTCEnginePerfOpt(enableDestroyEngine=" + this.enableDestroyEngine + ", enableDestroyEngineForDora=" + this.enableDestroyEngineForDora + ", engineDestroyDelayTime=" + this.engineDestroyDelayTime + ')';
    }

    public g0(int r100) {
        this.enableDestroyEngine = false;
        this.enableDestroyEngineForDora = false;
        this.engineDestroyDelayTime = -1;
    }
}
