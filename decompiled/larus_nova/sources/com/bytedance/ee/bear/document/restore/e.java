package com.bytedance.ee.bear.document.restore;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes16.dex */
public final class e extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DocDeletedView f221467c;

    public e(DocDeletedView r100) {
        this.f221467c = r100;
        super(500);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        DocDeletedView.b r101 = this.f221467c.f221438d;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
