package ux4;

import android.app.Dialog;
import jx4.u;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f551973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f551974b;

    public /* synthetic */ b(d r100, String r101) {
        this.f551973a = r100;
        this.f551974b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r100 = this.f551973a;
        String r101 = this.f551974b;
        u r102 = r100.f551978c;
        if (r102 != null) goto L8;
        u r103 = new u(r100.f551977b, r101);
        r100.f551978c = r103;
        Dialog r104 = r103.f500860b;
        if (r104 == null) goto L7;
        r104.setCancelable(false);
    L7:
        r100.f551978c.c();
        return;
    L8:
        Dialog r105 = r102.f500860b;
        if (r105 != null) goto L11;
        return;
    L11:
        if (r105.isShowing() == false) goto L16;
        r102.f500861c.setText(r101);
        return;
    }
}
