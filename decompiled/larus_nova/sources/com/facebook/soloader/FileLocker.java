package com.facebook.soloader;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class FileLocker implements Closeable {

    @Nullable
    private FileLock mLock;
    private FileOutputStream mLockFileOutputStream;

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

    public static FileLocker lock(File r100) throws IOException {
        return new FileLocker(r100, false);
    }

    @Nullable
    public static FileLocker tryLock(File r100) throws IOException {
        FileLocker r101 = new FileLocker(r100, true);
        if (r101.mLock != null) goto L6;
        r101.close();
        return null;
    L6:
        return r101;
    }

    private FileLocker(File r100, boolean r101) throws IOException {
        init(r100, r101);
    }

    private void init(File r100, boolean r101) throws IOException {
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r100);
        this.mLockFileOutputStream = r102;
        if (r101 == true) goto L18;
        FileLock r103 = r102.getChannel().lock();     // Catch: Throwable -> L12
    L15:
    L8:
        if (r103 != null) goto L10;
        this.mLockFileOutputStream.close();
    L10:
        this.mLock = r103;
        return;
    L18:
        r103 = r102.getChannel().tryLock();     // Catch: IOException -> L6 Throwable -> L12
    L6:
        r103 = null;
    L12:
        th = move-exception;
        this.mLockFileOutputStream.close();
        throw th;
    }
}
