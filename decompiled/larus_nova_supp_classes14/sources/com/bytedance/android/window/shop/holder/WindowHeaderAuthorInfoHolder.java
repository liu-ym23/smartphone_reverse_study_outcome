package com.bytedance.android.window.shop.holder;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.window.shop.holder.presenter.HeadAnimationPresenter;
import com.bytedance.android.window.shop.holder.presenter.WindowHeaderAuthorInfoItemPresenter;
import com.bytedance.android.window.shop.holder.presenter.WindowHeaderFollowAboutPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHeaderAuthorInfoHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Loq3/a;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderAuthorInfoHolder extends ShopWindowGenericHolder<oq3.a> {
    public WindowHeaderAuthorInfoHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = r5.requireContext();
        r0.getClass();
        super(r5, ShoppingAsyncInflater.a.a(r1).aU(2131561013, new FrameLayout(r5.requireContext()), true));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        QGroupPresenter r0 = new QGroupPresenter();
        LinkedHashSet r1 = new LinkedHashSet();
        WindowHeaderAuthorInfoItemPresenter r2 = new WindowHeaderAuthorInfoItemPresenter(r5, r1);
        WindowHeaderFollowAboutPresenter r3 = new WindowHeaderFollowAboutPresenter(r5);
        r1.add(r2);
        r1.add(r3);
        r0.a(r2);
        r0.a(r3);
        r0.a(new HeadAnimationPresenter());
        return r0;
    }
}
