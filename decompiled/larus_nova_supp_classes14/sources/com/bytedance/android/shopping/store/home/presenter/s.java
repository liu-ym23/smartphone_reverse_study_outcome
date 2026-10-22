package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s extends ECShopBasePresenter {
    public static final /* synthetic */ int E = 0;
    public final float A;
    public int B;
    public int C;
    public final a D;
    public ViewGroup u;
    public ECDraweeView v;
    public View w;
    public View x;
    public View y;
    public SimpleDraweeView z;

    public static final class a implements vi3.a {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        @Override // vi3.a
        public final void a(ShopContainerType r3, vi3.c r4) {
            Intrinsics.checkNotNullParameter(r3, "shopContainerType");
            Intrinsics.checkNotNullParameter(r4, "containerConfig");
            if (r3 != ShopContainerType.SHOP_TOPBAR_CONTAINER) goto L6;
            s r5 = this.a;
            r5.B = r4.a();
        L8:
            s r6 = this.a;
            View r7 = r6.x;
            if (r7 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundWrapperWithoutTips");
        L11:
            s.q0(r7, r6.B);
            int r8 = r6.B + r6.C;
            SimpleDraweeView r0 = r6.z;
            if (r0 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundView");
        L14:
            s.q0(r0, r8);
            View r9 = r6.y;
            if (r9 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundWithoutTipsMask");
        L17:
            s.q0(r9, r8);
            return;
        L6:
            if (r3 != ShopContainerType.SHOP_INFO_CONTAINER) goto L8;
            s r10 = this.a;
            r10.C = r4.a();
            goto L8
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ s a;

        public b(s r1) {
            this.a = r1;
        }

        public final void onChanged(Object r14) {
            if (((com.bytedance.android.shopping.store.home.entity.n) r14).d() == false) goto L5;
            this.a.y().setVisibility(8);
            return;
        L5:
            s r15 = this.a;
            View r1 = r15.o0();
            r15.u = (ViewGroup) r15.w().b(2131371046).f();
            r15.v = (ECDraweeView) r15.w().b(2131371039).f();
            r15.w = r15.w().b(2131371040).f();
            r15.z = r1.findViewById(2131371162);
            r15.y = r1.findViewById(2131371163);
            r15.x = r1.findViewById(2131371164);
            s r16 = this.a;
            ECUrlModel r2 = r16.c0();
            if (r2 == null) goto L12;
            SimpleDraweeView r3 = r16.z;
            if (r3 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundView");
        L10:
            ECShopBasePresenter.Y(r16, r3, r2);
        L12:
            if (r2 == null) goto L17;
            ECDraweeView r4 = r16.v;
            if (r4 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("background");
        L16:
            ECShopBasePresenter.Y(r16, r4, r2);
        L17:
            if (r2 == null) goto L19;
            com.bytedance.android.ec.core.utils.p1 r5 = com.bytedance.android.ec.core.utils.p1.d;
            String r6 = r2.getFirstUrl();
            ECShopBackgroundV2Presenter$bindBackgroundImg$3$1 r7 = ECShopBackgroundV2Presenter$bindBackgroundImg$3$1.INSTANCE;
            r5.getClass();
            com.bytedance.android.ec.core.utils.p1.f(r6, r7);
        L19:
            GradientDrawable r8 = new GradientDrawable();
            qc3.a.f(r8, r16.T().getBackgroundColorArray());
            qc3.a.g(r8, GradientDrawable.Orientation.RIGHT_LEFT);
            View r9 = r16.y;
            if (r9 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundWithoutTipsMask");
        L22:
            qc3.a.e(r9, r8);
            ViewGroup r10 = r16.u;
            if (r10 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("backgroundWrapper");
        L25:
            qc3.a.e(r10, r8);
            View r11 = r16.w;
            if (r11 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("bottomToTopGradient");
        L28:
            GradientDrawable r12 = new GradientDrawable();
            qc3.a.f(r12, new int[]{16119545, (int) 4294309625L});
            qc3.a.g(r12, GradientDrawable.Orientation.TOP_BOTTOM);
            Unit r13 = Unit.INSTANCE;
            qc3.a.e(r11, r12);
            if (r2 == null) goto L43;
            View r17 = r16.w;
            if (r17 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("bottomToTopGradient");
        L33:
            r17.setVisibility(4);
            GenericDraweeView r18 = r16.v;
            if (r18 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("background");
        L36:
            r18.setVisibility(0);
            SimpleDraweeView r19 = r16.z;
            if (r19 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundView");
        L39:
            r19.setVisibility(0);
            View r110 = r16.y;
            if (r110 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundWithoutTipsMask");
        L42:
            r110.setVisibility(8);
        L43:
            ECStoreViewModel.registerContainerSizeChangeListener$default(this.a.T(), ShopContainerType.SHOP_TOPBAR_CONTAINER, this.a.D, false, 4, null);
            ECStoreViewModel.registerContainerSizeChangeListener$default(this.a.T(), ShopContainerType.SHOP_INFO_CONTAINER, this.a.D, false, 4, null);
            this.a.T().getCollapseFactor().a(this.a.W(), new t(this), false);
        }
    }

    public s(Fragment r1) {
        super(r1);
        this.A = 0.5f;
        this.D = new a(this);
    }

    public final void A(QModel r4) {
        T().getHeaderArea().a(W(), new b(this), false);
    }

    public static void q0(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$changeHeight");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 != null) goto L5;
    L6:
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if (r3 == null) goto L9;
        r3.height = r2;
    L9:
        r1.requestLayout();
        return;
    L5:
        if (r0.height != r2) goto L6;
    }
}
