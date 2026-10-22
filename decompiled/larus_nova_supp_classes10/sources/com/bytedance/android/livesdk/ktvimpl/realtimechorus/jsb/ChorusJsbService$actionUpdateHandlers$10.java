package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.live.livelink.kmp.impl.extend.chorus.ChorusManager;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionUpdateHandlers$10 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionUpdateHandlers$10(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "closeVoiceSimilarScore", "closeVoiceSimilarScore(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ChorusJsbService r3 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r0 = ChorusJsbService.l;
        ei6.a r4 = r3.d();
        if (r4 == null) goto L7;
        ChorusManager r5 = r4.i();
        if (r5 == null) goto L7;
        r5.q();
    L7:
        ChorusJsbService.g("closeVoiceSimilarScore");
        return new JsonObject();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
