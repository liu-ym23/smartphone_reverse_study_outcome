package com.bytedance.android.window.shop.home.header.presenter;

import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.window.base.widget.ECWindowRoundedLinearLayout;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/window/shop/home/header/presenter/WindowHeaderHybridPresenter$windowAbilities$2$createLynxHolder$ecLynxCardHolder$1", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLynxCardHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderHybridPresenter$windowAbilities$2$createLynxHolder$ecLynxCardHolder$1 extends ECLynxCardHolder {
    public final WindowHeaderHybridPresenter$windowAbilities$2$createLynxHolder$ecLynxCardHolder$1$observer$1 W;
    public final /* synthetic */ WindowHeaderHybridPresenter$windowAbilities$2 X;

    public final void o() {
        this.X.a.e0().getSubCollapseProgress().removeObserver(this.W);
        super.o();
    }

    /* JADX WARN: Type inference failed for: r13v1, types: [com.bytedance.android.window.shop.home.header.presenter.WindowHeaderHybridPresenter$windowAbilities$2$createLynxHolder$ecLynxCardHolder$1$observer$1] */
    public WindowHeaderHybridPresenter$windowAbilities$2$createLynxHolder$ecLynxCardHolder$1(WindowHeaderHybridPresenter$windowAbilities$2 r13, ECWindowRoundedLinearLayout r14, String r15) {
        this.X = r13;
        super(r14, r15, null, null, null, null, null, null, false, false, 2044);
        this.W = new WindowHeaderHybridPresenter$windowAbilities$2$createLynxHolder$ecLynxCardHolder$1$observer$1(this);
    }

    public final void b4(Object r2, String r3, k.a r4) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        super.b4(r2, r3, r4);
        this.X.a.e0().getSubCollapseProgress().observe(((QFragmentPresenter) this.X.a).e, this.W);
    }
}
