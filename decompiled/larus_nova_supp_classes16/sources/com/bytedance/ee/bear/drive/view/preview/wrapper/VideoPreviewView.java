package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveViewFullScreenVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowVM;
import com.bytedance.ee.bear.drive.core.ai.DriveAiInteractionVM;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.UrlSplicer;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.capture.DriveCaptureVM;
import com.bytedance.ee.bear.drive.view.preview.media.DriveMediaVM;
import com.bytedance.ee.bear.drive.view.preview.video.TTVideoView;
import com.bytedance.ee.bear.drive.view.preview.video.VideoCacheViewModel;
import com.bytedance.ee.bear.drive.view.preview.video.VideoPlayerContentView;
import com.bytedance.ee.bear.drive.view.preview.video.VideoPlayerControllerView;
import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import com.bytedance.ee.bear.drive.view.preview.video.aisummary.VideoSummaryViewModel;
import com.bytedance.ee.bear.middleground.drive.export.player.view.VideoSurfaceView;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.ttvideoengine.TTVideoEngine;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VideoPreviewView extends AbsPreviewView implements com.bytedance.ee.bear.drive.biz.preview.vc.connector.g {
    private static final String TAG = "DRIVE_VideoPlayer";
    private Pattern NET_UNUSABLE_CODE_PATTEN;
    private final fa5.a aiSummaryDependency;
    private VideoCacheViewModel cacheViewModel;
    private Disposable clearVideoCacheDisposable;
    private FrameLayout container;
    private final View.OnAttachStateChangeListener containerAttachStateChangeListener;
    private ga5.d deviceController;
    private boolean hasReport;
    private final boolean mIsVCFollow;
    private String mOpenType;
    private boolean mVCFollowInit;
    private VideoView mVideoView;
    private VideoSummaryViewModel videoSummaryViewModel;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ VideoPreviewView a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public a(VideoPreviewView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
            VideoPreviewView.access$000(this.a);
        }
    }

    public class b extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ DriveBlockPreviewVM c;
        public final /* synthetic */ VideoPreviewView d;

        public final void a(View r4) {
            if (VideoPreviewView.access$100(this.d) == null) goto L9;
            if (VideoPreviewView.access$100(this.d).isSummaryExpand() == false) goto L9;
            VideoPreviewView.access$100(this.d).collapseSummary();
            return;
        L9:
            if (VideoPreviewView.access$200(this.d).getBarsShowState() == 0) goto L11;
            boolean r5 = true;
        L13:
            if (VideoPreviewView.access$100(this.d) == null) goto L15;
            VideoPreviewView.access$100(this.d).sendEvent(new fa5.c.a(!r5));
        L15:
            DriveBlockPreviewVM.BlockState r0 = (DriveBlockPreviewVM.BlockState) this.c.getLiveBlockState().getValue();
            if (r0 == null) goto L23;
            if (r0 == DriveBlockPreviewVM.BlockState.FULLSCREEN) goto L23;
            if (r5 == false) goto L26;
            VideoPreviewView.access$200(this.d).x();
            return;
        L26:
            return;
        L23:
            if (VideoPreviewView.access$300(this.d) == null) goto L28;
            VideoPreviewView.access$300(this.d).d.onClick();
            return;
        L28:
            return;
        L11:
            r5 = false;
            goto L13
        }

        public b(VideoPreviewView r1, DriveBlockPreviewVM r2) {
            this.d = r1;
            this.c = r2;
        }
    }

    public static /* synthetic */ void a(VideoPreviewView r0, Runnable r1, Throwable r2) {
        r0.lambda$clearVideoCacheAndRetry$5(r1, r2);
    }

    public static /* synthetic */ Boolean b(VideoPreviewView r0) {
        return r0.lambda$clearVideoCacheAndRetry$3();
    }

    public static /* synthetic */ void c(VideoPreviewView r0, boolean r1, Throwable r2) {
        r0.lambda$initVideoView$2(r1, r2);
    }

    public static /* synthetic */ void d(VideoPreviewView r0, Runnable r1, Boolean r2) {
        r0.lambda$clearVideoCacheAndRetry$4(r1, r2);
    }

    public static /* synthetic */ void e(VideoPreviewView r0, com.bytedance.ee.bear.drive.biz.preview.screen.a r1) {
        r0.lambda$initVideoView$1(r1);
    }

    public static /* synthetic */ void f(VideoPreviewView r0, ea5.z r1) {
        r0.clearVideoCacheAndRetry(r1);
    }

    public static /* synthetic */ void g(VideoPreviewView r0, Runnable r1) {
        r0.lambda$runRetryActionIfAlive$6(r1);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public /* bridge */ /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    private void disposeClearVideoCacheTask() {
        Disposable r0 = this.clearVideoCacheDisposable;
        if (r0 != null) goto L5;
    L7:
        this.clearVideoCacheDisposable = null;
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        tt5.a.h(TAG, "disposeClearVideoCacheTask");
        this.clearVideoCacheDisposable.dispose();
        goto L7
    }

    private String getVideoUrl() {
        String r0 = getVideoPreviewUrl(this.mFileModel);
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L8:
        String r1 = ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).r();
        boolean r3 = true;
        boolean r2 = !TextUtils.isEmpty(r1);
        if (r2 == true) goto L12;
        r1 = s45.p.u;
    L12:
        Uri.Builder r4 = new Uri.Builder().scheme("https").authority(r1);
        PreviewViewModel r5 = this.mPreviewViewModel;
        if (r5 == null) goto L23;
        Integer r6 = Integer.valueOf(r5.getBizType());
        int r7 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        if (r6 != null) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == false) goto L23;
    L25:
        if (r3 == true) goto L27;
        r4.appendEncodedPath("space/api/box/stream/download/preview/").appendEncodedPath(this.mFileModel.o).appendQueryParameter("version", this.mFileModel.n).appendQueryParameter("preview_type", String.valueOf(16));
    L30:
        String r9 = r4.build().toString();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.drive.mobile.video_little_rate") == false) goto L33;
        z r10 = this.mFileModel;
        r9 = UrlSplicer.sliceExtraTranCodeCodeUrl(r9, r10.s, r10.t);
    L33:
        tt5.a.h(TAG, "getVideoUrl() ResolutionUrl is empty!!! useDriveDomain= " + r2 + ", apiDomain= " + r1 + ", previewUrl= " + du5.b.f(r9));
        return r9;
    L27:
        r4.appendEncodedPath("space/api/box/stream/sdk/download/preview").appendQueryParameter("app_id", this.mFileModel.p).appendQueryParameter("app_file_id", this.mFileModel.o).appendQueryParameter("preview_type", String.valueOf(16));
        if (TextUtils.isEmpty(this.mFileModel.r) == true) goto L30;
        r4.appendQueryParameter("auth_extra", this.mFileModel.r);
        goto L30
    L18:
        if (r6.intValue() != 3) goto L20;
        r8 = true;
    L23:
        r3 = false;
        goto L25
    L5:
        if (hitSourcePreview() == true) goto L8;
        tt5.a.h(TAG, "getVideoUrl() ResolutionUrl is not empty!!! previewUrl=" + du5.b.f(r0));
        return r0;
    }

    private boolean hitSourcePreview() {
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.drive.mobile.play_origin_video") == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mFileModel.q != 3) goto L7;
        return true;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void initVideoView() {
        FrameLayout r1 = new FrameLayout(this.mContext);
        this.container = r1;
        r1.addOnAttachStateChangeListener(this.containerAttachStateChangeListener);
        final TTVideoView r2 = new TTVideoView(this.mContext);
        this.mVideoView = r2;
        ViewOwner r3 = this.mParentViewOwner;
        ViewOwner r4 = this.mViewOwner;
        r2.x = r4;
        r2.A = (DriveComponentRenderVM) r3.viewModel(DriveComponentRenderVM.class);
        r2.w = (PreviewViewModel) r4.viewModel(PreviewViewModel.class);
        r2.B = (DriveMediaVM) r4.viewModel(DriveMediaVM.class);
        r2.D = (DriveCaptureVM) r4.viewModel(DriveCaptureVM.class);
        r2.C = (DriveBlockPreviewVM) r4.viewModel(DriveBlockPreviewVM.class);
        com.bytedance.ee.drive.render.k.h r7 = null;
        com.bytedance.ee.drive.render.k r8 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(r2.getContext()).b();     // Catch: Throwable -> L15
        if (r8 != null) goto L6;
        com.bytedance.ee.drive.render.k.h r9 = null;
    L7:
        if (r9 != null) goto L9;
    L12:
        boolean r10 = true;
    L13:
        tt5.a.h(TAG, "resolveVideoLandscapeEnabled, enabled=" + r10 + ", isPad=" + ku5.c.k(r2.getContext()));     // Catch: Throwable -> L15
    L17:
        r2.J = r10;
        com.bytedance.ee.drive.render.k r11 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(r2.getContext()).b();     // Catch: Throwable -> L42
        if (r11 == null) goto L22;
        r7 = r11.getVideo();     // Catch: Throwable -> L42
    L22:
        PreviewViewModel r12 = r2.w;     // Catch: Throwable -> L42
        if (r12 == null) goto L33;
        Integer r13 = Integer.valueOf(r12.getBizType());     // Catch: Throwable -> L42
        int r14 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;     // Catch: Throwable -> L42
        if (r13 != null) goto L28;
    L30:
        boolean r16 = false;
    L31:
        if (r16 == false) goto L33;
        boolean r17 = true;
    L34:
        if (r7 != null) goto L36;
    L39:
        boolean r18 = false;
    L40:
        tt5.a.h(TAG, "resolveVideoControlBarV2Enabled, v2Enabled=" + r18 + ", isSpaceFile=" + r17 + ", isPad=" + ku5.c.k(r2.getContext()));     // Catch: Throwable -> L42
    L44:
        r2.K = r18;
        r2.A.bindReleaseListener(r2);
        r2.C.addBlockClickInterceptor(r2);
        ((DriveMediaVM) r4.viewModel(DriveMediaVM.class)).getPauseMedia().observe(r4.lifecycleOwner(), new ea5.x(r2));
        if ((r2.getContext() instanceof Activity) == false) goto L47;
        r2.L = new h65.a((Activity) r2.getContext(), r4, r2);
    L47:
        VideoView r5 = this.mVideoView;
        r5.o = this.mIsVCFollow;
        r5.p = this;
        r5.setCommunication(this.mPreviewViewModel);
        this.mVideoView.setVideoCacheRecoveryHandler(new j0(this));
        final VideoPlayerControllerView r6 = new VideoPlayerControllerView(this.mContext);
        r6.setViewModel(this.mViewOwner);
        ((DriveAiInteractionVM) this.mParentViewOwner.viewModel(DriveAiInteractionVM.class)).getActive().observe(r6.q, new ea5.s(r6));
        VideoPlayerContentView r19 = new VideoPlayerContentView(this.mContext);
        VideoSurfaceView r20 = r19.getSurfaceView();
        r20.getClass();
        TextureView r21 = new TextureView(r20.getContext());
        r20.c = r21;
        r20.a.addView(r21, new FrameLayout.LayoutParams(-1, -1));
        final VideoView r22 = this.mVideoView;
        r22.getClass();
        tt5.a.h(TAG, "addContentView... ");
        r22.b.removeView(r19);
        r22.d = r19;
        if (r22.I == false) goto L50;
        r19.setRootViewClickable(false);
    L51:
        r22.c = r19.getSurfaceView();
        r22.b.addView(r19, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        r22.D.getInCapture().observe(r22.x.lifecycleOwner(), new ea5.i0(r22));
        final VideoView r23 = this.mVideoView;
        r23.getClass();
        tt5.a.h(TAG, "addControllerView... ");
        r23.b.removeView(r23.e);
        r23.e = r6;
        r6.setVideoLandscapeEnabled(r23.J);
        r23.e.setVideoControlBarV2Enabled(r23.K);
        VideoPlayerControllerView r24 = r23.e;
        com.bytedance.ee.drive.render.k.h r26 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(r23.getContext()).b().getVideo();     // Catch: Throwable -> L61
        if (r26 != null) goto L55;
    L58:
        boolean r27 = true;
    L59:
        tt5.a.h(TAG, "resolveControllerAutoHideInDriveFilePreviewEnabled, enabled=" + r27);     // Catch: Throwable -> L61
    L63:
        r24.setControllerAutoHideInDriveFilePreviewEnabled(r27);
        if (r23.I == false) goto L69;
        r23.e.setRootViewClickable(false);
        r23.e.setVisibility(0);
        r23.e.setPlayState(false);
        if (((DriveBlockPreviewVM.BlockState) r23.C.getLiveBlockState().getValue()) != DriveBlockPreviewVM.BlockState.BLOCK) goto L68;
        r23.e.l(true);
    L70:
        r23.e.d.setProgress(0);
        r23.b.addView(r23.e, new FrameLayout.LayoutParams(-1, -1));
        r23.e.setUpdateProgressBarListener(new com.bytedance.ee.bear.drive.view.preview.video.a(r23));
        ((DriveConfigurationVM) r23.x.viewModel(DriveConfigurationVM.class)).isPortrait().observe(r23.x.lifecycleOwner(), new ea5.h0(r23));
        this.container.addView(this.mVideoView);
        this.aiSummaryDependency.a(this.mFileModel);
        this.deviceController = new ga5.d(this.mContext, this.mVideoView, this.mViewOwner, this.mFileModel);
        z r28 = this.mFileModel;
        String r29 = com.bytedance.ee.bear.drive.preload.n.c(r28.o, r28.n);
        String r30 = getVideoUrl();
        z r31 = this.mFileModel;
        if (r31.m == true) goto L73;
    L75:
        z r32 = this.mFileModel;
        if (r32.l == false) goto L79;
        VFSFile r33 = z75.b.e(r32.d, this.mUserComponentAbility.b);
        tt5.a.h(TAG, "preview local video file type is " + this.mFileModel.c);
        VideoView r0 = this.mVideoView;
        String r34 = Uri.fromFile(r33).toString();
        z r36 = this.mFileModel;
        r0.i(new VideoView.d(r34, r29, r36.f, r36));
        this.mOpenType = "fullCache";
    L91:
        this.mVideoView.setOnClickListener(new b(this, (DriveBlockPreviewVM) this.mViewOwner.viewModel(DriveBlockPreviewVM.class)));
        ((DriveViewFullScreenVM) this.mViewOwner.viewModel(DriveViewFullScreenVM.class)).liveOuterFullScreenSate.observe(this.mViewOwner.lifecycleOwner(), new k0(this));
        this.mVideoView.setReportCb(new l0(this));
        return;
    L79:
        if (hitSourcePreview() == false) goto L88;
        tt5.a.h(TAG, "preview video use source net, url= " + du5.b.f(r30));
        VideoView r37 = this.mVideoView;
        z r38 = this.mFileModel;
        r37.i(new VideoView.d(r30, r29, r38.f, r38));
        VideoView r39 = this.mVideoView;
        com.bytedance.ee.bear.drive.view.preview.video.player.w r40 = r39.q;
        if (r40 == null) goto L83;
        r40.g = "";
    L83:
        VideoView.d r41 = r39.v;
        if (r41 == null) goto L86;
        r41.b = "";
    L86:
        this.mOpenType = "sourceUrl";
        goto L91
    L88:
        if (hu5.a.e(this.mFileModel.f) == true) goto L90;
        tt5.a.h(TAG, "preview video from net");
        this.cacheViewModel.getPreLoadVideoTask().postValue(r30);
        VideoView r42 = this.mVideoView;
        z r43 = this.mFileModel;
        r42.i(new VideoView.d(r30, r29, r43.f, r43));
        this.mOpenType = "previewUrl";
        goto L91
    L90:
        tt5.a.d(TAG, "initVideoView no logic");
        VideoView r44 = this.mVideoView;
        z r46 = this.mFileModel;
        r44.i(new VideoView.d(r30, r29, r46.f, r46));
        this.mOpenType = "originUrl";
        goto L91
    L73:
        if (hu5.a.e(r31.f) == true) goto L75;
        tt5.a.h(TAG, "preview video from preload cache");
        VideoView r47 = this.mVideoView;
        z r48 = this.mFileModel;
        r47.i(new VideoView.d(r30, r29, r48.f, r48));
        this.mOpenType = "partCache";
        goto L91
    L68:
        r23.e.m(r23.o());
        goto L70
    L69:
        r23.e.setVisibility(8);
        goto L70
    L55:
        if (r26.b == true) goto L58;
        r27 = false;
    L61:
        th = move-exception;
        tt5.a.e(TAG, "resolveControllerAutoHideInDriveFilePreviewEnabled failed, use default", th, false);
        r27 = true;
        goto L63
    L50:
        r19.setEmptyViewVisibility(0);
        goto L51
    L36:
        if (r7.c == false) goto L39;
        if (r17 == false) goto L39;
        r18 = true;
        goto L40
    L28:
        if (r13.intValue() != 2) goto L30;
        r16 = true;
    L33:
        r17 = false;
    L42:
        th = move-exception;
        tt5.a.e(TAG, "resolveVideoControlBarV2Enabled failed, use legacy", th, false);
        r18 = false;
        goto L44
    L9:
        if (r9.a == true) goto L12;
        r10 = false;
        goto L13
    L6:
        r9 = r8.getVideo();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        tt5.a.e(TAG, "resolveVideoLandscapeEnabled failed, use default", th, false);
        r10 = true;
        goto L17
    }

    private Boolean lambda$clearVideoCacheAndRetry$3() throws Exception {
        a95.a r0 = this.mUserComponentAbility;
        Application r1 = eu5.b.a;
        com.bytedance.ee.bear.drive.preload.r.b(r0);
        z r2 = this.mFileModel;
        String r3 = r2.o;
        TTVideoEngine.removeCacheFile(com.bytedance.ee.bear.drive.preload.n.c(r3, r2.n));
        String r4 = com.bytedance.ee.bear.drive.preload.n.b(r3);
        if (TextUtils.isEmpty(r4) == true) goto L9;
        DriveFilePath r5 = com.bytedance.ee.bear.drive.cache.t.g();
        r5.cacheName(r4);
        VFSFile r6 = z75.b.e(r5, r0.b);
        if (r6.exists() == false) goto L11;
        if (r6.delete() == false) goto L11;
        tt5.a.d("VideoCacheInfoManager", "delete cache file success");
    L11:
        return Boolean.TRUE;
    L9:
        tt5.a.d("VideoCacheInfoManager", "delete cache fileName is null");
        goto L11
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public void clean() {
        this.container.removeOnAttachStateChangeListener(this.containerAttachStateChangeListener);
        disposeClearVideoCacheTask();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public boolean onBackPressed() {
        ga5.d r0 = this.deviceController;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.d.onBackPress() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.g
    public void onViewReady() {
        tt5.a.h(TAG, "onViewReady: init=" + this.mVCFollowInit + ", isVCFollow=" + this.mIsVCFollow);
        if (this.mVCFollowInit == true) goto L8;
        this.mVCFollowInit = true;
        if (this.mIsVCFollow == false) goto L9;
        ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveFollowDocumentInfo().setValue(new l65.d(o65.b.class, this.mVideoView));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void show() {
        trackOpenStart();
        VideoView r0 = this.mVideoView;
        VideoView.d r1 = r0.v;
        if (r1 != null) goto L5;
        tt5.a.h(TAG, "mVideoEntity == null, can not play");
        return;
    L5:
        String r2 = r1.d.c;
        boolean r4 = true;
        if (com.bytedance.ee.bear.drive.view.preview.video.player.e.k == true) goto L24;
        if (yn4.a.b == true) goto L11;
        tt5.a.k("AbsDynamicSoServiceImpl", "isLibrarySoReady() sHasInjectAgent IS false");
        boolean r6 = true;
    L22:
        com.bytedance.ee.bear.drive.view.preview.video.player.e.k = r6;
        goto L24
    L11:
        if (yn4.a.a != null) goto L37;
        tt5.a.k("AbsDynamicSoServiceImpl", "isLibrarySoReady() sDynamicSoAgent IS NULL");
    L21:
        r6 = false;
        goto L22
    L37:
    L19:
        th = move-exception;
        tt5.a.f("AbsDynamicSoServiceImpl", th, false);
        goto L21
    L14:
        if (yn4.a.a.a(eu5.b.a) == true) goto L16;
        r6 = true;
    L17:
        tt5.a.h("AbsDynamicSoServiceImpl", "isLibrarySoReady() isReady = " + r6);     // Catch: Throwable -> L19
        goto L22
    L16:
        r6 = false;
    L24:
        if (com.bytedance.ee.bear.drive.view.preview.video.player.e.k == false) goto L26;
    L30:
        r4 = false;
    L31:
        if (r4 == false) goto L33;
        r0.w.liveInnerUnsupprtPreview().postValue(r0.v.d.c);
        tt5.a.k(TAG, "show() TTPlayer.isSoReady false.");
        return;
    L33:
        r0.u(r0.v.a);
        r0.k(r0.v);
        r0.s();
        if (r0.l() == false) goto L41;
        r0.play();
        return;
    L41:
        return;
    L26:
        if ("ts".equalsIgnoreCase(r2) == true) goto L31;
        if ("flv".equalsIgnoreCase(r2) == false) goto L30;
        goto L30
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this.container;
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.g
    public boolean isVcFollow() {
        return this.mIsVCFollow;
    }

    public static /* synthetic */ void access$000(VideoPreviewView r0) {
        r0.disposeClearVideoCacheTask();
    }

    public static /* synthetic */ VideoSummaryViewModel access$100(VideoPreviewView r0) {
        return r0.videoSummaryViewModel;
    }

    public static /* synthetic */ VideoView access$200(VideoPreviewView r0) {
        return r0.mVideoView;
    }

    public static /* synthetic */ ga5.d access$300(VideoPreviewView r0) {
        return r0.deviceController;
    }

    private void clearVideoCacheAndRetry(final Runnable r4) {
        disposeClearVideoCacheTask();
        this.clearVideoCacheDisposable = Flowable.fromCallable(new m0(this)).subscribeOn(fo5.d.b()).subscribe(new n0(this, r4), new o0(this, r4));
    }

    private static String getVideoPreviewUrl(z r0) {
        return ea5.b.a(r0.f);
    }

    private void lambda$initVideoView$1(com.bytedance.ee.bear.drive.biz.preview.screen.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.a == true) goto L6;
        return;
    L6:
        if (TextUtils.equals(this.mFileModel.o, r3.c) == false) goto L8;
        return;
    L8:
        if (this.mViewOwner.lifecycleOwner().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L14;
        tt5.a.h("DriveSdk", "VideoPreviewView#liveOuterFullScreenSate() event=" + r3);
        this.mPreviewViewModel.liveInnerForceFullScreen().postValue(Boolean.FALSE);
        return;
    }

    private void lambda$new$0(Boolean r3) {
        if (this.deviceController == null) goto L9;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.booleanValue() == true) goto L11;
        ga5.d r4 = this.deviceController;
        ((PreviewViewModel) r4.c.viewModel(PreviewViewModel.class)).liveInnerForceFullScreen().setValue(Boolean.TRUE);
        r4.b.f();
        return;
    L11:
        return;
    }

    private /* synthetic */ void lambda$runRetryActionIfAlive$6(Runnable r3) {
        if (this.mViewOwner.lifecycleOwner().getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
    L9:
        tt5.a.h(TAG, "skip video cache retry, lifecycle=" + this.mViewOwner.lifecycleOwner().getLifecycle().getCurrentState() + ", containerAttached=" + this.container.isAttachedToWindow());
        return;
    L5:
        if (this.container.isAttachedToWindow() == false) goto L9;
        r3.run();
    }

    private void runRetryActionIfAlive(final Runnable r3) {
        FrameLayout r0 = this.container;
        if (r0 != null) goto L6;
        tt5.a.h(TAG, "skip video cache retry, container is null");
        return;
    L6:
        r0.post(new p0(this, r3));
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView
    public void onPermissionChanged(boolean r4) {
        VideoView r0 = this.mVideoView;
        r0.getClass();
        tt5.a.k(TAG, "handleMessage: MSG_PREVIEW_PAUSE");
        if (r4 == true) goto L6;
        r0.post(new ea5.k0(r0));
        return;
    }

    private /* synthetic */ void lambda$clearVideoCacheAndRetry$4(Runnable r2, Boolean r3) throws Exception {
        tt5.a.h(TAG, "clearVideoCacheAndRetry success");
        runRetryActionIfAlive(r2);
    }

    private void lambda$clearVideoCacheAndRetry$5(Runnable r4, Throwable r5) throws Exception {
        tt5.a.e(TAG, "clearVideoCacheAndRetry error", r5, false);
        runRetryActionIfAlive(r4);
    }

    private void lambda$initVideoView$2(boolean r5, Throwable r6) {
        if (this.hasReport == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.hasReport = true;
        String r1 = "tt_video_" + this.mOpenType;
        if (r5 == false) goto L8;
        trackOpenSuccess(r1);
        return;
    L8:
        boolean r7 = false;
        if (r6 != null) goto L11;
    L21:
        if (r7 == true) goto L27;
        trackOpenFailed(r1, r6);
        return;
    L27:
        return;
    L11:
        if (TextUtils.isEmpty(r6.getMessage()) == true) goto L21;
    L19:
        e = move-exception;
        tt5.a.e(TAG, "setReportCb isUnUsableNetState=", e, false);
        goto L21
    L13:
        if (this.NET_UNUSABLE_CODE_PATTEN.matcher(r6.getMessage()).find() == true) goto L18;
        if (i75.g.a() == true) goto L18;
        r0 = false;
    L18:
        r7 = r0;
        goto L21
    }

    public VideoPreviewView(ViewOwner r1, ViewOwner r2, Context r3, z r4, a95.a r5) {
        super(r1, r2, r3, r4, r5);
        this.NET_UNUSABLE_CODE_PATTEN = PatternProtector.compile("-499975|-499895|-499798|-499797|-499796|-499795|-499794|-499793|-499792|-59987|-59989|-59990");
        this.mOpenType = "";
        this.mVCFollowInit = false;
        this.deviceController = null;
        this.containerAttachStateChangeListener = new a(this);
        Boolean r6 = (Boolean) ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveIsVCFollowMode().getValue();
        this.mIsVCFollow = Boolean.TRUE.equals(r6);
        this.cacheViewModel = (VideoCacheViewModel) r2.viewModel(VideoCacheViewModel.class);
        fa5.a r7 = (fa5.a) LarkContext.spiByDwarf(fa5.a.class);
        this.aiSummaryDependency = r7;
        initVideoView();
        r7.a(this.mFileModel);
    }
}
