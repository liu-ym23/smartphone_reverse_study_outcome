package uv4;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements DialogInterface.OnCancelListener {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r1) {
        c.a r2 = this.a.k;
        if (r2 == null) goto L7;
        if (r2 == null) goto L8;
        r2.onCancel();
        return;
    L8:
        return;
    }
}
