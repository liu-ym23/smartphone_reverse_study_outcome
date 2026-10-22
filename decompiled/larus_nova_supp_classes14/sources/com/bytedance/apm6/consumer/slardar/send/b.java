package com.bytedance.apm6.consumer.slardar.send;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Comparator<File> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(File r2, File r3) {
        return String.CASE_INSENSITIVE_ORDER.compare(r2.getName(), r3.getName());
    }
}
