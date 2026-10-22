package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* JADX INFO: loaded from: classes23.dex */
public class NavigationSubMenu extends SubMenuBuilder {
    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void onItemsChanged(boolean r100) {
        super.onItemsChanged(r100);
        ((MenuBuilder) getParentMenu()).onItemsChanged(r100);
    }

    public NavigationSubMenu(Context r100, NavigationMenu r101, MenuItemImpl r102) {
        super(r100, r101, r102);
    }
}
