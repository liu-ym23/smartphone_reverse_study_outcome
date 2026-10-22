package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameFlowLayout;", "Landroid/view/ViewGroup;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class SurnameFlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<View>> f401137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f401138b;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        Intrinsics.checkNotNullParameter(r100, "attrs");
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        return new ViewGroup.MarginLayoutParams(r100);
    }

    public SurnameFlowLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f401137a = new ArrayList();
        this.f401138b = new ArrayList();
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r210) {
        super.onMeasure(r110, r210);
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getSize(r210);
        int r102 = View.MeasureSpec.getMode(r110);
        int r103 = View.MeasureSpec.getMode(r210);
        int r104 = getChildCount();
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
        int r111 = 0;
    L3:
        if (r105 >= r104) goto L16;
        int r112 = r105 + 1;
        View r113 = getChildAt(r105);
        measureChild(r113, r110, r210);
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L15;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        int r116 = r101;
        int r109 = (r113.getMeasuredWidth() + r115.leftMargin) + r115.rightMargin;
        int r117 = r106;
        int r118 = (r113.getMeasuredHeight() + r115.topMargin) + r115.bottomMargin;
        int r119 = r107 + r109;
        if (r119 <= r100) goto L9;
        r106 = (int) Math.max(r107, r109);
        r111 = r111 + r108;
        r107 = r109;
        r108 = r118;
    L11:
        if (r105 != (r104 - 1)) goto L13;
        r106 = (int) Math.max(r106, r107);
        r111 = r111 + r108;
    L13:
        r105 = r112;
        r101 = r116;
        goto L3
    L9:
        r108 = (int) Math.max(r108, r118);
        r107 = r119;
        r106 = r117;
        goto L11
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L16:
        int r120 = r101;
        int r121 = r106;
        if (r102 == 1073741824) goto L20;
        r100 = r121;
    L20:
        if (r103 != 1073741824) goto L22;
        int r122 = r120;
    L23:
        setMeasuredDimension(r100, r122);
        return;
    L22:
        r122 = r111;
        goto L23
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        ((ArrayList) this.f401137a).clear();
        ((ArrayList) this.f401138b).clear();
        int r100 = getWidth();
        ArrayList r101 = new ArrayList();
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r103 >= r102) goto L13;
        int r106 = r103 + 1;
        View r107 = getChildAt(r103);
        ViewGroup.LayoutParams r112 = r107.getLayoutParams();
        if (r112 == null) goto L12;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        int r108 = r107.getMeasuredWidth();
        int r114 = r107.getMeasuredHeight();
        if ((((r113.leftMargin + r108) + r113.rightMargin) + r105) <= r100) goto L10;
        ((ArrayList) this.f401138b).add(Integer.valueOf(r104));
        ((ArrayList) this.f401137a).add(r101);
        r101 = new ArrayList();
        r105 = 0;
    L10:
        r105 = r105 + ((r108 + r113.leftMargin) + r113.rightMargin);
        r104 = (int) Math.max(r104, (r114 + r113.topMargin) + r113.bottomMargin);
        r101.add(r107);
        r103 = r106;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        ((ArrayList) this.f401138b).add(Integer.valueOf(r104));
        ((ArrayList) this.f401137a).add(r101);
        int r109 = ((ArrayList) this.f401137a).size();
        int r115 = 0;
        int r116 = 0;
    L14:
        if (r115 >= r109) goto L26;
        int r117 = r115 + 1;
        List r118 = (List) ListProtector.get(this.f401137a, r115);
        int r119 = ((Number) ListProtector.get(this.f401138b, r115)).intValue();
        int r120 = r118.size();
        int r121 = 0;
        int r122 = 0;
    L16:
        if (r121 >= r120) goto L25;
        int r123 = r121 + 1;
        View r124 = (View) ListProtector.get(r118, r121);
        if (r124.getVisibility() == 8) goto L19;
        ViewGroup.LayoutParams r125 = r124.getLayoutParams();
        if (r125 == null) goto L24;
        ViewGroup.MarginLayoutParams r126 = (ViewGroup.MarginLayoutParams) r125;
        int r127 = r126.leftMargin + r122;
        int r128 = r126.topMargin + r116;
        int r129 = r124.getMeasuredWidth() + r127;
        int r130 = r128 + r124.getMeasuredHeight();
        r124.toString();
        r124.layout(r127, r128, r129, r130);
        r122 = r122 + ((r124.getMeasuredWidth() + r126.rightMargin) + r126.leftMargin);
        goto L19
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        r121 = r123;
        goto L16
    L25:
        r116 = r116 + r119;
        r115 = r117;
        goto L14
    }
}
