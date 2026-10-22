package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v extends b7.a {
    public v() {
    }

    public final void onLoadSuccess(View r2) {
        w.b("ConcertStageHybridManager", "loadLynxView success");
    }

    public final void onLoadFail(View r1, String r2, String r3) {
        w.b("ConcertStageHybridManager", "loadLynxView onLoadFail");
    }
}
