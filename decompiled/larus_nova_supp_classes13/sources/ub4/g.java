package ub4;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ i a;

    public g(i r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        a r2 = this.a.b;
        if (r2 == null) goto L5;
        r2.onCancel();
    L5:
        i r3 = this.a;
        r3.getClass();
        i.a(r3);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
