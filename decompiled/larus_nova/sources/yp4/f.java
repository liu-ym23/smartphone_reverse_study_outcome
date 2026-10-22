package yp4;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.cell.progress.b f568710a;

    public f(com.bytedance.ee.bear.bitable.card.view.cell.progress.b r100) {
        this.f568710a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L4;
        com.bytedance.ee.bear.bitable.card.view.cell.progress.b.a(this.f568710a);
        return;
    L4:
        this.f568710a.c();
    }
}
