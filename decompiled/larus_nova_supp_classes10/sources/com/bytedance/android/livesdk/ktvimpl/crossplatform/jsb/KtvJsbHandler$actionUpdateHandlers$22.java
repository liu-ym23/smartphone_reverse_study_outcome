package com.bytedance.android.livesdk.ktvimpl.crossplatform.jsb;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvJsbHandler$actionUpdateHandlers$22 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public KtvJsbHandler$actionUpdateHandlers$22(b r8) {
        super(1, r8, b.class, "setBGMPushVolume", "setBGMPushVolume(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        b r0 = (b) ((CallableReference) this).receiver;
        int r1 = b.g;
        r0.getClass();
        JsonObject r2 = new JsonObject();
        JsonElement r5 = r4.get("volume");
        if (r5 == null) goto L5;
        r5.getAsFloat();
    L5:
        r0.a();
        return r2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
