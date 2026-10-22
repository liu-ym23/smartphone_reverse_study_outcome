package com.bytedance.commerce.uikit.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.text.TextUtilsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/commerce/uikit/flowlayout/FlowLayout;", "Landroid/view/ViewGroup;", "", "lineNum", "", "setMaxLine", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "uikit_release"}, k = 1, mv = {1, 4, 0})
public class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f202940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f202941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f202942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f202943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<List<View>> f202944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Integer> f202945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Integer> f202946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<View> f202947h;

    public static final class a {
    }

    static {
    }

    public FlowLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public final void setMaxLine(int r100) {
        this.f202943d = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    @Override // android.view.View
    public void onMeasure(int r210, int r211) {
        int r100 = View.MeasureSpec.getSize(r210);
        int r101 = View.MeasureSpec.getMode(r210);
        int r102 = View.MeasureSpec.getSize(r211);
        int r103 = View.MeasureSpec.getMode(r211);
        int r104 = getChildCount();
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 1;
    L3:
        if (r105 >= r104) goto L28;
        View r113 = getChildAt(r105);
        if (r113.getVisibility() == 8) goto L7;
        measureChild(r113, r210, r211);
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L27;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r114;
        int r115 = r102;
        int r116 = (r113.getMeasuredWidth() + r108.leftMargin) + r108.rightMargin;
        r111 = (r113.getMeasuredHeight() + r108.topMargin) + r108.bottomMargin;
        if ((r106 + r116) <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L19;
        r107 = Math.max(r107, r106);
        int r117 = r116 + this.f202942c;
        r110 = r110 + r111;
        r112 = r112 + 1;
        int r109 = this.f202943d;
        if (1 > r109) goto L20;
        if (r112 <= r109) goto L20;
        r111 = r111;
    L29:
        if (r111 <= 0) goto L32;
        r110 = r110 + (((r110 / r111) - 1) * this.f202941b);
    L32:
        if (r101 == 1073741824) goto L35;
        r100 = getPaddingRight() + (r107 + getPaddingLeft());
    L35:
        if (r103 != 1073741824) goto L37;
        int r118 = r115;
    L38:
        setMeasuredDimension(r100, r118);
        return;
    L37:
        r118 = (r110 + getPaddingTop()) + getPaddingBottom();
    L20:
        int r119 = r117;
        if (r105 != (r104 - 1)) goto L24;
        r110 = r110 + r111;
        r107 = Math.max(r119, r107);
    L24:
        r106 = r119;
    L25:
        r105 = r105 + 1;
        r102 = r115;
        goto L3
    L19:
        r117 = r106 + (r116 + this.f202942c);
        r111 = Math.max(r111, r111);
        goto L20
    L27:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L7:
        if (r105 != (r104 - 1)) goto L9;
        r107 = Math.max(r106, r107);
        r110 = r110 + r111;
    L9:
        r115 = r102;
        goto L25
    L28:
        r115 = r102;
        goto L29
    }

    public FlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f202944e = new ArrayList();
        this.f202945f = new ArrayList();
        this.f202946g = new ArrayList();
        this.f202947h = new ArrayList();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.commerce_fll_max_select, R.attr.commerce_fll_tag_gravity, R.attr.commerce_fll_tag_maxLine, R.attr.commerce_fll_tag_space_horizontal, R.attr.commerce_fll_tag_space_vertical});
        int r104 = 1;
        int r105 = r103.getInt(1, -1);
        this.f202940a = r105;
        this.f202942c = r103.getDimensionPixelSize(3, 0);
        this.f202941b = r103.getDimensionPixelSize(4, 0);
        this.f202943d = r103.getInteger(2, 0);
        if (TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L8;
        if (r105 == (-1)) goto L7;
        r104 = -1;
    L7:
        this.f202940a = r104;
    L8:
        r103.recycle();
    }

    public /* synthetic */ FlowLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        ((ArrayList) this.f202944e).clear();
        ((ArrayList) this.f202945f).clear();
        ((ArrayList) this.f202946g).clear();
        this.f202947h.clear();
        int r100 = getWidth();
        int r101 = getChildCount();
        int r102 = 1;
        int r103 = 0;
        int r104 = 0;
        int r105 = 1;
        int r106 = 0;
    L3:
        int r112 = 8;
        if (r103 >= r101) goto L22;
        View r113 = getChildAt(r103);
        if (r113.getVisibility() == 8) goto L19;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L21;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        int r116 = (r113.getMeasuredWidth() + r115.leftMargin) + r115.rightMargin;
        int r117 = (r113.getMeasuredHeight() + r115.topMargin) + r115.bottomMargin;
        if ((r116 + r104) <= ((r100 - getPaddingLeft()) - getPaddingRight())) goto L18;
        r105 = r105 + 1;
        int r118 = this.f202943d;
        if (1 > r118) goto L17;
        if (r105 > r118) goto L22;
    L17:
        List<Integer> r107 = this.f202945f;
        ArrayList r108 = (ArrayList) r107;
        r108.add(Integer.valueOf(r106));
        List<List<View>> r109 = this.f202944e;
        ArrayList r119 = (ArrayList) r109;
        r119.add(this.f202947h);
        List<Integer> r120 = this.f202946g;
        ArrayList r121 = (ArrayList) r120;
        r121.add(Integer.valueOf(r104));
        this.f202947h = new ArrayList();
        r106 = r117;
        r104 = 0;
    L18:
        r104 = r104 + (r116 + this.f202942c);
        r106 = Math.max(r106, r117);
        this.f202947h.add(r113);
        goto L19
    L21:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        r103 = r103 + 1;
    L22:
        List<Integer> r122 = this.f202945f;
        ArrayList r123 = (ArrayList) r122;
        r123.add(Integer.valueOf(r106));
        List<Integer> r124 = this.f202946g;
        ArrayList r125 = (ArrayList) r124;
        r125.add(Integer.valueOf(r104));
        List<List<View>> r126 = this.f202944e;
        ArrayList r127 = (ArrayList) r126;
        r127.add(this.f202947h);
        int r128 = getPaddingLeft();
        int r129 = getPaddingTop();
        int r130 = ((ArrayList) this.f202944e).size();
        int r131 = 0;
    L23:
        if (r131 >= r130) goto L46;
        List<View> r132 = (List) ListProtector.get(this.f202944e, r131);
        this.f202947h = r132;
        int r133 = r132.size();
        int r134 = ((Number) ListProtector.get(this.f202945f, r131)).intValue() + this.f202941b;
        int r135 = ((Number) ListProtector.get(this.f202946g, r131)).intValue();
        int r136 = this.f202940a;
        if (r136 == (-1)) goto L31;
        if (r136 == 0) goto L30;
        if (r136 != r102) goto L32;
        r128 = (r100 - (r135 + getPaddingLeft())) - getPaddingRight();
        CollectionsKt.reverse(this.f202947h);
    L32:
        int r137 = 0;
    L33:
        if (r137 >= r133) goto L45;
        View r138 = (View) ListProtector.get(this.f202947h, r137);
        if (r138 == null) goto L44;
        if (r138.getVisibility() == r112) goto L44;
        ViewGroup.LayoutParams r139 = r138.getLayoutParams();
        if (r139 == null) goto L43;
        ViewGroup.MarginLayoutParams r140 = (ViewGroup.MarginLayoutParams) r139;
        int r141 = r140.leftMargin + r128;
        int r142 = r140.topMargin + r129;
        r138.layout(r141, r142, r141 + r138.getMeasuredWidth(), r142 + r138.getMeasuredHeight());
        r128 = r128 + (((r138.getMeasuredWidth() + r140.leftMargin) + r140.rightMargin) + this.f202942c);
        goto L44
    L43:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L44:
        r137 = r137 + 1;
        r112 = 8;
        goto L33
    L45:
        r129 = r129 + r134;
        r131 = r131 + 1;
        r102 = 1;
        r112 = 8;
        goto L23
    L30:
        r128 = ((r100 - r135) / 2) + getPaddingLeft();
        goto L32
    L31:
        r128 = getPaddingLeft();
        goto L32
    }
}
