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
import com.bytedance.ee.bear.drive.view.preview.wrapper.y;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PhotoViewContainer extends FrameLayout implements m, n65.b, m85.a {
    public static final /* synthetic */ int w = 0;
    public Context a;
    public View b;
    public FrameLayout c;
    public CommentRectLayout d;
    public com.bytedance.ee.bear.drive.biz.comment.c e;
    public PreviewViewModel f;
    public DriveComponentRenderVM g;
    public f h;
    public d i;
    public r95.c j;
    public a k;
    public long l;
    public b m;
    public final CompositeDisposable n;
    public c95.c o;
    public n65.b.a p;
    public g q;
    public boolean r;
    public DriveConfigurationVM s;
    public boolean t;
    public com.bytedance.ee.bear.bizwidget.magicshare.cursor.b u;
    public a95.a v;

    public static class a {
        public final z a;
        public final int b;

        public a(z r1, int r2) {
            this.a = r1;
            this.b = r2;
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
    public final /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    public final void e() {
        n65.b.a r0 = this.p;
        if (r0 == null) goto L6;
        ((n65.a.C0260a) r0).a();
        return;
    }

    public final void f() {
        if (this.f.liveOuterNotPreviewContentHeight().getValue() != null) goto L5;
        return;
    L5:
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) getLayoutParams();
        r0.height = ((Integer) ((y) this.f.liveOuterNotPreviewContentHeight().getValue()).run()).intValue();
        setLayoutParams(r0);
        d r1 = this.i;
        if (r1 == null) goto L9;
        r1.a(1.0f, false);
        return;
    }

    @Override // n65.b
    public float getScale() {
        d r0 = this.i;
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        if ((r0 instanceof h) == false) goto L11;
        return ((h) r0).getStandScale();
    L11:
        return r0.getScale();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final CommentRectF hideCreateComment() {
        tt5.a.h("preview_image", "photoview container hideCreateComment()");
        this.f.liveInnerForceFullScreen().postValue(Boolean.FALSE);
        this.d.i(false, false);
        return this.d.j();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onAreaClick() {
        tt5.a.h("preview_image", "photoview container onAreaClick()");
        this.f.liveInnerCommentSelected().postValue(null);
        CommentRectLayout r0 = getCommentRectLayout();
        if (r0.q() == false) goto L6;
        MutableLiveData<Boolean> r1 = this.f.liveInnerForceFullScreen();
        Boolean r2 = Boolean.FALSE;
        r1.postValue(r2);
        r0.j();
        this.f.liveInnerCreateNewComment().postValue(r2);
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
        CommentRectLayout r0 = this.d;
        r0.B = null;
        r0.J.invalidate();
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) getLayoutParams();
        r1.height = -1;
        setLayoutParams(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        com.bytedance.ee.bear.bizwidget.magicshare.cursor.b r0 = this.u;
        if (r0 == null) goto L5;
        r0.hide();
    L5:
        PreviewViewModel r1 = this.f;
        if (r1 != null) goto L8;
    L10:
        super.onDetachedFromWindow();
        if (this.g.needBindReleaseListener() == true) goto L14;
        onRelease();
        return;
    L14:
        return;
    L8:
        if (r1.isBlockViewChanging() == false) goto L10;
    }

    @Override // m85.a
    public final void onRelease() {
        PreviewViewModel r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        this.n.clear();
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        a r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == null) goto L12;
        this.l = System.currentTimeMillis();
        c95.c r1 = this.o;
        if (r1 == null) goto L9;
        r1.onShowStart();
    L9:
        this.n.add(Flowable.fromCallable(new v(this)).observeOn(fo5.d.d()).flatMap(new j()).flatMap(new k(this)).map(new s(this)).subscribe(new t(this), new u(this)));
        return;
    }

    public CommentRectLayout getCommentRectLayout() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showThumbnailPreview() {
        f();
    }

    public PhotoViewContainer(Context r2) {
        super(r2);
        this.n = new CompositeDisposable();
        this.r = false;
        this.t = false;
        this.u = null;
        d(r2);
    }

    public final void b(boolean r5) {
        boolean r0 = false;
        com.bytedance.ee.drive.render.k.c r1 = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(getContext()).b().d();     // Catch: Throwable -> L8
        if (r1 == null) goto L11;
        if (r1.a == false) goto L11;
        r0 = true;
    L11:
        if (r5 == true) goto L15;
        if (r0 == true) goto L15;
        int r6 = 2131103546;
    L16:
        this.c.setBackgroundColor(getResources().getColor(r6));
        View r7 = this.b;
        if (r7 == null) goto L23;
        if (r0 == false) goto L24;
        r7.setBackgroundColor(getResources().getColor(2131106500));
        return;
    L24:
        return;
    L23:
        return;
    L15:
        r6 = 2131106500;
    L8:
        th = move-exception;
        tt5.a.e("PhotoViewContainer", "resolve media immersive config failed, use default", th, false);
        goto L11
    }

    public final void d(Context r2) {
        this.a = r2;
        LayoutInflater.from(r2).inflate(2131560217, this);
        this.b = findViewById(2131370313);
        this.c = (FrameLayout) findViewById(2131367728);
        CommentRectLayout r3 = findViewById(2131370253);
        this.d = r3;
        r3.w(null, null);
        this.e = new com.bytedance.ee.bear.drive.biz.comment.c(this.d);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r14) {
        Object r0 = this.i;
        if (r0 == null) goto L5;
        com.bytedance.ee.bear.drive.biz.comment.c r1 = this.e;
        r1.getClass();
        float r2 = r14.getX();
        float r3 = r14.getY();
        if (r14.getPointerCount() <= 1) goto L13;
        r1.j.removeCallbacks(r1.k);
        r1.j.removeCallbacks(r1.l);
        if (r1.h.q() == true) goto L13;
        if ((r0 instanceof View) == false) goto L13;
        r1.d = true;
        r1.h.setEnableCorrectMatrix(true);
        r1.i.d();
        boolean r4 = ((View) r0).dispatchTouchEvent(MotionEvent.obtain(r14));
    L46:
        if (r4 == false) goto L48;
    L49:
        return true;
    L48:
        if (super.dispatchTouchEvent(r14) == true) goto L49;
        return false;
    L13:
        int r5 = r14.getAction();
        if (r5 == 0) goto L35;
        if (r5 != 1) goto L17;
    L31:
        r1.e = false;
        r1.j.removeCallbacks(r1.k);
        r1.h.setEnableCorrectMatrix(false);
        if (r1.d == false) goto L34;
        r1.i.f();
    L34:
        r1.d = false;
    L45:
        r4 = r1.c;
        goto L46
    L17:
        if (r5 != 2) goto L19;
        float r6 = Math.abs(r1.a - r2);
        float r7 = Math.abs(r1.b - r3);
        if (r6 < 15.0f) goto L24;
    L25:
        r1.j.removeCallbacks(r1.k);
    L27:
        if (r6 < 8.0f) goto L29;
    L30:
        r1.j.removeCallbacks(r1.l);
        goto L45
    L29:
        if (r7 < 8.0f) goto L45;
    L24:
        if (r7 < 15.0f) goto L27;
    L19:
        if (r5 == 3) goto L31;
    L35:
        r1.c = false;
        r1.e = true;
        long r8 = System.currentTimeMillis();
        if ((r8 - r1.f) >= 300) goto L38;
        r1.j.removeCallbacks(r1.l);
        boolean r9 = true;
    L39:
        r1.f = r8;
        r1.a = r2;
        r1.b = r3;
        if (r1.h.q() == true) goto L44;
        r1.j.postDelayed(r1.k, ViewConfiguration.getLongPressTimeout());
        CommentRectF r10 = r1.h.o(r2, r3);
        com.bytedance.ee.bear.drive.biz.comment.c.b r11 = r1.l;
        r11.a = r10;
        if (r9 == true) goto L44;
        r1.j.postDelayed(r11, 300);
    L44:
        r1.h.setEnableCorrectMatrix(true);
        goto L45
    L38:
        r9 = false;
        goto L39
    L5:
        return super.dispatchTouchEvent(r14);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelClose(boolean r3) {
        tt5.a.h("preview_image", "photoview container onCommentInputPanelClose()");
        if (this.d.q() == false) goto L5;
        this.f.liveInnerForceFullScreen().postValue(Boolean.TRUE);
    L5:
        if (r3 == true) goto L8;
        this.d.i(false, true);
        return;
    }

    public void setDowngrade(boolean r1) {
        this.r = r1;
    }

    @Override // n65.b
    public void setImageActionListener(n65.b.a r1) {
        this.p = r1;
    }

    public void setIsVCFollow(g r1) {
        this.q = r1;
    }

    public void setMimeTypeManager(f r1) {
        this.h = r1;
    }

    public void setOnPhotoRequestListener(b r1) {
        this.m = r1;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c95.c r1) {
        this.o = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r1) {
        this.v = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showSelectedComment(String r3) {
        tt5.a.h("preview_image", "photoview container showSelectedComment() id=" + r3);
        CommentRectLayout r0 = this.d;
        r0.B = r3;
        r0.J.invalidate();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void updateComment(ArrayList<CommentRectF> r3) {
        StringBuilder r0 = new StringBuilder("photoview container updateComment(), size=");
        if (r3 != null) goto L5;
        int r1 = 0;
    L6:
        r0.append(r1);
        tt5.a.h("preview_image", r0.toString());
        this.d.w(r3, null);
        return;
    L5:
        r1 = r3.size();
        goto L6
    }

    public PhotoViewContainer(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.n = new CompositeDisposable();
        this.r = false;
        this.t = false;
        this.u = null;
        d(r1);
    }

    public static String c(BitmapFactory.Options r2, String r3) {
        if (r2 != null) goto L6;
        return "";
    L6:
        return "width: " + r2.outWidth + " height: " + r2.outHeight + " multi: " + (r2.outHeight * r2.outWidth) + "  open mode: " + r3;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r5, ViewOwner r6) {
        this.f = (PreviewViewModel) r6.viewModel(PreviewViewModel.class);
        this.s = (DriveConfigurationVM) r6.viewModel(DriveConfigurationVM.class);
        this.g = (DriveComponentRenderVM) r5.viewModel(DriveComponentRenderVM.class);
        BaseOpenEntity r7 = ((DriveViewModel) r6.viewModel(DriveViewModel.class)).getOpenEntity();
        if (r7 != null) goto L5;
    L7:
        final boolean r8 = false;
    L8:
        this.f.liveInnerCreateNewComment().observe(r6.lifecycleOwner(), new i(this));
        this.g.bindReleaseListener(this);
        ((DriveViewFullScreenVM) r6.viewModel(DriveViewFullScreenVM.class)).liveOuterFullScreenSate.observe(r6.lifecycleOwner(), new n(this, r8));
        if (r8 == true) goto L11;
    L13:
        b(false);
    L14:
        ((DriveBlockPreviewVM) r6.viewModel(DriveBlockPreviewVM.class)).getLiveBlockState().observe(r6.lifecycleOwner(), new o(this));
        this.s.getLiveUiState().observe(r6.lifecycleOwner(), new p(this));
        this.s.isPortrait().observe(r6.lifecycleOwner(), new q(this));
        this.s.isLandscape().observe(r6.lifecycleOwner(), new r(this));
        return;
    L11:
        if (this.a == null) goto L13;
        this.c.setBackgroundColor(-1);
        goto L14
    L5:
        if (r7.isTintWhiteBgInDarkMode() == false) goto L7;
        r8 = true;
        goto L8
    }

    @Override // n65.b
    public final void a(float r2, float r3, float r4) {
        d r0 = this.i;
        if (r0 == null) goto L6;
        r0.i(r4, r2, r3);
        return;
    }
}
