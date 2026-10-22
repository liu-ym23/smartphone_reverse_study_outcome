package com.bytedance.ee.bear.widgets;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class k extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseTitleBar.a f240224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BaseTitleBar f240225d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        this.f240224c.performAction(r100);
        BaseTitleBar r101 = this.f240225d;
        if (r101.f240044s == false) goto L12;
        BaseTitleBar.a r102 = this.f240224c;
        r101.getClass();
        if ((r102 instanceof BaseTitleBar.c) == false) goto L13;
        View r103 = r100.findViewById(R.id.widgetTitleMenuBadgePoint);
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.getVisibility() != 0) goto L15;
        r103.setVisibility(8);
        return;
    L15:
        return;
    L13:
        return;
    }

    public k(BaseTitleBar r100, BaseTitleBar.b r101) {
        this.f240225d = r100;
        this.f240224c = r101;
    }
}
