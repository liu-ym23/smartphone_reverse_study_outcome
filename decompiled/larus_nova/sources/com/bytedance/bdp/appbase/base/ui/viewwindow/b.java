package com.bytedance.bdp.appbase.base.ui.viewwindow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b extends d implements a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Bundle f200622u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f200623v;

    @Override // com.bytedance.bdp.appbase.base.ui.viewwindow.a
    public Activity getActivity() {
        return null;
    }

    public g getRoot() {
        return null;
    }

    public Intent getIntent() {
        Activity r100 = getActivity();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getIntent();
    }

    public Bundle getParams() {
        return this.f200622u;
    }

    public b(Context r100) {
        super(r100);
        this.f200622u = null;
        this.f200623v = false;
    }

    public void setParams(Bundle r100) {
        this.f200622u = r100;
    }
}
