package nu9;

import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.ErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/dora/FlowDoraSamiConfig;", "", "reconnectInterval", "", "reconnectTimeout", "", "startSessionTimeout", "startSessionTimeoutEnable", "", "startSessionTimeoutOnRadio", "reconnectIntervalOnRadio", "<init>", "([IIIZI[I)V", "getReconnectInterval", "()[I", "getReconnectTimeout", "()I", "getStartSessionTimeout", "getStartSessionTimeoutEnable", "()Z", "getStartSessionTimeoutOnRadio", "getReconnectIntervalOnRadio", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r {

    @SerializedName("reconnect_interval")
    private final int[] reconnectInterval;

    @SerializedName("reconnect_interval_on_radio")
    private final int[] reconnectIntervalOnRadio;

    @SerializedName("reconnect_timeout")
    private final int reconnectTimeout;

    @SerializedName("start_session_timeout")
    private final int startSessionTimeout;

    @SerializedName("start_session_timeout_enable")
    private final boolean startSessionTimeoutEnable;

    @SerializedName("start_session_timeout_on_radio")
    private final int startSessionTimeoutOnRadio;

    public r() {
        this(0);
    }

    public final int[] a() {
        return this.reconnectInterval;
    }

    public final int[] b() {
        return this.reconnectIntervalOnRadio;
    }

    public final int c() {
        return this.reconnectTimeout;
    }

    public final int d() {
        return this.startSessionTimeout;
    }

    public final boolean e() {
        return this.startSessionTimeoutEnable;
    }

    public final int f() {
        return this.startSessionTimeoutOnRadio;
    }

    public r(int r100) {
        int[] r101 = {100, 200, 400, 800, 1600, 3200, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT};
        this.reconnectInterval = new int[]{100, 200, 400, 800, 1600, 3200};
        this.reconnectTimeout = 5000;
        this.startSessionTimeout = 15;
        this.startSessionTimeoutEnable = true;
        this.startSessionTimeoutOnRadio = 30;
        this.reconnectIntervalOnRadio = r101;
    }
}
