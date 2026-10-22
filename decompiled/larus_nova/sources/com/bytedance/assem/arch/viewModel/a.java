package com.bytedance.assem.arch.viewModel;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static final Handler a(Looper r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r100, null, Boolean.TRUE});
    L10:
        return new Handler(r100);
    L5:
        return Handler.createAsync(r100);
    }
}
