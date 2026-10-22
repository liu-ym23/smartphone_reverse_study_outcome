package com.bytedance.ee.bear.doc.cover.selectcover.official;

import android.view.View;
import my4.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ CoverImageAdapter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ OfficialCoverData.CoverItem c;

    public a(CoverImageAdapter r1, String r2, OfficialCoverData.CoverItem r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        g r4 = this.a.c;
        if (r4 == null) goto L6;
        r4.onClick(this.b, this.c.getMimeType());
        return;
    }
}
