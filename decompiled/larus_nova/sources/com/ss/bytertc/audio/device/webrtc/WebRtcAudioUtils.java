package com.ss.bytertc.audio.device.webrtc;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import tb2.c;

/* JADX INFO: loaded from: classes40.dex */
public final class WebRtcAudioUtils {
    private static final String[] BLACKLISTED_AEC_MODELS = null;
    private static final String[] BLACKLISTED_NS_MODELS = null;
    private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = null;
    private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    private static final String RO_PRODUCT_BRAND = "ro.product.brand";
    private static final String RO_VIVO_OS_BUILD_DISPLAY_ID = "ro.vivo.os.build.display.id";
    private static final String RO_VIVO_OS_PRODUCT_VERSION = "ro.vivo.product.version";
    private static final String TAG = "WebRtcAudioUtils";
    private static int defaultSampleRateHz;
    private static boolean isDefaultSampleRateOverridden;
    private static boolean useWebRtcBasedAcousticEchoCanceler;
    private static boolean useWebRtcBasedNoiseSuppressor;

    public WebRtcAudioUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static String deviceTypeToString(int r100) {
        switch(r100) {
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L43;
            case 4: goto L41;
            case 5: goto L39;
            case 6: goto L37;
            case 7: goto L35;
            case 8: goto L33;
            case 9: goto L31;
            case 10: goto L29;
            case 11: goto L27;
            case 12: goto L25;
            case 13: goto L23;
            case 14: goto L21;
            case 15: goto L19;
            case 16: goto L17;
            case 17: goto L15;
            case 18: goto L13;
            case 19: goto L11;
            case 20: goto L9;
            case 21: goto L7;
            case 22: goto L5;
            default: goto L3;
        };
    L3:
        return "TYPE_UNKNOWN";
    L5:
        return "TYPE_USB_HEADSET";
    L7:
        return "TYPE_BUS";
    L9:
        return "TYPE_IP";
    L11:
        return "TYPE_AUX_LINE";
    L13:
        return "TYPE_TELEPHONY";
    L15:
        return "TYPE_TV_TUNER";
    L17:
        return "TYPE_FM_TUNER";
    L19:
        return "TYPE_BUILTIN_MIC";
    L21:
        return "TYPE_FM";
    L23:
        return "TYPE_DOCK";
    L25:
        return "TYPE_USB_ACCESSORY";
    L27:
        return "TYPE_USB_DEVICE";
    L29:
        return "TYPE_HDMI_ARC";
    L31:
        return "TYPE_HDMI";
    L33:
        return "TYPE_BLUETOOTH_A2DP";
    L35:
        return "TYPE_BLUETOOTH_SCO";
    L37:
        return "TYPE_LINE_DIGITAL";
    L39:
        return "TYPE_LINE_ANALOG";
    L41:
        return "TYPE_WIRED_HEADPHONES";
    L43:
        return "TYPE_WIRED_HEADSET";
    L45:
        return "TYPE_BUILTIN_SPEAKER";
    L47:
        return "TYPE_BUILTIN_EARPIECE";
    }

    public static boolean isAutomaticGainControlSupported() {
        return false;
    }

    public static String modeToString(int r100) {
        if (r100 != 0) goto L4;
        return "MODE_NORMAL";
    L4:
        if (r100 != 1) goto L6;
        return "MODE_RINGTONE";
    L6:
        if (r100 != 2) goto L8;
        return "MODE_IN_CALL";
    L8:
        if (r100 == 3) goto L11;
        return "MODE_INVALID";
    L11:
        return "MODE_IN_COMMUNICATION";
    }

    private static String streamTypeToString(int r100) {
        if (r100 != 0) goto L4;
        return "STREAM_VOICE_CALL";
    L4:
        if (r100 != 1) goto L6;
        return "STREAM_SYSTEM";
    L6:
        if (r100 != 2) goto L8;
        return "STREAM_RING";
    L8:
        if (r100 != 3) goto L10;
        return "STREAM_MUSIC";
    L10:
        if (r100 != 4) goto L12;
        return "STREAM_ALARM";
    L12:
        if (r100 == 5) goto L15;
        return "STREAM_INVALID";
    L15:
        return "STREAM_NOTIFICATION";
    }

