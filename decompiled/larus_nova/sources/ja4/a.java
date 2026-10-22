package ja4;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnDismissListener f497849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f497850b;

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f497850b.b();
        this.f497849a.onDismiss(r100);
    }

    public a(b r100, DialogInterface.OnDismissListener r101) {
        this.f497850b = r100;
        this.f497849a = r101;
    }
}
