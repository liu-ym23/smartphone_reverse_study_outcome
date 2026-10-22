package com.ss.android.lark.keyboard.plugin.tool.voice.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class SmartTabLayout extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.keyboard.plugin.tool.voice.widget.a f430885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f430886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f430887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f430888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ColorStateList f430889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f430890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f430891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f430892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewPager f430893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewPager.OnPageChangeListener f430894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f430895k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f430896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f430897m;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SmartTabLayout f430898a;

        public a(SmartTabLayout r100) {
            this.f430898a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            int r101 = 0;
        L4:
            if (r101 >= this.f430898a.f430885a.getChildCount()) goto L10;
            if (r100 == this.f430898a.f430885a.getChildAt(r101)) goto L7;
            r101 = r101 + 1;
            goto L4
        L7:
            this.f430898a.getClass();
            this.f430898a.f430893i.setCurrentItem(r101);
            return;
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f430899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SmartTabLayout f430900b;

        public b(SmartTabLayout r100) {
            this.f430900b = r100;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f430899a = r100;
            ViewPager.OnPageChangeListener r101 = this.f430900b.f430894j;
            if (r101 == null) goto L6;
            r101.onPageScrollStateChanged(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            if (this.f430899a != 0) goto L8;
            com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r101 = this.f430900b.f430885a;
            r101.f430924u = r100;
            r101.f430925v = 0.0f;
            if (r101.f430923t == r100) goto L7;
            r101.f430923t = r100;
        L7:
            r101.invalidate();
            this.f430900b.a(r100, 0.0f);
        L8:
            int r102 = this.f430900b.f430885a.getChildCount();
            int r103 = 0;
        L9:
            if (r103 >= r102) goto L15;
            View r104 = this.f430900b.f430885a.getChildAt(r103);
            if (r100 != r103) goto L13;
            boolean r105 = true;
        L14:
            r104.setSelected(r105);
            r103 = r103 + 1;
            goto L9
        L13:
            r105 = false;
            goto L14
        L15:
            ViewPager.OnPageChangeListener r106 = this.f430900b.f430894j;
            if (r106 == null) goto L22;
            r106.onPageSelected(r100);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            int r103 = this.f430900b.f430885a.getChildCount();
            if (r103 == 0) goto L16;
            if (r100 < 0) goto L17;
            if (r100 >= r103) goto L19;
            com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r104 = this.f430900b.f430885a;
            r104.f430924u = r100;
            r104.f430925v = r101;
            if (r101 == 0.0f) goto L10;
        L12:
            r104.invalidate();
            this.f430900b.a(r100, r101);
            ViewPager.OnPageChangeListener r105 = this.f430900b.f430894j;
            if (r105 == null) goto L18;
            r105.onPageScrolled(r100, r101, r102);
            return;
        L18:
            return;
        L10:
            if (r104.f430923t == r100) goto L12;
            r104.f430923t = r100;
            goto L12
        L19:
            return;
        L17:
            return;
        }
    }

    public interface c {
    }

    public interface d {
    }

    public static class e implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LayoutInflater f430901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f430902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f430903c;

        public e(Context r100, int r101, int r102) {
            this.f430901a = LayoutInflater.from(r100);
            this.f430902b = r101;
            this.f430903c = r102;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.widget.SmartTabLayout.g
        public final View a(com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r100, int r101, PagerAdapter r102) {
            int r103 = this.f430902b;
            TextView r104 = null;
            if (r103 == (-1)) goto L5;
            View r105 = this.f430901a.inflate(r103, r100, false);
        L6:
            int r106 = this.f430903c;
            if (r106 == (-1)) goto L10;
            if (r105 == null) goto L10;
            r104 = (TextView) r105.findViewById(r106);
        L10:
            if (r104 == null) goto L12;
        L14:
            if (r104 == null) goto L16;
            r104.setText(r102.getPageTitle(r101));
        L16:
            return r105;
        L12:
            if (TextView.class.isInstance(r105) == false) goto L14;
            r104 = (TextView) r105;
            goto L14
        L5:
            r105 = null;
            goto L6
        }
    }

    public interface f {
    }

    public interface g {
        View a(com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r100, int r101, PagerAdapter r102);
    }

    public void setOnScrollChangeListener(c r100) {
    }

    public void setOnTabClickListener(d r100) {
    }

    public List<View> getTabs() {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
    L4:
        if (r101 >= this.f430885a.getChildCount()) goto L6;
        r100.add(this.f430885a.getChildAt(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public SmartTabLayout(Context r100) {
        this(r100, null);
    }

    public void setCustomTabColorizer(f r100) {
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r101 = this.f430885a;
        r101.f430927x = r100;
        r101.invalidate();
    }

    public void setCustomTabView(g r100) {
        this.f430895k = r100;
    }

    public void setDefaultTabTextColor(int r100) {
        this.f430889e = ColorStateList.valueOf(r100);
    }

    public void setDistributeEvenly(boolean r100) {
        this.f430897m = r100;
    }

    public void setDividerColors(int... r100) {
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r101 = this.f430885a;
        r101.f430927x = null;
        r101.f430921r.f430929b = r100;
        r101.invalidate();
    }

    public void setIndicationInterpolator(vob.c r100) {
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r101 = this.f430885a;
        r101.f430926w = r100;
        r101.invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener r100) {
        this.f430894j = r100;
    }

    public void setSelectedIndicatorColors(int... r100) {
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r101 = this.f430885a;
        r101.f430927x = null;
        r101.f430921r.f430928a = r100;
        r101.invalidate();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setViewPager(ViewPager r100) {
        this.f430885a.removeAllViews();
        this.f430893i = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getAdapter() == null) goto L37;
        r100.addOnPageChangeListener(new b(this));
        PagerAdapter r101 = this.f430893i.getAdapter();
        int r102 = 0;
    L8:
        if (r102 >= r101.getCount()) goto L38;
        g r103 = this.f430895k;
        if (r103 != null) goto L18;
        CharSequence r104 = r101.getPageTitle(r102);
        TextView r105 = new TextView(getContext());
        r105.setGravity(17);
        r105.setText(r104);
        r105.setTextColor(this.f430889e);
        r105.setTextSize(0, a08.b.a(this.f430890f, getContext()));
        r105.setTypeface(Typeface.DEFAULT_BOLD);
        r105.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        int r106 = this.f430887c;
        if (r106 == (-1)) goto L14;
        r105.setBackgroundResource(r106);
    L15:
        r105.setAllCaps(this.f430888d);
        int r107 = this.f430891g;
        r105.setPadding(r107, 0, r107, 0);
        int r108 = this.f430892h;
        View r109 = r105;
        if (r108 <= 0) goto L19;
        r105.setMinWidth(r108);
        r109 = r105;
    L19:
        if (r109 == null) goto L31;
        if (this.f430897m == false) goto L23;
        LinearLayout.LayoutParams r110 = (LinearLayout.LayoutParams) r109.getLayoutParams();
        r110.width = 0;
        r110.weight = 1.0f;
    L23:
        a r111 = this.f430896l;
        if (r111 == null) goto L26;
        r109.setOnClickListener(r111);
    L26:
        this.f430885a.addView(r109);
        if (r102 != this.f430893i.getCurrentItem()) goto L29;
        r109.setSelected(true);
    L29:
        r102 = r102 + 1;
        goto L8
    L31:
        throw new IllegalStateException("tabView is null.");
    L14:
        TypedValue r112 = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.selectableItemBackground, r112, true);
        r105.setBackgroundResource(r112.resourceId);
        goto L15
    L18:
        r109 = r103.a(this.f430885a, r102, r101);
        goto L19
    L38:
        return;
    }

    public void setDefaultTabTextColor(ColorStateList r100) {
        this.f430889e = r100;
    }

    public SmartTabLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void a(int r110, float r111) {
        int r100 = this.f430885a.getChildCount();
        if (r100 == 0) goto L65;
        if (r110 < 0) goto L66;
        if (r110 < r100) goto L8;
        return;
    L8:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
        boolean r101 = true;
    L11:
        View r102 = this.f430885a.getChildAt(r110);
        int r103 = vob.d.e(r102);
        if (r102 != null) goto L14;
        int r104 = 0;
    L15:
        int r105 = (int) ((r103 + r104) * r111);
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r106 = this.f430885a;
        if (r106.f430911h == true) goto L18;
        int r107 = this.f430886b;
        if (r107 == (-1)) goto L31;
        if (r101 == false) goto L53;
        if (r110 <= 0) goto L49;
    L52:
        int r112 = r107;
    L59:
        int r113 = vob.d.d(r102, false);
        int r108 = vob.d.c(r102);
        if (r101 == false) goto L62;
        int r114 = (((r113 + r108) - r105) - getWidth()) + (getPaddingLeft() + getPaddingRight());
    L63:
        scrollTo(r112 + r114, 0);
        return;
    L62:
        r114 = (r113 - r108) + r105;
        goto L63
    L49:
        if (r111 > 0.0f) goto L52;
        r107 = 0;
        goto L52
    L53:
        if (r110 <= 0) goto L55;
    L58:
        r112 = -r107;
        goto L59
    L55:
        if (r111 > 0.0f) goto L58;
        r112 = 0;
        goto L59
    L31:
        if (0.0f < r111) goto L33;
    L35:
        if (r101 == false) goto L41;
        int r115 = vob.d.e(r102);
        if (r102 != null) goto L39;
        int r116 = 0;
    L40:
        r112 = (((-(r115 + r116)) / 2) + (getWidth() / 2)) - ViewCompat.getPaddingStart(this);
        goto L59
    L39:
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        r116 = MarginLayoutParamsCompat.getMarginEnd(r117) + MarginLayoutParamsCompat.getMarginStart(r117);
        goto L40
    L41:
        int r118 = vob.d.e(r102);
        if (r102 != null) goto L44;
        int r119 = 0;
    L45:
        r112 = (((r118 + r119) / 2) - (getWidth() / 2)) + ViewCompat.getPaddingStart(this);
        goto L59
    L44:
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        r119 = MarginLayoutParamsCompat.getMarginEnd(r120) + MarginLayoutParamsCompat.getMarginStart(r120);
        goto L45
    L33:
        if (r111 >= 1.0f) goto L35;
        View r121 = r106.getChildAt(r110 + 1);
        r105 = Math.round(r111 * (((vob.d.e(r102) / 2) + vob.d.b(r102)) + ((vob.d.e(r121) / 2) + vob.d.c(r121))));
        goto L35
    L18:
        if (0.0f < r111) goto L20;
    L22:
        View r122 = this.f430885a.getChildAt(0);
        if (r101 == false) goto L25;
        int r123 = vob.d.e(r122) + vob.d.b(r122);
        int r124 = vob.d.e(r102) + vob.d.b(r102);
        int r109 = (vob.d.a(r102, false) - vob.d.b(r102)) - r105;
        int r125 = (r123 - r124) / 2;
    L26:
        scrollTo(r109 - r125, 0);
        return;
    L25:
        int r126 = vob.d.e(r122) + vob.d.c(r122);
        int r127 = vob.d.e(r102) + vob.d.c(r102);
        r109 = (vob.d.d(r102, false) - vob.d.c(r102)) + r105;
        r125 = (r126 - r127) / 2;
        goto L26
    L20:
        if (r111 >= 1.0f) goto L22;
        View r128 = r106.getChildAt(r110 + 1);
        r105 = Math.round(r111 * (((vob.d.e(r102) / 2) + vob.d.b(r102)) + ((vob.d.e(r128) / 2) + vob.d.c(r128))));
        goto L22
    L14:
        ViewGroup.MarginLayoutParams r129 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        r104 = MarginLayoutParamsCompat.getMarginStart(r129) + MarginLayoutParamsCompat.getMarginEnd(r129);
        goto L15
    L10:
        r101 = false;
        goto L11
    L66:
        return;
    }

    public SmartTabLayout(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        setHorizontalScrollBarEnabled(false);
        Resources r100 = getResources();
        DisplayMetrics r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        float r102 = r101.density;
        float r103 = TypedValue.applyDimension(2, 12.0f, r101);
        TypedArray r104 = r110.obtainStyledAttributes(r111, new int[]{com.larus.nova.R.attr.stl_clickable, com.larus.nova.R.attr.stl_customTabTextLayoutId, com.larus.nova.R.attr.stl_customTabTextViewId, com.larus.nova.R.attr.stl_defaultTabBackground, com.larus.nova.R.attr.stl_defaultTabTextAllCaps, com.larus.nova.R.attr.stl_defaultTabTextColor, com.larus.nova.R.attr.stl_defaultTabTextHorizontalPadding, com.larus.nova.R.attr.stl_defaultTabTextMinWidth, com.larus.nova.R.attr.stl_defaultTabTextSize, com.larus.nova.R.attr.stl_distributeEvenly, com.larus.nova.R.attr.stl_dividerColor, com.larus.nova.R.attr.stl_dividerColors, com.larus.nova.R.attr.stl_dividerThickness, com.larus.nova.R.attr.stl_drawDecorationAfterTab, com.larus.nova.R.attr.stl_indicatorAlwaysInCenter, com.larus.nova.R.attr.stl_indicatorColor, com.larus.nova.R.attr.stl_indicatorColors, com.larus.nova.R.attr.stl_indicatorCornerRadius, com.larus.nova.R.attr.stl_indicatorGravity, com.larus.nova.R.attr.stl_indicatorInFront, com.larus.nova.R.attr.stl_indicatorInterpolation, com.larus.nova.R.attr.stl_indicatorThickness, com.larus.nova.R.attr.stl_indicatorWidth, com.larus.nova.R.attr.stl_indicatorWithoutPadding, com.larus.nova.R.attr.stl_overlineColor, com.larus.nova.R.attr.stl_overlineThickness, com.larus.nova.R.attr.stl_titleOffset, com.larus.nova.R.attr.stl_underlineColor, com.larus.nova.R.attr.stl_underlineThickness}, r112, 0);
        int r113 = r104.getResourceId(3, -1);
        boolean r114 = r104.getBoolean(4, true);
        ColorStateList r115 = r104.getColorStateList(5);
        float r105 = r104.getDimension(8, r103);
        int r106 = r104.getDimensionPixelSize(6, (int) (16.0f * r102));
        int r107 = r104.getDimensionPixelSize(7, (int) (0.0f * r102));
        int r116 = r104.getResourceId(1, -1);
        int r108 = r104.getResourceId(2, -1);
        boolean r117 = r104.getBoolean(9, false);
        boolean r109 = r104.getBoolean(0, true);
        int r118 = r104.getLayoutDimension(26, (int) (r102 * 24.0f));
        r104.recycle();
        this.f430886b = r118;
        this.f430887c = r113;
        this.f430888d = r114;
        if (r115 != null) goto L6;
        r115 = ColorStateList.valueOf(-67108864);
    L6:
        this.f430889e = r115;
        this.f430890f = r105;
        this.f430891g = r106;
        this.f430892h = r107;
        if (r109 == false) goto L9;
        a r119 = new a(this);
    L10:
        this.f430896l = r119;
        this.f430897m = r117;
        if (r116 == (-1)) goto L13;
        this.f430895k = new e(getContext(), r116, r108);
    L13:
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r120 = new com.ss.android.lark.keyboard.plugin.tool.voice.widget.a(r110, r111);
        this.f430885a = r120;
        if (r117 == true) goto L16;
    L20:
        setFillViewport(!r120.f430911h);
        addView(r120, -1, -1);
        return;
    L16:
        if (r120.f430911h == false) goto L20;
        throw new UnsupportedOperationException("'distributeEvenly' and 'indicatorAlwaysInCenter' both use does not support");
    L9:
        r119 = null;
        goto L10
    }

    @Override // android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r104 = this.f430885a;
        if (r104.f430911h == true) goto L5;
        return;
    L5:
        if (r104.getChildCount() <= 0) goto L17;
        View r105 = this.f430885a.getChildAt(0);
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r106 = this.f430885a;
        View r107 = r106.getChildAt(r106.getChildCount() - 1);
        if (r105 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = ((r100 - r108) / 2) - vob.d.c(r105);
        if (r107 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = ((r100 - r110) / 2) - vob.d.b(r107);
        com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r112 = this.f430885a;
        r112.setMinimumWidth(r112.getMeasuredWidth());
        ViewCompat.setPaddingRelative(this, r109, getPaddingTop(), r111, getPaddingBottom());
        setClipToPadding(false);
        return;
    L13:
        r110 = r107.getMeasuredWidth();
        goto L14
    L9:
        r108 = r105.getMeasuredWidth();
        goto L10
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L8;
        ViewPager r105 = this.f430893i;
        if (r105 == null) goto L9;
        a(r105.getCurrentItem(), 0.0f);
        return;
    L9:
        return;
    }
}
