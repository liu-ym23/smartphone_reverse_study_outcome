package com.bytedance.ee.bear.document.loading;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ LoadingLayout.a a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ LoadingLayout d;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (this.a.c == false) goto L5;
        LoadingLayout.b r3 = this.d.b;
        if (r3 == null) goto L13;
        LoadingFailedPlugin.c(((e) r3).a);
        return;
    L13:
        return;
    L5:
        if (this.d.a == null) goto L11;
        this.b.setVisibility(8);
        this.d.a.onFailedRetry(this.c);
        return;
    }

    public h(LoadingLayout r1, LoadingLayout.a r2, TextView r3, int r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
