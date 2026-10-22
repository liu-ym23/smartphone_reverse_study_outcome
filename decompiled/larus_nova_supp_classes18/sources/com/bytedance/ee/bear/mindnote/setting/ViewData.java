package com.bytedance.ee.bear.mindnote.setting;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setViewType(String r1) {
        this.viewType = r1;
    }
}
