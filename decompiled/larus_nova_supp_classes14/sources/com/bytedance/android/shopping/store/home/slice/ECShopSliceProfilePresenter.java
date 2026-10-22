package com.bytedance.android.shopping.store.home.slice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.view.ECAutoScrollHorizontalScrollView;
import com.bytedance.android.ec.store.view.ECScrollTagListView;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.SlcElementContainer;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.Scene;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.a0;
import com.bytedance.android.shopping.store.home.b0;
import com.bytedance.android.shopping.store.home.entity.n;
import com.bytedance.android.shopping.store.home.presenter.ECShopBasePresenter;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.bytedance.android.shopping.store.lifecycle.m;
import com.bytedance.android.shopping.store.slicecard.ShopSlcCardFactory;
import com.bytedance.android.shopping.store.slicecard.ShopSliceKey;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/home/slice/ECShopSliceProfilePresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSliceProfilePresenter extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int D = 0;
    public Map<String, Object> A;
    public final Lazy B;
    public boolean C;
    public r u;
    public ECScrollTagListView v;
    public View w;
    public Map<String, ? extends Object> x;
    public Map<String, Object> y;
    public final Map<String, Object> z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopSliceProfilePresenter a;

        public b(ECShopSliceProfilePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            n r8 = (n) r7;
            Intrinsics.checkNotNullParameter(r8, "headerArea");
            com.bytedance.android.shopping.store.home.slice.d r0 = r8.o;
            if (r0 == null) goto L115;
            Map<Long, m> r1 = com.bytedance.android.shopping.store.lifecycle.a.a;
            m r2 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.T().getStoreParam().getLifecycleMonitorId()));
            if (r2 == null) goto L7;
            r2.t();
        L7:
            ECShopSliceProfilePresenter r3 = this.a;
            r3.T().getSliceService().d(com.bytedance.android.shopping.store.home.slice.f.a(r0));
            ShopSlcCardFactory r4 = r3.T().getSliceCardFactory();
            Map<String, ECStoreHeaderInfoSliceConfig> r5 = r0.a;
            View r6 = null;
            if (r5 == null) goto L18;
            ECStoreHeaderInfoSliceConfig r9 = r5.get(SliceItemType.SHOP_PROFILE.getType());
            if (r9 == null) goto L18;
            ShopSliceItemConfig r10 = r9.getSliceItemConfig();
            if (r10 == null) goto L18;
            List<SliceTemplate> r11 = r10.getTemplates();
            if (r11 == null) goto L18;
            SliceTemplate r12 = (SliceTemplate) CollectionsKt.firstOrNull(r11);
            if (r12 == null) goto L18;
            String r13 = r12.getName();
        L19:
            r r14 = r4.c(r13);
            r3.u = r14;
            if (r14 == null) goto L22;
            r14.b((com.bytedance.android.shopping.store.slicecard.e) r3.B.getValue());
        L22:
            r r15 = r3.u;
            if (r15 == null) goto L27;
            SlcTemplateContext r16 = r15.b;
            if (r16 == null) goto L27;
            r16.s(ShopSliceUniqueId.SHOP_PROFILE.getId(), new ECShopSliceProfilePresenter$initViewInfo$1(r3));
        L27:
            ECShopSliceProfilePresenter.s0(this.a, r0, r8.c);
            ECShopSliceProfilePresenter.q0(this.a);
            com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.T().getStoreParam().getLifecycleMonitorId()));
            m r17 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(this.a.T().getStoreParam().getLifecycleMonitorId()));
            if (r17 == null) goto L30;
            r17.T();
        L30:
            final ECShopSliceProfilePresenter r18 = this.a;
            r r19 = r18.u;
            if (r19 == null) goto L113;
            View r20 = r19.c;
            if (r20 == null) goto L113;
            FrameLayout.LayoutParams r21 = new FrameLayout.LayoutParams(-1, -2);
            View r22 = r18.y();
            if ((r22 instanceof ViewGroup) == true) goto L37;
            r22 = null;
        L37:
            ViewGroup r23 = (ViewGroup) r22;
            if (r23 == null) goto L40;
            r23.addView(r20, r21);
        L40:
            r r24 = r18.u;
            if (r24 == null) goto L47;
            SlcTemplateContext r25 = r24.b;
            if (r25 == null) goto L47;
            if (r25.w == null) goto L47;
            View r26 = SlcRenderContext.f(r20, ShopSliceKey.SHORT_TERM_INDICATORS.getKey());
        L49:
            if ((r26 instanceof SlcElementContainer) == true) goto L51;
            r26 = null;
        L51:
            SlcElementContainer r27 = (SlcElementContainer) r26;
            if (r27 == null) goto L54;
            View r28 = r27.getContentView();
        L56:
            if ((r28 instanceof ECTagListView) == true) goto L58;
            r28 = null;
        L58:
            ECTagListView r29 = (ECTagListView) r28;
            r r30 = r18.u;
            if (r30 == null) goto L65;
            SlcTemplateContext r31 = r30.b;
            if (r31 == null) goto L65;
            if (r31.w == null) goto L65;
            View r32 = SlcRenderContext.f(r20, ShopSliceKey.LONG_TERM_INDICATORS.getKey());
        L67:
            if ((r32 instanceof SlcElementContainer) == true) goto L69;
            r32 = null;
        L69:
            SlcElementContainer r33 = (SlcElementContainer) r32;
            if (r33 == null) goto L72;
            View r34 = r33.getContentView();
        L74:
            if ((r34 instanceof ECScrollTagListView) == true) goto L76;
            r34 = null;
        L76:
            r18.v = (ECScrollTagListView) r34;
            r r35 = r18.u;
            if (r35 == null) goto L83;
            SlcTemplateContext r36 = r35.b;
            if (r36 == null) goto L83;
            if (r36.w == null) goto L83;
            View r37 = SlcRenderContext.f(r20, ShopSliceKey.SHOP_NAME.getKey());
        L85:
            if ((r37 instanceof SlcElementContainer) == true) goto L87;
            r37 = null;
        L87:
            SlcElementContainer r38 = (SlcElementContainer) r37;
            if (r38 == null) goto L90;
            Object r39 = r38.getContentView();
        L92:
            if ((r39 instanceof ECShopMarqueeTextView) == true) goto L94;
            r39 = null;
        L94:
            ECShopMarqueeTextView r40 = (ECShopMarqueeTextView) r39;
            if (r40 == null) goto L97;
            r40.setOnScrollEndAction(new ECShopSliceProfilePresenter$initViews$$inlined$let$lambda$1(r18));
        L97:
            r r41 = r18.u;
            if (r41 == null) goto L104;
            SlcTemplateContext r42 = r41.b;
            if (r42 == null) goto L104;
            if (r42.w == null) goto L104;
            View r43 = SlcRenderContext.f(r20, ShopSliceKey.SHOP_LOGO.getKey());
        L105:
            r18.w = r43;
            ECStoreViewModel r44 = r18.T();
            r r45 = r18.u;
            if (r45 == null) goto L112;
            SlcTemplateContext r46 = r45.b;
            if (r46 == null) goto L112;
            if (r46.w == null) goto L112;
            r6 = SlcRenderContext.f(r20, ShopSliceKey.FOLLOW_BUTTON.getKey());
        L112:
            r44.setSliceHeaderFollowButtonView(new WeakReference(r6));
        L104:
            r43 = null;
            goto L105
        L90:
            r39 = null;
        L83:
            r37 = null;
            goto L85
        L72:
            r34 = null;
        L65:
            r32 = null;
            goto L67
        L54:
            r28 = null;
        L47:
            r26 = null;
        L113:
            r18.T().getViewTransitShipment().d(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.store.viewmodel.d.class), new com.bytedance.android.shopping.store.home.slice.b(r18));
            return;
        L18:
            r13 = null;
            goto L19
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopSliceProfilePresenter a;

        public c(ECShopSliceProfilePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            a0 r4 = (a0) r3;
            Intrinsics.checkNotNullParameter(r4, "followConfig");
            h.a(this.a.z, r4, "ECShopInfoTotalAreaSlicePresenter");
            ECShopSliceProfilePresenter.q0(this.a);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopSliceProfilePresenter a;

        public d(ECShopSliceProfilePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ((Number) r3).floatValue();
            ECShopSliceProfilePresenter r4 = this.a;
            if (r4.U() == false) goto L5;
            float r5 = 1.0f;
        L6:
            this.a.z.put("media_scroll_percent", Float.valueOf(r5));
            ECShopSliceProfilePresenter.q0(this.a);
            ECShopSliceProfilePresenter.r0(this.a);
            return;
        L5:
            r5 = r4.b0();
            goto L6
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECShopSliceProfilePresenter a;

        public e(ECShopSliceProfilePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Map<String, Object> r0 = this.a.z;
            r0.put("profile_scroll_percent", (Float) r3);
            ECShopSliceProfilePresenter.q0(this.a);
            ECShopSliceProfilePresenter.r0(this.a);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ECShopSliceProfilePresenter a;

        public f(ECShopSliceProfilePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            ECScrollTagListView r4 = this.a.v;
            if (r4 == null) goto L5;
            r4.setHasShopNameScrollEnd(true);
        L5:
            ECShopSliceProfilePresenter.r0(this.a);
        }
    }

    static {
    }

    public ECShopSliceProfilePresenter() {
        this(null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        this.C = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (this.C == false) goto L9;
        T().refreshHeaderArea(new AnonymousClass1(this));
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L9;
        wu1.a r2 = r1.getECLiveStateController();
        if (r2 == null) goto L9;
        r2.a(Scene.SHOP);
    L9:
        this.C = false;
    }

    public ECShopSliceProfilePresenter(Fragment r1) {
        super(r1);
        this.z = new LinkedHashMap();
        this.B = LazyKt.lazy(new ECShopSliceProfilePresenter$slcActionHandler$2(this));
    }

    public static final void q0(ECShopSliceProfilePresenter r8) {
        if (r8.x == null) goto L35;
        Map<String, Object> r0 = r8.z;
        if (r8.T().getStoreParam().getStoreUIParam().getLiveDefaultMute() == false) goto L8;
        String r1 = "mute";
    L12:
        r0.put("shop_live_volume_state", r1);
        int r2 = ECSdk.a;
        IAdapterService r3 = (IAdapterService) ECSdk.a(IAdapterService.class);
        Object r4 = null;
        if (r3 == null) goto L15;
        wu1.a r5 = r3.getECLiveStateController();
    L17:
        if (r8.T().canShowLiveIcon() == true) goto L19;
    L22:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.putAll(r8.z);
        r6.putAll(r8.T().getSliceService().a());
        LinkedHashMap r7 = new LinkedHashMap();
        Map<String, ? extends Object> r9 = r8.x;
        if (r9 != null) goto L25;
        r9 = MapsKt.emptyMap();
    L25:
        r7.putAll(r9);
        r7.put("slice_item_actions", r8.y);
        r7.put("slice_item_states", r6);
        r7.put("slice_item_extra", r8.A);
        Unit r10 = Unit.INSTANCE;
        Map r11 = MapsKt.mapOf(TuplesKt.to("data", r7));
        dm.a.a("ECShopInfoTotalAreaSlicePresenter").a("bindData, sliceItemStates: " + r8.z);
        dm.a.b r12 = dm.a.a("ECShopInfoTotalAreaSlicePresenter");
        StringBuilder r13 = new StringBuilder("bindData, dataCtx sliceItemStates: ");
        Object r14 = r11.get("data");
        if (r14 == null) goto L30;
        Map r15 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r14);
        if (r15 == null) goto L30;
        r4 = r15.get("slice_item_states");
    L30:
        r13.append(r4);
        r12.a(r13.toString());
        r r16 = r8.u;
        if (r16 == null) goto L34;
        r16.a(r11, ShopSliceUniqueId.SHOP_PROFILE.getId());
        return;
    L34:
        return;
    L19:
        if (r8.T().getStoreParam().getStoreUIParam().getCanShowFloatLive() == false) goto L22;
        if (r5 == null) goto L22;
        FloatWindowState r17 = FloatWindowState.OPEN;
        Scene r18 = Scene.LIVE;
        r5.b(r17);
        goto L22
    L15:
        r5 = null;
        goto L17
    L8:
        int r19 = ECSdk.a;
        IAdapterService r20 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r20 == null) goto L11;
        r20.muteLiveRoom();
    L11:
        r1 = "unmute";
        goto L12
    }

    public static final void r0(ECShopSliceProfilePresenter r2) {
        if (r2.T().getUseNewSign() == true) goto L5;
    L13:
        ECScrollTagListView r3 = r2.v;
        if (r3 != null) goto L16;
        return;
    L16:
        if (r3.getVisibility() != 0) goto L26;
        ECAutoScrollHorizontalScrollView r4 = r3.d;
        if (r4 == null) goto L25;
        r4.a.forceFinished(true);
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) r2.T().getHeaderAreaStartScrollTag().getValue(), Boolean.TRUE) == false) goto L13;
        if (k.e((Float) r2.T().getUpglideFactor().getValue(), 0.0f) > 0.0f) goto L13;
        if (k.e((Float) r2.T().getCollapseFactor().getValue(), 1.0f) < 1.0f) goto L13;
        ECScrollTagListView r5 = r2.v;
        if (r5 == null) goto L22;
        r5.a();
        return;
    }

    public final void A(QModel r4) {
        Lifecycle r5 = W().getLifecycle();
        if (r5 == null) goto L5;
        r5.addObserver(this);
    L5:
        T().getHeaderArea().a(W(), new b(this), false);
        T().getFollowConfigLiveData().a(W(), new c(this), false);
        T().getCollapseFactor().a(ECQuickUtilKt.a(u()), new d(this), false);
        T().getUpglideFactor().a(ECQuickUtilKt.a(u()), new e(this), false);
        T().getHeaderAreaStartScrollTag().a(ECQuickUtilKt.a(u()), new f(this), false);
    }

    public static final void s0(ECShopSliceProfilePresenter r2, com.bytedance.android.shopping.store.home.slice.d r3, com.bytedance.android.shopping.store.home.entity.d r4) {
        r2.getClass();
        r2.x = r3.b;
        Map<String, ECStoreHeaderInfoSliceConfig> r5 = r3.a;
        if (r5 == null) goto L17;
        ECStoreHeaderInfoSliceConfig r6 = r5.get(SliceItemType.SHOP_PROFILE.getType());
        if (r6 == null) goto L17;
        Map<String, Object> r0 = r6.getSliceItemActions();
        Map<String, Object> r1 = null;
        if (r0 == null) goto L9;
        Map<String, Object> r7 = MapsKt.toMutableMap(r0);
    L10:
        r2.y = r7;
        Map<String, Object> r8 = r6.getSliceItemExtra();
        if (r8 == null) goto L13;
        r1 = MapsKt.toMutableMap(r8);
    L13:
        r2.A = r1;
        Map<String, Object> r9 = r2.z;
        Map<String, Object> r10 = r6.getSliceItemStates();
        if (r10 != null) goto L16;
        r10 = MapsKt.emptyMap();
    L16:
        r9.putAll(r10);
        goto L17
    L9:
        r7 = null;
    L17:
        int r11 = b0.a;
        b0.a(r2.z, b0.b(r4));
        dm.a.a("ECShopInfoTotalAreaSlicePresenter").a("updateFollowStateFromAccountInfo, sliceItemStates: " + r2.z);
    }
}
