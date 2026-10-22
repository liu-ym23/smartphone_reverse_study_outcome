package ub4;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements DialogInterface.OnCancelListener {
    public final /* synthetic */ i a;

    public f(i r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r1) {
        a r2 = this.a.b;
        if (r2 == null) goto L6;
        r2.onCancel();
        return;
    }
}
