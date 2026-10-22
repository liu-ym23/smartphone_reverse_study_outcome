package com.google.android.gms.internal.common;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.s;

/* JADX INFO: loaded from: classes23.dex */
public class l extends Handler {
    public l(Looper r100) {
        super(r100);
        Looper.getMainLooper();
    }

    public l(Looper r100, s r101) {
        super(r100, r101);
        Looper.getMainLooper();
    }
}
