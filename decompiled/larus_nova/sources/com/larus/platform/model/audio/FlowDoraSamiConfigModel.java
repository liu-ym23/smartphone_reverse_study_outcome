package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.common.ErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/audio/FlowDoraSamiConfigModel;", "", "reconnectInterval", "", "doraVisionReconnectInterval", "reconnectTimeout", "", "startSessionTimeout", "startSessionTimeoutEnable", "", "startSessionTimeoutOnRadio", "reconnectIntervalOnRadio", "<init>", "([I[IIIZI[I)V", "getReconnectInterval", "()[I", "getDoraVisionReconnectInterval", "getReconnectTimeout", "()I", "getStartSessionTimeout", "getStartSessionTimeoutEnable", "()Z", "getStartSessionTimeoutOnRadio", "getReconnectIntervalOnRadio", "hasVision", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDoraSamiConfigModel {

    @SerializedName("reconnect_interval_on_vision")
    private final int[] doraVisionReconnectInterval;

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

    public FlowDoraSamiConfigModel() {
        this(null, null, 0, 0, false, 0, null, 127, null);
    }

    public final int[] getDoraVisionReconnectInterval() {
        return this.doraVisionReconnectInterval;
    }

    public final int[] getReconnectInterval() {
        return this.reconnectInterval;
    }

    public final int[] getReconnectIntervalOnRadio() {
        return this.reconnectIntervalOnRadio;
    }

    public final int getReconnectTimeout() {
        return this.reconnectTimeout;
    }

    public final int getStartSessionTimeout() {
        return this.startSessionTimeout;
    }

    public final boolean getStartSessionTimeoutEnable() {
        return this.startSessionTimeoutEnable;
    }

    public final int getStartSessionTimeoutOnRadio() {
        return this.startSessionTimeoutOnRadio;
    }

    public final int[] getReconnectInterval(boolean r100) {
        if (r100 == false) goto L5;
        return this.doraVisionReconnectInterval;
    L5:
        return this.reconnectInterval;
    }

    public FlowDoraSamiConfigModel(int[] r100, int[] r101, int r102, int r103, boolean r104, int r105, int[] r106) {
        this.reconnectInterval = r100;
        this.doraVisionReconnectInterval = r101;
        this.reconnectTimeout = r102;
        this.startSessionTimeout = r103;
        this.startSessionTimeoutEnable = r104;
        this.startSessionTimeoutOnRadio = r105;
        this.reconnectIntervalOnRadio = r106;
    }

    public /* synthetic */ FlowDoraSamiConfigModel(int[] r100, int[] r101, int r102, int r103, boolean r110, int r111, int[] r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L6;
        r100 = new int[]{100, 200, 400, 800, 1200, 3200};
    L6:
        if ((r113 & 2) == 0) goto L8;
        r101 = new int[]{100, 200, 400, 800, 1200, 3200, 3200, 3200, 3200, 3200, 3200};
    L8:
        int[] r115 = r101;
        if ((r113 & 4) == 0) goto L11;
        int r104 = 5000;
    L13:
        if ((r113 & 8) == 0) goto L15;
        int r105 = 15;
    L17:
        if ((r113 & 16) == 0) goto L19;
        boolean r106 = true;
    L21:
        if ((r113 & 32) == 0) goto L23;
        int r107 = 30;
    L25:
        if ((r113 & 64) == 0) goto L27;
        r112 = new int[]{100, 200, 400, 800, 1600, 3200, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT, ErrorCode.Memory.ERROR_UPDATE_BUT_TYPE_NOT_SUPPORT};
    L27:
        int[] r108 = r112;
        this(r100, r115, r104, r105, r106, r107, r108);
        return;
    L23:
        r107 = r111;
        goto L25
    L19:
        r106 = r110;
        goto L21
    L15:
        r105 = r103;
        goto L17
    L11:
        r104 = r102;
        goto L13
    }
}
