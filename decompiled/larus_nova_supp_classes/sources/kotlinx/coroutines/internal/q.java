package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class q<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = null;
    public static final /* synthetic */ AtomicLongFieldUpdater f = null;
    public static final b0 g = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    public final int a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;

    public static final class a {
    }

    public static final class b {
        public final int a;

        public b(int r1) {
            this.a = r1;
        }
    }

    static {
        e = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next$volatile");
        f = AtomicLongFieldUpdater.newUpdater(q.class, "_state$volatile");
        g = new b0("REMOVE_FROZEN");
    }

    public final boolean b() {
        AtomicLongFieldUpdater r6 = f;
    L3:
        long r2 = r6.get(this);
        if ((r2 & 2305843009213693952L) != 0) goto L5;
        if ((1152921504606846976L & r2) != 0) goto L8;
        if (r6.compareAndSet(this, r2, r2 | 2305843009213693952L) == false) goto L3;
        return true;
    L8:
        return false;
    L5:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final q<E> c() {
        AtomicLongFieldUpdater r6 = f;
    L3:
        long r2 = r6.get(this);
        if ((r2 & 1152921504606846976L) != 0) goto L9;
        long r7 = r2 | 1152921504606846976L;
        if (r6.compareAndSet(this, r2, r7) == false) goto L3;
        r2 = r7;
    L9:
        AtomicReferenceFieldUpdater r0 = e;
    L10:
        q<E> r1 = (q) r0.get(this);
        if (r1 != null) goto L12;
        AtomicReferenceFieldUpdater r3 = e;
        q r4 = new q(this.a * 2, this.b);
        int r8 = (int) ((1073741823 & r2) >> 0);
        int r5 = (int) ((1152921503533105152L & r2) >> 30);
    L14:
        int r9 = this.c;
        int r10 = r8 & r9;
        if (r10 == (r9 & r5)) goto L20;
        Object r11 = this.d.get(r10);
        if (r11 != null) goto L19;
        r11 = new b(r8);
    L19:
        r4.d.set(r4.c & r8, r11);
        r8 = r8 + 1;
        goto L14
    L20:
        f.set(r4, (-1152921504606846977L) & r2);
    L22:
        if (r3.compareAndSet(this, null, r4) == true) goto L10;
        if (r3.get(this) == null) goto L22;
    L12:
        return r1;
    }

    public final Object d() {
        AtomicLongFieldUpdater r7 = f;
    L3:
        long r2 = r7.get(this);
        if ((r2 & 1152921504606846976L) != 0) goto L6;
        int r15 = (int) ((r2 & 1073741823) >> 0);
        int r0 = this.c;
        int r1 = ((int) ((1152921503533105152L & r2) >> 30)) & r0;
        int r3 = r0 & r15;
        if (r1 == r3) goto L9;
        Object r5 = this.d.get(r3);
        if (r5 == null) goto L13;
        if ((r5 instanceof b) == true) goto L17;
        long r21 = ((long) ((r15 + 1) & 1073741823)) << 0;
        if (f.compareAndSet(this, r2, (r2 & (-1073741824)) | r21) == true) goto L20;
        if (this.b == false) goto L3;
        q<E> r4 = this;
    L25:
        AtomicLongFieldUpdater r6 = f;
    L26:
        long r25 = r6.get(r4);
        int r8 = (int) ((r25 & 1073741823) >> 0);
        if ((r25 & 1152921504606846976L) != 0) goto L28;
        if (f.compareAndSet(r4, r25, (r25 & (-1073741824)) | r21) == false) goto L26;
        r4.d.set(r4.c & r8, null);
        r4 = null;
    L32:
        if (r4 != null) goto L25;
        return r5;
    L28:
        r4 = r4.c();
        goto L32
    L20:
        this.d.set(this.c & r15, null);
        return r5;
    L17:
        return null;
    L13:
        if (this.b == false) goto L3;
        return null;
    L9:
        return null;
    L6:
        return g;
    }

    public final int a(E r17) {
        AtomicLongFieldUpdater r8 = f;
    L3:
        long r2 = r8.get(this);
        if ((3458764513820540928L & r2) != 0) goto L6;
        int r1 = (int) ((1073741823 & r2) >> 0);
        int r13 = (int) ((1152921503533105152L & r2) >> 30);
        int r12 = this.c;
        if (((r13 + 2) & r12) == (r1 & r12)) goto L11;
        if (this.b == true) goto L22;
        if (this.d.get(r13 & r12) == null) goto L22;
        int r0 = this.a;
        if (r0 < 1024) goto L20;
        if (((r13 - r1) & 1073741823) <= (r0 >> 1)) goto L3;
    L20:
        return 1;
    L22:
        if (f.compareAndSet(this, r2, ((-1152921503533105153L) & r2) | (((long) ((r13 + 1) & 1073741823)) << 30)) == false) goto L3;
        this.d.set(r13 & r12, r17);
        q<E> r3 = this;
    L25:
        if ((f.get(r3) & 1152921504606846976L) == 0) goto L33;
        r3 = r3.c();
        Object r4 = r3.d.get(r3.c & r13);
        if ((r4 instanceof b) == true) goto L29;
    L31:
        r3 = null;
    L32:
        if (r3 != null) goto L25;
    L29:
        if (((b) r4).a != r13) goto L31;
        r3.d.set(r3.c & r13, r17);
    L33:
        return 0;
    L11:
        return 1;
    L6:
        if ((2305843009213693952L & r2) == 0) goto L50;
        return 2;
    L50:
        return 1;
    }

    public q(int r5, boolean r6) {
        this.a = r5;
        this.b = r6;
        int r7 = r5 - 1;
        this.c = r7;
        this.d = new AtomicReferenceArray(r5);
        boolean r1 = false;
        if (r7 > 1073741823) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L16;
        if ((r5 & r7) != 0) goto L11;
        r1 = true;
    L11:
        if (r1 == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r0 = false;
        goto L7
    }
}
