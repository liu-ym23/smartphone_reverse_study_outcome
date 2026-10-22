package d41;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f466819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f466820b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f466821a;

        public a(f r100) {
            this.f466821a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.f466821a.f466820b.c() == false) goto L10;
            this.f466821a.f466820b.b();     // Catch: Throwable -> L7
            return;
        }
    }

    public final void a() {
        Disposable r100 = this.f466819a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f466819a = null;
    }

    public final void b() {
        if (this.f466820b.c() == true) goto L5;
        return;
    L5:
        a r100 = new a(this);
        Disposable r101 = this.f466819a;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        d51.c r102 = d51.c.A0;
        r102.getClass();
        this.f466819a = Observable.timer(((Number) d51.c.f466935k.getValue(r102, d51.c.f466915a[9])).longValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r100));
    }

    public f(g r100) {
        Intrinsics.checkNotNullParameter(r100, "machine");
        this.f466820b = r100;
    }
}
