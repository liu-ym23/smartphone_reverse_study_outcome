package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$44 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$44(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "updateChorusPlayModeStatus", "updateChorusPlayModeStatus(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r5) {
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        r0.getClass();
        if (r5 == null) goto L7;
        JsonElement r2 = r5.get("play_mode");
        if (r2 == null) goto L7;
        int r3 = r2.getAsInt();
    L8:
        if (r5 == null) goto L12;
        JsonElement r6 = r5.get("enable");
        if (r6 == null) goto L12;
        boolean r7 = r6.getAsBoolean();
    L14:
        if (r3 != 46) goto L27;
        if (r7 == false) goto L21;
        ei6.a r8 = r0.d();
        if (r8 == null) goto L27;
        ChorusManager r9 = r8.i();
        if (r9 == null) goto L27;
        r9.c = true;
        goto L27
    L21:
        ei6.a r10 = r0.d();
        if (r10 == null) goto L27;
        ChorusManager r11 = r10.i();
        if (r11 == null) goto L27;
        r11.c = false;
    L27:
        return new JsonObject();
    L12:
        r7 = false;
    L7:
        r3 = 0;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
