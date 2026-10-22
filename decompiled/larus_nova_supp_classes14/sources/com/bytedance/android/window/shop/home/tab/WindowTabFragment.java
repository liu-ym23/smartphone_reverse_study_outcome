package com.bytedance.android.window.shop.home.tab;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabFragment extends Fragment implements QViewModelOwner {
    public static final /* synthetic */ int f = 0;
    public QUIManager d;
    public final com.bytedance.commerce.base.viewmodel.a e;

    public static final class a {
    }

    static {
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void onDestroy() {
        QUIManager r0 = this.d;
        if (r0 == null) goto L5;
        r0.r(sp3.b.class);
    L5:
        super.onDestroy();
    }

    public WindowTabFragment() {
        Function0<ViewModelProvider.Factory> r0 = new WindowTabFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new WindowTabFragment$$special$$inlined$viewModels$1(this);
        this.e = new com.bytedance.commerce.base.viewmodel.a(Reflection.getOrCreateKotlinClass(WindowTabViewModelDeprecated.class), new WindowTabFragment$$special$$inlined$viewModels$2(r1), r0);
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        Integer r4 = Integer.valueOf(r0.getInt("SHOP_WINDOW_ITEM_TYPE"));
    L8:
        if (r4 == null) goto L10;
        int r5 = r4.intValue();
    L11:
        WindowTabViewModelDeprecated r1 = (WindowTabViewModelDeprecated) this.e.getValue();
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r2 = com.bytedance.android.window.shop.c.b;
        r1.setShopWindowItemType(com.bytedance.android.window.shop.c.a.a(r5));
        ((WindowTabViewModelDeprecated) this.e.getValue()).prepareDataSource(((WindowTabViewModelDeprecated) this.e.getValue()).getShopWindowItemType());
        return;
    L10:
        r5 = com.bytedance.android.window.shop.c.c.getType();
        goto L11
    L5:
        if (r3 == null) goto L7;
        r4 = Integer.valueOf(r3.getInt("SHOP_WINDOW_ITEM_TYPE"));
        goto L8
    L7:
        r4 = null;
        goto L8
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        r3.putInt("SHOP_WINDOW_ITEM_TYPE", ((WindowTabViewModelDeprecated) this.e.getValue()).getShopWindowItemType().getType());
        super.onSaveInstanceState(r3);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        QUIManager r4 = this.d;
        if (r4 == null) goto L6;
        r4.c(sp3.b.class, null);
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        QUIManager r7 = this.d;
        if (r7 == null) goto L12;
        return r7.p();
    L12:
        View r8 = LayoutInflater.from(requireActivity()).inflate(2131564720, null);     // Catch: Exception -> L9
    L10:
        QUIManager r9 = new QUIManager();
        this.d = r9;
        com.bytedance.android.ec.window.base.utils.quick.d.a(r9, new sp3.b(r8), requireContext(), this);
        return r8;
    L9:
        Context r10 = requireContext();
        dm.a.a("WINDOW").i("window requireContext:" + r10.getClass());
        r8 = LayoutInflater.from(r10).inflate(2131564720, null);
        goto L10
    }
}
