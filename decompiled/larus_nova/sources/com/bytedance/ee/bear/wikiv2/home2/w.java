package com.bytedance.ee.bear.wikiv2.home2;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;

/* JADX INFO: loaded from: classes18.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpaceBean f240954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WikiHomeTopSpaceView f240955b;

    public w(SpaceBean r100, WikiHomeTopSpaceView r101) {
        this.f240954a = r100;
        this.f240955b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f240954a.space_id;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L14;
        WikiHomeTopSpaceView.b r103 = this.f240955b.f240830f;
        if (r103 == null) goto L15;
        r103.a(this.f240954a.space_id);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
