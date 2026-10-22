package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o0 extends ECShopBasePresenter {
    public final b A;
    public View u;
    public View v;
    public View w;
    public View x;
    public SimpleDraweeView y;
    public int z;

    public static final class a {
    }

    public static final class b implements vi3.a {
        public final /* synthetic */ o0 a;

        public b(o0 r1) {
            this.a = r1;
        }

        @Override // vi3.a
        public final void a(ShopContainerType r3, vi3.c r4) {
            Intrinsics.checkNotNullParameter(r3, "shopContainerType");
            Intrinsics.checkNotNullParameter(r4, "containerConfig");
            if (r3 != ShopContainerType.SHOP_INFO_CONTAINER) goto L27;
            o0 r5 = this.a;
            int r6 = r4.a();
            if (r6 > 0) goto L7;
            r5.getClass();
            return;
        L7:
            if (r6 == r5.z) goto L30;
            r5.z = r6;
            r5.s0();
            View r0 = r5.w;
            if (r0 == null) goto L14;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if (r1 == null) goto L14;
            r1.height = r5.n0();
        L14:
            SimpleDraweeView r2 = r5.y;
            if (r2 == null) goto L19;
            ViewGroup.LayoutParams r7 = r2.getLayoutParams();
            if (r7 == null) goto L19;
            r7.height = r5.n0();
        L19:
            View r8 = r5.v;
            if (r8 == null) goto L28;
            ViewGroup.LayoutParams r9 = r8.getLayoutParams();
            if (r9 == null) goto L24;
            r9.height = r6;
        L24:
            r8.requestLayout();
            return;
        L28:
            return;
        L30:
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ o0 a;

        public c(o0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            com.bytedance.android.shopping.store.home.entity.n r3 = (com.bytedance.android.shopping.store.home.entity.n) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (r3.d() == false) goto L9;
            this.a.y().setVisibility(8);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ o0 a;

        public d(o0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Float r2 = (Float) r1;
            o0.q0(this.a);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ o0 a;

        public e(o0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Pair r2 = (Pair) r1;
            o0.q0(this.a);
        }
    }

    static {
    }

    public final void s0() {
        if (this.z > 0) goto L5;
        return;
    L5:
        float r1 = 1.0f - a0(0.5f);
        float r0 = h0();
        int r2 = (int) (r0 - (r1 * r0));
        View r3 = this.v;
        if (r3 == null) goto L8;
        r3.setPadding(0, r2, 0, 0);
    L8:
        View r4 = this.u;
        if (r4 == null) goto L13;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L13;
        r5.height = this.z - r2;
    L13:
        View r6 = this.x;
        if (r6 == null) goto L18;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L18;
        r7.height = this.z - r2;
    L18:
        View r8 = this.v;
        if (r8 == null) goto L22;
        r8.requestLayout();
        return;
    }

    public o0(Fragment r1) {
        super(r1);
        this.A = new b(this);
    }

    public static final void q0(o0 r8) {
        float r0 = r8.Z();
        boolean r1 = r8.p0();
        if (r0 < 0) goto L48;
        float r5 = (1.0f - r0) * 12.0f;
        if (r8.U() == false) goto L49;
        View r3 = r8.u;
        if (r3 == null) goto L11;
        qc3.a.i(r3, r5, r5);
    L11:
        View r4 = r8.x;
        if (r4 == null) goto L14;
        r4.setVisibility(0);
    L14:
        if (r1 == false) goto L19;
        Integer r6 = (Integer) r8.T().getBigSalePicFinalColor().getValue();
        if (r6 == null) goto L18;
        int r7 = r6.intValue();
        r8.r0(r5, 16777215 & r7, r7);
    L20:
        r8.s0();
        if (r1 == false) goto L38;
        ECUrlModel r2 = r8.c0();
        if (r2 != null) goto L25;
    L35:
        View r9 = r8.w;
        if (r9 == null) goto L45;
        r9.setVisibility(8);
        return;
    L45:
        return;
    L25:
        if (r0 >= 1.0f) goto L29;
        SimpleDraweeView r10 = r8.y;
        if (r10 == null) goto L32;
        r10.setVisibility(0);
    L32:
        SimpleDraweeView r11 = r8.y;
        if (r11 == null) goto L35;
        ECShopBasePresenter.Y(r8, r11, r2);
        goto L35
    L29:
        SimpleDraweeView r12 = r8.y;
        if (r12 == null) goto L32;
        r12.setVisibility(8);
        goto L32
    L38:
        View r13 = r8.w;
        if (r13 == null) goto L41;
        r13.setVisibility(0);
    L41:
        View r14 = r8.w;
        if (r14 == null) goto L47;
        GradientDrawable r15 = new GradientDrawable();
        qc3.a.f(r15, r8.T().getBackgroundColorArray());
        Unit r16 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r14, "$this$setBackgroundCompat");
        r14.setBackground(r15);
        return;
    L47:
        return;
    L18:
        r8.T().getBigSalePicFinalColor().a(r8.W(), new p0(r8, r5), false);
        goto L20
    L19:
        r8.r0(r5, 16119545, (int) 4294309625L);
        goto L20
    L49:
        return;
    }

    public final void A(QModel r10) {
        T().getHeaderArea().a(W(), new c(this), false);
        this.u = y();
        ViewParent r11 = y().getParent();
        if ((r11 instanceof ViewGroup) == true) goto L5;
        r11 = null;
    L5:
        this.v = (ViewGroup) r11;
        this.w = w().b(2131371051).f();
        this.x = w().b(2131371050).f();
        this.y = w().b(2131371049).f();
        ECStoreViewModel.registerContainerSizeChangeListener$default(T(), ShopContainerType.SHOP_INFO_CONTAINER, this.A, false, 4, null);
        T().getCollapseFactor().a(W(), new d(this), false);
        T().getSelectedTabLocation().d(W(), new e(this));
    }

    public final void r0(float r5, int r6, int r7) {
        View r0 = this.x;
        if (r0 == null) goto L6;
        GradientDrawable r1 = new GradientDrawable();
        qc3.a.f(r1, new int[]{r6, r7});
        r1.setCornerRadii(qc3.a.b(r5, r5, 0.0f, 0.0f));
        Unit r8 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "$this$setBackgroundCompat");
        r0.setBackground(r1);
        return;
    }
}
