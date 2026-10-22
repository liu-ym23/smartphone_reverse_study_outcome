package com.bytedance.ee.bear.document.model.toolbar.insertblock;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class InsertNewBlock implements NonProguard {
    private Children[] children;
    private String title;

    public static class ChildData implements NonProguard {
        private boolean adminLimit;
        private String backgroundColor;
        private String iconColor;
        private String iconId;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f220277id;
        private String name;
        private Boolean shouldShowInputMethodAfterClick;
        private boolean showBadge;

        public int hashCode() {
            return Objects.hash(new Object[]{this.f220277id, this.name, Boolean.valueOf(this.showBadge), Boolean.valueOf(this.adminLimit), this.iconId, this.shouldShowInputMethodAfterClick, this.backgroundColor, this.iconColor});
        }

        public String toString() {
            return "ChildData{id='" + this.f220277id + "', name='" + this.name + "', showBadge=" + this.showBadge + ", adminLimit=" + this.adminLimit + '}';
        }

        public ChildData() {
        }

        public String getBackgroundColor() {
            return this.backgroundColor;
        }

        public String getIconColor() {
            return this.iconColor;
        }

        public String getIconId() {
            return this.iconId;
        }

        public String getId() {
            return this.f220277id;
        }

        public String getName() {
            return this.name;
        }

        public Boolean getShouldShowInputMethodAfterClick() {
            return this.shouldShowInputMethodAfterClick;
        }

        public boolean isAdminLimit() {
            return this.adminLimit;
        }

        public boolean isShowBadge() {
            return this.showBadge;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L29:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L29;
            ChildData r101 = (ChildData) r100;
            if (this.showBadge == r101.showBadge) goto L13;
        L27:
            return false;
        L13:
            if (this.adminLimit != r101.adminLimit) goto L27;
            if (this.shouldShowInputMethodAfterClick != r101.shouldShowInputMethodAfterClick) goto L27;
            if (Objects.equals(this.f220277id, r101.f220277id) == false) goto L27;
            if (Objects.equals(this.name, r101.name) == false) goto L27;
            if (Objects.equals(this.iconId, r101.iconId) == false) goto L27;
            if (Objects.equals(this.backgroundColor, r101.backgroundColor) == false) goto L27;
            if (Objects.equals(this.iconColor, r101.iconColor) == false) goto L27;
            return true;
        }

        public void setAdminLimit(boolean r100) {
            this.adminLimit = r100;
        }

        public void setBackgroundColor(String r100) {
            this.backgroundColor = r100;
        }

        public void setIconColor(String r100) {
            this.iconColor = r100;
        }

        public void setIconId(String r100) {
            this.iconId = r100;
        }

        public void setId(String r100) {
            this.f220277id = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setShouldShowInputMethodAfterClick(Boolean r100) {
            this.shouldShowInputMethodAfterClick = r100;
        }

        public void setShowBadge(boolean r100) {
            this.showBadge = r100;
        }
    }

    public static class Children implements NonProguard {
        public ChildData[] data;
        private String subTitle;

        public int hashCode() {
            return (Objects.hash(new Object[]{this.subTitle}) * 31) + Arrays.hashCode(this.data);
        }

        public String toString() {
            return "Children{subTitle='" + this.subTitle + "', data=" + Arrays.toString(this.data) + '}';
        }

        public Children() {
        }

        public ChildData[] getData() {
            return this.data;
        }

        public String getSubTitle() {
            return this.subTitle;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L17;
            Children r101 = (Children) r100;
            if (Objects.equals(this.subTitle, r101.subTitle) == true) goto L13;
        L15:
            return false;
        L13:
            if (Arrays.equals(this.data, r101.data) == false) goto L15;
            return true;
        }

        public void setData(ChildData[] r100) {
            this.data = r100;
        }

        public void setSubTitle(String r100) {
            this.subTitle = r100;
        }
    }

    public String toString() {
        return "InsertNewBlock{, children=" + Arrays.toString(this.children) + '}';
    }

    public InsertNewBlock() {
    }

    public Children[] getChildren() {
        return this.children;
    }

    public String getTitle() {
        return this.title;
    }

    public void setChildren(Children[] r100) {
        this.children = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
