package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ApkPreviewView extends AbsPreviewView {
    private x mPlaceHolderViewWrapper;

    public static /* synthetic */ void a(ApkPreviewView r0, String r1) {
        r0.lambda$show$0(r1);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public /* bridge */ /* synthetic */ void clean() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this.mPlaceHolderViewWrapper.b;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
        trackOpenStart();
        this.mPlaceHolderViewWrapper.b.setVisibility(0);
        trackOpenSuccess("apk_view");
        PreviewViewModel r0 = this.mPreviewViewModel;
        if (r0 == null) goto L6;
        r0.liveInnerFileNameChanged().observe(this.mViewOwner.lifecycleOwner(), new a(this));
        return;
    }

    private void initPlaceHolderView(a95.a r8) {
        PlaceHolderView r2 = new PlaceHolderView(this.mContext);
        r2.b(this.mParentViewOwner, this.mViewOwner);
        r2.setImagePlaceHolder(kac.a.b(2131254617));
        r2.setTipsText(this.mFileModel.a);
        r2.setSizeInBytes(this.mFileModel.e);
        r2.setPrimaryText(this.mContext.getString(2131888413));
        r2.setBtnOpenExternalVisibility(false);
        this.mPlaceHolderViewWrapper = new x(this.mContext, r2, com.bytedance.ee.bear.drive.biz.external.f.e(this.mPreviewViewModel.getBizType(), this.mContext, r8), this.mViewOwner, this.mFileModel);
    }

    private void lambda$show$0(String r2) {
        this.mFileModel.a = r2;
        this.mPlaceHolderViewWrapper.b.setTipsText(r2);
    }

    public ApkPreviewView(ViewOwner r1, ViewOwner r2, Context r3, z r4, a95.a r5) {
        super(r1, r2, r3, r4, r5);
        initPlaceHolderView(r5);
    }
}
