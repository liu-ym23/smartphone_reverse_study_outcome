package z95;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f571016a;

    public g(a r100) {
        this.f571016a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.ee.util.ui.h.a(800) == false) goto L8;
        View.OnClickListener r101 = this.f571016a;
        if (r101 == null) goto L9;
        r101.onClick(r100);
        return;
    L9:
        return;
    }
}
