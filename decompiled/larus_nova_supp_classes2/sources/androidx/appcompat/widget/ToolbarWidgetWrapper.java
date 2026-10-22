package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.compose.material3.MenuKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200;
    private static final String TAG = "ToolbarWidgetWrapper";
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    CharSequence mTitle;
    private boolean mTitleSet;
    Toolbar mToolbar;
    Window.Callback mWindowCallback;

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initIndeterminateProgress() {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initProgress() {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean r1) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    private int detectDisplayOptions() {
        if (this.mToolbar.getNavigationIcon() == null) goto L5;
        this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
        return 15;
    L5:
        return 11;
    }

    private void ensureSpinner() {
        if (this.mSpinner != null) goto L6;
        this.mSpinner = new AppCompatSpinner(getContext(), null, 2130968722);
        Toolbar.LayoutParams r0 = new Toolbar.LayoutParams(-2, -2, 8388627);
        this.mSpinner.setLayoutParams(r0);
        return;
    }

    private void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) != 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mHomeDescription) == false) goto L7;
        this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        return;
    L7:
        this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
    }

    private void updateNavigationIcon() {
        if ((this.mDisplayOpts & 4) == 0) goto L9;
        Toolbar r0 = this.mToolbar;
        Drawable r1 = this.mNavIcon;
        if (r1 != null) goto L8;
        r1 = this.mDefaultNavigationIcon;
    L8:
        r0.setNavigationIcon(r1);
        return;
    L9:
        this.mToolbar.setNavigationIcon(null);
    }

    private void updateToolbarLogo() {
        int r0 = this.mDisplayOpts;
        if ((r0 & 2) != 0) goto L5;
        Drawable r1 = null;
    L12:
        this.mToolbar.setLogo(r1);
        return;
    L5:
        if ((r0 & 1) == 0) goto L10;
        r1 = this.mLogo;
        if (r1 != null) goto L12;
        r1 = this.mIcon;
        goto L12
    L10:
        r1 = this.mIcon;
        goto L12
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        this.mToolbar.collapseActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return this.mToolbar.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownItemCount() {
        Spinner r0 = this.mSpinner;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCount();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        Spinner r0 = this.mSpinner;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getSelectedItemPosition();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getVisibility() {
        return this.mToolbar.getVisibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        if (this.mTabView == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasIcon() {
        if (this.mIcon == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasLogo() {
        if (this.mLogo == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isTitleTruncated() {
        return this.mToolbar.isTitleTruncated();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public View getCustomView() {
        return this.mCustomView;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    private void setTitleInt(CharSequence r2) {
        this.mTitle = r2;
        if ((this.mDisplayOpts & 8) == 0) goto L6;
        this.mToolbar.setTitle(r2);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int r3) {
        ViewPropertyAnimatorCompat r4 = setupAnimatorToVisibility(r3, DEFAULT_FADE_DURATION_MS);
        if (r4 == null) goto L6;
        r4.start();
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void restoreHierarchyState(SparseArray<Parcelable> r2) {
        this.mToolbar.restoreHierarchyState(r2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> r2) {
        this.mToolbar.saveHierarchyState(r2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable r2) {
        ViewCompat.setBackground(this.mToolbar, r2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean r2) {
        this.mToolbar.setCollapsible(r2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCustomView(View r3) {
        View r0 = this.mCustomView;
        if (r0 != null) goto L5;
    L7:
        this.mCustomView = r3;
        if (r3 != null) goto L10;
        return;
    L10:
        if ((this.mDisplayOpts & 16) == 0) goto L14;
        this.mToolbar.addView(r3);
        return;
    L14:
        return;
    L5:
        if ((this.mDisplayOpts & 16) == 0) goto L7;
        this.mToolbar.removeView(r0);
        goto L7
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int r2) {
        if (r2 != this.mDefaultNavigationContentDescription) goto L5;
        return;
    L5:
        this.mDefaultNavigationContentDescription = r2;
        if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription()) == false) goto L9;
        setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable r2) {
        if (this.mDefaultNavigationIcon == r2) goto L6;
        this.mDefaultNavigationIcon = r2;
        updateNavigationIcon();
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int r4) {
        int r0 = this.mDisplayOpts ^ r4;
        this.mDisplayOpts = r4;
        if (r0 != 0) goto L5;
        return;
    L5:
        if ((r0 & 4) == 0) goto L11;
        if ((r4 & 4) == 0) goto L9;
        updateHomeAccessibility();
    L9:
        updateNavigationIcon();
    L11:
        if ((r0 & 3) == 0) goto L14;
        updateToolbarLogo();
    L14:
        if ((r0 & 8) == 0) goto L20;
        if ((r4 & 8) == 0) goto L18;
        this.mToolbar.setTitle(this.mTitle);
        this.mToolbar.setSubtitle(this.mSubtitle);
        goto L20
    L18:
        this.mToolbar.setTitle(null);
        this.mToolbar.setSubtitle(null);
    L20:
        if ((r0 & 16) == 0) goto L29;
        View r1 = this.mCustomView;
        if (r1 != null) goto L24;
        return;
    L24:
        if ((r4 & 16) == 0) goto L26;
        this.mToolbar.addView(r1);
        return;
    L26:
        this.mToolbar.removeView(r1);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int r2) {
        Spinner r0 = this.mSpinner;
        if (r0 == null) goto L7;
        r0.setSelection(r2);
        return;
    L7:
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView r3) {
        View r0 = this.mTabView;
        if (r0 == null) goto L7;
        ViewParent r1 = r0.getParent();
        Toolbar r2 = this.mToolbar;
        if (r1 != r2) goto L7;
        r2.removeView(this.mTabView);
    L7:
        this.mTabView = r3;
        if (r3 != null) goto L10;
        return;
    L10:
        if (this.mNavigationMode != 2) goto L14;
        this.mToolbar.addView(r3, 0);
        Toolbar.LayoutParams r4 = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r4).width = -2;
        ((ViewGroup.MarginLayoutParams) r4).height = -2;
        r4.gravity = 8388691;
        r3.setAllowCollapse(true);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setIcon(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setLogo(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int r2) {
        if (r2 != 0) goto L4;
        String r3 = null;
    L5:
        setNavigationContentDescription(r3);
        return;
    L4:
        r3 = getContext().getString(r2);
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = AppCompatResources.getDrawable(getContext(), r2);
    L5:
        setNavigationIcon(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int r5) {
        int r0 = this.mNavigationMode;
        if (r5 != r0) goto L5;
        return;
    L5:
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L18;
        View r1 = this.mTabView;
        if (r1 == null) goto L18;
        ViewParent r2 = r1.getParent();
        Toolbar r3 = this.mToolbar;
        if (r2 != r3) goto L18;
        r3.removeView(this.mTabView);
    L18:
        this.mNavigationMode = r5;
        if (r5 != 0) goto L21;
        return;
    L21:
        if (r5 == 1) goto L28;
        if (r5 != 2) goto L27;
        View r6 = this.mTabView;
        if (r6 == null) goto L32;
        this.mToolbar.addView(r6, 0);
        Toolbar.LayoutParams r7 = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r7).width = -2;
        ((ViewGroup.MarginLayoutParams) r7).height = -2;
        r7.gravity = 8388691;
        return;
    L32:
        return;
    L27:
        throw new IllegalArgumentException("Invalid navigation mode " + r5);
    L28:
        ensureSpinner();
        this.mToolbar.addView(this.mSpinner, 0);
        return;
    L13:
        Spinner r4 = this.mSpinner;
        if (r4 == null) goto L18;
        ViewParent r8 = r4.getParent();
        Toolbar r9 = this.mToolbar;
        if (r8 != r9) goto L18;
        r9.removeView(this.mSpinner);
        goto L18
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setSubtitle(CharSequence r2) {
        this.mSubtitle = r2;
        if ((this.mDisplayOpts & 8) == 0) goto L6;
        this.mToolbar.setSubtitle(r2);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence r2) {
        this.mTitleSet = true;
        setTitleInt(r2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int r2) {
        this.mToolbar.setVisibility(r2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback r1) {
        this.mWindowCallback = r1;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence r2) {
        if (this.mTitleSet == true) goto L6;
        setTitleInt(r2);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable r1) {
        this.mIcon = r1;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(Drawable r1) {
        this.mLogo = r1;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence r1) {
        this.mHomeDescription = r1;
        updateHomeAccessibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable r1) {
        this.mNavIcon = r1;
        updateNavigationIcon();
    }

    public ToolbarWidgetWrapper(Toolbar r3, boolean r4) {
        this(r3, r4, 2131894040, 2131231136);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter r2, AdapterView.OnItemSelectedListener r3) {
        ensureSpinner();
        this.mSpinner.setAdapter(r2);
        this.mSpinner.setOnItemSelectedListener(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu r3, MenuPresenter.Callback r4) {
        if (this.mActionMenuPresenter != null) goto L5;
        ActionMenuPresenter r0 = new ActionMenuPresenter(this.mToolbar.getContext());
        this.mActionMenuPresenter = r0;
        r0.setId(2131362114);
    L5:
        this.mActionMenuPresenter.setCallback(r4);
        this.mToolbar.setMenu((MenuBuilder) r3, this.mActionMenuPresenter);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback r2, MenuBuilder.Callback r3) {
        this.mToolbar.setMenuCallbacks(r2, r3);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int r3, long r4) {
        ViewPropertyAnimatorCompat r0 = ViewCompat.animate(this.mToolbar);
        if (r3 != 0) goto L5;
        float r1 = 1.0f;
    L7:
        return r0.alpha(r1).setDuration(r4).setListener(new AnonymousClass2(this, r3));
    L5:
        r1 = MenuKt.ClosedAlphaTarget;
        goto L7
    }

    public ToolbarWidgetWrapper(Toolbar r4, boolean r5, int r6, int r7) {
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = r4;
        this.mTitle = r4.getTitle();
        this.mSubtitle = r4.getSubtitle();
        if (this.mTitle == null) goto L5;
        boolean r0 = true;
    L6:
        this.mTitleSet = r0;
        this.mNavIcon = r4.getNavigationIcon();
        TintTypedArray r8 = TintTypedArray.obtainStyledAttributes(r4.getContext(), null, new int[]{2130968899, 2130968904, 2130968905, 2130969620, 2130969621, 2130969622, 2130969623, 2130969624, 2130969625, 2130969710, 2130969757, 2130969758, 2130969940, 2130970198, 2130970208, 2130970261, 2130970262, 2130970280, 2130970332, 2130970410, 2130972601, 2130972815, 2130973585, 2130973620, 2130973621, 2130974326, 2130974330, 2130974574, 2130974592}, 2130968715, 0);
        this.mDefaultNavigationIcon = r8.getDrawable(15);
        if (r5 == false) goto L44;
        CharSequence r9 = r8.getText(27);
        if (TextUtils.isEmpty(r9) == true) goto L11;
        setTitle(r9);
    L11:
        CharSequence r10 = r8.getText(25);
        if (TextUtils.isEmpty(r10) == true) goto L14;
        setSubtitle(r10);
    L14:
        Drawable r11 = r8.getDrawable(20);
        if (r11 == null) goto L17;
        setLogo(r11);
    L17:
        Drawable r12 = r8.getDrawable(17);
        if (r12 == null) goto L21;
        setIcon(r12);
    L21:
        if (this.mNavIcon != null) goto L25;
        Drawable r13 = this.mDefaultNavigationIcon;
        if (r13 == null) goto L25;
        setNavigationIcon(r13);
    L25:
        setDisplayOptions(r8.getInt(10, 0));
        int r14 = r8.getResourceId(9, 0);
        if (r14 == 0) goto L28;
        setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(r14, this.mToolbar, false));
        setDisplayOptions(this.mDisplayOpts | 16);
    L28:
        int r15 = r8.getLayoutDimension(13, 0);
        if (r15 <= 0) goto L31;
        ViewGroup.LayoutParams r1 = this.mToolbar.getLayoutParams();
        r1.height = r15;
        this.mToolbar.setLayoutParams(r1);
    L31:
        int r16 = r8.getDimensionPixelOffset(7, -1);
        int r2 = r8.getDimensionPixelOffset(3, -1);
        if (r16 >= 0) goto L34;
        if (r2 >= 0) goto L34;
    L35:
        int r17 = r8.getResourceId(28, 0);
        if (r17 == 0) goto L38;
        Toolbar r3 = this.mToolbar;
        r3.setTitleTextAppearance(r3.getContext(), r17);
    L38:
        int r18 = r8.getResourceId(26, 0);
        if (r18 == 0) goto L41;
        Toolbar r19 = this.mToolbar;
        r19.setSubtitleTextAppearance(r19.getContext(), r18);
    L41:
        int r20 = r8.getResourceId(22, 0);
        if (r20 == 0) goto L45;
        this.mToolbar.setPopupTheme(r20);
    L45:
        r8.recycle();
        setDefaultNavigationContentDescription(r6);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new AnonymousClass1(this));
        return;
    L34:
        this.mToolbar.setContentInsetsRelative(Math.max(r16, 0), Math.max(r2, 0));
        goto L35
    L44:
        this.mDisplayOpts = detectDisplayOptions();
        goto L45
    L5:
        r0 = false;
        goto L6
    }
}
