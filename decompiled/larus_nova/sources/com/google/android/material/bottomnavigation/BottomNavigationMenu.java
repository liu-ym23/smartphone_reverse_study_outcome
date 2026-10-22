package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: loaded from: classes23.dex */
public final class BottomNavigationMenu extends MenuBuilder {
    public static final int MAX_ITEM_COUNT = 5;

    public BottomNavigationMenu(Context r100) {
        super(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuItem addInternal(int r100, int r101, int r102, CharSequence r103) {
        if ((size() + 1) > 5) goto L10;
        stopDispatchingItemsChanged();
        MenuItem r104 = super.addInternal(r100, r101, r102, r103);
        if ((r104 instanceof MenuItemImpl) == false) goto L7;
        ((MenuItemImpl) r104).setExclusiveCheckable(true);
    L7:
        startDispatchingItemsChanged();
        return r104;
    L10:
        throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int r100, int r101, int r102, CharSequence r103) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }
}
