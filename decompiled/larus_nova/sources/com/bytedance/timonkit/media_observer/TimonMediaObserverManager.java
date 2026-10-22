package com.bytedance.timonkit.media_observer;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
public final class TimonMediaObserverManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function0<? extends Handler> f270916a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f270917b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f270918c = null;

    public static final class a extends ContentObserver {
        public a(Handler r100) {
            super(r100);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            Function0<? extends Handler> r101 = TimonMediaObserverManager.f270916a;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100, Uri r101) {
            Function0<? extends Handler> r102 = TimonMediaObserverManager.f270916a;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100, Uri r101, int r102) {
            Function0<? extends Handler> r103 = TimonMediaObserverManager.f270916a;
        }
    }

    static {
        new AtomicBoolean(false);
        new ConcurrentLinkedQueue();
        f270916a = TimonMediaObserverManager$asyncHandler$1.INSTANCE;
        new AtomicBoolean(false);
        f270917b = new AtomicBoolean(false);
        f270918c = new AtomicBoolean(false);
        new a(new Handler(Looper.getMainLooper()));
        if (Build.VERSION.SDK_INT < 34) goto L6;
        new e();
        return;
    }
}
