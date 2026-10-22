package com.bytedance.ee.bear.doc.cover.selectcover.official;

import android.view.View;
import my4.g;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoverImageAdapter f217852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f217853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OfficialCoverData.CoverItem f217854c;

    public a(CoverImageAdapter r100, String r101, OfficialCoverData.CoverItem r102) {
        this.f217852a = r100;
        this.f217853b = r101;
        this.f217854c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        g r101 = this.f217852a.f217824c;
        if (r101 == null) goto L6;
        r101.onClick(this.f217853b, this.f217854c.getMimeType());
        return;
    }
}
