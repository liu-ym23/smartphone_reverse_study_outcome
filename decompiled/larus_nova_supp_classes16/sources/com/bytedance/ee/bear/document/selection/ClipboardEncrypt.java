package com.bytedance.ee.bear.document.selection;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ClipboardEncrypt implements NonProguard {
    private HashMap<String, String> encryptIds;

    public ClipboardEncrypt() {
    }

    public HashMap<String, String> getEncryptIds() {
        return this.encryptIds;
    }

    public void setEncryptIds(HashMap<String, String> r1) {
        this.encryptIds = r1;
    }
}
