package com.bytedance.iesgurd.core;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f250669a = null;

    static {
        f250669a = new g();
    }

    public g() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        return r100.isDirectory();
    }
}
