package com.bytedance.ee.bear.more.protocol3.extension;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import oj5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class u<State extends oj5.c> {
    public final MutableLiveData<State> a;
    public final CompositeDisposable b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ u<State> a;

        public b(u<State> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            tt5.a.h("DocMoreInfoBehavior", "isManualOfflineByNet ok  it: " + r4);
            u<State> r0 = this.a;
            oj5.c r1 = r0.c();
            if (r1 == null) goto L5;
            Intrinsics.checkNotNull(r4);
            r1.J(r4.booleanValue());
        L6:
            r0.e(r1);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r4) {
            tt5.a.e("DocMoreInfoBehavior", "isManualOfflineByNet err. ", (Throwable) r4, false);
        }
    }

    static {
    }

    public abstract void a();

    public final State c() {
        return (State) this.a.getValue();
    }

    public u() {
        this.a = new MutableLiveData();
        this.b = new CompositeDisposable();
    }

    public final void b(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        this.b.add(r2);
    }

    public final void e(State r2) {
        this.a.setValue(r2);
    }

    public final void d(String r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "objToken");
        b(((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).y(r4, r5, r6).observeOn(fo5.d.d()).subscribe(new b(this), c.a));
    }
}
