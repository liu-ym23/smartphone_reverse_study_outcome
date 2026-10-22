package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003!\"#B%\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0015¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECStoreCollapsibleTextView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/store/home/view/ECStoreCollapsibleTextView$c;", "creator", "", "setComponentCreator", "Lcom/bytedance/android/shopping/store/home/view/ECStoreCollapsibleTextView$b;", "config", "setStyleConfig", "Landroid/view/View$OnClickListener;", "listener", "setSearchCameraClickListener", "setSearchTextViewListener", "", "enable", "setCollapseEnable", "", "colors", "setStrokeColor", "able", "setSearchIconAlphaChangeAble", "", "size", "setSearchIconSize", ScrollPosition.POSITION_LEFT, "setSearchIconMargin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreCollapsibleTextView extends LinearLayout {
    public static final int o = 0;
    public static final int p = 0;
    public static final int q = 0;
    public static final int r = 0;
    public static final int s = 0;
    public static final float t = 0.0f;
    public boolean a;
    public b b;
    public SimpleDraweeView c;
    public ImageView d;
    public boolean e;
    public View f;
    public TextView g;
    public View h;
    public float i;
    public boolean j;
    public int k;
    public int l;
    public com.bytedance.android.ec.store.view.q m;
    public c n;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public Integer e;
        public Integer f;
        public Drawable g;
        public Drawable h;
        public final Integer i;
        public final Integer j;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L26;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.j, r4.j) == true) goto L40;
            return false;
        L40:
            return true;
        L26:
            return false;
        }

        public final int hashCode() {
            int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
            Integer r1 = this.e;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.f;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (r4 + r6) * 31;
            Drawable r8 = this.g;
            if (r8 == null) goto L13;
            int r9 = r8.hashCode();
        L14:
            int r10 = (r7 + r9) * 31;
            Drawable r11 = this.h;
            if (r11 == null) goto L17;
            int r12 = r11.hashCode();
        L18:
            int r13 = (r10 + r12) * 31;
            Integer r14 = this.i;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            Integer r17 = this.j;
            if (r17 == null) goto L26;
            r2 = r17.hashCode();
        L26:
            return r16 + r2;
        L21:
            r15 = 0;
            goto L22
        L17:
            r12 = 0;
            goto L18
        L13:
            r9 = 0;
            goto L14
        L9:
            r6 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "GradientColorConfig(fullyExpandBackgroundColor=" + this.a + ", fullyCollapseBackgroundColor=" + this.b + ", fullyExpandTextColor=" + this.c + ", fullyCollapseTextColor=" + this.d + ", fullyExpandSearchTextColor=" + this.e + ", fullyCollapseSearchTextColor=" + this.f + ", fullyExpandSearchBtnBgDrawable=" + this.g + ", fullyCollapseSearchBtnBgDrawable=" + this.h + ", fullyExpandSearchIconColor=" + this.i + ", fullyCollapseSearchIconColor=" + this.j + ")";
        }

        public b(int r1, int r2, int r3, int r4, Integer r5, Integer r6, Integer r7, Integer r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = null;
            this.h = null;
            this.i = r7;
            this.j = r8;
        }
    }

    public interface c {
        void a(ECStoreCollapsibleTextView r1, int r2);

        Drawable b();

        TextView c(ECStoreCollapsibleTextView r1);

        View d(ECStoreCollapsibleTextView r1);
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ECStoreCollapsibleTextView a;

        public d(ECStoreCollapsibleTextView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECStoreCollapsibleTextView r0 = this.a;     // Catch: Throwable -> L4
            r0.e(r0.i);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        o = com.bytedance.android.shopping.extensions.b.b(12);
        p = com.bytedance.android.shopping.extensions.b.b(4);
        q = com.bytedance.android.shopping.extensions.b.b(8);
        r = com.bytedance.android.shopping.extensions.b.b(16);
        s = com.bytedance.android.shopping.extensions.b.b(16);
        t = com.bytedance.android.ec.core.utils.q.a(Double.valueOf(1.5d));
    }

    public final void d() {
        removeAllViews();
        setOrientation(0);
        this.c = new SimpleDraweeView(getContext());
        int r1 = s;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(r1, r1);
        int r2 = o;
        int r3 = q;
        r0.setMargins(r2, r3, p, r3);
        addView(this.c, r0);
        c r4 = this.n;
        if (r4 == null) goto L6;
        View r5 = r4.d(this);
        if (r5 == null) goto L6;
    L7:
        this.f = r5;
        addView(r5);
        setGravity(16);
        c r6 = this.n;
        if (r6 == null) goto L11;
        Drawable r7 = r6.b();
        if (r7 == null) goto L11;
    L12:
        setBackground(r7);
        return;
    L11:
        r7 = new GradientDrawable();
    L6:
        r5 = new TextView(getContext());
        goto L7
    }

    public final void a(Integer r5) {
        if (this.h != null) goto L11;
        this.h = new View(getContext());
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), com.bytedance.android.shopping.extensions.b.b(16));
        r0.gravity = 16;
        addView(this.h, r0);
        View r1 = this.h;
        if (r1 == null) goto L12;
        if (r5 == null) goto L8;
        int r6 = r5.intValue();
    L9:
        r1.setBackgroundColor(r6);
        return;
    L8:
        r6 = 521541667;
        goto L9
    L12:
        return;
    }

    public final void e(float r6) {
        this.i = r6;
        com.bytedance.android.ec.store.view.q r0 = this.m;
        Drawable r1 = null;
        if (r0 != null) goto L12;
        if (r0 == null) goto L6;
        r0.a(r6);
    L6:
        View r2 = this.f;
        if ((r2 instanceof TextView) == true) goto L9;
        r2 = null;
    L9:
        TextView r3 = (TextView) r2;
        if (r3 == null) goto L12;
        r3.setText(this.m);
    L12:
        b r4 = this.b;
        if (r4 == null) goto L23;
        Integer r5 = r4.e;
        if (r5 == null) goto L23;
        int r7 = r5.intValue();
        Integer r8 = r4.f;
        if (r8 == null) goto L19;
        int r9 = r8.intValue();
    L20:
        int r10 = ColorUtils.blendARGB(r7, r9, this.i);
        TextView r11 = this.g;
        if (r11 == null) goto L23;
        r11.setTextColor(r10);
        goto L23
    L19:
        r9 = r7;
    L23:
        b r12 = this.b;
        if (r12 == null) goto L37;
        Integer r13 = r12.j;
        if (r13 != null) goto L28;
    L30:
        int r14 = ColorUtils.blendARGB(-15329245, -1, this.i);
    L31:
        int r15 = (int) (153 + (this.i * 102));
        SimpleDraweeView r16 = this.c;
        if (r16 == null) goto L36;
        r16.setColorFilter(r14);
        if (this.a == false) goto L36;
        r16.setAlpha(r15);
    L36:
        invalidate();
        goto L37
    L28:
        if (r12.i == null) goto L30;
        Intrinsics.checkNotNull(r13);
        int r17 = r13.intValue();
        Integer r18 = r12.i;
        Intrinsics.checkNotNull(r18);
        r14 = ColorUtils.blendARGB(r17, r18.intValue(), this.i);
    L37:
        b r19 = this.b;
        if (r19 == null) goto L51;
        if (this.j == false) goto L42;
        int r20 = r19.b & 16777215;
    L43:
        this.l = ColorUtils.blendARGB(r19.a, r20, this.i);
        Drawable r21 = getBackground();
        if ((r21 instanceof GradientDrawable) == false) goto L47;
        r1 = r21;
    L47:
        GradientDrawable r22 = (GradientDrawable) r1;
        if (r22 == null) goto L51;
        r22.setColor(this.l);
        goto L51
    L42:
        r20 = r19.b;
    L51:
        if (this.j == true) goto L53;
        return;
    L53:
        if (ECStoreFoldPhoneHelper.d() == false) goto L56;
        requestLayout();
    L59:
        g(r6);
        return;
    L56:
        if (this.k <= 0) goto L59;
        ViewGroup.LayoutParams r23 = getLayoutParams();
        int r24 = RangesKt.coerceAtLeast(0, getMeasuredHeight());
        int r25 = this.k;
        r23.width = (int) (r24 + ((1 - this.i) * (r25 - r24)));
        r23.height = getMeasuredHeight();
        setLayoutParams(r23);
        goto L59
    }

    public final void f(float r7) {
        float r8 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r7, 0.0f), 1.0f);
        TextView r0 = this.g;
        if (r0 == null) goto L11;
        r0.setVisibility(0);
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        LinearLayout.LayoutParams r4 = null;
        if ((r2 instanceof LinearLayout.LayoutParams) == true) goto L7;
        r2 = null;
    L7:
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2;
        if (r3 == null) goto L10;
        int r5 = com.bytedance.android.shopping.extensions.b.b(4);
        r3.setMargins(0, 0, (int) (r5 + (r8 * (com.bytedance.android.shopping.extensions.b.b(2) - r5))), 0);
        Unit r9 = Unit.INSTANCE;
        r4 = r3;
    L10:
        r0.setLayoutParams(r4);
    L11:
        requestLayout();
    }

    public final void g(float r5) {
        SimpleDraweeView r0 = this.c;
        if (r0 == null) goto L6;
        int r1 = r;
        float r2 = r1;
        int r6 = (int) (r2 + (r5 * (((int) (1.5f * r2)) - r1)));
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        r3.width = r6;
        r3.height = r6;
        r0.setLayoutParams(r3);
        return;
    }

    public final void h(float r6) {
        if (r6 <= 0.2d) goto L10;
        ImageView r0 = this.d;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        View r1 = this.h;
        if (r1 == null) goto L16;
        r1.setVisibility(0);
    L16:
        ImageView r2 = this.d;
        if (r2 == null) goto L19;
        r2.setAlpha(r6);
    L19:
        View r3 = this.h;
        if (r3 == null) goto L23;
        r3.setAlpha(r6);
        return;
    L23:
        return;
    L10:
        ImageView r4 = this.d;
        if (r4 == null) goto L13;
        r4.setVisibility(8);
    L13:
        View r5 = this.h;
        if (r5 == null) goto L16;
        r5.setVisibility(8);
        goto L16
    }

    public final com.bytedance.android.ec.store.view.q i(String r6) {
        if (r6 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        r6 = "搜索本店商品";
    L10:
        com.bytedance.android.ec.store.view.q r1 = new com.bytedance.android.ec.store.view.q(r6);
        int r2 = r1.length();
        b r3 = this.b;
        int r4 = -1;
        if (r3 == null) goto L13;
        int r5 = r3.c;
    L14:
        if (r3 == null) goto L16;
        r4 = r3.d;
    L16:
        com.bytedance.android.ec.store.view.q.a r7 = new com.bytedance.android.ec.store.view.q.a(r2, r5, r4);
        Intrinsics.checkNotNullParameter(r7, "span");
        r1.a.add(r7);
        return r1;
    L13:
        r5 = -1;
        goto L14
    L4:
        if (r6.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void setCollapseEnable(boolean r2) {
        if (this.j == r2) goto L6;
        this.j = r2;
        post(new d(this));
        return;
    }

    public final void setComponentCreator(c r2) {
        Intrinsics.checkNotNullParameter(r2, "creator");
        this.n = r2;
        d();
    }

    public final void setSearchCameraClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ImageView r0 = this.d;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public final void setSearchIconAlphaChangeAble(boolean r1) {
        this.a = r1;
    }

    public final void setSearchIconMargin(int r2) {
        SimpleDraweeView r0 = this.c;
        if (r0 == null) goto L6;
        d2.c(r0, r2);
        return;
    }

    public final void setSearchIconSize(int r3) {
        SimpleDraweeView r0 = this.c;
        if (r0 == null) goto L11;
        Intrinsics.checkNotNullParameter(r0, "$this$setWidthHeight");
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L7;
        r1.height = r3;
    L7:
        if (r1 == null) goto L9;
        r1.width = r3;
    L9:
        r0.setLayoutParams(r1);
        return;
    }

    public final void setSearchTextViewListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        TextView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setOnClickListener(r2);
        return;
    }

    public final void setStrokeColor(int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "colors");
        int[][] r0 = {LinearLayout.EMPTY_STATE_SET};
        Drawable r1 = getBackground();
        if ((r1 instanceof GradientDrawable) == true) goto L5;
        r1 = null;
    L5:
        GradientDrawable r2 = (GradientDrawable) r1;
        if (r2 == null) goto L9;
        r2.setStroke((int) t, new ColorStateList(r0, r5));
        return;
    }

    public final void setStyleConfig(b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.b = r2;
    }

    public ECStoreCollapsibleTextView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void b(int r5, Integer r6) {
        Lazy r0 = ECAppInfoService.a;
        if (we.a.a == false) goto L5;
        return;
    L5:
        if (this.d != null) goto L18;
        this.e = true;
        this.d = new ImageView(getContext());
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        addView(this.d, r1);
        ImageView r2 = this.d;
        if (r2 == null) goto L9;
        r2.setImageResource(r5);
    L9:
        ImageView r7 = this.d;
        if (r7 == null) goto L12;
        r7.setPadding(com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8));
    L12:
        if (r6 == null) goto L19;
        int r8 = r6.intValue();
        ImageView r9 = this.d;
        if (r9 == null) goto L20;
        r9.setColorFilter(r8);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void c(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "searchTex");
        if (this.g != null) goto L26;
        c r0 = this.n;
        if (r0 == null) goto L8;
        TextView r1 = r0.c(this);
        if (r1 == null) goto L8;
    L9:
        this.g = r1;
        addView(r1);
        TextView r2 = this.g;
        if (r2 == null) goto L12;
        r2.setGravity(8388629);
    L12:
        TextView r5 = this.g;
        if (r5 == null) goto L15;
        r5.setText(r3);
    L15:
        TextView r6 = this.g;
        if (r6 == null) goto L18;
        r6.setMaxLines(1);
    L18:
        TextView r7 = this.g;
        if (r7 == null) goto L21;
        r7.setTextSize(2, 15.0f);
    L21:
        if (r4 == false) goto L27;
        TextView r8 = this.g;
        if (r8 == null) goto L28;
        com.bytedance.android.shopping.extensions.f.e(r8, 600);
        return;
    L28:
        return;
    L27:
        return;
    L8:
        r1 = new TextView(getContext());
        goto L9
    }

    public final void j(float r8, Function2<? super Integer, ? super Integer, Unit> r9) {
        TextView r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getVisibility();
        if (r8 <= 0.2d) goto L8;
        r0.setVisibility(0);
    L9:
        r0.setAlpha(r8);
        int r10 = r0.getVisibility();
        if (r1 == r10) goto L14;
        if (r9 == null) goto L15;
        Unit r11 = (Unit) r9.invoke(Integer.valueOf(r1), Integer.valueOf(r10));
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r0.setVisibility(8);
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        if (ECStoreFoldPhoneHelper.d() == false) goto L5;
        int r5 = getMeasuredHeight();
        int r6 = View.MeasureSpec.getSize(r3);
        setMeasuredDimension((int) (r5 + ((1 - this.i) * (r6 - r5))), getMeasuredHeight());
        return;
    L5:
        this.k = RangesKt.coerceAtLeast(this.k, View.MeasureSpec.getSize(r3));
    }

    public ECStoreCollapsibleTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
        this.l = -1;
        d();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        c r5 = this.n;
        if (r5 == null) goto L6;
        r5.a(this, r2);
        return;
    }
}
