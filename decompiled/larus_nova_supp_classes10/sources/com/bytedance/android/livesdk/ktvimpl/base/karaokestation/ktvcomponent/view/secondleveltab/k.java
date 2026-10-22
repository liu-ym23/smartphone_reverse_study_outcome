package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import com.bytedance.android.live.ktv.common.model.api.z0;
import com.bytedance.android.livesdk.message.model.KtvMusic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements e {
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d a;

    public k(com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.e
    public final void a(z0 r2) {
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.a;
        if (r0 == null) goto L9;
        if (r2 == null) goto L6;
        KtvMusic r3 = r2.b();
    L7:
        r0.removeWantSingSong(r3);
        return;
    L6:
        r3 = null;
        goto L7
    }
}
