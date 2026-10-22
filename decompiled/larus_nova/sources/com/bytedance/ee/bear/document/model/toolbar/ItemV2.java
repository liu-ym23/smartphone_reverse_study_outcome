package com.bytedance.ee.bear.document.model.toolbar;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class ItemV2 implements NonProguard {
    private boolean adminLimit;
    private Children children;
    private boolean enable;
    private String iconKey;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f220260id;
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

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L19;
            Children r101 = (Children) r100;
            if (Arrays.equals(this.items, r101.items) == true) goto L13;
        L17:
            return false;
        L13:
            if (this.count != r101.count) goto L17;
            if (this.orientationType != r101.orientationType) goto L17;
            return true;
        }

        public void setCount(int r100) {
            this.count = r100;
        }

        public void setItems(ItemV2[] r100) {
            this.items = r100;
        }

        public void setOrientationType(int r100) {
            this.orientationType = r100;
        }
    }

    public ItemV2[] getChildrenItems() {
        Children r100 = this.children;
        if (r100 == null) goto L9;
        if (r100.getItems() == null) goto L9;
        return this.children.getItems();
    L9:
        return new ItemV2[0];
    }

    public String getId() {
        String r100 = this.f220260id;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getValue() {
        String r100 = this.value;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f220260id, this.itemId, this.value, Boolean.valueOf(this.enable), Boolean.valueOf(this.adminLimit), Boolean.valueOf(this.selected), this.children, this.list, this.iconKey});
    }

    public ItemIdV2 id() {
        ItemIdV2 r100 = this.itemId;
        if (r100 == null) goto L5;
        return r100;
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
        return this.f220260id;
    }

    public ItemV2(ItemIdV2 r100) {
        this.f220260id = r100.name();
        this.itemId = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L31;
        ItemV2 r101 = (ItemV2) r100;
        if (this.enable == r101.enable) goto L13;
    L29:
        return false;
    L13:
        if (this.adminLimit != r101.adminLimit) goto L29;
        if (this.selected != r101.selected) goto L29;
        if (Objects.equals(this.f220260id, r101.f220260id) == false) goto L29;
        if (Objects.equals(this.itemId, r101.itemId) == false) goto L29;
        if (Objects.equals(this.value, r101.value) == false) goto L29;
        if (Arrays.equals(this.list, r101.list) == false) goto L29;
        if (Objects.equals(this.children, r101.children) == false) goto L29;
        if (Objects.equals(this.iconKey, r101.iconKey) == false) goto L29;
        return true;
    }

    public void setAdminLimit(boolean r100) {
        this.adminLimit = r100;
    }

    public void setChildren(Children r100) {
        this.children = r100;
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public void setId(String r100) {
        this.f220260id = r100;
    }

    public void setItemId(ItemIdV2 r100) {
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

    public int valueIndexInList(String r100) {
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

    public String nextValueInList(String r100, boolean r101) {
        int r102 = valueIndexInList(r100);
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
