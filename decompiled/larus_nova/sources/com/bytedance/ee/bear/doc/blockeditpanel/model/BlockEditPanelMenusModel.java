package com.bytedance.ee.bear.doc.blockeditpanel.model;

import com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl.Highlight;
import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
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

        public void setExtra(Extra r100) {
            this.extra = r100;
        }

        public void setMenus(List<BlockEditPanelMenuItem> r100) {
            this.menus = r100;
        }

        public void setPanelId(String r100) {
            this.panelId = r100;
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

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f217613id;
        private List<BlockEditPanelMenuItem> members;
        private boolean selected;
        private String text;
        private boolean visible;

        public int hashCode() {
            return Objects.hash(new Object[]{this.f217613id});
        }

        public EMenuItemButtonType getEMenuItemButtonType() {
            if (this.eMenuItemButtonType != null) goto L6;
            this.eMenuItemButtonType = EMenuItemButtonType.getEMenuItemButtonTypeByName(this.buttonType);
        L6:
            return this.eMenuItemButtonType;
        }

        public String toString() {
            return "BlockEditPanelMenuItem{id='" + this.f217613id + "'text = '" + this.text + "', buttonType='" + this.buttonType + "', enable=" + this.enable + ", selected=" + this.selected + ", members=" + this.members + ", backgroundColor=" + this.backgroundColor + '}';
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
            return this.f217613id;
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
            return Objects.equals(this.f217613id, ((BlockEditPanelMenuItem) r100).f217613id);
        }

        public void setBackgroundColor(Highlight.ColorRgba r100) {
            this.backgroundColor = r100;
        }

        public void setButtonType(String r100) {
            this.buttonType = r100;
        }

        public void setCustomConfig(CustomEMenuConfig r100) {
            this.customConfig = r100;
        }

        public void setEnable(boolean r100) {
            this.enable = r100;
        }

        public void setForegroundColor(Highlight.ColorRgba r100) {
            this.foregroundColor = r100;
        }

        public void setGroupId(String r100) {
            this.groupId = r100;
        }

        public void setId(String r100) {
            this.f217613id = r100;
        }

        public void setMembers(List<BlockEditPanelMenuItem> r100) {
            this.members = r100;
        }

        public void setSelected(boolean r100) {
            this.selected = r100;
        }

        public void setText(String r100) {
            this.text = r100;
        }

        public void setVisible(boolean r100) {
            this.visible = r100;
        }

        public BlockEditPanelMenuItem(String r100, EMenuItemButtonType r101, String r102) {
            this(r100, r101, r102, true, false);
        }

        public BlockEditPanelMenuItem(String r100, EMenuItemButtonType r101, String r102, boolean r103, boolean r104) {
            this.visible = true;
            this.f217613id = r100;
            this.buttonType = r101.name;
            this.text = r102;
            this.enable = r103;
            this.selected = r104;
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

        public void setBlockToken(String r100) {
            this.blockToken = r100;
        }

        public void setFileName(String r100) {
            this.fileName = r100;
        }

        public void setFileSize(Long r100) {
            this.fileSize = r100;
        }

        public void setMimeType(String r100) {
            this.mimeType = r100;
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

    public static boolean isValid(BlockEditPanelMenusModel r100) {
        if (r100 == null) goto L8;
        List<BlockEditPanel> r101 = r100.panels;
        if (r101 == null) goto L8;
        if (r101.isEmpty() == true) goto L8;
        return true;
    L8:
        return false;
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
        return Objects.equals(this.panels, ((BlockEditPanelMenusModel) r100).panels);
    }

    public void setPanels(List<BlockEditPanel> r100) {
        this.panels = r100;
    }
}
