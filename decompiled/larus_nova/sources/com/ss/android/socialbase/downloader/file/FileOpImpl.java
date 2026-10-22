package com.ss.android.socialbase.downloader.file;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
class FileOpImpl implements IDownloadFileOp {
    private File file;
    private boolean isSecurity;

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getExtraMsg() {
        return "";
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public int getFileType() {
        return 1;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean canWrite() {
        return this.file.canWrite();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean delete() {
        if (this.isSecurity == true) goto L7;
        return true;
    L7:
        return this.file.delete();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean exists() {
        return this.file.exists();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getAbsolutePath() {
        return this.file.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getCanonicalPath() throws IOException {
        return this.file.getCanonicalPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getParentFile() {
        return this.file.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getPath() {
        return this.file.getPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean isDirectory() {
        return this.file.isDirectory();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long lastModified() {
        return this.file.lastModified();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long length() {
        return this.file.length();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean mkdirs() {
        return this.file.mkdirs();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileInputStream obtainInputStream() throws IOException {
        if (this.file.isFile() == false) goto L7;
        return new PolarisFileInputStreamWrapper(this.file);
    L7:
        throw new IOException(this.file.getAbsolutePath() + " Fail to obtain InputStream, file type error");
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileOutputStream obtainOutputStream() throws IOException {
        return new PolarisFileOutputStreamWrapper(this.file);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getFile() {
        return this.file;
    }

    public FileOpImpl(File r100) {
        this.isSecurity = true;
        this.file = r100;
        this.isSecurity = DownloadDirUtils.isSavePathSecurity(r100.getPath());
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean renameTo(DownloadFile r100) {
        return this.file.renameTo(r100.getFile());
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean setLastModified(long r100) {
        return this.file.setLastModified(r100);
    }

    public FileOpImpl(String r100, String r101, boolean r102) {
        this.isSecurity = true;
        if (TextUtils.isEmpty(r101) == true) goto L5;
        this.file = new PolarisFileWrapper(r100, r101);
    L6:
        if (r102 == false) goto L9;
        this.isSecurity = DownloadDirUtils.isSavePathSecurity(r100);
        return;
    L9:
        return;
    L5:
        this.file = new PolarisFileWrapper(r100);
        goto L6
    }
}
