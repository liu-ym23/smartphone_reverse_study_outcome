package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0003\n(B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'R\"\u0010\t\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R>\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`\u00198\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/BaseHorizontalPullLayout;", "Landroid/view/ViewGroup;", "", "a", "I", "getMaxOffsetLeft", "()I", "setMaxOffsetLeft", "(I)V", "maxOffsetLeft", "b", "getMaxOffsetRight", "setMaxOffsetRight", "maxOffsetRight", "", "c", "J", "getRollBackDuration", "()J", "setRollBackDuration", "(J)V", "rollBackDuration", "Ljava/util/HashMap;", "Landroid/view/View;", "Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/BaseHorizontalPullLayout$a;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "getChildViews", "()Ljava/util/HashMap;", "setChildViews", "(Ljava/util/HashMap;)V", "childViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutParams", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseHorizontalPullLayout extends ViewGroup {
    public int a;
    public int b;
    public long c;
    public HashMap<View, a> d;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/horizontalpull/BaseHorizontalPullLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "", "a", "I", "getType", "()I", "setType", "(I)V", "type", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public final int a;

        public LayoutParams() {
            super(-2, -2);
            this.a = -1;
        }

        public final int getType() {
            return this.a;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.a = -1;
        }

        public LayoutParams(Context r5, AttributeSet r6) {
            super(r5, r6);
            this.a = -1;
            Integer r1 = null;
            if (r5 == null) goto L7;
            Resources.Theme r7 = r5.getTheme();
            if (r7 == null) goto L7;
            TypedArray r8 = r7.obtainStyledAttributes(r6, new int[]{2130972447, 2130972489}, 0, 0);
        L8:
            if (r8 == null) goto L10;
            r1 = Integer.valueOf(r8.getInt(1, -1));
        L10:
            Intrinsics.checkNotNull(r1);
            this.a = r1.intValue();
            r8.recycle();
            return;
        L7:
            r8 = null;
            goto L8
        }
    }

    public static final class a {
        public int a;
        public int b;

        public a() {
            this(0);
        }

        public a(int r1) {
            this.a = 0;
            this.b = 0;
        }
    }

    public static final class b {
    }

    static {
    }

    public BaseHorizontalPullLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseHorizontalPullLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final boolean a() {
        View r0 = com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.d, 4);
        if (r0 == null) goto L9;
        if (com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.d, 0) != null) goto L7;
        return false;
    L7:
        return !r0.canScrollHorizontally(-1);
    L9:
        throw new Exception("Child type \"content\" must be defined!");
    }

    public final boolean b() {
        View r0 = com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.d, 4);
        if (r0 == null) goto L10;
        if (com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.d, 2) != null) goto L11;
        return false;
    L11:
        return !r0.canScrollHorizontally(1);
    L10:
        throw new Exception("Child type \"content\" must be defined!");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        View r3 = getChildAt(r2);
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L12;
        if (com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.d, Integer.valueOf(((LayoutParams) r4).getType())) != null) goto L10;
        a r5 = this.d.put(r3, new a(0));
        r2 = r2 + 1;
        goto L3
    L10:
        throw new Exception("Each child type can only be defined once!");
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.BaseHorizontalPullLayout.LayoutParams");
    }

    public final HashMap<View, a> getChildViews() {
        return this.d;
    }

    public final int getMaxOffsetLeft() {
        return this.a;
    }

    public final int getMaxOffsetRight() {
        return this.b;
    }

    public final long getRollBackDuration() {
        return this.c;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if ((r1 instanceof LayoutParams) == false) goto L6;
        return true;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public final void setChildViews(HashMap<View, a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setMaxOffsetLeft(int r1) {
        this.a = r1;
    }

    public final void setMaxOffsetRight(int r1) {
        this.b = r1;
    }

    public final void setRollBackDuration(long r1) {
        this.c = r1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        return new LayoutParams(r2);
    }

    @Override // android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        Iterator<Map.Entry<View, a>> r0 = this.d.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        Map.Entry<View, a> r1 = r0.next();
        View r2 = r1.getKey();
        a r3 = r1.getValue();
        measureChildWithMargins(r2, r10, 0, r11, 0);
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if (r4 == null) goto L21;
        LayoutParams r5 = (LayoutParams) r4;
        int r6 = r5.getType();
        if (r6 == 0) goto L12;
        if (r6 != 2) goto L4;
    L12:
        int r7 = (r2.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r5).leftMargin) + ((ViewGroup.MarginLayoutParams) r5).rightMargin;
        r3.b = r7;
        int r8 = this.a;
        if (r8 >= 0) goto L15;
        r8 = r7;
    L15:
        this.a = r8;
        int r9 = this.b;
        if (r9 < 0) goto L19;
        r7 = r9;
    L19:
        this.b = r7;
        goto L4
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.BaseHorizontalPullLayout.LayoutParams");
    }

    public BaseHorizontalPullLayout(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.c = 200;
        this.d = new HashMap(4);
        Resources r0 = r5.getResources();
        if (r0 == null) goto L5;
        DisplayMetrics r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics());
    L6:
        int r2 = (int) TypedValue.applyDimension(1, -1.0f, r1);
        Resources.Theme r8 = r5.getTheme();
        if (r8 == null) goto L12;
        TypedArray r9 = r8.obtainStyledAttributes(r6, new int[]{2130972711, 2130972712}, r7, 0);
        if (r9 == null) goto L13;
        this.a = r9.getDimensionPixelOffset(0, r2);
        this.b = r9.getDimensionPixelOffset(1, r2);
        r9.recycle();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public /* synthetic */ BaseHorizontalPullLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        View r11 = com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.a.a(this.d, 4);
        if (r11 == null) goto L21;
        int r12 = r11.getMeasuredWidth();
        Iterator<Map.Entry<View, a>> r13 = this.d.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L19;
        Map.Entry<View, a> r14 = r13.next();
        View r15 = r14.getKey();
        a r16 = r14.getValue();
        ViewGroup.LayoutParams r17 = r15.getLayoutParams();
        if (r17 == null) goto L18;
        LayoutParams r18 = (LayoutParams) r17;
        int r0 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r18).leftMargin;
        int r1 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) r18).topMargin;
        int r2 = r15.getMeasuredWidth() + r0;
        int r3 = r15.getMeasuredHeight() + r1;
        int r19 = r18.getType();
        if (r19 != 0) goto L12;
        int r110 = r16.b;
        r0 = r0 - r110;
        r2 = r2 - r110;
    L16:
        r16.a = r0;
        r16.b = 0;
        r15.layout(r0, r1, r2, r3);
        goto L6
    L12:
        if (r19 != 2) goto L16;
        r0 = r0 + r12;
        r2 = r2 + r12;
        goto L16
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.BaseHorizontalPullLayout.LayoutParams");
    L19:
        return;
    L21:
        throw new Exception("EasyPullLayout must have and only have one layout_type \"content\"!");
    }
}
