package com.bytedance.ee.bear.drive.view.preview.wps;

import android.webkit.WebView;
import com.bytedance.ee.bear.drive.biz.wps.DriveWPSPreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends com.bytedance.ee.bear.drive.view.widget.j {
    public final DriveWPSPreviewViewModel a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.j
    public final void b(int r1, String r2, String r3) {
    }

    public i(ViewOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "mViewOwner");
        this.a = (DriveWPSPreviewViewModel) r2.viewModel(DriveWPSPreviewViewModel.class);
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.j
    public final void a(WebView r2, String r3) {
        StringBuilder r4 = new StringBuilder("onPageFinished: view=");
        if (r2 == null) goto L5;
        Integer r5 = Integer.valueOf(r2.hashCode());
    L6:
        r4.append(r5);
        r4.append(", thread=");
        r4.append(ThreadMethodProxy.currentThread().getName());
        tt5.a.h("WPSWebViewHandler", r4.toString());
        this.a.getLiveWpsTryReload().postValue(Boolean.FALSE);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.j
    public final void c(WebView r3, int r4) {
        StringBuilder r0 = new StringBuilder("onRenderProcessGone: view=");
        if (r3 == null) goto L5;
        Integer r5 = Integer.valueOf(r3.hashCode());
    L6:
        r0.append(r5);
        r0.append(", rendererPriority=");
        r0.append(r4);
        r0.append(", thread=");
        r0.append(ThreadMethodProxy.currentThread().getName());
        tt5.a.h("WPSWebViewHandler", r0.toString());
        this.a.getLiveWpsTryReload().postValue(Boolean.TRUE);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
