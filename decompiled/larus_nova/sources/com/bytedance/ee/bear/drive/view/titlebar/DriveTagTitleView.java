package com.bytedance.ee.bear.drive.view.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public class DriveTagTitleView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f225854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f225855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f225856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Pair<SpaceTagType, View>> f225857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Pair<SpaceTagType, View>> f225858e;

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

    public DriveTagTitleView(Context r100) {
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
        if (hu5.a.d(this.f225857d) == true) goto L16;
        Iterator r102 = ((ArrayList) this.f225857d).iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        View r103 = (View) ((Pair) r102.next()).second;
        if (r103 == null) goto L10;
        removeView(r103);
        goto L10
    L14:
        ((ArrayList) this.f225857d).clear();
    L16:
        if (hu5.a.d(this.f225858e) == true) goto L18;
        ((ArrayList) this.f225858e).clear();
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
        if (((ArrayList) this.f225857d).size() != 0) goto L34;
        float r109 = this.f225854a;
    L35:
        r108.leftMargin = (int) r109;
        r107.setLayoutParams(r108);
        Pair r110 = new Pair(r105, r107);
        ((ArrayList) this.f225857d).add(r110);
        if (r105.f240341b != null) goto L38;
    L40:
        addView(r107);
        goto L20
    L38:
        if (r105.f240342c == null) goto L40;
        ((ArrayList) this.f225858e).add(r110);
        goto L40
    L34:
        r109 = this.f225855b;
        goto L35
    L30:
        r108 = new LinearLayout.LayoutParams(-2, -2);
        goto L31
    L42:
        if (hu5.a.d(this.f225858e) == true) goto L61;
        Collections.sort(this.f225858e, new a());
        return;
    }

    public void setLabelsMargin(int r100) {
        this.f225854a = r100;
    }

    public void setTitleView(View r100) {
        this.f225856c = r100;
        addView(r100);
    }

    public void setLabels(SpaceTagType... r100) {
        ArrayList r101 = new ArrayList(r100.length);
        Collections.addAll(r101, r100);
        setLabels(r101);
    }

    public DriveTagTitleView(Context r100, AttributeSet r101) {
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
        if (this.f225856c.getVisibility() != 0) goto L9;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) this.f225856c.getLayoutParams();
        int r103 = (this.f225856c.getMeasuredWidth() + r102.leftMargin) + r102.rightMargin;
    L10:
        Iterator r104 = ((ArrayList) this.f225857d).iterator();
        int r105 = 0;
    L12:
        if (r104.hasNext() == false) goto L16;
        Pair r106 = (Pair) r104.next();
        if (r106 == null) goto L12;
        View r107 = (View) r106.second;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107.getLayoutParams();
        r105 = r105 + ((r107.getMeasuredWidth() + r108.leftMargin) + r108.rightMargin);
        goto L12
    L16:
        int r109 = ((r103 + 0) + r105) - r112;
        if (r109 > 0) goto L19;
    L34:
        r100 = r109;
    L35:
        if (r100 <= 0) goto L38;
        if (r103 <= r100) goto L38;
        r103 = r103 - r100;
    L38:
        this.f225856c.measure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f225856c.getMeasuredHeight(), 1073741824));
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(r112, 1073741824), View.MeasureSpec.makeMeasureSpec(r113, 1073741824));
        return;
    L19:
        if (hu5.a.d(this.f225858e) == true) goto L34;
        Iterator r114 = ((ArrayList) this.f225858e).iterator();
    L22:
        if (r114.hasNext() == false) goto L34;
        Pair r115 = (Pair) r114.next();
        SpaceTagType r116 = (SpaceTagType) r115.first;
        View r117 = (View) r115.second;
        if (r117 == null) goto L22;
        if (r116 == null) goto L22;
        Integer r118 = r116.f240342c;
        if (r118 == null) goto L22;
        int r119 = n.d(r118.intValue());
        int r120 = r117.getMeasuredWidth();
        if (r120 <= r119) goto L22;
        int r121 = r120 - r109;
        if (r121 >= r119) goto L33;
        r117.measure(View.MeasureSpec.makeMeasureSpec(r119, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(r117.getMeasuredHeight(), 1073741824));
        r109 = r109 - (r120 - r117.getMeasuredWidth());
        goto L22
    L33:
        r117.measure(View.MeasureSpec.makeMeasureSpec(r121, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(r117.getMeasuredHeight(), 1073741824));
        goto L35
    L9:
        r103 = 0;
        goto L10
    }

    public DriveTagTitleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225857d = new ArrayList();
        this.f225858e = new ArrayList();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.titleColor, R.attr.titleMaxLines, R.attr.titleSize, R.attr.titleTagInterval, R.attr.titleTagMargin, R.attr.titleText});
        this.f225854a = r103.getDimension(4, getResources().getDimension(R.dimen.facade_star_view_margin_left));
        this.f225855b = r103.getDimension(3, getResources().getDimension(R.dimen.facade_star_view_margin_left));
        r103.recycle();
        setOrientation(0);
        setGravity(16);
        new LinearLayout.LayoutParams(-2, -2).gravity = 17;
    }
}
