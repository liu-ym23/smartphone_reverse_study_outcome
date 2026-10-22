package com.bytedance.ee.bear.mindnote.setting;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
class ViewData implements NonProguard {
    private String viewType;

    public ViewData() {
    }

    public String toString() {
        return "ViewData{viewType='" + this.viewType + "'}";
    }

    public String getViewType() {
        return this.viewType;
    }

    public void setViewType(String r100) {
        this.viewType = r100;
    }
}
