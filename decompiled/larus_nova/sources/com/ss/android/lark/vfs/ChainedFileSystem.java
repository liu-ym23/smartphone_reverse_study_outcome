package com.ss.android.lark.vfs;

import android.net.Uri;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0017J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u001dJ\u001b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001c2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0018\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u001aH\u0016J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u001fH\u0016J\u0010\u00103\u001a\u00020)2\u0006\u00102\u001a\u00020\u001fH\u0016J\u000e\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u0001J\u0013\u00106\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u000108H\u0096\u0002J\b\u00109\u001a\u00020:H\u0016R\u001a\u0010\u0002\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006;"}, d2 = {"Lcom/ss/android/lark/vfs/ChainedFileSystem;", "Lcom/ss/android/lark/vfs/FileSystem;", "delegate", "<init>", "(Lcom/ss/android/lark/vfs/FileSystem;)V", "getDelegate$unistore_release", "()Lcom/ss/android/lark/vfs/FileSystem;", "setDelegate$unistore_release", "resolvePath", "Lcom/ss/android/lark/vfs/VFSPath;", "uri", "Landroid/net/Uri;", "onInstalled", "", "fms", "Lcom/ss/android/lark/vfs/FileSystemManager;", "path", "openInput", "Ljava/io/InputStream;", "openOutput", "Ljava/io/OutputStream;", "append", "", "randomAccessFile", "Ljava/io/RandomAccessFile;", "mode", "", "list", "", "(Lcom/ss/android/lark/vfs/VFSPath;)[Ljava/lang/String;", "listFiles", "Lcom/ss/android/lark/vfs/VFSFile;", "(Lcom/ss/android/lark/vfs/VFSPath;)[Lcom/ss/android/lark/vfs/VFSFile;", "exists", "delete", "size", "", "lastModified", "createNewFile", "mkdirs", "getReadFile", "Ljava/io/File;", "getWriteFile", "move", "src", "dest", "isFile", "isDirectory", "toString", "afterWriteCompat", "originalFile", "beforeReadCompat", "contains", "fs", "equals", "other", "", "hashCode", "", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ChainedFileSystem implements FileSystem {
    private FileSystem delegate;

    @Override // com.ss.android.lark.vfs.FileSystem
    public abstract /* synthetic */ String getName();

    public String toString() {
        return getName() + " -> " + this.delegate;
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public final FileSystem getDelegate$unistore_release() {
        return this.delegate;
    }

    public ChainedFileSystem(FileSystem r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.delegate = r100;
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File afterWriteCompat(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return this.delegate.afterWriteCompat(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File beforeReadCompat(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return this.delegate.beforeReadCompat(r100);
    }

    public final boolean contains(FileSystem r100) {
        Intrinsics.checkNotNullParameter(r100, "fs");
        if (Intrinsics.areEqual(this, r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.delegate, r100) == true) goto L8;
        return false;
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean createNewFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.createNewFile(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean delete(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.delete(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Class<?> r101 = getClass();
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(r101, r102) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        r102 = null;
        goto L10
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean exists(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.exists(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File getReadFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.getReadFile(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File getWriteFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.getWriteFile(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean isDirectory(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.isDirectory(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean isFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.isFile(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public long lastModified(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.lastModified(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public String[] list(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.list(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public VFSFile[] listFiles(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.listFiles(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean mkdirs(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.mkdirs(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public InputStream openInput(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.openInput(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public VFSPath resolvePath(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return this.delegate.resolvePath(r100);
    }

    public final void setDelegate$unistore_release(FileSystem r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.delegate = r100;
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public long size(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.size(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean move(VFSPath r100, VFSPath r101) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "dest");
        return this.delegate.move(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public void onInstalled(FileSystemManager r100, VFSPath r101) {
        Intrinsics.checkNotNullParameter(r100, "fms");
        Intrinsics.checkNotNullParameter(r101, "path");
        this.delegate.onInstalled(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public OutputStream openOutput(VFSPath r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return this.delegate.openOutput(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public RandomAccessFile randomAccessFile(VFSPath r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "mode");
        return this.delegate.randomAccessFile(r100, r101);
    }
}
