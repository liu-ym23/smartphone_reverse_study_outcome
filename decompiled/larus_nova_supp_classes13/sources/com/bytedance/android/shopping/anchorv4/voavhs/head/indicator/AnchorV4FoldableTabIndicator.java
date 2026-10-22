package com.bytedance.android.shopping.anchorv4.voavhs.head.indicator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import c63.d;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import f83.i;
import f83.l;
import f83.m;
import f83.n;
import f83.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/indicator/AnchorV4FoldableTabIndicator;", "Landroid/widget/FrameLayout;", "Lf83/l;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getFindSameElement", "Lf83/p;", "m", "Lf83/p;", "getTabLogicInterceptor", "()Lf83/p;", "tabLogicInterceptor", "Lc63/d;", "n", "Lc63/d;", "getLogAction", "()Lc63/d;", "logAction", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FoldableTabIndicator extends FrameLayout implements l {
    public static final /* synthetic */ int p = 0;
    public final LinearLayout a;
    public final LinearLayout b;
    public final View c;
    public final View d;
    public final List<n> e;
    public TextView f;
    public TextView g;
    public String h;
    public final List<String> i;
    public boolean j;
    public int k;
    public String l;
    public final p m;
    public final d n;
    public final m o;

    public static final class a {
        public a() {
        }

        public static TextView a(Context r3, String r4) {
            int r0 = AnchorV4FoldableTabIndicator.p;
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "textValue");
            TextView r1 = new TextView(r3);
            int r5 = (int) UIUtils.dip2Px(r1.getContext(), 8.0f);
            int r2 = (int) UIUtils.dip2Px(r1.getContext(), 2.0f);
            r1.setTextSize(10.0f);
            r1.setTypeface(Typeface.DEFAULT_BOLD);
            r1.setTextColor(-1);
            r1.setPadding(r5, r2, r5, r2);
            r1.setText(r4);
            r1.setGravity(17);
            return r1;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AnchorV4FoldableTabIndicator a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void a() {
                View r0 = this.a.a.c;
                ViewGroup.LayoutParams r1 = r0.getLayoutParams();
                r1.width = this.a.b.getWidth();
                r1.height = this.a.b.getHeight();
                Unit r2 = Unit.INSTANCE;
                r0.setLayoutParams(r1);
                b r3 = this.a;
                if (r3.c <= 0) goto L11;
                View r4 = r3.a.c;
                ViewGroup.LayoutParams r5 = r4.getLayoutParams();
                if ((r5 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
                r5 = null;
            L7:
                ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
                if (r6 == null) goto L12;
                r6.leftMargin = this.a.b.getLeft();
                r4.setLayoutParams(r6);
                return;
            L12:
                return;
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

        public b(AnchorV4FoldableTabIndicator r1, View r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.post(new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ AnchorV4FoldableTabIndicator a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;

        public c(AnchorV4FoldableTabIndicator r1, View r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r6) {
            Object r7 = r6.getAnimatedValue();
            if (r7 == null) goto L13;
            float r8 = ((Float) r7).floatValue();
            View r0 = this.a.c;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
            r1 = null;
        L7:
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
            if (r2 == null) goto L10;
            r2.leftMargin = (int) (this.b.getLeft() + ((this.c.getLeft() - this.b.getLeft()) * r8));
            r0.setLayoutParams(r2);
        L10:
            View r3 = this.a.c;
            ViewGroup.LayoutParams r4 = r3.getLayoutParams();
            r4.width = (int) (this.b.getWidth() + ((this.c.getWidth() - this.b.getWidth()) * r8));
            r4.height = com.bytedance.android.shopping.extensions.b.b(20);
            Unit r9 = Unit.INSTANCE;
            r3.setLayoutParams(r4);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
        new a();
    }

    public AnchorV4FoldableTabIndicator(Context r10) {
        this(r10, null, 0, null, null, false, null, 254);
    }

    public AnchorV4FoldableTabIndicator(Context r10, AttributeSet r11) {
        this(r10, r11, 0, null, null, false, null, 252);
    }

    public AnchorV4FoldableTabIndicator(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, null, null, false, null, 248);
    }

    @Override // f83.l
    public final void a(boolean r1) {
    }

    @Override // f83.l
    public final void c(List<String> r2, List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r2, "titleTags");
        Intrinsics.checkNotNullParameter(r3, "originTags");
        Intrinsics.checkNotNullParameter(r4, "tabTypes");
    }

    @Override // f83.l
    public CommonFindSameElement getFindSameElement() {
        return null;
    }

    public final d getLogAction() {
        return this.n;
    }

    public final p getTabLogicInterceptor() {
        return this.m;
    }

    @Override // f83.l
    public final void h(boolean r1) {
        wg.a.h(this, r1);
    }

    public final void d(int r10, String r11, boolean r12) {
        n r0 = (n) CollectionsKt.getOrNull(this.e, r10);
        View r1 = null;
        if (r0 == null) goto L8;
        boolean r4 = r0.a;
        boolean r5 = r0.b;
        m r2 = this.o;
        if (r2 == null) goto L7;
        r2.b(r10, r4, r5, r11, r12, r0.e);
    L7:
        r0.a = false;
    L9:
        Iterator<T> r13 = this.e.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Object r3 = r13.next();
        if (((n) r3).c.isSelected() == false) goto L11;
    L16:
        n r6 = (n) r3;
        if (r6 == null) goto L19;
        r1 = r6.c;
    L19:
        n r14 = (n) CollectionsKt.getOrNull(this.e, r10);
        if (r14 == null) goto L32;
        View r15 = r14.c;
        if (r15 == null) goto L37;
        if (r12 == false) goto L26;
        r15.post(new b(this, r15, r10));
    L28:
        Iterator<T> r16 = this.e.iterator();
    L30:
        if (r16.hasNext() == false) goto L38;
        n r17 = (n) r16.next();
        r17.c.setSelected(Intrinsics.areEqual(r0, r17));
        goto L30
    L38:
        return;
    L26:
        if (r1 == null) goto L28;
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(250);
        r18.addUpdateListener(new c(this, r1, r15));
        r18.start();
        goto L28
    L37:
        return;
    L32:
        return;
    L15:
        r3 = null;
        goto L16
    L8:
        r0 = null;
        goto L9
    }

    @Override // f83.l
    public final void b(Integer r10, int r11, String r12, boolean r13) {
        int r0 = -1;
        if (r10 == null) goto L8;
        d(r10.intValue(), r12, r13);
        if (this.k == r10.intValue()) goto L7;
        r0 = this.k;
    L7:
        this.k = r10.intValue();
    L8:
        this.l = r12;
        List<String> r14 = this.i;
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L14;
        Object r17 = r16.next();
        if (Intrinsics.areEqual((String) r17, (String) ListProtector.get(this.i, r11)) == false) goto L10;
        r15.add(r17);
        goto L10
    L14:
        int r18 = r15.size();
        boolean r19 = true;
        if (r18 <= 1) goto L17;
        boolean r1 = true;
    L18:
        String r3 = "";
        if (this.j == false) goto L21;
        String r2 = "";
    L22:
        int r4 = ((ArrayList) this.i).indexOf(r2);
        if (r4 >= 0) goto L25;
        r4 = 0;
    L25:
        int r5 = r11 - r4;
        TextView r6 = this.f;
        if (r1 == false) goto L28;
        String r7 = j.e(2131914060, Integer.valueOf(r5 + 1), Integer.valueOf(r18));
    L29:
        r6.setText(Intrinsics.stringPlus(r2, r7));
        if (r11 > ((ArrayList) this.i).lastIndexOf(this.h)) goto L32;
        this.g.setText(this.h + j.e(2131914060, Integer.valueOf(r11 + 1), Integer.valueOf(r18)));
    L32:
        Object r110 = CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(this.b), r0);
        Object r8 = null;
        if ((r110 instanceof TextView) == true) goto L35;
        r110 = null;
    L35:
        TextView r111 = (TextView) r110;
        if (r111 == null) goto L42;
        n r9 = (n) CollectionsKt.getOrNull(this.e, r0);
        if (r9 == null) goto L40;
        String r20 = r9.d;
    L41:
        r111.setText(r20);
        goto L42
    L40:
        r20 = null;
    L42:
        Object r112 = CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(this.b), this.k);
        if ((r112 instanceof TextView) == false) goto L46;
        r8 = r112;
    L46:
        TextView r21 = (TextView) r8;
        if (r21 == null) goto L51;
        if (r1 == false) goto L50;
        r3 = j.e(2131914060, Integer.valueOf(r5 + 1), Integer.valueOf(r18));
    L50:
        r21.setText(Intrinsics.stringPlus(r2, r3));
    L51:
        CharSequence r113 = this.f.getText();
        if (r113 != null) goto L54;
    L57:
        if (r19 == false) goto L59;
        this.f.setVisibility(8);
        return;
    L59:
        this.f.setVisibility(0);
        return;
    L54:
        if (r113.length() == 0) goto L57;
        r19 = false;
        goto L57
    L28:
        r7 = "";
        goto L29
    L21:
        r2 = (String) ListProtector.get(this.i, r11);
        goto L22
    L17:
        r1 = false;
        goto L18
    }

    public AnchorV4FoldableTabIndicator(Context r4, AttributeSet r5, int r6, p r7, d r8, boolean r9, i r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r11 & 4) == 0) goto L9;
        r6 = 0;
    L9:
        if ((r11 & 8) == 0) goto L12;
        r7 = null;
    L12:
        if ((r11 & 16) == 0) goto L15;
        r8 = null;
    L15:
        if ((r11 & 64) == 0) goto L18;
        r9 = false;
    L18:
        if ((r11 & 128) == 0) goto L20;
        r10 = null;
    L20:
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.m = r7;
        this.n = r8;
        this.o = r10;
        this.e = new ArrayList();
        this.f = new TextView(r4);
        this.g = new TextView(r4);
        this.h = "";
        this.i = new ArrayList();
        this.k = -1;
        this.l = "";
        new ArrayList();
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r4).aU(2131564608, this, true);
        LinearLayout r12 = (LinearLayout) findViewById(2131374256);
        this.a = r12;
        LinearLayout r13 = (LinearLayout) findViewById(2131374255);
        this.b = r13;
        View r14 = findViewById(2131374265);
        this.d = r14;
        r13.setVisibility(8);
        r12.setVisibility(0);
        View r15 = findViewById(2131374257);
        this.c = r15;
        ViewGroup.LayoutParams r16 = r14.getLayoutParams();
        r16.height = com.bytedance.android.shopping.extensions.b.b(20);
        Unit r0 = Unit.INSTANCE;
        r14.setLayoutParams(r16);
        r14.setBackgroundDrawable(ag4.a.c(2131233415));
        ViewGroup.LayoutParams r17 = r15.getLayoutParams();
        r17.height = com.bytedance.android.shopping.extensions.b.b(20);
        r15.setLayoutParams(r17);
        r15.setBackgroundDrawable(ag4.a.c(2131231273));
        if (r9 == false) goto L23;
        r12.setVisibility(8);
        r13.setVisibility(0);
    L23:
        addOnAttachStateChangeListener(new f83.c(this));
    }
}
