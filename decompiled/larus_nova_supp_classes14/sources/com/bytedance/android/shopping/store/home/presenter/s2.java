package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.utils.ECImageHelper;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.GenericDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s2 extends ECShopBasePresenter {
    public ECDraweeView u;
    public View v;
    public View w;
    public Boolean x;
    public Boolean y;

    public static final class a<T> implements Observer {
        public final /* synthetic */ s2 a;

        public a(s2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            s2.q0(this.a);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ s2 a;

        public b(s2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            pj3.a r4 = (pj3.a) r3;
            ECDraweeView r0 = this.a.u;
            if (r0 == null) goto L6;
            Lazy r1 = ECImageHelper.a;
            ECImageHelper.b(r0, r4.b);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ s2 a;

        public c(s2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Pair r3 = (Pair) r2;
            Boolean r4 = (Boolean) this.a.T().isBrandShop().getValue();
            Boolean r0 = Boolean.TRUE;
            if (Intrinsics.areEqual(r4, r0) == false) goto L6;
            s2.q0(this.a);
            return;
        L6:
            if (this.a.T().isHomePage() == false) goto L19;
            if (this.a.T().isMiddleTabFramework() == true) goto L19;
            GenericDraweeView r5 = this.a.u;
            if (r5 == null) goto L12;
            r5.setVisibility(8);
        L12:
            View r6 = this.a.w;
            if (r6 == null) goto L15;
            r6.setVisibility(8);
        L15:
            View r7 = this.a.v;
            if (r7 == null) goto L33;
            r7.setVisibility(8);
            return;
        L33:
            return;
        L19:
            if (this.a.T().isHomePage() == false) goto L21;
        L30:
            s2.q0(this.a);
            return;
        L21:
            if (this.a.T().isMiddleTabFramework() == true) goto L30;
            if ((!Intrinsics.areEqual((Boolean) this.a.T().isBrandShop().getValue(), r0)) == false) goto L30;
            View r8 = this.a.w;
            if (r8 == null) goto L27;
            r8.setVisibility(0);
        L27:
            View r9 = this.a.v;
            if (r9 == null) goto L35;
            r9.setVisibility(0);
            return;
        }
    }

    public s2(Fragment r1) {
        super(r1);
    }

    public static final void q0(s2 r5) {
        Boolean r0 = (Boolean) r5.T().isProductListAllShowCrossShop().getValue();
        Boolean r1 = (Boolean) r5.T().isBrandShop().getValue();
        if ((!Intrinsics.areEqual(r0, r5.x)) == false) goto L5;
    L6:
        r5.x = r0;
        r5.y = r1;
        Boolean r2 = (Boolean) r5.T().isProductListAllShowCrossShop().getValue();
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L17;
        GenericDraweeView r4 = r5.u;
        if (r4 == null) goto L11;
        r4.setVisibility(0);
    L11:
        View r6 = r5.w;
        if (r6 == null) goto L14;
        r6.setVisibility(8);
    L14:
        View r7 = r5.v;
        if (r7 == null) goto L46;
        r7.setVisibility(8);
        return;
    L46:
        return;
    L17:
        GenericDraweeView r8 = r5.u;
        if (r8 == null) goto L21;
        r8.setVisibility(8);
    L21:
        if (Intrinsics.areEqual((Boolean) r5.T().isBrandShop().getValue(), r3) == false) goto L28;
        View r9 = r5.w;
        if (r9 == null) goto L25;
        r9.setVisibility(8);
    L25:
        View r10 = r5.v;
        if (r10 == null) goto L48;
        r10.setVisibility(8);
        return;
    L48:
        return;
    L28:
        com.bytedance.android.shopping.store.home.entity.n r11 = (com.bytedance.android.shopping.store.home.entity.n) r5.T().getHeaderArea().getValue();
        if (r11 == null) goto L38;
        com.bytedance.android.shopping.store.home.entity.g r12 = r11.e;
        if (r12 == null) goto L38;
        if (r12.e != true) goto L38;
        View r13 = r5.v;
        if (r13 == null) goto L41;
        r13.setVisibility(0);
    L41:
        View r14 = r5.w;
        if (r14 == null) goto L50;
        r14.setVisibility(0);
        return;
    L50:
        return;
    L38:
        View r15 = r5.v;
        if (r15 == null) goto L41;
        r15.setVisibility(8);
        goto L41
    L5:
        if ((!Intrinsics.areEqual(r5.y, r1)) == true) goto L6;
    }

    public final void A(QModel r4) {
        this.u = (ECDraweeView) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131370970));
        this.w = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371160));
        this.v = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371165));
        T().isProductListAllShowCrossShop().a(W(), new a(this), false);
        T().getCrossShopProductDividerVO().a(W(), new b(this), false);
        T().getSelectedTabLocation().a(W(), new c(this), false);
    }
}
