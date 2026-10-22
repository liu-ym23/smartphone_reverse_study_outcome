package ve9;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import nuc.v0;
import ouc.d0;
import ouc.v;
import ouc.w;

/* JADX INFO: loaded from: classes30.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f554468a = null;

    static {
        f554468a = w.a(new i());
    }

    public static final a a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new a(h.c(r100, "sami_asr_audio_format"), h.c(r100, "sami_asr_language"), h.c(r100, "sami_asr_extra"), h.b(r100, "audio_upload_channel", 1), 8);
    }

    public static final e b(g r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.f554467a.get("user_id");
        if (r100 != null) goto L5;
        String r101 = "";
    L6:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r102 = r110.f554467a.get("device_id");
        if (r102 != null) goto L9;
        String r103 = "";
    L10:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r104 = r110.f554467a.get("version_name");
        if (r104 != null) goto L13;
        String r105 = "";
    L14:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r106 = r110.f554467a.get("update_version_code");
        if (r106 != null) goto L17;
        String r107 = "";
    L18:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r108 = r110.f554467a.get("conversation_id");
        if (r108 != null) goto L21;
        String r109 = "";
    L22:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r111 = r110.f554467a.get("bot_id");
        if (r111 != null) goto L25;
        String r112 = "";
    L26:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r113 = r110.f554467a.get("sami_token");
        if (r113 != null) goto L30;
        r113 = "";
    L30:
        return new e(r101, r103, r105, r107, r109, r112, r113);
    L25:
        r112 = r111;
        goto L26
    L21:
        r109 = r108;
        goto L22
    L17:
        r107 = r106;
        goto L18
    L13:
        r105 = r104;
        goto L14
    L9:
        r103 = r102;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }

    public static final f c(g r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        boolean r100 = h.a(r210, "sami_sync_realtime_call_enabled", false);
        String r101 = h.c(r210, "sami_auth_app_key");
        String r102 = h.c(r210, "sami_connect_pool_business");
        String r103 = h.c(r210, "sami_business_info");
        String r104 = h.c(r210, "sami_url_with_queries");
        String r110 = h.c(r210, "common_network_param");
        String r111 = h.c(r210, "sami_header");
        String r112 = h.c(r210, "sami_span_header");
        String r113 = h.c(r210, "sami_flow_trace_context");
        int r114 = h.b(r210, "sami_reconnect_timeout", 0);
        boolean r115 = h.a(r210, "sami_frontier_quic_enabled", false);
        String r116 = h.c(r210, "denoise_feature_enable");
        boolean r117 = h.a(r210, "sami_enable_transfer_retry", true);
        int r105 = h.b(r210, "sami_retry_ping_pong_timeout", 0);
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter("sami_retry_time_array", "key");
        String r106 = r210.f554467a.get("sami_retry_time_array");
        if (r106 != null) goto L41;
        String r211 = r113;
    L20:
        int[] r107 = null;
    L21:
        b r108 = new b(r117, r105, r107);
        Intrinsics.checkNotNullParameter(r210, "<this>");
        String r109 = r210.f554467a.get("sami_namespace");
        if (r109 != null) goto L24;
        r109 = "VoiceGenie";
    L24:
        String r118 = r109;
        String r119 = h.c(r210, "av_quic_connect_config");
        if ((!StringsKt.isBlank(r119)) == true) goto L28;
        r119 = null;
    L28:
        if (r119 != null) goto L43;
        c r120 = null;
    L40:
        return new f(r100, r101, r102, r103, r104, r110, r111, r112, r211, r114, r115, r108, r116, r118, r120);
    L43:
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L31
        v r122 = f554468a;     // Catch: Throwable -> L31
        r122.getClass();     // Catch: Throwable -> L31
        Object r123 = Result.m9449constructorimpl((c) r122.c(c.Companion.serializer(), r119));     // Catch: Throwable -> L31
    L34:
        if (Result.m9455isFailureimpl(r123) == false) goto L36;
        Object r124 = null;
    L37:
        r120 = (c) r124;
        goto L40
    L36:
        r124 = r123;
    L31:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L41:
        Result.Companion r212 = Result.Companion;     // Catch: Throwable -> L10
        ouc.a.C7114a r126 = ouc.a.f526798d;     // Catch: Throwable -> L10
        r126.getClass();     // Catch: Throwable -> L10
        r211 = r113;
        Object r127 = Result.m9449constructorimpl((int[]) r126.c(v0.f520787c, r106));     // Catch: Throwable -> L8
    L14:
        if (Result.m9455isFailureimpl(r127) == false) goto L16;
        r127 = null;
    L16:
        r107 = (int[]) r127;
        if (r107 != null) goto L21;
    L8:
        th = th;
    L12:
        Result.Companion r128 = Result.Companion;
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L10:
        th = th;
        r211 = r113;
        goto L12
    }

    public static final m d(g r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        return new m(h.a(r110, "sami_wakeup_enable", false), h.c(r110, "sami_wakeup_format"), h.b(r110, "sami_wakeup_decoder_length", 0), h.b(r110, "sami_wakeup_sample_rate", 0), h.b(r110, "sami_wakeup_channel_num", 0), h.b(r110, "sami_wakeup_bit_rate", 0), h.c(r110, "sami_wakeup_model_path"), h.c(r110, "sami_wakeup_model_file_md5"));
    }

    public static final n e(g r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new n(h.a(r100, "sami_scene_enable_no_input_hangup", false), h.b(r100, "sami_scene_no_input_hangup_time_second", 0), h.a(r100, "sami_scene_enable_scene_mode", false), h.a(r100, "sami_scene_enable_scene_mode_guide", false));
    }

    public static final o f(g r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        int r100 = h.b(r210, "sami_business", 0);
        d0 r101 = sf9.a.f(h.c(r210, "sami_session_extra"));
        int r102 = h.b(r210, "sami_request_type", 0);
        int r103 = h.b(r210, "sami_interrupt_type", 0);
        boolean r104 = h.a(r210, "sami_enable_pre_query", false);
        String r110 = h.c(r210, "sami_sub_conv_first_met_type");
        String r111 = h.c(r210, "sami_sub_conv_source_msg");
        l r112 = new l(h.c(r210, "sami_scene_type"), h.c(r210, "sami_scene_speaker_id"), h.b(r210, "sami_listening_waiting_time", 0));
        boolean r113 = h.a(r210, "sami_session_dora_enable_burst", false);
        boolean r114 = h.a(r210, "sami_session_dora_enable_touch", false);
        String r115 = h.c(r210, "sami_session_chat");
        String r116 = h.c(r210, "sami_session_vui_id");
        int r117 = h.b(r210, "sami_session_dora_wake_mode", 0);
        k r105 = new k(0);
        r105.f554469a = h.a(r210, "sami_session_enable_one_shot", false);
        String r118 = h.c(r210, "sami_oneshot_keyword");
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r105.f554470b = r118;
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter("sami_oneshot_offset_time", "key");
        String r106 = r210.f554467a.get("sami_oneshot_offset_time");
        if (r106 != null) goto L17;
    L14:
        long r211 = 0;
    L15:
        r105.f554471c = r211;
        int r212 = h.b(r210, "sami_session_dora_vision_query_mode", 0);
        boolean r213 = h.a(r210, "sami_session_enable_one_shot", false);
        d r214 = g(r210);
        boolean r215 = h.a(r210, "sami_is_first_enter_si", false);
        String r216 = h.c(r210, "sami_nc_iuctc_path");
        int r107 = h.b(r210, "modal_type", 0);
        boolean r119 = h.a(r210, "is_realtime_new_background_enabled", false);
        String r217 = h.c(r210, "sami_ast_channels");
        return new o(r100, r101, Integer.valueOf(r103), r102, r104, r110, r111, r112, r115, r116, r114, r113, Integer.valueOf(r107), r119, r117, r212, r213, r215, r105, r216, r214, r217);
    L17:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L6
        Object r109 = Result.m9449constructorimpl(Long.valueOf(CastLongProtector.parseLong(r106)));     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r109) == false) goto L11;
        r109 = null;
    L11:
        Long r120 = (Long) r109;
        if (r120 == null) goto L14;
        r211 = r120.longValue();
    L6:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static final d g(g r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        d0 r100 = sf9.a.f(h.c(r110, "sami_session_chat"));
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r101 = r110.f554467a.get("conversation_id");
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r103 = r110.f554467a.get("user_id");
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        String r105 = h.c(r110, "sami_call_id");
        String r106 = sf9.a.c(r100, "local_call_id", "");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r107 = r110.f554467a.get("bot_id");
        if (r107 != null) goto L13;
        String r108 = "";
    L14:
        String r111 = sf9.a.c(r100, "wake_word", "");
        boolean r112 = sf9.a.a(r100, "is_conf_fetched", false);
        String r113 = h.c(r110, "last_section_id");
        String r114 = h.c(r110, "last_message_index");
        String r115 = sf9.a.c(r100, AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, "");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("extra", "key");
        Object r109 = r100.get("extra");
        if ((r109 instanceof d0) == false) goto L17;
        d0 r116 = (d0) r109;
    L18:
        if (r116 == null) goto L32;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        Set<Map.Entry<String, ouc.i>> r117 = r116.entrySet();
        LinkedHashMap r118 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r117, 10)), 16));
        Iterator<T> r119 = r117.iterator();
    L21:
        if (r119.hasNext() == false) goto L31;
        Map.Entry r120 = (Map.Entry) r119.next();
        String r121 = (String) r120.getKey();
        ouc.i r122 = (ouc.i) r120.getValue();
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L25
        Object r124 = Result.m9449constructorimpl(ouc.k.o(r122).a());     // Catch: Throwable -> L25
    L27:
        String r125 = r122.toString();
        if (Result.m9455isFailureimpl(r124) == false) goto L30;
        r124 = r125;
    L30:
        Pair r126 = TuplesKt.to(r121, r124);
        r118.put(r126.getFirst(), r126.getSecond());
    L25:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L31:
        Map r128 = r118;
    L34:
        return new d(r102, r104, r105, r106, r108, r111, r112, r113, r114, r115, r128);
    L32:
        r128 = MapsKt.emptyMap();
        goto L34
    L17:
        r116 = null;
        goto L18
    L13:
        r108 = r107;
        goto L14
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }

    public static final p h(g r210) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        String r100 = h.c(r210, "sami_tts_audio_format");
        String r101 = h.c(r210, "sami_tts_speaker");
        boolean r102 = h.a(r210, "sami_tts_enable_compress", false);
        int r103 = h.b(r210, "sami_tts_bit_rate", 0);
        int r104 = h.b(r210, "sami_tts_sample_rate", 0);
        String r105 = h.c(r210, "sami_loudness_meta_data");
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Intrinsics.checkNotNullParameter("sami_tts_target_lufs", "key");
        String r106 = r210.f554467a.get("sami_tts_target_lufs");
        if (r106 != null) goto L17;
    L14:
        float r110 = 0.0f;
    L16:
        return new p(r100, r101, r102, r103, r104, r105, h.c(r210, "sami_loudness_device_ai_data"), r110, h.b(r210, "sami_loudness_loud_norm_algo_type", 0), h.c(r210, "sami_tts_loudness_audio_dump_path"), h.c(r210, "sami_tts_extra"), h.a(r210, "sami_enable_player", false), h.c(r210, "sami_si_src_language"), h.c(r210, "sami_si_dst_language"), h.c(r210, "sami_si_scene"), h.c(r210, "sami_speaker_clone"), 2);
    L17:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L6
        Object r108 = Result.m9449constructorimpl(Float.valueOf(CastFloatProtector.parseFloat(r106)));     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r108) == false) goto L11;
        r108 = null;
    L11:
        Float r109 = (Float) r108;
        if (r109 == null) goto L14;
        r110 = r109.floatValue();
    L6:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }
}
