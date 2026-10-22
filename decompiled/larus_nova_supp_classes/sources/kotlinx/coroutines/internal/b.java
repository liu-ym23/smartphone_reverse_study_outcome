package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class b<T> extends u {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = null;
    private volatile /* synthetic */ Object _consensus$volatile;

    static {
        a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus$volatile");
    }

    public abstract void b(T r1, Object r2);

    public abstract b0 c(Object r1);

    public b() {
        this._consensus$volatile = a.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.u
    public final Object a(Object r5) {
        AtomicReferenceFieldUpdater r0 = a;
        Object r1 = r0.get(this);
        b0 r2 = a.a;
        if (r1 != r2) goto L16;
        b0 r3 = c(r5);
        r1 = r0.get(this);
        if (r1 != r2) goto L16;
    L8:
        if (r0.compareAndSet(this, r2, r3) == true) goto L9;
        if (r0.get(this) == r2) goto L8;
        boolean r4 = false;
    L13:
        if (r4 == false) goto L15;
        r1 = r3;
        goto L16
    L15:
        r1 = a.get(this);
        goto L16
    L9:
        r4 = true;
    L16:
        b(r5, r1);
        return r1;
    }
}
