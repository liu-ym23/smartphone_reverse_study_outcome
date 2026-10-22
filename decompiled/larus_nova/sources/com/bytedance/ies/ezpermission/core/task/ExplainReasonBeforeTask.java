package com.bytedance.ies.ezpermission.core.task;

import com.bytedance.ies.ezpermission.EzPermission;
import com.bytedance.ies.ezpermission.core.e;
import com.bytedance.ies.ezpermission.core.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ExplainReasonBeforeTask extends BasePermissionTask {
    public ExplainReasonBeforeTask(com.bytedance.ies.ezpermission.core.d r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionContext");
        super(r100);
    }

    @Override // com.bytedance.ies.ezpermission.core.task.BasePermissionTask
    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof ExplainReasonBeforeTask$run$1) == false) goto L7;
        ExplainReasonBeforeTask$run$1 r100 = (ExplainReasonBeforeTask$run$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r111);
    L53:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ExplainReasonBeforeTask$run$1 r104 = (ExplainReasonBeforeTask$run$1) r100.L$4;
        i r105 = (i) r100.L$3;
        List r106 = (List) r100.L$2;
        List r107 = (List) r100.L$1;
        ExplainReasonBeforeTask r108 = (ExplainReasonBeforeTask) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L49:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 3;
        if (r108.a(r100) != r102) goto L53;
        return r102;
    L17:
        ExplainReasonBeforeTask$run$1 r109 = (ExplainReasonBeforeTask$run$1) r100.L$5;
        i r112 = (i) r100.L$4;
        List r113 = (List) r100.L$3;
        List r114 = (List) r100.L$2;
        i r115 = (i) r100.L$1;
        ExplainReasonBeforeTask r116 = (ExplainReasonBeforeTask) r100.L$0;
        ResultKt.throwOnFailure(r111);
        List r117 = r113;
        r108 = r116;
    L38:
        if (r115 == null) goto L49;
        r100.L$0 = r108;
        r100.L$1 = r114;
        r100.L$2 = r117;
        r100.L$3 = r115;
        r100.L$4 = r100;
        r100.L$5 = null;
        r100.label = 2;
        SafeContinuation r118 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        List r119 = r117;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L41:
        if (r121.hasNext() == false) goto L43;
        r120.add(((com.bytedance.ies.ezpermission.core.permissions.a) r121.next()).d());
        goto L41
    L43:
        r115.a();
        Object r122 = r118.getOrThrow();
        if (r122 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L46:
        if (r122 != r102) goto L49;
        return r102;
    L18:
        ResultKt.throwOnFailure(r111);
        e r123 = this.f248588b.b();
        EzPermission.INSTANCE.getGlobalConfig();
        r115 = r123.f248573e;
        if (r115 == null) goto L48;
        c r124 = this.f248588b.g();
        if (r124 == null) goto L48;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r125 = r124.f248590b;
        if (r125 == null) goto L48;
        List r126 = CollectionsKt.flatten(r125);
        if (r126 == null) goto L48;
        ArrayList r127 = new ArrayList();
        Iterator r128 = r126.iterator();
    L28:
        if (r128.hasNext() == false) goto L33;
        Object r129 = r128.next();
        if (Boxing.boxBoolean(((com.bytedance.ies.ezpermission.core.permissions.a) r129).b(this.f248588b.getActivity())).booleanValue() == false) goto L28;
        r127.add(r129);
        goto L28
    L33:
        if (Boxing.boxBoolean(!r127.isEmpty()).booleanValue() == true) goto L36;
        r127 = null;
    L36:
        if (r127 == null) goto L48;
        n46.a.f517060b.getClass();
        n46.a.c("On explain before:" + r127);
        r117 = r127;
        r114 = r117;
        r108 = this;
    L48:
        r108 = this;
    L7:
        r100 = new ExplainReasonBeforeTask$run$1(this, r110);
        goto L8
    }
}
