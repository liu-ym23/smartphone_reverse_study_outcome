package ub4;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        a r2 = this.a.b;
        if (r2 == null) goto L12;
        r2.onConfirm();
        i r3 = this.a;
        r3.getClass();
        i.a(r3);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
