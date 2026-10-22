package com.ss.android.lark.vfs;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u000f\u001a\u00020\f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/vfs/ChainedFileSystemFactory;", "Lcom/ss/android/lark/vfs/FileSystemManager$FileSystemFactory;", "initFactory", "<init>", "(Lcom/ss/android/lark/vfs/FileSystemManager$FileSystemFactory;)V", "factoryList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addFactory", "", "factory", "create", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "createByIndex", "list", "index", "", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChainedFileSystemFactory extends FileSystemManager.FileSystemFactory {
    private final ArrayList<FileSystemManager.FileSystemFactory> factoryList;

    public ChainedFileSystemFactory(FileSystemManager.FileSystemFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "initFactory");
        ArrayList<FileSystemManager.FileSystemFactory> r101 = new ArrayList();
        r101.add(r100);
        this.factoryList = r101;
    }

    public final void addFactory(FileSystemManager.FileSystemFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        if (this.factoryList.contains(r100) == true) goto L6;
        this.factoryList.add(r100);
        return;
    }

    @Override // com.ss.android.lark.vfs.FileSystemManager.FileSystemFactory
    public ChainedFileSystem create(FileSystem r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        ArrayList<FileSystemManager.FileSystemFactory> r101 = this.factoryList;
        return a(r101, r101.size() - 1, r100);
    }

    public static ChainedFileSystem a(ArrayList r100, int r101, FileSystem r102) {
        if (r101 != 0) goto L5;
        return ((FileSystemManager.FileSystemFactory) ListProtector.get(r100, 0)).create(r102);
    L5:
        return ((FileSystemManager.FileSystemFactory) ListProtector.get(r100, r101)).create(a(r100, r101 - 1, r102));
    }
}
