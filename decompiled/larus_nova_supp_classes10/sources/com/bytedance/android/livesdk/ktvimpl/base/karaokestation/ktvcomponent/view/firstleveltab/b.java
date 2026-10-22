package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab;

import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.BaseFirstLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ AudienceSingFirstLevelTabFragment a;

    public b(AudienceSingFirstLevelTabFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        AudienceSingFirstLevelTabFragment r0 = this.a;
        int r1 = AudienceSingFirstLevelTabFragment.w;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r2 = ((BaseFirstLevelTabFragment) r0).q;
        KSongOrderSongUtilKt.h(r2, (Long) r4, "multi_chorus", FirstLevelTab.AudienceSingTab);
    }
}
