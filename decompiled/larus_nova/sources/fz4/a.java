package fz4;

import androidx.lifecycle.Observer;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements k15.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<Observer<Boolean>> f479351a;

    public a() {
        this.f479351a = new HashSet();
    }

    @Override // k15.a
    public final void a(Observer<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f479351a.remove(r100);
    }

    @Override // k15.a
    public final void b(boolean r100) {
        Iterator<Observer<Boolean>> r101 = this.f479351a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onChanged(Boolean.valueOf(r100));
        goto L4
    }

    @Override // k15.a
    public final void c(Observer<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f479351a.add(r100);
    }
}
