package ij7;

import android.view.View;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f490092a;

    public c(a r100) {
        this.f490092a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        pi7.i r101 = this.f490092a.f490081i;
        if (r101 == null) goto L6;
        r101.Q3();
        return;
    }
}
