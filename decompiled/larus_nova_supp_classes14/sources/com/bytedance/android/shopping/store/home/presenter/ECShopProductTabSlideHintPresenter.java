package com.bytedance.android.shopping.store.home.presenter;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopProductTabSlideHintPresenter extends ECShopBasePresenter {
    public boolean A;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public TextView x;
    public TextView y;
    public boolean z;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECShopProductTabSlideHintPresenter a;

        public a(ECShopProductTabSlideHintPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            ECShopProductTabSlideHintPresenter.q0(this.a);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopProductTabSlideHintPresenter a;

        public b(ECShopProductTabSlideHintPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            ECShopProductTabSlideHintPresenter.q0(this.a);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopProductTabSlideHintPresenter a;

        public c(ECShopProductTabSlideHintPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.FALSE) == false) goto L5;
            this.a.y().setVisibility(8);
            ECShopProductTabSlideHintPresenter r3 = this.a;
            r3.z = false;
            r3.T().getSlideHintState().setValue(0);
            return;
        L5:
            ECShopProductTabSlideHintPresenter r4 = this.a;
            r4.z = true;
            ECShopProductTabSlideHintPresenter.q0(r4);
        }
    }

    public ECShopProductTabSlideHintPresenter(Fragment r1) {
        super(r1);
        this.u = LazyKt.lazy(ECShopProductTabSlideHintPresenter$slideHintConfig$2.INSTANCE);
        this.v = LazyKt.lazy(new ECShopProductTabSlideHintPresenter$limitNumerator$2(this));
        this.w = LazyKt.lazy(new ECShopProductTabSlideHintPresenter$limitDenominator$2(this));
        this.z = true;
    }

    public static final void q0(ECShopProductTabSlideHintPresenter r8) {
        Integer r0 = (Integer) r8.T().getProductViewsNum().getValue();
        Integer r1 = (Integer) r8.T().getTotalProductNum().getValue();
        dm.a.a("slide_hint_debug").a("viewNums:" + r0 + ",totalNums:" + r1 + ",limitNumerator:" + ((Number) r8.v.getValue()).intValue() + ",limitDenominator:" + ((Number) r8.w.getValue()).intValue() + ",canShowSlideHint:" + r8.z);
        if (r0 == null) goto L32;
        if (r1 == null) goto L32;
        if (r0.intValue() < ((Number) r8.v.getValue()).intValue()) goto L32;
        if (r1.intValue() < ((Number) r8.w.getValue()).intValue()) goto L32;
        if (r8.z == false) goto L32;
        uj3.j r3 = r8.T().getCurrentTab();
        if (r3 != null) goto L14;
    L16:
        r8.y().setVisibility(0);
        r8.T().getSlideHintState().setValue(1);
        TextView r4 = r8.x;
        String r5 = "999+";
        if (r4 != null) goto L19;
    L23:
        TextView r2 = r8.y;
        if (r2 == null) goto L30;
        if (r1.intValue() > 999) goto L28;
        r5 = String.valueOf(r1.intValue());
    L28:
        r2.setText(r5);
    L30:
        if (r8.A == true) goto L34;
        r8.A = true;
        r8.T().doEventAction("show_shop_float_pendant", new Pair[]{TuplesKt.to("type", "slide_progress"), TuplesKt.to("product_view_num", String.valueOf(((Number) r8.v.getValue()).intValue())), TuplesKt.to("product_total_num", String.valueOf(r1.intValue()))});
        return;
    L34:
        return;
    L19:
        if (r0.intValue() > 999) goto L21;
        String r6 = String.valueOf(r0.intValue());
    L22:
        r4.setText(r6);
        goto L23
    L21:
        r6 = "999+";
        goto L22
    L14:
        if ((!r3.i()) != true) goto L16;
    L32:
        r8.y().setVisibility(8);
        r8.T().getSlideHintState().setValue(0);
    }

    public final void A(QModel r4) {
        this.x = (TextView) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131370952));
        this.y = (TextView) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131370950));
        T().getProductViewsNum().a(W(), new a(this), false);
        T().getTotalProductNum().a(W(), new b(this), false);
        T().getCanShowSlideHint().a(W(), new c(this), false);
    }
}
