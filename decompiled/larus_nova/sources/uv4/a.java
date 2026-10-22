package uv4;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f551841a;

    public a(c r100) {
        this.f551841a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        c.a r101 = this.f551841a.f551854k;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.onCancel();
        return;
    L8:
        return;
    }
}
