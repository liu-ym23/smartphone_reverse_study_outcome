package tu;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uu.b f547592a;

    public c(uu.b r100) {
        this.f547592a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        uu.b r101 = this.f547592a;
        if (r101 == null) goto L6;
        r101.cancel();
        return;
    }
}
