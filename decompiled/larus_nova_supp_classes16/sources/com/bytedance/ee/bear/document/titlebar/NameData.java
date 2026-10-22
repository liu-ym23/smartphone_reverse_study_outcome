package com.bytedance.ee.bear.document.titlebar;

import com.bytedance.ee.bear.contract.icon.IconInfo;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setIcon_info(IconInfo r1) {
        this.icon_info = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }
}
