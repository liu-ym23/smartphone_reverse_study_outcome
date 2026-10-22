package com.bytedance.awemeopen.apps.framework.feed.follow.util;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference<Handler> f194779a;

    public static Handler a() {
        SoftReference<Handler> r100 = f194779a;
        if (r100 == null) goto L7;
        Handler r101 = r100.get();
        if (r101 == null) goto L7;
        return r101;
    L7:
        Handler r102 = new Handler(Looper.getMainLooper());
        f194779a = new SoftReference(r102);
        return r102;
    }

    public static boolean b() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
