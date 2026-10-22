package ep5;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements DialogInterface.OnCancelListener {
    public final WeakReference<DialogInterface.OnCancelListener> a;

    public b(DialogInterface.OnCancelListener r2) {
        this.a = new WeakReference(r2);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r2) {
        DialogInterface.OnCancelListener r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.onCancel(r2);
        return;
    }
}
