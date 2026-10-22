package com.bytedance.assem.jedi_vm.store;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final Handler a = null;
    public static final d b = null;

    static {
        Handler r0 = new Handler(Looper.getMainLooper());
        a = r0;
        b = new d(r0);
    }

    public static final boolean a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }
}
