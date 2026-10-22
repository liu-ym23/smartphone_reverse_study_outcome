package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.api.model.filepolicy.h;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.n;
import i8b.q;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements n {

    public static final class a {
    }

    static {
    }

    public d(q r100) {
        Intrinsics.checkNotNullParameter(r100, "mManager");
    }

    public static boolean c(List r100) {
        if ((!r100.isEmpty()) == true) goto L5;
    L7:
        return false;
    L5:
        if (h.d(((PolicyModel) CollectionsKt.first(r100)).getEntity()) != FileBizDomain.FileBizDomainMeetingMinutes) goto L7;
        return true;
    }

    public static boolean d(List r100) {
        if ((!r100.isEmpty()) == true) goto L5;
    L7:
        return false;
    L5:
        if (h.d(((PolicyModel) CollectionsKt.first(r100)).getEntity()) != FileBizDomain.FileBizDomainVC) goto L7;
        return true;
    }

    public static boolean e(List r100) {
        if ((!r100.isEmpty()) == true) goto L5;
        return false;
    L5:
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.f440407a.values().contains(((PolicyModel) CollectionsKt.first(r100)).getPointKey()) == false) goto L7;
        return false;
    L7:
        if (ArraysKt.contains(e.f417890a, h.d(((PolicyModel) CollectionsKt.first(r100)).getEntity())) == true) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // i8b.n
    public final com.ss.android.lark.conditional.access.auth.v2.c a(g r110) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        long r100 = System.currentTimeMillis();
        PolicyModel r101 = r110.f417894c;
        if (com.ss.android.lark.conditional.access.utils.f.a() == true) goto L14;
        if (com.ss.android.lark.conditional.access.auth.v2.b.f417781c.contains(r101.getPointKey()) == true) goto L14;
        List<String> r102 = w4c.c.a().q0();
        if (r102 != null) goto L10;
        r102 = CollectionsKt.emptyList();
    L10:
        if (r102.contains(r101.getPointKey()) == true) goto L14;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L14:
        if (Intrinsics.areEqual(r101.getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS") == false) goto L18;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L18:
        if (d(CollectionsKt.listOf(r101)) == false) goto L22;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L22:
        if (w4c.c.a().L() == true) goto L28;
        if (c(CollectionsKt.listOf(r101)) == false) goto L28;
        ScsLogger.d("SecurityPolicy_PreCheckInterceptor", "syncCheck, MM is disable");
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L28:
        if (Intrinsics.areEqual(r101.getEntity().getEntityOperate(), "IM_MSG_FILE_READ") == false) goto L34;
        if (w4c.c.a().q() == false) goto L34;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    L34:
        if (w4c.c.a().D() == true) goto L36;
    L39:
        com.ss.android.lark.conditional.access.auth.v2.c r111 = r110.a(r101);
        FileAuthMonitor.UpdateTrigger[] r103 = FileAuthMonitor.f418450a;
        FileAuthMonitor.m(r101, r111, FileAuthMonitor.CheckType.CacheCheck, System.currentTimeMillis() - r100);
        return r111;
    L36:
        if (e(CollectionsKt.listOf(r101)) == false) goto L39;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);
    }

    @Override // i8b.n
    public final Object b(com.ss.android.lark.conditional.access.auth.v2.service.chain.a r100, Continuation r110) {
        if ((r110 instanceof PreCheckInterceptor$intercept$1) == false) goto L7;
        PreCheckInterceptor$intercept$1 r101 = (PreCheckInterceptor$intercept$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r101.J$0;
        List<PolicyModel> r106 = (List) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L50:
        Map r112 = (Map) r111;
        Iterator<T> r107 = r106.iterator();
    L52:
        if (r107.hasNext() == false) goto L56;
        PolicyModel r108 = (PolicyModel) r107.next();
        com.ss.android.lark.conditional.access.auth.v2.c r109 = (com.ss.android.lark.conditional.access.auth.v2.c) r112.get(r108.getTaskId());
        if (r109 == null) goto L52;
        FileAuthMonitor.UpdateTrigger[] r113 = FileAuthMonitor.f418450a;
        FileAuthMonitor.m(r108, r109, FileAuthMonitor.CheckType.AsyncCheck, System.currentTimeMillis() - r105);
        goto L52
    L56:
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        long r114 = System.currentTimeMillis();
        List<PolicyModel> r115 = r100.f417885c;
        List r116 = CollectionsKt.plus(w4c.c.a().q0(), com.ss.android.lark.conditional.access.auth.v2.b.f417781c);
        if (com.ss.android.lark.conditional.access.utils.f.a() == true) goto L21;
        if (r116.contains(((PolicyModel) CollectionsKt.first(r115)).getPointKey()) == true) goto L21;
        return com.ss.android.lark.conditional.access.utils.e.b(r115);
    L21:
        if (Intrinsics.areEqual(((PolicyModel) CollectionsKt.first(r115)).getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS") == false) goto L25;
        return com.ss.android.lark.conditional.access.utils.e.b(r115);
    L25:
        if (d(r115) == false) goto L29;
        return com.ss.android.lark.conditional.access.utils.e.b(r115);
    L29:
        if (w4c.c.a().L() == true) goto L35;
        if (c(r115) == false) goto L35;
        ScsLogger.d("SecurityPolicy_PreCheckInterceptor", "asyncCheck, MM is disable");
        return com.ss.android.lark.conditional.access.utils.e.b(r115);
    L35:
        if (Intrinsics.areEqual(((PolicyModel) CollectionsKt.first(r115)).getEntity().getEntityOperate(), "IM_MSG_FILE_READ") == false) goto L41;
        if (w4c.c.a().q() == false) goto L41;
        return com.ss.android.lark.conditional.access.utils.e.b(r115);
    L41:
        if (w4c.c.a().D() == true) goto L43;
    L46:
        r101.L$0 = r115;
        r101.J$0 = r114;
        r101.label = 1;
        Object r117 = r100.a(r115, r101);
        if (r117 != r103) goto L49;
        return r103;
    L49:
        r105 = r114;
        r111 = r117;
        r106 = r115;
        goto L50
    L43:
        if (e(r115) == false) goto L46;
        return com.ss.android.lark.conditional.access.utils.e.b(r115);
    L7:
        r101 = new PreCheckInterceptor$intercept$1(this, r110);
        goto L8
    }
}
