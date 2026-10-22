package com.ss.android.ttve.monitor;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements FileFilter {
    public d() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        return Pattern.matches("cpu[0-9]", r100.getName());
    }
}
