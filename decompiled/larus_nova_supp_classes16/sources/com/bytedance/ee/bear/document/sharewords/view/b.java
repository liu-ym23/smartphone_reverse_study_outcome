package com.bytedance.ee.bear.document.sharewords.view;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.widgets.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ CCMShareWordsEnhancedView a;
    public final /* synthetic */ View b;

    public b(CCMShareWordsEnhancedView r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ConstraintLayout r4 = this.a.c;
        if (r4 == null) goto L5;
        r4.setVisibility(0);
    L5:
        View r5 = this.b;
        if (r5 == null) goto L8;
        r5.setVisibility(0);
    L8:
        n r6 = this.a.j;
        if (r6 == null) goto L11;
        int r0 = r6.c;
        lt7.d.a r1 = u.a(r6.b);
        r1.b = r0;
        r1.a(2131100785);
        r6.d = r1.b();
    L11:
        ConstraintLayout r7 = this.a.f;
        if (r7 == null) goto L14;
        r7.setVisibility(8);
    L14:
        ConstraintLayout r8 = this.a.d;
        if (r8 == null) goto L18;
        r8.setVisibility(8);
    L18:
        if (com.bytedance.ee.bear.document.sharewords.g.e == true) goto L21;
        com.bytedance.ee.bear.document.sharewords.g.a.a(true);
        return;
    }
}
