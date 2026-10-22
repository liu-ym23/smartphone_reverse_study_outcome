package com.bytedance.ee.bear.templates.preview.announce;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ PanelTemplateAdapter a;
    public final /* synthetic */ int b;

    public e(PanelTemplateAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        PanelTemplateAdapter r4 = this.a;
        PanelTemplateAdapter.b r0 = r4.c;
        if (r0 == null) goto L6;
        int r1 = this.b;
        r0.a(r1, (AnnounceTemplate) ListProtector.get(r4.b, r1));
        return;
    }
}
