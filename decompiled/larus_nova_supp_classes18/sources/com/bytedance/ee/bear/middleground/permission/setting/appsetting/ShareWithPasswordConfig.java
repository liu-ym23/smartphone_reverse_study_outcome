package com.bytedance.ee.bear.middleground.permission.setting.appsetting;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@AppConfig(key = "docs_folder_ShareWithPasswordEnable")
public class ShareWithPasswordConfig implements NonProguard {
    private boolean doc_enable;
    private boolean folder_enable;

    public boolean isDoc_enable() {
        return this.doc_enable;
    }

    public boolean isFolder_enable() {
        return this.folder_enable;
    }

    public ShareWithPasswordConfig(boolean r2) {
        this.doc_enable = !r2;
        this.folder_enable = !r2;
    }

    public void setDoc_enable(boolean r1) {
        this.doc_enable = r1;
    }

    public void setFolder_enable(boolean r1) {
        this.folder_enable = r1;
    }
}
