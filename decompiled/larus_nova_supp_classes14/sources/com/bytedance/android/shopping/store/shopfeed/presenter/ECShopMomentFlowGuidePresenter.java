package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopMomentFlowGuidePresenter extends QPresenter {
    public static final /* synthetic */ int m = 0;
    public final Lazy e;
    public final Handler f;
    public FrameLayout g;
    public LottieAnimationView h;
    public TextView i;
    public final Lazy j;
    public final Lazy k;
    public final Fragment l;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopMomentFlowGuidePresenter a;

        public b(ECShopMomentFlowGuidePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r14) {
            if (((LoadStatus) r14) != LoadStatus.InitializeSuccess) goto L21;
            ECShopMomentFlowGuidePresenter r15 = this.a;
            r15.getClass();
            long r0 = System.currentTimeMillis();
            q r2 = q.a;
            long r3 = q.f("shop_moment_flow_guide_last_show_time");
            if (q.f("shop_moment_flow_guide_show_count") < 3) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == false) goto L22;
            long r4 = System.currentTimeMillis();
            long r5 = q.f("shop_moment_flow_guide_show_count");
            q.h("shop_moment_flow_guide_last_show_time", r4);
            q.h("shop_moment_flow_guide_show_count", r5 + 1);
            FrameLayout r6 = r15.g;
            if (r6 == null) goto L15;
            r6.setVisibility(0);
        L15:
            View r7 = th.a.c(r15.u().c(), 2131560916, r15.g, false);
            LottieAnimationView r8 = r7.findViewById(2131386261);
            if (r8 == null) goto L18;
            r8.addAnimatorListener((ECShopMomentFlowGuidePresenter$lottieAnimatorListener$2.a) r15.j.getValue());
            r8.setRepeatCount(1);
            Unit r9 = Unit.INSTANCE;
        L19:
            r15.h = r8;
            r15.i = (TextView) r7.findViewById(2131386262);
            r15.f.postDelayed(new g(r15, r7), 1500);
            return;
        L18:
            r8 = null;
            goto L19
        L22:
            return;
        L7:
            if (Math.abs(r0 - r3) <= 86400000) goto L9;
            r1 = true;
            goto L10
        }
    }

    static {
    }

    public ECShopMomentFlowGuidePresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.l = r2;
        this.e = LazyKt.lazy(new ECShopMomentFlowGuidePresenter$viewModel$2(this));
        this.f = new Handler(Looper.getMainLooper());
        this.j = LazyKt.lazy(new ECShopMomentFlowGuidePresenter$lottieAnimatorListener$2(this));
        this.k = LazyKt.lazy(new ECShopMomentFlowGuidePresenter$guideContainerTouchListener$2(this));
    }

    public final void A(QModel r3) {
        FrameLayout r4 = (FrameLayout) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131386232));
        this.g = r4;
        if (r4 == null) goto L5;
        r4.setOnTouchListener((ECShopMomentFlowGuidePresenter$guideContainerTouchListener$2.a) this.k.getValue());
    L5:
        ((ECShopFeedViewModel) this.e.getValue()).getLoadStatus().b(ECQuickUtilKt.a(u()), new b(this));
    }
}
