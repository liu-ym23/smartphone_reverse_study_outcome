package com.larus.dora.impl.assistant;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f332035a = null;

    static {
        f332035a = new a();
    }

    public a() {
    }

    public static f a() {
        FLogger r100 = FLogger.f375446a;
        r100.i("AssistantIntentDispatcher", "isWifiEnabled start");
        IAgentAppIntentIDL r101 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r101 != null) goto L16;
        r100.w("AssistantIntentDispatcher", "isWifiEnabled failed, ipc is null");
        return new f(false, false, "ipc_null", "IAgentAppIntentIDL is null");
    L16:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        boolean r103 = r101.isWifiEnabled();     // Catch: Throwable -> L8
        r100.i("AssistantIntentDispatcher", "isWifiEnabled returns " + r103);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(new f(true, r103, null, null));     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        FLogger.f375446a.w("AssistantIntentDispatcher", "isWifiEnabled failed", r105);
        r104 = new f(false, false, "ipc_exception", r105.getMessage());
    L15:
        return (f) r104;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
