package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4PriceViewContainer;", "Landroid/widget/LinearLayout;", "", "width", "", "setMaxWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4PriceViewContainer extends LinearLayout {
    public int a;

    public AnchorV4PriceViewContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4PriceViewContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setMaxWidth(int r1) {
        this.a = r1;
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        List r10 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r0 = new ArrayList();
        Iterator r11 = r10.iterator();
    L6:
        boolean r2 = false;
        if (r11.hasNext() == false) goto L13;
        Object r1 = r11.next();
        if (((View) r1).getVisibility() != 0) goto L11;
        r2 = true;
    L11:
        if (r2 == false) goto L6;
        r0.add(r1);
        goto L6
    L13:
        Iterator r12 = r0.iterator();
        int r3 = 0;
    L14:
        ViewGroup.LayoutParams r4 = null;
        if (r12.hasNext() == false) goto L24;
        View r5 = (View) r12.next();
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r4 = r6;
    L20:
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r4;
        if (r7 == null) goto L23;
        r3 = r3 + (r7.leftMargin + r7.rightMargin);
    L23:
        r3 = r3 + r5.getMeasuredWidth();
        goto L14
    L24:
        int r13 = Math.min(getMeasuredWidth(), r3);
        int r14 = this.a;
        if (1 > r14) goto L49;
        if (r13 <= r14) goto L46;
        setOrientation(1);
        View r15 = (View) CollectionsKt.getOrNull(r0, 1);
        if (r15 == null) goto L47;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L34;
        r4 = r16;
    L34:
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r4;
        if (r17 == null) goto L48;
        r17.leftMargin = 0;
        r15.setLayoutParams(r17);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    }

    public AnchorV4PriceViewContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ AnchorV4PriceViewContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
