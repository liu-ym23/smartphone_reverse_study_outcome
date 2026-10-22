package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$24 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$24(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "setVoiceVolume", "setVoiceVolume(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonObject r2 = new JsonObject();
        if (r5 == null) goto L7;
        JsonElement r6 = r5.get("volume");
        if (r6 == null) goto L7;
        Float r7 = Float.valueOf(r6.getAsFloat());
    L8:
        ChorusJsbService.g("setVoiceVolume, volume: " + r7);
        if (r7 == null) goto L14;
        float r3 = r7.floatValue() * KtvSettingHelper.d().f();
        ld2.b r4 = r0.g;
        if (r4 == null) goto L13;
        r4.h(r3);
    L13:
        int r8 = xe2.a.a;
        xe2.a.j(r3, r7.floatValue());
    L14:
        return r2;
    L7:
        r7 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
