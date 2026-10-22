package ep5;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<DialogInterface.OnShowListener> f473436a;

    public d(DialogInterface.OnShowListener r100) {
        this.f473436a = new WeakReference(r100);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        DialogInterface.OnShowListener r101 = this.f473436a.get();
        if (r101 == null) goto L6;
        r101.onShow(r100);
        return;
    }
}
