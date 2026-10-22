package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.conditional.access.auth.v2.y;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.CheckPriority;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import i8b.n;
import i8b.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f417888a;

    public static final class a {
    }

    static {
    }

    public b(q r100) {
        Intrinsics.checkNotNullParameter(r100, "mManager");
        this.f417888a = r100;
    }

    @Override // i8b.n
    public final com.ss.android.lark.conditional.access.auth.v2.c a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        PolicyModel r101 = r100.f417894c;
        if (Intrinsics.areEqual(r101.getEntity().getEntityOperate(), "IM_MSG_FILE_READ") == false) goto L8;
        if (w4c.c.a().r() == false) goto L8;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ERROR, ValidateResultSource.OTHERS, null, null, 1016);
    L8:
        return c(r101, this.f417888a.j(r101, true));
    }

    public static com.ss.android.lark.conditional.access.auth.v2.c c(PolicyModel r110, com.ss.android.lark.conditional.access.auth.v2.e r111) {
        com.ss.android.lark.conditional.access.auth.v2.d r100 = r111.f417791a;
        if (r100 != null) goto L5;
        ScsLogger.d("SecurityPolicy_CheckAuthService", "memoryResult is null.");
    L5:
        com.ss.android.lark.conditional.access.auth.v2.c r101 = new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ERROR, ValidateResultSource.CACHE, null, null, 1016);
        r101.q(r110.getPointKey());
        if (r100 != null) goto L8;
    L36:
        return r101;
    L8:
        if (r100.b() == false) goto L10;
        ResultType r102 = ResultType.ALLOW;
    L11:
        r101.s(r102);
        r101.l(r100.a());
        r101.p(r100.c());
        r101.t(true);
        r101.m(r110.getTaskId());
        r101.n(r111.f417792b);
        Long r112 = r100.g();
        if (r112 == null) goto L25;
        long r103 = r112.longValue();
        if (r103 >= System.currentTimeMillis()) goto L25;
        com.ss.android.lark.storage.kv.repo.a r113 = y.f417932a;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a == true) goto L18;
    L22:
        r101.t(false);
    L23:
        FileAuthMonitor.UpdateTrigger[] r114 = FileAuthMonitor.f418450a;
        long r104 = System.currentTimeMillis() - r103;
        Intrinsics.checkNotNullParameter(r110, "policyModel");
        String r115 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_hit_invalid_cache", MapsKt.mapOf(new Pair[]{TuplesKt.to(WikiFolderPushPlugin.OPT, r110.getEntity().getEntityOperate()), TuplesKt.to("entityType", r110.getEntity().getEntityType()), TuplesKt.to("entityDomain", r110.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r110.getPointKey())}), MapsKt.mapOf(TuplesKt.to("invalid_duration", Long.valueOf(r104 / ((long) 1000)))), null, 0, 24);
        goto L25
    L18:
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440410b == true) goto L22;
        if (Intrinsics.areEqual(r110.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L22;
        r101.o();
    L25:
        if (r101.k() == true) goto L27;
    L30:
        ScsLogger.d("SecurityPolicy_MemoryCheckInterceptor", "[cacheIsValid:False]");
    L31:
        ValidateLogInfo r116 = com.ss.android.lark.conditional.access.auth.v2.g.b(r100);
        if (r116 == null) goto L36;
        if (Intrinsics.areEqual(r110.getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS_WITH_OBJECT") == true) goto L36;
        r101.u(CollectionsKt.listOf(r116));
        goto L36
    L27:
        if (r101.j() == false) goto L30;
        ScsLogger.d("SecurityPolicy_MemoryCheckInterceptor", "[cacheIsValid:True]");
        goto L31
    L10:
        r102 = ResultType.DENY;
        goto L11
    }

    @Override // i8b.n
    public final Object b(com.ss.android.lark.conditional.access.auth.v2.service.chain.a r210, Continuation r211) {
        String r100 = "";
        if ((r211 instanceof MemoryCheckInterceptor$intercept$1) == false) goto L7;
        MemoryCheckInterceptor$intercept$1 r101 = (MemoryCheckInterceptor$intercept$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r110 = false;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        List r106 = (List) r101.L$1;
        Map r107 = (Map) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L85:
        Map r108 = MapsKt.toMutableMap((Map) r103);
        Iterator r109 = r106.iterator();
    L87:
        if (r109.hasNext() == false) goto L97;
        PolicyModel r111 = (PolicyModel) r109.next();
        com.ss.android.lark.conditional.access.auth.v2.c r112 = (com.ss.android.lark.conditional.access.auth.v2.c) r108.get(r111.getTaskId());
        ValidateResultSource[] r113 = {ValidateResultSource.DOWNGRADE, ValidateResultSource.FALLBACK};
        if (r112 == null) goto L91;
        ValidateResultSource r114 = r112.g();
    L93:
        if (ArraysKt.contains(r113, r114) == false) goto L87;
        com.ss.android.lark.conditional.access.auth.v2.c r115 = c(r111, this.f417888a.j(r111, false));
        if (r115.h() == ResultType.ERROR) goto L87;
        r108.put(r111.getTaskId(), r115);
        goto L87
    L91:
        r114 = null;
        goto L93
    L97:
        r107.putAll(r108);
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
    L23:
        return r103;
    L16:
        ResultKt.throwOnFailure(r103);
        List<PolicyModel> r116 = r210.f417885c;
        if (Intrinsics.areEqual(((PolicyModel) CollectionsKt.first(r116)).getEntity().getEntityOperate(), "IM_MSG_FILE_READ") == true) goto L19;
    L24:
        LinkedHashMap r117 = new LinkedHashMap();
        ArrayList r118 = new ArrayList();
        String r119 = r210.f417887e;
        String r120 = qqb.a.d();     // Catch: Throwable -> L104
        qqb.a.f(r119);     // Catch: Throwable -> L102
        Iterator<T> r121 = r116.iterator();     // Catch: Throwable -> L102
    L27:
        if (r121.hasNext() == false) goto L77;
        PolicyModel r122 = (PolicyModel) r121.next();     // Catch: Throwable -> L102
        if (Intrinsics.areEqual(r122.getPointKey(), "PointKey_CCM_OPEN_EXTERNAL_ACCESS") == false) goto L33;
        com.ss.android.lark.conditional.access.auth.v2.c r123 = new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.OTHERS, null, null, 1016);     // Catch: Throwable -> L102
    L75:
        r117.put(r122.getTaskId(), r123);     // Catch: Throwable -> L102
        r110 = false;
        goto L27
    L33:
        com.ss.android.lark.conditional.access.auth.v2.e r124 = this.f417888a.j(r122, r110);     // Catch: Throwable -> L102
        com.ss.android.lark.conditional.access.auth.v2.c r125 = c(r122, r124);     // Catch: Throwable -> L102
        int r126 = ScsLogger.f440428a;     // Catch: Throwable -> L102
        StringBuilder r127 = new StringBuilder();     // Catch: Throwable -> L102
        r127.append("checkPriority is: ");     // Catch: Throwable -> L102
        ValidateConfig r128 = r210.f417886d;     // Catch: Throwable -> L102
        if (r128 == null) goto L36;
        CheckPriority r129 = r128.getCheckPriority();     // Catch: Throwable -> L102
    L37:
        r127.append(r129);     // Catch: Throwable -> L102
        ScsLogger.d("SecurityPolicy_CheckAuthService", r127.toString());     // Catch: Throwable -> L102
        ValidateConfig r130 = r210.f417886d;     // Catch: Throwable -> L102
        if (r130 == null) goto L40;
        CheckPriority r131 = r130.getCheckPriority();     // Catch: Throwable -> L102
    L42:
        if (r131 != CheckPriority.RemoteFirst) goto L44;
        boolean r132 = true;
    L45:
        if (r132 == false) goto L47;
    L73:
        r118.add(r122);     // Catch: Throwable -> L102
    L74:
        r123 = r125;
        goto L75
    L47:
        if (r125.h() == ResultType.ERROR) goto L73;
        if (r125.e() == true) goto L73;
        if (r125.k() == false) goto L73;
        com.ss.android.lark.storage.kv.repo.a r133 = y.f417932a;     // Catch: Throwable -> L102
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a == false) goto L74;
        if (Intrinsics.areEqual(r122.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L74;
        com.ss.android.lark.conditional.access.auth.v2.d r134 = r124.f417791a;     // Catch: Throwable -> L102
        if (r134 == null) goto L70;
        Map<String, Integer> r135 = com.ss.android.lark.conditional.access.auth.v2.g.f417797a;     // Catch: Throwable -> L102
        Intrinsics.checkNotNullParameter(r134, "<this>");     // Catch: Throwable -> L102
        Long r136 = r134.g();     // Catch: Throwable -> L102
        if (r136 == null) goto L62;
        long r137 = r136.longValue();     // Catch: Throwable -> L102
    L64:
        if ((r137 - System.currentTimeMillis()) < 0) goto L66;
        boolean r138 = true;
    L68:
        if (r138 != true) goto L70;
        boolean r139 = true;
    L71:
        if (r139 == true) goto L74;
        ScsLogger.d("SecurityPolicy_MemoryCheckInterceptor", "im share isInvalid, taskID: " + r122.getTaskId());     // Catch: Throwable -> L102
        r118.add(r122);     // Catch: Throwable -> L102
        goto L74
    L66:
        r138 = false;
        goto L68
    L62:
        r137 = 0;
    L70:
        r139 = false;
        goto L71
    L44:
        r132 = false;
        goto L45
    L40:
        r131 = null;
        goto L42
    L36:
        r129 = null;
        goto L37
    L77:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r120, "traceId");
        qqb.a.g(r120);
        if (r118.size() <= 0) goto L101;
        String r140 = r210.f417887e;
        r100 = qqb.a.d();     // Catch: Throwable -> L98
        qqb.a.f(r140);     // Catch: Throwable -> L98
        ArrayList<String> r141 = com.ss.android.lark.conditional.access.utils.c.f418483a;     // Catch: Throwable -> L98
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_CheckAuthService", "async check no cache models: " + r118.size(), false);     // Catch: Throwable -> L98
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r100, "traceId");
        qqb.a.g(r100);
        r101.L$0 = r117;
        r101.L$1 = r118;
        r101.label = 2;
        r103 = r210.a(r118, r101);
        if (r103 != r104) goto L84;
        return r104;
    L84:
        r107 = r117;
        r106 = r118;
    L98:
        th = move-exception;
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r100, "traceId");
        qqb.a.g(r100);
        throw th;
    L101:
        return r117;
    L102:
        th = th;
        r100 = r120;
    L105:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r100, "traceId");
        qqb.a.g(r100);
        throw th;
    L104:
        th = th;
        goto L105
    L19:
        if (w4c.c.a().r() == false) goto L24;
        r101.label = 1;
        r103 = r210.a(r116, r101);
        if (r103 != r104) goto L23;
        return r104;
    L7:
        r101 = new MemoryCheckInterceptor$intercept$1(this, r211);
        goto L8
    }
}
