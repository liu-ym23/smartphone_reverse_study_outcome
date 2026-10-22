package com.bytedance.assem.jedi_vm.store;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f193107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f193108b = null;

    static {
        Handler r100 = new Handler(Looper.getMainLooper());
        f193107a = r100;
        f193108b = new d(r100);
    }

    public static final boolean a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }
}
