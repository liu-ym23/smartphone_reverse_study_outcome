package com.bytedance.ee.bear.bitable.itemview.cell.link;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkTagAllAdapter f213944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkTagItem f213945b;

    public f(LinkTagAllAdapter r100, LinkTagItem r101) {
        this.f213944a = r100;
        this.f213945b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f213944a.f213906e.invoke(this.f213945b.getRecordId());
    }
}
