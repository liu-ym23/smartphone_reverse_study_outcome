package com.bytedance.ee.bear.bitable.uikit.catalog;

import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gv4.a f216108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SimpleItemModel f216109b;

    public c(gv4.a r100, SimpleItemModel r101) {
        this.f216108a = r100;
        this.f216109b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gv4.a r101 = this.f216108a;
        if (r101 == null) goto L13;
        SimpleItemModel r102 = this.f216109b;
        String r103 = null;
        if (r102 == null) goto L7;
        String r104 = r102.getId();
    L8:
        SimpleItemModel r105 = this.f216109b;
        if (r105 == null) goto L11;
        r103 = r105.getClickAction();
    L11:
        r101.a(new Action(r104, r103));
        return;
    L7:
        r104 = null;
        goto L8
    }
}
