package com.bytedance.ee.bear.mindnote.setting;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
class StructureItem implements NonProguard {
    private String key;
    private String type;

    public String toString() {
        return "StructureItem{key='" + this.key + "', type='" + this.type + "'}";
    }

    public StructureItem() {
        this.key = "";
        this.type = "";
    }

    public String getKey() {
        return this.key;
    }

    public String getType() {
        return this.type;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }
}
