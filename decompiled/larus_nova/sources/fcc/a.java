package fcc;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f476416a;

    public a(c r100) {
        this.f476416a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f476416a.f();
        this.f476416a.f476425h = null;
    }
}
