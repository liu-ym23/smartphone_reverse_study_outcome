package com.bytedance.ee.bear.doc.syncblock;

import android.view.View;
import com.bytedance.ee.bear.document.loading.LoadingLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ SyncBlockLoadingLayout a;
    public final /* synthetic */ int b;

    public d(SyncBlockLoadingLayout r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LoadingLayout.c r3 = this.a.a;
        if (r3 == null) goto L5;
        r3.onFailedRetry(this.b);
    L5:
        this.a.setOnClickListener(null);
    }
}
