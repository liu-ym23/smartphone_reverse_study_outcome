package yhc;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes40.dex */
public final class t implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f567730a;

    public t(u r100) {
        this.f567730a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        u r101 = this.f567730a;
        if (r101.f567736f == false) goto L5;
        r101.f567736f = false;
        return;
    L5:
        r101.f567734d.n(false);
    }
}
