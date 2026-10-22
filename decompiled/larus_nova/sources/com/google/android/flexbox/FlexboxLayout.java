package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class FlexboxLayout extends ViewGroup implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f274343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f274344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f274345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f274346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f274347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f274348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f274349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f274350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f274351i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f274352j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f274353k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f274354l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f274355m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SparseIntArray f274356n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f274357o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<b> f274358p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c.a f274359q;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f274360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f274361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f274362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f274363d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f274364e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f274365f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f274366g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f274367h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f274368i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f274369j;

        public static class a implements Parcelable.Creator<LayoutParams> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final LayoutParams createFromParcel(Parcel r100) {
                return new LayoutParams(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final LayoutParams[] newArray(int r100) {
                return new LayoutParams[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        @Override // com.google.android.flexbox.FlexItem
        public final boolean B1() {
            return this.f274369j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getAlignSelf() {
            return this.f274363d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final float getFlexGrow() {
            return this.f274361b;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final float getFlexShrink() {
            return this.f274362c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMaxHeight() {
            return this.f274368i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMaxWidth() {
            return this.f274367h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMinHeight() {
            return this.f274366g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMinWidth() {
            return this.f274365f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getOrder() {
            return this.f274360a;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final float l0() {
            return this.f274364e;
        }

        public LayoutParams(Parcel r100) {
            boolean r101 = false;
            super(0, 0);
            this.f274360a = 1;
            this.f274361b = 0.0f;
            this.f274362c = 1.0f;
            this.f274363d = -1;
            this.f274364e = -1.0f;
            this.f274365f = -1;
            this.f274366g = -1;
            this.f274367h = 16777215;
            this.f274368i = 16777215;
            this.f274360a = r100.readInt();
            this.f274361b = r100.readFloat();
            this.f274362c = r100.readFloat();
            this.f274363d = r100.readInt();
            this.f274364e = r100.readFloat();
            this.f274365f = r100.readInt();
            this.f274366g = r100.readInt();
            this.f274367h = r100.readInt();
            this.f274368i = r100.readInt();
            if (r100.readByte() == 0) goto L5;
            r101 = true;
        L5:
            this.f274369j = r101;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r100.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r100.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r100.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = r100.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = r100.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = r100.readInt();
        }

        @Override // com.google.android.flexbox.FlexItem
        public final void V0(int r100) {
            this.f274366g = r100;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final void a1(int r100) {
            this.f274365f = r100;
        }

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.f274360a = 1;
            this.f274361b = 0.0f;
            this.f274362c = 1.0f;
            this.f274363d = -1;
            this.f274364e = -1.0f;
            this.f274365f = -1;
            this.f274366g = -1;
            this.f274367h = 16777215;
            this.f274368i = 16777215;
            this.f274360a = r100.f274360a;
            this.f274361b = r100.f274361b;
            this.f274362c = r100.f274362c;
            this.f274363d = r100.f274363d;
            this.f274364e = r100.f274364e;
            this.f274365f = r100.f274365f;
            this.f274366g = r100.f274366g;
            this.f274367h = r100.f274367h;
            this.f274368i = r100.f274368i;
            this.f274369j = r100.f274369j;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f274360a = 1;
            this.f274361b = 0.0f;
            this.f274362c = 1.0f;
            this.f274363d = -1;
            this.f274364e = -1.0f;
            this.f274365f = -1;
            this.f274366g = -1;
            this.f274367h = 16777215;
            this.f274368i = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.f274360a = 1;
            this.f274361b = 0.0f;
            this.f274362c = 1.0f;
            this.f274363d = -1;
            this.f274364e = -1.0f;
            this.f274365f = -1;
            this.f274366g = -1;
            this.f274367h = 16777215;
            this.f274368i = 16777215;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f274360a = 1;
            this.f274361b = 0.0f;
            this.f274362c = 1.0f;
            this.f274363d = -1;
            this.f274364e = -1.0f;
            this.f274365f = -1;
            this.f274366g = -1;
            this.f274367h = 16777215;
            this.f274368i = 16777215;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.layout_alignSelf, R.attr.layout_flexBasisPercent, R.attr.layout_flexGrow, R.attr.layout_flexShrink, R.attr.layout_maxHeight, R.attr.layout_maxWidth, R.attr.layout_minHeight, R.attr.layout_minWidth, R.attr.layout_order, R.attr.layout_wrapBefore});
            this.f274360a = r102.getInt(8, 1);
            this.f274361b = r102.getFloat(2, 0.0f);
            this.f274362c = r102.getFloat(3, 1.0f);
            this.f274363d = r102.getInt(0, -1);
            this.f274364e = r102.getFraction(1, 1, 1, -1.0f);
            this.f274365f = r102.getDimensionPixelSize(7, -1);
            this.f274366g = r102.getDimensionPixelSize(6, -1);
            this.f274367h = r102.getDimensionPixelSize(5, 16777215);
            this.f274368i = r102.getDimensionPixelSize(4, 16777215);
            this.f274369j = r102.getBoolean(9, false);
            r102.recycle();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.f274360a);
            r100.writeFloat(this.f274361b);
            r100.writeFloat(this.f274362c);
            r100.writeInt(this.f274363d);
            r100.writeFloat(this.f274364e);
            r100.writeInt(this.f274365f);
            r100.writeInt(this.f274366g);
            r100.writeInt(this.f274367h);
            r100.writeInt(this.f274368i);
            r100.writeByte(this.f274369j ? 1 : 0);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(int r100, int r101) {
            super(new ViewGroup.LayoutParams(r100, r101));
            this.f274360a = 1;
            this.f274361b = 0.0f;
            this.f274362c = 1.0f;
            this.f274363d = -1;
            this.f274364e = -1.0f;
            this.f274365f = -1;
            this.f274366g = -1;
            this.f274367h = 16777215;
            this.f274368i = 16777215;
        }
    }

    @Override // com.google.android.flexbox.a
    public final int h(View r100) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public final void n(int r100, View r101) {
    }

    public List<b> getFlexLines() {
        ArrayList r100 = new ArrayList(this.f274358p.size());
        Iterator<b> r101 = this.f274358p.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        b r102 = r101.next();
        if ((r102.f274431h - r102.f274432i) == 0) goto L4;
        r100.add(r102);
        goto L4
    L9:
        return r100;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        Iterator<b> r100 = this.f274358p.iterator();
        int r101 = Integer.MIN_VALUE;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = Math.max(r101, r100.next().f274428e);
        goto L4
    L6:
        return r101;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int r100 = this.f274358p.size();
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L19;
        b r103 = (b) ListProtector.get(this.f274358p, r101);
        if (q(r101) == false) goto L12;
        if (o() == false) goto L9;
        int r104 = this.f274353k;
    L10:
        r102 = r102 + r104;
        goto L12
    L9:
        r104 = this.f274354l;
    L12:
        if (r(r101) == false) goto L18;
        if (o() == false) goto L16;
        int r105 = this.f274353k;
    L17:
        r102 = r102 + r105;
        goto L18
    L16:
        r105 = this.f274354l;
    L18:
        r102 = r102 + r103.f274430g;
        r101 = r101 + 1;
        goto L3
    L19:
        return r102;
    }

    @Override // com.google.android.flexbox.a
    public final boolean o() {
        int r100 = this.f274343a;
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.f274347e;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f274346d;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f274349g;
    }

    public Drawable getDividerDrawableVertical() {
        return this.f274350h;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.f274343a;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.f274358p;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.f274344b;
    }

    public int getJustifyContent() {
        return this.f274345c;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.f274348f;
    }

    public int getShowDividerHorizontal() {
        return this.f274351i;
    }

    public int getShowDividerVertical() {
        return this.f274352j;
    }

    public FlexboxLayout(Context r100) {
        this(r100, null);
    }

    @Override // com.google.android.flexbox.a
    public final void b(b r100) {
        if (o() == false) goto L8;
        if ((this.f274352j & 4) <= 0) goto L11;
        int r101 = r100.f274428e;
        int r102 = this.f274354l;
        r100.f274428e = r101 + r102;
        r100.f274429f += r102;
        return;
    L11:
        return;
    L8:
        if ((this.f274351i & 4) <= 0) goto L13;
        int r103 = r100.f274428e;
        int r104 = this.f274353k;
        r100.f274428e = r103 + r104;
        r100.f274429f += r104;
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // com.google.android.flexbox.a
    public final View d(int r100) {
        return getChildAt(r100);
    }

    public final View g(int r100) {
        if (r100 < 0) goto L8;
        int[] r101 = this.f274355m;
        if (r100 < r101.length) goto L7;
        return null;
    L7:
        return getChildAt(r101[r100]);
    L8:
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r100);
    L7:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L11:
        return new LayoutParams(r100);
    }

    @Override // com.google.android.flexbox.a
    public final View l(int r100) {
        return g(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f274350h != null) goto L8;
        if (this.f274349g != null) goto L8;
        return;
    L8:
        if (this.f274351i == 0) goto L10;
    L12:
        int r101 = ViewCompat.getLayoutDirection(this);
        int r102 = this.f274343a;
        boolean r103 = false;
        boolean r104 = true;
        if (r102 == 0) goto L39;
        if (r102 == 1) goto L32;
        if (r102 != 2) goto L17;
        if (r101 == 1) goto L29;
        r104 = false;
    L29:
        if (this.f274344b != 2) goto L31;
        r104 = !r104;
    L31:
        c(r100, r104, false);
        return;
    L17:
        if (r102 != 3) goto L50;
        if (r101 != 1) goto L22;
        r103 = true;
    L22:
        if (this.f274344b != 2) goto L24;
        r103 = !r103;
    L24:
        c(r100, r103, true);
        return;
    L50:
        return;
    L32:
        if (r101 == 1) goto L34;
        boolean r105 = true;
    L36:
        if (this.f274344b != 2) goto L38;
        r103 = true;
    L38:
        a(r100, r105, r103);
        return;
    L34:
        r105 = false;
        goto L36
    L39:
        if (r101 != 1) goto L41;
        boolean r106 = true;
    L43:
        if (this.f274344b != 2) goto L45;
        r103 = true;
    L45:
        a(r100, r106, r103);
        return;
    L41:
        r106 = false;
        goto L43
    L10:
        if (this.f274352j != 0) goto L12;
    }

    public final boolean q(int r100) {
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (r100 >= this.f274358p.size()) goto L43;
        int r101 = 0;
    L9:
        if (r101 >= r100) goto L14;
        b r102 = (b) ListProtector.get(this.f274358p, r101);
        if ((r102.f274431h - r102.f274432i) > 0) goto L12;
        r101 = r101 + 1;
        goto L9
    L12:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L27;
        if (o() == false) goto L23;
        if ((this.f274351i & 1) == 0) goto L38;
        return true;
    L38:
        return false;
    L23:
        if ((this.f274352j & 1) == 0) goto L39;
        return true;
    L39:
        return false;
    L27:
        if (o() == false) goto L33;
        if ((this.f274351i & 2) == 0) goto L40;
        return true;
    L40:
        return false;
    L33:
        if ((this.f274352j & 2) == 0) goto L42;
        return true;
    L42:
        return false;
    L14:
        r103 = true;
        goto L15
    L43:
        return false;
    }

    public final boolean r(int r100) {
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (r100 >= this.f274358p.size()) goto L29;
        int r101 = r100 + 1;
    L9:
        if (r101 >= this.f274358p.size()) goto L15;
        b r102 = (b) ListProtector.get(this.f274358p, r101);
        if ((r102.f274431h - r102.f274432i) > 0) goto L12;
        r101 = r101 + 1;
        goto L9
    L12:
        return false;
    L15:
        if (o() == false) goto L21;
        if ((this.f274351i & 4) == 0) goto L26;
        return true;
    L26:
        return false;
    L21:
        if ((this.f274352j & 4) == 0) goto L28;
        return true;
    L28:
        return false;
    L29:
        return false;
    }

    public void setAlignContent(int r100) {
        if (this.f274347e == r100) goto L6;
        this.f274347e = r100;
        requestLayout();
        return;
    }

    public void setAlignItems(int r100) {
        if (this.f274346d == r100) goto L6;
        this.f274346d = r100;
        requestLayout();
        return;
    }

    public void setDividerDrawable(Drawable r100) {
        setDividerDrawableHorizontal(r100);
        setDividerDrawableVertical(r100);
    }

    public void setDividerDrawableHorizontal(Drawable r100) {
        if (r100 != this.f274349g) goto L5;
        return;
    L5:
        this.f274349g = r100;
        if (r100 == null) goto L8;
        this.f274353k = r100.getIntrinsicHeight();
    L10:
        if (this.f274349g == null) goto L12;
    L14:
        setWillNotDraw(false);
    L15:
        requestLayout();
        return;
    L12:
        if (this.f274350h != null) goto L14;
        setWillNotDraw(true);
        goto L15
    L8:
        this.f274353k = 0;
        goto L10
    }

    public void setDividerDrawableVertical(Drawable r100) {
        if (r100 != this.f274350h) goto L5;
        return;
    L5:
        this.f274350h = r100;
        if (r100 == null) goto L8;
        this.f274354l = r100.getIntrinsicWidth();
    L10:
        if (this.f274349g == null) goto L12;
    L14:
        setWillNotDraw(false);
    L15:
        requestLayout();
        return;
    L12:
        if (this.f274350h != null) goto L14;
        setWillNotDraw(true);
        goto L15
    L8:
        this.f274354l = 0;
        goto L10
    }

    public void setFlexDirection(int r100) {
        if (this.f274343a == r100) goto L6;
        this.f274343a = r100;
        requestLayout();
        return;
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> r100) {
        this.f274358p = r100;
    }

    public void setFlexWrap(int r100) {
        if (this.f274344b == r100) goto L6;
        this.f274344b = r100;
        requestLayout();
        return;
    }

    public void setJustifyContent(int r100) {
        if (this.f274345c == r100) goto L6;
        this.f274345c = r100;
        requestLayout();
        return;
    }

    public void setMaxLine(int r100) {
        if (this.f274348f == r100) goto L6;
        this.f274348f = r100;
        requestLayout();
        return;
    }

    public void setShowDivider(int r100) {
        setShowDividerVertical(r100);
        setShowDividerHorizontal(r100);
    }

    public void setShowDividerHorizontal(int r100) {
        if (r100 == this.f274351i) goto L6;
        this.f274351i = r100;
        requestLayout();
        return;
    }

    public void setShowDividerVertical(int r100) {
        if (r100 == this.f274352j) goto L6;
        this.f274352j = r100;
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public FlexboxLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r111) {
        if (this.f274356n != null) goto L5;
        this.f274356n = new SparseIntArray(getChildCount());
    L5:
        c r100 = this.f274357o;
        SparseIntArray r101 = this.f274356n;
        int r102 = r100.f274442a.getFlexItemCount();
        if (r101.size() != r102) goto L15;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L17;
        View r104 = r100.f274442a.d(r103);
        if (r104 == null) goto L16;
        if (((FlexItem) r104.getLayoutParams()).getOrder() != r101.get(r103)) goto L15;
    L16:
        r103 = r103 + 1;
        goto L9
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L20;
        c r106 = this.f274357o;
        SparseIntArray r107 = this.f274356n;
        int r108 = r106.f274442a.getFlexItemCount();
        this.f274355m = c.r(r108, r106.f(r108), r107);
    L20:
        int r109 = this.f274343a;
        if (r109 == 0) goto L29;
        if (r109 == 1) goto L29;
        if (r109 == 2) goto L28;
        if (r109 == 3) goto L28;
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f274343a);
    L28:
        this.f274358p.clear();
        c.a r112 = this.f274359q;
        r112.f274447a = null;
        r112.f274448b = 0;
        this.f274357o.b(r112, r111, r110, Integer.MAX_VALUE, 0, -1, null);
        this.f274358p = this.f274359q.f274447a;
        this.f274357o.h(r110, r111, 0);
        this.f274357o.g(r110, r111, getPaddingLeft() + getPaddingRight());
        this.f274357o.u(0);
        u(this.f274343a, r110, r111, this.f274359q.f274448b);
        return;
    L29:
        this.f274358p.clear();
        c.a r113 = this.f274359q;
        r113.f274447a = null;
        r113.f274448b = 0;
        this.f274357o.b(r113, r110, r111, Integer.MAX_VALUE, 0, -1, null);
        this.f274358p = this.f274359q.f274447a;
        this.f274357o.h(r110, r111, 0);
        if (this.f274346d != 3) goto L48;
        Iterator<b> r114 = this.f274358p.iterator();
    L33:
        if (r114.hasNext() == false) goto L48;
        b r115 = r114.next();
        int r116 = Integer.MIN_VALUE;
        int r117 = 0;
    L36:
        if (r117 >= r115.f274431h) goto L47;
        View r118 = g(r115.f274438o + r117);
        if (r118 == null) goto L46;
        if (r118.getVisibility() == 8) goto L46;
        LayoutParams r119 = (LayoutParams) r118.getLayoutParams();
        if (this.f274344b == 2) goto L45;
        r116 = Math.max(r116, (r118.getMeasuredHeight() + Math.max(r115.f274435l - r118.getBaseline(), ((ViewGroup.MarginLayoutParams) r119).topMargin)) + ((ViewGroup.MarginLayoutParams) r119).bottomMargin);
        goto L46
    L45:
        r116 = Math.max(r116, (r118.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r119).topMargin) + Math.max((r115.f274435l - r118.getMeasuredHeight()) + r118.getBaseline(), ((ViewGroup.MarginLayoutParams) r119).bottomMargin));
    L46:
        r117 = r117 + 1;
        goto L36
    L47:
        r115.f274430g = r116;
    L48:
        this.f274357o.g(r110, r111, getPaddingTop() + getPaddingBottom());
        this.f274357o.u(0);
        u(this.f274343a, r110, r111, this.f274359q.f274448b);
        return;
    L15:
        r105 = true;
        goto L18
    }

    public final boolean p(int r100, int r101) {
        int r102 = 1;
    L4:
        if (r102 > r101) goto L11;
        View r103 = g(r100 - r102);
        if (r103 == null) goto L10;
        if (r103.getVisibility() == 8) goto L10;
        boolean r104 = false;
    L12:
        if (r104 == false) goto L26;
        if (o() == false) goto L21;
        if ((this.f274352j & 1) != 0) goto L41;
        return false;
    L41:
        return true;
    L21:
        if ((this.f274351i & 1) != 0) goto L42;
        return false;
    L42:
        return true;
    L26:
        if (o() == false) goto L33;
        if ((this.f274352j & 2) != 0) goto L43;
        return false;
    L43:
        return true;
    L33:
        if ((this.f274351i & 2) != 0) goto L44;
        return false;
    L44:
        return true;
    L10:
        r102 = r102 + 1;
        goto L4
    L11:
        r104 = true;
        goto L12
    }

    public FlexboxLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f274348f = -1;
        this.f274357o = new c(this);
        this.f274358p = new ArrayList();
        this.f274359q = new c.a();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.alignContent, R.attr.alignItems, R.attr.dividerDrawable, R.attr.dividerDrawableHorizontal, R.attr.dividerDrawableVertical, R.attr.flexDirection, R.attr.flexWrap, R.attr.justifyContent, R.attr.maxLine, R.attr.showDivider, R.attr.showDividerHorizontal, R.attr.showDividerVertical}, r102, 0);
        this.f274343a = r103.getInt(5, 0);
        this.f274344b = r103.getInt(6, 0);
        this.f274345c = r103.getInt(7, 0);
        this.f274346d = r103.getInt(1, 0);
        this.f274347e = r103.getInt(0, 0);
        this.f274348f = r103.getInt(8, -1);
        Drawable r104 = r103.getDrawable(2);
        if (r104 == null) goto L5;
        setDividerDrawableHorizontal(r104);
        setDividerDrawableVertical(r104);
    L5:
        Drawable r105 = r103.getDrawable(3);
        if (r105 == null) goto L8;
        setDividerDrawableHorizontal(r105);
    L8:
        Drawable r106 = r103.getDrawable(4);
        if (r106 == null) goto L11;
        setDividerDrawableVertical(r106);
    L11:
        int r107 = r103.getInt(9, 0);
        if (r107 == 0) goto L14;
        this.f274352j = r107;
        this.f274351i = r107;
    L14:
        int r108 = r103.getInt(11, 0);
        if (r108 == 0) goto L17;
        this.f274352j = r108;
    L17:
        int r109 = r103.getInt(10, 0);
        if (r109 == 0) goto L20;
        this.f274351i = r109;
    L20:
        r103.recycle();
    }

    public final void a(Canvas r110, boolean r111, boolean r112) {
        int r100 = getPaddingLeft();
        int r101 = Math.max(0, (getWidth() - getPaddingRight()) - r100);
        int r102 = this.f274358p.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L42;
        b r104 = (b) ListProtector.get(this.f274358p, r103);
        int r105 = 0;
    L6:
        if (r105 >= r104.f274431h) goto L28;
        int r106 = r104.f274438o + r105;
        View r107 = g(r106);
        if (r107 == null) goto L26;
        if (r107.getVisibility() == 8) goto L26;
        LayoutParams r108 = (LayoutParams) r107.getLayoutParams();
        if (p(r106, r105) == false) goto L19;
        if (r111 == false) goto L16;
        int r109 = r107.getRight() + ((ViewGroup.MarginLayoutParams) r108).rightMargin;
    L17:
        f(r110, r109, r104.f274425b, r104.f274430g);
        goto L19
    L16:
        r109 = (r107.getLeft() - ((ViewGroup.MarginLayoutParams) r108).leftMargin) - this.f274354l;
    L19:
        if (r105 != (r104.f274431h - 1)) goto L26;
        if ((this.f274352j & 4) <= 0) goto L26;
        if (r111 == false) goto L24;
        int r113 = (r107.getLeft() - ((ViewGroup.MarginLayoutParams) r108).leftMargin) - this.f274354l;
    L25:
        f(r110, r113, r104.f274425b, r104.f274430g);
        goto L26
    L24:
        r113 = r107.getRight() + ((ViewGroup.MarginLayoutParams) r108).rightMargin;
    L26:
        r105 = r105 + 1;
        goto L6
    L28:
        if (q(r103) == false) goto L34;
        if (r112 == false) goto L31;
        int r114 = r104.f274427d;
    L32:
        e(r110, r100, r114, r101);
        goto L34
    L31:
        r114 = r104.f274425b - this.f274353k;
    L34:
        if (r(r103) == false) goto L41;
        if ((this.f274351i & 4) <= 0) goto L41;
        if (r112 == false) goto L39;
        int r115 = r104.f274425b - this.f274353k;
    L40:
        e(r110, r100, r115, r101);
        goto L41
    L39:
        r115 = r104.f274427d;
    L41:
        r103 = r103 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final void addView(View r100, int r110, ViewGroup.LayoutParams r111) {
        if (this.f274356n != null) goto L5;
        this.f274356n = new SparseIntArray(getChildCount());
    L5:
        c r101 = this.f274357o;
        SparseIntArray r102 = this.f274356n;
        int r103 = r101.f274442a.getFlexItemCount();
        List<c.b> r104 = r101.f(r103);
        c.b r105 = new c.b();
        if (r100 != null) goto L8;
    L10:
        r105.f274450b = 1;
    L12:
        if (r110 == (-1)) goto L21;
        if (r110 == r103) goto L21;
        if (r110 >= r101.f274442a.getFlexItemCount()) goto L20;
        r105.f274449a = r110;
        int r106 = r110;
    L18:
        if (r106 >= r103) goto L22;
        ((c.b) ListProtector.get(r104, r106)).f274449a++;
        r106 = r106 + 1;
    L22:
        ((ArrayList) r104).add(r105);
        this.f274355m = c.r(r103 + 1, r104, r102);
        super.addView(r100, r110, r111);
        return;
    L20:
        r105.f274449a = r103;
    L21:
        r105.f274449a = r103;
        goto L22
    L8:
        if ((r111 instanceof FlexItem) == false) goto L10;
        r105.f274450b = ((FlexItem) r111).getOrder();
        goto L12
    }

    public final void c(Canvas r110, boolean r111, boolean r112) {
        int r100 = getPaddingTop();
        int r101 = Math.max(0, (getHeight() - getPaddingBottom()) - r100);
        int r102 = this.f274358p.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L42;
        b r104 = (b) ListProtector.get(this.f274358p, r103);
        int r105 = 0;
    L6:
        if (r105 >= r104.f274431h) goto L28;
        int r106 = r104.f274438o + r105;
        View r107 = g(r106);
        if (r107 == null) goto L26;
        if (r107.getVisibility() == 8) goto L26;
        LayoutParams r108 = (LayoutParams) r107.getLayoutParams();
        if (p(r106, r105) == false) goto L19;
        if (r112 == false) goto L16;
        int r109 = r107.getBottom() + ((ViewGroup.MarginLayoutParams) r108).bottomMargin;
    L17:
        e(r110, r104.f274424a, r109, r104.f274430g);
        goto L19
    L16:
        r109 = (r107.getTop() - ((ViewGroup.MarginLayoutParams) r108).topMargin) - this.f274353k;
    L19:
        if (r105 != (r104.f274431h - 1)) goto L26;
        if ((this.f274351i & 4) <= 0) goto L26;
        if (r112 == false) goto L24;
        int r113 = (r107.getTop() - ((ViewGroup.MarginLayoutParams) r108).topMargin) - this.f274353k;
    L25:
        e(r110, r104.f274424a, r113, r104.f274430g);
        goto L26
    L24:
        r113 = r107.getBottom() + ((ViewGroup.MarginLayoutParams) r108).bottomMargin;
    L26:
        r105 = r105 + 1;
        goto L6
    L28:
        if (q(r103) == false) goto L34;
        if (r111 == false) goto L31;
        int r114 = r104.f274426c;
    L32:
        f(r110, r114, r100, r101);
        goto L34
    L31:
        r114 = r104.f274424a - this.f274354l;
    L34:
        if (r(r103) == false) goto L41;
        if ((this.f274352j & 4) <= 0) goto L41;
        if (r111 == false) goto L39;
        int r115 = r104.f274424a - this.f274354l;
    L40:
        f(r110, r115, r100, r101);
        goto L41
    L39:
        r115 = r104.f274426c;
    L41:
        r103 = r103 + 1;
        goto L3
    }

    @Override // com.google.android.flexbox.a
    public final int i(View r100, int r101, int r102) {
        int r103 = 0;
        if (o() == false) goto L11;
        if (p(r101, r102) == false) goto L8;
        r103 = 0 + this.f274354l;
    L8:
        if ((this.f274352j & 4) <= 0) goto L18;
        int r104 = this.f274354l;
    L17:
        return r103 + r104;
    L18:
        return r103;
    L11:
        if (p(r101, r102) == false) goto L14;
        r103 = 0 + this.f274353k;
    L14:
        if ((this.f274351i & 4) <= 0) goto L19;
        r104 = this.f274353k;
        goto L17
    L19:
        return r103;
    }

    @Override // com.google.android.flexbox.a
    public final int k(int r100, int r101, int r102) {
        return ViewGroup.getChildMeasureSpec(r100, r101, r102);
    }

    @Override // com.google.android.flexbox.a
    public final int m(int r100, int r101, int r102) {
        return ViewGroup.getChildMeasureSpec(r100, r101, r102);
    }

    public final void e(Canvas r100, int r101, int r102, int r103) {
        Drawable r104 = this.f274349g;
        if (r104 != null) goto L5;
        return;
    L5:
        r104.setBounds(r101, r102, r103 + r101, this.f274353k + r102);
        this.f274349g.draw(r100);
    }

    public final void f(Canvas r100, int r101, int r102, int r103) {
        Drawable r104 = this.f274350h;
        if (r104 != null) goto L5;
        return;
    L5:
        r104.setBounds(r101, r102, this.f274354l + r101, r103 + r102);
        this.f274350h.draw(r100);
    }

    @Override // com.google.android.flexbox.a
    public final void j(View r100, int r101, int r102, b r103) {
        if (p(r101, r102) == true) goto L5;
        return;
    L5:
        if (o() == false) goto L7;
        int r104 = r103.f274428e;
        int r105 = this.f274354l;
        r103.f274428e = r104 + r105;
        r103.f274429f += r105;
        return;
    L7:
        int r106 = r103.f274428e;
        int r107 = this.f274353k;
        r103.f274428e = r106 + r107;
        r103.f274429f += r107;
    }

    public final void u(int r100, int r110, int r111, int r112) {
        int r101 = View.MeasureSpec.getMode(r110);
        int r102 = View.MeasureSpec.getSize(r110);
        int r103 = View.MeasureSpec.getMode(r111);
        int r104 = View.MeasureSpec.getSize(r111);
        if (r100 != 0) goto L5;
    L14:
        int r105 = (getSumOfCrossSize() + getPaddingTop()) + getPaddingBottom();
        int r106 = getLargestMainSize();
    L16:
        if (r101 == Integer.MIN_VALUE) goto L25;
        if (r101 == 0) goto L24;
        if (r101 != 1073741824) goto L23;
        if (r102 >= r106) goto L21;
        r112 = View.combineMeasuredStates(r112, 16777216);
    L21:
        int r113 = View.resolveSizeAndState(r102, r110, r112);
    L30:
        if (r103 == Integer.MIN_VALUE) goto L39;
        if (r103 == 0) goto L38;
        if (r103 != 1073741824) goto L37;
        if (r104 >= r105) goto L35;
        r112 = View.combineMeasuredStates(r112, 256);
    L35:
        int r107 = View.resolveSizeAndState(r104, r111, r112);
    L43:
        setMeasuredDimension(r113, r107);
        return;
    L37:
        throw new IllegalStateException("Unknown height mode is set: " + r103);
    L38:
        r107 = View.resolveSizeAndState(r105, r111, r112);
        goto L43
    L39:
        if (r104 >= r105) goto L41;
        r112 = View.combineMeasuredStates(r112, 256);
    L42:
        r107 = View.resolveSizeAndState(r104, r111, r112);
        goto L43
    L41:
        r104 = r105;
        goto L42
    L23:
        throw new IllegalStateException("Unknown width mode is set: " + r101);
    L24:
        r113 = View.resolveSizeAndState(r106, r110, r112);
        goto L30
    L25:
        if (r102 >= r106) goto L27;
        r112 = View.combineMeasuredStates(r112, 16777216);
    L28:
        r113 = View.resolveSizeAndState(r102, r110, r112);
        goto L30
    L27:
        r102 = r106;
        goto L28
    L5:
        if (r100 == 1) goto L14;
        if (r100 != 2) goto L9;
    L13:
        r105 = getLargestMainSize();
        r106 = (getSumOfCrossSize() + getPaddingLeft()) + getPaddingRight();
        goto L16
    L9:
        if (r100 == 3) goto L13;
        throw new IllegalArgumentException("Invalid flex direction: " + r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r110, int r111, int r112) {
        int r102 = ViewCompat.getLayoutDirection(this);
        int r103 = this.f274343a;
        boolean r104 = false;
        if (r103 == 0) goto L29;
        if (r103 != 1) goto L6;
        if (r102 == 1) goto L27;
        boolean r105 = true;
    L28:
        s(r105, r101, r110, r111, r112);
        return;
    L27:
        r105 = false;
        goto L28
    L6:
        if (r103 != 2) goto L8;
        if (r102 != 1) goto L21;
        r104 = true;
    L21:
        if (this.f274344b != 2) goto L23;
        boolean r106 = !r104;
    L24:
        t(r106, false, r101, r110, r111, r112);
        return;
    L23:
        r106 = r104;
        goto L24
    L8:
        if (r103 != 3) goto L17;
        if (r102 != 1) goto L12;
        r104 = true;
    L12:
        if (this.f274344b != 2) goto L14;
        boolean r107 = !r104;
    L15:
        t(r107, true, r101, r110, r111, r112);
        return;
    L14:
        r107 = r104;
        goto L15
    L17:
        throw new IllegalStateException("Invalid flex direction is set: " + this.f274343a);
    L29:
        if (r102 != 1) goto L31;
        boolean r108 = true;
    L32:
        s(r108, r101, r110, r111, r112);
        return;
    L31:
        r108 = false;
        goto L32
    }

    public final void s(boolean r210, int r310, int r311, int r312, int r313) {
        int r100 = getPaddingLeft();
        int r101 = getPaddingRight();
        int r102 = r312 - r310;
        int r103 = (r313 - r311) - getPaddingBottom();
        int r104 = getPaddingTop();
        int r105 = this.f274358p.size();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L74;
        b r107 = (b) ListProtector.get(this.f274358p, r106);
        if (q(r106) == false) goto L7;
        int r110 = this.f274353k;
        r103 = r103 - r110;
        r104 = r104 + r110;
    L7:
        int r111 = this.f274345c;
        int r112 = 1;
        if (r111 == 0) goto L36;
        if (r111 != 1) goto L11;
        int r108 = r107.f274428e;
        float r113 = r108 - r100;
        float r109 = (r102 - r108) + r101;
    L37:
        float r114 = 0.0f;
    L38:
        float r115 = Math.max(r114, 0.0f);
        int r116 = 0;
    L40:
        if (r116 >= r107.f274431h) goto L73;
        int r117 = r107.f274438o + r116;
        View r118 = g(r117);
        if (r118 != null) goto L44;
    L71:
        int r211 = r100;
        int r212 = r116;
    L72:
        r116 = r212 + 1;
        r100 = r211;
        r112 = 1;
        goto L40
    L44:
        if (r118.getVisibility() == 8) goto L71;
        LayoutParams r119 = (LayoutParams) r118.getLayoutParams();
        float r120 = r109 + ((ViewGroup.MarginLayoutParams) r119).leftMargin;
        float r121 = r113 - ((ViewGroup.MarginLayoutParams) r119).rightMargin;
        if (p(r117, r116) == false) goto L49;
        int r122 = this.f274354l;
        float r123 = r122;
        r120 = r120 + r123;
        int r213 = r122;
        float r124 = r121 - r123;
    L51:
        if (r116 != (r107.f274431h - r112)) goto L56;
        if ((this.f274352j & 4) <= 0) goto L56;
        int r214 = this.f274354l;
    L58:
        if (this.f274344b != 2) goto L62;
        if (r210 == false) goto L61;
        r212 = r116;
        r211 = r100;
        LayoutParams r125 = r119;
        this.f274357o.o(r118, r107, Math.round(r124) - r118.getMeasuredWidth(), r103 - r118.getMeasuredHeight(), Math.round(r124), r103);
    L66:
        r109 = r120 + ((r118.getMeasuredWidth() + r115) + ((ViewGroup.MarginLayoutParams) r125).rightMargin);
        float r126 = r124 - ((r118.getMeasuredWidth() + r115) + ((ViewGroup.MarginLayoutParams) r125).leftMargin);
        if (r210 == false) goto L69;
        r107.a(r118, r214, 0, r213, 0);
    L70:
        r113 = r126;
        goto L72
    L69:
        r107.a(r118, r213, 0, r214, 0);
        goto L70
    L61:
        r211 = r100;
        r212 = r116;
        r125 = r119;
        this.f274357o.o(r118, r107, Math.round(r120), r103 - r118.getMeasuredHeight(), Math.round(r120) + r118.getMeasuredWidth(), r103);
        goto L66
    L62:
        r211 = r100;
        r212 = r116;
        r125 = r119;
        if (r210 == false) goto L65;
        this.f274357o.o(r118, r107, Math.round(r124) - r118.getMeasuredWidth(), r104, Math.round(r124), r104 + r118.getMeasuredHeight());
        goto L66
    L65:
        this.f274357o.o(r118, r107, Math.round(r120), r104, Math.round(r120) + r118.getMeasuredWidth(), r104 + r118.getMeasuredHeight());
    L56:
        r214 = 0;
        goto L58
    L49:
        r124 = r121;
        r213 = 0;
        goto L51
    L73:
        int r215 = r100;
        int r127 = r107.f274430g;
        r104 = r104 + r127;
        r103 = r103 - r127;
        r106 = r106 + 1;
        r100 = r215;
        goto L3
    L11:
        if (r111 != 2) goto L13;
        int r128 = r107.f274428e;
        r109 = r100 + ((r102 - r128) / 2.0f);
        r113 = (r102 - r101) - ((r102 - r128) / 2.0f);
        goto L37
    L13:
        if (r111 == 3) goto L29;
        if (r111 != 4) goto L16;
        int r129 = r107.f274431h - r107.f274432i;
        if (r129 == 0) goto L27;
        r114 = (r102 - r107.f274428e) / r129;
    L28:
        float r130 = r114 / 2.0f;
        r109 = r100 + r130;
        r113 = (r102 - r101) - r130;
        goto L38
    L27:
        r114 = 0.0f;
        goto L28
    L16:
        if (r111 != 5) goto L23;
        int r131 = r107.f274431h - r107.f274432i;
        if (r131 == 0) goto L20;
        r114 = (r102 - r107.f274428e) / (r131 + 1);
    L21:
        r109 = r100 + r114;
        r113 = (r102 - r101) - r114;
        goto L38
    L20:
        r114 = 0.0f;
        goto L21
    L23:
        throw new IllegalStateException("Invalid justifyContent is set: " + this.f274345c);
    L29:
        r109 = r100;
        int r132 = r107.f274431h - r107.f274432i;
        if (r132 == 1) goto L32;
        float r133 = r132 - 1;
    L33:
        r114 = (r102 - r107.f274428e) / r133;
        r113 = r102 - r101;
        goto L38
    L32:
        r133 = 1.0f;
        goto L33
    L36:
        r109 = r100;
        r113 = r102 - r101;
        goto L37
    }

    public final void t(boolean r310, boolean r311, int r312, int r313, int r314, int r315) {
        int r100 = getPaddingTop();
        int r101 = getPaddingBottom();
        int r102 = getPaddingRight();
        int r103 = getPaddingLeft();
        int r104 = r315 - r313;
        int r105 = (r314 - r312) - r102;
        int r106 = this.f274358p.size();
        int r107 = 0;
    L3:
        if (r107 >= r106) goto L74;
        b r108 = (b) ListProtector.get(this.f274358p, r107);
        if (q(r107) == false) goto L7;
        int r110 = this.f274354l;
        r103 = r103 + r110;
        r105 = r105 - r110;
    L7:
        int r111 = this.f274345c;
        if (r111 == 0) goto L36;
        if (r111 != 1) goto L11;
        int r109 = r108.f274428e;
        float r112 = (r104 - r109) + r101;
        int r113 = r109 - r100;
    L37:
        float r114 = r113;
    L38:
        float r115 = 0.0f;
    L39:
        float r116 = Math.max(r115, 0.0f);
        int r117 = 0;
    L41:
        if (r117 >= r108.f274431h) goto L73;
        int r118 = r108.f274438o + r117;
        View r119 = g(r118);
        if (r119 != null) goto L45;
    L71:
        int r210 = r117;
    L72:
        r117 = r210 + 1;
        goto L41
    L45:
        if (r119.getVisibility() == 8) goto L71;
        LayoutParams r120 = (LayoutParams) r119.getLayoutParams();
        float r121 = r112 + ((ViewGroup.MarginLayoutParams) r120).topMargin;
        float r122 = r114 - ((ViewGroup.MarginLayoutParams) r120).bottomMargin;
        if (p(r118, r117) == false) goto L50;
        int r123 = this.f274353k;
        float r124 = r123;
        float r125 = r121 + r124;
        int r211 = r123;
        float r212 = r122 - r124;
    L52:
        if (r117 != (r108.f274431h - 1)) goto L57;
        if ((this.f274351i & 4) <= 0) goto L57;
        int r213 = this.f274353k;
    L58:
        if (r310 == false) goto L62;
        if (r311 == false) goto L61;
        r210 = r117;
        LayoutParams r214 = r120;
        this.f274357o.p(r119, r108, true, r105 - r119.getMeasuredWidth(), Math.round(r212) - r119.getMeasuredHeight(), r105, Math.round(r212));
    L66:
        LayoutParams r126 = r214;
        float r127 = r125 + ((r119.getMeasuredHeight() + r116) + ((ViewGroup.MarginLayoutParams) r126).bottomMargin);
        float r215 = r212 - ((r119.getMeasuredHeight() + r116) + ((ViewGroup.MarginLayoutParams) r126).topMargin);
        if (r311 == false) goto L69;
        r108.a(r119, 0, r213, 0, r211);
    L70:
        r112 = r127;
        r114 = r215;
        goto L72
    L69:
        r108.a(r119, 0, r211, 0, r213);
        goto L70
    L61:
        r210 = r117;
        r214 = r120;
        this.f274357o.p(r119, r108, true, r105 - r119.getMeasuredWidth(), Math.round(r125), r105, Math.round(r125) + r119.getMeasuredHeight());
        goto L66
    L62:
        r210 = r117;
        r214 = r120;
        if (r311 == false) goto L65;
        this.f274357o.p(r119, r108, false, r103, Math.round(r212) - r119.getMeasuredHeight(), r103 + r119.getMeasuredWidth(), Math.round(r212));
        goto L66
    L65:
        this.f274357o.p(r119, r108, false, r103, Math.round(r125), r103 + r119.getMeasuredWidth(), Math.round(r125) + r119.getMeasuredHeight());
    L57:
        r213 = 0;
        goto L58
    L50:
        r125 = r121;
        r212 = r122;
        r211 = 0;
        goto L52
    L73:
        int r128 = r108.f274430g;
        r103 = r103 + r128;
        r105 = r105 - r128;
        r107 = r107 + 1;
        goto L3
    L11:
        if (r111 != 2) goto L13;
        int r129 = r108.f274428e;
        r114 = (r104 - r101) - ((r104 - r129) / 2.0f);
        r112 = r100 + ((r104 - r129) / 2.0f);
        goto L38
    L13:
        if (r111 == 3) goto L29;
        if (r111 != 4) goto L16;
        int r130 = r108.f274431h - r108.f274432i;
        if (r130 == 0) goto L27;
        r115 = (r104 - r108.f274428e) / r130;
    L28:
        float r131 = r115 / 2.0f;
        r112 = r100 + r131;
        r114 = (r104 - r101) - r131;
        goto L39
    L27:
        r115 = 0.0f;
        goto L28
    L16:
        if (r111 != 5) goto L23;
        int r132 = r108.f274431h - r108.f274432i;
        if (r132 == 0) goto L20;
        r115 = (r104 - r108.f274428e) / (r132 + 1);
    L21:
        r112 = r100 + r115;
        r114 = (r104 - r101) - r115;
        goto L39
    L20:
        r115 = 0.0f;
        goto L21
    L23:
        throw new IllegalStateException("Invalid justifyContent is set: " + this.f274345c);
    L29:
        r112 = r100;
        int r133 = r108.f274431h - r108.f274432i;
        if (r133 == 1) goto L32;
        float r134 = r133 - 1;
    L33:
        r115 = (r104 - r108.f274428e) / r134;
        r114 = r104 - r101;
        goto L39
    L32:
        r134 = 1.0f;
        goto L33
    L36:
        r112 = r100;
        r113 = r104 - r101;
        goto L37
    }
}
