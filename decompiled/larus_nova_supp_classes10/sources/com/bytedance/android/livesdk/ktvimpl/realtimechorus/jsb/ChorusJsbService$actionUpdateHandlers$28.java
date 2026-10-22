package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.ChorusStreamMixService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$28 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$28(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "startExtraStreamMixTask", "startExtraStreamMixTask(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r5) {
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        String r2 = "";
        if (r5 == null) goto L8;
        JsonElement r3 = r5.get("task_id");
        if (r3 == null) goto L8;
        String r4 = r3.getAsString();
        if (r4 == null) goto L8;
    L9:
        if (r5 == null) goto L16;
        JsonElement r6 = r5.get("stream_url");
        if (r6 == null) goto L16;
        String r7 = r6.getAsString();
        if (r7 == null) goto L16;
        r2 = r7;
    L16:
        ChorusStreamMixService r8 = r0.c;
        if (r8 == null) goto L20;
        r8.b(r4, r2);
    L20:
        return new JsonObject();
    L8:
        r4 = "";
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
