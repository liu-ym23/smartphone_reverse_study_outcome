package com.bytedance.ee.bear.doc.editmodeswitchplugin;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EditModeSwitchButtonVisibleInfo implements NonProguard {
    private boolean visible;

    public EditModeSwitchButtonVisibleInfo() {
    }

    public String toString() {
        return "edit mode switch button is visible " + this.visible;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean r1) {
        this.visible = r1;
    }
}
