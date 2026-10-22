package com.bytedance.ee.bear.sheet.filter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements View.OnClickListener {
    public final /* synthetic */ OfficeBaseSubFilterFragment a;
    public final /* synthetic */ int b;

    public s(OfficeBaseSubFilterFragment r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.aa0(this.b - 1);
    }
}
