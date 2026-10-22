package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hg6.g;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$15 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$15(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "setRuntimeParameters", "setRuntimeParameters(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r5 = r4.get("jsonStr");
        if (r5 == null) goto L5;
        String r6 = r5.getAsString();
    L6:
        ChorusJsbService.g("setRuntimeParameters, jsonStr: " + r6);
        if (r6 != null) goto L24;
    L22:
        xe2.a.i(r6);
        return new JsonObject();
    L24:
        j1 r2 = r0.e();     // Catch: Exception -> L20
        if (r2 == null) goto L22;
        cg6.a r3 = r2.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);     // Catch: Exception -> L20
        if (r3 == null) goto L22;
        g r7 = r3.getRtcManager();     // Catch: Exception -> L20
        if (r7 == null) goto L22;
        ei6.a r8 = r7.V0();     // Catch: Exception -> L20
        if (r8 == null) goto L22;
        si6.b r9 = r8.b();     // Catch: Exception -> L20
        if (r9 == null) goto L22;
        r9.d(new JSONObject(r6));     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ALogger.e("ChorusJsbService", "setRuntimeParameters, jsonStr: " + r6 + ", exception: " + e);
        goto L22
    L5:
        r6 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
