package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionGetHandlers$1 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionGetHandlers$1(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "getVoiceLoudness", "getVoiceLoudness(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        ChorusJsbService r4 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r0 = ChorusJsbService.l;
        r4.getClass();
        JsonObject r1 = new JsonObject();
        ld2.b r5 = r4.g;
        if (r5 == null) goto L5;
        Float r6 = Float.valueOf(r5.e());
    L6:
        r1.addProperty("result", r6);
        return r1;
    L5:
        r6 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
