package com.bytedance.ee.bear.bitable.app.titlebar;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes15.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppTitleBarAdapter f206967a;

    public c(BitableAppTitleBarAdapter r100) {
        this.f206967a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        com.bytedance.ee.bear.document.titlebar.titleview.b r101 = this.f206967a.f218659g;
        r101.setTitle((CharSequence) r100);
    }
}
