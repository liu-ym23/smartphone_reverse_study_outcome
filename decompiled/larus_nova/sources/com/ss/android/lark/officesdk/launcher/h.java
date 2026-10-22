package com.ss.android.lark.officesdk.launcher;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class h implements eva.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Long, b> f433446a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f433447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f433448b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f433447a, r101.f433447a) == true) goto L12;
            return false;
        L12:
            if (this.f433448b == r101.f433448b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f433447a.hashCode() * 31;
            long r101 = this.f433448b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "Entry(name=" + this.f433447a + ", startNs=" + this.f433448b + ')';
        }

        public b(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f433447a = r100;
            this.f433448b = r101;
        }
    }

    static {
    }

    @Inject
    public h() {
        this.f433446a = new ConcurrentHashMap();
    }

    @Override // eva.a
    public final void endSection() {
        long r100 = ThreadMethodProxy.currentThread().getId();
        String r101 = ThreadMethodProxy.currentThread().getName();
        b r102 = this.f433446a.remove(Long.valueOf(r100));
        if (r102 != null) goto L6;
        Log.w("OfficeSdkLaunchPerfDispatcher", "OfficeSDK_Boot_Init_Task_End_WithoutBegin @tid=" + r100 + '/' + r101);
        return;
    L6:
        long r103 = (SystemClock.elapsedRealtimeNanos() - r102.f433448b) / ((long) 1000000);
        Log.i("OfficeSdkLaunchPerfDispatcher", "OfficeSDK_Boot_Init_Task_End: " + r102.f433447a + ", cost: " + r103 + "ms");
        HashMap<String, com.ss.android.lark.officesdk.internal.b> r104 = com.ss.android.lark.officesdk.internal.g.f433363a;
        String r105 = r102.f433447a;
        Intrinsics.checkNotNullParameter(r105, "name");
        com.ss.android.lark.officesdk.internal.g.a(r105, "init", r103);
    }

    @Override // eva.a
    public final void beginSection(String r110) {
        Intrinsics.checkNotNullParameter(r110, "name");
        long r100 = ThreadMethodProxy.currentThread().getId();
        String r101 = ThreadMethodProxy.currentThread().getName();
        b r102 = this.f433446a.put(Long.valueOf(r100), new b(r110, SystemClock.elapsedRealtimeNanos()));
        if (r102 == null) goto L5;
        Log.i("OfficeSdkLaunchPerfDispatcher", "OfficeSDK_Boot_Init_Task_Overlap: prev=" + r102.f433447a + " replaced by " + r110 + " @tid=" + r100 + '/' + r101);
    L5:
        Log.i("OfficeSdkLaunchPerfDispatcher", "OfficeSDK_Boot_Init_Task_Begin: " + r110 + " @tid=" + r100 + '/' + r101);
    }
}
