package com.bytedance.ee.bear.drive.view.preview.loadingview;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.drive.render.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsLoadingView implements d {
    protected Context mContext;
    protected z mFileModel;
    protected g85.e mMimeTypeInfo;
    protected ViewOwner mParentViewOwner;

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public abstract /* synthetic */ View getView();

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public abstract /* synthetic */ void setProgress(int r1);

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public abstract /* synthetic */ void setUIConfig(k.b r1);

    @Override // com.bytedance.ee.bear.drive.view.preview.loadingview.d
    public abstract /* synthetic */ void show();

    public AbsLoadingView(Context r1, ViewOwner r2, z r3, g85.e r4) {
        this.mContext = r1;
        this.mParentViewOwner = r2;
        this.mFileModel = r3;
        this.mMimeTypeInfo = r4;
    }
}
