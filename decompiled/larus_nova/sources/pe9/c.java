package pe9;

import com.larus.im.internal.utils.n;
import com.larus.im.service.audio.z0;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import pf9.a0;
import pf9.c0;
import pf9.h0;
import pf9.z;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f528724b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f528725a = null;

        static {
            int[] r100 = new int[SAMICoreCallBackEventType.values().length];
            r100[SAMICoreCallBackEventType.ASRInfo.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[SAMICoreCallBackEventType.ASRResponse.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[SAMICoreCallBackEventType.ASREnded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[SAMICoreCallBackEventType.EventReplaceResult.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f528725a = r100;
        }
    }

    public c() {
        this.f528724b = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // pe9.d
    public final List<z0.a> c(SAMICoreCallBackEventType r310, SAMICoreBlock r311, SAMICoreServerEvent r312, e r313) {
        Intrinsics.checkNotNullParameter(r310, "type");
        Intrinsics.checkNotNullParameter(r311, "data");
        Intrinsics.checkNotNullParameter(r313, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r100 = new ArrayList();
        int r101 = a.f528725a[r310.ordinal()];
        ?? r102 = "";
        Object r103 = null;
        if (r101 != 1) goto L5;
        r313.f528728b = true;
        Intrinsics.checkNotNullParameter(r311, "data");
        JSONObject r104 = d.e(r311);
        if (r104 != null) goto L80;
        z r105 = null;
    L81:
        if (r105 == null) goto L83;
        r100.add(r105);
    L84:
        if (r105 == null) goto L86;
        r103 = r105.f528981b;
    L86:
        if (r103 == null) goto L89;
        r102 = r103;
    L89:
        this.f528724b = r102;
    L90:
        return r100;
    L83:
        r105 = null;
        goto L84
    L80:
        r105 = new z(r104.optString(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID), r104.optString("asr_task_id"), r104.optLong("round_id"), r104.optLong("start_listen_timestamp_ms"), r104.optString("local_message_id"), r104.optBoolean("continue_tts"));
        goto L81
    L5:
        if (r101 != 2) goto L7;
        String r106 = this.f528724b;
        Intrinsics.checkNotNullParameter(r311, "data");
        Intrinsics.checkNotNullParameter(r106, "asrTaskId");
        Object r107 = ArraysKt.firstOrNull(r311.audioData);
        if ((r107 instanceof SAMICoreServerEvent) == false) goto L39;
        SAMICoreServerEvent r108 = (SAMICoreServerEvent) r107;
    L40:
        if (r108 == null) goto L75;
        JSONObject r109 = d.e(r311);
        if (r109 == null) goto L75;
        JSONArray r110 = r109.optJSONArray("results");
        if (r110 == null) goto L75;
        JSONObject r111 = r110.optJSONObject(0);
        if (r111 == null) goto L75;
        JSONObject r112 = r109.optJSONObject("extra");
        if (r112 == null) goto L53;
        String r113 = r112.optString("sv_result");
    L54:
        if (r113 != null) goto L56;
        r113 = "";
    L56:
        LinkedHashMap r114 = new LinkedHashMap();
        JSONObject r115 = r109.optJSONObject("extra");
        if (r115 == null) goto L59;
        Map<String, String> r116 = n.b(r115);
    L60:
        r114.putAll(r116);
        r114.put("sv_result", r113);
        JSONObject r117 = r109.optJSONObject("extra");
        if (r117 == null) goto L63;
        String r118 = r117.optString("semantic_integrity_seg");
    L64:
        if (r118 != null) goto L66;
        r118 = "";
    L66:
        r114.put("semantic_integrity_seg", r118);
        String r119 = r108.extra;
        if (r119 == null) goto L71;
        JSONObject r120 = com.flow.kmp.common.util.g.b(r119);
        if (r120 == null) goto L71;
        r103 = r120.optString("command_list");
    L71:
        if (r103 == null) goto L74;
        r102 = r103;
    L74:
        r114.put("command_list", r102);
        r103 = new c0(new pf9.a(r111.optString("text"), r111.optBoolean("is_interim", true), r106, r114));
        goto L75
    L63:
        r118 = null;
        goto L64
    L59:
        r116 = MapsKt.emptyMap();
        goto L60
    L53:
        r113 = null;
    L75:
        if (r103 == null) goto L90;
        r100.add(r103);
        goto L90
    L39:
        r108 = null;
        goto L40
    L7:
        if (r101 != 3) goto L9;
        Intrinsics.checkNotNullParameter(r311, "data");
        JSONObject r121 = d.e(r311);
        if (r121 == null) goto L34;
        long r122 = r121.optLong("user_duration");
        long r123 = r121.optLong("last_resp_cost_time");
        boolean r124 = r121.optBoolean("no_content");
        long r125 = r121.optLong("comfort_wait_time");
        r103 = new a0(r122, Long.valueOf(r123), r124, r121.optBoolean("trigger_bot"), r125, r121.optLong("soft_vad_timestamp_ms"), r121.optLong("hard_vad_timestamp_ms"), r121.optBoolean("is_prequery"), r121.optLong("prefetch_backtrack_time"), r121.optLong("last_user_audio_timestamp_ms"), r121.optLong("user_last_audio_client_timestamp_ms"), r121.optLong("answer_start_duration"), r121.optBoolean("hit_pre_resp"), r121.optLong("asr_duration"));
    L34:
        if (r103 == null) goto L90;
        r100.add(r103);
        goto L90
    L9:
        if (r101 != 4) goto L90;
        Intrinsics.checkNotNullParameter(r311, "data");
        JSONObject r126 = d.e(r311);
        if (r126 == null) goto L28;
        fe9.a.f476620a.e("SamiDownLinkMapper", "receive security check body:" + r126);
        String r127 = r126.optString("ast_seq_id");
        if (r127 != null) goto L17;
        r127 = "";
    L17:
        String r128 = r126.optString("asr_replace_content");
        if (r128 != null) goto L20;
        r128 = "";
    L20:
        String r129 = r126.optString("chat_replace_content");
        if (r129 != null) goto L23;
        r129 = "";
    L23:
        String r130 = r126.optString("src_channel");
        ?? r131 = r102;
        if (r130 == null) goto L27;
        r131 = r130;
    L27:
        r103 = new h0(r127, r128, r129, r131);
    L28:
        if (r103 == null) goto L90;
        r100.add(r103);
        goto L90
    }
}
