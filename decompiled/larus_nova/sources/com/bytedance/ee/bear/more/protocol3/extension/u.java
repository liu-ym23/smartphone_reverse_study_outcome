package com.bytedance.ee.bear.more.protocol3.extension;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;

/* JADX INFO: loaded from: classes18.dex */
public abstract class u<State extends oj5.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<State> f234845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f234846b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u<State> f234847a;

        public b(u<State> r100) {
            this.f234847a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            tt5.a.h("DocMoreInfoBehavior", "isManualOfflineByNet ok  it: " + r101);
            u<State> r102 = this.f234847a;
            oj5.c r103 = r102.c();
            if (r103 == null) goto L5;
            Intrinsics.checkNotNull(r101);
            r103.J(r101.booleanValue());
        L6:
            r102.e(r103);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f234848a = null;

        static {
            f234848a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("DocMoreInfoBehavior", "isManualOfflineByNet err. ", (Throwable) r100, false);
        }
    }

    static {
    }

    public abstract void a();

    public final State c() {
        return this.f234845a.getValue();
    }

    public u() {
        this.f234845a = new MutableLiveData();
        this.f234846b = new CompositeDisposable();
    }

    public final void b(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f234846b.add(r100);
    }

    public final void e(State r100) {
        this.f234845a.setValue(r100);
    }

    public final void d(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        b(((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).y(r100, r101, r102).observeOn(fo5.d.d()).subscribe(new b(this), c.f234848a));
    }
}
