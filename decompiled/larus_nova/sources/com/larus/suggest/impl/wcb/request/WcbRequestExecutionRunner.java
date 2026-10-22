package com.larus.suggest.impl.wcb.request;

import com.larus.suggest.impl.wcb.policy.a0;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes31.dex */
public final class WcbRequestExecutionRunner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f370070a;

    public WcbRequestExecutionRunner(a r100) {
        Intrinsics.checkNotNullParameter(r100, "inputStateTracker");
        this.f370070a = r100;
    }

    public final Deferred<e> b(f r110, long r111) {
        if (r110.f370118f.f370100b != WcbRequestTrigger.FOREGROUND) goto L5;
        this.f370070a.f370089c = true;
    L5:
        b r100 = b.f370091a;
        Intrinsics.checkNotNullParameter(r110, "snapshot");
        b.a r101 = b.c(r110);
        Map<b.a, Deferred<e>> r102 = b.f370093c;
        Deferred<e> r103 = (Deferred) ((LinkedHashMap) r102).get(r101);
        if (r103 == null) goto L8;
        FLogger.f375446a.d("WcbLog", "[network] reuse inFlight scene=" + r101.f370097d + " requestScene=" + r101.f370098e + " exec=" + r110.f370117e);
        return r103;
    L8:
        Deferred<e> r104 = BuildersKt.async$default(b.f370092b, null, CoroutineStart.LAZY, new WcbNetworkRequester$request$task$1(r110, r111, r101, null), 1, null);
        r102.put(r101, r104);
        r104.start();
        return r104;
    }

    public final Object a(f r100, a0 r101, long r102, Function2<? super g, ? super Continuation<? super Unit>, ? extends Object> r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof WcbRequestExecutionRunner$run$1) == false) goto L7;
        WcbRequestExecutionRunner$run$1 r103 = (WcbRequestExecutionRunner$run$1) r111;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r112 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r103.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r112);
    L48:
        return Unit.INSTANCE;
    L13:
        WcbRequestExecutionRunner r106 = (WcbRequestExecutionRunner) r103.L$1;
        Function2<? super g, ? super Continuation<? super Unit>, ? extends Object> r107 = (Function2) r103.L$0;
        ResultKt.throwOnFailure(r112);
    L44:
        r106.getClass();
        g r108 = new g((e) r112, WcbTransportSource.NETWORK, true);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 6;
        if (r107.invoke(r108, r103) != r105) goto L48;
        return r105;
    L14:
        Deferred<e> r109 = (Deferred) r103.L$1;
        r110 = (Function2) r103.L$0;
        ResultKt.throwOnFailure(r112);
    L40:
        r103.L$0 = r110;
        r103.L$1 = this;
        r103.label = 5;
        r112 = r109.await(r103);
        if (r112 != r105) goto L43;
        return r105;
    L43:
        r106 = this;
        r107 = r110;
        goto L44
    L15:
        ResultKt.throwOnFailure(r112);
    L34:
        return Unit.INSTANCE;
    L16:
        r110 = (Function2) r103.L$0;
        ResultKt.throwOnFailure(r112);
    L30:
        g r113 = new g((e) r112, WcbTransportSource.NETWORK, false);
        r103.L$0 = null;
        r103.label = 3;
        if (r110.invoke(r113, r103) != r105) goto L34;
        return r105;
    L17:
        ResultKt.throwOnFailure(r112);
    L24:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r112);
        if ((r101 instanceof a0.a) == false) goto L26;
        g r114 = new g(new e.c(((a0.a) r101).f369957a), WcbTransportSource.CACHE, false);
        r103.label = 1;
        if (r110.invoke(r114, r103) != r105) goto L24;
        return r105;
    L26:
        if (Intrinsics.areEqual(r101, a0.c.f369959a) == false) goto L36;
        Deferred<e> r115 = b(r100, r102);
        r103.L$0 = r110;
        r103.label = 2;
        r112 = r115.await(r103);
        if (r112 != r105) goto L30;
        return r105;
    L36:
        if ((r101 instanceof a0.b) == false) goto L50;
        r109 = b(r100, r102);
        g r116 = new g(new e.c(((a0.b) r101).f369958a), WcbTransportSource.CACHE, false);
        r103.L$0 = r110;
        r103.L$1 = r109;
        r103.label = 4;
        if (r110.invoke(r116, r103) != r105) goto L40;
        return r105;
    L50:
        if ((r101 instanceof a0.d) == false) goto L54;
        return Unit.INSTANCE;
    L54:
        throw new NoWhenBranchMatchedException();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r103 = new WcbRequestExecutionRunner$run$1(this, r111);
        goto L8
    }
}
