package com.mammon.audiosdk.enums;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
public final enum SAMICoreContextType extends Enum<SAMICoreContextType> {
    private static final /* synthetic */ SAMICoreContextType[] $VALUES = null;
    public static final SAMICoreContextType AIS_DumpConfig = null;
    public static final SAMICoreContextType ConnectPoolAddConnectClient = null;
    public static final SAMICoreContextType ConnectPoolInit = null;
    public static final SAMICoreContextType ConnectPoolRemoveConnectClient = null;
    public static final SAMICoreContextType ConnectPoolShutDown = null;
    public static final SAMICoreContextType FrontierClientClose = null;
    public static final SAMICoreContextType FrontierClientInit = null;
    public static final SAMICoreContextType FrontierClientUpdatePingInterval = null;
    public static final SAMICoreContextType SAMICoreContextType_AbConfig = null;
    public static final SAMICoreContextType SAMICoreContextType_Lic_Auth = null;
    public static final SAMICoreContextType TTNETDynamicInit = null;
    public static final SAMICoreContextType TokenVerifyMixedContext = null;
    public static final SAMICoreContextType TokenVerifyOfflineContext = null;
    public static final SAMICoreContextType TokenVerifyOnlineContext = null;
    public static final SAMICoreContextType WakeupFingerprintFetchAudio = null;
    public static final SAMICoreContextType WakeupFingerprintInit = null;
    public static final SAMICoreContextType WakeupFingerprintSetSidSensitivity = null;
    public static final SAMICoreContextType WakeupFingerprintSetSidThreshold = null;
    public static final SAMICoreContextType WakeupFingerprintSetSidVolume = null;
    public static final SAMICoreContextType WakeupFingerprintUpdateFWEngineVersion = null;
    public static final SAMICoreContextType WakeupFingerprintUpdateModelPath = null;
    public static final SAMICoreContextType WakeupFingerprintUpdateUid = null;
    public static final SAMICoreContextType WebSocketConnectPoolContext = null;
    public static final SAMICoreContextType WebSocketConnectPoolContextShutDown = null;
    public static final HashMap<Integer, SAMICoreContextType> intToEnumMap = null;
    private int value;

    static {
        SAMICoreContextType r100 = new SAMICoreContextType("SAMICoreContextType_Lic_Auth", 0, 0);
        SAMICoreContextType_Lic_Auth = r100;
        SAMICoreContextType r101 = new SAMICoreContextType("TokenVerifyOnlineContext", 1, 1);
        TokenVerifyOnlineContext = r101;
        SAMICoreContextType r102 = new SAMICoreContextType("TokenVerifyOfflineContext", 2, 2);
        TokenVerifyOfflineContext = r102;
        SAMICoreContextType r103 = new SAMICoreContextType("TokenVerifyMixedContext", 3, 3);
        TokenVerifyMixedContext = r103;
        SAMICoreContextType r104 = new SAMICoreContextType("SAMICoreContextType_AbConfig", 4, 4);
        SAMICoreContextType_AbConfig = r104;
        SAMICoreContextType r105 = new SAMICoreContextType("WebSocketConnectPoolContext", 5, 5);
        WebSocketConnectPoolContext = r105;
        SAMICoreContextType r110 = new SAMICoreContextType("WebSocketConnectPoolContextShutDown", 6, 6);
        WebSocketConnectPoolContextShutDown = r110;
        SAMICoreContextType r111 = new SAMICoreContextType("ConnectPoolInit", 7, 7);
        ConnectPoolInit = r111;
        SAMICoreContextType r112 = new SAMICoreContextType("ConnectPoolAddConnectClient", 8, 8);
        ConnectPoolAddConnectClient = r112;
        SAMICoreContextType r113 = new SAMICoreContextType("ConnectPoolRemoveConnectClient", 9, 9);
        ConnectPoolRemoveConnectClient = r113;
        SAMICoreContextType r114 = new SAMICoreContextType("ConnectPoolShutDown", 10, 10);
        ConnectPoolShutDown = r114;
        SAMICoreContextType r115 = new SAMICoreContextType("TTNETDynamicInit", 11, 11);
        TTNETDynamicInit = r115;
        SAMICoreContextType r106 = new SAMICoreContextType("FrontierClientInit", 12, 12);
        FrontierClientInit = r106;
        SAMICoreContextType r107 = new SAMICoreContextType("FrontierClientClose", 13, 13);
        FrontierClientClose = r107;
        SAMICoreContextType r108 = new SAMICoreContextType("FrontierClientUpdatePingInterval", 14, 14);
        FrontierClientUpdatePingInterval = r108;
        SAMICoreContextType r109 = new SAMICoreContextType("WakeupFingerprintInit", 15, 17);
        WakeupFingerprintInit = r109;
        SAMICoreContextType r116 = new SAMICoreContextType("WakeupFingerprintUpdateUid", 16, 18);
        WakeupFingerprintUpdateUid = r116;
        SAMICoreContextType r117 = new SAMICoreContextType("WakeupFingerprintUpdateModelPath", 17, 19);
        WakeupFingerprintUpdateModelPath = r117;
        SAMICoreContextType r118 = new SAMICoreContextType("WakeupFingerprintUpdateFWEngineVersion", 18, 20);
        WakeupFingerprintUpdateFWEngineVersion = r118;
        SAMICoreContextType r119 = new SAMICoreContextType("WakeupFingerprintSetSidThreshold", 19, 21);
        WakeupFingerprintSetSidThreshold = r119;
        SAMICoreContextType r120 = new SAMICoreContextType("WakeupFingerprintFetchAudio", 20, 22);
        WakeupFingerprintFetchAudio = r120;
        SAMICoreContextType r121 = new SAMICoreContextType("AIS_DumpConfig", 21, 23);
        AIS_DumpConfig = r121;
        SAMICoreContextType r122 = new SAMICoreContextType("WakeupFingerprintSetSidSensitivity", 22, 24);
        WakeupFingerprintSetSidSensitivity = r122;
        SAMICoreContextType r123 = new SAMICoreContextType("WakeupFingerprintSetSidVolume", 23, 25);
        WakeupFingerprintSetSidVolume = r123;
        $VALUES = new SAMICoreContextType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123};
        intToEnumMap = new HashMap();
        SAMICoreContextType[] r124 = values();
        int r125 = r124.length;
        int r126 = 0;
    L3:
        if (r126 >= r125) goto L5;
        SAMICoreContextType r127 = r124[r126];
        intToEnumMap.put(Integer.valueOf(r127.getValue()), r127);
        r126 = r126 + 1;
        goto L3
    }

    public static SAMICoreContextType[] values() {
        return (SAMICoreContextType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreContextType fromInt(int r100) {
        return intToEnumMap.get(Integer.valueOf(r100));
    }

    public static SAMICoreContextType valueOf(String r100) {
        return (SAMICoreContextType) a.a(SAMICoreContextType.class, r100);
    }

    private SAMICoreContextType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
