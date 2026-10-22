package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ RecentOperationResult.a c;
    public final /* synthetic */ RecentOperationAdapter d;
    public final /* synthetic */ int e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        RecentOperationResult.a r0 = this.c;
        if ((r0 instanceof RecentOperationResult.FolderInfo) == false) goto L8;
        RecentOperationAdapter.b r1 = this.d.c;
        if (r1 == null) goto L13;
        r1.a(r4, this.e, (RecentOperationResult.FolderInfo) r0);
        return;
    L13:
        return;
    L8:
        if ((r0 instanceof RecentOperationResult.WikiInfo) == false) goto L15;
        RecentOperationAdapter.b r2 = this.d.c;
        if (r2 == null) goto L16;
        r2.b(r4, this.e, (RecentOperationResult.WikiInfo) r0);
        return;
    L16:
        return;
    }

    public r(RecentOperationResult.a r1, RecentOperationAdapter r2, int r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
