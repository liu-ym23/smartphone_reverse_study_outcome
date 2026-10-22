package com.bytedance.ee.bear.integrator.wiki;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).C().c(FileInfoPuller.CALLER_WIKI);
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }

    public a(View r1) {
        this.a = r1;
    }
}
