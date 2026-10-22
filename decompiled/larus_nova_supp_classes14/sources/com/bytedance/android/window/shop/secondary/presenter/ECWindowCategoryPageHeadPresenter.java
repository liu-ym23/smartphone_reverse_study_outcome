package com.bytedance.android.window.shop.secondary.presenter;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/secondary/presenter/ECWindowCategoryPageHeadPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowCategoryPageHeadPresenter extends QPresenter implements LifecycleObserver {
    public final Lazy e;
    public final Lazy f;
    public ECWindowViewModel g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECWindowCategoryPageHeadPresenter a;

        public a(ECWindowCategoryPageHeadPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            uq3.b r6 = (uq3.b) r5;
            final ECWindowCategoryPageHeadPresenter r7 = this.a;
            SimpleDraweeView r0 = (SimpleDraweeView) r7.e.getValue();
            if (r0 == null) goto L5;
            r0.setVisibility(0);
        L5:
            SimpleDraweeView r1 = (SimpleDraweeView) r7.e.getValue();
            if (r1 == null) goto L8;
            r1.setOnClickListener(new com.bytedance.android.window.shop.secondary.presenter.a(r7));
        L8:
            View r2 = (View) r7.f.getValue();
            if (r2 == null) goto L11;
            f.c(r2, null, null, new ECWindowCategoryPageHeadPresenter$initViews$2(r7), 3);
        L11:
            ECWindowViewModel r8 = this.a.g;
            if (r8 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L14:
            r8.doEventAction("window_secondary_page_show", new Pair[0]);
        }
    }

    public ECWindowCategoryPageHeadPresenter() {
        this.e = LazyKt.lazy(new ECWindowCategoryPageHeadPresenter$backIcon$2(this));
        this.f = LazyKt.lazy(new ECWindowCategoryPageHeadPresenter$searchIcon$2(this));
        this.h = LazyKt.lazy(new ECWindowCategoryPageHeadPresenter$headSkeleton$2(this));
        this.i = LazyKt.lazy(new ECWindowCategoryPageHeadPresenter$headerContainerView$2(this));
        this.j = LazyKt.lazy(new ECWindowCategoryPageHeadPresenter$headerChildView$2(this));
    }

    public final void A(QModel r4) {
        this.g = u().f(ECWindowViewModel.class);
        View r5 = (View) this.j.getValue();
        if (r5 == null) goto L16;
        TextView r6 = (TextView) r5.findViewById(2131371346);
        if (r6 == null) goto L16;
        ECWindowViewModel r1 = this.g;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        Uri r2 = r1.getSecondaryPageParams().b;
        if (r2 == null) goto L12;
        String r3 = UriProtector.getQueryParameter(r2, "category_name");
    L13:
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r6.setText(r3);
        goto L16
    L12:
        r3 = null;
    L16:
        ECWindowViewModel r7 = this.g;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        r7.getSecondaryPageParams().f.a(u().e(), new a(this), false);
    }
}
