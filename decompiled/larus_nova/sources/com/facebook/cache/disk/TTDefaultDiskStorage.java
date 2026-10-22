package com.facebook.cache.disk;

import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.image.entity.LoadParams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public class TTDefaultDiskStorage implements TTDiskStorage {
    private static final String CONTENT_FILE_EXTENSION = ".cnt";
    private static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
    private static final int SHARDING_BUCKET_COUNT = 100;
    private static final Class<?> TAG = null;
    private static final String TEMP_FILE_EXTENSION = ".tmp";
    static final long TEMP_FILE_LIFETIME_MS = 0;
    private final CacheErrorLogger mCacheErrorLogger;
    private final Clock mClock;
    private final File mConfigRootDirectory;
    private final File mConfigVersionDirectory;
    private final boolean mIsExternal;
    private final File mOldConfigVersionDirectory;
    private final File mRootDirectory;
    private final File mVersionDirectory;

    /* JADX INFO: renamed from: com.facebook.cache.disk.TTDefaultDiskStorage$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class ConfigEntriesCollector implements FileTreeVisitor {
        private FileCategory mFileCategory;
        private final List<DiskStorage.Entry> result;
        final /* synthetic */ TTDefaultDiskStorage this$0;

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File r100) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File r100) {
        }

        public List<DiskStorage.Entry> getEntries() {
            return Collections.unmodifiableList(this.result);
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File r100) {
            AnonymousClass1 r101 = null;
            if (this.mFileCategory != FileCategory.CONFIG_FILE) goto L9;
            FileInfo r102 = TTDefaultDiskStorage.access$1000(this.this$0, r100);
            if (r102 != null) goto L7;
            return;
        L7:
            if (r102.type != FileType.CONTENT) goto L21;
            this.result.add(new EntryImpl(r102.resourceId, r100, r101));
            return;
        L21:
            return;
        L9:
            FileInfo r103 = TTDefaultDiskStorage.access$000(this.this$0, r100);
            if (r103 == null) goto L23;
            FileType r104 = r103.type;
            if (r104 != FileType.CONTENT) goto L14;
        L15:
            EntryImpl r105 = new EntryImpl(r103.resourceId, r100, r101);
            FileType r106 = r103.type;
            FileType r107 = FileType.TEMP;
            if (r106 != r107) goto L18;
            EntryImpl.access$1100(r105, r107);
        L18:
            this.result.add(r105);
            return;
        L14:
            if (r104 == FileType.TEMP) goto L15;
            return;
        }

        public ConfigEntriesCollector(TTDefaultDiskStorage r100, FileCategory r101) {
            this.this$0 = r100;
            this.result = new ArrayList();
            this.mFileCategory = r101;
        }
    }

    public class EntriesCollector implements FileTreeVisitor {
        private final List<DiskStorage.Entry> result;
        final /* synthetic */ TTDefaultDiskStorage this$0;

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File r100) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File r100) {
        }

        public List<DiskStorage.Entry> getEntries() {
            return Collections.unmodifiableList(this.result);
        }

        private EntriesCollector(TTDefaultDiskStorage r100) {
            this.this$0 = r100;
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File r100) {
            FileInfo r101 = TTDefaultDiskStorage.access$000(this.this$0, r100);
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.type != FileType.CONTENT) goto L9;
            this.result.add(new EntryImpl(r101.resourceId, r100, null));
            return;
        }

        public /* synthetic */ EntriesCollector(TTDefaultDiskStorage r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static class EntryImpl implements DiskStorage.Entry {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f274103id;
        private final FileBinaryResource resource;
        private long size;
        private long timestamp;
        private FileType type;

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getSize() {
            if (this.size >= 0) goto L6;
            this.size = this.resource.size();
        L6:
            return this.size;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getTimestamp() {
            if (this.timestamp >= 0) goto L6;
            this.timestamp = this.resource.getFile().lastModified();
        L6:
            return this.timestamp;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public int getVisitCount() {
            return DiskCacheUtil.getVisitCount(this.f274103id);
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public boolean isContentFile() {
            if (this.type != FileType.CONTENT) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public /* bridge */ /* synthetic */ BinaryResource getResource() {
            return getResource();
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public String getId() {
            return this.f274103id;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public FileBinaryResource getResource() {
            return this.resource;
        }

        private void setType(FileType r100) {
            this.type = r100;
        }

        private EntryImpl(String r100, File r101) {
            this.type = FileType.CONTENT;
            Preconditions.checkNotNull(r101);
            this.f274103id = (String) Preconditions.checkNotNull(r100);
            this.resource = FileBinaryResource.createOrNull(r101);
            this.size = -1;
            this.timestamp = -1;
        }

        public static /* synthetic */ void access$1100(EntryImpl r100, FileType r101) {
            r100.setType(r101);
        }

        public /* synthetic */ EntryImpl(String r100, File r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static final enum FileCategory extends Enum<FileCategory> {
        private static final /* synthetic */ FileCategory[] $VALUES = null;
        public static final FileCategory CONFIG_FILE = null;
        public static final FileCategory IMAGE_CACHE_FILE = null;

        static {
            FileCategory r100 = new FileCategory("IMAGE_CACHE_FILE", 0);
            IMAGE_CACHE_FILE = r100;
            FileCategory r101 = new FileCategory("CONFIG_FILE", 1);
            CONFIG_FILE = r101;
            $VALUES = new FileCategory[]{r100, r101};
        }

        public static FileCategory[] values() {
            return (FileCategory[]) $VALUES.clone();
        }

        public static FileCategory valueOf(String r100) {
            return (FileCategory) Enum.valueOf(FileCategory.class, r100);
        }

        private FileCategory(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class FileInfo {
        public final String resourceId;
        public final FileType type;

        public String toString() {
            return this.type + "(" + this.resourceId + ")";
        }

        public static FileInfo fromFile(File r100) {
            String r101 = r100.getName();
            int r102 = r101.lastIndexOf(46);
            if (r102 > 0) goto L5;
            return null;
        L5:
            FileType r103 = FileType.fromExtension(r101.substring(r102));
            if (r103 != null) goto L8;
            return null;
        L8:
            String r104 = r101.substring(0, r102);
            if (r103.equals(FileType.TEMP) == false) goto L15;
            int r105 = r104.lastIndexOf(46);
            if (r105 > 0) goto L13;
            return null;
        L13:
            r104 = r104.substring(0, r105);
        L15:
            return new FileInfo(r103, r104);
        }

        public File createTempFile(File r100) throws IOException {
            PolarisFileWrapper r101 = new PolarisFileWrapper(r100, this.resourceId + ".tmp");
            if (r101.exists() == true) goto L5;
            r101.createNewFile();
        L5:
            return r101;
        }

        public String toPath(String r100) {
            return r100 + File.separator + this.resourceId + this.type.extension;
        }

        private FileInfo(FileType r100, String r101) {
            this.type = r100;
            this.resourceId = r101;
        }

        public /* synthetic */ FileInfo(FileType r100, String r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static final enum FileType extends Enum<FileType> {
        private static final /* synthetic */ FileType[] $VALUES = null;
        public static final FileType CONTENT = null;
        public static final FileType TEMP = null;
        public final String extension;

        static {
            FileType r100 = new FileType("CONTENT", 0, ".cnt");
            CONTENT = r100;
            FileType r101 = new FileType("TEMP", 1, ".tmp");
            TEMP = r101;
            $VALUES = new FileType[]{r100, r101};
        }

        public static FileType[] values() {
            return (FileType[]) $VALUES.clone();
        }

        public static FileType fromExtension(String r100) {
            if (".cnt".equals(r100) == false) goto L7;
            return CONTENT;
        L7:
            if (".tmp".equals(r100) == true) goto L9;
            return null;
        L9:
            return TEMP;
        }

        public static FileType valueOf(String r100) {
            return (FileType) Enum.valueOf(FileType.class, r100);
        }

        private FileType(String r100, int r101, String r102) {
            super(r100, r101);
            this.extension = r102;
        }
    }

    public static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long r100, long r101) {
            super("File was not written completely. Expected: " + r100 + ", found: " + r101);
            this.expected = r100;
            this.actual = r101;
        }
    }

    public class InserterImpl implements DiskStorage.Inserter {
        private final String mResourceId;
        final File mTemporaryFile;
        final /* synthetic */ TTDefaultDiskStorage this$0;

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public boolean cleanUp() {
            if (this.mTemporaryFile.exists() == true) goto L5;
        L8:
            return true;
        L5:
            if (this.mTemporaryFile.delete() == true) goto L8;
            return false;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public BinaryResource commit(Object r100) throws IOException {
            File r101 = this.this$0.getContentFileFor(this.mResourceId);
            FileUtils.rename(this.mTemporaryFile, r101);     // Catch: FileUtils.RenameException -> L9
            if (r101.exists() == false) goto L8;
            r101.setLastModified(TTDefaultDiskStorage.access$400(this.this$0).now());
        L8:
            return FileBinaryResource.createOrNull(r101);
        L9:
            e = move-exception;
            Throwable r102 = e.getCause();
            if (r102 != null) goto L13;
            CacheErrorLogger.CacheErrorCategory r103 = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
        L20:
            TTDefaultDiskStorage.access$900(this.this$0).logError(r103, TTDefaultDiskStorage.access$800(), "commit", e);
            throw e;
        L13:
            if ((r102 instanceof FileUtils.ParentDirNotFoundException) == false) goto L15;
            r103 = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
            goto L20
        L15:
            if ((r102 instanceof FileNotFoundException) == false) goto L17;
            r103 = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
            goto L20
        L17:
            r103 = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
            goto L20
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public void writeData(WriterCallback r100, Object r101) throws IOException {
            PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(this.mTemporaryFile);     // Catch: FileNotFoundException -> L12
            CountingOutputStream r103 = new CountingOutputStream(r102);     // Catch: Throwable -> L9
            r100.write(r103);     // Catch: Throwable -> L9
            r103.flush();     // Catch: Throwable -> L9
            long r104 = r103.getCount();     // Catch: Throwable -> L9
            r102.close();
            if (this.mTemporaryFile.length() != r104) goto L8;
            return;
        L8:
            throw new IncompleteFileException(r104, this.mTemporaryFile.length());
        L9:
            th = move-exception;
            r102.close();
            throw th;
        L12:
            e = move-exception;
            TTDefaultDiskStorage.access$900(this.this$0).logError(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, TTDefaultDiskStorage.access$800(), "updateResource", e);
            throw e;
        }

        public InserterImpl(TTDefaultDiskStorage r100, String r101, File r102) {
            this.this$0 = r100;
            this.mResourceId = r101;
            this.mTemporaryFile = r102;
        }
    }

    public class PurgingVisitor implements FileTreeVisitor {
        private boolean insideBaseDirectory;
        final /* synthetic */ TTDefaultDiskStorage this$0;

        private PurgingVisitor(TTDefaultDiskStorage r100) {
            this.this$0 = r100;
        }

        private boolean isExpectedFile(File r100) {
            FileInfo r101 = TTDefaultDiskStorage.access$000(this.this$0, r100);
            boolean r102 = false;
            if (r101 != null) goto L5;
            return false;
        L5:
            FileType r103 = r101.type;
            if (r103 != FileType.TEMP) goto L10;
            return isRecentFile(r100);
        L10:
            if (r103 != FileType.CONTENT) goto L12;
            r102 = true;
        L12:
            Preconditions.checkState(r102);
            return true;
        }

        private boolean isRecentFile(File r100) {
            if (r100.lastModified() <= (TTDefaultDiskStorage.access$400(this.this$0).now() - TTDefaultDiskStorage.TEMP_FILE_LIFETIME_MS)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File r100) {
            if (TTDefaultDiskStorage.access$300(this.this$0).equals(r100) == true) goto L8;
            if (this.insideBaseDirectory == true) goto L8;
            r100.delete();
        L8:
            if (this.insideBaseDirectory == true) goto L10;
            return;
        L10:
            if (r100.equals(TTDefaultDiskStorage.access$200(this.this$0)) == false) goto L14;
            this.insideBaseDirectory = false;
            return;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File r100) {
            if (this.insideBaseDirectory == false) goto L5;
            return;
        L5:
            if (r100.equals(TTDefaultDiskStorage.access$200(this.this$0)) == false) goto L9;
            this.insideBaseDirectory = true;
            return;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File r100) {
            if (this.insideBaseDirectory == true) goto L5;
        L6:
            r100.delete();
            return;
        L5:
            if (isExpectedFile(r100) == false) goto L6;
        }

        public /* synthetic */ PurgingVisitor(TTDefaultDiskStorage r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public class TempInserterImpl extends InserterImpl {
        private CountingOutputStream countingStream;
        private FileOutputStream fileStream;
        private boolean isFinal;
        private int offset;
        final /* synthetic */ TTDefaultDiskStorage this$0;

        @Override // com.facebook.cache.disk.TTDefaultDiskStorage.InserterImpl, com.facebook.cache.disk.DiskStorage.Inserter
        public /* bridge */ /* synthetic */ boolean cleanUp() {
            return super.cleanUp();
        }

        public CountingOutputStream getCountingStream() {
            return this.countingStream;
        }

        @Override // com.facebook.cache.disk.TTDefaultDiskStorage.InserterImpl, com.facebook.cache.disk.DiskStorage.Inserter
        public /* bridge */ /* synthetic */ BinaryResource commit(Object r100) throws IOException {
            return super.commit(r100);
        }

        public void setFinal(boolean r100) {
            this.isFinal = r100;
        }

        @Override // com.facebook.cache.disk.TTDefaultDiskStorage.InserterImpl, com.facebook.cache.disk.DiskStorage.Inserter
        public void writeData(WriterCallback r100, Object r101) throws IOException {
            File r102 = this.mTemporaryFile;     // Catch: FileNotFoundException -> L28
            if (r102 == null) goto L9;
            long r103 = r102.length();     // Catch: FileNotFoundException -> L28
            int r104 = this.offset;     // Catch: FileNotFoundException -> L28
            if (r103 == r104) goto L9;
            if (r104 <= 0) goto L9;
            return;
        L9:
            if (this.fileStream != null) goto L33;
            File r105 = this.mTemporaryFile;     // Catch: FileNotFoundException -> L28
            if (this.offset <= 0) goto L13;
            boolean r106 = true;
        L14:
            this.fileStream = new PolarisFileOutputStreamWrapper(r105, r106);     // Catch: FileNotFoundException -> L28
            goto L33
        L13:
            r106 = false;
        L33:
        L23:
            th = move-exception;
            if (this.isFinal == false) goto L27;
            this.fileStream.close();
        L27:
            throw th;
        L16:
            if (this.countingStream != null) goto L18;
            this.countingStream = new CountingOutputStream(this.fileStream);     // Catch: Throwable -> L23
        L18:
            r100.write(this.countingStream);     // Catch: Throwable -> L23
            this.countingStream.flush();     // Catch: Throwable -> L23
            if (this.isFinal == false) goto L35;
            this.fileStream.close();
            return;
        L35:
            return;
        L28:
            e = move-exception;
            TTDefaultDiskStorage.access$900(this.this$0).logError(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, TTDefaultDiskStorage.access$800(), "updateResource", e);
            throw e;
        }

        public TempInserterImpl(TTDefaultDiskStorage r100, String r101, int r102, File r103) {
            this.this$0 = r100;
            super(r100, r101, r103);
            this.isFinal = false;
            this.offset = r102;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        return true;
    }

    static {
        TAG = DefaultDiskStorage.class;
        TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30);
    }

    private void recreateConfigDirectoryIfVersionChanges() {
        boolean r100 = true;
        if (this.mRootDirectory.exists() == true) goto L6;
    L9:
        if (r100 == false) goto L16;
        FileUtils.mkdirs(this.mVersionDirectory);     // Catch: FileUtils.CreateDirectoryException -> L12
        return;
    L12:
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "version directory could not be created: " + this.mVersionDirectory, null);
        return;
    L16:
        return;
    L6:
        if (this.mVersionDirectory.exists() == true) goto L8;
        FileTree.deleteRecursively(this.mRootDirectory);
        goto L9
    L8:
        r100 = false;
        goto L9
    }

    private void recreateDirectoryIfVersionChanges() {
        boolean r100 = true;
        if (this.mRootDirectory.exists() == true) goto L6;
    L9:
        if (r100 == false) goto L16;
        FileUtils.mkdirs(this.mVersionDirectory);     // Catch: FileUtils.CreateDirectoryException -> L12
        return;
    L12:
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "version directory could not be created: " + this.mVersionDirectory, null);
        return;
    L16:
        return;
    L6:
        if (this.mVersionDirectory.exists() == true) goto L8;
        FileTree.deleteRecursively(this.mRootDirectory);
        goto L9
    L8:
        r100 = false;
        goto L9
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() {
        FileTree.deleteContents(this.mRootDirectory);
        FileTree.deleteContents(this.mConfigRootDirectory);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public List<DiskStorage.Entry> getConfigEntries() throws IOException {
        ConfigEntriesCollector r100 = new ConfigEntriesCollector(this, FileCategory.CONFIG_FILE);
        FileTree.walkFileTree(this.mConfigVersionDirectory, r100);
        return r100.getEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public List<DiskStorage.Entry> getDiskCacheEntries() throws IOException {
        ConfigEntriesCollector r100 = new ConfigEntriesCollector(this, FileCategory.IMAGE_CACHE_FILE);
        FileTree.walkFileTree(this.mVersionDirectory, r100);
        return r100.getEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public List<DiskStorage.Entry> getEntries() throws IOException {
        EntriesCollector r100 = new EntriesCollector(this, null);
        FileTree.walkFileTree(this.mVersionDirectory, r100);
        return r100.getEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public String getStorageName() {
        String r100 = this.mRootDirectory.getAbsolutePath();
        return "_" + r100.substring(r100.lastIndexOf(47) + 1, r100.length()) + "_" + r100.hashCode();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        FileTree.walkFileTree(this.mRootDirectory, new PurgingVisitor(this, null));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        List<DiskStorage.Entry> r100 = getEntries();
        DiskStorage.DiskDumpInfo r101 = new DiskStorage.DiskDumpInfo();
        Iterator<DiskStorage.Entry> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        DiskStorage.DiskDumpInfoEntry r103 = dumpCacheEntry(r102.next());
        String r104 = r103.type;
        if (r101.typeCounts.containsKey(r104) == true) goto L8;
        r101.typeCounts.put(r104, 0);
    L8:
        Map<String, Integer> r105 = r101.typeCounts;
        r105.put(r104, Integer.valueOf(r105.get(r104).intValue() + 1));
        r101.entries.add(r103);
        goto L4
    L9:
        return r101;
    }

    public static /* synthetic */ Class access$800() {
        return TAG;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        return this.mIsExternal;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public /* bridge */ /* synthetic */ Collection getConfigEntries() throws IOException {
        return getConfigEntries();
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public /* bridge */ /* synthetic */ Collection getEntries() throws IOException {
        return getEntries();
    }

    public static /* synthetic */ File access$200(TTDefaultDiskStorage r100) {
        return r100.mVersionDirectory;
    }

    public static /* synthetic */ File access$300(TTDefaultDiskStorage r100) {
        return r100.mRootDirectory;
    }

    public static /* synthetic */ Clock access$400(TTDefaultDiskStorage r100) {
        return r100.mClock;
    }

    public static /* synthetic */ CacheErrorLogger access$900(TTDefaultDiskStorage r100) {
        return r100.mCacheErrorLogger;
    }

    private long doRemove(File r100) {
        if (r100.exists() == true) goto L6;
        return 0;
    L6:
        long r101 = r100.length();
        if (r100.delete() == false) goto L9;
        return r101;
    L9:
        return -1;
    }

    private DiskStorage.DiskDumpInfoEntry dumpCacheEntry(DiskStorage.Entry r100) throws IOException {
        EntryImpl r101 = (EntryImpl) r100;
        byte[] r102 = r101.getResource().read();
        String r103 = typeOfBytes(r102);
        if (r103.equals("undefined") == true) goto L5;
    L7:
        String r104 = "";
    L9:
        return new DiskStorage.DiskDumpInfoEntry(r101.getResource().getFile().getPath(), r103, r101.getSize(), r104);
    L5:
        if (r102.length < 4) goto L7;
        r104 = String.format(null, "0x%02X 0x%02X 0x%02X 0x%02X", new Object[]{Byte.valueOf(r102[0]), Byte.valueOf(r102[1]), Byte.valueOf(r102[2]), Byte.valueOf(r102[3])});
        goto L9
    }

    private Map<String, String> fileToMap(File r100) {
        HashMap r101 = new HashMap();
        BufferedReader r102 = null;
        String r103 = null;
        BufferedReader r104 = null;
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper(r100));     // Catch: Throwable -> L14 IOException -> L16
    L35:
        String r106 = r105.readLine();     // Catch: Throwable -> L10 IOException -> L12
        if (r106 == null) goto L7;
        String[] r107 = r106.split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L10 IOException -> L12
        String r108 = r107[0];     // Catch: Throwable -> L10 IOException -> L12
        r101.put(r108, r107[1]);     // Catch: Throwable -> L10 IOException -> L12
        r103 = r108;
        goto L35
    L7:
        r105.close();     // Catch: Throwable -> L10 IOException -> L12
        r105.close();     // Catch: IOException -> L24
        r102 = r103;
    L26:
        goto L20
    L12:
        e = e;
        r104 = r105;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L14
        r102 = r104;
        if (r104 == null) goto L26;
        r104.close();     // Catch: IOException -> L24
        r102 = r104;
    L10:
        th = th;
        r102 = r105;
    L21:
        if (r102 != null) goto L30;
    L23:
        throw th;
    L30:
        r102.close();     // Catch: IOException -> L25
    L14:
        th = th;
    L16:
        e = e;
    L20:
        return r101;
    }

    private File getConfigFileFor(String r100) {
        return new PolarisFileWrapper(getConfigSubdirectoryPath(r100));
    }

    private FileInfo getConfigShardFileInfo(File r100) {
        FileInfo r101 = FileInfo.fromFile(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if (new PolarisFileWrapper(getConfigSubdirectoryPath(r101.resourceId)).equals(r100.getParentFile()) == false) goto L9;
        return r101;
    L9:
        return null;
    }

    private String getConfigSubdirectoryPath(String r100) {
        return this.mConfigVersionDirectory + File.separator + String.valueOf(Math.abs(r100.hashCode() % 100));
    }

    private String getFilename(String r100) {
        FileInfo r101 = new FileInfo(FileType.CONTENT, r100, null);
        return r101.toPath(getSubdirectoryPath(r101.resourceId));
    }

    private FileInfo getShardFileInfo(File r100) {
        FileInfo r101 = FileInfo.fromFile(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if (getSubdirectory(r101.resourceId).equals(r100.getParentFile()) == false) goto L9;
        return r101;
    L9:
        return null;
    }

    private File getSubdirectory(String r100) {
        return new PolarisFileWrapper(getSubdirectoryPath(r100));
    }

    private String getSubdirectoryPath(String r100) {
        return this.mVersionDirectory + File.separator + String.valueOf(Math.abs(r100.hashCode() % 100));
    }

    private String getTempFileName(String r100) {
        FileInfo r101 = new FileInfo(FileType.TEMP, r100, null);
        return r101.toPath(getSubdirectoryPath(r101.resourceId));
    }

    public static String getVersionSubdirectoryName(int r100) {
        return String.format(null, "%s.ols%d.%d", new Object[]{"v2", 100, Integer.valueOf(r100)});
    }

    private String typeOfBytes(byte[] r100) {
        if (r100.length < 2) goto L28;
        byte r101 = r100[0];
        if (r101 != (-1)) goto L11;
        if (r100[1] != (-40)) goto L11;
        return "jpg";
    L11:
        if (r101 != (-119)) goto L17;
        if (r100[1] != 80) goto L17;
        return LoadParams.ImageFormat.PNG;
    L17:
        if (r101 != 82) goto L23;
        if (r100[1] != 73) goto L23;
        return "webp";
    L23:
        if (r101 == 71) goto L25;
        return "undefined";
    L25:
        if (r100[1] != 73) goto L31;
        return "gif";
    L31:
        return "undefined";
    L28:
        return "undefined";
    }

    public File getContentFileFor(String r100) {
        return new PolarisFileWrapper(getFilename(r100));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry r100) {
        return doRemove(((EntryImpl) r100).getResource().getFile());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long removeConfig(String r100) {
        String r101 = String.valueOf(Math.abs(r100.hashCode() % 100));
        StringBuilder r102 = new StringBuilder();
        r102.append(this.mOldConfigVersionDirectory);
        String r103 = File.separator;
        r102.append(r103);
        r102.append(r101);
        doRemove(new PolarisFileWrapper(r102.toString() + r103 + r100 + ".cnt"));
        return doRemove(getConfigFileFor(r100));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String r100) {
        return doRemove(getContentFileFor(r100));
    }

    public static /* synthetic */ FileInfo access$000(TTDefaultDiskStorage r100, File r101) {
        return r100.getShardFileInfo(r101);
    }

    public static /* synthetic */ FileInfo access$1000(TTDefaultDiskStorage r100, File r101) {
        return r100.getConfigShardFileInfo(r101);
    }

    private void insertConfigFile(String r100, Object r101) throws IOException {
        if ((r101 instanceof DiskWrapperCacheKey) == true) goto L5;
        return;
    L5:
        DiskWrapperCacheKey r102 = (DiskWrapperCacheKey) r101;
        File r103 = getSubdirectory(r100);
        if (r103.exists() == true) goto L8;
        mkdirs(r103, "insert");
    L8:
        mapToFile(r102.getExtraInfo(), File.createTempFile(r100 + ".", ".cnt", r103));
    }

    private static boolean isExternal(File r100, CacheErrorLogger r101) {
        File r102 = Environment.getExternalStorageDirectory();
        if (r102 == null) goto L13;
        String r103 = r102.toString();
        String r104 = r100.getCanonicalPath();     // Catch: IOException -> L10
        return r104.contains(r103);
    L8:
        e = e;
    L12:
        r101.logError(CacheErrorLogger.CacheErrorCategory.OTHER, TAG, "failed to read folder to check if external: " + r104, e);
    L10:
        e = e;
        r104 = null;
    L13:
        return false;
    }

    private File mapToFile(Map<String, String> r100, File r101) throws IOException {
        StringBuilder r102 = new StringBuilder();
        PolarisFileWriterWrapper r103 = new PolarisFileWriterWrapper(r101, false);
        Iterator<Map.Entry<String, String>> r104 = r100.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<String, String> r105 = r104.next();
        String r106 = r105.getKey();
        String r107 = r105.getValue();
        r102.append(r106);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r107);
        r102.append(System.lineSeparator());
        goto L4
    L6:
        r103.write(r102.toString());
        r103.close();
        return r101;
    }

    private void mkdirs(File r100, String r101) throws IOException {
        FileUtils.mkdirs(r100);     // Catch: FileUtils.CreateDirectoryException -> L4
        return;
    L4:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, r101, e);
        throw e;
    }

    private boolean query(String r100, boolean r101) {
        File r102 = getContentFileFor(r100);
        boolean r103 = r102.exists();
        if (r101 == false) goto L6;
        if (r103 == false) goto L6;
        r102.setLastModified(this.mClock.now());
    L6:
        return r103;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String r100, Object r101) {
        return query(r100, false);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public BinaryResource getResource(String r100, Object r101) {
        File r102 = getContentFileFor(r100);
        if (r102.exists() == false) goto L6;
        r102.setLastModified(this.mClock.now());
        return FileBinaryResource.createOrNull(r102);
    L6:
        return null;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public Map<String, String> getResourceConfig(String r100, Object r101) throws IOException {
        String r102 = String.valueOf(Math.abs(r100.hashCode() % 100));
        StringBuilder r103 = new StringBuilder();
        r103.append(this.mOldConfigVersionDirectory);
        String r104 = File.separator;
        r103.append(r104);
        r103.append(r102);
        Map<String, String> r105 = fileToMap(new PolarisFileWrapper(r103.toString() + r104 + r100 + ".cnt"));
        r105.putAll(fileToMap(getConfigFileFor(r100)));
        return r105;
    }

    @Override // com.facebook.cache.disk.TTDiskStorage
    public BinaryResource getTempResource(String r100, Object r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(getTempFileName(r100));
        if (r102.exists() == false) goto L6;
        r102.setLastModified(this.mClock.now());
        return FileBinaryResource.createOrNull(r102);
    L6:
        return null;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String r100, Object r101) throws IOException {
        FileInfo r102 = new FileInfo(FileType.TEMP, r100, null);
        File r103 = getSubdirectory(r102.resourceId);
        if (r103.exists() == true) goto L10;
        mkdirs(r103, "insert");
    L10:
        File r104 = r102.createTempFile(r103);     // Catch: IOException -> L7
        insertConfigFile(r100, r101);     // Catch: IOException -> L7
        return new InserterImpl(this, r100, r104);
    L7:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", e);
        throw e;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(String r100, Object r101) {
        return query(r100, true);
    }

    @Override // com.facebook.cache.disk.TTDiskStorage
    public DiskStorage.Inserter insertTemp(String r100, int r101, Object r102) throws IOException {
        FileInfo r103 = new FileInfo(FileType.TEMP, r100, null);
        File r104 = getSubdirectory(r103.resourceId);
        if (r104.exists() == true) goto L10;
        mkdirs(r104, "insert");
    L10:
        return new TempInserterImpl(this, r100, r101, r103.createTempFile(r104));
    L7:
        e = move-exception;
        this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", e);
        throw e;
    }

    public TTDefaultDiskStorage(File r100, File r101, int r102, CacheErrorLogger r103) {
        Preconditions.checkNotNull(r100);
        this.mRootDirectory = r100;
        this.mConfigRootDirectory = r101;
        this.mIsExternal = isExternal(r100, r103);
        this.mVersionDirectory = new PolarisFileWrapper(r100, getVersionSubdirectoryName(r102));
        this.mOldConfigVersionDirectory = new PolarisFileWrapper(r100, getVersionSubdirectoryName(r102) + "-config");
        this.mConfigVersionDirectory = new PolarisFileWrapper(r101, getVersionSubdirectoryName(r102) + "-config2.0");
        this.mCacheErrorLogger = r103;
        recreateDirectoryIfVersionChanges();
        recreateConfigDirectoryIfVersionChanges();
        this.mClock = SystemClock.get();
    }
}
