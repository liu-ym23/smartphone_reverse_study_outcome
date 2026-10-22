package com.bytedance.iesgurd.core;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f250655a = null;

    static {
        f250655a = new d();
    }

    public d() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        return r100.isDirectory();
    }
}
