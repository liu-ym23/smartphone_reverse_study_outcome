package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public class ReactiveGuide extends View implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f400470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f400471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f400472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f400473d;

    @Override // android.view.View
    public final void draw(Canvas r100) {
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
    }

    public int getApplyToConstraintSetId() {
        return this.f400472c;
    }

    public int getAttributeId() {
        return this.f400470a;
    }

    public ReactiveGuide(Context r100) {
        super(r100);
        this.f400470a = -1;
        this.f400471b = false;
        this.f400472c = 0;
        this.f400473d = true;
        super.setVisibility(8);
        a(null);
    }

    public final void a(AttributeSet r100) {
        if (r100 == null) goto L19;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.reactiveGuide_animateChange, R.attr.reactiveGuide_applyToAllConstraintSets, R.attr.reactiveGuide_applyToConstraintSet, R.attr.reactiveGuide_valueId});
        int r102 = r101.getIndexCount();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L17;
        int r104 = r101.getIndex(r103);
        if (r104 != 3) goto L8;
        this.f400470a = r101.getResourceId(r104, this.f400470a);
    L16:
        r103 = r103 + 1;
        goto L4
    L8:
        if (r104 != 0) goto L11;
        this.f400471b = r101.getBoolean(r104, this.f400471b);
        goto L16
    L11:
        if (r104 != 2) goto L14;
        this.f400472c = r101.getResourceId(r104, this.f400472c);
        goto L16
    L14:
        if (r104 != 1) goto L16;
        this.f400473d = r101.getBoolean(r104, this.f400473d);
        goto L16
    L17:
        r101.recycle();
    L19:
        if (this.f400470a == (-1)) goto L28;
        ConstraintLayout.getSharedValues().a(this.f400470a, this);
        return;
    }

    public void setAnimateChange(boolean r100) {
        this.f400471b = r100;
    }

    public void setApplyToConstraintSetId(int r100) {
        this.f400472c = r100;
    }

    public void setAttributeId(int r100) {
        b r101 = ConstraintLayout.getSharedValues();
        int r102 = this.f400470a;
        if (r102 == (-1)) goto L15;
        HashSet<WeakReference<b.a>> r103 = r101.f400584a.get(Integer.valueOf(r102));
        if (r103 == null) goto L15;
        ArrayList r104 = new ArrayList();
        Iterator<WeakReference<b.a>> r105 = r103.iterator();
    L9:
        if (r105.hasNext() == false) goto L14;
        WeakReference<b.a> r106 = r105.next();
        b.a r107 = r106.get();
        if (r107 == null) goto L13;
        if (r107 != this) goto L9;
    L13:
        r104.add(r106);
        goto L9
    L14:
        r103.removeAll(r104);
    L15:
        this.f400470a = r100;
        if (r100 == (-1)) goto L25;
        r101.a(this.f400470a, this);
        return;
    }

    public void setGuidelineBegin(int r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r101.f400403a = r100;
        setLayoutParams(r101);
    }

    public void setGuidelineEnd(int r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r101.f400405b = r100;
        setLayoutParams(r101);
    }

    public void setGuidelinePercent(float r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) getLayoutParams();
        r101.f400407c = r100;
        setLayoutParams(r101);
    }

    public ReactiveGuide(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f400470a = -1;
        this.f400471b = false;
        this.f400472c = 0;
        this.f400473d = true;
        super.setVisibility(8);
        a(r101);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        setMeasuredDimension(0, 0);
    }

    public ReactiveGuide(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f400470a = -1;
        this.f400471b = false;
        this.f400472c = 0;
        this.f400473d = true;
        super.setVisibility(8);
        a(r101);
    }
}
