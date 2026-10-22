package com.obric.assistant.reporter.utils;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.WakeupSoundEffectSettings;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.WindowLayoutInfo;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.t1;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ObricLaunchReportManager {
    public static final String A = null;
    public static final String B = null;
    public static final String C = null;
    public static final String D = null;
    public static final String E = null;
    public static final String F = null;
    public static final String G = null;
    public static final String H = null;
    public static final String I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final String f391416J = null;
    public static final String K = null;
    public static final String L = null;
    public static final String M = null;
    public static final String N = null;
    public static final String O = null;
    public static final String P = null;
    public static final CoroutineScope Q = null;
    public static final Map<String, JSONObject> R = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricLaunchReportManager f391417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f391418b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f391419c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f391420d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f391421e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f391422f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f391423g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f391424h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f391425i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f391426j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f391427k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f391428l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f391429m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f391430n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f391431o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f391432p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f391433q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f391434r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f391435s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f391436t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f391437u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f391438v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f391439w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f391440x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f391441y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f391442z = null;

    public ObricLaunchReportManager() {
    }

    static {
        f391417a = new ObricLaunchReportManager();
        f391418b = "obric_assistant_launch";
        f391419c = "obric_assistant_terminate";
        f391420d = WindowEvent.Params.LAUNCH_METHOD;
        f391421e = WindowEvent.Params.LAUNCH_POSITION_LEVEL1;
        f391422f = WindowEvent.Params.LAUNCH_POSITION_LEVEL2;
        f391423g = WindowEvent.Params.LAUNCH_SERVICE;
        f391424h = WindowEvent.Params.LAUNCH_WAKEUP;
        f391425i = "desktop_icon_settings";
        f391426j = "background_reading_settings";
        f391427k = "semantic_screen_qa_settings";
        f391428l = "voice_wakeup_settings";
        f391429m = "speak_nearby_settings";
        f391430n = "use_doubao_when_locked";
        f391431o = "oauto_settings";
        f391432p = "external_device";
        f391433q = "wifi_auto_download_settings";
        f391434r = "ai_fingerprint_settings";
        f391435s = "screen_off_aibutton_settings";
        f391436t = "aibutton_sensitivity_options";
        f391437u = "click_ai_button_options";
        f391438v = "doubleclick_ai_button_options";
        f391439w = "enhanced_intent";
        f391440x = "enhanced_voiceinput";
        f391441y = "operate_app_use_memory";
        f391442z = "operate_app_use_clipboard";
        A = "omni_app_custom_permission";
        B = "omni_system_settings_modification";
        C = "omni_install_app";
        D = "omni_risk_preference_setting";
        E = "lockscreen_chat_onlineqa";
        F = "lockscreen_read_chat_history";
        G = "lockscreen_simple_instructions";
        H = "lockscreen_read_and_modify_local_data";
        I = "lockscreen_operate_mobile_phone";
        f391416J = "always_on_wakeup_switch";
        K = "audio_collect_switch";
        L = "able_to_record_enhanced_voiceprint";
        M = "enhanced_voiceprint_record";
        N = "launch_system_os_did";
        O = "long_press_power_key_settings";
        P = "default_assistant";
        Q = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        R = Collections.synchronizedMap(new ObricLaunchReportManager$cachedSessionParams$1());
    }

    @WakeupSoundEffectSettings
    public static String d(String r100) {
        if (r100 == null) goto L19;
        int r101 = r100.hashCode();
        if (r101 != 109549001) goto L7;
        String r102 = "smart";
        if (r100.equals("smart") == true) goto L18;
        return WakeupSoundEffectSettings.CLASSIC;
    L18:
        return r102;
    L7:
        if (r101 != 853620882) goto L9;
        r100.equals(WakeupSoundEffectSettings.CLASSIC);
        return WakeupSoundEffectSettings.CLASSIC;
    L9:
        if (r101 != 2093206386) goto L22;
        r102 = WakeupSoundEffectSettings.DOUBAO_SAME_VOICE;
        if (r100.equals(WakeupSoundEffectSettings.DOUBAO_SAME_VOICE) == true) goto L18;
        return WakeupSoundEffectSettings.CLASSIC;
    L22:
        return WakeupSoundEffectSettings.CLASSIC;
    L19:
        return WakeupSoundEffectSettings.CLASSIC;
    }

    public static final String b(ObricLaunchReportManager r100, String r101) {
        r100.getClass();
        if (Intrinsics.areEqual(com.obric.assistant.c.a(t1.f393353a.P1(r101, "0")), "1") == false) goto L5;
        return "on";
    L5:
        return "off";
    }

    public static final String c(ObricLaunchReportManager r100, int r101) {
        r100.getClass();
        if (t1.f393353a.i() == false) goto L16;
        if (r101 != 0) goto L6;
        return "system_authentication";
    L6:
        if (r101 != 1) goto L8;
        return "voice_print";
    L8:
        if (r101 != 2) goto L10;
        return NameKeys.LoadStrategy_Always;
    L10:
        if (r101 != 3) goto L16;
        return "not_allowed";
    L16:
        return "unavailable";
    }

    public final synchronized void e(String r110, long r111) {
        monitor-enter(this);
        boolean r100 = t9a.b.a().b();     // Catch: Throwable -> L46
        FLogger.f375446a.i("ObricLaunchReportManager", "onAnyActivityResumed and report for assistant, isObricOS: " + r100);     // Catch: Throwable -> L46
        if (KeyguardLockedState.UNLOCKED != IAssistantInteractionServiceKt.getInteractionStateService().getInteractionKeyguardLockedState()) goto L7;
        String r101 = "unlocked_screen";
    L8:
        IObricReporter.f391335a.getClass();     // Catch: Throwable -> L46
        IObricReporter r102 = IObricReporter.a.a();     // Catch: Throwable -> L46
        String r103 = null;
        if (r102 == null) goto L11;
        String r104 = r102.a();     // Catch: Throwable -> L46
    L12:
        IObricReporter r105 = IObricReporter.a.a();     // Catch: Throwable -> L46
        if (r105 == null) goto L15;
        String r106 = r105.l();     // Catch: Throwable -> L46
    L16:
        IObricReporter r107 = IObricReporter.a.a();     // Catch: Throwable -> L46
        if (r107 == null) goto L19;
        r103 = r107.getWakeupSource();     // Catch: Throwable -> L46
    L19:
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L46
        r108.put(f391420d, r104);     // Catch: Throwable -> L46
        r108.put(f391421e, r101);     // Catch: Throwable -> L46
        r108.put(f391422f, IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpAppPkg());     // Catch: Throwable -> L46
        r108.put(f391423g, r106);     // Catch: Throwable -> L46
        r108.put(f391424h, r103);     // Catch: Throwable -> L46
        IObricReporter r109 = IObricReporter.a.a();     // Catch: Throwable -> L46
        if (r109 == null) goto L22;
        int r112 = r109.m();     // Catch: Throwable -> L46
    L23:
        r108.put("launch_process_type", r112);     // Catch: Throwable -> L46
        if (r110 == null) goto L26;
        r108.put(WindowEvent.Params.LAUNCH_SESSION_ID, r110);     // Catch: Throwable -> L46
    L26:
        IAssistantChatWindow r113 = IAssistantChatWindowKt.getAssistantChatWindow();     // Catch: Throwable -> L46
        boolean r114 = false;
        if (r113 != null) goto L29;
    L31:
        boolean r115 = false;
    L32:
        if (r115 == false) goto L41;
        WindowLayoutInfo r116 = r113.getWindowLayoutInfo();     // Catch: Throwable -> L46
        if (r116 != null) goto L36;
    L38:
        boolean r117 = false;
    L39:
        if (r117 == false) goto L41;
        r114 = true;
        goto L41
    L36:
        if (r116.isLandscapeWindowLayout() != true) goto L38;
        r117 = true;
    L41:
        if (r114 == false) goto L43;
        r108.put("obric_screen_orientation", "landscape");     // Catch: Throwable -> L46
    L43:
        BuildersKt.launch$default(Q, null, null, new ObricLaunchReportManager$reportLaunchEventForAssistant$1(r108, r103, r100, r111, r106, r104, r110, null), 3, null);     // Catch: Throwable -> L46
        monitor-exit(this);
        return;
    L29:
        if (r113.isShowing() != true) goto L31;
        r115 = true;
        goto L32
    L22:
        r112 = -1;
        goto L23
    L15:
        r106 = null;
        goto L16
    L11:
        r104 = null;
        goto L12
    L7:
        r101 = "lock_screen";
    L46:
        th = move-exception;
        throw th;
    }

    public static final String a(ObricLaunchReportManager r110, String r111, String r112) {
        r110.getClass();
        Set r113 = SetsKt.setOf(new String[]{"dora_call", "dora_radio", "third_party_gesture", "audio", "long_press_power_button", "long_press_ai_button", "single_click_ai_button", "single_click_power_button", "oauto_input_icon", "mcp_input_icon", "dynamic_island", "notification_center"});
        Set r100 = SetsKt.setOf(new String[]{"open_video_call", "open_voice_call", "open_doubao_camera", "open_share_screen_call", "open_doubao"});
        if (r113.contains(r111) == true) goto L5;
    L7:
        return "full_screen";
    L5:
        if (r100.contains(r112) == true) goto L7;
        return "global_small_window";
    }
}
