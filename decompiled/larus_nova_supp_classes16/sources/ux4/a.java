package ux4;

import jx4.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ d a;

    public /* synthetic */ a(d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r0 = this.a;
        u r1 = r0.c;
        if (r1 == null) goto L6;
        r1.b();
        r0.c = null;
        return;
    }
}
