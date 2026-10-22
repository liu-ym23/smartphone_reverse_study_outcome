package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class e<N extends e<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504941a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504942b = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    static {
        f504941a = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next$volatile");
        f504942b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev$volatile");
    }

    public abstract boolean d();

    public final void b() {
        f504942b.set(this, null);
    }

    public final N c() {
        Object r100 = f504941a.get(this);
        if (r100 != d.f504939a) goto L7;
        return null;
    L7:
        return (N) r100;
    }

    public final void e() {
        if (c() != null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        e r101 = (e) f504942b.get(this);
    L9:
        if (r101 == null) goto L13;
        if (r101.d() == false) goto L13;
        r101 = (e) f504942b.get(r101);
    L13:
        e r102 = c();
        Intrinsics.checkNotNull(r102);
    L15:
        if (r102.d() == false) goto L20;
        e r103 = r102.c();
        if (r103 == null) goto L20;
        r102 = r103;
    L20:
        AtomicReferenceFieldUpdater r104 = f504942b;
    L21:
        Object r105 = r104.get(r102);
        if (((e) r105) != null) goto L24;
        e r106 = null;
    L26:
        if (r104.compareAndSet(r102, r105, r106) == true) goto L27;
        if (r104.get(r102) == r105) goto L26;
        boolean r107 = false;
    L31:
        if (r107 == false) goto L21;
        if (r101 == null) goto L35;
        f504941a.set(r101, r102);
    L35:
        if (r102.d() == false) goto L41;
        if (r102.c() != null) goto L39;
        boolean r108 = true;
    L40:
        if (r108 == false) goto L8;
    L39:
        r108 = false;
    L41:
        if (r101 == null) goto L44;
        if (r101.d() == true) goto L8;
        return;
    L44:
        return;
    L27:
        r107 = true;
        goto L31
    L24:
        r106 = r101;
        goto L26
    L5:
        r100 = false;
        goto L6
    }

    public e(N r100) {
        this._prev$volatile = r100;
    }
}
