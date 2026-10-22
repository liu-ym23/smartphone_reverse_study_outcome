package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.bytedance.lark.policy.model.ResponseType;
import com.bytedance.lark.policy.model.b0;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import i8b.n;
import i8b.q;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f417889a;

    public c(q r100) {
        Intrinsics.checkNotNullParameter(r100, "mManager");
        this.f417889a = r100;
    }

    @Override // i8b.n
    public final com.ss.android.lark.conditional.access.auth.v2.c a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    }

    @Override // i8b.n
    public final Object b(a r100, Continuation r101) {
        if ((r101 instanceof PolicyCheckInterceptor$intercept$1) == false) goto L7;
        PolicyCheckInterceptor$intercept$1 r102 = (PolicyCheckInterceptor$intercept$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        String r107 = (String) r102.L$1;
        List<PolicyModel> r108 = (List) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L24:
        Map r109 = (Map) r104;     // Catch: Throwable -> L14
        qqb.a.a();
        qqb.a.f(r107);
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator<T> r111 = r108.iterator();
    L27:
        if (r111.hasNext() == false) goto L51;
        PolicyModel r112 = (PolicyModel) r111.next();
        b0 r113 = (b0) r109.get(r112.getTaskId());
        if (r113 == null) goto L46;
        int r114 = com.ss.android.lark.conditional.access.utils.e.f418491a;
        ResponseType r115 = r113.getType();
        if (r115 != null) goto L33;
        int r116 = -1;
    L34:
        if (r116 != 1) goto L36;
        ValidateResultSource r117 = ValidateResultSource.REMOTE_POLICY;
    L47:
        com.ss.android.lark.conditional.access.auth.v2.c r118 = com.ss.android.lark.conditional.access.auth.v2.b.a(r113, r117);
        if (Intrinsics.areEqual(r112.getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS_WITH_OBJECT") == false) goto L50;
        r118.u(CollectionsKt.emptyList());
    L50:
        r110.put(r112.getTaskId(), r118);
        goto L27
    L36:
        if (r116 != 2) goto L38;
        r117 = ValidateResultSource.LOCAL_POLICY;
        goto L47
    L38:
        if (r116 != 3) goto L40;
        r117 = ValidateResultSource.DOWNGRADE;
        goto L47
    L40:
        if (r116 == 4) goto L42;
        r117 = ValidateResultSource.OTHERS;
        goto L47
    L42:
        r117 = ValidateResultSource.FAST_PASS;
        goto L47
    L33:
        r116 = com.ss.android.lark.conditional.access.utils.e.a.f418492a[r115.ordinal()];
        goto L34
    L46:
        r117 = ValidateResultSource.OTHERS;
        goto L47
    L51:
        return r110;
    L14:
        th = th;
        String r119 = r107;
    L57:
        qqb.a.a();
        qqb.a.f(r119);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        List<PolicyModel> r120 = r100.f417885c;
        String r121 = r100.f417887e;
        r119 = qqb.a.d();     // Catch: Throwable -> L55
        qqb.a.f(r121);     // Catch: Throwable -> L53
        q r122 = this.f417889a;     // Catch: Throwable -> L53
        FileAuthMonitor.UpdateTrigger r123 = FileAuthMonitor.UpdateTrigger.BusinessCheck;     // Catch: Throwable -> L53
        r102.L$0 = r120;     // Catch: Throwable -> L53
        r102.L$1 = r119;     // Catch: Throwable -> L53
        r102.label = 1;     // Catch: Throwable -> L53
        Object r124 = r122.e(r120, r123, r102);     // Catch: Throwable -> L53
        if (r124 != r105) goto L23;
        return r105;
    L23:
        r108 = r120;
        r104 = r124;
        r107 = r119;
    L53:
        th = move-exception;
        th = th;
    L55:
        th = th;
        r119 = "";
    L7:
        r102 = new PolicyCheckInterceptor$intercept$1(this, r101);
        goto L8
    }
}
