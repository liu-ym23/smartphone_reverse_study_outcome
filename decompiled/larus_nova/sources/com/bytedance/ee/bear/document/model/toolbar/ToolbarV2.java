package com.bytedance.ee.bear.document.model.toolbar;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: classes16.dex */
public class ToolbarV2 implements NonProguard {
    private ItemV2[] items;
    private String showingItemId;
    private int type;

    public boolean shouldShowSubToolbar() {
        ItemV2[] r100 = this.items;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.length <= 0) goto L13;
        ItemV2 r101 = r100[0];
        if (TextUtils.isEmpty(this.showingItemId) == false) goto L10;
        return false;
    L10:
        if (this.showingItemId.equals(r101.id().name()) == false) goto L15;
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

    private void initIds(ItemIdV2.a[] r110) {
        ItemV2[] r100 = this.items;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length == 0) goto L22;
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L23;
        ItemV2 r103 = r100[r102];
        ItemIdV2 r104 = findItemId(r103, r110);
        r103.setItemId(r104);
        ItemV2.Children r105 = r103.getChildren();
        if (r105 == null) goto L16;
        if (r105.getItems() == null) goto L16;
        ItemV2[] r106 = r105.getItems();
        int r107 = r106.length;
        int r108 = 0;
    L14:
        if (r108 >= r107) goto L16;
        ItemV2 r109 = r106[r108];
        r109.setItemId(findItemId(r109, r104.children()));
        r108 = r108 + 1;
    L16:
        r102 = r102 + 1;
        goto L8
    L23:
        return;
    }

    public boolean contains(ItemIdV2 r100) {
        ItemV2[] r101 = this.items;
        ItemIdV2[] r102 = new ItemIdV2[r101.length];
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L7;
        r102[r103] = r101[r103].id();
        r103 = r103 + 1;
        goto L4
    L7:
        return contains(r100, r102);
    }

    public void initFromJsBridge(ItemIdV2.a[] r100) {
        initIds(r100);
    }

    public void setItems(ItemV2[] r100) {
        this.items = r100;
    }

    public void setShowingItemId(String r100) {
        this.showingItemId = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public boolean supportSubToolbar(ItemIdV2 r100) {
        if (r100.displayMode() != ItemIdV2.DisplayMode.FunctionPanel) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean contains(ItemIdV2 r100, ItemIdV2[] r101) {
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
        if (contains(r100, r101[r105].children()) == true) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        return true;
    L18:
        return false;
    }

    public static <T extends ToolbarV2> boolean equals(T r100, T r101) {
        if (r100 != null) goto L8;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r100.equals(r101);
    }

    private ItemIdV2 findItemId(ItemV2 r100, ItemIdV2[] r101) {
        if (r101 == null) goto L4;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        ItemIdV2 r104 = r101[r103];
        if (r104.name().equals(r100.getId()) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return r104;
    L12:
        return ItemIdV2.ConstId.unknown;
    L4:
        return ItemIdV2.ConstId.unknown;
    }
}
