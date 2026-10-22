package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v extends ECShopBasePresenter {
    public View u;
    public View v;
    public boolean w;

    public static final class a<T> implements Observer {
        public final /* synthetic */ v a;

        public a(v r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (this.a.w == false) goto L6;
            return;
        L6:
            if (r3.booleanValue() == false) goto L8;
            v.q0(this.a);
            return;
        L8:
            v.r0(this.a);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ v a;

        public b(v r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ECStoreTabAreaVO r4 = (ECStoreTabAreaVO) r3;
            if (r4 == null) goto L8;
            List<uj3.j> r1 = r4.b;
            if (r1 == null) goto L8;
            if (r1.isEmpty() != true) goto L8;
        L22:
            v r5 = this.a;
            r5.w = true;
            v.q0(r5);
            return;
        L8:
            com.bytedance.android.shopping.store.home.entity.n r2 = (com.bytedance.android.shopping.store.home.entity.n) this.a.T().getHeaderArea().getValue();
            if (r2 != null) goto L11;
        L12:
            List<uj3.j> r6 = r4.b;
            if (r6 == null) goto L15;
            Integer r7 = Integer.valueOf(r6.size());
        L17:
            if (com.bytedance.android.shopping.extensions.k.f(r7) <= 1) goto L19;
        L23:
            v r8 = this.a;
            r8.w = false;
            v.r0(r8);
            return;
        L19:
            if (Intrinsics.areEqual((Boolean) this.a.T().isBrandShop().getValue(), Boolean.TRUE) == true) goto L22;
            if (this.a.T().isMiddleTabFramework() == false) goto L23;
        L15:
            r7 = null;
            goto L17
        L11:
            if (r2.c() == true) goto L22;
            goto L12
        }
    }

    public v(Fragment r1) {
        super(r1);
    }

    public static final void q0(v r2) {
        View r0 = r2.u;
        if (r0 != null) goto L5;
    L7:
        View r1 = r2.u;
        if (r1 == null) goto L10;
        ExtensionsKt.gone(r1);
    L10:
        View r3 = r2.v;
        if (r3 == null) goto L22;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 != null) goto L15;
    L20:
        r3.requestLayout();
        return;
    L15:
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r4 = null;
    L17:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L20;
        r5.bottomMargin = 0;
        goto L20
    L22:
        return;
    L5:
        if (r0.getVisibility() != 8) goto L7;
    }

    public static final void r0(v r3) {
        View r0 = r3.u;
        if (r0 != null) goto L5;
    L7:
        View r1 = r3.u;
        if (r1 == null) goto L10;
        ExtensionsKt.visible(r1);
    L10:
        View r2 = r3.v;
        if (r2 == null) goto L26;
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if (r4 != null) goto L15;
    L24:
        r2.requestLayout();
        return;
    L15:
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L17;
        r4 = null;
    L17:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L24;
        if (r3.U() == true) goto L22;
        int r6 = r3.e0();
    L23:
        r5.bottomMargin = r6;
        goto L24
    L22:
        r6 = 0;
        goto L23
    L26:
        return;
    L5:
        if (r0.getVisibility() != 0) goto L7;
    }

    public final void A(QModel r4) {
        this.u = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371128));
        this.v = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371057));
        T().isProductListAllShowCrossShop().a(W(), new a(this), false);
        T().getTabArea().a(W(), new b(this), false);
    }
}
