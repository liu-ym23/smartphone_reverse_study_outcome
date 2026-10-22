package com.bytedance.ee.bear.document.menu;

import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class MenuData implements BaseJSModel {
    private List<MenuItem> items;

    public String toString() {
        return "NavigationMenu{items=" + this.items + '}';
    }

    public MenuData() {
    }

    public List<MenuItem> getItems() {
        return this.items;
    }

    public MenuData(List<MenuItem> r100) {
        this.items = r100;
    }

    public void setItems(List<MenuItem> r100) {
        this.items = r100;
    }
}
