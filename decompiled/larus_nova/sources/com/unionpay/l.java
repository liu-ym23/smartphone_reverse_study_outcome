package com.unionpay;

import android.view.View;

/* JADX INFO: loaded from: classes41.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462165a;

    public l(UPPayWapActivity r100) {
        this.f462165a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f462165a.finish();
    }
}
