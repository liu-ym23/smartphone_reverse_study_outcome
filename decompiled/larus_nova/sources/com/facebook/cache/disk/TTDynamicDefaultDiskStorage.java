package com.facebook.cache.disk;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.common.file.FileTree;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public class TTDynamicDefaultDiskStorage extends DynamicDefaultDiskStorage implements TTDiskStorage {
    private final String mBaseDirectoryName;
    private final Supplier<File> mBaseDirectoryPathSupplier;
    private final CacheErrorLogger mCacheErrorLogger;
    private final String mConfigBaseDirectoryName;
    private final Supplier<File> mConfigBaseDirectoryPathSupplier;
    private final int mVersion;

    @Override // com.facebook.cache.disk.DynamicDefaultDiskStorage
    public synchronized DiskStorage get() throws IOException {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (shouldCreateNewStorage() == false) goto L6;
        deleteOldStorageIfNecessary();     // Catch: Throwable -> L9
        createStorage();     // Catch: Throwable -> L9
    L6:
        DiskStorage r100 = (DiskStorage) Preconditions.checkNotNull(this.mCurrentState.delegate);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    private void createStorage() throws IOException {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.mConfigBaseDirectoryPathSupplier.get(), this.mConfigBaseDirectoryName);
        createRootDirectoryIfNecessary(r100);
        createConfigRootDirectoryIfNecessary(r101);
        this.mCurrentState = new DynamicDefaultDiskStorage.State(r100, new TTDefaultDiskStorage(r100, r101, this.mVersion, this.mCacheErrorLogger));
    }

    private boolean shouldCreateNewStorage() {
        DynamicDefaultDiskStorage.State r100 = this.mCurrentState;
        if (r100.delegate == null) goto L10;
        File r101 = r100.rootDirectory;
        if (r101 == null) goto L10;
        if (r101.exists() == false) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.facebook.cache.disk.DynamicDefaultDiskStorage
    public void deleteOldStorageIfNecessary() {
        if (this.mCurrentState.delegate != null) goto L5;
        return;
    L5:
        if (this.mCurrentState.rootDirectory == null) goto L9;
        FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
        return;
    }

    @Override // com.facebook.cache.disk.TTDiskStorage
    public BinaryResource getTempResource(String r100, Object r101) throws IOException {
        if ((get() instanceof TTDiskStorage) == true) goto L5;
        return null;
    L5:
        return ((TTDiskStorage) get()).getTempResource(r100, r101);
    }

    @Override // com.facebook.cache.disk.TTDiskStorage
    public DiskStorage.Inserter insertTemp(String r100, int r101, Object r102) throws IOException {
        if ((get() instanceof TTDiskStorage) == true) goto L5;
        return null;
    L5:
        return ((TTDiskStorage) get()).insertTemp(r100, r101, r102);
    }

    public TTDynamicDefaultDiskStorage(int r100, Supplier<File> r101, String r110, CacheErrorLogger r111, Supplier<File> r112, String r113) {
        super(r100, r101, r110, r112, r113, r111);
        this.mVersion = r100;
        this.mCacheErrorLogger = r111;
        this.mBaseDirectoryPathSupplier = r101;
        this.mBaseDirectoryName = r110;
        this.mConfigBaseDirectoryPathSupplier = r112;
        this.mConfigBaseDirectoryName = r113;
    }
}
