package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.render.k;

/* JADX INFO: loaded from: classes16.dex */
public class AudioLoadingView extends AbsLoadingView {
    private FileLoadingView mFileLoadingView;

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public void show() {
        int r100 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).c3(this.mFileModel.f225834b);
        this.mFileLoadingView.e(r100);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public View getView() {
        return this.mFileLoadingView;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public void setProgress(int r100) {
        this.mFileLoadingView.setProgress(r100);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView, com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public void setUIConfig(k.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mFileLoadingView.d(r100.f242740a, r100.f242741b);
        this.mFileLoadingView.c(r100.f242743d, r100.f242742c);
    }

    public AudioLoadingView(Context r100, ViewOwner r101, z r102, g85.e r103) {
        super(r100, r101, r102, r103);
        FileLoadingView r104 = new FileLoadingView(r100);
        this.mFileLoadingView = r104;
        r104.b(r101);
    }
}
