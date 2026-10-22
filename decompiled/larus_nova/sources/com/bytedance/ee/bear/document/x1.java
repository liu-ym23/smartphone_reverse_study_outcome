package com.bytedance.ee.bear.document;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class x1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocTipsLayout f222502a;

    public x1(DocTipsLayout r100) {
        this.f222502a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f222502a.f218581t.setVisibility(8);
        this.f222502a.f218571j = true;
    }
}
