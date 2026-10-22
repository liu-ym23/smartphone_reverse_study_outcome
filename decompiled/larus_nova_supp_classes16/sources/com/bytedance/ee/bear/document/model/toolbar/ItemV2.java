package com.bytedance.ee.bear.document.model.toolbar;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ItemV2 implements NonProguard {
    private boolean adminLimit;
    private Children children;
    private boolean enable;
    private String iconKey;
    private String id;
    private ItemIdV2 itemId;
    private String[] list;
    private boolean selected;
    private String value;

    public static class Children implements NonProguard {
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;
        private int count;
        private ItemV2[] items;
        private int orientationType;

        public int hashCode() {
            return (((Arrays.hashCode(this.items) * 31) + Objects.hashCode(Integer.valueOf(this.count))) * 31) + Objects.hashCode(Integer.valueOf(this.orientationType));
        }

        public boolean isHorizontal() {
            if (this.orientationType != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "Children{items=" + Arrays.toString(this.items) + ", count:" + this.count + ", orientationType" + this.orientationType + '}';
        }

        public Children() {
        }

        public int getCount() {
            return this.count;
        }

        public ItemV2[] getItems() {
            return this.items;
        }

        public int getOrientationType() {
            return this.orientationType;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L19;
            Children r6 = (Children) r5;
            if (Arrays.equals(this.items, r6.items) == true) goto L13;
        L17:
            return false;
        L13:
            if (this.count != r6.count) goto L17;
            if (this.orientationType != r6.orientationType) goto L17;
            return true;
        }

        public void setCount(int r1) {
            this.count = r1;
        }

        public void setItems(ItemV2[] r1) {
            this.items = r1;
        }

        public void setOrientationType(int r1) {
            this.orientationType = r1;
        }
    }

    public ItemV2[] getChildrenItems() {
        Children r0 = this.children;
        if (r0 == null) goto L9;
        if (r0.getItems() == null) goto L9;
        return this.children.getItems();
    L9:
        return new ItemV2[0];
    }

    public String getId() {
        String r0 = this.id;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public String getValue() {
        String r0 = this.value;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.itemId, this.value, Boolean.valueOf(this.enable), Boolean.valueOf(this.adminLimit), Boolean.valueOf(this.selected), this.children, this.list, this.iconKey});
    }

    public ItemIdV2 id() {
        ItemIdV2 r0 = this.itemId;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ItemIdV2.ConstId.unknown;
    }

    public int valueIndexInList() {
        return valueIndexInList(this.value);
    }

    public ItemV2() {
    }

    public Children getChildren() {
        return this.children;
    }

    public String getIconKey() {
        return this.iconKey;
    }

    public String[] getList() {
        return this.list;
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

    public ItemV2(ItemIdV2 r2) {
        this.id = r2.name();
        this.itemId = r2;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L31;
        ItemV2 r6 = (ItemV2) r5;
        if (this.enable == r6.enable) goto L13;
    L29:
        return false;
    L13:
        if (this.adminLimit != r6.adminLimit) goto L29;
        if (this.selected != r6.selected) goto L29;
        if (Objects.equals(this.id, r6.id) == false) goto L29;
        if (Objects.equals(this.itemId, r6.itemId) == false) goto L29;
        if (Objects.equals(this.value, r6.value) == false) goto L29;
        if (Arrays.equals(this.list, r6.list) == false) goto L29;
        if (Objects.equals(this.children, r6.children) == false) goto L29;
        if (Objects.equals(this.iconKey, r6.iconKey) == false) goto L29;
        return true;
    }

    public void setAdminLimit(boolean r1) {
        this.adminLimit = r1;
    }

    public void setChildren(Children r1) {
        this.children = r1;
    }

    public void setEnable(boolean r1) {
        this.enable = r1;
    }

    public void setIconKey(String r1) {
        this.iconKey = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setItemId(ItemIdV2 r1) {
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

    public int valueIndexInList(String r5) {
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

    public String nextValueInList(String r3, boolean r4) {
        int r0 = valueIndexInList(r3);
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
