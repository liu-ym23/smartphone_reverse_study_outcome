package com.bytedance.ies.ezpermission.core.task;

import com.bytedance.ies.ezpermission.EzPermission;
import com.bytedance.ies.ezpermission.core.e;
import com.bytedance.ies.ezpermission.core.h;
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
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class ExplainReasonAfterTask extends BasePermissionTask {
    public ExplainReasonAfterTask(com.bytedance.ies.ezpermission.core.d r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionContext");
        super(r100);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, com.bytedance.ies.ezpermission.core.h] */
    @Override // com.bytedance.ies.ezpermission.core.task.BasePermissionTask
    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof ExplainReasonAfterTask$run$1) == false) goto L7;
        ExplainReasonAfterTask$run$1 r100 = (ExplainReasonAfterTask$run$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L22;
        if (r104 == 1) goto L21;
        if (r104 == 2) goto L20;
        if (r104 == 3) goto L19;
        if (r104 == 4) goto L18;
        if (r104 != 5) goto L17;
        ResultKt.throwOnFailure(r102);
    L88:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
    L82:
        return Unit.INSTANCE;
    L19:
        ExplainReasonAfterTask$run$1 r105 = (ExplainReasonAfterTask$run$1) r100.L$4;
        List r106 = (List) r100.L$3;
        List r107 = (List) r100.L$2;
        Ref.ObjectRef r108 = (Ref.ObjectRef) r100.L$1;
        ExplainReasonAfterTask r109 = (ExplainReasonAfterTask) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L76:
        boolean r111 = ((Boolean) r102).booleanValue();
    L77:
        if (r111 == false) goto L84;
        a r112 = r109.f248588b;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 4;
        if (r112.d(r100) != r103) goto L82;
        return r103;
    L84:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 5;
        if (r109.a(r100) != r103) goto L88;
        return r103;
    L20:
        ExplainReasonAfterTask$run$1 r113 = (ExplainReasonAfterTask$run$1) r100.L$5;
        List r114 = (List) r100.L$4;
        List r115 = (List) r100.L$3;
        Ref.ObjectRef r116 = (Ref.ObjectRef) r100.L$2;
        Ref.ObjectRef r117 = (Ref.ObjectRef) r100.L$1;
        ExplainReasonAfterTask r118 = (ExplainReasonAfterTask) r100.L$0;
        ResultKt.throwOnFailure(r102);
        List r119 = r114;
        List r120 = r115;
    L62:
        r111 = ((Boolean) r102).booleanValue();
        List r121 = r119;
        List r122 = r120;
        r109 = r118;
        Ref.ObjectRef r123 = r116;
    L64:
        if (r111 == true) goto L77;
        if (((h) r123.element) == null) goto L77;
        r100.L$0 = r109;
        r100.L$1 = r123;
        r100.L$2 = r122;
        r100.L$3 = r121;
        r100.L$4 = r100;
        r100.L$5 = null;
        r100.label = 3;
        SafeContinuation r124 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        h r125 = (h) r123.element;
        List r126 = r121;
        ArrayList r127 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator r128 = r126.iterator();
    L69:
        if (r128.hasNext() == false) goto L71;
        r127.add(((com.bytedance.ies.ezpermission.core.permissions.a) r128.next()).d());
        goto L69
    L71:
        r125.a(r127, r124);
        r102 = r124.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L74;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L74:
        if (r102 != r103) goto L76;
        return r103;
    L21:
        ResultKt.throwOnFailure(r102);
    L28:
        return Unit.INSTANCE;
    L22:
        ResultKt.throwOnFailure(r102);
        if (this.f248588b.f() == false) goto L29;
        r100.label = 1;
        if (a(r100) != r103) goto L28;
        return r103;
    L29:
        e r129 = this.f248588b.b();
        Ref.ObjectRef r130 = new Ref.ObjectRef();
        EzPermission.INSTANCE.getGlobalConfig();
        r130.element = null;
        r123 = new Ref.ObjectRef();
        ?? r131 = r129.f248574f;
        r123.element = r131;
        if (((h) r130.element) != null) goto L32;
        if (r131 != 0) goto L32;
    L83:
        r109 = this;
    L32:
        c r132 = this.f248588b.g();
        if (r132 == null) goto L83;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r133 = r132.f248590b;
        if (r133 == null) goto L83;
        List r134 = CollectionsKt.flatten(r133);
        if (r134 == null) goto L83;
        ArrayList r135 = new ArrayList();
        Iterator r136 = r134.iterator();
    L40:
        if (r136.hasNext() == false) goto L45;
        Object r137 = r136.next();
        if (Boxing.boxBoolean(((com.bytedance.ies.ezpermission.core.permissions.a) r137).b(this.f248588b.getActivity())).booleanValue() == false) goto L40;
        r135.add(r137);
        goto L40
    L45:
        boolean r138 = Boxing.boxBoolean(!r135.isEmpty()).booleanValue();
        ArrayList r139 = r135;
        if (r138 == true) goto L49;
        r139 = null;
    L49:
        if (r139 == null) goto L83;
        if (((h) r130.element) == null) goto L63;
        r100.L$0 = this;
        r100.L$1 = r130;
        r100.L$2 = r123;
        r100.L$3 = r139;
        r100.L$4 = r139;
        r100.L$5 = r100;
        r100.label = 2;
        SafeContinuation r140 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        h r141 = (h) r130.element;
        ArrayList r142 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r139, 10));
        Iterator r143 = r139.iterator();
    L54:
        if (r143.hasNext() == false) goto L56;
        r142.add(((com.bytedance.ies.ezpermission.core.permissions.a) r143.next()).d());
        goto L54
    L56:
        r141.a(r142, r140);
        r102 = r140.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L59;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L59:
        if (r102 != r103) goto L61;
        return r103;
    L61:
        r116 = r123;
        ArrayList r144 = r139;
        r120 = r144;
        r118 = this;
        r119 = r144;
        goto L62
    L63:
        r111 = false;
        r109 = this;
        r121 = r139;
        r122 = r139;
    L7:
        r100 = new ExplainReasonAfterTask$run$1(this, r110);
        goto L8
    }
}
