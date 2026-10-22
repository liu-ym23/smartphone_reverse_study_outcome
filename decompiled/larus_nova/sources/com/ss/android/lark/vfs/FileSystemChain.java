package com.ss.android.lark.vfs;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0002J&\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tJ\u0014\u0010\u001c\u001a\u00020\u001a2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0013J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020-2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u001eH\u0016J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001e0/2\u0006\u0010%\u001a\u00020\u0003H\u0016¢\u0006\u0002\u00100J\u001b\u00101\u001a\b\u0012\u0004\u0012\u0002020/2\u0006\u0010%\u001a\u00020\u0003H\u0016¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u00105\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u00106\u001a\u0002072\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u00108\u001a\u0002072\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u00109\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u0010:\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0018\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0003H\u0016J\u0010\u0010>\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u0010?\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u000202H\u0016J\u0010\u0010C\u001a\u00020A2\u0006\u0010B\u001a\u000202H\u0016J\u0010\u0010D\u001a\u00020A2\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u0010E\u001a\u00020A2\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0013\u0010F\u001a\u00020+2\b\u0010G\u001a\u0004\u0018\u00010HH\u0096\u0002J\b\u0010I\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006J"}, d2 = {"Lcom/ss/android/lark/vfs/FileSystemChain;", "Lcom/ss/android/lark/vfs/FileSystem;", "targetPath", "Lcom/ss/android/lark/vfs/VFSPath;", "schemeFileSystem", "<init>", "(Lcom/ss/android/lark/vfs/VFSPath;Lcom/ss/android/lark/vfs/FileSystem;)V", "factoryList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/vfs/FileSystemManager$FileSystemFactory;", "Lkotlin/collections/ArrayList;", "fileSystem", "getFileSystem", "()Lcom/ss/android/lark/vfs/FileSystem;", "fileSystem$delegate", "Lkotlin/Lazy;", "createChainedFileSystem", RootDescription.ROOT_ELEMENT, "extendList", "", "createByIndex", "delegate", "list", "index", "", "addFileSystem", "", "factory", "addFileSystems", "getName", "", "resolvePath", "uri", "Landroid/net/Uri;", "onInstalled", "fms", "Lcom/ss/android/lark/vfs/FileSystemManager;", "path", "openInput", "Ljava/io/InputStream;", "openOutput", "Ljava/io/OutputStream;", "append", "", "randomAccessFile", "Ljava/io/RandomAccessFile;", "mode", "", "(Lcom/ss/android/lark/vfs/VFSPath;)[Ljava/lang/String;", "listFiles", "Lcom/ss/android/lark/vfs/VFSFile;", "(Lcom/ss/android/lark/vfs/VFSPath;)[Lcom/ss/android/lark/vfs/VFSFile;", "exists", "delete", "size", "", "lastModified", "createNewFile", "mkdirs", "move", "src", "dest", "isFile", "isDirectory", "afterWriteCompat", "Ljava/io/File;", "originalFile", "beforeReadCompat", "getReadFile", "getWriteFile", "equals", "other", "", "hashCode", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileSystemChain implements FileSystem {
    private final ArrayList<FileSystemManager.FileSystemFactory> factoryList;
    private final Lazy fileSystem$delegate;
    private final FileSystem schemeFileSystem;
    private final VFSPath targetPath;

    public final FileSystem getFileSystem() {
        return (FileSystem) this.fileSystem$delegate.getValue();
    }

    public int hashCode() {
        return (this.schemeFileSystem.hashCode() * 31) + this.factoryList.hashCode();
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public String getName() {
        return getFileSystem().getName();
    }

    public static final /* synthetic */ ArrayList access$getFactoryList$p(FileSystemChain r100) {
        return r100.factoryList;
    }

    public static final /* synthetic */ FileSystem access$getSchemeFileSystem$p(FileSystemChain r100) {
        return r100.schemeFileSystem;
    }

    public final void addFileSystem(FileSystemManager.FileSystemFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        if (this.factoryList.contains(r100) == true) goto L6;
        this.factoryList.add(r100);
        return;
    }

    public final void addFileSystems(List<? extends FileSystemManager.FileSystemFactory> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        FileSystemManager.FileSystemFactory r102 = (FileSystemManager.FileSystemFactory) r101.next();
        this.factoryList.add(r102);
        goto L4
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File afterWriteCompat(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return getFileSystem().afterWriteCompat(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File beforeReadCompat(VFSFile r100) {
        Intrinsics.checkNotNullParameter(r100, "originalFile");
        return getFileSystem().beforeReadCompat(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean createNewFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().createNewFile(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean delete(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().delete(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileSystemChain) == true) goto L8;
        return false;
    L8:
        FileSystemChain r101 = (FileSystemChain) r100;
        if (Intrinsics.areEqual(this.schemeFileSystem, r101.schemeFileSystem) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.factoryList, r101.factoryList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean exists(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().exists(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File getReadFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().getReadFile(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public File getWriteFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().getWriteFile(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean isDirectory(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().isDirectory(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean isFile(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().isFile(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public long lastModified(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().lastModified(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public String[] list(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().list(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public VFSFile[] listFiles(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().listFiles(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean mkdirs(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().mkdirs(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public InputStream openInput(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().openInput(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public VFSPath resolvePath(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return getFileSystem().resolvePath(r100);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public long size(VFSPath r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().size(r100);
    }

    public FileSystemChain(VFSPath r100, FileSystem r101) {
        Intrinsics.checkNotNullParameter(r100, "targetPath");
        Intrinsics.checkNotNullParameter(r101, "schemeFileSystem");
        this.targetPath = r100;
        this.schemeFileSystem = r101;
        this.factoryList = new ArrayList();
        this.fileSystem$delegate = LazyKt.lazy(new FileSystemChain$fileSystem$2(this));
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public boolean move(VFSPath r100, VFSPath r101) {
        Intrinsics.checkNotNullParameter(r100, "src");
        Intrinsics.checkNotNullParameter(r101, "dest");
        return getFileSystem().move(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public void onInstalled(FileSystemManager r100, VFSPath r101) {
        Intrinsics.checkNotNullParameter(r100, "fms");
        Intrinsics.checkNotNullParameter(r101, "path");
        getFileSystem().onInstalled(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public OutputStream openOutput(VFSPath r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return getFileSystem().openOutput(r100, r101);
    }

    @Override // com.ss.android.lark.vfs.FileSystem
    public RandomAccessFile randomAccessFile(VFSPath r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "mode");
        return getFileSystem().randomAccessFile(r100, r101);
    }

    public static FileSystem a(FileSystem r100, List r101, int r102) {
        if (r102 >= 0) goto L4;
        return r100;
    L4:
        if (r102 > r101.size()) goto L12;
        if (r102 != 0) goto L9;
        return ((FileSystemManager.FileSystemFactory) ListProtector.get(r101, 0)).create(r100);
    L9:
        return ((FileSystemManager.FileSystemFactory) ListProtector.get(r101, r102)).create(a(r100, r101, r102 - 1));
    L12:
        return r100;
    }

    public static final FileSystem access$createChainedFileSystem(FileSystemChain r100, FileSystem r101, List r102) {
        return a(r101, r102, r100.factoryList.size() - 1);
    }
}
