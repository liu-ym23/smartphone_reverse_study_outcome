package com.bytedance.ee.bear.document.toolbar;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class Item implements BaseJSModel {
    private boolean adminLimit;
    private Item[] children;
    private boolean enable;
    private String id;
    private ItemId itemId;
    private String[] list;
    private boolean selected;
    private String value;

    public Item[] getChildren() {
        Item[] r0 = this.children;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new Item[0];
    }

    public String getId() {
        String r0 = this.id;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public String[] getList() {
        String[] r0 = this.list;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new String[0];
    }

    public String getValue() {
        String r0 = this.value;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ItemId r4 = this.itemId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.value;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return ((((((((((r6 + r1) * 31) + Arrays.hashCode(this.list)) * 31) + (this.enable ? 1 : 0)) * 31) + (this.selected ? 1 : 0)) * 31) + (this.adminLimit ? 1 : 0)) * 31) + Arrays.hashCode(this.children);
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public ItemId id() {
        ItemId r0 = this.itemId;
        if (r0 == null) goto L5;
        return r0;
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
        return this.id;
    }

    public Item(ItemId r2) {
        this.id = r2.name();
        this.itemId = r2;
    }

    public final int a(String r5) {
        if (this.list == null) goto L14;
        if (r5 == null) goto L18;
        int r1 = 0;
    L7:
        String[] r2 = this.list;
        if (r1 >= r2.length) goto L13;
        if (r5.equals(r2[r1]) == true) goto L11;
        r1 = r1 + 1;
        goto L7
    L11:
        return r1;
    L13:
        return 0;
    L18:
        return -1;
    L14:
        return -1;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L48:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L48;
        Item r5 = (Item) r4;
        if (this.enable == r5.enable) goto L14;
        return false;
    L14:
        if (this.selected == r5.selected) goto L17;
        return false;
    L17:
        if (this.adminLimit == r5.adminLimit) goto L19;
        return false;
    L19:
        String r1 = this.id;
        if (r1 == null) goto L25;
        if (r1.equals(r5.id) == false) goto L26;
    L27:
        ItemId r2 = this.itemId;
        if (r2 == null) goto L33;
        if (r2.equals(r5.itemId) == false) goto L34;
    L35:
        String r3 = this.value;
        if (r3 == null) goto L41;
        if (r3.equals(r5.value) == true) goto L44;
    L42:
        return false;
    L44:
        if (Arrays.equals(this.list, r5.list) == true) goto L47;
        return false;
    L47:
        return Arrays.equals(this.children, r5.children);
    L41:
        if (r5.value == null) goto L44;
    L34:
        return false;
    L33:
        if (r5.itemId == null) goto L35;
    L26:
        return false;
    L25:
        if (r5.id == null) goto L27;
        goto L26
    }

    public void setAdminLimit(boolean r1) {
        this.adminLimit = r1;
    }

    public void setChildren(List<Item> r2) {
        if (r2 != null) goto L4;
        this.children = null;
        return;
    L4:
        Item[] r0 = new Item[r2.size()];
        this.children = r0;
        r2.toArray(r0);
    }

    public void setEnable(boolean r1) {
        this.enable = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setItemId(ItemId r1) {
        this.itemId = r1;
    }

    public void setList(String[] r1) {
        this.list = r1;
    }

    public void setSelected(boolean r1) {
        this.selected = r1;
    }

    public void setValue(String r1) {
        this.value = r1;
    }

    public void setChildren(Item[] r1) {
        this.children = r1;
    }

    public String nextValueInList(String r3, boolean r4) {
        int r0 = a(r3);
        if (r0 >= 0) goto L5;
        return r3;
    L5:
        if (r4 == false) goto L7;
        int r1 = r0 + 1;
    L8:
        String[] r5 = getList();
        if (r1 >= 0) goto L11;
        return r3;
    L11:
        if (r1 < r5.length) goto L13;
        return r3;
    L13:
        return r5[r1];
    L7:
        r1 = r0 - 1;
        goto L8
    }
}
