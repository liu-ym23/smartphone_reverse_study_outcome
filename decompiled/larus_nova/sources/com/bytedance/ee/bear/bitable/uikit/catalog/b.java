package com.bytedance.ee.bear.bitable.uikit.catalog;

import android.view.View;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.Action;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gv4.a f216105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f216106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Icon f216107c;

    public b(gv4.a r100, String r101, Icon r102) {
        this.f216105a = r100;
        this.f216106b = r101;
        this.f216107c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gv4.a r101 = this.f216105a;
        if (r101 == null) goto L10;
        String r102 = this.f216106b;
        Icon r103 = this.f216107c;
        if (r103 == null) goto L7;
        String r104 = r103.getClickAction();
    L8:
        r101.a(new Action(r102, r104));
        return;
    L7:
        r104 = null;
        goto L8
    }
}
