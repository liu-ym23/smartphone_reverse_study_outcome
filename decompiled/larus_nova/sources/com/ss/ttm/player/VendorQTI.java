package com.ss.ttm.player;

/* JADX INFO: loaded from: classes40.dex */
public class VendorQTI {
    private static final int LEVEL_HIGH = 2;
    private static final int LEVEL_LITE = 0;
    private static final int LEVEL_MIDIUM = 1;
    private static final String TAG = "VendorQTI";

    public VendorQTI() {
    }

    public static void debugEffect(AJMediaFormat r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setInteger("vendor.qti-ext-vpp-demo.process-percent", 50);
        r100.toString();
    }

    public static void enableLowLatency(AJMediaFormat r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
    }

    public static void setupVpp(AJMediaFormat r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setString("vendor.qti-ext-vpp.mode", "HQV_MODE_MANUAL");
        if (r101 != 0) goto L7;
    L12:
        if (r101 != 0) goto L14;
        int r102 = 10;
    L15:
        r100.setInteger("vendor.qti-ext-vpp-cade.cade-level", r102);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-gain", 65);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-offset", 60);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-str", 50);
    L16:
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-brightness-low", 20);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-brightness-high", 20);
        return;
    L14:
        r102 = 20;
        goto L15
    L7:
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L11;
        return;
    L11:
        r100.setInteger("vendor.qti-ext-vpp-cade.cade-level", 15);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-gain", 70);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-offset", 70);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-str", 50);
        goto L16
    }
}
