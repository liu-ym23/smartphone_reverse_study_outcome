package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public class NavigationMenuView extends RecyclerView implements MenuView {
    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r100) {
    }

    public NavigationMenuView(Context r100) {
        this(r100, null);
    }

    public NavigationMenuView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public NavigationMenuView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setLayoutManager(new LinearLayoutManager(r100, 1, false));
    }
}
