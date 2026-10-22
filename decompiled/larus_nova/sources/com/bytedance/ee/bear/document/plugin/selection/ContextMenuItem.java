package com.bytedance.ee.bear.document.plugin.selection;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class ContextMenuItem implements NonProguard {
    public Object data;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f220904id;
    public String text;

    public ContextMenuItem() {
    }

    public Object getData() {
        return this.data;
    }

    public String getId() {
        return this.f220904id;
    }

    public String getText() {
        return this.text;
    }

    public void setData(Object r100) {
        this.data = r100;
    }

    public void setId(String r100) {
        this.f220904id = r100;
    }

    public void setText(String r100) {
        this.text = r100;
    }
}
