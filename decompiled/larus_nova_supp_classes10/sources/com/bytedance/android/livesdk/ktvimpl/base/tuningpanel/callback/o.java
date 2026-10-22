package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o<T> implements Observer {
    public final /* synthetic */ KSongViceSingerTuningButtonOuterCallback a;

    public o(KSongViceSingerTuningButtonOuterCallback r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        KSongViceSingerTuningButtonOuterCallback r0 = this.a;
        if (r0.g() == false) goto L8;
        bc0.c r1 = r0.b;
        if (r1 == null) goto L9;
        r1.m2(new KSongViceSingerTuningButtonOuterCallback$checkEchoMode$1(r0, r5), TuningButtonType.ECHO_ITEM, false);
        return;
    L9:
        return;
    }
}
