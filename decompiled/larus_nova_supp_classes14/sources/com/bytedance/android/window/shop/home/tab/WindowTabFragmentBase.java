package com.bytedance.android.window.shop.home.tab;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabFragmentBase;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabFragmentBase extends Fragment implements QViewModelOwner {
    public static final /* synthetic */ int g = 0;
    public QUIManager d;
    public final com.bytedance.commerce.base.viewmodel.a e;
    public final QLiveData<b> f;

    public static final class a {
        public a() {
        }

        public static WindowTabFragmentBase a(String r3, String r4, long r5, boolean r7, int r8) {
            Intrinsics.checkNotNullParameter(r3, "categoryId");
            Intrinsics.checkNotNullParameter(r4, "categoryName");
            com.bytedance.android.window.shop.lifecycle.f r0 = com.bytedance.android.window.shop.lifecycle.c.a(r5);
            if (r0 == null) goto L5;
            r0.k();
        L5:
            WindowTabFragmentBase r1 = new WindowTabFragmentBase();
            Bundle r2 = new Bundle();
            r2.putInt("window_tab_type", r8);
            r2.putInt("SHOP_WINDOW_ITEM_TYPE", 100);
            r2.putString("window_tab_category_id", r3);
            r2.putString("window_tab_category_name", r4);
            r2.putLong("lifecycleMonitorId", r5);
            r2.putBoolean("window_tab_pre_create", r7);
            Unit r6 = Unit.INSTANCE;
            r1.setArguments(r2);
            return r1;
        }
    }

    static {
        new a();
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void onDestroy() {
        QUIManager r0 = this.d;
        if (r0 == null) goto L5;
        r0.r(sp3.a.class);
    L5:
        super.onDestroy();
    }

    public WindowTabFragmentBase() {
        Function0<ViewModelProvider.Factory> r0 = new WindowTabFragmentBase$viewModel$2(this);
        final Function0<Fragment> r1 = new WindowTabFragmentBase$$special$$inlined$viewModels$1(this);
        this.e = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(WindowTabViewModel.class), new WindowTabFragmentBase$$special$$inlined$viewModels$2(r1), r0);
        QLiveData<b> r2 = new QLiveData();
        r2.g(null);
        Unit r3 = Unit.INSTANCE;
        this.f = r2;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 != null) goto L5;
    L7:
        Bundle r6 = getArguments();
        if (r6 == null) goto L11;
        String r7 = r6.getString("window_tab_category_id");
        if (r7 == null) goto L11;
    L12:
        Bundle r0 = getArguments();
        if (r0 == null) goto L16;
        String r1 = r0.getString("window_tab_category_name");
        if (r1 == null) goto L16;
    L17:
        Bundle r2 = getArguments();
        if (r2 == null) goto L20;
        int r3 = r2.getInt("window_tab_type");
    L21:
        ((WindowTabViewModel) this.e.getValue()).setCategoryName(r1);
        ((WindowTabViewModel) this.e.getValue()).prepareDataSource(r7, Integer.valueOf(r3));
    L22:
        Bundle r8 = getArguments();
        if (r8 == null) goto L29;
        long r9 = Long.valueOf(r8.getLong("lifecycleMonitorId")).longValue();
        com.bytedance.android.window.shop.lifecycle.f r10 = com.bytedance.android.window.shop.lifecycle.c.a(r9);
        if (r10 == null) goto L27;
        r10.l();
    L27:
        ((WindowTabViewModel) this.e.getValue()).setLifecycleMonitorId(r9);
        return;
    L29:
        return;
    L20:
        r3 = 100;
    L16:
        r1 = "";
    L11:
        r7 = "-1";
        goto L12
    L5:
        if (r5.getBoolean("window_tab_pre_create") != true) goto L7;
        goto L7
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        r3.putInt("SHOP_WINDOW_ITEM_TYPE", ((WindowTabViewModel) this.e.getValue()).getShopWindowItemType().getType());
        super.onSaveInstanceState(r3);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        QUIManager r4 = this.d;
        if (r4 == null) goto L6;
        r4.c(sp3.a.class, null);
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        QUIManager r7 = this.d;
        if (r7 == null) goto L21;
        return r7.p();
    L21:
        View r8 = LayoutInflater.from(requireActivity()).inflate(2131564720, null);     // Catch: Exception -> L9
    L10:
        this.d = new QUIManager();
        Bundle r9 = getArguments();
        if (r9 != null) goto L13;
    L17:
        QUIManager r10 = this.d;
        if (r10 == null) goto L20;
        com.bytedance.android.ec.window.base.utils.quick.d.a(r10, new sp3.a(r8, null), requireContext(), this);
    L20:
        return r8;
    L13:
        if (r9.getBoolean("window_tab_pre_create") != true) goto L17;
        QUIManager r11 = this.d;
        if (r11 == null) goto L20;
        com.bytedance.android.ec.window.base.utils.quick.d.a(r11, new sp3.a(r8, this.f), requireContext(), this);
    L9:
        Context r12 = requireContext();
        com.bytedance.android.ec.sdk.helper.c.a.b("WINDOW", "window requireContext:" + r12.getClass());
        r8 = LayoutInflater.from(r12).inflate(2131564720, null);
        goto L10
    }
}
