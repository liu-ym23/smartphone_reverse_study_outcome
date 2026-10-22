package com.bytedance.ee.bear.doc.editmodeswitchplugin;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class EditModeCompleteButtonVisibleInfo implements NonProguard {
    private boolean visible;

    public EditModeCompleteButtonVisibleInfo() {
    }

    public String toString() {
        return "edit mode complete button is visible " + this.visible;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean r100) {
        this.visible = r100;
    }
}
