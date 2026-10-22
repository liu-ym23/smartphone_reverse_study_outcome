package com.bytedance.ee.bear.document.ai.myai;

import android.os.SystemClock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public long a;

    public final boolean a() {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.a) <= 1000) goto L6;
        this.a = r0;
        return false;
    L6:
        return true;
    }

    public a() {
    }
}
