package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.ThemeEnforcement;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class BottomNavigationView extends FrameLayout {
    private static final int MENU_PRESENTER_ID = 1;
    private final MenuBuilder menu;
    private MenuInflater menuInflater;
    private final BottomNavigationMenuView menuView;
    private final BottomNavigationPresenter presenter;
    private OnNavigationItemReselectedListener reselectedListener;
    private OnNavigationItemSelectedListener selectedListener;

    public interface OnNavigationItemReselectedListener {
        void onNavigationItemReselected(MenuItem r100);
    }

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem r100);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Bundle menuPresenterState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            readFromParcel(r100, r101);
        }

        private void readFromParcel(Parcel r100, ClassLoader r101) {
            this.menuPresenterState = r100.readBundle(r101);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeBundle(this.menuPresenterState);
        }
    }

    public int getMaxItemCount() {
        return 5;
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new SupportMenuInflater(getContext());
    L6:
        return this.menuInflater;
    }

    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.menuView.isItemHorizontalTranslationEnabled();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        Bundle r101 = new Bundle();
        r100.menuPresenterState = r101;
        this.menu.savePresenterStates(r101);
        return r100;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public BottomNavigationView(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ OnNavigationItemReselectedListener access$000(BottomNavigationView r100) {
        return r100.reselectedListener;
    }

    public static /* synthetic */ OnNavigationItemSelectedListener access$100(BottomNavigationView r100) {
        return r100.selectedListener;
    }

    private void addCompatibilityTopDivider(Context r100) {
        View r101 = new View(r100);
        r101.setBackgroundColor(ContextCompat.getColor(r100, R.color.design_bottom_navigation_shadow_color));
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(r101);
    }

    public void inflateMenu(int r100) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r100, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.menu.restorePresenterStates(r101.menuPresenterState);
    }

    public void setItemBackground(Drawable r100) {
        this.menuView.setItemBackground(r100);
    }

    public void setItemBackgroundResource(int r100) {
        this.menuView.setItemBackgroundRes(r100);
    }

    public void setItemHorizontalTranslationEnabled(boolean r100) {
        if (this.menuView.isItemHorizontalTranslationEnabled() == r100) goto L6;
        this.menuView.setItemHorizontalTranslationEnabled(r100);
        this.presenter.updateMenuView(false);
        return;
    }

    public void setItemIconSize(int r100) {
        this.menuView.setItemIconSize(r100);
    }

    public void setItemIconSizeRes(int r100) {
        setItemIconSize(getResources().getDimensionPixelSize(r100));
    }

    public void setItemIconTintList(ColorStateList r100) {
        this.menuView.setIconTintList(r100);
    }

    public void setItemTextAppearanceActive(int r100) {
        this.menuView.setItemTextAppearanceActive(r100);
    }

    public void setItemTextAppearanceInactive(int r100) {
        this.menuView.setItemTextAppearanceInactive(r100);
    }

    public void setItemTextColor(ColorStateList r100) {
        this.menuView.setItemTextColor(r100);
    }

    public void setLabelVisibilityMode(int r100) {
        if (this.menuView.getLabelVisibilityMode() == r100) goto L6;
        this.menuView.setLabelVisibilityMode(r100);
        this.presenter.updateMenuView(false);
        return;
    }

    public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener r100) {
        this.reselectedListener = r100;
    }

    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener r100) {
        this.selectedListener = r100;
    }

    public void setSelectedItemId(int r100) {
        MenuItem r101 = this.menu.findItem(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.menu.performItemAction(r101, this.presenter, 0) == true) goto L9;
        r101.setChecked(true);
        return;
    }

    public BottomNavigationView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        BottomNavigationPresenter r100 = new BottomNavigationPresenter();
        this.presenter = r100;
        BottomNavigationMenu r101 = new BottomNavigationMenu(r110);
        this.menu = r101;
        BottomNavigationMenuView r102 = new BottomNavigationMenuView(r110);
        this.menuView = r102;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        r102.setLayoutParams(r103);
        r100.setBottomNavigationMenuView(r102);
        r100.setId(1);
        r102.setPresenter(r100);
        this.menu.addMenuPresenter(this.presenter);
        r100.initForMenu(getContext(), r101);
        TintTypedArray r113 = ThemeEnforcement.obtainTintedStyledAttributes(r110, r111, new int[]{R.attr.elevation, R.attr.itemBackground, R.attr.itemHorizontalTranslationEnabled, R.attr.itemIconSize, R.attr.itemIconTint, R.attr.itemTextAppearanceActive, R.attr.itemTextAppearanceInactive, R.attr.itemTextColor, R.attr.labelVisibilityMode, R.attr.menu}, r112, R.style.Widget_Design_BottomNavigationView, new int[]{6, 5});
        if (r113.hasValue(4) == false) goto L5;
        r102.setIconTintList(r113.getColorStateList(4));
    L6:
        setItemIconSize(r113.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (r113.hasValue(6) == false) goto L10;
        setItemTextAppearanceInactive(r113.getResourceId(6, 0));
    L10:
        if (r113.hasValue(5) == false) goto L13;
        setItemTextAppearanceActive(r113.getResourceId(5, 0));
    L13:
        if (r113.hasValue(7) == false) goto L16;
        setItemTextColor(r113.getColorStateList(7));
    L16:
        if (r113.hasValue(0) == false) goto L18;
        ViewCompat.setElevation(this, r113.getDimensionPixelSize(0, 0));
    L18:
        setLabelVisibilityMode(r113.getInteger(8, -1));
        setItemHorizontalTranslationEnabled(r113.getBoolean(2, true));
        r102.setItemBackgroundRes(r113.getResourceId(1, 0));
        if (r113.hasValue(9) == false) goto L21;
        inflateMenu(r113.getResourceId(9, 0));
    L21:
        r113.recycle();
        addView(r102, r103);
        r101.setCallback(new AnonymousClass1(this));
        return;
    L5:
        r102.setIconTintList(r102.createDefaultColorStateList(android.R.attr.textColorSecondary));
        goto L6
    }
}
