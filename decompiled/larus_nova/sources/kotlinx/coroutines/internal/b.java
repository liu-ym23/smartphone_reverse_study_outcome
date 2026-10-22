package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504936a = null;
    private volatile /* synthetic */ Object _consensus$volatile;

    static {
        f504936a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus$volatile");
    }

    public abstract void b(T r100, Object r101);

    public abstract b0 c(Object r100);

    public b() {
        this._consensus$volatile = a.f504934a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.u
    public final Object a(Object r100) {
        AtomicReferenceFieldUpdater r101 = f504936a;
        Object r102 = r101.get(this);
        b0 r103 = a.f504934a;
        if (r102 != r103) goto L16;
        b0 r104 = c(r100);
        r102 = r101.get(this);
        if (r102 != r103) goto L16;
    L8:
        if (r101.compareAndSet(this, r103, r104) == true) goto L9;
        if (r101.get(this) == r103) goto L8;
        boolean r105 = false;
    L13:
        if (r105 == false) goto L15;
        r102 = r104;
        goto L16
    L15:
        r102 = f504936a.get(this);
        goto L16
    L9:
        r105 = true;
    L16:
        b(r100, r102);
        return r102;
    }
}
