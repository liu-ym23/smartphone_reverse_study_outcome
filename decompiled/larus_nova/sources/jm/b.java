package jm;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<T> f499613a;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Observer f499614a;

        /* JADX INFO: renamed from: jm.b$a$a, reason: collision with other inner class name */
        public static final class RunnableC6457a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f499615a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f499616b;

            public RunnableC6457a(a r100, Object r101) {
                this.f499615a = r100;
                this.f499616b = r101;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                this.f499615a.f499614a.onChanged(this.f499616b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(Observer r100) {
            this.f499614a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T r100) {
            ArchTaskExecutor.getInstance().postToMainThread(new RunnableC6457a(this, r100));
        }
    }

    @Override // jm.c
    public final T getValue() {
        return this.f499613a.getValue();
    }

    public b() {
        this.f499613a = new MutableLiveData();
    }

    @Override // jm.c
    public final void b(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f499613a.removeObserver(r100);
    }

    @Override // jm.c
    public final void c(T r100) {
        this.f499613a.postValue(r100);
    }

    @Override // jm.c
    public final void setValue(T r100) {
        this.f499613a.setValue(r100);
    }

    @Override // jm.c
    public final void d(LifecycleOwner r100, Observer<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f499613a.observe(r100, new a(r101));
    }

    @Override // jm.c
    public final void a(LifecycleOwner r100, Observer<T> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f499613a.observe(r100, r101);
    }
}
