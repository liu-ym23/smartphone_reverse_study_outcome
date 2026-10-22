package com.ss.bytertc.audio.device.webrtc;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.realx.base.RXLogging;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes40.dex */
public class WebRtcAudioEffects {
    private static final boolean DEBUG = false;
    private static final String TAG = "WebRtcAudioEffects";
    private static Map<String, List<String>> audioEffectBlackList;
    private static AudioEffect.Descriptor[] cachedEffects;

    /* JADX INFO: renamed from: aec, reason: collision with root package name */
    private AcousticEchoCanceler f456087aec;

    /* JADX INFO: renamed from: ns, reason: collision with root package name */
    private NoiseSuppressor f456088ns;
    private boolean shouldEnableAec;
    private boolean shouldEnableNs;

    static {
        audioEffectBlackList = new HashMap();
    }

    public static boolean IsAudioEffectSupported() {
        if (audioEffectBlackList.isEmpty() == false) goto L5;
        initAudioEffectBlackList();
    L5:
        String r100 = WebRtcAudioUtils.getProductBrand();
        if (r100.isEmpty() == false) goto L9;
        return true;
    L9:
        if (audioEffectBlackList.containsKey(r100) == true) goto L11;
        return true;
    L11:
        String r101 = WebRtcAudioUtils.getRomVersion(r100);
        boolean r102 = audioEffectBlackList.get(r100).contains(r101);
        RXLogging.w(TAG, "IsAudioEffectSupported, " + r100 + ", " + r101 + ", in black list = " + r102);
        return !r102;
    }

    public static WebRtcAudioEffects create() {
        return new WebRtcAudioEffects();
    }

    private static AudioEffect.Descriptor[] getAvailableEffects() {
        AudioEffect.Descriptor[] r100 = cachedEffects;
        if (r100 == null) goto L10;
        return r100;
    L10:
        AudioEffect.Descriptor[] r101 = AudioEffect.queryEffects();     // Catch: Exception -> L7
        cachedEffects = r101;     // Catch: Exception -> L7
        return r101;
    L7:
        e = move-exception;
        e.printStackTrace();
        return cachedEffects;
    }

    private static void initAudioEffectBlackList() {
        audioEffectBlackList.put(DimLocationCheckUtil.VIVO, new ArrayList());
        audioEffectBlackList.get(DimLocationCheckUtil.VIVO).add("Funtouch OS_3.1_PD1616_D_7.17.5");
    }

