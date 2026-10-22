package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import com.bytedance.android.live.core.utils.StateMachine;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ TopPauseStartFunctionItem a;

    public g(TopPauseStartFunctionItem r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        StateMachine.c.b r3 = (StateMachine.c.b) r2;
        if (r3 != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.f.a(r3) != true) goto L9;
        this.a.a();
        return;
    }
}
