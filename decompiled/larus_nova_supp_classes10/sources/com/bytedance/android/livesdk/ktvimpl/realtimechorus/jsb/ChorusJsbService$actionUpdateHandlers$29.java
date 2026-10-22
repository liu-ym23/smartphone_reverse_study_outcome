package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.ChorusStreamMixService;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ti6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$29 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$29(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "stopExtraStreamMixTask", "stopExtraStreamMixTask(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r4) {
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        if (r4 == null) goto L8;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r5 = r4.get("task_id");
        if (r5 == null) goto L8;
        String r6 = r5.getAsString();
        if (r6 == null) goto L8;
    L9:
        ChorusStreamMixService r2 = r0.c;
        if (r2 == null) goto L17;
        Intrinsics.checkNotNullParameter(r6, "taskId");
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusStreamMixService", "stopExtraStreamMixTask taskId ".concat(r6));
        r2.b = BDLocationException.ERROR_TIMEOUT;
        ei6.a r3 = r2.a();
        if (r3 == null) goto L17;
        d r7 = r3.p();
        if (r7 == null) goto L17;
        r7.b(r6, "VideoChorusStreamMixService stopExtraStreamMixTask");
    L17:
        return new JsonObject();
    L8:
        r6 = "";
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
