package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowVM;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import com.bytedance.ee.bear.drive.view.preview.pdf.SimplePdfView;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SimplePdfPreviewView extends AbsPreviewView implements com.bytedance.ee.bear.drive.biz.preview.vc.connector.g {
    private static final String TAG = "SimplePdfPreviewView";
    private q75.a mDriveConfig;
    private v95.a mPdfEntity;
    private m mPdfView;
    private boolean mVCFollowInit;

    public class a implements com.bytedance.ee.bear.drive.view.preview.ttreader.a.c {
        public final /* synthetic */ SimplePdfPreviewView a;

        @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.a.c
        public final void a() {
            PreviewViewModel r0 = this.a.mPreviewViewModel;
            if (r0 == null) goto L6;
            r0.liveInnerForceFullScreen().postValue(Boolean.FALSE);
            return;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.a.c
        public final void b() {
            PreviewViewModel r0 = this.a.mPreviewViewModel;
            if (r0 == null) goto L6;
            r0.liveInnerForceFullScreen().postValue(Boolean.TRUE);
            return;
        }

        @Override // com.bytedance.ee.bear.drive.view.preview.ttreader.a.c
        public final void toggle() {
            PreviewViewModel r0 = this.a.mPreviewViewModel;
            if (r0 == null) goto L6;
            r0.liveInnerToggleFullScreen().postValue(this.a.mFileModel.c);
            return;
        }

        public a(SimplePdfPreviewView r1) {
            this.a = r1;
        }
    }

    public class b implements c95.c {
        public final /* synthetic */ SimplePdfPreviewView a;

        @Override // c95.c
        public final void onShowStart() {
            this.a.trackOpenStart();
        }

        public b(SimplePdfPreviewView r1) {
            this.a = r1;
        }

        @Override // c95.c
        public final void b(String r2) {
            this.a.trackOpenSuccess(r2);
            SimplePdfPreviewView.access$000(this.a);
        }

        @Override // c95.c
        public final void a(String r2, Throwable r3) {
            this.a.trackOpenFailed(r2, r3);
        }
    }

    public class c implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        public c() {
        }
    }

    public class d implements c95.c {
        public final /* synthetic */ SimplePdfPreviewView a;

        @Override // c95.c
        public final void onShowStart() {
            this.a.trackOpenStart();
        }

        public d(SimplePdfPreviewView r1) {
            this.a = r1;
        }

        @Override // c95.c
        public final void b(String r2) {
            this.a.trackOpenSuccess(r2);
            SimplePdfPreviewView.access$000(this.a);
        }

        @Override // c95.c
        public final void a(String r2, Throwable r3) {
            this.a.trackOpenFailed(r2, r3);
        }
    }

    public static /* synthetic */ void a(SimplePdfPreviewView r0, SimplePdfView r1, View r2) {
        r0.lambda$initSimplePdf$0(r1, r2);
    }

    private void adjustViewForImmersive() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public /* bridge */ /* synthetic */ void clean() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    private m initSimplePdf() {
        final SimplePdfView r0 = new SimplePdfView(this.mContext);
        r0.setUserAbility(this.mUserComponentAbility);
        r0.onSetup(this.mParentViewOwner, this.mViewOwner);
        boolean r1 = isVcFollow();
        Integer r2 = (Integer) ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveBizType().getValue();
        boolean r3 = false;
        if (r2 != null) goto L5;
        int r4 = 0;
    L7:
        if (r1 == false) goto L9;
    L12:
        boolean r5 = true;
    L13:
        r0.setPresentationEnable(r5);
        if (r1 == false) goto L28;
        r0.setIsVCFollow(this);
        if (this.mContext.getResources().getConfiguration().orientation != 1) goto L18;
        r3 = true;
    L18:
        int r6 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(r4) == false) goto L22;
        ExhibitionMode r7 = ExhibitionMode.NORMAL;
    L25:
        r0.setDefaultExhibitionMode(r7);
        if (r3 == false) goto L29;
        this.mPreviewViewModel.liveInnerForceFullScreen().postValue(Boolean.TRUE);
    L29:
        r0.i = this.mPdfEntity;
        r0.setOnPageClickListener(new i0(this, r0));
        r0.addOnAttachStateChangeListener(new c());
        return r0;
    L22:
        if (((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).isPresenter() == false) goto L24;
        r7 = ExhibitionMode.PRESENTATION;
        goto L25
    L24:
        r7 = ExhibitionMode.NORMAL;
        goto L25
    L28:
        r0.setDefaultExhibitionMode(ExhibitionMode.NORMAL);
        goto L29
    L9:
        if (this.mDriveConfig.i == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r4 = r2.intValue();
        goto L7
    }

    private void initTrackEvent() {
        m r0 = this.mPdfView;
        if (r0 == null) goto L6;
        r0.setOnShowViewTrackEventCallback(new d(this));
        return;
    }

    private boolean isEnterPresentation() {
        Integer r0 = (Integer) ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveBizType().getValue();
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a(r1) == false) goto L10;
        return false;
    L10:
        if (((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).isPresenter() == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = r0.intValue();
        goto L7
    }

    private com.bytedance.ee.bear.drive.view.preview.ttreader.a newClickHelper() {
        com.bytedance.ee.bear.drive.view.preview.ttreader.a r0 = new com.bytedance.ee.bear.drive.view.preview.ttreader.a();
        r0.h = new com.bytedance.ee.bear.drive.view.preview.ttreader.a.b(true, true);
        r0.d = new a(this);
        return r0;
    }

    private c95.c newTrackEventCallback() {
        return new b(this);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public String getCommentQuote() {
        m r0 = this.mPdfView;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getCommentQuote();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this.mPdfView.getView();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public CommentRectF hideCreateComment() {
        return this.mPdfView.hideCreateComment();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.g
    public boolean isVcFollow() {
        Boolean r0 = (Boolean) ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveIsVCFollowMode().getValue();
        return Boolean.TRUE.equals(r0);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onAreaClick() {
        return this.mPdfView.onAreaClick();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onBackPressed() {
        m r0 = this.mPdfView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.onBackPressed() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentInputPanelOpen() {
        this.mPdfView.onCommentInputPanelOpen();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentListPanelClose() {
        this.mPdfView.onCommentListPanelClose();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentListPanelOpen() {
        this.mPdfView.onCommentListPanelOpen();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showThumbnailPreview() {
        this.mPdfView.showThumbnailPreview();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.g
    public void onViewReady() {
        boolean r0 = isVcFollow();
        tt5.a.h(TAG, "onViewReady: init=" + this.mVCFollowInit + ", isVCFollow=" + r0);
        if (this.mVCFollowInit == true) goto L8;
        this.mVCFollowInit = true;
        if (r0 == false) goto L9;
        ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveFollowDocumentInfo().setValue(new l65.d(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.class, (SimplePdfView) this.mPdfView));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
        initTrackEvent();
        i75.n.a(this.mPdfEntity, this.mFileModel);
        if (this.mPdfEntity.c == false) goto L5;
        PreviewViewModel.a r0 = new PreviewViewModel.a();
        r0.a = xo5.a.c(this.mContext, 2131888435, "ext", "." + this.mFileModel.b);
        r0.b = 1;
        this.mPreviewViewModel.getLiveInnerChangeTipsState().postValue(r0);
    L5:
        this.mPdfView.show();
    }

    public static /* synthetic */ void access$000(SimplePdfPreviewView r0) {
        r0.adjustViewForImmersive();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onCommentInputPanelClose(boolean r2) {
        this.mPdfView.onCommentInputPanelClose(r2);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void onNewConfiguration(Configuration r2) {
        m r0 = this.mPdfView;
        if (r0 == null) goto L6;
        r0.onNewConfiguration(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void showSelectedComment(String r2) {
        this.mPdfView.showSelectedComment(r2);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void updateComment(ArrayList<CommentRectF> r2) {
        this.mPdfView.updateComment(r2);
    }

    private void lambda$initSimplePdf$0(SimplePdfView r1, View r2) {
        PreviewViewModel r3 = this.mPreviewViewModel;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r1.x == true) goto L9;
        r3.liveInnerToggleFullScreen().postValue(this.mFileModel.c);
        return;
    }

    public SimplePdfPreviewView(ViewOwner r1, ViewOwner r2, Context r3, z r4, a95.a r5) {
        super(r1, r2, r3, r4, r5);
        this.mVCFollowInit = false;
        this.mDriveConfig = o75.b.a().getDriveConfig();
        this.mPdfEntity = new v95.a();
        this.mPdfView = initSimplePdf();
    }
}
