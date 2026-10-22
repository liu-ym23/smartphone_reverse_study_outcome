package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: classes18.dex */
public class FabPanelItem implements NonProguard {
    private String[] badges;
    private SheetItem[] data;
    private boolean forceOpen;
    private boolean showEditButton;
    private String uri;

    public FabPanelItem() {
    }

    public String toString() {
        return "FabPanelItem{forceOpen=" + this.forceOpen + ", showEditButton=" + this.showEditButton + ", uri=" + this.uri + ", items=" + Arrays.toString(this.data) + '}';
    }

    public String[] getBadges() {
        return this.badges;
    }

    public SheetItem[] getData() {
        return this.data;
    }

    public String getUri() {
        return this.uri;
    }

    public boolean isForceOpen() {
        return this.forceOpen;
    }

    public boolean isShowEditButton() {
        return this.showEditButton;
    }

    public void setBadges(String[] r100) {
        this.badges = r100;
    }

    public void setData(SheetItem[] r100) {
        this.data = r100;
    }

    public void setForceOpen(boolean r100) {
        this.forceOpen = r100;
    }

    public void setShowEditButton(boolean r100) {
        this.showEditButton = r100;
    }

    public void setUri(String r100) {
        this.uri = r100;
    }
}
