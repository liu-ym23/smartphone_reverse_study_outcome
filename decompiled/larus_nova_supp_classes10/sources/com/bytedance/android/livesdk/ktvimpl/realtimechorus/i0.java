package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i0 implements fd0.a {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public i0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void onStart() {
        FrameLayout r0 = this.a.I;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }
}
