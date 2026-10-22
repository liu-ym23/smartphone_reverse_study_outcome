package fcc;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f476417a;

    public b(c r100) {
        this.f476417a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Runnable r101 = this.f476417a.f476425h;
        if (r101 == null) goto L6;
        r101.run();
        return;
    }
}
