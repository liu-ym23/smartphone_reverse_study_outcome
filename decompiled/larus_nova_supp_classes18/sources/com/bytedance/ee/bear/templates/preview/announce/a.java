package com.bytedance.ee.bear.templates.preview.announce;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ d a;

    public a(d r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        AnnounceTemplateViewModel r2 = this.a.g;
        if (r2 == null) goto L6;
        r2.loadTemplateDataFromNet();
        return;
    }
}
