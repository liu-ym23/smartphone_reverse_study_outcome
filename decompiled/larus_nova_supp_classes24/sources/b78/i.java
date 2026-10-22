package b78;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.common.AvKitPlatform;
import com.larus.audio.call.n;
import com.larus.audio.call.util.l;
import com.larus.audio.call.util.p;
import com.larus.audio.call.utils.AvBizType;
import com.larus.im.internal.network.link.service.config.SAMICoreTokenType;
import com.larus.im.service.audio.AvConnectionType;
import com.larus.im.service.audio.ModalType;
import com.larus.im.service.audio.y0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import nuc.v0;
import ouc.d0;
import ouc.e0;
import ouc.j;
import ouc.k;
import ouc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i {
    public static final List<String> a = null;

    static {
        a = CollectionsKt.listOf(new String[]{"doubao_update_version_code", "doubao_os_version", "doubao_device_type", "doubao_device_brand", "doubao_device_platform"});
    }

    public static final void a(Map r3, RealtimeCallParam r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "param");
        r3.put("sami_wakeup_enable", "true");
        r3.put("sami_wakeup_format", r4.m.a);
        r3.put("sami_wakeup_bit_rate", String.valueOf(r4.m.e));
        r3.put("sami_wakeup_sample_rate", String.valueOf(r4.m.c));
        r3.put("sami_wakeup_channel_num", String.valueOf(r4.m.d));
        r3.put("sami_wakeup_decoder_length", String.valueOf(r4.m.b));
        String r0 = r4.m.f;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r3.put("sami_wakeup_model_path", r0);
        String r5 = r4.m.g;
        if (r5 == null) goto L9;
        r1 = r5;
    L9:
        r3.put("sami_wakeup_model_file_md5", r1);
        if (com.larus.audio.call.f.c().appContext().d() == false) goto L12;
        String r6 = "1";
    L13:
        r3.put("sami_app_status", r6);
        r3.put("sami_query_type", "2");
        return;
    L12:
        r6 = "3";
        goto L13
    }

    public static final Map<String, String> b(RealtimeCallParam r31, com.larus.audio.call.tracer.b r32, AvBizType r33, boolean r34) {
        Intrinsics.checkNotNullParameter(r31, "<this>");
        Intrinsics.checkNotNullParameter(r32, "traceSpan");
        Intrinsics.checkNotNullParameter(r33, "bizType");
        LinkedHashMap r5 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        Map r7 = com.larus.audio.call.f.c().c().i;
        LinkedHashMap r8 = new LinkedHashMap(MapsKt.mapCapacity(r7.size()));
        Iterator r9 = r7.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry r10 = (Map.Entry) r9.next();
        r8.put(r10.getKey(), k.c((String) r10.getValue()));
        goto L4
    L6:
        r5.put("common_network_param", new d0(r8).toString());
        Map r11 = com.larus.audio.call.f.c().c().i;
        Iterator<T> r12 = a.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        String r13 = (String) r12.next();
        String r14 = (String) r11.get(r13);
        if (r14 == null) goto L8;
        r5.put(r13, r14);
        goto L8
    L12:
        r5.put("uid", r31.k.f);
        r5.put("user_id", r31.k.f);
        r5.put("device_id", r31.k.g);
        r5.put("version_name", r31.k.h);
        r5.put("version_code", String.valueOf(r31.k.i));
        r5.put("update_version_code", String.valueOf(r31.k.j));
        r5.put("bot_id", r31.o.h);
        r5.put("conversation_id", r31.o.c);
        String r15 = r31.p.P;
        if (r15 != null) goto L15;
        r15 = "";
    L15:
        r5.put("last_section_id", r15);
        Long r16 = r31.p.Q;
        if (r16 == null) goto L19;
        String r17 = r16.toString();
        if (r17 == null) goto L19;
    L20:
        r5.put("last_message_index", r17);
        com.larus.audio.call.util.e r19 = com.larus.audio.call.util.e.a;
        r19.i("Session_Config", "convLastMessageIndex: " + r31.p.Q + ", convLastSectionId: " + r31.p.P);
        r5.put("ppe_info", com.larus.audio.call.f.c().b());
        r5.put("audio_download_sample_rate", String.valueOf(r31.o.j));
        r5.put("audio_upload_channel", String.valueOf(r31.l.f));
        r5.put("audio_upload_sample_rate", String.valueOf(r31.l.e));
        r5.put("audio_scene", r31.k.t);
        r5.put("launch_stream_task_on_start", String.valueOf(r31.k.v));
        if (y0.e(r31.s) == false) goto L23;
    L26:
        boolean r110 = true;
    L27:
        if (r34 == false) goto L29;
        boolean r111 = com.larus.audio.call.f.c().i();
    L30:
        if (r110 == false) goto L33;
        if (r111 == false) goto L33;
        ModalType r112 = ModalType.VIDEO;
    L34:
        r5.put("modal_type", String.valueOf(r112.ordinal()));
        r5.put("is_realtime_new_background_enabled", String.valueOf(r31.p.u));
        r5.put("stream_app", r31.k.z);
        r5.put("enable_uplink_burst_mode", String.valueOf(r31.k.B));
        ouc.i r113 = (ouc.i) r31.r.get("is_dora_vui_wakeup");
        if (r113 == null) goto L37;
        String r114 = (String) r5.put("is_dora_vui_wakeup", r113.toString());
    L37:
        Boolean r115 = r31.X;
        if (r115 == null) goto L40;
        String r116 = (String) r5.put("enable_omni_dump", String.valueOf(r115.booleanValue()));
    L40:
        Boolean r117 = r31.Y;
        if (r117 == null) goto L43;
        String r118 = (String) r5.put("enable_mmt_audio_dump", String.valueOf(r117.booleanValue()));
    L43:
        Boolean r119 = r31.Z;
        if (r119 == null) goto L47;
        String r120 = (String) r5.put("enable_mmt_video_dump", String.valueOf(r119.booleanValue()));
    L47:
        if (y0.e(r31.s) == false) goto L61;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        RealtimeCallParam.m r121 = r31.B;
        if (r121 != null) goto L51;
    L53:
        r5.put("rtc_user_id", r31.k.g);
        if (r31.u != 1) goto L56;
        AvConnectionType r122 = AvConnectionType.TokenPoolWithRTCMerge;
    L57:
        r5.put("rtc_client_connection_type", String.valueOf(r122.getType()));
        if (r31.l.f != 2) goto L68;
        r5.put("rtc_audio_encode_stereo", "true");
    L68:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        Intrinsics.checkNotNullParameter(r32, "traceSpan");
        String r4 = com.larus.audio.call.f.c().d(r32.d(), "call");
        if (r4 != null) goto L71;
        r4 = "";
    L71:
        String r123 = com.larus.audio.call.f.c().d(r32.d(), "create_call");
        if (r123 != null) goto L74;
        r123 = "";
    L74:
        RealtimeCallParam.h r124 = r31.k;
        r124.getClass();
        if (CollectionsKt.listOf(new String[]{"VWkAjHuAlm", "HmRdheYWOw", "MGdLITXH7b6Y2Yx5", "wjniI7WRchbdX0rm", "HqxgWPsgLv", "qoZHsKsRzH", "Wd4coUDTJ8zmVZ0T", "HgZBnrFyOUeW9eWN", "8WXv2rMtrmQ6QeJd", "phiDZKCcuhc6srv1"}).contains(r124.b) == false) goto L78;
    L83:
        String r125 = "dora_flowV2";
    L88:
        String r126 = r31.D;
        if (r126 != null) goto L92;
        r126 = "";
    L92:
        if (r126.length() <= 0) goto L94;
        boolean r127 = true;
    L95:
        r5.put("sami_sync_realtime_call_enabled", "false");
        r5.put("sami_auth_app_key", r31.k.b);
        r5.put("sami_token", r31.k.c);
        r5.put("sami_token_type", String.valueOf(SAMICoreTokenType.TOKEN_TO_B.getValue()));
        String r0 = (String) r5.put("sami_business_info", r125);
        r19.i("businessInfo", "businessInfo is ".concat(r125));
        r5.put("sami_url_with_queries", r31.k.a);
        r5.put("sami_header", r31.k.d);
        r5.put("sami_span_header", r4);
        r5.put("sami_flow_trace_context", r123);
        r5.put("sami_reconnect_timeout", String.valueOf(r31.k.e));
        r5.put("sami_frontier_quic_enabled", com.larus.audio.call.f.d().f);
        r5.put("sami_enable_connect_pool", String.valueOf(r127));
        r5.put("sami_connect_pool_business", r126);
        r5.put("sami_namespace", r31.k.x);
        RealtimeCallParam.e r1 = r31.k.l.a;
        if (r1 == null) goto L99;
        String r2 = Boolean.valueOf(r1.a).toString();
        if (r2 == null) goto L99;
    L100:
        r5.put("sami_enable_transfer_retry", r2);
        RealtimeCallParam.e r3 = r31.k.l.a;
        if (r3 == null) goto L103;
        Integer r6 = Integer.valueOf(r3.b);
    L104:
        r5.put("sami_retry_ping_pong_timeout", String.valueOf(r6));
        v r20 = com.larus.audio.call.util.i.a;
        RealtimeCallParam.e r21 = r31.k.l.a;
        if (r21 == null) goto L107;
        int[] r22 = r21.c;
    L108:
        r20.getClass();
        r5.put("sami_retry_time_array", r20.a(kuc.a.d(v0.c), r22));
        r5.put("sami_trace_id", r32.d());
        r5.put("sami_trace_span_parent_name", r32.e());
        e0 r23 = new e0();
        j.c(r23, "span_header", r4);
        j.c(r23, "x-flow-trace", r4);
        Unit r24 = Unit.INSTANCE;
        r5.put("sami_trace_info", r23.a().toString());
        r5.put("trace_id", r32.d());
        r5.put("trace_tag", r32.e());
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        String r25 = r31.k.o;
        switch(r25.hashCode()) {
            case -1917129045: goto L131;
            case -1698888077: goto L128;
            case -1590195861: goto L124;
            case 434773765: goto L120;
            case 847278215: goto L116;
            case 1842156731: goto L112;
            default: goto L132;
        };
    L131:
        r25.equals("dora_full_duplex");
    L132:
        int r26 = 1;
    L133:
        r5.put("sami_request_type", String.valueOf(r26));
        r5.put("sami_business", String.valueOf(r31.k.n));
        d0 r27 = k.n(ouc.a.d.e(r31.q.toString()));
        e0 r29 = new e0();
        if (r34 == false) goto L136;
        r29.b("is_doubao_reconnect", k.b(Integer.valueOf(r34 ? 1 : 0)));
    L136:
        j.c(r29, "os", AvKitPlatform.Android.getOsName$avkit_release());
        j.c(r29, "uid", com.larus.audio.call.f.c().appContext().c());
        j.c(r29, "did", com.larus.audio.call.f.c().appContext().b());
        j.c(r29, "app_version", com.larus.audio.call.f.c().appContext().h());
        j.a(r29, "enable_pre_query", Boolean.valueOf(r31.l.m));
        if (r26 != 14) goto L143;
        j.a(r29, "enable_asr_twopass", Boolean.valueOf(r31.l.t));
        RealtimeCallParam.d r128 = r31.l;
        if (r128.t == false) goto L141;
        j.c(r29, "nonstream_model", r128.u);
    L141:
        Boolean r129 = Boolean.TRUE;
        j.a(r29, "use_bigasr_punc", r129);
        j.a(r29, "use_bigasr_itn", r129);
    L143:
        j.c(r29, "sub_conv_firstmet_type", r31.k.q);
        j.c(r29, "sub_conv_source_message", r31.k.r);
        j.a(r29, "enable_semantic_seg", Boolean.valueOf(r31.E));
        String r130 = com.larus.audio.call.f.c().c().z;
        if (r130 != null) goto L147;
        r130 = "";
    L147:
        if (p.a(r130) == false) goto L149;
        j.c(r29, "feature_key", r130);
    L149:
        j.a(r29, "enable_retry", Boolean.valueOf(r31.p.D));
        if (r31.p.r == false) goto L153;
        j.a(r29, "enable_silence_timeout", Boolean.TRUE);
        j.b(r29, "silence_timeout_ms", Long.valueOf(r31.p.s));
    L153:
        r5.put("sami_session_extra", q68.d.a(r27, r29.a()).toString());
        if (r26 != 23) goto L157;
        r5.put("sami_is_first_enter_si", String.valueOf(r31.k.p));
    L157:
        if (r31.p.E == false) goto L159;
        String r210 = "0";
        String r30 = "1";
    L160:
        r5.put("denoise_feature_enable", r30);
        r5.put("", String.valueOf(r31.l.h));
        r5.put("sami_enable_pre_query", String.valueOf(r31.l.m));
        r5.put("sami_sub_conv_first_met_type", r31.k.q);
        r5.put("sami_sub_conv_source_msg", r31.k.r);
        r5.put("sami_enable_realtime_voice_call", "true");
        r5.put("sami_enable_asr", "true");
        r5.put("sami_enable_tts", "true");
        r5.put("sami_enable_text_uploading", "false");
        if (r26 != 12) goto L163;
        Object r35 = "true";
    L164:
        r5.put("sami_dora_radio_talk", r35);
        r5.put("sami_record_minutes", "false");
        r5.put("sami_enable_audio_input", "true");
        r5.put("sami_enable_text_reading", "true");
        String r36 = r31.e;
        if (r36 != null) goto L167;
        r36 = "";
    L167:
        r5.put("sami_call_id", r36);
        r5.put("sami_task_id", r31.l.a);
        e0 r37 = new e0();
        j.c(r37, "conversation_id", r31.o.c);
        j.c(r37, "local_call_id", r31.e);
        j.c(r37, "uid", r31.k.f);
        j.c(r37, "bot_id", r31.o.h);
        j.c(r37, "interrupt_type", String.valueOf(r31.l.h));
        j.c(r37, "project_id", r31.d0);
        e0 r38 = new e0();
        if (r31.a == false) goto L170;
        String r39 = "1";
    L171:
        j.c(r38, "is_continuous_speak", r39);
        if (r31.b == false) goto L174;
        String r131 = "1";
    L175:
        j.c(r38, "is_obric_continuous_talk", r131);
        if (r31.p.D == false) goto L178;
        String r40 = "true";
    L179:
        j.c(r38, "enable_retry", r40);
        r37.b("extra", l.c(r38.a()));
        String r41 = "sami_session_chat";
        r5.put("sami_session_chat", r37.a().toString());
        r5.put("sami_session_id", r31.o.b);
        if (t68.a.a.c() == false) goto L184;
        int r42 = r31.g;
        if (r42 == 0) goto L184;
        r5.put("sami_session_vui_id", String.valueOf(r42));
        r5.put("sami_session_dora_wake_mode", String.valueOf(r31.k.s));
    L184:
        n r43 = r31.L;
        if (r43 == null) goto L190;
        String r44 = r43.a;
        if (r44 == null) goto L190;
    L194:
        r5.put("sami_scene_type", r44);
        n r45 = r31.L;
        if (r45 == null) goto L198;
        String r46 = r45.b;
        if (r46 == null) goto L198;
    L202:
        r5.put("sami_scene_speaker_id", r46);
        n r47 = com.larus.audio.call.f.c().g();
        if (r47 == null) goto L205;
        Integer r48 = Integer.valueOf(r47.c);
    L206:
        r5.put("sami_listening_waiting_time", String.valueOf(r48));
        r5.put("sami_scene_enable_scene_mode", String.valueOf(r31.F));
        r5.put("request_token_business", r31.J);
        r5.put("request_token_sub_business", r31.K);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        r5.put("sami_asr_audio_format", r31.l.g);
        r5.put("sami_asr_language", r31.l.d);
        r5.put("sami_asr_extra", r31.l.o);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        r5.put("sami_tts_audio_format", r31.o.k);
        r5.put("sami_tts_speaker", r31.o.d);
        r5.put("sami_tts_enable_compress", String.valueOf(r31.o.l));
        r5.put("sami_tts_bit_rate", String.valueOf(r31.o.m));
        r5.put("sami_tts_sample_rate", String.valueOf(r31.o.j));
        r5.put("sami_loudness_meta_data", r31.o.t);
        r5.put("sami_tts_target_lufs", String.valueOf(r31.o.u));
        r5.put("sami_loudness_loud_norm_algo_type", String.valueOf(r31.o.v));
        r5.put("sami_loudness_device_ai_data", "{\"target_lufs\": " + r31.o.u + '}');
        r5.put("sami_tts_loudness_audio_dump_path", com.larus.audio.call.f.d().c.g);
        r5.put("sami_tts_extra", r31.o.n);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        List<RealtimeCallParam.a> r49 = r31.j.a;
        if (r49 != null) goto L209;
    L211:
        boolean r132 = false;
    L212:
        if (r132 == false) goto L230;
        int r50 = com.larus.audio.call.util.j.a;
        RealtimeCallParam.b r51 = r31.j;
        juc.n r133 = RealtimeCallParam.b.Companion.serializer();
        Intrinsics.checkNotNullParameter(r133, "serializer");
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L216
        Object r52 = Result.constructor-impl(r20.a(r133, r51));     // Catch: Throwable -> L216
    L218:
        Throwable r53 = Result.exceptionOrNull-impl(r52);
        if (r53 == null) goto L223;
        com.larus.audio.call.util.e.a.e("GsonHolder", "fromJson failed, stack: " + ExceptionsKt.stackTraceToString(r53));
    L223:
        if (Result.isFailure-impl(r52) == false) goto L225;
        Object r54 = null;
    L226:
        String r55 = (String) r54;
        if (r55 != null) goto L229;
        r55 = "";
    L229:
        r5.put("sami_ast_channels", r55);
    L232:
        if (r33 != AvBizType.DORA) goto L269;
        a(r5, r31);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        r5.put("sami_sync_realtime_call_enabled", "true");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        d0 r56 = r31.q;
        e0 r135 = new e0();
        j.c(r135, "os", AvKitPlatform.Android.getOsName$avkit_release());
        j.c(r135, "uid", com.larus.audio.call.f.c().appContext().c());
        j.c(r135, "did", com.larus.audio.call.f.c().appContext().b());
        j.c(r135, "app_version", com.larus.audio.call.f.c().appContext().h());
        j.a(r135, "enable_pre_query", Boolean.valueOf(r31.l.m));
        String r136 = com.larus.audio.call.f.c().c().z;
        if (r136 != null) goto L237;
        r136 = "";
    L237:
        if (p.a(r136) == false) goto L239;
        j.c(r135, "feature_key", r136);
    L239:
        Map<String, Object> r137 = r31.n.n;
        Intrinsics.checkNotNullParameter(r135, "<this>");
        Intrinsics.checkNotNullParameter(r137, "param");
        Iterator r138 = ((LinkedHashMap) r137).entrySet().iterator();
    L241:
        if (r138.hasNext() == false) goto L253;
        Map.Entry r139 = (Map.Entry) r138.next();
        Iterator r310 = r138;
        String r140 = (String) r139.getKey();
        Object r141 = r139.getValue();
        if ((r141 instanceof String) == false) goto L246;
        j.c(r135, r140, (String) r141);
    L252:
        r138 = r310;
        goto L241
    L246:
        if ((r141 instanceof Integer) == false) goto L249;
        j.b(r135, r140, (Number) r141);
        goto L252
    L249:
        if ((r141 instanceof Boolean) == false) goto L251;
        j.a(r135, r140, (Boolean) r141);
        goto L252
    L251:
        r135.b(r140, k.c(r141.toString()));
        goto L252
    L253:
        Unit r57 = Unit.INSTANCE;
        r5.put("sami_session_extra", q68.d.a(r56, r135.a()).toString());
        e0 r59 = new e0();
        if (r31.f.length() <= 0) goto L256;
        boolean r142 = true;
    L257:
        if (r142 == false) goto L259;
        j.c(r59, "wake_word", r31.f);
        j.a(r59, "is_conf_fetched", Boolean.TRUE);
    L260:
        j.c(r59, "local_call_id", r31.e);
        j.c(r59, "uid", r31.k.f);
        j.b(r59, "interrupt_type", Integer.valueOf(r31.l.h));
        r59.b("extra", l.c(new d0(new LinkedHashMap())));
        j.a(r59, "is_dora_onboarding", Boolean.valueOf(r31.l.q));
        e0 r60 = new e0();
        Iterator r61 = com.larus.audio.call.f.c().j().entrySet().iterator();
    L262:
        if (r61.hasNext() == false) goto L264;
        Map.Entry r62 = (Map.Entry) r61.next();
        j.c(r60, (String) r62.getKey(), (String) r62.getValue());
        goto L262
    L264:
        Iterator<Map.Entry<String, String>> r63 = r31.n.m.entrySet().iterator();
    L266:
        if (r63.hasNext() == false) goto L268;
        Map.Entry<String, String> r64 = r63.next();
        j.c(r60, r64.getKey(), r64.getValue());
        goto L266
    L268:
        Unit r65 = Unit.INSTANCE;
        r59.b("extra", r60.a());
        r5.put(r41, r59.a().toString());
        r5.put("sami_session_dora_wake_mode", String.valueOf(r31.k.s));
        r5.put("sami_session_enable_one_shot", String.valueOf(r31.k.w));
        Object r66 = "false";
        r5.put("sami_scene_enable_scene_mode", r66);
        r5.put("sami_session_vui_id", String.valueOf(r31.k.u));
        r5.put("sami_session_dora_enable_touch", String.valueOf(r31.n.b));
        r5.put("sami_session_dora_enable_burst", String.valueOf(r31.n.c));
        r5.put("sami_session_dora_vision_query_mode", String.valueOf(r31.n.d));
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        r5.put("sami_enable_player", String.valueOf(r31.o.w));
        r5.put("sami_si_src_language", r31.n.g);
        r5.put("sami_si_dst_language", r31.n.h);
        r5.put("sami_si_scene", r31.n.i);
        r5.put("sami_speaker_clone", r31.n.l);
        r5.put("sami_nc_iuctc_path", r31.n.k);
        Object r67 = r66;
    L271:
        if (t68.a.a.c() == false) goto L307;
        RealtimeCallParam.l r68 = r31.M;
        if (r68 == null) goto L275;
        boolean r69 = r68.a;
    L276:
        if (r69 == false) goto L307;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        RealtimeCallParam.l r70 = r31.M;
        if (r70 != null) goto L280;
    L282:
        boolean r143 = false;
    L283:
        if (r143 == false) goto L285;
        Object r144 = "true";
    L286:
        r5.put("sami_session_enable_one_shot", r144);
        RealtimeCallParam.l r71 = r31.M;
        if (r71 == null) goto L292;
        String r72 = r71.b;
        if (r72 == null) goto L292;
        String r145 = r72;
    L293:
        r5.put("sami_oneshot_keyword", r145);
        RealtimeCallParam.l r73 = r31.M;
        if (r73 == null) goto L299;
        String r74 = Long.valueOf(r73.c).toString();
        if (r74 == null) goto L299;
        String r146 = r74;
    L300:
        r5.put("sami_oneshot_offset_time", r146);
        com.larus.audio.call.util.e.a.i("Session_Config", "bizType = " + r33 + ", vuiId = " + r31.g + ", voiceWakeupId = " + r31.c0);
        if (r33 != AvBizType.OBRIC_CONTINUOUS_TALK) goto L307;
        int r75 = r31.g;
        if (r75 == 0) goto L307;
        if (r75 == r31.c0) goto L307;
        a(r5, r31);
    L299:
        r146 = r210;
    L292:
        r145 = "";
        goto L293
    L285:
        r144 = r67;
        goto L286
    L280:
        if (r70.a != true) goto L282;
        r143 = true;
        goto L283
    L275:
        r69 = false;
    L307:
        return r5;
    L259:
        j.c(r59, "conversation_id", r31.l.c);
        j.c(r59, "bot_id", r31.o.h);
        goto L260
    L256:
        r142 = false;
        goto L257
    L269:
        r67 = "false";
        goto L271
    L225:
        r54 = r52;
    L216:
        th = move-exception;
        Result.Companion r76 = Result.Companion;
        r52 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L218
    L230:
        r41 = "sami_session_chat";
        goto L232
    L209:
        if ((!r49.isEmpty()) != true) goto L211;
        r132 = true;
        goto L212
    L205:
        r48 = null;
    L198:
        n r77 = com.larus.audio.call.f.c().g();
        if (r77 == null) goto L201;
        r46 = r77.b;
        goto L202
    L201:
        r46 = "";
    L190:
        n r79 = com.larus.audio.call.f.c().g();
        if (r79 == null) goto L193;
        r44 = r79.a;
        goto L194
    L193:
        r44 = "";
        goto L194
    L178:
        r40 = "false";
        goto L179
    L174:
        r131 = r210;
        goto L175
    L170:
        r39 = r210;
        goto L171
    L163:
        r35 = "false";
        goto L164
    L159:
        r30 = "0";
        r210 = r30;
        goto L160
    L112:
        if (r25.equals("dora_si") == false) goto L132;
        r26 = 23;
        goto L133
    L116:
        if (r25.equals("dora_half_duplex") == false) goto L132;
        r26 = 12;
        goto L133
    L120:
        if (r25.equals("dora_env_observe") == false) goto L132;
        r26 = 30;
        goto L133
    L124:
        if (r25.equals("assistant_half_duplex") == false) goto L132;
        r26 = 14;
        goto L133
    L128:
        if (r25.equals("request_type_quic") == false) goto L132;
        r26 = 21;
        goto L133
    L107:
        r22 = null;
        goto L108
    L103:
        r6 = null;
    L99:
        r2 = "true";
        goto L100
    L94:
        r127 = false;
        goto L95
    L78:
        if (t68.a.a.c() == false) goto L85;
        if (r31.g == 0) goto L85;
        if (r31.c0 == 0) goto L83;
    L85:
        if (com.larus.audio.call.f.c().appContext().f() == true) goto L87;
        r125 = "flowV2";
        goto L88
    L87:
        r125 = "";
        goto L88
    L56:
        r122 = AvConnectionType.Default;
        goto L57
    L51:
        if (p.a(r121.a) == false) goto L53;
        r5.put("rtc_app_id", r121.a);
        goto L53
    L61:
        if (y0.d(r31.s) == false) goto L63;
    L64:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r31, "param");
        ve9.c r147 = r31.C;
        if (r147 == null) goto L68;
        v r148 = ve9.j.a;
        r148.getClass();
        String r149 = (String) r5.put("av_quic_connect_config", r148.a(ve9.c.Companion.serializer(), r147));
        goto L68
    L63:
        if (y0.b(r31.s) == false) goto L68;
    L33:
        r112 = ModalType.AUDIO;
        goto L34
    L29:
        r111 = r31.p.t;
        goto L30
    L23:
        if (y0.b(r31.s) == true) goto L26;
        r110 = false;
    L19:
        r17 = "";
        goto L20
    }
}
