package gm3;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f481671a;

    public d(b r100) {
        this.f481671a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        hm3.a r101 = this.f481671a.f481663b;
        if (r101 == null) goto L5;
        r101.onCancel();
    L5:
        b r102 = this.f481671a;
        r102.f481667f = true;
        Dialog r103 = r102.f481666e;
        if (r103 == null) goto L9;
        b.a(r103);
        return;
    }
}
