package com.bytedance.android.shopping.anchorv4.voavhs.head.indicator;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.anchorv4.experiment.d;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import f83.m;
import f83.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/indicator/AnchorV4TabIndicator;", "Landroid/widget/FrameLayout;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4TabIndicator extends FrameLayout {
    public final List<n> a;
    public final LinearLayout b;
    public final View c;
    public final View d;
    public final m e;

    public static final class a implements Runnable {
        public final /* synthetic */ AnchorV4TabIndicator a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4TabIndicator$a$a, reason: collision with other inner class name */
        public static final class RunnableC0009a implements Runnable {
            public final /* synthetic */ a a;

            public RunnableC0009a(a r1) {
                this.a = r1;
            }

            public final void a() {
                View r0 = this.a.a.c;
                ViewGroup.LayoutParams r1 = r0.getLayoutParams();
                r1.width = this.a.b.getWidth();
                r1.height = this.a.b.getHeight();
                Unit r2 = Unit.INSTANCE;
                r0.setLayoutParams(r1);
                a r3 = this.a;
                if (r3.c <= 0) goto L11;
                int r4 = r3.b.getLeft();
                View r5 = this.a.a.c;
                ViewGroup.LayoutParams r6 = r5.getLayoutParams();
                if ((r6 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
                r6 = null;
            L7:
                ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
                if (r7 == null) goto L12;
                r7.leftMargin = r4;
                r5.setLayoutParams(r7);
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

        public a(AnchorV4TabIndicator r1, View r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c.post(new RunnableC0009a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ AnchorV4TabIndicator a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;

        public b(AnchorV4TabIndicator r1, View r2, View r3) {
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
            r4.height = com.bytedance.android.shopping.extensions.b.b(24);
            Unit r9 = Unit.INSTANCE;
            r3.setLayoutParams(r4);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ n a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AnchorV4TabIndicator c;

        public c(n r1, int r2, AnchorV4TabIndicator r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.a = true;
            m r3 = this.c.e;
            if (r3 == null) goto L6;
            r3.a(this.b);
            return;
        }
    }

    public AnchorV4TabIndicator(Context r7) {
        this(r7, null, 0, null, 30);
    }

    public AnchorV4TabIndicator(Context r7, AttributeSet r8) {
        this(r7, r8, 0, null, 28);
    }

    public AnchorV4TabIndicator(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, null, 24);
    }

    public final void b(List<String> r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r11, "indicatorTags");
        Intrinsics.checkNotNullParameter(r12, "tabTypes");
        this.b.removeAllViews();
        ((ArrayList) this.a).clear();
        Iterator<T> r13 = r11.iterator();
        int r1 = 0;
    L4:
        if (r13.hasNext() == false) goto L13;
        Object r2 = r13.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r3 = (String) r2;
        TextView r6 = new TextView(getContext());
        ColorStateList r5 = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{-16777216, -1});
        float r7 = 10.0f;
        int r8 = (int) UIUtils.dip2Px(r6.getContext(), 10.0f);
        int r9 = (int) UIUtils.dip2Px(r6.getContext(), 2.5f);
        if (d.a() == true) goto L12;
        r7 = 12.0f;
    L12:
        r6.setTextSize(r7);
        r6.setTypeface(Typeface.DEFAULT_BOLD);
        r6.setTextColor(r5);
        r6.setPadding(r8, r9, r8, r9);
        r6.setText(r3);
        r6.setGravity(17);
        n r10 = new n(r6, r3, null);
        r6.setOnClickListener(new c(r10, r1, this));
        this.b.addView(r6, new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(24)));
        ((ArrayList) this.a).add(r10);
        r1 = r4;
        goto L4
    L13:
        a(0, (String) CollectionsKt.getOrNull(r12, 0), true);
    }

    public final void a(int r10, String r11, boolean r12) {
        n r0 = (n) CollectionsKt.getOrNull(this.a, r10);
        View r1 = null;
        if (r0 == null) goto L8;
        boolean r4 = r0.a;
        boolean r5 = r0.b;
        m r2 = this.e;
        if (r2 == null) goto L7;
        r2.b(r10, r4, r5, r11, r12, null);
    L7:
        r0.a = false;
    L9:
        Iterator<T> r13 = this.a.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Object r3 = r13.next();
        if (((n) r3).c.isSelected() == false) goto L11;
    L16:
        n r6 = (n) r3;
        if (r6 == null) goto L19;
        r1 = r6.c;
    L19:
        n r14 = (n) CollectionsKt.getOrNull(this.a, r10);
        if (r14 == null) goto L35;
        View r15 = r14.c;
        if (r15 != null) goto L25;
        return;
    L25:
        if (Intrinsics.areEqual(r1, r15) == false) goto L27;
        return;
    L27:
        if (r12 == false) goto L29;
        r15.post(new a(this, r15, r10));
    L31:
        Iterator<T> r16 = this.a.iterator();
    L33:
        if (r16.hasNext() == false) goto L41;
        n r17 = (n) r16.next();
        r17.c.setSelected(Intrinsics.areEqual(r0, r17));
        goto L33
    L41:
        return;
    L29:
        if (r1 == null) goto L31;
        ValueAnimator r18 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(250);
        r18.addUpdateListener(new b(this, r1, r15));
        r18.start();
        goto L31
    L35:
        return;
    L15:
        r3 = null;
        goto L16
    L8:
        r0 = null;
        goto L9
    }

    public AnchorV4TabIndicator(Context r3, AttributeSet r4, int r5, m r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.e = r6;
        this.a = new ArrayList();
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(2131564608, this, true);
        View r8 = findViewById(2131374265);
        this.d = r8;
        LinearLayout r9 = (LinearLayout) findViewById(2131374255);
        this.b = r9;
        View r10 = findViewById(2131374257);
        this.c = r10;
        if (d.a() == false) goto L15;
        ViewGroup.LayoutParams r11 = r9.getLayoutParams();
        r11.height = com.bytedance.android.shopping.extensions.b.b(20);
        Unit r0 = Unit.INSTANCE;
        r9.setLayoutParams(r11);
        ViewGroup.LayoutParams r12 = r8.getLayoutParams();
        r12.height = com.bytedance.android.shopping.extensions.b.b(20);
        r8.setLayoutParams(r12);
        r8.setBackgroundDrawable(ag4.a.c(2131233415));
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        r13.height = com.bytedance.android.shopping.extensions.b.b(24);
        r10.setLayoutParams(r13);
        r10.setBackgroundDrawable(ag4.a.c(2131231273));
        return;
    }
}
