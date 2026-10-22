package com.bytedance.ee.bear.core.toolbar;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public class Toolbar extends Item {
    private ItemId.a[] supportedItems;

    public Toolbar() {
    }

    public boolean adminLimit(ItemId r100) {
        Item[] r101 = getChildren();
        int r102 = r101.length;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 >= r102) goto L8;
        Item r105 = r101[r103];
        if (r105.id() != r100) goto L7;
        r104 = r105.isAdminLimit();
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r104;
    }

    public boolean contains(ItemId r100) {
        Item[] r101 = getChildren();
        ItemId[] r102 = new ItemId[r101.length];
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L7;
        r102[r103] = r101[r103].id();
        r103 = r103 + 1;
        goto L4
    L7:
        return b(r100, r102);
    }

    public final void d(Item[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Item r103 = r100[r102];
        r103.setItemId(c(r103, this.supportedItems));
        d(r103.getChildren());
        r102 = r102 + 1;
        goto L3
    }

    public final void e(Item r100) {
        Item[] r101 = r100.getChildren();
        if (r101.length != 0) goto L5;
        return;
    L5:
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        Item r105 = r101[r104];
        if ((r105.id() instanceof ItemId.ConstId) == true) goto L10;
        e(r105);
        r102.add(r105);
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        setChildren(r102);
    }

    public void initFromJsBridge(ItemId.a[] r100) {
        this.supportedItems = r100;
        d(getChildren());
        e(this);
    }

    public void setItems(Item[] r100) {
        setChildren(r100);
    }

    public boolean supportSubToolbar(ItemId r100) {
        if (r100.children() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b(ItemId r100, ItemId[] r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        if (r100 == r101[r103]) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        return true;
    L12:
        int r104 = r101.length;
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L18;
        if (b(r100, r101[r105].children()) == true) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        return true;
    L18:
        return false;
    }

    public static ItemId c(Item r100, ItemId[] r101) {
        if (r101 == null) goto L4;
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L11;
        ItemId r105 = r101[r104];
        if (r105.name().equals(r100.getId()) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return r105;
    L11:
        int r106 = r101.length;
    L12:
        if (r103 >= r106) goto L18;
        ItemId r107 = c(r100, r101[r103].children());
        if ((r107 instanceof ItemId.ConstId) == false) goto L15;
        r103 = r103 + 1;
        goto L12
    L15:
        return r107;
    L18:
        return ItemId.ConstId.unknown;
    L4:
        return ItemId.ConstId.unknown;
    }

    public static <T extends Toolbar> boolean equals(T r100, T r101) {
        if (r100 != null) goto L8;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r100.equals(r101);
    }
}
