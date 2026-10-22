package com.bytedance.ee.bear.sheet.fab;

import android.widget.LinearLayout;
import com.bytedance.ee.util.observer.DiffObserver;

/* JADX INFO: loaded from: classes18.dex */
public final class k extends DiffObserver<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FabFragment f237643b;

    public k(FabFragment r100) {
        this.f237643b = r100;
    }

    @Override // com.bytedance.ee.util.observer.DiffObserver
    public final void a(Boolean r100) {
        LinearLayout r101 = this.f237643b.f237595e;
        Boolean r102 = Boolean.TRUE;
        if (r102.equals(r100) == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        return;
    L5:
        r103 = 8;
        goto L6
    }
}
