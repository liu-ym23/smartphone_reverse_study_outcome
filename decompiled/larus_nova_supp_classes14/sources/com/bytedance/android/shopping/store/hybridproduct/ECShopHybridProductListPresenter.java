package com.bytedance.android.shopping.store.hybridproduct;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.RecyclerViewPerformanceMonitor;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.ECItemOperationType;
import com.bytedance.android.ec.hybrid.list.entity.ECSectionOperationType;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.InteractiveControl;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.list.view.ECVirtualLayoutManager;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.status.DefaultStoreTadLoadingStatusView;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.ec.store.utils.playable.controller.RestrictMarginAreaProcessor;
import com.bytedance.android.ec.store.utils.playable.controller.playcontrol.PlayControlStrategy;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.store.home.ECShopPlayAbilityPlugin;
import com.bytedance.android.shopping.store.home.ECStoreModuleBinderFragment;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.entity.ShopMarketingScene;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopProductListBffResponseDTO;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridDataTransformer;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridHolderCreatorSource;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt$addCrossShopAbout$1;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt$addGotoTopAbout$2;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt$addGotoTopAbout$3;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt$addGotoTopAbout$4;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt$addPlayEventListener$2;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt$addScrollPerfMonitor$1;
import com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridTabExtKt$handlerStickView$$inlined$let$lambda$1;
import com.bytedance.android.shopping.store.hybridproduct.holder.creator.ECShopHybridHolderFactory;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/ECShopHybridProductListPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Landroidx/lifecycle/LifecycleEventObserver;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopHybridProductListPresenter extends QFragmentPresenter implements LifecycleEventObserver {
    public static final int O = 0;
    public final a0 A;
    public ECShopPlayAbilityPlugin B;
    public Integer C;
    public com.bytedance.android.ec.hybrid.list.entity.k D;
    public com.bytedance.android.shopping.store.restore.f E;
    public t F;
    public boolean G;
    public com.bytedance.android.shopping.store.restore.f H;
    public Runnable I;
    public CompositeDisposable J;
    public boolean K;
    public final com.bytedance.android.shopping.store.hybridproduct.c L;
    public final com.bytedance.android.shopping.store.hybridproduct.c M;
    public final ECStoreViewModel N;
    public final String f;
    public final ECStoreParam g;
    public final Map<String, ? super Object> h;
    public final boolean i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public ECHybridListContainer m;
    public ECHybridListEngine n;
    public ViewGroup o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public Float t;
    public Integer u;
    public final TreeMap<Integer, vn.m> v;
    public final List<Runnable> w;
    public ShopItemAnimator x;
    public final Set<String> y;
    public final q z;

    public static final class a {
        public static GradientDrawable a(int r13) {
            int r0 = ColorProtector.parseColor("#FFFFFF");
            int r1 = ColorProtector.parseColor("#F5F6F9");
            GradientDrawable r2 = new GradientDrawable();
            qc3.a.g(r2, GradientDrawable.Orientation.TOP_BOTTOM);
            r2.setGradientType(0);
            r2.setCornerRadii(new float[]{ExtensionsKt.b(Integer.valueOf(r13)), ExtensionsKt.b(Integer.valueOf(r13)), ExtensionsKt.b(Integer.valueOf(r13)), ExtensionsKt.b(Integer.valueOf(r13)), 0.0f, 0.0f, 0.0f, 0.0f});
            qc3.a.f(r2, new int[]{r0, r0, r1, r1, r1, r1, r1, r1});
            return r2;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECShopHybridProductListPresenter a;
        public final /* synthetic */ ECHybridRecyclerView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public b(ECShopHybridProductListPresenter r1, ECHybridRecyclerView r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECShopHybridProductListPresenter.h0(this.a, this.b, 0, this.c, this.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECShopHybridProductListPresenter a;

        public c(ECShopHybridProductListPresenter r1) {
            this.a = r1;
        }

        public final void a() {
            ShopHybridTabExtKt.b(this.a);
            ECShopHybridProductListPresenter r0 = this.a;
            Intrinsics.checkNotNullParameter(r0, "$this$addPlayEventListener");
            ((View) r0.k.getValue()).getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.shopping.store.hybridproduct.extension.g(r0));
            boolean r3 = false;
            r0.N.getCollapseFactor().a(r0.l0(), new ShopHybridTabExtKt$addPlayEventListener$2(), false);
            ECShopHybridProductListPresenter r1 = this.a;
            r1.m0().getRefresh().setValue(Boolean.FALSE);
            r1.m0().getRefresh().a(ECQuickUtilKt.a(r1.Y()), new p(r1), false);
            final ECShopHybridProductListPresenter r2 = this.a;
            Intrinsics.checkNotNullParameter(r2, "$this$addGotoTopAbout");
            r2.N.getGoTopEventReceiver().a(r2.l0(), new com.bytedance.android.shopping.store.hybridproduct.extension.e(r2), false);
            if (r2.p <= 0) goto L5;
            ShopHybridTabExtKt.g(r2, com.bytedance.android.shopping.store.hybridproduct.extension.a.a(r2.n));
        L6:
            ECHybridListEngine r4 = r2.n;
            if (r4 == null) goto L11;
            ECHybridRecyclerView r5 = r4.b;
            if (r5 == null) goto L11;
            r5.addOnScrollListener(new ShopHybridTabExtKt$addGotoTopAbout$2(r2));
        L11:
            ECHybridListEngine r6 = r2.n;
            if (r6 == null) goto L16;
            ECHybridRecyclerView r7 = r6.b;
            if (r7 == null) goto L16;
            r7.addOnScrollListener(new ShopHybridTabExtKt$addGotoTopAbout$3(r2));
        L16:
            ECHybridListEngine r8 = r2.n;
            if (r8 == null) goto L21;
            ECHybridRecyclerView r9 = r8.b;
            if (r9 == null) goto L21;
            r9.addOnScrollListener(new ShopHybridTabExtKt$addGotoTopAbout$4(r2));
        L21:
            final ECShopHybridProductListPresenter r10 = this.a;
            Intrinsics.checkNotNullParameter(r10, "$this$addCrossShopAbout");
            ECHybridListEngine r11 = r10.n;
            if (r11 == null) goto L26;
            ECHybridRecyclerView r12 = r11.b;
            if (r12 == null) goto L26;
            r12.addOnScrollListener(new ShopHybridTabExtKt$addCrossShopAbout$1(r10));
        L26:
            ECShopHybridProductListPresenter r13 = this.a;
            Intrinsics.checkNotNullParameter(r13, "$this$addProductInfoExchange");
            Integer r14 = r13.m0().getRequestParam().getRequestTabType();
            if (r14 != null) goto L30;
        L33:
            ECShopHybridProductListPresenter r15 = this.a;
            Intrinsics.checkNotNullParameter(r15, "$this$addLayoutUpdateListener");
            r15.m0().getLayoutType().a(r15.l0(), new com.bytedance.android.shopping.store.hybridproduct.extension.f(r15), false);
            ECShopHybridProductListPresenter r16 = this.a;
            Intrinsics.checkNotNullParameter(r16, "$this$addRemoveVipCard");
            r16.m0().getRemoveVipCard().a(r16.l0(), new com.bytedance.android.shopping.store.hybridproduct.extension.l(r16), false);
            final ECShopHybridProductListPresenter r17 = this.a;
            r17.getClass();
            Intrinsics.checkNotNullParameter(r17, "$this$addScrollPerfMonitor");
            ECHybridListEngine r18 = r17.n;
            if (r18 == null) goto L38;
            ECHybridRecyclerView r19 = r18.b;
            if (r19 == null) goto L38;
            r19.addOnScrollListener(new ShopHybridTabExtKt$addScrollPerfMonitor$1(r17));
        L38:
            Intrinsics.checkNotNullParameter(r17, "$this$addFpsMonitor");
            ECHybridListEngine r20 = r17.n;
            Integer r21 = null;
            if (r20 == null) goto L44;
            ECHybridRecyclerView r22 = r20.b;
            if (r22 == null) goto L44;
            r22.addOnScrollListener(new RecyclerViewPerformanceMonitor(new com.bytedance.android.ec.core.monitor.q(MonitorScenes.EC_STORE_FPS, "products_hybrid", null)));
        L44:
            if (ECStoreSettings.c() != 0) goto L50;
            ECHybridListEngine r23 = r17.n;
            if (r23 == null) goto L50;
            ECHybridRecyclerView r24 = r23.b;
            if (r24 == null) goto L50;
            jh.b.a r25 = jh.b.c;
            com.bytedance.android.ec.core.monitor.q r26 = new com.bytedance.android.ec.core.monitor.q(MonitorScenes.EC_SHOP_FPS, "products_hybrid", null);
            r25.getClass();
            jh.b.a.c(r26).c(r24);
        L50:
            Intrinsics.checkNotNullParameter(r17, "$this$handlerStickView");
            ECHybridListEngine r27 = r17.n;
            if (r27 == null) goto L55;
            final ECHybridRecyclerView r28 = r27.b;
            if (r28 == null) goto L55;
            r28.addOnScrollListener(new ShopHybridTabExtKt$handlerStickView$$inlined$let$lambda$1(r28, r17));
        L55:
            ECHybridListEngine r29 = r17.n;
            if (r29 == null) goto L62;
            ECHybridRecyclerView r30 = r29.b;
            if (r30 == null) goto L62;
            ViewTreeObserver r31 = r30.getViewTreeObserver();
            if (r31 == null) goto L62;
            r31.addOnGlobalLayoutListener(new com.bytedance.android.shopping.store.hybridproduct.extension.n(r17));
        L62:
            ECShopHybridProductListPresenter r32 = this.a;
            Intrinsics.checkNotNullParameter(r32, "$this$addPlayStrategyListener");
            r32.m0().getCurrentPlayStrategy().a(r32.l0(), new com.bytedance.android.shopping.store.hybridproduct.extension.h(r32), false);
            ECShopHybridProductListPresenter r33 = this.a;
            Integer r34 = r33.C;
            if (r34 == null) goto L100;
            int r35 = r34.intValue();
            r33.o0("product_register_providers tabType=" + r35);
            if (r33.F != null) goto L101;
            t r36 = new t(r33, r35);
            r33.F = r36;
            com.bytedance.android.shopping.store.restore.q r37 = r33.N.getPageRestoreCoordinator();
            if (r37 == null) goto L102;
            Intrinsics.checkNotNullParameter(r36, "provider");
            if (com.bytedance.android.shopping.store.restore.r.c() == false) goto L104;
            r37.e.put(Integer.valueOf(r35), r36);
            com.bytedance.android.shopping.store.restore.m r38 = r37.b;
            if (r38 == null) goto L78;
            com.bytedance.android.shopping.store.restore.s r39 = r38.d;
            if (r39 == null) goto L78;
            Map<Integer, com.bytedance.android.shopping.store.restore.l> r40 = r39.h;
            if (r40 == null) goto L78;
            com.bytedance.android.shopping.store.restore.l r41 = r40.get(Integer.valueOf(r35));
        L79:
            if (r41 == null) goto L81;
            com.bytedance.android.shopping.store.restore.f r42 = r41.c;
        L83:
            if (com.bytedance.android.shopping.store.restore.r.b() == false) goto L89;
            com.bytedance.android.shopping.store.restore.m r43 = r37.b;
            if (r43 == null) goto L89;
            Map<Integer, com.bytedance.android.ec.hybrid.list.entity.k> r44 = r43.e;
            if (r44 == null) goto L89;
            com.bytedance.android.ec.hybrid.list.entity.k r45 = r44.get(Integer.valueOf(r35));
        L90:
            if (r45 != null) goto L92;
            if (r42 != null) goto L92;
            return;
        L92:
            StringBuilder r46 = new StringBuilder("coordinator_restore_listData tabId=");
            r46.append(r35);
            r46.append(" hasList=");
            if (r45 == null) goto L95;
            r3 = true;
        L95:
            r46.append(r3);
            r46.append(" pos=");
            if (r42 == null) goto L98;
            r21 = r42.a;
        L98:
            r46.append(r21);
            com.bytedance.android.shopping.store.restore.q.b(r46.toString());
            r36.b(new com.bytedance.android.shopping.store.restore.j(r45, r42));
            return;
        L89:
            r45 = null;
            goto L90
        L81:
            r42 = null;
        L78:
            r41 = null;
            goto L79
        L104:
            return;
        L102:
            return;
        L101:
            return;
        L100:
            return;
        L30:
            if (r14.intValue() != 3) goto L33;
            r13.m0().getProductViewsNum().a(r13.l0(), new com.bytedance.android.shopping.store.hybridproduct.extension.i(r13), false);
            r13.m0().getTotalProductNum().a(r13.l0(), new com.bytedance.android.shopping.store.hybridproduct.extension.j(r13), false);
            r13.m0().getTruelyTotalProductNum().a(r13.l0(), new com.bytedance.android.shopping.store.hybridproduct.extension.k(r13), false);
            goto L33
        L5:
            ShopHybridTabExtKt.g(r2, -1);
            goto L6
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

    public static final class d implements Runnable {
        public final /* synthetic */ ECShopHybridProductListPresenter a;
        public final /* synthetic */ com.bytedance.android.ec.hybrid.list.entity.i b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Map e;

        public d(ECShopHybridProductListPresenter r1, com.bytedance.android.ec.hybrid.list.entity.i r2, List r3, String r4, Map r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            ECShopHybridProductListPresenter r0 = this.a;
            com.bytedance.android.ec.hybrid.list.entity.i r1 = this.b;
            int r2 = ECShopHybridProductListPresenter.O;
            int r3 = r0.j0(r1);
            if (r3 == (-1)) goto L22;
            ECHybridListItemDTO r4 = (ECHybridListItemDTO) CollectionsKt.firstOrNull(this.c);
            if (r4 == null) goto L16;
            ECHybridListItemDTO.Companion r5 = ECHybridListItemDTO.Companion;
            String r6 = this.d;
            r5.getClass();
            ECHybridListItemVO r7 = ECHybridListItemDTO.Companion.b(r4, r6, false, null);
            ECItemOperationType r8 = ECItemOperationType.INSERT;
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r7.p = r8;
            ShopHybridTabExtKt.d(r7, this.b);
            String r9 = r7.d;
            if (r9 == null) goto L20;
            ShopItemAnimator r10 = this.a.x;
            if (r10 == null) goto L20;
            Intrinsics.checkNotNullParameter(r9, "itemId");
            ((ArrayList) r10.a).add(r9);
        L20:
            ArrayList r11 = this.b.i;     // Catch: Exception -> L15
            if (r11 == null) goto L16;
            ListProtector.add(r11, r3, r7);     // Catch: Exception -> L15
            Unit r12 = Unit.INSTANCE;     // Catch: Exception -> L15
        L15:
            EnsureManager.ensureNotReachHere();
            Unit r13 = Unit.INSTANCE;
        L16:
            this.b.c(ECSectionOperationType.INSERT_SECTION);
            ECHybridListEngine r14 = this.a.n;
            if (r14 == null) goto L23;
            r14.t(this.b, Boolean.FALSE, this.e);
            return;
        L23:
            return;
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

    public final LifecycleOwner l0() {
        return (LifecycleOwner) this.j.getValue();
    }

    public final ECShopHybridProductViewModel m0() {
        return (ECShopHybridProductViewModel) this.l.getValue();
    }

    static {
        O = ExtensionsKt.a(100);
    }

    public final void c0() {
        ECShopPlayAbilityPlugin r0 = this.B;
        if (r0 == null) goto L8;
        com.bytedance.android.shopping.store.home.r r1 = r0.a;
        if (r1 == null) goto L7;
        r1.e.c();
    L7:
        s0.e(r0);
        r0.c.getLifecycle().removeObserver(r0);
    L8:
        o0("product_unregister_providers tabId=" + this.C);
        t r2 = this.F;
        if (r2 == null) goto L18;
        com.bytedance.android.shopping.store.restore.q r3 = this.N.getPageRestoreCoordinator();
        if (r3 == null) goto L18;
        Intrinsics.checkNotNullParameter(r2, "provider");
        com.bytedance.android.shopping.store.restore.k r4 = r3.e.get(Integer.valueOf(r2.a));
        if (r4 == null) goto L18;
        if (Intrinsics.areEqual(r4, r2) == false) goto L18;
        r3.e.remove(Integer.valueOf(r2.a));
    L18:
        this.F = null;
        EventCenter.unregisterJsEventSubscriber("ecom.shop.update_product_notify_status", this.z);
        ECLiveHybridUtil.p("successJoinVip", this.L);
        ECLiveHybridUtil.p("successExitVip", this.M);
        this.N.getSliceService().g();
        ((QFragmentPresenter) this).e.getLifecycle().removeObserver(this);
    }

    public final void i0() {
        com.bytedance.android.shopping.store.restore.f r0 = this.E;
        if (r0 != null) goto L5;
        return;
    L5:
        ECHybridListEngine r1 = this.n;
        if (r1 == null) goto L18;
        ECHybridRecyclerView r2 = r1.b;
        if (r2 == null) goto L20;
        Integer r3 = r0.a;
        if (r3 == null) goto L19;
        int r4 = r3.intValue();
        Integer r5 = r0.b;
        if (r5 == null) goto L15;
        int r6 = r5.intValue();
    L16:
        r2.post(new b(this, r2, r4, r6));
        return;
    L15:
        r6 = 0;
        goto L16
    L19:
        return;
    L20:
        return;
    }

    public static int k0(com.bytedance.android.ec.hybrid.list.entity.k r3) {
        ArrayList r4 = r3.c;
        if (r4 == null) goto L17;
        Iterator r5 = r4.iterator();
        int r1 = 0;
    L6:
        if (r5.hasNext() == false) goto L13;
        ArrayList r2 = ((com.bytedance.android.ec.hybrid.list.entity.i) r5.next()).i;
        if (r2 == null) goto L10;
        int r6 = r2.size();
    L11:
        r1 = r1 + r6;
        goto L6
    L10:
        r6 = 0;
        goto L11
    L13:
        return r1;
    L17:
        return 0;
    }

    public final void b0(QModel r25) {
        this.C = m0().getRequestParam().getRequestTabType();
        StringBuilder r1 = new StringBuilder("product_onBind secShopId=");
        r1.append(this.g.getSecShopId());
        r1.append(" lmId=");
        r1.append(this.g.getLifecycleMonitorId());
        r1.append(" tabId=");
        r1.append(this.C);
        r1.append(" hasVO=");
        com.bytedance.android.ec.hybrid.list.entity.k r5 = m0().getHybridListVO();
        if (r5 == null) goto L5;
        ArrayList r6 = r5.c;
    L7:
        if (r6 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        r1.append(!r7);
        o0(r1.toString());
        this.m = a0().findViewById(2131370940);
        GradientDrawable r2 = new GradientDrawable();
        qc3.a.g(r2, GradientDrawable.Orientation.TOP_BOTTOM);
        r2.setGradientType(0);
        r2.setCornerRadii(new float[]{ExtensionsKt.b(10), ExtensionsKt.b(10), ExtensionsKt.b(10), ExtensionsKt.b(10), 0.0f, 0.0f, 0.0f, 0.0f});
        int r13 = (int) 4294967295L;
        qc3.a.f(r2, new int[]{r13, r13});
        ECHybridListContainer r8 = this.m;
        if (r8 == null) goto L17;
        Intrinsics.checkNotNullParameter(r8, "$this$setBackgroundCompat");
        r8.setBackground(r2);
    L17:
        if (this.i == true) goto L19;
        ViewExtensionsKt.f(a0().findViewById(2131374650), ExtensionsKt.b(12), ExtensionsKt.b(12), 0.0f, 0.0f, false);
    L19:
        ECHybridListContainer r3 = this.m;
        if (r3 == null) goto L24;
        ECHybridRecyclerView r4 = r3.getRecyclerView();
        if (r4 == null) goto L24;
        r4.setNeedFixCanScrollVerticallyAPI(true);
    L24:
        Context r9 = Y().c();
        this.o = (ViewGroup) Z().b(2131370941).f();
        View r10 = new LazyStatusView(r9, null);
        ViewGroup r12 = this.o;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("statusViewContainer");
    L27:
        r12.addView(r10);
        r10.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.a.a, new com.bytedance.android.ec.store.status.c(new ECShopHybridProductListPresenter$initOptStatusView$1(this), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.b.a, new com.bytedance.android.ec.store.status.c(new ECShopHybridProductListPresenter$initOptStatusView$2(this), null, 6))}));
        r10.a(new DefaultStoreTadLoadingStatusView(r9).a());
        m0().getLoadStatus().b(ECQuickUtilKt.a(Y()), new o(this, r10));
        boolean r11 = ShopHybridHolderCreatorSource.a;
        Fragment r14 = ((QFragmentPresenter) this).e;
        km.b r15 = new km.b();
        ECShopHybridProductViewModel r16 = m0();
        ECStoreViewModel r17 = this.N;
        String r18 = this.f;
        Intrinsics.checkNotNullParameter(r14, "fragment");
        Intrinsics.checkNotNullParameter(r15, "config");
        Intrinsics.checkNotNullParameter(r16, "tabViewModel");
        Intrinsics.checkNotNullParameter(r17, "viewModel");
        Intrinsics.checkNotNullParameter(r18, "sceneId");
        Map r19 = ShopHybridHolderCreatorSource.a(ECShopHybridHolderFactory.a);
        ArrayList r110 = new ArrayList();
        Iterator r111 = ((LinkedHashMap) r19).entrySet().iterator();
    L29:
        if (r111.hasNext() == false) goto L37;
        Map.Entry r112 = (Map.Entry) r111.next();
        int r20 = ((Number) r112.getKey()).intValue();
        Function5 r21 = (Function5) r112.getValue();
        boolean r113 = ShopHybridHolderCreatorSource.a;
        com.bytedance.android.shopping.store.hybridproduct.extension.p r22 = ShopHybridDataTransformer.a.get(Integer.valueOf(r20));
        if (r22 != null) goto L33;
        ShopHybridHolderCreatorSource.a r114 = null;
    L34:
        if (r114 == null) goto L29;
        r110.add(r114);
        goto L29
    L33:
        r114 = new ShopHybridHolderCreatorSource.a(r20, r22.a, r22.b, r21);
        goto L34
    L37:
        Iterator r23 = r110.iterator();
    L39:
        if (r23.hasNext() == false) goto L53;
        ShopHybridHolderCreatorSource.a r24 = (ShopHybridHolderCreatorSource.a) r23.next();
        com.bytedance.android.shopping.store.hybridproduct.extension.b r26 = new com.bytedance.android.shopping.store.hybridproduct.extension.b(r24.d, r14, r15, r16, r17);
        Function2<DTO, String, VO> r27 = r24.c;
        if (r27 == 0) goto L52;
        com.bytedance.android.shopping.store.hybridproduct.extension.c r115 = new com.bytedance.android.shopping.store.hybridproduct.extension.c(r24.b, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r27, 2));
        int r28 = r24.getType();
        List r29 = CollectionsKt.listOf(new Boolean[]{Boolean.TRUE, Boolean.FALSE});
        km.b r116 = r15;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator r30 = r29.iterator();
    L44:
        if (r30.hasNext() == false) goto L46;
        ((Boolean) r30.next()).booleanValue();
        r117.add(Integer.valueOf(r28));
        goto L44
    L46:
        LinkedHashMap r31 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r117, 10)), 16));
        Iterator r32 = r117.iterator();
    L48:
        if (r32.hasNext() == false) goto L50;
        Object r118 = r32.next();
        ((Number) r118).intValue();
        r31.put(r118, r26);
        goto L48
    L50:
        ECHybridListEngine.Companion r33 = ECHybridListEngine.x;
        Pair r34 = TuplesKt.to(Integer.valueOf(r28), r115);
        r33.getClass();
        ECHybridListEngine.Companion.d(r18, r14, r34, r31);
        r15 = r116;
        goto L39
    L52:
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Any, kotlin.String?) -> com.bytedance.android.shopping.store.hybridproduct.extension.ShopHybridItemVO");
    L53:
        ECHybridListContainer r35 = this.m;
        if (r35 == null) goto L56;
        ECHybridListEngine.a r36 = new ECHybridListEngine.a(Y().c(), this.f);
        Intrinsics.checkNotNullParameter(r35, "view");
        r36.b = r35;
        r36.b(ECQuickUtilKt.a(Y()));
        r36.d = ((com.bytedance.android.ec.store.setting.h) ECStoreSettings.d.getValue()).a();
        r36.a(new ECShopHybridProductListPresenter$initEngine$$inlined$let$lambda$1(this));
        r36.d(com.bytedance.android.ec.hybrid.list.ability.m0.class, new i(this));
        r36.d(com.bytedance.android.ec.hybrid.list.ability.j0.class, new n());
        r36.d(com.bytedance.android.ec.hybrid.list.ability.k0.class, new j(this));
        r36.d(com.bytedance.android.ec.hybrid.list.ability.l0.class, new k(this));
        r36.d(com.bytedance.android.ec.hybrid.list.ability.u.class, new l(this));
        ECHybridListEngine r37 = r36.c();
    L57:
        this.n = r37;
        if (r37 == null) goto L66;
        ECHybridRecyclerView r38 = r37.b;
        if (r38 == null) goto L66;
        this.B = new ECShopPlayAbilityPlugin(r38, ((QFragmentPresenter) this).e, new RestrictMarginAreaProcessor(RestrictMarginAreaProcessor.Companion.a(), RestrictMarginAreaProcessor.Companion.a(), RestrictMarginAreaProcessor.Companion.a(), RestrictMarginAreaProcessor.Companion.a()));
        ShopItemAnimator r39 = new ShopItemAnimator();
        this.x = r39;
        ECHybridListEngine r40 = this.n;
        if (r40 == null) goto L66;
        ECHybridRecyclerView r41 = r40.b;
        if (r41 == null) goto L66;
        r41.setItemAnimator(r39);
    L66:
        ECShopPlayAbilityPlugin r42 = this.B;
        if (r42 == null) goto L69;
        r42.c.getLifecycle().addObserver(r42);
        com.bytedance.android.shopping.store.home.r r43 = new com.bytedance.android.shopping.store.home.r(new nn.e(), new on.b(r42.b), r42.d, PlayControlStrategy.ORDER_FIRST_IMAGE);
        RecyclerView r44 = r42.b;
        Intrinsics.checkNotNullParameter(r44, "recyclerView");
        r43.a = r44;
        r44.addOnScrollListener(r43.d);
        Unit r45 = Unit.INSTANCE;
        r42.a = r43;
        s0.c(r42);
    L69:
        ECHybridListEngine r46 = this.n;
        if (r46 == null) goto L74;
        final ECHybridRecyclerView r47 = r46.b;
        if (r47 == null) goto L74;
        r47.addOnScrollListener(new ECShopHybridProductListPresenter$initEngine$$inlined$apply$lambda$1(r47, this));
    L74:
        Intrinsics.checkNotNullParameter(this, "$this$addShowMarqueListener");
        ECHybridListEngine r48 = this.n;
        if (r48 == null) goto L77;
        r48.q(new com.bytedance.android.shopping.store.hybridproduct.extension.m(this));
    L77:
        StringBuilder r49 = new StringBuilder("product_initEngine secShopId=");
        r49.append(this.g.getSecShopId());
        r49.append(" lmId=");
        r49.append(this.g.getLifecycleMonitorId());
        r49.append(" tabId=");
        r49.append(this.C);
        r49.append(" pendingVO=");
        if (this.D == null) goto L80;
        boolean r50 = true;
    L81:
        r49.append(r50);
        r49.append(" hasVO=");
        com.bytedance.android.ec.hybrid.list.entity.k r51 = m0().getHybridListVO();
        if (r51 == null) goto L84;
        ArrayList r52 = r51.c;
    L85:
        if (r52 != null) goto L87;
    L90:
        boolean r210 = true;
    L91:
        r49.append(!r210);
        o0(r49.toString());
        com.bytedance.android.ec.hybrid.list.entity.k r53 = this.D;
        if (r53 == null) goto L94;
        m0().setHybridListVO(r53);
    L94:
        com.bytedance.android.ec.hybrid.list.entity.k r54 = m0().getHybridListVO();
        if (r54 == null) goto L97;
        ArrayList r55 = r54.c;
    L98:
        if (r55 != null) goto L100;
    L103:
        boolean r56 = true;
    L104:
        if (r56 == false) goto L117;
        com.bytedance.android.shopping.store.restore.q r57 = this.N.getPageRestoreCoordinator();
        if (r57 == null) goto L113;
        Integer r58 = this.C;
        if (r58 == null) goto L110;
        int r119 = r58.intValue();
    L112:
        if (r57.a(r119) == true) goto L117;
    L110:
        r119 = 3;
    L113:
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r59 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r60 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(m0().getStoreParam().getLifecycleMonitorId()));
        if (r60 == null) goto L116;
        r60.k(m0().getTabConfig());
    L116:
        m0().fetchProductBffApi();
    L147:
        ECHybridListEngine r61 = this.n;
        if (r61 == null) goto L152;
        ECHybridRecyclerView r62 = r61.b;
        if (r62 == null) goto L152;
        r62.setHasFixedSize(true);
    L152:
        this.N.getCartView().a(ECQuickUtilKt.a(Y()), new com.bytedance.android.shopping.store.hybridproduct.d(this), false);
        this.N.getCartAnimationView().a(ECQuickUtilKt.a(Y()), new e(this), false);
        m0().getResponse().a(ECQuickUtilKt.a(Y()), new g(this), false);
        m0().getApiSliceConfig().a(ECQuickUtilKt.a(Y()), new h(this), false);
        a0().post(new c(this));
        m0().setHasBind(true);
        Iterator<T> r63 = m0().getPendingAction().iterator();
    L154:
        if (r63.hasNext() == false) goto L156;
        ((Runnable) r63.next()).run();
        goto L154
    L156:
        EventCenter.registerJsEventSubscriber("ecom.shop.update_product_notify_status", this.z);
        ECLiveHybridUtil.m("successJoinVip", this.L);
        ECLiveHybridUtil.m("successExitVip", this.M);
        ((QFragmentPresenter) this).e.getLifecycle().addObserver(this);
        return;
    L117:
        com.bytedance.android.ec.hybrid.list.entity.k r64 = m0().getHybridListVO();
        if (r64 == null) goto L147;
        if (m0().isRestoredData() == true) goto L142;
        ShopHybridTabExtKt.f(this, r64, m0().getHasNextPage());
        ECHybridListEngine r65 = this.n;
        if (r65 == null) goto L124;
        r65.c(r64);
    L124:
        ECHybridListEngine r66 = this.n;
        if (r66 == null) goto L142;
        com.bytedance.android.ec.hybrid.list.entity.k r67 = r66.c.g;
        if (r67 == null) goto L142;
        ArrayList r68 = r67.c;
        if (r68 == null) goto L142;
        Iterator r69 = r68.iterator();
    L132:
        if (r69.hasNext() == false) goto L136;
        Object r70 = r69.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r70).a, "__PRODUCTS_SECTION__") == false) goto L132;
    L137:
        com.bytedance.android.ec.hybrid.list.entity.i r71 = (com.bytedance.android.ec.hybrid.list.entity.i) r70;
        if (r71 == null) goto L142;
        r71.c(ECSectionOperationType.INSERT_SECTION);
        ECHybridListEngine r72 = this.n;
        if (r72 == null) goto L142;
        ECHybridListEngine.s(r72, r71, Boolean.TRUE, 4);
        goto L142
    L136:
        r70 = null;
    L142:
        this.N.getFirstScreenConfig().e = k0(r64);
        Choreographer.getInstance().postFrameCallback(new r(this, new ECShopHybridProductListPresenter$recordProductCardRender$runnable$1(this)));
        StringBuilder r73 = new StringBuilder("product_render_by_cache secShopId=");
        r73.append(this.g.getSecShopId());
        r73.append(" lmId=");
        r73.append(this.g.getLifecycleMonitorId());
        r73.append(" tabId=");
        r73.append(this.C);
        r73.append(" sections=");
        ArrayList r74 = r64.c;
        if (r74 == null) goto L145;
        Integer r75 = Integer.valueOf(r74.size());
    L146:
        r73.append(r75);
        r73.append(" itemCount=");
        r73.append(k0(r64));
        o0(r73.toString());
        goto L147
    L145:
        r75 = null;
        goto L146
    L100:
        if (r55.isEmpty() == true) goto L103;
        r56 = false;
        goto L104
    L97:
        r55 = null;
        goto L98
    L87:
        if (r52.isEmpty() == true) goto L90;
        r210 = false;
        goto L91
    L84:
        r52 = null;
        goto L85
    L80:
        r50 = false;
        goto L81
    L56:
        r37 = null;
        goto L57
    L9:
        if (r6.isEmpty() == true) goto L12;
        r7 = false;
        goto L13
    L5:
        r6 = null;
        goto L7
    }

    public final int j0(com.bytedance.android.ec.hybrid.list.entity.i r11) {
        ArrayList r0 = r11.i;
        boolean r1 = false;
        if (r0 == null) goto L13;
        Iterator r2 = r0.iterator();
        int r4 = 0;
    L6:
        if (r2.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(((ECHybridListItemVO) r2.next()).d, m0().getCurrentProductId()) == true) goto L12;
        r4 = r4 + 1;
    L12:
        Integer r3 = Integer.valueOf(r4);
    L14:
        if (r3 != null) goto L17;
    L18:
        r1 = true;
    L19:
        if (r1 == true) goto L22;
        r3 = null;
    L22:
        if (r3 == null) goto L59;
        int r5 = r3.intValue();
        ArrayList r6 = r11.i;
        if (r6 == null) goto L59;
        int r7 = r6.size();
        ECHybridListEngine r8 = this.n;
        if (r8 == null) goto L59;
        ECHybridListAdapter r9 = r8.a;
        if (r9 == null) goto L59;
        BaseViewHolder r10 = r9.y2("__PRODUCTS_SECTION__", m0().getCurrentProductId());
        if (r10 == null) goto L59;
        View r12 = ((RecyclerView.ViewHolder) r10).itemView;
        if (r12 == null) goto L59;
        Rect r13 = new Rect();
        Rect r14 = new Rect();
        r12.getGlobalVisibleRect(r13);
    L35:
        if (r5 >= r7) goto L59;
        ECHybridListEngine r15 = this.n;
        if (r15 == null) goto L58;
        ECHybridListAdapter r16 = r15.a;
        if (r16 == null) goto L58;
        ArrayList r17 = r11.i;
        if (r17 == null) goto L45;
        ECHybridListItemVO r18 = (ECHybridListItemVO) ListProtector.get(r17, r5);
        if (r18 == null) goto L45;
        String r19 = r18.d;
    L46:
        if (r19 != null) goto L48;
        r19 = "";
    L48:
        BaseViewHolder r20 = r16.y2("__PRODUCTS_SECTION__", r19);
        if (r20 == null) goto L58;
        ((RecyclerView.ViewHolder) r20).itemView.getGlobalVisibleRect(r14);
        if (r14.top <= r13.bottom) goto L58;
        int r21 = r14.left;
        int r22 = r13.right;
        int r23 = O;
        if (r21 >= (r22 - r23)) goto L58;
        if (r14.right <= (r13.left + r23)) goto L58;
        return r5;
    L45:
        r19 = null;
    L58:
        r5 = r5 + 1;
    L59:
        return -1;
    L17:
        if (r3.intValue() == (-1)) goto L19;
    L11:
        r4 = -1;
        goto L12
    L13:
        r3 = null;
        goto L14
    }

    public final void o0(String r2) {
        dm.a.a("ec_shop_restore").a(r2);
    }

    public ECShopHybridProductListPresenter(ECStoreModuleBinderFragment r2, ECStoreViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        super(r2);
        this.N = r3;
        this.f = r3.getSceneId();
        this.g = r3.getStoreParam();
        this.h = r3.getCommonEventParams();
        this.i = r3.isWhiteBrand();
        this.j = LazyKt.lazy(new ECShopHybridProductListPresenter$lifecycleOwner$2(this));
        this.k = LazyKt.lazy(new ECShopHybridProductListPresenter$rootView$2(this));
        this.l = LazyKt.lazy(new ECShopHybridProductListPresenter$viewModel$2(this));
        this.v = new TreeMap();
        this.w = new ArrayList();
        this.y = new LinkedHashSet();
        this.z = new q(this);
        this.A = a0.a;
        this.L = new com.bytedance.android.shopping.store.hybridproduct.c(this, "successJoinVip");
        this.M = new com.bytedance.android.shopping.store.hybridproduct.c(this, "successExitVip");
    }

    public static final void d0(ECShopHybridProductListPresenter r5, ECShopProductListBffResponseDTO r6) {
        r5.getClass();
        ECHybridListDTO r0 = r6.getHybridList();
        if (r0 == null) goto L20;
        Map r1 = r0.getExtra();
        if (r1 == null) goto L8;
        String r2 = (String) r1.get("background_type");
    L10:
        if ((r2 instanceof String) == true) goto L12;
        r2 = null;
    L12:
        CompositeDisposable r3 = r5.J;
        if (r3 == null) goto L15;
        r3.dispose();
    L15:
        r5.J = new CompositeDisposable();
        ECHybridListDTO.Companion.getClass();
        Intrinsics.checkNotNullParameter(r0, "dto");
        Disposable r7 = Observable.create(new com.bytedance.android.ec.hybrid.list.entity.dto.b(r0, false, null)).doOnNext(new u(r5)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new w(r5, r2, r6), x.a, new y(r5));
        CompositeDisposable r8 = r5.J;
        if (r8 == null) goto L19;
        r8.add(r7);
        return;
    L19:
        return;
    L8:
        r2 = null;
        goto L10
    }

    public final void onStateChanged(LifecycleOwner r4, Lifecycle.Event r5) {
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "event");
        int r6 = com.bytedance.android.shopping.store.hybridproduct.a.b[r5.ordinal()];
        if (r6 == 1) goto L12;
        if (r6 != 2) goto L6;
        CompositeDisposable r7 = this.J;
        if (r7 == null) goto L30;
        r7.dispose();
        return;
    L30:
        return;
    L6:
        if (r6 != 3) goto L33;
        this.K = true;
        return;
    L33:
        return;
    L12:
        monitor-enter(this);
    L25:
    L22:
        th = move-exception;
        throw th;
    L14:
        if ((!((ArrayList) this.w).isEmpty()) == false) goto L17;
        ((Runnable) ListProtector.remove(this.w, 0)).run();     // Catch: Throwable -> L22
        goto L25
    L17:
        monitor-exit(this);
        if (this.K == false) goto L32;
        ECStoreViewModel.tryUpdateFloatView$default(this.N, ShopMarketingScene.CART_UPDATE, null, 2, null);
        this.K = false;
        return;
    }

    public static final void e0(ECShopHybridProductListPresenter r1, int r2, RecyclerView r3, com.bytedance.android.ec.hybrid.list.entity.k r4) {
        r1.getClass();
        if (r3.isComputingLayout() == true) goto L28;
        if (r3.getScrollState() != 0) goto L28;
        com.bytedance.android.shopping.store.restore.q r5 = r1.N.getPageRestoreCoordinator();
        if (r5 == null) goto L16;
        Integer r6 = r1.C;
        if (r6 == null) goto L12;
        int r7 = r6.intValue();
    L13:
        boolean r8 = r5.a(r7);
        boolean r9 = true;
        if (r8 != true) goto L16;
    L17:
        r1.G = r9;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L24
        ECHybridListEngine r11 = r1.n;     // Catch: Throwable -> L24
        if (r11 == null) goto L21;
        ECHybridListEngine.p(r11, r4, 6);     // Catch: Throwable -> L24
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        Result.constructor-impl(r12);     // Catch: Throwable -> L24
    L26:
        r1.i0();
        return;
    L21:
        r12 = null;
    L24:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L12:
        r7 = 3;
    L16:
        r9 = false;
    L28:
        if (r2 >= 30) goto L30;
        r3.post(new b0(r1, r2, r3, r4));
        return;
    L30:
        r3.post(new c0(r1, r3, r4));
    }

    public final void n0(InteractiveControl r8, List<ECHybridListItemDTO> r9, com.bytedance.android.ec.hybrid.list.entity.i r10, Map<String, com.bytedance.android.ec.hybrid.list.entity.k.a> r11) {
        if (r8.getRemoveUnexposedProducts() == false) goto L26;
        HashSet<String> r12 = m0().getAllIdRecords();
        r12.removeAll(m0().getIdRecords());
        Iterator<T> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L15;
        String r0 = (String) r13.next();
        ECHybridListEngine r1 = this.n;
        if (r1 == null) goto L14;
        Integer r2 = r1.d("__PRODUCTS_SECTION__", r0);
        if (r2 == null) goto L40;
        int r3 = r2.intValue();
        ECHybridListEngine r4 = this.n;
        if (r4 == null) goto L6;
        r4.c.hB(r3);
        goto L6
    L40:
        return;
    L14:
        return;
    L15:
        r10.c(ECSectionOperationType.NONE);
        if (r9.size() <= 1) goto L23;
        Iterator<T> r14 = r9.subList(1, r9.size()).iterator();
    L19:
        if (r14.hasNext() == false) goto L23;
        ECHybridListItemDTO r5 = (ECHybridListItemDTO) r14.next();
        ArrayList r6 = r10.i;
        if (r6 == null) goto L19;
        ECHybridListItemDTO.Companion r7 = ECHybridListItemDTO.Companion;
        String r15 = r10.a;
        r7.getClass();
        ECHybridListItemVO r16 = ECHybridListItemDTO.Companion.b(r5, r15, false, null);
        ECItemOperationType r17 = ECItemOperationType.INSERT;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.p = r17;
        ShopHybridTabExtKt.d(r16, r10);
        Unit r18 = Unit.INSTANCE;
        r6.add(r16);
    L23:
        r10.c(ECSectionOperationType.INSERT_SECTION);
        ECHybridListEngine r19 = this.n;
        if (r19 == null) goto L26;
        r19.t(r10, Boolean.FALSE, r11);
    L26:
        String r20 = r10.a;
        a0().postDelayed(new d(this, r10, r9, r20, r11), 500);
    }

    public static final void h0(ECShopHybridProductListPresenter r7, RecyclerView r8, int r9, int r10, int r11) {
        r7.getClass();
        if (r8.isComputingLayout() == true) goto L22;
        if (r8.getScrollState() != 0) goto L22;
        if (Intrinsics.areEqual(r7.H, r7.E) == true) goto L27;
        r7.H = r7.E;
        RecyclerView.LayoutManager r12 = r8.getLayoutManager();
        if (r12 != null) goto L14;
        return;
    L14:
        if ((r12 instanceof ECVirtualLayoutManager) == true) goto L16;
        r12 = null;
    L16:
        ECVirtualLayoutManager r13 = (ECVirtualLayoutManager) r12;
        if (r13 == null) goto L19;
        r13.scrollToPositionWithOffset(r10, r11);
    L20:
        t93.a.b().post(new e0(r7));
        r7.o0("product_restore_scroll_reapply from=firstScreenCallback tabId=" + r7.C + " pos=" + r10 + " offset=" + r11);
        return;
    L19:
        r8.scrollToPosition(r10);
        goto L20
    L27:
        return;
    L22:
        if (r9 >= 30) goto L26;
        r8.post(new d0(r7, r8, r9, r10, r11));
        return;
    }
}
