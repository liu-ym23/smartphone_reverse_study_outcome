package ep5;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements DialogInterface.OnShowListener {
    public final WeakReference<DialogInterface.OnShowListener> a;

    public d(DialogInterface.OnShowListener r2) {
        this.a = new WeakReference(r2);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r2) {
        DialogInterface.OnShowListener r0 = this.a.get();
        if (r0 == null) goto L6;
        r0.onShow(r2);
        return;
    }
}
