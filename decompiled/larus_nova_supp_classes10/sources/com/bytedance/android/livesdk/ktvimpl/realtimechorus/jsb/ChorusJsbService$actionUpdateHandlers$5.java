package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vb6.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$5 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$5(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "initLiveClient", "initLiveClient(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r13) {
        Intrinsics.checkNotNullParameter(r13, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonObject r2 = new JsonObject();
        if (r13 == null) goto L7;
        JsonElement r3 = r13.get("live_core_ext_info");
        if (r3 == null) goto L7;
        String r4 = r3.getAsString();
    L9:
        if (r13 == null) goto L14;
        JsonElement r14 = r13.get("source");
        if (r14 == null) goto L14;
        String r15 = r14.getAsString();
        if (r15 == null) goto L14;
    L15:
        ChorusJsbService.g("initLiveClient, extInfo: " + r4 + ", source: " + r15);
        if (r4 == null) goto L25;
        j1 r5 = r0.e();
        if (r5 == null) goto L24;
        cg6.a r6 = r5.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r6 == null) goto L24;
        g r7 = r6.O5();
        if (r7 == null) goto L24;
        r7.W0(r4, r15);
    L24:
        int r8 = xe2.a.a;
        Intrinsics.checkNotNullParameter(r15, "source");
        JSONObject r10 = new JSONObject();
        r10.put("live_core_ext_info", r4);
        r10.put("source", r15);
        int r16 = rd0.a.a;
        rd0.a.b(xe2.a.c(), MultiTraceData.TraceEvent.JoinChorus, "initLiveClient", 0, null, r10, 88);
    L25:
        return r2;
    L14:
        r15 = "";
    L7:
        r4 = null;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
