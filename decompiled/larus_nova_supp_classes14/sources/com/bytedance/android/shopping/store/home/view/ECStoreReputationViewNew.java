package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R*\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECStoreReputationViewNew;", "Landroid/widget/LinearLayout;", "", "", "params", "", "setCommonEventParams", "", "collapse", "setXzgViewCollapse", "value", "q", "F", "getCollapse", "()F", "setCollapse", "(F)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreReputationViewNew extends LinearLayout {
    public ECDraweeView a;
    public TextView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public LinearLayout f;
    public ECStoreXzgLevelView g;
    public ECStoreExperienceScoreView h;
    public TextView i;
    public ECTagListView j;
    public ECTagListView k;
    public boolean l;
    public boolean m;
    public View n;
    public final List<TextView> o;
    public final Map<String, String> p;
    public float q;

    public ECStoreReputationViewNew(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECStoreReputationViewNew(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        Iterator<T> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((TextView) r0.next()).setVisibility(8);
        goto L4
    }

    public final float getCollapse() {
        return this.q;
    }

    public final void b(boolean r6) {
        if (r6 == false) goto L4;
        int r0 = -1;
    L5:
        TextView r1 = this.d;
        if (r1 == null) goto L8;
        r1.setTextColor(r0);
    L8:
        TextView r2 = this.d;
        if (r2 == null) goto L11;
        r2.setAlpha(0.75f);
    L11:
        TextView r3 = this.e;
        if (r3 == null) goto L14;
        r3.setTextColor(r0);
    L14:
        TextView r4 = this.e;
        if (r4 == null) goto L17;
        r4.setAlpha(0.75f);
    L17:
        TextView r5 = this.d;
        if (r5 == null) goto L20;
        wg.a.g(r5, 11);
    L20:
        TextView r7 = this.e;
        if (r7 == null) goto L23;
        wg.a.g(r7, 10);
    L23:
        float r8 = 1.0f;
        if (this.l == false) goto L31;
        TextView r9 = this.e;
        if (r9 == null) goto L28;
        r9.setTextColor(1930827811);
    L28:
        TextView r10 = this.e;
        if (r10 == null) goto L31;
        r10.setAlpha(1.0f);
    L31:
        TextView r11 = this.b;
        if (r11 == null) goto L34;
        r11.setTextColor((int) 4290807365L);
    L34:
        TextView r12 = this.b;
        if (r12 == null) goto L37;
        wg.a.g(r12, 12);
    L37:
        TextView r13 = this.b;
        if (r13 == null) goto L45;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == true) goto L42;
        r14 = null;
    L42:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L45;
        r15.setMargins(com.bytedance.android.shopping.extensions.b.b(2), 0, 0, 0);
    L45:
        TextView r16 = this.b;
        if (r16 == null) goto L50;
        if (r6 == false) goto L49;
        r8 = 0.9f;
    L49:
        r16.setAlpha(r8);
    L50:
        ImageView r17 = this.c;
        if (r17 == null) goto L57;
        r17.setImageResource(2131234792);
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L56;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        r19.width = com.bytedance.android.shopping.extensions.b.b(11);
        r19.height = com.bytedance.android.shopping.extensions.b.b(11);
        r17.setLayoutParams(r19);
        return;
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L57:
        return;
    L4:
        r0 = (int) 4279638051L;
        goto L5
    }

    public final void setCollapse(float r3) {
        if (this.q != r3) goto L5;
        return;
    L5:
        if (this.m == false) goto L11;
        this.q = r3;
        int r4 = ColorUtils.blendARGB(1946157055, 1930827811, r3);
        TextView r0 = this.i;
        if (r0 == null) goto L12;
        r0.setTextColor(r4);
        return;
    L12:
        return;
    }

    public final void setCommonEventParams(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        ((LinkedHashMap) this.p).clear();
        this.p.putAll(r2);
    }

    public final void setXzgViewCollapse(float r2) {
        ECStoreXzgLevelView r0 = this.g;
        if (r0 == null) goto L6;
        r0.setCollapse(r2);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r18, int r19) {
        int r1 = View.MeasureSpec.getSize(r18);
        int r2 = View.MeasureSpec.getMode(r18);
        int r3 = View.MeasureSpec.getSize(r19);
        int r4 = View.MeasureSpec.getMode(r19);
        int r5 = getChildCount();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L3:
        if (r6 >= r5) goto L19;
        View r10 = getChildAt(r6);
        if (r10.getVisibility() != 0) goto L17;
        measureChild(r10, r18, r19);
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if (r13 == null) goto L16;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        int r15 = (r10.getMeasuredWidth() + r14.leftMargin) + r14.rightMargin;
        if (r8 <= 0) goto L11;
        r15 = r15 + com.bytedance.android.shopping.extensions.b.b(4);
    L11:
        int r16 = r3;
        int r17 = (r10.getMeasuredHeight() + r14.topMargin) + r14.bottomMargin;
        int r110 = r15 + r7;
        if (r110 <= ((r1 - getPaddingLeft()) - getPaddingRight())) goto L14;
        r10.setVisibility(8);
    L18:
        r6 = r6 + 1;
        r3 = r16;
        goto L3
    L14:
        r8 = r8 + 1;
        r9 = RangesKt.coerceAtLeast(r9, r17);
        r7 = r110;
        goto L18
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L17:
        r16 = r3;
        goto L18
    L19:
        int r111 = r3;
        if (r2 == 1073741824) goto L23;
        int r11 = r7 + getPaddingLeft();
        r1 = getPaddingRight() + r11;
    L23:
        if (r4 != 1073741824) goto L25;
        int r12 = r111;
    L26:
        setMeasuredDimension(r1, r12);
        return;
    L25:
        r12 = (r9 + getPaddingTop()) + getPaddingBottom();
        goto L26
    }

    public ECStoreReputationViewNew(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setOrientation(0);
        setGravity(16);
        setDividerDrawable(ag4.a.c(2131234485));
        setShowDividers(2);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560953, this, true);
        this.o = new ArrayList();
        this.p = new LinkedHashMap();
    }

    public /* synthetic */ ECStoreReputationViewNew(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        float r6 = 0.0f;
        if (((ArrayList) this.o).size() < 2) goto L15;
        if (l0.f(getContext()) == null) goto L15;
        TextPaint r7 = ((TextView) ListProtector.get(this.o, 1)).getPaint();
        String r8 = ((TextView) ListProtector.get(this.o, 1)).getText().toString();
        if (r7 == null) goto L10;
        float r9 = r7.measureText(r8);
    L12:
        if (r9 <= ((TextView) ListProtector.get(this.o, 1)).getWidth()) goto L15;
        ((View) ListProtector.get(this.o, 1)).setVisibility(8);
        goto L15
    L10:
        r9 = 0.0f;
    L15:
        if (l0.f(getContext()) == null) goto L36;
        TextView r10 = this.e;
        CharSequence r11 = null;
        if (r10 == null) goto L19;
        TextPaint r12 = r10.getPaint();
    L20:
        TextView r13 = this.e;
        if (r13 == null) goto L23;
        r11 = r13.getText();
    L23:
        String r14 = String.valueOf(r11);
        if (r12 == null) goto L26;
        r6 = r12.measureText(r14);
    L26:
        TextView r15 = this.e;
        if (r15 == null) goto L29;
        int r16 = r15.getWidth();
    L31:
        if (r6 <= r16) goto L37;
        TextView r17 = this.e;
        if (r17 == null) goto L38;
        r17.setVisibility(8);
        return;
    L38:
        return;
    L37:
        return;
    L29:
        r16 = 0;
        goto L31
    L19:
        r12 = null;
        goto L20
    }
}
