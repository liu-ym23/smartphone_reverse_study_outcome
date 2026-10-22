package ep5;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<DialogInterface.OnCancelListener> f473434a;

    public b(DialogInterface.OnCancelListener r100) {
        this.f473434a = new WeakReference(r100);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        DialogInterface.OnCancelListener r101 = this.f473434a.get();
        if (r101 == null) goto L6;
        r101.onCancel(r100);
        return;
    }
}
