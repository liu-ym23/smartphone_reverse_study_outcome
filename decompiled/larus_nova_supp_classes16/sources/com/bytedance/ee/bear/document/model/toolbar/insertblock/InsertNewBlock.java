package com.bytedance.ee.bear.document.model.toolbar.insertblock;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class InsertNewBlock implements NonProguard {
    private Children[] children;
    private String title;

    public static class ChildData implements NonProguard {
        private boolean adminLimit;
        private String backgroundColor;
        private String iconColor;
        private String iconId;
        private String id;
        private String name;
        private Boolean shouldShowInputMethodAfterClick;
        private boolean showBadge;

        public int hashCode() {
            return Objects.hash(new Object[]{this.id, this.name, Boolean.valueOf(this.showBadge), Boolean.valueOf(this.adminLimit), this.iconId, this.shouldShowInputMethodAfterClick, this.backgroundColor, this.iconColor});
        }

        public String toString() {
            return "ChildData{id='" + this.id + "', name='" + this.name + "', showBadge=" + this.showBadge + ", adminLimit=" + this.adminLimit + '}';
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
            return this.id;
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

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L29:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L29;
            ChildData r6 = (ChildData) r5;
            if (this.showBadge == r6.showBadge) goto L13;
        L27:
            return false;
        L13:
            if (this.adminLimit != r6.adminLimit) goto L27;
            if (this.shouldShowInputMethodAfterClick != r6.shouldShowInputMethodAfterClick) goto L27;
            if (Objects.equals(this.id, r6.id) == false) goto L27;
            if (Objects.equals(this.name, r6.name) == false) goto L27;
            if (Objects.equals(this.iconId, r6.iconId) == false) goto L27;
            if (Objects.equals(this.backgroundColor, r6.backgroundColor) == false) goto L27;
            if (Objects.equals(this.iconColor, r6.iconColor) == false) goto L27;
            return true;
        }

        public void setAdminLimit(boolean r1) {
            this.adminLimit = r1;
        }

        public void setBackgroundColor(String r1) {
            this.backgroundColor = r1;
        }

        public void setIconColor(String r1) {
            this.iconColor = r1;
        }

        public void setIconId(String r1) {
            this.iconId = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public void setShouldShowInputMethodAfterClick(Boolean r1) {
            this.shouldShowInputMethodAfterClick = r1;
        }

        public void setShowBadge(boolean r1) {
            this.showBadge = r1;
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

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L17;
            Children r6 = (Children) r5;
            if (Objects.equals(this.subTitle, r6.subTitle) == true) goto L13;
        L15:
            return false;
        L13:
            if (Arrays.equals(this.data, r6.data) == false) goto L15;
            return true;
        }

        public void setData(ChildData[] r1) {
            this.data = r1;
        }

        public void setSubTitle(String r1) {
            this.subTitle = r1;
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

    public void setChildren(Children[] r1) {
        this.children = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
