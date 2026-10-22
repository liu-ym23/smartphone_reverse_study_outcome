package com.obric.assistant.network.restrict;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentNetworkIDL;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.obric.assistant.ObricAIagentNetworkInterceptConfig;
import com.obric.assistant.t1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.restrict.ObricAIagentNetworkConfigManager$updateRules$1", f = "ObricAIagentNetworkConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricAIagentNetworkConfigManager$updateRules$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricAIagentNetworkConfigManager$updateRules$1(Continuation<? super ObricAIagentNetworkConfigManager$updateRules$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricAIagentNetworkConfigManager$updateRules$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricAIagentNetworkConfigManager$updateRules$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.assistant.network.restrict.b, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r110);
        ObricAIagentNetworkInterceptConfig r111 = t1.f393353a.getObricPowerLockConfig().getObricAiAgentNetworkInterceptConfig();     // Catch: Exception -> L13
        if (r111 != null) goto L8;
        r111 = new ObricAIagentNetworkInterceptConfig(null, null, null, 7, null);     // Catch: Exception -> L13
    L8:
        FLogger r100 = FLogger.f375446a;     // Catch: Exception -> L13
        r100.i("ObricAIagentNetworkConfigManager", "updateRules config: " + r111);     // Catch: Exception -> L13
        final RequestRestrictRule r101 = new RequestRestrictRule(r111.getAllowedHosts(), r111.getAllowedPaths(), r111.getAllowedUrlPrefixes());     // Catch: Exception -> L13
        KClass r112 = Reflection.getOrCreateKotlinClass(IAgentNetworkIDL.class);     // Catch: Exception -> L13
        int r102 = com.obric.aiagent.assistant.idl.j.f384537a;     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r112, "<this>");     // Catch: Exception -> L13
        com.obric.aiagent.ipc.utils.g.f384740a.getClass();     // Catch: Exception -> L13
        IAgentNetworkIDL r113 = (IAgentNetworkIDL) com.obric.aiagent.ipc.utils.g.b(IAgentNetworkIDL.class);     // Catch: Exception -> L13
        if (r113 == null) goto L11;
        r100.i("ObricAIagentNetworkConfigManager", "IPC ready, update rules directly");     // Catch: Exception -> L13
        r113.updateExcludeRules(r101);     // Catch: Exception -> L13
    L16:
        return Unit.INSTANCE;
    L11:
        r100.i("ObricAIagentNetworkConfigManager", "IPC not ready, wait for register");     // Catch: Exception -> L13
        KClass r114 = Reflection.getOrCreateKotlinClass(IAgentNetworkIDL.class);     // Catch: Exception -> L13
        ?? r103 = new b(r101);     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r114, "<this>");     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r103, "action");     // Catch: Exception -> L13
        com.obric.aiagent.ipc.utils.g.a(IAgentNetworkIDL.class, new com.obric.aiagent.assistant.idl.i(r103), true);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        FLogger.f375446a.e("ObricAIagentNetworkConfigManager", "updateRules error", e);
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
