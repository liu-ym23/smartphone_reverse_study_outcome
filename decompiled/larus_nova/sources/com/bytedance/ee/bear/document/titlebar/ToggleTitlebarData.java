package com.bytedance.ee.bear.document.titlebar;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes16.dex */
public class ToggleTitlebarData implements BaseJSModel {
    public static final int HIDE_TITLE = 0;
    public static final int SHOW_TITLE = 1;
    private boolean isLarkAndroidSupportPad;
    private int states;

    public String toString() {
        return "ToggleTitlebarData{states=" + this.states + ", isSupportPad=" + this.isLarkAndroidSupportPad + '}';
    }

    public ToggleTitlebarData() {
        this.isLarkAndroidSupportPad = false;
    }

    public int getStates() {
        return this.states;
    }

    public boolean isIsLarkAndroidSupportPad() {
        return this.isLarkAndroidSupportPad;
    }

    public void setIsLarkAndroidSupportPad(boolean r100) {
        this.isLarkAndroidSupportPad = r100;
    }

    public void setStates(int r100) {
        this.states = r100;
    }
}
