package h86;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f484216a;

    public b(a r100) {
        this.f484216a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        f86.c r101 = this.f484216a.f484207d;
        if (r101 == null) goto L10;
        a.C6113a r102 = (a.C6113a) r101;
        a r103 = r102.f484213a;
        if (r103.f484210g == false) goto L7;
        return;
    L7:
        if (r103.f().f467409a == null) goto L12;
        r102.f484213a.f().f467409a.onCancel();
        return;
    L12:
        return;
    }
}
