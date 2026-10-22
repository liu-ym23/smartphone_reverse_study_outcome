package com.bytedance.android.window.shop.product.presenter.group;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends ECWindowProductCardGroupPresenterBase {
    public static final /* synthetic */ int y = 0;
    public final Lazy x;

    @Override // com.bytedance.android.window.shop.product.presenter.group.ECWindowProductCardGroupPresenterBase
    public final BaseWindowTabViewModel n0() {
        return (BaseWindowTabViewModel) this.x.getValue();
    }

    public b(final Fragment r2, WindowLayoutType r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, null);
        this.x = LazyKt.lazy(new ECWindowProductCardGroupPresenterNew$tabViewModel$2(this, r2));
    }
}
