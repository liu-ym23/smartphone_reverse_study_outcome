package com.bytedance.objectcontainer;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes21.dex */
class AsyncHandlerExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f266105a;

    public AsyncHandlerExecutor() {
        Looper r100 = Looper.getMainLooper();
        if (Build.VERSION.SDK_INT < 28) goto L12;
        Handler r101 = Handler.createAsync(r100);
    L10:
        this.f266105a = r101;
        return;
    L12:
        Handler r102 = (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r100, null, Boolean.TRUE});     // Catch: InvocationTargetException -> L7 Throwable -> L8
    L9:
        r101 = r102;
        goto L10
    L8:
        r102 = new Handler(r100);
    L7:
        r102 = new Handler(r100);
        goto L9
    }
}
