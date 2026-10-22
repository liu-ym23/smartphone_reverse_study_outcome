package com.bytedance.ee.bear.middleground.permission.secret.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/detail/SecretDetailFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "presenter", "Lcom/bytedance/ee/bear/middleground/permission/secret/detail/SecretDetailPresenter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", LiveCommonConstants.REASON_ON_DEDTROY, "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretDetailFragment extends BaseFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f234042e;

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        h r100 = this.f234042e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        r100 = null;
    L5:
        r100.f234088h.clear();
    }

    public SecretDetailFragment() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        BaseTitleBar r102 = (BaseTitleBar) r100.findViewById(R.id.titleBar);
        r102.i(getString(R.string.LarkCCM_Workspace_Security_Settings_Title), true);
        r102.setDividerVisible(false);
        r102.setLeftClickListener(new e(this));
        Bundle r103 = getArguments();
        if (r103 == null) goto L6;
        String r104 = r103.getString("SecretDetail.token");
        if (r104 == null) goto L6;
    L7:
        String r105 = r104;
        Bundle r106 = getArguments();
        if (r106 == null) goto L10;
        int r107 = r106.getInt("SecretDetail.type");
    L11:
        this.f234042e = new h(requireContext(), r100, r105, r107, null);
        return;
    L10:
        r107 = 0;
    L6:
        r104 = "";
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.secret_activity, r101, false);
        r103.setFitsSystemWindows(true);
        return r103;
    }
}
