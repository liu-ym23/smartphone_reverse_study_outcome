package com.ss.bytertc.engine.type;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum NetworkDetectionStopReason extends Enum<NetworkDetectionStopReason> {
    private static final /* synthetic */ NetworkDetectionStopReason[] $VALUES = null;
    public static final NetworkDetectionStopReason CONNECTION_LOST = null;
    public static final NetworkDetectionStopReason INNER_ERR = null;
    public static final NetworkDetectionStopReason STREAMING = null;
    public static final NetworkDetectionStopReason TIMEOUT = null;
    public static final NetworkDetectionStopReason USER = null;
    int value;

    static {
        NetworkDetectionStopReason r100 = new NetworkDetectionStopReason(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0, 0);
        USER = r100;
        NetworkDetectionStopReason r101 = new NetworkDetectionStopReason("TIMEOUT", 1, 1);
        TIMEOUT = r101;
        NetworkDetectionStopReason r102 = new NetworkDetectionStopReason("CONNECTION_LOST", 2, 2);
        CONNECTION_LOST = r102;
        NetworkDetectionStopReason r103 = new NetworkDetectionStopReason("STREAMING", 3, 3);
        STREAMING = r103;
        NetworkDetectionStopReason r104 = new NetworkDetectionStopReason("INNER_ERR", 4, 4);
        INNER_ERR = r104;
        $VALUES = new NetworkDetectionStopReason[]{r100, r101, r102, r103, r104};
    }

    public static NetworkDetectionStopReason[] values() {
        return (NetworkDetectionStopReason[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static NetworkDetectionStopReason fromId(int r100) {
        NetworkDetectionStopReason[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        NetworkDetectionStopReason r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return USER;
    }

    public static NetworkDetectionStopReason valueOf(String r100) {
        return (NetworkDetectionStopReason) a.a(NetworkDetectionStopReason.class, r100);
    }

    private NetworkDetectionStopReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
