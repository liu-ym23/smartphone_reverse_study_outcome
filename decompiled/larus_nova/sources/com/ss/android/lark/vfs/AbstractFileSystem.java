package com.ss.android.lark.vfs;

import android.net.Uri;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u0018H\u0016¨\u0006-"}, d2 = {"Lcom/ss/android/lark/vfs/AbstractFileSystem;", "Lcom/ss/android/lark/vfs/FileSystem;", "<init>", "()V", "onInstalled", "", "fms", "Lcom/ss/android/lark/vfs/FileSystemManager;", "path", "Lcom/ss/android/lark/vfs/VFSPath;", "openInput", "Ljava/io/InputStream;", "openOutput", "Ljava/io/OutputStream;", "append", "", "randomAccessFile", "Ljava/io/RandomAccessFile;", "mode", "", "list", "", "(Lcom/ss/android/lark/vfs/VFSPath;)[Ljava/lang/String;", "listFiles", "Lcom/ss/android/lark/vfs/VFSFile;", "(Lcom/ss/android/lark/vfs/VFSPath;)[Lcom/ss/android/lark/vfs/VFSFile;", "exists", "delete", "size", "", "lastModified", "createNewFile", "mkdirs", "getReadFile", "Ljava/io/File;", "getWriteFile", "move", "src", "dest", "isFile", "isDirectory", "toString", "afterWriteCompat", "originalFile", "beforeReadCompat", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractFileSystem implements FileSystem {
    public AbstractFileSystem() {
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File afterWriteCompat(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return r100;
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File beforeReadCompat(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return r100;
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public abstract /* synthetic */ String getName();

    @Override // com.ss.android.lark.vfs.FileSystem
    public void onInstalled(FileSystemManager r100, VFSPath r101) {
        Intrinsics.checkNotNullParameter(r100, "fms");
        Intrinsics.checkNotNullParameter(r101, "path");
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public abstract /* synthetic */ VFSPath resolvePath(Uri r100);

    public String toString() {
        return getName();
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean createNewFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean delete(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean exists(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File getReadFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File getWriteFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean isDirectory(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean isFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public long lastModified(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public String[] list(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public VFSFile[] listFiles(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean mkdirs(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public InputStream openInput(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public long size(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean move(VFSPath r100, VFSPath r101) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "dest");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public OutputStream openOutput(VFSPath r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public RandomAccessFile randomAccessFile(VFSPath r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "mode");
        throw new UnsupportedOperationException("openInput unimplement for this file system " + this);
    }
}
