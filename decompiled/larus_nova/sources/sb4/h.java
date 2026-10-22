package sb4;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f541230a;

    public h(k r100) {
        this.f541230a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        l r101 = this.f541230a.f541234b;
        if (r101 == null) goto L6;
        r101.onCancel();
        return;
    }
}
