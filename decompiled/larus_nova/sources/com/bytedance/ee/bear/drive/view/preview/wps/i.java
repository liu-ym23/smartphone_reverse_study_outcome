package com.bytedance.ee.bear.drive.view.preview.wps;

import android.webkit.WebView;
import com.bytedance.ee.bear.drive.biz.wps.DriveWPSPreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i extends com.bytedance.ee.bear.drive.view.widget.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DriveWPSPreviewViewModel f225682a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.j
    public final void b(int r100, String r101, String r102) {
    }

    public i(ViewOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "mViewOwner");
        this.f225682a = (DriveWPSPreviewViewModel) r100.viewModel(DriveWPSPreviewViewModel.class);
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.j
    public final void a(WebView r100, String r101) {
        StringBuilder r102 = new StringBuilder("onPageFinished: view=");
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.hashCode());
    L6:
        r102.append(r103);
        r102.append(", thread=");
        r102.append(ThreadMethodProxy.currentThread().getName());
        tt5.a.h("WPSWebViewHandler", r102.toString());
        this.f225682a.getLiveWpsTryReload().postValue(Boolean.FALSE);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.view.widget.j
    public final void c(WebView r100, int r101) {
        StringBuilder r102 = new StringBuilder("onRenderProcessGone: view=");
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.hashCode());
    L6:
        r102.append(r103);
        r102.append(", rendererPriority=");
        r102.append(r101);
        r102.append(", thread=");
        r102.append(ThreadMethodProxy.currentThread().getName());
        tt5.a.h("WPSWebViewHandler", r102.toString());
        this.f225682a.getLiveWpsTryReload().postValue(Boolean.TRUE);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
