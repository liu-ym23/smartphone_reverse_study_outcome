package com.bytedance.bdp.appbase.chain;

import android.os.SystemClock;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import com.bytedance.bdp.appbase.base.bdptask.BdpTrace;
import com.bytedance.bdp.appbase.base.bdptask.TracePoint;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a<T> f200720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m<? super T, ?> f200721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<TracePoint> f200722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f200723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f200724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f200725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f200726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BdpTask.Builder f200727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f200728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f200729k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f200730l;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f200731a;

        public a(T r100) {
            this.f200731a = r100;
        }
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f200732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f200733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f200734c;

        public b(f0 r100, e r101, Object r102) {
            this.f200732a = r100;
            this.f200733b = r101;
            this.f200734c = r102;
        }

        @Override // java.util.concurrent.Callable
        public final Unit call() {
            e r100 = this.f200733b;
            if (r100 == null) goto L5;
            this.f200732a.f200729k.f200699e = r100;
        L6:
            f0 r101 = this.f200732a;
            f r102 = r101.f200729k;
            r102.f200714t = r101.f200727i;
            r102.f200713s = null;
            m<? super T, ?> r103 = r101.f200721c;
            if (r103 == null) goto L12;
            m<?, ?> r104 = r103.g(r102);
            if (r104 == null) goto L13;
            r104.b(this.f200732a.f200729k);
            return Unit.INSTANCE;
        L13:
            return null;
        L12:
            return null;
        L5:
            f r105 = this.f200732a.f200729k;
            r105.f200698d = this.f200734c;
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public final void a() {
        Object r100 = this.f200723e;
        monitor-enter(r100);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.f200720b == null) goto L7;
    L20:
        monitor-exit(r100);
        return;
    L7:
        if (this.f200724f != null) goto L20;
        if (BdpTrace.ENABLE == false) goto L12;
        String r101 = "FL." + this.f200729k.f200695a + '_' + this.f200719a + ' ';     // Catch: Throwable -> L22
    L13:
        this.f200724f = new e(new CancelEvent(r101 + "CANCEL " + this.f200728j));     // Catch: Throwable -> L22
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r100);
        Integer r103 = this.f200725g;
        if (r103 == null) goto L18;
        BdpPool.cancelTask(r103.intValue());
    L18:
        c(this.f200724f, null, "CANCEL", this.f200728j);
        return;
    L12:
        r101 = "";
        goto L13
    }

    public final void e() throws SuspendEvent {
        if (BdpTrace.ENABLE == false) goto L24;
        Object r100 = this.f200723e;
        monitor-enter(r100);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.f200720b != null) goto L19;
        if (this.f200724f != null) goto L19;
        this.f200726h = Long.valueOf(SystemClock.elapsedRealtime());     // Catch: Throwable -> L20
        if (BdpTrace.ENABLE == false) goto L13;
        String r101 = "FL." + this.f200729k.f200695a + '_' + this.f200719a + " SUSPEND " + this.f200728j;     // Catch: Throwable -> L20
    L14:
        TracePoint r102 = new TracePoint(r101, "", 3);     // Catch: Throwable -> L20
        BdpTrace.addNewPointToList(this.f200722d, r102);     // Catch: Throwable -> L20
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r100);
        BdpTrace.sectionPoint(r102);
        throw new SuspendEvent(this);
    L13:
        r101 = "";
    L19:
        throw new SuspendEvent(this);     // Catch: Throwable -> L20
    L24:
        throw new SuspendEvent(this);
    }

    public final void b(T r100) {
        Object r101 = this.f200723e;
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f200720b == null) goto L7;
    L16:
        monitor-exit(r101);
        return;
    L7:
        if (this.f200724f != null) goto L16;
        this.f200720b = new a(r100);     // Catch: Throwable -> L18
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r101);
        Integer r103 = this.f200725g;
        if (r103 == null) goto L14;
        BdpPool.cancelTask(r103.intValue());
    L14:
        c(null, r100, "RESUME", this.f200728j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(m<? super T, ?> r100) {
        Object r101 = this.f200723e;
        monitor-enter(r101);
        this.f200721c = r100;     // Catch: Throwable -> L10
        if (this.f200730l == false) goto L7;
        this.f200729k.f200713s = this;     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public f0(f r100, boolean r101) {
        this.f200729k = r100;
        this.f200730l = r101;
        this.f200719a = Chain.f200668k.incrementAndGet();
        LinkedList<TracePoint> r102 = BdpTrace.a();
        BdpTask.TaskType r103 = null;
        if (r102 == null) goto L5;
        LinkedList<TracePoint> r104 = new LinkedList(r102);
    L6:
        if (r104 != null) goto L8;
        r104 = new LinkedList();
    L8:
        this.f200722d = r104;
        this.f200723e = new Object();
        BdpTask r105 = BdpPool.curThreadTask();
        if (r105 != null) goto L11;
    L20:
        BdpTask.Builder r106 = new BdpTask.Builder();
        if (BdpPool.isOnMain() == false) goto L28;
        BdpTask r107 = r100.f200715u;
        if (r107 == null) goto L26;
        r103 = r107.taskType;
    L26:
        if (r103 == BdpTask.TaskType.MAIN) goto L28;
        r106.onMain();
    L28:
        Unit r108 = Unit.INSTANCE;
    L29:
        this.f200727i = r106;
        this.f200728j = "";
        return;
    L11:
        if (Intrinsics.areEqual(r105, r100.f200715u) == false) goto L18;
        BdpTask.TaskType r109 = r105.taskType;
        if (r109 != BdpTask.TaskType.MAIN) goto L15;
    L16:
        r109 = BdpTask.TaskType.CPU;
    L17:
        r106 = new BdpTask.Builder().taskType(r109);
    L19:
        if (r106 != null) goto L29;
    L15:
        if (r109 != BdpTask.TaskType.LOGIC) goto L17;
    L18:
        r106 = r105.newBuilder().delayedMillis(0).stageListener(null);
        goto L19
    L5:
        r104 = null;
        goto L6
    }

    public final void c(e r100, T r101, String r102, String r103) {
        Long r104 = this.f200726h;
        if (r104 == null) goto L5;
        long r105 = SystemClock.elapsedRealtime() - r104.longValue();
    L7:
        if (BdpTrace.ENABLE == false) goto L9;
        String r106 = "FL." + this.f200729k.f200695a + '_' + this.f200719a + ' ' + r102 + " D:" + r105 + ' ' + r103;
    L10:
        BdpPool.directRun(r106, this.f200722d, new b(this, r100, r101));
        return;
    L9:
        r106 = "";
        goto L10
    L5:
        r105 = 0;
        goto L7
    }
}
