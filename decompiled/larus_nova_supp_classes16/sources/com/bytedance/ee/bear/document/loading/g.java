package com.bytedance.ee.bear.document.loading;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ LoadingLayout b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LoadingLayout.c r3 = this.b.a;
        if (r3 == null) goto L6;
        r3.onFailedRetry(this.a);
        this.b.setOnClickListener(null);
        return;
    }

    public g(LoadingLayout r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
