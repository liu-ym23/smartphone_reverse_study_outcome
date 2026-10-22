package ux4;

import jx4.u;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f551972a;

    public /* synthetic */ a(d r100) {
        this.f551972a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r100 = this.f551972a;
        u r101 = r100.f551978c;
        if (r101 == null) goto L6;
        r101.b();
        r100.f551978c = null;
        return;
    }
}
