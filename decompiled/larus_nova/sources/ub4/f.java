package ub4;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f549354a;

    public f(i r100) {
        this.f549354a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        a r101 = this.f549354a.f549358b;
        if (r101 == null) goto L6;
        r101.onCancel();
        return;
    }
}
