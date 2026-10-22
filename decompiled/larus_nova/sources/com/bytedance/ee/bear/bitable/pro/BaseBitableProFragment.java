package com.bytedance.ee.bear.bitable.pro;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BaseBitableProFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "statusBar", "Lcom/bytedance/ee/util/statusbar/IStatusBar;", "getStatusBar", "()Lcom/bytedance/ee/util/statusbar/IStatusBar;", "statusBar$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "getStatusBarColorRes", "", "onBackPressed", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseBitableProFragment extends BaseFragment implements com.bytedance.ee.bear.l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f215047e;

    public int U90() {
        return R.color.bg_base;
    }

    public BaseBitableProFragment() {
        this.f215047e = LazyKt.lazy(new BaseBitableProFragment$statusBar$2(this));
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public boolean onBackPressed() {
        if (super.onBackPressed() == true) goto L7;
        T90(R.anim.facade_slide_right_out);
        return true;
    L7:
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((xu5.a) this.f215047e.getValue()).resetState();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ((xu5.a) this.f215047e.getValue()).saveState();
        ((xu5.a) this.f215047e.getValue()).b(getResources().getColor(U90()), !ColorUtils.b(requireContext()));
    }
}
