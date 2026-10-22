package doc;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes40.dex */
public final class j implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f469542a;

    public j(l r100) {
        this.f469542a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f469542a.f469546b = false;
    }
}
