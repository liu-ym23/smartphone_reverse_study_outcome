package com.obric.assistant.utils;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.aiagent.assistant.idl.t;
import com.obric.aiagent.assistant.idl.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes33.dex */
public final class b {
    static {
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.assistant.utils.a, java.lang.Object] */
    public static void a(final String r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "action");
        IAgentVoiceInteractionIDL r102 = u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r102 == null) goto L6;
        FLogger.f375446a.i("AgentIpcUtils", "voice interaction ipc ready, execute directly, event=".concat(r100));
        r101.invoke(r102);
        return;
    L6:
        final long r103 = SystemClock.elapsedRealtime();
        FLogger.f375446a.i("AgentIpcUtils", "voice interaction ipc unavailable, wait for register, event=".concat(r100));
        KClass r104 = Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class);
        ?? r105 = new a(r103, r100, r101);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Intrinsics.checkNotNullParameter(r105, "action");
        com.obric.aiagent.ipc.utils.g r106 = com.obric.aiagent.ipc.utils.g.f384740a;
        t r107 = new t(r105);
        r106.getClass();
        com.obric.aiagent.ipc.utils.g.a(IAgentVoiceInteractionIDL.class, r107, true);
    }
}
