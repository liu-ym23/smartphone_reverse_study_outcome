package com.facebook.cache.disk;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicDefaultDiskStorage implements DiskStorage {
    private static final Class<?> TAG = null;
    private final String mBaseDirectoryName;
    private final Supplier<File> mBaseDirectoryPathSupplier;
    private final CacheErrorLogger mCacheErrorLogger;
    private final String mConfigBaseDirectoryName;
    private final Supplier<File> mConfigBaseDirectoryPathSupplier;
    volatile State mCurrentState;
    private final int mVersion;

    public static class State {

        @Nullable
        public final DiskStorage delegate;

        @Nullable
        public final File rootDirectory;

        public State(@Nullable File r100, @Nullable DiskStorage r101) {
            this.delegate = r101;
            this.rootDirectory = r100;
        }
    }

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

    static {
        TAG = DynamicDefaultDiskStorage.class;
    }

    private void createStorage() throws IOException {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.mConfigBaseDirectoryPathSupplier.get(), this.mConfigBaseDirectoryName);
        createRootDirectoryIfNecessary(r100);
        createConfigRootDirectoryIfNecessary(r101);
        this.mCurrentState = new State(r100, new DefaultDiskStorage(r100, r101, this.mVersion, this.mCacheErrorLogger));
    }

    private boolean shouldCreateNewStorage() {
        State r100 = this.mCurrentState;
        if (r100.delegate == null) goto L10;
        File r101 = r100.rootDirectory;
        if (r101 == null) goto L10;
        if (r101.exists() == false) goto L10;
        return false;
    L10:
        return true;
    }

    public void deleteOldStorageIfNecessary() {
        if (this.mCurrentState.delegate != null) goto L5;
        return;
    L5:
        if (this.mCurrentState.rootDirectory == null) goto L9;
        FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
        return;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() throws IOException {
        get().clearAll();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Collection<DiskStorage.Entry> getConfigEntries() throws IOException {
        return get().getConfigEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public List<DiskStorage.Entry> getDiskCacheEntries() throws IOException {
        return get().getDiskCacheEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        return get().getDumpInfo();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Collection<DiskStorage.Entry> getEntries() throws IOException {
        return get().getEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public String getStorageName() {
        return get().getStorageName();
    L4:
        return "";
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        return get().isEnabled();
    L4:
        return false;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        return get().isExternal();
    L4:
        return false;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        get().purgeUnexpectedResources();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        FLog.e(TAG, "purgeUnexpectedResources", e);
    }

    public void createConfigRootDirectoryIfNecessary(File r100) throws IOException {
        FileUtils.mkdirs(r100);     // Catch: FileUtils.CreateDirectoryException -> L4
    L5:
        FLog.d(TAG, "Created config directory %s", r100.getAbsolutePath());
        return;
    L4:
        FLog.e(TAG, "create config directory %s failed", new Object[]{r100.getAbsoluteFile()});
        goto L5
    }

    public void createRootDirectoryIfNecessary(File r100) throws IOException {
        FileUtils.mkdirs(r100);     // Catch: FileUtils.CreateDirectoryException -> L5
        FLog.d(TAG, "Created cache directory %s", r100.getAbsolutePath());
        return;
    L5:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "createRootDirectoryIfNecessary", e);
        throw e;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry r100) throws IOException {
        return get().remove(r100);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long removeConfig(String r100) throws IOException {
        return get().removeConfig(r100);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String r100) throws IOException {
        return get().remove(r100);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String r100, Object r101) throws IOException {
        return get().contains(r100, r101);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public BinaryResource getResource(String r100, Object r101) throws IOException {
        return get().getResource(r100, r101);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Map<String, String> getResourceConfig(String r100, Object r101) throws IOException {
        return get().getResourceConfig(r100, r101);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String r100, Object r101) throws IOException {
        return get().insert(r100, r101);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(String r100, Object r101) throws IOException {
        return get().touch(r100, r101);
    }

    public DynamicDefaultDiskStorage(int r100, Supplier<File> r101, String r102, Supplier<File> r103, String r104, CacheErrorLogger r105) {
        this.mVersion = r100;
        this.mCacheErrorLogger = r105;
        this.mBaseDirectoryPathSupplier = r101;
        this.mBaseDirectoryName = r102;
        this.mConfigBaseDirectoryPathSupplier = r103;
        this.mConfigBaseDirectoryName = r104;
        this.mCurrentState = new State(null, null);
    }
}
