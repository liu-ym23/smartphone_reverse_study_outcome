package com.bytedance.locallife.poi.dito.poi.component;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiDetailNavigationBar f262507a;

    public b(PoiDetailNavigationBar r100) {
        this.f262507a = r100;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        if (r101 == 4) goto L5;
    L12:
        return false;
    L5:
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L12;
        this.f262507a.T = true;
        goto L12
    L7:
        if (r102.getAction() != 0) goto L9;
        r103 = true;
        goto L10
    }
}
