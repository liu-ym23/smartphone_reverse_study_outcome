package com.bytedance.ee.bear.bitable.managerpanel;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f214663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BitableManagerPanelAdapter f214664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BitableManagerPanelData.BlockBean f214665e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        if (this.f214663c == false) goto L10;
        BitableManagerPanelAdapter r101 = this.f214664d;
        BitableManagerPanelData.BlockBean r102 = this.f214665e;
        int r103 = BitableManagerPanelAdapter.f214648d;
        r101.getClass();
        int r104 = r101.z2(r102.getId());
        if (r104 >= 0) goto L7;
        return;
    L7:
        if (r102.isExpanded() == false) goto L9;
        r101.collapse(r104);
        return;
    L9:
        r101.expand(r104);
        return;
    L10:
        BitableManagerPanelAdapter r105 = this.f214664d;
        int r106 = BitableManagerPanelAdapter.f214648d;
        r105.getClass();
    }

    public c(boolean r100, BitableManagerPanelAdapter r101, BitableManagerPanelData.BlockBean r102) {
        this.f214663c = r100;
        this.f214664d = r101;
        this.f214665e = r102;
        super(250);
    }
}
