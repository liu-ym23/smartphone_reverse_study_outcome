package com.bytedance.mira.helper;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes21.dex */
public final class FileLocker implements Closeable {
    private final FileLock mLock;
    private final FileOutputStream mLockFileOutputStream;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        FileLock r100 = this.mLock;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.release();     // Catch: Throwable -> L7
    L5:
        this.mLockFileOutputStream.close();
        return;
    L7:
        th = move-exception;
        this.mLockFileOutputStream.close();
        throw th;
    }

    private FileLocker(File r100) throws IOException {
        PolarisFileOutputStreamWrapper r101 = new PolarisFileOutputStreamWrapper(r100);
        this.mLockFileOutputStream = r101;
        FileLock r102 = r101.getChannel().lock();     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        r101.close();
    L6:
        this.mLock = r102;
        return;
    L8:
        th = move-exception;
        this.mLockFileOutputStream.close();
        throw th;
    }

    public static FileLocker lock(File r100) throws IOException {
        return new FileLocker(r100);
    }
}
