package com.bytedance.ee.bear.demo;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class k0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCCMDemoActivity f217557a;

    public k0(OfficeCCMDemoActivity r100) {
        this.f217557a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intent r101 = new Intent(this.f217557a, OfficeCCMDemoContainerActivity.class);
        r101.putExtra("demo_url", "https://doubao.com/file/boxcnNbmRhbBbKKiHgOnhX");
        this.f217557a.startActivity(r101);
    }
}
