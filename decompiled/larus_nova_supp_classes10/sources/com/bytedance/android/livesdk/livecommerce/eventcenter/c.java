package com.bytedance.android.livesdk.livecommerce.eventcenter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements d {
    public c() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final void a(d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final void b(d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.d
    public final void sendEvent(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
    }
}
