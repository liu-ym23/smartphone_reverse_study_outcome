package com.bytedance.ee.bear.document.model.toolbar;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ToolbarV2 implements NonProguard {
    private ItemV2[] items;
    private String showingItemId;
    private int type;

    public boolean shouldShowSubToolbar() {
        ItemV2[] r0 = this.items;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.length <= 0) goto L13;
        ItemV2 r1 = r0[0];
        if (TextUtils.isEmpty(this.showingItemId) == false) goto L10;
        return false;
    L10:
        if (this.showingItemId.equals(r1.id().name()) == false) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public String toString() {
        return "ToolbarV2{items=" + Arrays.toString(this.items) + ", type=" + this.type + ", showingItemId='" + this.showingItemId + "'}";
    }

    public ToolbarV2() {
    }

    public ItemV2[] getItems() {
        return this.items;
    }

    public String getShowingItemId() {
        return this.showingItemId;
    }

    public int getType() {
        return this.type;
    }

    private void initIds(ItemIdV2.a[] r11) {
        ItemV2[] r0 = this.items;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length == 0) goto L22;
        int r1 = r0.length;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L23;
        ItemV2 r4 = r0[r3];
        ItemIdV2 r5 = findItemId(r4, r11);
        r4.setItemId(r5);
        ItemV2.Children r6 = r4.getChildren();
        if (r6 == null) goto L16;
        if (r6.getItems() == null) goto L16;
        ItemV2[] r7 = r6.getItems();
        int r8 = r7.length;
        int r9 = 0;
    L14:
        if (r9 >= r8) goto L16;
        ItemV2 r10 = r7[r9];
        r10.setItemId(findItemId(r10, r5.children()));
        r9 = r9 + 1;
    L16:
        r3 = r3 + 1;
        goto L8
    L23:
        return;
    }

    public boolean contains(ItemIdV2 r5) {
        ItemV2[] r0 = this.items;
        ItemIdV2[] r1 = new ItemIdV2[r0.length];
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L7;
        r1[r2] = r0[r2].id();
        r2 = r2 + 1;
        goto L4
    L7:
        return contains(r5, r1);
    }

    public void initFromJsBridge(ItemIdV2.a[] r1) {
        initIds(r1);
    }

    public void setItems(ItemV2[] r1) {
        this.items = r1;
    }

    public void setShowingItemId(String r1) {
        this.showingItemId = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public boolean supportSubToolbar(ItemIdV2 r2) {
        if (r2.displayMode() != ItemIdV2.DisplayMode.FunctionPanel) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean contains(ItemIdV2 r6, ItemIdV2[] r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        int r1 = r7.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        if (r6 == r7[r2]) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    L12:
        int r3 = r7.length;
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L18;
        if (contains(r6, r7[r4].children()) == true) goto L16;
        r4 = r4 + 1;
        goto L13
    L16:
        return true;
    L18:
        return false;
    }

    public static <T extends ToolbarV2> boolean equals(T r0, T r1) {
        if (r0 != null) goto L8;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r0.equals(r1);
    }

    private ItemIdV2 findItemId(ItemV2 r6, ItemIdV2[] r7) {
        if (r7 == null) goto L4;
        int r0 = r7.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L12;
        ItemIdV2 r2 = r7[r1];
        if (r2.name().equals(r6.getId()) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return r2;
    L12:
        return ItemIdV2.ConstId.unknown;
    L4:
        return ItemIdV2.ConstId.unknown;
    }
}
