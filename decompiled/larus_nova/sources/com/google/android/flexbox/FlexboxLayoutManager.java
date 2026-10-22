package com.google.android.flexbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements com.google.android.flexbox.a, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Rect f274370y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f274371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f274372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f274373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f274374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f274375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f274376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<com.google.android.flexbox.b> f274377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f274378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView.Recycler f274379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView.State f274380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f274381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f274382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OrientationHelper f274383m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OrientationHelper f274384n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SavedState f274385o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f274386p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f274387q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f274388r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f274389s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SparseArray<View> f274390t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f274391u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f274392v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f274393w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c.a f274394x;

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f274395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f274396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f274397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f274398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f274399e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f274400f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f274401g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f274402h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f274403i;

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

        @Override // com.google.android.flexbox.FlexItem
        public final int getOrder() {
            return 1;
        }

        static {
            CREATOR = new a();
        }

        @Override // com.google.android.flexbox.FlexItem
        public final boolean B1() {
            return this.f274403i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getAlignSelf() {
            return this.f274397c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final float getFlexGrow() {
            return this.f274395a;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final float getFlexShrink() {
            return this.f274396b;
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
            return this.f274402h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMaxWidth() {
            return this.f274401g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMinHeight() {
            return this.f274400f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMinWidth() {
            return this.f274399e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final float l0() {
            return this.f274398d;
        }

        public LayoutParams(Parcel r100) {
            super(-2, -2);
            this.f274395a = 0.0f;
            this.f274396b = 1.0f;
            this.f274397c = -1;
            this.f274398d = -1.0f;
            this.f274401g = 16777215;
            this.f274402h = 16777215;
            this.f274395a = r100.readFloat();
            this.f274396b = r100.readFloat();
            this.f274397c = r100.readInt();
            this.f274398d = r100.readFloat();
            this.f274399e = r100.readInt();
            this.f274400f = r100.readInt();
            this.f274401g = r100.readInt();
            this.f274402h = r100.readInt();
            if (r100.readByte() == 0) goto L5;
            boolean r101 = true;
        L6:
            this.f274403i = r101;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r100.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r100.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r100.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = r100.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = r100.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = r100.readInt();
            return;
        L5:
            r101 = false;
            goto L6
        }

        @Override // com.google.android.flexbox.FlexItem
        public final void V0(int r100) {
            this.f274400f = r100;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final void a1(int r100) {
            this.f274399e = r100;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f274395a = 0.0f;
            this.f274396b = 1.0f;
            this.f274397c = -1;
            this.f274398d = -1.0f;
            this.f274401g = 16777215;
            this.f274402h = 16777215;
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.f274395a = 0.0f;
            this.f274396b = 1.0f;
            this.f274397c = -1;
            this.f274398d = -1.0f;
            this.f274401g = 16777215;
            this.f274402h = 16777215;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeFloat(this.f274395a);
            r100.writeFloat(this.f274396b);
            r100.writeInt(this.f274397c);
            r100.writeFloat(this.f274398d);
            r100.writeInt(this.f274399e);
            r100.writeInt(this.f274400f);
            r100.writeInt(this.f274401g);
            r100.writeInt(this.f274402h);
            r100.writeByte(this.f274403i ? 1 : 0);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            r100.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f274395a = 0.0f;
            this.f274396b = 1.0f;
            this.f274397c = -1;
            this.f274398d = -1.0f;
            this.f274401g = 16777215;
            this.f274402h = 16777215;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f274404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f274405b;

        public static class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public final String toString() {
            return "SavedState{mAnchorPosition=" + this.f274404a + ", mAnchorOffset=" + this.f274405b + '}';
        }

        public SavedState() {
        }

        public SavedState(Parcel r100) {
            this.f274404a = r100.readInt();
            this.f274405b = r100.readInt();
        }

        public SavedState(SavedState r100) {
            this.f274404a = r100.f274404a;
            this.f274405b = r100.f274405b;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.f274404a);
            r100.writeInt(this.f274405b);
        }
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f274406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f274407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f274408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f274409d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f274410e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f274411f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f274412g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ FlexboxLayoutManager f274413h;

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.f274406a + ", mFlexLinePosition=" + this.f274407b + ", mCoordinate=" + this.f274408c + ", mPerpendicularCoordinate=" + this.f274409d + ", mLayoutFromEnd=" + this.f274410e + ", mValid=" + this.f274411f + ", mAssignedFromSavedState=" + this.f274412g + '}';
        }

        static {
        }

        public a(FlexboxLayoutManager r100) {
            this.f274413h = r100;
            this.f274409d = 0;
        }

        public static void a(a r100) {
            if (r100.f274413h.o() == true) goto L12;
            FlexboxLayoutManager r101 = r100.f274413h;
            if (r101.f274375e == false) goto L12;
            if (r100.f274410e == false) goto L9;
            int r102 = r101.f274383m.getEndAfterPadding();
        L10:
            r100.f274408c = r102;
            return;
        L9:
            r102 = r101.getWidth() - r100.f274413h.f274383m.getStartAfterPadding();
        L12:
            if (r100.f274410e == false) goto L14;
            int r103 = r100.f274413h.f274383m.getEndAfterPadding();
        L15:
            r100.f274408c = r103;
            return;
        L14:
            r103 = r100.f274413h.f274383m.getStartAfterPadding();
            goto L15
        }

        public static void b(a r100) {
            r100.f274406a = -1;
            r100.f274407b = -1;
            r100.f274408c = Integer.MIN_VALUE;
            boolean r101 = false;
            r100.f274411f = false;
            r100.f274412g = false;
            if (r100.f274413h.o() == false) goto L13;
            FlexboxLayoutManager r102 = r100.f274413h;
            int r103 = r102.f274372b;
            if (r103 == 0) goto L7;
            if (r103 != 2) goto L12;
            r101 = true;
        L12:
            r100.f274410e = r101;
            return;
        L7:
            if (r102.f274371a != 1) goto L9;
            r101 = true;
        L9:
            r100.f274410e = r101;
            return;
        L13:
            FlexboxLayoutManager r104 = r100.f274413h;
            int r105 = r104.f274372b;
            if (r105 == 0) goto L16;
            if (r105 != 2) goto L21;
            r101 = true;
        L21:
            r100.f274410e = r101;
            return;
        L16:
            if (r104.f274371a != 3) goto L18;
            r101 = true;
        L18:
            r100.f274410e = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f274414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f274415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f274416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f274417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f274418e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f274419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f274420g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f274421h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f274422i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f274423j;

        public final String toString() {
            return "LayoutState{mAvailable=" + this.f274414a + ", mFlexLinePosition=" + this.f274416c + ", mPosition=" + this.f274417d + ", mOffset=" + this.f274418e + ", mScrollingOffset=" + this.f274419f + ", mLastScrollDelta=" + this.f274420g + ", mItemDirection=" + this.f274421h + ", mLayoutDirection=" + this.f274422i + '}';
        }

        public b() {
            this.f274421h = 1;
            this.f274422i = 1;
        }
    }

    @Override // com.google.android.flexbox.a
    public final void b(com.google.android.flexbox.b r100) {
    }

    @Override // com.google.android.flexbox.a
    public final int getAlignContent() {
        return 5;
    }

    static {
        f274370y = new Rect();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f274372b != 0) goto L7;
        return o();
    L7:
        if (o() == false) goto L13;
        int r100 = getWidth();
        View r101 = this.f274392v;
        if (r101 == null) goto L11;
        int r102 = r101.getWidth();
    L12:
        if (r100 > r102) goto L13;
        return false;
    L11:
        r102 = 0;
    L13:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        if (this.f274372b != 0) goto L7;
        return !o();
    L7:
        if (o() == true) goto L16;
        int r100 = getHeight();
        View r101 = this.f274392v;
        if (r101 == null) goto L11;
        int r102 = r101.getHeight();
    L12:
        if (r100 > r102) goto L17;
        return false;
    L17:
        return true;
    L11:
        r102 = 0;
        goto L12
    L16:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // com.google.android.flexbox.a
    public final int getFlexItemCount() {
        return this.f274380j.getItemCount();
    }

    @Override // com.google.android.flexbox.a
    public final int getLargestMainSize() {
        int r100 = 0;
        if (this.f274377g.size() != 0) goto L5;
        return 0;
    L5:
        int r101 = this.f274377g.size();
        int r102 = Integer.MIN_VALUE;
    L6:
        if (r100 >= r101) goto L8;
        r102 = Math.max(r102, ((com.google.android.flexbox.b) ListProtector.get(this.f274377g, r100)).f274428e);
        r100 = r100 + 1;
        goto L6
    L8:
        return r102;
    }

    @Override // com.google.android.flexbox.a
    public final int getSumOfCrossSize() {
        int r100 = this.f274377g.size();
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L5;
        r102 = r102 + ((com.google.android.flexbox.b) ListProtector.get(this.f274377g, r101)).f274430g;
        r101 = r101 + 1;
        goto L3
    L5:
        return r102;
    }

    @Override // com.google.android.flexbox.a
    public final boolean o() {
        int r100 = this.f274371a;
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final Parcelable onSaveInstanceState() {
        if (this.f274385o != null) goto L5;
        SavedState r100 = new SavedState();
        if (getChildCount() <= 0) goto L9;
        View r101 = getChildAt(0);
        r100.f274404a = getPosition(r101);
        r100.f274405b = this.f274383m.getDecoratedStart(r101) - this.f274383m.getStartAfterPadding();
    L10:
        return r100;
    L9:
        r100.f274404a = -1;
        goto L10
    L5:
        return new SavedState(this.f274385o);
    }

    public final void p() {
        if (this.f274383m == null) goto L6;
        return;
    L6:
        if (o() == false) goto L12;
        if (this.f274372b != 0) goto L10;
        this.f274383m = OrientationHelper.createHorizontalHelper(this);
        this.f274384n = OrientationHelper.createVerticalHelper(this);
        return;
    L10:
        this.f274383m = OrientationHelper.createVerticalHelper(this);
        this.f274384n = OrientationHelper.createHorizontalHelper(this);
        return;
    L12:
        if (this.f274372b != 0) goto L14;
        this.f274383m = OrientationHelper.createVerticalHelper(this);
        this.f274384n = OrientationHelper.createHorizontalHelper(this);
        return;
    L14:
        this.f274383m = OrientationHelper.createHorizontalHelper(this);
        this.f274384n = OrientationHelper.createVerticalHelper(this);
    }

    public final void A() {
        if (o() == false) goto L5;
        int r100 = getHeightMode();
    L6:
        b r101 = this.f274381k;
        if (r100 != 0) goto L9;
    L12:
        boolean r102 = true;
    L13:
        r101.f274415b = r102;
        return;
    L9:
        if (r100 == Integer.MIN_VALUE) goto L12;
        r102 = false;
        goto L13
    L5:
        r100 = getWidthMode();
        goto L6
    }

    @Override // com.google.android.flexbox.a
    public final int getAlignItems() {
        return this.f274373c;
    }

    @Override // com.google.android.flexbox.a
    public final int getFlexDirection() {
        return this.f274371a;
    }

    @Override // com.google.android.flexbox.a
    public final List<com.google.android.flexbox.b> getFlexLinesInternal() {
        return this.f274377g;
    }

    @Override // com.google.android.flexbox.a
    public final int getFlexWrap() {
        return this.f274372b;
    }

    @Override // com.google.android.flexbox.a
    public final int getMaxLine() {
        return this.f274374d;
    }

    public FlexboxLayoutManager(Context r100) {
        this(r100, 0, 1);
    }

    public final void B(int r100) {
        if (this.f274373c == 4) goto L6;
        removeAllViews();
        this.f274377g.clear();
        a.b(this.f274382l);
        this.f274382l.f274409d = 0;
        this.f274373c = 4;
        requestLayout();
        return;
    }

    public final void C(int r100) {
        if (this.f274371a == r100) goto L6;
        removeAllViews();
        this.f274371a = r100;
        this.f274383m = null;
        this.f274384n = null;
        this.f274377g.clear();
        a.b(this.f274382l);
        this.f274382l.f274409d = 0;
        requestLayout();
        return;
    }

    public final void D(int r100) {
        if (r100 == 2) goto L12;
        int r101 = this.f274372b;
        if (r101 == r100) goto L13;
        if (r101 == 0) goto L8;
        if (r100 == 0) goto L8;
    L9:
        this.f274372b = r100;
        this.f274383m = null;
        this.f274384n = null;
        requestLayout();
        return;
    L8:
        removeAllViews();
        this.f274377g.clear();
        a.b(this.f274382l);
        this.f274382l.f274409d = 0;
        goto L9
    L13:
        return;
    L12:
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    public final void E(int r100) {
        int r101 = -1;
        View r102 = v(getChildCount() - 1, -1, false);
        if (r102 == null) goto L6;
        r101 = getPosition(r102);
    L6:
        if (r100 < r101) goto L8;
        return;
    L8:
        int r103 = getChildCount();
        this.f274378h.j(r103);
        this.f274378h.k(r103);
        this.f274378h.i(r103);
        if (r100 < this.f274378h.f274444c.length) goto L11;
        return;
    L11:
        this.f274393w = r100;
        View r104 = getChildAt(0);
        if (r104 != null) goto L14;
        return;
    L14:
        this.f274386p = getPosition(r104);
        if (o() == false) goto L17;
    L19:
        this.f274387q = this.f274383m.getDecoratedStart(r104) - this.f274383m.getStartAfterPadding();
        return;
    L17:
        if (this.f274375e == false) goto L19;
        this.f274387q = this.f274383m.getDecoratedEnd(r104) + this.f274383m.getEndPadding();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean checkLayoutParams(RecyclerView.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollExtent(RecyclerView.State r100) {
        return computeScrollExtent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(RecyclerView.State r100) {
        return computeScrollOffset(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollRange(RecyclerView.State r100) {
        return computeScrollRange(r100);
    }

    public final int computeScrollExtent(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        int r101 = r100.getItemCount();
        p();
        View r102 = r(r101);
        View r103 = t(r101);
        if (r100.getItemCount() == 0) goto L12;
        if (r102 == null) goto L12;
        if (r103 == null) goto L12;
        int r104 = this.f274383m.getDecoratedEnd(r103) - this.f274383m.getDecoratedStart(r102);
        return Math.min(this.f274383m.getTotalSpace(), r104);
    L12:
        return 0;
    }

    public final int computeScrollOffset(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        int r101 = r100.getItemCount();
        View r102 = r(r101);
        View r103 = t(r101);
        if (r100.getItemCount() == 0) goto L17;
        if (r102 == null) goto L17;
        if (r103 == null) goto L17;
        int r104 = getPosition(r102);
        int r105 = getPosition(r103);
        int r106 = Math.abs(this.f274383m.getDecoratedEnd(r103) - this.f274383m.getDecoratedStart(r102));
        int[] r107 = this.f274378h.f274444c;
        int r108 = r107[r104];
        if (r108 == 0) goto L17;
        if (r108 == (-1)) goto L17;
        return Math.round((r108 * (r106 / ((r107[r105] - r108) + 1))) + (this.f274383m.getStartAfterPadding() - this.f274383m.getDecoratedStart(r102)));
    L17:
        return 0;
    }

    public final int computeScrollRange(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        int r101 = r100.getItemCount();
        View r102 = r(r101);
        View r103 = t(r101);
        if (r100.getItemCount() == 0) goto L20;
        if (r102 == null) goto L20;
        if (r103 == null) goto L20;
        View r104 = v(0, getChildCount(), false);
        int r105 = -1;
        if (r104 != null) goto L13;
        int r106 = -1;
    L14:
        View r107 = v(getChildCount() - 1, -1, false);
        if (r107 == null) goto L19;
        r105 = getPosition(r107);
    L19:
        return (int) ((Math.abs(this.f274383m.getDecoratedEnd(r103) - this.f274383m.getDecoratedStart(r102)) / ((r105 - r106) + 1)) * r100.getItemCount());
    L13:
        r106 = getPosition(r104);
    L20:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF computeScrollVectorForPosition(int r100) {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        if (r100 >= getPosition(getChildAt(0))) goto L9;
        int r101 = -1;
    L11:
        if (o() == false) goto L15;
        return new PointF(0.0f, r101);
    L15:
        return new PointF(r101, 0.0f);
    L9:
        r101 = 1;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollExtent(RecyclerView.State r100) {
        return computeScrollExtent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State r100) {
        return computeScrollOffset(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollRange(RecyclerView.State r100) {
        return computeScrollRange(r100);
    }

    @Override // com.google.android.flexbox.a
    public final View d(int r100) {
        View r101 = this.f274390t.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return this.f274379i.getViewForPosition(r100);
    }

    @Override // com.google.android.flexbox.a
    public final int h(View r100) {
        if (o() == false) goto L5;
        int r101 = getTopDecorationHeight(r100);
        int r102 = getBottomDecorationHeight(r100);
    L7:
        return r101 + r102;
    L5:
        r101 = getLeftDecorationWidth(r100);
        r102 = getRightDecorationWidth(r100);
        goto L7
    }

    @Override // com.google.android.flexbox.a
    public final View l(int r100) {
        return d(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView r100) {
        super.onAttachedToWindow(r100);
        this.f274392v = (View) r100.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        this.f274385o = null;
        this.f274386p = -1;
        this.f274387q = Integer.MIN_VALUE;
        this.f274393w = -1;
        a.b(this.f274382l);
        this.f274390t.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == false) goto L6;
        this.f274385o = (SavedState) r100;
        requestLayout();
        return;
    }

    public final View r(int r100) {
        View r101 = w(0, getChildCount(), r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        int r102 = getPosition(r101);
        int r103 = this.f274378h.f274444c[r102];
        if (r103 != (-1)) goto L9;
        return null;
    L9:
        return s(r101, (com.google.android.flexbox.b) ListProtector.get(this.f274377g, r103));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        this.f274386p = r100;
        this.f274387q = Integer.MIN_VALUE;
        SavedState r101 = this.f274385o;
        if (r101 == null) goto L5;
        r101.f274404a = -1;
    L5:
        requestLayout();
    }

    @Override // com.google.android.flexbox.a
    public final void setFlexLines(List<com.google.android.flexbox.b> r100) {
        this.f274377g = r100;
    }

    public final View t(int r100) {
        View r101 = w(getChildCount() - 1, -1, r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return u(r101, (com.google.android.flexbox.b) ListProtector.get(this.f274377g, this.f274378h.f274444c[getPosition(r101)]));
    }

    public final int y(int r100) {
        boolean r101 = false;
        if (getChildCount() == 0) goto L28;
        if (r100 == 0) goto L28;
        p();
        boolean r102 = o();
        View r103 = this.f274392v;
        if (r102 == false) goto L9;
        int r104 = r103.getWidth();
    L10:
        if (r102 == false) goto L12;
        int r105 = getWidth();
    L14:
        if (getLayoutDirection() != 1) goto L16;
        r101 = true;
    L16:
        if (r101 == false) goto L23;
        int r106 = Math.abs(r100);
        if (r100 < 0) goto L27;
        int r107 = this.f274382l.f274409d;
        if ((r107 + r100) > 0) goto L30;
        return r100;
    L30:
        return -r107;
    L27:
        return -Math.min((r105 + this.f274382l.f274409d) - r104, r106);
    L23:
        if (r100 > 0) goto L31;
        r107 = this.f274382l.f274409d;
        if ((r107 + r100) < 0) goto L30;
        return r100;
    L31:
        return Math.min((r105 - this.f274382l.f274409d) - r104, r100);
    L12:
        r105 = getHeight();
        goto L14
    L9:
        r104 = r103.getHeight();
    L28:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(Context r100, AttributeSet r101) {
        return new LayoutParams(r100, r101);
    }

    @Override // com.google.android.flexbox.a
    public final void n(int r100, View r101) {
        this.f274390t.put(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter r100, RecyclerView.Adapter r101) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        super.onDetachedFromWindow(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r210, RecyclerView.State r211) {
        this.f274379i = r210;
        this.f274380j = r211;
        int r100 = r211.getItemCount();
        if (r100 == 0) goto L5;
    L7:
        int r101 = getLayoutDirection();
        int r102 = this.f274371a;
        if (r102 == 0) goto L36;
        if (r102 == 1) goto L28;
        if (r102 != 2) goto L12;
        if (r101 != 1) goto L23;
        boolean r103 = true;
    L24:
        this.f274375e = r103;
        if (this.f274372b != 2) goto L27;
        this.f274375e = !r103;
    L27:
        this.f274376f = false;
    L44:
        p();
        if (this.f274381k != null) goto L47;
        this.f274381k = new b();
    L47:
        this.f274378h.j(r100);
        this.f274378h.k(r100);
        this.f274378h.i(r100);
        this.f274381k.f274423j = false;
        SavedState r104 = this.f274385o;
        if (r104 == null) goto L56;
        int r105 = r104.f274404a;
        if (r105 < 0) goto L53;
        if (r105 >= r100) goto L53;
        boolean r106 = true;
    L54:
        if (r106 == false) goto L56;
        this.f274386p = r105;
    L53:
        r106 = false;
    L56:
        a r107 = this.f274382l;
        if (r107.f274411f == true) goto L59;
    L61:
        a.b(r107);
        a r108 = this.f274382l;
        SavedState r109 = this.f274385o;
        if (r211.isPreLayout() == true) goto L113;
        int r110 = this.f274386p;
        if (r110 == (-1)) goto L113;
        if (r110 >= 0) goto L68;
    L112:
        this.f274386p = -1;
        this.f274387q = Integer.MIN_VALUE;
        goto L113
    L68:
        if (r110 >= r211.getItemCount()) goto L112;
        int r111 = this.f274386p;
        r108.f274406a = r111;
        r108.f274407b = this.f274378h.f274444c[r111];
        SavedState r112 = this.f274385o;
        if (r112 == null) goto L80;
        int r113 = r211.getItemCount();
        int r114 = r112.f274404a;
        if (r114 < 0) goto L76;
        if (r114 >= r113) goto L76;
        boolean r115 = true;
    L77:
        if (r115 == false) goto L80;
        r108.f274408c = this.f274383m.getStartAfterPadding() + r109.f274405b;
        r108.f274412g = true;
        r108.f274407b = -1;
    L111:
        boolean r116 = true;
    L114:
        if (r116 == false) goto L117;
    L173:
        this.f274382l.f274411f = true;
    L174:
        detachAndScrapAttachedViews(r210);
        a r117 = this.f274382l;
        if (r117.f274410e == false) goto L177;
        G(r117, false, true);
    L178:
        int r118 = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int r119 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int r120 = getWidth();
        int r121 = getHeight();
        if (o() == false) goto L189;
        int r122 = this.f274388r;
        if (r122 == Integer.MIN_VALUE) goto L184;
        if (r122 == r120) goto L184;
        boolean r123 = true;
    L185:
        b r124 = this.f274381k;
        if (r124.f274415b == false) goto L188;
        Resources r125 = this.f274391u.getResources();
        int r126 = WindowDisplayMetricsOverride.apply(r125, r125.getDisplayMetrics()).heightPixels;
    L198:
        int r127 = r126;
        this.f274388r = r120;
        this.f274389s = r121;
        int r128 = this.f274393w;
        if (r128 == (-1)) goto L201;
    L211:
        if (r128 == (-1)) goto L213;
        int r129 = Math.min(r128, this.f274382l.f274406a);
    L214:
        c.a r130 = this.f274394x;
        r130.f274447a = null;
        r130.f274448b = 0;
        if (o() == false) goto L221;
        if (this.f274377g.size() <= 0) goto L219;
        this.f274378h.d(this.f274377g, r129);
        this.f274378h.b(this.f274394x, r118, r119, r127, r129, this.f274382l.f274406a, this.f274377g);
    L224:
        this.f274377g = this.f274394x.f274447a;
        this.f274378h.h(r118, r119, r129);
        this.f274378h.u(r129);
    L226:
        if (this.f274382l.f274410e == false) goto L228;
        q(r210, r211, this.f274381k);
        int r131 = this.f274381k.f274418e;
        F(this.f274382l, true, false);
        q(r210, r211, this.f274381k);
        int r132 = this.f274381k.f274418e;
    L230:
        if (getChildCount() > 0) goto L232;
        return;
    L232:
        if (this.f274382l.f274410e == false) goto L234;
        fixLayoutStartGap(r131 + fixLayoutEndGap(r132, r210, r211, true), r210, r211, false);
        return;
    L234:
        fixLayoutEndGap(r132 + fixLayoutStartGap(r131, r210, r211, true), r210, r211, false);
        return;
    L228:
        q(r210, r211, this.f274381k);
        r132 = this.f274381k.f274418e;
        G(this.f274382l, true, false);
        q(r210, r211, this.f274381k);
        r131 = this.f274381k.f274418e;
        goto L230
    L219:
        this.f274378h.i(r100);
        this.f274378h.b(this.f274394x, r118, r119, r127, 0, -1, this.f274377g);
        goto L224
    L221:
        if (this.f274377g.size() <= 0) goto L223;
        this.f274378h.d(this.f274377g, r129);
        this.f274378h.b(this.f274394x, r119, r118, r127, r129, this.f274382l.f274406a, this.f274377g);
        goto L224
    L223:
        this.f274378h.i(r100);
        this.f274378h.b(this.f274394x, r119, r118, r127, 0, -1, this.f274377g);
        goto L224
    L213:
        r129 = this.f274382l.f274406a;
        goto L214
    L201:
        if (this.f274386p != (-1)) goto L204;
        if (r123 == false) goto L211;
    L204:
        if (this.f274382l.f274410e == true) goto L226;
        this.f274377g.clear();
        c.a r133 = this.f274394x;
        r133.f274447a = null;
        r133.f274448b = 0;
        if (o() == false) goto L209;
        this.f274378h.b(this.f274394x, r118, r119, r127, 0, this.f274382l.f274406a, this.f274377g);
    L210:
        this.f274377g = this.f274394x.f274447a;
        this.f274378h.h(r118, r119, 0);
        this.f274378h.u(0);
        a r134 = this.f274382l;
        int r135 = this.f274378h.f274444c[r134.f274406a];
        r134.f274407b = r135;
        this.f274381k.f274416c = r135;
        goto L226
    L209:
        this.f274378h.b(this.f274394x, r119, r118, r127, 0, this.f274382l.f274406a, this.f274377g);
        goto L210
    L188:
        r126 = r124.f274414a;
    L184:
        r123 = false;
        goto L185
    L189:
        int r136 = this.f274389s;
        if (r136 == Integer.MIN_VALUE) goto L193;
        if (r136 == r121) goto L193;
        r123 = true;
    L194:
        b r137 = this.f274381k;
        if (r137.f274415b == false) goto L197;
        Resources r138 = this.f274391u.getResources();
        r126 = WindowDisplayMetricsOverride.apply(r138, r138.getDisplayMetrics()).widthPixels;
        goto L198
    L197:
        r126 = r137.f274414a;
    L193:
        r123 = false;
        goto L194
    L177:
        F(r117, false, true);
        goto L178
    L117:
        if (getChildCount() != 0) goto L120;
    L169:
        boolean r139 = false;
    L170:
        if (r139 == true) goto L173;
        a.a(r108);
        r108.f274406a = 0;
        r108.f274407b = 0;
        goto L173
    L120:
        if (r108.f274410e == false) goto L122;
        View r140 = t(r211.getItemCount());
    L123:
        if (r140 == null) goto L169;
        FlexboxLayoutManager r141 = r108.f274413h;
        if (r141.f274372b != 0) goto L127;
        OrientationHelper r142 = r141.f274384n;
    L129:
        if (r141.o() == true) goto L137;
        if (r108.f274413h.f274375e == false) goto L137;
        if (r108.f274410e == false) goto L135;
        r108.f274408c = r142.getDecoratedStart(r140) + r142.getTotalSpaceChange();
    L140:
        int r143 = r108.f274413h.getPosition(r140);
        r108.f274406a = r143;
        r108.f274412g = false;
        FlexboxLayoutManager r144 = r108.f274413h;
        int[] r145 = r144.f274378h.f274444c;
        if (r143 != (-1)) goto L144;
        r143 = 0;
    L144:
        int r146 = r145[r143];
        if (r146 != (-1)) goto L148;
        r146 = 0;
    L148:
        r108.f274407b = r146;
        int r147 = r144.f274377g.size();
        int r148 = r108.f274407b;
        if (r147 <= r148) goto L152;
        r108.f274406a = ((com.google.android.flexbox.b) ListProtector.get(r108.f274413h.f274377g, r148)).f274438o;
    L152:
        if (r211.isPreLayout() == false) goto L154;
    L168:
        r139 = true;
        goto L170
    L154:
        if (supportsPredictiveItemAnimations() == false) goto L168;
        if (this.f274383m.getDecoratedStart(r140) < this.f274383m.getEndAfterPadding()) goto L158;
    L161:
        boolean r149 = true;
    L162:
        if (r149 == false) goto L168;
        if (r108.f274410e == false) goto L166;
        int r150 = this.f274383m.getEndAfterPadding();
    L167:
        r108.f274408c = r150;
        goto L168
    L166:
        r150 = this.f274383m.getStartAfterPadding();
        goto L167
    L158:
        if (this.f274383m.getDecoratedEnd(r140) < this.f274383m.getStartAfterPadding()) goto L161;
        r149 = false;
        goto L162
    L135:
        r108.f274408c = r142.getDecoratedEnd(r140);
    L137:
        if (r108.f274410e == false) goto L139;
        r108.f274408c = r142.getDecoratedEnd(r140) + r142.getTotalSpaceChange();
        goto L140
    L139:
        r108.f274408c = r142.getDecoratedStart(r140);
        goto L140
    L127:
        r142 = r141.f274383m;
        goto L129
    L122:
        r140 = r(r211.getItemCount());
    L76:
        r115 = false;
    L80:
        if (this.f274387q != Integer.MIN_VALUE) goto L106;
        View r151 = findViewByPosition(this.f274386p);
        if (r151 == null) goto L98;
        if (this.f274383m.getDecoratedMeasurement(r151) <= this.f274383m.getTotalSpace()) goto L87;
        a.a(r108);
        goto L111
    L87:
        if ((this.f274383m.getDecoratedStart(r151) - this.f274383m.getStartAfterPadding()) >= 0) goto L90;
        r108.f274408c = this.f274383m.getStartAfterPadding();
        r108.f274410e = false;
        goto L111
    L90:
        if ((this.f274383m.getEndAfterPadding() - this.f274383m.getDecoratedEnd(r151)) >= 0) goto L93;
        r108.f274408c = this.f274383m.getEndAfterPadding();
        r108.f274410e = true;
        goto L111
    L93:
        if (r108.f274410e == false) goto L95;
        int r152 = this.f274383m.getDecoratedEnd(r151) + this.f274383m.getTotalSpaceChange();
    L96:
        r108.f274408c = r152;
        goto L111
    L95:
        r152 = this.f274383m.getDecoratedStart(r151);
        goto L96
    L98:
        if (getChildCount() > 0) goto L100;
    L104:
        a.a(r108);
        goto L111
    L100:
        if (this.f274386p >= getPosition(getChildAt(0))) goto L102;
        boolean r153 = true;
    L103:
        r108.f274410e = r153;
        goto L104
    L102:
        r153 = false;
        goto L103
    L106:
        if (o() == false) goto L108;
    L110:
        r108.f274408c = this.f274383m.getStartAfterPadding() + this.f274387q;
        goto L111
    L108:
        if (this.f274375e == false) goto L110;
        r108.f274408c = this.f274387q - this.f274383m.getEndPadding();
    L113:
        r116 = false;
        goto L114
    L59:
        if (this.f274386p != (-1)) goto L61;
        if (r104 == null) goto L174;
    L23:
        r103 = false;
        goto L24
    L12:
        if (r102 == 3) goto L14;
        this.f274375e = false;
        this.f274376f = false;
        goto L44
    L14:
        if (r101 != 1) goto L16;
        boolean r154 = true;
    L17:
        this.f274375e = r154;
        if (this.f274372b != 2) goto L20;
        this.f274375e = !r154;
    L20:
        this.f274376f = true;
        goto L44
    L16:
        r154 = false;
        goto L17
    L28:
        if (r101 == 1) goto L30;
        boolean r155 = true;
    L31:
        this.f274375e = r155;
        if (this.f274372b != 2) goto L34;
        boolean r156 = true;
    L35:
        this.f274376f = r156;
        goto L44
    L34:
        r156 = false;
        goto L35
    L30:
        r155 = false;
        goto L31
    L36:
        if (r101 != 1) goto L38;
        boolean r157 = true;
    L39:
        this.f274375e = r157;
        if (this.f274372b != 2) goto L42;
        boolean r158 = true;
    L43:
        this.f274376f = r158;
        goto L44
    L42:
        r158 = false;
        goto L43
    L38:
        r157 = false;
        goto L39
    L5:
        if (r211.isPreLayout() == false) goto L7;
    }

    public final View s(View r100, com.google.android.flexbox.b r101) {
        boolean r102 = o();
        int r103 = r101.f274431h;
        int r104 = 1;
    L3:
        if (r104 >= r103) goto L19;
        View r105 = getChildAt(r104);
        if (r105 == null) goto L18;
        if (r105.getVisibility() == 8) goto L18;
        if (this.f274375e == false) goto L16;
        if (r102 == true) goto L16;
        if (this.f274383m.getDecoratedEnd(r100) >= this.f274383m.getDecoratedEnd(r105)) goto L18;
    L17:
        r100 = r105;
    L16:
        if (this.f274383m.getDecoratedStart(r100) > this.f274383m.getDecoratedStart(r105)) goto L17;
    L18:
        r104 = r104 + 1;
        goto L3
    L19:
        return r100;
    }

    public final View u(View r100, com.google.android.flexbox.b r101) {
        boolean r102 = o();
        int r103 = getChildCount() - 2;
        int r104 = (getChildCount() - r101.f274431h) - 1;
    L3:
        if (r103 <= r104) goto L19;
        View r105 = getChildAt(r103);
        if (r105 == null) goto L18;
        if (r105.getVisibility() == 8) goto L18;
        if (this.f274375e == false) goto L16;
        if (r102 == true) goto L16;
        if (this.f274383m.getDecoratedStart(r100) <= this.f274383m.getDecoratedStart(r105)) goto L18;
    L17:
        r100 = r105;
    L16:
        if (this.f274383m.getDecoratedEnd(r100) < this.f274383m.getDecoratedEnd(r105)) goto L17;
    L18:
        r103 = r103 - 1;
        goto L3
    L19:
        return r100;
    }

    public final void z(RecyclerView.Recycler r110, b r111) {
        if (r111.f274423j == true) goto L5;
        return;
    L5:
        int r100 = -1;
        if (r111.f274422i != (-1)) goto L39;
        if (r111.f274419f < 0) goto L70;
        this.f274383m.getEnd();
        int r101 = getChildCount();
        if (r101 == 0) goto L85;
        int r102 = r101 - 1;
        int r103 = this.f274378h.f274444c[getPosition(getChildAt(r102))];
        if (r103 == (-1)) goto L86;
        com.google.android.flexbox.b r104 = (com.google.android.flexbox.b) ListProtector.get(this.f274377g, r103);
        int r105 = r102;
    L17:
        if (r105 < 0) goto L36;
        View r106 = getChildAt(r105);
        int r107 = r111.f274419f;
        if (o() == true) goto L26;
        if (this.f274375e == false) goto L26;
        if (this.f274383m.getDecoratedEnd(r106) <= r107) goto L27;
    L28:
        boolean r108 = false;
    L29:
        if (r108 == false) goto L36;
        if (r104.f274438o != getPosition(r106)) goto L35;
        if (r103 <= 0) goto L33;
        r103 = r103 + r111.f274422i;
        r104 = (com.google.android.flexbox.b) ListProtector.get(this.f274377g, r103);
        r101 = r105;
        goto L35
    L33:
        r101 = r105;
    L35:
        r105 = r105 - 1;
    L27:
        r108 = true;
    L26:
        if (this.f274383m.getDecoratedStart(r106) < (this.f274383m.getEnd() - r107)) goto L28;
    L36:
        if (r102 < r101) goto L90;
        removeAndRecycleViewAt(r102, r110);
        r102 = r102 - 1;
        goto L36
    L90:
        return;
    L86:
        return;
    L85:
        return;
    L70:
        return;
    L39:
        if (r111.f274419f < 0) goto L87;
        int r109 = getChildCount();
        if (r109 == 0) goto L88;
        int r112 = this.f274378h.f274444c[getPosition(getChildAt(0))];
        if (r112 == (-1)) goto L89;
        com.google.android.flexbox.b r113 = (com.google.android.flexbox.b) ListProtector.get(this.f274377g, r112);
        int r114 = 0;
    L48:
        if (r114 >= r109) goto L68;
        View r115 = getChildAt(r114);
        int r116 = r111.f274419f;
        if (o() == true) goto L57;
        if (this.f274375e == false) goto L57;
        if ((this.f274383m.getEnd() - this.f274383m.getDecoratedStart(r115)) <= r116) goto L58;
    L59:
        boolean r117 = false;
    L60:
        if (r117 == false) goto L68;
        if (r113.f274439p != getPosition(r115)) goto L67;
        if (r112 >= (this.f274377g.size() - 1)) goto L65;
        r112 = r112 + r111.f274422i;
        r113 = (com.google.android.flexbox.b) ListProtector.get(this.f274377g, r112);
        r100 = r114;
        goto L67
    L65:
        r100 = r114;
    L67:
        r114 = r114 + 1;
    L58:
        r117 = true;
    L57:
        if (this.f274383m.getDecoratedEnd(r115) > r116) goto L59;
    L68:
        if (r100 < 0) goto L91;
        removeAndRecycleViewAt(r100, r110);
        r100 = r100 - 1;
        goto L68
    L91:
        return;
    L89:
        return;
    L88:
        return;
    }

    public FlexboxLayoutManager(Context r100, int r101, int r102) {
        this.f274374d = -1;
        this.f274377g = new ArrayList();
        this.f274378h = new c(this);
        this.f274382l = new a(this);
        this.f274386p = -1;
        this.f274387q = Integer.MIN_VALUE;
        this.f274388r = Integer.MIN_VALUE;
        this.f274389s = Integer.MIN_VALUE;
        this.f274390t = new SparseArray();
        this.f274393w = -1;
        this.f274394x = new c.a();
        C(r101);
        D(r102);
        B(4);
        setAutoMeasureEnabled(true);
        this.f274391u = r100;
    }

    public static boolean isMeasurementUpToDate(int r100, int r101, int r102) {
        int r103 = View.MeasureSpec.getMode(r101);
        int r104 = View.MeasureSpec.getSize(r101);
        if (r102 <= 0) goto L7;
        if (r100 == r102) goto L7;
        return false;
    L7:
        if (r103 == Integer.MIN_VALUE) goto L16;
        if (r103 != 0) goto L10;
        return true;
    L10:
        if (r103 == 1073741824) goto L12;
        return false;
    L12:
        if (r104 != r100) goto L19;
        return true;
    L19:
        return false;
    L16:
        if (r104 < r100) goto L20;
        return true;
    L20:
        return false;
    }

    public final void F(a r100, boolean r101, boolean r102) {
        if (r102 == false) goto L4;
        A();
    L6:
        if (o() == false) goto L8;
    L10:
        this.f274381k.f274414a = this.f274383m.getEndAfterPadding() - r100.f274408c;
    L11:
        b r103 = this.f274381k;
        r103.f274417d = r100.f274406a;
        r103.f274421h = 1;
        r103.f274422i = 1;
        r103.f274418e = r100.f274408c;
        r103.f274419f = Integer.MIN_VALUE;
        r103.f274416c = r100.f274407b;
        if (r101 == true) goto L14;
        return;
    L14:
        if (this.f274377g.size() <= 1) goto L22;
        int r104 = r100.f274407b;
        if (r104 >= 0) goto L18;
        return;
    L18:
        if (r104 >= (this.f274377g.size() - 1)) goto L24;
        com.google.android.flexbox.b r105 = (com.google.android.flexbox.b) ListProtector.get(this.f274377g, r100.f274407b);
        b r106 = this.f274381k;
        r106.f274416c++;
        r106.f274417d += r105.f274431h;
        return;
    L24:
        return;
    L22:
        return;
    L8:
        if (this.f274375e == false) goto L10;
        this.f274381k.f274414a = r100.f274408c - getPaddingRight();
        goto L11
    L4:
        this.f274381k.f274415b = false;
        goto L6
    }

    public final void G(a r100, boolean r101, boolean r102) {
        if (r102 == false) goto L4;
        A();
    L6:
        if (o() == false) goto L8;
    L10:
        this.f274381k.f274414a = r100.f274408c - this.f274383m.getStartAfterPadding();
    L11:
        b r103 = this.f274381k;
        r103.f274417d = r100.f274406a;
        r103.f274421h = 1;
        r103.f274422i = -1;
        r103.f274418e = r100.f274408c;
        r103.f274419f = Integer.MIN_VALUE;
        int r104 = r100.f274407b;
        r103.f274416c = r104;
        if (r101 == false) goto L18;
        if (r104 <= 0) goto L19;
        int r105 = this.f274377g.size();
        int r106 = r100.f274407b;
        if (r105 <= r106) goto L20;
        com.google.android.flexbox.b r107 = (com.google.android.flexbox.b) ListProtector.get(this.f274377g, r106);
        b r108 = this.f274381k;
        r108.f274416c--;
        r108.f274417d -= r107.f274431h;
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L8:
        if (this.f274375e == false) goto L10;
        this.f274381k.f274414a = (this.f274392v.getWidth() - r100.f274408c) - this.f274383m.getStartAfterPadding();
        goto L11
    L4:
        this.f274381k.f274415b = false;
        goto L6
    }

    @Override // com.google.android.flexbox.a
    public final int i(View r100, int r101, int r102) {
        if (o() == false) goto L5;
        int r103 = getLeftDecorationWidth(r100);
        int r104 = getRightDecorationWidth(r100);
    L7:
        return r103 + r104;
    L5:
        r103 = getTopDecorationHeight(r100);
        r104 = getBottomDecorationHeight(r100);
        goto L7
    }

    @Override // com.google.android.flexbox.a
    public final int k(int r100, int r101, int r102) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), r101, r102, canScrollVertically());
    }

    @Override // com.google.android.flexbox.a
    public final int m(int r100, int r101, int r102) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), r101, r102, canScrollHorizontally());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView r100, int r101, int r102) {
        super.onItemsAdded(r100, r101, r102);
        E(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView r100, int r101, int r102) {
        super.onItemsRemoved(r100, r101, r102);
        E(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsUpdated(RecyclerView r100, int r101, int r102) {
        super.onItemsUpdated(r100, r101, r102);
        E(r101);
    }

    public final int q(RecyclerView.Recycler r310, RecyclerView.State r311, b r312) {
        int r100 = r312.f274419f;
        if (r100 == Integer.MIN_VALUE) goto L8;
        int r101 = r312.f274414a;
        if (r101 >= 0) goto L7;
        r312.f274419f = r100 + r101;
    L7:
        z(r310, r312);
    L8:
        int r102 = r312.f274414a;
        boolean r103 = o();
        int r104 = r102;
        int r105 = 0;
    L9:
        if (r104 <= 0) goto L11;
    L12:
        List<com.google.android.flexbox.b> r106 = this.f274377g;
        int r110 = r312.f274417d;
        if (r110 >= 0) goto L15;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == false) goto L85;
        com.google.android.flexbox.b r108 = (com.google.android.flexbox.b) ListProtector.get(this.f274377g, r312.f274416c);
        r312.f274417d = r108.f274438o;
        if (o() == false) goto L48;
        int r111 = getPaddingLeft();
        int r112 = getPaddingRight();
        int r113 = getWidth();
        int r109 = r312.f274418e;
        if (r312.f274422i != (-1)) goto L28;
        r109 = r109 - r108.f274430g;
    L28:
        int r114 = r312.f274417d;
        float r115 = r113 - r112;
        float r116 = this.f274382l.f274409d;
        float r117 = r111 - r116;
        float r118 = r115 - r116;
        float r119 = Math.max(0.0f, 0.0f);
        int r120 = r108.f274431h;
        int r121 = r114;
        int r122 = 0;
    L30:
        if (r121 >= (r114 + r120)) goto L47;
        View r123 = d(r121);
        if (r123 != null) goto L35;
        r121 = r121;
    L46:
        r121 = r121 + 1;
        r114 = r114;
        r102 = r102;
        r120 = r120;
        goto L30
    L35:
        if (r312.f274422i != 1) goto L37;
        calculateItemDecorationsForChild(r123, f274370y);
        addView(r123);
    L38:
        int r124 = r122;
        long r125 = this.f274378h.f274445d[r121];
        int r126 = (int) r125;
        int r127 = (int) (r125 >> 32);
        LayoutParams r128 = (LayoutParams) r123.getLayoutParams();
        if (shouldMeasureChild(r123, r126, r127, r128) == false) goto L41;
        r123.measure(r126, r127);
    L41:
        float r129 = r117 + (((ViewGroup.MarginLayoutParams) r128).leftMargin + getLeftDecorationWidth(r123));
        float r130 = r118 - (((ViewGroup.MarginLayoutParams) r128).rightMargin + getRightDecorationWidth(r123));
        int r131 = r109 + getTopDecorationHeight(r123);
        if (this.f274375e == false) goto L44;
        this.f274378h.o(r123, r108, Math.round(r130) - r123.getMeasuredWidth(), r131, Math.round(r130), r131 + r123.getMeasuredHeight());
    L45:
        r117 = r129 + (((r123.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r128).rightMargin) + getRightDecorationWidth(r123)) + r119);
        r118 = r130 - (((r123.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r128).leftMargin) + getLeftDecorationWidth(r123)) + r119);
        r122 = r124;
        goto L46
    L44:
        this.f274378h.o(r123, r108, Math.round(r129), r131, Math.round(r129) + r123.getMeasuredWidth(), r131 + r123.getMeasuredHeight());
        goto L45
    L37:
        calculateItemDecorationsForChild(r123, f274370y);
        addView(r123, r122);
        r122 = r122 + 1;
        goto L38
    L47:
        int r210 = r102;
        r312.f274416c += this.f274381k.f274422i;
        int r132 = r108.f274430g;
        int r211 = r104;
        int r212 = r105;
    L78:
        r105 = r212 + r132;
        if (r103 == false) goto L81;
    L83:
        r312.f274418e += r108.f274430g * r312.f274422i;
    L84:
        r104 = r211 - r108.f274430g;
        r102 = r210;
        goto L9
    L81:
        if (this.f274375e == false) goto L83;
        r312.f274418e -= r108.f274430g * r312.f274422i;
        goto L84
    L48:
        r210 = r102;
        int r133 = getPaddingTop();
        int r134 = getPaddingBottom();
        int r135 = getHeight();
        int r136 = r312.f274418e;
        if (r312.f274422i != (-1)) goto L51;
        int r137 = r108.f274430g;
        int r138 = r136 - r137;
        int r139 = r136 + r137;
        r136 = r138;
    L52:
        int r140 = r312.f274417d;
        float r141 = r135 - r134;
        float r142 = this.f274382l.f274409d;
        float r143 = r133 - r142;
        float r144 = r141 - r142;
        float r145 = Math.max(0.0f, 0.0f);
        int r146 = r108.f274431h;
        int r147 = r140;
        int r148 = 0;
    L54:
        if (r147 >= (r140 + r146)) goto L77;
        View r149 = d(r147);
        if (r149 != null) goto L58;
        int r213 = r147;
        int r214 = r146;
        int r215 = r140;
    L76:
        r147 = r213 + 1;
        r146 = r214;
        r104 = r104;
        r105 = r105;
        r140 = r215;
        goto L54
    L58:
        int r150 = r146;
        long r151 = this.f274378h.f274445d[r147];
        int r152 = (int) r151;
        int r153 = (int) (r151 >> 32);
        LayoutParams r154 = (LayoutParams) r149.getLayoutParams();
        if (shouldMeasureChild(r149, r152, r153, r154) == false) goto L61;
        r149.measure(r152, r153);
    L61:
        float r155 = r143 + (((ViewGroup.MarginLayoutParams) r154).topMargin + getTopDecorationHeight(r149));
        float r156 = r144 - (((ViewGroup.MarginLayoutParams) r154).rightMargin + getBottomDecorationHeight(r149));
        if (r312.f274422i != 1) goto L64;
        calculateItemDecorationsForChild(r149, f274370y);
        addView(r149);
    L65:
        int r157 = r148;
        int r158 = r136 + getLeftDecorationWidth(r149);
        int r159 = r139 - getRightDecorationWidth(r149);
        boolean r160 = this.f274375e;
        if (r160 == true) goto L68;
        r213 = r147;
        r215 = r140;
        r214 = r150;
        if (this.f274376f == false) goto L74;
        this.f274378h.p(r149, r108, r160, r158, Math.round(r156) - r149.getMeasuredHeight(), r158 + r149.getMeasuredWidth(), Math.round(r156));
    L75:
        r143 = r155 + (((r149.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r154).topMargin) + getBottomDecorationHeight(r149)) + r145);
        r144 = r156 - (((r149.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r154).bottomMargin) + getTopDecorationHeight(r149)) + r145);
        r148 = r157;
        goto L76
    L74:
        this.f274378h.p(r149, r108, r160, r158, Math.round(r155), r158 + r149.getMeasuredWidth(), Math.round(r155) + r149.getMeasuredHeight());
        goto L75
    L68:
        if (this.f274376f == false) goto L70;
        r213 = r147;
        r214 = r150;
        r215 = r140;
        this.f274378h.p(r149, r108, r160, r159 - r149.getMeasuredWidth(), Math.round(r156) - r149.getMeasuredHeight(), r159, Math.round(r156));
        goto L75
    L70:
        r213 = r147;
        r215 = r140;
        r214 = r150;
        this.f274378h.p(r149, r108, r160, r159 - r149.getMeasuredWidth(), Math.round(r155), r159, Math.round(r155) + r149.getMeasuredHeight());
        goto L75
    L64:
        calculateItemDecorationsForChild(r149, f274370y);
        addView(r149, r148);
        r148 = r148 + 1;
        goto L65
    L77:
        r211 = r104;
        r212 = r105;
        r312.f274416c += this.f274381k.f274422i;
        r132 = r108.f274430g;
        goto L78
    L51:
        r139 = r136;
    L85:
        int r216 = r102;
        int r217 = r105;
        int r161 = r312.f274414a - r217;
        r312.f274414a = r161;
        int r162 = r312.f274419f;
        if (r162 == Integer.MIN_VALUE) goto L92;
        int r163 = r162 + r217;
        r312.f274419f = r163;
        if (r161 >= 0) goto L90;
        r312.f274419f = r163 + r161;
    L90:
        z(r310, r312);
    L92:
        return r216 - r312.f274414a;
    L15:
        if (r110 >= r311.getItemCount()) goto L21;
        int r164 = r312.f274416c;
        if (r164 < 0) goto L21;
        if (r164 >= r106.size()) goto L21;
        r107 = true;
        goto L22
    L11:
        if (this.f274381k.f274415b == false) goto L85;
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (o() == true) goto L5;
    L11:
        int r103 = x(r100, r101, r102);
        this.f274390t.clear();
        return r103;
    L5:
        if (this.f274372b == 0) goto L7;
    L9:
        int r104 = y(r100);
        this.f274382l.f274409d += r104;
        this.f274384n.offsetChildren(-r104);
        return r104;
    L7:
        if (o() == false) goto L9;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (o() == false) goto L5;
    L11:
        int r103 = x(r100, r101, r102);
        this.f274390t.clear();
        return r103;
    L5:
        if (this.f274372b == 0) goto L7;
    L9:
        int r104 = y(r100);
        this.f274382l.f274409d += r104;
        this.f274384n.offsetChildren(-r104);
        return r104;
    L7:
        if (o() == true) goto L9;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        LinearSmoothScroller r103 = new LinearSmoothScroller(r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }

    public final View v(int r110, int r111, boolean r112) {
        int r100 = r110;
        if (r111 <= r100) goto L5;
        int r101 = 1;
    L6:
        if (r100 == r111) goto L36;
        View r102 = getChildAt(r100);
        int r103 = getPaddingLeft();
        int r104 = getPaddingTop();
        int r105 = getWidth() - getPaddingRight();
        int r106 = getHeight() - getPaddingBottom();
        RecyclerView.LayoutParams r113 = (RecyclerView.LayoutParams) r102.getLayoutParams();
        int r114 = getDecoratedLeft(r102) - ((ViewGroup.MarginLayoutParams) r113).leftMargin;
        RecyclerView.LayoutParams r115 = (RecyclerView.LayoutParams) r102.getLayoutParams();
        int r116 = getDecoratedTop(r102) - ((ViewGroup.MarginLayoutParams) r115).topMargin;
        RecyclerView.LayoutParams r117 = (RecyclerView.LayoutParams) r102.getLayoutParams();
        int r118 = getDecoratedRight(r102) + ((ViewGroup.MarginLayoutParams) r117).rightMargin;
        RecyclerView.LayoutParams r119 = (RecyclerView.LayoutParams) r102.getLayoutParams();
        int r120 = getDecoratedBottom(r102) + ((ViewGroup.MarginLayoutParams) r119).bottomMargin;
        boolean r121 = false;
        if (r103 > r114) goto L11;
        if (r105 < r118) goto L11;
        boolean r122 = true;
    L12:
        if (r114 >= r105) goto L16;
        if (r118 >= r103) goto L16;
        boolean r107 = false;
    L17:
        if (r104 > r116) goto L20;
        if (r106 < r120) goto L20;
        boolean r108 = true;
    L21:
        if (r116 >= r106) goto L25;
        if (r120 >= r104) goto L25;
        boolean r109 = false;
    L26:
        if (r112 == false) goto L30;
        if (r122 == false) goto L33;
        if (r108 == false) goto L33;
    L29:
        r121 = true;
    L33:
        if (r121 == true) goto L34;
        r100 = r100 + r101;
        goto L6
    L34:
        return r102;
    L30:
        if (r107 == false) goto L33;
        if (r109 == false) goto L33;
    L25:
        r109 = true;
    L20:
        r108 = false;
    L16:
        r107 = true;
    L11:
        r122 = false;
        goto L12
    L36:
        return null;
    L5:
        r101 = -1;
        goto L6
    }

    public final View w(int r100, int r101, int r110) {
        p();
        if (this.f274381k != null) goto L5;
        this.f274381k = new b();
    L5:
        int r102 = this.f274383m.getStartAfterPadding();
        int r103 = this.f274383m.getEndAfterPadding();
        if (r101 <= r100) goto L8;
        int r104 = 1;
    L9:
        View r105 = null;
        View r106 = null;
    L10:
        if (r100 == r101) goto L27;
        View r107 = getChildAt(r100);
        int r108 = getPosition(r107);
        if (r108 < 0) goto L26;
        if (r108 >= r110) goto L26;
        if (((RecyclerView.LayoutParams) r107.getLayoutParams()).isItemRemoved() == false) goto L19;
        if (r106 != null) goto L26;
        r106 = r107;
        goto L26
    L19:
        if (this.f274383m.getDecoratedStart(r107) >= r102) goto L21;
    L24:
        if (r105 != null) goto L26;
        r105 = r107;
        goto L26
    L21:
        if (this.f274383m.getDecoratedEnd(r107) > r103) goto L24;
        return r107;
    L26:
        r100 = r100 + r104;
        goto L10
    L27:
        if (r105 == null) goto L30;
        return r105;
    L30:
        return r106;
    L8:
        r104 = -1;
        goto L9
    }

    public final int x(int r110, RecyclerView.Recycler r210, RecyclerView.State r211) {
        if (getChildCount() == 0) goto L78;
        if (r110 == 0) goto L78;
        p();
        this.f274381k.f274423j = true;
        if (o() == false) goto L9;
    L11:
        boolean r100 = false;
    L13:
        if (r100 == false) goto L16;
        if (r110 < 0) goto L17;
    L18:
        int r101 = -1;
    L19:
        int r102 = Math.abs(r110);
        this.f274381k.f274422i = r101;
        boolean r103 = o();
        int r104 = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int r105 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        if (r103 == false) goto L22;
    L24:
        boolean r111 = false;
    L25:
        if (r101 != 1) goto L49;
        View r112 = getChildAt(getChildCount() - 1);
        this.f274381k.f274418e = this.f274383m.getDecoratedEnd(r112);
        int r113 = getPosition(r112);
        View r114 = u(r112, (com.google.android.flexbox.b) ListProtector.get(this.f274377g, this.f274378h.f274444c[r113]));
        b r115 = this.f274381k;
        r115.f274421h = 1;
        int r116 = r113 + 1;
        r115.f274417d = r116;
        int[] r117 = this.f274378h.f274444c;
        if (r117.length > r116) goto L29;
        r115.f274416c = -1;
    L30:
        if (r111 == false) goto L36;
        r115.f274418e = this.f274383m.getDecoratedStart(r114);
        this.f274381k.f274419f = (-this.f274383m.getDecoratedStart(r114)) + this.f274383m.getStartAfterPadding();
        b r118 = this.f274381k;
        int r119 = r118.f274419f;
        if (r119 >= 0) goto L35;
        r119 = 0;
    L35:
        r118.f274419f = r119;
    L37:
        int r120 = this.f274381k.f274416c;
        if (r120 == (-1)) goto L42;
        if (r120 > (this.f274377g.size() - 1)) goto L42;
    L67:
        b r106 = this.f274381k;
        int r107 = r106.f274419f;
        r106.f274414a = r102 - r107;
        int r108 = r107 + q(r210, r211, r106);
        if (r108 >= 0) goto L70;
        return 0;
    L70:
        if (r100 == false) goto L73;
        if (r102 <= r108) goto L75;
        int r109 = (-r101) * r108;
    L76:
        this.f274383m.offsetChildren(-r109);
        this.f274381k.f274420g = r109;
        return r109;
    L75:
        r109 = r110;
        goto L76
    L73:
        if (r102 <= r108) goto L75;
        r109 = r101 * r108;
    L42:
        if (this.f274381k.f274417d > getFlexItemCount()) goto L67;
        b r121 = this.f274381k;
        int r122 = r102 - r121.f274419f;
        c.a r123 = this.f274394x;
        r123.f274447a = null;
        r123.f274448b = 0;
        if (r122 <= 0) goto L67;
        if (r103 == false) goto L47;
        this.f274378h.b(r123, r104, r105, r122, r121.f274417d, -1, this.f274377g);
    L48:
        this.f274378h.h(r104, r105, this.f274381k.f274417d);
        this.f274378h.u(this.f274381k.f274417d);
        goto L67
    L47:
        this.f274378h.b(r123, r105, r104, r122, r121.f274417d, -1, this.f274377g);
        goto L48
    L36:
        r115.f274418e = this.f274383m.getDecoratedEnd(r114);
        this.f274381k.f274419f = this.f274383m.getDecoratedEnd(r114) - this.f274383m.getEndAfterPadding();
        goto L37
    L29:
        r115.f274416c = r117[r116];
        goto L30
    L49:
        View r124 = getChildAt(0);
        this.f274381k.f274418e = this.f274383m.getDecoratedStart(r124);
        int r125 = getPosition(r124);
        View r126 = s(r124, (com.google.android.flexbox.b) ListProtector.get(this.f274377g, this.f274378h.f274444c[r125]));
        b r127 = this.f274381k;
        r127.f274421h = 1;
        int r128 = this.f274378h.f274444c[r125];
        if (r128 != (-1)) goto L52;
        r128 = 0;
    L52:
        if (r128 <= 0) goto L54;
        com.google.android.flexbox.b r129 = (com.google.android.flexbox.b) ListProtector.get(this.f274377g, r128 - 1);
        this.f274381k.f274417d = r125 - r129.f274431h;
    L55:
        b r130 = this.f274381k;
        if (r128 <= 0) goto L58;
        int r131 = r128 - 1;
    L59:
        r130.f274416c = r131;
        if (r111 == false) goto L66;
        r130.f274418e = this.f274383m.getDecoratedEnd(r126);
        this.f274381k.f274419f = this.f274383m.getDecoratedEnd(r126) - this.f274383m.getEndAfterPadding();
        b r132 = this.f274381k;
        int r133 = r132.f274419f;
        if (r133 >= 0) goto L65;
        r133 = 0;
    L65:
        r132.f274419f = r133;
        goto L67
    L66:
        r130.f274418e = this.f274383m.getDecoratedStart(r126);
        this.f274381k.f274419f = (-this.f274383m.getDecoratedStart(r126)) + this.f274383m.getStartAfterPadding();
        goto L67
    L58:
        r131 = 0;
        goto L59
    L54:
        r127.f274417d = -1;
        goto L55
    L22:
        if (this.f274375e == false) goto L24;
        r111 = true;
    L17:
        r101 = 1;
        goto L19
    L16:
        if (r110 <= 0) goto L18;
    L9:
        if (this.f274375e == false) goto L11;
        r100 = true;
    L78:
        return 0;
    }

    public FlexboxLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        this.f274374d = -1;
        this.f274377g = new ArrayList();
        this.f274378h = new c(this);
        this.f274382l = new a(this);
        this.f274386p = -1;
        this.f274387q = Integer.MIN_VALUE;
        this.f274388r = Integer.MIN_VALUE;
        this.f274389s = Integer.MIN_VALUE;
        this.f274390t = new SparseArray();
        this.f274393w = -1;
        this.f274394x = new c.a();
        RecyclerView.LayoutManager.Properties r104 = RecyclerView.LayoutManager.getProperties(r100, r101, r102, r103);
        int r105 = r104.orientation;
        if (r105 == 0) goto L11;
        if (r105 == 1) goto L7;
    L14:
        D(1);
        B(4);
        setAutoMeasureEnabled(true);
        this.f274391u = r100;
        return;
    L7:
        if (r104.reverseLayout == false) goto L9;
        C(3);
        goto L14
    L9:
        C(2);
        goto L14
    L11:
        if (r104.reverseLayout == false) goto L13;
        C(1);
        goto L14
    L13:
        C(0);
        goto L14
    }

    private boolean shouldMeasureChild(View r100, int r101, int r102, RecyclerView.LayoutParams r103) {
        if (r100.isLayoutRequested() == false) goto L5;
    L12:
        return true;
    L5:
        if (isMeasurementCacheEnabled() == false) goto L12;
        if (isMeasurementUpToDate(r100.getWidth(), r101, ((ViewGroup.MarginLayoutParams) r103).width) == false) goto L12;
        if (isMeasurementUpToDate(r100.getHeight(), r102, ((ViewGroup.MarginLayoutParams) r103).height) == false) goto L12;
        return false;
    }

    public final int fixLayoutEndGap(int r100, RecyclerView.Recycler r101, RecyclerView.State r102, boolean r103) {
        if (o() == false) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L13;
        int r105 = r100 - this.f274383m.getStartAfterPadding();
        if (r105 <= 0) goto L12;
        int r106 = x(r105, r101, r102);
    L16:
        int r107 = r100 + r106;
        if (r103 == false) goto L22;
        int r108 = this.f274383m.getEndAfterPadding() - r107;
        if (r108 <= 0) goto L22;
        this.f274383m.offsetChildren(r108);
        return r108 + r106;
    L22:
        return r106;
    L12:
        return 0;
    L13:
        int r109 = this.f274383m.getEndAfterPadding() - r100;
        if (r109 <= 0) goto L23;
        r106 = -x(-r109, r101, r102);
        goto L16
    L23:
        return 0;
    L5:
        if (this.f274375e == false) goto L7;
        r104 = true;
        goto L8
    }

    public final int fixLayoutStartGap(int r100, RecyclerView.Recycler r101, RecyclerView.State r102, boolean r103) {
        if (o() == false) goto L5;
    L10:
        int r104 = r100 - this.f274383m.getStartAfterPadding();
        if (r104 <= 0) goto L19;
        int r105 = -x(r104, r101, r102);
    L13:
        int r106 = r100 + r105;
        if (r103 == false) goto L20;
        int r107 = r106 - this.f274383m.getStartAfterPadding();
        if (r107 <= 0) goto L21;
        this.f274383m.offsetChildren(-r107);
        return r105 - r107;
    L21:
        return r105;
    L20:
        return r105;
    L19:
        return 0;
    L5:
        if (this.f274375e == false) goto L10;
        int r108 = this.f274383m.getEndAfterPadding() - r100;
        if (r108 <= 0) goto L9;
        r105 = x(-r108, r101, r102);
        goto L13
    L9:
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public final void j(View r100, int r101, int r102, com.google.android.flexbox.b r103) {
        calculateItemDecorationsForChild(r100, f274370y);
        if (o() == false) goto L5;
        int r104 = getLeftDecorationWidth(r100) + getRightDecorationWidth(r100);
        r103.f274428e += r104;
        r103.f274429f += r104;
        return;
    L5:
        int r105 = getTopDecorationHeight(r100) + getBottomDecorationHeight(r100);
        r103.f274428e += r105;
        r103.f274429f += r105;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsMoved(RecyclerView r100, int r101, int r102, int r103) {
        super.onItemsMoved(r100, r101, r102, r103);
        E(Math.min(r101, r102));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsUpdated(RecyclerView r100, int r101, int r102, Object r103) {
        super.onItemsUpdated(r100, r101, r102, r103);
        E(r101);
    }
}
