package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopSubTabsTabKitPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/shopping/store/tabkit/g;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopSubTabsTabKitPresenter extends ECShopBasePresenter implements LifecycleObserver, com.bytedance.android.shopping.store.tabkit.g {
    public ViewGroup u;
    public final com.bytedance.android.shopping.store.tabkit.f v;

    public static final class a<T> implements Observer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
            Pair r2 = (Pair) r1;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopSubTabsTabKitPresenter a;

        public b(ECShopSubTabsTabKitPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            if (((Float) r4).floatValue() < 1.0f) goto L8;
            ViewGroup r5 = this.a.u;
            if (r5 == null) goto L16;
            ViewExtensionsKt.g(r5, 12.0f, 12.0f, 0.0f, 0.0f);
            return;
        L16:
            return;
        L8:
            if (this.a.K() == false) goto L12;
            ViewGroup r6 = this.a.u;
            if (r6 == null) goto L18;
            ViewExtensionsKt.g(r6, 0.0f, 0.0f, 0.0f, 0.0f);
            return;
        L18:
            return;
        L12:
            ViewGroup r7 = this.a.u;
            if (r7 == null) goto L20;
            ViewExtensionsKt.g(r7, 12.0f, 12.0f, 0.0f, 0.0f);
            return;
        }
    }

    public ECShopSubTabsTabKitPresenter() {
        super(null);
        this.v = null;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void f(ECTabLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "tabLayout");
    }

    public final void A(QModel r4) {
        W().getLifecycle().addObserver(this);
        ViewGroup r5 = (ViewGroup) y().findViewById(2131371056);
        qc3.a.e(r5, new ColorDrawable(qc3.a.d(u().c(), 2131101856)));
        Unit r0 = Unit.INSTANCE;
        this.u = r5;
        T().getSelectedTabLocation().a(W(), a.a, false);
        com.bytedance.android.shopping.store.tabkit.f r6 = this.v;
        if (r6 == null) goto L5;
        TabKitViewModel r7 = r6.getTabKitViewModel();
    L6:
        if (r7 == null) goto L9;
        r7.addTabKitLifeListener(this);
    L9:
        if (T().isWhiteBrand() == false) goto L12;
        T().getUpglideFactor().a(W(), new b(this), false);
        return;
    L12:
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void k(com.bytedance.android.shopping.store.tabkit.model.k r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void l(com.bytedance.android.shopping.store.tabkit.model.k r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Intrinsics.checkNotNullParameter(r2, "tab");
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void o(com.bytedance.android.shopping.store.tabkit.model.k r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        Intrinsics.checkNotNullParameter(r2, "tab");
    }
}
