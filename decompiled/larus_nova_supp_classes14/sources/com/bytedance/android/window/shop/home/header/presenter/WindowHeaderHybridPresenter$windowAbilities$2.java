package com.bytedance.android.window.shop.home.header.presenter;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.ec.window.base.widget.ECWindowRoundedLinearLayout;
import kotlin.jvm.internal.Intrinsics;
import zq3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowHeaderHybridPresenter$windowAbilities$2 extends m0 {
    public final /* synthetic */ WindowHeaderHybridPresenter a;

    public WindowHeaderHybridPresenter$windowAbilities$2(WindowHeaderHybridPresenter r1) {
        this.a = r1;
    }

    public final ECLynxCardHolder a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ECWindowRoundedLinearLayout r0 = new ECWindowRoundedLinearLayout(r5, null, 6, 0);
        r0.setOrientation(1);
        r0.setLayoutParams(new VirtualLayoutManager.LayoutParams(-1));
        r0.setMinimumHeight(10);
        WindowHeaderHybridPresenter$windowAbilities$2$createLynxHolder$ecLynxCardHolder$1 r6 = new WindowHeaderHybridPresenter$windowAbilities$2$createLynxHolder$ecLynxCardHolder$1(this, r0, this.a.j);
        int r1 = d.a;
        ((ECLynxCardHolder) r6).q = d.b(this.a.e0(), null, null);
        return r6;
    }
}
