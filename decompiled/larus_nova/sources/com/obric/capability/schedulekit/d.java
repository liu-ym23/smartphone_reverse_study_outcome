package com.obric.capability.schedulekit;

import com.obric.capabilitykit.common.ICapabilitySchedule;
import com.obric.capabilitykit.corecommon.BinderExceptionHandlerProxy;
import java.lang.reflect.Proxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICapabilitySchedule f396041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ICapabilitySchedule f396042b;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
    }

    static {
    }

    public d(ICapabilitySchedule r100) {
        Intrinsics.checkNotNullParameter(r100, "api");
        this.f396041a = r100;
        BinderExceptionHandlerProxy.Companion r101 = BinderExceptionHandlerProxy.Companion;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Proxy.newProxyInstance(ICapabilitySchedule.class.getClassLoader(), new Class[]{ICapabilitySchedule.class}, new BinderExceptionHandlerProxy(r100, "ScheduleProxy", ICapabilitySchedule.class));     // Catch: Throwable -> L8
        if (r103 == null) goto L7;
        r100 = (ICapabilitySchedule) r103;     // Catch: Throwable -> L8
    L12:
        this.f396042b = r100;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilitySchedule");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        if (Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th))) == null) goto L12;
        r100.getClass().toString();
        goto L12
    }
}
