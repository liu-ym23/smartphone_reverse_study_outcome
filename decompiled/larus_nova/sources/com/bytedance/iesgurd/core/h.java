package com.bytedance.iesgurd.core;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f250670a = null;

    static {
        f250670a = new h();
    }

    public h() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        return r100.isDirectory();
    }
}
