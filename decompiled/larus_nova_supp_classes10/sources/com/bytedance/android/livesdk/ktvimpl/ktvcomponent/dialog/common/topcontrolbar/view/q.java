package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q<T> implements Observer {
    public final /* synthetic */ VideoChorusTopBarControlContainer a;

    public q(VideoChorusTopBarControlContainer r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        jd2.a r4 = (jd2.a) r3;
        if (r4 == null) goto L13;
        int r5 = r4.b;
        if (r5 <= 0) goto L14;
        VideoChorusTopBarControlContainer r0 = this.a;
        boolean r1 = true;
        if (r5 == 1) goto L11;
        r1 = false;
    L11:
        r0.e(r1);
        return;
    L14:
        return;
    }
}
