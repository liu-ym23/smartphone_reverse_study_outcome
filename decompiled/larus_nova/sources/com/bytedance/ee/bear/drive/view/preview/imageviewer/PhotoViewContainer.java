package com.bytedance.ee.bear.drive.view.preview.imageviewer;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.preview.configuration.DriveConfigurationVM;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveViewFullScreenVM;
import com.bytedance.ee.bear.drive.biz.preview.vc.connector.g;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.module.nativepreview.model.DriveComponentRenderVM;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.m;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.larus.nova.R;
import g85.f;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import r95.d;
import r95.h;
import r95.i;
import r95.j;
import r95.k;
import r95.n;
import r95.o;
import r95.p;
import r95.q;
import r95.r;
import r95.s;
import r95.t;
import r95.u;
import r95.v;

/* JADX INFO: loaded from: classes16.dex */
public class PhotoViewContainer extends FrameLayout implements m, n65.b, m85.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f225003w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f225004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f225005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f225006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommentRectLayout f225007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.ee.bear.drive.biz.comment.c f225008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PreviewViewModel f225009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DriveComponentRenderVM f225010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f225011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f225012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r95.c f225013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f225014k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f225015l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f225016m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeDisposable f225017n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c95.c f225018o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public n65.b.a f225019p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g f225020q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f225021r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DriveConfigurationVM f225022s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f225023t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.bytedance.ee.bear.bizwidget.magicshare.cursor.b f225024u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a95.a f225025v;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f225026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f225027b;

        public a(z r100, int r101) {
            this.f225026a = r100;
            this.f225027b = r101;
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public String getCommentQuote() {
        return null;
    }

    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    @Override // m85.a
    public String getReleaseKey() {
        return "PhotoViewContainer";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ void onNewConfiguration(Configuration r100) {
    }

    public final void e() {
        n65.b.a r100 = this.f225019p;
        if (r100 == null) goto L6;
        ((n65.a.C6901a) r100).a();
        return;
    }

    public final void f() {
        if (this.f225009f.liveOuterNotPreviewContentHeight().getValue() != null) goto L5;
        return;
    L5:
        FrameLayout.LayoutParams r100 = (FrameLayout.LayoutParams) getLayoutParams();
        r100.height = this.f225009f.liveOuterNotPreviewContentHeight().getValue().run().intValue();
        setLayoutParams(r100);
        d r101 = this.f225012i;
        if (r101 == null) goto L9;
        r101.a(1.0f, false);
        return;
    }

    @Override // n65.b
    public float getScale() {
        d r100 = this.f225012i;
        if (r100 != null) goto L7;
        return 1.0f;
    L7:
        if ((r100 instanceof h) == false) goto L11;
        return ((h) r100).getStandScale();
    L11:
        return r100.getScale();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final CommentRectF hideCreateComment() {
        tt5.a.h("preview_image", "photoview container hideCreateComment()");
        this.f225009f.liveInnerForceFullScreen().postValue(Boolean.FALSE);
        this.f225007d.i(false, false);
        return this.f225007d.j();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onAreaClick() {
        tt5.a.h("preview_image", "photoview container onAreaClick()");
        this.f225009f.liveInnerCommentSelected().postValue(null);
        CommentRectLayout r100 = getCommentRectLayout();
        if (r100.q() == false) goto L6;
        MutableLiveData<Boolean> r101 = this.f225009f.liveInnerForceFullScreen();
        Boolean r102 = Boolean.FALSE;
        r101.postValue(r102);
        r100.j();
        this.f225009f.liveInnerCreateNewComment().postValue(r102);
        return false;
    L6:
        getCommentRectLayout().u();
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelOpen() {
        tt5.a.h("preview_image", "photoview container onCommentInputPanelOpen()");
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelClose() {
        tt5.a.h("preview_image", "photoview container onCommentListPanelClose()");
        CommentRectLayout r100 = this.f225007d;
        r100.B = null;
        r100.f236784J.invalidate();
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) getLayoutParams();
        r101.height = -1;
        setLayoutParams(r101);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        com.bytedance.ee.bear.bizwidget.magicshare.cursor.b r100 = this.f225024u;
        if (r100 == null) goto L5;
        r100.hide();
    L5:
        PreviewViewModel r101 = this.f225009f;
        if (r101 != null) goto L8;
    L10:
        super.onDetachedFromWindow();
        if (this.f225010g.needBindReleaseListener() == true) goto L14;
        onRelease();
        return;
    L14:
        return;
    L8:
        if (r101.isBlockViewChanging() == false) goto L10;
    }

    @Override // m85.a
    public final void onRelease() {
        PreviewViewModel r100 = this.f225009f;
        if (r100 != null) goto L5;
    L7:
        this.f225017n.clear();
        return;
    L5:
        if (r100.isBlockViewChanging() == false) goto L7;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        a r100 = this.f225014k;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f225026a == null) goto L12;
        this.f225015l = System.currentTimeMillis();
        c95.c r101 = this.f225018o;
        if (r101 == null) goto L9;
        r101.onShowStart();
    L9:
        this.f225017n.add(Flowable.fromCallable(new v(this)).observeOn(fo5.d.d()).flatMap(new j()).flatMap(new k(this)).map(new s(this)).subscribe(new t(this), new u(this)));
        return;
    }

    public CommentRectLayout getCommentRectLayout() {
        return this.f225007d;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showThumbnailPreview() {
        f();
    }

    public PhotoViewContainer(Context r100) {
        super(r100);
        this.f225017n = new CompositeDisposable();
        this.f225021r = false;
        this.f225023t = false;
        this.f225024u = null;
        d(r100);
    }

    public final void b(boolean r100) {
        boolean r101 = false;
        com.bytedance.ee.drive.render.k.c r102 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(getContext()).b().d();     // Catch: Throwable -> L8
        if (r102 == null) goto L11;
        if (r102.f242744a == false) goto L11;
        r101 = true;
    L11:
        if (r100 == true) goto L15;
        if (r101 == true) goto L15;
        int r103 = R.color.lkui_transparent;
    L16:
        this.f225006c.setBackgroundColor(getResources().getColor(r103));
        View r104 = this.f225005b;
        if (r104 == null) goto L23;
        if (r101 == false) goto L24;
        r104.setBackgroundColor(getResources().getColor(R.color.static_black));
        return;
    L24:
        return;
    L23:
        return;
    L15:
        r103 = R.color.static_black;
    L8:
        th = move-exception;
        tt5.a.e("PhotoViewContainer", "resolve media immersive config failed, use default", th, false);
        goto L11
    }

    public final void d(Context r100) {
        this.f225004a = r100;
        LayoutInflater.from(r100).inflate(R.layout.drive_preview_photo_view, this);
        this.f225005b = findViewById(R.id.drive_preview_photo_view_root);
        this.f225006c = (FrameLayout) findViewById(R.id.container);
        CommentRectLayout r101 = (CommentRectLayout) findViewById(R.id.drive_comment_rect_layout);
        this.f225007d = r101;
        r101.w(null, null);
        this.f225008e = new com.bytedance.ee.bear.drive.biz.comment.c(this.f225007d);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Object r100 = this.f225012i;
        if (r100 == null) goto L5;
        com.bytedance.ee.bear.drive.biz.comment.c r101 = this.f225008e;
        r101.getClass();
        float r102 = r110.getX();
        float r103 = r110.getY();
        if (r110.getPointerCount() <= 1) goto L13;
        r101.f222725j.removeCallbacks(r101.f222726k);
        r101.f222725j.removeCallbacks(r101.f222727l);
        if (r101.f222723h.q() == true) goto L13;
        if ((r100 instanceof View) == false) goto L13;
        r101.f222719d = true;
        r101.f222723h.setEnableCorrectMatrix(true);
        r101.f222724i.d();
        boolean r104 = ((View) r100).dispatchTouchEvent(MotionEvent.obtain(r110));
    L46:
        if (r104 == false) goto L48;
    L49:
        return true;
    L48:
        if (super.dispatchTouchEvent(r110) == true) goto L49;
        return false;
    L13:
        int r105 = r110.getAction();
        if (r105 == 0) goto L35;
        if (r105 != 1) goto L17;
    L31:
        r101.f222720e = false;
        r101.f222725j.removeCallbacks(r101.f222726k);
        r101.f222723h.setEnableCorrectMatrix(false);
        if (r101.f222719d == false) goto L34;
        r101.f222724i.f();
    L34:
        r101.f222719d = false;
    L45:
        r104 = r101.f222718c;
        goto L46
    L17:
        if (r105 != 2) goto L19;
        float r106 = Math.abs(r101.f222716a - r102);
        float r107 = Math.abs(r101.f222717b - r103);
        if (r106 < 15.0f) goto L24;
    L25:
        r101.f222725j.removeCallbacks(r101.f222726k);
    L27:
        if (r106 < 8.0f) goto L29;
    L30:
        r101.f222725j.removeCallbacks(r101.f222727l);
        goto L45
    L29:
        if (r107 < 8.0f) goto L45;
    L24:
        if (r107 < 15.0f) goto L27;
    L19:
        if (r105 == 3) goto L31;
    L35:
        r101.f222718c = false;
        r101.f222720e = true;
        long r108 = System.currentTimeMillis();
        if ((r108 - r101.f222721f) >= 300) goto L38;
        r101.f222725j.removeCallbacks(r101.f222727l);
        boolean r109 = true;
    L39:
        r101.f222721f = r108;
        r101.f222716a = r102;
        r101.f222717b = r103;
        if (r101.f222723h.q() == true) goto L44;
        r101.f222725j.postDelayed(r101.f222726k, ViewConfiguration.getLongPressTimeout());
        CommentRectF r111 = r101.f222723h.o(r102, r103);
        com.bytedance.ee.bear.drive.biz.comment.c.b r112 = r101.f222727l;
        r112.f222729a = r111;
        if (r109 == true) goto L44;
        r101.f222725j.postDelayed(r112, 300);
    L44:
        r101.f222723h.setEnableCorrectMatrix(true);
        goto L45
    L38:
        r109 = false;
        goto L39
    L5:
        return super.dispatchTouchEvent(r110);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelClose(boolean r100) {
        tt5.a.h("preview_image", "photoview container onCommentInputPanelClose()");
        if (this.f225007d.q() == false) goto L5;
        this.f225009f.liveInnerForceFullScreen().postValue(Boolean.TRUE);
    L5:
        if (r100 == true) goto L8;
        this.f225007d.i(false, true);
        return;
    }

    public void setDowngrade(boolean r100) {
        this.f225021r = r100;
    }

    @Override // n65.b
    public void setImageActionListener(n65.b.a r100) {
        this.f225019p = r100;
    }

    public void setIsVCFollow(g r100) {
        this.f225020q = r100;
    }

    public void setMimeTypeManager(f r100) {
        this.f225011h = r100;
    }

    public void setOnPhotoRequestListener(b r100) {
        this.f225016m = r100;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c95.c r100) {
        this.f225018o = r100;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r100) {
        this.f225025v = r100;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showSelectedComment(String r100) {
        tt5.a.h("preview_image", "photoview container showSelectedComment() id=" + r100);
        CommentRectLayout r101 = this.f225007d;
        r101.B = r100;
        r101.f236784J.invalidate();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void updateComment(ArrayList<CommentRectF> r100) {
        StringBuilder r101 = new StringBuilder("photoview container updateComment(), size=");
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        r101.append(r102);
        tt5.a.h("preview_image", r101.toString());
        this.f225007d.w(r100, null);
        return;
    L5:
        r102 = r100.size();
        goto L6
    }

    public PhotoViewContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225017n = new CompositeDisposable();
        this.f225021r = false;
        this.f225023t = false;
        this.f225024u = null;
        d(r100);
    }

    public static String c(BitmapFactory.Options r100, String r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return "width: " + r100.outWidth + " height: " + r100.outHeight + " multi: " + (r100.outHeight * r100.outWidth) + "  open mode: " + r101;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r100, ViewOwner r101) {
        this.f225009f = (PreviewViewModel) r101.viewModel(PreviewViewModel.class);
        this.f225022s = (DriveConfigurationVM) r101.viewModel(DriveConfigurationVM.class);
        this.f225010g = (DriveComponentRenderVM) r100.viewModel(DriveComponentRenderVM.class);
        BaseOpenEntity r102 = ((DriveViewModel) r101.viewModel(DriveViewModel.class)).getOpenEntity();
        if (r102 != null) goto L5;
    L7:
        final boolean r103 = false;
    L8:
        this.f225009f.liveInnerCreateNewComment().observe(r101.lifecycleOwner(), new i(this));
        this.f225010g.bindReleaseListener(this);
        ((DriveViewFullScreenVM) r101.viewModel(DriveViewFullScreenVM.class)).liveOuterFullScreenSate.observe(r101.lifecycleOwner(), new n(this, r103));
        if (r103 == true) goto L11;
    L13:
        b(false);
    L14:
        ((DriveBlockPreviewVM) r101.viewModel(DriveBlockPreviewVM.class)).getLiveBlockState().observe(r101.lifecycleOwner(), new o(this));
        this.f225022s.getLiveUiState().observe(r101.lifecycleOwner(), new p(this));
        this.f225022s.isPortrait().observe(r101.lifecycleOwner(), new q(this));
        this.f225022s.isLandscape().observe(r101.lifecycleOwner(), new r(this));
        return;
    L11:
        if (this.f225004a == null) goto L13;
        this.f225006c.setBackgroundColor(-1);
        goto L14
    L5:
        if (r102.isTintWhiteBgInDarkMode() == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // n65.b
    public final void a(float r100, float r101, float r102) {
        d r103 = this.f225012i;
        if (r103 == null) goto L6;
        r103.i(r102, r100, r101);
        return;
    }
}
