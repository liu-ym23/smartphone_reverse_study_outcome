package com.bytedance.ee.bear.sheet.tab.jsdata;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: classes18.dex */
public class SheetModalPanelData implements NonProguard {
    private ModalItem[] items;
    private String title;

    public static class ModalItem implements NonProguard {
        private boolean enable;
        private String groupId;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f238377id;
        private boolean isShowLeftIcon;
        private RightIconsItem[] rightIcons;
        private String tableId;
        private String title;

        public String toString() {
            return "Item{enable=" + this.enable + ", id='" + this.f238377id + "', title='" + this.title + "', tableId='" + this.tableId + "', isShowLeftIcon=" + this.isShowLeftIcon + ", groupId=" + this.groupId + ", rightIcons=" + Arrays.toString(this.rightIcons) + '}';
        }

        public ModalItem() {
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getId() {
            return this.f238377id;
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

        public void setEnable(boolean r100) {
            this.enable = r100;
        }

        public void setGroupId(String r100) {
            this.groupId = r100;
        }

        public void setId(String r100) {
            this.f238377id = r100;
        }

        public void setRightIcons(RightIconsItem[] r100) {
            this.rightIcons = r100;
        }

        public void setShowLeftIcon(boolean r100) {
            this.isShowLeftIcon = r100;
        }

        public void setTableId(String r100) {
            this.tableId = r100;
        }

        public void setTitle(String r100) {
            this.title = r100;
        }

        public ModalItem(boolean r100, String r101, String r102, String r103, boolean r104) {
            this.enable = r100;
            this.f238377id = r101;
            this.title = r102;
            this.tableId = r103;
            this.isShowLeftIcon = r104;
        }
    }

    public static class RightIconsItem implements NonProguard {
        private boolean enable;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f238378id;

        public RightIconsItem() {
        }

        public String toString() {
            return "RightIconsItem{id='" + this.f238378id + "', enable=" + this.enable + '}';
        }

        public String getId() {
            return this.f238378id;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public void setEnable(boolean r100) {
            this.enable = r100;
        }

        public void setId(String r100) {
            this.f238378id = r100;
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

    public static boolean isValid(SheetModalPanelData r100) {
        if (r100 == null) goto L8;
        ModalItem[] r101 = r100.items;
        if (r101 == null) goto L8;
        if (r101.length <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public void setItems(ModalItem[] r100) {
        this.items = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
