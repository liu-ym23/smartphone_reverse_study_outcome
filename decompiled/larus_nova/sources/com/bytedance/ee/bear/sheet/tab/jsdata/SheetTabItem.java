package com.bytedance.ee.bear.sheet.tab.jsdata;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class SheetTabItem implements NonProguard {
    private CustomIcon customIcon;
    private boolean enabled;
    private boolean hidden;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f238379id;
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

        public void setSelectedColorId(String r100) {
            this.selectedColorId = r100;
        }

        public void setSelectedUrl(String r100) {
            this.selectedUrl = r100;
        }

        public void setType(int r100) {
            this.type = r100;
        }

        public void setUnselectedColorId(String r100) {
            this.unselectedColorId = r100;
        }

        public void setUnselectedUrl(String r100) {
            this.unselectedUrl = r100;
        }
    }

    public SheetTabItem() {
        this(null, null);
    }

    public String toString() {
        return String.format("SheetTabItem[%s] locked :%s; hidden: %s; selected: %s; enabled: %s", new Object[]{this.f238379id, Boolean.valueOf(this.locked), Boolean.valueOf(this.hidden), Boolean.valueOf(this.selected), Boolean.valueOf(this.enabled)});
    }

    public int hashCode() {
        String r100 = this.f238379id;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public CustomIcon getCustomIcon() {
        return this.customIcon;
    }

    public String getId() {
        return this.f238379id;
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

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.f238379id, ((SheetTabItem) r100).f238379id);
    }

    public void setCustomIcon(CustomIcon r100) {
        this.customIcon = r100;
    }

    public void setEnabled(boolean r100) {
        this.enabled = r100;
    }

    public void setHidden(boolean r100) {
        this.hidden = r100;
    }

    public void setId(String r100) {
        this.f238379id = r100;
    }

    public void setIsSelected(boolean r100) {
        setSelected(r100);
    }

    public void setLocked(boolean r100) {
        this.locked = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setRenderedTabColor(String r100) {
        this.renderedTabColor = r100;
    }

    public void setSelected(boolean r100) {
        this.selected = r100;
    }

    public SheetTabItem(String r100, String r101) {
        this.f238379id = r100;
        this.name = r101;
    }

    public static boolean contentEquals(SheetTabItem r100, SheetTabItem r101) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L17;
        if (TextUtils.equals(r100.f238379id, r101.f238379id) == false) goto L17;
        if (TextUtils.equals(r100.name, r101.name) == false) goto L17;
        if (TextUtils.equals(r100.renderedTabColor, r101.renderedTabColor) == false) goto L17;
        if (r100.hidden != r101.hidden) goto L17;
        if (r100.locked != r101.locked) goto L17;
        if (r100.selected != r101.selected) goto L17;
        return true;
    L17:
        return false;
    }
}
