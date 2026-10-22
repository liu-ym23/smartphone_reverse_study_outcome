package com.ss.ttm.player;

import android.media.MediaCodecInfo;
import android.os.Build;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class MediaCodecHelper {
    private static final int LEVEL_HIGH = 2;
    private static final int LEVEL_LITE = 0;
    private static final int LEVEL_MIDIUM = 1;
    private static final String TAG = "MediaCodecHelper";
    private static final List<String> amlogicDecoderPrefixes = null;
    private static final List<String> exynosDecoderPrefixes = null;
    private static final List<String> kirinDecoderPrefixes = null;
    private static final List<String> qualcommDecoderPrefixes = null;

    public MediaCodecHelper() {
    }

    static {
        LinkedList r100 = new LinkedList();
        qualcommDecoderPrefixes = r100;
        r100.add("omx.qcom");
        r100.add("c2.qti");
        LinkedList r101 = new LinkedList();
        kirinDecoderPrefixes = r101;
        r101.add("omx.hisi");
        r101.add("c2.hisi");
        LinkedList r102 = new LinkedList();
        exynosDecoderPrefixes = r102;
        r102.add("omx.exynos");
        r102.add("c2.exynos");
        LinkedList r103 = new LinkedList();
        amlogicDecoderPrefixes = r103;
        r103.add("omx.amlogic");
        r103.add("c2.amlogic");
    }

    public static void disableAllowFrameDrop(AJMediaFormat r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 31) goto L9;
        r100.setInteger("allow-frame-drop", 0);
        return;
    }

    public static void setMaxOperatingRate(AJMediaFormat r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        r100.setInteger("operating-rate", 32767);
        return;
    }

    public static void debugEffect(AJMediaFormat r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDecoderInList(qualcommDecoderPrefixes, r101) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r100.setInteger("vendor.qti-ext-vpp-demo.process-percent", 50);
        r100.toString();
        return;
    }

    public static boolean decoderSupportsAndroidRLowLatency(MediaCodecInfo r100, String r101) {
        if (Build.VERSION.SDK_INT < 30) goto L14;
        if (r100.getCapabilitiesForType(r101).isFeatureSupported("low-latency") == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L14:
        return false;
    }

    private static boolean isDecoderInList(List<String> r100, String r101) {
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        if (r101.length() < r103.length()) goto L4;
        if (r101.substring(0, r103.length()).equalsIgnoreCase(r103) == false) goto L4;
        return true;
    L11:
        return false;
    }

    public static void setHisiLowLatency(AJMediaFormat r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDecoderInList(kirinDecoderPrefixes, r101) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r100.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
        r100.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
        return;
    }

    public static void setImportance(AJMediaFormat r100, int r101) {
        if (r100 == null) goto L9;
        if (r101 >= 0) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 35) goto L11;
        r100.setInteger("importance", r101);
        return;
    L11:
        return;
    }

    public static void setOperatingRateBeforeOpen(AJMediaFormat r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        if (r101 < 0) goto L11;
        r100.setInteger("operating-rate", r101);
        return;
    L11:
        return;
    }

    public static void setPriority(AJMediaFormat r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        if (r101 >= 0) goto L7;
        return;
    L7:
        if (r101 > 1) goto L14;
        r100.setInteger("priority", r101);
        return;
    L14:
        return;
    }

    public static void setQcomOrder(AJMediaFormat r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDecoderInList(qualcommDecoderPrefixes, r101) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r100.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
        return;
    }

    public static void setQcomSliceDeliveryMode(AJMediaFormat r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDecoderInList(qualcommDecoderPrefixes, r101) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r100.setFeatureEnabled("vendor.qti-ext-dec-slice-delivery-mode.value", true);
        return;
    }

    public static void setQcomTimestampReorder(AJMediaFormat r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDecoderInList(qualcommDecoderPrefixes, r101) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r100.setFeatureEnabled("vendor.qti-ext-dec-timestamp-reorder.value", true);
        return;
    }

    public static void setHisiFrequence(AJMediaFormat r100, int r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDecoderInList(kirinDecoderPrefixes, r102) == false) goto L14;
        if (r101 >= 0) goto L7;
        return;
    L7:
        if (r101 <= 2) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        r100.setInteger("vendor.hisi-ext-frequence-request-video-dec.video-scene-for-frequence-req", r101);
        return;
    L17:
        return;
    }

    public static void setLowLatency(AJMediaFormat r100, MediaCodecInfo r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setInteger("low-latency", 1);
        if ((r102 & 1) <= 0) goto L10;
        if (decoderSupportsAndroidRLowLatency(r101, r100.getString("mime")) == false) goto L10;
        return;
    L10:
        if ((r102 & 2) <= 0) goto L15;
        if (Build.VERSION.SDK_INT <= 23) goto L15;
        r100.setInteger("vdec-lowlatency", 1);
    L15:
        if ((r102 & 4) > 0) goto L17;
        return;
    L17:
        if (Build.VERSION.SDK_INT >= 26) goto L19;
        return;
    L19:
        if (isDecoderInList(qualcommDecoderPrefixes, r101.getName()) == false) goto L22;
        r100.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
        return;
    L22:
        if (isDecoderInList(exynosDecoderPrefixes, r101.getName()) == false) goto L25;
        r100.setInteger("vendor.rtc-ext-dec-low-latency.enable", 1);
        return;
    L25:
        if (isDecoderInList(amlogicDecoderPrefixes, r101.getName()) == false) goto L32;
        r100.setInteger("vendor.low-latency.enable", 1);
        return;
    }

    public static void setQcomCpuAffinityMask(AJMediaFormat r100, int r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDecoderInList(qualcommDecoderPrefixes, r102) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r100.setInteger("vendor.qti-ext-cpu-affinity-set-mask.value", r101);
        return;
    }

    public static void setQcomEarlyNotifyValue(AJMediaFormat r100, int r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDecoderInList(qualcommDecoderPrefixes, r102) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r100.setInteger("vendor.qti-ext-dec-early-notify.value", r101);
        return;
    }

    public static void setupVpp(AJMediaFormat r100, int r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (isDecoderInList(qualcommDecoderPrefixes, r102) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L24;
        r100.setString("vendor.qti-ext-vpp.mode", "HQV_MODE_MANUAL");
        if (r101 != 0) goto L11;
    L16:
        if (r101 != 0) goto L18;
        int r103 = 10;
    L19:
        r100.setInteger("vendor.qti-ext-vpp-cade.cade-level", r103);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-gain", 65);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-offset", 60);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-str", 50);
    L20:
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-brightness-low", 20);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-brightness-high", 20);
        return;
    L18:
        r103 = 20;
        goto L19
    L11:
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L15;
        return;
    L15:
        r100.setInteger("vendor.qti-ext-vpp-cade.cade-level", 15);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-gain", 70);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-sat-offset", 70);
        r100.setInteger("vendor.qti-ext-vpp-aie.ltm-ace-str", 50);
        goto L20
    }
}
