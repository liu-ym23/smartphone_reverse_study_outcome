package com.bytedance.iesgurd.core;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f250650a = null;

    static {
        f250650a = new b();
    }

    public b() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        return r100.isDirectory();
    }
}
