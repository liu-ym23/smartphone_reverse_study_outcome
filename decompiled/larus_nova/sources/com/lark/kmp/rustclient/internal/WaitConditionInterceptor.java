package com.lark.kmp.rustclient.internal;

import com.bytedance.lark.sdk.InvokeResponse;
import com.lark.kmp.logger.LarkLogger;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes24.dex */
public abstract class WaitConditionInterceptor implements com.lark.kmp.rustclient.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f282542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutexImpl f282543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final buc.e<List<Function1<Continuation<? super Unit>, Object>>> f282544c;

    public static final class a {
    }

    static {
    }

    public WaitConditionInterceptor() {
        this(0);
    }

    @Override // com.lark.kmp.rustclient.api.g
    public final <Resp> Object b(com.lark.kmp.rustclient.api.h<Resp> r100, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, Resp>> r101) {
        return d(this, r100, r101);
    }

    public abstract <T> boolean c(com.lark.kmp.rustclient.api.a<T> r100);

    public WaitConditionInterceptor(int r100) {
        CoroutineDispatcher r101 = Dispatchers.getDefault();
        Intrinsics.checkNotNullParameter(r101, "dispatcher");
        this.f282542a = r101;
        this.f282543b = kotlinx.coroutines.sync.b.a();
        this.f282544c = buc.b.d(CollectionsKt.emptyList());
    }

    @Override // com.lark.kmp.rustclient.api.g
    public final <Resp> Flow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> a(com.lark.kmp.rustclient.api.h<Resp> r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        return new c1(new WaitConditionInterceptor$interceptEnqueue$1(this, r100, null));
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [T, java.lang.Object] */
    public final Object e(Continuation<? super Unit> r100) {
        if ((r100 instanceof WaitConditionInterceptor$notifyConditionSatisfied$1) == false) goto L7;
        WaitConditionInterceptor$notifyConditionSatisfied$1 r101 = (WaitConditionInterceptor$notifyConditionSatisfied$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L25:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$1;
        Ref.ObjectRef r107 = (Ref.ObjectRef) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L29:
        r107.element = this.f282544c.b(CollectionsKt.emptyList());     // Catch: Throwable -> L26
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r106.unlock(null);
        LarkLogger r109 = LarkLogger.f278603a;
        LarkLogger.c("WaitConditionInterceptor", "notifyConditionSatisfied, flushing " + ((List) r107.element).size() + " requests");
        WaitConditionInterceptor$notifyConditionSatisfied$3 r110 = new WaitConditionInterceptor$notifyConditionSatisfied$3(r107, this, null);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        if (CoroutineScopeKt.coroutineScope(r110, r101) != r104) goto L25;
        return r104;
    L26:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r103);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r106 = this.f282543b;
        r101.L$0 = r111;
        r101.L$1 = r106;
        r101.label = 1;
        if (r106.a(null, r101) != r104) goto L19;
        return r104;
    L19:
        r107 = r111;
    L7:
        r101 = new WaitConditionInterceptor$notifyConditionSatisfied$1(this, r100);
        goto L8
    }

    public static <Resp> Object d(WaitConditionInterceptor r100, com.lark.kmp.rustclient.api.h<Resp> r101, Continuation<? super com.lark.kmp.rustclient.api.model.g<InvokeResponse, Resp>> r110) {
        if ((r110 instanceof WaitConditionInterceptor$intercept$1) == false) goto L7;
        WaitConditionInterceptor$intercept$1 r102 = (WaitConditionInterceptor$intercept$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L25:
        return r111;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.lark.kmp.rustclient.api.h<Resp> r106 = (com.lark.kmp.rustclient.api.h) r102.L$1;
        WaitConditionInterceptor r107 = (WaitConditionInterceptor) r102.L$0;
        ResultKt.throwOnFailure(r111);
        r101 = r106;
        r100 = r107;
    L18:
        if (r100.c(r101.f282460c) == true) goto L22;
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.label = 1;
        if (DelayKt.delay(50, r102) != r104) goto L18;
        return r104;
    L22:
        com.lark.kmp.rustclient.api.a<Resp> r108 = r101.f282460c;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        r111 = r101.a(r108, r102);
        if (r111 != r104) goto L25;
        return r104;
    L16:
        ResultKt.throwOnFailure(r111);
    L7:
        r102 = new WaitConditionInterceptor$intercept$1(r100, r110);
        goto L8
    }
}
