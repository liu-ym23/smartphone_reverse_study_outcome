package com.bytedance.live.livelink.kmp.impl.base.thread;

import com.bytedance.live.livelink.kmp.impl.base.log.TraceEvent;
import ej6.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import oi6.b;
import oi6.d;

/* JADX INFO: loaded from: classes19.dex */
public final class ThreadManager implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f255333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f255334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f255335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f255336e;

    public static final class a {
    }

    static {
    }

    public final void g() {
        ((b) this.f255333b.getValue()).release();
        ((b) this.f255335d.getValue()).release();
        ((b) this.f255334c.getValue()).release();
        Iterator r100 = ((ArrayList) this.f255336e).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).release();
        goto L4
    L6:
        ((ArrayList) this.f255336e).clear();
    }

    public ThreadManager() {
        this.f255333b = LazyKt.lazy(ThreadManager$workThread$2.INSTANCE);
        this.f255334c = LazyKt.lazy(ThreadManager$logUpThread$2.INSTANCE);
        this.f255335d = LazyKt.lazy(ThreadManager$clientMixThread$2.INSTANCE);
        this.f255336e = new ArrayList();
    }

    @Override // oi6.d
    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "thread");
        ((ArrayList) this.f255336e).remove(r100);
        r100.release();
    }

    @Override // oi6.d
    public final CustomWorkThreadImpl e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        CustomWorkThreadImpl r101 = new CustomWorkThreadImpl(r100);
        ((ArrayList) this.f255336e).add(r101);
        return r101;
    }

    @Override // oi6.d
    public final long a(Function0<Unit> r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "taskInfo");
        if (((b) this.f255333b.getValue()).a(r100, r101, r102) == false) goto L5;
        return 0;
    L5:
        return -1;
    }

    @Override // oi6.d
    public final long c(Function0<Unit> r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "taskInfo");
        if (((b) this.f255335d.getValue()).a(r100, r101, r102) == false) goto L5;
        return 0;
    L5:
        return -1;
    }

    @Override // oi6.d
    public final long d(Function0<Unit> r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "taskInfo");
        if (((b) this.f255334c.getValue()).a(r100, r101, r102) == false) goto L5;
        return 0;
    L5:
        return -1;
    }

    @Override // oi6.d
    public final long f(Function0 r110, boolean r111, long r112) {
        Intrinsics.checkNotNullParameter(r110, "task");
        Intrinsics.checkNotNullParameter("Video_VideoSubscribeMixerPushNode pushMixedFrame", "taskInfo");
        if (r111 == false) goto L15;
        if (((b) this.f255335d.getValue()).a(r110, "Video_VideoSubscribeMixerPushNode pushMixedFrame", r112) == false) goto L8;
        return 0;
    L8:
        return -1;
    L15:
        r110.invoke();     // Catch: Exception -> L12
        return 0;
    L12:
        e = move-exception;
        int r100 = ej6.a.f472874a;
        ej6.a.b("ThreadManager", "submitTask error, submitClientMixTask taskInfo: Video_VideoSubscribeMixerPushNode pushMixedFrame, ex: " + e);
        int r101 = e.f472877a;
        e.a(TraceEvent.THREAD_MANAGER, "submitTaskError", 0, "submitTask error, submitClientMixTask taskInfo: Video_VideoSubscribeMixerPushNode pushMixedFrame, ex: " + e, null, 20);
        return -1;
    }
}
