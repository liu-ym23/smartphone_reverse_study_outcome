package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes38.dex */
public final class q0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q0<T> f445489a = null;

    static {
        f445489a = new q0();
    }

    public q0() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("watermarkV3", "push file data error: " + ((Throwable) r100).getMessage());
    }
}
