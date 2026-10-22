package com.bytedance.ee.bear.doc.screenshot;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareView;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.scaleimageview.ImageViewState;
import com.bytedance.ee.bear.scaleimageview.SubsamplingScaleImageView;
import com.bytedance.ee.bear.share.e;
import com.bytedance.ee.bear.share.export.SharePanelState;
import com.bytedance.ee.bear.share.export.i;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.vfs.VFSPath;
import fz4.a0;
import fz4.b0;
import fz4.y;
import fz4.z;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class DocShotView extends LinearLayout implements b0, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f218096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f218097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a0 f218098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BaseTitleBar f218099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BearLottieView f218100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SubsamplingScaleImageView f218101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public xu5.b.a f218102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f218103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ExternalShareView f218104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f218105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f218106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f218107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f218108m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f218109n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f218110o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f218111p;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f218112a = null;

        static {
            int[] r100 = new int[ShareType.values().length];
            f218112a = r100;
            r100[ShareType.Download.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f218112a[ShareType.Lark.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f218112a[ShareType.Wechat.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f218112a[ShareType.WechatMoments.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f218112a[ShareType.QQ.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f218112a[ShareType.Weibo.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f218112a[ShareType.More.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public class b implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r100) {
        }

        public b() {
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return true;
    }

    private List<ShareItemModel> getExportImageShareItems() {
        return ((cj5.c) org.koin.java.a.a(cj5.c.class)).getProvider().a(b());
    }

    public final km5.a b() {
        return new km5.a(0, 0, null, false, false, null, null, null, false, false, false, false, null, null, false, false, ShareScene.EXPORT_IMAGE);
    }

    public final void c() {
        tt5.a.b("ScreenShotView", "onDocShotFail()...");
        String r100 = this.f218097b.getString(R.string.LarkCCM_Docx_ExportFailed);
        xu5.b.a r101 = this.f218102g;
        if (r101 == null) goto L5;
        r101.resetState();
    L5:
        setVisibility(8);
        this.f218100e.cancelAnimation();
        this.f218109n.setVisibility(8);
        this.f218101f.setVisibility(8);
        this.f218103h.setVisibility(8);
        Toast.showFailureText(this.f218097b, r100, 0);
    }

    public final void d() {
        tt5.a.b("ScreenShotView", "onDocShotLoading()...");
        setVisibility(0);
        setViewVisibility(false);
        setBackgroundResource(R.color.bg_body);
        this.f218100e.playAnimation();
    }

    public final void f() {
        ExternalShareView r100 = this.f218104i;
        if (r100 != null) goto L5;
    L7:
        clearAnimation();
        Animation r101 = AnimationUtils.loadAnimation(getContext(), R.anim.translate_top_to_bottom);
        r101.setAnimationListener(new d(this));
        setAnimation(r101);
        xu5.b.a r102 = this.f218102g;
        if (r102 == null) goto L10;
        r102.resetState();
    L10:
        r101.start();
        return;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).H9(this, SharePanelState.NOT_SHOW, b());
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExternalShareView r100 = this.f218104i;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getVisibility() != 0) goto L9;
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).H9(this, SharePanelState.NOT_SHOW, b());
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        BaseTitleBar r100 = (BaseTitleBar) findViewById(R.id.screen_shot_title);
        this.f218099d = r100;
        r100.setLeftClickListener(new y(this));
        this.f218099d.setDividerVisible(false);
        this.f218100e = (BearLottieView) findViewById(R.id.screen_shot_loading);
        SubsamplingScaleImageView r101 = (SubsamplingScaleImageView) findViewById(R.id.screen_shot_bitmap);
        this.f218101f = r101;
        r101.setScaleImageConfig(new SubsamplingScaleImageView.k(false, false));
        this.f218103h = findViewById(R.id.ll_bottom);
        this.f218107l = findViewById(R.id.screen_shot_title_divider);
        this.f218108m = findViewById(R.id.screen_shot_layout);
        this.f218109n = findViewById(R.id.loading_layout);
        this.f218104i = (ExternalShareView) findViewById(R.id.external_share_view);
        this.f218105j = findViewById(R.id.share_btn);
        this.f218106k = (TextView) findViewById(R.id.share_btn_text);
        this.f218110o = findViewById(R.id.content_container);
    }

    @Override // com.bytedance.ee.bear.share.export.i
    public String getPanelSession() {
        return this.f218096a;
    }

    public DocShotView(Context r100) {
        this(r100, null);
    }

    private void setViewVisibility(boolean r100) {
        View r101 = this.f218109n;
        int r102 = 8;
        if (r100 == false) goto L5;
        int r103 = 8;
    L6:
        r101.setVisibility(r103);
        SubsamplingScaleImageView r104 = this.f218101f;
        if (r100 == false) goto L9;
        int r105 = 0;
    L10:
        r104.setVisibility(r105);
        View r106 = this.f218103h;
        if (r100 == false) goto L13;
        int r107 = 0;
    L14:
        r106.setVisibility(r107);
        View r108 = this.f218107l;
        if (r100 == false) goto L17;
        int r109 = 0;
    L18:
        r108.setVisibility(r109);
        View r110 = this.f218108m;
        if (r100 == false) goto L21;
        r102 = 0;
    L21:
        r110.setVisibility(r102);
        return;
    L17:
        r109 = 8;
        goto L18
    L13:
        r107 = 8;
        goto L14
    L9:
        r105 = 8;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final void a(Configuration r100) {
        if (ku5.c.k(getContext()) == true) goto L15;
        View r101 = this.f218110o;
        if (r101 == null) goto L16;
        if (r100 == null) goto L17;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101.getLayoutParams();
        int r103 = r100.orientation;
        if (r103 != 2) goto L11;
        BaseTitleBar r104 = this.f218099d;
        r104.setBackgroundDrawable(l.a(r104.getContext(), R.drawable.facade_round_top_xxl, R.color.bg_body));
        r102.width = (int) (n.q(getContext()) * 0.7f);
    L13:
        this.f218110o.setLayoutParams(r102);
        return;
    L11:
        if (r103 != 1) goto L13;
        BaseTitleBar r105 = this.f218099d;
        r105.setBackgroundDrawable(l.a(r105.getContext(), R.drawable.facade_rectangle, R.color.bg_body));
        r102.width = -1;
        goto L13
    L17:
        return;
    L16:
        return;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        a(r100);
    }

    @Override // fz4.b0
    public void setActivity(Activity r100) {
        this.f218102g = xu5.b.a(r100);
    }

    @Override // fz4.b0
    public void setDocShotPresenter(a0 r100) {
        this.f218098c = r100;
    }

    @Override // fz4.b0
    public void setShareUrl(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.f218111p = r100;
    }

    @Override // fz4.b0
    public void setSnapState(boolean r100) {
        ((k15.a) org.koin.java.a.a(k15.a.class)).b(r100);
    }

    public void setSourceInfo(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (r100.equals(ShareType.ExportImage.name()) == false) goto L8;
        this.f218104i.setVisibility(0);
        this.f218105j.setVisibility(8);
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).H9(this, SharePanelState.SHOWING, b());
        return;
    L8:
        this.f218104i.setVisibility(8);
        this.f218105j.setVisibility(0);
        final ShareType r101 = ShareType.valueOf(r100);
        Context r102 = getContext();
        e r103 = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9();
        Context r104 = getContext();
        r103.getClass();
        String r105 = xo5.a.c(r102, R.string.Doc_Share_DownloadAndShare, "channelName", km5.c.c(r104, r101));
        this.f218106k.setText(r105);
        this.f218105j.setOnClickListener(new z(this, r101));
    }

    public DocShotView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f218096a = String.valueOf(hashCode());
        this.f218111p = "";
        this.f218097b = r100;
    }

    public final void e(VFSPath r100, float r101) {
        if (r100 == null) goto L13;
        tt5.a.b("ScreenShotView", "onDocShotSuccess()... success");
        setBackgroundResource(R.color.lkui_transparent);
        setViewVisibility(true);
        this.f218104i.b(getExportImageShareItems());
        this.f218104i.setOnShareItemClickListener(new com.bytedance.ee.bear.doc.screenshot.b(this));
        this.f218100e.cancelAnimation();
        if (r101 > 0.0f) goto L8;
        r101 = 1.0f;
    L8:
        this.f218101f.setEagerLoadingEnabled(false);
        this.f218101f.setMinScale(r101);
        this.f218101f.setMaxScale(2.0f);
        SubsamplingScaleImageView r102 = this.f218101f;
        Uri r103 = Uri.fromFile(r100.toFile());
        if (r103 == null) goto L12;
        r102.O(new zl5.a(r103), new ImageViewState(r101, new PointF(0.0f, 0.0f), 0));
        this.f218099d.setLeftImageResource(R.drawable.ud_icon_close_small_outlined);
        this.f218099d.setLeftImageTint(R.color.facade_selector_icon_n1);
        a(getResources().getConfiguration());
        Animation r104 = AnimationUtils.loadAnimation(getContext(), R.anim.translate_from_bottom_in);
        setAnimation(r104);
        r104.setDuration(500);
        r104.setAnimationListener(new c(this));
        r104.start();
        return;
    L12:
        throw new NullPointerException("Uri must not be null");
    L13:
        tt5.a.b("ScreenShotView", "onDocShotFail()... fail");
        c();
    }

    public DocShotView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101);
    }
}
