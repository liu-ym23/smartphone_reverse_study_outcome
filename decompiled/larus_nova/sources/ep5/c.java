package ep5;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<DialogInterface.OnDismissListener> f473435a;

    public c(DialogInterface.OnDismissListener r100) {
        this.f473435a = new WeakReference(r100);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        DialogInterface.OnDismissListener r101 = this.f473435a.get();
        if (r101 == null) goto L6;
        r101.onDismiss(r100);
        return;
    }
}
