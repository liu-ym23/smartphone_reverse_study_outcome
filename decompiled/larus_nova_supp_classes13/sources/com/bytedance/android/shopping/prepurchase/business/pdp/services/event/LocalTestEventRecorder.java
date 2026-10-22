package com.bytedance.android.shopping.prepurchase.business.pdp.services.event;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LocalTestEventRecorder {
    public final Lazy a;

    public LocalTestEventRecorder() {
        this.a = LazyKt.lazy(LocalTestEventRecorder$btmEvents$2.INSTANCE);
    }
}
