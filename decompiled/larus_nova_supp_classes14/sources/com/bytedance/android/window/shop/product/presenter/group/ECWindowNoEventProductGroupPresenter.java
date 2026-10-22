package com.bytedance.android.window.shop.product.presenter.group;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.widget.product.WindowFollowCouponTagView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import sq3.h;
import yo.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowNoEventProductGroupPresenter extends ECWindowProductCardGroupPresenterBase {
    public static final /* synthetic */ int z = 0;
    public final Lazy x;
    public final WindowLayoutType y;

    public static final class a implements g {
        public a() {
        }

        public final void b(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void g(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
        }

        public final void c(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void d(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void e(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void f(WindowFollowCouponTagView r2) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r2, "tag");
        }

        public final void h(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void i(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void j(WindowV2ProductItemVO r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public final void k(h r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r2, "item");
        }
    }

    public static final class b implements yo.h {
        public final /* synthetic */ ECWindowNoEventProductGroupPresenter a;

        public final String a() {
            return null;
        }

        public final Function3<String, String, Long, Unit> b() {
            return null;
        }

        public final String d() {
            return null;
        }

        public final Function1<Integer, Unit> e() {
            return null;
        }

        public final ap.c f() {
            return null;
        }

        public final void g() {
        }

        public final boolean isClickable() {
            return false;
        }

        public final WindowLayoutTypes c() {
            WindowLayoutType r0 = this.a.y;
            if (r0 != null) goto L5;
        L7:
            WindowLayoutType r1 = this.a.y;
            if (r1 == null) goto L13;
            if (r1.isDoubleColumn() != true) goto L13;
            return WindowLayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        L13:
            return WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        L5:
            if (r0.isSingleColumn() != true) goto L7;
            return WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        }

        public final r h() {
            int r0 = r.h;
            return r.a.d("ec_window_home_product_card");
        }

        public b(ECWindowNoEventProductGroupPresenter r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.window.shop.product.presenter.group.ECWindowProductCardGroupPresenterBase
    public final BaseWindowTabViewModel n0() {
        return (BaseWindowTabViewModel) this.x.getValue();
    }

    @Override // com.bytedance.android.window.shop.product.presenter.group.ECWindowProductCardGroupPresenterBase
    public final g e0() {
        return new a();
    }

    @Override // com.bytedance.android.window.shop.product.presenter.group.ECWindowProductCardGroupPresenterBase
    public final yo.h h0() {
        return new b(this);
    }

    public ECWindowNoEventProductGroupPresenter(final Fragment r2, WindowLayoutType r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, null);
        this.y = r3;
        this.x = LazyKt.lazy(new ECWindowNoEventProductGroupPresenter$tabViewModel$2(this, r2));
    }
}
