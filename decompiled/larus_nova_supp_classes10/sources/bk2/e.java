package bk2;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QArchLiveData;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> extends QLiveData<T> {
    public final QArchLiveData<T> f;
    public volatile Object g;

    public static final class a implements Runnable {
        public final /* synthetic */ e a;
        public final /* synthetic */ Object b;

        public a(e r1, Object r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e r0 = this.a;     // Catch: Throwable -> L4
            r0.g = this.b;     // Catch: Throwable -> L4
            this.a.f.setValue(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final T a() {
        T r0 = (T) this.g;
        QLiveData.e.getClass();
        if (r0 != QLiveData.c) goto L7;
        return null;
    L7:
        return r0;
    }

    public e() {
        this.f = new QArchLiveData();
        QLiveData.e.getClass();
        this.g = QLiveData.c;
    }

    public final void d(Observer<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.f.observeForever(r2);
    }

    public final void e(T r3) {
        QLiveData.e.getClass();
        if (Intrinsics.areEqual(QLiveData.d, ThreadMethodProxy.currentThread()) == false) goto L5;
        this.g = r3;
        this.f.setValue(r3);
        return;
    L5:
        UtilityKotlinExtentionsKt.b.post(new a(this, r3));
    }

    public final void f(Observer<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.f.removeObserver(r2);
    }

    public final void g(T r2) {
        this.g = r2;
        this.f.setValue(r2);
    }

    public final void b(LifecycleOwner r2, Observer<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.f.observe(r2, r3);
    }

    public final void c(LifecycleOwner r2, Observer<T> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.f.observe(r2, r3, true);
    }
}
