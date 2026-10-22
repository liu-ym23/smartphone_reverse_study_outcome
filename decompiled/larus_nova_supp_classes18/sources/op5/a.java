package op5;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a {
    public final DataSetObservable a;
    public DataSetObserver b;

    public abstract void a(ViewGroup r1, int r2, Object r3);

    public abstract int b();

    public abstract int c(Object r1);

    public abstract Object d(ViewGroup r1, int r2);

    public abstract boolean e(View r1, Object r2);

    public void f() {
        monitor-enter(this);
        DataSetObserver r0 = this.b;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.onChanged();     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        this.a.notifyChanged();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void g(ViewGroup r1, int r2, Object r3) {
    }

    public a() {
        this.a = new DataSetObservable();
    }

    public final void h(DataSetObserver r1) {
        monitor-enter(this);
        this.b = r1;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
