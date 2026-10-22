package zs1;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f573464a;

    public d(i r100) {
        this.f573464a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f573464a.onClose();
    }
}
