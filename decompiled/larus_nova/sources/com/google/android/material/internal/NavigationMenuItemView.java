package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes23.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = null;
    private final AccessibilityDelegateCompat accessibilityDelegate;
    private FrameLayout actionArea;
    boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private final int iconSize;
    private ColorStateList iconTintList;
    private MenuItemImpl itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r100, char r101) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    private StateListDrawable createDefaultBackground() {
        TypedValue r100 = new TypedValue();
        if (getContext().getTheme().resolveAttribute(com.larus.nova.R.attr.colorControlHighlight, r100, true) == false) goto L6;
        StateListDrawable r101 = new StateListDrawable();
        r101.addState(CHECKED_STATE_SET, new ColorDrawable(r100.data));
        r101.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return r101;
    L6:
        return null;
    }

    private boolean shouldExpandActionArea() {
        if (this.itemData.getTitle() == null) goto L5;
    L9:
        return false;
    L5:
        if (this.itemData.getIcon() != null) goto L9;
        if (this.itemData.getActionView() == null) goto L9;
        return true;
    }

    public void recycle() {
        FrameLayout r100 = this.actionArea;
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea() == false) goto L7;
        this.textView.setVisibility(8);
        FrameLayout r100 = this.actionArea;
        if (r100 == null) goto L11;
        LinearLayoutCompat.LayoutParams r101 = (LinearLayoutCompat.LayoutParams) r100.getLayoutParams();
        ((LinearLayout.LayoutParams) r101).width = -1;
        this.actionArea.setLayoutParams(r101);
        return;
    L11:
        return;
    L7:
        this.textView.setVisibility(0);
        FrameLayout r102 = this.actionArea;
        if (r102 == null) goto L13;
        LinearLayoutCompat.LayoutParams r103 = (LinearLayoutCompat.LayoutParams) r102.getLayoutParams();
        ((LinearLayout.LayoutParams) r103).width = -2;
        this.actionArea.setLayoutParams(r103);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public NavigationMenuItemView(Context r100) {
        this(r100, null);
    }

    private void setActionView(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.actionArea != null) goto L6;
        this.actionArea = (FrameLayout) ((ViewStub) findViewById(com.larus.nova.R.id.design_menu_item_action_area_stub)).inflate();
    L6:
        this.actionArea.removeAllViews();
        this.actionArea.addView(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int r100) {
        int[] r101 = super.onCreateDrawableState(r100 + 1);
        MenuItemImpl r102 = this.itemData;
        if (r102 != null) goto L5;
    L9:
        return r101;
    L5:
        if (r102.isCheckable() == false) goto L9;
        if (this.itemData.isChecked() == false) goto L9;
        ViewGroup.mergeDrawableStates(r101, CHECKED_STATE_SET);
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r100) {
        refreshDrawableState();
        if (this.checkable == r100) goto L6;
        this.checkable = r100;
        this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r100) {
        refreshDrawableState();
        this.textView.setChecked(r100);
    }

    public void setHorizontalPadding(int r100) {
        setPadding(r100, 0, r100, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r100) {
        if (r100 == null) goto L13;
        if (this.hasIconTintList == false) goto L11;
        Drawable.ConstantState r101 = r100.getConstantState();
        if (r101 == null) goto L10;
        r100 = r101.newDrawable();
    L10:
        r100 = DrawableCompat.wrap(r100).mutate();
        DrawableCompat.setTintList(r100, this.iconTintList);
    L11:
        int r102 = this.iconSize;
        r100.setBounds(0, 0, r102, r102);
    L20:
        TextViewCompat.setCompoundDrawablesRelative(this.textView, r100, null, null, null);
        return;
    L13:
        if (this.needsEmptyIcon == false) goto L20;
        if (this.emptyDrawable != null) goto L19;
        Drawable r103 = ResourcesCompat.getDrawable(getResources(), com.larus.nova.R.drawable.navigation_empty_icon, getContext().getTheme());
        this.emptyDrawable = r103;
        if (r103 == null) goto L19;
        int r104 = this.iconSize;
        r103.setBounds(0, 0, r104, r104);
    L19:
        r100 = this.emptyDrawable;
        goto L20
    }

    public void setIconPadding(int r100) {
        this.textView.setCompoundDrawablePadding(r100);
    }

    public void setIconTintList(ColorStateList r100) {
        this.iconTintList = r100;
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        this.hasIconTintList = r101;
        MenuItemImpl r102 = this.itemData;
        if (r102 == null) goto L10;
        setIcon(r102.getIcon());
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setNeedsEmptyIcon(boolean r100) {
        this.needsEmptyIcon = r100;
    }

    public void setTextAppearance(int r100) {
        TextViewCompat.setTextAppearance(this.textView, r100);
    }

    public void setTextColor(ColorStateList r100) {
        this.textView.setTextColor(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r100) {
        this.textView.setText(r100);
    }

    public NavigationMenuItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r100, int r101) {
        this.itemData = r100;
        if (r100.isVisible() == false) goto L5;
        int r102 = 0;
    L6:
        setVisibility(r102);
        if (getBackground() != null) goto L9;
        ViewCompat.setBackground(this, createDefaultBackground());
    L9:
        setCheckable(r100.isCheckable());
        setChecked(r100.isChecked());
        setEnabled(r100.isEnabled());
        setTitle(r100.getTitle());
        setIcon(r100.getIcon());
        setActionView(r100.getActionView());
        setContentDescription(r100.getContentDescription());
        TooltipCompat.setTooltipText(this, r100.getTooltipText());
        adjustAppearance();
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public NavigationMenuItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        AccessibilityDelegateCompat r103 = new AnonymousClass1(this);
        this.accessibilityDelegate = r103;
        setOrientation(0);
        LayoutInflater.from(r100).inflate(com.larus.nova.R.layout.design_navigation_menu_item, this, true);
        this.iconSize = r100.getResources().getDimensionPixelSize(com.larus.nova.R.dimen.design_navigation_icon_size);
        CheckedTextView r104 = (CheckedTextView) findViewById(com.larus.nova.R.id.design_menu_item_text);
        this.textView = r104;
        r104.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(r104, r103);
    }
}
