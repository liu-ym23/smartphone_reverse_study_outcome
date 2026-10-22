package com.bytedance.ee.bear.drive.biz.preview.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.fragment.i;
import com.bytedance.ee.bear.facade.common.widget.DLPRiskBannerView;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView;
import com.bytedance.ee.bear.middleground.permission.secret.o;
import com.bytedance.ee.drive.preview.f;
import com.bytedance.ee.drive.render.j;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.ss.android.lark.utils.LarkContext;
import i75.h;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final UDNotice f;
    public final SecretSetBannerView g;
    public final DLPRiskBannerView h;
    public final LinearLayout i;
    public final FrameLayout j;
    public final ForbiddenBannerView k;
    public final DriveCustomBannerContainer l;
    public final LinkedList<b> m;
    public b n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public DrivePluginHost s;
    public final Context t;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.banner.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0134a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0134a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.f();
            this.a.b();
        }
    }

    public static final class b {
        public final UDNotice.Type a;
        public final int b;
        public final String c;
        public final boolean d;
        public final int e;
        public final boolean f;
        public final String g;
        public final View.OnClickListener h;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
            int r2 = 1231;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((r0 + r1) * 31) + this.e) * 31;
            if (this.f == true) goto L10;
            r2 = 1237;
        L10:
            int r4 = (r3 + r2) * 31;
            String r5 = this.g;
            int r6 = 0;
            if (r5 != null) goto L13;
            int r7 = 0;
        L14:
            int r8 = (r4 + r7) * 31;
            View.OnClickListener r9 = this.h;
            if (r9 == null) goto L19;
            r6 = r9.hashCode();
        L19:
            return r8 + r6;
        L13:
            r7 = r5.hashCode();
            goto L14
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Notice(type=" + this.a + ", drawableRes=" + this.b + ", tips=" + this.c + ", showClose=" + this.d + ", id=" + this.e + ", overlay=" + this.f + ", clickText=" + this.g + ", clickListener=" + this.h + ')';
        }

        public final UDNotice.Type getType() {
            return this.a;
        }

        public /* synthetic */ b(UDNotice.Type r10, String r11) {
            this(r10, 2131256187, r11, false, 0, false, null, null);
        }

        public b(UDNotice.Type r2, int r3, String r4, boolean r5, int r6, boolean r7, String r8, View.OnClickListener r9) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r4, "tips");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    public final void b() {
        UDNotice r0 = this.f;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        DLPRiskBannerView r1 = this.h;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        UDNotice r2 = this.k;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        SecretSetBannerView r3 = this.g;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
    L14:
        c();
        if (this.a == false) goto L70;
        if (this.n != null) goto L21;
        if (this.m.size() <= 0) goto L70;
    L21:
        if (this.n != null) goto L23;
        f();
    L23:
        b r4 = this.n;
        if (r4 == null) goto L70;
        Intrinsics.checkNotNull(r4);
        UDNotice r5 = this.f;
        if (r5 != null) goto L28;
    L30:
        boolean r6 = false;
    L31:
        if (r6 == true) goto L35;
        UDNotice r7 = this.f;
        if (r7 == null) goto L35;
        r7.setVisibility(0);
    L35:
        UDNotice r8 = this.f;
        if (r8 == null) goto L39;
        r8.setType(r4.getType());
    L39:
        if (TextUtils.isEmpty(r4.g) == false) goto L41;
    L51:
        UDNotice r9 = this.f;
        if (r9 == null) goto L54;
        r9.setText(r4.c);
    L54:
        UDNotice r10 = this.f;
        if (r10 == null) goto L58;
        r10.setIcon(r4.b);
    L58:
        if (r4.d == false) goto L65;
        UDNotice r11 = this.f;
        if (r11 == null) goto L62;
        r11.i6(true);
    L62:
        UDNotice r12 = this.f;
        if (r12 == null) goto L91;
        r12.setIconButton(2131254124);
        return;
    L91:
        return;
    L65:
        UDNotice r13 = this.f;
        if (r13 == null) goto L93;
        r13.i6(false);
        return;
    L93:
        return;
    L41:
        if (r4.h == null) goto L51;
        String r14 = r4.c + r4.g;
        UDNotice r16 = this.f;
        if (r16 == null) goto L89;
        r16.setText(r14);
    L89:
        UDNotice r17 = this.f;     // Catch: Exception -> L49
        if (r17 == null) goto L54;
        r17.S5(r4.c.length(), r14.length(), new d(r4, this));     // Catch: Exception -> L49
        Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L49
    L49:
        e = move-exception;
        tt5.a.f("DriveComponent", e, false);
        Unit r19 = Unit.INSTANCE;
        goto L54
    L28:
        if (r5.getVisibility() != 0) goto L30;
        r6 = true;
    L70:
        if (this.c == false) goto L78;
        if (this.d == true) goto L78;
        DLPRiskBannerView r20 = this.h;
        if (r20 == null) goto L94;
        r20.setVisibility(0);
        return;
    L94:
        return;
    L78:
        if (this.e == false) goto L84;
        UDNotice r21 = this.k;
        if (r21 == null) goto L95;
        r21.setVisibility(0);
        return;
    L95:
        return;
    L84:
        if (this.b == false) goto L96;
        SecretSetBannerView r22 = this.g;
        if (r22 == null) goto L97;
        r22.setVisibility(0);
        return;
    L97:
        return;
    }

    public final void c() {
        LinearLayout r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        FrameLayout r1 = this.j;
        if (r1 != null) goto L8;
        return;
    L8:
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        ConstraintLayout.LayoutParams r4 = null;
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L11;
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r2;
    L12:
        if (r3 != null) goto L14;
        return;
    L14:
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L17;
        r4 = (ConstraintLayout.LayoutParams) r5;
    L17:
        if (r4 != null) goto L20;
        return;
    L20:
        if (e() == true) goto L22;
    L24:
        boolean r6 = false;
    L26:
        if (r6 == false) goto L28;
        ((ViewGroup.MarginLayoutParams) r3).topMargin = (this.q + this.p) + this.r;
        r4.topToTop = 0;
        r4.topToBottom = -1;
        r0.bringToFront();
    L29:
        r0.setLayoutParams(r3);
        r1.setLayoutParams(r4);
        return;
    L28:
        ((ViewGroup.MarginLayoutParams) r3).topMargin = this.r;
        r4.topToTop = -1;
        r4.topToBottom = r0.getId();
        goto L29
    L22:
        if (this.o == true) goto L24;
        r6 = true;
        goto L26
    L11:
        r3 = null;
        goto L12
    }

    public final boolean e() {
        DrivePluginHost r0 = this.s;
        if (r0 == null) goto L15;
        Context r1 = r0.a.getContext();
        int r2 = i.a;
        j r3 = null;
        f r4 = (f) org.koin.java.a.c(f.class, null, null, 6);     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = LarkContext.getApplication();     // Catch: Throwable -> L10
    L8:
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L10
        r3 = r4.U4(r1);     // Catch: Throwable -> L10
    L13:
        if (i.a(r0, r3) != true) goto L15;
        return true;
    L10:
        th = move-exception;
        tt5.a.l("DRIVE_CACHE_FLOW", "media immersive openStrategy resolve failed", th);
    L15:
        return false;
    }

    public final void f() {
        b r0 = this.m.poll();
        this.n = r0;
        if (r0 != null) goto L8;
        UDNotice r1 = this.f;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    L9:
        return;
    }

    public final void a(b r14) {
        boolean r0 = true;
        this.a = true;
        if (r14.f == false) goto L18;
        b r1 = this.n;
        if (r1 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L12;
        return;
    L12:
        Iterator<b> r3 = this.m.iterator();
    L14:
        if (r3.hasNext() == false) goto L18;
        if (r3.next().e != r14.e) goto L14;
        return;
    L7:
        if (r1.e != r14.e) goto L9;
        r2 = true;
    L18:
        this.m.add(new b(r14.getType(), r14.b, r14.c, r14.d, r14.e, r14.f, r14.g, r14.h));
        UDNotice r16 = this.f;
        if (r16 != null) goto L21;
    L23:
        r0 = false;
    L24:
        if (r0 == true) goto L30;
        f();
        b();
        return;
    L30:
        return;
    L21:
        if (r16.getVisibility() != 0) goto L23;
        goto L23
    }

    public a(t r5, Context r6) {
        Intrinsics.checkNotNullParameter(r5, "uiContainer");
        Intrinsics.checkNotNullParameter(r6, "context");
        this.m = new LinkedList();
        UDNotice r0 = r5.findView(2131370284);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larksuite.component.universe_design.notice.UDNotice");
        UDNotice r1 = r0;
        this.f = r1;
        View r2 = r5.findView(2131370323);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.facade.common.widget.SecretSetBannerView");
        this.g = (SecretSetBannerView) r2;
        View r3 = r5.findView(2131369260);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.ee.bear.facade.common.widget.DLPRiskBannerView");
        this.h = (DLPRiskBannerView) r3;
        View r4 = r5.findView(2131363934);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.i = (LinearLayout) r4;
        View r7 = r5.findView(2131370305);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.j = (FrameLayout) r7;
        ForbiddenBannerView r8 = null;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.platform.appeal_v2") == false) goto L7;
        Object r9 = r5.findView(2131373158);
        if ((r9 instanceof ForbiddenBannerView) == false) goto L10;
        r8 = (ForbiddenBannerView) r9;
    L10:
        this.k = r8;
        View r10 = r5.findView(2131370257);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ee.bear.drive.biz.preview.banner.DriveCustomBannerContainer");
        this.l = (DriveCustomBannerContainer) r10;
        this.t = r6;
        if (r1 == null) goto L14;
        r1.setIconButtonListener(new ViewOnClickListenerC0134a(this));
        return;
    L14:
        return;
    L7:
        Object r11 = r5.findView(2131373159);
        if ((r11 instanceof ForbiddenBannerView) == false) goto L10;
        r8 = (ForbiddenBannerView) r11;
        goto L10
    }

    public final void g(boolean r4, String r5) {
        SecretSetBannerView r0 = this.g;
        if (r0 == null) goto L10;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r1;
        boolean r6 = h.e(r5);
        if (this.b == false) goto L8;
        if (r4 == true) goto L8;
        r0.setVisibility(0);
        d(r2, r6, false);
        return;
    L8:
        r0.setVisibility(8);
        d(r2, r6, r4);
        return;
    }

    public final void h(String r4, o r5) {
        Intrinsics.checkNotNullParameter(r4, "extension");
        Intrinsics.checkNotNullParameter(r5, "params");
        boolean r0 = r5.d;
        this.b = r0;
        if (r0 == false) goto L20;
        SecretSetBannerView r1 = this.g;
        if (r1 != null) goto L7;
    L9:
        SecretSetBannerView r2 = this.g;
        if (r2 == null) goto L14;
        boolean r3 = r5.e;
        r2.s = r3;
        if (r3 == false) goto L14;
        r2.b.setVisibility(8);
        r2.d.setVisibility(8);
    L14:
        SecretSetBannerView r6 = this.g;
        if (r6 == null) goto L17;
        r6.r = r5.b;
    L17:
        if (r6 == null) goto L19;
        r6.d(r5.f, r5.a);
    L19:
        g(this.o, r4);
        goto L20
    L7:
        if (r5.c == false) goto L9;
        r1.l.setVisibility(0);
    L20:
        b();
    }

    public final void d(LinearLayout.LayoutParams r3, boolean r4, boolean r5) {
        int r1 = 0;
        if (e() == false) goto L6;
        if (r5 == true) goto L6;
        boolean r0 = true;
    L7:
        c();
        if (r0 == true) goto L12;
        if (r4 == false) goto L12;
        if (r5 == true) goto L12;
        r1 = this.p;
    L12:
        r3.topMargin = r1;
        return;
    L6:
        r0 = false;
        goto L7
    }
}
