package com.bytedance.ee.bear.sheet.borderline;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends t {
    public final /* synthetic */ String c;
    public final /* synthetic */ BorderStyleAdapter d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        BorderStyleAdapter r5 = this.d;
        String[] r0 = r5.a;
        String r1 = this.c;
        r5.a = r0;
        r5.b = r1;
        r5.notifyDataSetChanged();
        BorderStyleAdapter.a r6 = this.d.c;
        if (r6 == null) goto L6;
        String r2 = this.c;
        BorderLinePanelView r7 = ((e) r6).a;
        r7.c(r2, r7.g, "border");
        return;
    }

    public f(BorderStyleAdapter r1, String r2) {
        this.d = r1;
        this.c = r2;
    }
}
