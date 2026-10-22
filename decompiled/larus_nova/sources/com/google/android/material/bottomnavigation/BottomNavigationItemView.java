package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

/* JADX INFO: loaded from: classes23.dex */
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {
    private static final int[] CHECKED_STATE_SET = null;
    public static final int INVALID_ITEM_POSITION = -1;
    private final int defaultMargin;
    private ImageView icon;
    private ColorStateList iconTint;
    private boolean isShifting;
    private MenuItemImpl itemData;
    private int itemPosition;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;

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

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public BottomNavigationItemView(Context r100) {
        this(r100, null);
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
        FrameLayout.mergeDrawableStates(r101, CHECKED_STATE_SET);
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r100) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r110) {
        TextView r100 = this.largeLabel;
        r100.setPivotX(r100.getWidth() / 2);
        TextView r101 = this.largeLabel;
        r101.setPivotY(r101.getBaseline());
        TextView r102 = this.smallLabel;
        r102.setPivotX(r102.getWidth() / 2);
        TextView r103 = this.smallLabel;
        r103.setPivotY(r103.getBaseline());
        int r104 = this.labelVisibilityMode;
        if (r104 == (-1)) goto L18;
        if (r104 != 0) goto L6;
        if (r110 == false) goto L15;
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
    L16:
        this.smallLabel.setVisibility(4);
    L26:
        refreshDrawableState();
        setSelected(r110);
        return;
    L15:
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        setViewValues(this.largeLabel, 0.5f, 0.5f, 4);
        goto L16
    L6:
        if (r104 == 1) goto L10;
        if (r104 != 2) goto L26;
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        this.largeLabel.setVisibility(8);
        this.smallLabel.setVisibility(8);
        goto L26
    L10:
        if (r110 == false) goto L12;
        setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
        setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r105 = this.smallLabel;
        float r106 = this.scaleUpFactor;
        setViewValues(r105, r106, r106, 4);
        goto L26
    L12:
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        TextView r107 = this.largeLabel;
        float r108 = this.scaleDownFactor;
        setViewValues(r107, r108, r108, 4);
        setViewValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L26
    L18:
        if (this.isShifting == false) goto L23;
        if (r110 == false) goto L21;
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
    L22:
        this.smallLabel.setVisibility(4);
        goto L26
    L21:
        setViewLayoutParams(this.icon, this.defaultMargin, 17);
        setViewValues(this.largeLabel, 0.5f, 0.5f, 4);
        goto L22
    L23:
        if (r110 == false) goto L25;
        setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
        setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
        TextView r109 = this.smallLabel;
        float r111 = this.scaleUpFactor;
        setViewValues(r109, r111, r111, 4);
        goto L26
    L25:
        setViewLayoutParams(this.icon, this.defaultMargin, 49);
        TextView r112 = this.largeLabel;
        float r113 = this.scaleDownFactor;
        setViewValues(r112, r113, r113, 4);
        setViewValues(this.smallLabel, 1.0f, 1.0f, 0);
        goto L26
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.smallLabel.setEnabled(r100);
        this.largeLabel.setEnabled(r100);
        this.icon.setEnabled(r100);
        if (r100 == false) goto L5;
        ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        return;
    L5:
        ViewCompat.setPointerIcon(this, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r100) {
        if (r100 == null) goto L8;
        Drawable.ConstantState r101 = r100.getConstantState();
        if (r101 == null) goto L7;
        r100 = r101.newDrawable();
    L7:
        r100 = DrawableCompat.wrap(r100).mutate();
        DrawableCompat.setTintList(r100, this.iconTint);
    L8:
        this.icon.setImageDrawable(r100);
    }

    public void setIconSize(int r100) {
        FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        r101.width = r100;
        r101.height = r100;
        this.icon.setLayoutParams(r101);
    }

    public void setIconTintList(ColorStateList r100) {
        this.iconTint = r100;
        MenuItemImpl r101 = this.itemData;
        if (r101 == null) goto L6;
        setIcon(r101.getIcon());
        return;
    }

    public void setItemBackground(int r100) {
        if (r100 != 0) goto L4;
        Drawable r101 = null;
    L5:
        setItemBackground(r101);
        return;
    L4:
        r101 = ContextCompat.getDrawable(getContext(), r100);
        goto L5
    }

    public void setItemPosition(int r100) {
        this.itemPosition = r100;
    }

    public void setLabelVisibilityMode(int r100) {
        if (this.labelVisibilityMode == r100) goto L11;
        this.labelVisibilityMode = r100;
        MenuItemImpl r101 = this.itemData;
        if (r101 == null) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L12;
        setChecked(r101.isChecked());
        return;
    L12:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public void setShifting(boolean r100) {
        if (this.isShifting == r100) goto L11;
        this.isShifting = r100;
        MenuItemImpl r101 = this.itemData;
        if (r101 == null) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L12;
        setChecked(r101.isChecked());
        return;
    L12:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public void setTextAppearanceActive(int r100) {
        TextViewCompat.setTextAppearance(this.largeLabel, r100);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(int r100) {
        TextViewCompat.setTextAppearance(this.smallLabel, r100);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(ColorStateList r100) {
        if (r100 == null) goto L5;
        this.smallLabel.setTextColor(r100);
        this.largeLabel.setTextColor(r100);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r100) {
        this.smallLabel.setText(r100);
        this.largeLabel.setText(r100);
        MenuItemImpl r101 = this.itemData;
        if (r101 != null) goto L5;
    L6:
        setContentDescription(r100);
        return;
    L5:
        if (TextUtils.isEmpty(r101.getContentDescription()) == true) goto L6;
    }

    public void setItemBackground(Drawable r100) {
        ViewCompat.setBackground(this, r100);
    }

    public BottomNavigationItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    private void calculateTextScaleFactors(float r100, float r101) {
        this.shiftAmount = r100 - r101;
        this.scaleUpFactor = (r101 * 1.0f) / r100;
        this.scaleDownFactor = (r100 * 1.0f) / r101;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r100, int r101) {
        this.itemData = r100;
        setCheckable(r100.isCheckable());
        setChecked(r100.isChecked());
        setEnabled(r100.isEnabled());
        setIcon(r100.getIcon());
        setTitle(r100.getTitle());
        setId(r100.getItemId());
        if (TextUtils.isEmpty(r100.getContentDescription()) == true) goto L5;
        setContentDescription(r100.getContentDescription());
    L5:
        TooltipCompat.setTooltipText(this, r100.getTooltipText());
        if (r100.isVisible() == false) goto L8;
        int r102 = 0;
    L9:
        setVisibility(r102);
        return;
    L8:
        r102 = 8;
        goto L9
    }

    public BottomNavigationItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.itemPosition = -1;
        Resources r103 = getResources();
        LayoutInflater.from(r100).inflate(com.larus.nova.R.layout.design_bottom_navigation_item, this, true);
        setBackgroundResource(com.larus.nova.R.drawable.design_bottom_navigation_item_background);
        this.defaultMargin = r103.getDimensionPixelSize(com.larus.nova.R.dimen.design_bottom_navigation_margin);
        this.icon = (ImageView) findViewById(com.larus.nova.R.id.icon);
        TextView r104 = (TextView) findViewById(com.larus.nova.R.id.smallLabel);
        this.smallLabel = r104;
        TextView r105 = (TextView) findViewById(com.larus.nova.R.id.largeLabel);
        this.largeLabel = r105;
        ViewCompat.setImportantForAccessibility(r104, 2);
        ViewCompat.setImportantForAccessibility(r105, 2);
        setFocusable(true);
        calculateTextScaleFactors(r104.getTextSize(), r105.getTextSize());
    }

    private void setViewLayoutParams(View r100, int r101, int r102) {
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r100.getLayoutParams();
        r103.topMargin = r101;
        r103.gravity = r102;
        r100.setLayoutParams(r103);
    }

    private void setViewValues(View r100, float r101, float r102, int r103) {
        r100.setScaleX(r101);
        r100.setScaleY(r102);
        r100.setVisibility(r103);
    }
}
