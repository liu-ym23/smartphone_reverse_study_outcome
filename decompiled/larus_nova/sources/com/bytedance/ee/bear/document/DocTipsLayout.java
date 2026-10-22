package com.bytedance.ee.bear.document;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.document.tips.TipsWithConfirmView;
import com.bytedance.ee.bear.facade.common.widget.DLPRiskBannerView;
import com.bytedance.ee.bear.facade.common.widget.ErrorTipsView;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;
import com.bytedance.ee.bear.facade.common.widget.QuotaBannerView;
import com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView;
import com.bytedance.ee.bear.facade.common.widget.TemplateTagTipsView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class DocTipsLayout extends FrameLayout {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f218561u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f218562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f218563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f218564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f218565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f218566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f218567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f218568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f218569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f218570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f218571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f218572k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TipsWithConfirmView f218573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public NoNetworkView f218574m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TemplateTagTipsView f218575n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.ee.bear.notification.a.b f218576o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ErrorTipsView f218577p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f218578q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public SecretSetBannerView f218579r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public DLPRiskBannerView f218580s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public QuotaBannerView f218581t;

    public final void c() {
        this.f218564c = false;
        a();
        this.f218576o.a();
        b();
    }

    public final void a() {
        d(new View[]{this.f218574m, this.f218573l, this.f218580s, this.f218578q, this.f218577p, this.f218579r, this.f218575n, this.f218581t});
        boolean r100 = this.f218562a;
        if (r100 == true) goto L5;
    L11:
        if (r100 == false) goto L15;
        this.f218574m.setVisibility(0);
        return;
    L15:
        if (this.f218565d == false) goto L19;
        this.f218577p.setVisibility(0);
        return;
    L19:
        if (this.f218563b == false) goto L23;
        this.f218573l.setVisibility(0);
        return;
    L23:
        if (this.f218568g == false) goto L29;
        if (this.f218569h == true) goto L29;
        this.f218580s.setVisibility(0);
        return;
    L29:
        if (this.f218564c == false) goto L33;
        this.f218578q.setVisibility(0);
        return;
    L33:
        if (this.f218567f == false) goto L37;
        this.f218579r.setVisibility(0);
        return;
    L37:
        if (this.f218566e == false) goto L41;
        this.f218575n.setVisibility(0);
        return;
    L41:
        if (this.f218570i == false) goto L45;
        this.f218581t.setVisibility(0);
        return;
    L45:
        return;
    L5:
        if (this.f218565d == false) goto L11;
        if (this.f218572k == false) goto L9;
        this.f218574m.setVisibility(0);
        return;
    L9:
        this.f218577p.setVisibility(0);
    }

    public final void b() {
        if (this.f218563b == false) goto L5;
        return;
    L5:
        if (this.f218562a == false) goto L7;
        return;
    L7:
        if (this.f218564c == false) goto L9;
        return;
    L9:
        if (this.f218565d == false) goto L11;
        return;
    L11:
        if (this.f218566e == false) goto L13;
        return;
    L13:
        if (this.f218567f == false) goto L15;
        return;
    L15:
        if (this.f218568g == false) goto L17;
        return;
    L17:
        if (this.f218570i == true) goto L27;
        setVisibility(8);
        return;
    }

    public com.bytedance.ee.bear.notification.a.b getNotificationView() {
        return this.f218576o;
    }

    public DocTipsLayout(Context r100) {
        super(r100);
        this.f218562a = false;
        this.f218563b = false;
        this.f218564c = false;
        this.f218565d = false;
        this.f218566e = false;
        this.f218567f = false;
        this.f218568g = false;
        this.f218569h = false;
        this.f218570i = false;
        this.f218571j = false;
        this.f218572k = true;
        e(r100);
    }

    public static void d(View... r100) {
        if (r100.length != 0) goto L5;
        return;
    L5:
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        r100[r102].setVisibility(8);
        r102 = r102 + 1;
        goto L6
    }

    public final void e(Context r100) {
        FrameLayout.inflate(r100, R.layout.doc_main_tips_layout, this);
        this.f218573l = (TipsWithConfirmView) findViewById(R.id.at_notify_tips);
        this.f218574m = (NoNetworkView) findViewById(R.id.doc_main_no_network_tip_banner);
        this.f218575n = (TemplateTagTipsView) findViewById(R.id.doc_main_template_tag_tip_banner);
        this.f218578q = (ViewGroup) findViewById(R.id.doc_main_notification_container);
        com.bytedance.ee.bear.notification.a.b r101 = ((com.bytedance.ee.bear.notification.a) org.koin.java.a.a(com.bytedance.ee.bear.notification.a.class)).d();
        this.f218576o = r101;
        this.f218578q.addView(r101.e(r100));
        ErrorTipsView r102 = (ErrorTipsView) findViewById(R.id.error_tips);
        this.f218577p = r102;
        r102.setIconButtonListener(new v1(this));
        this.f218579r = (SecretSetBannerView) findViewById(R.id.secret_banner_view);
        this.f218580s = (DLPRiskBannerView) findViewById(R.id.dlp_risk_banner_view);
        QuotaBannerView r103 = (QuotaBannerView) findViewById(R.id.doc_main_quota_banner);
        this.f218581t = r103;
        r103.setIconButtonListener(new x1(this));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return super.generateLayoutParams(r100);
    L4:
        e = move-exception;
        tt5.a.e("DocTipsLayout", "generateLayoutParams failed, return default params", e, false);
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public void setNoNetworkTip(String r100) {
        this.f218574m.setTip(r100);
    }

    public void setSecretBannerClick(SecretSetBannerView.b r100) {
        this.f218579r.setClick(r100);
    }

    public void setTemplateClick(TemplateTagTipsView.e r100) {
        this.f218575n.setClick(r100);
    }

    public void setTemplateTagTitle(TemplateTagTipsView.d r100) {
        this.f218575n.setTagTitle(r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return generateLayoutParams(r100);
    }

    public DocTipsLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f218562a = false;
        this.f218563b = false;
        this.f218564c = false;
        this.f218565d = false;
        this.f218566e = false;
        this.f218567f = false;
        this.f218568g = false;
        this.f218569h = false;
        this.f218570i = false;
        this.f218571j = false;
        this.f218572k = true;
        e(r100);
    }

    public final void f(com.bytedance.ee.bear.middleground.permission.secret.o r100, boolean r101) {
        if (r100.f234123d == false) goto L12;
        setVisibility(0);
        this.f218567f = true;
        SecretSetBannerView r102 = this.f218579r;
        if (r100.f234122c == false) goto L7;
        r102.f226549l.setVisibility(0);
    L8:
        SecretSetBannerView r103 = this.f218579r;
        r103.f226555r = r100.f234121b;
        boolean r104 = r100.f234124e;
        r103.f226556s = r104;
        if (r104 == false) goto L11;
        r103.f226539b.setVisibility(8);
        r103.f226541d.setVisibility(8);
    L11:
        this.f218579r.d(r100.f234125f, r100.f234120a);
        a();
        d(new View[]{this.f218575n});
        com.bytedance.ee.bear.middleground.permission.c.O(r101);
        return;
    L7:
        r102.getClass();
        goto L8
    L12:
        this.f218567f = false;
        a();
        b();
    }

    public DocTipsLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f218562a = false;
        this.f218563b = false;
        this.f218564c = false;
        this.f218565d = false;
        this.f218566e = false;
        this.f218567f = false;
        this.f218568g = false;
        this.f218569h = false;
        this.f218570i = false;
        this.f218571j = false;
        this.f218572k = true;
        e(r100);
    }
}
