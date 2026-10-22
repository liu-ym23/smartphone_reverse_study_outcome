package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view.TuningMusicControlContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ j a;

    public f(j r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        TuningMusicControlContainer r3 = this.a.d;
        if (r3 == null) goto L10;
        Context r4 = r3.getContext();
        if (r4 == null) goto L11;
        ec0.a r0 = this.a.c;
        if (r0 == null) goto L12;
        r0.s(r4);
        return;
    L12:
        return;
    L11:
        return;
    }
}
