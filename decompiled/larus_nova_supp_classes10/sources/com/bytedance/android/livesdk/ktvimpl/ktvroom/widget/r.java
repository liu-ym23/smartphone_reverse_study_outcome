package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvOpusMicLabelAnim;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ KtvInteractElementWidget a;

    public r(KtvInteractElementWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        py.k r3 = (py.k) r2;
        if (r3 == null) goto L8;
        KtvOpusMicLabelAnim r0 = this.a.x;
        if (r0 == null) goto L9;
        r0.setUserAvatar(r3);
        return;
    L9:
        return;
    }
}
