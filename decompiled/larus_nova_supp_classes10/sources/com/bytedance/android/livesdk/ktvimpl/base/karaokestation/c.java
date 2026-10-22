package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements e {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final void a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "secondLevelTabName");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final void c(Integer r1, String r2) {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final void clearData() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.e
    public final com.bytedance.android.live.ktv.common.karaokestation.model.a b(Function0<Unit> r2) {
        return new com.bytedance.android.live.ktv.common.karaokestation.model.a(0);
    }
}
