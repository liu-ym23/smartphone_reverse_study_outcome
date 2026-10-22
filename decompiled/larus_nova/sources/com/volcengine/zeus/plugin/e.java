package com.volcengine.zeus.plugin;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes41.dex */
public final class e implements FileFilter {
    public e() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        if (r100.getName().endsWith(".apk") == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.getName().endsWith(".jar") == true) goto L8;
        return false;
    }
}
