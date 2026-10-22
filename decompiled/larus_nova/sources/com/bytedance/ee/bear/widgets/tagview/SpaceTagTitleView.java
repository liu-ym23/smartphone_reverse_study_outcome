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
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceTagTitleView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f240333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f240334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f240335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f240336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Pair<SpaceTagType, View>> f240337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Pair<SpaceTagType, View>> f240338f;

    public class a implements Comparator<Pair<SpaceTagType, View>> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Pair<SpaceTagType, View> r100, Pair<SpaceTagType, View> r101) {
            Pair<SpaceTagType, View> r102 = r100;
            Pair<SpaceTagType, View> r103 = r101;
            if (r102 == null) goto L11;
            if (r103 == null) goto L11;
            Integer r104 = ((SpaceTagType) r102.first).f240341b;
            Integer r105 = ((SpaceTagType) r103.first).f240341b;
            if (r104 == null) goto L11;
            if (r105 == null) goto L11;
            return r105.intValue() - r104.intValue();
        L11:
            return 0;
        }
    }

    public CharSequence getTitle() {
        return this.f240335c.getText();
    }

    public SpaceTagTitleView(Context r100) {
        this(r100, null);
    }

    public void setLabels(List<SpaceTagType> r100) {
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        if (hu5.a.d(r100) == false) goto L7;
        return;
    L7:
        if (hu5.a.d(this.f240337e) == true) goto L16;
        Iterator r102 = ((ArrayList) this.f240337e).iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        View r103 = (View) ((Pair) r102.next()).second;
        if (r103 == null) goto L10;
        removeView(r103);
        goto L10
    L14:
        ((ArrayList) this.f240337e).clear();
    L16:
        if (hu5.a.d(this.f240338f) == true) goto L18;
        ((ArrayList) this.f240338f).clear();
    L18:
        Iterator<SpaceTagType> r104 = r100.iterator();
    L20:
        if (r104.hasNext() == false) goto L42;
        SpaceTagType r105 = r104.next();
        if (r105.f240340a == false) goto L20;
        Function1<Context, View> r106 = r105.f240343d;
        if (r106 == null) goto L20;
        View r107 = r106.invoke(r101);
        if (r107 == null) goto L20;
        if (r107.getLayoutParams() == null) goto L30;
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(r107.getLayoutParams());
    L31:
        r108.gravity = 17;
        if (((ArrayList) this.f240337e).size() != 0) goto L34;
        float r109 = this.f240333a;
    L35:
        r108.leftMargin = (int) r109;
        r107.setLayoutParams(r108);
        Pair r110 = new Pair(r105, r107);
        ((ArrayList) this.f240337e).add(r110);
        if (r105.f240341b != null) goto L38;
    L40:
        addView(r107);
        goto L20
    L38:
        if (r105.f240342c == null) goto L40;
        ((ArrayList) this.f240338f).add(r110);
        goto L40
    L34:
        r109 = this.f240334b;
        goto L35
    L30:
        r108 = new LinearLayout.LayoutParams(-2, -2);
        goto L31
    L42:
        if (hu5.a.d(this.f240338f) == true) goto L61;
        Collections.sort(this.f240338f, new a());
        return;
    }

    public void setLabelsMargin(int r100) {
        this.f240333a = r100;
    }

    public void setTitle(int r100) {
        setTitle(getResources().getString(r100));
    }

    public void setTitleBold(boolean r100) {
        this.f240335c.getPaint().setFakeBoldText(r100);
    }

    public void setTitleColor(int r100) {
        this.f240335c.setTextColor(r100);
    }

    public void setTitleMaxLines(int r100) {
        if (r100 != 1) goto L5;
        this.f240335c.setSingleLine(true);
        this.f240335c.setMaxLines(1);
        return;
    L5:
        this.f240335c.setSingleLine(false);
        this.f240335c.setMaxLines(r100);
    }

    public void setTitleSize(float r100) {
        this.f240335c.setTextSize(r100);
    }

    public void setTitleVisibility(boolean r100) {
        TextView r101 = this.f240335c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public void setUnConstraintTitle(CharSequence r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.f240336d.setText(r100);
        this.f240336d.setVisibility(0);
        return;
    L5:
        this.f240336d.setText(null);
        this.f240336d.setVisibility(8);
    }

    public void setLabels(SpaceTagType... r100) {
        ArrayList r101 = new ArrayList(r100.length);
        Collections.addAll(r101, r100);
        setLabels(r101);
    }

    public void setTitle(CharSequence r100) {
        this.f240335c.setText(r100);
    }

    public SpaceTagTitleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L6;
        measureChildWithMargins(getChildAt(r101), r110, 0, r111, 0);
        r101 = r101 + 1;
        goto L4
    L6:
        int r112 = getMeasuredWidth();
        int r113 = getMeasuredHeight();
        if (this.f240335c.getVisibility() != 0) goto L9;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) this.f240335c.getLayoutParams();
        int r103 = (this.f240335c.getMeasuredWidth() + r102.leftMargin) + r102.rightMargin;
    L11:
        if (this.f240336d.getVisibility() != 0) goto L13;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) this.f240336d.getLayoutParams();
        int r105 = (this.f240336d.getMeasuredWidth() + r104.leftMargin) + r104.rightMargin;
    L14:
        Iterator r106 = ((ArrayList) this.f240337e).iterator();
        int r107 = 0;
    L16:
        if (r106.hasNext() == false) goto L20;
        Pair r108 = (Pair) r106.next();
        if (r108 == null) goto L16;
        View r109 = (View) r108.second;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r109.getLayoutParams();
        r107 = r107 + ((r109.getMeasuredWidth() + r114.leftMargin) + r114.rightMargin);
        goto L16
    L20:
        int r115 = ((r105 + r103) + r107) - r112;
        if (r115 > 0) goto L23;
    L38:
        r100 = r115;
    L39:
        if (r100 <= 0) goto L42;
        if (r103 <= r100) goto L42;
        r103 = r103 - r100;
    L42:
        this.f240335c.measure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f240335c.getMeasuredHeight(), 1073741824));
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r112, 1073741824), View.MeasureSpec.makeMeasureSpec(r113, 1073741824));
        return;
    L23:
        if (hu5.a.d(this.f240338f) == true) goto L38;
        Iterator r116 = ((ArrayList) this.f240338f).iterator();
    L26:
        if (r116.hasNext() == false) goto L38;
        Pair r117 = (Pair) r116.next();
        SpaceTagType r118 = (SpaceTagType) r117.first;
        View r119 = (View) r117.second;
        if (r119 == null) goto L26;
        if (r118 == null) goto L26;
        Integer r120 = r118.f240342c;
        if (r120 == null) goto L26;
        int r121 = n.d(r120.intValue());
        int r122 = r119.getMeasuredWidth();
        if (r122 <= r121) goto L26;
        int r123 = r122 - r115;
        if (r123 >= r121) goto L37;
        r119.measure(View.MeasureSpec.makeMeasureSpec(r121, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(r119.getMeasuredHeight(), 1073741824));
        r115 = r115 - (r122 - r119.getMeasuredWidth());
        goto L26
    L37:
        r119.measure(View.MeasureSpec.makeMeasureSpec(r123, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(r119.getMeasuredHeight(), 1073741824));
        goto L39
    L13:
        r105 = 0;
        goto L14
    L9:
        r103 = 0;
        goto L11
    }

    public SpaceTagTitleView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.f240337e = new ArrayList();
        this.f240338f = new ArrayList();
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.titleColor, R.attr.titleMaxLines, R.attr.titleSize, R.attr.titleTagInterval, R.attr.titleTagMargin, R.attr.titleText});
        String r114 = r113.getString(5);
        float r100 = r113.getDimension(2, getResources().getDimension(R.dimen.facade_title_text_size));
        int r101 = r113.getColor(0, getResources().getColor(R.color.text_title));
        int r102 = r113.getInt(1, 1);
        this.f240333a = r113.getDimension(4, getResources().getDimension(R.dimen.facade_star_view_margin_left));
        this.f240334b = r113.getDimension(3, getResources().getDimension(R.dimen.facade_star_view_margin_left));
        r113.recycle();
        setOrientation(0);
        setGravity(16);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        TextView r104 = new TextView(r110);
        this.f240335c = r104;
        r104.setEllipsize(TextUtils.TruncateAt.END);
        r104.setGravity(16);
        r104.setTextSize(0, r100);
        r104.setTextColor(r101);
        if (TextUtils.isEmpty(r114) == true) goto L5;
        r104.setText(r114);
    L5:
        if (r102 != 1) goto L7;
        r104.setSingleLine(true);
    L8:
        addView(r104, r103);
        ViewGroup.LayoutParams r115 = new LinearLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        TextView r105 = new TextView(r110);
        this.f240336d = r105;
        r105.setGravity(16);
        r105.setTextSize(0, r100);
        r105.setTextColor(r101);
        r105.setSingleLine(true);
        r105.setVisibility(8);
        addView(r105, r115);
        return;
    L7:
        r104.setSingleLine(false);
        r104.setMaxLines(r102);
        goto L8
    }
}
