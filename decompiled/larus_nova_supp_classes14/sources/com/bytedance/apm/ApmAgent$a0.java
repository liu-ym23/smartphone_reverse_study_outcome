package com.bytedance.apm;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$a0 implements Comparator<File> {
    public ApmAgent$a0() {
    }

    @Override // java.util.Comparator
    public final int compare(File r3, File r4) {
        return Long.compare(r3.lastModified(), r4.lastModified());
    }
}
