package com.bytedance.mira.core;

import android.text.TextUtils;
import com.bytedance.mira.Mira;

/* JADX INFO: loaded from: classes21.dex */
public final class RuntimeManager {
    private static volatile RuntimeManager sRef;
    private ClassLoader mApplicationClassLoader;
    private String mApplicationSourceDir;
    private int mApplicationTheme;

    public static RuntimeManager getRef() {
        if (sRef != null) goto L15;
        monitor-enter(RuntimeManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sRef != null) goto L9;
        sRef = new RuntimeManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RuntimeManager.class);     // Catch: Throwable -> L11
    L15:
        return sRef;
    }

    public ClassLoader getApplicationClassLoader() {
        ClassLoader r100 = this.mApplicationClassLoader;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return Mira.class.getClassLoader();
    }

    public String getApplicationSourceDir() {
        String r100 = this.mApplicationSourceDir;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return Mira.getAppContext().getApplicationInfo().sourceDir;
    }

    public int getApplicationTheme() {
        int r100 = this.mApplicationTheme;
        if (r100 == 0) goto L5;
        return r100;
    L5:
        return Mira.getAppContext().getApplicationInfo().theme;
    }

    private RuntimeManager() {
    }

    public void setApplicationClassLoader(ClassLoader r100) {
        this.mApplicationClassLoader = r100;
    }

    public void setApplicationSourceDir(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.equals(this.mApplicationSourceDir, r100) == true) goto L9;
        this.mApplicationSourceDir = r100;
        return;
    }

    public void setApplicationTheme(int r100) {
        this.mApplicationTheme = r100;
    }
}
