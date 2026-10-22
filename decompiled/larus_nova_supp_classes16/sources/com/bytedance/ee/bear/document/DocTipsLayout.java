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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocTipsLayout extends FrameLayout {
    public static final /* synthetic */ int u = 0;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public TipsWithConfirmView l;
    public NoNetworkView m;
    public TemplateTagTipsView n;
    public com.bytedance.ee.bear.notification.a.b o;
    public ErrorTipsView p;
    public ViewGroup q;
    public SecretSetBannerView r;
    public DLPRiskBannerView s;
    public QuotaBannerView t;

    public final void c() {
        this.c = false;
        a();
        this.o.a();
        b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        d(new View[]{this.m, this.l, this.s, this.q, this.p, this.r, this.n, this.t});
        boolean r0 = this.a;
        if (r0 == true) goto L5;
    L11:
        if (r0 == false) goto L15;
        this.m.setVisibility(0);
        return;
    L15:
        if (this.d == false) goto L19;
        this.p.setVisibility(0);
        return;
    L19:
        if (this.b == false) goto L23;
        this.l.setVisibility(0);
        return;
    L23:
        if (this.g == false) goto L29;
        if (this.h == true) goto L29;
        this.s.setVisibility(0);
        return;
    L29:
        if (this.c == false) goto L33;
        this.q.setVisibility(0);
        return;
    L33:
        if (this.f == false) goto L37;
        this.r.setVisibility(0);
        return;
    L37:
        if (this.e == false) goto L41;
        this.n.setVisibility(0);
        return;
    L41:
        if (this.i == false) goto L45;
        this.t.setVisibility(0);
        return;
    L45:
        return;
    L5:
        if (this.d == false) goto L11;
        if (this.k == false) goto L9;
        this.m.setVisibility(0);
        return;
    L9:
        this.p.setVisibility(0);
    }

    public final void b() {
        if (this.b == false) goto L5;
        return;
    L5:
        if (this.a == false) goto L7;
        return;
    L7:
        if (this.c == false) goto L9;
        return;
    L9:
        if (this.d == false) goto L11;
        return;
    L11:
        if (this.e == false) goto L13;
        return;
    L13:
        if (this.f == false) goto L15;
        return;
    L15:
        if (this.g == false) goto L17;
        return;
    L17:
        if (this.i == true) goto L27;
        setVisibility(8);
        return;
    }

    public com.bytedance.ee.bear.notification.a.b getNotificationView() {
        return this.o;
    }

    public DocTipsLayout(Context r2) {
        super(r2);
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = true;
        e(r2);
    }

    public static void d(View... r4) {
        if (r4.length != 0) goto L5;
        return;
    L5:
        int r0 = r4.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        r4[r1].setVisibility(8);
        r1 = r1 + 1;
        goto L6
    }

    public final void e(Context r3) {
        FrameLayout.inflate(r3, 2131560088, this);
        this.l = (TipsWithConfirmView) findViewById(2131363312);
        this.m = (NoNetworkView) findViewById(2131369332);
        this.n = (TemplateTagTipsView) findViewById(2131369335);
        this.q = (ViewGroup) findViewById(2131369333);
        com.bytedance.ee.bear.notification.a.b r0 = ((com.bytedance.ee.bear.notification.a) org.koin.java.a.a(com.bytedance.ee.bear.notification.a.class)).d();
        this.o = r0;
        this.q.addView(r0.e(r3));
        ErrorTipsView r4 = (ErrorTipsView) findViewById(2131371775);
        this.p = r4;
        r4.setIconButtonListener(new v1(this));
        this.r = (SecretSetBannerView) findViewById(2131385713);
        this.s = (DLPRiskBannerView) findViewById(2131369260);
        QuotaBannerView r5 = (QuotaBannerView) findViewById(2131369334);
        this.t = r5;
        r5.setIconButtonListener(new x1(this));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r4) {
        return super.generateLayoutParams(r4);
    L4:
        e = move-exception;
        tt5.a.e("DocTipsLayout", "generateLayoutParams failed, return default params", e, false);
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public void setNoNetworkTip(String r2) {
        this.m.setTip(r2);
    }

    public void setSecretBannerClick(SecretSetBannerView.b r2) {
        this.r.setClick(r2);
    }

    public void setTemplateClick(TemplateTagTipsView.e r2) {
        this.n.setClick(r2);
    }

    public void setTemplateTagTitle(TemplateTagTipsView.d r2) {
        this.n.setTagTitle(r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public DocTipsLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = true;
        e(r1);
    }

    public final void f(com.bytedance.ee.bear.middleground.permission.secret.o r6, boolean r7) {
        if (r6.d == false) goto L12;
        setVisibility(0);
        this.f = true;
        SecretSetBannerView r2 = this.r;
        if (r6.c == false) goto L7;
        r2.l.setVisibility(0);
    L8:
        SecretSetBannerView r3 = this.r;
        r3.r = r6.b;
        boolean r4 = r6.e;
        r3.s = r4;
        if (r4 == false) goto L11;
        r3.b.setVisibility(8);
        r3.d.setVisibility(8);
    L11:
        this.r.d(r6.f, r6.a);
        a();
        d(new View[]{this.n});
        com.bytedance.ee.bear.middleground.permission.c.O(r7);
        return;
    L7:
        r2.getClass();
        goto L8
    L12:
        this.f = false;
        a();
        b();
    }

    public DocTipsLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = true;
        e(r1);
    }
}
