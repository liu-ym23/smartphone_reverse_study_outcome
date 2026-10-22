package com.bytedance.ies.ezpermission.core.task;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.entry.auth.CertAuthEntry;
import com.bytedance.ies.ezpermission.core.PermissionResultListener;
import com.bytedance.ies.ezpermission.core.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class CheckAuthCertTask extends BasePermissionTask {
    public CheckAuthCertTask(com.bytedance.ies.ezpermission.core.d r100) {
        Intrinsics.checkNotNullParameter(r100, "permissionContext");
        super(r100);
    }

    @Override // com.bytedance.ies.ezpermission.core.task.BasePermissionTask
    public final Object b(Continuation<? super Unit> r100) {
        if ((r100 instanceof CheckAuthCertTask$run$1) == false) goto L7;
        CheckAuthCertTask$run$1 r101 = (CheckAuthCertTask$run$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 != 2) goto L16;
        e r106 = (e) r101.L$1;
        CheckAuthCertTask r107 = (CheckAuthCertTask) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: BPEAException -> L46
    L45:
        return Unit.INSTANCE;
    L29:
        n46.a r108 = n46.a.f517060b;
        String r109 = "auth failed " + r106.f248571c;
        r108.getClass();
        n46.a.c(r109);
        ArrayList r110 = new ArrayList();
        c r111 = r107.f248588b.g();
        Iterator<T> r112 = r111.f248590b.iterator();
    L31:
        if (r112.hasNext() == false) goto L37;
        List r113 = (List) r112.next();
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
    L34:
        if (r115.hasNext() == false) goto L36;
        r114.add(((com.bytedance.ies.ezpermission.core.permissions.a) r115.next()).d());
        goto L34
    L36:
        r110.addAll(r114);
        goto L31
    L37:
        List<m46.c> r116 = r111.f248591c;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r118 = r116.iterator();
    L39:
        if (r118.hasNext() == false) goto L41;
        r117.add(((m46.c) r118.next()).f507349a);
        goto L39
    L41:
        r110.addAll(r117);
        PermissionResultListener r119 = r106.f248579k;
        if (r119 == null) goto L45;
        r119.onResult(false, Collections.emptyList(), r110);
        goto L45
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
    L24:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r103);
        e r120 = this.f248588b.b();
        Cert r121 = r120.f248571c;
        if (r121 != null) goto L47;
        r101.label = 1;
        if (a(r101) != r104) goto L24;
        return r104;
    L47:
        CertAuthEntry.Companion.checkSDKCert(r121, new String[]{"permission"}, "EzPermission", "requestPermission");     // Catch: BPEAException -> L28
        r101.L$0 = this;     // Catch: BPEAException -> L28
        r101.L$1 = r120;     // Catch: BPEAException -> L28
        r101.label = 2;     // Catch: BPEAException -> L28
        if (a(r101) != r104) goto L45;
        return r104;
    L28:
        r107 = this;
        r106 = r120;
    L7:
        r101 = new CheckAuthCertTask$run$1(this, r100);
        goto L8
    }
}
