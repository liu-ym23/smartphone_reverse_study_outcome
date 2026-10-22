package com.bytedance.ee.bear.bitable.itemview.record;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleItemModel f214056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ gv4.a f214057b;

    public c(SimpleItemModel r100, gv4.a r101) {
        this.f214056a = r100;
        this.f214057b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ActionPayload r101 = this.f214056a.getClickActionPayload();
        if (r101 == null) goto L8;
        gv4.a r102 = this.f214057b;
        if (r102 == null) goto L9;
        r102.a(r101);
        return;
    L9:
        return;
    }
}
