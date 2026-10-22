package com.bytedance.ee.bear.wikiv2.selector;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class r extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecentOperationResult.a f241199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecentOperationAdapter f241200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f241201e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        RecentOperationResult.a r101 = this.f241199c;
        if ((r101 instanceof RecentOperationResult.FolderInfo) == false) goto L8;
        RecentOperationAdapter.b r102 = this.f241200d.f241106c;
        if (r102 == null) goto L13;
        r102.a(r100, this.f241201e, (RecentOperationResult.FolderInfo) r101);
        return;
    L13:
        return;
    L8:
        if ((r101 instanceof RecentOperationResult.WikiInfo) == false) goto L15;
        RecentOperationAdapter.b r103 = this.f241200d.f241106c;
        if (r103 == null) goto L16;
        r103.b(r100, this.f241201e, (RecentOperationResult.WikiInfo) r101);
        return;
    L16:
        return;
    }

    public r(RecentOperationResult.a r100, RecentOperationAdapter r101, int r102) {
        this.f241199c = r100;
        this.f241200d = r101;
        this.f241201e = r102;
    }
}
