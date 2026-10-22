package com.larksuite.framework.ui.flowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes24.dex */
public class TagFlowLayout extends FlowLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p28.a f285854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f285855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f285856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MotionEvent f285857i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Integer> f285858j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f285859k;

    public interface a {
    }

    public interface b {
    }

    public void setOnSelectListener(a r100) {
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f285858j);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("key_default", super.onSaveInstanceState());
        String r101 = "";
        if (((HashSet) this.f285858j).size() <= 0) goto L9;
        Iterator r102 = ((HashSet) this.f285858j).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101 = r101 + ((Integer) r102.next()).intValue() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        goto L6
    L8:
        r101 = r101.substring(0, r101.length() - 1);
    L9:
        r100.putString("key_choose_pos", r101);
        return r100;
    }

    @Override // android.view.View
    public final boolean performClick() {
        MotionEvent r100 = this.f285857i;
        if (r100 == null) goto L5;
        int r101 = (int) r100.getX();
        int r102 = (int) this.f285857i.getY();
        p28.b r103 = null;
        this.f285857i = null;
        int r104 = getChildCount();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L15;
        p28.b r106 = (p28.b) getChildAt(r105);
        if (r106.getVisibility() == 8) goto L14;
        Rect r107 = new Rect();
        r106.getHitRect(r107);
        if (r107.contains(r101, r102) == false) goto L14;
        r103 = r106;
    L14:
        r105 = r105 + 1;
    L15:
        int r108 = getChildCount();
        int r109 = 0;
    L16:
        if (r109 >= r108) goto L21;
        if (getChildAt(r109) == r103) goto L23;
        r109 = r109 + 1;
    L23:
        if (r103 != null) goto L25;
    L40:
        return true;
    L25:
        if (this.f285855g == false) goto L40;
        if (r103.f527467a == false) goto L29;
        r103.setChecked(false);
        Set<Integer> r110 = this.f285858j;
        HashSet r111 = (HashSet) r110;
        r111.remove(Integer.valueOf(r109));
        goto L40
    L29:
        if (this.f285856h != 1) goto L34;
        if (((HashSet) this.f285858j).size() != 1) goto L34;
        Integer r112 = (Integer) ((HashSet) this.f285858j).iterator().next();
        ((p28.b) getChildAt(r112.intValue())).setChecked(false);
        r103.setChecked(true);
        ((HashSet) this.f285858j).remove(r112);
        Set<Integer> r113 = this.f285858j;
        HashSet r114 = (HashSet) r113;
        r114.add(Integer.valueOf(r109));
    L34:
        if (this.f285856h > 0) goto L36;
    L38:
        r103.setChecked(true);
        Set<Integer> r115 = this.f285858j;
        HashSet r116 = (HashSet) r115;
        r116.add(Integer.valueOf(r109));
        goto L40
    L36:
        if (((HashSet) this.f285858j).size() < this.f285856h) goto L38;
    L21:
        r109 = -1;
        goto L23
    L5:
        return super.performClick();
    }

    public p28.a getAdapter() {
        return this.f285854f;
    }

    public TagFlowLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof Bundle) == false) goto L14;
        Bundle r101 = (Bundle) r100;
        String r102 = r101.getString("key_choose_pos");
        if (TextUtils.isEmpty(r102) == true) goto L12;
        String[] r103 = r102.split("\\|");
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L12;
        int r106 = CastIntegerProtector.parseInt(r103[r105]);
        Set<Integer> r107 = this.f285858j;
        HashSet r108 = (HashSet) r107;
        r108.add(Integer.valueOf(r106));
        p28.b r109 = (p28.b) getChildAt(r106);
        if (r109 == null) goto L11;
        r109.setChecked(true);
    L11:
        r105 = r105 + 1;
    L12:
        super.onRestoreInstanceState(r101.getParcelable("key_default"));
        return;
    L14:
        super.onRestoreInstanceState(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 1) goto L6;
        this.f285857i = MotionEvent.obtain(r100);
    L6:
        return super.onTouchEvent(r100);
    }

    public void setAdapter(p28.a r110) {
        this.f285854f = r110;
        r110.getClass();
        ((HashSet) this.f285858j).clear();
        removeAllViews();
        p28.a r111 = this.f285854f;
        HashSet<Integer> r100 = r111.f527465b;
        int r101 = 0;
    L3:
        List<T> r102 = r111.f527464a;
        if (r102 != 0) goto L6;
        int r103 = 0;
    L7:
        if (r101 >= r103) goto L15;
        View r104 = r111.a(this, ListProtector.get(r111.f527464a, r101));
        p28.b r105 = new p28.b(getContext());
        r104.setDuplicateParentStateEnabled(true);
        if (r104.getLayoutParams() != null) goto L11;
        ViewGroup.MarginLayoutParams r106 = new ViewGroup.MarginLayoutParams(-2, -2);
        r106.setMargins(a(getContext(), this.f285859k), a(getContext(), this.f285859k), a(getContext(), this.f285859k), a(getContext(), this.f285859k));
        r105.setLayoutParams(r106);
    L11:
        r105.addView(r104);
        addView(r105);
        if (r100.contains(Integer.valueOf(r101)) == false) goto L14;
        r105.setChecked(true);
    L14:
        p28.a r107 = this.f285854f;
        ListProtector.get(r111.f527464a, r101);
        r107.getClass();
        r101 = r101 + 1;
        goto L3
    L15:
        this.f285858j.addAll(r100);
        return;
    L6:
        r103 = r102.size();
        goto L7
    }

    public void setMaxSelectCount(int r100) {
        if (((HashSet) this.f285858j).size() <= r100) goto L5;
        ((HashSet) this.f285858j).clear();
    L5:
        this.f285856h = r100;
    }

    public void setOnTagClickListener(b r100) {
        if (r100 == null) goto L5;
        setClickable(true);
        return;
    }

    public void setTagMarginInDp(int r100) {
        this.f285859k = r100;
    }

    public TagFlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static int a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // com.larksuite.framework.ui.flowlayout.FlowLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        p28.b r104 = (p28.b) getChildAt(r103);
        if (r104.getVisibility() == 8) goto L10;
        if (r104.getTagView().getVisibility() != 8) goto L10;
        r104.setVisibility(8);
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        super.onMeasure(r100, r101);
    }

    public TagFlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f285855g = true;
        this.f285856h = -1;
        this.f285858j = new HashSet();
        this.f285859k = 5;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.auto_select_effect, R.attr.gravity, R.attr.marginOutside, R.attr.maxLines, R.attr.max_select, R.attr.paddingBottom, R.attr.paddingEnd, R.attr.paddingStart, R.attr.paddingTop, R.attr.rowSpacing, R.attr.tag_gravity_ec, R.attr.tag_maxline, R.attr.tag_space_horizontal, R.attr.tag_space_vertical, R.attr.textColor, R.attr.textSize});
        boolean r104 = r103.getBoolean(0, true);
        this.f285855g = r104;
        this.f285856h = r103.getInt(4, -1);
        r103.recycle();
        if (r104 == false) goto L6;
        setClickable(true);
        return;
    }
}
