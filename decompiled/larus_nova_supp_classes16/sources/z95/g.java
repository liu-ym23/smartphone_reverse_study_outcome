package z95;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener a;

    public g(a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (com.bytedance.ee.util.ui.h.a(800) == false) goto L8;
        View.OnClickListener r0 = this.a;
        if (r0 == null) goto L9;
        r0.onClick(r3);
        return;
    L9:
        return;
    }
}
