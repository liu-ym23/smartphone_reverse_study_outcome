package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import android.os.Handler;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.framework.utils.NetworkUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.conditional.access.auth.v2.l;
import com.ss.android.lark.conditional.access.auth.v2.service.i;
import com.ss.android.lark.conditional.access.auth.v2.y;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyEntityWithBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import i8b.n;
import i8b.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class HandleInvalidDataInterceptor implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f417875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f417876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f417877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap<String, PolicyModel> f417878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f417879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f417880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f417881g;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HandleInvalidDataInterceptor f417882a;

        public b(HandleInvalidDataInterceptor r100) {
            this.f417882a = r100;
        }

        public final void a() {
            HandleInvalidDataInterceptor r100 = this.f417882a;
            Object r101 = r100.f417877c;
            monitor-enter(r101);
            r100.f417880f = false;     // Catch: Throwable -> L19
            List r102 = CollectionsKt.toList(r100.f417878d.values());     // Catch: Throwable -> L19
            r100.f417878d.clear();     // Catch: Throwable -> L19
            monitor-exit(r101);
            if (r102.isEmpty() == true) goto L30;
            ArrayList r103 = new ArrayList();
            ArrayList r104 = new ArrayList();
            Iterator r105 = r102.iterator();
        L12:
            if (r105.hasNext() == false) goto L17;
            Object r106 = r105.next();
            if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.f440407a.values().contains(((PolicyModel) r106).getPointKey()) == true) goto L15;
            r104.add(r106);
            goto L12
        L15:
            r103.add(r106);
            goto L12
        L17:
            Pair r107 = new Pair(r103, r104);
            List<PolicyModel> r108 = (List) r107.component1();
            List<PolicyModel> r109 = (List) r107.component2();
            int r110 = ScsLogger.f440428a;
            ScsLogger.d("SecurityPolicy_HandleInvalidDataInterceptor", "flush NoCacheRetry batch, total:" + r102.size() + ", policyEngine:" + r109.size() + ", dlp:" + r108.size());
            r100.f(r109);
            r100.f(r108);
            return;
        L30:
            return;
        L19:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public HandleInvalidDataInterceptor(q r100) {
        Intrinsics.checkNotNullParameter(r100, "mManager");
        this.f417875a = r100;
        this.f417876b = new l();
        this.f417877c = new Object();
        this.f417878d = new LinkedHashMap();
        this.f417879e = LazyKt.lazy(HandleInvalidDataInterceptor$noCacheRetryHandler$2.INSTANCE);
        this.f417881g = new b(this);
    }

    public static List c(PolicyModel r110) {
        DecisionData.Action r100 = new DecisionData.Action();
        r100.setName("FILE_BLOCK_COMMON");
        r100.setParams(MapsKt.mapOf(new Pair[]{new Pair("entity_operation", r110.getEntity().getEntityOperate()), new Pair("file_biz_domain", r110.getEntity().getEntityDomain().getDomainName())}));
        DecisionData.Action r101 = new DecisionData.Action();
        r101.setName("BLOCKED_BY_IP_STRICT_POLICY");
        r101.setParams(MapsKt.mapOf(new Pair[]{new Pair("entity_operation", r110.getEntity().getEntityOperate()), new Pair("file_biz_domain", r110.getEntity().getEntityDomain().getDomainName()), new Pair("policyType", "FILE_PROTECT")}));
        return CollectionsKt.listOf(new DecisionData.Action[]{r100, r101});
    }

    @Override // i8b.n
    public final com.ss.android.lark.conditional.access.auth.v2.c a(g r210) {
        Intrinsics.checkNotNullParameter(r210, "chain");
        PolicyModel r100 = r210.f417894c;
        com.ss.android.lark.conditional.access.auth.v2.c r101 = r210.a(r100);
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440411c == true) goto L23;
        if (r101.e() == true) goto L11;
        if (r101.k() == false) goto L11;
        if (r101.h() == ResultType.ERROR) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L40;
        com.ss.android.lark.storage.kv.repo.a r103 = y.f417932a;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a == true) goto L18;
    L38:
        r102 = false;
        goto L40
    L18:
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L38;
        if (r101.j() == true) goto L38;
    L39:
        r102 = true;
    L40:
        long r104 = 0;
        if (r102 == false) goto L67;
        l r105 = this.f417876b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (idb.f.a().isEnable("lark.security.android_disable_policy_req_opt") == false) goto L45;
        boolean r106 = true;
    L57:
        if (r106 == false) goto L67;
        if (w4c.c.a().k() == false) goto L61;
        ScsLogger.d("SecurityPolicy_HandleInvalidDataInterceptor", "data is invalid or result is ERROR, notify NoCacheRetry immediately");
        f(CollectionsKt.listOf(r100));
    L62:
        this.f417876b.a(r100);
        goto L67
    L61:
        ScsLogger.d("SecurityPolicy_HandleInvalidDataInterceptor", "data is invalid or result is ERROR, enqueue NoCacheRetry");
        e(r100);
        goto L62
    L45:
        Object r107 = r105.f417831a;
        monitor-enter(r107);
        Long r108 = r105.f417832b.get(r100.getTaskId());     // Catch: Throwable -> L63
        if (r108 == null) goto L50;
        long r109 = r108.longValue();     // Catch: Throwable -> L63
    L51:
        if ((System.currentTimeMillis() - r109) <= 2000) goto L55;
        r106 = true;
    L56:
        monitor-exit(r107);
        goto L57
    L55:
        r106 = false;
        goto L56
    L50:
        r109 = 0;
    L63:
        th = move-exception;
        throw th;
    L67:
        if (r101.h() != ResultType.ERROR) goto L77;
        r101 = this.f417875a.a(r100);
        FileAuthMonitor.UpdateTrigger[] r110 = FileAuthMonitor.f418450a;
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        PolicyEntity r111 = r100.getEntity();
        if ((r111 instanceof PolicyEntityWithBizDomain) == false) goto L71;
        String r112 = ((PolicyEntityWithBizDomain) r111).getFileBizDomain().getBiz();
    L72:
        String r113 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_no_cache_downgrade", MapsKt.mapOf(new Pair[]{TuplesKt.to(WikiFolderPushPlugin.OPT, r100.getEntity().getEntityOperate()), TuplesKt.to("entityType", r100.getEntity().getEntityType()), TuplesKt.to("entityDomain", r100.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r100.getPointKey()), TuplesKt.to("fileBizDomain", r112), TuplesKt.to("networkAvailable", Boolean.valueOf(NetworkUtils.d(LarkContext.getApplication())))}), null, null, 0, 28);
        if (idb.f.a().isEnable("lark.security.file_ip_disconnect_deny") == true) goto L75;
    L89:
        return r101;
    L75:
        if (d(r101, r100) == false) goto L89;
        Log.i("SecurityPolicy_HandleInvalidDataInterceptor", "sync check with ip limit cache " + r100.getTaskId());
        r101.l(c(r100));
        r101.s(ResultType.DENY);
        r101.r(ValidateResultSource.DOWNGRADE);
        goto L89
    L71:
        r112 = "";
        goto L72
    L77:
        String r114 = r100.getTaskId();
        if (this.f417875a.i().keySet().contains(r114) == false) goto L89;
        i r115 = this.f417875a.i().get(r114);
        if (r115 == null) goto L89;
        if (r115.f417909a == false) goto L89;
        if (r115.f417910b == null) goto L89;
        long r116 = System.currentTimeMillis();
        Long r117 = r115.f417910b;
        if (r117 == null) goto L88;
        r104 = r117.longValue();
    L88:
        FileAuthMonitor.UpdateTrigger[] r118 = FileAuthMonitor.f418450a;
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        String r119 = u4c.a.f548750a;
        u4c.a.a("scs_security_policy_hit_delay_clear_cache", MapsKt.mapOf(new Pair[]{TuplesKt.to(WikiFolderPushPlugin.OPT, r100.getEntity().getEntityOperate()), TuplesKt.to("entityType", r100.getEntity().getEntityType()), TuplesKt.to("entityDomain", r100.getEntity().getEntityDomain()), TuplesKt.to("pointKey", r100.getPointKey())}), MapsKt.mapOf(TuplesKt.to("delay_duration", Long.valueOf((r116 - r104) / ((long) 1000)))), null, 0, 24);
    L11:
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_IM_MSG_FILE_READ") == true) goto L13;
        r102 = true;
        goto L14
    L23:
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L32;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440410b == true) goto L32;
        com.ss.android.lark.storage.kv.repo.a r120 = y.f417932a;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a == false) goto L38;
        if (r101.j() == true) goto L38;
    L32:
        if (r101.e() == true) goto L39;
        if (r101.k() == false) goto L39;
        if (r101.h() != ResultType.ERROR) goto L38;
        goto L38
    }

    public final void e(PolicyModel r100) {
        Object r101 = this.f417877c;
        monitor-enter(r101);
        this.f417878d.put(r100.getTaskId(), r100);     // Catch: Throwable -> L10
        if (this.f417880f == true) goto L7;
        this.f417880f = true;     // Catch: Throwable -> L10
        ((Handler) this.f417879e.getValue()).postDelayed(this.f417881g, 1000);     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void f(List<PolicyModel> r100) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        this.f417875a.c(new i8b.c(new i8b.b(new FileAuthMonitor.a(FileAuthMonitor.UpdateTrigger.NoCacheRetry, null), r100)));
    }

    @Override // i8b.n
    public final Object b(com.ss.android.lark.conditional.access.auth.v2.service.chain.a r110, Continuation r111) {
        if ((r111 instanceof HandleInvalidDataInterceptor$intercept$1) == false) goto L7;
        HandleInvalidDataInterceptor$intercept$1 r100 = (HandleInvalidDataInterceptor$intercept$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        List<PolicyModel> r113 = (List) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L18:
        Map r114 = (Map) r112;
        if (idb.f.a().isEnable("lark.security.file_ip_disconnect_deny") == false) goto L38;
        LinkedHashMap r104 = new LinkedHashMap(MapsKt.mapCapacity(r114.size()));
        Iterator r115 = r114.entrySet().iterator();
    L22:
        if (r115.hasNext() == false) goto L37;
        Map.Entry r105 = (Map.Entry) r115.next();
        Object r106 = r105.getKey();
        com.ss.android.lark.conditional.access.auth.v2.c r107 = (com.ss.android.lark.conditional.access.auth.v2.c) r105.getValue();
        Iterator<T> r108 = r113.iterator();
    L25:
        if (r108.hasNext() == false) goto L29;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((PolicyModel) r109).getTaskId(), r105.getKey()) == false) goto L25;
    L30:
        PolicyModel r116 = (PolicyModel) r109;
        if (r116 == null) goto L36;
        if (d(r107, r116) == false) goto L36;
        Log.i("SecurityPolicy_HandleInvalidDataInterceptor", "handle async check ip limit result: " + r113);
        r107.l(c(r116));
        r107.s(ResultType.DENY);
        r107.r(ValidateResultSource.DOWNGRADE);
    L36:
        r104.put(r106, r107);
        goto L22
    L29:
        r109 = null;
        goto L30
    L37:
        return r104;
    L38:
        return r114;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        List<PolicyModel> r117 = r110.f417885c;
        r100.L$0 = r117;
        r100.label = 1;
        Object r118 = r110.a(r117, r100);
        if (r118 != r102) goto L17;
        return r102;
    L17:
        r112 = r118;
        r113 = r117;
    L7:
        r100 = new HandleInvalidDataInterceptor$intercept$1(this, r111);
        goto L8
    }

    public final boolean d(com.ss.android.lark.conditional.access.auth.v2.c r100, PolicyModel r101) {
        boolean r102 = true;
        boolean r103 = !NetworkUtils.d(LarkContext.getApplication());
        if (r100.g() != ValidateResultSource.DOWNGRADE) goto L8;
        if (r103 == false) goto L8;
        if (this.f417875a.f(r101) == false) goto L8;
    L9:
        int r104 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_HandleInvalidDataInterceptor", "checkResultShouldDenyByIp network: " + r103 + ", result " + r102);
        return r102;
    L8:
        r102 = false;
        goto L9
    }
}
