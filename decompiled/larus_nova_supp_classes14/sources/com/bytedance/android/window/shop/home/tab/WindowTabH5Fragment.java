package com.bytedance.android.window.shop.home.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.view.NestedScrollFrameLayout;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabH5Fragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabH5Fragment extends Fragment implements QViewModelOwner {
    public static final /* synthetic */ int g = 0;
    public final Lazy d;
    public final QUIManager e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void onDestroy() {
        com.bytedance.android.ec.window.base.utils.quick.f.b(this.e);
        super.onDestroy();
    }

    public WindowTabH5Fragment() {
        this.d = LazyKt.lazy(new WindowTabH5Fragment$viewModel$2(this));
        this.e = new QUIManager();
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        String r5 = r4.getString("window_tab_category_id");
        if (r5 == null) goto L6;
    L7:
        Bundle r0 = getArguments();
        if (r0 == null) goto L11;
        String r1 = r0.getString("window_tab_category_name");
        if (r1 == null) goto L11;
    L12:
        ((BaseWindowTabViewModel) this.d.getValue()).setCategoryName(r1);
        ((BaseWindowTabViewModel) this.d.getValue()).prepareDataSource(r5);
        Bundle r6 = getArguments();
        if (r6 == null) goto L18;
        com.bytedance.android.window.shop.lifecycle.f r7 = com.bytedance.android.window.shop.lifecycle.c.a(Long.valueOf(r6.getLong("lifecycleMonitorId")).longValue());
        if (r7 == null) goto L19;
        r7.l();
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r1 = "";
    L6:
        r5 = "-1";
        goto L7
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        com.bytedance.android.ec.window.base.utils.quick.f.a(this.e, null);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.f == true) goto L5;
        this.f = true;
        QUIManager r5 = this.e;
        AnonymousClass1 r6 = AnonymousClass1.INSTANCE;
        NestedScrollFrameLayout r0 = new NestedScrollFrameLayout(r2.getContext());
        com.bytedance.android.ec.window.base.utils.quick.d.a(r5, new com.bytedance.android.ec.window.base.utils.quick.e(r0, this, r6), r0.getContext(), this);
        return this.e.p();
    L5:
        return this.e.p();
    }
}
