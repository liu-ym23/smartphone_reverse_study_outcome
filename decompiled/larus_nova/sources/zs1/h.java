package zs1;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f573470a;

    public h(g r100) {
        this.f573470a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f573470a.f573467g = null;
    }
}
