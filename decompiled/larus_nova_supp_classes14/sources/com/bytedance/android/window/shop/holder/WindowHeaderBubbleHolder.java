package com.bytedance.android.window.shop.holder;

import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.presenter.WindowHeaderBubbleItemPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHeaderBubbleHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Loq3/b;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderBubbleHolder extends ShopWindowGenericHolder<oq3.b> {
    public WindowHeaderBubbleHolder(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(r3, new LinearLayout(r3.getContext()));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new WindowHeaderBubbleItemPresenter(r2);
    }
}
