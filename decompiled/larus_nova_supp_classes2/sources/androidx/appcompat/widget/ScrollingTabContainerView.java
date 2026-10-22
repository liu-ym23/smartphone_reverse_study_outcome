package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.compose.material3.MenuKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator = null;
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private TabClickListener mTabClickListener;
    LinearLayoutCompat mTabLayout;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimator mVisibilityAnim;

    public class TabAdapter extends BaseAdapter {
        final /* synthetic */ ScrollingTabContainerView this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r3) {
            return r3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.this$0.mTabLayout.getChildCount();
        }

        public TabAdapter(ScrollingTabContainerView r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            return ((TabView) this.this$0.mTabLayout.getChildAt(r2)).getTab();
        }

        @Override // android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            if (r2 == null) goto L6;
            ((TabView) r2).bindTab((ActionBar.Tab) getItem(r1));
            return r2;
        L6:
            return this.this$0.createTabView((ActionBar.Tab) getItem(r1), true);
        }
    }

    public class TabClickListener implements View.OnClickListener {
        final /* synthetic */ ScrollingTabContainerView this$0;

        public TabClickListener(ScrollingTabContainerView r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r6) {
            ((TabView) r6).getTab().select();
            int r0 = this.this$0.mTabLayout.getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            View r3 = this.this$0.mTabLayout.getChildAt(r2);
            if (r3 != r6) goto L7;
            boolean r4 = true;
        L8:
            r3.setSelected(r4);
            r2 = r2 + 1;
            goto L3
        L7:
            r4 = false;
            goto L8
        }
    }

    public class TabView extends LinearLayout {
        private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
        private final int[] BG_ATTRS;
        private View mCustomView;
        private ImageView mIconView;
        private ActionBar.Tab mTab;
        private TextView mTextView;
        final /* synthetic */ ScrollingTabContainerView this$0;

        public void update() {
            ActionBar.Tab r0 = this.mTab;
            View r1 = r0.getCustomView();
            CharSequence r3 = null;
            if (r1 == null) goto L15;
            ViewParent r2 = r1.getParent();
            if (r2 == this) goto L9;
            if (r2 == null) goto L8;
            ((ViewGroup) r2).removeView(r1);
        L8:
            addView(r1);
        L9:
            this.mCustomView = r1;
            TextView r4 = this.mTextView;
            if (r4 == null) goto L12;
            r4.setVisibility(8);
        L12:
            ImageView r5 = this.mIconView;
            if (r5 == null) goto L44;
            r5.setVisibility(8);
            this.mIconView.setImageDrawable(null);
            return;
        L44:
            return;
        L15:
            View r6 = this.mCustomView;
            if (r6 == null) goto L18;
            removeView(r6);
            this.mCustomView = null;
        L18:
            Drawable r7 = r0.getIcon();
            CharSequence r8 = r0.getText();
            if (r7 != null) goto L21;
            ImageView r9 = this.mIconView;
            if (r9 == null) goto L27;
            r9.setVisibility(8);
            this.mIconView.setImageDrawable(null);
        L27:
            boolean r10 = !TextUtils.isEmpty(r8);
            if (r10 == true) goto L30;
            TextView r11 = this.mTextView;
            if (r11 == null) goto L36;
            r11.setVisibility(8);
            this.mTextView.setText(null);
        L36:
            ImageView r12 = this.mIconView;
            if (r12 == null) goto L39;
            r12.setContentDescription(r0.getContentDescription());
        L39:
            if (r10 == true) goto L42;
            r3 = r0.getContentDescription();
        L42:
            TooltipCompat.setTooltipText(this, r3);
            return;
        L30:
            if (this.mTextView != null) goto L32;
            AppCompatTextView r13 = new AppCompatTextView(getContext(), null, 2130968718);
            r13.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
            r14.gravity = 16;
            r13.setLayoutParams(r14);
            addView(r13);
            this.mTextView = r13;
        L32:
            this.mTextView.setText(r8);
            this.mTextView.setVisibility(0);
            goto L36
        L21:
            if (this.mIconView != null) goto L23;
            AppCompatImageView r15 = new AppCompatImageView(getContext());
            LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -2);
            r16.gravity = 16;
            r15.setLayoutParams(r16);
            addView(r15, 0);
            this.mIconView = r15;
        L23:
            this.mIconView.setImageDrawable(r7);
            this.mIconView.setVisibility(0);
            goto L27
        }

        public ActionBar.Tab getTab() {
            return this.mTab;
        }

        public void bindTab(ActionBar.Tab r1) {
            this.mTab = r1;
            update();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r2);
            r2.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
            super.onInitializeAccessibilityNodeInfo(r2);
            r2.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.view.View
        public void setSelected(boolean r2) {
            if (isSelected() == r2) goto L5;
            boolean r0 = true;
        L6:
            super.setSelected(r2);
            if (r0 == false) goto L11;
            if (r2 == false) goto L12;
            sendAccessibilityEvent(4);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r2, int r3) {
            super.onMeasure(r2, r3);
            if (this.this$0.mMaxTabWidth <= 0) goto L8;
            int r4 = getMeasuredWidth();
            int r0 = this.this$0.mMaxTabWidth;
            if (r4 <= r0) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r0, 1073741824), r3);
            return;
        L9:
            return;
        }

        public TabView(ScrollingTabContainerView r5, Context r6, ActionBar.Tab r7, boolean r8) {
            this.this$0 = r5;
            super(r6, null, 2130968717);
            int[] r1 = {R.attr.background};
            this.BG_ATTRS = r1;
            this.mTab = r7;
            TintTypedArray r9 = TintTypedArray.obtainStyledAttributes(r6, null, r1, 2130968717, 0);
            if (r9.hasValue(0) == false) goto L5;
            setBackgroundDrawable(r9.getDrawable(0));
        L5:
            r9.recycle();
            if (r8 == false) goto L8;
            setGravity(8388627);
        L8:
            update();
        }
    }

    public class VisibilityAnimListener extends AnimatorListenerAdapter {
        private boolean mCanceled;
        private int mFinalVisibility;
        final /* synthetic */ ScrollingTabContainerView this$0;

        public VisibilityAnimListener(ScrollingTabContainerView r1) {
            this.this$0 = r1;
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            ScrollingTabContainerView r3 = this.this$0;
            r3.mVisibilityAnim = null;
            r3.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            this.this$0.setVisibility(0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator r1, int r2) {
            this.mFinalVisibility = r2;
            this.this$0.mVisibilityAnim = r1;
            return this;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }

    static {
        sAlphaInterpolator = new DecelerateInterpolator();
    }

    private Spinner createSpinner() {
        AppCompatSpinner r0 = new AppCompatSpinner(getContext(), null, 2130968722);
        r0.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        r0.setOnItemSelectedListener(this);
        return r0;
    }

    private LinearLayoutCompat createTabLayout() {
        LinearLayoutCompat r0 = new LinearLayoutCompat(getContext(), null, 2130968716);
        r0.setMeasureWithLargestChildEnabled(true);
        r0.setGravity(17);
        r0.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return r0;
    }

    private boolean isCollapsed() {
        Spinner r0 = this.mTabSpinner;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getParent() != this) goto L7;
        return true;
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner r0 = this.mTabSpinner;
        if (r0 == null) goto L6;
        ((TabAdapter) r0.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    private void performCollapse() {
        if (isCollapsed() == false) goto L6;
        return;
    L6:
        if (this.mTabSpinner != null) goto L8;
        this.mTabSpinner = createSpinner();
    L8:
        removeView(this.mTabLayout);
        addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
        if (this.mTabSpinner.getAdapter() != null) goto L11;
        this.mTabSpinner.setAdapter(new TabAdapter(this));
    L11:
        Runnable r0 = this.mTabSelector;
        if (r0 == null) goto L14;
        removeCallbacks(r0);
        this.mTabSelector = null;
    L14:
        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }

    private boolean performExpand() {
        if (isCollapsed() == true) goto L5;
        return false;
    L5:
        removeView(this.mTabSpinner);
        addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable r0 = this.mTabSelector;
        if (r0 == null) goto L6;
        post(r0);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r0 = this.mTabSelector;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
        return;
    }

    public ScrollingTabContainerView(Context r4) {
        super(r4);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy r5 = ActionBarPolicy.get(r4);
        setContentHeight(r5.getTabContainerHeight());
        this.mStackedTabMaxWidth = r5.getStackedTabMaxWidth();
        LinearLayoutCompat r6 = createTabLayout();
        this.mTabLayout = r6;
        addView(r6, new ViewGroup.LayoutParams(-2, -1));
    }

    public void animateToTab(int r2) {
        final View r3 = this.mTabLayout.getChildAt(r2);
        Runnable r0 = this.mTabSelector;
        if (r0 == null) goto L5;
        removeCallbacks(r0);
    L5:
        Runnable r1 = new AnonymousClass1(this, r3);
        this.mTabSelector = r1;
        post(r1);
    }

    public void animateToVisibility(int r5) {
        ViewPropertyAnimator r0 = this.mVisibilityAnim;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r5 == 0) goto L8;
        ViewPropertyAnimator r2 = animate().alpha(MenuKt.ClosedAlphaTarget);
        r2.setDuration(200);
        r2.setInterpolator(sAlphaInterpolator);
        r2.setListener(this.mVisAnimListener.withFinalVisibility(r2, r5));
        r2.start();
        return;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(MenuKt.ClosedAlphaTarget);
    L10:
        ViewPropertyAnimator r3 = animate().alpha(1.0f);
        r3.setDuration(200);
        r3.setInterpolator(sAlphaInterpolator);
        r3.setListener(this.mVisAnimListener.withFinalVisibility(r3, r5));
        r3.start();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        ActionBarPolicy r3 = ActionBarPolicy.get(getContext());
        setContentHeight(r3.getTabContainerHeight());
        this.mStackedTabMaxWidth = r3.getStackedTabMaxWidth();
    }

    public void removeTabAt(int r2) {
        this.mTabLayout.removeViewAt(r2);
        Spinner r3 = this.mTabSpinner;
        if (r3 == null) goto L6;
        ((TabAdapter) r3.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void setAllowCollapse(boolean r1) {
        this.mAllowCollapse = r1;
    }

    public void setContentHeight(int r1) {
        this.mContentHeight = r1;
        requestLayout();
    }

    public void setTabSelected(int r6) {
        this.mSelectedTabIndex = r6;
        int r0 = this.mTabLayout.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        View r3 = this.mTabLayout.getChildAt(r2);
        if (r2 != r6) goto L7;
        boolean r4 = true;
    L8:
        r3.setSelected(r4);
        if (r4 == false) goto L11;
        animateToTab(r6);
    L11:
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = false;
        goto L8
    L12:
        Spinner r1 = this.mTabSpinner;
        if (r1 == null) goto L20;
        if (r6 < 0) goto L21;
        r1.setSelection(r6);
        return;
    L21:
        return;
    }

    public void updateTab(int r2) {
        ((TabView) this.mTabLayout.getChildAt(r2)).update();
        Spinner r3 = this.mTabSpinner;
        if (r3 == null) goto L6;
        ((TabAdapter) r3.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void addTab(ActionBar.Tab r6, boolean r7) {
        TabView r8 = createTabView(r6, false);
        this.mTabLayout.addView(r8, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner r0 = this.mTabSpinner;
        if (r0 == null) goto L5;
        ((TabAdapter) r0.getAdapter()).notifyDataSetChanged();
    L5:
        if (r7 == false) goto L8;
        r8.setSelected(true);
    L8:
        if (this.mAllowCollapse == false) goto L11;
        requestLayout();
        return;
    }

    public TabView createTabView(ActionBar.Tab r3, boolean r4) {
        TabView r0 = new TabView(this, getContext(), r3, r4);
        if (r4 == false) goto L5;
        r0.setBackgroundDrawable(null);
        r0.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
    L9:
        return r0;
    L5:
        r0.setFocusable(true);
        if (this.mTabClickListener != null) goto L8;
        this.mTabClickListener = new TabClickListener(this);
    L8:
        r0.setOnClickListener(this.mTabClickListener);
        goto L9
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r7, int r8) {
        int r9 = View.MeasureSpec.getMode(r7);
        boolean r0 = true;
        if (r9 != 1073741824) goto L5;
        boolean r3 = true;
    L6:
        setFillViewport(r3);
        int r4 = this.mTabLayout.getChildCount();
        if (r4 <= 1) goto L16;
        if (r9 == 1073741824) goto L12;
        if (r9 != Integer.MIN_VALUE) goto L16;
    L12:
        if (r4 <= 2) goto L14;
        this.mMaxTabWidth = (int) (View.MeasureSpec.getSize(r7) * 0.4f);
    L15:
        this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
    L17:
        int r10 = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (r3 == false) goto L20;
    L22:
        r0 = false;
    L23:
        if (r0 == false) goto L28;
        this.mTabLayout.measure(0, r10);
        if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(r7)) goto L27;
        performCollapse();
    L29:
        int r1 = getMeasuredWidth();
        super.onMeasure(r7, r10);
        int r11 = getMeasuredWidth();
        if (r3 == false) goto L34;
        if (r1 == r11) goto L35;
        setTabSelected(this.mSelectedTabIndex);
        return;
    L35:
        return;
    L34:
        return;
    L27:
        performExpand();
        goto L29
    L28:
        performExpand();
        goto L29
    L20:
        if (this.mAllowCollapse == false) goto L22;
    L14:
        this.mMaxTabWidth = View.MeasureSpec.getSize(r7) / 2;
    L16:
        this.mMaxTabWidth = -1;
        goto L17
    L5:
        r3 = false;
        goto L6
    }

    public void addTab(ActionBar.Tab r6, int r7, boolean r8) {
        TabView r9 = createTabView(r6, false);
        this.mTabLayout.addView(r9, r7, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner r10 = this.mTabSpinner;
        if (r10 == null) goto L5;
        ((TabAdapter) r10.getAdapter()).notifyDataSetChanged();
    L5:
        if (r8 == false) goto L8;
        r9.setSelected(true);
    L8:
        if (this.mAllowCollapse == false) goto L11;
        requestLayout();
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        ((TabView) r2).getTab().select();
    }
}
