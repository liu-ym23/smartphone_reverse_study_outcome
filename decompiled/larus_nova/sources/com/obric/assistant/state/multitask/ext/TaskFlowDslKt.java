package com.obric.assistant.state.multitask.ext;

import aha.s;
import com.obric.assistant.state.multitask.TaskFlowManager;
import jha.i;
import jha.k;
import jha.l;
import jha.m;
import jha.n;
import jha.o;
import jha.p;
import jha.q;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: classes33.dex */
public final class TaskFlowDslKt {
    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.state.multitask.ext.TaskFlowDslKt$observeAllStates$$inlined$filter$1] */
    public static final TaskFlowDslKt$observeAllStates$$inlined$map$1 a() {
        s r100 = s.f3666a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        a1 r101 = TaskFlowManager.f393254h;
        final FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r102 = new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(new TaskFlowDslKt$observeAllStates$1(r100, null), r101);
        return new TaskFlowDslKt$observeAllStates$$inlined$map$1(new TaskFlowDslKt$observeAllStates$$inlined$filter$1(r102));
    }

    public static final <S extends o> jha.g<S> b(k<S> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "id");
        return new jha.g(r101, r100);
    }

    public static void c(l r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "finalState");
        TaskFlowManager r102 = TaskFlowManager.f393247a;
        TaskFlowManager.g(r100, new q.a(new p(r100.f499139a, r101, true)));
    }

    public static void f(l r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "newState");
        TaskFlowManager r102 = TaskFlowManager.f393247a;
        TaskFlowManager.g(r100, new q.c(new p(r100.f499139a, r101, true)));
    }

    public static Object e(jha.g r100, o r101, jha.c r102, Continuation r103) {
        return d(r100, r101, true, r102, null, r103);
    }

    public static final <S extends o> Object d(jha.g<S> r100, S r101, boolean r102, jha.c r103, i<S> r104, Continuation<? super m<S>> r105) {
        if ((r105 instanceof TaskFlowDslKt$tryStart$1) == false) goto L7;
        TaskFlowDslKt$tryStart$1 r106 = (TaskFlowDslKt$tryStart$1) r105;
        int r107 = r106.label;
        if ((r107 & Integer.MIN_VALUE) == 0) goto L7;
        r106.label = r107 - Integer.MIN_VALUE;
    L8:
        Object r108 = r106.result;
        Object r109 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r110 = r106.label;
        if (r110 == 0) goto L14;
        if (r110 != 1) goto L13;
        p r111 = (p) r106.L$3;
        r104 = (i) r106.L$2;
        r103 = (jha.c) r106.L$1;
        jha.g<S> r112 = (jha.g) r106.L$0;
        ResultKt.throwOnFailure(r108);
    L15:
        TaskFlowManager r113 = TaskFlowManager.f393247a;
        n r114 = TaskFlowManager.h(r112, new q.b(r111), r103, r104);
        if ((r114 instanceof n.d) == true) goto L18;
        if ((r114 instanceof n.b) == true) goto L22;
        if ((r114 instanceof n.a) == false) goto L29;
        Deferred<Unit> r115 = ((n.a) r114).f499143a;
        r106.L$0 = r112;
        r106.L$1 = r103;
        r106.L$2 = r104;
        r106.L$3 = r111;
        r106.label = 1;
        if (r115.await(r106) != r109) goto L15;
        return r109;
    L29:
        if ((r114 instanceof n.c) == false) goto L33;
        return null;
    L33:
        throw new NoWhenBranchMatchedException();
    L22:
        return new m(((n.b) r114).f499144a, false);
    L18:
        return new m(((n.d) r114).f499146a, true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r108);
        p r116 = new p(r100, r101, r102);
        r112 = r100;
        r111 = r116;
    L7:
        r106 = new TaskFlowDslKt$tryStart$1(r105);
        goto L8
    }
}
