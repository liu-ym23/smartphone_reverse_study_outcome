package com.ss.android.lark.videosend.checker.raw;

import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.ttve.nativePort.TEVideoUtils;
import com.ss.android.vesdk.VEAVInterleaveChecker;
import com.ss.android.vesdk.r;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class InterLeaveChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f444857a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, VEAVInterleaveChecker> f444858b = null;

    public interface a {
        void a(String r100, boolean r101);
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f444859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f444860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VEAVInterleaveChecker f444861c;

        public b(String r100, boolean r101, VEAVInterleaveChecker r102) {
            this.f444859a = r100;
            this.f444860b = r101;
            this.f444861c = r102;
        }

        public final void a() {
            Log.i("InterLeaveChecker", "releaseChecker, mediaPath:" + this.f444859a.hashCode() + ", isAbnormalInterleaved:" + this.f444860b);
            VEAVInterleaveChecker r100 = this.f444861c;
            long r101 = r100.f455509a;
            if (0 >= r101) goto L6;
            TEVideoUtils.AVInterleaveCheckExecute(r101, 255);
            r100.f455509a = -1;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f444857a = LazyKt.lazy(InterLeaveChecker$BAD_AV_DIFF$2.INSTANCE);
        f444858b = new ConcurrentHashMap();
    }

    public static void a(String r110, com.ss.android.lark.videosend.checker.raw.b r111) {
        Intrinsics.checkNotNullParameter(r110, "mediaPath");
        Intrinsics.checkNotNullParameter(r111, "callback");
        ConcurrentHashMap<String, VEAVInterleaveChecker> r100 = f444858b;
        if (r100.containsKey(r110) == false) goto L6;
        r111.a(r110, true);
        return;
    L6:
        VEAVInterleaveChecker r101 = new VEAVInterleaveChecker();
        r100.put(r110, r101);
        long r102 = ((Number) f444857a.getValue()).longValue();
        c r103 = new c(r110, r111);
        long r104 = r101.f455509a;
        if ((-1) != r104) goto L9;
    L11:
        long r105 = TEVideoUtils.AVInterleaveCheckInit(r110, r102, new r(r103));
        r101.f455509a = r105;
        Log.i("InterLeaveChecker", "check, mediaPath:" + r110.hashCode() + ", resultCode:" + r105);
        if (r105 == (-1)) goto L14;
        TEVideoUtils.AVInterleaveCheckExecute(r101.f455509a, 0);
        return;
    L14:
        b(r110, r111, true);
        return;
    L9:
        if (0 >= r104) goto L11;
        TEVideoUtils.AVInterleaveCheckExecute(r104, 255);
        r101.f455509a = -1;
        goto L11
    }

    public static void b(String r100, a r101, boolean r102) {
        VEAVInterleaveChecker r103 = f444858b.remove(r100);
        if (r103 == null) goto L6;
        UICallbackExecutor.execute(new b(r100, r102, r103));
        r101.a(r100, r102);
        return;
    }
}
