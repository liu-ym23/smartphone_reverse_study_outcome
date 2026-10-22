package com.bytedance.locallife.poi.media.ui;

import android.view.View;
import android.view.ViewStub;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements ViewStub.OnInflateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiMediaFragment f262846a;

    public d(PoiMediaFragment r100) {
        this.f262846a = r100;
    }

    @Override // android.view.ViewStub.OnInflateListener
    public final void onInflate(ViewStub r100, View r101) {
        PoiMediaFragment r102 = this.f262846a;
        PoiMediaFragment.S90(r102, r101);
        r102.f262830y = r101;
    }
}
