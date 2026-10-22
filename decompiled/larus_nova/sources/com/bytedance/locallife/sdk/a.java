package com.bytedance.locallife.sdk;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveData<Boolean> f264329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f264330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f264331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<b> f264332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f264333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f264334f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f264335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f264336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f264337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ExecutorService f264338j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LocalLifePendingTaskQueue$observer$1 f264339k;

    /* JADX INFO: renamed from: com.bytedance.locallife.sdk.a$a, reason: collision with other inner class name */
    public static final class C3708a {
    }

    public static final class b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "PendingTask(name=null, handler=null, block=null)";
        }
    }

    static {
    }

    public static final void a(a r100) {
        if (r100.f264337i.compareAndSet(false, true) == false) goto L7;
        r100.f264338j.execute(new com.bytedance.locallife.sdk.b(r100));
        return;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.locallife.sdk.LocalLifePendingTaskQueue$observer$1] */
    public a(MutableLiveData r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "totalSdkInitializedLiveData");
        Intrinsics.checkNotNullParameter(r101, "isTotalSdkInitialized");
        this.f264329a = r100;
        this.f264330b = r101;
        this.f264331c = new Object();
        this.f264332d = new ArrayDeque();
        this.f264333e = new Handler(Looper.getMainLooper());
        new AtomicBoolean(false);
        this.f264334f = new AtomicBoolean(false);
        this.f264335g = new AtomicBoolean(false);
        this.f264336h = new AtomicBoolean(false);
        this.f264337i = new AtomicBoolean(false);
        this.f264338j = PThreadExecutorsUtils.newSingleThreadExecutor(c.f264341a);
        this.f264339k = new LocalLifePendingTaskQueue$observer$1(this);
    }
}
