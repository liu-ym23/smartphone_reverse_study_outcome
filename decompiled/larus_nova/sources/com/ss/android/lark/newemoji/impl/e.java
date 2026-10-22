package com.ss.android.lark.newemoji.impl;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes36.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f433046a = null;

    static {
        f433046a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("EmojiService2", "PUSH_EMOJIS error", (Throwable) r100);
    }
}
