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
import com.ss.android.lark.vfs.VFSPath;
import fz4.a0;
import fz4.b0;
import fz4.y;
import fz4.z;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocShotView extends LinearLayout implements b0, i {
    public final String a;
    public Context b;
    public a0 c;
    public BaseTitleBar d;
    public BearLottieView e;
    public SubsamplingScaleImageView f;
    public xu5.b.a g;
    public View h;
    public ExternalShareView i;
    public View j;
    public TextView k;
    public View l;
    public View m;
    public View n;
    public View o;
    public String p;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            a = r0;
            r0[ShareType.Download.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            a[ShareType.Lark.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            a[ShareType.Wechat.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            a[ShareType.WechatMoments.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            a[ShareType.QQ.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            a[ShareType.Weibo.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            a[ShareType.More.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public class b implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r1) {
        }

        public b() {
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
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
        String r0 = this.b.getString(2131889352);
        xu5.b.a r1 = this.g;
        if (r1 == null) goto L5;
        r1.resetState();
    L5:
        setVisibility(8);
        this.e.cancelAnimation();
        this.n.setVisibility(8);
        this.f.setVisibility(8);
        this.h.setVisibility(8);
        Toast.showFailureText(this.b, r0, 0);
    }

    public final void d() {
        tt5.a.b("ScreenShotView", "onDocShotLoading()...");
        setVisibility(0);
        setViewVisibility(false);
        setBackgroundResource(2131100548);
        this.e.playAnimation();
    }

    public final void f() {
        ExternalShareView r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        clearAnimation();
        Animation r1 = AnimationUtils.loadAnimation(getContext(), 2130772669);
        r1.setAnimationListener(new d(this));
        setAnimation(r1);
        xu5.b.a r2 = this.g;
        if (r2 == null) goto L10;
        r2.resetState();
    L10:
        r1.start();
        return;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).H9(this, SharePanelState.NOT_SHOW, b());
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExternalShareView r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L9;
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).H9(this, SharePanelState.NOT_SHOW, b());
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        BaseTitleBar r0 = findViewById(2131385203);
        this.d = r0;
        r0.setLeftClickListener(new y(this));
        this.d.setDividerVisible(false);
        this.e = (BearLottieView) findViewById(2131385202);
        SubsamplingScaleImageView r1 = findViewById(2131385192);
        this.f = r1;
        r1.setScaleImageConfig(new SubsamplingScaleImageView.k(false, false));
        this.h = findViewById(2131378624);
        this.l = findViewById(2131385204);
        this.m = findViewById(2131385201);
        this.n = findViewById(2131379045);
        this.i = (ExternalShareView) findViewById(2131372009);
        this.j = findViewById(2131386059);
        this.k = (TextView) findViewById(2131386060);
        this.o = findViewById(2131367812);
    }

    public String getPanelSession() {
        return this.a;
    }

    public DocShotView(Context r2) {
        this(r2, null);
    }

    private void setViewVisibility(boolean r5) {
        View r0 = this.n;
        int r1 = 8;
        if (r5 == false) goto L5;
        int r3 = 8;
    L6:
        r0.setVisibility(r3);
        SubsamplingScaleImageView r2 = this.f;
        if (r5 == false) goto L9;
        int r4 = 0;
    L10:
        r2.setVisibility(r4);
        View r6 = this.h;
        if (r5 == false) goto L13;
        int r7 = 0;
    L14:
        r6.setVisibility(r7);
        View r8 = this.l;
        if (r5 == false) goto L17;
        int r9 = 0;
    L18:
        r8.setVisibility(r9);
        View r10 = this.m;
        if (r5 == false) goto L21;
        r1 = 0;
    L21:
        r10.setVisibility(r1);
        return;
    L17:
        r9 = 8;
        goto L18
    L13:
        r7 = 8;
        goto L14
    L9:
        r4 = 8;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void a(Configuration r5) {
        if (ku5.c.k(getContext()) == true) goto L15;
        View r0 = this.o;
        if (r0 == null) goto L16;
        if (r5 == null) goto L17;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0.getLayoutParams();
        int r6 = r5.orientation;
        if (r6 != 2) goto L11;
        BaseTitleBar r7 = this.d;
        r7.setBackgroundDrawable(l.a(r7.getContext(), 2131235325, 2131100548));
        r1.width = (int) (n.q(getContext()) * 0.7f);
    L13:
        this.o.setLayoutParams(r1);
        return;
    L11:
        if (r6 != 1) goto L13;
        BaseTitleBar r8 = this.d;
        r8.setBackgroundDrawable(l.a(r8.getContext(), 2131235305, 2131100548));
        r1.width = -1;
        goto L13
    L17:
        return;
    L16:
        return;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        a(r1);
    }

    @Override // fz4.b0
    public void setActivity(Activity r1) {
        this.g = xu5.b.a(r1);
    }

    @Override // fz4.b0
    public void setDocShotPresenter(a0 r1) {
        this.c = r1;
    }

    @Override // fz4.b0
    public void setShareUrl(String r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.p = r1;
    }

    @Override // fz4.b0
    public void setSnapState(boolean r2) {
        ((k15.a) org.koin.java.a.a(k15.a.class)).b(r2);
    }

    public void setSourceInfo(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return;
    L6:
        if (r5.equals(ShareType.ExportImage.name()) == false) goto L8;
        this.i.setVisibility(0);
        this.j.setVisibility(8);
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).H9(this, SharePanelState.SHOWING, b());
        return;
    L8:
        this.i.setVisibility(8);
        this.j.setVisibility(0);
        final ShareType r6 = ShareType.valueOf(r5);
        Context r0 = getContext();
        e r1 = ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9();
        Context r2 = getContext();
        r1.getClass();
        String r3 = xo5.a.c(r0, 2131888208, "channelName", km5.c.c(r2, r6));
        this.k.setText(r3);
        this.j.setOnClickListener(new z(this, r6));
    }

    public DocShotView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = String.valueOf(hashCode());
        this.p = "";
        this.b = r1;
    }

    public final void e(VFSPath r6, float r7) {
        if (r6 == null) goto L13;
        tt5.a.b("ScreenShotView", "onDocShotSuccess()... success");
        setBackgroundResource(2131103546);
        setViewVisibility(true);
        this.i.b(getExportImageShareItems());
        this.i.setOnShareItemClickListener(new com.bytedance.ee.bear.doc.screenshot.b(this));
        this.e.cancelAnimation();
        if (r7 > 0.0f) goto L8;
        r7 = 1.0f;
    L8:
        this.f.setEagerLoadingEnabled(false);
        this.f.setMinScale(r7);
        this.f.setMaxScale(2.0f);
        SubsamplingScaleImageView r1 = this.f;
        Uri r8 = Uri.fromFile(r6.toFile());
        if (r8 == null) goto L12;
        r1.O(new zl5.a(r8), new ImageViewState(r7, new PointF(0.0f, 0.0f), 0));
        this.d.setLeftImageResource(2131254124);
        this.d.setLeftImageTint(2131101926);
        a(getResources().getConfiguration());
        Animation r9 = AnimationUtils.loadAnimation(getContext(), 2130772664);
        setAnimation(r9);
        r9.setDuration(500);
        r9.setAnimationListener(new c(this));
        r9.start();
        return;
    L12:
        throw new NullPointerException("Uri must not be null");
    L13:
        tt5.a.b("ScreenShotView", "onDocShotFail()... fail");
        c();
    }

    public DocShotView(Context r1, AttributeSet r2, int r3) {
        this(r1, r2);
    }
}
