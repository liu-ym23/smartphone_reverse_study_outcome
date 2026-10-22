package com.bytedance.ee.bear.drive.biz.extra_info;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentVM;
import com.bytedance.ee.bear.drive.biz.encryption.DriveEncryptionVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0005H\u0017J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/extra_info/DriveSpaceFileExtraInfoViewPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "mExtraInfoView", "Lcom/bytedance/ee/bear/drive/biz/extra_info/FileExtraInfoView;", "mMainPageRootRl", "Landroid/view/ViewGroup;", "driveFullscreenAnimationEnabled", "", "hideByPerceive", "permAllow", "fullScreenAllow", "videoFullScreenAllow", "scapeAllow", "liveInnerAllow", "panelAllow", "thumbAllow", "deleteAllow", "passwordAllow", "fileLoadAllow", "addExtraViewListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "handleCommentShow", "", "isAllowToShow", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "canShowComment", "onAttachPreview", "onDetachPreview", "getFileExtraView", "findMainPageRoot", "ensureFileExtraView", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFileExtraInfoViewPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveSpaceFileExtraInfoViewPlugin";
    private final u75.b.a addExtraViewListener;
    private boolean deleteAllow;
    private final boolean driveFullscreenAnimationEnabled;
    private boolean fileLoadAllow;
    private boolean fullScreenAllow;
    private boolean hideByPerceive;
    private boolean liveInnerAllow;
    private FileExtraInfoView mExtraInfoView;
    private ViewGroup mMainPageRootRl;
    private boolean panelAllow;
    private boolean passwordAllow;
    private boolean permAllow;
    private boolean scapeAllow;
    private boolean thumbAllow;
    private boolean videoFullScreenAllow;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements u75.b.a {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        @Override // u75.b.a
        public final void b(z r2) {
            Intrinsics.checkNotNullParameter(r2, "previewFileModel");
        }

        @Override // u75.b.a
        public final void c(ErrCode r2) {
            Intrinsics.checkNotNullParameter(r2, "code");
        }

        @Override // u75.b.a
        public final void onProgress(int r1) {
        }

        public b(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.a
        public final <I> void a(InfoCode r2, I r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 == InfoCode.FileInfoSuccess) goto L5;
            return;
        L5:
            if ((r3 instanceof w75.a) == false) goto L25;
            tt5.a.h(DriveSpaceFileExtraInfoViewPlugin.TAG, "addExtraViewListener - onInfo, load file finished.");
            this.a.getHost().c().g(this);
            FileExtraInfoView r4 = DriveSpaceFileExtraInfoViewPlugin.access$getMExtraInfoView$p(this.a);
            if (r4 != null) goto L10;
            return;
        L10:
            if (r4.getParent() != null) goto L12;
            boolean r5 = true;
        L13:
            if (r5 == true) goto L16;
            r4 = null;
        L16:
            if (r4 == null) goto L24;
            DriveSpaceFileExtraInfoViewPlugin r6 = this.a;
            ViewGroup r0 = DriveSpaceFileExtraInfoViewPlugin.access$getMMainPageRootRl$p(r6);
            if (r0 == null) goto L20;
            r0.addView(r4);
        L20:
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(r6);
            return;
        L24:
            return;
        L12:
            r5 = false;
            goto L13
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public c(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            DriveSpaceFileExtraInfoViewPlugin.access$setDeleteAllow$p(this.a, false);
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public d(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            DriveSpaceFileExtraInfoViewPlugin.access$setScapeAllow$p(this.a, false);
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public e(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            DriveSpaceFileExtraInfoViewPlugin.access$setScapeAllow$p(this.a, true);
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public f(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            DriveSpaceFileExtraInfoViewPlugin.access$setPasswordAllow$p(this.a, !((Boolean) r2).booleanValue());
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public g(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            DriveSpaceFileExtraInfoViewPlugin r0 = this.a;
            if (r4 != null) goto L6;
        L8:
            boolean r5 = false;
        L9:
            DriveSpaceFileExtraInfoViewPlugin.access$setFileLoadAllow$p(r0, r5);
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
            return;
        L6:
            if (r4.intValue() != 2) goto L8;
            r5 = true;
            goto L9
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public h(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            com.bytedance.ee.bear.drive.biz.comment.g r2 = (com.bytedance.ee.bear.drive.biz.comment.g) r1;
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public i(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            u55.b r6 = (u55.b) r5;
            if (r6 == null) goto L20;
            DriveSpaceFileExtraInfoViewPlugin r0 = this.a;
            if (r6.h() == false) goto L7;
        L17:
            DriveSpaceFileExtraInfoViewPlugin.access$setPermAllow$p(r0, false);
            DriveSpaceFileExtraInfoViewPlugin.access$setHideByPerceive$p(r0, true);
        L18:
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(r0);
            return;
        L7:
            if (r6.b.a.isConditionAccessControl() == true) goto L17;
            if (DriveSpaceFileExtraInfoViewPlugin.access$getHideByPerceive$p(r0) == false) goto L13;
            DriveSpaceFileExtraInfoViewPlugin.access$setHideByPerceive$p(r0, false);
            DriveSpaceFileExtraInfoViewPlugin.access$setPermAllow$p(r0, true);
            goto L18
        L13:
            if (r6.k() == true) goto L18;
            if (r6.f() != 10013) goto L18;
            DriveSpaceFileExtraInfoViewPlugin.access$setPermAllow$p(r0, false);
            goto L18
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public j(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            com.bytedance.ee.bear.drive.biz.preview.screen.a r4 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) r3;
            DriveSpaceFileExtraInfoViewPlugin.access$ensureFileExtraView(this.a);
            DriveSpaceFileExtraInfoViewPlugin.access$setFullScreenAllow$p(this.a, !r4.a);
            if (DriveSpaceFileExtraInfoViewPlugin.access$getDriveFullscreenAnimationEnabled$p(this.a) == true) goto L5;
        L7:
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
            return;
        L5:
            if (r4.a == false) goto L7;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public k(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L5;
            DriveSpaceFileExtraInfoViewPlugin.access$setVideoFullScreenAllow$p(this.a, false);
        L6:
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
            return;
        L5:
            DriveSpaceFileExtraInfoViewPlugin.access$setVideoFullScreenAllow$p(this.a, true);
            goto L6
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public l(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.FALSE) == false) goto L5;
            DriveSpaceFileExtraInfoViewPlugin.access$setPermAllow$p(this.a, false);
        L5:
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
        }
    }

    public static final class m<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public m(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            DriveSpaceFileExtraInfoViewPlugin.access$setThumbAllow$p(this.a, !((Boolean) r2).booleanValue());
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
        }
    }

    public static final class n<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public n(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L5;
            DriveSpaceFileExtraInfoViewPlugin.access$setLiveInnerAllow$p(this.a, true);
        L6:
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
            return;
        L5:
            DriveSpaceFileExtraInfoViewPlugin.access$setLiveInnerAllow$p(this.a, false);
            goto L6
        }
    }

    public static final class o<T> implements Observer {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public o(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L5;
            DriveSpaceFileExtraInfoViewPlugin.access$setPanelAllow$p(this.a, false);
        L6:
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);
            return;
        L5:
            DriveSpaceFileExtraInfoViewPlugin.access$setPanelAllow$p(this.a, true);
            goto L6
        }
    }

    public static final class p implements Runnable {
        public final /* synthetic */ DriveSpaceFileExtraInfoViewPlugin a;

        public p(DriveSpaceFileExtraInfoViewPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DriveSpaceFileExtraInfoViewPlugin.access$setDeleteAllow$p(this.a, false);     // Catch: Throwable -> L4
            DriveSpaceFileExtraInfoViewPlugin.access$handleCommentShow(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void findMainPageRoot() {
        if (this.mMainPageRootRl != null) goto L6;
        this.mMainPageRootRl = (ViewGroup) findViewById(2131379451);
    L6:
        if (this.mMainPageRootRl != null) goto L9;
        tt5.a.d("DriveComponent", "DriveSpaceFileExtraInfoViewPlugin() find mainPageRootRl null");
        return;
    }

    private final void handleCommentShow() {
        com.bytedance.ee.bear.drive.biz.comment.g r0 = (com.bytedance.ee.bear.drive.biz.comment.g) ((DriveCommentVM) viewModel(DriveCommentVM.class)).getLiveCommentEntryDisplayState().getValue();
        boolean r2 = true;
        int r3 = 0;
        if (isAllowToShow() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r0 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L15;
    L20:
        r2 = false;
    L21:
        tt5.a.h(TAG, "handleCommentShow, displayState=" + r0 + ", bottomSelfAllowed=" + r1 + ", shouldShow=" + r2);
        FileExtraInfoView r5 = this.mExtraInfoView;
        if (r5 == null) goto L28;
        if (r2 == true) goto L26;
        r3 = 8;
    L26:
        r5.setVisibility(r3);
        return;
    L28:
        return;
    L15:
        if (r0.c == true) goto L20;
        if (r0.b == true) goto L20;
        if (r1 == false) goto L20;
    L10:
        if (r0.a != true) goto L12;
        r4 = true;
        goto L13
    L5:
        if (canShowComment() == false) goto L7;
        r1 = true;
        goto L8
    }

    private final boolean isAllowToShow() {
        if (this.permAllow == true) goto L5;
    L25:
        boolean r0 = false;
    L26:
        tt5.a.h(TAG, "isAllowToShow, result: " + r0 + ", permAllow: " + this.permAllow + ", fullScreenAllow: " + this.fullScreenAllow + ", videoFullScreenAllow: " + this.videoFullScreenAllow + ", scapeAllow: " + this.scapeAllow + ", liveInnerAllow: " + this.liveInnerAllow + ", panelAllow: " + this.panelAllow + ", thumbAllow: " + this.thumbAllow + ", deleteAllow: " + this.deleteAllow + ", passwordAllow: " + this.passwordAllow + ", fileLoadAllow: " + this.fileLoadAllow + ", isDeleted: " + getHost().c.isIsDeleted());
        return r0;
    L5:
        if (this.fullScreenAllow == false) goto L25;
        if (this.videoFullScreenAllow == false) goto L25;
        if (this.scapeAllow == false) goto L25;
        if (this.liveInnerAllow == false) goto L25;
        if (this.panelAllow == false) goto L25;
        if (this.thumbAllow == false) goto L25;
        if (this.deleteAllow == false) goto L25;
        if (this.passwordAllow == false) goto L25;
        if (this.fileLoadAllow == false) goto L25;
        if (getHost().c.isIsDeleted() == true) goto L25;
        r0 = true;
        goto L26
    }

    public DriveSpaceFileExtraInfoViewPlugin() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.h("spacekit.mobile.drive_fullscreen_animation");
        this.driveFullscreenAnimationEnabled = r0;
        this.permAllow = true;
        this.fullScreenAllow = true;
        this.videoFullScreenAllow = true;
        this.scapeAllow = true;
        this.liveInnerAllow = true;
        this.panelAllow = true;
        this.thumbAllow = true;
        this.deleteAllow = true;
        this.passwordAllow = true;
        this.fileLoadAllow = true ^ w55.n.d;
        tt5.a.h(TAG, "init drive space file extra info view plugin, driveFullscreenAnimationEnabled=" + r0);
        this.addExtraViewListener = new b(this);
    }

    private final boolean canShowComment() {
        if (ku5.c.k(getActivity()) == false) goto L5;
        return true;
    L5:
        DriveFullScreenVM r0 = (DriveFullScreenVM) new ViewModelProvider(getActivity()).get(DriveFullScreenVM.class);
        int r2 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.a;
        if (com.bytedance.ee.bear.drive.biz.preview.orientation.a.C0152a.a(getActivity()) == true) goto L16;
        com.bytedance.ee.bear.drive.biz.preview.screen.a r1 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) r0.getLiveFullScreen().getValue();
        if (r1 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == true) goto L16;
        return true;
    L10:
        if (r1.a != true) goto L12;
        r3 = true;
    L16:
        return false;
    }

    private final void ensureFileExtraView() {
        findMainPageRoot();
        if (this.mExtraInfoView != null) goto L11;
        this.mExtraInfoView = new FileExtraInfoView(getContext());
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-1, -2);
        r0.addRule(12);
        FileExtraInfoView r1 = this.mExtraInfoView;
        if (r1 == null) goto L7;
        r1.setLayoutParams(r0);
    L7:
        handleCommentShow();
        FileExtraInfoView r2 = this.mExtraInfoView;
        if (r2 == null) goto L12;
        r2.setId(2131370259);
        return;
    L12:
        return;
    }

    public FileExtraInfoView getFileExtraView() {
        ensureFileExtraView();
        FileExtraInfoView r0 = this.mExtraInfoView;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        ensureFileExtraView();
        FileExtraInfoView r0 = this.mExtraInfoView;
        if (r0 == null) goto L9;
        t75.b.a(getHost()).e();
        r0.a(getHost().c, canShowComment());
        if (r0.getParent() != null) goto L7;
        getHost().c().c(this.addExtraViewListener);
    L7:
        handleCommentShow();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        getHost().c().g(this.addExtraViewListener);
        FileExtraInfoView r0 = this.mExtraInfoView;
        if (r0 == null) goto L8;
        ViewGroup r1 = this.mMainPageRootRl;
        if (r1 == null) goto L9;
        r1.removeView(r0);
        return;
    L9:
        return;
    }

    public static final /* synthetic */ void access$ensureFileExtraView(DriveSpaceFileExtraInfoViewPlugin r0) {
        r0.ensureFileExtraView();
    }

    public static final /* synthetic */ boolean access$getDriveFullscreenAnimationEnabled$p(DriveSpaceFileExtraInfoViewPlugin r0) {
        return r0.driveFullscreenAnimationEnabled;
    }

    public static final /* synthetic */ boolean access$getHideByPerceive$p(DriveSpaceFileExtraInfoViewPlugin r0) {
        return r0.hideByPerceive;
    }

    public static final /* synthetic */ FileExtraInfoView access$getMExtraInfoView$p(DriveSpaceFileExtraInfoViewPlugin r0) {
        return r0.mExtraInfoView;
    }

    public static final /* synthetic */ ViewGroup access$getMMainPageRootRl$p(DriveSpaceFileExtraInfoViewPlugin r0) {
        return r0.mMainPageRootRl;
    }

    public static final /* synthetic */ void access$handleCommentShow(DriveSpaceFileExtraInfoViewPlugin r0) {
        r0.handleCommentShow();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        ((DriveCommentVM) viewModel(DriveCommentVM.class)).getLiveCommentEntryDisplayState().observe(getLifecycleOwner(), new h(this));
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new i(this));
        ((DriveFullScreenVM) new ViewModelProvider(getActivity()).get(DriveFullScreenVM.class)).getLiveFullScreen().observe(getLifecycleOwner(), new j(this));
        k75.a.i(r5).liveInnerVideoFullScreen().observe(getLifecycleOwner(), new k(this));
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).getLiveConditionControl().observe(getLifecycleOwner(), new l(this));
        k75.a.i(r5).liveInnerThumbVisibleState().observe(getLifecycleOwner(), new m(this));
        k75.a.i(r5).liveInnerExtraViewVisible().observe(getLifecycleOwner(), new n(this));
        ((DriveCommentVM) viewModel(DriveCommentVM.class)).getCommentPanelShowing().observe(getLifecycleOwner(), new o(this));
        addErrorHandler(new p(this), new ErrCode[]{ErrCode.OWNER_DELETED_FILE, ErrCode.FILE_NOT_FOUND, ErrCode.ENCRYPTION_KEY_DELETED});
        ((DriveEncryptionVM) viewModel(DriveEncryptionVM.class)).getEncryptionKeyDeleted().observe(getLifecycleOwner(), new c(this));
        DriveConfigurationVM r0 = (DriveConfigurationVM) viewModel(DriveConfigurationVM.class);
        r0.isLandscape().observe(getLifecycleOwner(), new d(this));
        r0.isPortrait().observe(getLifecycleOwner(), new e(this));
        k75.a.i(r5).liveInnerPasswordEncrypted.observe(getLifecycleOwner(), new f(this));
        if (this.fileLoadAllow == true) goto L6;
        k75.a.i(r5).liveInnerPreviewShowStatus().observe(getLifecycleOwner(), new g(this));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setDeleteAllow$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.deleteAllow = r1;
    }

    public static final /* synthetic */ void access$setFileLoadAllow$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.fileLoadAllow = r1;
    }

    public static final /* synthetic */ void access$setFullScreenAllow$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.fullScreenAllow = r1;
    }

    public static final /* synthetic */ void access$setHideByPerceive$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.hideByPerceive = r1;
    }

    public static final /* synthetic */ void access$setLiveInnerAllow$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.liveInnerAllow = r1;
    }

    public static final /* synthetic */ void access$setPanelAllow$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.panelAllow = r1;
    }

    public static final /* synthetic */ void access$setPasswordAllow$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.passwordAllow = r1;
    }

    public static final /* synthetic */ void access$setPermAllow$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.permAllow = r1;
    }

    public static final /* synthetic */ void access$setScapeAllow$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.scapeAllow = r1;
    }

    public static final /* synthetic */ void access$setThumbAllow$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.thumbAllow = r1;
    }

    public static final /* synthetic */ void access$setVideoFullScreenAllow$p(DriveSpaceFileExtraInfoViewPlugin r0, boolean r1) {
        r0.videoFullScreenAllow = r1;
    }

    public void onDetachFromUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }
}
