package ep5;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements DialogInterface.OnDismissListener {
    public final WeakReference<DialogInterface.OnDismissListener> a;

    public c(DialogInterface.OnDismissListener r2) {
        this.a = new WeakReference(r2);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        DialogInterface.OnDismissListener r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.onDismiss(r2);
        return;
    }
}
