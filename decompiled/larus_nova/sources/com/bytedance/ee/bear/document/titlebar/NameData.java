package com.bytedance.ee.bear.document.titlebar;

import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes16.dex */
public class NameData implements BaseJSModel {
    private IconInfo icon_info;
    private String title;

    public NameData() {
    }

    public String toString() {
        return "NameData{title='" + this.title + "', icon_info=" + this.icon_info + '}';
    }

    public IconInfo getIcon_info() {
        return this.icon_info;
    }

    public String getName() {
        return this.title;
    }

    public void setIcon_info(IconInfo r100) {
        this.icon_info = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
