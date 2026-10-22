package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes26.dex */
public final class ResourceAccessPipeline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ResourceAccessPipeline f313574a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f313575a = null;

        static {
            int[] r100 = new int[ResourcePipelineRoute.values().length];
            r100[ResourcePipelineRoute.LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ResourcePipelineRoute.REMOTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f313575a = r100;
        }
    }

    static {
        f313574a = new ResourceAccessPipeline();
    }

    public ResourceAccessPipeline() {
    }

    public final Object a(f r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ResourceAccessPipeline$execute$1) == false) goto L7;
        ResourceAccessPipeline$execute$1 r100 = (ResourceAccessPipeline$execute$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r112);
    L41:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        h0 r113 = (h0) r100.L$1;
        f r104 = (f) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L29:
        h r114 = (h) r112;
    L37:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 3;
        if (b(r104, r113, r114, r100) != r102) goto L41;
        return r102;
    L17:
        r113 = (h0) r100.L$1;
        r104 = (f) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L36:
        r114 = (h) r112;
        goto L37
    L18:
        ResultKt.throwOnFailure(r112);
        h0 r115 = new h0(r110.f313634c, r110);
        Set<ResourceTraceResult> r105 = e0.f313631a;
        e0.b(r110, r115, ResourceTraceStage.TASK_LIFECYCLE, ResourceTraceResult.START, null);
        int r106 = k0.f313697a;
        ResourceInputType r107 = r115.f313673c.getType();
        Intrinsics.checkNotNullParameter(r107, "resourceInputType");
        if (s.a(r107) == false) goto L21;
        ResourcePipelineRoute r108 = ResourcePipelineRoute.REMOTE;
    L22:
        int r109 = a.f313575a[r108.ordinal()];
        if (r109 == 1) goto L32;
        if (r109 != 2) goto L31;
        b r116 = q.f313715a;
        r100.L$0 = r110;
        r100.L$1 = r115;
        r100.label = 2;
        int r117 = p0.f313714a;
        Object r118 = p0.a(r110, r115, CollectionsKt.listOf(new l0[]{new d1(), new p(), new o(), new l(), new k(), new m(), new n(), new i(CollectionsKt.listOf("remote_fallback")), new com.larus.bmhome.resource.access.a()}), q.f313715a, r100);
        if (r118 != r102) goto L28;
        return r102;
    L28:
        r104 = r110;
        r113 = r115;
        r112 = r118;
        goto L29
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        b r119 = e.f313630a;
        r100.L$0 = r110;
        r100.L$1 = r115;
        r100.label = 1;
        Object r120 = e.a(r110, r115, r100);
        if (r120 != r102) goto L35;
        return r102;
    L35:
        r104 = r110;
        r113 = r115;
        r112 = r120;
        goto L36
    L21:
        r108 = ResourcePipelineRoute.LOCAL;
    L7:
        r100 = new ResourceAccessPipeline$execute$1(this, r111);
        goto L8
    }

    public final Object b(f r100, h0 r101, h r102, Continuation<? super Unit> r110) {
        if ((r110 instanceof ResourceAccessPipeline$handleResult$1) == false) goto L7;
        ResourceAccessPipeline$handleResult$1 r103 = (ResourceAccessPipeline$handleResult$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L56:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (h0) r103.L$2;
        r100 = (f) r103.L$1;
        ResourceAccessPipeline r107 = (ResourceAccessPipeline) r103.L$0;
        ResultKt.throwOnFailure(r111);
    L52:
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.label = 2;
        if (r107.b(r100, r101, (h) r111, r103) != r105) goto L56;
        return r105;
    L16:
        ResultKt.throwOnFailure(r111);
        if (Intrinsics.areEqual(r102, h.a.f313668a) == false) goto L30;
        if (r100.c() == true) goto L65;
        f0 r108 = r101.f313678h;
        if (r108 != null) goto L24;
        r r109 = new r("pipeline", "empty_artifact", "pipeline finished without artifact", null);
        if (r100.e(new a0.c(r109)) == false) goto L65;
        Set<ResourceTraceResult> r112 = e0.f313631a;
        e0.b(r100, r101, ResourceTraceStage.TASK_LIFECYCLE, ResourceTraceResult.FAILED, r109.f313723b);
        goto L65
    L24:
        if (r100.e(new a0.d(f0.a(r108, MapsKt.plus(r108.f313648f, r101.b())))) == false) goto L65;
        Set<ResourceTraceResult> r113 = e0.f313631a;
        e0.b(r100, r101, ResourceTraceStage.TASK_LIFECYCLE, ResourceTraceResult.READY, null);
    L65:
        return Unit.INSTANCE;
    L30:
        if ((r102 instanceof h.b) == false) goto L35;
        h.b r114 = (h.b) r102;
        if (r100.e(new a0.c(r114.f313669a)) == false) goto L65;
        Set<ResourceTraceResult> r115 = e0.f313631a;
        e0.b(r100, r101, ResourceTraceStage.TASK_LIFECYCLE, ResourceTraceResult.FAILED, r114.f313669a.f313723b);
        goto L65
    L35:
        if ((r102 instanceof h.c) == false) goto L67;
        if (r100.c() == true) goto L39;
        ResourceInputType r116 = r101.f313673c.getType();
        StateFlowImpl r117 = s.f313730a;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        if (r116 != ResourceInputType.LOCAL_PATH) goto L43;
    L46:
        boolean r118 = true;
    L47:
        if (r118 == false) goto L58;
        Set<ResourceTraceResult> r119 = e0.f313631a;
        e0.b(r100, r101, ResourceTraceStage.REMOTE_FALLBACK, ResourceTraceResult.FALLBACK_TO_LOCAL, ((h.c) r102).f313670a.f313723b);
        FLogger.f375446a.i("ResourceAccessPipeline", "[handleResult] remote fallback to local, taskId=" + r100.f313632a + ", resourceInput=" + r101.f313673c.getType());
        b r120 = e.f313630a;
        r103.L$0 = this;
        r103.L$1 = r100;
        r103.L$2 = r101;
        r103.label = 1;
        r111 = e.a(r100, r101, r103);
        if (r111 != r105) goto L51;
        return r105;
    L51:
        r107 = this;
        goto L52
    L58:
        if (r100.c() == true) goto L60;
        h.c r121 = (h.c) r102;
        if (r100.e(new a0.c(r121.f313670a)) == false) goto L65;
        Set<ResourceTraceResult> r122 = e0.f313631a;
        e0.b(r100, r101, ResourceTraceStage.TASK_LIFECYCLE, ResourceTraceResult.FAILED, r121.f313670a.f313723b);
        goto L65
    L60:
        return Unit.INSTANCE;
    L43:
        if (r116 == ResourceInputType.CONTENT_URI) goto L46;
        r118 = false;
        goto L47
    L39:
        return Unit.INSTANCE;
    L67:
        throw new NoWhenBranchMatchedException();
    L7:
        r103 = new ResourceAccessPipeline$handleResult$1(this, r110);
        goto L8
    }
}
