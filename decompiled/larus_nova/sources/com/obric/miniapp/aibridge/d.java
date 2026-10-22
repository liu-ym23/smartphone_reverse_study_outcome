package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class d implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h f397330a;

    public /* synthetic */ d(f3.h r100) {
        this.f397330a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        f3.h r101 = this.f397330a;
        String r102 = (String) r100;
        FLogger.f375446a.d("GetAlarmInfoMethod", "getAlarmJsonById result: " + r102);
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(AbsGetAlarmInfoMethodIDL.b.class, "<this>");
        BaseModel r103 = k3.c.a(AbsGetAlarmInfoMethodIDL.b.class);
        ((AbsGetAlarmInfoMethodIDL.b) r103).setResult(r102);
        f3.h.a.b(r101, (ResultModel) r103);
    L7:
        return Unit.INSTANCE;
    L5:
        f3.h.a.a(r101, "Empty", null, null, 14);
        goto L7
    }
}
