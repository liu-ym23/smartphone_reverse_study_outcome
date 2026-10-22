package com.bytedance.ee.bear.wikiv2.home2;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeMenuLayout f240945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpaceBean f240946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WikiHomeRecentSpaceView f240947c;

    public q(SwipeMenuLayout r100, SpaceBean r101, WikiHomeRecentSpaceView r102) {
        this.f240945a = r100;
        this.f240946b = r101;
        this.f240947c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f240945a.b();
        String r101 = this.f240946b.space_id;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L14;
        WikiHomeRecentSpaceView.b r103 = this.f240947c.f240819k;
        if (r103 == null) goto L15;
        SpaceBean r104 = this.f240946b;
        r103.N2(r104.space_id, true ^ r104.is_star);
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
