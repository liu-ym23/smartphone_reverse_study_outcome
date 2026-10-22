package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class q<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f504972e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f504973f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b0 f504974g = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f504975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f504976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f504977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f504978d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f504979a;

        public b(int r100) {
            this.f504979a = r100;
        }
    }

    static {
        f504972e = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next$volatile");
        f504973f = AtomicLongFieldUpdater.newUpdater(q.class, "_state$volatile");
        f504974g = new b0("REMOVE_FROZEN");
    }

    public final boolean b() {
        AtomicLongFieldUpdater r100 = f504973f;
    L3:
        long r101 = r100.get(this);
        if ((r101 & 2305843009213693952L) != 0) goto L5;
        if ((1152921504606846976L & r101) != 0) goto L8;
        if (r100.compareAndSet(this, r101, r101 | 2305843009213693952L) == false) goto L3;
        return true;
    L8:
        return false;
    L5:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final q<E> c() {
        AtomicLongFieldUpdater r100 = f504973f;
    L3:
        long r101 = r100.get(this);
        if ((r101 & 1152921504606846976L) != 0) goto L9;
        long r102 = r101 | 1152921504606846976L;
        if (r100.compareAndSet(this, r101, r102) == false) goto L3;
        r101 = r102;
    L9:
        AtomicReferenceFieldUpdater r103 = f504972e;
    L10:
        q<E> r104 = (q) r103.get(this);
        if (r104 != null) goto L12;
        AtomicReferenceFieldUpdater r105 = f504972e;
        q r106 = new q(this.f504975a * 2, this.f504976b);
        int r107 = (int) ((1073741823 & r101) >> 0);
        int r108 = (int) ((1152921503533105152L & r101) >> 30);
    L14:
        int r109 = this.f504977c;
        int r110 = r107 & r109;
        if (r110 == (r109 & r108)) goto L20;
        Object r111 = this.f504978d.get(r110);
        if (r111 != null) goto L19;
        r111 = new b(r107);
    L19:
        r106.f504978d.set(r106.f504977c & r107, r111);
        r107 = r107 + 1;
        goto L14
    L20:
        f504973f.set(r106, (-1152921504606846977L) & r101);
    L22:
        if (r105.compareAndSet(this, null, r106) == true) goto L10;
        if (r105.get(this) == null) goto L22;
    L12:
        return r104;
    }

    public final Object d() {
        AtomicLongFieldUpdater r100 = f504973f;
    L3:
        long r101 = r100.get(this);
        if ((r101 & 1152921504606846976L) != 0) goto L6;
        int r110 = (int) ((r101 & 1073741823) >> 0);
        int r102 = this.f504977c;
        int r103 = ((int) ((1152921503533105152L & r101) >> 30)) & r102;
        int r104 = r102 & r110;
        if (r103 == r104) goto L9;
        Object r105 = this.f504978d.get(r104);
        if (r105 == null) goto L13;
        if ((r105 instanceof b) == true) goto L17;
        long r210 = ((long) ((r110 + 1) & 1073741823)) << 0;
        if (f504973f.compareAndSet(this, r101, (r101 & (-1073741824)) | r210) == true) goto L20;
        if (this.f504976b == false) goto L3;
        q<E> r106 = this;
    L25:
        AtomicLongFieldUpdater r107 = f504973f;
    L26:
        long r211 = r107.get(r106);
        int r108 = (int) ((r211 & 1073741823) >> 0);
        if ((r211 & 1152921504606846976L) != 0) goto L28;
        if (f504973f.compareAndSet(r106, r211, (r211 & (-1073741824)) | r210) == false) goto L26;
        r106.f504978d.set(r106.f504977c & r108, null);
        r106 = null;
    L32:
        if (r106 != null) goto L25;
        return r105;
    L28:
        r106 = r106.c();
        goto L32
    L20:
        this.f504978d.set(this.f504977c & r110, null);
        return r105;
    L17:
        return null;
    L13:
        if (this.f504976b == false) goto L3;
        return null;
    L9:
        return null;
    L6:
        return f504974g;
    }

    public final int a(E r110) {
        AtomicLongFieldUpdater r100 = f504973f;
    L3:
        long r101 = r100.get(this);
        if ((3458764513820540928L & r101) != 0) goto L6;
        int r102 = (int) ((1073741823 & r101) >> 0);
        int r111 = (int) ((1152921503533105152L & r101) >> 30);
        int r112 = this.f504977c;
        if (((r111 + 2) & r112) == (r102 & r112)) goto L11;
        if (this.f504976b == true) goto L22;
        if (this.f504978d.get(r111 & r112) == null) goto L22;
        int r103 = this.f504975a;
        if (r103 < 1024) goto L20;
        if (((r111 - r102) & 1073741823) <= (r103 >> 1)) goto L3;
    L20:
        return 1;
    L22:
        if (f504973f.compareAndSet(this, r101, ((-1152921503533105153L) & r101) | (((long) ((r111 + 1) & 1073741823)) << 30)) == false) goto L3;
        this.f504978d.set(r111 & r112, r110);
        q<E> r104 = this;
    L25:
        if ((f504973f.get(r104) & 1152921504606846976L) == 0) goto L33;
        r104 = r104.c();
        Object r105 = r104.f504978d.get(r104.f504977c & r111);
        if ((r105 instanceof b) == true) goto L29;
    L31:
        r104 = null;
    L32:
        if (r104 != null) goto L25;
    L29:
        if (((b) r105).f504979a != r111) goto L31;
        r104.f504978d.set(r104.f504977c & r111, r110);
    L33:
        return 0;
    L11:
        return 1;
    L6:
        if ((2305843009213693952L & r101) == 0) goto L50;
        return 2;
    L50:
        return 1;
    }

    public q(int r100, boolean r101) {
        this.f504975a = r100;
        this.f504976b = r101;
        int r102 = r100 - 1;
        this.f504977c = r102;
        this.f504978d = new AtomicReferenceArray(r100);
        boolean r103 = false;
        if (r102 > 1073741823) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L16;
        if ((r100 & r102) != 0) goto L11;
        r103 = true;
    L11:
        if (r103 == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r104 = false;
        goto L7
    }
}
