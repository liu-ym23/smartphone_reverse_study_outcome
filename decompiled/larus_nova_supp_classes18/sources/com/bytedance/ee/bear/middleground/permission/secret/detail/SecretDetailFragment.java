package com.bytedance.ee.bear.middleground.permission.secret.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/detail/SecretDetailFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "presenter", "Lcom/bytedance/ee/bear/middleground/permission/secret/detail/SecretDetailPresenter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "onDestroy", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretDetailFragment extends BaseFragment {
    public h e;

    public final void onDestroy() {
        super.onDestroy();
        h r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        r0 = null;
    L5:
        r0.h.clear();
    }

    public SecretDetailFragment() {
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        BaseTitleBar r10 = (BaseTitleBar) r8.findViewById(2131388775);
        r10.i(getString(2131889951), true);
        r10.setDividerVisible(false);
        r10.setLeftClickListener(new e(this));
        Bundle r11 = getArguments();
        if (r11 == null) goto L6;
        String r12 = r11.getString("SecretDetail.token");
        if (r12 == null) goto L6;
    L7:
        String r4 = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L10;
        int r5 = r13.getInt("SecretDetail.type");
    L11:
        this.e = new h(requireContext(), r8, r4, r5, null);
        return;
    L10:
        r5 = 0;
    L6:
        r12 = "";
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131564488, r3, false);
        r5.setFitsSystemWindows(true);
        return r5;
    }
}
