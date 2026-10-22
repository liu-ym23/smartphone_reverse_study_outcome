package com.bytedance.ee.bear.drive.view.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.util.ui.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveTagTitleView extends LinearLayout {
    public float a;
    public final float b;
    public View c;
    public final List<Pair<SpaceTagType, View>> d;
    public final List<Pair<SpaceTagType, View>> e;

    public class a implements Comparator<Pair<SpaceTagType, View>> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Pair<SpaceTagType, View> r1, Pair<SpaceTagType, View> r2) {
            Pair<SpaceTagType, View> r3 = r1;
            Pair<SpaceTagType, View> r4 = r2;
            if (r3 == null) goto L11;
            if (r4 == null) goto L11;
            Integer r5 = ((SpaceTagType) r3.first).b;
            Integer r6 = ((SpaceTagType) r4.first).b;
            if (r5 == null) goto L11;
            if (r6 == null) goto L11;
            return r6.intValue() - r5.intValue();
        L11:
            return 0;
        }
    }

    public DriveTagTitleView(Context r2) {
        this(r2, null);
    }

    public void setLabels(List<SpaceTagType> r6) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        if (hu5.a.d(r6) == false) goto L7;
        return;
    L7:
        if (hu5.a.d(this.d) == true) goto L16;
        Iterator r1 = ((ArrayList) this.d).iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        View r2 = (View) ((Pair) r1.next()).second;
        if (r2 == null) goto L10;
        removeView(r2);
        goto L10
    L14:
        ((ArrayList) this.d).clear();
    L16:
        if (hu5.a.d(this.e) == true) goto L18;
        ((ArrayList) this.e).clear();
    L18:
        Iterator<SpaceTagType> r7 = r6.iterator();
    L20:
        if (r7.hasNext() == false) goto L42;
        SpaceTagType r3 = r7.next();
        if (r3.a == false) goto L20;
        Function1 r4 = r3.d;
        if (r4 == null) goto L20;
        View r5 = (View) r4.invoke(r0);
        if (r5 == null) goto L20;
        if (r5.getLayoutParams() == null) goto L30;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(r5.getLayoutParams());
    L31:
        r8.gravity = 17;
        if (((ArrayList) this.d).size() != 0) goto L34;
        float r9 = this.a;
    L35:
        r8.leftMargin = (int) r9;
        r5.setLayoutParams(r8);
        Pair r10 = new Pair(r3, r5);
        ((ArrayList) this.d).add(r10);
        if (r3.b != null) goto L38;
    L40:
        addView(r5);
        goto L20
    L38:
        if (r3.c == null) goto L40;
        ((ArrayList) this.e).add(r10);
        goto L40
    L34:
        r9 = this.b;
        goto L35
    L30:
        r8 = new LinearLayout.LayoutParams(-2, -2);
        goto L31
    L42:
        if (hu5.a.d(this.e) == true) goto L61;
        Collections.sort(this.e, new a());
        return;
    }

    public void setLabelsMargin(int r1) {
        this.a = r1;
    }

    public void setTitleView(View r1) {
        this.c = r1;
        addView(r1);
    }

    public void setLabels(SpaceTagType... r3) {
        ArrayList r0 = new ArrayList(r3.length);
        Collections.addAll(r0, r3);
        setLabels(r0);
    }

    public DriveTagTitleView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= getChildCount()) goto L6;
        measureChildWithMargins(getChildAt(r1), r11, 0, r12, 0);
        r1 = r1 + 1;
        goto L4
    L6:
        int r13 = getMeasuredWidth();
        int r14 = getMeasuredHeight();
        if (this.c.getVisibility() != 0) goto L9;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        int r3 = (this.c.getMeasuredWidth() + r2.leftMargin) + r2.rightMargin;
    L10:
        Iterator r4 = ((ArrayList) this.d).iterator();
        int r5 = 0;
    L12:
        if (r4.hasNext() == false) goto L16;
        Pair r6 = (Pair) r4.next();
        if (r6 == null) goto L12;
        View r7 = (View) r6.second;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7.getLayoutParams();
        r5 = r5 + ((r7.getMeasuredWidth() + r8.leftMargin) + r8.rightMargin);
        goto L12
    L16:
        int r9 = ((r3 + 0) + r5) - r13;
        if (r9 > 0) goto L19;
    L34:
        r0 = r9;
    L35:
        if (r0 <= 0) goto L38;
        if (r3 <= r0) goto L38;
        r3 = r3 - r0;
    L38:
        this.c.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.c.getMeasuredHeight(), 1073741824));
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r13, 1073741824), View.MeasureSpec.makeMeasureSpec(r14, 1073741824));
        return;
    L19:
        if (hu5.a.d(this.e) == true) goto L34;
        Iterator r10 = ((ArrayList) this.e).iterator();
    L22:
        if (r10.hasNext() == false) goto L34;
        Pair r16 = (Pair) r10.next();
        SpaceTagType r17 = (SpaceTagType) r16.first;
        View r18 = (View) r16.second;
        if (r18 == null) goto L22;
        if (r17 == null) goto L22;
        Integer r19 = r17.c;
        if (r19 == null) goto L22;
        int r20 = n.d(r19.intValue());
        int r21 = r18.getMeasuredWidth();
        if (r21 <= r20) goto L22;
        int r22 = r21 - r9;
        if (r22 >= r20) goto L33;
        r18.measure(View.MeasureSpec.makeMeasureSpec(r20, ShareItemModel.SRC_TINT_UNDEFINED), View.MeasureSpec.makeMeasureSpec(r18.getMeasuredHeight(), 1073741824));
        r9 = r9 - (r21 - r18.getMeasuredWidth());
        goto L22
    L33:
        r18.measure(View.MeasureSpec.makeMeasureSpec(r22, ShareItemModel.SRC_TINT_UNDEFINED), View.MeasureSpec.makeMeasureSpec(r18.getMeasuredHeight(), 1073741824));
        goto L35
    L9:
        r3 = 0;
        goto L10
    }

    public DriveTagTitleView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.d = new ArrayList();
        this.e = new ArrayList();
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130974575, 2130974583, 2130974585, 2130974586, 2130974587, 2130974588});
        this.a = r5.getDimension(4, getResources().getDimension(2131166501));
        this.b = r5.getDimension(3, getResources().getDimension(2131166501));
        r5.recycle();
        setOrientation(0);
        setGravity(16);
        new LinearLayout.LayoutParams(-2, -2).gravity = 17;
    }
}
