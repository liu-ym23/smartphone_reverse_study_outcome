package tz3;

import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Observer<T>> f548044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f548045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public T f548046c;

    public b() {
        this.f548044a = new ArrayList();
    }

    public final void a(Observer<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f548045b == 0) goto L5;
        r100.onChanged(this.f548046c);
    L5:
        this.f548044a.add(r100);
    }

    public final void b(T r100) {
        this.f548045b++;
        this.f548046c = r100;
        Iterator<T> r101 = this.f548044a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Observer) r101.next()).onChanged(r100);
        goto L4
    }
}
