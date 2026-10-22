package com.ss.android.ugc.aweme.shortvideo;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes40.dex */
public class SafeHandler extends Handler implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f454177a = 0;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.shortvideo.SafeHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f454178a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            f454178a = r100;
            r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        if (AnonymousClass1.f454178a[r101.ordinal()] != 1) goto L11;
        removeCallbacksAndMessages(null);
        Runnable r102 = new a(this);
        if (Looper.myLooper() == Looper.getMainLooper()) goto L8;
        post(r102);
        return;
    L8:
        r102.run();
        return;
    }
}
