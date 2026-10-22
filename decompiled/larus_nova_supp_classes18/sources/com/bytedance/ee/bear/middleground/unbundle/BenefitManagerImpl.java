package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.middleground.unbundle.cache.BenefitCacheManager;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BenefitManagerImpl implements BenefitManagerAPI {
    public final NetService a;
    public final m b;
    public final boolean c;
    public volatile boolean d;
    public final String e;
    public final com.bytedance.ee.bear.middleground.unbundle.b f;
    public final BenefitCacheManager g;
    public final e h;
    public final b i;
    public Job j;

    public static final class a {
    }

    public static final class b implements Function1<h, Unit> {
        public final /* synthetic */ BenefitManagerImpl a;

        public b(BenefitManagerImpl r1) {
            this.a = r1;
        }

        public final Object invoke(Object r7) {
            h r8 = (h) r7;
            Intrinsics.checkNotNullParameter(r8, "userStatePayload");
            if (r8.a != UserState.ONLINE) goto L8;
            if (this.a.d == true) goto L8;
            tt5.a.h("Benefit_ManagerImpl", "user login");
            this.a.d = true;
            BenefitManagerImpl r9 = this.a;
            r9.j = BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new BenefitManagerImpl$userStateObserver$1$invoke$1(this.a, null), 2, null);
        L8:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final void destroy() {
        tt5.a.h("Benefit_ManagerImpl", "destroy...");
        this.b.b(this.i);
        BenefitCacheManager r0 = this.g;
        r0.getClass();
        tt5.a.h("Benefit_BenefitCacheManager", "clear...");
        Iterator r1 = ((ArrayList) r0.f).iterator();
    L3:
        boolean r4 = false;
        if (r1.hasNext() == false) goto L12;
        Job r2 = (Job) r1.next();
        if (r2 != null) goto L8;
    L10:
        if (r4 == false) goto L3;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        goto L3
    L8:
        if (r2.isActive() != true) goto L10;
        r4 = true;
        goto L10
    L12:
        com.bytedance.ee.bear.middleground.unbundle.b r3 = this.f;
        monitor-enter(r3);
        com.bytedance.ee.util.ui.m.a(new c(r3));     // Catch: Throwable -> L26
        monitor-exit(r3);
        Job r5 = this.j;
        if (r5 != null) goto L19;
    L21:
        if (r4 == false) goto L36;
        Job r6 = this.j;
        if (r6 == null) goto L37;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
        return;
    L37:
        return;
    L36:
        return;
    L19:
        if (r5.isActive() != true) goto L21;
        r4 = true;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore n1() {
        if (this.c == false) goto L5;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new BenefitManagerImpl$getCurrentUserBenefits$1(this, null), 2, null);
        BenefitCacheManager r0 = this.g;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L9:
        if (r0.d != null) goto L15;
        tt5.a.h("Benefit_BenefitCacheManager", "userBenefitStore is null");     // Catch: Throwable -> L22
        com.bytedance.ee.bear.appsetting.c r2 = com.bytedance.ee.bear.appsetting.c.a.a;     // Catch: Exception -> L13 Throwable -> L22
        String r3 = (String) r2.d("unbundle_wiki_benefit", "{}");     // Catch: Exception -> L13 Throwable -> L22
        String r4 = (String) r2.d("unbundle_doc_benefit", "{}");     // Catch: Exception -> L13 Throwable -> L22
        String r5 = (String) r2.d("unbundle_base_benefit", "{}");     // Catch: Exception -> L13 Throwable -> L22
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L13 Throwable -> L22
        r6.put("unbundle_wiki_benefit", new JSONObject(r3));     // Catch: Exception -> L13 Throwable -> L22
        r6.put("unbundle_doc_benefit", new JSONObject(r4));     // Catch: Exception -> L13 Throwable -> L22
        r6.put("unbundle_base_benefit", new JSONObject(r5));     // Catch: Exception -> L13 Throwable -> L22
        tt5.a.h("Benefit_BenefitCacheManager", "sourceBenefit: " + r6);     // Catch: Exception -> L13 Throwable -> L22
        r0.d = BenefitStore.b.b(BenefitStore.Companion, r0.b, r6.toString(), BenefitStore.FROM_SETTINGS);     // Catch: Exception -> L13 Throwable -> L22
    L13:
        e = move-exception;
        tt5.a.e("Benefit_BenefitCacheManager", "get from settings err", e, false);     // Catch: Throwable -> L22
    L15:
        BenefitStore r1 = r0.d;     // Catch: Throwable -> L22
        monitor-exit(r0);
        if (r1 == null) goto L20;
        tt5.a.h("Benefit_ManagerImpl", "getCurrentUserBenefits... from = " + r1.getFrom());
        return r1;
    L20:
        BenefitStore r7 = new BenefitStore(this.e, new LinkedHashMap(), "{}", null, false, 24, null);
        tt5.a.h("Benefit_ManagerImpl", "getCurrentUserBenefits... from = " + r7.getFrom());
        return r7;
    L5:
        return new BenefitStore("", MapsKt.emptyMap(), "", null, false, 24, null);
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore R7(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_TOKEN);
        return (BenefitStore) BuildersKt.runBlocking(Dispatchers.getIO(), new BenefitManagerImpl$fetchResourceBenefitsFromServer$1(this, r10, r11, null, true, null));
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final BenefitStore g7(String r18, int r19, BenefitManagerAPI.CacheType r20) {
        Intrinsics.checkNotNullParameter(r18, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r20, "cacheType");
        if (this.c == false) goto L5;
        tt5.a.h("Benefit_ManagerImpl", "getResourceBenefits... cacheType is " + r20);
        BenefitCacheManager r0 = this.g;
        if (r20 != BenefitManagerAPI.CacheType.TOKEN) goto L9;
        String r1 = r18;
    L10:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "cacheKey");
        BenefitStore r9 = r0.c.get(r1);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BenefitManagerImpl$getResourceBenefits$1(this, r18, r19, null, r20, null), 3, null);
        StringBuilder r2 = new StringBuilder("getResourceBenefits... from = ");
        if (r9 == null) goto L13;
        String r3 = r9.getFrom();
    L14:
        r2.append(r3);
        tt5.a.h("Benefit_ManagerImpl", r2.toString());
        if (r9 == null) goto L17;
        return r9;
    L17:
        return new BenefitStore("", new LinkedHashMap(), "{}", null, false, 24, null);
    L13:
        r3 = null;
        goto L14
    L9:
        r1 = "";
        goto L10
    L5:
        return new BenefitStore("", MapsKt.emptyMap(), "", null, false, 24, null);
    }

    @Inject
    public BenefitManagerImpl(NetService r4, m r5, by4.b r6, com.bytedance.ee.util.db.a r7) {
        Intrinsics.checkNotNullParameter(r4, "netService");
        Intrinsics.checkNotNullParameter(r5, "passportUserService");
        Intrinsics.checkNotNullParameter(r6, "kvStorage");
        Intrinsics.checkNotNullParameter(r7, "dbController");
        this.a = r4;
        this.b = r5;
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.doc.enable_unbundle");
        this.c = r0;
        String r1 = r5.getUser().userId;
        this.e = r1;
        this.f = new com.bytedance.ee.bear.middleground.unbundle.b(r4);
        this.g = new BenefitCacheManager(r6, r7, r1);
        this.h = new e();
        b r8 = new b(this);
        this.i = r8;
        if (r0 == false) goto L5;
        tt5.a.h("Benefit_ManagerImpl", "BenefitManagerImpl init");
        r5.a(r8);
        return;
    L5:
        tt5.a.h("Benefit_ManagerImpl", "benefitEnable is false");
    }

    @Override // com.bytedance.ee.bear.unbundle.BenefitManagerAPI
    public final Object d8(String r21, int r22, String r23, BenefitManagerAPI.CacheType r24, Continuation<? super BenefitStore> r25) {
        if ((r25 instanceof BenefitManagerImpl$asyncGetResourceBenefits$1) == false) goto L7;
        BenefitManagerImpl$asyncGetResourceBenefits$1 r1 = (BenefitManagerImpl$asyncGetResourceBenefits$1) r25;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        BenefitManagerImpl$asyncGetResourceBenefits$1 r6 = r1;
        Object r0 = r6.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r4 = (String) r6.L$0;
        ResultKt.throwOnFailure(r0);
    L32:
        BenefitStore r5 = (BenefitStore) r0;
        if (r5 == null) goto L35;
    L39:
        return r5;
    L35:
        if (r4 != null) goto L37;
        String r13 = "";
    L38:
        r5 = new BenefitStore(r13, new LinkedHashMap(), "{}", null, false, 24, null);
        goto L39
    L37:
        r13 = r4;
        goto L38
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (this.c == false) goto L17;
        tt5.a.h("Benefit_ManagerImpl", "asyncGetResourceBenefits... cacheType is " + r24);
        BenefitCacheManager r7 = this.g;
        if (r24 != BenefitManagerAPI.CacheType.TOKEN) goto L21;
        String r8 = r21;
    L24:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "cacheKey");
        BenefitStore r12 = r7.c.get(r8);
        if (r12 == null) goto L28;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new BenefitManagerImpl$asyncGetResourceBenefits$2(this, r21, r22, r23, r24, null), 3, null);
        tt5.a.h("Benefit_ManagerImpl", "asyncGetResourceBenefits... from = " + r12.getFrom());
        return r12;
    L28:
        r6.L$0 = r23;
        r6.label = 1;
        r0 = a(this, r21, r22, r23, r24, false, r6, 16);
        if (r0 != r10) goto L31;
        return r10;
    L31:
        r4 = r23;
        goto L32
    L21:
        if (r23 != null) goto L23;
        r8 = "";
        goto L24
    L23:
        r8 = r23;
        goto L24
    L17:
        return new BenefitStore("", MapsKt.emptyMap(), "", null, false, 24, null);
    L7:
        r1 = new BenefitManagerImpl$asyncGetResourceBenefits$1(this, r25);
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
    public static Object a(final BenefitManagerImpl r2, final String r3, int r4, String r5, final BenefitManagerAPI.CacheType r6, boolean r7, Continuation r8, int r9) {
        Object r1 = null;
        Function1<BenefitStore, Unit> r10 = null;
        if ((r9 & 8) == 0) goto L6;
        r6 = null;
    L6:
        if ((r9 & 16) == 0) goto L8;
        r7 = false;
    L8:
        r2.getClass();
        if (((a4) org.koin.java.a.c(a4.class, null, null, 6)).c(r3) == true) goto L32;
        if (r6 == null) goto L13;
        r10 = new BenefitManagerImpl$fetchResBenefit$handleResult$1$1(r6, r2, r3);
    L13:
        com.bytedance.ee.bear.middleground.unbundle.b r11 = r2.f;
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        r11.getClass();
        tt5.a.h("Benefit_FetchResBenefitExecutor", "fetchResBenefit...  ownerId is " + r5 + ", token is " + du5.b.i(r3));
        if (r11.b == true) goto L19;
        tt5.a.h("Benefit_FetchResBenefitExecutor", "mIsConnected is false");
    L19:
        j r12 = new j(IntrinsicsKt.intercepted(r8), 1);
        r12.C();
        monitor-enter(r11);
        String r13 = com.bytedance.ee.bear.middleground.unbundle.b.b(r3, r7);     // Catch: Throwable -> L33
        if (r11.e.containsKey(r13) == true) goto L24;
        r11.e.put(r13, new ArrayList());     // Catch: Throwable -> L33
        r11.c(r3, r4, r10, r7);     // Catch: Throwable -> L33
    L25:
        List r14 = (List) ((LinkedHashMap) r11.e).get(r13);     // Catch: Throwable -> L33
        if (r14 == null) goto L28;
        r14.add(r12);     // Catch: Throwable -> L33
    L28:
        monitor-exit(r11);
        r1 = r12.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        DebugProbesKt.probeCoroutineSuspended(r8);
        goto L32
    L24:
        tt5.a.h("Benefit_FetchResBenefitExecutor", "fetchResBenefit...  token is " + du5.b.i(r3) + "  is requesting, includeOwnerTenantInfo = " + r7);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L32:
        return r1;
    }
}
