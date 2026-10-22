package op5;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSetObservable f524720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataSetObserver f524721b;

    public abstract void a(ViewGroup r100, int r101, Object r102);

    public abstract int b();

    public abstract int c(Object r100);

    public abstract Object d(ViewGroup r100, int r101);

    public abstract boolean e(View r100, Object r101);

    public void f() {
        monitor-enter(this);
        DataSetObserver r100 = this.f524721b;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        r100.onChanged();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        this.f524720a.notifyChanged();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void g(ViewGroup r100, int r101, Object r102) {
    }

    public a() {
        this.f524720a = new DataSetObservable();
    }

    public final void h(DataSetObserver r100) {
        monitor-enter(this);
        this.f524721b = r100;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
