package jm;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<T> f499617a;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Observer f499618a;

        /* JADX INFO: renamed from: jm.d$a$a, reason: collision with other inner class name */
        public static final class RunnableC6458a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f499619a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f499620b;

            public RunnableC6458a(a r100, Object r101) {
                this.f499619a = r100;
                this.f499620b = r101;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                this.f499619a.f499618a.onChanged(this.f499620b);     // Catch: Throwable -> L4
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
            this.f499618a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T r100) {
            ArchTaskExecutor.getInstance().postToMainThread(new RunnableC6458a(this, r100));
        }
    }

    @Override // jm.c
    public final T getValue() {
        return this.f499617a.getValue();
    }

    public d() {
        this.f499617a = new MutableLiveData();
    }

    @Override // jm.c
    public final void b(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f499617a.removeObserver(r100);
    }

    @Override // jm.c
    public final void c(T r100) {
        this.f499617a.postValue(r100);
    }

    @Override // jm.c
    public final void setValue(T r100) {
        this.f499617a.setValue(r100);
    }

    @Override // jm.c
    public final void d(LifecycleOwner r100, Observer<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f499617a.observe(r100, new a(r101));
    }

    @Override // jm.c
    public final void a(LifecycleOwner r100, Observer<T> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f499617a.observe(r100, r101);
    }
}
