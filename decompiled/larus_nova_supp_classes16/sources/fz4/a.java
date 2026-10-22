package fz4;

import androidx.lifecycle.Observer;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements k15.a {
    public final HashSet<Observer<Boolean>> a;

    public a() {
        this.a = new HashSet();
    }

    @Override // k15.a
    public final void a(Observer<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.a.remove(r2);
    }

    @Override // k15.a
    public final void b(boolean r4) {
        Iterator<Observer<Boolean>> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onChanged(Boolean.valueOf(r4));
        goto L4
    }

    @Override // k15.a
    public final void c(Observer<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.a.add(r2);
    }
}
