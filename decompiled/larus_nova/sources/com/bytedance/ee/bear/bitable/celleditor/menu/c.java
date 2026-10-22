package com.bytedance.ee.bear.bitable.celleditor.menu;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleItemModel f209578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f209579b;

    public c(SimpleItemModel r100, a r101) {
        this.f209578a = r100;
        this.f209579b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ActionPayload r101 = this.f209578a.getClickActionPayload();
        if (r101 == null) goto L6;
        this.f209579b.f209575b.a(r101);
        return;
    }
}
