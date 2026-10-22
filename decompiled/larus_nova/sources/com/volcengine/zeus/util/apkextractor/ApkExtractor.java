package com.volcengine.zeus.util.apkextractor;

import java.io.Closeable;
import java.util.zip.ZipFile;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public class ApkExtractor implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f462916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f462917b;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((ZipFile) this.f462916a.getValue()).close();
    }

    public ApkExtractor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "apkPath");
        this.f462917b = r100;
        this.f462916a = LazyKt.lazy(new ApkExtractor$apkZipFile$2(this));
    }
}
