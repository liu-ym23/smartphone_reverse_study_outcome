package com.larus.im.internal.audio.trace.smartnetwork;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/im/internal/audio/trace/smartnetwork/MultipathCause;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "RSSI", "RX_LINK_SPEED", "TX_LINK_SPEED", "PREDICT_RSSI", "PREDICT_RX_LINK_SPEED", "PREDICT_TX_LINK_SPEED", "WIFI_SCAN_TIMES", "RTC_L4_MULTIPATH", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultipathCause extends Enum<MultipathCause> {
    public static final MultipathCause NONE = null;
    public static final MultipathCause PREDICT_RSSI = null;
    public static final MultipathCause PREDICT_RX_LINK_SPEED = null;
    public static final MultipathCause PREDICT_TX_LINK_SPEED = null;
    public static final MultipathCause RSSI = null;
    public static final MultipathCause RTC_L4_MULTIPATH = null;
    public static final MultipathCause RX_LINK_SPEED = null;
    public static final MultipathCause TX_LINK_SPEED = null;
    public static final MultipathCause WIFI_SCAN_TIMES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultipathCause[] f347499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347500b = null;

    public static EnumEntries<MultipathCause> getEntries() {
        return f347500b;
    }

    static {
        MultipathCause r100 = new MultipathCause(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        MultipathCause r101 = new MultipathCause("RSSI", 1);
        RSSI = r101;
        MultipathCause r102 = new MultipathCause("RX_LINK_SPEED", 2);
        RX_LINK_SPEED = r102;
        MultipathCause r103 = new MultipathCause("TX_LINK_SPEED", 3);
        TX_LINK_SPEED = r103;
        MultipathCause r104 = new MultipathCause("PREDICT_RSSI", 4);
        PREDICT_RSSI = r104;
        MultipathCause r105 = new MultipathCause("PREDICT_RX_LINK_SPEED", 5);
        PREDICT_RX_LINK_SPEED = r105;
        MultipathCause r110 = new MultipathCause("PREDICT_TX_LINK_SPEED", 6);
        PREDICT_TX_LINK_SPEED = r110;
        MultipathCause r111 = new MultipathCause("WIFI_SCAN_TIMES", 7);
        WIFI_SCAN_TIMES = r111;
        MultipathCause r112 = new MultipathCause("RTC_L4_MULTIPATH", 8);
        RTC_L4_MULTIPATH = r112;
        MultipathCause[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f347499a = r113;
        f347500b = EnumEntriesKt.enumEntries(r113);
    }

    public static MultipathCause[] values() {
        return (MultipathCause[]) f347499a.clone();
    }

    public static MultipathCause valueOf(String r100) {
        return (MultipathCause) a.a(MultipathCause.class, r100);
    }

    public MultipathCause(String r100, int r101) {
        super(r100, r101);
    }
}
