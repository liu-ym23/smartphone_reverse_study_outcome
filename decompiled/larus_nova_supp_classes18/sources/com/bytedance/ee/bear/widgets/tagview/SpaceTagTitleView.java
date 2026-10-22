package com.bytedance.ee.bear.widgets.tagview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceTagTitleView extends LinearLayout {
    public float a;
    public final float b;
    public final TextView c;
    public final TextView d;
    public final List<Pair<SpaceTagType, View>> e;
    public final List<Pair<SpaceTagType, View>> f;

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

    public CharSequence getTitle() {
        return this.c.getText();
    }

    public SpaceTagTitleView(Context r2) {
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
        if (hu5.a.d(this.e) == true) goto L16;
        Iterator r1 = ((ArrayList) this.e).iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        View r2 = (View) ((Pair) r1.next()).second;
        if (r2 == null) goto L10;
        removeView(r2);
        goto L10
    L14:
        ((ArrayList) this.e).clear();
    L16:
        if (hu5.a.d(this.f) == true) goto L18;
        ((ArrayList) this.f).clear();
    L18:
        Iterator<SpaceTagType> r7 = r6.iterator();
    L20:
        if (r7.hasNext() == false) goto L42;
        SpaceTagType r3 = r7.next();
        if (r3.a == false) goto L20;
        Function1<Context, View> r4 = r3.d;
        if (r4 == null) goto L20;
        View r5 = (View) r4.invoke(r0);
        if (r5 == null) goto L20;
        if (r5.getLayoutParams() == null) goto L30;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(r5.getLayoutParams());
    L31:
        r8.gravity = 17;
        if (((ArrayList) this.e).size() != 0) goto L34;
        float r9 = this.a;
    L35:
        r8.leftMargin = (int) r9;
        r5.setLayoutParams(r8);
        Pair r10 = new Pair(r3, r5);
        ((ArrayList) this.e).add(r10);
        if (r3.b != null) goto L38;
    L40:
        addView(r5);
        goto L20
    L38:
        if (r3.c == null) goto L40;
        ((ArrayList) this.f).add(r10);
        goto L40
    L34:
        r9 = this.b;
        goto L35
    L30:
        r8 = new LinearLayout.LayoutParams(-2, -2);
        goto L31
    L42:
        if (hu5.a.d(this.f) == true) goto L61;
        Collections.sort(this.f, new a());
        return;
    }

    public void setLabelsMargin(int r1) {
        this.a = r1;
    }

    public void setTitle(int r2) {
        setTitle(getResources().getString(r2));
    }

    public void setTitleBold(boolean r2) {
        this.c.getPaint().setFakeBoldText(r2);
    }

    public void setTitleColor(int r2) {
        this.c.setTextColor(r2);
    }

    public void setTitleMaxLines(int r3) {
        if (r3 != 1) goto L5;
        this.c.setSingleLine(true);
        this.c.setMaxLines(1);
        return;
    L5:
        this.c.setSingleLine(false);
        this.c.setMaxLines(r3);
    }

    public void setTitleSize(float r2) {
        this.c.setTextSize(r2);
    }

    public void setTitleVisibility(boolean r2) {
        TextView r0 = this.c;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public void setUnConstraintTitle(CharSequence r2) {
        if (TextUtils.isEmpty(r2) == true) goto L5;
        this.d.setText(r2);
        this.d.setVisibility(0);
        return;
    L5:
        this.d.setText(null);
        this.d.setVisibility(8);
    }

    public void setLabels(SpaceTagType... r3) {
        ArrayList r0 = new ArrayList(r3.length);
        Collections.addAll(r0, r3);
        setLabels(r0);
    }

    public void setTitle(CharSequence r2) {
        this.c.setText(r2);
    }

    public SpaceTagTitleView(Context r2, AttributeSet r3) {
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
    L11:
        if (this.d.getVisibility() != 0) goto L13;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        int r5 = (this.d.getMeasuredWidth() + r4.leftMargin) + r4.rightMargin;
    L14:
        Iterator r6 = ((ArrayList) this.e).iterator();
        int r7 = 0;
    L16:
        if (r6.hasNext() == false) goto L20;
        Pair r8 = (Pair) r6.next();
        if (r8 == null) goto L16;
        View r9 = (View) r8.second;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9.getLayoutParams();
        r7 = r7 + ((r9.getMeasuredWidth() + r10.leftMargin) + r10.rightMargin);
        goto L16
    L20:
        int r15 = ((r5 + r3) + r7) - r13;
        if (r15 > 0) goto L23;
    L38:
        r0 = r15;
    L39:
        if (r0 <= 0) goto L42;
        if (r3 <= r0) goto L42;
        r3 = r3 - r0;
    L42:
        this.c.measure(View.MeasureSpec.makeMeasureSpec(r3, 1073741824), View.MeasureSpec.makeMeasureSpec(this.c.getMeasuredHeight(), 1073741824));
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r13, 1073741824), View.MeasureSpec.makeMeasureSpec(r14, 1073741824));
        return;
    L23:
        if (hu5.a.d(this.f) == true) goto L38;
        Iterator r16 = ((ArrayList) this.f).iterator();
    L26:
        if (r16.hasNext() == false) goto L38;
        Pair r17 = (Pair) r16.next();
        SpaceTagType r18 = (SpaceTagType) r17.first;
        View r19 = (View) r17.second;
        if (r19 == null) goto L26;
        if (r18 == null) goto L26;
        Integer r20 = r18.c;
        if (r20 == null) goto L26;
        int r21 = n.d(r20.intValue());
        int r22 = r19.getMeasuredWidth();
        if (r22 <= r21) goto L26;
        int r23 = r22 - r15;
        if (r23 >= r21) goto L37;
        r19.measure(View.MeasureSpec.makeMeasureSpec(r21, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(r19.getMeasuredHeight(), 1073741824));
        r15 = r15 - (r22 - r19.getMeasuredWidth());
        goto L26
    L37:
        r19.measure(View.MeasureSpec.makeMeasureSpec(r23, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(r19.getMeasuredHeight(), 1073741824));
        goto L39
    L13:
        r5 = 0;
        goto L14
    L9:
        r3 = 0;
        goto L11
    }

    public SpaceTagTitleView(Context r11, AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.e = new ArrayList();
        this.f = new ArrayList();
        TypedArray r14 = r11.obtainStyledAttributes(r12, new int[]{2130974575, 2130974583, 2130974585, 2130974586, 2130974587, 2130974588});
        String r15 = r14.getString(5);
        float r0 = r14.getDimension(2, getResources().getDimension(2131166502));
        int r1 = r14.getColor(0, getResources().getColor(2131106622));
        int r4 = r14.getInt(1, 1);
        this.a = r14.getDimension(4, getResources().getDimension(2131166501));
        this.b = r14.getDimension(3, getResources().getDimension(2131166501));
        r14.recycle();
        setOrientation(0);
        setGravity(16);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, -2);
        r5.gravity = 17;
        TextView r8 = new TextView(r11);
        this.c = r8;
        r8.setEllipsize(TextUtils.TruncateAt.END);
        r8.setGravity(16);
        r8.setTextSize(0, r0);
        r8.setTextColor(r1);
        if (TextUtils.isEmpty(r15) == true) goto L5;
        r8.setText(r15);
    L5:
        if (r4 != 1) goto L7;
        r8.setSingleLine(true);
    L8:
        addView(r8, r5);
        ViewGroup.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -2);
        r5.gravity = 17;
        TextView r6 = new TextView(r11);
        this.d = r6;
        r6.setGravity(16);
        r6.setTextSize(0, r0);
        r6.setTextColor(r1);
        r6.setSingleLine(true);
        r6.setVisibility(8);
        addView(r6, r16);
        return;
    L7:
        r8.setSingleLine(false);
        r8.setMaxLines(r4);
        goto L8
    }
}
