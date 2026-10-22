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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$6 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$6(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "releaseLiveClient", "releaseLiveClient(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonObject r2 = new JsonObject();
        ChorusJsbService.g("releaseLiveClient, extraData: " + r5);
        if (r5 == null) goto L15;
        JsonElement r6 = r5.get("source");
        if (r6 == null) goto L15;
        String r7 = r6.getAsString();
        if (r7 == null) goto L15;
        j1 r3 = r0.e();
        if (r3 == null) goto L15;
        cg6.a r4 = r3.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r4 == null) goto L15;
        g r8 = r4.O5();
        if (r8 == null) goto L15;
        r8.E0(r7);
    L15:
        return r2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
