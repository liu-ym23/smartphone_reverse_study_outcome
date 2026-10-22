package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.WindowTabEventReporter;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowFloatGoTopPresenter extends AbsWindowFloatPresenter {
    public final Lazy j;
    public final Function0<Integer> k;

    public static final class a implements h2 {
        public final /* synthetic */ ECWindowFloatGoTopPresenter a;

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void onHidden() {
        }

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void a() {
            this.a.O().doEventAction("store_show_totop", new Pair[]{TuplesKt.to("page_name", "store_page"), TuplesKt.to("click_area", "icon"), TuplesKt.to("author_id", this.a.O().getShopParam().getAuthorId())});
        }

        @Override // com.bytedance.android.window.shop.home.presenter.h2
        public final void onClick() {
            int r0 = WindowTabEventReporter.a;
            ECWindowViewModel r1 = this.a.O();
            ECWindowParam r2 = this.a.O().getShopParam();
            Intrinsics.checkNotNullParameter(r1, "reporter");
            Intrinsics.checkNotNullParameter(r2, "shopParam");
            r1.doEventAction("store_click_totop", WindowTabEventReporter.b(r2), new Pair[0]);
            this.a.O().getGoTopEventReceiver().setValue(new Object());
            this.a.O().getScrollPositionFarEnough().setValue(Boolean.FALSE);
        }

        public a(ECWindowFloatGoTopPresenter r1) {
            this.a = r1;
        }
    }

    public static final class b implements i2 {
        public final /* synthetic */ ECWindowFloatGoTopPresenter a;

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final void c(View r1) {
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.a<WindowCartEntryConfig> e() {
            return null;
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b a() {
            return this.a.O().getScrollState();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b b() {
            return this.a.O().getSelectedTabLocation();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final int d() {
            return ((Number) this.a.k.invoke()).intValue();
        }

        @Override // com.bytedance.android.window.shop.home.presenter.i2
        public final zn.b f() {
            zn.b<Pair<Integer, Integer>> r0 = this.a.O().getOffsetState();
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.common.livedata.ECWindowLiveData<kotlin.Any>");
        }

        public b(ECWindowFloatGoTopPresenter r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowFloatGoTopPresenter a;

        public c(ECWindowFloatGoTopPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.N();
        }
    }

    public final ECWindowViewModel O() {
        return (ECWindowViewModel) this.j.getValue();
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final h2 E() {
        return new a(this);
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final i2 F() {
        return new b(this);
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final boolean D() {
        Boolean r0 = (Boolean) O().getScrollPositionFarEnough().getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public ECWindowFloatGoTopPresenter(Function0<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "getViewHeight");
        this.k = r2;
        this.j = LazyKt.lazy(new ECWindowFloatGoTopPresenter$shopViewModel$2(this));
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsWindowFloatPresenter
    public final void A(QModel r4) {
        this.e = ECQuickUtilKt.b(u(), ECWindowDialogFragment.class);
        super.A(r4);
        O().getScrollPositionFarEnough().a(I(), new c(this), false);
    }
}
