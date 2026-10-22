package ux4;

import android.app.Dialog;
import jx4.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(d r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r0 = this.a;
        String r1 = this.b;
        u r2 = r0.c;
        if (r2 != null) goto L8;
        u r3 = new u(r0.b, r1);
        r0.c = r3;
        Dialog r4 = r3.b;
        if (r4 == null) goto L7;
        r4.setCancelable(false);
    L7:
        r0.c.c();
        return;
    L8:
        Dialog r5 = r2.b;
        if (r5 != null) goto L11;
        return;
    L11:
        if (r5.isShowing() == false) goto L16;
        r2.c.setText(r1);
        return;
    }
}
