package com.bytedance.ee.bear.document.titlebar;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class TitleVisibilityData implements NonProguard {
    private boolean visible;

    public TitleVisibilityData() {
    }

    public String toString() {
        return "TitleVisibilityData{visible=" + this.visible + '}';
    }

    public boolean getVisible() {
        return this.visible;
    }

    public void setVisible(boolean r100) {
        this.visible = r100;
    }
}
