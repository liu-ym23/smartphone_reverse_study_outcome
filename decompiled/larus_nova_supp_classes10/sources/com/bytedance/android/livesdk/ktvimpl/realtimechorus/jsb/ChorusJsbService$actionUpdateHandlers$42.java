package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import android.content.Context;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.grouplive.c;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$42 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$42(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "showGroupLiveChorusInvitePage", "showGroupLiveChorusInvitePage(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r3) {
        Context r4 = ((ChorusJsbService) ((CallableReference) this).receiver).a.get();
        if (r4 == null) goto L6;
        new c().a(r4, false);
    L6:
        return new JsonObject();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
