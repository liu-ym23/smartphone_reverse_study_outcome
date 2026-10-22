package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowFloatCartEntryPresenter extends AbsWindowFloatPresenter {
    public final Lazy j;
    public final Function0<Integer> k;

    public static final class a implements h2 {
        public final /* synthetic */ ECWindowFloatCartEntryPresenter a;

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void onHidden() {
        }

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void a() {
            ECWindowFloatCartEntryPresenter.O(this.a).doEventAction("show_cart_entrance", new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to("click_area", "icon"), TuplesKt.to("author_id", ECWindowFloatCartEntryPresenter.O(this.a).getShopParam().getAuthorId())});
        }

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void onClick() {
            ECWindowFloatCartEntryPresenter.O(this.a).doEventAction("click_cart_entrance", new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to("click_area", "icon"), TuplesKt.to("author_id", ECWindowFloatCartEntryPresenter.O(this.a).getShopParam().getAuthorId())});
        }

        public a(ECWindowFloatCartEntryPresenter r1) {
            this.a = r1;
        }
    }

    public static final class b implements i2 {
        public final /* synthetic */ ECWindowFloatCartEntryPresenter a;

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b a() {
            return ECWindowFloatCartEntryPresenter.O(this.a).getScrollState();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b b() {
            return ECWindowFloatCartEntryPresenter.O(this.a).getSelectedTabLocation();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final int d() {
            return ((Number) this.a.k.invoke()).intValue();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.a<WindowCartEntryConfig> e() {
            return ECWindowFloatCartEntryPresenter.O(this.a).getCartEntryConfig();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b f() {
            zn.b<Pair<Integer, Integer>> r0 = ECWindowFloatCartEntryPresenter.O(this.a).getOffsetState();
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.common.livedata.ECWindowLiveData<kotlin.Any>");
        }

        public b(ECWindowFloatCartEntryPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final void c(View r3) {
            ECWindowFloatCartEntryPresenter.O(this.a).getDestView().setValue(new WeakReference(r3));
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowFloatCartEntryPresenter a;

        public c(ECWindowFloatCartEntryPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            WindowCartEntryConfig r6 = (WindowCartEntryConfig) r5;
            ECWindowFloatCartEntryPresenter r0 = this.a;
            boolean r1 = false;
            if (r6 == null) goto L13;
            String r2 = r6.getJumpUrl();
            if (r2 != null) goto L7;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == true) goto L13;
            r1 = true;
            goto L13
        L7:
            if (StringsKt.isBlank(r2) == true) goto L10;
            r3 = false;
        L13:
            r0.h = Boolean.valueOf(r1);
            Boolean r4 = this.a.h;
            Intrinsics.checkNotNull(r4);
            if (r4.booleanValue() == false) goto L17;
            this.a.N();
            this.a.y().setOnClickListener(new u0(this, r6));
            return;
        }
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final boolean D() {
        return true;
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final h2 E() {
        return new a(this);
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final i2 F() {
        return new b(this);
    }

    public ECWindowFloatCartEntryPresenter(Function0<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "getViewHeight");
        this.k = r2;
        this.j = LazyKt.lazy(new ECWindowFloatCartEntryPresenter$viewModel$2(this));
    }

    public static final ECWindowViewModel O(ECWindowFloatCartEntryPresenter r0) {
        return (ECWindowViewModel) r0.j.getValue();
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final void A(QModel r4) {
        this.e = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        super.A(r4);
        zn.a<WindowCartEntryConfig> r5 = G().e();
        if (r5 == null) goto L6;
        r5.a(I(), new c(this), false);
        return;
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final void K(int r2) {
        if (r2 != 0) goto L4;
        G().c(y());
        return;
    L4:
        G().c(null);
    }
}
