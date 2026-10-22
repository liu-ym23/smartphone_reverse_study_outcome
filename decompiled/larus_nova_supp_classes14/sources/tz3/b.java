package tz3;

import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> {
    public final ArrayList<Observer<T>> a;
    public int b;
    public T c;

    public b() {
        this.a = new ArrayList();
    }

    public final void a(Observer<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        if (this.b == 0) goto L5;
        r2.onChanged(this.c);
    L5:
        this.a.add(r2);
    }

    public final void b(T r3) {
        this.b++;
        this.c = r3;
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Observer) r0.next()).onChanged(r3);
        goto L4
    }
}
