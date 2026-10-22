package com.bytedance.android.window.shop.home.header;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.window.base.utils.quick.d;
import com.bytedance.android.ec.window.base.utils.quick.e;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/home/header/WindowHeaderFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderFragment extends Fragment implements QViewModelOwner {
    public final boolean d;
    public QUIManager e;

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void onDestroy() {
        QUIManager r0 = this.e;
        if (r0 != null) goto L5;
    L9:
        super.onDestroy();
        return;
    L5:
        if (this.d == false) goto L7;
        Class<e> r1 = e.class;
    L8:
        r0.r(r1);
        goto L9
    L7:
        r1 = qp3.a.class;
        goto L8
    }

    public WindowHeaderFragment() {
        fo.a<WindowLayoutType> r0 = WindowConstDef.a;
        this.d = WindowConstDef.f;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        QUIManager r4 = this.e;
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.d == false) goto L7;
        Class<e> r5 = e.class;
    L8:
        r4.c(r5, null);
        return;
    L7:
        r5 = qp3.a.class;
        goto L8
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        QUIManager r8 = this.e;
        if (r8 != null) goto L5;
        QUIManager r9 = new QUIManager();
        this.e = r9;
        if (this.d == false) goto L9;
        View r10 = LayoutInflater.from(requireActivity()).inflate(2131561000, null);
        final ECHybridListContainer r11 = r10.findViewById(2131370822);
        r11.getRecyclerView().setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        e r0 = new e(r10, this, new WindowHeaderFragment$getModule$1(r11));
    L10:
        d.a(r9, r0, requireContext(), this);
        return r9.p();
    L9:
        r0 = new qp3.a(LayoutInflater.from(requireActivity()).inflate(2131560999, null));
        goto L10
    L5:
        return r8.p();
    }
}
