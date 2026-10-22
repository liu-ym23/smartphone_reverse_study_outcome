package com.bytedance.ee.bear.drive.view.preview.permission;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setBlock(boolean r100) {
        this.isBlock = r100;
    }

    public void setEncryptId(String r100) {
        this.encryptId = r100;
    }
}
