package com.tonicartos.superslim;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes41.dex */
public class LayoutManager extends RecyclerView.LayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f461893a;

    public static final enum Direction extends Enum<Direction> {
        public static final Direction END = null;
        public static final Direction NONE = null;
        public static final Direction START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Direction[] f461894a = null;

        static {
            Direction r100 = new Direction(GXAnimation.STATE_START, 0);
            START = r100;
            Direction r101 = new Direction(GXAnimation.STATE_END, 1);
            END = r101;
            Direction r102 = new Direction(UserProfileEvent.POSITION_NONE, 2);
            NONE = r102;
            f461894a = new Direction[]{r100, r101, r102};
        }

        public static Direction[] values() {
            return (Direction[]) f461894a.clone();
        }

        public static Direction valueOf(String r100) {
            return (Direction) r27.a.a(Direction.class, r100);
        }

        public Direction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ int f461895j = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f461896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f461897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f461898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f461899d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f461900e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f461901f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f461902g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f461903h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f461904i;

        @Retention(RetentionPolicy.SOURCE)
        public @interface HeaderDisplayOptions {
        }

        public class InvalidFirstPositionException extends RuntimeException {
            final /* synthetic */ LayoutParams this$0;

            public InvalidFirstPositionException(LayoutParams r100) {
                this.this$0 = r100;
                super("Invalid section first position given.");
            }
        }

        public class MissingFirstPositionException extends RuntimeException {
            final /* synthetic */ LayoutParams this$0;

            public MissingFirstPositionException(LayoutParams r100) {
                this.this$0 = r100;
                super("Missing section first position.");
            }
        }

        public LayoutParams() {
            super(-2, -2);
            this.f461903h = 1;
            this.f461896a = false;
        }

        public final int a() {
            int r100 = this.f461904i;
            if (r100 == (-1)) goto L6;
            return r100;
        L6:
            throw new MissingFirstPositionException(this);
        }

        public final boolean c() {
            if ((this.f461897b & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean d() {
            if ((this.f461897b & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean e() {
            if ((this.f461897b & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean g() {
            if ((this.f461897b & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.f461903h = 1;
            b(r100);
        }

        public final void b(ViewGroup.LayoutParams r100) {
            if ((r100 instanceof LayoutParams) == false) goto L5;
            LayoutParams r101 = (LayoutParams) r100;
            this.f461896a = r101.f461896a;
            this.f461897b = r101.f461897b;
            this.f461904i = r101.f461904i;
            this.f461902g = r101.f461902g;
            this.f461903h = r101.f461903h;
            this.f461898c = r101.f461898c;
            this.f461899d = r101.f461899d;
            this.f461901f = r101.f461901f;
            this.f461900e = r101.f461900e;
            return;
        L5:
            this.f461896a = false;
            this.f461897b = 17;
            this.f461898c = -1;
            this.f461899d = -1;
            this.f461900e = true;
            this.f461901f = true;
            this.f461903h = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.f461903h = 1;
            b(r100);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f461903h = 1;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.slm_headerDisplay, R.attr.slm_isHeader, R.attr.slm_section_firstPosition, R.attr.slm_section_headerMarginEnd, R.attr.slm_section_headerMarginStart, R.attr.slm_section_sectionManager});
            boolean r103 = false;
            this.f461896a = r102.getBoolean(1, false);
            this.f461897b = r102.getInt(0, 17);
            this.f461904i = r102.getInt(2, -1);
            if (r102.getType(4) != 5) goto L5;
            boolean r104 = true;
        L6:
            if (r104 == false) goto L8;
            this.f461900e = false;
            this.f461899d = r102.getDimensionPixelSize(4, 0);
        L10:
            if (r102.getType(3) != 5) goto L12;
            boolean r105 = true;
        L13:
            if (r105 == false) goto L15;
            this.f461901f = false;
            this.f461898c = r102.getDimensionPixelSize(3, 0);
        L17:
            if (r102.getType(5) != 3) goto L19;
            r103 = true;
        L19:
            if (r103 == false) goto L24;
            String r106 = r102.getString(5);
            this.f461902g = r106;
            if (TextUtils.isEmpty(r106) == false) goto L23;
            this.f461903h = 1;
        L25:
            r102.recycle();
            return;
        L23:
            this.f461903h = -1;
            goto L25
        L24:
            this.f461903h = r102.getInt(5, 1);
            goto L25
        L15:
            this.f461901f = true;
            goto L17
        L12:
            r105 = false;
            goto L13
        L8:
            this.f461900e = true;
            goto L10
        L5:
            r104 = false;
            goto L6
        }
    }

    public class NotYetImplementedSlmException extends RuntimeException {
        final /* synthetic */ LayoutManager this$0;

        public NotYetImplementedSlmException(LayoutManager r100, int r101) {
            this.this$0 = r100;
            super("SLM not yet implemented " + r101 + ".");
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f461905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f461906b;

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

        public SavedState() {
        }

        public SavedState(Parcel r100) {
            this.f461905a = r100.readInt();
            this.f461906b = r100.readInt();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.f461905a);
            r100.writeInt(this.f461906b);
        }
    }

    public class UnknownSectionLayoutException extends RuntimeException {
        final /* synthetic */ LayoutManager this$0;

        public UnknownSectionLayoutException(LayoutManager r100, String r101) {
            this.this$0 = r100;
            super("No registered layout for id " + r101 + ".");
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f461907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f461908b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LayoutManager f461909c;

        /* JADX INFO: renamed from: com.tonicartos.superslim.LayoutManager$a$a, reason: collision with other inner class name */
        public class C5546a extends LinearSmoothScroller {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f461910a;

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final int getVerticalSnapPreference() {
                return -1;
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public final void onStop() {
                super.onStop();
                this.f461910a.f461909c.requestLayout();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public final PointF computeScrollVectorForPosition(int r100) {
                if (getChildCount() != 0) goto L5;
                return null;
            L5:
                LayoutManager r101 = this.f461910a.f461909c;
                View r102 = r101.getChildAt(0);
                r101.getPaddingStart();
                r101.getPaddingEnd();
                LayoutParams r103 = (LayoutParams) r102.getLayoutParams();
                if (r103.f461896a == false) goto L8;
                r101.getDecoratedMeasuredWidth(r102);
                r101.getDecoratedMeasuredHeight(r102);
            L8:
                r103.a();
                int r104 = r103.f461903h;
                if (r104 != (-1)) goto L11;
                throw null;
            L11:
                if (r104 != 1) goto L13;
                throw null;
            L13:
                if (r104 != 2) goto L16;
                throw null;
            L16:
                throw new NotYetImplementedSlmException(r101, r103.f461903h);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public final void onChildAttachedToWindow(View r100) {
                super.onChildAttachedToWindow(r100);
            }

            public C5546a(a r100, Context r101) {
                this.f461910a = r100;
                super(r101);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final int calculateDyToMakeVisible(View r110, int r111) {
                RecyclerView.LayoutManager r100 = getLayoutManager();
                if (r100.canScrollVertically() == true) goto L5;
                return 0;
            L5:
                RecyclerView.LayoutParams r101 = (RecyclerView.LayoutParams) r110.getLayoutParams();
                int r102 = r100.getDecoratedTop(r110) - ((ViewGroup.MarginLayoutParams) r101).topMargin;
                int r103 = r100.getDecoratedBottom(r110) + ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
                if (this.f461910a.f461909c.getPosition(r110) != 0) goto L8;
                int r104 = r100.getPaddingTop();
            L9:
                int r112 = calculateDtToFit(r102, r103, r104, r100.getHeight() - r100.getPaddingBottom(), r111);
                if (r112 != 0) goto L13;
                return 1;
            L13:
                return r112;
            L8:
                r104 = 0;
                goto L9
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            C5546a r100 = new C5546a(this, this.f461907a.getContext());     // Catch: Throwable -> L4
            r100.setTargetPosition(this.f461908b);     // Catch: Throwable -> L4
            this.f461909c.startSmoothScroll(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LayoutManager r100, RecyclerView r101, int r102) {
            this.f461909c = r100;
            this.f461907a = r101;
            this.f461908b = r102;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return true;
    }

    public final void q() {
        View r100 = getChildAt(0);
        getPaddingStart();
        getPaddingEnd();
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        if (r101.f461896a == false) goto L5;
        getDecoratedMeasuredWidth(r100);
        getDecoratedMeasuredHeight(r100);
        boolean r102 = r101.f461900e;
        boolean r103 = r101.f461901f;
    L5:
        r101.a();
        int r104 = r101.f461903h;
        if (r104 != (-1)) goto L8;
        throw null;
    L8:
        if (r104 != 1) goto L10;
        throw null;
    L10:
        if (r104 != 2) goto L13;
        throw null;
    L13:
        throw new NotYetImplementedSlmException(this, r101.f461903h);
    }

    public final View s() {
        View r100 = getChildAt(0);
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        int r102 = r101.a();
        if (r101.f461896a == true) goto L6;
        return r100;
    L6:
        if (1 >= getChildCount()) goto L10;
        View r103 = getChildAt(1);
        if (((LayoutParams) r103.getLayoutParams()).a() != r102) goto L10;
        return r103;
    L10:
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState();
        View r101 = t();
        if (r101 != null) goto L5;
        r100.f461905a = 0;
        r100.f461906b = 0;
    L6:
        return r100;
    L5:
        r100.f461905a = getPosition(r101);
        r100.f461906b = getDecoratedTop(r101);
        goto L6
    }

    public final View r() {
        if (getChildCount() == 1) goto L5;
        View r100 = getChildAt(getChildCount() - 1);
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        if (r101.f461896a == false) goto L12;
        View r102 = getChildAt(getChildCount() - 2);
        if (((LayoutParams) r102.getLayoutParams()).a() == r101.a()) goto L11;
        return r100;
    L11:
        return r102;
    L12:
        return r100;
    L5:
        return getChildAt(0);
    }

    public final View t() {
        if (getChildCount() != 0) goto L6;
        return null;
    L6:
        View r100 = getChildAt(0);
        int r101 = ((LayoutParams) r100.getLayoutParams()).a();
        View r102 = p(r101, 0, Direction.START);
        if (r102 != null) goto L9;
        return r100;
    L9:
        LayoutParams r103 = (LayoutParams) r102.getLayoutParams();
        if (r103.f461896a == true) goto L13;
        return r100;
    L13:
        if (r103.d() == false) goto L21;
        if (r103.e() == true) goto L21;
        if (getDecoratedBottom(r102) > getDecoratedTop(r100)) goto L19;
        return r102;
    L19:
        return r100;
    L21:
        if (getDecoratedTop(r100) >= getDecoratedTop(r102)) goto L24;
        return r100;
    L24:
        if ((r101 + 1) != getPosition(r100)) goto L26;
        return r102;
    L26:
        return r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollExtent(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        if (r100.getItemCount() != 0) goto L8;
        return 0;
    L8:
        return getChildCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L5;
    L9:
        return 0;
    L5:
        if (r100.getItemCount() == 0) goto L9;
        return getPosition(getChildAt(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollRange(RecyclerView.State r100) {
        return r100.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 == null) goto L7;
        int r101 = LayoutParams.f461895j;
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        LayoutParams r102 = new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L8:
        ((ViewGroup.MarginLayoutParams) r102).width = -1;
        ((ViewGroup.MarginLayoutParams) r102).height = -1;
        int r103 = r102.f461903h;
        if (r103 != (-1)) goto L11;
        throw null;
    L11:
        if (r103 != 1) goto L13;
        throw null;
    L13:
        if (r103 != 2) goto L16;
        throw null;
    L16:
        throw new NotYetImplementedSlmException(this, r102.f461903h);
    L6:
        r102 = new LayoutParams(r100);
        goto L8
    L7:
        r102 = new LayoutParams();
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getDecoratedBottom(View r100) {
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        return super.getDecoratedBottom(r100) + r101.bottomMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getDecoratedLeft(View r100) {
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        return super.getDecoratedLeft(r100) - r101.leftMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getDecoratedMeasuredHeight(View r100) {
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        return (super.getDecoratedMeasuredHeight(r100) + r101.topMargin) + r101.bottomMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getDecoratedMeasuredWidth(View r100) {
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        return (super.getDecoratedMeasuredWidth(r100) + r101.leftMargin) + r101.rightMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getDecoratedRight(View r100) {
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        return super.getDecoratedRight(r100) + r101.rightMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getDecoratedTop(View r100) {
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        return super.getDecoratedTop(r100) - r101.topMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView r100) {
        View r101 = t();
        if (r101 != null) goto L5;
        this.f461893a = -1;
        return;
    L5:
        this.f461893a = getPosition(r101);
        getDecoratedTop(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onRestoreInstanceState(Parcelable r100) {
        this.f461893a = ((SavedState) r100).f461905a;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int r100) {
        if (r100 >= 0) goto L4;
    L8:
        getItemCount();
        return;
    L4:
        if (getItemCount() <= r100) goto L8;
        this.f461893a = r100;
        requestLayout();
    }

    public final void v(View r100) {
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        int r102 = (getWidth() - getPaddingStart()) - getPaddingEnd();
        if (r101.e() == false) goto L5;
    L15:
        int r103 = 0;
    L16:
        measureChildWithMargins(r100, r103, 0);
        return;
    L5:
        if (r101.g() == false) goto L11;
        if (r101.f461900e == true) goto L11;
        int r104 = r101.f461899d;
    L9:
        r103 = r102 - r104;
    L11:
        if (r101.c() == false) goto L15;
        if (r101.f461901f == true) goto L15;
        r104 = r101.f461898c;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.slm_headerDisplay, R.attr.slm_isHeader, R.attr.slm_section_firstPosition, R.attr.slm_section_headerMarginEnd, R.attr.slm_section_headerMarginStart, R.attr.slm_section_sectionManager});
        if (r102.getType(5) != 3) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == true) goto L9;
        int r104 = r102.getInt(5, 1);
    L13:
        r102.recycle();
        if (r104 == (-1)) goto L22;
        if (r104 != 1) goto L17;
        throw null;
    L17:
        if (r104 != 2) goto L20;
        throw null;
    L20:
        throw new NotYetImplementedSlmException(this, r104);
    L22:
        throw null;
    L9:
        if (TextUtils.isEmpty(r102.getString(5)) == false) goto L11;
        r104 = 1;
        goto L13
    L11:
        r104 = -1;
        goto L13
    L5:
        r103 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter r100, RecyclerView.Adapter r101) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        int r102 = r101.getItemCount();
        if (r102 != 0) goto L6;
        detachAndScrapAttachedViews(r100);
        return;
    L6:
        int r103 = this.f461893a;
        boolean r104 = false;
        if (r103 != (-1)) goto L22;
        View r105 = t();
        if (r105 != null) goto L11;
        int r106 = 0;
    L12:
        Direction r107 = Direction.END;
        if (r105 != null) goto L19;
        if (r107 != Direction.START) goto L17;
        getPaddingBottom();
    L23:
        detachAndScrapAttachedViews(r100);
        SparseArray r108 = new SparseArray(getChildCount());
        getLayoutDirection();
        getHeight();
        View r109 = (View) r108.get(r106);
        if (r109 == null) goto L26;
        boolean r110 = true;
    L27:
        if (r109 != null) goto L29;
        r109 = r100.getViewForPosition(r106);
    L29:
        com.tonicartos.superslim.a.C5547a r111 = new com.tonicartos.superslim.a.C5547a(r109, r110);
        r108.put(r106, r111.f461913a);
        int r112 = ((LayoutParams) r111.f461913a.getLayoutParams()).a();
        View r113 = (View) r108.get(r112);
        if (r113 == null) goto L32;
        r104 = true;
    L32:
        if (r113 != null) goto L34;
        r113 = r100.getViewForPosition(r112);
    L34:
        com.tonicartos.superslim.a.C5547a r114 = new com.tonicartos.superslim.a.C5547a(r113, r104);
        v(r114.f461913a);
        r108.put(r112, r114.f461913a);
        View r115 = r114.f461913a;
        getPaddingStart();
        getPaddingEnd();
        LayoutParams r116 = (LayoutParams) r115.getLayoutParams();
        if (r116.f461896a == false) goto L46;
        getDecoratedMeasuredWidth(r115);
        getDecoratedMeasuredHeight(r115);
        if (r116.f461900e == false) goto L42;
        if (r116.g() == false) goto L42;
        r116.e();
    L42:
        if (r116.f461901f == false) goto L46;
        if (r116.c() == false) goto L46;
        r116.e();
    L46:
        r116.a();
        int r117 = r116.f461903h;
        if (r117 == (-1)) goto L55;
        if (r117 != 1) goto L50;
        throw null;
    L50:
        if (r117 != 2) goto L53;
        throw null;
    L53:
        throw new NotYetImplementedSlmException(this, r116.f461903h);
    L55:
        throw null;
    L26:
        r110 = false;
        goto L27
    L17:
        getPaddingTop();
        goto L23
    L19:
        if (r107 != Direction.START) goto L21;
        getDecoratedBottom(r105);
        goto L23
    L21:
        getDecoratedTop(r105);
        goto L23
    L11:
        r106 = Math.min(getPosition(r105), r102 - 1);
        goto L12
    L22:
        r106 = Math.min(r103, r102 - 1);
        this.f461893a = -1;
        goto L23
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsUpdated(RecyclerView r100, int r101, int r102) {
        super.onItemsUpdated(r100, r101, r102);
        View r103 = getChildAt(0);
        View r104 = getChildAt(getChildCount() - 1);
        if ((r102 + r101) > getPosition(r103)) goto L6;
        return;
    L6:
        if (r101 > getPosition(r104)) goto L9;
        requestLayout();
        return;
    }

    public final View p(int r100, int r101, Direction r102) {
        if (r102 != Direction.START) goto L5;
        int r103 = 1;
    L6:
        if (r101 < 0) goto L16;
        if (r101 >= getChildCount()) goto L23;
        View r104 = getChildAt(r101);
        if (getPosition(r104) == r100) goto L11;
        if (((LayoutParams) r104.getLayoutParams()).a() != r100) goto L24;
        r101 = r101 + r103;
        goto L6
    L24:
        return null;
    L11:
        return r104;
    L23:
        return null;
    L16:
        return null;
    L5:
        r103 = -1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        boolean r103 = false;
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        com.tonicartos.superslim.a r104 = new com.tonicartos.superslim.a(this, r101, r102);
        if (r100 <= 0) goto L8;
        Direction r105 = Direction.END;
    L9:
        Direction r106 = Direction.END;
        if (r105 != r106) goto L12;
        r103 = true;
    L12:
        getHeight();
        if (r103 == true) goto L40;
        Direction r107 = Direction.START;
        if (r105 != r107) goto L28;
        View r108 = u(((LayoutParams) s().getLayoutParams()).a(), r107, r104);
        getPaddingStart();
        getPaddingEnd();
        LayoutParams r109 = (LayoutParams) r108.getLayoutParams();
        if (r109.f461896a == false) goto L19;
        getDecoratedMeasuredWidth(r108);
        getDecoratedMeasuredHeight(r108);
        boolean r110 = r109.f461900e;
        boolean r111 = r109.f461901f;
    L19:
        r109.a();
        int r112 = r109.f461903h;
        if (r112 == (-1)) goto L27;
        if (r112 == 1) goto L26;
        if (r112 != 2) goto L25;
        throw null;
    L25:
        throw new NotYetImplementedSlmException(this, r109.f461903h);
    L26:
        throw null;
    L27:
        throw null;
    L28:
        View r113 = u(((LayoutParams) r().getLayoutParams()).a(), r106, r104);
        getPaddingStart();
        getPaddingEnd();
        LayoutParams r114 = (LayoutParams) r113.getLayoutParams();
        if (r114.f461896a == false) goto L31;
        getDecoratedMeasuredWidth(r113);
        getDecoratedMeasuredHeight(r113);
    L31:
        r114.a();
        int r115 = r114.f461903h;
        if (r115 == (-1)) goto L39;
        if (r115 == 1) goto L38;
        if (r115 != 2) goto L37;
        throw null;
    L37:
        throw new NotYetImplementedSlmException(this, r114.f461903h);
    L38:
        throw null;
    L39:
        throw null;
    L40:
        View r116 = r();
        LayoutParams r117 = (LayoutParams) r116.getLayoutParams();
        int r118 = r117.f461903h;
        if (r118 == (-1)) goto L49;
        if (r118 == 1) goto L47;
        if (r118 == 2) goto L47;
        throw new NotYetImplementedSlmException(this, r117.f461903h);
    L47:
        r117.a();
        getChildCount();
        getDecoratedBottom(r116);
        throw null;
    L49:
        throw null;
    L8:
        r105 = Direction.START;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        if (r102 >= 0) goto L4;
    L8:
        getItemCount();
        return;
    L4:
        if (getItemCount() <= r102) goto L8;
        requestLayout();
        r100.getHandler().post(new a(this, r100, r102));
    }

    public final View u(int r100, Direction r101, com.tonicartos.superslim.a r102) {
        if (r101 != Direction.START) goto L5;
        int r103 = 0;
    L6:
        View r104 = p(r100, r103, r101);
        if (r104 != null) goto L13;
        com.tonicartos.superslim.a.C5547a r105 = r102.a(r100);
        View r106 = r105.f461913a;
        if (((LayoutParams) r106.getLayoutParams()).f461896a == false) goto L11;
        v(r105.f461913a);
    L11:
        r102.f461912b.put(r100, r106);
        return r106;
    L13:
        return r104;
    L5:
        r103 = getChildCount() - 1;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void layoutDecorated(View r100, int r110, int r111, int r112, int r113) {
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100.getLayoutParams();
        super.layoutDecorated(r100, r110 + r101.leftMargin, r111 + r101.topMargin, r112 - r101.rightMargin, r113 - r101.bottomMargin);
    }
}
