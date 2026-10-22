package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowVM;
import com.bytedance.ee.bear.drive.view.preview.image.thumb.DriveImageThumbViewModel;
import com.bytedance.ee.bear.drive.view.preview.imageviewer.PhotoViewContainer;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImagePreviewView extends AbsPreviewView implements com.bytedance.ee.bear.drive.biz.preview.vc.connector.g {
    private static final String TAG = "ImagePreviewView";
    private CommentRectLayout mCommentRectLayout;
    private g85.f mMimeTypeManager;
    private Observer<ConnectionService.NetworkState> mNetworkStateObserver;
    private PhotoViewContainer mPhotoViewContainer;
    private DriveImageThumbViewModel mThumbViewModel;
    private boolean mVCFollowInit;

    public class a extends com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a {
        public final /* synthetic */ ImagePreviewView a;

        public a(ImagePreviewView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b
        public final void b(String r3, Throwable r4, boolean r5, boolean r6) {
            tt5.a.e(ImagePreviewView.TAG, "OnPhotoRequestListener onError", r4, false);
            if (ImagePreviewView.access$000(this.a).r == true) goto L8;
            if (r6 == false) goto L8;
            tt5.a.d(ImagePreviewView.TAG, "OnPhotoRequestListener onError: run downgrade");
            ImagePreviewView.access$000(this.a).setDowngrade(true);
            ImagePreviewView.access$000(this.a).show();
            return;
        L8:
            if (r5 == false) goto L10;
            this.a.mPreviewViewModel.liveInnerShowRetryPage().postValue(null);
            return;
        L10:
            this.a.mPreviewViewModel.getLiveInnerShowPreviewFailedPage().postValue(null);
        }
    }

    public class b implements c95.c {
        public final /* synthetic */ ImagePreviewView a;

        @Override // c95.c
        public final void onShowStart() {
            this.a.trackOpenStart();
        }

        public b(ImagePreviewView r1) {
            this.a = r1;
        }

        @Override // c95.c
        public final void b(String r4) {
            Boolean r0 = (Boolean) ImagePreviewView.access$100(this.a).isOnImageThumbProcess().getValue();
            MutableLiveData<Boolean> r1 = ImagePreviewView.access$100(this.a).isImageThumbSuccess();
            Boolean r2 = Boolean.TRUE;
            if (r2.equals(r0) == true) goto L5;
        L8:
            this.a.trackOpenSuccess(r4);
            if (this.a.mFileModel.j == false) goto L13;
            r1.postValue(r2);
            return;
        L13:
            return;
        L5:
            if (this.a.mFileModel.j == true) goto L8;
            if (r2.equals(r1.getValue()) == false) goto L8;
        }

        @Override // c95.c
        public final void a(String r3, Throwable r4) {
            if (Boolean.TRUE.equals((Boolean) ImagePreviewView.access$100(this.a).isOnImageThumbProcess().getValue()) == true) goto L5;
        L8:
            this.a.trackOpenFailed(r3, r4);
            return;
        L5:
            if (this.a.mFileModel.j == false) goto L8;
            tt5.a.d(ImagePreviewView.TAG, "onImageThumbProcess thumb show fail: " + r4);
        }
    }

    public static /* synthetic */ void a(ImagePreviewView r0, Boolean r1) {
        r0.lambda$new$0(r1);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public /* bridge */ /* synthetic */ void clean() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentListPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    private void initTrackEvent() {
        this.mPhotoViewContainer.setOnShowViewTrackEventCallback(new b(this));
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this.mPhotoViewContainer.getView();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public CommentRectF hideCreateComment() {
        return this.mPhotoViewContainer.hideCreateComment();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.g
    public boolean isVcFollow() {
        Boolean r0 = (Boolean) ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveIsVCFollowMode().getValue();
        return Boolean.TRUE.equals(r0);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onAreaClick() {
        return this.mPhotoViewContainer.onAreaClick();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onBackPressed() {
        CommentRectLayout r0 = this.mCommentRectLayout;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.q() == false) goto L10;
        this.mCommentRectLayout.j();
        this.mPreviewViewModel.liveInnerForceFullScreen().postValue(Boolean.FALSE);
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentInputPanelOpen() {
        this.mPhotoViewContainer.onCommentInputPanelOpen();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentListPanelClose() {
        this.mPhotoViewContainer.onCommentListPanelClose();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showThumbnailPreview() {
        this.mPhotoViewContainer.f();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.g
    public void onViewReady() {
        boolean r0 = isVcFollow();
        tt5.a.h(TAG, "onViewReady: init=" + this.mVCFollowInit + ", isVCFollow=" + r0);
        if (this.mVCFollowInit == true) goto L8;
        this.mVCFollowInit = true;
        if (r0 == false) goto L9;
        ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveFollowDocumentInfo().setValue(new l65.d(n65.a.class, this.mPhotoViewContainer));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
        initTrackEvent();
        this.mPhotoViewContainer.show();
        this.mPreviewViewModel.liveInnerAreaCommentEnableState().postValue(Boolean.TRUE);
    }

    public static /* synthetic */ PhotoViewContainer access$000(ImagePreviewView r0) {
        return r0.mPhotoViewContainer;
    }

    public static /* synthetic */ DriveImageThumbViewModel access$100(ImagePreviewView r0) {
        return r0.mThumbViewModel;
    }

    private void initPhotoViewContainer(z r4) {
        int r0 = this.mPreviewViewModel.getBizType();
        PhotoViewContainer r1 = new PhotoViewContainer(this.mContext);
        this.mPhotoViewContainer = r1;
        r1.setUserAbility(this.mUserComponentAbility);
        PhotoViewContainer r2 = this.mPhotoViewContainer;
        r2.k = new PhotoViewContainer.a(r4, r0);
        r2.onSetup(this.mParentViewOwner, this.mViewOwner);
        this.mPhotoViewContainer.setIsVCFollow(this);
        this.mPhotoViewContainer.setMimeTypeManager(this.mMimeTypeManager);
        this.mPhotoViewContainer.setOnPhotoRequestListener(new a(this));
        this.mCommentRectLayout = this.mPhotoViewContainer.getCommentRectLayout();
        if (r4.j == false) goto L6;
        ((DriveImageThumbViewModel) this.mViewOwner.viewModel(DriveImageThumbViewModel.class)).isOnImageDowngrade().postValue(Boolean.TRUE);
        return;
    }

    private /* synthetic */ void lambda$new$0(Boolean r2) {
        CommentRectLayout r0 = this.mCommentRectLayout;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r0.setDisableShowCommentRect(r3);
        return;
    L5:
        if (r2.booleanValue() == false) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentInputPanelClose(boolean r2) {
        this.mPhotoViewContainer.onCommentInputPanelClose(r2);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public void onPermissionChanged(boolean r1) {
        this.mPhotoViewContainer.getClass();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showSelectedComment(String r2) {
        this.mPhotoViewContainer.showSelectedComment(r2);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void updateComment(ArrayList<CommentRectF> r2) {
        this.mPhotoViewContainer.updateComment(r2);
    }

    public ImagePreviewView(ViewOwner r1, ViewOwner r2, Context r3, z r4, a95.a r5) {
        super(r1, r2, r3, r4, r5);
        this.mVCFollowInit = false;
        this.mMimeTypeManager = o75.b.a().getMimeTypeManager();
        this.mThumbViewModel = (DriveImageThumbViewModel) r2.viewModel(DriveImageThumbViewModel.class);
        initPhotoViewContainer(r4);
        this.mPreviewViewModel.liveOuterDisableShowComment().observe(r2.lifecycleOwner(), new n(this));
    }
}
