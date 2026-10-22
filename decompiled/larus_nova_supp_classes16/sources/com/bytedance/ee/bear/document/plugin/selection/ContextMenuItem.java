package com.bytedance.ee.bear.document.plugin.selection;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ContextMenuItem implements NonProguard {
    public Object data;
    public String id;
    public String text;

    public ContextMenuItem() {
    }

    public Object getData() {
        return this.data;
    }

    public String getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void setData(Object r1) {
        this.data = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setText(String r1) {
        this.text = r1;
    }
}
