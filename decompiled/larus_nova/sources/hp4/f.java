package hp4;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f486396a;

    public f(g r100) {
        this.f486396a = r100;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        g r101 = this.f486396a;
        g.b r102 = r101.f486402f;
        if (r102 == null) goto L6;
        r102.d(r101.f486403g, "EDIT_PANEL_SHOW");
        return;
    }
}
