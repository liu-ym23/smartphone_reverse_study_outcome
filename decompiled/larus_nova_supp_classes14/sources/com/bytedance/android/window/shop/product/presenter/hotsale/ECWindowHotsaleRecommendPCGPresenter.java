package com.bytedance.android.window.shop.product.presenter.hotsale;

import androidx.fragment.app.Fragment;
import ap.c;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import sq3.f;
import yo.g;
import yo.h;
import yo.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowHotsaleRecommendPCGPresenter extends j {
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final ECWindowHotsaleRecommendPCGPresenter$behaviorAdapter$1 q;
    public final a r;

    public static final class a implements h {
        public final /* synthetic */ ECWindowHotsaleRecommendPCGPresenter a;

        public final Function3<String, String, Long, Unit> b() {
            return null;
        }

        public final Function1<Integer, Unit> e() {
            return null;
        }

        public final void g() {
        }

        public final boolean isClickable() {
            return true;
        }

        public final String a() {
            return ECWindowHotsaleRecommendPCGPresenter.k0(this.a).getShopParam().getAuthorId();
        }

        public final String d() {
            return ECWindowHotsaleRecommendPCGPresenter.k0(this.a).getShopParam().getSecAuthorId();
        }

        public final c f() {
            return ECWindowHotsaleRecommendPCGPresenter.k0(this.a).getTagPools();
        }

        public final r h() {
            int r0 = r.h;
            return r.a.d("ec_window_hotsale_recommend_card");
        }

        public final WindowLayoutTypes c() {
            return WindowLayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        }

        public a(ECWindowHotsaleRecommendPCGPresenter r1) {
            this.a = r1;
        }
    }

    public final g e0() {
        return this.q;
    }

    public final h h0() {
        return this.r;
    }

    public ECWindowHotsaleRecommendPCGPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.n = LazyKt.lazy(new ECWindowHotsaleRecommendPCGPresenter$shopViewModel$2(this));
        this.o = LazyKt.lazy(new ECWindowHotsaleRecommendPCGPresenter$tabViewModel$2(this));
        this.p = LazyKt.lazy(new ECWindowHotsaleRecommendPCGPresenter$btmHost$2(this));
        this.q = new ECWindowHotsaleRecommendPCGPresenter$behaviorAdapter$1(this);
        this.r = new a(this);
    }

    public static final ECWindowViewModel k0(ECWindowHotsaleRecommendPCGPresenter r0) {
        return (ECWindowViewModel) r0.n.getValue();
    }

    public final QModel j0(QModel r3) {
        if ((r3 instanceof f) == true) goto L5;
        r3 = null;
    L5:
        f r4 = (f) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.j;
    }
}
