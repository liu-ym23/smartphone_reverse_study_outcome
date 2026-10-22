package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.render.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImageLoadingView extends AbsLoadingView {
    private FileLoadingView mFileLoadingView;

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public void show() {
        int r0 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).c3(this.mFileModel.b);
        this.mFileLoadingView.e(kac.a.b(r0));
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public View getView() {
        return this.mFileLoadingView;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public void setProgress(int r2) {
        this.mFileLoadingView.setProgress(r2);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public void setUIConfig(k.b r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.mFileLoadingView.d(r4.a, r4.b);
        this.mFileLoadingView.c(r4.d, r4.c);
    }

    public ImageLoadingView(Context r1, ViewOwner r2, z r3, g85.e r4) {
        super(r1, r2, r3, r4);
        FileLoadingView r5 = new FileLoadingView(this.mContext);
        this.mFileLoadingView = r5;
        r5.b(r2);
    }
}
