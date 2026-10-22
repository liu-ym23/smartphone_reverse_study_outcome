package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab;

import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ OrderFirstLevelTabFragment a;

    public f(OrderFirstLevelTabFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        MusicPanel r6 = (MusicPanel) r5;
        OrderFirstLevelTabFragment r0 = this.a;
        int r1 = OrderFirstLevelTabFragment.E;
        if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) r0).q, FirstLevelTab.OrderSongTab) == false) goto L6;
        OrderFirstLevelTabFragment r2 = this.a;
        KSongOrderSongUtilKt.k(r6, ((BaseFirstLevelTabFragment) r2).o, ((BaseFirstLevelTabFragment) r2).m, r2.getView(), this.a.getContext());
        return;
    }
}