    static {
        BLACKLISTED_OPEN_SL_ES_MODELS = new String[]{"SM-G9650", "SM-G9750", "SM-N9600", "V1962A"};
        BLACKLISTED_AEC_MODELS = new String[0];
        BLACKLISTED_NS_MODELS = new String[0];
        defaultSampleRateHz = 16000;
        useWebRtcBasedAcousticEchoCanceler = false;
        useWebRtcBasedNoiseSuppressor = false;
    }

    public static boolean deviceIsBlacklistedForOpenSLESUsage() {
        return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
    }

    public static List<String> getBlackListedModelsForAecUsage() {
        return Arrays.asList(BLACKLISTED_AEC_MODELS);
    }

    public static List<String> getBlackListedModelsForNsUsage() {
        return Arrays.asList(BLACKLISTED_NS_MODELS);
    }

    public static synchronized int getDefaultSampleRateHz() {
        monitor-enter(WebRtcAudioUtils.class);
        int r100 = defaultSampleRateHz;     // Catch: Throwable -> L7
        monitor-exit(WebRtcAudioUtils.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getThreadInfo() {
        return "@[name=" + ThreadMethodProxy.currentThread().getName() + ", id=" + ThreadMethodProxy.currentThread().getId() + "]";
    }

    public static synchronized boolean isDefaultSampleRateOverridden() {
        monitor-enter(WebRtcAudioUtils.class);
        boolean r100 = isDefaultSampleRateOverridden;     // Catch: Throwable -> L7
        monitor-exit(WebRtcAudioUtils.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean runningOnEmulator() {
        if (Build.HARDWARE.equals("goldfish") == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.BRAND.startsWith("generic_") == false) goto L7;
        return true;
    }

    public static synchronized boolean useWebRtcBasedAcousticEchoCanceler() {
        monitor-enter(WebRtcAudioUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (useWebRtcBasedAcousticEchoCanceler == false) goto L7;
        RXLogging.w(TAG, "Overriding default behavior; now using WebRTC AEC!");     // Catch: Throwable -> L10
    L7:
        boolean r100 = useWebRtcBasedAcousticEchoCanceler;     // Catch: Throwable -> L10
        monitor-exit(WebRtcAudioUtils.class);
        return r100;
    }

    public static synchronized boolean useWebRtcBasedAutomaticGainControl() {
        monitor-enter(WebRtcAudioUtils.class);
        monitor-exit(WebRtcAudioUtils.class);
        return true;
    }

    public static synchronized boolean useWebRtcBasedNoiseSuppressor() {
        monitor-enter(WebRtcAudioUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (useWebRtcBasedNoiseSuppressor == false) goto L7;
        RXLogging.w(TAG, "Overriding default behavior; now using WebRTC NS!");     // Catch: Throwable -> L10
    L7:
        boolean r100 = useWebRtcBasedNoiseSuppressor;     // Catch: Throwable -> L10
        monitor-exit(WebRtcAudioUtils.class);
        return r100;
    }

    public static String getProductBrand() {
        return getSystemProperty("ro.product.brand");
    }

    private static String getVivoRomVersion() {
        return getSystemProperty(RO_VIVO_OS_BUILD_DISPLAY_ID) + "_" + getSystemProperty(RO_VIVO_OS_PRODUCT_VERSION);
    }

    public static boolean hasMicrophone() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    public static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    public static boolean isPermissionGranted() {
        if (ContextCompat.checkSelfPermission(ContextUtils.getApplicationContext(), "android.permission.RECORD_AUDIO") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_bytertc_audio_device_webrtc_WebRtcAudioUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static String getRomVersion(String r100) {
        if (r100.toLowerCase().equals(DimLocationCheckUtil.VIVO) == true) goto L5;
        return "";
    L5:
        return getVivoRomVersion();
    }

    private static String getSystemProperty(String r100) {
        Class r101 = INVOKESTATIC_com_ss_bytertc_audio_device_webrtc_WebRtcAudioUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L5
        return (String) r101.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r101, new Object[]{r100, ""});
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private static boolean isVolumeFixed(AudioManager r100) {
        return r100.isVolumeFixed();
    }

    public static void logAudioState(String r100) {
        AudioManager r101 = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        if (r101 == null) goto L6;
        logAudioStateBasic(r100, r101);
        return;
    }

    public static synchronized void setDefaultSampleRateHz(int r100) {
        monitor-enter(WebRtcAudioUtils.class);
        isDefaultSampleRateOverridden = true;     // Catch: Throwable -> L8
        defaultSampleRateHz = r100;     // Catch: Throwable -> L8
        monitor-exit(WebRtcAudioUtils.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void setWebRtcBasedAcousticEchoCanceler(boolean r100) {
        monitor-enter(WebRtcAudioUtils.class);
        useWebRtcBasedAcousticEchoCanceler = r100;     // Catch: Throwable -> L7
        monitor-exit(WebRtcAudioUtils.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setWebRtcBasedAutomaticGainControl(boolean r100) {
        monitor-enter(WebRtcAudioUtils.class);
        RXLogging.w(TAG, "setWebRtcBasedAutomaticGainControl() is deprecated");     // Catch: Throwable -> L7
        monitor-exit(WebRtcAudioUtils.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setWebRtcBasedNoiseSuppressor(boolean r100) {
        monitor-enter(WebRtcAudioUtils.class);
        useWebRtcBasedNoiseSuppressor = r100;     // Catch: Throwable -> L7
        monitor-exit(WebRtcAudioUtils.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void logAudioDeviceInfo(String r100, AudioManager r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        AudioDeviceInfo[] r102 = r101.getDevices(3);
        if (r102.length != 0) goto L8;
        return;
    L8:
        RXLogging.i(r100, "Audio Devices: ");
        int r103 = r102.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L24;
        AudioDeviceInfo r105 = r102[r104];
        StringBuilder r106 = new StringBuilder(c.DEFAULT_TEXT);
        r106.append(deviceTypeToString(r105.getType()));
        if (r105.isSource() == false) goto L13;
        String r107 = "(in): ";
    L14:
        r106.append(r107);
        if (r105.getChannelCounts().length <= 0) goto L18;
        r106.append("channels=");
        r106.append(Arrays.toString(r105.getChannelCounts()));
        r106.append(", ");
    L18:
        if (r105.getEncodings().length <= 0) goto L21;
        r106.append("encodings=");
        r106.append(Arrays.toString(r105.getEncodings()));
        r106.append(", ");
    L21:
        if (r105.getSampleRates().length <= 0) goto L23;
        r106.append("sample rates=");
        r106.append(Arrays.toString(r105.getSampleRates()));
        r106.append(", ");
    L23:
        r106.append("id=");
        r106.append(r105.getId());
        RXLogging.i(r100, r106.toString());
        r104 = r104 + 1;
        goto L9
    L13:
        r107 = "(out): ";
        goto L14
    }

    private static void logAudioStateBasic(String r100, AudioManager r101) {
        RXLogging.i(r100, "Audio State: audio mode: " + modeToString(r101.getMode()) + ", has mic: " + hasMicrophone() + ", mic muted: " + r101.isMicrophoneMute() + ", music active: " + r101.isMusicActive() + ", speakerphone: " + r101.isSpeakerphoneOn() + ", BT SCO: " + r101.isBluetoothScoOn());
    }

    private static void logAudioStateVolume(String r100, AudioManager r101) {
        int[] r102 = {0, 3, 2, 4, 5, 1};
        RXLogging.i(r100, "Audio State: ");
        boolean r103 = isVolumeFixed(r101);
        RXLogging.i(r100, "  fixed volume=" + r103);
        if (r103 == true) goto L7;
        int r104 = 0;
    L5:
        if (r104 >= 6) goto L9;
        int r105 = r102[r104];
        StringBuilder r106 = new StringBuilder();
        r106.append(c.DEFAULT_TEXT + streamTypeToString(r105) + ": ");
        r106.append("volume=");
        r106.append(r101.getStreamVolume(r105));
        r106.append(", max=");
        r106.append(r101.getStreamMaxVolume(r105));
        logIsStreamMute(r100, r101, r105, r106);
        RXLogging.i(r100, r106.toString());
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }

    private static void logIsStreamMute(String r100, AudioManager r101, int r102, StringBuilder r103) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r103.append(", muted=");
        r103.append(r101.isStreamMute(r102));
        return;
    }
}
