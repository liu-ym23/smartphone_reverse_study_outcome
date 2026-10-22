package com.bytedance.android.shopping.mall.homepage.pendant.anchor;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.shopping.mall.settings.MallSettings;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/pendant/anchor/AnchorPendant;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lcom/bytedance/android/shopping/api/mall/b$a;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPendant extends RecyclerView.OnScrollListener implements com.bytedance.android.shopping.api.mall.b.a {
    public static final Lazy u = null;
    public boolean a;
    public final View b;
    public View c;
    public int d;
    public int e;
    public final b f;
    public final Lazy g;
    public final String h;
    public boolean i;
    public boolean j;
    public final Lazy k;
    public final ViewGroup l;
    public final View m;
    public final ConstraintLayout n;
    public final View o;
    public final View p;
    public final com.bytedance.android.shopping.mall.homepage.pendant.anchor.c q;
    public final com.bytedance.android.shopping.mall.homepage.pendant.anchor.b r;
    public final com.bytedance.android.shopping.api.mall.b s;
    public final Function0<Integer> t;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ViewTreeObserver.OnScrollChangedListener {
        public final /* synthetic */ AnchorPendant a;

        public b(AnchorPendant r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            AnchorPendant r0 = this.a;
            if (r0.r.d == false) goto L5;
            return;
        L5:
            View r1 = r0.c;
            int r3 = 0;
            if ((r1 instanceof RecyclerView) == false) goto L8;
            int r2 = r0.d - r0.e;
        L11:
            AnchorPendant r4 = this.a;
            r4.p.setTranslationY(r2 - r4.d);
            ECLynxCard r5 = null;
            if (this.a.p.getY() <= ((Number) this.a.t.invoke()).floatValue()) goto L23;
            float r6 = this.a.p.getY();
            Object r7 = this.a.p.getParent();
            if ((r7 instanceof View) == true) goto L16;
            r7 = null;
        L16:
            View r8 = (View) r7;
            if (r8 == null) goto L19;
            int r9 = r8.getMeasuredHeight();
        L21:
            if (r6 >= r9) goto L23;
            boolean r10 = true;
        L24:
            AnchorPendant r11 = this.a;
            if (r10 == r11.a) goto L39;
            ECLynxCard r12 = r11.r.b.b;
            if ((r12 instanceof ECLynxCard) == false) goto L30;
            r5 = r12;
        L30:
            ECLynxCard r13 = r5;
            if (r13 == null) goto L33;
            ECLynxCard.m(r13, r10, "list", "", false, false, false, 0, 248);
        L33:
            View r14 = this.a.p;
            if (r10 == true) goto L37;
            r3 = 4;
        L37:
            r14.setVisibility(r3);
            this.a.a = r10;
            return;
        L39:
            return;
        L19:
            r9 = Integer.MAX_VALUE;
        L23:
            r10 = false;
            goto L24
        L8:
            if (r1 == null) goto L10;
            r2 = r1.getTop();
            goto L11
        L10:
            r2 = 0;
            goto L11
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ AnchorPendant a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AnchorPendant r0 = this.a.a;     // Catch: Throwable -> L4
                r0.b(r0.s.a());     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(AnchorPendant r1) {
            this.a = r1;
        }

        public final void a() {
            com.bytedance.android.shopping.api.mall.b r0 = this.a.s;
            if (r0 != null) goto L5;
        L15:
            com.bytedance.android.shopping.api.mall.b r1 = this.a.s;
            if (r1 != null) goto L18;
            return;
        L18:
            if (r1.a() != true) goto L23;
            ((Handler) this.a.k.getValue()).postDelayed(new a(this), 350);
            return;
        L23:
            return;
        L5:
            if (r0.a() != true) goto L15;
            View r2 = this.a.m;
            Rect r3 = new Rect();
            r2.getGlobalVisibleRect(r3);
            if (r3.width() <= 0) goto L9;
        L12:
            boolean r4 = true;
        L13:
            if (r4 == false) goto L15;
            this.a.j();
            return;
        L9:
            if (r3.height() > 0) goto L12;
            r4 = false;
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ AnchorPendant a;

        public d(AnchorPendant r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.j();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void k() {
        int[] r1 = new int[2];
        this.o.getLocationInWindow(r1);
        int[] r0 = new int[2];
        this.m.getLocationInWindow(r0);
        int r3 = r1[0] - r0[0];
        int r2 = r1[1] - r0[1];
        View r4 = this.b;
        int r6 = this.o.getMeasuredWidth();
        if (r2 >= 0) goto L5;
        int r5 = RangesKt.coerceAtLeast(this.o.getMeasuredHeight() + r2, 1);
    L6:
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(r6, r5);
        r7.leftToLeft = 0;
        r7.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r7).leftMargin = r3;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = r2;
        Unit r8 = Unit.INSTANCE;
        r4.setLayoutParams(r7);
        return;
    L5:
        r5 = this.o.getMeasuredHeight();
        goto L6
    }

    static {
        new a();
        u = LazyKt.lazy(AnchorPendant$Companion$pendingShowEnable$2.INSTANCE);
    }

    public final String j() {
        if (this.i == true) goto L108;
        if (this.j == true) goto L108;
        Lazy r0 = u;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L16;
        com.bytedance.android.shopping.api.mall.b r1 = this.s;
        if (r1 == null) goto L16;
        if (r1.a() == true) goto L16;
        return this.h;
    L16:
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L31;
        com.bytedance.android.shopping.api.mall.b r2 = this.s;
        if (r2 == null) goto L31;
        if (r2.a() == false) goto L31;
        View r3 = this.m;
        Rect r4 = new Rect();
        r3.getGlobalVisibleRect(r4);
        if (r4.width() <= 0) goto L24;
    L27:
        boolean r5 = true;
    L28:
        if (r5 == true) goto L31;
        ((Handler) this.k.getValue()).postDelayed(new d(this), 350);
        return this.h;
    L24:
        if (r4.height() > 0) goto L27;
        r5 = false;
    L31:
        ViewParent r6 = null;
        if (this.r.d == true) goto L46;
        View r7 = t93.a.a(this.l, AnchorPendant$show$2.INSTANCE);
        this.c = r7;
        if ((r7 instanceof RecyclerView) == true) goto L36;
        r7 = null;
    L36:
        RecyclerView r8 = (RecyclerView) r7;
        if (r8 == null) goto L39;
        r8.addOnScrollListener(this);
    L39:
        View r9 = this.c;
        if ((r9 instanceof RecyclerView) == false) goto L42;
        int r10 = this.d - this.e;
    L45:
        this.d = r10;
        goto L46
    L42:
        if (r9 == null) goto L44;
        r10 = r9.getTop();
        goto L45
    L44:
        r10 = 0;
    L46:
        ViewParent r11 = this.b.getParent();
        if ((r11 instanceof ViewGroup) == true) goto L49;
        r11 = null;
    L49:
        ViewGroup r12 = (ViewGroup) r11;
        if (r12 == null) goto L52;
        r12.removeView(this.b);
    L52:
        k();
        this.n.addView(this.b);
        View r13 = this.p;
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(com.bytedance.android.ec.hybrid.tools.d.a(this.q.a), com.bytedance.android.ec.hybrid.tools.d.a(this.q.b));
        String r15 = this.q.c;
        switch(r15.hashCode()) {
            case -1383228885: goto L65;
            case 115029: goto L62;
            case 3317767: goto L59;
            case 108511772: goto L56;
            default: goto L68;
        };
    L56:
        if (r15.equals("right") == false) goto L68;
        r14.leftToRight = this.b.getId();
        goto L68
    L59:
        if (r15.equals("left") == false) goto L68;
        r14.rightToLeft = this.b.getId();
        goto L68
    L62:
        if (r15.equals("top") == false) goto L68;
        r14.bottomToTop = this.b.getId();
        goto L68
    L65:
        if (r15.equals("bottom") == false) goto L68;
        r14.topToBottom = this.b.getId();
    L68:
        if (Intrinsics.areEqual(this.q.c, "left") == false) goto L70;
    L73:
        boolean r16 = true;
    L74:
        String r17 = this.q.d;
        int r18 = r17.hashCode();
        if (r18 == 100571) goto L85;
        if (r18 == 109757538) goto L80;
    L89:
        if (r16 == false) goto L91;
        r14.topToTop = this.b.getId();
        r14.bottomToBottom = this.b.getId();
    L92:
        Number[] r19 = this.q.e;
        r14.setMargins(com.bytedance.android.ec.hybrid.tools.d.b(r19[0]), com.bytedance.android.ec.hybrid.tools.d.b(r19[1]), com.bytedance.android.ec.hybrid.tools.d.b(r19[2]), com.bytedance.android.ec.hybrid.tools.d.b(r19[3]));
        Unit r20 = Unit.INSTANCE;
        r13.setLayoutParams(r14);
        ViewParent r21 = this.p.getParent();
        if ((r21 instanceof ViewGroup) == false) goto L96;
        r6 = r21;
    L96:
        ViewGroup r22 = (ViewGroup) r6;
        if (r22 == null) goto L99;
        r22.removeView(this.p);
    L99:
        this.n.addView(this.p);
        this.o.getViewTreeObserver().addOnScrollChangedListener(this.f);
        if (MallSettings.a() == false) goto L102;
        this.o.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) this.g.getValue());
    L102:
        this.i = true;
        com.bytedance.android.shopping.api.mall.b r23 = this.s;
        if (r23 == null) goto L106;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r23.a).remove(this);
    L106:
        return this.h;
    L91:
        r14.leftToLeft = this.b.getId();
        r14.rightToRight = this.b.getId();
        goto L92
    L80:
        if (r17.equals("start") == false) goto L89;
        if (r16 == false) goto L83;
        r14.topToTop = this.b.getId();
        goto L92
    L83:
        r14.leftToLeft = this.b.getId();
        goto L92
    L85:
        if (r17.equals("end") == false) goto L89;
        if (r16 == false) goto L88;
        r14.bottomToBottom = this.b.getId();
        goto L92
    L88:
        r14.rightToRight = this.b.getId();
        goto L92
    L70:
        if (Intrinsics.areEqual(this.q.c, "right") == true) goto L73;
        r16 = false;
    L108:
        return this.h;
    }

    public final String toString() {
        return "schema = " + this.r.a;
    }

    @Override // com.bytedance.android.shopping.api.mall.b.a
    public final void b(boolean r4) {
        if (this.j == false) goto L5;
        return;
    L5:
        if (this.i == true) goto L10;
        if (r4 == false) goto L11;
        ((Handler) this.k.getValue()).postDelayed(new c(this), 350);
        return;
    L11:
        return;
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        this.e += r4;
    }

    public AnchorPendant(ViewGroup r2, View r3, ConstraintLayout r4, View r5, View r6, com.bytedance.android.shopping.mall.homepage.pendant.anchor.c r7, com.bytedance.android.shopping.mall.homepage.pendant.anchor.b r8, com.bytedance.android.shopping.api.mall.b r9, Function0<Integer> r10) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "pendantContainer");
        Intrinsics.checkNotNullParameter(r4, "internalPendantContainer");
        Intrinsics.checkNotNullParameter(r5, "anchor");
        Intrinsics.checkNotNullParameter(r6, "pendant");
        Intrinsics.checkNotNullParameter(r7, "layout");
        Intrinsics.checkNotNullParameter(r8, "extra");
        Intrinsics.checkNotNullParameter(r10, "instantTopBoundaryGetter");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.p = r6;
        this.q = r7;
        this.r = r8;
        this.s = r9;
        this.t = r10;
        this.a = true;
        View r11 = new View(r4.getContext());
        r11.setId(r11.hashCode());
        Unit r12 = Unit.INSTANCE;
        this.b = r11;
        this.f = new b(this);
        this.g = LazyKt.lazy(new AnchorPendant$anchorAttachStateChangeListener$2(this));
        this.h = UUID.randomUUID().toString();
        this.k = LazyKt.lazy(AnchorPendant$mainHandler$2.INSTANCE);
        if (r9 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r9.a).add(this);
        return;
    }
}
