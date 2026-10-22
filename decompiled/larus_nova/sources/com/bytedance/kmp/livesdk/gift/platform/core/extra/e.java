package com.bytedance.kmp.livesdk.gift.platform.core.extra;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f252255a = null;

    static {
        f252255a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.b("GiftExtraRepository", "failed to refreshGiftExtra", (Throwable) r100);
    }
}
