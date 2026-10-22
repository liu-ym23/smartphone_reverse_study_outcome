package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h f397333a;

    public /* synthetic */ f(f3.h r100) {
        this.f397333a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        f3.h r101 = this.f397333a;
        List<String> r102 = (List) r100;
        Intrinsics.checkNotNullParameter(r102, "it");
        FLogger.f375446a.d("GetAllAlarmMethod", "getAllAlarmIds result: " + r102);
        Intrinsics.checkNotNullParameter(AbsGetAllAlarmMethodIDL.b.class, "<this>");
        BaseModel r103 = k3.c.a(AbsGetAllAlarmMethodIDL.b.class);
        ((AbsGetAllAlarmMethodIDL.b) r103).setResult(r102);
        f3.h.a.b(r101, (ResultModel) r103);
        return Unit.INSTANCE;
    }
}
