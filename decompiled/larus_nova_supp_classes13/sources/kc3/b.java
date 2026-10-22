package kc3;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class b<T> {
    public static final Object j = null;
    public final Object a;
    public final SafeIterableMap<Observer<? super T>, b<T>.AbstractC0212b> b;
    public int c;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;

    public class a extends b<T>.AbstractC0212b implements LifecycleEventObserver {
        public final LifecycleOwner e;
        public final /* synthetic */ b f;

        @Override // kc3.b.AbstractC0212b
        public final void b() {
            this.e.getLifecycle().removeObserver(this);
        }

        @Override // kc3.b.AbstractC0212b
        public final boolean d() {
            return this.e.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // kc3.b.AbstractC0212b
        public final boolean c(LifecycleOwner r2) {
            if (this.e != r2) goto L5;
            return true;
        L5:
            return false;
        }

        public final void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
            Lifecycle.State r5 = this.e.getLifecycle().getCurrentState();
            if (r5 != Lifecycle.State.DESTROYED) goto L9;
            b r6 = this.f;
            Observer<? super T> r7 = this.a;
            r6.getClass();
            b.a("removeObserver");
            AbstractC0212b r8 = (AbstractC0212b) r6.b.remove(r7);
            if (r8 == null) goto L14;
            r8.b();
            r8.a(false);
            return;
        L14:
            return;
        L9:
            Lifecycle.State r9 = null;
        L10:
            if (r9 == r5) goto L12;
            a(d());
            Lifecycle.State r10 = this.e.getLifecycle().getCurrentState();
            r9 = r5;
            r5 = r10;
            goto L10
        }

        public a(b r1, Fragment r2, Observer r3) {
            this.f = r1;
            super(r1, r3);
            this.e = r2;
        }
    }

    /* JADX INFO: renamed from: kc3.b$b, reason: collision with other inner class name */
    public abstract class AbstractC0212b {
        public final Observer<? super T> a;
        public boolean b;
        public int c;
        public final /* synthetic */ b d;

        void b() {
        }

        boolean c(LifecycleOwner r1) {
            return false;
        }

        abstract boolean d();

        public final void a(boolean r5) {
            if (r5 != this.b) goto L5;
            return;
        L5:
            this.b = r5;
            b r0 = this.d;
            if (r5 == false) goto L8;
            int r6 = 1;
        L9:
            int r2 = r0.c;
            r0.c = r6 + r2;
            if (r0.d == true) goto L19;
            r0.d = true;
        L25:
            int r3 = r0.c;     // Catch: Throwable -> L22
            if (r2 == r3) goto L17;
            r2 = r3;
            goto L25
        L17:
            r0.d = false;
        L22:
            th = move-exception;
            r0.d = false;
            throw th;
        L19:
            if (this.b == false) goto L28;
            this.d.c(this, true);
            return;
        L28:
            return;
        L8:
            r6 = -1;
            goto L9
        }

        public AbstractC0212b(b r1, Observer<? super T> r2) {
            this.d = r1;
            this.c = -1;
            this.a = r2;
        }
    }

    static {
        j = new Object();
    }

    public final T d() {
        T r0 = (T) this.e;
        if (r0 == j) goto L5;
        return r0;
    L5:
        return null;
    }

    public b() {
        this.a = new Object();
        this.b = new SafeIterableMap();
        this.c = 0;
        Object r0 = j;
        this.f = r0;
        this.e = r0;
        this.g = -1;
    }

    public static void a(String r3) {
        if (ArchTaskExecutor.getInstance().isMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot invoke " + r3 + " on a background thread");
    }

    public final void b(b<T>.AbstractC0212b r2, boolean r3) {
        if (r3 == true) goto L5;
        return;
    L5:
        if (r2.b == true) goto L8;
        return;
    L8:
        if (r2.d() == true) goto L11;
        r2.a(false);
        return;
    L11:
        int r4 = r2.c;
        int r0 = this.g;
        if (r4 < r0) goto L14;
        return;
    L14:
        r2.c = r0;
        r2.a.onChanged(this.e);
    }

    public final void c(b<T>.AbstractC0212b r4, boolean r5) {
        if (this.h == false) goto L6;
        this.i = true;
        return;
    L6:
        this.h = true;
    L7:
        this.i = false;
        if (r4 == null) goto L10;
        b(r4, r5);
        r4 = null;
    L16:
        if (this.i == true) goto L7;
        this.h = false;
        return;
    L10:
        SafeIterableMap.IteratorWithAdditions r1 = this.b.iteratorWithAdditions();
    L12:
        if (r1.hasNext() == false) goto L16;
        b((AbstractC0212b) ((Map.Entry) r1.next()).getValue(), r5);
        if (this.i == false) goto L12;
        goto L16
    }

    public final void e(Fragment r3, Observer r4) {
        a("observe");
        if (r3.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        a r0 = new a(this, r3, r4);
        AbstractC0212b r5 = (AbstractC0212b) this.b.putIfAbsent(r4, r0);
        if (r5 != null) goto L8;
    L12:
        if (r5 == null) goto L14;
        return;
    L14:
        r3.getLifecycle().addObserver(r0);
        return;
    L8:
        if (r5.c(r3) == true) goto L12;
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
}
