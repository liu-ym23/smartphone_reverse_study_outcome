package com.obric.assistant.reporter.startup;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.bdp.appbase.settings.SettingsConstants;
import com.larus.media.MediaScene;
import com.larus.platform.model.NotificationBusiness;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f391383a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f391384b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f391385c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f391386d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f391387e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f391388f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f391389g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set<String> f391390h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<String> f391391i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<String> f391392j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set<String> f391393k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set<String> f391394l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set<String> f391395m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Set<String> f391396n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Set<String> f391397o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set<String> f391398p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Set<String> f391399q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Set<String> f391400r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Set<String> f391401s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Set<String> f391402t = null;

    /* JADX INFO: renamed from: com.obric.assistant.reporter.startup.a$a, reason: collision with other inner class name */
    public static final class C4620a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Object> f391403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Long> f391404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f391405c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4620a) == true) goto L8;
            return false;
        L8:
            C4620a r101 = (C4620a) r100;
            if (Intrinsics.areEqual(this.f391403a, r101.f391403a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f391404b, r101.f391404b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f391405c, r101.f391405c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f391403a.hashCode() * 31) + this.f391404b.hashCode()) * 31) + this.f391405c.hashCode();
        }

        public final String toString() {
            return "Payload(category=" + this.f391403a + ", metric=" + this.f391404b + ", extraLog=" + this.f391405c + ')';
        }

        public C4620a(Map<String, ? extends Object> r100, Map<String, Long> r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "category");
            Intrinsics.checkNotNullParameter(r101, "metric");
            Intrinsics.checkNotNullParameter(r102, "extraLog");
            this.f391403a = r100;
            this.f391404b = r101;
            this.f391405c = r102;
        }
    }

    static {
        f391383a = SetsKt.setOf(new String[]{"desktop", "voice", "breath", "ai_key", MediaScene.DORA, "bluetooth", "auto_mic"});
        f391384b = SetsKt.setOf(new String[]{"icon_click", "voice_wakeup", "breath_wakeup", "dora_voice_wakeup", "voice_command", "auto_mic", "physical_press", "single_press", "short_press", com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, "double_press"});
        f391385c = SetsKt.setOf(new String[]{"chat", LiveEndPageData.TAG_WINDOW, "click_talk", "touch_speak", "assistant", NotificationBusiness.REALTIME_CALL, "camera"});
        f391386d = SetsKt.setOf(new String[]{"success", "blocked", "dropped", "timeout", "cancelled", "superseded"});
        f391387e = SetsKt.setOf(new String[]{"elapsed_realtime", "uptime_converted_to_elapsed", "wall_converted_to_elapsed", "receiver_elapsed_fallback"});
        f391388f = SetsKt.setOf(new String[]{"cold", "alive", "unknown"});
        f391389g = SetsKt.setOf(new String[]{"cold", "warm", "hot", "not_applicable", "unknown"});
        f391390h = SetsKt.setOf(new String[]{"foreground", "background", "no_real_activity", "unknown"});
        f391391i = SetsKt.setOf(PullConfiguration.PROCESS_NAME_MAIN);
        f391392j = SetsKt.setOf("interactor");
        f391393k = SetsKt.setOf(new String[]{"0", "1"});
        f391394l = SetsKt.setOf(new String[]{LiveEndPageData.TAG_WINDOW, "activity", "reuse_current_chat", "legacy_camera"});
        f391395m = SetsKt.setOf(new String[]{"HighLevel", "MidLevel", "LowLevel", "Unknown"});
        f391396n = SetsKt.setOf(new String[]{"main_view", "child_first_frame"});
        f391397o = SetsKt.setOf(new String[]{"child_first_frame", "main_view"});
        f391398p = SetsKt.setOf("interactor_oneshot");
        f391399q = SetsKt.setOf(new String[]{"audio", "video", "screen_share", "camera"});
        f391400r = SetsKt.setOf(new String[]{"ready", "deadline_exceeded", "new_attempt", "other", "login_required", "network_unavailable", "assistant_unavailable", "ai_key_cancelled", "ai_key_gesture_timeout", "mic_in_use", "audio_input_disabled", "audio_session_busy", "record_audio_denied", "bot_unavailable", "camera_ability_unavailable", "camera_already_foreground", "camera_background_transition", "camera_launch_in_progress", "camera_legacy_host_destroyed", "camera_legacy_exact_launch_unavailable", "conversation_unavailable", "dora_pressing", "speaker_ability_unavailable", "speaker_ability_missing", "chat_context_unavailable", "chat_fragment_detached", "click_talk_replaced_before_start", "click_talk_start_failed", "asr_failed_before_pcm", "asr_finished_before_pcm", "asr_cancelled_before_pcm", "touch_speak_start_failed", "touch_speak_stopped_before_pcm", "continuous_talk_replaced_before_start", "continuous_talk_replaced_before_pcm", "continuous_talk_start_failed", "continuous_talk_error", "continuous_talk_finished_before_pcm", "continuous_talk_stopped_before_pcm", "realtime_call_downgraded", "realtime_call_not_enable", "realtime_call_timbre_not_set", "realtime_call_network_unavailable", "realtime_call_launch_failed", "dismiss_keyguard_failed", "dismiss_keyguard_in_progress", "low_storage", "start_chat_activity_failed", "ai_key_cancel", "ai_key_orphan_up_cancel", "new_ai_key_sequence", "intercom_condition_failed", "user_not_login", "screen_rotated", "screen_landscape", "pocket_mode", "click_talk_activation_failed", "touch_speak_activation_failed", "stopped_before_user_guide", "long_press_stopped_before_ready", "system_alert_window_permission", "user_guide_showing", "legacy_launcher_fallback", "session_processing_exception", "launch_failed", "quit_session", "only_end", "interactor_show_session_failed", "interactor_delivery_failed", "interactor_client_unavailable", "interactor_handoff_failed", "session_proxy_unavailable", "Album-camera-result", "Album-canvas-ps", "Blocked-by-system-alert-window-permission", "System-aiKeyPressing", "System-all-search-launch", "System-clickTalkSpeaking", "System-continuousTalkRunning", "System-dismiss-keyguard", "System-doraPressing", "System-ignore-request", "System-invalid-request-from", "System-pullup-once", "System-realtime-calling", "System-rotate-display", "System-startup", "System-user-guiding", "System-voice-enrolling", "Voice-in-pocket-mode", "Voice-mic-in-use-and-breath", "Voice-mic-in-use-calling", "Voice-mic-in-use-common", "Voice-re-wakeup-when-sessioning", "Voice-sync-error", "Voice-timer-running", "Voice-wrong-uid"});
        f391401s = SetsKt.setOf(new String[]{"window_content_ready", "chat_content_ready", "asr_record_ready", "first_frame_ready", "route_ready", "rtc_call_content_ready", "camera_content_ready"});
        f391402t = SetsKt.setOf(new String[]{"attempt_id", SettingsConstants.SETTINGS_UPDATE_FROM, "session_name", "handoff_stage", "session_error_code", "window_fallback", "launcher_payload_version", "requested_start_clock", "start_timestamp_rejected_reason", "child_surface_generation", "error_code", "error_type", "superseded_by_attempt_id"});
    }

    public static C4620a c(Map r310) {
        Intrinsics.checkNotNullParameter(r310, TemplateNodeType.RAW);
        String r100 = (String) r310.get("schema_version");
        if (r100 == null) goto L202;
        Integer r101 = StringsKt.toIntOrNull(r100);
        if (r101 == null) goto L202;
        if (r101.intValue() != 1) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L202;
        int r103 = r101.intValue();
        String r104 = b(r310, "source", f391383a);
        if (r104 != null) goto L17;
        return null;
    L17:
        String r105 = b(r310, "action", f391384b);
        if (r105 != null) goto L20;
        return null;
    L20:
        String r110 = b(r310, PickerReporterConstants.KEY.TARGET, f391385c);
        if (r110 != null) goto L23;
        return null;
    L23:
        String r111 = b(r310, "result", f391386d);
        if (r111 != null) goto L26;
        return null;
    L26:
        String r112 = b(r310, "start_clock", f391387e);
        if (r112 != null) goto L29;
        return null;
    L29:
        String r106 = b(r310, "process_start_type", f391388f);
        if (r106 != null) goto L32;
        return null;
    L32:
        String r107 = b(r310, "activity_start_type", f391389g);
        if (r107 != null) goto L36;
        return null;
    L36:
        String r108 = b(r310, "app_visibility_at_start", f391390h);
        if (r108 != null) goto L39;
        return null;
    L39:
        String r109 = b(r310, "state_owner_process_role", f391391i);
        if (r109 != null) goto L42;
        return null;
    L42:
        String r210 = (String) r310.get("total_duration_ms");
        if (r210 == null) goto L54;
        Long r211 = StringsKt.toLongOrNull(r210);
        if (r211 == null) goto L54;
        long r212 = r211.longValue();
        if (0 <= r212) goto L49;
    L51:
        boolean r213 = false;
    L52:
        if (r213 == false) goto L54;
    L55:
        Pair[] r113 = new Pair[11];
        r113[0] = TuplesKt.to("schema_version", Integer.valueOf(r103));
        r113[1] = TuplesKt.to("source", r104);
        r113[2] = TuplesKt.to("action", r105);
        r113[3] = TuplesKt.to(PickerReporterConstants.KEY.TARGET, r110);
        r113[4] = TuplesKt.to("result", r111);
        r113[5] = TuplesKt.to("start_clock", r112);
        r113[6] = TuplesKt.to("process_start_type", r106);
        r113[7] = TuplesKt.to("activity_start_type", r107);
        r113[8] = TuplesKt.to("app_visibility_at_start", r108);
        r113[9] = TuplesKt.to("state_owner_process_role", r109);
        if (r211 == null) goto L58;
        String r114 = "1";
    L59:
        r113[10] = TuplesKt.to("duration_valid", r114);
        LinkedHashMap r115 = MapsKt.linkedMapOf(r113);
        a(r115, r310, "origin_process_role", f391392j);
        Set<String> r116 = f391393k;
        a(r115, r310, "main_handoff_completed", r116);
        a(r115, r310, CloudControlInf.ROUTE, f391394l);
        a(r115, r310, "call_type", f391399q);
        a(r115, r310, "keep_alive_level_mode", f391395m);
        a(r115, r310, "window_ready_source", f391396n);
        a(r115, r310, "asr_ready_source", f391398p);
        a(r115, r310, "first_frame_source", f391397o);
        String r117 = (String) r310.get("process_start_inferred");
        if (r117 == null) goto L69;
        String r118 = StringsKt.trim(r117).toString();
        if (r118 == null) goto L69;
        if (r116.contains(r118) == true) goto L67;
        r118 = null;
    L67:
        if (r118 == null) goto L69;
        r115.put("process_start_inferred", r118);
    L69:
        String r119 = (String) r310.get("reason");
        if (r119 != null) goto L72;
        r119 = "";
    L72:
        String r120 = StringsKt.trim(r119).toString();
        if (f391400r.contains(r120) == false) goto L76;
    L95:
        r115.put("reason", r120);
        String r121 = (String) r310.get("missing_gate");
        if (r121 == null) goto L137;
        List r122 = StringsKt.split$default(r121, new char[]{','}, false, 0, 6, null);
        if (r122 == null) goto L137;
        List r123 = r122;
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
        Iterator r125 = r123.iterator();
    L101:
        if (r125.hasNext() == false) goto L103;
        r124.add(StringsKt.trim((String) r125.next()).toString());
        goto L101
    L103:
        ArrayList r126 = new ArrayList();
        Iterator r127 = r124.iterator();
    L105:
        if (r127.hasNext() == false) goto L113;
        Object r128 = r127.next();
        if (((String) r128).length() <= 0) goto L109;
        boolean r129 = true;
    L110:
        if (r129 == false) goto L105;
        r126.add(r128);
        goto L105
    L109:
        r129 = false;
        goto L110
    L113:
        if ((!r126.isEmpty()) == false) goto L126;
        Set<String> r130 = f391401s;
        if (r126.isEmpty() == true) goto L123;
        Iterator r131 = r126.iterator();
    L119:
        if (r131.hasNext() == false) goto L123;
        if (r130.contains((String) r131.next()) == true) goto L119;
        boolean r132 = false;
    L124:
        if (r132 == false) goto L126;
        boolean r133 = true;
    L127:
        if (r133 == true) goto L130;
        r126 = null;
    L130:
        if (r126 == null) goto L137;
        List r134 = CollectionsKt.sorted(r126);
        if (r134 == null) goto L137;
        String r135 = CollectionsKt.joinToString$default(r134, ",", null, null, 0, null, null, 62, null);
        if (r135 == null) goto L137;
        r115.put("missing_gate", r135);
    L123:
        r132 = true;
    L126:
        r133 = false;
    L137:
        LinkedHashMap r136 = new LinkedHashMap();
        if (r211 == null) goto L140;
        r136.put("total_duration_ms", Long.valueOf(r211.longValue()));
    L140:
        String r137 = (String) r310.get("first_frame_duration_ms");
        if (r137 == null) goto L155;
        Long r138 = StringsKt.toLongOrNull(r137);
        if (r138 == null) goto L155;
        long r139 = r138.longValue();
        if (0 <= r139) goto L147;
    L149:
        boolean r140 = false;
    L150:
        if (r140 == true) goto L153;
        r138 = null;
    L153:
        if (r138 == null) goto L155;
        r136.put("first_frame_duration_ms", Long.valueOf(r138.longValue()));
        goto L155
    L147:
        if (r139 >= 60001) goto L149;
        r140 = true;
    L155:
        String r141 = (String) r310.get("process_uptime_ms");
        if (r141 == null) goto L168;
        Long r142 = StringsKt.toLongOrNull(r141);
        if (r142 == null) goto L168;
        if (r142.longValue() < 0) goto L162;
        boolean r143 = true;
    L163:
        if (r143 == true) goto L166;
        r142 = null;
    L166:
        if (r142 == null) goto L168;
        r136.put("process_uptime_ms", Long.valueOf(r142.longValue()));
        goto L168
    L162:
        r143 = false;
    L168:
        LinkedHashMap r144 = new LinkedHashMap();
        Iterator<T> r145 = f391402t.iterator();
    L170:
        if (r145.hasNext() == false) goto L200;
        String r146 = (String) r145.next();
        String r147 = (String) r310.get(r146);
        if (r147 == null) goto L170;
        String r148 = StringsKt.trim(r147).toString();
        if (r148 == null) goto L170;
        int r149 = r148.length();
        if (1 <= r149) goto L178;
    L180:
        boolean r150 = false;
    L181:
        if (r150 == false) goto L192;
        int r151 = 0;
    L184:
        if (r151 >= r148.length()) goto L189;
        if (Character.isISOControl(r148.charAt(r151)) == true) goto L187;
        r151 = r151 + 1;
        goto L184
    L187:
        boolean r152 = false;
    L190:
        if (r152 == false) goto L192;
        boolean r153 = true;
    L193:
        if (r153 == true) goto L196;
        r148 = null;
    L196:
        if (r148 == null) goto L170;
        r144.put(r146, r148);
        goto L170
    L189:
        r152 = true;
    L192:
        r153 = false;
        goto L193
    L178:
        if (r149 >= 257) goto L180;
        r150 = true;
        goto L181
    L200:
        return new C4620a(r115, r136, r144);
    L76:
        if (StringsKt.startsWith$default(r120, "intercom_condition_", false, 2, null) == false) goto L80;
        String r154 = "intercom_condition_failed";
    L78:
        r120 = r154;
        goto L95
    L80:
        if (StringsKt.startsWith$default(r120, "click_talk_", false, 2, null) == false) goto L85;
        if (StringsKt.endsWith$default(r120, "_before_pcm", false, 2, null) == false) goto L85;
        r154 = "click_talk_ended_before_pcm";
    L85:
        if (StringsKt.startsWith$default(r120, "click_talk_", false, 2, null) == false) goto L90;
        if (StringsKt.endsWith$default(r120, "_before_start", false, 2, null) == false) goto L90;
        r154 = "click_talk_ended_before_start";
    L90:
        if (StringsKt.startsWith$default(r120, "continuous_talk_", false, 2, null) == true) goto L92;
    L94:
        r154 = "other";
        goto L78
    L92:
        if (StringsKt.endsWith$default(r120, "_before_start", false, 2, null) == false) goto L94;
        r154 = "continuous_talk_ended_before_start";
        goto L78
    L58:
        r114 = "0";
        goto L59
    L49:
        if (r212 >= 60001) goto L51;
        r213 = true;
    L54:
        r211 = null;
        goto L55
    L9:
        r102 = false;
    L202:
        return null;
    }

    public static String b(Map r100, String r101, Set r102) {
        String r103 = (String) r100.get(r101);
        if (r103 == null) goto L9;
        String r104 = StringsKt.trim(r103).toString();
        if (r104 == null) goto L9;
        if (r102.contains(r104) == false) goto L9;
        return r104;
    L9:
        return null;
    }

    public static void a(Map r100, Map r101, String r102, Set r103) {
        String r104 = (String) r101.get(r102);
        if (r104 == null) goto L13;
        String r105 = StringsKt.trim(r104).toString();
        if (r105 != null) goto L7;
        return;
    L7:
        if (r103.contains(r105) == true) goto L10;
        r105 = null;
    L10:
        if (r105 == null) goto L15;
        r100.put(r102, r105);
        return;
    L15:
        return;
    }
}
