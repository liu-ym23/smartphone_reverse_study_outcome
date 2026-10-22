package com.bytedance.scene.navigation;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f268775a;

    public a(Looper r100) {
        super(r100);
        this.f268775a = true;
        if (Build.VERSION.SDK_INT >= 22) goto L12;
        Message r101 = Message.obtain();
        r101.setAsynchronous(true);     // Catch: NoSuchMethodError -> L7
    L8:
        r101.recycle();
        return;
    L7:
        this.f268775a = false;
        goto L8
    }
}
