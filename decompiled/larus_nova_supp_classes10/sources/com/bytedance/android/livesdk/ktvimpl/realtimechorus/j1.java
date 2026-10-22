package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdkapi.model.SeiAppData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j1 extends com.bytedance.android.livesdk.ktvimpl.base.sei.j {
    public final com.bytedance.android.live.liveinteract.plantform.datamerge.d a;

    public j1(com.bytedance.android.live.liveinteract.plantform.datamerge.d r1) {
        this.a = r1;
    }

    public final void onSeiUpdated(SeiAppData r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r0 = this.a;
        if (r0 == null) goto L8;
        r0.t0(r2);
        return;
    }
}
