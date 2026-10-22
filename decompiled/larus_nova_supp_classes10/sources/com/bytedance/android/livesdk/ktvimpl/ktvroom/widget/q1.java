package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q1<T> implements Observer {
    public static final q1 a = null;

    static {
        a = new q1();
    }

    public q1() {
    }

    public final void onChanged(Object r2) {
        boolean r3 = ((Boolean) r2).booleanValue();
        com.bytedance.android.live.liveinteract.plantform.base.g r0 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r0 == null) goto L6;
        r0.Lp(!r3);
        return;
    }
}
