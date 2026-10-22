package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$43 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$43(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "setRuntimeParametersOnLink", "setRuntimeParametersOnLink(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r3) {
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        if (r3 == null) goto L8;
        r0.getClass();
        JsonElement r4 = r3.get("jsonStr");
        if (r4 == null) goto L8;
        String r5 = r4.getAsString();
        if (r5 == null) goto L8;
    L9:
        r0.k.put(ChorusJsbDataContext.CMD_RUNTIME_PARAMETERS_ON_LINK, r5);
        return new JsonObject();
    L8:
        r5 = "";
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
