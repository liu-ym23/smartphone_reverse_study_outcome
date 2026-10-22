package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h f397326a;

    public /* synthetic */ b(f3.h r100) {
        this.f397326a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        f3.h r101 = this.f397326a;
        boolean r102 = ((Boolean) r100).booleanValue();
        FLogger.f375446a.d("DeleteAlarmMethod", "deleteAlarm result: " + r102);
        if (r102 == false) goto L5;
        Intrinsics.checkNotNullParameter(AbsDeleteAlarmMethodIDL.b.class, "<this>");
        f3.h.a.b(r101, (ResultModel) k3.c.a(AbsDeleteAlarmMethodIDL.b.class));
    L7:
        return Unit.INSTANCE;
    L5:
        f3.h.a.a(r101, "Set AlarmMethod Failed", null, null, 14);
        goto L7
    }
}
