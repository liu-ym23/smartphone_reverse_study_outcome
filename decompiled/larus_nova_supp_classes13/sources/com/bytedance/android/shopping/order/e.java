package com.bytedance.android.shopping.order;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.shopping.extensions.k;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ PreviewPanelFragment a;

    public e(PreviewPanelFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        cg3.e r6 = (cg3.e) r5;
        String r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.c();
    L6:
        boolean r2 = false;
        if (k.c(r1) == false) goto L17;
        View r3 = this.a.t;
        if (r3 == null) goto L11;
        r3.setVisibility(0);
    L11:
        TextView r4 = this.a.n;
        if (r4 == null) goto L17;
        if (r6 == null) goto L15;
        String r7 = r6.c();
    L16:
        r4.setText(r7);
        goto L17
    L15:
        r7 = null;
    L17:
        if (r6 == null) goto L19;
        String r8 = r6.b();
    L20:
        if (r8 != null) goto L22;
    L23:
        r2 = true;
    L24:
        if (r2 == false) goto L28;
        TextView r9 = this.a.o;
        if (r9 == null) goto L34;
        r9.setVisibility(8);
        return;
    L34:
        return;
    L28:
        TextView r10 = this.a.o;
        if (r10 == null) goto L36;
        if (r6 == null) goto L32;
        r0 = r6.b();
    L32:
        r10.setText(r0);
        return;
    L36:
        return;
    L22:
        if (r8.length() != 0) goto L24;
    L19:
        r8 = null;
        goto L20
    L5:
        r1 = null;
        goto L6
    }
}
