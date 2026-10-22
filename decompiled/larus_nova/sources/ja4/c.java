package ja4;

import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f497856a;

    public c(e r100) {
        this.f497856a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f497856a.b();
        ib4.e r101 = this.f497856a.C;
        if (r101 == null) goto L6;
        r101.onCancel();
        return;
    }
}
