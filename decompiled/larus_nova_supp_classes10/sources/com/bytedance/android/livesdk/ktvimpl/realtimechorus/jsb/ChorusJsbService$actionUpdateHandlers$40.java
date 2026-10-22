package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$40 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$40(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "enableLocalAudio", "enableLocalAudio(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r2 = r4.get("enable");
        if (r2 == null) goto L5;
        boolean r3 = r2.getAsBoolean();
    L6:
        JsonElement r5 = r4.get("source");
        if (r5 == null) goto L10;
        String r6 = r5.getAsString();
        if (r6 == null) goto L10;
    L11:
        ei6.a r7 = r0.d();
        if (r7 == null) goto L17;
        ri6.b r8 = r7.r();
        if (r8 == null) goto L17;
        r8.o(r3, r6);
    L17:
        return new JsonObject();
    L10:
        r6 = "";
        goto L11
    L5:
        r3 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
