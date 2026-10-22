package com.ss.android.lark.forwardv2.sharefile;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements RxScheduledExecutor.Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f425047a = null;

    static {
        f425047a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
    public final void consume(Object r100) {
        Log.e("FileShareEnhancedView", "get file error", (Throwable) r100);
    }
}
