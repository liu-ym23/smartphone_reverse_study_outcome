package gm3;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        hm3.a r3 = this.a.b;
        if (r3 == null) goto L5;
        r3.onCancel();
    L5:
        b r4 = this.a;
        r4.f = true;
        Dialog r5 = r4.e;
        if (r5 == null) goto L9;
        b.a(r5);
        return;
    }
}
