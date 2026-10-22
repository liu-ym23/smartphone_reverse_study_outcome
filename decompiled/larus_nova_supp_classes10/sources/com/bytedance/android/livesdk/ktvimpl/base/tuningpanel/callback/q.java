package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListAdapter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ KSongViceSingerTuningButtonOuterCallback a;
    public final /* synthetic */ bc0.c b;

    public q(KSongViceSingerTuningButtonOuterCallback r1, TuningButtonListAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        final Boolean r5 = (Boolean) r4;
        this.b.m2(new KSongViceSingerTuningButtonOuterCallback$addSwitchObserver$3$1(this, r5), TuningButtonType.ECHO_ITEM, false);
    }
}
