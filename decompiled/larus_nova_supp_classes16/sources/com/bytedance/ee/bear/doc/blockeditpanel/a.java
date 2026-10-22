package com.bytedance.ee.bear.doc.blockeditpanel;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final BearUrl a;
    public final d b;

    public final void a(String r6) {
        if (this.b != null) goto L5;
        return;
    L5:
        tt5.a.h("BlockEditPanelAnalytic", "report:".concat(r6));
        HashMap r0 = new HashMap();
        BearUrl r2 = this.a;
        String r3 = "ERR";
        if (r2 != null) goto L9;
    L10:
        String r4 = "ERR";
    L12:
        r0.put("file_id", r4);
        BearUrl r5 = this.a;
        if (r5 != null) goto L16;
    L19:
        r0.put("file_type", r3);
        r0.put("module", r3);
        r0.put("action_source", r6);
        tt5.a.b("BlockEditPanelAnalytic", "report param:" + r0);
        this.b.v("ccm_block_close", r0);
        return;
    L16:
        if (TextUtils.isEmpty(r5.a) == true) goto L19;
        r3 = this.a.a;
        goto L19
    L9:
        if (TextUtils.isEmpty(r2.b) == true) goto L10;
        r4 = du5.b.g(this.a.b);
        goto L12
    }

    public a(BearUrl r1, d r2) {
        this.a = r1;
        this.b = r2;
    }
}
