package ub4;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f549356a;

    public h(i r100) {
        this.f549356a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a r101 = this.f549356a.f549358b;
        if (r101 == null) goto L12;
        r101.onConfirm();
        i r102 = this.f549356a;
        r102.getClass();
        i.a(r102);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
