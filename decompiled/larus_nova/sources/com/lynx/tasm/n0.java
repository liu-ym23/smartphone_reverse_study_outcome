package com.lynx.tasm;

import android.os.Debug;
import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class n0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n0 f383491c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<a> f383492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f383493b;

    public static final class a extends WeakReference<t0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f383494a;

        public final int hashCode() {
            return this.f383494a;
        }

        public a(t0 r100) {
            super(r100);
            this.f383494a = System.identityHashCode(r100);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            t0 r101 = get();
            t0 r102 = ((a) r100).get();
            if (r101 == null) goto L12;
            if (r101 != r102) goto L12;
            return true;
        L12:
            return false;
        }
    }

    static {
        f383491c = new n0();
    }

    public static long a() {
        Debug.MemoryInfo r100 = new Debug.MemoryInfo();     // Catch: Throwable -> L6
        Debug.getMemoryInfo(r100);     // Catch: Throwable -> L6
        return Math.max(0, r100.getTotalPss()) * 1024;
    L6:
        th = move-exception;
        LLog.e("LynxMemoryCollector", "Failed to sample app memory usage: " + th.getMessage());
        return 0;
    }

    public n0() {
        this.f383492a = ConcurrentHashMap.newKeySet();
    }
}
