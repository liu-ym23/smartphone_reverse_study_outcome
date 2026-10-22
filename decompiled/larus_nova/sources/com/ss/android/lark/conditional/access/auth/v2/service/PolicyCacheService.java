package com.ss.android.lark.conditional.access.auth.v2.service;

import android.os.Build;
import android.os.Looper;
import android.util.LruCache;
import com.bytedance.lark.policy.model.ResponseType;
import com.bytedance.lark.policy.model.b0;
import com.google.gson.Gson;
import com.ss.android.lark.conditional.access.auth.v2.SecurityPolicyAuthManager;
import com.ss.android.lark.conditional.access.auth.v2.SenderTenantMap;
import com.ss.android.lark.conditional.access.auth.v2.o;
import com.ss.android.lark.conditional.access.auth.v2.p;
import com.ss.android.lark.conditional.access.auth.v2.r;
import com.ss.android.lark.conditional.access.auth.v2.u;
import com.ss.android.lark.conditional.access.auth.v2.x;
import com.ss.android.lark.conditional.access.auth.v2.y;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateLogInfo;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.e0;
import i8b.s;
import i8b.v;
import i8b.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class PolicyCacheService extends i8b.m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, com.ss.android.lark.conditional.access.auth.v2.d> f417849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d>> f417850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<Long, Boolean> f417851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f417852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f417853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f417854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f417855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f417856i;

    public static final class a {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
    }

    public final void i() {
        com.ss.android.lark.storage.kv.repo.a r100 = y.f417932a;
        Function1<SenderTenantMap, Unit> r101 = new PolicyCacheService$readSenderTenantIdMap$1(this);
        Intrinsics.checkNotNullParameter(r101, "onResult");
        y.f417938g.execute(new r(r101));
        Iterator<T> r102 = com.ss.android.lark.security.compliance.api.model.filepolicy.f.f440407a.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final String r103 = (String) r102.next();
        com.ss.android.lark.storage.kv.repo.a r104 = y.f417932a;
        Function1<Map<String, ? extends com.ss.android.lark.conditional.access.auth.v2.d>, Unit> r105 = new PolicyCacheService$loadDynamicData$1$1(this, r103);
        Intrinsics.checkNotNullParameter(r103, "pointKey");
        Intrinsics.checkNotNullParameter(r105, "onResult");
        y.f417938g.execute(new o(r103, r105));
        goto L4
    L6:
        Iterator<T> r106 = com.ss.android.lark.security.compliance.api.model.filepolicy.f.f440408b.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        final String r107 = (String) r106.next();
        com.ss.android.lark.storage.kv.repo.a r108 = y.f417932a;
        Function1<Map<String, ? extends com.ss.android.lark.conditional.access.auth.v2.d>, Unit> r109 = new PolicyCacheService$loadDynamicData$2$1(this, r107);
        Intrinsics.checkNotNullParameter(r107, "pointKey");
        Intrinsics.checkNotNullParameter(r109, "onResult");
        y.f417938g.execute(new o(r107, r109));
        goto L8
    L10:
        com.ss.android.lark.storage.kv.repo.a r110 = y.f417932a;
        if (y.b() == false) goto L13;
        int r111 = w4c.c.a().v().a();
    L14:
        Function1<LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d>, Unit> r112 = new PolicyCacheService$loadDynamicData$3(this);
        Intrinsics.checkNotNullParameter(r112, "onResult");
        if (y.b() == false) goto L19;
        int r113 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "getLatestImFileReadResult() V2, size:" + r111);
        com.ss.android.lark.conditional.access.auth.v2.j r114 = y.f417939h;
        if (r114 == null) goto L26;
        Intrinsics.checkNotNullParameter(r112, "onResult");
        r114.f417830c.execute(new com.ss.android.lark.conditional.access.auth.v2.h(r111, r114, r112));
        return;
    L26:
        return;
    L19:
        int r115 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "getLatestImFileReadResult() V1, size:" + r111);
        if (y.f417933b == null) goto L22;
        y.f417938g.execute(new p(r111, r112));
        return;
    L22:
        r112.invoke(new LruCache(r111));
        return;
    L13:
        r111 = w4c.c.a().i0();
        goto L14
    }

    public PolicyCacheService(SecurityPolicyAuthManager r100) {
        Intrinsics.checkNotNullParameter(r100, "mManager");
        super(r100);
        this.f417849b = new HashMap();
        this.f417850c = new HashMap();
        this.f417851d = new HashMap();
        this.f417852e = "";
        this.f417853f = LazyKt.lazy(PolicyCacheService$debugMode$2.INSTANCE);
        this.f417854g = LazyKt.lazy(PolicyCacheService$devMode$2.INSTANCE);
        this.f417855h = CollectionsKt.plus(com.ss.android.lark.security.compliance.api.model.filepolicy.f.f440408b, w4c.c.a().q0());
        this.f417856i = w4c.c.a().h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r210) {
        Intrinsics.checkNotNullParameter(r210, "event");
        String r100 = "SecurityPolicy_PolicyCacheService";
        if ((r210 instanceof w) == false) goto L141;
        ArrayList<String> r101 = com.ss.android.lark.conditional.access.utils.c.f418483a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_PolicyCacheService", "handleEvent ValidateUpdateEvent.", false);
        v r102 = (v) ((w) r210).f440413a;
        List<PolicyModel> r103 = r102.f488733a;
        Map<String, b0> r104 = r102.f488734b;
        FileAuthMonitor.a r105 = r102.f488735c;
        Intrinsics.checkNotNullParameter(r103, "models");
        Intrinsics.checkNotNullParameter(r104, "resultMap");
        Intrinsics.checkNotNullParameter(r105, "updateInfo");
        ArrayList r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
        Iterator r108 = r103.iterator();
        boolean r109 = false;
    L5:
        boolean r110 = true;
        if (r108.hasNext() == false) goto L127;
        PolicyModel r111 = (PolicyModel) r108.next();
        String r112 = r111.getPointKey();
        String r113 = r111.getTaskId();
        b0 r114 = r104.get(r113);
        if (r114 != null) goto L10;
    L125:
        FileAuthMonitor.a r211 = r105;
        Iterator r115 = r108;
        String r116 = r100;
        Map<String, b0> r117 = r104;
        r106 = r106;
    L126:
        r108 = r115;
        r104 = r117;
        r100 = r116;
        r106 = r106;
        r105 = r211;
        goto L5
    L10:
        if (com.ss.android.lark.conditional.access.auth.v2.b.f417779a.contains(r111.getPointKey()) == true) goto L125;
        if (r114.c() != null) goto L125;
        if (com.bytedance.lark.policy.utils.d.a(r114) == true) goto L125;
        boolean r118 = r114.f();
        String r119 = r114.e();
        ResponseType r120 = r114.getType();
        int r121 = com.ss.android.lark.conditional.access.utils.e.f418491a;
        com.ss.android.lark.conditional.access.auth.v2.d r122 = new com.ss.android.lark.conditional.access.auth.v2.d(r118, r119, r120, com.ss.android.lark.conditional.access.utils.e.d(r114.a()), r114.d(), qqb.a.d());
        if (com.ss.android.lark.conditional.access.auth.v2.b.f417782d.contains(r112) == false) goto L32;
        PolicyModel.a r123 = r111.getConfig();
        if (r123 != null) goto L20;
    L22:
        boolean r124 = false;
    L23:
        if (r124 == true) goto L32;
        com.ss.android.lark.conditional.access.auth.v2.d r125 = this.f417849b.put(r113, r122);
        if (r125 != null) goto L27;
    L29:
        r110 = false;
    L30:
        if (r110 == true) goto L125;
        r106.add(r112);
        goto L125
    L27:
        if (r125.b() != r122.b()) goto L29;
    L20:
        if (r123.f440394a != true) goto L22;
        r124 = true;
    L32:
        com.ss.android.lark.conditional.access.auth.v2.d r126 = l(r111, r122);
        if (r126 == null) goto L37;
        r115 = r108;
        if (r126.b() != r122.b()) goto L38;
        boolean r127 = true;
    L39:
        if (r127 == true) goto L42;
        r106.add(r112);
    L42:
        if (this.f417856i.contains(r111.getPointKey()) == false) goto L73;
        Intrinsics.checkNotNullParameter(r114, "<this>");
        List<com.bytedance.lark.policy.model.a> r128 = r114.a();
        if (r128 == null) goto L58;
        Iterator r129 = r128.iterator();
    L47:
        if (r129.hasNext() == false) goto L52;
        Object r130 = r129.next();
        Iterator r131 = r129;
        r117 = r104;
        if (Intrinsics.areEqual(((com.bytedance.lark.policy.model.a) r130).a(), "ACCESS_CONTROL_ACTION_COMMON") == true) goto L53;
        r104 = r117;
        r129 = r131;
    L53:
        com.bytedance.lark.policy.model.a r132 = (com.bytedance.lark.policy.model.a) r130;
        if (r132 == null) goto L59;
        Map<String, String> r133 = r132.b();
        if (r133 == null) goto L59;
        String r134 = r133.get("decisionCacheTTL");
    L61:
        if ((r134 instanceof Number) == false) goto L63;
        Long r135 = Long.valueOf(((Number) r134).longValue());
    L66:
        if (r135 != null) goto L68;
    L74:
        r135 = null;
    L75:
        String r136 = r111.getPointKey();
        r116 = r100;
        if (Intrinsics.areEqual(r136, "PointKey_IM_MSG_FILE_READ") == false) goto L111;
        if (r135 == null) goto L79;
        r211 = r105;
        r122.h(Long.valueOf(System.currentTimeMillis() + (r135.longValue() * ((long) 1000))));
    L85:
        com.ss.android.lark.storage.kv.repo.a r137 = y.f417932a;
        Intrinsics.checkNotNullParameter(r113, "key");
        Intrinsics.checkNotNullParameter(r122, "data");
        if (y.b() == false) goto L90;
        int r138 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "saveDynamicResult() V2, key:" + r113 + ", data:" + com.ss.android.lark.security.compliance.infra.util.f.c(r122));
        com.ss.android.lark.conditional.access.auth.v2.j r139 = y.f417939h;
        if (r139 == null) goto L91;
        Intrinsics.checkNotNullParameter(r113, "key");
        Intrinsics.checkNotNullParameter(r122, "data");
        r139.f417830c.execute(new com.ss.android.lark.conditional.access.auth.v2.i(r122, r139, r113));
    L91:
        PolicyEntity r140 = r111.getEntity();
        if ((r140 instanceof IMFileEntity) == false) goto L94;
        IMFileEntity r141 = (IMFileEntity) r140;
    L95:
        if (r141 == null) goto L97;
        Long r142 = r141.getSenderTenantId();
    L98:
        boolean r143 = r114.f();
        if (r142 == null) goto L110;
        Boolean r144 = this.f417851d.get(r142);
        if (r144 != null) goto L104;
        this.f417851d.put(r142, Boolean.valueOf(r143));
        goto L110
    L104:
        HashMap<Long, Boolean> r145 = this.f417851d;
        if (r144.booleanValue() == false) goto L108;
        if (r143 == false) goto L108;
        boolean r146 = true;
    L109:
        r145.put(r142, Boolean.valueOf(r146));
    L108:
        r146 = false;
    L110:
        r109 = true;
        goto L126
    L97:
        r142 = null;
        goto L98
    L94:
        r141 = null;
        goto L95
    L90:
        int r147 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "saveDynamicResult() V1, key:" + r113 + ", data:" + com.ss.android.lark.security.compliance.infra.util.f.c(r122));
        y.f417938g.execute(new com.ss.android.lark.conditional.access.auth.v2.v(r113, r122));
        goto L91
    L79:
        r211 = r105;
        com.ss.android.lark.storage.kv.repo.a r148 = y.f417932a;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a == false) goto L85;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440410b == true) goto L85;
        r122.h(Long.valueOf(System.currentTimeMillis() + (w4c.c.a().h0() * ((long) 1000))));
        goto L85
    L111:
        r211 = r105;
        r106 = r106;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.f.f440407a.values().contains(r136) == false) goto L119;
        r122.h(Long.valueOf(System.currentTimeMillis() + (w4c.c.a().t() * ((long) 1000))));
        com.ss.android.lark.storage.kv.repo.a r149 = y.f417932a;
        LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d> r150 = this.f417850c.get(r112);
        if (r150 == null) goto L116;
        Map<String, com.ss.android.lark.conditional.access.auth.v2.d> r151 = r150.snapshot();
    L117:
        Intrinsics.checkNotNullParameter(r112, "pointKey");
        y.f417938g.execute(new u(r151, r112));
        r107.add(r126);
        goto L126
    L116:
        r151 = null;
        goto L117
    L119:
        if (this.f417855h.contains(r136) == false) goto L126;
        com.ss.android.lark.storage.kv.repo.a r152 = y.f417932a;
        LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d> r153 = this.f417850c.get(r112);
        if (r153 == null) goto L123;
        Map<String, com.ss.android.lark.conditional.access.auth.v2.d> r154 = r153.snapshot();
    L124:
        Intrinsics.checkNotNullParameter(r112, "pointKey");
        y.f417938g.execute(new u(r154, r112));
        goto L126
    L123:
        r154 = null;
        goto L124
    L68:
        if (r135.longValue() <= 0) goto L70;
        boolean r155 = true;
    L71:
        if (r155 == false) goto L74;
    L70:
        r155 = false;
        goto L71
    L63:
        if (r134 == 0) goto L65;
        r135 = StringsKt.toLongOrNull(r134);
        goto L66
    L65:
        r135 = null;
    L59:
        r134 = 0;
        goto L61
    L52:
        r117 = r104;
        r130 = null;
        goto L53
    L58:
        r117 = r104;
        goto L59
    L73:
        r117 = r104;
    L38:
        r127 = false;
        goto L39
    L37:
        r115 = r108;
        goto L38
    L127:
        FileAuthMonitor.a r212 = r105;
        String r156 = r100;
        ArrayList r213 = r106;
        ArrayList r157 = new ArrayList();
        Iterator r158 = r107.iterator();
    L129:
        if (r158.hasNext() == false) goto L136;
        com.ss.android.lark.conditional.access.auth.v2.d r159 = (com.ss.android.lark.conditional.access.auth.v2.d) r158.next();
        if (r159 == null) goto L133;
        ValidateLogInfo r160 = com.ss.android.lark.conditional.access.auth.v2.g.b(r159);
    L134:
        if (r160 == null) goto L129;
        r157.add(r160);
        goto L129
    L133:
        r160 = null;
        goto L134
    L136:
        c(new i8b.j(r157));
        if ((!r213.isEmpty()) == false) goto L139;
        c(new i8b.i(new i8b.h(r213, r212)));
    L139:
        j(r109);
        ScsLogger.d(r156, "[end update auth result]");
        return;
    L141:
        if ((r210 instanceof s) == false) goto L169;
        List r161 = (List) ((s) r210).f440413a;
        int r162 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "removeResult, taskIDs size is " + r161.size());
        Iterator r163 = r161.iterator();
    L144:
        if (r163.hasNext() == false) goto L148;
        String r164 = (String) r163.next();
        this.f417849b.remove(r164);
        String r165 = com.ss.android.lark.security.compliance.api.model.filepolicy.h.k(r164);
        if (r165 == null) goto L144;
        this.f417850c.put(r165, new LruCache(w4c.c.a().l0()));
        com.ss.android.lark.storage.kv.repo.a r166 = y.f417932a;
        Map r167 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r165, "pointKey");
        y.f417938g.execute(new u(r167, r165));
        goto L144
    L148:
        j(false);
        return;
    }

    @Override // i8b.m
    public final com.ss.android.lark.conditional.access.auth.v2.c f(PolicyModel r110) {
        Intrinsics.checkNotNullParameter(r110, "policyModel");
        PolicyEntity r111 = r110.getEntity();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity");
        Long r112 = ((IMFileEntity) r111).getSenderTenantId();
        if (Intrinsics.areEqual(this.f417851d.get(r112), Boolean.FALSE) == false) goto L6;
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.DENY, ValidateResultSource.FALLBACK, null, null, 1016);
    L6:
        return new com.ss.android.lark.conditional.access.auth.v2.c(ResultType.ALLOW, ValidateResultSource.FALLBACK, null, null, 1016);
    }

    @Override // i8b.m
    public final void h(List<PolicyModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "policyModels");
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "removeCaches, policyModels size is " + ((ArrayList) r100).size());
        Iterator<T> r102 = r100.iterator();
    L3:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L15;
        PolicyModel r104 = (PolicyModel) r102.next();
        String r105 = r104.getTaskId();
        if (com.ss.android.lark.conditional.access.auth.v2.b.f417782d.contains(r104.getPointKey()) == false) goto L14;
        PolicyModel.a r106 = r104.getConfig();
        if (r106 != null) goto L10;
    L12:
        if (r103 == true) goto L14;
        this.f417849b.remove(r105);
        goto L3
    L10:
        if (r106.f440394a != true) goto L12;
        r103 = true;
    L14:
        k(r104.getPointKey(), r105);
        goto L3
    L15:
        j(false);
    }

    public final void j(boolean r100) {
        com.ss.android.lark.conditional.access.auth.v2.k r101 = new com.ss.android.lark.conditional.access.auth.v2.k(this.f417849b);
        if (Intrinsics.areEqual(this.f417852e, "") == true) goto L11;
        com.ss.android.lark.storage.kv.repo.a r102 = y.f417932a;
        Intrinsics.checkNotNullParameter(r101, "data");
        com.ss.android.lark.storage.kv.repo.a r103 = y.f417932a;
        if (r103 == null) goto L7;
        r103.putJSONObject("FilePolicyValidateResult", r101);
    L7:
        ArrayList<String> r104 = com.ss.android.lark.conditional.access.utils.c.f418483a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_PolicyCacheService", "putMemoryIntoLocal() done", false);
        if (r100 == false) goto L12;
        SenderTenantMap r105 = new SenderTenantMap(this.f417851d);
        Intrinsics.checkNotNullParameter(r105, "tenantMap");
        y.f417938g.execute(new x(r105));
        return;
    L12:
        return;
    }

    @Override // i8b.a
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "tenantId");
        this.f417852e = r100;
        HashMap<String, com.ss.android.lark.conditional.access.auth.v2.d> r102 = this.f417849b;
        monitor-enter(r102);
        this.f417849b.clear();     // Catch: Throwable -> L19
        this.f417850c.clear();     // Catch: Throwable -> L19
        ArrayList<String> r103 = com.ss.android.lark.conditional.access.utils.c.f418483a;     // Catch: Throwable -> L19
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_PolicyCacheService", "loadLocalData(), old data clear", false);     // Catch: Throwable -> L19
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r102);
        com.ss.android.lark.storage.kv.repo.a r105 = y.f417932a;
        if (r105 == null) goto L9;
        com.ss.android.lark.conditional.access.auth.v2.k r106 = (com.ss.android.lark.conditional.access.auth.v2.k) r105.getJSONObject("FilePolicyValidateResult", com.ss.android.lark.conditional.access.auth.v2.k.class);
    L10:
        if (r106 != null) goto L12;
    L14:
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_PolicyCacheService", "loadLocalData(), update curUid static data complete", false);
        if (Build.VERSION.SDK_INT < 23) goto L17;
        Looper.getMainLooper().getQueue().addIdleHandler(new l(this));
        return;
    L17:
        i();
        return;
    L12:
        if (r106.a() == null) goto L14;
        this.f417849b = r106.a();
        goto L14
    L9:
        r106 = null;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // i8b.m
    public final com.ss.android.lark.conditional.access.auth.v2.e e(PolicyModel r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "policyModel");
        String r102 = r100.getTaskId();
        String r103 = null;
        if (com.ss.android.lark.conditional.access.auth.v2.b.f417782d.contains(r100.getPointKey()) == false) goto L12;
        PolicyModel.a r104 = r100.getConfig();
        if (r104 == null) goto L9;
        boolean r105 = true;
        if (r104.f440394a != true) goto L9;
    L10:
        if (r105 == true) goto L12;
        com.ss.android.lark.conditional.access.auth.v2.d r106 = this.f417849b.get(r102);
        String r107 = "StaticCache";
    L47:
        if (r106 == null) goto L49;
        int r108 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "[cacheType:" + r107 + "], [hitCache:True], [traceId:" + r106.e() + ']');
    L50:
        if (r106 == null) goto L53;
        r103 = r107;
    L53:
        return new com.ss.android.lark.conditional.access.auth.v2.e(r106, r103);
    L49:
        int r109 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "[cacheType:" + r107 + "], [hitCache:False]");
    L9:
        r105 = false;
    L12:
        LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d> r110 = this.f417850c.get(r100.getPointKey());
        if (r110 == null) goto L15;
        com.ss.android.lark.conditional.access.auth.v2.d r111 = r110.get(r102);
    L16:
        if (r111 != null) goto L44;
        if (r101 == true) goto L44;
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L44;
        com.ss.android.lark.storage.kv.repo.a r112 = y.f417932a;
        Intrinsics.checkNotNullParameter(r102, "key");
        if (y.b() == false) goto L34;
        com.ss.android.lark.conditional.access.auth.v2.j r113 = y.f417939h;
        if (r113 == null) goto L32;
        Intrinsics.checkNotNullParameter(r102, "key");
        x4c.g r114 = r113.a();
        Intrinsics.checkNotNullParameter(r102, "key");
        x4c.f r115 = (x4c.f) ((HashMap) r114.f562498c).get(r102);
        if (r115 == null) goto L27;
        r115.f562495d = System.currentTimeMillis();
        ((x4c.e) r114.f562497b).b(r115);
        String r116 = r115.f562494c;
    L31:
        Gson r117 = e0.f444707a;
        com.ss.android.lark.conditional.access.auth.v2.d r118 = (com.ss.android.lark.conditional.access.auth.v2.d) e0.a(r116, com.ss.android.lark.conditional.access.auth.v2.d.class);
    L33:
        int r119 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "getDynamicResult() V2, key:" + r102 + ", data:" + com.ss.android.lark.security.compliance.infra.util.f.c(r118));
    L39:
        if (r118 != null) goto L41;
    L43:
        r106 = r118;
    L45:
        r107 = "LRUCache";
        goto L47
    L41:
        if (r118.c() == true) goto L43;
        l(r100, r118);
        goto L43
    L27:
        x4c.f r120 = ((x4c.e) r114.f562497b).a(r102);
        if (r120 == null) goto L30;
        r120.f562495d = System.currentTimeMillis();
        ((x4c.e) r114.f562497b).b(r120);
        ((HashMap) r114.f562498c).put(r102, r120);
        r116 = r120.f562494c;
        goto L31
    L30:
        r116 = null;
        goto L31
    L32:
        r118 = null;
        goto L33
    L34:
        com.ss.android.lark.storage.kv.repo.a r121 = y.f417933b;
        if (r121 == null) goto L37;
        r118 = (com.ss.android.lark.conditional.access.auth.v2.d) r121.getJSONObject(r102, com.ss.android.lark.conditional.access.auth.v2.d.class);
    L38:
        int r122 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "getDynamicResult() V1, key:" + r102 + ", data:" + com.ss.android.lark.security.compliance.infra.util.f.c(r118));
        goto L39
    L37:
        r118 = null;
    L44:
        r106 = r111;
        goto L45
    L15:
        r111 = null;
        goto L16
    }

    public final void k(String r100, String r101) {
        if (Intrinsics.areEqual(r100, "PointKey_IM_MSG_FILE_READ") == false) goto L10;
        LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d> r102 = this.f417850c.get(r100);
        if (r102 == null) goto L9;
        com.ss.android.lark.conditional.access.auth.v2.d r103 = r102.get(r101);
        if (r103 == null) goto L9;
        r103.h(Long.valueOf(System.currentTimeMillis() - 1));
    L9:
        com.ss.android.lark.storage.kv.repo.a r104 = y.f417932a;
        Intrinsics.checkNotNullParameter(r101, "key");
        y.f417938g.execute(new com.ss.android.lark.conditional.access.auth.v2.s(r101));
        return;
    L10:
        int r105 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "removeDynamicCache skipped, pointKey: " + r100 + ", taskID: " + r101);
    }

    public final com.ss.android.lark.conditional.access.auth.v2.d l(PolicyModel r100, com.ss.android.lark.conditional.access.auth.v2.d r101) {
        if (w4c.c.a().j() == false) goto L5;
        return null;
    L5:
        String r102 = r100.getTaskId();
        if (this.f417850c.get(r100.getPointKey()) == null) goto L8;
    L17:
        LruCache<String, com.ss.android.lark.conditional.access.auth.v2.d> r103 = this.f417850c.get(r100.getPointKey());
        if (r103 != null) goto L20;
        return null;
    L20:
        return r103.put(r102, r101);
    L8:
        if (Intrinsics.areEqual(r100.getPointKey(), "PointKey_IM_MSG_FILE_READ") == false) goto L15;
        com.ss.android.lark.storage.kv.repo.a r104 = y.f417932a;
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a == true) goto L12;
    L14:
        int r105 = w4c.c.a().l0();
    L16:
        this.f417850c.put(r100.getPointKey(), new LruCache(r105));
        goto L17
    L12:
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440410b == true) goto L14;
        r105 = w4c.c.a().i0();
        goto L16
    L15:
        r105 = w4c.c.a().l0();
        goto L16
    }

    @Override // i8b.m
    public final void g(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276354d);
        Intrinsics.checkNotNullParameter(r101, "cacheType");
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyCacheService", "removeCache, taskID is " + r100 + ", cacheType is " + r101 + ", pointKey is " + r102);
        if (Intrinsics.areEqual(r101, "StaticCache") == false) goto L6;
        this.f417849b.remove(r100);
        j(false);
        return;
    L6:
        k(r102, r100);
        j(false);
    }
}
