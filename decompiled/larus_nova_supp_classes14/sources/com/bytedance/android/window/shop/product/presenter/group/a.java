package com.bytedance.android.window.shop.product.presenter.group;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends ECWindowProductCardGroupPresenterBase {
    public static final /* synthetic */ int y = 0;
    public final Lazy x;

    @Override // com.bytedance.android.window.shop.product.presenter.group.ECWindowProductCardGroupPresenterBase
    public final String m0() {
        return "live_order";
    }

    @Override // com.bytedance.android.window.shop.product.presenter.group.ECWindowProductCardGroupPresenterBase
    public final BaseWindowTabViewModel n0() {
        return (BaseWindowTabViewModel) this.x.getValue();
    }

    public a(final Fragment r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, null, r3);
        this.x = LazyKt.lazy(new ECWindowLiveOrderProductCardGroupPresenter$tabViewModel$2(this, r2));
    }
}
