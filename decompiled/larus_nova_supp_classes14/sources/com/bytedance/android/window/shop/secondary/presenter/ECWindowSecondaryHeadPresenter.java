package com.bytedance.android.window.shop.secondary.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/secondary/presenter/ECWindowSecondaryHeadPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowSecondaryHeadPresenter extends QPresenter implements LifecycleObserver {
    public SimpleDraweeView e;
    public SimpleDraweeView f;
    public TextView g;
    public View h;
    public ECWindowViewModel i;
    public View j;
    public View k;
    public View l;
    public final Lazy m;
    public final Lazy n;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECWindowSecondaryHeadPresenter a;

        public a(ECWindowSecondaryHeadPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r15) {
            uq3.b r16 = (uq3.b) r15;
            ECWindowSecondaryHeadPresenter r0 = this.a;
            View r1 = r0.k;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("headSkeleton");
        L5:
            r1.setVisibility(8);
            SimpleDraweeView r2 = r0.e;
            if (r2 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("backIcon");
        L8:
            r2.setVisibility(0);
            SimpleDraweeView r3 = r0.e;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("backIcon");
        L11:
            r3.setOnClickListener(new b(r0));
            uq3.c r17 = r16.a;
            if (r17 == null) goto L56;
            View r4 = r0.j;
            if (r4 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("authorContainer");
        L17:
            r4.setVisibility(0);
            String r5 = r17.a;
            if (r5 == null) goto L23;
            TextView r6 = r0.g;
            if (r6 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("authorName");
        L22:
            r6.setText(r5);
        L23:
            ECUrlModel r7 = r17.b;
            if (r7 == null) goto L32;
            SimpleDraweeView r8 = r0.f;
            if (r8 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("avatarImg");
        L28:
            ECWindowViewModel r9 = r0.i;
            if (r9 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L31:
            h0.d(r8, r7, r9.getImageCallerContext(), null, null, null, null, 120);
        L32:
            ECWindowViewModel r10 = r0.i;
            if (r10 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L36:
            if (r10.getSecondaryPageParams().c == false) goto L49;
            View r18 = r0.l;
            if (r18 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("nameSuffix");
        L40:
            ViewGroup.LayoutParams r19 = r18.getLayoutParams();
            if ((r19 instanceof ConstraintLayout.LayoutParams) == true) goto L43;
            r19 = null;
        L43:
            ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r19;
            if (r110 == null) goto L56;
            r110.rightToRight = 0;
            r110.setMarginEnd(com.bytedance.android.shopping.extensions.b.b(8));
            View r11 = r0.l;
            if (r11 != null) goto L48;
            Intrinsics.throwUninitializedPropertyAccessException("nameSuffix");
        L48:
            r11.setLayoutParams(r110);
            goto L56
        L49:
            View r12 = r0.h;
            if (r12 != null) goto L52;
            Intrinsics.throwUninitializedPropertyAccessException("entrance");
        L52:
            r12.setVisibility(0);
            View r13 = r0.h;
            if (r13 != null) goto L55;
            Intrinsics.throwUninitializedPropertyAccessException("entrance");
        L55:
            r13.setOnClickListener(new c(r0, r17));
        L56:
            ECWindowSecondaryHeadPresenter.D(this.a).doEventAction("window_secondary_page_show", new Pair[0]);
        }
    }

    public ECWindowSecondaryHeadPresenter() {
        this.m = LazyKt.lazy(new ECWindowSecondaryHeadPresenter$headerContainerView$2(this));
        this.n = LazyKt.lazy(new ECWindowSecondaryHeadPresenter$headerChildView$2(this));
    }

    public static final /* synthetic */ ECWindowViewModel D(ECWindowSecondaryHeadPresenter r1) {
        ECWindowViewModel r2 = r1.i;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r2;
    }

    public final void A(QModel r4) {
        View r5 = (View) this.n.getValue();
        this.i = u().f(ECWindowViewModel.class);
        this.e = w().b(2131371338).f();
        this.f = w().b(2131371336).f();
        this.g = (TextView) w().b(2131371341).f();
        this.l = w().b(2131371342).f();
        this.h = w().b(2131371340).f();
        this.j = w().b(2131371335).f();
        View r6 = w().b(2131371345).f();
        this.k = r6;
        r6.setBackgroundResource(2131234919);
        ECWindowViewModel r7 = this.i;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r7.getSecondaryPageParams().f.a(u().e(), new a(this), false);
    }
}
