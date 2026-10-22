package com.ss.android.lark.vfs2.file;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/vfs2/file/LocalFileWrapper;", "Ljava/io/File;", "localFilePath", "Lcom/ss/android/lark/vfs2/file/LocalFilePath;", "<init>", "(Lcom/ss/android/lark/vfs2/file/LocalFilePath;)V", "getParent", "", "delete", "", "length", "", "newInputStream", "Ljava/io/InputStream;", "newOutputStream", "Ljava/io/OutputStream;", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalFileWrapper extends File {
    private final d localFilePath;

    @Override // java.io.File
    public boolean delete() {
        this.localFilePath.a();
        throw null;
    }

    @Override // java.io.File
    public String getParent() {
        this.localFilePath.getClass();
        return new d().f444839b;
    }

    @Override // java.io.File
    public long length() {
        this.localFilePath.a();
        throw null;
    }

    public final InputStream newInputStream() {
        this.localFilePath.a();
        throw null;
    }

    public final OutputStream newOutputStream() {
        this.localFilePath.a();
        throw null;
    }

    public LocalFileWrapper(d r100) {
        Intrinsics.checkNotNullParameter(r100, "localFilePath");
        super(r100.f444839b);
        this.localFilePath = r100;
    }
}
