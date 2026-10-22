package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ KSongViceSingerTuningButtonOuterCallback a;

    public p(KSongViceSingerTuningButtonOuterCallback r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        KSongViceSingerTuningButtonOuterCallback r6 = this.a;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = r6.f();
        if (r0 == null) goto L5;
        Boolean r1 = r0.I();
    L6:
        Boolean r2 = Boolean.valueOf(Intrinsics.areEqual(r1, Boolean.TRUE));
        if (r6.g() == false) goto L12;
        bc0.c r3 = r6.b;
        if (r3 == null) goto L13;
        r3.m2(new KSongViceSingerTuningButtonOuterCallback$checkEchoMode$1(r6, r2), TuningButtonType.ECHO_ITEM, false);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
