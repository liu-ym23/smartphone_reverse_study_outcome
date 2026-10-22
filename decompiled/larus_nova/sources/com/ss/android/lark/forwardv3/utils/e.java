package com.ss.android.lark.forwardv3.utils;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f425574a;

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public final boolean a() {
        long r100 = SystemClock.uptimeMillis();
        long r101 = r100 - this.f425574a;
        this.f425574a = r100;
        if (r101 >= 1000) goto L5;
        Log.i("ForwardClickThrottle", "elapsedTime is short than LENGTH_SHORT");
        return false;
    L5:
        Log.i("ForwardClickThrottle", "click is normal");
        return true;
    }
}
