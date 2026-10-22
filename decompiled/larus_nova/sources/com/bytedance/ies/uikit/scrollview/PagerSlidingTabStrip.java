package com.bytedance.ies.uikit.scrollview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;

/* JADX INFO: loaded from: classes19.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    public static final int[] C = null;
    public int A;
    public final Locale B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout.LayoutParams f249188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout.LayoutParams f249189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f249190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewPager.OnPageChangeListener f249191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f249192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager f249193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f249194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f249195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f249196i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f249197j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f249198k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f249199l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f249200m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f249201n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f249202o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f249203p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f249204q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f249205r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f249206s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f249207t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f249208u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f249209v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f249210w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f249211x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f249212y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f249213z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f249214a;

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

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            this.f249214a = r100.readInt();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f249214a);
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f249215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f249216b;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if ((this.f249216b.f249193f.getAdapter() instanceof d) == true) goto L5;
        L8:
            this.f249216b.f249193f.setCurrentItem(this.f249215a);
            return;
        L5:
            if (this.f249216b.f249193f.getCurrentItem() != this.f249215a) goto L8;
            ((d) this.f249216b.f249193f.getAdapter()).a();
        }

        public a(PagerSlidingTabStrip r100, int r101) {
            this.f249216b = r100;
            this.f249215a = r101;
        }
    }

    public interface b {
        int a();
    }

    public class c implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f249217a;

        public c(PagerSlidingTabStrip r100) {
            this.f249217a = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            if (r100 != 0) goto L4;
            PagerSlidingTabStrip r101 = this.f249217a;
            PagerSlidingTabStrip.a(r101, r101.f249193f.getCurrentItem(), 0);
        L4:
            ViewPager.OnPageChangeListener r102 = this.f249217a.f249191d;
            if (r102 == null) goto L8;
            r102.onPageScrollStateChanged(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            PagerSlidingTabStrip r101 = this.f249217a;
            if (r101.f249204q == false) goto L22;
            int r102 = r101.f249193f.getCurrentItem();
            int r103 = 0;
        L6:
            if (r103 >= r101.f249194g) goto L22;
            View r104 = r101.f249192e.getChildAt(r103);
            if ((r101.f249193f.getAdapter() instanceof d) == false) goto L10;
            TextView r105 = ((d) r101.f249193f.getAdapter()).c();
        L11:
            if (r105 == null) goto L13;
        L15:
            if (r105 == null) goto L21;
            if (r102 == r103) goto L18;
        L20:
            r105.setTextColor(r101.f249212y);
            goto L21
        L18:
            if (r101.f249204q == false) goto L20;
            r105.setTextColor(r101.f249199l);
        L21:
            r103 = r103 + 1;
            goto L6
        L13:
            if ((r104 instanceof TextView) == false) goto L15;
            r105 = (TextView) r104;
            goto L15
        L10:
            r105 = null;
        L22:
            ViewPager.OnPageChangeListener r106 = this.f249217a.f249191d;
            if (r106 == null) goto L30;
            r106.onPageSelected(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            PagerSlidingTabStrip r103 = this.f249217a;
            r103.f249195h = r100;
            r103.f249196i = r101;
            PagerSlidingTabStrip.a(r103, r100, (int) (r103.f249192e.getChildAt(r100).getWidth() * r101));
            this.f249217a.invalidate();
            ViewPager.OnPageChangeListener r104 = this.f249217a.f249191d;
            if (r104 == null) goto L6;
            r104.onPageScrolled(r100, r101, r102);
            return;
        }
    }

    public interface d {
        void a();

        View b();

        TextView c();
    }

    static {
        C = new int[]{R.attr.textSize, R.attr.textColor};
    }

    public final void c() {
        int r100 = this.f249193f.getCurrentItem();
        int r101 = 0;
    L4:
        if (r101 >= this.f249194g) goto L24;
        View r102 = this.f249192e.getChildAt(r101);
        r102.setBackgroundResource(this.A);
        if ((this.f249193f.getAdapter() instanceof d) == false) goto L8;
        TextView r103 = ((d) this.f249193f.getAdapter()).c();
    L9:
        if (r103 == null) goto L11;
    L13:
        if (r103 == null) goto L23;
        r103.setTextSize(0, this.f249211x);
        r103.setTypeface(null, 0);
        if (r100 == r101) goto L17;
    L19:
        r103.setTextColor(this.f249212y);
    L21:
        if (this.f249203p == false) goto L23;
        r103.setAllCaps(true);
        goto L23
    L17:
        if (this.f249204q == false) goto L19;
        r103.setTextColor(this.f249199l);
    L23:
        r101 = r101 + 1;
        goto L4
    L11:
        if ((r102 instanceof TextView) == false) goto L13;
        r103 = (TextView) r102;
        goto L13
    L8:
        r103 = null;
        goto L9
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f249214a = this.f249195h;
        return r100;
    }

    public int getDividerColor() {
        return this.f249201n;
    }

    public int getDividerPadding() {
        return this.f249209v;
    }

    public boolean getHighlightTitle() {
        return this.f249204q;
    }

    public int getIndicatorColor() {
        return this.f249199l;
    }

    public int getIndicatorHeight() {
        return this.f249207t;
    }

    public int getScrollOffset() {
        return this.f249206s;
    }

    public boolean getShouldExpand() {
        return this.f249202o;
    }

    public int getTabBackground() {
        return this.A;
    }

    public int getTabPaddingLeftRight() {
        return this.f249210w;
    }

    public int getTextColor() {
        return this.f249212y;
    }

    public int getTextSize() {
        return this.f249211x;
    }

    public int getUnderlineColor() {
        return this.f249200m;
    }

    public int getUnderlineHeight() {
        return this.f249208u;
    }

    public PagerSlidingTabStrip(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f249194g == 0) goto L24;
        int r100 = getHeight();
        if (this.f249205r == false) goto L10;
        this.f249197j.setColor(this.f249200m);
        r110.drawRect(0.0f, r100 - this.f249208u, this.f249192e.getWidth(), r100, this.f249197j);
    L10:
        this.f249197j.setColor(this.f249199l);
        View r101 = this.f249192e.getChildAt(this.f249195h);
        float r102 = r101.getLeft();
        float r103 = r101.getRight();
        if (this.f249196i <= 0.0f) goto L15;
        int r104 = this.f249195h;
        if (r104 >= (this.f249194g - 1)) goto L15;
        View r105 = this.f249192e.getChildAt(r104 + 1);
        float r106 = r105.getLeft();
        float r107 = r105.getRight();
        float r108 = this.f249196i;
        r102 = (r106 * r108) + ((1.0f - r108) * r102);
        r103 = (r107 * r108) + ((1.0f - r108) * r103);
    L15:
        float r111 = r100;
        r110.drawRect(r102, r100 - this.f249207t, r103, r111, this.f249197j);
        if (this.f249205r == true) goto L18;
        this.f249197j.setColor(this.f249200m);
        r110.drawRect(0.0f, r100 - this.f249208u, this.f249192e.getWidth(), r111, this.f249197j);
    L18:
        this.f249198k.setColor(this.f249201n);
        int r109 = 0;
    L20:
        if (r109 >= (this.f249194g - 1)) goto L25;
        View r112 = this.f249192e.getChildAt(r109);
        r110.drawLine(r112.getRight(), this.f249209v, r112.getRight(), r100 - this.f249209v, this.f249198k);
        r109 = r109 + 1;
        goto L20
    L25:
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.f249195h = r101.f249214a;
        requestLayout();
    }

    public void setAllCaps(boolean r100) {
        this.f249203p = r100;
    }

    public void setDividerColor(int r100) {
        this.f249201n = r100;
        invalidate();
    }

    public void setDividerColorResource(int r100) {
        this.f249201n = getResources().getColor(r100);
        invalidate();
    }

    public void setDividerPadding(int r100) {
        this.f249209v = r100;
        invalidate();
    }

    public void setHighlightTitle(boolean r100) {
        this.f249204q = r100;
    }

    public void setIndicatorColor(int r100) {
        this.f249199l = r100;
        invalidate();
    }

    public void setIndicatorColorResource(int r100) {
        this.f249199l = getResources().getColor(r100);
        invalidate();
    }

    public void setIndicatorHeight(int r100) {
        this.f249207t = r100;
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        this.f249191d = r100;
    }

    public void setOverlayIndicator(boolean r100) {
        this.f249205r = r100;
    }

    public void setScrollOffset(int r100) {
        this.f249206s = r100;
        invalidate();
    }

    public void setShouldExpand(boolean r100) {
        this.f249202o = r100;
        requestLayout();
    }

    public void setTabBackground(int r100) {
        this.A = r100;
    }

    public void setTabPaddingLeftRight(int r100) {
        this.f249210w = r100;
        c();
    }

    public void setTextColor(int r100) {
        this.f249212y = r100;
        c();
    }

    public void setTextColorResource(int r100) {
        this.f249212y = getResources().getColor(r100);
        c();
    }

    public void setTextSize(int r100) {
        this.f249211x = r100;
        c();
    }

    public void setUnderlineColor(int r100) {
        this.f249200m = r100;
        invalidate();
    }

    public void setUnderlineColorResource(int r100) {
        this.f249200m = getResources().getColor(r100);
        invalidate();
    }

    public void setUnderlineHeight(int r100) {
        this.f249208u = r100;
        invalidate();
    }

    public void setViewPager(ViewPager r100) {
        this.f249193f = r100;
        if (r100.getAdapter() == null) goto L23;
        r100.setOnPageChangeListener(this.f249190c);
        this.f249192e.removeAllViews();
        this.f249194g = this.f249193f.getAdapter().getCount();
        int r101 = 0;
    L6:
        if (r101 >= this.f249194g) goto L20;
        if ((this.f249193f.getAdapter() instanceof b) == false) goto L10;
        int r102 = ((b) this.f249193f.getAdapter()).a();
        ImageButton r103 = new ImageButton(getContext());
        r103.setImageResource(r102);
        b(r101, r103);
    L19:
        r101 = r101 + 1;
        goto L6
    L10:
        String r104 = this.f249193f.getAdapter().getPageTitle(r101).toString();
        TextView r105 = null;
        if ((this.f249193f.getAdapter() instanceof d) == false) goto L15;
        d r106 = (d) this.f249193f.getAdapter();
        View r107 = r106.b();
        if (r107 == null) goto L16;
        r105 = r106.c();
    L16:
        if (r105 != null) goto L18;
        r105 = new TextView(getContext());
        r107 = r105;
    L18:
        r105.setText(r104);
        r105.setGravity(17);
        r105.setSingleLine();
        b(r101, r107);
        goto L19
    L15:
        r107 = null;
        goto L16
    L20:
        c();
        getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.ies.uikit.scrollview.a(this));
        return;
    L23:
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public PagerSlidingTabStrip(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void b(int r100, View r101) {
        r101.setFocusable(true);
        r101.setOnClickListener(new a(this, r100));
        int r102 = this.f249210w;
        r101.setPadding(r102, 0, r102, 0);
        LinearLayout r103 = this.f249192e;
        if (this.f249202o == false) goto L5;
        LinearLayout.LayoutParams r104 = this.f249189b;
    L6:
        r103.addView(r101, r100, r104);
        return;
    L5:
        r104 = this.f249188a;
        goto L6
    }

    public PagerSlidingTabStrip(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        this.f249190c = new c(this);
        this.f249195h = 0;
        this.f249196i = 0.0f;
        this.f249199l = -10066330;
        this.f249200m = 436207616;
        this.f249201n = 436207616;
        this.f249202o = false;
        this.f249203p = true;
        this.f249204q = false;
        this.f249205r = false;
        this.f249206s = 52;
        this.f249207t = 8;
        this.f249208u = 2;
        this.f249209v = 12;
        this.f249210w = 24;
        this.f249211x = 12;
        this.f249212y = -10066330;
        this.f249213z = 0;
        this.A = com.larus.nova.R.drawable.background_tab;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout r101 = new LinearLayout(r100);
        this.f249192e = r101;
        r101.setOrientation(0);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r101);
        Resources r102 = getResources();
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        this.f249206s = (int) TypedValue.applyDimension(1, this.f249206s, r103);
        this.f249207t = (int) TypedValue.applyDimension(1, this.f249207t, r103);
        this.f249208u = (int) TypedValue.applyDimension(1, this.f249208u, r103);
        this.f249209v = (int) TypedValue.applyDimension(1, this.f249209v, r103);
        this.f249210w = (int) TypedValue.applyDimension(1, this.f249210w, r103);
        int r104 = (int) TypedValue.applyDimension(1, 1, r103);
        this.f249211x = (int) TypedValue.applyDimension(2, this.f249211x, r103);
        TypedArray r105 = r100.obtainStyledAttributes(r110, C);
        this.f249211x = r105.getDimensionPixelSize(0, this.f249211x);
        this.f249212y = r105.getColor(1, this.f249212y);
        r105.recycle();
        TypedArray r106 = r100.obtainStyledAttributes(r110, new int[]{com.larus.nova.R.attr.isTextUnderLine, com.larus.nova.R.attr.pstsDividerColor, com.larus.nova.R.attr.pstsDividerPadding, com.larus.nova.R.attr.pstsIndicatorColor, com.larus.nova.R.attr.pstsIndicatorHeight, com.larus.nova.R.attr.pstsIndicatorPadding, com.larus.nova.R.attr.pstsScrollOffset, com.larus.nova.R.attr.pstsShouldExpand, com.larus.nova.R.attr.pstsTabBackground, com.larus.nova.R.attr.pstsTabPaddingLeftRight, com.larus.nova.R.attr.pstsTabSpaceing, com.larus.nova.R.attr.pstsTextAllCaps, com.larus.nova.R.attr.pstsUnderlineColor, com.larus.nova.R.attr.pstsUnderlineHeight, com.larus.nova.R.attr.tabIndicatorTextColor});
        this.f249199l = r106.getColor(3, this.f249199l);
        this.f249200m = r106.getColor(12, this.f249200m);
        this.f249201n = r106.getColor(1, this.f249201n);
        this.f249207t = r106.getDimensionPixelSize(4, this.f249207t);
        this.f249208u = r106.getDimensionPixelSize(13, this.f249208u);
        this.f249209v = r106.getDimensionPixelSize(2, this.f249209v);
        this.f249210w = r106.getDimensionPixelSize(9, this.f249210w);
        this.A = r106.getResourceId(8, this.A);
        this.f249202o = r106.getBoolean(7, this.f249202o);
        this.f249206s = r106.getDimensionPixelSize(6, this.f249206s);
        this.f249203p = r106.getBoolean(11, this.f249203p);
        r106.recycle();
        Paint r107 = new Paint();
        this.f249197j = r107;
        r107.setAntiAlias(true);
        r107.setStyle(Paint.Style.FILL);
        Paint r108 = new Paint();
        this.f249198k = r108;
        r108.setAntiAlias(true);
        r108.setStrokeWidth(r104);
        this.f249188a = new LinearLayout.LayoutParams(-2, -1);
        this.f249189b = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.B != null) goto L6;
        this.B = getResources().getConfiguration().locale;
        return;
    }

    public static void a(PagerSlidingTabStrip r100, int r101, int r102) {
        if (r100.f249194g == 0) goto L14;
        int r103 = r100.f249192e.getChildAt(r101).getLeft() + r102;
        if (r101 > 0) goto L8;
        if (r102 > 0) goto L8;
    L10:
        if (r103 == r100.f249213z) goto L13;
        r100.f249213z = r103;
        r100.scrollTo(r103, 0);
        return;
    L13:
        return;
    L8:
        r103 = r103 - r100.f249206s;
        goto L10
    }
}
