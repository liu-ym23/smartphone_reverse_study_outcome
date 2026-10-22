package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.content.res.Configuration;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class NotSupportPreviewView extends AbsPreviewView {
    private PlaceHolderView mPlaceHolderView;
    private x mPlaceHolderViewWrapper;

    public static /* synthetic */ void a(View r0) {
        lambda$initPlaceHolderView$0(r0);
    }

    private static /* synthetic */ void lambda$initPlaceHolderView$0(View r0) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public /* bridge */ /* synthetic */ void clean() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean isPreviewSupported() {
        return false;
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
        trackOpenSuccess("not_support_view");
    }

    private void initPlaceHolderView(a95.a r9) {
        PlaceHolderView r0 = new PlaceHolderView(this.mContext);
        this.mPlaceHolderView = r0;
        r0.b(this.mParentViewOwner, this.mViewOwner);
        this.mPlaceHolderView.setImagePlaceHolder(2131232553);
        PlaceHolderView r1 = this.mPlaceHolderView;
        Context r2 = this.mContext;
        z r3 = this.mFileModel;
        r1.setTipsText(getTypeTipsText(r2, r3, r3.b));
        this.mPlaceHolderView.setSizeInBytes(this.mFileModel.e);
        this.mPlaceHolderView.setPrimaryText(this.mContext.getString(2131888429));
        this.mPlaceHolderView.setOnClickListener(new o());
        this.mPlaceHolderViewWrapper = new x(this.mContext, this.mPlaceHolderView, com.bytedance.ee.bear.drive.biz.external.f.e(this.mPreviewViewModel.getBizType(), this.mContext, r9), this.mViewOwner, this.mFileModel);
    }

    public void setEncryptedFile(boolean r3) {
        if (r3 == false) goto L7;
        PlaceHolderView r4 = this.mPlaceHolderView;
        if (r4 == null) goto L8;
        r4.setTipsText(this.mContext.getString(2131889538));
        return;
    L8:
        return;
    }

    public void setHandoverFile(String r2) {
        if (r2 != null) goto L4;
        r2 = this.mContext.getString(2131888398);
    L4:
        this.mPlaceHolderView.setTipsText(r2);
    }

    public void setOnClickListener(View.OnClickListener r2) {
        PlaceHolderView r0 = this.mPlaceHolderView;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    private SpannableString getTypeTipsText(Context r3, z r4, String r5) {
        int r6 = r4.h;
        if (r6 != 5) goto L7;
        return new SpannableString(r3.getString(2131888436));
    L7:
        if (r6 != 6) goto L11;
        return new SpannableString(r3.getString(2131888437));
    L11:
        if (r6 == 1006) goto L13;
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        SpannableString r7 = new SpannableString(String.format("%s .%s", new Object[]{r3.getString(2131888438), r5.toLowerCase()}));
        r7.setSpan(new StyleSpan(1), 0, r7.length(), 33);
        return r7;
    L13:
        return new SpannableString(r3.getString(2131890719));
    }

    public NotSupportPreviewView(ViewOwner r1, ViewOwner r2, Context r3, z r4, a95.a r5) {
        super(r1, r2, r3, r4, r5);
        initPlaceHolderView(r5);
    }
}
