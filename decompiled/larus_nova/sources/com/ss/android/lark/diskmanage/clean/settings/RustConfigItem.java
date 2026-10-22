package com.ss.android.lark.diskmanage.clean.settings;

import com.ss.android.lark.diskmanage.NonProguard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class RustConfigItem implements NonProguard {
    private List<String> files;

    public String toString() {
        return "RustConfigItem{files=" + this.files + '}';
    }

    public RustConfigItem() {
        this.files = new ArrayList();
    }

    public List<String> getFiles() {
        return this.files;
    }

    public void setFiles(List<String> r100) {
        this.files = r100;
    }
}
