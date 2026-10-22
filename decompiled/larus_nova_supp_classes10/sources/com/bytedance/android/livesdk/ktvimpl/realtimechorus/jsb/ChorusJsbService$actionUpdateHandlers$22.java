package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import vb6.g;
import yb6.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$22 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$22(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "startAudioCapture", "startAudioCapture(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r4 = r3.get("reason");
        if (r4 == null) goto L6;
        String r5 = r4.getAsString();
        if (r5 == null) goto L6;
    L7:
        ChorusJsbService.g("startAudioCapture, reason : ".concat(r5));
        j1 r2 = r0.e();
        if (r2 == null) goto L17;
        cg6.a r6 = r2.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r6 == null) goto L17;
        g r7 = r6.O5();
        if (r7 == null) goto L17;
        e r8 = r7.j();
        if (r8 == null) goto L17;
        r8.f(r5);
    L17:
        return new JsonObject();
    L6:
        r5 = "chorus";
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
