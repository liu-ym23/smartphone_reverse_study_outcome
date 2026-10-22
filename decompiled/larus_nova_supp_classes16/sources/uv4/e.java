package uv4;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ c a;

    public e(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.a();
        c.a r2 = this.a.k;
        if (r2 == null) goto L6;
        r2.onClickClose();
        return;
    }
}
