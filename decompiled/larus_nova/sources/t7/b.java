package t7;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<DialogInterface.OnShowListener> f544856a;

    public b(DialogInterface.OnShowListener r100) {
        if (r100 == null) goto L6;
        this.f544856a = new WeakReference(r100);
        return;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        if (r100 == null) goto L9;
        WeakReference<DialogInterface.OnShowListener> r101 = this.f544856a;
        if (r101 == null) goto L10;
        DialogInterface.OnShowListener r102 = r101.get();
        if (r102 == null) goto L11;
        r102.onShow(r100);
        return;
    L11:
        return;
    L10:
        return;
    }
}
