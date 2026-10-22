package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GULFeedbackDislikeReq;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GuessULikeResponseDTO;
import com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionProductDetailResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.SearchSuggestWordResponse;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4Repository;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.helper.PdpSliceLocalCacheHelper;
import com.bytedance.android.shopping.anchorv4.helper.u;
import com.bytedance.android.shopping.prepurchase.arch.container.aware.DataFetchLifecycleDispatcher;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.state.ObservableData;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService$onAttach$1;
import com.bytedance.android.shopping.utils.e0;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import vg3.j0;
import vg3.m0;
import vg3.w;
import vg3.x;
import vg3.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpDataFetchService extends sg3.a<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> implements com.bytedance.android.shopping.anchorv4.data.i, x {
    public static final /* synthetic */ int E = 0;
    public boolean A;
    public boolean B;
    public final com.bytedance.android.shopping.prepurchase.arch.container.aware.a C;
    public final u D;
    public int i;
    public final Lazy j;
    public CompositeDisposable k;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n>> l;
    public final ObservableData m;
    public final Lazy n;
    public final Lazy o;
    public final PdpDataStore p;
    public final List<j0> q;
    public final List<m0> r;
    public final Map<String, Object> s;
    public final Map<String, Object> t;
    public Disposable u;
    public Function1<? super PDPRefreshStatus, Unit> v;
    public final AtomicLong w;
    public final Lazy x;
    public final i y;
    public boolean z;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ com.bytedance.android.shopping.prepurchase.business.pdp.repository.b a;

        public a(com.bytedance.android.shopping.prepurchase.business.pdp.repository.b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            com.bytedance.android.shopping.prepurchase.arch.container.intf.l r4 = (com.bytedance.android.shopping.prepurchase.arch.container.intf.l) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            if ((r4.a instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.c) == false) goto L5;
            this.a.t();
        L5:
            com.bytedance.android.shopping.prepurchase.arch.container.intf.k r0 = r4.a;
            if ((r0 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d) == false) goto L8;
            this.a.v((com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d) r0);
        L8:
            com.bytedance.android.shopping.prepurchase.arch.container.intf.k r5 = r4.a;
            if ((r5 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.a) == false) goto L12;
            this.a.u((com.bytedance.android.shopping.prepurchase.arch.container.intf.k.a) r5);
            return;
        }
    }

    public static final class b implements o {
        public final /* synthetic */ PdpDataFetchService a;

        public b(PdpDataFetchService r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.o
        public final void a(final PackParsedDTO r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            final PdpDataFetchService r0 = this.a;
            if ((r0.d2().a instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.c.a) == true) goto L5;
            com.bytedance.android.shopping.store.tabkit.container.i.a("preload success but current state is " + r0.d2().a + ", skip update data.");
            return;
        L5:
            r0.g2(new PdpDataFetchService$updateWithPreloadData$1(r0, r3));
        }
    }

    public static final class c implements m0 {
        public final /* synthetic */ PdpDataFetchService a;

        public c(PdpDataFetchService r1) {
            this.a = r1;
        }

        @Override // vg3.m0
        public final void a(PdpPackRequestParam r4) {
            Intrinsics.checkNotNullParameter(r4, "param");
            if (this.a.t.isEmpty() == false) goto L5;
            this.a.s.remove("__pdp_native");
        L6:
            this.a.s.put("is_refresh", Boolean.TRUE);
            if (this.a.s.isEmpty() == true) goto L12;
            String r0 = new JSONObject(this.a.s).toString();     // Catch: Exception -> L15
        L13:
            r4.updateRefreshRepParams(r0);
            return;
        L12:
            r0 = null;
            goto L13
        L5:
            PdpDataFetchService r1 = this.a;
            r1.s.put("__pdp_native", MapsKt.toMap(r1.t));
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataFetchService$onGetExtraChunkPack$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/shopping/prepurchase/arch/container/ability/l;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataFetchService$onGetExtraChunkPack$1", f = "PdpDataFetchService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03191 extends SuspendLambda implements Function3<CoroutineScope, com.bytedance.android.shopping.prepurchase.arch.container.ability.l, Continuation<? super Unit>, Object> {
        final /* synthetic */ PackResponseDTO $packDTO;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PdpDataFetchService this$0;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataFetchService$onGetExtraChunkPack$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
            public final /* synthetic */ C03191 c;
            public final /* synthetic */ Ref.ObjectRef d;

            @Override // java.lang.Runnable
            public final void run() {
                PdpDataFetchService r0 = this.c.this$0;
                Function1<p, Unit> r1 = new PdpDataFetchService$onGetExtraChunkPack$1$2$run$1(this);
                int r2 = PdpDataFetchService.E;
                r0.g2(r1);
            }

            public AnonymousClass2(C03191 r1, Ref.ObjectRef r2) {
                this.c = r1;
                this.d = r2;
                super("onGetExtraChunkPack");
            }
        }

        public C03191(PdpDataFetchService r1, PackResponseDTO r2, Continuation r3) {
            this.this$0 = r1;
            this.$packDTO = r2;
            super(3, r3);
        }

        public final Continuation<Unit> create(CoroutineScope r3, com.bytedance.android.shopping.prepurchase.arch.container.ability.l r4, Continuation<? super Unit> r5) {
            Intrinsics.checkNotNullParameter(r3, "$this$create");
            Intrinsics.checkNotNullParameter(r4, "it");
            Intrinsics.checkNotNullParameter(r5, "continuation");
            C03191 r6 = new C03191(this.this$0, this.$packDTO, r5);
            r6.L$0 = r4;
            return r6;
        }

        public final Object invoke(Object r1, Object r2, Object r3) {
            return create((CoroutineScope) r1, (com.bytedance.android.shopping.prepurchase.arch.container.ability.l) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r4);
            com.bytedance.android.shopping.prepurchase.arch.container.ability.l r5 = (com.bytedance.android.shopping.prepurchase.arch.container.ability.l) this.L$0;
            com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this.this$0, "whenAbilityAvailable callback " + this.$packDTO);
            Ref.ObjectRef r0 = new Ref.ObjectRef();
            r0.element = null;
            if (this.$packDTO.isOptRespProcess() == false) goto L7;
            r0.element = (com.bytedance.android.shopping.prepurchase.business.pdp.repository.c) this.this$0.g2(new C01651(this));
        L7:
            r5.e1(new AnonymousClass2(this, r0));
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataFetchService$onGetPack$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/repository/p;", "it", "", "invoke", "(Lcom/bytedance/android/shopping/prepurchase/business/pdp/repository/p;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class C03221 extends Lambda implements Function1<p, Object> {
        final /* synthetic */ boolean $justPack;
        final /* synthetic */ PackResponseDTO $packDTO;
        final /* synthetic */ PdpDataFetchService this$0;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataFetchService$onGetPack$1$a */
        public static final class a implements Runnable {
            public final /* synthetic */ Function0 a;

            public a(Function0 r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.invoke();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public C03221(PdpDataFetchService r1, PackResponseDTO r2, boolean r3) {
            this.this$0 = r1;
            this.$packDTO = r2;
            this.$justPack = r3;
            super(1);
        }

        public final Object invoke(p r6) {
            Intrinsics.checkNotNullParameter(r6, "it");
            if (this.$packDTO.getStatusCode() == 0) goto L5;
            PdpDataFetchService r7 = this.this$0;
            int r0 = this.$packDTO.getStatusCode();
            String r1 = this.$packDTO.getStatusMsg();
            int r2 = PdpDataFetchService.E;
            r7.getClass();
            ECHybridExtensionsKt.f(new PdpDataFetchService$onError$1(r7, r0, r1));
            return Unit.INSTANCE;
        L5:
            p.b r8 = r6.a(this.$packDTO);
            final Ref.ObjectRef r3 = new Ref.ObjectRef();
            com.bytedance.android.shopping.prepurchase.arch.container.intf.k.b r4 = com.bytedance.android.shopping.prepurchase.arch.container.intf.k.b.a;
            r3.element = r4;
            if (this.$packDTO.isFirstChunk() == true) goto L10;
            if (this.$packDTO.getFromCache() == true) goto L10;
        L12:
            boolean r5 = false;
        L13:
            final n r9 = r8.d(this.this$0.i);
            if (Intrinsics.areEqual((com.bytedance.android.shopping.prepurchase.arch.container.intf.k) r3.element, r4) == false) goto L16;
            r3.element = PdpDataFetchService.a2(this.this$0, this.$packDTO, r9);
        L16:
            Function0<Unit> r10 = new PdpDataFetchService$onGetPack$1$action$1(this, r9, r3);
            if (r5 == false) goto L20;
            return Boolean.valueOf(ECHybridExtensionsKt.c().postAtFrontOfQueue(new a(r10)));
        L20:
            return r10.invoke();
        L10:
            if (PdpMessageOpt.b() == false) goto L12;
            final n r11 = r8.a.b(r8.b.a);
            r8.b.a = r11;
            r3.element = PdpDataFetchService.a2(this.this$0, this.$packDTO, r11);
            ECHybridExtensionsKt.f(new C01681(this, r11, r3));
            r5 = true;
            goto L13
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((p) r1);
        }
    }

    @Override // vg3.x
    public final PdpSliceLocalCacheHelper M() {
        return (PdpSliceLocalCacheHelper) this.n.getValue();
    }

    public final String c2() {
        return (String) this.j.getValue();
    }

    public final void onGetGULError() {
        this.B = false;
    }

    @Override // vg3.k
    public final void F0() {
        if (this.B == false) goto L5;
        return;
    L5:
        this.B = true;
        Set r1 = ECProcessMonitor.a;
        ECProcessMonitor.c("ec_product_detail", "/aweme/v2/commerce/common/favorite/feed/").d();
        String r3 = null;
        Z1(y.class, new PdpDataFetchService$refreshGul$1(null));
        com.bytedance.android.shopping.anchorv4.data.k r2 = AnchorV4DataManager.a;
        String r4 = c2();
        CommonMeta r5 = b2();
        if (r5 == null) goto L8;
        String r6 = r5.getProductId();
    L9:
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        String r7 = r6;
        CommonMeta r8 = b2();
        if (r8 == null) goto L14;
        String r9 = r8.getMetaParam();
    L15:
        String r10 = com.bytedance.android.shopping.extensions.k.j(r9);
        CommonMeta r11 = b2();
        if (r11 == null) goto L18;
        Boolean r12 = Boolean.valueOf(r11.getProductIsInvalid());
    L19:
        boolean r13 = com.bytedance.android.shopping.extensions.k.i(r12);
        int r14 = com.bytedance.android.shopping.utils.y.a;
        int r15 = com.bytedance.android.shopping.utils.y.e(null, Boolean.valueOf(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.a), 1);
        int r16 = com.bytedance.android.shopping.utils.y.c();
        CommonMeta r0 = b2();
        if (r0 == null) goto L22;
        String r17 = r0.getAuthorId();
    L23:
        CommonMeta r18 = b2();
        if (r18 == null) goto L26;
        String r19 = r18.getShopId();
    L27:
        CommonMeta r20 = b2();
        if (r20 == null) goto L36;
        String r21 = r20.getEntranceInfo();
        if (r21 == null) goto L36;
        JSONObject r22 = com.bytedance.android.shopping.extensions.k.w(r21);
        if (r22 == null) goto L36;
        Object r23 = r22.opt("ecom_scene_id");
        if (r23 == null) goto L36;
        r3 = r23.toString();
    L36:
        AnchorV4DataManager.c(r4, r7, r10, r13, r15, r16, r17, r19, r3);
        return;
    L26:
        r19 = null;
        goto L27
    L22:
        r17 = null;
        goto L23
    L18:
        r12 = null;
        goto L19
    L14:
        r9 = null;
        goto L15
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(w.class);
    }

    @Override // vg3.x
    public final void Q() {
        g2(new PdpDataFetchService$stopCollapseDetail$1(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        Lazy r0 = UIUtils.a;
        UIUtils.c().removeCallbacks(this.y);
        com.bytedance.android.shopping.anchorv4.data.k r1 = AnchorV4DataManager.a;
        String r2 = c2();
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(this, "watch");
        AnchorV4Repository r3 = AnchorV4DataManager.m(r2);
        Intrinsics.checkNotNullParameter(this, "watch");
        r3.g().remove(this);
        String r4 = c2();
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Intrinsics.checkNotNullParameter(this, "watch");
        AnchorV4Repository r5 = AnchorV4DataManager.m(r4);
        Intrinsics.checkNotNullParameter(this, "watch");
        ((List) r5.f.getValue()).remove(this);
        u r6 = this.D;
        if (r6 == null) goto L5;
        com.bytedance.android.shopping.anchorv4.perf.preload.b r7 = r6.c;
    L6:
        if (r7 == null) goto L8;
        r7.onDestroy();
    L8:
        CompositeDisposable r8 = this.k;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("disposables");
    L12:
        if (r8.isDisposed() == true) goto L17;
        CompositeDisposable r9 = this.k;
        if (r9 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("disposables");
    L16:
        r9.dispose();
    L17:
        AnchorV4DataManager.r(c2(), null);
        AnchorV4DataManager.q(c2(), true);
        super.U1();
        return;
    L5:
        r7 = null;
        goto L6
    }

    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n> d2() {
        com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n> r0 = this.l.a();
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final void e2() {
        com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n> r0 = this.l.a();
        if (r0 == null) goto L12;
        n r1 = r0.b;
        if (r1 == null) goto L13;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r2 = r1.d;
        if (r2 != null) goto L9;
        return;
    L9:
        if ((!r2.isEmpty()) != true) goto L15;
        x.a.a(this, false, "back_to_pdp", null, 28);
        return;
    L15:
        return;
    L13:
        return;
    }

    public final void onGetPackClientError() {
        ECHybridExtensionsKt.f(new PdpDataFetchService$onError$1(this, -1, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        com.bytedance.android.shopping.anchorv4.data.k r0 = AnchorV4DataManager.a;
        AnchorV4DataManager.d = c2();
        if (this.A == false) goto L5;
    L9:
        this.A = false;
        return;
    L5:
        if (com.bytedance.android.ec.core.abtest.d.y() == true) goto L7;
    L8:
        e2();
        this.z = false;
        goto L9
    L7:
        if (this.z == false) goto L9;
        goto L8
    }

    @Override // sg3.a, com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        this.k = new CompositeDisposable();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(this.m, this, new l(this));
        this.m.e(this, new m(this));
        AbsComponent.Y1(this, x.class, this, false, 12);
        com.bytedance.android.shopping.anchorv4.perf.preload.b r2 = null;
        f2(com.bytedance.android.shopping.prepurchase.arch.container.intf.l.a(d2(), com.bytedance.android.shopping.prepurchase.arch.container.intf.k.c.a.a, null, 2));
        com.bytedance.android.shopping.anchorv4.data.k r0 = AnchorV4DataManager.a;
        AnchorV4DataManager.r(c2(), new PdpDataFetchService$onAttach$1(this));
        com.bytedance.android.shopping.prepurchase.business.pdp.repository.b r1 = new com.bytedance.android.shopping.prepurchase.business.pdp.repository.b(this.C);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(this.l, this, new a(r1));
        u r3 = this.D;
        if (r3 == null) goto L5;
        r2 = r3.c;
    L5:
        if (r2 == null) goto L7;
        r2.c(new b(this));
    L7:
        w1(new c(this));
        e0.a();
        Lazy r4 = UIUtils.a;
        UIUtils.c().postAtFrontOfQueue(this.y);
    }

    public final CommonMeta b2() {
        PageMeta r0 = d2().b.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCommonMeta();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.j
    public final void retry() {
        f2(com.bytedance.android.shopping.prepurchase.arch.container.intf.l.a(d2(), com.bytedance.android.shopping.prepurchase.arch.container.intf.k.c.a.a, null, 2));
        com.bytedance.android.shopping.anchorv4.data.k r0 = AnchorV4DataManager.a;
        AnchorV4DataManager.h(c2(), C03251.INSTANCE, new AnonymousClass2(this), false, 8);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.j
    public final PdpDataStore getData() {
        return this.p;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.j
    public final ObservableData q0() {
        return this.m;
    }

    @Override // vg3.k
    public final void B(final int r2) {
        g2(new PdpDataFetchService$removeSpecificGUL$1(this, r2));
    }

    @Override // vg3.x
    public final void D1(PackResponseDTO r2) {
        Intrinsics.checkNotNullParameter(r2, "dto");
        onGetPack(r2, true);
    }

    @Override // vg3.x
    public final void c0(boolean r2) {
        if (com.bytedance.android.ec.core.abtest.d.y() == true) goto L5;
    L7:
        if (r2 == true) goto L9;
        return;
    L9:
        if (P1().b().isAtLeast(Lifecycle.State.RESUMED) == false) goto L13;
        e2();
        return;
    L13:
        return;
    L5:
        if (this.z == true) goto L7;
        this.z = true;
        goto L7
    }

    @Override // vg3.x
    public final void c1(Map<String, ? extends Object> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.s.putAll(r2);
    }

    public final void f2(final com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n> r2) {
        ECHybridExtensionsKt.f(new PdpDataFetchService$updateState$1(this, r2));
    }

    public final <T> T g2(Function1<? super p, ? extends T> r2) {
        monitor-enter(this);
        T r3 = (T) r2.invoke((p) this.o.getValue());
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // vg3.x
    public final void h1(final List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r2) {
        g2(new PdpDataFetchService$updateComponents$1(this, r2));
    }

    @Override // vg3.x
    public final void o0(ProductDetailEventService$onAttach$1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "processor");
        ((ArrayList) this.q).add(r2);
    }

    public final void onGetDetail(final PromotionProductDetailResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "detailDTO");
        Intrinsics.checkNotNullParameter(r2, "detailDTO");
        g2(new AnonymousClass1(this, r2));
    }

    public final void onGetExtraChunkPack(PackResponseDTO r4) {
        Intrinsics.checkNotNullParameter(r4, "packDTO");
        Intrinsics.checkNotNullParameter(r4, "packDTO");
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "onGetExtraChunkPack " + r4);
        Z1(com.bytedance.android.shopping.prepurchase.arch.container.ability.l.class, new C03191(this, r4, null));
    }

    public final void onGetFindSameGoods(final com.bytedance.android.shopping.anchorv4.dto.business.d r2) {
        Intrinsics.checkNotNullParameter(r2, "sameGoodsDTOI");
        Intrinsics.checkNotNullParameter(r2, "sameGoodsDTOI");
        g2(new C03201(this, r2));
    }

    public final void onGetGUL(final GuessULikeResponseDTO r2) {
        Intrinsics.checkNotNullParameter(r2, "gulDTO");
        Intrinsics.checkNotNullParameter(r2, "gulDTO");
        this.B = false;
        g2(new C03211(this, r2));
    }

    public final void onGetSearchWords(final SearchSuggestWordResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "searchDTO");
        Intrinsics.checkNotNullParameter(r2, "searchDTO");
        g2(new C03231(this, r2));
    }

    public final void onGetShopRecommends(final PromotionRecommendResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "shopRecDTO");
        Intrinsics.checkNotNullParameter(r2, "shopRecDTO");
        g2(new C03241(this, r2));
    }

    @Override // vg3.k
    public final void p(GULFeedbackDislikeReq r3) {
        Intrinsics.checkNotNullParameter(r3, "req");
        String r0 = c2();
        com.bytedance.android.shopping.anchorv4.data.k r1 = AnchorV4DataManager.a;
        AnchorV4DataManager.o(r3, r0);
    }

    @Override // vg3.x
    public final void w1(m0 r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.r).add(r2);
    }

    public PdpDataFetchService(DataFetchLifecycleDispatcher r4, u r5) {
        Intrinsics.checkNotNullParameter(r4, "contentQueryListener");
        this.C = r4;
        this.D = r5;
        this.j = LazyKt.lazy(new PdpDataFetchService$sessionId$2(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<com.bytedance.android.shopping.prepurchase.arch.container.intf.l<n>> r6 = new com.bytedance.android.shopping.prepurchase.arch.container.state.d(new com.bytedance.android.shopping.prepurchase.arch.container.intf.l(com.bytedance.android.shopping.prepurchase.arch.container.intf.k.b.a, new n(0)));
        this.l = r6;
        this.m = r6.d(PdpDataFetchService$networkState$1.INSTANCE);
        this.n = LazyKt.lazy(PdpDataFetchService$sliceLocalCacheHelper$2.INSTANCE);
        this.o = LazyKt.lazy(new PdpDataFetchService$netDataParser$2(this));
        this.p = new PdpDataStore(r6);
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new LinkedHashMap();
        this.t = new LinkedHashMap();
        this.w = new AtomicLong(0);
        this.x = LazyKt.lazy(PdpDataFetchService$curChunkMonitorName$2.INSTANCE);
        this.y = new i(this);
        this.A = true;
    }

    @Override // vg3.x
    public final void T(Map<String, ? extends Object> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r3 == false) goto L8;
        Iterator<T> r4 = r2.keySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        String r5 = (String) r4.next();
        this.t.remove(r5);
        goto L6
    L11:
        return;
    L8:
        this.t.putAll(r2);
    }

    public final void onGetPack(PackResponseDTO r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "packDTO");
        Intrinsics.checkNotNullParameter(r3, "packDTO");
        cl.d r0 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r0 == null) goto L5;
        r0.q();
    L5:
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this, "onGetPack " + r3 + ' ' + r3.getFromCache());
        g2(new C03221(this, r3, r4));
    }

    public static final com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d a2(PdpDataFetchService r1, PackResponseDTO r2, n r3) {
        r1.getClass();
        String r4 = r3.c;
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        if (r2.getFromCache() == false) goto L9;
        return new com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.a(r4);
    L9:
        if (r2.hasMultipleChunks() == false) goto L20;
        Integer r0 = r2.getChunkIndex();
        if (r0 == null) goto L13;
        int r5 = r0.intValue();
    L14:
        Integer r6 = r2.getChunkCount();
        if (r6 == null) goto L17;
        int r7 = r6.intValue();
    L22:
        return new com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.b(r4, r5, r7);
    L17:
        r7 = 1;
        goto L22
    L13:
        r5 = 0;
        goto L14
    L20:
        return new com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.c(r4);
    }

    @Override // vg3.x
    public final void w0(String r10, Map r11, boolean r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r10, "refreshType");
        w r0 = (w) N1(w.class);
        boolean r1 = false;
        if (r0 == null) goto L12;
        ProductDetailEventService.b r2 = r0.m();
        if (r2 == null) goto L12;
        Map<String, ? extends Object> r14 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("refresh_type", r10)});
        if (r11 == null) goto L9;
        r14.putAll(r11);
    L9:
        Unit r15 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r3 = r2.d(r14);
        if (r3 == null) goto L12;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r3, "pdp_refresh_pack", true, null, null, 12);
    L12:
        long r16 = this.w.incrementAndGet();
        Disposable r4 = this.u;
        if (r4 != null) goto L15;
    L22:
        this.u = null;
        this.v = null;
        if (r12 == false) goto L25;
        this.v = r13;
    L25:
        this.i++;
        com.bytedance.android.shopping.anchorv4.vm.a r5 = d2().b.y;
        if (r5 != null) goto L28;
    L30:
        boolean r6 = !Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d.a(), Boolean.FALSE);
        final JSONObject r7 = new JSONObject();
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L33
        r7.put("collapse", r1);     // Catch: Throwable -> L33
        Result.constructor-impl(r7.put("expand", r6));     // Catch: Throwable -> L33
    L35:
        Function1<PdpPackRequestParam, Unit> r9 = new PdpDataFetchService$doRefresh$refreshParamBuilder$1(this, r7);
        com.bytedance.android.shopping.anchorv4.data.k r17 = AnchorV4DataManager.a;
        String r18 = c2();
        Intrinsics.checkNotNullParameter(r18, "sessionId");
        Intrinsics.checkNotNullParameter(r9, "paramBuilder");
        PdpPackRequestParam r19 = (PdpPackRequestParam) AnchorV4DataManager.c.get(r18);
        if (r19 == null) goto L41;
        r9.invoke(r19);
        boolean r20 = ECServiceManager.a;
        r19.updateIsAuth(((IECHostService) ECServiceManager.c(IECHostService.class)).getIECHostUserService().isLogin());
        if (((Boolean) PdpAB.a.getValue()).booleanValue() == false) goto L40;
        r19.updateFullResp(true);
        Observable r21 = Observable.create(new com.bytedance.android.shopping.anchorv4.data.d(r18, r19));
    L42:
        Disposable r110 = r21.subscribe(new j(this, r16, r13), new k(this, r16, r13));
        CompositeDisposable r111 = this.k;
        if (r111 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("disposables");
    L45:
        r111.add(r110);
        if (r12 == false) goto L51;
        this.u = r110;
        return;
    L51:
        return;
    L40:
        r21 = AnchorV4DataManager.m(r18).e(r19);
        goto L42
    L41:
        r21 = Observable.empty();
    L33:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L28:
        if (r5.a != true) goto L30;
        r1 = true;
        goto L30
    L15:
        if (r4.isDisposed() == true) goto L22;
        Disposable r23 = this.u;
        if (r23 == null) goto L19;
        r23.dispose();
    L19:
        Function1<? super PDPRefreshStatus, Unit> r24 = this.v;
        if (r24 == null) goto L22;
        Unit r25 = (Unit) r24.invoke(PDPRefreshStatus.CANCELED);
        goto L22
    }
}
