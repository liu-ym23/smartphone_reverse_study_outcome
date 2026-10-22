package com.bytedance.ee.bear.bitable.load.workimpl;

import com.bytedance.ee.bear.bitable.load.AbsLoadWork;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a extends AbsLoadWork {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Class<? extends zt4.a>> f214563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f214564g;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.load.workimpl.a$a, reason: collision with other inner class name */
    public static final class C3063a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f214565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.bitable.load.e f214566b;

        public C3063a(a r100, com.bytedance.ee.bear.bitable.load.e r101) {
            this.f214565a = r100;
            this.f214566b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            List<Class<? extends zt4.a>> r101 = this.f214565a.f214563f;
            com.bytedance.ee.bear.bitable.load.e r102 = this.f214566b;
            Iterator r103 = ((ArrayList) r101).iterator();
        L4:
            if (r103.hasNext() == false) goto L29;
            Class r104 = (Class) r103.next();
            zt4.a r105 = r102.e(r104);
            if (r105 != null) goto L8;
        L15:
            zt4.a r106 = r102.e(r104);
            if (r106 == null) goto L4;
            if (r106.e() == true) goto L4;
            r106.b();
        L25:
            e = move-exception;
            tt5.a.e(r106.f573582b, "loadResourceInBackground failed:", e, false);
        L27:
            r106.f573583c.countDown();
            r106.a();
            goto L4
        L22:
            if (r106.f573584d == true) goto L27;
            r106.f573584d = r106.f();     // Catch: Exception -> L25
            goto L27
        L8:
            if (r105.e() == false) goto L15;
            r105.b();
            r105.f573583c.await();     // Catch: Exception -> L12
            r105.f573584d = r105.h();     // Catch: Exception -> L12
        L14:
            r105.a();
        L12:
            e = move-exception;
            tt5.a.e(r105.f573582b, "preloadDataInRust failed:", e, false);
            goto L14
        L29:
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f214567a;

        public b(a r100) {
            this.f214567a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            if (this.f214567a.e() == false) goto L6;
            this.f214567a.m();
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f214568a;

        public c(a r100) {
            this.f214568a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d("PreloadDataWorkV2", "PreloadDataWork error " + ((Throwable) r100));
            if (this.f214568a.e() == false) goto L6;
            this.f214568a.m();
            return;
        }
    }

    @Override // com.bytedance.ee.bear.bitable.load.AbsLoadWork
    public final void f() {
        Iterator<T> r100 = this.f214563f.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Class r101 = (Class) r100.next();
        zt4.a r102 = this.f214440a.e(r101);
        if (r102 == null) goto L4;
        r102.i();
        goto L4
    L8:
        Disposable r103 = this.f214564g;
        boolean r104 = false;
        if (r103 != null) goto L11;
    L13:
        if (r104 == true) goto L23;
        Disposable r105 = this.f214564g;
        if (r105 == null) goto L24;
        r105.dispose();
        return;
    L24:
        return;
    L23:
        return;
    L11:
        if (r103.isDisposed() != true) goto L13;
        r104 = true;
        goto L13
    }

    public final void o(com.bytedance.ee.bear.bitable.load.e r100) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        this.f214564g = Flowable.just("").observeOn(Schedulers.io()).map(new C3063a(this, r100)).subscribe(new b(this), new c(this));
    }

    public a(com.bytedance.ee.bear.bitable.load.e r100, com.bytedance.ee.bear.bitable.load.f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        super(r100, r101);
        this.f214563f = new ArrayList();
    }

    public final <T extends zt4.a> void n(T r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        if (r101 == false) goto L6;
        List<Class<? extends zt4.a>> r102 = this.f214563f;
        ArrayList r103 = (ArrayList) r102;
        r103.add(r100.getClass());
        this.f214440a.d(r100.getClass(), r100);
        return;
    }
}
