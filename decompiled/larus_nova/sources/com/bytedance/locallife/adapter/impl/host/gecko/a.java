package com.bytedance.locallife.adapter.impl.host.gecko;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f256457a = null;

    static {
        f256457a = new a();
    }

    public a() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        return r100.isDirectory();
    }
}
