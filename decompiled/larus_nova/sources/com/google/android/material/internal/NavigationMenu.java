package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes23.dex */
public class NavigationMenu extends MenuBuilder {
    public NavigationMenu(Context r100) {
        super(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int r100, int r101, int r102, CharSequence r103) {
        MenuItemImpl r104 = (MenuItemImpl) addInternal(r100, r101, r102, r103);
        NavigationSubMenu r105 = new NavigationSubMenu(getContext(), this, r104);
        r104.setSubMenu(r105);
        return r105;
    }
}
