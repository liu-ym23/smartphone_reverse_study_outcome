package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class ResourceNodeRunner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ResourceNodeRunner f313584a = null;

    static {
        f313584a = new ResourceNodeRunner();
    }

    public ResourceNodeRunner() {
    }

    public static q0 b(ResourceNodeRunner r100, l0 r101, ResourceNodeStatus r110) {
        Map r102 = MapsKt.emptyMap();
        r100.getClass();
        return new q0(r101.getKey(), r101.d(), r110, 0, null, r102);
    }

    public final Object a(f r210, h0 r211, l0 r212, boolean r213, boolean r214, Continuation<? super m0> r215) {
        f r100 = r210;
        h0 r101 = r211;
        l0 r110 = r212;
        boolean r102 = r214;
        if ((r215 instanceof ResourceNodeRunner$executeNode$1) == false) goto L7;
        ResourceNodeRunner$executeNode$1 r103 = (ResourceNodeRunner$executeNode$1) r215;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        long r108 = r103.J$0;
        r102 = r103.Z$0;
        l0 r109 = (l0) r103.L$2;
        h0 r111 = (h0) r103.L$1;
        f r112 = (f) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14 CancellationException -> L120
        long r113 = r108;
        r100 = r112;
        r110 = r109;
        r101 = r111;
    L36:
        g r114 = (g) r105;     // Catch: Throwable -> L38 CancellationException -> L117
    L117:
        r112 = r100;
        r109 = r110;
    L38:
        Throwable th10 = th;
        r112 = r100;
        r111 = r101;
        r109 = r110;
        r108 = r113;
    L40:
        FLogger.f375446a.e("ResourceAccessPipeline", "[execute] node=" + r109.getKey() + " exception", th10);
        String r115 = r109.getKey();
        String r116 = th10.getMessage();
        if (r116 != null) goto L43;
        r116 = "";
    L43:
        g.b r117 = new g.b(new r(r115, "node_exception", r116, th10));
        r113 = r108;
        r100 = r112;
        r110 = r109;
        r101 = r111;
        r114 = r117;
    L45:
        if (r100.c() == false) goto L49;
        if (r102 == true) goto L49;
        FLogger.f375446a.i("ResourceAccessPipeline", "[execute] ignore node=" + r110.getKey() + " result after terminal, taskId=" + r100.f313632a);
        return new m0(r110, g.e.f313653a);
    L49:
        long r118 = System.currentTimeMillis() - r113;
        FLogger.f375446a.i("ResourceAccessPipeline", "[execute] finish node=" + r110.getKey() + ", taskId=" + r100.f313632a + ", cost=" + r118);
        boolean r119 = r114 instanceof g.b;
        String r120 = null;
        if (r119 == false) goto L52;
        g.b r121 = (g.b) r114;
    L53:
        if (r121 == null) goto L59;
        r r122 = r121.f313650a;
        if (r122 == null) goto L59;
        String r123 = r122.f313723b;
        if (r123 == null) goto L59;
    L67:
        boolean r124 = r114 instanceof g.a;
        if (r124 == false) goto L71;
        Map<String, String> r125 = ((g.a) r114).f313649a.f313687g;
    L82:
        if (r124 == false) goto L86;
        ResourceNodeStatus r126 = ResourceNodeStatus.CONTINUED;
    L96:
        r100.f(new q0(r110.getKey(), r110.d(), r126, r118, r123, r125));
        Set<ResourceTraceResult> r127 = e0.f313631a;
        if (r124 == false) goto L101;
        ResourceTraceResult r128 = ResourceTraceResult.CONTINUE;
    L111:
        e0.c(r100, r101, r110, r118, r128, r123, r125);
        return new m0(r110, r114);
    L101:
        if (Intrinsics.areEqual(r114, g.e.f313653a) == false) goto L103;
        r128 = ResourceTraceResult.SKIP;
        goto L111
    L103:
        if (r119 == false) goto L106;
        r128 = ResourceTraceResult.FAILED;
        goto L111
    L106:
        if ((r114 instanceof g.c) == false) goto L109;
        r128 = ResourceTraceResult.FALLBACK;
        goto L111
    L109:
        if ((r114 instanceof g.d) == false) goto L114;
        r128 = ResourceTraceResult.READY;
        goto L111
    L114:
        throw new NoWhenBranchMatchedException();
    L86:
        if (Intrinsics.areEqual(r114, g.e.f313653a) == false) goto L88;
        r126 = ResourceNodeStatus.SKIPPED;
        goto L96
    L88:
        if (r119 == false) goto L91;
        r126 = ResourceNodeStatus.FAILED;
        goto L96
    L91:
        if ((r114 instanceof g.c) == false) goto L94;
        r126 = ResourceNodeStatus.FALLBACK;
        goto L96
    L94:
        if ((r114 instanceof g.d) == false) goto L116;
        r126 = ResourceNodeStatus.READY;
        goto L96
    L116:
        throw new NoWhenBranchMatchedException();
    L71:
        if ((r114 instanceof g.d) == false) goto L74;
        r125 = ((g.d) r114).f313652a.f313648f;
        goto L82
    L74:
        if (Intrinsics.areEqual(r114, g.e.f313653a) == true) goto L81;
        if (r119 == true) goto L81;
        if ((r114 instanceof g.c) == true) goto L81;
        throw new NoWhenBranchMatchedException();
    L81:
        r125 = MapsKt.emptyMap();
    L59:
        if ((r114 instanceof g.c) == false) goto L61;
        g.c r129 = (g.c) r114;
    L62:
        if (r129 == null) goto L66;
        r r130 = r129.f313651a;
        if (r130 == null) goto L66;
        r120 = r130.f313723b;
    L66:
        r123 = r120;
        goto L67
    L61:
        r129 = null;
        goto L62
    L52:
        r121 = null;
        goto L53
    L14:
        th10 = th;
    L118:
        FLogger.f375446a.i("ResourceAccessPipeline", "[execute] node=" + r109.getKey() + " cancelled, taskId=" + r112.f313632a);
        r112.f(b(this, r109, ResourceNodeStatus.CANCELLED));
        return new m0(r109, g.e.f313653a);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        if (r210.c() == false) goto L24;
        if (r102 == true) goto L24;
        return new m0(r110, g.e.f313653a);
    L24:
        if (r110.e(r101) == true) goto L27;
        FLogger.f375446a.i("ResourceAccessPipeline", "[execute] skip node=" + r212.getKey() + ", taskId=" + r100.f313632a);
        r100.f(b(this, r110, ResourceNodeStatus.SKIPPED));
        Set<ResourceTraceResult> r131 = e0.f313631a;
        e0.c(r210, r211, r212, 0, ResourceTraceResult.SKIP, null, MapsKt.emptyMap());
        return new m0(r110, g.e.f313653a);
    L27:
        if (r213 == true) goto L29;
    L32:
        r100.f(b(this, r110, ResourceNodeStatus.RUNNING));
        FLogger.f375446a.i("ResourceAccessPipeline", "[execute] start node=" + r212.getKey() + ", phase=" + r212.d() + ", taskId=" + r100.f313632a);
        r113 = System.currentTimeMillis();
        r103.L$0 = r100;     // Catch: Throwable -> L38 CancellationException -> L117
        r103.L$1 = r101;     // Catch: Throwable -> L38 CancellationException -> L117
        r103.L$2 = r110;     // Catch: Throwable -> L38 CancellationException -> L117
        r103.Z$0 = r102;     // Catch: Throwable -> L38 CancellationException -> L117
        r103.J$0 = r113;     // Catch: Throwable -> L38 CancellationException -> L117
        r103.label = 1;     // Catch: Throwable -> L38 CancellationException -> L117
        r105 = r110.c(r101, r103);     // Catch: Throwable -> L38 CancellationException -> L117
        if (r105 != r106) goto L36;
        return r106;
    L29:
        if (r100.e(new a0.e(r212.d(), r212.getKey(), r101.f313673c, r211.b())) == true) goto L32;
        return new m0(r110, g.e.f313653a);
    L7:
        r103 = new ResourceNodeRunner$executeNode$1(this, r215);
        goto L8
    }
}
