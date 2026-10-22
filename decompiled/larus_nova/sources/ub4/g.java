package ub4;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f549355a;

    public g(i r100) {
        this.f549355a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f549355a.f549358b;
        if (r101 == null) goto L5;
        r101.onCancel();
    L5:
        i r102 = this.f549355a;
        r102.getClass();
        i.a(r102);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
