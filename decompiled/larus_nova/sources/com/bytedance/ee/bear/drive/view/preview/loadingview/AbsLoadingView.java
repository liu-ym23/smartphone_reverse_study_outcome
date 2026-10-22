package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.render.k;

/* JADX INFO: loaded from: classes16.dex */
public abstract class AbsLoadingView implements d {
    protected Context mContext;
    protected z mFileModel;
    protected g85.e mMimeTypeInfo;
    protected ViewOwner mParentViewOwner;

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public abstract /* synthetic */ View getView();

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public abstract /* synthetic */ void setProgress(int r100);

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public abstract /* synthetic */ void setUIConfig(k.b r100);

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public abstract /* synthetic */ void show();

    public AbsLoadingView(Context r100, ViewOwner r101, z r102, g85.e r103) {
        this.mContext = r100;
        this.mParentViewOwner = r101;
        this.mFileModel = r102;
        this.mMimeTypeInfo = r103;
    }
}
