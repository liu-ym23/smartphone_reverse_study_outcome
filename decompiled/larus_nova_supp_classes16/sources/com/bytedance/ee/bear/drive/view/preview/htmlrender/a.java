package com.bytedance.ee.bear.drive.view.preview.htmlrender;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.drive.biz.permission.inject.PointValue;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.document.DocumentView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.LoadingAnimView;
import com.bytedance.ee.bear.drive.view.preview.permission.EncryptData;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.m;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.drive.view.widget.DriveWebView;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.UIHelper;
import fo5.d;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import j95.c;
import j95.e;
import j95.f;
import j95.g;
import j95.h;
import j95.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends FrameLayout implements m, c95.b {
    public static final RenderSecurityScene w = null;
    public View a;
    public TextView b;
    public TextView c;
    public UDNotice d;
    public LoadingAnimView e;
    public b f;
    public DocumentView g;
    public z h;
    public PreviewViewModel i;
    public DriveViewModel j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public String r;
    public Disposable s;
    public Disposable t;
    public final Context u;
    public boolean v;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.htmlrender.a$a, reason: collision with other inner class name */
    public static class C0176a {
        public final BenefitStore a;
        public final String b;
        public final String c;

        public C0176a(BenefitStore r1, String r2, String r3) {
            this.a = r1;
            String r4 = "";
            if (r2 != null) goto L5;
            String r5 = "";
        L6:
            this.b = r5;
            if (r3 == null) goto L10;
            r4 = r3.trim();
        L10:
            this.c = r4;
            return;
        L5:
            r5 = r2.trim();
            goto L6
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public String getCommentQuote() {
        return null;
    }

    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    public String getReleaseKey() {
        return "HtmlPreviewWrapperView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public View getView() {
        return this;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final CommentRectF hideCreateComment() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ boolean isPreviewSupported() {
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onAreaClick() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelClose(boolean r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentInputPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelClose() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onCommentListPanelOpen() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final /* synthetic */ void onNewConfiguration(Configuration r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        this.l = true;
        i();
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showSelectedComment(String r1) {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void showThumbnailPreview() {
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void updateComment(ArrayList<CommentRectF> r1) {
    }

    static {
        w = RenderSecurityScene.DRIVE_DEGRADED_SCENE;
    }

    private String getDisclaimerText() {
        return xo5.a.c(this.u, 2131889526, "APP_DISPLAY_NAME", UIHelper.getAppName());
    }

    public DriveWebView getRenderWebView() {
        return this.f.getWebView();
    }

    public DriveWebView getSourceWebView() {
        return this.g.getWebView();
    }

    public final void h() {
        if (this.p == false) goto L6;
        tt5.a.k("HtmlPreviewWrapperView", "resolveOwnerTenantInfo skipped, ownerTenantInfoResolved");
        return;
    L6:
        View r0 = this.a;
        if (r0 == null) goto L9;
        r0.setVisibility(8);
    L9:
        LoadingAnimView r1 = this.e;
        boolean r2 = false;
        if (r1 == null) goto L13;
        r1.a.clear();
        r1.setVisibility(0);
        r1.c.playAnimation();
    L13:
        if (this.p == false) goto L16;
        tt5.a.h("HtmlPreviewWrapperView", "startSecuritySceneTimeout skipped, ownerTenantInfoResolved");
    L20:
        if (this.q == false) goto L24;
        tt5.a.k("HtmlPreviewWrapperView", "resolveOwnerTenantInfo skipped, ownerTenantInfoResolving");
        return;
    L24:
        if (this.o == true) goto L26;
    L52:
        StringBuilder r3 = new StringBuilder("resolveOwnerTenantInfo skipped, setupCalled:");
        r3.append(this.o);
        r3.append(" ,renderView is null:");
        if (this.f != null) goto L55;
        r2 = true;
    L55:
        r3.append(r2);
        tt5.a.h("HtmlPreviewWrapperView", r3.toString());
        return;
    L26:
        if (this.f == null) goto L52;
        PreviewViewModel r4 = this.i;
        if (r4 == null) goto L39;
        Integer r5 = Integer.valueOf(r4.getBizType());
        int r6 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        if (r5 != null) goto L34;
    L36:
        if (r2 == false) goto L39;
        tt5.a.h("HtmlPreviewWrapperView", "resolveOwnerTenantInfo skipped, bizType is IM file, use relaxed mode");
        d(RenderSecurityScene.IM_SCENE);
        return;
    L34:
        if (r5.intValue() != 3) goto L36;
        r2 = true;
    L39:
        z r7 = this.h;
        if (r7 != null) goto L42;
    L50:
        tt5.a.h("HtmlPreviewWrapperView", "resolveOwnerTenantInfo skipped, file token is empty");
        d(w);
        return;
    L42:
        if (TextUtils.isEmpty(r7.o) == true) goto L50;
        if (TextUtils.isEmpty(this.r) == false) goto L48;
        tt5.a.h("HtmlPreviewWrapperView", "resolveOwnerTenantInfo wait for creator tenant id");
        return;
    L48:
        this.q = true;
        final String r8 = this.r;
        this.s = Flowable.fromCallable(new c(this, r8)).subscribeOn(d.b()).observeOn(d.d()).subscribe(new j95.d(this), new e(this));
        return;
    L16:
        if (this.t == null) goto L18;
        tt5.a.h("HtmlPreviewWrapperView", "startSecuritySceneTimeout skipped, securitySceneTimeoutDisposable has begun");
        goto L20
    L18:
        this.t = Flowable.timer(12000, TimeUnit.MILLISECONDS).observeOn(d.d()).subscribe(new h(this), new i(this));
        goto L20
    }

    public final void i() {
        if (this.p == true) goto L7;
        h();
        return;
    L7:
        if (this.k != 0) goto L12;
        if (this.m == true) goto L15;
        this.m = true;
        this.f.show();
        return;
    L15:
        return;
    L12:
        if (this.n == true) goto L17;
        this.n = true;
        this.g.show();
        return;
    }

    public final void k() {
        TextView r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.c == null) goto L17;
        boolean r2 = false;
        if (this.k != 0) goto L10;
        boolean r1 = true;
    L11:
        l(r0, r1);
        TextView r3 = this.c;
        if (this.k != 1) goto L14;
        r2 = true;
    L14:
        l(r3, r2);
        return;
    L10:
        r1 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        if (this.k != 0) goto L5;
        Object r0 = this.f;
    L6:
        r0.getClass();
        return false;
    L5:
        r0 = this.g;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public a(Context r3) {
        super(r3);
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = "";
        this.v = false;
        this.u = r3;
    }

    private void setupTabLayout(View r4) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(ContextCompat.getColor(getContext(), 2131101950));
        r0.setCornerRadius(e(6));
        r4.setBackground(r0);
        this.b.setOnClickListener(new j95.a(this));
        this.c.setOnClickListener(new j95.b(this));
        k();
    }

    @Override // c95.b
    public final void a(PointValue r2) {
        b r0 = this.f;
        if (r0 == null) goto L5;
        r0.a(r2);
    L5:
        DocumentView r1 = this.g;
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    }

    @Override // c95.b
    public final void b(int r2) {
        b r0 = this.f;
        if (r0 == null) goto L5;
        r0.b(r2);
    L5:
        DocumentView r1 = this.g;
        if (r1 == null) goto L9;
        r1.b(r2);
        return;
    }

    @Override // c95.b
    public final void c(String r2) {
        b r0 = this.f;
        if (r0 == null) goto L5;
        r0.c(r2);
    L5:
        DocumentView r1 = this.g;
        if (r1 == null) goto L9;
        r1.c(r2);
        return;
    }

    public final void d(RenderSecurityScene r8) {
        if (this.p == false) goto L6;
        tt5.a.h("HtmlPreviewWrapperView", "applyRenderSecurityScene skipped, ownerTenantInfoResolved");
        return;
    L6:
        boolean r0 = true;
        this.p = true;
        this.q = false;
        Disposable r2 = this.s;
        if (r2 == null) goto L9;
        r2.dispose();
        this.s = null;
    L9:
        Disposable r3 = this.t;
        if (r3 == null) goto L12;
        r3.dispose();
        this.t = null;
    L12:
        LoadingAnimView r4 = this.e;
        if (r4 == null) goto L15;
        r4.a.clear();
        r4.c.cancelAnimation();
        r4.setVisibility(8);
    L15:
        View r5 = this.a;
        if (r5 == null) goto L18;
        r5.setVisibility(0);
    L18:
        b r6 = this.f;
        if (r6 == null) goto L27;
        r6.k = true;
        if (r6.i == null) goto L23;
        tt5.a.h("SafeHtmlRenderView", "apply security scene:" + r8);
        r6.i.b = r8;
    L25:
        if (r6.l == false) goto L27;
        r6.f();
        goto L27
    L23:
        tt5.a.k("SafeHtmlRenderView", "apply security scene failed, mSandboxWebViewHandler is null! securityScene:" + r8);
    L27:
        PreviewViewModel r7 = this.i;
        if (r7 == null) goto L45;
        Integer r9 = Integer.valueOf(r7.getBizType());
        int r10 = com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.a;
        if (r9 != null) goto L33;
    L35:
        boolean r11 = false;
    L36:
        if (r11 == false) goto L38;
    L39:
        UDNotice r12 = this.d;
        if (r12 == null) goto L42;
        r12.setVisibility(8);
    L42:
        DriveViewModel r13 = this.j;
        if (r13 == null) goto L52;
        r13.setTitleBarSubtitleOverride(getDisclaimerText());
    L52:
        if (r8 == w) goto L55;
        r0 = false;
    L55:
        this.v = r0;
        z r14 = this.h;
        if (r14 == null) goto L71;
        if (TextUtils.isEmpty(r14.o) == true) goto L71;
        o75.a r16 = o75.b.a();
        if (r16 == null) goto L71;
        if (r16.Tb() == null) goto L71;
        com.bytedance.ee.bear.drive.report.a r17 = r16.Tb();
        String r1 = this.h.o;
        if (this.v == false) goto L68;
        String r18 = "true";
    L69:
        r17.t(r1, "is_degraded", r18);
        goto L71
    L68:
        r18 = "false";
    L71:
        if (this.l == false) goto L74;
        i();
        return;
    L74:
        return;
    L38:
        if (com.bytedance.ee.bear.contract.drive.sdk.entity.open.a.C0037a.a(this.i.getBizType()) == false) goto L45;
    L33:
        if (r9.intValue() != 3) goto L35;
        r11 = true;
    L45:
        DriveViewModel r19 = this.j;
        if (r19 == null) goto L48;
        r19.clearTitleBarSubtitleOverride();
    L48:
        UDNotice r20 = this.d;
        if (r20 == null) goto L52;
        r20.setVisibility(0);
        goto L52
    }

    public final int e(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void g(int r7) {
        int r0 = this.k;
        if (r0 != r7) goto L6;
        return;
    L6:
        if (this.h == null) goto L21;
        o75.a r1 = o75.b.a();
        if (r1 == null) goto L21;
        if (r1.Ke() == null) goto L21;
        com.bytedance.ee.bear.drive.report.c r2 = r1.Ke();
        z r3 = this.h;
        String r4 = "render";
        if (r0 != 0) goto L16;
        Object r5 = "render";
    L17:
        if (r7 == 0) goto L20;
        r4 = "source";
    L20:
        r2.getClass();
        HashMap<String, Object> r6 = r2.h(r3.o, r3.b);
        r6.put("file_type", "html");
        r6.put("html_mode", r5);
        r6.put("click", r4);
        r2.A("ccm_html_mode_click", r6);
        goto L21
    L16:
        r5 = "source";
    L21:
        j(Integer.valueOf(r7));
    }

    public final void j(Integer r5) {
        int r1 = 0;
        if (r5 != null) goto L5;
    L7:
        int r6 = 0;
    L8:
        this.k = r6;
        b r2 = this.f;
        if (r2 != null) goto L11;
        return;
    L11:
        if (this.g == null) goto L26;
        int r7 = r6 ^ 1;
        if (r7 == 0) goto L16;
        int r3 = 0;
    L17:
        r2.setVisibility(r3);
        DocumentView r4 = this.g;
        if (r7 == 0) goto L20;
        r1 = 8;
    L20:
        r4.setVisibility(r1);
        k();
        if (this.l == false) goto L25;
        i();
        return;
    L25:
        return;
    L16:
        r3 = 8;
        goto L17
    L26:
        return;
    L5:
        if (r5.intValue() != 1) goto L7;
        r6 = 1;
        goto L8
    }

    @Override // c95.b
    public void setEncryptData(EncryptData r2) {
        b r0 = this.f;
        if (r0 == null) goto L5;
        r0.setEncryptData(r2);
    L5:
        DocumentView r1 = this.g;
        if (r1 == null) goto L9;
        r1.setEncryptData(r2);
        return;
    }

    @Override // c95.d
    public void setOnShowViewTrackEventCallback(c95.c r2) {
        this.f.setOnShowViewTrackEventCallback(r2);
        this.g.setOnShowViewTrackEventCallback(r2);
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r2) {
        this.f.setUserAbility(r2);
        this.g.setUserAbility(r2);
    }

    public final void f(z r7, boolean r8) {
        if (this.u != null) goto L6;
        tt5.a.d("HtmlPreviewWrapperView", "mContext is null");
        return;
    L6:
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.v = false;
        this.h = r7;
        Disposable r1 = this.s;
        if (r1 == null) goto L9;
        r1.dispose();
        this.s = null;
    L9:
        Disposable r2 = this.t;
        if (r2 == null) goto L12;
        r2.dispose();
        this.t = null;
    L12:
        LoadingAnimView r3 = this.e;
        if (r3 == null) goto L15;
        r3.a.clear();
        r3.c.cancelAnimation();
        r3.setVisibility(8);
        this.e = null;
    L15:
        removeAllViews();
        this.d = null;
        LayoutInflater.from(getContext()).inflate(2131560198, this, true);
        this.a = findViewById(2131374632);
        this.b = (TextView) findViewById(2131374630);
        this.c = (TextView) findViewById(2131374631);
        this.d = (UDNotice) findViewById(2131374629);
        FrameLayout r4 = (FrameLayout) findViewById(2131374628);
        setupTabLayout(this.a);
        UDNotice r5 = this.d;
        if (r5 == null) goto L19;
        r5.setText(getDisclaimerText());
        this.d.setType(UDNotice.Type.INFO);
        this.d.setIcon(2131254920);
        this.d.i6(true);
        this.d.setIconButton(2131254124);
        this.d.setIconButtonListener(new g(this));
    L19:
        b r6 = new b(this.u);
        this.f = r6;
        r6.h = new b.C0177b(r7);
        r6.k = false;
        r6.l = false;
        r6.m = false;
        DocumentView r0 = new DocumentView(this.u);
        this.g = r0;
        r0.h = new DocumentView.a(r7);
        r0.setHighLight(r8);
        r4.addView(this.f.getView(), new FrameLayout.LayoutParams(-1, -1));
        r4.addView(this.g.getView(), new FrameLayout.LayoutParams(-1, -1));
        LoadingAnimView r9 = new LoadingAnimView(getContext());
        this.e = r9;
        r9.setVisibility(8);
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.gravity = 17;
        addView(this.e, r10);
        j(Integer.valueOf(this.k));
    }

    public final void l(TextView r4, boolean r5) {
        r4.setSelected(r5);
        Context r0 = getContext();
        if (r5 == false) goto L5;
        int r1 = 2131106622;
    L6:
        r4.setTextColor(ContextCompat.getColor(r0, r1));
        if (r5 == false) goto L9;
        GradientDrawable r6 = new GradientDrawable();
        r6.setColor(ContextCompat.getColor(getContext(), 2131100548));
        r6.setStroke(e(1), ContextCompat.getColor(getContext(), 2131103352));
        r6.setCornerRadius(e(6));
    L10:
        r4.setBackground(r6);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r1 = 2131106607;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r2, ViewOwner r3) {
        this.f.onSetup(r2, r3);
        this.g.onSetup(r2, r3);
        LoadingAnimView r0 = this.e;
        if (r0 == null) goto L5;
        r0.c(r2);
    L5:
        this.i = (PreviewViewModel) r3.viewModel(PreviewViewModel.class);
        this.j = (DriveViewModel) r3.viewModel(DriveViewModel.class);
        this.i.getLiveCreatorTenantId().observe(r3.lifecycleOwner(), new f(this));
        this.o = true;
        h();
    }
}
