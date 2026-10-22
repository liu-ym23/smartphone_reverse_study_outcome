package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$19 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$19(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "initChorusEncodeConfig", "initChorusEncodeConfig(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ChorusJsbService r0 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r1 = ChorusJsbService.l;
        r0.getClass();
        JsonElement r6 = r5.get("enable");
        if (r6 == null) goto L5;
        boolean r7 = r6.getAsBoolean();
    L6:
        ei6.a r2 = r0.d();
        if (r2 == null) goto L11;
        ChorusManager r3 = r2.i();
        if (r3 == null) goto L11;
        r3.v("", KtvSettingHelper.B());
    L11:
        ei6.a r4 = r0.d();
        if (r4 == null) goto L16;
        ChorusManager r8 = r4.i();
        if (r8 == null) goto L16;
        r8.E(r7);
    L16:
        ei6.a r9 = r0.d();
        if (r9 == null) goto L22;
        ChorusManager r10 = r9.i();
        if (r10 == null) goto L22;
        r10.G(r7);
    L22:
        return new JsonObject();
    L5:
        r7 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
