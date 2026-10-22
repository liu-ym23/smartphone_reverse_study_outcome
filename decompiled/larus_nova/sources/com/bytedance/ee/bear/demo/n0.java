package com.bytedance.ee.bear.demo;

import android.content.Intent;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class n0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCCMDemoActivity f217563a;

    public n0(OfficeCCMDemoActivity r100) {
        this.f217563a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intent r101 = new Intent(this.f217563a, OfficeCCMDemoContainerActivity.class);
        r101.putExtra("demo_url", "https://doubao.com/file/boxcncCV3wQDym19mJd4K2386Mg");
        this.f217563a.startActivity(r101);
    }
}
