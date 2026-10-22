package com.ss.android.lark.vfs;

import android.net.Uri;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0005H&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H&J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\f\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0018J\u001b\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010\f\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H&J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H&J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001aH&J\u0010\u0010+\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001aH&J\u0010\u0010,\u001a\u00020)2\u0006\u0010\f\u001a\u00020\u0005H'J\u0010\u0010-\u001a\u00020)2\u0006\u0010\f\u001a\u00020\u0005H&¨\u0006."}, d2 = {"Lcom/ss/android/lark/vfs/FileSystem;", "Ljava/io/Serializable;", "getName", "", "resolvePath", "Lcom/ss/android/lark/vfs/VFSPath;", "uri", "Landroid/net/Uri;", "onInstalled", "", "fms", "Lcom/ss/android/lark/vfs/FileSystemManager;", "path", "openInput", "Ljava/io/InputStream;", "openOutput", "Ljava/io/OutputStream;", "append", "", "randomAccessFile", "Ljava/io/RandomAccessFile;", "mode", "list", "", "(Lcom/ss/android/lark/vfs/VFSPath;)[Ljava/lang/String;", "listFiles", "Lcom/ss/android/lark/vfs/VFSFile;", "(Lcom/ss/android/lark/vfs/VFSPath;)[Lcom/ss/android/lark/vfs/VFSFile;", "exists", "delete", "size", "", "lastModified", "createNewFile", "mkdirs", "move", "src", "dest", "isFile", "isDirectory", "afterWriteCompat", "Ljava/io/File;", "originalFile", "beforeReadCompat", "getReadFile", "getWriteFile", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FileSystem extends Serializable {
    File afterWriteCompat(VFSFile r100);

    File beforeReadCompat(VFSFile r100);

    boolean createNewFile(VFSPath r100);

    boolean delete(VFSPath r100);

    boolean exists(VFSPath r100);

    String getName();

    File getReadFile(VFSPath r100);

    File getWriteFile(VFSPath r100);

    boolean isDirectory(VFSPath r100);

    boolean isFile(VFSPath r100);

    long lastModified(VFSPath r100);

    String[] list(VFSPath r100);

    VFSFile[] listFiles(VFSPath r100);

    boolean mkdirs(VFSPath r100);

    boolean move(VFSPath r100, VFSPath r101);

    void onInstalled(FileSystemManager r100, VFSPath r101);

    InputStream openInput(VFSPath r100);

    OutputStream openOutput(VFSPath r100, boolean r101);

    RandomAccessFile randomAccessFile(VFSPath r100, String r101);

    VFSPath resolvePath(Uri r100);

    long size(VFSPath r100);
}
