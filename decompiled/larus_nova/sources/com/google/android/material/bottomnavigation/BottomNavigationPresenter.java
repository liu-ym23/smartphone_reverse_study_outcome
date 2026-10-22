package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* JADX INFO: loaded from: classes23.dex */
public class BottomNavigationPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f274674id;
    private MenuBuilder menu;
    private BottomNavigationMenuView menuView;
    private boolean updateSuspended;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int selectedItemId;

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r100) {
            this.selectedItemId = r100.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.selectedItemId);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r100, MenuItemImpl r101) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r100, MenuItemImpl r101) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r100, boolean r101) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r100) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r100) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState();
        r100.selectedItemId = this.menuView.getSelectedItemId();
        return r100;
    }

    public BottomNavigationPresenter() {
        this.updateSuspended = false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f274674id;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r100) {
        return this.menuView;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == false) goto L6;
        this.menuView.tryRestoreSelectedItemId(((SavedState) r100).selectedItemId);
        return;
    }

    public void setBottomNavigationMenuView(BottomNavigationMenuView r100) {
        this.menuView = r100;
    }

    public void setId(int r100) {
        this.f274674id = r100;
    }

    public void setUpdateSuspended(boolean r100) {
        this.updateSuspended = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r100) {
        if (this.updateSuspended == false) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        this.menuView.buildMenuView();
        return;
    L7:
        this.menuView.updateMenuView();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context r100, MenuBuilder r101) {
        this.menu = r101;
        this.menuView.initialize(r101);
    }
}
