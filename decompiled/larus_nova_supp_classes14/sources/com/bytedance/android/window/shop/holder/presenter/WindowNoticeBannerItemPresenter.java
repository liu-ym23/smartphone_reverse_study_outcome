package com.bytedance.android.window.shop.holder.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.repository.tab.entity.k0;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowNoticeBannerItemPresenter extends ECWindowHolderBaseFragmentPresenter {
    public final Lazy i;
    public k0 j;

    public WindowNoticeBannerItemPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.i = LazyKt.lazy(new WindowNoticeBannerItemPresenter$reportEventHelper$2(this));
    }

    public final void b0(QModel r2) {
        if (r2 == null) goto L10;
        k0 r3 = (k0) r2;
        this.j = r3;
        Unit r0 = (Unit) this.i.getValue();
        bp.a r1 = a0();
        if (r1 == null) goto L8;
        r1.getTextView().setText(r3.j);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.recommend.widget.WindowRecommendBannerNoticeView");
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.WindowSyncNoticeBannerVO");
    }
}
