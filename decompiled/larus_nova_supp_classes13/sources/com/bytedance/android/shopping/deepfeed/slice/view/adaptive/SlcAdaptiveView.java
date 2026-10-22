package com.bytedance.android.shopping.deepfeed.slice.view.adaptive;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.slice.service.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/adaptive/SlcAdaptiveView;", "Landroid/view/ViewGroup;", "Lcom/bytedance/android/shopping/deepfeed/slice/service/b;", "getService", "", "gravity", "", "setGravity", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcAdaptiveView extends ViewGroup {
    public Map<View, AdaptiveHelpParams> a;
    public final List<View> b;
    public final List<Integer> c;
    public final List<Integer> d;
    public final List<AdaptiveHelpParams.Gravity> e;
    public final int[] f;
    public boolean g;
    public int h;
    public boolean i;
    public SlcTemplateContext j;

    public SlcAdaptiveView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SlcAdaptiveView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final b getService() {
        SlcTemplateContext r0 = this.j;
        Object r1 = null;
        if (r0 == null) goto L10;
        Object r2 = r0.o(b.class);
        if ((r2 instanceof b) == false) goto L9;
        r1 = r2;
    L9:
        return (b) r1;
    L10:
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.i == false) goto L5;
        return;
    L5:
        super.requestLayout();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        return new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams) r2);
    L6:
        return new ViewGroup.MarginLayoutParams(r2);
    }

    public final void setGravity(int r2) {
        if (this.h == r2) goto L6;
        this.h = r2;
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new ViewGroup.MarginLayoutParams(getContext(), r3);
    }

    @Override // android.view.View
    public final void onMeasure(int r17, int r18) {
        this.i = true;
        int r4 = View.MeasureSpec.getSize(r17);
        int r5 = getChildCount();
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L5;
        getChildAt(r7).setVisibility(0);
        r7 = r7 + 1;
        goto L3
    L5:
        ((ArrayList) this.b).clear();
        ((ArrayList) this.c).clear();
        ((ArrayList) this.d).clear();
        ((ArrayList) this.e).clear();
        int r6 = getChildCount();
        int r8 = 0;
        int r9 = 0;
    L6:
        if (r8 >= r6) goto L49;
        View r10 = getChildAt(r8);
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r11 = null;
    L10:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        int r13 = getPaddingLeft() + getPaddingRight();
        if (r12 == null) goto L13;
        int r14 = r12.leftMargin;
    L14:
        int r15 = r13 + r14;
        if (r12 == null) goto L17;
        int r16 = r12.rightMargin;
    L18:
        int r19 = ViewGroup.getChildMeasureSpec(r17, r15 + r16, r10.getLayoutParams().width);
        int r110 = getPaddingTop() + getPaddingBottom();
        if (r12 == null) goto L21;
        int r111 = r12.topMargin;
    L22:
        int r112 = r110 + r111;
        if (r12 == null) goto L25;
        int r113 = r12.bottomMargin;
    L26:
        r10.measure(r19, ViewGroup.getChildMeasureSpec(r18, r112 + r113, r10.getLayoutParams().height));
        ViewGroup.LayoutParams r114 = r10.getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == true) goto L29;
        r114 = null;
    L29:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        int r116 = r10.getMeasuredWidth();
        if (r115 == null) goto L32;
        int r117 = r115.leftMargin;
    L33:
        int r118 = r116 + r117;
        if (r115 == null) goto L36;
        int r119 = r115.rightMargin;
    L37:
        int r120 = r118 + r119;
        r9 = r9 + r120;
        Map<View, AdaptiveHelpParams> r121 = this.a;
        if (r121 == null) goto L40;
        AdaptiveHelpParams r20 = r121.get(r10);
    L41:
        if (r20 == null) goto L43;
        int r122 = r20.a;
    L44:
        if (r20 == null) goto L47;
        AdaptiveHelpParams.Gravity r21 = r20.c;
        if (r21 == null) goto L47;
    L48:
        ((ArrayList) this.b).add(r10);
        ((ArrayList) this.c).add(Integer.valueOf(r120));
        ((ArrayList) this.d).add(Integer.valueOf(r122));
        ((ArrayList) this.e).add(r21);
        r8 = r8 + 1;
    L47:
        r21 = AdaptiveHelpParams.Gravity.LEFT;
        goto L48
    L43:
        r122 = 0;
        goto L44
    L40:
        r20 = null;
        goto L41
    L36:
        r119 = 0;
        goto L37
    L32:
        r117 = 0;
        goto L33
    L25:
        r113 = 0;
        goto L26
    L21:
        r111 = 0;
        goto L22
    L17:
        r16 = 0;
        goto L18
    L13:
        r14 = 0;
        goto L14
    L49:
        if (r9 <= r4) goto L86;
        int r22 = Math.min(((ArrayList) this.b).size(), this.f.length);
        int r23 = 0;
    L51:
        if (r23 >= r22) goto L56;
        int[] r123 = this.f;
        if (r23 >= r123.length) goto L55;
        r123[r23] = r23;
    L55:
        r23 = r23 + 1;
        goto L51
    L56:
        int r24 = r22 - 1;
        int r124 = 0;
    L57:
        if (r124 >= r24) goto L73;
        int r125 = (r22 - r124) - 1;
        int r126 = 0;
    L59:
        if (r126 >= r125) goto L72;
        Integer r127 = ArraysKt.getOrNull(this.f, r126);
        if (r127 == null) goto L71;
        int r128 = r127.intValue();
        int r129 = r126 + 1;
        Integer r130 = ArraysKt.getOrNull(this.f, r129);
        if (r130 == null) goto L71;
        int r131 = r130.intValue();
        Integer r25 = (Integer) CollectionsKt.getOrNull(this.d, r128);
        if (r25 == null) goto L71;
        int r26 = r25.intValue();
        Integer r27 = (Integer) CollectionsKt.getOrNull(this.d, r131);
        if (r27 == null) goto L71;
        if (r26 <= r27.intValue()) goto L71;
        int[] r28 = this.f;
        r28[r126] = r131;
        r28[r129] = r128;
    L71:
        r126 = r126 + 1;
        goto L59
    L72:
        r124 = r124 + 1;
        goto L57
    L73:
        int r29 = 0;
    L74:
        if (r9 <= r4) goto L86;
        if (r29 >= r22) goto L86;
        Integer r30 = ArraysKt.getOrNull(this.f, r29);
        if (r30 == null) goto L86;
        int r31 = r30.intValue();
        View r32 = (View) CollectionsKt.getOrNull(this.b, r31);
        if (r32 == null) goto L86;
        r32.setVisibility(8);
        Integer r33 = (Integer) CollectionsKt.getOrNull(this.c, r31);
        if (r33 == null) goto L84;
        int r34 = r33.intValue();
    L85:
        r9 = r9 - r34;
        r29 = r29 + 1;
        goto L74
    L84:
        r34 = 0;
    L86:
        int r35 = getChildCount();
        int r36 = 0;
    L87:
        if (r36 >= r35) goto L115;
        View r37 = getChildAt(r36);
        if (r37.getVisibility() != 0) goto L91;
        boolean r38 = true;
    L92:
        if (r38 == false) goto L113;
        ViewGroup.LayoutParams r39 = r37.getLayoutParams();
        if ((r39 instanceof ViewGroup.MarginLayoutParams) == true) goto L96;
        r39 = null;
    L96:
        ViewGroup.MarginLayoutParams r40 = (ViewGroup.MarginLayoutParams) r39;
        int r41 = getPaddingLeft() + getPaddingRight();
        if (r40 == null) goto L99;
        int r132 = r40.leftMargin;
    L100:
        int r42 = r41 + r132;
        if (r40 == null) goto L103;
        int r133 = r40.rightMargin;
    L104:
        int r43 = ViewGroup.getChildMeasureSpec(r17, r42 + r133, r37.getLayoutParams().width);
        int r134 = getPaddingTop() + getPaddingBottom();
        if (r40 == null) goto L107;
        int r135 = r40.topMargin;
    L108:
        int r136 = r134 + r135;
        if (r40 == null) goto L111;
        int r44 = r40.bottomMargin;
    L112:
        r37.measure(r43, ViewGroup.getChildMeasureSpec(r18, r136 + r44, r37.getLayoutParams().height));
        goto L113
    L111:
        r44 = 0;
        goto L112
    L107:
        r135 = 0;
        goto L108
    L103:
        r133 = 0;
        goto L104
    L99:
        r132 = 0;
    L113:
        r36 = r36 + 1;
        goto L87
    L91:
        r38 = false;
        goto L92
    L115:
        if (this.g == false) goto L142;
        ArrayList r1 = new ArrayList();
        Iterator r45 = ((ArrayList) this.b).iterator();
    L118:
        if (r45.hasNext() == false) goto L138;
        View r46 = (View) r45.next();
        if (r46.getVisibility() != 0) goto L122;
        boolean r47 = true;
    L123:
        if (r47 == false) goto L118;
        Map<View, AdaptiveHelpParams> r48 = this.a;
        if (r48 == null) goto L130;
        AdaptiveHelpParams r49 = r48.get(r46);
        if (r49 == null) goto L130;
        String r50 = r49.b;
        if (r50 == null) goto L130;
    L132:
        if (r50.length() <= 0) goto L134;
        boolean r51 = true;
    L135:
        if (r51 == false) goto L118;
        r1.add(r50);
        goto L118
    L134:
        r51 = false;
    L130:
        r50 = "";
        goto L132
    L122:
        r47 = false;
        goto L123
    L138:
        if ((!r1.isEmpty()) == false) goto L142;
        b r52 = getService();
        if (r52 == null) goto L142;
        r52.I(r1);
    L142:
        int r2 = View.MeasureSpec.getMode(r18);
        int r3 = View.MeasureSpec.getSize(r18);
        int r53 = getChildCount();
        int r54 = 0;
        int r55 = 0;
    L143:
        if (r54 >= r53) goto L151;
        View r56 = getChildAt(r54);
        if (r56.getVisibility() != 0) goto L147;
        boolean r57 = true;
    L148:
        if (r57 == false) goto L150;
        r55 = Math.max(r55, r56.getMeasuredHeight());
    L150:
        r54 = r54 + 1;
        goto L143
    L147:
        r57 = false;
        goto L148
    L151:
        int r58 = r55 + (getPaddingTop() + getPaddingBottom());
        if (r2 != Integer.MIN_VALUE) goto L154;
        r3 = Math.min(r58, r3);
    L157:
        setMeasuredDimension(r4, r3);
        this.i = false;
        return;
    L154:
        if (r2 == 1073741824) goto L157;
        r3 = r58;
        goto L157
    }

    public SlcAdaptiveView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new int[32];
        this.h = 80;
    }

    public /* synthetic */ SlcAdaptiveView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        int r14 = getPaddingLeft();
        int r15 = (r12 - r10) - getPaddingRight();
        int r16 = getPaddingTop();
        int r17 = ((r13 - r11) - getPaddingBottom()) - r16;
        ArrayList r18 = new ArrayList();
        ArrayList r0 = new ArrayList();
        int r1 = getChildCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L17;
        View r4 = getChildAt(r3);
        if (r4.getVisibility() != 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L16;
        AdaptiveHelpParams.Gravity r6 = (AdaptiveHelpParams.Gravity) CollectionsKt.getOrNull(this.e, r3);
        if (r6 != null) goto L13;
        r6 = AdaptiveHelpParams.Gravity.LEFT;
    L13:
        if (r6 != AdaptiveHelpParams.Gravity.LEFT) goto L15;
        r18.add(r4);
        goto L16
    L15:
        r0.add(r4);
    L16:
        r3 = r3 + 1;
        goto L3
    L7:
        r5 = false;
        goto L8
    L17:
        Iterator r19 = r18.iterator();
    L18:
        ViewGroup.LayoutParams r7 = null;
        if (r19.hasNext() == false) goto L43;
        View r2 = (View) r19.next();
        ViewGroup.LayoutParams r8 = r2.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        r7 = r8;
    L24:
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r7;
        if (r20 == null) goto L27;
        int r21 = r20.leftMargin;
    L28:
        int r22 = r14 + r21;
        int r23 = r2.getMeasuredHeight();
        int r24 = this.h & 112;
        if (r24 == 16) goto L33;
        if (r24 == 80) goto L32;
        int r25 = 0;
    L34:
        int r26 = r25 + r16;
        if (r20 == null) goto L37;
        int r27 = r20.topMargin;
    L38:
        int r28 = r26 + r27;
        int r29 = r2.getMeasuredWidth() + r22;
        r2.layout(r22, r28, r29, r2.getMeasuredHeight() + r28);
        if (r20 == null) goto L41;
        int r30 = r20.rightMargin;
    L42:
        r14 = r30 + r29;
        goto L18
    L41:
        r30 = 0;
        goto L42
    L37:
        r27 = 0;
        goto L38
    L32:
        r25 = r17 - r23;
        goto L34
    L33:
        r25 = (r17 - r23) / 2;
        goto L34
    L27:
        r21 = 0;
        goto L28
    L43:
        Iterator r31 = CollectionsKt.reversed(r0).iterator();
    L45:
        if (r31.hasNext() == false) goto L68;
        View r110 = (View) r31.next();
        ViewGroup.LayoutParams r32 = r110.getLayoutParams();
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == true) goto L49;
        r32 = null;
    L49:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;
        if (r33 == null) goto L52;
        int r34 = r33.rightMargin;
    L53:
        int r111 = r15 - r34;
        int r35 = r111 - r110.getMeasuredWidth();
        int r36 = r110.getMeasuredHeight();
        int r37 = this.h & 112;
        if (r37 == 16) goto L58;
        if (r37 == 80) goto L57;
        int r38 = 0;
    L59:
        int r39 = r38 + r16;
        if (r33 == null) goto L62;
        int r40 = r33.topMargin;
    L63:
        int r41 = r39 + r40;
        r110.layout(r35, r41, r111, r110.getMeasuredHeight() + r41);
        if (r33 == null) goto L66;
        int r112 = r33.leftMargin;
    L67:
        r15 = r35 - r112;
        goto L45
    L66:
        r112 = 0;
        goto L67
    L62:
        r40 = 0;
        goto L63
    L57:
        r38 = r17 - r36;
        goto L59
    L58:
        r38 = (r17 - r36) / 2;
        goto L59
    L52:
        r34 = 0;
        goto L53
    }
}
