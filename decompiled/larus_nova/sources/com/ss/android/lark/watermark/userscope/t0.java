package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes38.dex */
public final class t0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0<T> f445510a = null;

    static {
        f445510a = new t0();
    }

    public t0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("watermarkV3", "push page data error: " + ((Throwable) r100).getMessage());
    }
}
