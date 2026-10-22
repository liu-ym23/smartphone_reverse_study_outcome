package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import zi6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$41 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$41(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "enableChorusSpatialAudio", "enableChorusSpatialAudio(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r3) {
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        if (r3 == null) goto L9;
        r0.getClass();
        JsonElement r4 = r3.get("enable");
        if (r4 == null) goto L9;
        boolean r1 = true;
        if (r4.getAsBoolean() != true) goto L9;
    L10:
        if (r1 == false) goto L16;
        ei6.a r5 = r0.d();
        if (r5 == null) goto L22;
        ChorusManager r6 = r5.i();
        if (r6 == null) goto L22;
        r6.p(c.c.a, 15);
    L22:
        return new JsonObject();
    L16:
        ei6.a r7 = r0.d();
        if (r7 == null) goto L22;
        ChorusManager r8 = r7.i();
        if (r8 == null) goto L22;
        r8.o();
    L9:
        r1 = false;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
