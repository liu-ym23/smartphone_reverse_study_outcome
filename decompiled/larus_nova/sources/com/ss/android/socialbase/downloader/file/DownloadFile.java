package com.ss.android.socialbase.downloader.file;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadFile implements IDownloadFileOp {
    public static final int TYPE_AUDIO = 4;
    public static final int TYPE_DOWNLOADS = 5;
    public static final int TYPE_ERROR = -1;
    public static final int TYPE_FILE = 1;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_VIDEO = 3;
    public IDownloadFileOp downloadFileOp;
    private String mRealPath;

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean canWrite() {
        return this.downloadFileOp.canWrite();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean delete() {
        return this.downloadFileOp.delete();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean exists() {
        return this.downloadFileOp.exists();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getAbsolutePath() {
        return this.downloadFileOp.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getCanonicalPath() throws IOException {
        return this.downloadFileOp.getCanonicalPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getExtraMsg() {
        return this.downloadFileOp.getExtraMsg();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getFile() {
        return this.downloadFileOp.getFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public int getFileType() {
        return this.downloadFileOp.getFileType();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public File getParentFile() {
        return this.downloadFileOp.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public String getPath() {
        return this.downloadFileOp.getPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean isDirectory() {
        return this.downloadFileOp.isDirectory();
    }

    public boolean isTypeError() {
        if (this.downloadFileOp.getFileType() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTypeFile() {
        if (this.downloadFileOp.getFileType() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isTypeMediaStore() {
        int r100 = this.downloadFileOp.getFileType();
        if (r100 != 2) goto L5;
    L12:
        return true;
    L5:
        if (r100 == 3) goto L12;
        if (r100 == 4) goto L12;
        if (r100 == 5) goto L12;
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long lastModified() {
        return this.downloadFileOp.lastModified();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public long length() {
        return this.downloadFileOp.length();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean mkdirs() {
        return this.downloadFileOp.mkdirs();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileInputStream obtainInputStream() throws IOException {
        return this.downloadFileOp.obtainInputStream();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public FileOutputStream obtainOutputStream() throws IOException {
        return this.downloadFileOp.obtainOutputStream();
    }

    public String getRealPath() {
        return this.mRealPath;
    }

    public DownloadFile(File r100) {
        this.downloadFileOp = new FileOpImpl(r100);
        this.mRealPath = r100.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean renameTo(DownloadFile r100) {
        return this.downloadFileOp.renameTo(r100);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public boolean setLastModified(long r100) {
        return this.downloadFileOp.setLastModified(r100);
    }

    public DownloadFile(String r100, String r101) {
        this(r100, r101, true, true);
    }

    public DownloadFile(String r100, String r101, boolean r102, boolean r103) {
        this.mRealPath = r100;
        int r104 = DownloadFileUtils.getTypeByUri(r100);
        if (r104 != 1) goto L10;
        this.downloadFileOp = new FileOpImpl(r100, r101, r102);
        return;
    L10:
        Uri r105 = UriProtector.parse(r100);     // Catch: Throwable -> L7
        DownloadFileUtils.checkUri(r105, r104);     // Catch: Throwable -> L7
        this.downloadFileOp = new MediaStoreOpImpl(r105, r104, r103);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        this.downloadFileOp = new ErrorOpImpl(th.toString());
        th.printStackTrace();
    }
}
