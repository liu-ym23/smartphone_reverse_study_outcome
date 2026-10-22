package com.bytedance.android.window.shop.home.tab.presenter;

import android.view.View;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class WindowH5TabPresenter$initLazyStatusView$4 extends Lambda implements Function0<View> {
    final /* synthetic */ WindowLazyStatusView $statusView;
    final /* synthetic */ WindowH5TabPresenter this$0;

    public WindowH5TabPresenter$initLazyStatusView$4(WindowH5TabPresenter r1, WindowLazyStatusView r2) {
        this.this$0 = r1;
        this.$statusView = r2;
        super(0);
    }

    public final View invoke() {
        View r0 = th.a.d(th.a.e(this.this$0.y().getContext(), true), 2131561057, null, 6);
        com.bytedance.android.ec.core.widget.f.c(r0, null, null, new WindowH5TabPresenter$initLazyStatusView$4$$special$$inlined$also$lambda$1(this), 3);
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m799invoke() {
        return invoke();
    }
}