    private static boolean isAcousticEchoCancelerEffectAvailable() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_AEC);
    }

    private static boolean isAcousticEchoCancelerExcludedByUUID() {
        UUID r100 = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");     // Catch: Exception -> L4
    L6:
        AudioEffect.Descriptor[] r101 = getAvailableEffects();
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L16;
        AudioEffect.Descriptor r104 = r101[r103];
        if (r104.type.equals(AudioEffect.EFFECT_TYPE_AEC) == false) goto L15;
        if (r100 == null) goto L15;
        if (r104.uuid.equals(r100) == false) goto L15;
        return true;
    L15:
        r103 = r103 + 1;
        goto L7
    L16:
        return false;
    L4:
        e = move-exception;
        e.printStackTrace();
        r100 = null;
        goto L6
    }

    private static boolean isNoiseSuppressorEffectAvailable() {
        return isEffectTypeAvailable(AudioEffect.EFFECT_TYPE_NS);
    }

    private static boolean isNoiseSuppressorExcludedByUUID() {
        UUID r100 = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");     // Catch: Exception -> L4
    L6:
        AudioEffect.Descriptor[] r101 = getAvailableEffects();
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L16;
        AudioEffect.Descriptor r104 = r101[r103];
        if (r104.type.equals(AudioEffect.EFFECT_TYPE_NS) == false) goto L15;
        if (r100 == null) goto L15;
        if (r104.uuid.equals(r100) == false) goto L15;
        return true;
    L15:
        r103 = r103 + 1;
        goto L7
    L16:
        return false;
    L4:
        e = move-exception;
        e.printStackTrace();
        r100 = null;
        goto L6
    }

    public void release() {
        RXLogging.i(TAG, "release");
        AcousticEchoCanceler r100 = this.f456087aec;     // Catch: Exception -> L10
        if (r100 == null) goto L6;
        r100.release();     // Catch: Exception -> L10
        this.f456087aec = null;     // Catch: Exception -> L10
    L6:
        NoiseSuppressor r101 = this.f456088ns;     // Catch: Exception -> L10
        if (r101 == null) goto L15;
        r101.release();     // Catch: Exception -> L10
        this.f456088ns = null;     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        this.f456087aec = null;
        this.f456088ns = null;
    }

    private WebRtcAudioEffects() {
        RXLogging.i(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }

    public static boolean canUseAcousticEchoCanceler() {
        if (isAcousticEchoCancelerSupported() == true) goto L5;
    L9:
        boolean r100 = false;
    L10:
        RXLogging.i(TAG, "canUseAcousticEchoCanceler: " + r100);
        return r100;
    L5:
        if (WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler() == true) goto L9;
        if (isAcousticEchoCancelerBlacklisted() == true) goto L9;
        r100 = true;
        goto L10
    }

    public static boolean canUseNoiseSuppressor() {
        if (isNoiseSuppressorSupported() == true) goto L5;
    L9:
        boolean r100 = false;
    L10:
        RXLogging.i(TAG, "canUseNoiseSuppressor: " + r100);
        return r100;
    L5:
        if (WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor() == true) goto L9;
        if (isNoiseSuppressorBlacklisted() == true) goto L9;
        r100 = true;
        goto L10
    }

    public static boolean isAcousticEchoCancelerBlacklisted() {
        List<String> r100 = WebRtcAudioUtils.getBlackListedModelsForAecUsage();
        String r101 = Build.MODEL;
        boolean r102 = r100.contains(r101);
        if (r102 == false) goto L5;
        RXLogging.w(TAG, r101 + " is blacklisted for HW AEC usage!");
    L5:
        return r102;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return isAcousticEchoCancelerEffectAvailable();
    }

    public static boolean isNoiseSuppressorBlacklisted() {
        List<String> r100 = WebRtcAudioUtils.getBlackListedModelsForNsUsage();
        String r101 = Build.MODEL;
        boolean r102 = r100.contains(r101);
        if (r102 == false) goto L5;
        RXLogging.w(TAG, r101 + " is blacklisted for HW NS usage!");
    L5:
        return r102;
    }

    public static boolean isNoiseSuppressorSupported() {
        return isNoiseSuppressorEffectAvailable();
    }

    private static void assertTrue(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new AssertionError("Expected condition to be true");
    }

    private boolean effectTypeIsVoIP(UUID r100) {
        if (AudioEffect.EFFECT_TYPE_AEC.equals(r100) == false) goto L7;
        if (isAcousticEchoCancelerSupported() == false) goto L7;
    L10:
        return true;
    L7:
        if (AudioEffect.EFFECT_TYPE_NS.equals(r100) == true) goto L9;
    L11:
        return false;
    L9:
        if (isNoiseSuppressorSupported() == false) goto L11;
        goto L10
    }

    private static boolean isEffectTypeAvailable(UUID r100) {
        AudioEffect.Descriptor[] r101 = getAvailableEffects();
        if (r101 != null) goto L5;
        return false;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r101[r103].type.equals(r100) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public void enable(int r110) {
        RXLogging.i(TAG, "enable(audioSession=" + r110 + ")");
        boolean r100 = true;
        String r101 = "enabled";
        boolean r102 = false;
        if (isAcousticEchoCancelerSupported() == false) goto L43;
    L26:
        e = e;
        boolean r103 = false;
        boolean r111 = false;
    L28:
        e.printStackTrace();
        boolean r104 = r103;
        boolean r105 = r111;
    L29:
        boolean r112 = false;
    L31:
        if (this.f456087aec == null) goto L41;
        StringBuilder r113 = new StringBuilder("AcousticEchoCanceler: was ");
        if (r104 == false) goto L35;
        String r106 = "enabled";
    L36:
        r113.append(r106);
        r113.append(", enable: ");
        r113.append(r105);
        r113.append(", is now: ");
        if (r112 == false) goto L39;
        String r107 = "enabled";
    L40:
        r113.append(r107);
        RXLogging.i(TAG, r113.toString());
        goto L43
    L39:
        r107 = "disabled";
        goto L40
    L35:
        r106 = "disabled";
        goto L36
    L41:
        RXLogging.e(TAG, "Failed to create the AcousticEchoCanceler instance");
        goto L43
    L5:
        if (this.f456087aec == null) goto L7;
        RXLogging.e(TAG, "Release previous aec instance");     // Catch: Exception -> L26
        this.f456087aec.release();     // Catch: Exception -> L26
        this.f456087aec = null;     // Catch: Exception -> L26
    L7:
        AcousticEchoCanceler r108 = AcousticEchoCanceler.create(r110);     // Catch: Exception -> L26
        this.f456087aec = r108;     // Catch: Exception -> L26
        if (r108 == null) goto L25;
        r104 = r108.getEnabled();     // Catch: Exception -> L26
    L23:
        e = move-exception;
        r111 = false;
        r103 = r104;
        e = e;
        goto L28
    L11:
        if (this.shouldEnableAec == false) goto L15;
        if (canUseAcousticEchoCanceler() == false) goto L15;
        r105 = true;
    L89:
    L21:
        e = move-exception;
        boolean r114 = r105;
        r103 = r104;
        e = e;
        r111 = r114;
        goto L28
    L17:
        if (this.f456087aec.setEnabled(r105) == 0) goto L19;
        RXLogging.e(TAG, "Failed to set the AcousticEchoCanceler state");     // Catch: Exception -> L21
    L19:
        r112 = this.f456087aec.getEnabled();     // Catch: Exception -> L21
    L15:
        r105 = false;
        goto L89
    L25:
        r104 = false;
        r105 = false;
    L43:
        if (isNoiseSuppressorSupported() == false) goto L95;
    L67:
        e = e;
        boolean r109 = false;
        r100 = false;
    L69:
        e.printStackTrace();
        r102 = r109;
        boolean r115 = false;
    L71:
        if (this.f456088ns == null) goto L81;
        StringBuilder r116 = new StringBuilder("NoiseSuppressor: was ");
        if (r102 == false) goto L75;
        String r117 = "enabled";
    L76:
        r116.append(r117);
        r116.append(", enable: ");
        r116.append(r100);
        r116.append(", is now: ");
        if (r115 == true) goto L80;
        r101 = "disabled";
    L80:
        r116.append(r101);
        RXLogging.i(TAG, r116.toString());
        return;
    L75:
        r117 = "disabled";
        goto L76
    L81:
        RXLogging.e(TAG, "Failed to create the NoiseSuppressor instance");
        return;
    L45:
        if (this.f456088ns == null) goto L47;
        RXLogging.e(TAG, "Release previous ns instance");     // Catch: Exception -> L67
        this.f456088ns.release();     // Catch: Exception -> L67
        this.f456088ns = null;     // Catch: Exception -> L67
    L47:
        NoiseSuppressor r118 = NoiseSuppressor.create(r110);     // Catch: Exception -> L67
        this.f456088ns = r118;     // Catch: Exception -> L67
        if (r118 == null) goto L66;
        boolean r119 = r118.getEnabled();     // Catch: Exception -> L67
    L63:
        e = e;
        r100 = false;
    L65:
        Exception r120 = e;
        r109 = r119;
        e = r120;
        goto L69
    L51:
        if (this.shouldEnableNs == false) goto L55;
        if (canUseNoiseSuppressor() == false) goto L55;
    L93:
    L61:
        e = e;
        goto L65
    L57:
        if (this.f456088ns.setEnabled(r100) == 0) goto L59;
        RXLogging.e(TAG, "Failed to set the NoiseSuppressor state");     // Catch: Exception -> L61
    L59:
        r102 = r119;
        r115 = this.f456088ns.getEnabled();     // Catch: Exception -> L61
    L55:
        r100 = false;
        goto L93
    L66:
        r115 = false;
        r100 = false;
        goto L71
    }

    public boolean setAEC(boolean r100) {
        RXLogging.i(TAG, "setAEC(" + r100 + ")");
        if (canUseAcousticEchoCanceler() == true) goto L7;
        RXLogging.w(TAG, "Platform AEC is not supported");
        this.shouldEnableAec = false;
        return false;
    L7:
        if (this.f456087aec != null) goto L9;
    L12:
        this.shouldEnableAec = r100;
        return true;
    L9:
        if (r100 == this.shouldEnableAec) goto L12;
        RXLogging.e(TAG, "Platform AEC state can't be modified while recording");
        return false;
    }

    public boolean setNS(boolean r100) {
        RXLogging.i(TAG, "setNS(" + r100 + ")");
        if (canUseNoiseSuppressor() == true) goto L7;
        RXLogging.w(TAG, "Platform NS is not supported");
        this.shouldEnableNs = false;
        return false;
    L7:
        if (this.f456088ns != null) goto L9;
    L12:
        this.shouldEnableNs = r100;
        return true;
    L9:
        if (r100 == this.shouldEnableNs) goto L12;
        RXLogging.e(TAG, "Platform NS state can't be modified while recording");
        return false;
    }
}
