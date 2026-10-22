package loc;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f510164a;

    public a(String r100) {
        this.f510164a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        joc.c r101 = e.f510168a;
        joc.b r102 = e.f510169b;
        if (r102 == null) goto L6;
        r102.a(this.f510164a);
        return;
    }
}
