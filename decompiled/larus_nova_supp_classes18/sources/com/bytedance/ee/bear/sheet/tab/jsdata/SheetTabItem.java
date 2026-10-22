package com.bytedance.ee.bear.sheet.tab.jsdata;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetTabItem implements NonProguard {
    private CustomIcon customIcon;
    private boolean enabled;
    private boolean hidden;
    private String id;
    private boolean locked;
    private String name;
    private String renderedTabColor;
    private boolean selected;

    public static class CustomIcon implements NonProguard {
        public static final int INNER_ICON = 1;
        public static final int OUTER_ICON = 0;
        public static final int UD_ICON = 2;
        private String selectedColorId;
        private String selectedUrl;
        private int type;
        private String unselectedColorId;
        private String unselectedUrl;

        @Retention(RetentionPolicy.SOURCE)
        public @interface CustomIconType {
        }

        public CustomIcon() {
        }

        public boolean isValidIconId() {
            if (TextUtils.isEmpty(this.selectedUrl) == false) goto L5;
        L7:
            return false;
        L5:
            if (TextUtils.isEmpty(this.unselectedUrl) == true) goto L7;
            return true;
        }

        public boolean isValidIconUrl() {
            if (TextUtils.isEmpty(this.selectedUrl) == false) goto L5;
        L7:
            return false;
        L5:
            if (TextUtils.isEmpty(this.unselectedUrl) == true) goto L7;
            return true;
        }

        public String getSelectedColorId() {
            return this.selectedColorId;
        }

        public String getSelectedUrl() {
            return this.selectedUrl;
        }

        public int getType() {
            return this.type;
        }

        public String getUnselectedColorId() {
            return this.unselectedColorId;
        }

        public String getUnselectedUrl() {
            return this.unselectedUrl;
        }

        public void setSelectedColorId(String r1) {
            this.selectedColorId = r1;
        }

        public void setSelectedUrl(String r1) {
            this.selectedUrl = r1;
        }

        public void setType(int r1) {
            this.type = r1;
        }

        public void setUnselectedColorId(String r1) {
            this.unselectedColorId = r1;
        }

        public void setUnselectedUrl(String r1) {
            this.unselectedUrl = r1;
        }
    }

    public SheetTabItem() {
        this(null, null);
    }

    public String toString() {
        return String.format("SheetTabItem[%s] locked :%s; hidden: %s; selected: %s; enabled: %s", new Object[]{this.id, Boolean.valueOf(this.locked), Boolean.valueOf(this.hidden), Boolean.valueOf(this.selected), Boolean.valueOf(this.enabled)});
    }

    public int hashCode() {
        String r0 = this.id;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public CustomIcon getCustomIcon() {
        return this.customIcon;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRenderedTabColor() {
        return this.renderedTabColor;
    }

    public boolean getSelected() {
        return this.selected;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.id, ((SheetTabItem) r3).id);
    }

    public void setCustomIcon(CustomIcon r1) {
        this.customIcon = r1;
    }

    public void setEnabled(boolean r1) {
        this.enabled = r1;
    }

    public void setHidden(boolean r1) {
        this.hidden = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setIsSelected(boolean r1) {
        setSelected(r1);
    }

    public void setLocked(boolean r1) {
        this.locked = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setRenderedTabColor(String r1) {
        this.renderedTabColor = r1;
    }

    public void setSelected(boolean r1) {
        this.selected = r1;
    }

    public SheetTabItem(String r1, String r2) {
        this.id = r1;
        this.name = r2;
    }

    public static boolean contentEquals(SheetTabItem r2, SheetTabItem r3) {
        if (r2 == null) goto L17;
        if (r3 == null) goto L17;
        if (TextUtils.equals(r2.id, r3.id) == false) goto L17;
        if (TextUtils.equals(r2.name, r3.name) == false) goto L17;
        if (TextUtils.equals(r2.renderedTabColor, r3.renderedTabColor) == false) goto L17;
        if (r2.hidden != r3.hidden) goto L17;
        if (r2.locked != r3.locked) goto L17;
        if (r2.selected != r3.selected) goto L17;
        return true;
    L17:
        return false;
    }
}
