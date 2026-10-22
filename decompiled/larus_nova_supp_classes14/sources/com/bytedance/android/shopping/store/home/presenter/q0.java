package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q0 extends ECShopBasePresenter implements View.OnClickListener {
    public View u;
    public View v;
    public final float w;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ q0 a;

        public b(q0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            StoreV3LiveRoomVO r3 = (StoreV3LiveRoomVO) r2;
            View r4 = this.a.v;
            if (r4 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("liveTipsContainer");
        L6:
            if (this.a.D() == false) goto L8;
            int r0 = 0;
        L9:
            r4.setVisibility(r0);
            return;
        L8:
            r0 = 8;
            goto L9
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ q0 a;

        public c(q0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ShopHeaderVideoVO r3 = (ShopHeaderVideoVO) r2;
            View r4 = this.a.v;
            if (r4 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("liveTipsContainer");
        L6:
            if (this.a.D() == false) goto L8;
            int r0 = 0;
        L9:
            r4.setVisibility(r0);
            return;
        L8:
            r0 = 8;
            goto L9
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ q0 a;

        public d(q0 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Float r5 = (Float) r4;
            q0 r6 = this.a;
            View r0 = r6.u;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("infoGroupArea");
        L5:
            Drawable r1 = r0.getBackground();
            if ((r1 instanceof GradientDrawable) == true) goto L8;
            r1 = null;
        L8:
            GradientDrawable r2 = (GradientDrawable) r1;
            if (r2 == null) goto L12;
            float r3 = (1.0f - r6.a0(0.5f)) * r6.w;
            r2.setCornerRadii(qc3.a.b(r3, r3, 0.0f, 0.0f));
            return;
        }
    }

    public static final class e implements View.OnLayoutChangeListener {
        public final /* synthetic */ q0 a;

        public e(q0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            ECStoreViewModel r10 = this.a.T();
            ShopContainerType r11 = ShopContainerType.SHOP_INFO_CONTAINER;
            vi3.c r12 = new vi3.c(r1.getLayoutParams().width, r1.getLayoutParams().height);
            r12.a = r1.getHeight();
            r12.b = r1.getWidth();
            Unit r13 = Unit.INSTANCE;
            r10.updateContainer(r11, r12);
        }
    }

    static {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    public q0(Fragment r1) {
        super(r1);
        this.w = 12.0f;
    }

    public final void A(QModel r4) {
        this.u = y();
        this.v = w().b(2131371095).f();
        T().getLiveInfo().a(W(), new b(this), false);
        T().getVideoInfo().a(W(), new c(this), false);
        T().getCollapseFactor().a(W(), new d(this), false);
        y().addOnLayoutChangeListener(new e(this));
    }
}
