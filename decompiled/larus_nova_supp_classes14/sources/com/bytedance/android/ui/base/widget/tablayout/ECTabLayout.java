package com.bytedance.android.ui.base.widget.tablayout;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.tabs.TabItem;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@ViewPager.DecorView
public class ECTabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = -1;
    private static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools.Pool<Tab> tabPool = null;
    private AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;
    private BaseOnTabSelectedListener currentVpSelectedListener;
    private boolean defaultUnSelected;
    private int indicatorBottomMargin;
    boolean inlineLabel;
    int mode;
    private boolean needBindListener;
    private boolean needHideIndicatorWhenSingleTab;
    private OnScrollChangeListener onScrollChangeListener;
    private TabLayoutOnPageChangeListener pageChangeListener;
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private BaseOnTabSelectedListener selectedListener;
    private final ArrayList<BaseOnTabSelectedListener> selectedListeners;
    private Tab selectedTab;
    private boolean setupViewPagerImplicitly;
    private final SlidingTabIndicator slidingTabIndicator;
    final int tabBackgroundResId;
    int tabGravity;
    ColorStateList tabIconTint;
    PorterDuff.Mode tabIconTintMode;
    int tabIndicatorAnimationDuration;
    boolean tabIndicatorFullWidth;
    int tabIndicatorGravity;
    int tabMaxWidth;
    int tabPaddingBottom;
    int tabPaddingEnd;
    int tabPaddingStart;
    int tabPaddingTop;
    ColorStateList tabRippleColorStateList;
    Drawable tabSelectedIndicator;
    int tabTextAppearance;
    ColorStateList tabTextColors;
    float tabTextMultiLineSize;
    float tabTextSize;
    private final RectF tabViewContentBounds;
    private final Pools.Pool<TabView> tabViewPool;
    private final ArrayList<Tab> tabs;
    boolean unboundedRipple;
    ViewPager viewPager;

    public class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
        private boolean autoRefresh;
        final /* synthetic */ ECTabLayout this$0;

        public AdapterChangeListener(ECTabLayout r1) {
            this.this$0 = r1;
        }

        public void setAutoRefresh(boolean r1) {
            this.autoRefresh = r1;
        }

        public void onAdapterChanged(ViewPager r2, PagerAdapter r3, PagerAdapter r4) {
            ECTabLayout r5 = this.this$0;
            if (r5.viewPager != r2) goto L6;
            r5.setPagerAdapter(r4, this.autoRefresh);
            return;
        }
    }

    public interface BaseOnTabSelectedListener<T extends Tab> {

        /* JADX INFO: renamed from: com.bytedance.android.ui.base.widget.tablayout.ECTabLayout$BaseOnTabSelectedListener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC<T extends Tab> {
            public static void $default$onTabSelected(BaseOnTabSelectedListener r0, Tab r1, boolean r2) {
            }
        }

        void onTabReselected(T r1);

        void onTabSelected(T r1);

        void onTabSelected(T r1, boolean r2);

        void onTabUnselected(T r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnScrollChangeListener {
        void onScrollChange(View r1, int r2, int r3, int r4, int r5);
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    public class PagerAdapterObserver extends DataSetObserver {
        final /* synthetic */ ECTabLayout this$0;

        @Override // android.database.DataSetObserver
        public void onChanged() {
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }

        public PagerAdapterObserver(ECTabLayout r1) {
            this.this$0 = r1;
        }
    }

    public class SlidingTabIndicator extends LinearLayout {
        private final GradientDrawable defaultSelectionIndicator;
        private int fixedIndicatorWidth;
        private ValueAnimator indicatorAnimator;
        private int indicatorLeft;
        private int indicatorRight;
        private int layoutDirection;
        private int selectedIndicatorHeight;
        private final Paint selectedIndicatorPaint;
        int selectedPosition;
        float selectionOffset;
        final /* synthetic */ ECTabLayout this$0;

        private void updateIndicatorPosition() {
            View r0 = getChildAt(this.selectedPosition);
            if (r0 != null) goto L5;
        L24:
            int r1 = -1;
            int r2 = -1;
        L25:
            setIndicatorPosition(r1, r2);
            return;
        L5:
            if (r0.getWidth() <= 0) goto L24;
            r1 = r0.getLeft();
            r2 = r0.getRight();
            ECTabLayout r3 = this.this$0;
            if (r3.tabIndicatorFullWidth == true) goto L12;
            if ((r0 instanceof TabView) == false) goto L12;
            calculateTabViewContentBounds((TabView) r0, ECTabLayout.access$500(r3));
            r1 = (int) ECTabLayout.access$500(this.this$0).left;
            r2 = (int) ECTabLayout.access$500(this.this$0).right;
        L12:
            if (this.selectionOffset > 0.0f) goto L14;
        L21:
            int r4 = this.fixedIndicatorWidth;
            if (r4 <= 0) goto L25;
            int r5 = (r1 + r2) / 2;
            int r6 = r5 - (r4 / 2);
            int r7 = (r4 / 2) + r5;
            r1 = r6;
            r2 = r7;
            goto L25
        L14:
            if (this.selectedPosition >= (getChildCount() - 1)) goto L21;
            View r8 = getChildAt(this.selectedPosition + 1);
            int r9 = r8.getLeft();
            int r10 = r8.getRight();
            ECTabLayout r11 = this.this$0;
            if (r11.tabIndicatorFullWidth == false) goto L18;
        L20:
            float r12 = this.selectionOffset;
            r1 = (int) ((r9 * r12) + ((1.0f - r12) * r1));
            r2 = (int) ((r10 * r12) + ((1.0f - r12) * r2));
            goto L21
        L18:
            if ((r8 instanceof TabView) == false) goto L20;
            calculateTabViewContentBounds((TabView) r8, ECTabLayout.access$500(r11));
            r9 = (int) ECTabLayout.access$500(this.this$0).left;
            r10 = (int) ECTabLayout.access$500(this.this$0).right;
            goto L20
        }

        public float getIndicatorPosition() {
            return this.selectedPosition + this.selectionOffset;
        }

        public boolean childrenNeedLayout() {
            int r0 = getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            if (getChildAt(r2).getWidth() <= 0) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas r7) {
            Drawable r0 = this.this$0.tabSelectedIndicator;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.getIntrinsicHeight();
        L6:
            int r3 = this.selectedIndicatorHeight;
            if (r3 < 0) goto L9;
            r2 = r3;
        L9:
            int r4 = this.this$0.tabIndicatorGravity;
            if (r4 != 0) goto L12;
            r1 = (getHeight() - r2) - ECTabLayout.access$700(this.this$0);
            r2 = getHeight() - ECTabLayout.access$700(this.this$0);
        L20:
            int r5 = this.indicatorLeft;
            if (r5 >= 0) goto L23;
        L41:
            super.draw(r7);
            return;
        L23:
            if (this.indicatorRight <= r5) goto L41;
            Drawable r6 = this.this$0.tabSelectedIndicator;
            if (r6 != null) goto L28;
            r6 = this.defaultSelectionIndicator;
        L28:
            Drawable r8 = DrawableCompat.wrap(r6);
            r8.setBounds(this.indicatorLeft, r1, this.indicatorRight, r2);
            Paint r9 = this.selectedIndicatorPaint;
            if (r9 == null) goto L37;
            if (r9.getColor() == 0) goto L37;
            if (Build.VERSION.SDK_INT != 21) goto L35;
            r8.setColorFilter(this.selectedIndicatorPaint.getColor(), PorterDuff.Mode.SRC_IN);
            goto L37
        L35:
            DrawableCompat.setTint(r8, this.selectedIndicatorPaint.getColor());
        L37:
            if (ECTabLayout.access$800(this.this$0) == true) goto L39;
        L40:
            r8.draw(r7);
            goto L41
        L39:
            if (ECTabLayout.access$900(this.this$0).size() == 1) goto L41;
        L12:
            if (r4 == 1) goto L18;
            if (r4 == 2) goto L20;
            if (r4 == 3) goto L17;
            r2 = 0;
            goto L20
        L17:
            r2 = getHeight();
            goto L20
        L18:
            r1 = (getHeight() - r2) / 2;
            r2 = (getHeight() + r2) / 2;
            goto L20
        L5:
            r2 = 0;
            goto L6
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r3) {
            super.onRtlPropertiesChanged(r3);
            if (Build.VERSION.SDK_INT < 23) goto L5;
            return;
        L5:
            if (this.layoutDirection == r3) goto L9;
            requestLayout();
            this.layoutDirection = r3;
            return;
        }

        public void setSelectedIndicatorColor(int r2) {
            if (this.selectedIndicatorPaint.getColor() == r2) goto L6;
            this.selectedIndicatorPaint.setColor(r2);
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        public void setSelectedIndicatorFixedWidth(int r2) {
            if (this.fixedIndicatorWidth == r2) goto L6;
            this.fixedIndicatorWidth = r2;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        public void setSelectedIndicatorHeight(int r2) {
            if (this.selectedIndicatorHeight == r2) goto L6;
            this.selectedIndicatorHeight = r2;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }

        public SlidingTabIndicator(ECTabLayout r1, Context r2) {
            this.this$0 = r1;
            super(r2);
            this.fixedIndicatorWidth = -1;
            this.selectedPosition = -1;
            this.layoutDirection = -1;
            this.indicatorLeft = -1;
            this.indicatorRight = -1;
            setClipChildren(false);
            setWillNotDraw(false);
            this.selectedIndicatorPaint = new Paint();
            this.defaultSelectionIndicator = new GradientDrawable();
        }

        private void calculateTabViewContentBounds(TabView r4, RectF r5) {
            int r0 = TabView.access$600(r4);
            if (r0 >= this.this$0.dpToPx(ECTabLayout.MIN_INDICATOR_WIDTH)) goto L5;
            r0 = this.this$0.dpToPx(ECTabLayout.MIN_INDICATOR_WIDTH);
        L5:
            int r1 = (r4.getLeft() + r4.getRight()) / 2;
            int r2 = r0 / 2;
            r5.set(r1 - r2, 0.0f, r1 + r2, 0.0f);
        }

        public void animateIndicatorToPosition(final int r11, int r12) {
            ValueAnimator r0 = this.indicatorAnimator;
            if (r0 != null) goto L5;
        L7:
            View r1 = getChildAt(r11);
            if (r1 != null) goto L11;
            updateIndicatorPosition();
            return;
        L11:
            int r2 = r1.getLeft();
            int r3 = r1.getRight();
            ECTabLayout r4 = this.this$0;
            if (r4.tabIndicatorFullWidth == false) goto L14;
        L16:
            int r5 = this.fixedIndicatorWidth;
            if (r5 <= 0) goto L19;
            int r6 = (r2 + r3) / 2;
            final int r9 = (r5 / 2) + r6;
            final int r7 = r6 - (r5 / 2);
        L20:
            final int r8 = this.indicatorLeft;
            final int r10 = this.indicatorRight;
            if (r8 != r7) goto L23;
            if (r10 != r9) goto L23;
            return;
        L23:
            ValueAnimator r13 = new ValueAnimator();
            this.indicatorAnimator = r13;
            r13.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            r13.setDuration(r12);
            r13.setFloatValues(new float[]{0.0f, 1.0f});
            r13.addUpdateListener(new AnonymousClass1(this, r8, r7, r10, r9));
            r13.addListener(new AnonymousClass2(this, r11));
            r13.start();
            return;
        L19:
            r7 = r2;
            r9 = r3;
            goto L20
        L14:
            if ((r1 instanceof TabView) == false) goto L16;
            calculateTabViewContentBounds((TabView) r1, ECTabLayout.access$500(r4));
            r2 = (int) ECTabLayout.access$500(this.this$0).left;
            r3 = (int) ECTabLayout.access$500(this.this$0).right;
            goto L16
        L5:
            if (r0.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r9, int r10) {
            super.onMeasure(r9, r10);
            if (View.MeasureSpec.getMode(r9) == 1073741824) goto L5;
            return;
        L5:
            ECTabLayout r0 = this.this$0;
            boolean r2 = true;
            if (r0.mode == 1) goto L8;
            return;
        L8:
            if (r0.tabGravity != 1) goto L39;
            int r1 = getChildCount();
            int r3 = 0;
            int r4 = 0;
            int r5 = 0;
        L10:
            if (r4 >= r1) goto L15;
            View r6 = getChildAt(r4);
            if (r6.getVisibility() != 0) goto L14;
            r5 = Math.max(r5, r6.getMeasuredWidth());
        L14:
            r4 = r4 + 1;
            goto L10
        L15:
            if (r5 > 0) goto L17;
            return;
        L17:
            int r7 = this.this$0.dpToPx(16);
            if ((r5 * r1) > (getMeasuredWidth() - (r7 * 2))) goto L28;
            boolean r8 = false;
        L20:
            if (r3 >= r1) goto L27;
            LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) getChildAt(r3).getLayoutParams();
            if (r11.width == r5) goto L24;
        L25:
            r11.width = r5;
            r11.weight = 0.0f;
            r8 = true;
        L26:
            r3 = r3 + 1;
            goto L20
        L24:
            if (r11.weight == 0.0f) goto L26;
        L27:
            r2 = r8;
        L29:
            if (r2 == false) goto L40;
            super.onMeasure(r9, r10);
            return;
        L40:
            return;
        L28:
            ECTabLayout r12 = this.this$0;
            r12.tabGravity = 0;
            r12.updateTabViews(false);
            goto L29
        }

        public void setIndicatorPosition(int r2, int r3) {
            if (r2 == this.indicatorLeft) goto L5;
        L6:
            this.indicatorLeft = r2;
            this.indicatorRight = r3;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        L5:
            if (r3 != this.indicatorRight) goto L6;
        }

        public void setIndicatorPositionFromTabPosition(int r2, float r3) {
            ValueAnimator r0 = this.indicatorAnimator;
            if (r0 != null) goto L5;
        L7:
            this.selectedPosition = r2;
            this.selectionOffset = r3;
            updateIndicatorPosition();
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            goto L7
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            ValueAnimator r6 = this.indicatorAnimator;
            if (r6 != null) goto L5;
        L7:
            updateIndicatorPosition();
            return;
        L5:
            if (r6.isRunning() == false) goto L7;
            this.indicatorAnimator.cancel();
            animateIndicatorToPosition(this.selectedPosition, Math.round((1.0f - this.indicatorAnimator.getAnimatedFraction()) * this.indicatorAnimator.getDuration()));
        }
    }

    public static class Tab {
        public static final int INVALID_POSITION = -1;
        private CharSequence contentDesc;
        private View customView;
        private Drawable icon;
        public ECTabLayout parent;
        private int position;
        private Object tag;
        private CharSequence text;
        public TabView view;

        public void reset() {
            this.parent = null;
            this.view = null;
            this.tag = null;
            this.icon = null;
            this.text = null;
            this.contentDesc = null;
            this.position = -1;
            this.customView = null;
        }

        public void select() {
            select(false);
        }

        public CharSequence getContentDescription() {
            TabView r0 = this.view;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.getContentDescription();
        }

        public boolean isSelected() {
            ECTabLayout r0 = this.parent;
            if (r0 == null) goto L14;
            if (ECTabLayout.access$400(r0) == false) goto L10;
            if (this.parent.getSelectedTabPosition() != (-1)) goto L10;
            return false;
        L10:
            if (this.parent.getSelectedTabPosition() != this.position) goto L15;
            return true;
        L15:
            return false;
        L14:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void updateView() {
            TabView r0 = this.view;
            if (r0 == null) goto L6;
            r0.update();
            return;
        }

        public Tab() {
            this.position = -1;
        }

        public View getCustomView() {
            return this.customView;
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public int getPosition() {
            return this.position;
        }

        public Object getTag() {
            return this.tag;
        }

        public CharSequence getText() {
            return this.text;
        }

        public View getView() {
            return this.view;
        }

        public static /* synthetic */ CharSequence access$100(Tab r0) {
            return r0.contentDesc;
        }

        public static /* synthetic */ CharSequence access$200(Tab r0) {
            return r0.text;
        }

        public void select(boolean r2) {
            ECTabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            r0.selectTab(this, r2);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setContentDescription(int r2) {
            ECTabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            return setContentDescription(r0.getResources().getText(r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setCustomView(int r4) {
            return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(r4, this.view, false));
        }

        public Tab setIcon(int r2) {
            ECTabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            return setIcon(AppCompatResources.getDrawable(r0.getContext(), r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void setPosition(int r1) {
            this.position = r1;
        }

        public Tab setTag(Object r1) {
            this.tag = r1;
            return this;
        }

        public Tab setText(int r2) {
            ECTabLayout r0 = this.parent;
            if (r0 == null) goto L7;
            return setText(r0.getResources().getText(r2));
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab setContentDescription(CharSequence r1) {
            this.contentDesc = r1;
            updateView();
            return this;
        }

        public Tab setCustomView(View r1) {
            this.customView = r1;
            updateView();
            return this;
        }

        public Tab setIcon(Drawable r1) {
            this.icon = r1;
            updateView();
            return this;
        }

        public Tab setText(CharSequence r2) {
            if (TextUtils.isEmpty(this.contentDesc) == true) goto L5;
        L7:
            this.text = r2;
            updateView();
            return this;
        L5:
            if (TextUtils.isEmpty(r2) == true) goto L7;
            this.view.setContentDescription(r2);
            goto L7
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private int previousScrollState;
        private int scrollState;
        private final WeakReference<ECTabLayout> tabLayoutRef;

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }

        public TabLayoutOnPageChangeListener(ECTabLayout r2) {
            this.tabLayoutRef = new WeakReference(r2);
        }

        public void onPageScrollStateChanged(int r2) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r2;
        }

        public void onPageSelected(int r6) {
            ECTabLayout r0 = this.tabLayoutRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r6) goto L7;
            return;
        L7:
            if (r6 >= r0.getTabCount()) goto L21;
            int r1 = this.scrollState;
            if (r1 != 0) goto L11;
        L16:
            boolean r2 = true;
        L17:
            r0.selectTab(r0.getTabAt(r6), r2, false, true);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r2 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        public void onPageScrolled(int r6, float r7, int r8) {
            ECTabLayout r9 = this.tabLayoutRef.get();
            if (r9 == null) goto L17;
            int r0 = this.scrollState;
            boolean r1 = false;
            if (r0 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r0 == 2) goto L13;
        L14:
            r1 = true;
        L15:
            r9.setScrollPosition(r6, r7, r4, r1);
            return;
        L13:
            if (this.previousScrollState == 0) goto L15;
        L7:
            if (this.previousScrollState == 1) goto L10;
            r4 = false;
            goto L11
        }
    }

    public class TabView extends LinearLayout {
        private Drawable baseBackgroundDrawable;
        private ImageView customIconView;
        private TextView customTextView;
        private View customView;
        private int defaultMaxLines;
        private ImageView iconView;
        private Tab tab;
        private TextView textView;
        final /* synthetic */ ECTabLayout this$0;

        private int getContentWidth() {
            int r3 = 0;
            View[] r1 = {this.textView, this.iconView, this.customView};
            int r2 = 0;
            int r5 = 0;
            boolean r6 = false;
        L3:
            if (r3 >= 3) goto L17;
            View r7 = r1[r3];
            if (r7 == null) goto L15;
            if (r7.getVisibility() != 0) goto L15;
            if (r6 == false) goto L10;
            r5 = Math.min(r5, r7.getLeft());
        L11:
            if (r6 == false) goto L13;
            r2 = Math.max(r2, r7.getRight());
        L14:
            r6 = true;
            goto L15
        L13:
            r2 = r7.getRight();
            goto L14
        L10:
            r5 = r7.getLeft();
        L15:
            r3 = r3 + 1;
            goto L3
        L17:
            return r2 - r5;
        }

        private void updateBackgroundDrawable(Context r1) {
        }

        public void reset() {
            setTab(null);
            setSelected(false);
        }

        public final void update() {
            Tab r0 = this.tab;
            if (r0 != null) goto L5;
            return;
        L5:
            View r1 = r0.getCustomView();
            Drawable r2 = null;
            if (r1 == null) goto L22;
            ViewParent r3 = r1.getParent();
            if (r3 == this) goto L12;
            if (r3 == null) goto L11;
            ((ViewGroup) r3).removeView(r1);
        L11:
            addView(r1);
        L12:
            this.customView = r1;
            TextView r4 = this.textView;
            if (r4 == null) goto L15;
            r4.setVisibility(8);
        L15:
            ImageView r5 = this.iconView;
            if (r5 == null) goto L18;
            r5.setVisibility(8);
            this.iconView.setImageDrawable(null);
        L18:
            TextView r6 = (TextView) r1.findViewById(R.id.text1);
            this.customTextView = r6;
            if (r6 == null) goto L21;
            this.defaultMaxLines = TextViewCompat.getMaxLines(r6);
        L21:
            this.customIconView = (ImageView) r1.findViewById(R.id.icon);
        L27:
            if (this.customView == null) goto L29;
            TextView r7 = this.customTextView;
            if (r7 == null) goto L57;
        L58:
            updateTextAndIcon(r7, this.customIconView);
        L60:
            if (TextUtils.isEmpty(Tab.access$100(r0)) == true) goto L62;
            setContentDescription(Tab.access$100(r0));
        L62:
            setSelected(r0.isSelected());
            return;
        L57:
            if (this.customIconView == null) goto L60;
        L29:
            if (this.iconView != null) goto L34;
            if (r0.getIcon() == null) goto L34;
            ImageView r8 = (ImageView) LayoutInflater.from(getContext()).inflate(2131560004, this, false);
            addView(r8, 0);
            this.iconView = r8;
        L34:
            if (r0.getIcon() == null) goto L36;
            r2 = DrawableCompat.wrap(r0.getIcon()).mutate();
        L36:
            if (r2 == null) goto L41;
            DrawableCompat.setTintList(r2, this.this$0.tabIconTint);
            PorterDuff.Mode r9 = this.this$0.tabIconTintMode;
            if (r9 == null) goto L41;
            DrawableCompat.setTintMode(r2, r9);
        L41:
            if (this.textView == null) goto L43;
        L45:
            TextView r10 = this.textView;
            if (r10 == null) goto L48;
            TextViewCompat.setTextAppearance(r10, this.this$0.tabTextAppearance);
        L48:
            ColorStateList r11 = this.this$0.tabTextColors;
            if (r11 == null) goto L53;
            TextView r12 = this.textView;
            if (r12 == null) goto L53;
            r12.setTextColor(r11);
        L53:
            updateTextAndIcon(this.textView, this.iconView);
            goto L60
        L43:
            if (Tab.access$200(r0) == null) goto L45;
            TextView r13 = (TextView) LayoutInflater.from(getContext()).inflate(2131560005, this, false);
            addView(r13);
            this.textView = r13;
            this.defaultMaxLines = TextViewCompat.getMaxLines(r13);
            goto L45
        L22:
            View r14 = this.customView;
            if (r14 == null) goto L25;
            removeView(r14);
            this.customView = null;
        L25:
            this.customTextView = null;
            this.customIconView = null;
            goto L27
        }

        public final void updateOrientation() {
            setOrientation(!this.this$0.inlineLabel ? 1 : 0);
            TextView r0 = this.customTextView;
            if (r0 == null) goto L5;
        L8:
            updateTextAndIcon(r0, this.customIconView);
            return;
        L5:
            if (this.customIconView != null) goto L8;
            updateTextAndIcon(this.textView, this.iconView);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] r0 = getDrawableState();
            Drawable r1 = this.baseBackgroundDrawable;
            boolean r2 = false;
            if (r1 != null) goto L5;
        L7:
            if (r2 == false) goto L10;
            invalidate();
            this.this$0.invalidate();
            return;
        L10:
            return;
        L5:
            if (r1.isStateful() == false) goto L7;
            r2 = false | this.baseBackgroundDrawable.setState(r0);
            goto L7
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r0 = super.performClick();
            if (this.tab == null) goto L8;
            if (r0 == true) goto L6;
            playSoundEffect(0);
        L6:
            this.tab.select(true);
            return true;
        L8:
            return r0;
        }

        public Tab getTab() {
            return this.tab;
        }

        public static /* synthetic */ int access$600(TabView r0) {
            return r0.getContentWidth();
        }

        private void drawBackground(Canvas r6) {
            Drawable r0 = this.baseBackgroundDrawable;
            if (r0 == null) goto L6;
            r0.setBounds(getLeft(), getTop(), getRight(), getBottom());
            this.baseBackgroundDrawable.draw(r6);
            return;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r2);
            r2.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
            super.onInitializeAccessibilityNodeInfo(r2);
            r2.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void setSelected(boolean r2) {
            if (isSelected() != r2) goto L6;
        L6:
            super.setSelected(r2);
            TextView r0 = this.textView;
            if (r0 == null) goto L9;
            r0.setSelected(r2);
        L9:
            ImageView r1 = this.iconView;
            if (r1 == null) goto L12;
            r1.setSelected(r2);
        L12:
            View r3 = this.customView;
            if (r3 == null) goto L16;
            r3.setSelected(r2);
            return;
        }

        public void setTab(Tab r2) {
            if (r2 == this.tab) goto L6;
            this.tab = r2;
            update();
            return;
        }

        public TabView(ECTabLayout r4, Context r5) {
            this.this$0 = r4;
            super(r5);
            this.defaultMaxLines = 2;
            setClipChildren(false);
            updateBackgroundDrawable(r5);
            ViewCompat.setPaddingRelative(this, r4.tabPaddingStart, r4.tabPaddingTop, r4.tabPaddingEnd, r4.tabPaddingBottom);
            setGravity(17);
            setOrientation(!r4.inlineLabel ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        public static /* synthetic */ void access$000(TabView r0, Context r1) {
            r0.updateBackgroundDrawable(r1);
        }

        public static /* synthetic */ void access$300(TabView r0, Canvas r1) {
            r0.drawBackground(r1);
        }

        private void updateTextAndIcon(TextView r6, ImageView r7) {
            Tab r0 = this.tab;
            CharSequence r1 = null;
            if (r0 != null) goto L5;
        L7:
            Drawable r2 = null;
        L8:
            Tab r3 = this.tab;
            if (r3 == null) goto L11;
            CharSequence r4 = r3.getText();
        L13:
            if (r7 == null) goto L17;
            if (r2 == null) goto L16;
            r7.setImageDrawable(r2);
            r7.setVisibility(0);
            setVisibility(0);
            goto L17
        L16:
            r7.setVisibility(8);
            r7.setImageDrawable(null);
        L17:
            boolean r5 = !TextUtils.isEmpty(r4);
            if (r6 == null) goto L22;
            if (r5 == false) goto L21;
            r6.setText(r4);
            r6.setVisibility(0);
            setVisibility(0);
            goto L22
        L21:
            r6.setVisibility(8);
            r6.setText(null);
        L22:
            if (r7 == null) goto L37;
            ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7.getLayoutParams();
            if (r5 == true) goto L26;
        L28:
            int r9 = 0;
        L30:
            if (this.this$0.inlineLabel == false) goto L35;
            if (r9 == MarginLayoutParamsCompat.getMarginEnd(r8)) goto L37;
            MarginLayoutParamsCompat.setMarginEnd(r8, r9);
            r8.bottomMargin = 0;
            r7.setLayoutParams(r8);
            r7.requestLayout();
            goto L37
        L35:
            if (r9 == r8.bottomMargin) goto L37;
            r8.bottomMargin = r9;
            MarginLayoutParamsCompat.setMarginEnd(r8, 0);
            r7.setLayoutParams(r8);
            r7.requestLayout();
            goto L37
        L26:
            if (r7.getVisibility() != 0) goto L28;
            r9 = this.this$0.dpToPx(8);
        L37:
            Tab r10 = this.tab;
            if (r10 == null) goto L40;
            CharSequence r11 = Tab.access$100(r10);
        L41:
            if (r5 == true) goto L44;
            r1 = r11;
        L44:
            TooltipCompat.setTooltipText(this, r1);
            return;
        L40:
            r11 = null;
            goto L41
        L11:
            r4 = null;
            goto L13
        L5:
            if (r0.getIcon() == null) goto L7;
            r2 = DrawableCompat.wrap(this.tab.getIcon()).mutate();
            goto L8
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r8, int r9) {
            int r0 = View.MeasureSpec.getSize(r8);
            int r1 = View.MeasureSpec.getMode(r8);
            int r2 = this.this$0.getTabMaxWidth();
            if (r2 <= 0) goto L7;
            if (r1 == 0) goto L6;
            if (r0 <= r2) goto L7;
        L6:
            r8 = View.MeasureSpec.makeMeasureSpec(this.this$0.tabMaxWidth, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r8, r9);
            if (this.textView == null) goto L35;
            float r3 = this.this$0.tabTextSize;
            int r4 = this.defaultMaxLines;
            ImageView r5 = this.iconView;
            boolean r6 = true;
            if (r5 != null) goto L12;
        L14:
            TextView r7 = this.textView;
            if (r7 != null) goto L17;
        L19:
            float r10 = this.textView.getTextSize();
            int r11 = this.textView.getLineCount();
            int r12 = TextViewCompat.getMaxLines(this.textView);
            if (r3 != r10) goto L24;
            if (r12 < 0) goto L36;
            if (r4 != r12) goto L24;
            return;
        L36:
            return;
        L24:
            if (this.this$0.mode != 1) goto L32;
            if (r3 <= r10) goto L32;
            if (r11 != 1) goto L32;
            Layout r13 = this.textView.getLayout();
            if (r13 != null) goto L30;
        L31:
            r6 = false;
            goto L32
        L30:
            if (approximateLineWidth(r13, 0, r3) > ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L31;
        L32:
            if (r6 == false) goto L38;
            this.textView.setTextSize(0, r3);
            this.textView.setMaxLines(r4);
            super.onMeasure(r8, r9);
            return;
        L38:
            return;
        L17:
            if (r7.getLineCount() <= 1) goto L19;
            r3 = this.this$0.tabTextMultiLineSize;
            goto L19
        L12:
            if (r5.getVisibility() != 0) goto L14;
            r4 = 1;
            goto L19
        }

        private float approximateLineWidth(Layout r1, int r2, float r3) {
            return r1.getLineWidth(r2) * (r3 / r1.getPaint().getTextSize());
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager viewPager;

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public void onTabReselected(Tab r1) {
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(Tab r1) {
        }

        public ViewPagerOnTabSelectedListener(ViewPager r1) {
            this.viewPager = r1;
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public void onTabSelected(Tab r2) {
            this.viewPager.setCurrentItem(r2.getPosition());
        }

        @Override // com.bytedance.android.ui.base.widget.tablayout.ECTabLayout.BaseOnTabSelectedListener
        public void onTabSelected(Tab r1, boolean r2) {
            if (this.viewPager.isAttachedToWindow() == true) goto L10;
            return;
        L10:
            this.viewPager.setCurrentItem(r1.getPosition());     // Catch: IllegalArgumentException -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    static {
        tabPool = new Pools.SynchronizedPool(16);
    }

    private void applyModeAndGravity() {
        if (this.mode != 0) goto L5;
        int r0 = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
    L6:
        ViewCompat.setPaddingRelative(this.slidingTabIndicator, r0, 0, 0, 0);
        int r1 = this.mode;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L12;
        this.slidingTabIndicator.setGravity(1);
    L12:
        updateTabViews(true);
        return;
    L11:
        this.slidingTabIndicator.setGravity(8388611);
        goto L12
    L5:
        r0 = 0;
        goto L6
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(r0);
        return r0;
    }

    private void ensureScrollAnimator() {
        if (this.scrollAnimator != null) goto L6;
        ValueAnimator r0 = new ValueAnimator();
        this.scrollAnimator = r0;
        r0.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
        this.scrollAnimator.addUpdateListener(new AnonymousClass1(this));
        return;
    }

    private int getDefaultHeight() {
        int r0 = this.tabs.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        Tab r3 = (Tab) ListProtector.get(this.tabs, r2);
        if (r3 == null) goto L11;
        if (r3.getIcon() == null) goto L11;
        if (TextUtils.isEmpty(r3.getText()) == true) goto L11;
        r1 = true;
    L11:
        r2 = r2 + 1;
    L12:
        if (r1 == true) goto L14;
    L16:
        return DEFAULT_HEIGHT;
    L14:
        if (this.inlineLabel == true) goto L16;
        return DEFAULT_HEIGHT_WITH_TEXT_ICON;
    }

    private int getTabMinWidth() {
        int r0 = this.requestedTabMinWidth;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (this.mode == 0) goto L10;
        return 0;
    L10:
        return this.scrollableTabMinWidth;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.slidingTabIndicator.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void updateAllTabs() {
        int r0 = this.tabs.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((Tab) ListProtector.get(this.tabs, r1)).updateView();
        r1 = r1 + 1;
        goto L3
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public Tab createTabFromPool() {
        Tab r0 = (Tab) tabPool.acquire();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new Tab();
    }

    public int getSelectedTabPosition() {
        Tab r0 = this.selectedTab;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getPosition();
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public void removeAllTabs() {
        int r0 = this.slidingTabIndicator.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L5;
        removeTabViewAt(r0);
        r0 = r0 - 1;
        goto L3
    L5:
        Iterator<Tab> r1 = this.tabs.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Tab r2 = r1.next();
        r1.remove();
        r2.reset();
        releaseFromTabPool(r2);
        goto L7
    L9:
        this.selectedTab = null;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getRightFadingEdgeStrength() {
        return super.getRightFadingEdgeStrength();
    }

    public Tab newTab() {
        Tab r0 = createTabFromPool();
        r0.parent = this;
        r0.view = createTabView(r0);
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.viewPager != null) goto L8;
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewPager) == false) goto L9;
        setupWithViewPager((ViewPager) r0, true, true);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.setupViewPagerImplicitly == false) goto L6;
        setupWithViewPager(null);
        this.setupViewPagerImplicitly = false;
        return;
    }

    public void populateFromPagerAdapter() {
        removeAllTabs();
        PagerAdapter r0 = this.pagerAdapter;
        if (r0 == null) goto L17;
        int r1 = r0.getCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        addTab(newTab().setText(this.pagerAdapter.getPageTitle(r2)), false);
        r2 = r2 + 1;
        goto L5
    L7:
        ViewPager r3 = this.viewPager;
        if (r3 == null) goto L18;
        if (r1 <= 0) goto L19;
        int r4 = r3.getCurrentItem();
        if (r4 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r4 >= getTabCount()) goto L21;
        selectTab(getTabAt(r4), false);
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getIndicatorBottomMargin() {
        return this.indicatorBottomMargin;
    }

    public boolean getNeedHideIndicatorWhenSingleTab() {
        return this.needHideIndicatorWhenSingleTab;
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    public ECTabLayout(Context r2) {
        this(r2, null);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_ui_base_widget_tablayout_ECTabLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static /* synthetic */ boolean access$400(ECTabLayout r0) {
        return r0.defaultUnSelected;
    }

    public static /* synthetic */ RectF access$500(ECTabLayout r0) {
        return r0.tabViewContentBounds;
    }

    public static /* synthetic */ int access$700(ECTabLayout r0) {
        return r0.indicatorBottomMargin;
    }

    public static /* synthetic */ boolean access$800(ECTabLayout r0) {
        return r0.needHideIndicatorWhenSingleTab;
    }

    public static /* synthetic */ ArrayList access$900(ECTabLayout r0) {
        return r0.tabs;
    }

    private void addTabFromItemView(TabItem r3) {
        Tab r0 = newTab();
        CharSequence r1 = r3.text;
        if (r1 == null) goto L5;
        r0.setText(r1);
    L5:
        Drawable r2 = r3.icon;
        if (r2 == null) goto L8;
        r0.setIcon(r2);
    L8:
        int r4 = r3.customLayout;
        if (r4 == 0) goto L12;
        r0.setCustomView(r4);
    L12:
        if (TextUtils.isEmpty(r3.getContentDescription()) == true) goto L14;
        r0.setContentDescription(r3.getContentDescription());
    L14:
        addTab(r0);
    }

    private void addTabView(Tab r4) {
        TabView r0 = r4.view;
        this.slidingTabIndicator.addView(r0, r4.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View r2) {
        if ((r2 instanceof TabItem) == false) goto L7;
        addTabFromItemView((TabItem) r2);
        return;
    L7:
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private TabView createTabView(Tab r3) {
        Pools.Pool<TabView> r0 = this.tabViewPool;
        if (r0 == null) goto L5;
        TabView r1 = (TabView) r0.acquire();
    L6:
        if (r1 != null) goto L8;
        r1 = new TabView(this, getContext());
    L8:
        r1.setTab(r3);
        r1.setFocusable(true);
        r1.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(Tab.access$100(r3)) == false) goto L11;
        r1.setContentDescription(Tab.access$200(r3));
    L12:
        return r1;
    L11:
        r1.setContentDescription(Tab.access$100(r3));
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private void dispatchTabReselected(Tab r3) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((BaseOnTabSelectedListener) ListProtector.get(this.selectedListeners, r0)).onTabReselected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void dispatchTabUnselected(Tab r3) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((BaseOnTabSelectedListener) ListProtector.get(this.selectedListeners, r0)).onTabUnselected(r3);
        r0 = r0 - 1;
        goto L3
    }

    private void removeTabViewAt(int r3) {
        TabView r0 = (TabView) this.slidingTabIndicator.getChildAt(r3);
        this.slidingTabIndicator.removeViewAt(r3);
        if (r0 == null) goto L5;
        r0.reset();
        this.tabViewPool.release(r0);
    L5:
        requestLayout();
    }

    private void setSelectedTabView(int r7) {
        int r0 = this.slidingTabIndicator.getChildCount();
        if (r7 >= r0) goto L15;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L19;
        View r3 = this.slidingTabIndicator.getChildAt(r2);
        boolean r4 = true;
        if (r2 != r7) goto L9;
        boolean r5 = true;
    L10:
        r3.setSelected(r5);
        if (r2 == r7) goto L14;
        r4 = false;
    L14:
        r3.setActivated(r4);
        r2 = r2 + 1;
        goto L5
    L9:
        r5 = false;
        goto L10
    L19:
        return;
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams r3) {
        if (this.mode == 1) goto L5;
    L7:
        r3.width = -2;
        r3.weight = 0.0f;
        return;
    L5:
        if (this.tabGravity != 0) goto L7;
        r3.width = 0;
        r3.weight = 1.0f;
    }

    public void addOnTabSelectedListener(BaseOnTabSelectedListener r2) {
        if (this.selectedListeners.contains(r2) == true) goto L6;
        this.selectedListeners.add(r2);
        return;
    }

    public void addTab(Tab r2) {
        addTab(r2, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1) {
        addViewInternal(r1);
    }

    int dpToPx(int r2) {
        return Math.round(INVOKEVIRTUAL_com_bytedance_android_ui_base_widget_tablayout_ECTabLayout_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getResources()).density * r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    public Tab getTabAt(int r2) {
        if (r2 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r2 >= getTabCount()) goto L7;
        return (Tab) ListProtector.get(this.tabs, r2);
    }

    @Override // android.view.View
    public void onDraw(Canvas r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r1 = this.slidingTabIndicator.getChildAt(r0);
        if ((r1 instanceof TabView) == false) goto L8;
        TabView.access$300((TabView) r1, r4);
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        super.onDraw(r4);
    }

    public boolean releaseFromTabPool(Tab r2) {
        return tabPool.release(r2);
    }

    public void removeOnTabSelectedListener(BaseOnTabSelectedListener r2) {
        this.selectedListeners.remove(r2);
    }

    public void removeTab(Tab r2) {
        if (r2.parent != this) goto L7;
        removeTabAt(r2.getPosition());
        return;
    L7:
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int r6) {
        Tab r0 = this.selectedTab;
        if (r0 == null) goto L5;
        int r1 = r0.getPosition();
    L6:
        removeTabViewAt(r6);
        Tab r2 = (Tab) ListProtector.remove(this.tabs, r6);
        if (r2 == null) goto L9;
        r2.reset();
        releaseFromTabPool(r2);
    L9:
        int r3 = this.tabs.size();
        int r4 = r6;
    L10:
        if (r4 >= r3) goto L12;
        ((Tab) ListProtector.get(this.tabs, r4)).setPosition(r4);
        r4 = r4 + 1;
        goto L10
    L12:
        if (r1 == r6) goto L14;
        return;
    L14:
        if (this.tabs.isEmpty() == false) goto L16;
        Tab r7 = null;
    L17:
        selectTab(r7, false);
        return;
    L16:
        r7 = (Tab) ListProtector.get(this.tabs, Math.max(0, r6 - 1));
        goto L17
    L5:
        r1 = 0;
        goto L6
    }

    public void selectTab(int r3) {
        if (getSelectedTabPosition() != r3) goto L6;
        return;
    L6:
        if (r3 < this.tabs.size()) goto L8;
        return;
    L8:
        selectTab((Tab) ListProtector.get(this.tabs, r3), true, false, true);
    }

    public void selectTabWithoutAnimation(int r3) {
        if (getSelectedTabPosition() != r3) goto L6;
        return;
    L6:
        if (r3 < this.tabs.size()) goto L8;
        return;
    L8:
        selectTab((Tab) ListProtector.get(this.tabs, r3), true, false, false);
    }

    public void setBindListenerAble(boolean r1) {
        this.needBindListener = r1;
    }

    public void setDefaultUnSelected(boolean r1) {
        this.defaultUnSelected = r1;
    }

    public void setIndicatorBottomMargin(int r1) {
        this.indicatorBottomMargin = r1;
    }

    public void setInlineLabel(boolean r3) {
        if (this.inlineLabel == r3) goto L16;
        this.inlineLabel = r3;
        int r4 = 0;
    L6:
        if (r4 >= this.slidingTabIndicator.getChildCount()) goto L11;
        View r0 = this.slidingTabIndicator.getChildAt(r4);
        if ((r0 instanceof TabView) == false) goto L10;
        ((TabView) r0).updateOrientation();
    L10:
        r4 = r4 + 1;
        goto L6
    L11:
        applyModeAndGravity();
        return;
    }

    public void setInlineLabelResource(int r2) {
        setInlineLabel(getResources().getBoolean(r2));
    }

    public void setNeedHideIndicatorWhenSingleTab(boolean r1) {
        this.needHideIndicatorWhenSingleTab = r1;
    }

    public void setOnScrollChangeListenerCompat(OnScrollChangeListener r1) {
        this.onScrollChangeListener = r1;
    }

    public void setOnTabSelectedListener(BaseOnTabSelectedListener r2) {
        BaseOnTabSelectedListener r0 = this.selectedListener;
        if (r0 == null) goto L5;
        removeOnTabSelectedListener(r0);
    L5:
        this.selectedListener = r2;
        if (r2 == null) goto L9;
        addOnTabSelectedListener(r2);
        return;
    }

    void setScrollAnimatorListener(Animator.AnimatorListener r2) {
        ensureScrollAnimator();
        this.scrollAnimator.addListener(r2);
    }

    public void setSelectedTabIndicator(int r2) {
        if (r2 == 0) goto L4;
        setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), r2));
        return;
    L4:
        setSelectedTabIndicator(null);
    }

    public void setSelectedTabIndicatorColor(int r2) {
        this.slidingTabIndicator.setSelectedIndicatorColor(r2);
    }

    public void setSelectedTabIndicatorFixedWidth(int r2) {
        this.slidingTabIndicator.setSelectedIndicatorFixedWidth(r2);
    }

    public void setSelectedTabIndicatorGravity(int r2) {
        if (this.tabIndicatorGravity == r2) goto L6;
        this.tabIndicatorGravity = r2;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        return;
    }

    public void setSelectedTabIndicatorHeight(int r2) {
        this.slidingTabIndicator.setSelectedIndicatorHeight(r2);
    }

    public void setTabGravity(int r2) {
        if (this.tabGravity == r2) goto L6;
        this.tabGravity = r2;
        applyModeAndGravity();
        return;
    }

    public void setTabIconTint(ColorStateList r2) {
        if (this.tabIconTint == r2) goto L6;
        this.tabIconTint = r2;
        updateAllTabs();
        return;
    }

    public void setTabIconTintResource(int r2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public void setTabIndicatorFullWidth(boolean r1) {
        this.tabIndicatorFullWidth = r1;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }

    public void setTabMaxWidth(int r1) {
        this.requestedTabMaxWidth = r1;
    }

    public void setTabMode(int r2) {
        if (r2 == this.mode) goto L6;
        this.mode = r2;
        applyModeAndGravity();
        return;
    }

    public void setTabPaddingBottom(int r1) {
        this.tabPaddingBottom = r1;
    }

    public void setTabPaddingEnd(int r1) {
        this.tabPaddingEnd = r1;
    }

    public void setTabPaddingStart(int r1) {
        this.tabPaddingStart = r1;
    }

    public void setTabPaddingTop(int r1) {
        this.tabPaddingTop = r1;
    }

    public void setTabRippleColor(ColorStateList r3) {
        if (this.tabRippleColorStateList == r3) goto L11;
        this.tabRippleColorStateList = r3;
        int r4 = 0;
    L6:
        if (r4 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r0 = this.slidingTabIndicator.getChildAt(r4);
        if ((r0 instanceof TabView) == false) goto L10;
        TabView.access$000((TabView) r0, getContext());
    L10:
        r4 = r4 + 1;
        goto L6
    L15:
        return;
    }

    public void setTabRippleColorResource(int r2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public void setTabTextColors(ColorStateList r2) {
        if (this.tabTextColors == r2) goto L6;
        this.tabTextColors = r2;
        updateAllTabs();
        return;
    }

    public void setTabsFromPagerAdapter(PagerAdapter r2) {
        setPagerAdapter(r2, false);
    }

    public void setUnboundedRipple(boolean r3) {
        if (this.unboundedRipple == r3) goto L11;
        this.unboundedRipple = r3;
        int r4 = 0;
    L6:
        if (r4 >= this.slidingTabIndicator.getChildCount()) goto L15;
        View r0 = this.slidingTabIndicator.getChildAt(r4);
        if ((r0 instanceof TabView) == false) goto L10;
        TabView.access$000((TabView) r0, getContext());
    L10:
        r4 = r4 + 1;
        goto L6
    L15:
        return;
    }

    public void setUnboundedRippleResource(int r2) {
        setUnboundedRipple(getResources().getBoolean(r2));
    }

    public void setupWithViewPager(ViewPager r2) {
        setupWithViewPager(r2, true);
    }

    void updateTabViews(boolean r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L9;
        View r1 = this.slidingTabIndicator.getChildAt(r0);
        r1.setMinimumWidth(getTabMinWidth());
        updateTabViewLayoutParams((LinearLayout.LayoutParams) r1.getLayoutParams());
        if (r4 == false) goto L8;
        r1.requestLayout();
    L8:
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateDefaultLayoutParams();
    }

    public void selectTab(Tab r2) {
        selectTab(r2, false);
    }

    public void selectTabWithoutAnimation(Tab r3) {
        selectTab(r3, true, true, false);
    }

    public void setSelectedTabIndicator(Drawable r2) {
        if (this.tabSelectedIndicator == r2) goto L6;
        this.tabSelectedIndicator = r2;
        ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
        return;
    }

    public ECTabLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 2130974382);
    }

    private void animateToTab(int r6, boolean r7) {
        if (r6 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L20:
        setScrollPosition(r6, 0.0f, true);
        return;
    L8:
        if (ViewCompat.isLaidOut(this) == false) goto L20;
        if (this.slidingTabIndicator.childrenNeedLayout() == true) goto L20;
        int r0 = getScrollX();
        int r2 = calculateScrollXForTab(r6, 0.0f);
        if (r0 != r2) goto L15;
    L18:
        this.slidingTabIndicator.animateIndicatorToPosition(r6, this.tabIndicatorAnimationDuration);
        return;
    L15:
        if (r7 == false) goto L17;
        ensureScrollAnimator();
        this.scrollAnimator.setIntValues(new int[]{r0, r2});
        this.scrollAnimator.start();
        goto L18
    L17:
        scrollTo(r2, 0);
        goto L18
    }

    private int calculateScrollXForTab(int r4, float r5) {
        int r1 = 0;
        if (this.mode != 0) goto L21;
        View r0 = this.slidingTabIndicator.getChildAt(r4);
        int r6 = r4 + 1;
        if (r6 >= this.slidingTabIndicator.getChildCount()) goto L7;
        View r7 = this.slidingTabIndicator.getChildAt(r6);
    L8:
        if (r0 == null) goto L10;
        int r2 = r0.getWidth();
    L11:
        if (r7 == null) goto L13;
        int r8 = r7.getWidth();
    L14:
        if (r0 == null) goto L16;
        r1 = r0.getLeft();
    L16:
        int r3 = (r1 + (r2 / 2)) - (getWidth() / 2);
        int r9 = (int) (((r2 + r8) * 0.5f) * r5);
        if (ViewCompat.getLayoutDirection(this) != 0) goto L20;
        return r3 + r9;
    L20:
        return r3 - r9;
    L13:
        r8 = 0;
        goto L14
    L10:
        r2 = 0;
        goto L11
    L7:
        r7 = null;
        goto L8
    L21:
        return 0;
    }

    private void configureTab(Tab r2, int r3) {
        r2.setPosition(r3);
        ListProtector.add(this.tabs, r3, r2);
        int r4 = this.tabs.size();
    L3:
        r3 = r3 + 1;
        if (r3 >= r4) goto L6;
        ((Tab) ListProtector.get(this.tabs, r3)).setPosition(r3);
        goto L3
    }

    private static ColorStateList createColorStateList(int r4, int r5) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r5, r4});
    }

    private void dispatchTabSelected(Tab r3, boolean r4) {
        int r0 = this.selectedListeners.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((BaseOnTabSelectedListener) ListProtector.get(this.selectedListeners, r0)).onTabSelected(r3);
        ((BaseOnTabSelectedListener) ListProtector.get(this.selectedListeners, r0)).onTabSelected(r3, r4);
        r0 = r0 - 1;
        goto L3
    }

    public void addTab(Tab r2, int r3) {
        addTab(r2, r3, this.tabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2) {
        addViewInternal(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r6, int r7) {
        int r0 = (dpToPx(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r1 = View.MeasureSpec.getMode(r7);
        if (r1 == Integer.MIN_VALUE) goto L7;
        if (r1 != 0) goto L8;
        r7 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
    L8:
        int r2 = View.MeasureSpec.getSize(r6);
        if (View.MeasureSpec.getMode(r6) == 0) goto L15;
        int r3 = this.requestedTabMaxWidth;
        if (r3 > 0) goto L14;
        r3 = r2 - dpToPx(TAB_MIN_WIDTH_MARGIN);
    L14:
        this.tabMaxWidth = r3;
    L15:
        super.onMeasure(r6, r7);
        boolean r4 = true;
        if (getChildCount() != 1) goto L32;
        boolean r8 = false;
        View r5 = getChildAt(0);
        int r9 = this.mode;
        if (r9 == 0) goto L25;
        if (r9 == 1) goto L22;
    L29:
        if (r8 == false) goto L33;
        int r10 = HorizontalScrollView.getChildMeasureSpec(r7, getPaddingTop() + getPaddingBottom(), r5.getLayoutParams().height);
        r5.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), r10);
        return;
    L33:
        return;
    L22:
        if (r5.getMeasuredWidth() != getMeasuredWidth()) goto L28;
    L27:
        r4 = false;
    L28:
        r8 = r4;
        goto L29
    L25:
        if (r5.getMeasuredWidth() >= getMeasuredWidth()) goto L27;
    L32:
        return;
    L7:
        r7 = View.MeasureSpec.makeMeasureSpec(Math.min(r0, View.MeasureSpec.getSize(r7)), 1073741824);
        goto L8
    }

    public void selectTab(Tab r2, boolean r3) {
        selectTab(r2, true, r3, true);
    }

    void setPagerAdapter(PagerAdapter r3, boolean r4) {
        PagerAdapter r0 = this.pagerAdapter;
        if (r0 == null) goto L7;
        DataSetObserver r1 = this.pagerAdapterObserver;
        if (r1 == null) goto L7;
        r0.unregisterDataSetObserver(r1);
    L7:
        this.pagerAdapter = r3;
        if (r4 == false) goto L15;
        if (r3 != null) goto L11;
        return;
    L11:
        if (this.pagerAdapterObserver != null) goto L13;
        this.pagerAdapterObserver = new PagerAdapterObserver(this);
    L13:
        r3.registerDataSetObserver(this.pagerAdapterObserver);
        return;
    }

    public void setTabTextColors(int r1, int r2) {
        setTabTextColors(createColorStateList(r1, r2));
    }

    public void setupWithViewPager(ViewPager r2, boolean r3) {
        setupWithViewPager(r2, r3, false);
    }

    public void addTab(Tab r2, boolean r3) {
        addTab(r2, this.tabs.size(), r3);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r1, ViewGroup.LayoutParams r2) {
        addViewInternal(r1);
    }

    public ECTabLayout(Context r27, AttributeSet r28, int r29) {
        super(r27, r28, r29);
        this.defaultUnSelected = false;
        this.indicatorBottomMargin = 0;
        this.tabs = new ArrayList();
        this.tabViewContentBounds = new RectF();
        this.tabMaxWidth = Integer.MAX_VALUE;
        this.selectedListeners = new ArrayList();
        this.needHideIndicatorWhenSingleTab = false;
        this.tabViewPool = new Pools.SimplePool(12);
        this.needBindListener = true;
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator r2 = new SlidingTabIndicator(this, r27);
        this.slidingTabIndicator = r2;
        super.addView(r2, 0, new FrameLayout.LayoutParams(-2, -1));
        int r14 = 5;
        int r9 = 9;
        int r12 = 8;
        int r15 = 25;
        int r13 = 10;
        TypedArray r3 = ThemeEnforcement.obtainStyledAttributes(r27, r28, new int[]{2130974357, 2130974358, 2130974359, 2130974360, 2130974361, 2130974362, 2130974363, 2130974364, 2130974365, 2130974366, 2130974367, 2130974370, 2130974371, 2130974372, 2130974373, 2130974375, 2130974376, 2130974377, 2130974378, 2130974379, 2130974380, 2130974381, 2130974383, 2130974384, 2130974385}, r29, 2131954019, new int[]{22});     // Catch: Exception -> L22
    L9:
        this.slidingTabIndicator.setSelectedIndicatorHeight(r3.getDimensionPixelSize(r13, -1));
        this.slidingTabIndicator.setSelectedIndicatorColor(r3.getColor(7, 0));
        setSelectedTabIndicator(MaterialResources.getDrawable(r27, r3, r14));
        setSelectedTabIndicatorGravity(r3.getInt(r9, 0));
        setTabIndicatorFullWidth(r3.getBoolean(r12, true));
        int r4 = r3.getDimensionPixelSize(15, 0);
        this.tabPaddingBottom = r4;
        this.tabPaddingEnd = r4;
        this.tabPaddingTop = r4;
        this.tabPaddingStart = r4;
        this.tabPaddingStart = r3.getDimensionPixelSize(18, r4);
        this.tabPaddingTop = r3.getDimensionPixelSize(19, this.tabPaddingTop);
        this.tabPaddingEnd = r3.getDimensionPixelSize(17, this.tabPaddingEnd);
        this.tabPaddingBottom = r3.getDimensionPixelSize(16, this.tabPaddingBottom);
        int r5 = r3.getResourceId(22, 2131953595);
        this.tabTextAppearance = r5;
        TypedArray r6 = r27.obtainStyledAttributes(r5, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, 2130970118, 2130970129, 2130974497, 2130974532});
        this.tabTextSize = r6.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L19
        this.tabTextColors = MaterialResources.getColorStateList(r27, r6, 3);     // Catch: Throwable -> L19
        r6.recycle();
        if (r3.hasValue(23) == false) goto L15;
        this.tabTextColors = MaterialResources.getColorStateList(r27, r3, 23);
    L15:
        if (r3.hasValue(21) == false) goto L17;
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), r3.getColor(21, 0));
    L17:
        this.tabIconTint = MaterialResources.getColorStateList(r27, r3, 3);
        this.tabIconTintMode = ViewUtils.parseTintMode(r3.getInt(4, -1), null);
        this.tabRippleColorStateList = MaterialResources.getColorStateList(r27, r3, 20);
        this.tabIndicatorAnimationDuration = r3.getInt(6, ANIMATION_DURATION);
        this.requestedTabMinWidth = r3.getDimensionPixelSize(13, -1);
        this.requestedTabMaxWidth = r3.getDimensionPixelSize(12, -1);
        this.tabBackgroundResId = r3.getResourceId(0, 0);
        this.contentInsetStart = r3.getDimensionPixelSize(1, 0);
        this.mode = r3.getInt(14, 1);
        this.tabGravity = r3.getInt(2, 0);
        this.inlineLabel = r3.getBoolean(11, false);
        this.unboundedRipple = r3.getBoolean(MIN_INDICATOR_WIDTH, false);
        r3.recycle();
        Resources r0 = getResources();
        this.tabTextMultiLineSize = r0.getDimensionPixelSize(2131165822);
        this.scrollableTabMinWidth = r0.getDimensionPixelSize(2131165820);
        applyModeAndGravity();
        return;
    L19:
        th = move-exception;
        r6.recycle();
        throw th;
    L8:
        int[] r7 = new int[r15];
        r7 = {x0252: FILL_ARRAY_DATA  (LINE:50332242), data: [2130974357, 2130974358, 2130974359, 2130974360, 2130974361, 2130974362, 2130974363, 2130974364, 2130974365, 2130974366, 2130974367, 2130974370, 2130974371, 2130974372, 2130974373, 2130974375, 2130974376, 2130974377, 2130974378, 2130974379, 2130974380, 2130974381, 2130974383, 2130974384, 2130974385} // fill-array;
        r3 = r27.obtainStyledAttributes(r28, r7);
    L7:
        r9 = 9;
        r12 = 8;
        r13 = 10;
        r14 = 5;
        r15 = 25;
        goto L8
    }

    private void setupWithViewPager(ViewPager r3, boolean r4, boolean r5) {
        ViewPager r0 = this.viewPager;
        if (r0 == null) goto L10;
        TabLayoutOnPageChangeListener r1 = this.pageChangeListener;
        if (r1 == null) goto L7;
        r0.removeOnPageChangeListener(r1);
    L7:
        AdapterChangeListener r2 = this.adapterChangeListener;
        if (r2 == null) goto L10;
        this.viewPager.removeOnAdapterChangeListener(r2);
    L10:
        BaseOnTabSelectedListener r6 = this.currentVpSelectedListener;
        if (r6 == null) goto L13;
        removeOnTabSelectedListener(r6);
        this.currentVpSelectedListener = null;
    L13:
        if (r3 == null) goto L27;
        this.viewPager = r3;
        if (this.needBindListener == true) goto L17;
    L20:
        PagerAdapter r7 = r3.getAdapter();
        if (r7 == null) goto L24;
        setPagerAdapter(r7, r4);
    L24:
        if (this.adapterChangeListener != null) goto L26;
        this.adapterChangeListener = new AdapterChangeListener(this);
    L26:
        this.adapterChangeListener.setAutoRefresh(r4);
        r3.addOnAdapterChangeListener(this.adapterChangeListener);
        setScrollPosition(r3.getCurrentItem(), 0.0f, true);
    L28:
        this.setupViewPagerImplicitly = r5;
        return;
    L17:
        if (this.pageChangeListener != null) goto L19;
        this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
    L19:
        this.pageChangeListener.reset();
        r3.addOnPageChangeListener(this.pageChangeListener);
        ViewPagerOnTabSelectedListener r8 = new ViewPagerOnTabSelectedListener(r3);
        this.currentVpSelectedListener = r8;
        addOnTabSelectedListener(r8);
        goto L20
    L27:
        this.viewPager = null;
        setPagerAdapter(null, false);
        goto L28
    }

    public void addTab(Tab r2, int r3, boolean r4) {
        if (r2.parent != this) goto L9;
        configureTab(r2, r3);
        addTabView(r2);
        if (r4 == false) goto L10;
        r2.select(false);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        addViewInternal(r1);
    }

    public void setScrollPosition(int r2, float r3, boolean r4) {
        setScrollPosition(r2, r3, r4, true);
    }

    @Override // android.view.View
    public void onScrollChanged(int r7, int r8, int r9, int r10) {
        super.onScrollChanged(r7, r8, r9, r10);
        OnScrollChangeListener r0 = this.onScrollChangeListener;
        if (r0 == null) goto L6;
        r0.onScrollChange(this, r7, r8, r9, r10);
        return;
    }

    public void selectTab(Tab r4, boolean r5, boolean r6, boolean r7) {
        Tab r0 = this.selectedTab;
        if (r0 != r4) goto L7;
        if (r0 == null) goto L26;
        dispatchTabReselected(r4);
        animateToTab(r4.getPosition(), r7);
        return;
    L26:
        return;
    L7:
        if (r4 == null) goto L9;
        int r1 = r4.getPosition();
    L10:
        if (r5 == true) goto L12;
    L20:
        this.selectedTab = r4;
        if (r0 == null) goto L23;
        dispatchTabUnselected(r0);
    L23:
        if (r4 == null) goto L28;
        dispatchTabSelected(r4, r6);
        return;
    L28:
        return;
    L12:
        if (r0 != null) goto L14;
    L15:
        if (r1 == (-1)) goto L17;
        setScrollPosition(r1, 0.0f, true);
    L18:
        if (r1 == (-1)) goto L20;
        setSelectedTabView(r1);
    L17:
        animateToTab(r1, true);
        goto L18
    L14:
        if (r0.getPosition() != (-1)) goto L17;
    L9:
        r1 = -1;
        goto L10
    }

    public void setScrollPosition(int r3, float r4, boolean r5, boolean r6) {
        int r0 = Math.round(r3 + r4);
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= this.slidingTabIndicator.getChildCount()) goto L20;
        if (r6 == false) goto L9;
        this.slidingTabIndicator.setIndicatorPositionFromTabPosition(r3, r4);
    L9:
        ValueAnimator r7 = this.scrollAnimator;
        if (r7 != null) goto L12;
    L14:
        scrollTo(calculateScrollXForTab(r3, r4), 0);
        if (r5 == false) goto L19;
        setSelectedTabView(r0);
        return;
    L19:
        return;
    L12:
        if (r7.isRunning() == false) goto L14;
        this.scrollAnimator.cancel();
        goto L14
    }
}
