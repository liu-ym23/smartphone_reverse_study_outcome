package com.bytedance.android.window.shop.holder.presenter;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/presenter/WindowAnchorCardPresenter;", "Lcom/bytedance/android/window/shop/holder/presenter/ECWindowHolderBaseFragmentPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowAnchorCardPresenter extends ECWindowHolderBaseFragmentPresenter implements LifecycleObserver {
    public final Lazy i;

    public WindowAnchorCardPresenter(final Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.i = LazyKt.lazy(new WindowAnchorCardPresenter$tabViewModel$2(this, r2));
    }

    public final void b0(QModel r3) {
        if ((r3 instanceof sq3.c) == true) goto L5;
        r3 = null;
    L5:
        sq3.c r4 = (sq3.c) r3;
        if (r4 == null) goto L9;
        ((TextView) Z().b(2131371252).f()).setText(r4.m);
        i0("window_end_button_show");
        a0().setOnClickListener(new c(this, r4));
        return;
    }

    public final void i0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        d0().doEventAction(r5, new Pair[]{TuplesKt.to("tab_name", ((BaseWindowTabViewModel) this.i.getValue()).getLastCategoryId()), TuplesKt.to("tab_name_second", ((BaseWindowTabViewModel) this.i.getValue()).getLastSubCategoryId()), TuplesKt.to("ecom_entrance_form", ((BaseWindowTabViewModel) this.i.getValue()).getLastCategoryId()), TuplesKt.to("ecom_entrance_form_second", ((BaseWindowTabViewModel) this.i.getValue()).getLastSubCategoryId())});
    }
}
