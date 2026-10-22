package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setBadges(String[] r1) {
        this.badges = r1;
    }

    public void setData(SheetItem[] r1) {
        this.data = r1;
    }

    public void setForceOpen(boolean r1) {
        this.forceOpen = r1;
    }

    public void setShowEditButton(boolean r1) {
        this.showEditButton = r1;
    }

    public void setUri(String r1) {
        this.uri = r1;
    }
}
