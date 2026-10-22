package com.bytedance.apm6.consumer.slardar.send;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class f$a implements Comparator<File> {
    public f$a() {
    }

    @Override // java.util.Comparator
    public final int compare(File r1, File r2) {
        return r1.compareTo(r2);
    }
}
