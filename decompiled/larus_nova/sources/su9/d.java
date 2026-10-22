package su9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/larus/settings/provider/frontier/FrontierOptConfig;", "", "reconnectEnable", "", "connectInfoEnable", "doraBackgroundDisable", "backgroundMode", "", "backgroundDelayTime", "", "<init>", "(ZZZIJ)V", "getReconnectEnable", "()Z", "getConnectInfoEnable", "getDoraBackgroundDisable", "getBackgroundMode", "()I", "getBackgroundDelayTime", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("background_delay_time")
    private final long backgroundDelayTime;

    @SerializedName("background_mode")
    private final int backgroundMode;

    @SerializedName("connect_info_enable")
    private final boolean connectInfoEnable;

    @SerializedName("dora_background_disable")
    private final boolean doraBackgroundDisable;

    @SerializedName("reconnect_enable")
    private final boolean reconnectEnable;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.reconnectEnable == r101.reconnectEnable) goto L12;
        return false;
    L12:
        if (this.connectInfoEnable == r101.connectInfoEnable) goto L15;
        return false;
    L15:
        if (this.doraBackgroundDisable == r101.doraBackgroundDisable) goto L18;
        return false;
    L18:
        if (this.backgroundMode == r101.backgroundMode) goto L21;
        return false;
    L21:
        if (this.backgroundDelayTime == r101.backgroundDelayTime) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.reconnectEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.connectInfoEnable == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.doraBackgroundDisable == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (((r104 + r100) * 31) + this.backgroundMode) * 31;
        long r106 = this.backgroundDelayTime;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FrontierOptConfig(reconnectEnable=" + this.reconnectEnable + ", connectInfoEnable=" + this.connectInfoEnable + ", doraBackgroundDisable=" + this.doraBackgroundDisable + ", backgroundMode=" + this.backgroundMode + ", backgroundDelayTime=" + this.backgroundDelayTime + ')';
    }

    public final long a() {
        return this.backgroundDelayTime;
    }

    public final int b() {
        return this.backgroundMode;
    }

    public final boolean c() {
        return this.connectInfoEnable;
    }

    public final boolean d() {
        return this.doraBackgroundDisable;
    }

    public final boolean e() {
        return this.reconnectEnable;
    }

    public d(int r100) {
        this.reconnectEnable = true;
        this.connectInfoEnable = false;
        this.doraBackgroundDisable = true;
        this.backgroundMode = 0;
        this.backgroundDelayTime = 0;
    }
}
