package sb4;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f541216a;

    public d(g r100) {
        this.f541216a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        l r101 = this.f541216a.f541220b;
        if (r101 == null) goto L6;
        r101.onCancel();
        return;
    }
}
