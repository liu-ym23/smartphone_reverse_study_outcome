package com.bytedance.android.window.shop.home.tab;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.tab.presenter.ECWindowHybridTabPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.j;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabHybridFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabHybridFragment extends Fragment implements QViewModelOwner {
    public static final /* synthetic */ int g = 0;
    public boolean d;
    public QUIManager e;
    public final com.bytedance.commerce.base.viewmodel.a f;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.window.shop.home.module.a {
        public final View m;

        public final QIPresenter h() {
            Fragment r1 = a().i();
            if (r1 == null) goto L7;
            return new ECWindowHybridTabPresenter(r1);
        L7:
            throw new IllegalStateException("Required value was null.".toString());
        }

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "root");
            super(-1);
            this.m = r2;
        }

        @Override // com.bytedance.android.window.shop.home.module.a
        public final View k(ViewGroup r1) {
            return this.m;
        }
    }

    static {
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void onDestroy() {
        QUIManager r0 = this.e;
        if (r0 == null) goto L5;
        r0.r(b.class);
    L5:
        super.onDestroy();
    }

    public WindowTabHybridFragment() {
        Function0<ViewModelProvider.Factory> r0 = new WindowTabHybridFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new WindowTabHybridFragment$$special$$inlined$viewModels$1(this);
        this.f = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(WindowHybridTabViewModel.class), new WindowTabHybridFragment$$special$$inlined$viewModels$2(r1), r0);
        new QLiveData().g(null);
        Unit r2 = Unit.INSTANCE;
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
        ((WindowHybridTabViewModel) this.f.getValue()).setCategoryName(r1);
        ((WindowHybridTabViewModel) this.f.getValue()).prepareDataSource(r5);
        Bundle r6 = getArguments();
        if (r6 == null) goto L19;
        long r2 = Long.valueOf(r6.getLong("lifecycleMonitorId")).longValue();
        com.bytedance.android.window.shop.lifecycle.f r7 = com.bytedance.android.window.shop.lifecycle.c.a(r2);
        if (r7 == null) goto L17;
        r7.l();
    L17:
        ((WindowHybridTabViewModel) this.f.getValue()).setLifecycleMonitorId(r2);
        return;
    L19:
        return;
    L11:
        r1 = "";
    L6:
        r5 = "-1";
        goto L7
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        fo.a<WindowLayoutType> r5 = WindowConstDef.a;
        j r6 = null;
        if (((Boolean) WindowConstDef.o.getValue()).booleanValue() == false) goto L11;
        QUIManager r7 = this.e;
        if (r7 != null) goto L7;
    L10:
        this.d = false;
        return;
    L7:
        if (this.d == false) goto L9;
        r6 = j.j;
    L9:
        r7.c(b.class, r6);
        goto L10
    L11:
        QUIManager r8 = this.e;
        if (r8 == null) goto L16;
        r8.c(b.class, null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.view.LayoutInflater] */
    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        QUIManager r7 = this.e;
        if (r7 != null) goto L5;
        ?? r8 = 2131561032(0x7f0d0a48, float:1.8747453E38);
        fo.a<WindowLayoutType> r9 = WindowConstDef.a;     // Catch: Exception -> L12
        if (((Boolean) WindowConstDef.g.getValue()).booleanValue() == false) goto L10;
        ShoppingAsyncInflater.a r10 = ShoppingAsyncInflater.e;     // Catch: Exception -> L12
        FragmentActivity r0 = requireActivity();     // Catch: Exception -> L12
        r10.getClass();     // Catch: Exception -> L12
        r8 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r0), 2131561032, null, 4);     // Catch: Exception -> L12
    L15:
    L13:
        QUIManager r11 = new QUIManager();
        this.e = r11;
        com.bytedance.android.ec.window.base.utils.quick.d.a(r11, new b(r8), requireContext(), this);
        return r8;
    L10:
        r8 = LayoutInflater.from(requireActivity()).inflate(2131561032, null);     // Catch: Exception -> L12
    L12:
        Context r12 = requireContext();
        com.bytedance.android.ec.sdk.helper.c.a.b("WINDOW", "window requireContext:" + r12.getClass());
        r8 = LayoutInflater.from(r12).inflate(r8, null);
        goto L13
    L5:
        return r7.p();
    }
}
