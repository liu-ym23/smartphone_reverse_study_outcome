package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.bear.drive.biz.permission.DrivePermissionViewModel;
import com.bytedance.ee.bear.drive.biz.preview.viewfinder.DriveViewFinderVM;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsPreviewView implements m {
    private static final String TAG = "AbsPreviewView";
    protected Context mContext;
    protected z mFileModel;
    protected ViewOwner mParentViewOwner;
    protected DrivePermissionViewModel mPermissionViewModel;
    protected PreviewViewModel mPreviewViewModel;
    protected c95.c mShowViewTrackEventCallback;
    protected int mSourceType;
    protected a95.a mUserComponentAbility;
    protected ViewOwner mViewOwner;

    public /* bridge */ /* synthetic */ void clean() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public String getCommentQuote() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public abstract /* synthetic */ View getView();

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public CommentRectF hideCreateComment() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onAreaClick() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public abstract /* synthetic */ boolean onBackPressed();

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentInputPanelClose(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentInputPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentListPanelClose() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentListPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    public void onPermissionChanged(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showSelectedComment(String r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showThumbnailPreview() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void updateComment(ArrayList<CommentRectF> r1) {
    }

    public void disableBehavior() {
        View r0 = ((DriveViewFinderVM) this.mViewOwner.viewModel(DriveViewFinderVM.class)).findViewById(2131379451);
        if (r0 == null) goto L6;
        r0.getLayoutParams().setBehavior(null);
        return;
    }

    public void initWebViewBehavior() {
        View r0 = ((DriveViewFinderVM) this.mViewOwner.viewModel(DriveViewFinderVM.class)).findViewById(2131379451);
        if (r0 == null) goto L8;
        CoordinatorLayout.LayoutParams r1 = r0.getLayoutParams();
        CoordinatorLayout.Behavior r2 = r1.getBehavior();
        if ((r2 instanceof FooterBehavior) == false) goto L9;
        r1.setBehavior(new WebViewFooterBehavior(((FooterBehavior) r2).a));
        return;
    L9:
        return;
    }

    public void trackOpenStart() {
        PreviewViewModel r0 = this.mPreviewViewModel;
        if (r0 == null) goto L5;
        r0.liveInnerReportMsg().a(new a0(1));
    L5:
        j65.a.b(this.mPreviewViewModel, getClass().getSimpleName());
    }

    public z getPreviewFileModel() {
        return this.mFileModel;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c95.c r1) {
        this.mShowViewTrackEventCallback = r1;
    }

    public void setSourceType(int r1) {
        this.mSourceType = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r1) {
        this.mUserComponentAbility = r1;
    }

    public void trackOpenDowngradeSuccess(String r4) {
        tt5.a.h(TAG, "trackOpenDowngradeSuccess, openType: " + r4);
        if (this.mPreviewViewModel != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r4, "not_support_view") == true) goto L9;
        HashMap r0 = new HashMap();
        r0.put("open_type", r4);
        r0.put("source_type", String.valueOf(this.mSourceType));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(22, r0));
        return;
    }

    public void trackOpenSuccess(String r5) {
        if (this.mPreviewViewModel != null) goto L5;
    L7:
        c95.c r0 = this.mShowViewTrackEventCallback;
        if (r0 == null) goto L10;
        r0.b(r5);
    L10:
        j65.a.c(this.mPreviewViewModel, getClass().getSimpleName());
        return;
    L5:
        if (TextUtils.equals(r5, "not_support_view") == true) goto L7;
        HashMap r1 = new HashMap();
        r1.put("open_type", r5);
        r1.put("source_type", String.valueOf(this.mSourceType));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(2, r1));
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onSetup(ViewOwner r1, ViewOwner r2) {
        this.mViewOwner = r2;
        this.mParentViewOwner = r1;
        this.mPreviewViewModel = (PreviewViewModel) r2.viewModel(PreviewViewModel.class);
    }

    public void trackOpenDowngradeFail(String r3, Throwable r4) {
        tt5.a.l(TAG, "trackOpenDowngradeFail, openType: " + r3, r4);
        if (this.mPreviewViewModel == null) goto L6;
        HashMap r0 = new HashMap();
        r0.put("open_type", r3);
        r0.put("source_type", String.valueOf(this.mSourceType));
        r0.put("error_message", t85.b.a(r4));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(21, r0));
        return;
    }

    public void trackOpenFailed(String r5, Throwable r6) {
        tt5.a.l(TAG, "trackOpenFailed, openType: " + r5, r6);
        if (this.mPreviewViewModel == null) goto L5;
        HashMap r0 = new HashMap();
        r0.put("open_type", r5);
        r0.put("source_type", String.valueOf(this.mSourceType));
        r0.put("error_message", t85.b.a(r6));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(3, r0));
    L5:
        c95.c r1 = this.mShowViewTrackEventCallback;
        if (r1 == null) goto L8;
        r1.a(r5, r6);
    L8:
        j65.a.a(this.mPreviewViewModel, getClass().getSimpleName());
    }

    public AbsPreviewView(ViewOwner r1, ViewOwner r2, Context r3, z r4, a95.a r5) {
        this.mParentViewOwner = r1;
        this.mViewOwner = r2;
        this.mPreviewViewModel = (PreviewViewModel) r2.viewModel(PreviewViewModel.class);
        this.mPermissionViewModel = (DrivePermissionViewModel) r2.viewModel(DrivePermissionViewModel.class);
        this.mContext = r3;
        this.mFileModel = r4;
        this.mUserComponentAbility = r5;
    }
}
