package ey4;

import android.view.View;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends t {
    public final /* synthetic */ BaseBlockEditPanel c;

    public d(BaseBlockEditPanel r1) {
        this.c = r1;
    }

    public final void a(View r2) {
        r2.setClickable(false);
        dy4.c r3 = this.c.d;
        if (r3 == null) goto L6;
        r3.sg();
        return;
    }
}
