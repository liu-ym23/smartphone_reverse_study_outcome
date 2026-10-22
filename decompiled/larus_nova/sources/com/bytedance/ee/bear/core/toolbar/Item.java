package com.bytedance.ee.bear.core.toolbar;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class Item implements BaseJSModel {
    private boolean adminLimit;
    private Item[] children;
    private boolean enable;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f217212id;
    private ItemId itemId;
    private String[] list;
    private boolean selected;
    private String value;

    public Item[] getChildren() {
        Item[] r100 = this.children;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new Item[0];
    }

    public String getId() {
        String r100 = this.f217212id;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String[] getList() {
        String[] r100 = this.list;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new String[0];
    }

    public String getValue() {
        String r100 = this.value;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public int hashCode() {
        String r100 = this.f217212id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ItemId r104 = this.itemId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.value;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((((((((((r106 + r101) * 31) + Arrays.hashCode(this.list)) * 31) + (this.enable ? 1 : 0)) * 31) + (this.selected ? 1 : 0)) * 31) + (this.adminLimit ? 1 : 0)) * 31) + Arrays.hashCode(this.children);
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public ItemId id() {
        ItemId r100 = this.itemId;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ItemId.ConstId.unknown;
    }

    public int valueIndexInList() {
        return a(this.value);
    }

    public Item() {
    }

    public boolean isAdminLimit() {
        return this.adminLimit;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public String toString() {
        return this.f217212id;
    }

    public Item(ItemId r100) {
        this.f217212id = r100.name();
        this.itemId = r100;
    }

    public final int a(String r100) {
        if (this.list == null) goto L14;
        if (r100 == null) goto L18;
        int r101 = 0;
    L7:
        String[] r102 = this.list;
        if (r101 >= r102.length) goto L13;
        if (r100.equals(r102[r101]) == true) goto L11;
        r101 = r101 + 1;
        goto L7
    L11:
        return r101;
    L13:
        return 0;
    L18:
        return -1;
    L14:
        return -1;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L48:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L48;
        Item r101 = (Item) r100;
        if (this.enable == r101.enable) goto L14;
        return false;
    L14:
        if (this.selected == r101.selected) goto L17;
        return false;
    L17:
        if (this.adminLimit == r101.adminLimit) goto L19;
        return false;
    L19:
        String r102 = this.f217212id;
        if (r102 == null) goto L25;
        if (r102.equals(r101.f217212id) == false) goto L26;
    L27:
        ItemId r103 = this.itemId;
        if (r103 == null) goto L33;
        if (r103.equals(r101.itemId) == false) goto L34;
    L35:
        String r104 = this.value;
        if (r104 == null) goto L41;
        if (r104.equals(r101.value) == true) goto L44;
    L42:
        return false;
    L44:
        if (Arrays.equals(this.list, r101.list) == true) goto L47;
        return false;
    L47:
        return Arrays.equals(this.children, r101.children);
    L41:
        if (r101.value == null) goto L44;
    L34:
        return false;
    L33:
        if (r101.itemId == null) goto L35;
    L26:
        return false;
    L25:
        if (r101.f217212id == null) goto L27;
        goto L26
    }

    public void setAdminLimit(boolean r100) {
        this.adminLimit = r100;
    }

    public void setChildren(List<Item> r100) {
        if (r100 != null) goto L4;
        this.children = null;
        return;
    L4:
        Item[] r101 = new Item[r100.size()];
        this.children = r101;
        r100.toArray(r101);
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setId(String r100) {
        this.f217212id = r100;
    }

    public void setItemId(ItemId r100) {
        this.itemId = r100;
    }

    public void setList(String[] r100) {
        this.list = r100;
    }

    public void setSelected(boolean r100) {
        this.selected = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }

    public void setChildren(Item[] r100) {
        this.children = r100;
    }

    public String nextValueInList(String r100, boolean r101) {
        int r102 = a(r100);
        if (r102 >= 0) goto L5;
        return r100;
    L5:
        if (r101 == false) goto L7;
        int r103 = r102 + 1;
    L8:
        String[] r104 = getList();
        if (r103 >= 0) goto L11;
        return r100;
    L11:
        if (r103 < r104.length) goto L13;
        return r100;
    L13:
        return r104[r103];
    L7:
        r103 = r102 - 1;
        goto L8
    }
}
