package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab;

import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ MineFirstLevelTabFragment a;

    public a(MineFirstLevelTabFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        MusicPanel r6 = (MusicPanel) r5;
        MineFirstLevelTabFragment r0 = this.a;
        int r1 = MineFirstLevelTabFragment.G;
        if (KSongOrderSongUtilKt.j(((BaseFirstLevelTabFragment) r0).q, FirstLevelTab.MySongTab) == false) goto L6;
        MineFirstLevelTabFragment r2 = this.a;
        KSongOrderSongUtilKt.l(r6, ((BaseFirstLevelTabFragment) r2).n, ((BaseFirstLevelTabFragment) r2).m, r2.getView(), this.a.getContext());
        return;
    }
}
