package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.core.utils.StateMachine;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ l a;

    public b(l r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        l r0 = this.a;
        r0.b((StateMachine.c.b) r2);
    }
}
