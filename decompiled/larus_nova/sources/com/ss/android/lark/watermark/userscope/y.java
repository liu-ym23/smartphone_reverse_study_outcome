package com.ss.android.lark.watermark.userscope;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes38.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y<T> f445517a = null;

    static {
        f445517a = new y();
    }

    public y() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("watermarkV3", "fetch fallback watermark error: " + ((Throwable) r100).getMessage());
    }
}
