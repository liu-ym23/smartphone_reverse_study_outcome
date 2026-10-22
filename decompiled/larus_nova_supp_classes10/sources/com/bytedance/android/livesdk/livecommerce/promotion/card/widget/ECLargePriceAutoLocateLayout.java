package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\"\u0010\u000b\u001a\u00020\u00042\u001a\u0010\n\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0018\u00010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout$AutoLocateMode;", "mode", "", "setMode", "", "Lkotlin/Pair;", "Landroid/view/View;", "", "showSequence", "setCustomHideSequence", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AutoLocateMode", "LayoutParams", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECLargePriceAutoLocateLayout extends LinearLayout {
    public AutoLocateMode a;
    public int b;
    public List<? extends Pair<? extends View, Boolean>> c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout$AutoLocateMode;", "", "HIDE_MODE", "REVERSE_MODE", "CUSTOM_MODE", "DEFAULT_MODE", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AutoLocateMode extends Enum<AutoLocateMode> {
        public static final AutoLocateMode CUSTOM_MODE = null;
        public static final AutoLocateMode DEFAULT_MODE = null;
        public static final AutoLocateMode HIDE_MODE = null;
        public static final AutoLocateMode REVERSE_MODE = null;
        public static final /* synthetic */ AutoLocateMode[] a = null;

        static {
            AutoLocateMode r1 = new AutoLocateMode("HIDE_MODE", 0);
            HIDE_MODE = r1;
            AutoLocateMode r2 = new AutoLocateMode("REVERSE_MODE", 1);
            REVERSE_MODE = r2;
            AutoLocateMode r3 = new AutoLocateMode("CUSTOM_MODE", 2);
            CUSTOM_MODE = r3;
            AutoLocateMode r4 = new AutoLocateMode("DEFAULT_MODE", 3);
            DEFAULT_MODE = r4;
            a = new AutoLocateMode[]{r1, r2, r3, r4};
        }

        public static AutoLocateMode valueOf(String r1) {
            return (AutoLocateMode) r27.a.a(AutoLocateMode.class, r1);
        }

        public static AutoLocateMode[] values() {
            return (AutoLocateMode[]) a.clone();
        }

        public AutoLocateMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LayoutParams extends LinearLayout.LayoutParams {
        public final int a;
        public final int b;

        public LayoutParams(Context r5, AttributeSet r6) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "attrs");
            super(r5, r6);
            TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{2130972471, 2130972472});
            int r8 = r7.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r8) goto L10;
            int r2 = r7.getIndex(r1);
            if (r2 != 1) goto L7;
            this.a = r7.getInteger(r2, 0);
        L9:
            r1 = r1 + 1;
            goto L3
        L7:
            if (r2 != 0) goto L9;
            this.b = r7.getInteger(r2, 0);
            goto L9
        L10:
            r7.recycle();
        }
    }

    public static final class a<T> implements Comparator {
        public final /* synthetic */ boolean a;

        public a(boolean r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(Object r3, Object r4) {
            View r5 = (View) r4;
            ViewGroup.LayoutParams r6 = ((View) r3).getLayoutParams();
            if (r6 == null) goto L19;
            LayoutParams r7 = (LayoutParams) r6;
            if (this.a == false) goto L7;
            int r8 = r7.b;
        L8:
            ViewGroup.LayoutParams r9 = r5.getLayoutParams();
            if (r9 == null) goto L17;
            LayoutParams r10 = (LayoutParams) r9;
            if (this.a == false) goto L13;
            int r11 = r10.b;
        L15:
            return r8 - r11;
        L13:
            r11 = r10.a;
            goto L15
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout.LayoutParams");
        L7:
            r8 = r7.a;
            goto L8
        L19:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout.LayoutParams");
        }
    }

    public ECLargePriceAutoLocateLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECLargePriceAutoLocateLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(boolean r8) {
        int r0 = getChildCount();
        boolean r2 = true;
        if (r0 > 1) goto L5;
    L4:
        r2 = false;
    L26:
        if (r2 == false) goto L55;
        ArrayList r1 = new ArrayList();
        r1.addAll(com.bytedance.commerce.base.view.b.a(this));
        CollectionsKt.sortWith(r1, new a(r8));
        removeAllViews();
        Iterator r3 = r1.iterator();
    L29:
        if (r3.hasNext() == false) goto L65;
        View r4 = (View) r3.next();
        if (r8 == false) goto L33;
    L42:
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L54;
        LayoutParams r6 = (LayoutParams) r5;
        if (r8 == false) goto L51;
        Object r7 = r4.getTag();
        if (r7 == null) goto L50;
        int r9 = ((Integer) r7).intValue();
    L52:
        ((LinearLayout.LayoutParams) r6).leftMargin = r9;
        addView(r4);
        goto L29
    L50:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L51:
        r9 = 0;
        goto L52
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout.LayoutParams");
    L33:
        if (r4.getTag() != null) goto L42;
        ViewGroup.LayoutParams r10 = r4.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == true) goto L37;
        r10 = null;
    L37:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        if (r11 == null) goto L40;
        int r12 = r11.leftMargin;
    L41:
        r4.setTag(Integer.valueOf(r12));
        goto L42
    L40:
        r12 = 0;
        goto L41
    L65:
        return;
    L55:
        return;
    L5:
        int r13 = 1;
    L6:
        if (r13 >= r0) goto L4;
        View r14 = getChildAt(r13 - 1);
        View r15 = getChildAt(r13);
        ViewGroup.LayoutParams r16 = r14.getLayoutParams();
        if (r16 == null) goto L25;
        LayoutParams r17 = (LayoutParams) r16;
        if (r8 == false) goto L12;
        int r18 = r17.b;
    L13:
        ViewGroup.LayoutParams r19 = r15.getLayoutParams();
        if (r19 == null) goto L23;
        LayoutParams r20 = (LayoutParams) r19;
        if (r8 == false) goto L18;
        int r21 = r20.b;
    L19:
        if (r21 < r18) goto L26;
        r13 = r13 + 1;
        goto L6
    L18:
        r21 = r20.a;
        goto L19
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout.LayoutParams");
    L12:
        r18 = r17.a;
        goto L13
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout.LayoutParams");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r3, "attrs");
        return new LayoutParams(getContext(), r3);
    }

    public final void setCustomHideSequence(List<? extends Pair<? extends View, Boolean>> r2) {
        this.a = AutoLocateMode.CUSTOM_MODE;
        this.c = r2;
    }

    public final void setMode(AutoLocateMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.a = r2;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r3, "attrs");
        return new LayoutParams(getContext(), r3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r13, int r14) {
        int r0 = View.MeasureSpec.getSize(r13);
        this.b = -1;
        if (this.a != AutoLocateMode.CUSTOM_MODE) goto L8;
        List<? extends Pair<? extends View, Boolean>> r1 = this.c;
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L9:
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L11:
        if (r3 >= r2) goto L44;
        ViewGroup.LayoutParams r9 = null;
        if (this.a != AutoLocateMode.CUSTOM_MODE) goto L20;
        List<? extends Pair<? extends View, Boolean>> r7 = this.c;
        if (r7 == null) goto L19;
        Pair r8 = (Pair) ListProtector.get(r7, r3);
        if (r8 == null) goto L19;
        View r10 = (View) r8.getFirst();
    L21:
        if (r10 == null) goto L43;
        if (r10.getVisibility() == 8) goto L43;
        r10.measure(View.MeasureSpec.makeMeasureSpec(0, 0), r14);
        int r11 = r10.getMeasuredWidth();
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == true) goto L27;
        r12 = null;
    L27:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r12;
        if (r15 == null) goto L30;
        int r16 = r15.leftMargin;
    L31:
        int r17 = r11 + r16;
        ViewGroup.LayoutParams r18 = r10.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L35;
        r9 = r18;
    L35:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r9;
        if (r19 == null) goto L38;
        int r20 = r19.rightMargin;
    L39:
        int r21 = r17 + r20;
        if (r21 > (((r0 - getPaddingLeft()) - getPaddingRight()) - r4)) goto L41;
        r4 = r4 + r21;
        r5 = Math.max(r5, r10.getMeasuredHeight());
        goto L43
    L41:
        this.b = r3;
        boolean r6 = false;
    L45:
        if (r6 == true) goto L47;
        int r22 = d.a[this.a.ordinal()];
        if (r22 == 1) goto L59;
        if (r22 == 2) goto L56;
    L61:
        super.onMeasure(r13, r14);
        return;
    L56:
        if (getOrientation() == 1) goto L61;
        a(false);
        setOrientation(1);
        goto L61
    L59:
        if (getOrientation() == 0) goto L61;
        a(true);
        setOrientation(0);
        goto L61
    L47:
        if (getOrientation() == 0) goto L49;
        a(true);
        setOrientation(0);
    L49:
        super.onMeasure(r13, r14);
        return;
    L38:
        r20 = 0;
        goto L39
    L30:
        r16 = 0;
    L43:
        r3 = r3 + 1;
    L19:
        r10 = null;
        goto L21
    L20:
        r10 = getChildAt(r3);
        goto L21
    L44:
        r6 = true;
        goto L45
    L7:
        r2 = 0;
        goto L9
    L8:
        r2 = getChildCount();
        goto L9
    }

    public ECLargePriceAutoLocateLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(0);
        this.a = AutoLocateMode.HIDE_MODE;
        this.b = -1;
    }

    public /* synthetic */ ECLargePriceAutoLocateLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        super.onLayout(r9, r10, r11, r12, r13);
        AutoLocateMode r14 = this.a;
        if (r14 != AutoLocateMode.HIDE_MODE) goto L15;
        int r15 = getChildCount() - 1;
    L5:
        if (r15 < 1) goto L69;
        View r16 = getChildAt(r15);
        if (r16.getVisibility() == 8) goto L13;
        int r17 = this.b;
        if (r17 < 0) goto L70;
        if (r15 < r17) goto L71;
        r16.layout(r16.getLeft(), r16.getTop(), r16.getLeft(), r16.getBottom());
        goto L13
    L71:
        return;
    L70:
        return;
    L13:
        r15 = r15 - 1;
        goto L5
    L69:
        return;
    L15:
        if (r14 != AutoLocateMode.CUSTOM_MODE) goto L53;
        List<? extends Pair<? extends View, Boolean>> r18 = this.c;
        if (r18 != null) goto L19;
        return;
    L19:
        if (this.b <= 0) goto L68;
        int r19 = r18.size() - this.b;
        List<? extends Pair<? extends View, Boolean>> r20 = r18;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator<T> r111 = r20.iterator();
    L22:
        if (r111.hasNext() == false) goto L24;
        r110.add((View) ((Pair) r111.next()).getFirst());
        goto L22
    L24:
        List r112 = CollectionsKt.takeLast(r110, r19);
        int r113 = getChildCount();
        int r0 = 0;
        int r1 = 0;
        boolean r2 = false;
    L25:
        if (r0 >= r113) goto L72;
        View r3 = getChildAt(r0);
        Iterator<T> r4 = r20.iterator();
    L27:
        ViewGroup.LayoutParams r6 = null;
        if (r4.hasNext() == false) goto L32;
        Object r5 = r4.next();
        if (Intrinsics.areEqual((View) ((Pair) r5).getFirst(), r3) == false) goto L27;
    L33:
        Pair r7 = (Pair) r5;
        if (r7 == null) goto L36;
        Boolean r8 = (Boolean) r7.getSecond();
    L38:
        if (r112.contains(r3) == true) goto L40;
    L50:
        if (r2 == false) goto L52;
        r3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r21 = r3.getMeasuredWidth() - (r3.getRight() - r3.getLeft());
        r3.layout(r3.getLeft() - r1, r3.getTop() - (r3.getMeasuredHeight() - (r3.getBottom() - r3.getTop())), (r3.getRight() - r1) + r21, r3.getBottom());
    L52:
        r0 = r0 + 1;
        goto L25
    L40:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L50;
        int r22 = r3.getRight() - r3.getLeft();
        ViewGroup.LayoutParams r23 = r3.getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L45;
        r6 = r23;
    L45:
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r6;
        if (r24 == null) goto L48;
        int r25 = r24.leftMargin;
    L49:
        r1 = r1 + (r22 + r25);
        r3.layout(r3.getLeft(), r3.getTop(), r3.getLeft(), r3.getBottom());
        r2 = true;
        goto L52
    L48:
        r25 = 0;
        goto L49
    L36:
        r8 = null;
        goto L38
    L32:
        r5 = null;
        goto L33
    L72:
        return;
    L68:
        return;
    }
}
