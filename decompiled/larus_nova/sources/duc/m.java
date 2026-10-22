package duc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f470079b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f470080c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f470081d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f470082e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray<g> f470083a;
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    static {
        f470079b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask$volatile");
        f470080c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex$volatile");
        f470081d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex$volatile");
        f470082e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer$volatile");
    }

    public final int b() {
        return f470080c.get(this) - f470081d.get(this);
    }

    public final g c() {
    L2:
        AtomicIntegerFieldUpdater r100 = f470081d;
        int r101 = r100.get(this);
        if ((r101 - f470080c.get(this)) == 0) goto L4;
        int r102 = r101 & 127;
        if (r100.compareAndSet(this, r101, r101 + 1) == false) goto L2;
        g r103 = this.f470083a.getAndSet(r102, null);
        if (r103 == null) goto L2;
        boolean r104 = true;
        if (r103.f470067b.getTaskMode() == 1) goto L14;
        r104 = false;
    L14:
        if (r104 == false) goto L16;
        f470082e.decrementAndGet(this);
    L16:
        return r103;
    L4:
        return null;
    }

    public m() {
        this.f470083a = new AtomicReferenceArray(128);
    }

    public final g a(g r100) {
        if (b() != 127) goto L5;
        return r100;
    L5:
        boolean r101 = true;
        if (r100.f470067b.getTaskMode() == 1) goto L9;
        r101 = false;
    L9:
        if (r101 == false) goto L11;
        f470082e.incrementAndGet(this);
    L11:
        int r102 = f470080c.get(this) & 127;
    L13:
        if (this.f470083a.get(r102) == null) goto L15;
        Thread.yield();
        goto L13
    L15:
        this.f470083a.lazySet(r102, r100);
        f470080c.incrementAndGet(this);
        return null;
    }

    public final g d(int r100, boolean r101) {
        int r102 = r100 & 127;
        g r103 = this.f470083a.get(r102);
        if (r103 == null) goto L19;
        boolean r104 = false;
        if (r103.f470067b.getTaskMode() != 1) goto L7;
        boolean r105 = true;
    L8:
        if (r105 != r101) goto L19;
        AtomicReferenceArray<g> r106 = this.f470083a;
    L11:
        if (r106.compareAndSet(r102, r103, null) == true) goto L12;
        if (r106.get(r102) == r103) goto L11;
    L15:
        if (r104 == false) goto L19;
        if (r101 == false) goto L18;
        f470082e.decrementAndGet(this);
    L18:
        return r103;
    L12:
        r104 = true;
        goto L15
    L7:
        r105 = false;
    L19:
        return null;
    }
}
