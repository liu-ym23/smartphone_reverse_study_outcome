package com.bytedance.ee.bear.document.plugin.selection;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public class ClipboardEncrypt implements NonProguard {
    private HashMap<String, String> encryptIds;

    public ClipboardEncrypt() {
    }

    public HashMap<String, String> getEncryptIds() {
        return this.encryptIds;
    }

    public void setEncryptIds(HashMap<String, String> r100) {
        this.encryptIds = r100;
    }
}
