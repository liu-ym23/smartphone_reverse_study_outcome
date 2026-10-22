package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$23 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$23(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "updateJoinStatus", "updateJoinStatus(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        int r2 = 0;
        b r3 = new b(0);
        JsonElement r4 = r6.get("chorus_id");
        if (r4 == null) goto L6;
        String r5 = r4.getAsString();
        if (r5 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.a = r5;
        JsonElement r7 = r6.get("joined");
        if (r7 == null) goto L10;
        boolean r8 = r7.getAsBoolean();
    L11:
        r3.c = r8;
        JsonElement r9 = r6.get("user_type");
        if (r9 == null) goto L14;
        r2 = r9.getAsInt();
    L14:
        r3.b = r2;
        ChorusJsbService.g("updateJoinStatus, chorusId : " + r3.a + " joined " + r3.c);
        DataCenter r10 = r0.k;
        if (r10 == null) goto L18;
        r10.put(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE, r3);
    L18:
        return new JsonObject();
    L10:
        r8 = false;
    L6:
        r5 = BDLocationException.ERROR_TIMEOUT;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
