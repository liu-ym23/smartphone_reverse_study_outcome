package com.bytedance.ee.bear.core.toolbar;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class Toolbar extends Item {
    private ItemId.a[] supportedItems;

    public Toolbar() {
    }

    public boolean adminLimit(ItemId r7) {
        Item[] r0 = getChildren();
        int r1 = r0.length;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L8;
        Item r4 = r0[r2];
        if (r4.id() != r7) goto L7;
        r3 = r4.isAdminLimit();
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r3;
    }

    public boolean contains(ItemId r5) {
        Item[] r0 = getChildren();
        ItemId[] r1 = new ItemId[r0.length];
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L7;
        r1[r2] = r0[r2].id();
        r2 = r2 + 1;
        goto L4
    L7:
        return b(r5, r1);
    }

    public final void d(Item[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Item r2 = r5[r1];
        r2.setItemId(c(r2, this.supportedItems));
        d(r2.getChildren());
        r1 = r1 + 1;
        goto L3
    }

    public final void e(Item r6) {
        Item[] r7 = r6.getChildren();
        if (r7.length != 0) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        Item r3 = r7[r2];
        if ((r3.id() instanceof ItemId.ConstId) == true) goto L10;
        e(r3);
        r0.add(r3);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        setChildren(r0);
    }

    public void initFromJsBridge(ItemId.a[] r1) {
        this.supportedItems = r1;
        d(getChildren());
        e(this);
    }

    public void setItems(Item[] r1) {
        setChildren(r1);
    }

    public boolean supportSubToolbar(ItemId r1) {
        if (r1.children() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b(ItemId r5, ItemId[] r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        int r1 = r6.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        if (r5 == r6[r2]) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    L12:
        int r3 = r6.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L18;
        if (b(r5, r6[r4].children()) == true) goto L16;
        r4 = r4 + 1;
        goto L13
    L16:
        return true;
    L18:
        return false;
    }

    public static ItemId c(Item r6, ItemId[] r7) {
        if (r7 == null) goto L4;
        int r0 = r7.length;
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        ItemId r3 = r7[r2];
        if (r3.name().equals(r6.getId()) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return r3;
    L11:
        int r4 = r7.length;
    L12:
        if (r1 >= r4) goto L18;
        ItemId r5 = c(r6, r7[r1].children());
        if ((r5 instanceof ItemId.ConstId) == false) goto L15;
        r1 = r1 + 1;
        goto L12
    L15:
        return r5;
    L18:
        return ItemId.ConstId.unknown;
    L4:
        return ItemId.ConstId.unknown;
    }

    public static <T extends Toolbar> boolean equals(T r0, T r1) {
        if (r0 != null) goto L8;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r0.equals(r1);
    }
}
