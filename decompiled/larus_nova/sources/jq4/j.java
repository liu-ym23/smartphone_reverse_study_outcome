package jq4;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class j implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f500042a;

    public j() {
        this.f500042a = new ArrayList();
    }

    @Override // jq4.k
    public final void d(View r100, hp4.u r101) {
        Iterator r102 = ((ArrayList) this.f500042a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((k) r102.next()).d(r100, r101);
        goto L4
    }

    @Override // jq4.k
    public final void f(View r100, hp4.u r101) {
        Iterator r102 = ((ArrayList) this.f500042a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((k) r102.next()).f(r100, r101);
        goto L4
    }
}
