package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements d {
    public final y a;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d b;

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.d
    public final void a(com.bytedance.android.live.ktv.common.model.bean.d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.b;
        if (r0 == null) goto L8;
        r0.removeWaitingSongUser(r3, this.a);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab.d
    public final void b(com.bytedance.android.live.ktv.common.model.bean.d r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.b;
        if (r0 == null) goto L8;
        r0.permitWaitingSongUser(r3, this.a);
        return;
    }

    public a(y r2, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabData");
        this.a = r2;
        this.b = r3;
    }
}
