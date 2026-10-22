package com.bytedance.ee.bear.doc.blockeditpanel.model;

import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BlockEditPanelMenusModel implements NonProguard {
    private List<BlockEditPanel> panels;

    public static class BlockEditPanel implements NonProguard {
        private EMenuPanelId eMenuPanelId;
        private Extra extra;
        private List<BlockEditPanelMenuItem> menus;
        private String panelId;

        public BlockEditPanel() {
        }

        public EMenuPanelId getEMenuPanelId() {
            if (this.eMenuPanelId != null) goto L6;
            this.eMenuPanelId = EMenuPanelId.getEnumMenuPanelIdByPanelId(this.panelId);
        L6:
            return this.eMenuPanelId;
        }

        public String toString() {
            return "BlockEditPanel{panelId='" + this.panelId + "', menus=" + this.menus + ", extra=" + this.extra + '}';
        }

        public Extra getExtra() {
            return this.extra;
        }

        public List<BlockEditPanelMenuItem> getMenus() {
            return this.menus;
        }

        public String getPanelId() {
            return this.panelId;
        }

        public void setExtra(Extra r1) {
            this.extra = r1;
        }

        public void setMenus(List<BlockEditPanelMenuItem> r1) {
            this.menus = r1;
        }

        public void setPanelId(String r1) {
            this.panelId = r1;
        }
    }

    public static class BlockEditPanelMenuItem implements NonProguard {
        private Highlight.ColorRgba backgroundColor;
        private String buttonType;
        private CustomEMenuConfig customConfig;
        private EMenuItemButtonType eMenuItemButtonType;
        private boolean enable;
        private Highlight.ColorRgba foregroundColor;
        private String groupId;
        private String id;
        private List<BlockEditPanelMenuItem> members;
        private boolean selected;
        private String text;
        private boolean visible;

        public int hashCode() {
            return Objects.hash(new Object[]{this.id});
        }

        public EMenuItemButtonType getEMenuItemButtonType() {
            if (this.eMenuItemButtonType != null) goto L6;
            this.eMenuItemButtonType = EMenuItemButtonType.getEMenuItemButtonTypeByName(this.buttonType);
        L6:
            return this.eMenuItemButtonType;
        }

        public String toString() {
            return "BlockEditPanelMenuItem{id='" + this.id + "'text = '" + this.text + "', buttonType='" + this.buttonType + "', enable=" + this.enable + ", selected=" + this.selected + ", members=" + this.members + ", backgroundColor=" + this.backgroundColor + '}';
        }

        public BlockEditPanelMenuItem() {
            this.visible = true;
        }

        public Highlight.ColorRgba getBackgroundColor() {
            return this.backgroundColor;
        }

        public String getButtonType() {
            return this.buttonType;
        }

        public CustomEMenuConfig getCustomConfig() {
            return this.customConfig;
        }

        public Highlight.ColorRgba getForegroundColor() {
            return this.foregroundColor;
        }

        public String getGroupId() {
            return this.groupId;
        }

        public String getId() {
            return this.id;
        }

        public List<BlockEditPanelMenuItem> getMembers() {
            return this.members;
        }

        public String getText() {
            return this.text;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public boolean isSelected() {
            return this.selected;
        }

        public boolean isVisible() {
            return this.visible;
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
            return Objects.equals(this.id, ((BlockEditPanelMenuItem) r3).id);
        }

        public void setBackgroundColor(Highlight.ColorRgba r1) {
            this.backgroundColor = r1;
        }

        public void setButtonType(String r1) {
            this.buttonType = r1;
        }

        public void setCustomConfig(CustomEMenuConfig r1) {
            this.customConfig = r1;
        }

        public void setEnable(boolean r1) {
            this.enable = r1;
        }

        public void setForegroundColor(Highlight.ColorRgba r1) {
            this.foregroundColor = r1;
        }

        public void setGroupId(String r1) {
            this.groupId = r1;
        }

        public void setId(String r1) {
            this.id = r1;
        }

        public void setMembers(List<BlockEditPanelMenuItem> r1) {
            this.members = r1;
        }

        public void setSelected(boolean r1) {
            this.selected = r1;
        }

        public void setText(String r1) {
            this.text = r1;
        }

        public void setVisible(boolean r1) {
            this.visible = r1;
        }

        public BlockEditPanelMenuItem(String r7, EMenuItemButtonType r8, String r9) {
            this(r7, r8, r9, true, false);
        }

        public BlockEditPanelMenuItem(String r2, EMenuItemButtonType r3, String r4, boolean r5, boolean r6) {
            this.visible = true;
            this.id = r2;
            this.buttonType = r3.name;
            this.text = r4;
            this.enable = r5;
            this.selected = r6;
        }
    }

    public static class Extra implements NonProguard {
        private String blockToken;
        private String fileName;
        private Long fileSize;
        private String mimeType;

        public Extra() {
        }

        public String toString() {
            return "Extra{blockToken='" + b.g(this.blockToken) + "', fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", mimeType=" + this.mimeType + '}';
        }

        public String getBlockToken() {
            return this.blockToken;
        }

        public String getFileName() {
            return this.fileName;
        }

        public Long getFileSize() {
            return this.fileSize;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public void setBlockToken(String r1) {
            this.blockToken = r1;
        }

        public void setFileName(String r1) {
            this.fileName = r1;
        }

        public void setFileSize(Long r1) {
            this.fileSize = r1;
        }

        public void setMimeType(String r1) {
            this.mimeType = r1;
        }
    }

    public BlockEditPanelMenusModel() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.panels});
    }

    public String toString() {
        return "BlockEditPanelModel{menuItems=" + this.panels + '}';
    }

    public List<BlockEditPanel> getPanels() {
        return this.panels;
    }

    public static boolean isValid(BlockEditPanelMenusModel r0) {
        if (r0 == null) goto L8;
        List<BlockEditPanel> r1 = r0.panels;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        return true;
    L8:
        return false;
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
        return Objects.equals(this.panels, ((BlockEditPanelMenusModel) r3).panels);
    }

    public void setPanels(List<BlockEditPanel> r1) {
        this.panels = r1;
    }
}
