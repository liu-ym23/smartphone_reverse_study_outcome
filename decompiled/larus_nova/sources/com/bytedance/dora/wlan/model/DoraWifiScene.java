package com.bytedance.dora.wlan.model;

import com.larus.dora.api.model.FlowDoraWifiScene;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum DoraWifiScene extends Enum<DoraWifiScene> {
    private static final /* synthetic */ DoraWifiScene[] $VALUES = null;
    public static final DoraWifiScene ALBUM = null;
    public static final DoraWifiScene ALBUM_SILENT = null;
    public static final DoraWifiScene LOG_FROM_DEBUG = null;
    public static final DoraWifiScene LOG_FROM_FEEDBACK = null;
    public static final DoraWifiScene OTA = null;
    public static final DoraWifiScene OTHER = null;
    public static final DoraWifiScene RTC_P2P = null;
    public static final DoraWifiScene TEST = null;
    public static final DoraWifiScene VUI = null;

    static {
        DoraWifiScene r100 = new DoraWifiScene(FlowDoraWifiScene.VUI, 0);
        VUI = r100;
        DoraWifiScene r101 = new DoraWifiScene(FlowDoraWifiScene.OTA, 1);
        OTA = r101;
        DoraWifiScene r102 = new DoraWifiScene(FlowDoraWifiScene.ALBUM, 2);
        ALBUM = r102;
        DoraWifiScene r103 = new DoraWifiScene(FlowDoraWifiScene.ALBUM_SILENT, 3);
        ALBUM_SILENT = r103;
        DoraWifiScene r104 = new DoraWifiScene(FlowDoraWifiScene.LOG_FROM_FEEDBACK, 4);
        LOG_FROM_FEEDBACK = r104;
        DoraWifiScene r105 = new DoraWifiScene(FlowDoraWifiScene.LOG_FROM_DEBUG, 5);
        LOG_FROM_DEBUG = r105;
        DoraWifiScene r110 = new DoraWifiScene(FlowDoraWifiScene.TEST, 6);
        TEST = r110;
        DoraWifiScene r111 = new DoraWifiScene("RTC_P2P", 7);
        RTC_P2P = r111;
        DoraWifiScene r112 = new DoraWifiScene(FlowDoraWifiScene.OTHER, 8);
        OTHER = r112;
        $VALUES = new DoraWifiScene[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static DoraWifiScene[] values() {
        return (DoraWifiScene[]) $VALUES.clone();
    }

    public static DoraWifiScene valueOf(String r100) {
        return (DoraWifiScene) a.a(DoraWifiScene.class, r100);
    }

    private DoraWifiScene(String r100, int r101) {
        super(r100, r101);
    }
}
