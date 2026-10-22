package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.live.core.log.ALogger;
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
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$14 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$14(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "enableNetworkDetection", "enableNetworkDetection(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonObject r2 = new JsonObject();
        ALogger.i("ChorusJsbService", "enableNetworkDetection, extraData: " + r5);
        if (r5 == null) goto L16;
        JsonElement r6 = r5.get("enable");
        if (r6 == null) goto L16;
        boolean r7 = r6.getAsBoolean();
        ei6.a r3 = r0.d();
        if (r7 == false) goto L12;
        if (r3 == null) goto L16;
        si6.b r8 = r3.b();
        if (r8 == null) goto L16;
        r8.q((int) KtvSettingHelper.q().o());
        goto L16
    L12:
        if (r3 == null) goto L16;
        si6.b r9 = r3.b();
        if (r9 == null) goto L16;
        r9.i();
    L16:
        return r2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
