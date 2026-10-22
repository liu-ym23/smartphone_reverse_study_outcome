package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.bear.drive.biz.permission.DrivePermissionViewModel;
import com.bytedance.ee.bear.drive.biz.preview.viewfinder.DriveViewFinderVM;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
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
    public void onCommentInputPanelClose(boolean r100) {
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
    public /* bridge */ /* synthetic */ void onNewConfiguration(Configuration r100) {
    }

    public void onPermissionChanged(boolean r100) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showSelectedComment(String r100) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showThumbnailPreview() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void updateComment(ArrayList<CommentRectF> r100) {
    }

    public void disableBehavior() {
        View r100 = ((DriveViewFinderVM) this.mViewOwner.viewModel(DriveViewFinderVM.class)).findViewById(R.id.main_page_holder_view);
        if (r100 == null) goto L6;
        ((CoordinatorLayout.LayoutParams) r100.getLayoutParams()).setBehavior(null);
        return;
    }

    public void initWebViewBehavior() {
        View r100 = ((DriveViewFinderVM) this.mViewOwner.viewModel(DriveViewFinderVM.class)).findViewById(R.id.main_page_holder_view);
        if (r100 == null) goto L8;
        CoordinatorLayout.LayoutParams r101 = (CoordinatorLayout.LayoutParams) r100.getLayoutParams();
        CoordinatorLayout.Behavior r102 = r101.getBehavior();
        if ((r102 instanceof FooterBehavior) == false) goto L9;
        r101.setBehavior(new WebViewFooterBehavior(((FooterBehavior) r102).f225725a));
        return;
    L9:
        return;
    }

    public void trackOpenStart() {
        PreviewViewModel r100 = this.mPreviewViewModel;
        if (r100 == null) goto L5;
        r100.liveInnerReportMsg().a(new a0(1));
    L5:
        j65.a.b(this.mPreviewViewModel, getClass().getSimpleName());
    }

    public z getPreviewFileModel() {
        return this.mFileModel;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c95.c r100) {
        this.mShowViewTrackEventCallback = r100;
    }

    public void setSourceType(int r100) {
        this.mSourceType = r100;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r100) {
        this.mUserComponentAbility = r100;
    }

    public void trackOpenDowngradeSuccess(String r100) {
        tt5.a.h(TAG, "trackOpenDowngradeSuccess, openType: " + r100);
        if (this.mPreviewViewModel != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r100, "not_support_view") == true) goto L9;
        HashMap r101 = new HashMap();
        r101.put("open_type", r100);
        r101.put("source_type", String.valueOf(this.mSourceType));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(22, r101));
        return;
    }

    public void trackOpenSuccess(String r100) {
        if (this.mPreviewViewModel != null) goto L5;
    L7:
        c95.c r101 = this.mShowViewTrackEventCallback;
        if (r101 == null) goto L10;
        r101.b(r100);
    L10:
        j65.a.c(this.mPreviewViewModel, getClass().getSimpleName());
        return;
    L5:
        if (TextUtils.equals(r100, "not_support_view") == true) goto L7;
        HashMap r102 = new HashMap();
        r102.put("open_type", r100);
        r102.put("source_type", String.valueOf(this.mSourceType));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(2, r102));
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onSetup(ViewOwner r100, ViewOwner r101) {
        this.mViewOwner = r101;
        this.mParentViewOwner = r100;
        this.mPreviewViewModel = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
    }

    public void trackOpenDowngradeFail(String r100, Throwable r101) {
        tt5.a.l(TAG, "trackOpenDowngradeFail, openType: " + r100, r101);
        if (this.mPreviewViewModel == null) goto L6;
        HashMap r102 = new HashMap();
        r102.put("open_type", r100);
        r102.put("source_type", String.valueOf(this.mSourceType));
        r102.put("error_message", t85.b.a(r101));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(21, r102));
        return;
    }

    public void trackOpenFailed(String r100, Throwable r101) {
        tt5.a.l(TAG, "trackOpenFailed, openType: " + r100, r101);
        if (this.mPreviewViewModel == null) goto L5;
        HashMap r102 = new HashMap();
        r102.put("open_type", r100);
        r102.put("source_type", String.valueOf(this.mSourceType));
        r102.put("error_message", t85.b.a(r101));
        this.mPreviewViewModel.liveInnerReportMsg().a(new a0(3, r102));
    L5:
        c95.c r103 = this.mShowViewTrackEventCallback;
        if (r103 == null) goto L8;
        r103.a(r100, r101);
    L8:
        j65.a.a(this.mPreviewViewModel, getClass().getSimpleName());
    }

    public AbsPreviewView(ViewOwner r100, ViewOwner r101, Context r102, z r103, a95.a r104) {
        this.mParentViewOwner = r100;
        this.mViewOwner = r101;
        this.mPreviewViewModel = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        this.mPermissionViewModel = (DrivePermissionViewModel) r101.viewModel(DrivePermissionViewModel.class);
        this.mContext = r102;
        this.mFileModel = r103;
        this.mUserComponentAbility = r104;
    }
}
