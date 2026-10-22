package kc3;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes13.dex */
public abstract class b<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f502392j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f502393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SafeIterableMap<Observer<? super T>, b<T>.AbstractC6536b> f502394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f502395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f502396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f502397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f502398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f502399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f502400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f502401i;

    public class a extends b<T>.AbstractC6536b implements LifecycleEventObserver {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final LifecycleOwner f502402e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f502403f;

        @Override // kc3.b.AbstractC6536b
        public final void b() {
            this.f502402e.getLifecycle().removeObserver(this);
        }

        @Override // kc3.b.AbstractC6536b
        public final boolean d() {
            return this.f502402e.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // kc3.b.AbstractC6536b
        public final boolean c(LifecycleOwner r100) {
            if (this.f502402e != r100) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            Lifecycle.State r102 = this.f502402e.getLifecycle().getCurrentState();
            if (r102 != Lifecycle.State.DESTROYED) goto L9;
            b r103 = this.f502403f;
            Observer<? super T> r104 = this.f502404a;
            r103.getClass();
            b.a("removeObserver");
            b<T>.AbstractC6536b r105 = r103.f502394b.remove(r104);
            if (r105 == null) goto L14;
            r105.b();
            r105.a(false);
            return;
        L14:
            return;
        L9:
            Lifecycle.State r106 = null;
        L10:
            if (r106 == r102) goto L12;
            a(d());
            Lifecycle.State r107 = this.f502402e.getLifecycle().getCurrentState();
            r106 = r102;
            r102 = r107;
            goto L10
        }

        public a(b r100, Fragment r101, Observer r102) {
            this.f502403f = r100;
            super(r100, r102);
            this.f502402e = r101;
        }
    }

    /* JADX INFO: renamed from: kc3.b$b, reason: collision with other inner class name */
    public abstract class AbstractC6536b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f502404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f502405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f502406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f502407d;

        void b() {
        }

        boolean c(LifecycleOwner r100) {
            return false;
        }

        abstract boolean d();

        public final void a(boolean r100) {
            if (r100 != this.f502405b) goto L5;
            return;
        L5:
            this.f502405b = r100;
            b r101 = this.f502407d;
            if (r100 == false) goto L8;
            int r102 = 1;
        L9:
            int r103 = r101.f502395c;
            r101.f502395c = r102 + r103;
            if (r101.f502396d == true) goto L19;
            r101.f502396d = true;
        L25:
            int r104 = r101.f502395c;     // Catch: Throwable -> L22
            if (r103 == r104) goto L17;
            r103 = r104;
            goto L25
        L17:
            r101.f502396d = false;
        L22:
            th = move-exception;
            r101.f502396d = false;
            throw th;
        L19:
            if (this.f502405b == false) goto L28;
            this.f502407d.c(this, true);
            return;
        L28:
            return;
        L8:
            r102 = -1;
            goto L9
        }

        public AbstractC6536b(b r100, Observer<? super T> r101) {
            this.f502407d = r100;
            this.f502406c = -1;
            this.f502404a = r101;
        }
    }

    static {
        f502392j = new Object();
    }

    public final T d() {
        T r100 = (T) this.f502397e;
        if (r100 == f502392j) goto L5;
        return r100;
    L5:
        return null;
    }

    public b() {
        this.f502393a = new Object();
        this.f502394b = new SafeIterableMap();
        this.f502395c = 0;
        Object r100 = f502392j;
        this.f502398f = r100;
        this.f502397e = r100;
        this.f502399g = -1;
    }

    public static void a(String r100) {
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot invoke " + r100 + " on a background thread");
    }

    public final void b(b<T>.AbstractC6536b r100, boolean r101) {
        if (r101 == true) goto L5;
        return;
    L5:
        if (r100.f502405b == true) goto L8;
        return;
    L8:
        if (r100.d() == true) goto L11;
        r100.a(false);
        return;
    L11:
        int r102 = r100.f502406c;
        int r103 = this.f502399g;
        if (r102 < r103) goto L14;
        return;
    L14:
        r100.f502406c = r103;
        r100.f502404a.onChanged((Object) this.f502397e);
    }

    public final void c(b<T>.AbstractC6536b r100, boolean r101) {
        if (this.f502400h == false) goto L6;
        this.f502401i = true;
        return;
    L6:
        this.f502400h = true;
    L7:
        this.f502401i = false;
        if (r100 == null) goto L10;
        b(r100, r101);
        r100 = null;
    L16:
        if (this.f502401i == true) goto L7;
        this.f502400h = false;
        return;
    L10:
        SafeIterableMap<Observer<? super T>, b<T>.AbstractC6536b>.IteratorWithAdditions r102 = this.f502394b.iteratorWithAdditions();
    L12:
        if (r102.hasNext() == false) goto L16;
        b((AbstractC6536b) r102.next().getValue(), r101);
        if (this.f502401i == false) goto L12;
        goto L16
    }

    public final void e(Fragment r100, Observer r101) {
        a("observe");
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        a r102 = new a(this, r100, r101);
        b<T>.AbstractC6536b r103 = this.f502394b.putIfAbsent(r101, r102);
        if (r103 != null) goto L8;
    L12:
        if (r103 == null) goto L14;
        return;
    L14:
        r100.getLifecycle().addObserver(r102);
        return;
    L8:
        if (r103.c(r100) == true) goto L12;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
}
