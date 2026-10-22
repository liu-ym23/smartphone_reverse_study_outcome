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
public final /* synthetic */ class ChorusJsbService$actionGetHandlers$2 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionGetHandlers$2(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "getVoiceSimilarScore", "getVoiceSimilarScore(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        ChorusJsbService r4 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r0 = ChorusJsbService.l;
        ei6.a r5 = r4.d();
        if (r5 == null) goto L7;
        ChorusManager r1 = r5.i();
        if (r1 == null) goto L7;
        r1.q();
    L7:
        if (r5 == null) goto L11;
        ChorusManager r2 = r5.i();
        if (r2 == null) goto L11;
        r2.q();
    L11:
        if (r5 == null) goto L15;
        ChorusManager r6 = r5.i();
        if (r6 == null) goto L15;
        r6.q();
    L15:
        ChorusJsbService.g("getVoiceSimilarScore, averageScore: null, totalScore: null, lastScore: null");
        JsonObject r7 = new JsonObject();
        r7.addProperty("averageScore", null);
        r7.addProperty("totalScore", null);
        r7.addProperty("lastScore", null);
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}
