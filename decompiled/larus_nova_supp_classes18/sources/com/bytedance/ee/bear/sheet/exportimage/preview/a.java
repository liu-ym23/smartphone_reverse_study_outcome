package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends t {
    public final /* synthetic */ SheetImagePreviewFragment c;

    public a(SheetImagePreviewFragment r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        ImagePreviewViewModel r4 = this.c.f;
        if (r4 == null) goto L5;
        r4.onClose();
    L5:
        HashMap r5 = new HashMap();
        r5.put("click", "close");
        r5.put("target", "none");
        qm5.b.b("ccm_space_docs_topbar_click", r5);
    }
}
