package com.bytedance.ies.ezpermission.core.task;

import android.content.Context;
import android.content.Intent;
import com.bytedance.ies.ezpermission.EzPermission;
import com.bytedance.ies.ezpermission.core.e;
import com.bytedance.ies.ezpermission.core.k;
import com.bytedance.ies.ezpermission.core.result.ResultWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class SpecialPermissionRequestTask extends BasePermissionTask {
    public SpecialPermissionRequestTask(com.bytedance.ies.ezpermission.core.d r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionContext");
        super(r100);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.bytedance.ies.ezpermission.core.b] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01db -> B:66:0x0249). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0225 -> B:57:0x0228). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0234 -> B:63:0x0236). Please report as a decompilation issue!!! */
    @Override // com.bytedance.ies.ezpermission.core.task.BasePermissionTask
    public final Object b(Continuation<? super Unit> r210) {
        if ((r210 instanceof SpecialPermissionRequestTask$run$1) == false) goto L7;
        SpecialPermissionRequestTask$run$1 r100 = (SpecialPermissionRequestTask$run$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r110 = 1;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        ResultKt.throwOnFailure(r102);
    L71:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Iterator<m46.c> r105 = (Iterator) r100.L$9;
        final m46.c r111 = (m46.c) r100.L$8;
        List r112 = (List) r100.L$7;
        List<m46.c> r113 = (List) r100.L$6;
        Ref.ObjectRef r114 = (Ref.ObjectRef) r100.L$5;
        Ref.ObjectRef r115 = (Ref.ObjectRef) r100.L$4;
        List r106 = (List) r100.L$3;
        final k r107 = (k) r100.L$2;
        Context r108 = (Context) r100.L$1;
        final SpecialPermissionRequestTask r109 = (SpecialPermissionRequestTask) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L57:
        Boolean r116 = (Boolean) r102;
        if (r116 == null) goto L61;
        boolean r117 = r116.booleanValue();
    L63:
        if (r117 == false) goto L65;
        r106.add(r111);
        r112.add(r111);
    L65:
        Ref.ObjectRef r118 = r115;
        SpecialPermissionRequestTask r119 = r109;
        List r120 = r112;
        List r121 = r106;
        Ref.ObjectRef r211 = r114;
        Context r122 = r108;
        List<m46.c> r123 = r113;
        k r124 = r107;
        Ref.ObjectRef r125 = r211;
    L66:
        r110 = 1;
    L22:
        if (r105.hasNext() == false) goto L67;
        m46.c r126 = r105.next();
        com.bytedance.ies.ezpermission.core.b r127 = (com.bytedance.ies.ezpermission.core.b) r118.element;
        if (r127 == null) goto L26;
    L29:
        if (r127 == null) goto L36;
        r100.L$0 = r119;
        r100.L$1 = r122;
        r100.L$2 = r124;
        r100.L$3 = r121;
        r100.L$4 = r118;
        r100.L$5 = r125;
        r100.L$6 = r123;
        r100.L$7 = r120;
        r100.L$8 = r126;
        r100.L$9 = r105;
        r100.label = r110;
        SafeContinuation r128 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        com.bytedance.ies.ezpermission.core.b r129 = (com.bytedance.ies.ezpermission.core.b) r118.element;
        String r130 = r126.f507349a;
        r129.beforeRequest();
        r102 = r128.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L33:
        if (r102 != r103) goto L35;
        return r103;
    L35:
        boolean r131 = ((Boolean) r102).booleanValue();
    L37:
        if (r131 == true) goto L39;
    L46:
        if (r131 == false) goto L66;
    L28:
        Ref.ObjectRef r212 = r118;
        r111 = r126;
        r106 = r121;
        r112 = r120;
        r109 = r119;
        r115 = r212;
        k r213 = r124;
        r113 = r123;
        r108 = r122;
        r114 = r125;
        r107 = r213;
        if (r111.c(r108) == true) goto L62;
        Intent r132 = r111.e(r109.f248588b.getActivity());
        if (r132 == null) goto L61;
        ResultWrapper r133 = r109.f248588b.c();
        if (r133 == null) goto L61;
        Function0<Unit> r134 = new SpecialPermissionRequestTask$run$4(r111, r107);
        Function2<Integer, Intent, Boolean> r135 = new SpecialPermissionRequestTask$run$5(r109, r111);
        r100.L$0 = r109;
        r100.L$1 = r108;
        r100.L$2 = r107;
        r100.L$3 = r106;
        r100.L$4 = r115;
        r100.L$5 = r114;
        r100.L$6 = r113;
        r100.L$7 = r112;
        r100.L$8 = r111;
        r100.L$9 = r105;
        r100.label = 3;
        r102 = r133.b(r132, r134, null, r135, r100);
        if (r102 != r103) goto L57;
        return r103;
    L61:
        r117 = false;
        goto L63
    L62:
        r117 = true;
        goto L63
    L39:
        if (((com.bytedance.ies.ezpermission.core.b) r125.element) == null) goto L46;
        r100.L$0 = r119;
        r100.L$1 = r122;
        r100.L$2 = r124;
        r100.L$3 = r121;
        r100.L$4 = r118;
        r100.L$5 = r125;
        r100.L$6 = r123;
        r100.L$7 = r120;
        r100.L$8 = r126;
        r100.L$9 = r105;
        r100.label = 2;
        SafeContinuation r136 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        com.bytedance.ies.ezpermission.core.b r137 = (com.bytedance.ies.ezpermission.core.b) r125.element;
        String r138 = r126.f507349a;
        r137.beforeRequest();
        r102 = r136.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L43;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L43:
        if (r102 != r103) goto L45;
        return r103;
    L45:
        r131 = ((Boolean) r102).booleanValue();
        goto L46
    L36:
        r131 = false;
        goto L37
    L26:
        if (((com.bytedance.ies.ezpermission.core.b) r125.element) == null) goto L28;
    L67:
        r123.removeAll(r120);
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.L$6 = null;
        r100.L$7 = null;
        r100.L$8 = null;
        r100.L$9 = null;
        r100.label = 4;
        if (r119.a(r100) != r103) goto L71;
        return r103;
    L72:
        r117 = false;
        goto L63
    L18:
        r105 = (Iterator) r100.L$9;
        r126 = (m46.c) r100.L$8;
        r120 = (List) r100.L$7;
        r123 = (List) r100.L$6;
        r125 = (Ref.ObjectRef) r100.L$5;
        r118 = (Ref.ObjectRef) r100.L$4;
        r121 = (List) r100.L$3;
        r124 = (k) r100.L$2;
        r122 = (Context) r100.L$1;
        r119 = (SpecialPermissionRequestTask) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L45
    L19:
        r105 = (Iterator) r100.L$9;
        r126 = (m46.c) r100.L$8;
        r120 = (List) r100.L$7;
        r123 = (List) r100.L$6;
        r125 = (Ref.ObjectRef) r100.L$5;
        r118 = (Ref.ObjectRef) r100.L$4;
        r121 = (List) r100.L$3;
        r124 = (k) r100.L$2;
        r122 = (Context) r100.L$1;
        r119 = (SpecialPermissionRequestTask) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L35
    L20:
        ResultKt.throwOnFailure(r102);
        e r139 = this.f248588b.b();
        Context r140 = this.f248588b.getContext();
        k r141 = r139.f248577i;
        List<com.bytedance.ies.ezpermission.core.permissions.a> r142 = this.f248588b.g().f248589a;
        Ref.ObjectRef r143 = new Ref.ObjectRef();
        EzPermission.INSTANCE.getGlobalConfig();
        r143.element = null;
        r125 = new Ref.ObjectRef();
        r125.element = r139.f248576h;
        List<m46.c> r144 = this.f248588b.g().f248591c;
        n46.a.f517060b.getClass();
        n46.a.c("Start request special permissions:" + r144);
        ArrayList r145 = new ArrayList();
        r119 = this;
        r122 = r140;
        r124 = r141;
        r105 = r144.iterator();
        r121 = r142;
        r120 = r145;
        r118 = r143;
        r123 = r144;
    L7:
        r100 = new SpecialPermissionRequestTask$run$1(this, r210);
        goto L8
    }
}
