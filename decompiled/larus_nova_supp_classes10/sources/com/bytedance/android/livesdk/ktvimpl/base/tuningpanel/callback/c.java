package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ KSongTuningButtonOuterCallback a;

    public c(KSongTuningButtonOuterCallback r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        ((Boolean) r4).booleanValue();
        KSongTuningButtonOuterCallback r5 = this.a;
        bc0.c r0 = r5.b;
        if (r0 == null) goto L6;
        r0.m2(new KSongTuningButtonOuterCallback$handleOriginSwitchChanged$1(r5), TuningButtonType.ORIGIN_ITEM, false);
        return;
    }
}
