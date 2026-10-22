package com.bytedance.dora.wlan.trace;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum DoraStationEvent extends Enum<DoraStationEvent> {
    private static final /* synthetic */ DoraStationEvent[] $VALUES = null;
    private static final SimpleDateFormat DATE_FORMAT = null;
    public static final DoraStationEvent connectionSuccess = null;
    public static final DoraStationEvent isConnecting = null;
    public static final DoraStationEvent notConnected = null;
    public static final DoraStationEvent stationConnectFailed = null;
    public static final DoraStationEvent stationConnecting = null;
    public static final DoraStationEvent stationOpenCMDSendFailed = null;
    public static final DoraStationEvent stationOpenCMDSendSuccess = null;
    public static final DoraStationEvent stationOpenCMDSending = null;
    public static final DoraStationEvent stationOpenTimeout = null;

    static {
        DoraStationEvent r100 = new DoraStationEvent("notConnected", 0);
        notConnected = r100;
        DoraStationEvent r101 = new DoraStationEvent("isConnecting", 1);
        isConnecting = r101;
        DoraStationEvent r102 = new DoraStationEvent("stationOpenCMDSending", 2);
        stationOpenCMDSending = r102;
        DoraStationEvent r103 = new DoraStationEvent("stationOpenCMDSendSuccess", 3);
        stationOpenCMDSendSuccess = r103;
        DoraStationEvent r104 = new DoraStationEvent(DoraConnectionFailedReason.STATION_OPEN_CMD_SEND_FAILED, 4);
        stationOpenCMDSendFailed = r104;
        DoraStationEvent r105 = new DoraStationEvent("stationConnecting", 5);
        stationConnecting = r105;
        DoraStationEvent r110 = new DoraStationEvent(DoraConnectionFailedReason.STATION_OPEN_TIMEOUT, 6);
        stationOpenTimeout = r110;
        DoraStationEvent r111 = new DoraStationEvent(DoraConnectionFailedReason.STATION_CONNECT_FAILED, 7);
        stationConnectFailed = r111;
        DoraStationEvent r112 = new DoraStationEvent("connectionSuccess", 8);
        connectionSuccess = r112;
        $VALUES = new DoraStationEvent[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        DATE_FORMAT = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss", Locale.getDefault());
    }

    public static DoraStationEvent[] values() {
        return (DoraStationEvent[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return DATE_FORMAT.format(new Date()) + " " + name();
    }

    public static DoraStationEvent valueOf(String r100) {
        return (DoraStationEvent) a.a(DoraStationEvent.class, r100);
    }

    private DoraStationEvent(String r100, int r101) {
        super(r100, r101);
    }
}
