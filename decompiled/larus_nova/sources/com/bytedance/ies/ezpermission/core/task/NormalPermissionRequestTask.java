package com.bytedance.ies.ezpermission.core.task;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.ezpermission.core.e;
import com.bytedance.ies.ezpermission.core.k;
import com.bytedance.ies.ezpermission.core.result.ResultWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class NormalPermissionRequestTask extends BasePermissionTask {
    public NormalPermissionRequestTask(a r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionContext");
        super(r100);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0123 -> B:36:0x0126). Please report as a decompilation issue!!! */
    @Override // com.bytedance.ies.ezpermission.core.task.BasePermissionTask
    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof NormalPermissionRequestTask$run$1) == false) goto L7;
        NormalPermissionRequestTask$run$1 r100 = (NormalPermissionRequestTask$run$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L47:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Iterator<List<com.bytedance.ies.ezpermission.core.permissions.a>> r105 = (Iterator) r100.L$6;
        List<com.bytedance.ies.ezpermission.core.permissions.a> r106 = (List) r100.L$5;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r107 = (List) r100.L$4;
        List r108 = (List) r100.L$3;
        final k r111 = (k) r100.L$2;
        ResultWrapper r112 = (ResultWrapper) r100.L$1;
        NormalPermissionRequestTask r113 = (NormalPermissionRequestTask) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L36:
        final List r109 = (List) r102;
        ArrayList r114 = new ArrayList();
        Iterator<T> r115 = r106.iterator();
    L38:
        if (r115.hasNext() == false) goto L42;
        Object r116 = r115.next();
        if (Boxing.boxBoolean(r109.contains(((com.bytedance.ies.ezpermission.core.permissions.a) r116).d())).booleanValue() == false) goto L38;
        r114.add(r116);
        goto L38
    L42:
        r108.addAll(r114);
        CollectionsKt.removeAll(r106, new NormalPermissionRequestTask$run$3(r109));
    L24:
        if (r105.hasNext() == false) goto L43;
        r106 = r105.next();
        List<com.bytedance.ies.ezpermission.core.permissions.a> r117 = r106;
        final ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r119 = r117.iterator();
    L27:
        if (r119.hasNext() == false) goto L29;
        r118.add(((com.bytedance.ies.ezpermission.core.permissions.a) r119.next()).d());
        goto L27
    L29:
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r121 = r117.iterator();
    L31:
        if (r121.hasNext() == false) goto L33;
        r120.add(((com.bytedance.ies.ezpermission.core.permissions.a) r121.next()).d());
        goto L31
    L33:
        Function0<Unit> r122 = new NormalPermissionRequestTask$run$grantedList$2(r118, r111);
        r100.L$0 = r113;
        r100.L$1 = r112;
        r100.L$2 = r111;
        r100.L$3 = r108;
        r100.L$4 = r107;
        r100.L$5 = r106;
        r100.L$6 = r105;
        r100.label = 1;
        r102 = r112.a(r120, r122, r100);
        if (r102 != r103) goto L36;
        return r103;
    L43:
        CollectionsKt.removeAll(r107, NormalPermissionRequestTask$run$4.INSTANCE);
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.L$6 = null;
        r100.label = 2;
        if (r113.a(r100) != r103) goto L47;
        return r103;
    L16:
        ResultKt.throwOnFailure(r102);
        e r123 = this.f248588b.b();
        if (r123 == null) goto L21;
        Fragment r124 = r123.f248570b;
        if (r124 == null) goto L21;
        ResultWrapper r125 = new ResultWrapper(r124);
    L22:
        this.f248588b.e(r125);
        e r126 = this.f248588b.b();
        c r127 = this.f248588b.g();
        k r128 = r126.f248577i;
        List<com.bytedance.ies.ezpermission.core.permissions.a> r129 = r127.f248589a;
        List<List<com.bytedance.ies.ezpermission.core.permissions.a>> r130 = r127.f248590b;
        n46.a.f517060b.getClass();
        n46.a.c("Start request normal permissions:" + r130);
        r113 = this;
        r112 = r125;
        r111 = r128;
        r105 = r130.iterator();
        r108 = r129;
        r107 = r130;
    L21:
        Activity r131 = r123.getActivity();
        Intrinsics.checkNotNull(r131);
        ResultWrapper r132 = new ResultWrapper(r131);
        Unit r133 = Unit.INSTANCE;
        r125 = r132;
    L7:
        r100 = new NormalPermissionRequestTask$run$1(this, r110);
        goto L8
    }
}
