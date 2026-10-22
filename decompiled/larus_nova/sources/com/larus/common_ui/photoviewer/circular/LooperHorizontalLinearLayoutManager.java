package com.larus.common_ui.photoviewer.circular;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes27.dex */
public class LooperHorizontalLinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f327682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f327683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f327684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OrientationHelper f327685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f327686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f327687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f327688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SavedState f327689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f327690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f327691j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f327692k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f327693l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewBoundsCheck f327694m;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f327695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f327696b;

        public class a implements Parcelable.Creator<SavedState> {
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

        public SavedState() {
        }

        public SavedState(Parcel r100) {
            this.f327695a = r100.readInt();
            this.f327696b = r100.readInt();
        }

        public SavedState(SavedState r100) {
            this.f327695a = r100.f327695a;
            this.f327696b = r100.f327696b;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.f327695a);
            r100.writeInt(this.f327696b);
        }
    }

    public class a implements ViewBoundsCheck.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LooperHorizontalLinearLayoutManager f327697a;

        public a(LooperHorizontalLinearLayoutManager r100) {
            this.f327697a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrientationHelper f327698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f327699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f327700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f327701d;

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.f327699b + ", mCoordinate=" + this.f327700c + ", mValid=" + this.f327701d + '}';
        }

        public b() {
            this.f327699b = -1;
            this.f327700c = Integer.MIN_VALUE;
            this.f327701d = false;
        }

        public final void a(View r100, int r101) {
            int r102 = this.f327698a.getTotalSpaceChange();
            if (r102 < 0) goto L6;
            this.f327700c = this.f327698a.getDecoratedStart(r100);
            this.f327699b = r101;
            return;
        L6:
            this.f327699b = r101;
            int r103 = this.f327698a.getDecoratedStart(r100);
            int r104 = r103 - this.f327698a.getStartAfterPadding();
            this.f327700c = r103;
            if (r104 <= 0) goto L12;
            int r105 = (this.f327698a.getEndAfterPadding() - Math.min(0, (this.f327698a.getEndAfterPadding() - r102) - this.f327698a.getDecoratedEnd(r100))) - (r103 + this.f327698a.getDecoratedMeasurement(r100));
            if (r105 >= 0) goto L13;
            this.f327700c -= Math.min(r104, -r105);
            return;
        L13:
            return;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f327702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f327703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f327704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f327705d;

        public c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f327706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f327707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f327708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f327709d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f327710e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f327711f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f327712g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f327713h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f327714i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f327715j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f327716k;

        public d() {
            this.f327706a = true;
            this.f327713h = 0;
            this.f327714i = 0;
        }
    }

    public LooperHorizontalLinearLayoutManager() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    public final void ensureLayoutState() {
        if (this.f327684c != null) goto L6;
        this.f327684c = new d();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final Parcelable onSaveInstanceState() {
        if (this.f327689h != null) goto L5;
        SavedState r100 = new SavedState();
        if (getChildCount() <= 0) goto L9;
        ensureLayoutState();
        View r101 = getChildAt(0);
        r100.f327695a = getPosition(r101);
        r100.f327696b = this.f327685d.getDecoratedStart(r101) - this.f327685d.getStartAfterPadding();
    L10:
        return r100;
    L9:
        r100.f327695a = -1;
        goto L10
    L5:
        return new SavedState(this.f327689h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        if (this.f327689h != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void assertNotInLayoutOrScroll(String r100) {
        if (this.f327689h != null) goto L6;
        super.assertNotInLayoutOrScroll(r100);
        return;
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
        ensureLayoutState();
        OrientationHelper r101 = this.f327685d;
        View r102 = findOneVisibleChild(0, getChildCount(), !this.f327686e, true);
        View r103 = findOneVisibleChild(getChildCount() - 1, -1, !this.f327686e, true);
        boolean r104 = this.f327686e;
        if (getChildCount() != 0) goto L8;
        return 0;
    L8:
        if (r100.getItemCount() == 0) goto L17;
        if (r102 == null) goto L18;
        if (r103 == null) goto L20;
        if (r104 == true) goto L15;
        return Math.abs(getPosition(r102) - getPosition(r103)) + 1;
    L15:
        return Math.min(r101.getTotalSpace(), r101.getDecoratedEnd(r103) - r101.getDecoratedStart(r102));
    L20:
        return 0;
    L18:
        return 0;
    L17:
        return 0;
    }

    public final int computeScrollOffset(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        ensureLayoutState();
        OrientationHelper r101 = this.f327685d;
        View r102 = findOneVisibleChild(0, getChildCount(), !this.f327686e, true);
        View r103 = findOneVisibleChild(getChildCount() - 1, -1, !this.f327686e, true);
        boolean r104 = this.f327686e;
        if (getChildCount() != 0) goto L8;
        return 0;
    L8:
        if (r100.getItemCount() == 0) goto L18;
        if (r102 == null) goto L19;
        if (r103 == null) goto L20;
        int r105 = Math.min(getPosition(r102), getPosition(r103));
        Math.max(getPosition(r102), getPosition(r103));
        int r106 = Math.max(0, r105);
        if (r104 == true) goto L16;
        return r106;
    L16:
        return Math.round((r106 * (Math.abs(r101.getDecoratedEnd(r103) - r101.getDecoratedStart(r102)) / (Math.abs(getPosition(r102) - getPosition(r103)) + 1))) + (r101.getStartAfterPadding() - r101.getDecoratedStart(r102)));
    L20:
        return 0;
    L19:
        return 0;
    L18:
        return 0;
    }

    public final int computeScrollRange(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        ensureLayoutState();
        OrientationHelper r101 = this.f327685d;
        View r102 = findOneVisibleChild(0, getChildCount(), !this.f327686e, true);
        View r103 = findOneVisibleChild(getChildCount() - 1, -1, !this.f327686e, true);
        boolean r104 = this.f327686e;
        if (getChildCount() != 0) goto L8;
        return 0;
    L8:
        if (r100.getItemCount() == 0) goto L17;
        if (r102 == null) goto L18;
        if (r103 == null) goto L20;
        if (r104 == true) goto L15;
        return r100.getItemCount();
    L15:
        return (int) (((r101.getDecoratedEnd(r103) - r101.getDecoratedStart(r102)) / (Math.abs(getPosition(r102) - getPosition(r103)) + 1)) * r100.getItemCount());
    L20:
        return 0;
    L18:
        return 0;
    L17:
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
        if (this.f327683b != 0) goto L15;
        return new PointF(r101, 0.0f);
    L15:
        return new PointF(0.0f, r101);
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

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final View findViewByPosition(int r100) {
        int r101 = getChildCount();
        if (r101 != 0) goto L6;
        return null;
    L6:
        int r102 = r100 - getPosition(getChildAt(0));
        if (r102 < 0) goto L13;
        if (r102 >= r101) goto L13;
        View r103 = getChildAt(r102);
        if (getPosition(r103) != r100) goto L13;
        return r103;
    L13:
        return super.findViewByPosition(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        super.onInitializeAccessibilityEvent(r100);
        if (getChildCount() <= 0) goto L14;
        View r101 = findOneVisibleChild(0, getChildCount(), false, true);
        int r102 = -1;
        if (r101 != null) goto L7;
        int r103 = -1;
    L8:
        r100.setFromIndex(r103);
        View r104 = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (r104 == null) goto L12;
        r102 = getPosition(r104);
    L12:
        r100.setToIndex(r102);
        return;
    L7:
        r103 = getPosition(r101);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        this.f327689h = null;
        this.f327687f = -1;
        this.f327688g = Integer.MIN_VALUE;
        b r101 = this.f327690i;
        r101.f327699b = -1;
        r101.f327700c = Integer.MIN_VALUE;
        r101.f327701d = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == false) goto L9;
        SavedState r101 = (SavedState) r100;
        this.f327689h = r101;
        if (this.f327687f == (-1)) goto L7;
        r101.f327695a = -1;
    L7:
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        this.f327687f = r100;
        this.f327688g = Integer.MIN_VALUE;
        SavedState r101 = this.f327689h;
        if (r101 == null) goto L5;
        r101.f327695a = -1;
    L5:
        requestLayout();
    }

    public final void calculateExtraLayoutSpace(RecyclerView.State r100, int[] r101) {
        if (r100.hasTargetScrollPosition() == false) goto L5;
        int r102 = this.f327685d.getTotalSpace();
    L7:
        if (this.f327684c.f327711f != (-1)) goto L9;
        int r103 = 0;
    L10:
        r101[0] = r102;
        r101[1] = r103;
        return;
    L9:
        r103 = r102;
        r102 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void collectInitialPrefetchPositions(int r100, RecyclerView.LayoutManager.LayoutPrefetchRegistry r101) {
        SavedState r102 = this.f327689h;
        if (r102 == null) goto L10;
        int r103 = r102.f327695a;
        if (r103 < 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
    L13:
        int r105 = 0;
    L15:
        if (r105 >= this.f327692k) goto L24;
        if (r103 < 0) goto L19;
        if (r103 >= r100) goto L23;
        r101.addPosition(r103, 0);
        r103 = r103 + 1;
        r105 = r105 + 1;
        goto L15
    L23:
        return;
    L19:
        return;
    L24:
        return;
    L7:
        r104 = false;
    L10:
        r103 = this.f327687f;
        if (r103 != (-1)) goto L13;
        r103 = 0;
        goto L13
    }

    public final View findOnePartiallyOrCompletelyInvisibleChild(int r100, int r101) {
        ensureLayoutState();
        if (r101 <= r100) goto L5;
        byte r102 = 1;
    L8:
        if (r102 != 0) goto L12;
        return getChildAt(r100);
    L12:
        if (this.f327685d.getDecoratedStart(getChildAt(r100)) >= this.f327685d.getStartAfterPadding()) goto L14;
        int r103 = 16644;
        int r104 = 16388;
    L16:
        return this.f327694m.a(r100, r101, r103, r104);
    L14:
        r103 = 4161;
        r104 = 4097;
        goto L16
    L5:
        if (r101 >= r100) goto L7;
        r102 = -1;
        goto L8
    L7:
        r102 = 0;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        super.onDetachedFromWindow(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r110, RecyclerView.State r111) {
        if (this.f327689h != null) goto L7;
        if (this.f327687f != (-1)) goto L7;
    L10:
        SavedState r100 = this.f327689h;
        if (r100 == null) goto L18;
        int r101 = r100.f327695a;
        if (r101 < 0) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L18;
        this.f327687f = r101;
        goto L18
    L15:
        r102 = false;
    L18:
        ensureLayoutState();
        this.f327684c.f327706a = false;
        View r103 = getFocusedChild();
        b r104 = this.f327690i;
        if (r104.f327701d == true) goto L21;
    L32:
        r104.f327699b = -1;
        r104.f327700c = Integer.MIN_VALUE;
        r104.f327701d = false;
        if (r111.isPreLayout() == true) goto L70;
        int r105 = this.f327687f;
        if (r105 == (-1)) goto L70;
        if (r105 >= 0) goto L39;
    L69:
        this.f327687f = -1;
        this.f327688g = Integer.MIN_VALUE;
        goto L70
    L39:
        if (r105 >= r111.getItemCount()) goto L69;
        int r106 = this.f327687f;
        r104.f327699b = r106;
        SavedState r107 = this.f327689h;
        if (r107 == null) goto L50;
        if (r107.f327695a < 0) goto L46;
        boolean r108 = true;
    L47:
        if (r108 == false) goto L50;
        r104.f327700c = this.f327685d.getStartAfterPadding() + this.f327689h.f327696b;
    L68:
        boolean r109 = true;
    L71:
        if (r109 == false) goto L74;
    L140:
        char r112 = 1;
        this.f327690i.f327701d = true;
    L141:
        d r113 = this.f327684c;
        if (r113.f327715j < 0) goto L144;
        int r114 = 1;
    L145:
        r113.f327711f = r114;
        int[] r115 = this.f327693l;
        r115[0] = 0;
        r115[r112] = 0;
        calculateExtraLayoutSpace(r111, r115);
        int r116 = Math.max(0, this.f327693l[0]) + this.f327685d.getStartAfterPadding();
        int r117 = Math.max(0, this.f327693l[r112]) + this.f327685d.getEndPadding();
        if (r111.isPreLayout() == false) goto L157;
        int r118 = this.f327687f;
        if (r118 == (-1)) goto L157;
        if (this.f327688g == Integer.MIN_VALUE) goto L157;
        View r119 = findViewByPosition(r118);
        if (r119 == null) goto L157;
        int r120 = this.f327688g - (this.f327685d.getDecoratedStart(r119) - this.f327685d.getStartAfterPadding());
        if (r120 <= 0) goto L156;
        r116 = r116 + r120;
        goto L157
    L156:
        r117 = r117 - r120;
    L157:
        detachAndScrapAttachedViews(r110);
        d r121 = this.f327684c;
        if (this.f327685d.getMode() == 0) goto L160;
    L162:
        boolean r122 = false;
    L163:
        r121.f327716k = r122;
        d r123 = this.f327684c;
        r111.isPreLayout();
        r123.getClass();
        d r124 = this.f327684c;
        r124.f327714i = 0;
        b r125 = this.f327690i;
        int r126 = r125.f327699b;
        int r127 = r125.f327700c;
        r124.f327708c = this.f327685d.getEndAfterPadding() - r127;
        d r128 = this.f327684c;
        r128.f327710e = 1;
        r128.f327709d = r126;
        r128.f327711f = 1;
        r128.f327707b = r127;
        r128.f327712g = Integer.MIN_VALUE;
        r128.f327713h = r117;
        p(r110, r128, r111, false);
        d r129 = this.f327684c;
        int r130 = r129.f327707b;
        int r131 = r129.f327709d;
        int r132 = r129.f327708c;
        if (r132 <= 0) goto L166;
        r116 = r116 + r132;
    L166:
        b r133 = this.f327690i;
        int r134 = r133.f327699b;
        int r135 = r133.f327700c;
        r129.f327708c = r135 - this.f327685d.getStartAfterPadding();
        d r136 = this.f327684c;
        r136.f327710e = -1;
        r136.f327711f = -1;
        r136.f327707b = r135;
        r136.f327712g = Integer.MIN_VALUE;
        r136.f327713h = r116;
        r136.f327709d = r134 - 1;
        p(r110, r136, r111, false);
        d r137 = this.f327684c;
        int r138 = r137.f327707b;
        int r139 = r137.f327708c;
        if (r139 <= 0) goto L170;
        r137.f327708c = this.f327685d.getEndAfterPadding() - r130;
        d r140 = this.f327684c;
        r140.f327710e = 1;
        r140.f327709d = r131;
        r140.f327711f = 1;
        r140.f327707b = r130;
        r140.f327712g = Integer.MIN_VALUE;
        r140.f327713h = r139;
        p(r110, r140, r111, false);
        r130 = this.f327684c.f327707b;
    L170:
        if (getChildCount() <= 0) goto L181;
        int r141 = r138 - this.f327685d.getStartAfterPadding();
        if (r141 <= 0) goto L176;
        int r142 = -scrollBy(r141, r110, r111);
        int r143 = (r138 + r142) - this.f327685d.getStartAfterPadding();
        if (r143 <= 0) goto L177;
        this.f327685d.offsetChildren(-r143);
        r142 = r142 - r143;
    L177:
        int r144 = this.f327685d.getEndAfterPadding() - (r130 + r142);
        if (r144 <= 0) goto L181;
        scrollBy(-r144, r110, r111);
        goto L181
    L176:
        r142 = 0;
    L181:
        if (r111.isPreLayout() == true) goto L183;
        this.f327685d.onLayoutComplete();
        return;
    L183:
        b r145 = this.f327690i;
        r145.f327699b = -1;
        r145.f327700c = Integer.MIN_VALUE;
        r145.f327701d = false;
        return;
    L160:
        if (this.f327685d.getEnd() != 0) goto L162;
        r122 = true;
        goto L163
    L144:
        r114 = -1;
        goto L145
    L74:
        if (getChildCount() == 0) goto L136;
        View r146 = getFocusedChild();
        if (r146 == null) goto L88;
        r104.getClass();
        RecyclerView.LayoutParams r147 = (RecyclerView.LayoutParams) r146.getLayoutParams();
        if (r147.isItemRemoved() == false) goto L81;
    L85:
        boolean r148 = false;
    L86:
        if (r148 == false) goto L88;
        r104.a(r146, getPosition(r146));
    L135:
        boolean r149 = true;
    L137:
        if (r149 == true) goto L140;
        r104.f327700c = r104.f327698a.getStartAfterPadding();
        r104.f327699b = 0;
        goto L140
    L81:
        if (r147.getViewLayoutPosition() < 0) goto L85;
        if (r147.getViewLayoutPosition() >= r111.getItemCount()) goto L85;
        r148 = true;
    L88:
        ensureLayoutState();
        int r150 = getChildCount();
        int r151 = r111.getItemCount();
        int r152 = this.f327685d.getStartAfterPadding();
        int r153 = this.f327685d.getEndAfterPadding();
        View r154 = null;
        View r155 = null;
        View r156 = null;
        int r157 = 0;
    L89:
        if (r157 == r150) goto L112;
        View r158 = getChildAt(r157);
        int r159 = getPosition(r158);
        int r160 = this.f327685d.getDecoratedStart(r158);
        int r161 = this.f327685d.getDecoratedEnd(r158);
        if (r159 < 0) goto L111;
        if (r159 >= r151) goto L111;
        if (((RecyclerView.LayoutParams) r158.getLayoutParams()).isItemRemoved() == false) goto L97;
        if (r156 != null) goto L111;
        r156 = r158;
        goto L111
    L97:
        if (r161 > r152) goto L100;
        if (r160 >= r152) goto L100;
        boolean r162 = true;
    L101:
        if (r160 < r153) goto L104;
        if (r161 <= r153) goto L104;
        boolean r163 = true;
    L105:
        if (r162 == true) goto L107;
        if (r163 == true) goto L107;
    L118:
        if (r158 == null) goto L136;
        int r164 = getPosition(r158);
        r104.f327700c = r104.f327698a.getDecoratedStart(r158);
        r104.f327699b = r164;
        if (r111.isPreLayout() == true) goto L135;
        if (supportsPredictiveItemAnimations() == false) goto L135;
        int r165 = this.f327685d.getDecoratedStart(r158);
        int r166 = this.f327685d.getDecoratedEnd(r158);
        int r167 = this.f327685d.getStartAfterPadding();
        int r168 = this.f327685d.getEndAfterPadding();
        if (r166 > r167) goto L127;
        if (r165 >= r167) goto L127;
        boolean r169 = true;
    L128:
        if (r165 < r168) goto L131;
        if (r166 <= r168) goto L131;
        boolean r170 = true;
    L132:
        if (r169 == true) goto L134;
        if (r170 == false) goto L135;
    L134:
        r104.f327700c = r167;
    L131:
        r170 = false;
    L127:
        r169 = false;
    L107:
        if (r162 == false) goto L109;
        r155 = r158;
        goto L111
    L109:
        if (r154 != null) goto L111;
        r154 = r158;
    L104:
        r163 = false;
    L100:
        r162 = false;
    L111:
        r157 = r157 + 1;
        goto L89
    L112:
        if (r154 != null) goto L117;
        if (r155 == null) goto L116;
        r154 = r155;
        goto L117
    L116:
        r154 = r156;
    L117:
        r158 = r154;
    L136:
        r149 = false;
        goto L137
    L46:
        r108 = false;
    L50:
        if (this.f327688g != Integer.MIN_VALUE) goto L67;
        View r171 = findViewByPosition(r106);
        if (r171 == null) goto L64;
        if (this.f327685d.getDecoratedMeasurement(r171) <= this.f327685d.getTotalSpace()) goto L57;
        r104.f327700c = r104.f327698a.getStartAfterPadding();
        goto L68
    L57:
        if ((this.f327685d.getDecoratedStart(r171) - this.f327685d.getStartAfterPadding()) >= 0) goto L60;
        r104.f327700c = this.f327685d.getStartAfterPadding();
        goto L68
    L60:
        if ((this.f327685d.getEndAfterPadding() - this.f327685d.getDecoratedEnd(r171)) >= 0) goto L62;
        r104.f327700c = this.f327685d.getEndAfterPadding();
        goto L68
    L62:
        r104.f327700c = this.f327685d.getDecoratedStart(r171);
        goto L68
    L64:
        if (getChildCount() <= 0) goto L66;
        getPosition(getChildAt(0));
    L66:
        r104.f327700c = r104.f327698a.getStartAfterPadding();
        goto L68
    L67:
        r104.f327700c = this.f327685d.getStartAfterPadding() + this.f327688g;
    L70:
        r109 = false;
        goto L71
    L21:
        if (this.f327687f != (-1)) goto L32;
        if (this.f327689h != null) goto L32;
        if (r103 != null) goto L27;
    L31:
        r112 = 1;
        goto L141
    L27:
        if (this.f327685d.getDecoratedStart(r103) < this.f327685d.getEndAfterPadding()) goto L29;
    L30:
        this.f327690i.a(r103, getPosition(r103));
        goto L31
    L29:
        if (this.f327685d.getDecoratedEnd(r103) > this.f327685d.getStartAfterPadding()) goto L31;
    L7:
        if (r111.getItemCount() != 0) goto L10;
        removeAndRecycleAllViews(r110);
    }

    public final void q(RecyclerView.Recycler r100, d r101) {
        if (r101.f327706a == true) goto L5;
        return;
    L5:
        if (r101.f327716k == true) goto L57;
        int r102 = r101.f327712g;
        int r103 = r101.f327714i;
        if (r101.f327711f != (-1)) goto L28;
        int r104 = getChildCount();
        if (r102 < 0) goto L58;
        int r105 = (this.f327685d.getEnd() - r102) + r103;
        int r106 = r104 - 1;
        int r107 = r106;
    L13:
        if (r107 < 0) goto L62;
        View r108 = getChildAt(r107);
        if (this.f327685d.getDecoratedStart(r108) < r105) goto L20;
        if (this.f327685d.getTransformedStartWithDecoration(r108) < r105) goto L20;
        r107 = r107 - 1;
    L20:
        if (r106 == r107) goto L59;
        if (r107 <= r106) goto L26;
        int r109 = r107 - 1;
    L24:
        if (r109 < r106) goto L63;
        removeAndRecycleViewAt(r109, r100);
        r109 = r109 - 1;
        goto L24
    L63:
        return;
    L26:
        if (r106 <= r107) goto L64;
        removeAndRecycleViewAt(r106, r100);
        r106 = r106 - 1;
        goto L26
    L64:
        return;
    L59:
        return;
    L62:
        return;
    L58:
        return;
    L28:
        if (r102 < 0) goto L60;
        int r110 = r102 - r103;
        int r111 = getChildCount();
        int r112 = 0;
        int r113 = 0;
    L31:
        if (r113 >= r111) goto L65;
        View r114 = getChildAt(r113);
        if (this.f327685d.getDecoratedEnd(r114) > r110) goto L38;
        if (this.f327685d.getTransformedEndWithDecoration(r114) > r110) goto L38;
        r113 = r113 + 1;
    L38:
        if (r113 == 0) goto L61;
        if (r113 <= 0) goto L44;
        int r115 = r113 - 1;
    L42:
        if (r115 < 0) goto L66;
        removeAndRecycleViewAt(r115, r100);
        r115 = r115 - 1;
        goto L42
    L66:
        return;
    L44:
        if (r112 <= r113) goto L67;
        removeAndRecycleViewAt(r112, r100);
        r112 = r112 - 1;
        goto L44
    L67:
        return;
    L61:
        return;
    L65:
        return;
    L60:
        return;
    }

    public final int scrollBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (getChildCount() == 0) goto L17;
        if (r100 == 0) goto L17;
        ensureLayoutState();
        this.f327684c.f327706a = true;
        if (r100 <= 0) goto L9;
        int r103 = 1;
    L10:
        int r104 = Math.abs(r100);
        updateLayoutState(r103, r104, true, r102);
        d r105 = this.f327684c;
        int r106 = r105.f327712g + p(r101, r105, r102, false);
        if (r106 >= 0) goto L13;
        return 0;
    L13:
        if (r104 <= r106) goto L15;
        r100 = r103 * r106;
    L15:
        this.f327685d.offsetChildren(-r100);
        this.f327684c.f327715j = r100;
        return r100;
    L9:
        r103 = -1;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return scrollBy(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        LinearSmoothScroller r103 = new LinearSmoothScroller(r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }

    public LooperHorizontalLinearLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        this.f327682a = true;
        this.f327683b = 0;
        this.f327686e = true;
        this.f327687f = -1;
        this.f327688g = Integer.MIN_VALUE;
        this.f327689h = null;
        b r104 = new b();
        this.f327690i = r104;
        this.f327691j = new c();
        this.f327692k = 2;
        this.f327693l = new int[2];
        this.f327694m = new ViewBoundsCheck(new a(this));
        int r105 = RecyclerView.LayoutManager.getProperties(r100, r101, r102, r103).orientation;
        assertNotInLayoutOrScroll(null);
        if (r105 == this.f327683b) goto L5;
    L6:
        OrientationHelper r106 = OrientationHelper.createOrientationHelper(this, r105);
        this.f327685d = r106;
        r104.f327698a = r106;
        this.f327683b = r105;
        requestLayout();
        return;
    L5:
        if (this.f327685d == null) goto L6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void collectAdjacentPrefetchPositions(int r100, int r101, RecyclerView.State r102, RecyclerView.LayoutManager.LayoutPrefetchRegistry r103) {
        if (getChildCount() == 0) goto L16;
        if (r100 == 0) goto L19;
        ensureLayoutState();
        if (r100 <= 0) goto L9;
        int r104 = 1;
    L10:
        updateLayoutState(r104, Math.abs(r100), true, r102);
        d r105 = this.f327684c;
        int r106 = r105.f327709d;
        if (r106 >= 0) goto L13;
        return;
    L13:
        if (r106 >= r102.getItemCount()) goto L18;
        r103.addPosition(r106, Math.max(0, r105.f327712g));
        return;
    L18:
        return;
    L9:
        r104 = -1;
        goto L10
    L19:
        return;
    }

    public final View findOneVisibleChild(int r100, int r101, boolean r102, boolean r103) {
        ensureLayoutState();
        if (r102 == false) goto L5;
        int r104 = 24579;
    L7:
        return this.f327694m.a(r100, r101, r104, 320);
    L5:
        r104 = 320;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final View onFocusSearchFailed(View r100, int r101, RecyclerView.Recycler r102, RecyclerView.State r103) {
        if (getChildCount() != 0) goto L6;
        return null;
    L6:
        if (r101 != 1) goto L8;
    L15:
        int r104 = -1;
    L16:
        if (r104 != Integer.MIN_VALUE) goto L18;
        return null;
    L18:
        ensureLayoutState();
        updateLayoutState(r104, (int) (this.f327685d.getTotalSpace() * 0.33333334f), false, r103);
        d r105 = this.f327684c;
        r105.f327712g = Integer.MIN_VALUE;
        r105.f327706a = false;
        p(r102, r105, r103, true);
        if (r104 != (-1)) goto L21;
        View r106 = findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    L22:
        if (r104 != (-1)) goto L24;
        View r107 = getChildAt(0);
    L26:
        if (r107.hasFocusable() == false) goto L30;
        if (r106 != null) goto L29;
        return null;
    L29:
        return r107;
    L30:
        return r106;
    L24:
        r107 = getChildAt(getChildCount() - 1);
        goto L26
    L21:
        r106 = findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
        goto L22
    L8:
        if (r101 != 2) goto L10;
    L14:
        r104 = 1;
        goto L16
    L10:
        if (r101 == 17) goto L15;
        if (r101 == 66) goto L14;
        r104 = Integer.MIN_VALUE;
        goto L16
    }

    public final int p(RecyclerView.Recycler r110, d r111, RecyclerView.State r112, boolean r210) {
        int r100 = r111.f327708c;
        int r101 = r111.f327712g;
        if (r101 == Integer.MIN_VALUE) goto L7;
        if (r100 >= 0) goto L6;
        r111.f327712g = r101 + r100;
    L6:
        q(r110, r111);
    L7:
        int r102 = r111.f327708c + r111.f327713h;
        c r113 = this.f327691j;
        int r114 = r102;
    L9:
        if (r111.f327716k == true) goto L11;
        if (r114 > 0) goto L11;
    L53:
        return r100 - r111.f327708c;
    L11:
        int r103 = r111.f327709d;
        if (r103 >= 0) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L53;
        r113.f327702a = 0;
        r113.f327703b = false;
        r113.f327704c = false;
        r113.f327705d = false;
        View r115 = r110.getViewForPosition(r111.f327709d);
        r111.f327709d += r111.f327710e;
        if (r115 != null) goto L21;
        r113.f327703b = true;
    L36:
        if (r113.f327703b == true) goto L53;
        r111.f327707b += r113.f327702a * r111.f327711f;
        if (r113.f327704c == true) goto L41;
    L42:
        int r105 = r111.f327708c;
        int r106 = r113.f327702a;
        r111.f327708c = r105 - r106;
        r114 = r114 - r106;
    L43:
        int r107 = r111.f327712g;
        if (r107 == Integer.MIN_VALUE) goto L49;
        int r108 = r107 + r113.f327702a;
        r111.f327712g = r108;
        int r109 = r111.f327708c;
        if (r109 >= 0) goto L48;
        r111.f327712g = r108 + r109;
    L48:
        q(r110, r111);
    L49:
        if (r210 == false) goto L9;
        if (r113.f327705d == false) goto L9;
    L41:
        if (r112.isPreLayout() == true) goto L43;
    L21:
        RecyclerView.LayoutParams r116 = (RecyclerView.LayoutParams) r115.getLayoutParams();
        if (r111.f327711f == (-1)) goto L24;
        addView(r115);
    L25:
        measureChildWithMargins(r115, 0, 0);
        r113.f327702a = this.f327685d.getDecoratedMeasurement(r115);
        int r117 = getPaddingTop();
        int r118 = r117 + this.f327685d.getDecoratedMeasurementInOther(r115);
        if (r111.f327711f != (-1)) goto L28;
        int r119 = r111.f327707b;
        int r120 = r119;
        int r121 = r119 - r113.f327702a;
    L29:
        layoutDecoratedWithMargins(r115, r121, r117, r120, r118);
        if (r116.isItemRemoved() == false) goto L32;
    L33:
        r113.f327704c = true;
    L34:
        r113.f327705d = r115.hasFocusable();
        goto L36
    L32:
        if (r116.isItemChanged() == false) goto L34;
    L28:
        int r122 = r111.f327707b;
        r121 = r122;
        r120 = r113.f327702a + r122;
        goto L29
    L24:
        addView(r115, 0);
        goto L25
    L14:
        if (r103 >= r112.getItemCount()) goto L16;
        r104 = true;
        goto L17
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public final void prepareForDrop(View r100, View r101, int r102, int r103) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        int r104 = getPosition(r100);
        int r105 = getPosition(r101);
        if (r104 >= r105) goto L5;
        byte r106 = 1;
    L6:
        if (r106 != (-1)) goto L11;
        int r107 = this.f327685d.getDecoratedStart(r101);
        this.f327687f = r105;
        this.f327688g = r107;
        SavedState r108 = this.f327689h;
        if (r108 == null) goto L10;
        r108.f327695a = -1;
    L10:
        requestLayout();
        return;
    L11:
        int r109 = this.f327685d.getDecoratedEnd(r101) - this.f327685d.getDecoratedMeasurement(r100);
        this.f327687f = r105;
        this.f327688g = r109;
        SavedState r110 = this.f327689h;
        if (r110 == null) goto L14;
        r110.f327695a = -1;
    L14:
        requestLayout();
        return;
    L5:
        r106 = -1;
        goto L6
    }

    public final void updateLayoutState(int r100, int r101, boolean r102, RecyclerView.State r103) {
        d r104 = this.f327684c;
        if (this.f327685d.getMode() == 0) goto L5;
    L7:
        boolean r105 = false;
    L8:
        r104.f327716k = r105;
        this.f327684c.f327711f = r100;
        int[] r106 = this.f327693l;
        r106[0] = 0;
        r106[1] = 0;
        calculateExtraLayoutSpace(r103, r106);
        int r107 = Math.max(0, this.f327693l[0]);
        int r108 = Math.max(0, this.f327693l[1]);
        if (r100 != 1) goto L11;
        boolean r109 = true;
    L12:
        d r110 = this.f327684c;
        if (r109 == false) goto L15;
        int r111 = r108;
    L16:
        r110.f327713h = r111;
        if (r109 == true) goto L20;
        r107 = r108;
    L20:
        r110.f327714i = r107;
        if (r109 == false) goto L30;
        r110.f327713h = r111 + this.f327685d.getEndPadding();
        View r112 = getChildAt(getChildCount() - 1);
        d r113 = this.f327684c;
        r113.f327710e = 1;
        if (this.f327682a == true) goto L25;
        r113.f327709d = getPosition(r112) + this.f327684c.f327710e;
    L29:
        this.f327684c.f327707b = this.f327685d.getDecoratedEnd(r112);
        int r114 = this.f327685d.getDecoratedEnd(r112) - this.f327685d.getEndAfterPadding();
    L38:
        d r115 = this.f327684c;
        r115.f327708c = r101;
        if (r102 == false) goto L41;
        r115.f327708c = r101 - r114;
    L41:
        r115.f327712g = r114;
        return;
    L25:
        if (getPosition(r112) != (getItemCount() - 1)) goto L27;
        this.f327684c.f327709d = 0;
        goto L29
    L27:
        this.f327684c.f327709d = getPosition(r112) + this.f327684c.f327710e;
        goto L29
    L30:
        View r116 = getChildAt(0);
        this.f327684c.f327713h += this.f327685d.getStartAfterPadding();
        d r117 = this.f327684c;
        r117.f327710e = -1;
        if (this.f327682a == true) goto L33;
        r117.f327709d = getPosition(r116) + this.f327684c.f327710e;
    L37:
        this.f327684c.f327707b = this.f327685d.getDecoratedStart(r116);
        r114 = (-this.f327685d.getDecoratedStart(r116)) + this.f327685d.getStartAfterPadding();
        goto L38
    L33:
        if (getPosition(r116) != 0) goto L35;
        this.f327684c.f327709d = getItemCount() - 1;
        goto L37
    L35:
        this.f327684c.f327709d = getPosition(r116) + this.f327684c.f327710e;
        goto L37
    L15:
        r111 = r107;
        goto L16
    L11:
        r109 = false;
        goto L12
    L5:
        if (this.f327685d.getEnd() != 0) goto L7;
        r105 = true;
        goto L8
    }
}
