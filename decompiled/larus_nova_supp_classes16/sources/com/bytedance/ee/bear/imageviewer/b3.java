package com.bytedance.ee.bear.imageviewer;

import android.net.Uri;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b3 implements c3.f {
    public final /* synthetic */ c3 a;

    public b3(c3 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.imageviewer.c3.f
    public final void onFailed(Throwable r4) {
        tt5.a.e("ImageViewer", "sendDiagramToChat failed", r4, false);
    }

    @Override // com.bytedance.ee.bear.imageviewer.c3.f
    public final void onSuccess(Uri r2) {
        this.a.b0(r2);
    }
}
