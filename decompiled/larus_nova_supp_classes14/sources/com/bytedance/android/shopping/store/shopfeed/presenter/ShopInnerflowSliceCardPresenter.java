package com.bytedance.android.shopping.store.shopfeed.presenter;

import androidx.fragment.app.Fragment;
import cf.o;
import com.bytedance.android.ec.common.api.IPageStateService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.view.ECShopVideoPlayerView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.bytedance.android.shopping.store.slicecard.viewmanager.l;
import com.bytedance.android.shopping.store.slicecard.viewmanager.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopInnerflowSliceCardPresenter extends QPresenter {
    public final Lazy e;
    public com.bytedance.android.shopping.store.shopfeed.list.c f;
    public String g;
    public cf.k h;
    public ECShopVideoPlayerView i;
    public b j;
    public c k;
    public final Lazy l;
    public final a m;
    public final Fragment n;
    public final com.bytedance.android.shopping.store.hybridproduct.holder.e o;

    public static final class a implements o {
        public final /* synthetic */ ShopInnerflowSliceCardPresenter a;

        public final void c() {
        }

        public final void d(int r1, int r2, float r3) {
        }

        public final void e() {
        }

        public final void f() {
        }

        public final void g() {
        }

        public final void onCreate() {
        }

        public final void onDestroy() {
        }

        public final void onPause() {
        }

        public final void onResume() {
        }

        public final void onStart() {
        }

        public final void onStop() {
        }

        public final void b() {
            ECShopVideoPlayerView r0 = this.a.i;
            if (r0 == null) goto L6;
            r0.b("resume");
            return;
        }

        public a(ShopInnerflowSliceCardPresenter r1) {
            this.a = r1;
        }

        public final void a(boolean r2) {
            if (r2 == false) goto L6;
            ECShopVideoPlayerView r3 = this.a.i;
            if (r3 == null) goto L10;
            r3.b("pause");
            return;
        L10:
            return;
        L6:
            ECShopVideoPlayerView r4 = this.a.i;
            if (r4 == null) goto L12;
            r4.b("resume");
            return;
        }
    }

    public static final class b implements com.bytedance.android.ecom.arch.slice.render.context.a {
        public final /* synthetic */ ShopInnerflowSliceCardPresenter a;

        public b(ShopInnerflowSliceCardPresenter r1) {
            this.a = r1;
        }

        public final void a(SlcTemplateContext r2, String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r2, "templateContext");
            if (Intrinsics.areEqual(r3, this.a.g) == false) goto L18;
            ShopInnerflowSliceCardPresenter r5 = this.a;
            r r6 = r5.o.a;
            ECShopVideoPlayerView r7 = null;
            if (r6 == null) goto L9;
            SlcTemplateContext r8 = r6.b;
            if (r8 == null) goto L9;
            BaseSlcViewManager r9 = r8.h("shop_replay_video_player");
        L11:
            if ((r9 instanceof l) == true) goto L13;
            r9 = null;
        L13:
            l r10 = (l) r9;
            if (r10 == null) goto L16;
            r7 = (ECShopVideoPlayerView) r10.k1();
        L16:
            r5.i = r7;
            return;
        L9:
            r9 = null;
            goto L11
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ShopInnerflowSliceCardPresenter a;

        public c(ShopInnerflowSliceCardPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Double r6 = (Double) r5;
            dm.a.b r0 = dm.a.a("slice播控");
            StringBuilder r1 = new StringBuilder("exposure_percent_");
            com.bytedance.android.shopping.store.shopfeed.list.c r2 = this.a.f;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("currentItem");
        L5:
            r1.append(r2.g);
            r1.append(':');
            r1.append(r6);
            r0.a(r1.toString());
            com.bytedance.android.shopping.store.shopfeed.list.c r3 = this.a.f;
            if (r3 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("currentItem");
        L8:
            Map<String, Object> r4 = r3.e;
            if (r4 == null) goto L11;
            r4.putAll(this.a.D().getSliceService().a());
            r4.put("exposure_percent", r6);
        L11:
            ShopInnerflowSliceCardPresenter r7 = this.a;
            r r8 = r7.o.a;
            if (r8 == null) goto L18;
            com.bytedance.android.shopping.store.shopfeed.list.c r9 = r7.f;
            if (r9 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("currentItem");
        L16:
            r8.a(r9.b(), this.a.g);
            return;
        }
    }

    public final ECShopFeedViewModel D() {
        return (ECShopFeedViewModel) this.e.getValue();
    }

    public final void C() {
        b r0 = this.j;
        if (r0 == null) goto L5;
        D().getSliceService().h(r0);
    L5:
        this.j = null;
        c r1 = this.k;
        if (r1 == null) goto L8;
        this.o.b.b(r1);
    L8:
        this.k = null;
        cf.k r2 = this.h;
        if (r2 == null) goto L11;
        r2.remove();
    L11:
        this.h = null;
        ECShopVideoPlayerView r3 = this.i;
        if (r3 == null) goto L14;
        r3.setPlayStatus("stop");
    L14:
        this.i = null;
    }

    public final void A(QModel r6) {
        b r0 = this.j;
        if (r0 == null) goto L5;
        D().getSliceService().h(r0);
    L5:
        BaseSlcViewManager r1 = null;
        this.j = null;
        c r2 = this.k;
        if (r2 == null) goto L8;
        this.o.b.b(r2);
    L8:
        this.k = null;
        if ((r6 instanceof com.bytedance.android.shopping.store.shopfeed.list.c) == true) goto L11;
        QModel r3 = null;
    L13:
        if (((com.bytedance.android.shopping.store.shopfeed.list.c) r3) != null) goto L15;
        return;
    L15:
        if (r6 == null) goto L45;
        com.bytedance.android.shopping.store.shopfeed.list.c r7 = (com.bytedance.android.shopping.store.shopfeed.list.c) r6;
        this.f = r7;
        Map<String, Object> r4 = r7.e;
        if (r4 == null) goto L19;
        r4.putAll(D().getSliceService().a());
        r4.put("index", Integer.valueOf(r7.g));
        r4.put("exposure_percent", 0);
        r4.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r4.put("play_status", "stop");
    L19:
        Map<String, Object> r5 = r7.b();
        r r8 = this.o.a;
        if (r8 == null) goto L22;
        r8.b((ShopInnerflowSliceCardPresenter$actionHandler$2.a) this.l.getValue());
    L22:
        this.g = r7.f + "_" + r7.g;
        b r9 = new b(this);
        D().getSliceService().f(r9);
        Unit r10 = Unit.INSTANCE;
        this.j = r9;
        r r11 = this.o.a;
        if (r11 == null) goto L25;
        r11.a(r5, this.g);
    L25:
        c r12 = new c(this);
        this.o.b.a(u().e(), r12, false);
        this.k = r12;
        int r13 = ECSdk.a;
        IPageStateService r14 = (IPageStateService) ECSdk.a(IPageStateService.class);
        if (r14 == null) goto L28;
        cf.k r15 = r14.setPageStateListener(this.m);
    L29:
        this.h = r15;
        r r16 = this.o.a;
        if (r16 == null) goto L34;
        SlcTemplateContext r17 = r16.b;
        if (r17 == null) goto L34;
        BaseSlcViewManager r18 = r17.h("shop_replay_progress_bar");
    L36:
        if ((r18 instanceof m) == false) goto L39;
        r1 = r18;
    L39:
        final m r19 = (m) r1;
        if (r19 != null) goto L42;
        return;
    L42:
        if (r19.k1() == null) goto L47;
        Function1<Float, Unit> r20 = new ShopInnerflowSliceCardPresenter$mayHandlerProgressBarEvent$$inlined$apply$lambda$1(r19, this);
        Function1<Float, Unit> r21 = new ShopInnerflowSliceCardPresenter$mayHandlerProgressBarEvent$$inlined$apply$lambda$2(r19, this);
        Intrinsics.checkNotNullParameter(r20, "speedButtonClickListener");
        Intrinsics.checkNotNullParameter(r21, "seekBarChangeListener");
        return;
    L47:
        return;
    L34:
        r18 = null;
        goto L36
    L28:
        r15 = null;
        goto L29
    L45:
        return;
    L11:
        r3 = r6;
        goto L13
    }

    public ShopInnerflowSliceCardPresenter(Fragment r2, com.bytedance.android.shopping.store.hybridproduct.holder.e r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewInfoProxy");
        this.n = r2;
        this.o = r3;
        this.e = LazyKt.lazy(new ShopInnerflowSliceCardPresenter$viewModel$2(this));
        this.g = "";
        this.l = LazyKt.lazy(new ShopInnerflowSliceCardPresenter$actionHandler$2(this));
        this.m = new a(this);
    }
}
