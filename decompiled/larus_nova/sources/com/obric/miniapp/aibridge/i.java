package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h f397336a;

    public /* synthetic */ i(f3.h r100) {
        this.f397336a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        f3.h r101 = this.f397336a;
        JSONObject r102 = (JSONObject) r100;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(AbsIntentCardOperationMethodIDL.b.class, "<this>");
        BaseModel r103 = k3.c.a(AbsIntentCardOperationMethodIDL.b.class);
        ((AbsIntentCardOperationMethodIDL.b) r103).setResult(r102.toString());
        f3.h.a.b(r101, (ResultModel) r103);
        return Unit.INSTANCE;
    }
}
