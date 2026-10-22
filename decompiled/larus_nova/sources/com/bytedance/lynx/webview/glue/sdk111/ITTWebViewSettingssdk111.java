package com.bytedance.lynx.webview.glue.sdk111;

import com.bytedance.lynx.webview.glue.TextSelectedEventListener;

/* JADX INFO: loaded from: classes21.dex */
public abstract class ITTWebViewSettingssdk111 {
    public static final int MENU_ITEM_COPY = 16;
    public static final int MENU_ITEM_NONE = 0;
    public static final int MENU_ITEM_PROCESS_TEXT = 8;
    public static final int MENU_ITEM_SELECT_ALL = 4;
    public static final int MENU_ITEM_SHARE = 1;
    public static final int MENU_ITEM_WEB_SEARCH = 2;

    public ITTWebViewSettingssdk111() {
    }

    public abstract void addActionModeMenuItem(String r100, TextSelectedEventListener r101);

    public abstract void addActionModeMenuItem(String r100, TextSelectedEventListener r101, int r102);

    public abstract void addActionModeMenuItem(String r100, Object r101, int r102);

    public abstract void setDisabledActionModeMenuItems(int r100);
}
