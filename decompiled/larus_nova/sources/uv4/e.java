package uv4;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f551857a;

    public e(c r100) {
        this.f551857a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f551857a.a();
        c.a r101 = this.f551857a.f551854k;
        if (r101 == null) goto L6;
        r101.onClickClose();
        return;
    }
}
