package com.ss.android.socialbase.downloader.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
interface IDownloadFileOp {
    boolean canWrite();

    boolean delete();

    boolean exists();

    String getAbsolutePath();

    String getCanonicalPath() throws IOException;

    String getExtraMsg();

    File getFile();

    int getFileType();

    File getParentFile();

    String getPath();

    boolean isDirectory();

    long lastModified();

    long length();

    boolean mkdirs();

    FileInputStream obtainInputStream() throws IOException;

    FileOutputStream obtainOutputStream() throws IOException;

    boolean renameTo(DownloadFile r100);

    boolean setLastModified(long r100);
}
