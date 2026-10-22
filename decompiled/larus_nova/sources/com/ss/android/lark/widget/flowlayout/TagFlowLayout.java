package com.ss.android.lark.widget.flowlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes38.dex */
public class TagFlowLayout extends FlowLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f445851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f445852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MotionEvent f445853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<Integer> f445854i;

    public interface a {
    }

    public interface b {
    }

    public icc.a getAdapter() {
        return null;
    }

    public void setOnSelectListener(a r100) {
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.f445854i);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("key_default", super.onSaveInstanceState());
        String r101 = "";
        if (((HashSet) this.f445854i).size() <= 0) goto L9;
        Iterator r102 = ((HashSet) this.f445854i).iterator();
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
        MotionEvent r100 = this.f445853h;
        if (r100 == null) goto L5;
        int r101 = (int) r100.getX();
        int r102 = (int) this.f445853h.getY();
        icc.b r103 = null;
        this.f445853h = null;
        int r104 = getChildCount();
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L15;
        icc.b r106 = (icc.b) getChildAt(r105);
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
        if (this.f445851f == false) goto L40;
        if (r103.f489272a == false) goto L29;
        r103.setChecked(false);
        Set<Integer> r110 = this.f445854i;
        HashSet r111 = (HashSet) r110;
        r111.remove(Integer.valueOf(r109));
        goto L40
    L29:
        if (this.f445852g != 1) goto L34;
        if (((HashSet) this.f445854i).size() != 1) goto L34;
        Integer r112 = (Integer) ((HashSet) this.f445854i).iterator().next();
        ((icc.b) getChildAt(r112.intValue())).setChecked(false);
        r103.setChecked(true);
        ((HashSet) this.f445854i).remove(r112);
        Set<Integer> r113 = this.f445854i;
        HashSet r114 = (HashSet) r113;
        r114.add(Integer.valueOf(r109));
    L34:
        if (this.f445852g > 0) goto L36;
    L38:
        r103.setChecked(true);
        Set<Integer> r115 = this.f445854i;
        HashSet r116 = (HashSet) r115;
        r116.add(Integer.valueOf(r109));
        goto L40
    L36:
        if (((HashSet) this.f445854i).size() < this.f445852g) goto L38;
    L21:
        r109 = -1;
        goto L23
    L5:
        return super.performClick();
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
        Set<Integer> r107 = this.f445854i;
        HashSet r108 = (HashSet) r107;
        r108.add(Integer.valueOf(r106));
        icc.b r109 = (icc.b) getChildAt(r106);
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
        this.f445853h = MotionEvent.obtain(r100);
    L6:
        return super.onTouchEvent(r100);
    }

    public void setAdapter(icc.a r100) {
        throw null;
    }

    public void setMaxSelectCount(int r100) {
        if (((HashSet) this.f445854i).size() <= r100) goto L5;
        Log.w("TagFlowLayout", "you has already select more than " + r100 + " views , so it will be clear .");
        ((HashSet) this.f445854i).clear();
    L5:
        this.f445852g = r100;
    }

    public void setOnTagClickListener(b r100) {
        if (r100 == null) goto L5;
        setClickable(true);
        return;
    }

    public TagFlowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // com.ss.android.lark.widget.flowlayout.FlowLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        icc.b r104 = (icc.b) getChildAt(r103);
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
        this.f445851f = true;
        this.f445852g = -1;
        this.f445854i = new HashSet();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.auto_select_effect, R.attr.gravity, R.attr.marginOutside, R.attr.maxLines, R.attr.max_select, R.attr.paddingBottom, R.attr.paddingEnd, R.attr.paddingStart, R.attr.paddingTop, R.attr.rowSpacing, R.attr.tag_gravity_ec, R.attr.tag_maxline, R.attr.tag_space_horizontal, R.attr.tag_space_vertical, R.attr.textColor, R.attr.textSize});
        boolean r104 = r103.getBoolean(0, true);
        this.f445851f = r104;
        this.f445852g = r103.getInt(4, -1);
        r103.recycle();
        if (r104 == false) goto L6;
        setClickable(true);
        return;
    }
}
