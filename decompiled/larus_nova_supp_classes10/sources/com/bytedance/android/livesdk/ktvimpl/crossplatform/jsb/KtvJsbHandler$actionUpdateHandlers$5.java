package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xe2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvJsbHandler$actionUpdateHandlers$5 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public KtvJsbHandler$actionUpdateHandlers$5(b r8) {
        super(1, r8, b.class, "seekMusic", "seekMusic(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r14) {
        Intrinsics.checkNotNullParameter(r14, "p1");
        b r0 = (b) ((CallableReference) this).receiver;
        int r1 = b.g;
        r0.getClass();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvJsbHandler", "seekMusic, progress: " + r14);
        JsonObject r2 = new JsonObject();
        JsonElement r3 = r14.get("current_time");
        if (r3 == null) goto L5;
        long r6 = r3.getAsLong();
    L6:
        long r8 = System.currentTimeMillis() - r6;
        JsonElement r15 = r14.get("progress");
        if (r15 == null) goto L20;
        long r7 = r15.getAsLong();
        if (r8 > 0) goto L11;
    L15:
        long r4 = r7;
    L16:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvJsbHandler", "seekMusic, source progress: " + r7 + ", diff: " + r8 + ", target progress: " + r4);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b r16 = r0.c();
        if (r16 == null) goto L19;
        r16.f();
    L19:
        int r17 = g.a;
        JSONObject r11 = new JSONObject();
        r11.put("progress", r4);
        int r18 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.JoinChorus, "SeekMusic", 0, null, r11, 88);
        goto L20
    L11:
        if (r8 >= ((Number) r0.a.getValue()).intValue()) goto L15;
        if (r7 <= 0) goto L15;
        r4 = r7 + r8;
    L20:
        return r2;
    L5:
        r6 = 0;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
