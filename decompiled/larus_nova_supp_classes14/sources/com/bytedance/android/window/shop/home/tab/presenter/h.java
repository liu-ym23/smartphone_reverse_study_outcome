package com.bytedance.android.window.shop.home.tab.presenter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.window.shop.widget.ECWindowHybridRoundedLinearLayout;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends m0 {
    public final /* synthetic */ ECWindowHybridTabPresenter a;

    public h(ECWindowHybridTabPresenter r1) {
        this.a = r1;
    }

    public final ECLynxCardHolder a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        ECWindowHybridRoundedLinearLayout r0 = new ECWindowHybridRoundedLinearLayout(r6, null, 6, 0);
        r0.setOrientation(1);
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        ECWindowLynxMonitorHolder r7 = new ECWindowLynxMonitorHolder(this.a.j0(), r0, this.a.l0().getSceneId(), ((QFragmentPresenter) this.a).e.getLifecycle());
        int r1 = zq3.d.a;
        ((ECLynxCardHolder) r7).q = zq3.d.b(this.a.j0(), null, null);
        return r7;
    }
}
