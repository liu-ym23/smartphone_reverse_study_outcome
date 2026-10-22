package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class e<N extends e<N>> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = null;
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next$volatile");
        b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev$volatile");
    }

    public abstract boolean d();

    public final void b() {
        b.set(this, null);
    }

    public final N c() {
        Object r0 = a.get(this);
        if (r0 != d.a) goto L7;
        return null;
    L7:
        return (N) r0;
    }

    public final void e() {
        if (c() != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        e r1 = (e) b.get(this);
    L9:
        if (r1 == null) goto L13;
        if (r1.d() == false) goto L13;
        r1 = (e) b.get(r1);
    L13:
        e r3 = c();
        Intrinsics.checkNotNull(r3);
    L15:
        if (r3.d() == false) goto L20;
        e r4 = r3.c();
        if (r4 == null) goto L20;
        r3 = r4;
    L20:
        AtomicReferenceFieldUpdater r5 = b;
    L21:
        Object r6 = r5.get(r3);
        if (((e) r6) != null) goto L24;
        e r7 = null;
    L26:
        if (r5.compareAndSet(r3, r6, r7) == true) goto L27;
        if (r5.get(r3) == r6) goto L26;
        boolean r8 = false;
    L31:
        if (r8 == false) goto L21;
        if (r1 == null) goto L35;
        a.set(r1, r3);
    L35:
        if (r3.d() == false) goto L41;
        if (r3.c() != null) goto L39;
        boolean r9 = true;
    L40:
        if (r9 == false) goto L8;
    L39:
        r9 = false;
    L41:
        if (r1 == null) goto L44;
        if (r1.d() == true) goto L8;
        return;
    L44:
        return;
    L27:
        r8 = true;
        goto L31
    L24:
        r7 = r1;
        goto L26
    L5:
        r0 = false;
        goto L6
    }

    public e(N r1) {
        this._prev$volatile = r1;
    }
}
