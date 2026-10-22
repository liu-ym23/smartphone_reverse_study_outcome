package j9b;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f497832a;

    public a(View.OnClickListener r100) {
        this.f497832a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        View.OnClickListener r101 = this.f497832a;
        if (r101 == null) goto L6;
        r101.onClick(r100);
        return;
    }
}
