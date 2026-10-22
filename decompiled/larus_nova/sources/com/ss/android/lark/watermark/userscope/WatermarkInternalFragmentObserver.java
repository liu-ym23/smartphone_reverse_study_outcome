package com.ss.android.lark.watermark.userscope;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/watermark/userscope/WatermarkInternalFragmentObserver;", "Landroidx/lifecycle/Observer;", "Lcom/ss/android/lark/watermark/v2/WatermarkState;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "binder", "Lcom/ss/android/lark/watermark/v2/WatermarkBinder;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/ss/android/lark/watermark/v2/WatermarkBinder;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "onChanged", "", "t", "watermark_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WatermarkInternalFragmentObserver implements Observer<com.ss.android.lark.watermark.v2.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f445376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.watermark.v2.q<Fragment> f445377b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(com.ss.android.lark.watermark.v2.v r100) {
        com.ss.android.lark.watermark.v2.v r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.security.watermark_thread_opt_disabled.android") == true) goto L5;
        s.a(r101, this.f445376a, this.f445377b);
        return;
    L5:
        com.ss.android.lark.watermark.v2.u r102 = new com.ss.android.lark.watermark.v2.u(r101, this.f445376a.requireContext());
        this.f445377b.b(r102, this.f445376a);
    }

    public WatermarkInternalFragmentObserver(Fragment r100, com.ss.android.lark.watermark.v2.q<Fragment> r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "binder");
        this.f445376a = r100;
        this.f445377b = r101;
    }
}
