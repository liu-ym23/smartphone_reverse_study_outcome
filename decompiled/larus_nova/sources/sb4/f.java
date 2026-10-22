package sb4;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f541218a;

    public f(g r100) {
        this.f541218a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        l r101 = this.f541218a.f541220b;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }
}
