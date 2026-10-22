package com.huawei.hms.healthlite;

import android.view.View;

/* JADX INFO: loaded from: classes23.dex */
class aabb implements View.OnClickListener {

    /* JADX INFO: renamed from: aab, reason: collision with root package name */
    final /* synthetic */ aabc f277482aab;

    public aabb(aabc r100) {
        this.f277482aab = r100;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        aabc.aab(this.f277482aab).onBackPressed();
    }
}
