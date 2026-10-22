package if9;

import com.larus.im.internal.network.link.impl.rtc.e;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f489635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile if9.a f489636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile kf9.a f489637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f489638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile e f489639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f489640f;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f489635a = new ReentrantReadWriteLock();
        this.f489640f = new AtomicBoolean(false);
    }

    public final void a(if9.a r110) {
        Intrinsics.checkNotNullParameter(r110, "step");
        ReentrantReadWriteLock r100 = this.f489635a;
        ReentrantReadWriteLock.ReadLock r101 = r100.readLock();
        int r102 = 0;
        if (r100.getWriteHoldCount() != 0) goto L5;
        int r103 = r100.getReadHoldCount();
    L6:
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L9;
        r101.unlock();
        r104 = r104 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r105 = r100.writeLock();
        r105.lock();
    L36:
        th = move-exception;
    L37:
        if (r102 >= r103) goto L39;
        r101.lock();
        r102 = r102 + 1;
        goto L37
    L39:
        r105.unlock();
        throw th;
    L12:
        if (this.f489638d == false) goto L14;
        com.larus.im.internal.delegate.a.f348188b.i("FlowAVConnectionTraceData", "[addStep] Trace data is stabled, cannot add step.");     // Catch: Throwable -> L36
    L29:
        if (r102 >= r103) goto L31;
        r101.lock();
        r102 = r102 + 1;
        goto L29
    L31:
        r105.unlock();
        return;
    L14:
        if9.a r106 = this.f489636b;     // Catch: Throwable -> L36
        if (r106 != null) goto L17;
        r110.f489634i = null;     // Catch: Throwable -> L36
        this.f489636b = r110;     // Catch: Throwable -> L36
        goto L29
    L17:
        ReentrantReadWriteLock.ReadLock r107 = this.f489635a.readLock();     // Catch: Throwable -> L36
        r107.lock();     // Catch: Throwable -> L36
        if9.a r108 = this.f489636b;     // Catch: Throwable -> L33
        if (r108 == null) goto L24;
        boolean r109 = true;
        if (r108.d(r110) != true) goto L24;
    L25:
        r107.unlock();     // Catch: Throwable -> L36
        if (r109 == false) goto L28;
        com.larus.im.internal.delegate.a.f348188b.i("FlowAVConnectionTraceData", "[addStep] Repeat step, name: " + r110.f489626a);     // Catch: Throwable -> L36
        goto L29
    L28:
        r110.f489634i = r106;     // Catch: Throwable -> L36
        r106.a(r110);     // Catch: Throwable -> L36
        goto L29
    L24:
        r109 = false;
    L33:
        th = move-exception;
        r107.unlock();     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L5:
        r103 = 0;
        goto L6
    }

    public final if9.a c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stepName");
        ReentrantReadWriteLock.ReadLock r101 = this.f489635a.readLock();
        r101.lock();
        if9.a r102 = this.f489636b;     // Catch: Throwable -> L13
        if (r102 == null) goto L10;
        Intrinsics.checkNotNullParameter(r100, "stepName");     // Catch: Throwable -> L13
        if9.a r103 = r102.f489634i;     // Catch: Throwable -> L13
        int r104 = if9.a.f489625j;     // Catch: Throwable -> L13
        if (r103 == null) goto L8;
        if9.a r105 = if9.a.C6259a.a(r103, r100);     // Catch: Throwable -> L13
    L11:
        r101.unlock();
        return r105;
    L8:
        r105 = if9.a.C6259a.a(r102, r100);     // Catch: Throwable -> L13
        goto L11
    L10:
        r105 = null;
    L13:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final void d(long r100) {
        ReentrantReadWriteLock r101 = this.f489635a;
        ReentrantReadWriteLock.ReadLock r102 = r101.readLock();
        int r103 = 0;
        if (r101.getWriteHoldCount() != 0) goto L5;
        int r104 = r101.getReadHoldCount();
    L6:
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r102.unlock();
        r105 = r105 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r106 = r101.writeLock();
        r106.lock();
    L22:
        th = move-exception;
    L23:
        if (r103 >= r104) goto L25;
        r102.lock();
        r103 = r103 + 1;
        goto L23
    L25:
        r106.unlock();
        throw th;
    L11:
        if (this.f489638d == true) goto L17;
        this.f489638d = true;     // Catch: Throwable -> L22
        if9.a r107 = this.f489636b;     // Catch: Throwable -> L22
        if (r107 == null) goto L17;
        if9.a r108 = r107.m();     // Catch: Throwable -> L22
        if (r108 == null) goto L17;
        r108.f(r100);     // Catch: Throwable -> L22
    L17:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L22
    L18:
        if (r103 >= r104) goto L20;
        r102.lock();
        r103 = r103 + 1;
        goto L18
    L20:
        r106.unlock();
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public final void b(int r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        ReentrantReadWriteLock r103 = this.f489635a;
        ReentrantReadWriteLock.ReadLock r104 = r103.readLock();
        int r105 = 0;
        if (r103.getWriteHoldCount() != 0) goto L5;
        int r106 = r103.getReadHoldCount();
    L6:
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L9;
        r104.unlock();
        r107 = r107 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r108 = r103.writeLock();
        r108.lock();
    L24:
        th = move-exception;
    L25:
        if (r105 >= r106) goto L27;
        r104.lock();
        r105 = r105 + 1;
        goto L25
    L27:
        r108.unlock();
        throw th;
    L11:
        if (this.f489638d == true) goto L19;
        if9.a r109 = this.f489636b;     // Catch: Throwable -> L24
        if (r109 == null) goto L15;
        r109.f489629d = r100;     // Catch: Throwable -> L24
    L15:
        if9.a r110 = this.f489636b;     // Catch: Throwable -> L24
        if (r110 == null) goto L18;
        r110.f489630e = r101;     // Catch: Throwable -> L24
    L18:
        d(r102);     // Catch: Throwable -> L24
    L19:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L20:
        if (r105 >= r106) goto L22;
        r104.lock();
        r105 = r105 + 1;
        goto L20
    L22:
        r108.unlock();
        return;
    L5:
        r106 = 0;
        goto L6
    }
}
