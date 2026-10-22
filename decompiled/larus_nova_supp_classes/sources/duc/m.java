package duc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class m {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = null;
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = null;
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = null;
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = null;
    public final AtomicReferenceArray<g> a;
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    static {
        b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask$volatile");
        c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex$volatile");
        d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex$volatile");
        e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer$volatile");
    }

    public final int b() {
        return c.get(this) - d.get(this);
    }

    public final g c() {
    L2:
        AtomicIntegerFieldUpdater r0 = d;
        int r1 = r0.get(this);
        if ((r1 - c.get(this)) == 0) goto L4;
        int r2 = r1 & 127;
        if (r0.compareAndSet(this, r1, r1 + 1) == false) goto L2;
        g r3 = this.a.getAndSet(r2, null);
        if (r3 == null) goto L2;
        boolean r4 = true;
        if (r3.b.getTaskMode() == 1) goto L14;
        r4 = false;
    L14:
        if (r4 == false) goto L16;
        e.decrementAndGet(this);
    L16:
        return r3;
    L4:
        return null;
    }

    public m() {
        this.a = new AtomicReferenceArray(128);
    }

    public final g a(g r4) {
        if (b() != 127) goto L5;
        return r4;
    L5:
        boolean r2 = true;
        if (r4.b.getTaskMode() == 1) goto L9;
        r2 = false;
    L9:
        if (r2 == false) goto L11;
        e.incrementAndGet(this);
    L11:
        int r0 = c.get(this) & 127;
    L13:
        if (this.a.get(r0) == null) goto L15;
        Thread.yield();
        goto L13
    L15:
        this.a.lazySet(r0, r4);
        c.incrementAndGet(this);
        return null;
    }

    public final g d(int r7, boolean r8) {
        int r9 = r7 & 127;
        g r0 = this.a.get(r9);
        if (r0 == null) goto L19;
        boolean r3 = false;
        if (r0.b.getTaskMode() != 1) goto L7;
        boolean r2 = true;
    L8:
        if (r2 != r8) goto L19;
        AtomicReferenceArray<g> r4 = this.a;
    L11:
        if (r4.compareAndSet(r9, r0, null) == true) goto L12;
        if (r4.get(r9) == r0) goto L11;
    L15:
        if (r3 == false) goto L19;
        if (r8 == false) goto L18;
        e.decrementAndGet(this);
    L18:
        return r0;
    L12:
        r3 = true;
        goto L15
    L7:
        r2 = false;
    L19:
        return null;
    }
}
