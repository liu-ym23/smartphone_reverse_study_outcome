package com.bytedance.ee.bear.document.selection;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ClipboardContent implements NonProguard {
    private String encryptId;
    private String html;
    private boolean protect;
    private String text;

    public String toString() {
        StringBuilder r0 = new StringBuilder("ClipboardContent{text length=");
        String r1 = this.text;
        if (r1 == null) goto L5;
        int r2 = r1.length();
    L6:
        r0.append(r2);
        r0.append(", encryptId='");
        r0.append(du5.b.g(this.encryptId));
        r0.append("', protect=");
        r0.append(this.protect);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = 0;
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

    public void setEncryptId(String r1) {
        this.encryptId = r1;
    }

    public void setHtml(String r1) {
        this.html = r1;
    }

    public void setProtect(boolean r1) {
        this.protect = r1;
    }

    public void setText(String r1) {
        this.text = r1;
    }
}
