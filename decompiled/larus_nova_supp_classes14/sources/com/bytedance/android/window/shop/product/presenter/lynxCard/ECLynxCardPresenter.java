package com.bytedance.android.window.shop.product.presenter.lynxCard;

import android.util.Base64;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.bst.api.f;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.bridge.LynxStatefulBridgeProxy;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.api.d;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;
import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.ec.hybrid.card.util.q;
import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.bytedance.android.ec.window.base.utils.i;
import com.bytedance.android.ec.window.base.utils.window.WindowAutoCleanResourceCache;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBasePresenter;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.m0;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/product/presenter/lynxCard/ECLynxCardPresenter;", "Lcom/bytedance/android/window/shop/holder/presenter/ECWindowHolderBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onPause", "onResume", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLynxCardPresenter extends ECWindowHolderBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ KProperty[] t = null;
    public List<? extends Object> g;
    public final Lazy h;
    public Function2<? super Long, ? super Map<String, String>, Unit> i;
    public boolean j;
    public final Lazy k;
    public v l;
    public final c m;
    public final a n;
    public ViewGroup o;
    public final Lazy p;
    public final Function2<v, ECLynxCardEvent, Unit> q;
    public final WindowLayoutType r;
    public final Fragment s;

    public static final class a extends ObservableProperty<ECLynxCard> {
        public final /* synthetic */ ECLynxCardPresenter a;

        public a(ECLynxCardPresenter r1) {
            this.a = r1;
            super(null);
        }

        public final void afterChange(KProperty<?> r2, ECLynxCard r3, ECLynxCard r4) {
            Intrinsics.checkNotNullParameter(r2, "property");
            ECLynxCard r5 = r4;
            ECLynxCard r6 = r3;
            if (r6 == null) goto L5;
            WindowAutoCleanResourceCache r7 = (WindowAutoCleanResourceCache) this.a.h.getValue();
            r7.a.remove(r6);
            r7.b.invoke(r6);
        L5:
            if (r5 == null) goto L8;
            ((WindowAutoCleanResourceCache) this.a.h.getValue()).a.add(r5);
            return;
        }
    }

    public static final class b {
    }

    public static final class c extends IECLynxCardLifeCycle.Base {
        public final /* synthetic */ ECLynxCardPresenter a;

        public final void onRuntimeReady() {
            ECLynxCardPresenter r0 = this.a;
            KProperty[] r1 = ECLynxCardPresenter.t;
            ECLynxCard r2 = r0.G();
            if (r2 == null) goto L6;
            r2.n();
            return;
        }

        public final void onFirstScreen() {
            super.onFirstScreen();
        }

        public c(ECLynxCardPresenter r1) {
            this.a = r1;
        }

        public final void onPreCreateView(boolean r5) {
            ECLynxCardPresenter r0 = this.a;
            r0.j = r5;
            v r1 = r0.l;
            if (r1 == null) goto L5;
            Integer r2 = Integer.valueOf(r1.i);
        L6:
            String r3 = String.valueOf(r2);
            if (r5 == false) goto L9;
            String r6 = CommentScene.COMMENTSCENE_NO_AWEME;
        L10:
            r0.D().doEventAction("ec_window_hit_preload", new Pair[]{TuplesKt.to("item_type", r3), TuplesKt.to("use_preload", r6)});
            return;
        L9:
            r6 = "0";
            goto L10
        L5:
            r2 = null;
            goto L6
        }

        public final void onTimingSetupPref(k r8) {
            Function2<? super Long, ? super Map<String, String>, Unit> r0 = this.a.i;
            int r1 = 0;
            if (r0 == null) goto L18;
            if (r8 == null) goto L8;
            Long r2 = r8.b;
            if (r2 == null) goto L8;
            long r3 = r2.longValue();
        L9:
            Long r4 = Long.valueOf(r3);
            Pair[] r5 = new Pair[3];
            if (r8 == null) goto L12;
            Object r6 = null;
            r8.getClass();
        L13:
            r5[0] = TuplesKt.to("resource_perf", com.bytedance.android.ec.hybrid.list.util.k.d(r6));
            if (this.a.j == false) goto L16;
            String r7 = CommentScene.COMMENTSCENE_NO_AWEME;
        L17:
            r5[1] = TuplesKt.to("is_preload", r7);
            r5[2] = TuplesKt.to("is_end_with_update", "0");
            Unit r9 = (Unit) r0.invoke(r4, MapsKt.mapOf(r5));
            goto L18
        L16:
            r7 = "0";
            goto L17
        L12:
            r6 = null;
        L8:
            r3 = 0;
        L18:
            int r10 = com.bytedance.android.window.shop.lifecycle.a.a;
            ECWindowViewModel r11 = this.a.D();
            int r12 = com.bytedance.android.window.shop.b.a;
            v r13 = this.a.l;
            if (r13 == null) goto L21;
            r1 = r13.i;
        L21:
            com.bytedance.android.window.shop.lifecycle.a.a(r11, r8, String.valueOf(r1 & (-1073741825)), this.a.j);
        }

        public final void onTimingUpdatePref(k r8) {
            Function2<? super Long, ? super Map<String, String>, Unit> r0 = this.a.i;
            int r1 = 0;
            if (r0 == null) goto L18;
            if (r8 == null) goto L8;
            Long r2 = r8.b;
            if (r2 == null) goto L8;
            long r3 = r2.longValue();
        L9:
            Long r4 = Long.valueOf(r3);
            Pair[] r5 = new Pair[3];
            if (r8 == null) goto L12;
            Object r6 = null;
            r8.getClass();
        L13:
            r5[0] = TuplesKt.to("resource_perf", com.bytedance.android.ec.hybrid.list.util.k.d(r6));
            if (this.a.j == false) goto L16;
            String r7 = CommentScene.COMMENTSCENE_NO_AWEME;
        L17:
            r5[1] = TuplesKt.to("is_preload", r7);
            r5[2] = TuplesKt.to("is_end_with_update", CommentScene.COMMENTSCENE_NO_AWEME);
            Unit r9 = (Unit) r0.invoke(r4, MapsKt.mapOf(r5));
            goto L18
        L16:
            r7 = "0";
            goto L17
        L12:
            r6 = null;
        L8:
            r3 = 0;
        L18:
            int r10 = com.bytedance.android.window.shop.lifecycle.a.a;
            ECWindowViewModel r11 = this.a.D();
            v r12 = this.a.l;
            if (r12 == null) goto L24;
            v.b r13 = r12.k;
            if (r13 == null) goto L24;
            String r14 = r13.c();
            if (r14 == null) goto L24;
        L25:
            String r15 = q.c(UriProtector.parse(r14), "first_screen_flag");
            int r16 = com.bytedance.android.window.shop.b.a;
            v r17 = this.a.l;
            if (r17 == null) goto L28;
            r1 = r17.i;
        L28:
            com.bytedance.android.window.shop.lifecycle.a.b(r11, r8, r15, String.valueOf(r1 & (-1073741825)), this.a.j);
            return;
        L24:
            r14 = "";
            goto L25
        }

        public final void onLoadFailed(ECLynxCardErrorType r1, Integer r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "type");
            ECLynxCardPresenter r4 = this.a;
            KProperty[] r5 = ECLynxCardPresenter.t;
            r4.I(r1);
        }
    }

    static {
        t = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(ECLynxCardPresenter.class, "lynxCard", "getLynxCard()Lcom/bytedance/android/ec/hybrid/card/impl/ECLynxCard;", 0))};
    }

    public final ECLynxCard G() {
        return (ECLynxCard) this.n.getValue(this, t[0]);
    }

    public final void C() {
        this.s.getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        ECLynxCard r0 = G();
        if (r0 == null) goto L6;
        ECLynxCard.m(r0, true, "", "", false, false, false, 0, 240);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        ECLynxCard r0 = G();
        if (r0 == null) goto L6;
        ECLynxCard.m(r0, true, "", "", false, false, false, 0, 240);
        return;
    }

    public final void onShow() {
        D().getExtraSchemaClosed().a(E(), new com.bytedance.android.window.shop.product.presenter.lynxCard.b(this), false);
        ECLynxCard r4 = G();
        if (r4 == null) goto L9;
        v r0 = this.l;
        if (r0 == null) goto L7;
        boolean r8 = r0.l;
    L8:
        ECLynxCard.m(r4, true, "list", "", r8, false, false, 0, 240);
        goto L9
    L7:
        r8 = false;
    L9:
        v r1 = this.l;
        if (r1 == null) goto L13;
        r1.l = false;
        return;
    }

    public final void A(QModel r12) {
        this.s.getLifecycle().addObserver(this);
        byte[] r1 = null;
        if ((r12 instanceof v) == true) goto L5;
        r12 = null;
    L5:
        v r13 = (v) r12;
        if (r13 == null) goto L50;
        this.l = r13;
        v.b r0 = r13.k;
        if (r0 == null) goto L10;
        String r2 = r0.c();
    L12:
        if (r2 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        I(ECLynxCardErrorType.FAILED);
        return;
    L20:
        List<? extends Object> r5 = CollectionsKt.listOf(new Object[]{Integer.valueOf(r13.i), r2});
        String r6 = r13.j;
        if (G() == null) goto L29;
        if (r6 == null) goto L29;
        if (Intrinsics.areEqual(r5, this.g) == false) goto L29;
        int r7 = d.e;
        d r8 = d.a.c(r6, MapsKt.mapOf(TuplesKt.to("ec_lynx_props_extra", com.bytedance.android.ec.hybrid.list.util.k.b(F(r13)))));
        ECLynxCard r9 = G();
        if (r9 == null) goto L28;
        r9.e(r8, true);
    L28:
        onShow();
        boolean r10 = true;
    L30:
        if (r10 == false) goto L32;
        return;
    L32:
        this.g = r5;
        if (G() != null) goto L35;
        this.n.setValue(this, t[0], new ECLynxCard());
    L35:
        ViewGroup r11 = (ViewGroup) w().b(2131370930).f();
        this.o = r11;
        r11.removeAllViews();
        String r14 = com.bytedance.android.shopping.extensions.k.a(r13.j, new ECLynxCardPresenter$createLynxCardAndLoad$initData$1(this));
        if (yq3.a.e() != 1) goto L38;
        r2 = r2 + "&loader_name=forest";
    L38:
        ECLynxLoadParam.a r15 = new ECLynxLoadParam.a(y().getContext(), r2, r11);
        r15.j(2000);
        r15.i = this.s.getLifecycle();
        r15.j = r14;
        Map r3 = MapsKt.mapOf(TuplesKt.to("ec_lynx_props_extra", com.bytedance.android.ec.hybrid.list.util.k.b(F(r13))));
        Intrinsics.checkNotNullParameter(r3, "appendData");
        r15.m = r3;
        r15.f(this.m);
        r15.i(ECLynxLoadType.PRE_CREATE_VIEW);
        int r16 = zq3.d.a;
        ECWindowViewModel r17 = D();
        int r18 = com.bytedance.android.window.shop.b.a;
        r15.e(zq3.d.b(r17, String.valueOf(r13.i & (-1073741825)), r13.b));
        r15.g("ec_window_lynx_card");
        LinkedHashMap r19 = new LinkedHashMap();
        f.d(r11, r13);
        r15.q = r19;
        r15.d(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ecom.window.click_product", new LynxStatefulBridgeProxy(new ECLynxCardPresenter$makeJsBridgeMap$1(this), "ecom.window.click_product")), TuplesKt.to("ecom.window.show_bubble", new LynxStatefulBridgeProxy(new ECLynxCardPresenter$makeJsBridgeMap$2(this), "ecom.window.show_bubble"))}));
        v.d r110 = r13.m;
        if (r110 == null) goto L45;
        int r20 = i.a;
        String r21 = r110.c();
        if (r21 == null) goto L44;
        r1 = Base64.decode(r21, 0);
    L44:
        com.bytedance.android.ec.hybrid.card.api.c r22 = new com.bytedance.android.ec.hybrid.card.api.c(r1, z1.k(com.bytedance.android.shopping.extensions.k.u(r110.a())), r110.b());
        Intrinsics.checkNotNullParameter(r22, "ecLynxSsrParam");
        r15.k = r22;
    L45:
        ECLynxCard r111 = G();
        if (r111 == null) goto L48;
        r111.j(new ECLynxLoadParam(r15));
    L48:
        onShow();
        return;
    L29:
        r10 = false;
        goto L30
    L14:
        if (StringsKt.isBlank(r2) == true) goto L17;
        r4 = false;
        goto L18
    L10:
        r2 = null;
        goto L12
    }

    public final Map<String, Object> F(v r5) {
        BaseWindowTabViewModel r0 = (BaseWindowTabViewModel) this.k.getValue();
        if (r0 == null) goto L5;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("tab_id", r0.getLastCategoryId());
        String r2 = r0.getCategoryName();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        r1.put("classification_tab", r2);
        Intrinsics.checkNotNullParameter(r5, "$this$getCardPosition");
        Integer r6 = (Integer) r5.f.a(m0.e);
        if (r6 == null) goto L12;
        int r7 = r6.intValue();
    L13:
        r1.put("rank", Integer.valueOf(r7));
        return r1;
    L12:
        r7 = -1;
        goto L13
    L5:
        return MapsKt.emptyMap();
    }

    public final void I(ECLynxCardErrorType r4) {
        ViewGroup r0 = this.o;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        this.n.setValue(this, t[0], null);
        v r1 = this.l;
        if (r1 == null) goto L19;
        int r5 = com.bytedance.android.window.shop.product.presenter.lynxCard.a.a[r4.ordinal()];
        if (r5 != 1) goto L10;
        ECLynxCardEvent r6 = ECLynxCardEvent.TIMEOUT;
    L15:
        Function2<v, ECLynxCardEvent, Unit> r2 = this.q;
        if (r2 == null) goto L20;
        Unit r7 = (Unit) r2.invoke(r1, r6);
        return;
    L20:
        return;
    L10:
        if (r5 != 2) goto L13;
        r6 = ECLynxCardEvent.FAILED;
        goto L15
    L13:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECLynxCardPresenter(Function2<? super v, ? super ECLynxCardEvent, Unit> r2, WindowLayoutType r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        this.q = r2;
        this.r = r3;
        this.s = r4;
        this.h = LazyKt.lazy(new ECLynxCardPresenter$cardPool$2(this));
        this.k = LazyKt.lazy(new ECLynxCardPresenter$windowTabViewModel$2(this));
        this.m = new c(this);
        Delegates r5 = Delegates.INSTANCE;
        this.n = new a(this);
        this.p = LazyKt.lazy(new ECLynxCardPresenter$sharedPrefHelper$2(this));
    }
}
