package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.internal.TextScale;

/* JADX INFO: loaded from: classes23.dex */
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    private static final long ACTIVE_ANIMATION_DURATION_MS = 115;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] DISABLED_STATE_SET = null;
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private BottomNavigationItemView[] buttons;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private final Pools.Pool<BottomNavigationItemView> itemPool;
    private int itemTextAppearanceActive;
    private int itemTextAppearanceInactive;
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;
    private final View.OnClickListener onClickListener;
    private BottomNavigationPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;
    private final TransitionSet set;
    private int[] tempChildWidths;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    private boolean isShifting(int r100, int r101) {
        if (r100 == (-1)) goto L5;
        if (r100 == 0) goto L12;
    L9:
        return false;
    L12:
        return true;
    L5:
        if (r101 <= 3) goto L9;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView r100 = this.itemPool.acquire();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new BottomNavigationItemView(getContext());
    }

    public Drawable getItemBackground() {
        BottomNavigationItemView[] r100 = this.buttons;
        if (r100 == null) goto L9;
        if (r100.length <= 0) goto L9;
        return r100[0].getBackground();
    L9:
        return this.itemBackground;
    }

    public void updateMenuView() {
        MenuBuilder r100 = this.menu;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.buttons == null) goto L28;
        int r101 = r100.size();
        if (r101 == this.buttons.length) goto L11;
        buildMenuView();
        return;
    L11:
        int r102 = this.selectedItemId;
        int r103 = 0;
    L12:
        if (r103 >= r101) goto L18;
        MenuItem r104 = this.menu.getItem(r103);
        if (r104.isChecked() == false) goto L16;
        this.selectedItemId = r104.getItemId();
        this.selectedItemPosition = r103;
    L16:
        r103 = r103 + 1;
        goto L12
    L18:
        if (r102 == this.selectedItemId) goto L20;
        TransitionManager.beginDelayedTransition(this, this.set);
    L20:
        boolean r105 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r106 = 0;
    L21:
        if (r106 >= r101) goto L29;
        this.presenter.setUpdateSuspended(true);
        this.buttons[r106].setLabelVisibilityMode(this.labelVisibilityMode);
        this.buttons[r106].setShifting(r105);
        this.buttons[r106].initialize((MenuItemImpl) this.menu.getItem(r106), 0);
        this.presenter.setUpdateSuspended(false);
        r106 = r106 + 1;
        goto L21
    L29:
        return;
    }

    public void buildMenuView() {
        removeAllViews();
        BottomNavigationItemView[] r100 = this.buttons;
        if (r100 == null) goto L11;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L11;
        BottomNavigationItemView r103 = r100[r102];
        if (r103 == null) goto L9;
        this.itemPool.release(r103);
    L9:
        r102 = r102 + 1;
    L11:
        if (this.menu.size() != 0) goto L14;
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.buttons = null;
        return;
    L14:
        this.buttons = new BottomNavigationItemView[this.menu.size()];
        boolean r104 = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        int r105 = 0;
    L16:
        if (r105 >= this.menu.size()) goto L22;
        this.presenter.setUpdateSuspended(true);
        this.menu.getItem(r105).setCheckable(true);
        this.presenter.setUpdateSuspended(false);
        BottomNavigationItemView r106 = getNewItem();
        this.buttons[r105] = r106;
        r106.setIconTintList(this.itemIconTint);
        r106.setIconSize(this.itemIconSize);
        r106.setTextColor(this.itemTextColorDefault);
        r106.setTextAppearanceInactive(this.itemTextAppearanceInactive);
        r106.setTextAppearanceActive(this.itemTextAppearanceActive);
        r106.setTextColor(this.itemTextColorFromUser);
        Drawable r107 = this.itemBackground;
        if (r107 == null) goto L20;
        r106.setItemBackground(r107);
    L21:
        r106.setShifting(r104);
        r106.setLabelVisibilityMode(this.labelVisibilityMode);
        r106.initialize((MenuItemImpl) this.menu.getItem(r105), 0);
        r106.setItemPosition(r105);
        r106.setOnClickListener(this.onClickListener);
        addView(r106);
        r105 = r105 + 1;
        goto L16
    L20:
        r106.setItemBackground(this.itemBackgroundRes);
        goto L21
    L22:
        int r108 = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = r108;
        this.menu.getItem(r108).setChecked(true);
    }

    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    public int getItemIconSize() {
        return this.itemIconSize;
    }

    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    public BottomNavigationMenuView(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ BottomNavigationPresenter access$000(BottomNavigationMenuView r100) {
        return r100.presenter;
    }

    public static /* synthetic */ MenuBuilder access$100(BottomNavigationMenuView r100) {
        return r100.menu;
    }

    public ColorStateList createDefaultColorStateList(int r110) {
        TypedValue r100 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(r110, r100, true) == true) goto L5;
        return null;
    L5:
        ColorStateList r111 = AppCompatResources.getColorStateList(getContext(), r100.resourceId);
        if (getContext().getTheme().resolveAttribute(com.larus.nova.R.attr.colorPrimary, r100, true) == true) goto L8;
        return null;
    L8:
        int r101 = r100.data;
        int r102 = r111.getDefaultColor();
        int[] r103 = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{r103, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{r111.getColorForState(r103, r102), r101, r102});
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r100) {
        this.menu = r100;
    }

    public void setIconTintList(ColorStateList r100) {
        this.itemIconTint = r100;
        BottomNavigationItemView[] r101 = this.buttons;
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        r101[r103].setIconTintList(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackground(Drawable r100) {
        this.itemBackground = r100;
        BottomNavigationItemView[] r101 = this.buttons;
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        r101[r103].setItemBackground(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemBackgroundRes(int r100) {
        this.itemBackgroundRes = r100;
        BottomNavigationItemView[] r101 = this.buttons;
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        r101[r103].setItemBackground(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemHorizontalTranslationEnabled(boolean r100) {
        this.itemHorizontalTranslationEnabled = r100;
    }

    public void setItemIconSize(int r100) {
        this.itemIconSize = r100;
        BottomNavigationItemView[] r101 = this.buttons;
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        r101[r103].setIconSize(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public void setItemTextAppearanceActive(int r100) {
        this.itemTextAppearanceActive = r100;
        BottomNavigationItemView[] r101 = this.buttons;
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        BottomNavigationItemView r104 = r101[r103];
        r104.setTextAppearanceActive(r100);
        ColorStateList r105 = this.itemTextColorFromUser;
        if (r105 == null) goto L9;
        r104.setTextColor(r105);
    L9:
        r103 = r103 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextAppearanceInactive(int r100) {
        this.itemTextAppearanceInactive = r100;
        BottomNavigationItemView[] r101 = this.buttons;
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        BottomNavigationItemView r104 = r101[r103];
        r104.setTextAppearanceInactive(r100);
        ColorStateList r105 = this.itemTextColorFromUser;
        if (r105 == null) goto L9;
        r104.setTextColor(r105);
    L9:
        r103 = r103 + 1;
        goto L5
    L14:
        return;
    }

    public void setItemTextColor(ColorStateList r100) {
        this.itemTextColorFromUser = r100;
        BottomNavigationItemView[] r101 = this.buttons;
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        r101[r103].setTextColor(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public void setLabelVisibilityMode(int r100) {
        this.labelVisibilityMode = r100;
    }

    public void setPresenter(BottomNavigationPresenter r100) {
        this.presenter = r100;
    }

    public void tryRestoreSelectedItemId(int r100) {
        int r101 = this.menu.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        MenuItem r103 = this.menu.getItem(r102);
        if (r100 == r103.getItemId()) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        this.selectedItemId = r100;
        this.selectedItemPosition = r102;
        r103.setChecked(true);
        return;
    }

    public BottomNavigationMenuView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.itemPool = new Pools.SynchronizedPool(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        Resources r102 = getResources();
        this.inactiveItemMaxWidth = r102.getDimensionPixelSize(com.larus.nova.R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = r102.getDimensionPixelSize(com.larus.nova.R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = r102.getDimensionPixelSize(com.larus.nova.R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = r102.getDimensionPixelSize(com.larus.nova.R.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = r102.getDimensionPixelSize(com.larus.nova.R.dimen.design_bottom_navigation_height);
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        AutoTransition r103 = new AutoTransition();
        this.set = r103;
        r103.setOrdering(0);
        r103.setDuration(ACTIVE_ANIMATION_DURATION_MS);
        r103.setInterpolator(new FastOutSlowInInterpolator());
        r103.addTransition(new TextScale());
        this.onClickListener = new AnonymousClass1(this);
        this.tempChildWidths = new int[5];
    }

    @Override // android.view.View
    public void onMeasure(int r110, int r111) {
        int r112 = View.MeasureSpec.getSize(r110);
        int r113 = this.menu.getVisibleItems().size();
        int r100 = getChildCount();
        int r101 = View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
        int r102 = 1;
        if (isShifting(this.labelVisibilityMode, r113) == true) goto L5;
    L30:
        if (r113 == 0) goto L33;
        r102 = r113;
    L33:
        int r103 = Math.min(r112 / r102, this.activeItemMaxWidth);
        int r114 = r112 - (r113 * r103);
        int r115 = 0;
    L34:
        if (r115 >= r100) goto L42;
        if (getChildAt(r115).getVisibility() == 8) goto L40;
        int[] r104 = this.tempChildWidths;
        r104[r115] = r103;
        if (r114 <= 0) goto L41;
        r104[r115] = r103 + 1;
        r114 = r114 - 1;
    L41:
        r115 = r115 + 1;
        goto L34
    L40:
        this.tempChildWidths[r115] = 0;
    L42:
        int r116 = 0;
        int r117 = 0;
    L43:
        if (r116 >= r100) goto L49;
        View r105 = getChildAt(r116);
        if (r105.getVisibility() == 8) goto L48;
        r105.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[r116], 1073741824), r101);
        r105.getLayoutParams().width = r105.getMeasuredWidth();
        r117 = r117 + r105.getMeasuredWidth();
    L48:
        r116 = r116 + 1;
        goto L43
    L49:
        setMeasuredDimension(View.resolveSizeAndState(r117, View.MeasureSpec.makeMeasureSpec(r117, 1073741824), 0), View.resolveSizeAndState(this.itemHeight, r101, 0));
        return;
    L5:
        if (this.itemHorizontalTranslationEnabled == false) goto L30;
        View r106 = getChildAt(this.selectedItemPosition);
        int r107 = this.activeItemMinWidth;
        if (r106.getVisibility() == 8) goto L10;
        r106.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), r101);
        r107 = Math.max(r107, r106.getMeasuredWidth());
    L10:
        if (r106.getVisibility() == 8) goto L12;
        int r108 = 1;
    L13:
        int r118 = r113 - r108;
        int r109 = Math.min(r112 - (this.inactiveItemMinWidth * r118), Math.min(r107, this.activeItemMaxWidth));
        int r119 = r112 - r109;
        if (r118 == 0) goto L17;
        r102 = r118;
    L17:
        int r120 = Math.min(r119 / r102, this.inactiveItemMaxWidth);
        int r121 = r119 - (r118 * r120);
        int r122 = 0;
    L18:
        if (r122 >= r100) goto L42;
        if (getChildAt(r122).getVisibility() == 8) goto L28;
        int[] r123 = this.tempChildWidths;
        if (r122 != this.selectedItemPosition) goto L24;
        int r124 = r109;
    L25:
        r123[r122] = r124;
        if (r121 <= 0) goto L29;
        r123[r122] = r124 + 1;
        r121 = r121 - 1;
    L29:
        r122 = r122 + 1;
        goto L18
    L24:
        r124 = r120;
        goto L25
    L28:
        this.tempChildWidths[r122] = 0;
        goto L29
    L12:
        r108 = 0;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = r103 - r101;
        int r107 = r104 - r102;
        int r108 = 0;
        int r109 = 0;
    L3:
        if (r108 >= r105) goto L13;
        View r110 = getChildAt(r108);
        if (r110.getVisibility() == 8) goto L12;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L10;
        int r111 = r106 - r109;
        r110.layout(r111 - r110.getMeasuredWidth(), 0, r111, r107);
    L11:
        r109 = r109 + r110.getMeasuredWidth();
        goto L12
    L10:
        r110.layout(r109, 0, r110.getMeasuredWidth() + r109, r107);
    L12:
        r108 = r108 + 1;
        goto L3
    }
}
