package com.larus.audio.flow.client.mob;

import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import h68.e;
import j78.a;
import j78.b;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class FlowAudioAsrAndTTSCostMobHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f289760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f289761b = null;

    static {
        f289760a = LazyKt.lazy(new a());
        f289761b = LazyKt.lazy(new b());
    }

    public static void a(y58.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        JSONObject r101 = (JSONObject) ((FlowAudioAsrAndTTSCostMobHelper$asrMap$2$1) f289760a.getValue()).get(r100.f566268a);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.has("on_asr_end") == true) goto L15;
        ConcurrentHashMap<String, e> r102 = g68.a.f480171a;
        y58.a r103 = g68.a.c(r100.f566268a);
        if (r103 == null) goto L9;
        String r104 = r103.f566266y;
    L10:
        r101.put("err_code", r100.f566269b);
        r101.put(LocationMonitorConst.ERR_MSG, r100.f566270c);
        r101.put("bot_id", r104);
        r101.put("on_asr_end", SystemClock.elapsedRealtime());
        s r105 = h.f512131b;
        if (r105 == null) goto L16;
        r105.report("flow_asr_recog_trace", r101);
        return;
    L16:
        return;
    L9:
        r104 = null;
        goto L10
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        JSONObject r101 = (JSONObject) ((FlowAudioAsrAndTTSCostMobHelper$ttsMap$2$1) f289761b.getValue()).get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.has("on_start_tts_to_sami") == true) goto L9;
        r101.put("on_start_tts_to_sami", SystemClock.elapsedRealtime());
        return;
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "funcChannel");
        FlowAudioAsrAndTTSCostMobHelper$ttsMap$2$1 r102 = (FlowAudioAsrAndTTSCostMobHelper$ttsMap$2$1) f289761b.getValue();
        JSONObject r103 = new JSONObject();
        r103.put("start_tts_wait", SystemClock.elapsedRealtime());
        r103.put("func_channel", r101);
        r103.put("msg_id", r100);
        r102.put(r100, r103);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "funcChannel");
        FlowAudioAsrAndTTSCostMobHelper$asrMap$2$1 r102 = (FlowAudioAsrAndTTSCostMobHelper$asrMap$2$1) f289760a.getValue();
        JSONObject r103 = new JSONObject();
        r103.put("start_asr_recog_delay", SystemClock.elapsedRealtime());
        r103.put("func_channel", r101);
        r103.put("task_id", r100);
        r102.put(r100, r103);
    }
}
