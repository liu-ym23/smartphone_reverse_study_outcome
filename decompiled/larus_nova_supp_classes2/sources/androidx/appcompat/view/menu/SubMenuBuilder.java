package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public String getActionViewStatesKey() {
        MenuItemImpl r0 = this.mItem;
        if (r0 == null) goto L5;
        int r1 = r0.getItemId();
    L6:
        if (r1 != 0) goto L10;
        return null;
    L10:
        return super.getActionViewStatesKey() + ":" + r1;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuBuilder getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean collapseItemActionView(MenuItemImpl r2) {
        return this.mParentMenu.collapseItemActionView(r2);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean expandItemActionView(MenuItemImpl r2) {
        return this.mParentMenu.expandItemActionView(r2);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setCallback(MenuBuilder.Callback r2) {
        this.mParentMenu.setCallback(r2);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setGroupDividerEnabled(boolean r2) {
        this.mParentMenu.setGroupDividerEnabled(r2);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int r1) {
        return (SubMenu) super.setHeaderIconInt(r1);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r1) {
        return (SubMenu) super.setHeaderTitleInt(r1);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r1) {
        return (SubMenu) super.setHeaderViewInt(r1);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r2) {
        this.mItem.setIcon(r2);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean r2) {
        this.mParentMenu.setQwertyMode(r2);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setShortcutsVisible(boolean r2) {
        this.mParentMenu.setShortcutsVisible(r2);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r1) {
        return (SubMenu) super.setHeaderIconInt(r1);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r1) {
        return (SubMenu) super.setHeaderTitleInt(r1);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r2) {
        this.mItem.setIcon(r2);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean dispatchMenuItemSelected(MenuBuilder r2, MenuItem r3) {
        if (super.dispatchMenuItemSelected(r2, r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mParentMenu.dispatchMenuItemSelected(r2, r3) == true) goto L8;
        return false;
    }

    public SubMenuBuilder(Context r1, MenuBuilder r2, MenuItemImpl r3) {
        super(r1);
        this.mParentMenu = r2;
        this.mItem = r3;
    }
}
