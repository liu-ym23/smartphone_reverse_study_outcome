package com.bytedance.ee.bear.sheet.tab.jsdata;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetModalPanelData implements NonProguard {
    private ModalItem[] items;
    private String title;

    public static class ModalItem implements NonProguard {
        private boolean enable;
        private String groupId;
        private String id;
        private boolean isShowLeftIcon;
        private RightIconsItem[] rightIcons;
        private String tableId;
        private String title;

        public String toString() {
            return "Item{enable=" + this.enable + ", id='" + this.id + "', title='" + this.title + "', tableId='" + this.tableId + "', isShowLeftIcon=" + this.isShowLeftIcon + ", groupId=" + this.groupId + ", rightIcons=" + Arrays.toString(this.rightIcons) + '}';
        }

        public ModalItem() {
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getId() {
            return this.id;
        }

        public RightIconsItem[] getRightIcons() {
            return this.rightIcons;
        }

        public String getTableId() {
            return this.tableId;
        }

        public String getTitle() {
            return this.title;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public boolean isShowLeftIcon() {
            return this.isShowLeftIcon;
        }

        public void setEnable(boolean r1) {
            this.enable = r1;
        }

        public void setGroupId(String r1) {
            this.groupId = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setRightIcons(RightIconsItem[] r1) {
            this.rightIcons = r1;
        }

        public void setShowLeftIcon(boolean r1) {
            this.isShowLeftIcon = r1;
        }

        public void setTableId(String r1) {
            this.tableId = r1;
        }

        public void setTitle(String r1) {
            this.title = r1;
        }

        public ModalItem(boolean r1, String r2, String r3, String r4, boolean r5) {
            this.enable = r1;
            this.id = r2;
            this.title = r3;
            this.tableId = r4;
            this.isShowLeftIcon = r5;
        }
    }

    public static class RightIconsItem implements NonProguard {
        private boolean enable;
        private String id;

        public RightIconsItem() {
        }

        public String toString() {
            return "RightIconsItem{id='" + this.id + "', enable=" + this.enable + '}';
        }

        public String getId() {
            return this.id;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public void setEnable(boolean r1) {
            this.enable = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }
    }

    public SheetModalPanelData() {
    }

    public String toString() {
        return "ModelViewData{title='" + this.title + "', items=" + Arrays.toString(this.items) + '}';
    }

    public ModalItem[] getItems() {
        return this.items;
    }

    public String getTitle() {
        return this.title;
    }

    public static boolean isValid(SheetModalPanelData r0) {
        if (r0 == null) goto L8;
        ModalItem[] r1 = r0.items;
        if (r1 == null) goto L8;
        if (r1.length <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public void setItems(ModalItem[] r1) {
        this.items = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
