package sb4;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f541217a;

    public e(g r100) {
        this.f541217a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        l r101 = this.f541217a.f541220b;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
