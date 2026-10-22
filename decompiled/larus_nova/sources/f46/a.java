package f46;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f475521a;

    public a(g r100) {
        this.f475521a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        DialogInterface.OnCancelListener r101 = this.f475521a.f475552u;
        if (r101 == null) goto L6;
        r101.onCancel(r100);
        return;
    }
}
