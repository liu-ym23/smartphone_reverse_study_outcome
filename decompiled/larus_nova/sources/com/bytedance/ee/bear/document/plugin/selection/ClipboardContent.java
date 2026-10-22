package com.bytedance.ee.bear.document.plugin.selection;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class ClipboardContent implements NonProguard {
    private String encryptId;
    private String html;
    private boolean protect;
    private String text;

    public String toString() {
        StringBuilder r100 = new StringBuilder("ClipboardContent{text length=");
        String r101 = this.text;
        if (r101 == null) goto L5;
        int r102 = r101.length();
    L6:
        r100.append(r102);
        r100.append(", encryptId='");
        r100.append(du5.b.g(this.encryptId));
        r100.append("', protect=");
        r100.append(this.protect);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = 0;
        goto L6
    }

    public ClipboardContent() {
        this.protect = true;
    }

    public String getEncryptId() {
        return this.encryptId;
    }

    public String getHtml() {
        return this.html;
    }

    public String getText() {
        return this.text;
    }

    public boolean isProtect() {
        return this.protect;
    }

    public void setEncryptId(String r100) {
        this.encryptId = r100;
    }

    public void setHtml(String r100) {
        this.html = r100;
    }

    public void setProtect(boolean r100) {
        this.protect = r100;
    }

    public void setText(String r100) {
        this.text = r100;
    }
}
