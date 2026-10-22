package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f435443b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f435444c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f435445d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f435446e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f435447f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c f435448a;

    public static final class a {
        public a() {
        }

        public static void b(JSONObject r110) {
            Intrinsics.checkNotNullParameter(r110, "params");
            if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == true) goto L5;
            return;
        L5:
            String r100 = r110.optString("action_name");
            if (r100 != null) goto L8;
        L32:
            List<String> r101 = CollectionsKt.emptyList();
        L33:
            List r102 = CollectionsKt.plus(i.f435443b, r101);
            ArrayList r103 = new ArrayList();
            Iterator r104 = r102.iterator();
        L35:
            if (r104.hasNext() == false) goto L54;
            String r105 = (String) r104.next();
            List<String> r106 = i.f435443b;
            String r107 = null;
            if (r110.has(r105) == false) goto L52;
            Object r108 = r110.opt(r105);
            if (r108 == null) goto L42;
            String r109 = r108.toString();
        L43:
            if (r109 != null) goto L46;
            r109 = "";
        L46:
            if (r109.length() != 0) goto L48;
            boolean r111 = true;
        L49:
            if (r111 == true) goto L52;
            r107 = r105 + com.alipay.sdk.m.n.a.f25612h + r109;
            goto L52
        L48:
            r111 = false;
            goto L49
        L42:
            r109 = null;
        L52:
            if (r107 == null) goto L35;
            r103.add(r107);
            goto L35
        L54:
            lvb.a.e("MmRecordingDiagnosisTracker", "[diagnosis_event] " + CollectionsKt.joinToString$default(r103, ", ", null, null, 0, null, null, 62, null));
            return;
        L8:
            switch(r100.hashCode()) {
                case -737346698: goto L29;
                case -600415528: goto L26;
                case 294297342: goto L22;
                case 1228886738: goto L18;
                case 1295680288: goto L15;
                case 1801277313: goto L11;
                default: goto L32;
            };
        L11:
            if (r100.equals("recording_exception") == false) goto L32;
            r101 = i.f435446e;
            goto L33
        L15:
            if (r100.equals("recording_lifecycle_invalid_transition") == false) goto L32;
        L27:
            r101 = i.f435444c;
            goto L33
        L18:
            if (r100.equals("recording_rtc_stage") == false) goto L32;
            r101 = CollectionsKt.listOf(new String[]{"rtc_stage", "stage_status", "result_code", "result_source"});
            goto L33
        L22:
            if (r100.equals("recording_upload_segment_batch") == false) goto L32;
            r101 = CollectionsKt.listOf(new String[]{"batch_sequence", "batch_size", "flush_reason"});
            goto L33
        L26:
            if (r100.equals("recording_lifecycle_transition") == false) goto L32;
        L29:
            if (r100.equals("recording_upload_summary") == false) goto L32;
            r101 = i.f435445d;
            goto L33
        }

        public static void c(MmRecordingCommonParam r210, String r211, String r212, String r213, Integer r214, String r215, String r216, Integer r217, Integer r218, String r310, Integer r311, String r312, Boolean r313, String r314, Long r315, int r316) {
            List<String> r100 = i.f435443b;
            if ((r316 & 16) == 0) goto L5;
            Integer r101 = null;
        L7:
            if ((r316 & 32) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r316 & 64) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r316 & 128) == 0) goto L17;
            Integer r110 = null;
        L19:
            if ((r316 & 256) == 0) goto L21;
            Integer r111 = null;
        L23:
            if ((r316 & 512) == 0) goto L25;
            String r112 = "";
        L27:
            if ((r316 & 1024) == 0) goto L29;
            Integer r113 = null;
        L31:
            if ((r316 & 2048) == 0) goto L33;
            String r114 = "";
        L35:
            if ((r316 & 4096) == 0) goto L37;
            Boolean r115 = null;
        L39:
            if ((r316 & 8192) == 0) goto L41;
            String r104 = "";
        L43:
            if ((32768 & r316) == 0) goto L45;
            String r105 = "";
        L47:
            if ((r316 & 65536) == 0) goto L49;
            Long r116 = null;
        L50:
            Intrinsics.checkNotNullParameter(r210, "commonParam");
            Intrinsics.checkNotNullParameter(r211, "source");
            Intrinsics.checkNotNullParameter(r212, "exceptionStage");
            Intrinsics.checkNotNullParameter(r213, "severity");
            Intrinsics.checkNotNullParameter(r102, "errorMsg");
            Intrinsics.checkNotNullParameter(r103, "requestPath");
            Intrinsics.checkNotNullParameter(r112, "logId");
            Intrinsics.checkNotNullParameter(r114, "errorMessage");
            Intrinsics.checkNotNullParameter(r104, "state");
            Intrinsics.checkNotNullParameter(r105, "responseName");
            String r117 = r104;
            JSONObject r106 = a(r210, r211, r212, r213, r101, r102, r103, r110, r111, r112, r113, r114, r115, r117, null, r105, r116, 131072);
            b(r106);
            new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c(null, 3);
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.h("minutes_recording_dev", r106);
            return;
        L49:
            r116 = r315;
            goto L50
        L45:
            r105 = r314;
            goto L47
        L41:
            r104 = null;
            goto L43
        L37:
            r115 = r313;
            goto L39
        L33:
            r114 = r312;
            goto L35
        L29:
            r113 = r311;
            goto L31
        L25:
            r112 = r310;
            goto L27
        L21:
            r111 = r218;
            goto L23
        L17:
            r110 = r217;
            goto L19
        L13:
            r103 = r216;
            goto L15
        L9:
            r102 = r215;
            goto L11
        L5:
            r101 = r214;
            goto L7
        }

        public static JSONObject a(MmRecordingCommonParam r210, String r211, String r212, String r213, Integer r214, String r215, String r216, Integer r217, Integer r218, String r310, Integer r311, String r312, Boolean r313, String r314, Integer r315, String r316, Long r317, int r318) {
            List<String> r100 = i.f435443b;
            Long r101 = null;
            if ((r318 & 32) == 0) goto L5;
            Integer r102 = null;
        L6:
            String r103 = "";
            if ((r318 & 64) == 0) goto L9;
            String r104 = "";
        L11:
            if ((r318 & 128) == 0) goto L13;
            String r105 = "";
        L15:
            if ((r318 & 256) == 0) goto L17;
            Integer r106 = null;
        L19:
            if ((r318 & 512) == 0) goto L21;
            Integer r110 = null;
        L23:
            if ((r318 & 1024) == 0) goto L25;
            String r111 = "";
        L27:
            if ((r318 & 2048) == 0) goto L29;
            Integer r112 = null;
        L31:
            if ((r318 & 4096) == 0) goto L33;
            String r113 = "";
        L35:
            if ((r318 & 8192) == 0) goto L37;
            Boolean r114 = null;
        L39:
            if ((r318 & 16384) == 0) goto L41;
            String r115 = "";
        L43:
            if ((r318 & 32768) == 0) goto L45;
            Integer r116 = null;
        L47:
            if ((r318 & 65536) != 0) goto L51;
            r103 = r316;
        L51:
            if ((r318 & 131072) == 0) goto L53;
            long r117 = System.currentTimeMillis();
        L54:
            long r118 = r117;
            if ((r318 & 262144) != 0) goto L58;
            r101 = r317;
        L58:
            Long r219 = r101;
            Intrinsics.checkNotNullParameter("recording_exception", "actionName");
            Boolean r220 = r114;
            Intrinsics.checkNotNullParameter(r210, "commonParam");
            Intrinsics.checkNotNullParameter(r211, "source");
            Intrinsics.checkNotNullParameter(r212, "exceptionStage");
            Intrinsics.checkNotNullParameter(r213, "severity");
            Integer r221 = r110;
            Intrinsics.checkNotNullParameter(r104, "errorMsg");
            Intrinsics.checkNotNullParameter(r105, "requestPath");
            Intrinsics.checkNotNullParameter(r111, "logId");
            Intrinsics.checkNotNullParameter(r113, "errorMessage");
            Intrinsics.checkNotNullParameter(r115, "state");
            Intrinsics.checkNotNullParameter(r103, "responseName");
            com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r119 = r210.asRecordingDevTrackerParams();
            Integer r222 = r106;
            r119.e("action_name", "recording_exception");
            Integer r223 = r112;
            String r107 = r113;
            r119.c("event_time_ms", r118);
            r119.e("source", r211);
            r119.e("exception_stage", r212);
            r119.e("severity", r213);
            r119.e("error_msg", r104);
            r119.e("request_path", r105);
            r119.e(CronetDataStorageAccess.LOGID, r111);
            boolean r108 = true;
            if (r103.length() <= 0) goto L61;
            boolean r109 = true;
        L62:
            if (r109 == false) goto L65;
            r119.e("response_name", r103);
        L65:
            if (r115.length() <= 0) goto L67;
            boolean r120 = true;
        L68:
            if (r120 == false) goto L70;
            r119.e("latest_state", r115);
        L70:
            if (r102 == null) goto L72;
            r119.b("error_code", r102.intValue());
        L72:
            if (r223 == null) goto L75;
            r119.b("error_status", r223.intValue());
        L75:
            if (r107.length() > 0) goto L78;
            r108 = false;
        L78:
            if (r108 == false) goto L80;
            r119.e("error_message", r107);
        L80:
            if (r222 == null) goto L82;
            r119.b("http_error_code", r222.intValue());
        L82:
            if (r221 == null) goto L84;
            r119.b("biz_error_code", r221.intValue());
        L84:
            if (r220 == null) goto L86;
            r119.b("network_available", r220.booleanValue() ? 1 : 0);
        L86:
            if (r116 == null) goto L88;
            r119.b("seg_index", r116.intValue());
        L88:
            if (r219 == null) goto L91;
            r119.c("latency_ms", r219.longValue());
        L91:
            return r119.a();
        L67:
            r120 = false;
            goto L68
        L61:
            r109 = false;
            goto L62
        L53:
            r117 = 0;
            goto L54
        L45:
            r116 = r315;
            goto L47
        L41:
            r115 = r314;
            goto L43
        L37:
            r114 = r313;
            goto L39
        L33:
            r113 = r312;
            goto L35
        L29:
            r112 = r311;
            goto L31
        L25:
            r111 = r310;
            goto L27
        L21:
            r110 = r218;
            goto L23
        L17:
            r106 = r217;
            goto L19
        L13:
            r105 = r216;
            goto L15
        L9:
            r104 = r215;
            goto L11
        L5:
            r102 = r214;
            goto L6
        }
    }

    static {
        new a();
        f435443b = CollectionsKt.listOf(new String[]{"action_name", "recording_trace_id", "record_id", "event_time_ms"});
        f435444c = CollectionsKt.listOf(new String[]{"state_sequence", "from_state", "to_state", "event", "terminate_reason"});
        f435445d = CollectionsKt.listOf(new String[]{"summary_stage", com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, "success_count", "failed_count", "retry_count", "discard_count", "progress", "terminate_reason"});
        f435446e = CollectionsKt.listOf(new String[]{"exception_stage", "severity", "error_code", "error_status", "error_message", "response_name", "seg_index"});
        f435447f = SetsKt.setOf(new String[]{"event_time_ms", "recording_start_time_ms", "state_sequence", "duration_in_state_ms", "latency_ms", "result_code", "batch_sequence", "batch_size", "seg_index", "start_time_ms", "part_duration_ms", "file_size", MapMonitorConst.ATTEMPT, "http_code", "status_code", "queue_size", "running_count", com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, "success_count", "failed_count", "retry_count", "discard_count", "progress", "is_incomplete", "error_code", "error_status", "http_error_code", "biz_error_code", "network_available"});
    }

    public i(com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r100) {
        Intrinsics.checkNotNullParameter(r100, "businessTracker");
        this.f435448a = r100;
    }

    public final void b(JSONObject r100) {
        a.b(r100);
        this.f435448a.getClass();
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.h("minutes_recording_dev", r100);
    }

    public static com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d a(i r210, MmRecordingSession r211, String r212, String r213, long r214) {
        long r100 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r211, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r212, "actionName");
        Intrinsics.checkNotNullParameter(r213, "latestStateName");
        ovb.b r101 = r211.f434119w;
        MmRecordingCommonParam r102 = r211.j();
        String r103 = r102.getRecordId();
        boolean r215 = true;
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        r103 = r101.f526982a;
    L9:
        if (r103.length() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L15;
        r103 = r101.f526988g;
    L15:
        if (r103.length() != 0) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        r103 = r211.e();
    L20:
        String r110 = r102.getMeetingId();
        if (r110.length() != 0) goto L23;
        boolean r111 = true;
    L24:
        if (r111 == false) goto L26;
        r110 = r101.f526982a;
    L26:
        String r112 = r211.f434099c;
        MmRecordingSource r113 = r102.getSource();
        Long r216 = null;
        if (r113 != null) goto L32;
        iub.k r114 = r211.f434102f;
        if (r114 == null) goto L31;
        r113 = r114.f495846a;
        goto L32
    L31:
        r113 = null;
    L32:
        String r115 = r102.getSessionType();
        if (r115.length() != 0) goto L35;
        boolean r116 = true;
    L36:
        if (r116 == false) goto L38;
        r115 = r211.f434097a.name();
    L38:
        MmRecordingCommonParam r107 = MmRecordingCommonParam.copy$default(r102, null, r103, false, null, r110, null, r112, r113, null, null, r115, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD, null);
        MmRecordingSource r108 = r107.getSource();
        if (r108 == null) goto L42;
        String r109 = r108.getValue();
        if (r109 == null) goto L42;
    L50:
        Long r117 = Long.valueOf(r101.f526983b);
        if (r117.longValue() > 0) goto L54;
        r215 = false;
    L54:
        if (r215 == false) goto L56;
        r216 = r117;
    L56:
        if (r216 == null) goto L58;
        long r118 = r216.longValue();
    L59:
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r119 = r107.asRecordingDevTrackerParams();
        r119.e("action_name", r212);
        r119.c("event_time_ms", r100);
        r119.e("meeting_id", r107.getMeetingId());
        r119.e("minutes_token", r107.getToken());
        r119.e("source", r109);
        r119.e("is_hardware", String.valueOf(r107.isHardware()));
        r119.c("recording_start_time_ms", r118);
        r119.e("latest_state", r213);
        return r119;
    L58:
        r118 = r214;
    L42:
        iub.k r120 = r211.f434102f;
        if (r120 == null) goto L47;
        MmRecordingSource r121 = r120.f495846a;
        if (r121 == null) goto L47;
        r109 = r121.getValue();
    L48:
        if (r109 != null) goto L50;
        r109 = "";
    L47:
        r109 = null;
        goto L48
    L35:
        r116 = false;
        goto L36
    L23:
        r111 = false;
        goto L24
    L17:
        r106 = false;
        goto L18
    L11:
        r105 = false;
        goto L12
    L5:
        r104 = false;
        goto L6
    }
}
