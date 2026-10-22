package com.ss.android.lark.storage.file.statistics;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.vfs.ChainedFileSystem;
import com.ss.android.lark.vfs.FileSystem;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/storage/file/statistics/MonitorFileSystemFactory;", "Lcom/ss/android/lark/vfs/FileSystemManager$FileSystemFactory;", "<init>", "()V", "create", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "MonitorFileSystem", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MonitorFileSystemFactory extends FileSystemManager.FileSystemFactory {
    public static final MonitorFileSystemFactory INSTANCE = null;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016J1\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001b\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b2\u0006\u0010\f\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u001cJ\u001b\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001b2\u0006\u0010\f\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0018\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020&2\u0006\u0010-\u001a\u00020\u001eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ss/android/lark/storage/file/statistics/MonitorFileSystemFactory$MonitorFileSystem;", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "<init>", "(Lcom/ss/android/lark/vfs/FileSystem;)V", "TAG", "", "getName", "monitorInvoke", ExifInterface.GPS_DIRECTION_TRUE, "fileApi", "path", "realInvoke", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "resolvePath", "Lcom/ss/android/lark/vfs/VFSPath;", "uri", "Landroid/net/Uri;", "openInput", "Ljava/io/InputStream;", "openOutput", "Ljava/io/OutputStream;", "append", "", "list", "", "(Lcom/ss/android/lark/vfs/VFSPath;)[Ljava/lang/String;", "listFiles", "Lcom/ss/android/lark/vfs/VFSFile;", "(Lcom/ss/android/lark/vfs/VFSPath;)[Lcom/ss/android/lark/vfs/VFSFile;", "exists", "delete", "size", "", "createNewFile", "getReadFile", "Ljava/io/File;", "move", "src", "dest", "isFile", "isDirectory", "afterWriteCompat", "originalFile", "beforeReadCompat", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MonitorFileSystem extends ChainedFileSystem {
        private final String TAG;

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public String getName() {
            return this.TAG;
        }

        public MonitorFileSystem(FileSystem r100) {
            Intrinsics.checkNotNullParameter(r100, "delegate");
            super(r100);
            this.TAG = "MonitorFileSystem";
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public File afterWriteCompat(final VFSFile r100) {
            Intrinsics.checkNotNullParameter(r100, "originalFile");
            return (File) a("after_read", r100.getAbsolutePath(), new MonitorFileSystemFactory$MonitorFileSystem$afterWriteCompat$1(this, r100));
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public File beforeReadCompat(final VFSFile r100) {
            Intrinsics.checkNotNullParameter(r100, "originalFile");
            return (File) a("before_read", r100.getAbsolutePath(), new MonitorFileSystemFactory$MonitorFileSystem$beforeReadCompat$1(this, r100));
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public boolean createNewFile(final VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return ((Boolean) a("create_new_file", r100.getRealPath(), new MonitorFileSystemFactory$MonitorFileSystem$createNewFile$1(this, r100))).booleanValue();
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public boolean delete(final VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return ((Boolean) a("delete", r100.getRealPath(), new MonitorFileSystemFactory$MonitorFileSystem$delete$1(this, r100))).booleanValue();
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public boolean exists(final VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return ((Boolean) a("exists", r100.getRealPath(), new MonitorFileSystemFactory$MonitorFileSystem$exists$1(this, r100))).booleanValue();
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public File getReadFile(final VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return (File) a("get_read_file", r100.getRealPath(), new MonitorFileSystemFactory$MonitorFileSystem$getReadFile$1(this, r100));
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public boolean isDirectory(final VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return ((Boolean) a("is_dir", r100.getRealPath(), new MonitorFileSystemFactory$MonitorFileSystem$isDirectory$1(this, r100))).booleanValue();
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public boolean isFile(final VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return ((Boolean) a("is_file", r100.getRealPath(), new MonitorFileSystemFactory$MonitorFileSystem$isFile$1(this, r100))).booleanValue();
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public String[] list(final VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return (String[]) a("list", r100.getRealPath(), new MonitorFileSystemFactory$MonitorFileSystem$list$1(this, r100));
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public VFSFile[] listFiles(final VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return (VFSFile[]) a("list_files", r100.getRealPath(), new MonitorFileSystemFactory$MonitorFileSystem$listFiles$1(this, r100));
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public InputStream openInput(final VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return (InputStream) a("open_input", r100.toString(), new MonitorFileSystemFactory$MonitorFileSystem$openInput$1(this, r100));
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public VFSPath resolvePath(final Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            return (VFSPath) a("resolve_path", r100.toString(), new MonitorFileSystemFactory$MonitorFileSystem$resolvePath$1(this, r100));
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public long size(final VFSPath r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return ((Number) a("size", r100.getRealPath(), new MonitorFileSystemFactory$MonitorFileSystem$size$1(this, r100))).longValue();
        }

        public static final /* synthetic */ File access$afterWriteCompat$s17248747(MonitorFileSystem r100, VFSFile r101) {
            return super.afterWriteCompat(r101);
        }

        public static final /* synthetic */ File access$beforeReadCompat$s17248747(MonitorFileSystem r100, VFSFile r101) {
            return super.beforeReadCompat(r101);
        }

        public static final /* synthetic */ boolean access$createNewFile$s17248747(MonitorFileSystem r100, VFSPath r101) {
            return super.createNewFile(r101);
        }

        public static final /* synthetic */ boolean access$delete$s17248747(MonitorFileSystem r100, VFSPath r101) {
            return super.delete(r101);
        }

        public static final /* synthetic */ boolean access$exists$s17248747(MonitorFileSystem r100, VFSPath r101) {
            return super.exists(r101);
        }

        public static final /* synthetic */ File access$getReadFile$s17248747(MonitorFileSystem r100, VFSPath r101) {
            return super.getReadFile(r101);
        }

        public static final /* synthetic */ boolean access$isDirectory$s17248747(MonitorFileSystem r100, VFSPath r101) {
            return super.isDirectory(r101);
        }

        public static final /* synthetic */ boolean access$isFile$s17248747(MonitorFileSystem r100, VFSPath r101) {
            return super.isFile(r101);
        }

        public static final /* synthetic */ String[] access$list$s17248747(MonitorFileSystem r100, VFSPath r101) {
            return super.list(r101);
        }

        public static final /* synthetic */ VFSFile[] access$listFiles$s17248747(MonitorFileSystem r100, VFSPath r101) {
            return super.listFiles(r101);
        }

        public static final /* synthetic */ InputStream access$openInput$s17248747(MonitorFileSystem r100, VFSPath r101) {
            return super.openInput(r101);
        }

        public static final /* synthetic */ VFSPath access$resolvePath$s17248747(MonitorFileSystem r100, Uri r101) {
            return super.resolvePath(r101);
        }

        public static final /* synthetic */ long access$size$s17248747(MonitorFileSystem r100, VFSPath r101) {
            return super.size(r101);
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public boolean move(final VFSPath r100, final VFSPath r101) {
            Intrinsics.checkNotNullParameter(r100, "src");
            Intrinsics.checkNotNullParameter(r101, "dest");
            return ((Boolean) a("move", r100.getRealPath(), new MonitorFileSystemFactory$MonitorFileSystem$move$1(this, r100, r101))).booleanValue();
        }

        @Override // com.ss.android.lark.vfs.ChainedFileSystem, com.ss.android.lark.vfs.FileSystem
        public OutputStream openOutput(final VFSPath r100, final boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "path");
            return (OutputStream) a("open_output", r100.toString(), new MonitorFileSystemFactory$MonitorFileSystem$openOutput$1(this, r100, r101));
        }

        public static final /* synthetic */ boolean access$move$s17248747(MonitorFileSystem r100, VFSPath r101, VFSPath r102) {
            return super.move(r101, r102);
        }

        public static final /* synthetic */ OutputStream access$openOutput$s17248747(MonitorFileSystem r100, VFSPath r101, boolean r102) {
            return super.openOutput(r101, r102);
        }

        public final <T> T a(String r100, String r101, Function0<? extends T> r102) {
            FileMonitor.f441005a.getClass();     // Catch: Exception -> L5 IOException -> L8 FileNotFoundException -> L11
            String r103 = FileMonitor.d(FileMonitor$beginAccess$1.INSTANCE);     // Catch: Exception -> L5 IOException -> L8 FileNotFoundException -> L11
            T r104 = r102.invoke();     // Catch: Exception -> L5 IOException -> L8 FileNotFoundException -> L11
            FileMonitor.a(r103, r100, r101);     // Catch: Exception -> L5 IOException -> L8 FileNotFoundException -> L11
            return r104;
        L11:
            e = move-exception;
            int r105 = com.ss.android.lark.storage.monitor.b.a.f441106a;
            com.ss.android.lark.storage.monitor.b.a.b(this.TAG, "resolvePath error", e, 8);
            throw e;
        L8:
            e = move-exception;
            int r106 = com.ss.android.lark.storage.monitor.b.a.f441106a;
            com.ss.android.lark.storage.monitor.b.a.b(this.TAG, "resolvePath error", e, 8);
            throw e;
        L5:
            e = move-exception;
            int r107 = com.ss.android.lark.storage.monitor.b.a.f441106a;
            com.ss.android.lark.storage.monitor.b.a.b(this.TAG, "resolvePath error", e, 8);
            throw e;
        }
    }

    static {
        INSTANCE = new MonitorFileSystemFactory();
    }

    private MonitorFileSystemFactory() {
    }

    @Override // com.ss.android.lark.vfs.FileSystemManager.FileSystemFactory
    public ChainedFileSystem create(FileSystem r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        return new MonitorFileSystem(r100);
    }
}
