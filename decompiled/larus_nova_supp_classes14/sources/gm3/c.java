package gm3;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ b b;

    public c(a r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        hm3.b r3 = this.b.a;
        if (r3 == null) goto L6;
        r3.a(this.a);
    L6:
        if (this.a.c == false) goto L11;
        b r4 = this.b;
        r4.f = true;
        Dialog r5 = r4.e;
        if (r5 == null) goto L12;
        b.a(r5);
        return;
    L12:
        return;
    }
}
