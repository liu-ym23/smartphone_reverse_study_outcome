package com.ss.android.socialbase.downloader.file;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public class MediaStoreOpImpl implements IDownloadFileOp {
    private boolean enableMediaStoreSecurityStrategy;
    private File file;
    private int type;
    private Uri uri;

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean canWrite() {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getExtraMsg() {
        return "";
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean mkdirs() {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean renameTo(DownloadFile r100) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean exists() {
        return DownloadFileUtils.exists(this.uri);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getAbsolutePath() {
        File r100 = this.file;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getCanonicalPath() throws IOException {
        File r100 = this.file;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getCanonicalPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getParentFile() {
        File r100 = this.file;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getPath() {
        return DownloadFileUtils.getFilePathFromUri(this.uri);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean isDirectory() {
        File r100 = this.file;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isDirectory();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long lastModified() {
        File r100 = this.file;
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.exists() == true) goto L7;
        return 0;
    L7:
        return this.file.lastModified();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long length() {
        return DownloadFileUtils.getLength(this.uri);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileInputStream obtainInputStream() throws IOException {
        if (this.uri == null) goto L11;
        if (DownloadFileUtils.isExternalDownloadEnabled() == false) goto L9;
        return new ParcelFileDescriptor.AutoCloseInputStream(DownloadFileUtils.getParcelFileDescriptor(this.uri, "r"));
    L9:
        return new PolarisFileInputStreamWrapper(DownloadFileUtils.getFileDescriptor(this.uri, "r"));
    L11:
        throw new IOException("Fail to obtain InputStream, uri is null");
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileOutputStream obtainOutputStream() throws IOException {
        if (this.uri == null) goto L11;
        if (DownloadFileUtils.isExternalDownloadEnabled() == false) goto L9;
        return new ParcelFileDescriptor.AutoCloseOutputStream(DownloadFileUtils.getParcelFileDescriptor(this.uri, "w"));
    L9:
        return new PolarisFileOutputStreamWrapper(DownloadFileUtils.getFileDescriptor(this.uri, "w"));
    L11:
        throw new IOException("Fail to obtain OutputStream, uri is null");
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean delete() {
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    L3:
        if (DownloadFileUtils.isExternalDownloadEnabled() == true) goto L5;
        DownloadFileUtils.emptyFile(obtainOutputStream());     // Catch: Throwable -> L11
        return false;
    L5:
        if (exists() == false) goto L16;
        DownloadFileUtils.deleteUri(this.uri);     // Catch: Throwable -> L11
        return true;
    L16:
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getFile() {
        return this.file;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public int getFileType() {
        return this.type;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean setLastModified(long r100) {
        File r101 = this.file;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.exists() == true) goto L7;
        return false;
    L7:
        return this.file.setLastModified(r100);
    }

    public MediaStoreOpImpl(Uri r100, int r101, boolean r102) {
        this.uri = r100;
        this.type = r101;
        this.enableMediaStoreSecurityStrategy = r102;
        String r103 = getPath();
        if (TextUtils.isEmpty(r103) == true) goto L6;
        this.file = new PolarisFileWrapper(r103);
        return;
    }
}
