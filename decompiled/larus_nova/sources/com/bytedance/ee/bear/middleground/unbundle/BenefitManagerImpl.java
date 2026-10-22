package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.middleground.unbundle.cache.BenefitCacheManager;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserState;
import f0c.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class BenefitManagerImpl implements BenefitManagerAPI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f234375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f234376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f234377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f234378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f234379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.unbundle.b f234380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BenefitCacheManager f234381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f234382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f234383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f234384j;

    public static final class a {
    }

    public static final class b implements Function1<h, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BenefitManagerImpl f234385a;

        public b(BenefitManagerImpl r100) {
            this.f234385a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(h r100) {
            h r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "userStatePayload");
            if (r101.f475035a != UserState.ONLINE) goto L8;
            if (this.f234385a.f234378d == true) goto L8;
            tt5.a.h("Benefit_ManagerImpl", "user login");
            this.f234385a.f234378d = true;
            BenefitManagerImpl r102 = this.f234385a;
            r102.f234384j = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new BenefitManagerImpl$userStateObserver$1$invoke$1(this.f234385a, null), 2, null);
        L8:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final void destroy() {
        tt5.a.h("Benefit_ManagerImpl", "destroy...");
        this.f234376b.b(this.f234383i);
        BenefitCacheManager r100 = this.f234381g;
        r100.getClass();
        tt5.a.h("Benefit_BenefitCacheManager", "clear...");
        Iterator r101 = ((ArrayList) r100.f234411f).iterator();
    L3:
        boolean r102 = false;
        if (r101.hasNext() == false) goto L12;
        Job r103 = (Job) r101.next();
        if (r103 != null) goto L8;
    L10:
        if (r102 == false) goto L3;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
        goto L3
    L8:
        if (r103.isActive() != true) goto L10;
        r102 = true;
        goto L10
    L12:
        com.bytedance.ee.bear.middleground.unbundle.b r104 = this.f234380f;
        monitor-enter(r104);
        com.bytedance.ee.util.ui.m.a(new c(r104));     // Catch: Throwable -> L26
        monitor-exit(r104);
        Job r105 = this.f234384j;
        if (r105 != null) goto L19;
    L21:
        if (r102 == false) goto L36;
        Job r106 = this.f234384j;
        if (r106 == null) goto L37;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
        return;
    L37:
        return;
    L36:
        return;
    L19:
        if (r105.isActive() != true) goto L21;
        r102 = true;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore n1() {
        if (this.f234377c == false) goto L5;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new BenefitManagerImpl$getCurrentUserBenefits$1(this, null), 2, null);
        BenefitCacheManager r100 = this.f234381g;
        monitor-enter(r100);
    L22:
        th = move-exception;
        throw th;
    L9:
        if (r100.f234409d != null) goto L15;
        tt5.a.h("Benefit_BenefitCacheManager", "userBenefitStore is null");     // Catch: Throwable -> L22
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;     // Catch: Exception -> L13 Throwable -> L22
        String r102 = (String) r101.d("unbundle_wiki_benefit", SliceInitService.DEFAULT_SWITCH);     // Catch: Exception -> L13 Throwable -> L22
        String r103 = (String) r101.d("unbundle_doc_benefit", SliceInitService.DEFAULT_SWITCH);     // Catch: Exception -> L13 Throwable -> L22
        String r104 = (String) r101.d("unbundle_base_benefit", SliceInitService.DEFAULT_SWITCH);     // Catch: Exception -> L13 Throwable -> L22
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L13 Throwable -> L22
        r105.put("unbundle_wiki_benefit", new JSONObject(r102));     // Catch: Exception -> L13 Throwable -> L22
        r105.put("unbundle_doc_benefit", new JSONObject(r103));     // Catch: Exception -> L13 Throwable -> L22
        r105.put("unbundle_base_benefit", new JSONObject(r104));     // Catch: Exception -> L13 Throwable -> L22
        tt5.a.h("Benefit_BenefitCacheManager", "sourceBenefit: " + r105);     // Catch: Exception -> L13 Throwable -> L22
        r100.f234409d = BenefitStore.b.b(BenefitStore.Companion, r100.f234407b, r105.toString(), "settings");     // Catch: Exception -> L13 Throwable -> L22
    L13:
        e = move-exception;
        tt5.a.e("Benefit_BenefitCacheManager", "get from settings err", e, false);     // Catch: Throwable -> L22
    L15:
        BenefitStore r106 = r100.f234409d;     // Catch: Throwable -> L22
        monitor-exit(r100);
        if (r106 == null) goto L20;
        tt5.a.h("Benefit_ManagerImpl", "getCurrentUserBenefits... from = " + r106.getFrom());
        return r106;
    L20:
        BenefitStore r107 = new BenefitStore(this.f234379e, new LinkedHashMap(), SliceInitService.DEFAULT_SWITCH, null, false, 24, null);
        tt5.a.h("Benefit_ManagerImpl", "getCurrentUserBenefits... from = " + r107.getFrom());
        return r107;
    L5:
        return new BenefitStore("", MapsKt.emptyMap(), "", null, false, 24, null);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore R7(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "token");
        return (BenefitStore) BuildersKt.runBlocking(Dispatchers.getIO(), new BenefitManagerImpl$fetchResourceBenefitsFromServer$1(this, r110, r111, null, true, null));
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore g7(String r110, int r111, BenefitManagerAPI.CacheType r210) {
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r210, "cacheType");
        if (this.f234377c == false) goto L5;
        tt5.a.h("Benefit_ManagerImpl", "getResourceBenefits... cacheType is " + r210);
        BenefitCacheManager r100 = this.f234381g;
        String r112 = "";
        if (r210 != BenefitManagerAPI.CacheType.TOKEN) goto L9;
        String r101 = r110;
    L10:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "cacheKey");
        BenefitStore r102 = r100.f234408c.get(r101);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BenefitManagerImpl$getResourceBenefits$1(this, r110, r111, null, r210, null), 3, null);
        StringBuilder r103 = new StringBuilder("getResourceBenefits... from = ");
        if (r102 == null) goto L13;
        String r104 = r102.getFrom();
    L14:
        r103.append(r104);
        tt5.a.h("Benefit_ManagerImpl", r103.toString());
        if (r102 == null) goto L17;
        return r102;
    L17:
        return new BenefitStore(r112, new LinkedHashMap(), SliceInitService.DEFAULT_SWITCH, null, false, 24, null);
    L13:
        r104 = null;
        goto L14
    L9:
        r101 = "";
        goto L10
    L5:
        return new BenefitStore("", MapsKt.emptyMap(), "", null, false, 24, null);
    }

    @Inject
    public BenefitManagerImpl(NetService r100, m r101, by4.b r102, com.bytedance.ee.util.db.a r103) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        Intrinsics.checkNotNullParameter(r101, "passportUserService");
        Intrinsics.checkNotNullParameter(r102, "kvStorage");
        Intrinsics.checkNotNullParameter(r103, "dbController");
        this.f234375a = r100;
        this.f234376b = r101;
        boolean r104 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.doc.enable_unbundle");
        this.f234377c = r104;
        String r105 = r101.getUser().userId;
        this.f234379e = r105;
        this.f234380f = new com.bytedance.ee.bear.middleground.unbundle.b(r100);
        this.f234381g = new BenefitCacheManager(r102, r103, r105);
        this.f234382h = new e();
        b r106 = new b(this);
        this.f234383i = r106;
        if (r104 == false) goto L5;
        tt5.a.h("Benefit_ManagerImpl", "BenefitManagerImpl init");
        r101.a(r106);
        return;
    L5:
        tt5.a.h("Benefit_ManagerImpl", "benefitEnable is false");
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final Object d8(String r210, int r211, String r212, BenefitManagerAPI.CacheType r213, Continuation<? super BenefitStore> r214) {
        if ((r214 instanceof BenefitManagerImpl$asyncGetResourceBenefits$1) == false) goto L7;
        BenefitManagerImpl$asyncGetResourceBenefits$1 r100 = (BenefitManagerImpl$asyncGetResourceBenefits$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        BenefitManagerImpl$asyncGetResourceBenefits$1 r102 = r100;
        Object r103 = r102.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r105 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L32:
        BenefitStore r106 = (BenefitStore) r103;
        if (r106 == null) goto L35;
    L39:
        return r106;
    L35:
        if (r105 != null) goto L37;
        String r111 = "";
    L38:
        r106 = new BenefitStore(r111, new LinkedHashMap(), SliceInitService.DEFAULT_SWITCH, null, false, 24, null);
        goto L39
    L37:
        r111 = r105;
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (this.f234377c == false) goto L17;
        tt5.a.h("Benefit_ManagerImpl", "asyncGetResourceBenefits... cacheType is " + r213);
        BenefitCacheManager r107 = this.f234381g;
        if (r213 != BenefitManagerAPI.CacheType.TOKEN) goto L21;
        String r108 = r210;
    L24:
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "cacheKey");
        BenefitStore r112 = r107.f234408c.get(r108);
        if (r112 == null) goto L28;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BenefitManagerImpl$asyncGetResourceBenefits$2(this, r210, r211, r212, r213, null), 3, null);
        tt5.a.h("Benefit_ManagerImpl", "asyncGetResourceBenefits... from = " + r112.getFrom());
        return r112;
    L28:
        r102.L$0 = r212;
        r102.label = 1;
        r103 = a(this, r210, r211, r212, r213, false, r102, 16);
        if (r103 != r110) goto L31;
        return r110;
    L31:
        r105 = r212;
        goto L32
    L21:
        if (r212 != null) goto L23;
        r108 = "";
        goto L24
    L23:
        r108 = r212;
        goto L24
    L17:
        return new BenefitStore("", MapsKt.emptyMap(), "", null, false, 24, null);
    L7:
        r100 = new BenefitManagerImpl$asyncGetResourceBenefits$1(this, r214);
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static Object a(final BenefitManagerImpl r100, final String r101, int r102, String r103, final BenefitManagerAPI.CacheType r104, boolean r105, Continuation r106, int r107) {
        Object r108 = null;
        Function1<BenefitStore, Unit> r109 = null;
        if ((r107 & 8) == 0) goto L6;
        r104 = null;
    L6:
        if ((r107 & 16) == 0) goto L8;
        r105 = false;
    L8:
        r100.getClass();
        if (((a4) org.koin.java.a.c(a4.class, null, null, 6)).c(r101) == true) goto L32;
        if (r104 == null) goto L13;
        r109 = new BenefitManagerImpl$fetchResBenefit$handleResult$1$1(r104, r100, r101);
    L13:
        com.bytedance.ee.bear.middleground.unbundle.b r110 = r100.f234380f;
        if (r103 != null) goto L16;
        r103 = "";
    L16:
        r110.getClass();
        tt5.a.h("Benefit_FetchResBenefitExecutor", "fetchResBenefit...  ownerId is " + r103 + ", token is " + du5.b.i(r101));
        if (r110.f234388b == true) goto L19;
        tt5.a.h("Benefit_FetchResBenefitExecutor", "mIsConnected is false");
    L19:
        j r111 = new j(IntrinsicsKt.intercepted(r106), 1);
        r111.C();
        monitor-enter(r110);
        String r112 = com.bytedance.ee.bear.middleground.unbundle.b.b(r101, r105);     // Catch: Throwable -> L33
        if (r110.f234391e.containsKey(r112) == true) goto L24;
        r110.f234391e.put(r112, new ArrayList());     // Catch: Throwable -> L33
        r110.c(r101, r102, r109, r105);     // Catch: Throwable -> L33
    L25:
        List r113 = (List) ((LinkedHashMap) r110.f234391e).get(r112);     // Catch: Throwable -> L33
        if (r113 == null) goto L28;
        r113.add(r111);     // Catch: Throwable -> L33
    L28:
        monitor-exit(r110);
        r108 = r111.B();
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        DebugProbesKt.probeCoroutineSuspended(r106);
        goto L32
    L24:
        tt5.a.h("Benefit_FetchResBenefitExecutor", "fetchResBenefit...  token is " + du5.b.i(r101) + "  is requesting, includeOwnerTenantInfo = " + r105);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L32:
        return r108;
    }
}
