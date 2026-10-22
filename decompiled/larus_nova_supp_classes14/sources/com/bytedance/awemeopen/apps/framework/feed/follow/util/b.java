package com.bytedance.awemeopen.apps.framework.feed.follow.util;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static SoftReference<Handler> a;

    public static Handler a() {
        SoftReference<Handler> r0 = a;
        if (r0 == null) goto L7;
        Handler r1 = r0.get();
        if (r1 == null) goto L7;
        return r1;
    L7:
        Handler r2 = new Handler(Looper.getMainLooper());
        a = new SoftReference(r2);
        return r2;
    }

    public static boolean b() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
