package com.bytedance.ee.bear.drive.view.preview.wrapper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.DriveVCFollowVM;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.pdf.ExhibitionMode;
import com.bytedance.ee.bear.drive.view.preview.pdf.SimplePdfView;
import com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.PdfPresentationView;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFContentView;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFCtrlView;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFCtrlViewModel;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.PDFThumbnailSlider;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.TTStreamingPdfView$initLoadObserver$1;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a1;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.b1;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure.ScrollState;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.v0;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.w0;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.x0;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.y0;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.z0;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.bytedance.ee.plugin.common.PluginManager;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReader;
import com.bytedance.ee.plugin.common.ttpdfreader.TTPdfReaderFactory;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PdfPreviewView extends AbsPreviewView implements com.bytedance.ee.bear.drive.biz.preview.vc.connector.g {
    private static final String TAG = "DRIVE_PREVIEW_FLOWPdfPreviewView";
    private q75.a mDriveConfig;
    private v95.a mPdfEntity;
    private m mPdfView;
    private boolean mVCFollowInit;

    public class a implements com.bytedance.ee.bear.drive.view.preview.ttreader.a.c {
        public final /* synthetic */ PdfPreviewView a;

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

        public a(PdfPreviewView r1) {
            this.a = r1;
        }
    }

    public class b implements c95.c {
        public final /* synthetic */ PdfPreviewView a;

        @Override // c95.c
        public final void onShowStart() {
            this.a.trackOpenStart();
        }

        public b(PdfPreviewView r1) {
            this.a = r1;
        }

        @Override // c95.c
        public final void b(String r2) {
            this.a.trackOpenSuccess(r2);
            PdfPreviewView.access$000(this.a);
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
        public final /* synthetic */ PdfPreviewView a;

        @Override // c95.c
        public final void onShowStart() {
            this.a.trackOpenStart();
        }

        public d(PdfPreviewView r1) {
            this.a = r1;
        }

        @Override // c95.c
        public final void b(String r2) {
            this.a.trackOpenSuccess(r2);
            PdfPreviewView.access$000(this.a);
        }

        @Override // c95.c
        public final void a(String r2, Throwable r3) {
            this.a.trackOpenFailed(r2, r3);
        }
    }

    public static /* synthetic */ void a(PdfPreviewView r0, SimplePdfView r1, View r2) {
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
        r0.setOnPageClickListener(new p(this, r0));
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

    private m initTTStreamingPdf() {
        v0 r11 = new v0();
        boolean r12 = isVcFollow();
        Context r13 = this.mContext;
        ViewOwner r14 = this.mParentViewOwner;
        ViewOwner r16 = this.mViewOwner;
        z r4 = this.mFileModel;
        com.bytedance.ee.bear.drive.view.preview.ttreader.a r8 = newClickHelper();
        c95.c r9 = newTrackEventCallback();
        a95.a r1 = this.mUserComponentAbility;
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "parentViewOwner");
        Intrinsics.checkNotNullParameter(r16, "viewOwner");
        Intrinsics.checkNotNullParameter(r4, "previewFileModel");
        Intrinsics.checkNotNullParameter(r8, "clickHelper");
        Intrinsics.checkNotNullParameter(r9, "trackEventCallback");
        Intrinsics.checkNotNullParameter(this, "vcReadyCallback");
        Intrinsics.checkNotNullParameter(r1, "userComponentAbility");
        r11.b = r16;
        r11.c = this;
        r11.d = r1;
        TTPdfReader r3 = PluginManager.getPluginApi(TTPdfReaderFactory.class).create(r13);
        Fragment r2 = r16.lifecycleOwner();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        final PDFCtrlViewModel r5 = (PDFCtrlViewModel) new ViewModelProvider(r2).get(PDFCtrlViewModel.class);
        TitleBarViewModel r17 = (TitleBarViewModel) r16.viewModel(TitleBarViewModel.class);
        if (r5.isInit() == false) goto L5;
        r5.release();
    L5:
        LifecycleOwner r6 = r16.lifecycleOwner();
        Intrinsics.checkNotNull(r3);
        r5.init(r6, r3, r4, (PreviewViewModel) r16.viewModel(PreviewViewModel.class), r17, r11, r8, r9, r12);
        PDFCtrlView r7 = new PDFCtrlView(r13, null);
        r11.a = r7;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.g r10 = r11.c;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVCReadyCallback");
        r10 = null;
    L8:
        a95.a r18 = r11.d;
        if (r18 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mUserComponentAbility");
        r18 = null;
    L11:
        Intrinsics.checkNotNullParameter(r14, "parentViewOwner");
        Intrinsics.checkNotNullParameter(r16, "viewOwner");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        Intrinsics.checkNotNullParameter(r10, "vcReadyCallback");
        Intrinsics.checkNotNullParameter(r18, "userComponentAbility");
        r7.i = r14;
        r7.j = r16;
        r7.k = r5;
        r7.B = r18;
        if (w55.n.d == true) goto L14;
        tt5.a.h("PDFCtrlView", "initCommentRectLayout, isPdfCommentFgEnabled: false");
    L15:
        if (r12 == true) goto L22;
        Context r19 = r7.getContext();
        if ((r19 instanceof Activity) == false) goto L19;
        Activity r20 = (Activity) r19;
    L20:
        if (r20 == null) goto L22;
        r7.E = xu5.b.b(r20, null);
        goto L22
    L19:
        r20 = null;
    L22:
        r7.m = (DriveBlockPreviewVM) r16.viewModel(DriveBlockPreviewVM.class);
        r7.l = (DriveComponentRenderVM) r14.viewModel(DriveComponentRenderVM.class);
        r7.z = (DriveConfigurationVM) r16.viewModel(DriveConfigurationVM.class);
        TitleBarViewModel r21 = (TitleBarViewModel) r16.viewModel(TitleBarViewModel.class);
        DriveConfigurationVM r110 = r7.z;
        if (r110 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mDriveConfigurationVM");
        r110 = null;
    L25:
        r110.isLandscape().observe(r16.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.y(r21));
        DriveConfigurationVM r22 = r7.z;
        if (r22 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mDriveConfigurationVM");
        r22 = null;
    L28:
        r22.isPortrait().observe(r16.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.z(r5, r21));
        DriveConfigurationVM r23 = r7.z;
        if (r23 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mDriveConfigurationVM");
        r23 = null;
    L31:
        r23.getLiveUiState().observe(r16.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.a0(r7));
        DriveConfigurationVM r24 = r7.z;
        if (r24 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mDriveConfigurationVM");
        r24 = null;
    L34:
        r24.getLastPreviewConfig().observe(r16.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.b0(r7));
        r7.n = r10;
        r7.q = w95.b.a(r7.getContext());
        boolean r26 = a95.c.a(r18, "ccm.drive.mobile_ppt_prefer_transcode_preview");
        DriveComponentRenderVM r27 = r7.l;
        if (r27 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("componentRenderVM");
        r27 = null;
    L37:
        r27.bindReleaseListener(r7);
        if (r12 == true) goto L41;
        if (r26 == true) goto L41;
    L43:
        Context r28 = r7.getContext();
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type android.app.Activity");
        r7.o(((Activity) r28).getRequestedOrientation());
        PDFContentView r29 = r7.getPdfContentViewFromXml();
        PDFCtrlViewModel r30 = r7.k;
        if (r30 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r30 = null;
    L46:
        View r31 = r30.getRenderView();
        r29.getClass();
        Intrinsics.checkNotNullParameter(r31, "renderView");
        tt5.a.h("PDFContentView", "showRenderView. ");
        boolean r32 = false;
        ((ViewGroup) r29.findViewById(2131392488)).addView(r31, 0, new ViewGroup.LayoutParams(-1, -1));
        r7.m();
        r7.n();
        DriveBlockPreviewVM r33 = r7.m;
        if (r33 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r33 = null;
    L49:
        MutableLiveData<DriveBlockPreviewVM.BlockState> r34 = r33.getLiveBlockState();
        ViewOwner r36 = r7.j;
        if (r36 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r36 = null;
    L52:
        r34.observe(r36.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.p(r7));
        PDFCtrlViewModel r37 = r7.k;
        if (r37 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r37 = null;
    L55:
        MutableLiveData<Boolean> r38 = r37.getBookLoaded();
        ViewOwner r39 = r7.j;
        if (r39 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r39 = null;
    L58:
        r38.observe(r39.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.q(r7));
        PDFCtrlViewModel r40 = r7.k;
        if (r40 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r40 = null;
    L61:
        MutableLiveData<Boolean> r41 = r40.getShowThumbnail();
        ViewOwner r42 = r7.j;
        if (r42 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r42 = null;
    L64:
        r41.observe(r42.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.r(r7));
        PDFCtrlViewModel r43 = r7.k;
        if (r43 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r43 = null;
    L67:
        MutableLiveData<Integer> r44 = r43.getIndicator();
        ViewOwner r46 = r7.j;
        if (r46 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r46 = null;
    L70:
        r44.observe(r46.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.s(r7));
        PDFCtrlViewModel r47 = r7.k;
        if (r47 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r47 = null;
    L73:
        MutableLiveData<Integer> r48 = r47.getRequestPwd();
        ViewOwner r49 = r7.j;
        if (r49 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r49 = null;
    L76:
        r48.observe(r49.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.t(r7));
        DriveBlockPreviewVM r50 = r7.m;
        if (r50 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("blockVM");
        r50 = null;
    L79:
        MutableLiveData<DriveBlockPreviewVM.BlockState> r51 = r50.getLiveBlockState();
        ViewOwner r52 = r7.j;
        if (r52 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r52 = null;
    L82:
        r51.observe(r52.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.u(r7));
        ViewOwner r53 = r7.j;
        if (r53 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r53 = null;
    L85:
        MutableLiveData<Boolean> r54 = ((DriveVCFollowVM) r53.viewModel(DriveVCFollowVM.class)).getLiveIsReplay();
        ViewOwner r56 = r7.j;
        if (r56 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r56 = null;
    L88:
        r54.observe(r56.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.v(r7));
        ViewOwner r57 = r7.j;
        if (r57 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r57 = null;
    L91:
        MutableLiveData<Boolean> r58 = ((PreviewViewModel) r57.viewModel(PreviewViewModel.class)).liveInnerEditModeSwitchActive();
        ViewOwner r59 = r7.j;
        if (r59 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r59 = null;
    L94:
        r58.observe(r59.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.w(r7));
        r7.getPdfContentViewFromXml().setViewDelegate(new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.d(r7));
        r7.getPdfThumbnailToggleViewFromXml().setOnClickListener(new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.e(r7));
        r7.getPdfToWpsEditFromXml().setOnClickListener(new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.f(r7));
        PDFThumbnailSlider r60 = r7.getPdfThumbnailSliderFromXml();
        ViewOwner r61 = r7.i;
        if (r61 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewOwner");
        r61 = null;
    L97:
        r60.getClass();
        DriveComponentRenderVM r0 = (DriveComponentRenderVM) r61.viewModel(DriveComponentRenderVM.class);
        r60.l = r0;
        r0.bindReleaseListener(r60);
        r7.getPdfThumbnailSliderFromXml().setViewDelegate(new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.g(r7));
        r7.getPdfThumbnailSliderFromXml().setAutoHide(w55.n.d);
        r7.getPdfThumbnailViewFromXml().setViewDelegate(new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.h(r7));
        PDFCtrlViewModel r62 = r7.k;
        if (r62 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r62 = null;
    L100:
        MutableLiveData<Float> r63 = r62.getPositionOffset();
        ViewOwner r64 = r7.j;
        if (r64 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r64 = null;
    L103:
        r63.observe(r64.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.i(r7));
        if (w55.n.d == false) goto L112;
        PDFCtrlViewModel r66 = r7.k;
        if (r66 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r66 = null;
    L108:
        MutableLiveData<ScrollState> r67 = r66.getScrollState();
        ViewOwner r68 = r7.j;
        if (r68 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r68 = null;
    L111:
        r67.observe(r68.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.j(r7));
    L112:
        PDFCtrlViewModel r69 = r7.k;
        if (r69 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r69 = null;
    L115:
        MutableLiveData<Boolean> r70 = r69.getBookLoaded();
        ViewOwner r71 = r7.j;
        if (r71 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("viewOwner");
        r71 = null;
    L118:
        r70.observe(r71.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.k(r7));
        CompositeDisposable r72 = r7.s;
        PdfPresentationView r73 = r7.getPresentationViewFromXml();
        r73.getClass();
        r72.add(new com.bytedance.ee.bear.drive.view.preview.pdf.presentationview.a(r73).filter(new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.l(r7)).observeOn(Schedulers.single()).map(new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.m(r7)).observeOn(fo5.d.d()).subscribe(new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.n(r7), com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.o.a));
        tt5.a.h("PDFCtrlView", "init finish. ");
        com.bytedance.ee.bear.drive.view.widget.a r74 = new com.bytedance.ee.bear.drive.view.widget.a(r13, true);
        r74.setPadding(UIHelper.dp2px(18.0f), r74.getPaddingTop(), r74.getPaddingRight(), UIHelper.dp2px(18.0f));
        com.bytedance.ee.bear.drive.view.widget.a r76 = new com.bytedance.ee.bear.drive.view.widget.a(r13, false);
        r76.setPadding(r76.getPaddingLeft(), r76.getPaddingTop(), UIHelper.dp2px(18.0f), UIHelper.dp2px(18.0f));
        BubbleMenuVM r77 = (BubbleMenuVM) r16.viewModel(BubbleMenuVM.class);
        DrivePreviewAiResourceContextVM r78 = (DrivePreviewAiResourceContextVM) r16.viewModel(DrivePreviewAiResourceContextVM.class);
        Ref.BooleanRef r79 = new Ref.BooleanRef();
        Ref.BooleanRef r80 = new Ref.BooleanRef();
        Ref.ObjectRef r81 = new Ref.ObjectRef();
        r77.getEnabledLiveData().observe(r16.lifecycleOwner(), new y0(r79, r80, r81, r3, r78, r77, r74, r76));
        r78.getConsumerEnabledLiveData().observe(r16.lifecycleOwner(), new z0(r80, r79, r81, r3, r78, r77, r74, r76));
        r78.getGenerationLiveData().observe(r16.lifecycleOwner(), new a1(r79, r80, r81, r3, r78, r77, r74, r76));
        r77.getSelectionDataLiveData().observe(r16.lifecycleOwner(), new b1(r3, r78));
        if (w55.n.d == false) goto L130;
        BubbleMenuVM r82 = (BubbleMenuVM) r16.viewModel(BubbleMenuVM.class);
        if (r82 != null) goto L123;
        tt5.a.d("TTStreamingPdfView", "initCommentBubbleMenu, BubbleMenuVM is null.");
    L128:
        final v0 r83 = r11;
    L129:
        r3.setMarkClient(new x0(r83, r16));
        r5.getBookLoaded().observe(r16.lifecycleOwner(), new TTStreamingPdfView$initLoadObserver$1(r5, r83));
    L132:
        if (r12 == true) goto L134;
    L143:
        return r83;
    L134:
        if (this.mContext.getResources().getConfiguration().orientation != 1) goto L136;
        r32 = true;
    L136:
        DriveVCFollowVM r84 = (DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class);
        PDFCtrlView r86 = r83.a;
        if (r86 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        PDFCtrlView r87 = null;
    L140:
        r87.setDefaultEnterPresentation(isEnterPresentation());
        if (r32 == false) goto L143;
        this.mPreviewViewModel.liveInnerForceFullScreen().postValue(Boolean.TRUE);
        goto L143
    L139:
        r87 = r86;
        goto L140
    L123:
        DriveMGPermissionVM r88 = (DriveMGPermissionVM) r16.viewModel(DriveMGPermissionVM.class);
        if (r88 == null) goto L128;
        LiveData<u55.b> r89 = r88.livePerm();
        if (r89 == null) goto L128;
        r83 = r11;
        r89.observe(r16.lifecycleOwner(), new w0(r83, r82, r13));
        goto L129
    L130:
        r83 = r11;
    L41:
        if (r5.isPPT() == false) goto L43;
        PreviewViewModel r90 = (PreviewViewModel) r16.viewModel(PreviewViewModel.class);
        r90.liveInnerShowPresentationAction().postValue(Boolean.TRUE);
        r90.liveOuterEnterPresentationMode().observe(r16.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.c0(r7));
        ((DriveVCFollowVM) r16.viewModel(DriveVCFollowVM.class)).getLiveIsPresenter().observe(r16.lifecycleOwner(), new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.d0(r7));
        goto L43
    L14:
        CommentRectLayout r91 = new CommentRectLayout(r7.getContext());
        r91.setElevation(99.0f);
        r91.setOutlineProvider(null);
        r91.w(null, null);
        r91.setCommentClickListener(new com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.e0(r7, r91));
        new com.bytedance.ee.bear.drive.biz.comment.c(r91);
        r7.C = r91;
        goto L15
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
        if (this.mVCFollowInit == true) goto L14;
        this.mVCFollowInit = true;
        if (r0 == false) goto L15;
        m r1 = this.mPdfView;
        if ((r1 instanceof v0) == false) goto L11;
        Object r2 = ((v0) r1).a;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("pdfCtrlView");
        r2 = null;
    L12:
        ((DriveVCFollowVM) this.mViewOwner.viewModel(DriveVCFollowVM.class)).getLiveFollowDocumentInfo().setValue(new l65.d(com.bytedance.ee.bear.drive.biz.preview.vc.pdf.b.class, r2));
        return;
    L11:
        r2 = (SimplePdfView) r1;
        goto L12
    L15:
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

    public static /* synthetic */ void access$000(PdfPreviewView r0) {
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

    public PdfPreviewView(ViewOwner r1, ViewOwner r2, Context r3, z r4, a95.a r5) {
        super(r1, r2, r3, r4, r5);
        this.mVCFollowInit = false;
        q75.a r6 = o75.b.a().getDriveConfig();
        this.mDriveConfig = r6;
        this.mPdfEntity = new v95.a();
        boolean r7 = w55.n.j(r6);
        boolean r8 = com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.drive.vc_ttpdf_enable", false);
        boolean r9 = this.mPreviewViewModel.isVCFollowMode();
        tt5.a.h(TAG, "useTTPdf=" + r7 + " enableVcTTpdf=" + r8 + " isVC=" + r9);
        if (r7 == false) goto L8;
        if (r9 == false) goto L7;
        if (r8 == true) goto L7;
        tt5.a.h(TAG, "pdfview initSimplePdf");
        this.mPdfView = initSimplePdf();
        return;
    L7:
        tt5.a.h(TAG, "pdfview initTTStreamingPdf");
        this.mPdfView = initTTStreamingPdf();
        return;
    L8:
        tt5.a.h(TAG, "pdfview init simplepdfview");
        this.mPdfView = initSimplePdf();
    }
}
