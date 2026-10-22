package com.bytedance.ee.bear.sheet.fab;

import android.widget.LinearLayout;
import com.bytedance.ee.util.observer.DiffObserver;

/* JADX INFO: loaded from: classes18.dex */
public final class w extends DiffObserver<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeFabFragment f237656b;

    public w(OfficeFabFragment r100) {
        this.f237656b = r100;
    }

    @Override // com.bytedance.ee.util.observer.DiffObserver
    public final void a(Boolean r100) {
        Boolean r101 = r100;
        LinearLayout r102 = this.f237656b.f237615e;
        if (r102 != null) goto L6;
        return;
    L6:
        if (Boolean.TRUE.equals(r101) == false) goto L8;
        int r103 = 0;
    L9:
        r102.setVisibility(r103);
        return;
    L8:
        r103 = 8;
        goto L9
    }
}
