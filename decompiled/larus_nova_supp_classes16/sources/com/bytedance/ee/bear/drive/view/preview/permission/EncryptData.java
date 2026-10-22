package com.bytedance.ee.bear.drive.view.preview.permission;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EncryptData implements NonProguard {
    private String encryptId;
    private boolean isBlock;

    public EncryptData() {
        this.isBlock = false;
    }

    public String getEncryptId() {
        return this.encryptId;
    }

    public boolean isBlock() {
        return this.isBlock;
    }

    public void setBlock(boolean r1) {
        this.isBlock = r1;
    }

    public void setEncryptId(String r1) {
        this.encryptId = r1;
    }
}
