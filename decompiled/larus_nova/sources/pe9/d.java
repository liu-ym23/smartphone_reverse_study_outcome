package pe9;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.service.audio.cmd.ReplyEndType;
import com.larus.im.service.audio.cmd.ReplyStage;
import com.larus.im.service.audio.cmd.ReplyType;
import com.larus.im.service.audio.z0;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreServerEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pf9.e0;
import pf9.f0;
import pf9.m;
import pf9.v;

/* JADX INFO: loaded from: classes30.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f528726a;

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public abstract List<z0.a> c(SAMICoreCallBackEventType r100, SAMICoreBlock r101, SAMICoreServerEvent r102, e r103);

    public static JSONObject e(SAMICoreBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Object r101 = ArraysKt.firstOrNull(r100.audioData);
        if ((r101 instanceof SAMICoreServerEvent) == false) goto L5;
        SAMICoreServerEvent r102 = (SAMICoreServerEvent) r101;
    L6:
        if (r102 != null) goto L9;
        return null;
    L9:
        return com.flow.kmp.common.util.g.b(r102.textMsg);
    L5:
        r102 = null;
        goto L6
    }

    public static z0.a a(ReplyEndType r100, SAMICoreBlock r101) {
        Intrinsics.checkNotNullParameter(r100, "endType");
        Intrinsics.checkNotNullParameter(r101, "data");
        JSONObject r102 = e(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        boolean r103 = r102.optBoolean("no_content");
        boolean r104 = false;
        if (r100 != ReplyEndType.Pushed) goto L10;
        return new e0(r103, false);
    L10:
        if (r100 != ReplyEndType.Generated) goto L13;
        return new v(r103);
    L13:
        if (r100 != ReplyEndType.NoReply) goto L16;
        r104 = true;
    L16:
        return new e0(r103, r104);
    }

    public static f0 b(SAMICoreBlock r210, ReplyStage r211) {
        Intrinsics.checkNotNullParameter(r210, "data");
        Intrinsics.checkNotNullParameter(r211, "stage");
        JSONObject r100 = e(r210);
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashMap r101 = new LinkedHashMap();
        String r102 = b.f528723a;
        r101.put("sentence_id", b.f528723a);
        r101.put("text", r100.optString("text"));
        r101.put("tts_task_id", r100.optString("tts_task_id"));
        r101.put("silence_context", r100.optString("silence_context"));
        r101.put("with_draw_content", r100.optString("with_draw_content"));
        r101.put("tts_content_scene", r100.optString("tts_content_scene"));
        Object r103 = ArraysKt.firstOrNull(r210.audioData);
        if ((r103 instanceof SAMICoreServerEvent) == false) goto L8;
        SAMICoreServerEvent r104 = (SAMICoreServerEvent) r103;
    L9:
        if (r104 == null) goto L11;
        String r105 = r104.messageId;
    L12:
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        r101.put(MusicAppletPage.KEY_MESSAGE_ID, r105);
        r101.put("first_tts_latency", r100.optString("first_tts_latency"));
        return new f0(ReplyType.Sentence, null, new m(r101, r100.optLong("first_audio_gen_duration"), r100.optLong("first_audio_serv_send_ts"), r100.optLong("receive_speech_query_at"), r100.optLong("send_chat_resp_to_speech_at"), r100.optLong("first_chat_resp_duration"), r100.optLong("first_tts_resp_duration"), r100.optLong("flow_server_process_duration"), r100.optString("intention")), r211);
    L11:
        r105 = null;
        goto L12
    L8:
        r104 = null;
        goto L9
    }

    public final List<z0.a> d(SAMICoreCallBackEventType r100, SAMICoreBlock r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r103 = ArraysKt.firstOrNull(r101.audioData);
        if ((r103 instanceof SAMICoreServerEvent) == false) goto L5;
        SAMICoreServerEvent r104 = (SAMICoreServerEvent) r103;
    L6:
        List<z0.a> r105 = c(r100, r101, r104, r102);
        if ((!r105.isEmpty()) == false) goto L9;
        return r105;
    L9:
        d r106 = this.f528726a;
        if (r106 == null) goto L14;
        List<z0.a> r107 = r106.d(r100, r101, r102);
        if (r107 == null) goto L14;
        return r107;
    L14:
        return CollectionsKt.emptyList();
    L5:
        r104 = null;
        goto L6
    }
}
