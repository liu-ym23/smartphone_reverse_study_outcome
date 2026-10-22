package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;

/* JADX INFO: loaded from: classes23.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private final NavigationMenuPresenter presenter;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem r100);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public Bundle menuState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            this.menuState = r100.readBundle(r101);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeBundle(this.menuState);
        }
    }

    static {
        CHECKED_STATE_SET = new int[]{R.attr.state_checked};
        DISABLED_STATE_SET = new int[]{-16842910};
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater != null) goto L6;
        this.menuInflater = new SupportMenuInflater(getContext());
    L6:
        return this.menuInflater;
    }

    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        Bundle r101 = new Bundle();
        r100.menuState = r101;
        this.menu.savePresenterStates(r101);
        return r100;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public NavigationView(Context r100) {
        this(r100, null);
    }

    private ColorStateList createDefaultColorStateList(int r110) {
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
        return new ColorStateList(new int[][]{r103, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{r111.getColorForState(r103, r102), r101, r102});
    }

    public void addHeaderView(View r100) {
        this.presenter.addHeaderView(r100);
    }

    public View getHeaderView(int r100) {
        return this.presenter.getHeaderView(r100);
    }

    public View inflateHeaderView(int r100) {
        return this.presenter.inflateHeaderView(r100);
    }

    public void inflateMenu(int r100) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(r100, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public void onInsetsChanged(WindowInsetsCompat r100) {
        this.presenter.dispatchApplyWindowInsets(r100);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.menu.restorePresenterStates(r101.menuState);
    }

    public void removeHeaderView(View r100) {
        this.presenter.removeHeaderView(r100);
    }

    public void setCheckedItem(MenuItem r100) {
        MenuItem r101 = this.menu.findItem(r100.getItemId());
        if (r101 == null) goto L7;
        this.presenter.setCheckedItem((MenuItemImpl) r101);
        return;
    L7:
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public void setItemBackground(Drawable r100) {
        this.presenter.setItemBackground(r100);
    }

    public void setItemBackgroundResource(int r100) {
        setItemBackground(ContextCompat.getDrawable(getContext(), r100));
    }

    public void setItemHorizontalPadding(int r100) {
        this.presenter.setItemHorizontalPadding(r100);
    }

    public void setItemHorizontalPaddingResource(int r100) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(r100));
    }

    public void setItemIconPadding(int r100) {
        this.presenter.setItemIconPadding(r100);
    }

    public void setItemIconPaddingResource(int r100) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(r100));
    }

    public void setItemIconTintList(ColorStateList r100) {
        this.presenter.setItemIconTintList(r100);
    }

    public void setItemTextAppearance(int r100) {
        this.presenter.setItemTextAppearance(r100);
    }

    public void setItemTextColor(ColorStateList r100) {
        this.presenter.setItemTextColor(r100);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener r100) {
        this.listener = r100;
    }

    public void setCheckedItem(int r100) {
        MenuItem r101 = this.menu.findItem(r100);
        if (r101 == null) goto L6;
        this.presenter.setCheckedItem((MenuItemImpl) r101);
        return;
    }

    public NavigationView(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.navigationViewStyle);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        if (r102 == Integer.MIN_VALUE) goto L7;
        if (r102 != 0) goto L8;
        r100 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
    L8:
        super.onMeasure(r100, r101);
        return;
    L7:
        r100 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(r100), this.maxWidth), 1073741824);
        goto L8
    }

    public NavigationView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        NavigationMenuPresenter r100 = new NavigationMenuPresenter();
        this.presenter = r100;
        NavigationMenu r101 = new NavigationMenu(r110);
        this.menu = r101;
        TintTypedArray r113 = ThemeEnforcement.obtainTintedStyledAttributes(r110, r111, new int[]{R.attr.background, R.attr.fitsSystemWindows, R.attr.maxWidth, com.larus.nova.R.attr.elevation, com.larus.nova.R.attr.headerLayout, com.larus.nova.R.attr.itemBackground, com.larus.nova.R.attr.itemHorizontalPadding, com.larus.nova.R.attr.itemIconPadding, com.larus.nova.R.attr.itemIconTint, com.larus.nova.R.attr.itemTextAppearance, com.larus.nova.R.attr.itemTextColor, com.larus.nova.R.attr.menu}, r112, com.larus.nova.R.style.Widget_Design_NavigationView, new int[0]);
        ViewCompat.setBackground(this, r113.getDrawable(0));
        if (r113.hasValue(3) == false) goto L5;
        ViewCompat.setElevation(this, r113.getDimensionPixelSize(3, 0));
    L5:
        ViewCompat.setFitsSystemWindows(this, r113.getBoolean(1, false));
        this.maxWidth = r113.getDimensionPixelSize(2, 0);
        if (r113.hasValue(8) == false) goto L8;
        ColorStateList r102 = r113.getColorStateList(8);
    L10:
        if (r113.hasValue(9) == false) goto L12;
        int r103 = r113.getResourceId(9, 0);
        boolean r104 = true;
    L14:
        if (r113.hasValue(10) == false) goto L16;
        ColorStateList r105 = r113.getColorStateList(10);
    L17:
        if (r104 == true) goto L20;
        if (r105 != null) goto L20;
        r105 = createDefaultColorStateList(R.attr.textColorPrimary);
    L20:
        Drawable r106 = r113.getDrawable(5);
        if (r113.hasValue(6) == false) goto L23;
        r100.setItemHorizontalPadding(r113.getDimensionPixelSize(6, 0));
    L23:
        int r107 = r113.getDimensionPixelSize(7, 0);
        r101.setCallback(new AnonymousClass1(this));
        r100.setId(1);
        r100.initForMenu(r110, r101);
        r100.setItemIconTintList(r102);
        if (r104 == false) goto L26;
        r100.setItemTextAppearance(r103);
    L26:
        r100.setItemTextColor(r105);
        r100.setItemBackground(r106);
        r100.setItemIconPadding(r107);
        this.menu.addMenuPresenter(this.presenter);
        addView((View) r100.getMenuView(this));
        if (r113.hasValue(11) == false) goto L30;
        inflateMenu(r113.getResourceId(11, 0));
    L30:
        if (r113.hasValue(4) == false) goto L32;
        inflateHeaderView(r113.getResourceId(4, 0));
    L32:
        r113.recycle();
        return;
    L16:
        r105 = null;
        goto L17
    L12:
        r103 = 0;
        r104 = false;
        goto L14
    L8:
        r102 = createDefaultColorStateList(R.attr.textColorSecondary);
        goto L10
    }
}
