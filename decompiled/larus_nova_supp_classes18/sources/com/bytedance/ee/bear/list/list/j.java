package com.bytedance.ee.bear.list.list;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements d.b {
    public final d.b a;

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final boolean t0() {
        return this.a.t0();
    }

    public j(d.b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final void P(View r2, int r3, Document r4) {
        if (r4.b2 == false) goto L6;
        Context r5 = r2.getContext();
        Toast.showText(r5, r5.getString(2131887104), 0);
        return;
    L6:
        this.a.P(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final void B0(View r2, int r3, Document r4, boolean r5) {
        if (r4.b2 == false) goto L6;
        Context r6 = r2.getContext();
        Toast.showText(r6, r6.getString(2131887104), 0);
        return;
    L6:
        this.a.B0(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final void Y(View r2, int r3, Document r4, boolean r5) {
        if (r4.b2 == false) goto L6;
        Context r6 = r2.getContext();
        Toast.showText(r6, r6.getString(2131887104), 0);
        return;
    L6:
        this.a.Y(r2, r3, r4, r5);
    }

    @Override // com.bytedance.ee.bear.list.list.d.b
    public final void x0(View r2, int r3, Document r4, boolean r5) {
        if (r4.b2 == false) goto L6;
        Context r6 = r2.getContext();
        Toast.showText(r6, r6.getString(2131887104), 0);
        return;
    L6:
        this.a.x0(r2, r3, r4, r5);
    }
}
