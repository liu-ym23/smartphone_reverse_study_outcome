package com.ss.android.lark.vfs;

import android.app.Application;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.diskmanage.storage.KAFileEncryptFileSystem;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.file.statistics.FileMonitor;
import com.ss.android.lark.vfs.support.AssetsFileSystemProvider;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class FileSystemManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FileSystemManager f444805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f444806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, List<FileSystemFactory>> f444807c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, c> f444808d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f444809e;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/vfs/FileSystemManager$FileSystemFactory;", "Ljava/io/Serializable;", "<init>", "()V", "create", "Lcom/ss/android/lark/vfs/ChainedFileSystem;", "delegate", "Lcom/ss/android/lark/vfs/FileSystem;", "equals", "", "other", "", "hashCode", "", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class FileSystemFactory implements Serializable {
        public FileSystemFactory() {
        }

        public abstract ChainedFileSystem create(FileSystem r100);

        public int hashCode() {
            return getClass().hashCode();
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
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileSystemManager f444810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<Uri> f444811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<VFSPath> f444812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList<FileSystemFactory> f444813d;

        public a(FileSystemManager r100) {
            Intrinsics.checkNotNullParameter(r100, "fsm");
            this.f444810a = r100;
            this.f444811b = new ArrayList();
            this.f444812c = new ArrayList();
            this.f444813d = new ArrayList();
        }

        public final void a(FileSystemFactory r100) {
            Intrinsics.checkNotNullParameter(r100, "factory");
            this.f444813d.add(r100);
        }

        public final void b(boolean r100) {
            FileSystemManager r101 = this.f444810a;
            FileSystemManager r102 = FileSystemManager.f444805a;
            r101.getClass();
            ConcurrentHashMap<String, List<FileSystemFactory>> r103 = FileSystemManager.f444807c;
            monitor-enter(r103);
            Iterator<Uri> r104 = this.f444811b.iterator();     // Catch: Throwable -> L15
        L6:
            if (r104.hasNext() == false) goto L8;
            Uri r105 = r104.next();     // Catch: Throwable -> L15
            FileSystemManager.f444805a.getClass();     // Catch: Throwable -> L15
            FileSystemManager.d(FileSystemManager.b(r105).resolvePath(r105), this.f444813d, r100);     // Catch: Throwable -> L15
            goto L6
        L8:
            Iterator<VFSPath> r106 = this.f444812c.iterator();     // Catch: Throwable -> L15
        L10:
            if (r106.hasNext() == false) goto L12;
            VFSPath r107 = r106.next();     // Catch: Throwable -> L15
            FileSystemManager r108 = FileSystemManager.f444805a;     // Catch: Throwable -> L15
            ArrayList<FileSystemFactory> r109 = this.f444813d;     // Catch: Throwable -> L15
            r108.getClass();     // Catch: Throwable -> L15
            FileSystemManager.d(r107, r109, r100);     // Catch: Throwable -> L15
            goto L10
        L12:
            Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L15
            monitor-exit(r103);
            return;
        L15:
            th = move-exception;
            throw th;
        }

        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            if (r100.length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L9;
            this.f444811b.add(j.a(r100));
            return;
        L9:
            return;
        L5:
            r101 = false;
            goto L6
        }
    }

    public FileSystemManager() {
    }

    static {
        f444805a = new FileSystemManager();
        f444807c = new ConcurrentHashMap(10);
        f444808d = new ConcurrentHashMap();
        f(nac.a.f518494a);
        f(AssetsFileSystemProvider.f444832a);
    }

    @JvmStatic
    public static final a a() {
        return new a(f444805a);
    }

    public static Application g() {
        Application r100 = f444806b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("FileSystemManager not init correct");
    }

    public static FileSystem b(Uri r210) {
        String r100 = r210.getScheme();
        if (r100 == null) goto L5;
        c r101 = f444808d.get(r100);
    L6:
        if (r101 != null) goto L72;
        FileMonitor.f441005a.getClass();
        Intrinsics.checkNotNullParameter(r210, "path");
        new com.ss.android.lark.storage.file.statistics.b(FileMonitor.c(r210.toString())).a();
        StringBuilder r102 = new StringBuilder("no file system provider found for :");
        Intrinsics.checkNotNullParameter(r210, "uri");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L65
        String r104 = r210.getScheme();     // Catch: Throwable -> L65
        if (r104 == null) goto L12;
        String r105 = r104.concat("://");     // Catch: Throwable -> L65
    L13:
        String r106 = "";
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        String r107 = r210.getHost();     // Catch: Throwable -> L65
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        String r108 = r210.getPath();     // Catch: Throwable -> L65
        if (r108 != null) goto L23;
    L39:
        String r109 = null;
    L40:
        if (r109 != null) goto L43;
        r109 = "";
    L43:
        if (r105.length() <= 0) goto L45;
        boolean r110 = true;
    L47:
        if (r110 == false) goto L49;
        String r111 = r105 + r107 + "/****" + r109;     // Catch: Throwable -> L65
    L63:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L65
    L67:
        String r113 = r210.toString();
        if (Result.m9455isFailureimpl(r112) == false) goto L70;
        r112 = r113;
    L70:
        r102.append((String) r112);
        Log.e("FileSystemManager", new Throwable(r102.toString()), true);
        return nac.a.f518494a.a(g(), r210);
    L49:
        String r114 = r210.getPath();     // Catch: Throwable -> L65
        if (r114 != null) goto L53;
        r114 = "";
    L53:
        if (StringsKt.startsWith$default(r114, HTTP.URL_DEFAULT, false, 2, null) == false) goto L55;
        int r115 = 1;
    L56:
        int r116 = StringsKt.indexOf$default(r114, '/', r115, false, 4, null);     // Catch: Throwable -> L65
        if (r116 == (-1)) goto L59;
        r111 = r114.substring(0, r116) + "/****" + r109;     // Catch: Throwable -> L65
        goto L63
    L59:
        StringBuilder r117 = new StringBuilder();     // Catch: Throwable -> L65
        if (StringsKt.startsWith$default(r114, HTTP.URL_DEFAULT, false, 2, null) == false) goto L62;
        r106 = HTTP.URL_DEFAULT;
    L62:
        r117.append(r106);     // Catch: Throwable -> L65
        r117.append("****");     // Catch: Throwable -> L65
        r117.append(r109);     // Catch: Throwable -> L65
        r111 = r117.toString();     // Catch: Throwable -> L65
        goto L63
    L55:
        r115 = 0;
        goto L56
    L45:
        r110 = false;
        goto L47
    L23:
        String r118 = StringsKt.substringAfterLast(r108, '.', "");     // Catch: Throwable -> L65
        if (r118 == null) goto L39;
        if (r118.length() <= 0) goto L28;
        boolean r119 = true;
    L29:
        if (r119 == true) goto L31;
    L33:
        boolean r120 = false;
    L34:
        if (r120 == true) goto L37;
        r118 = null;
    L37:
        if (r118 == null) goto L39;
        r109 = ".".concat(r118);     // Catch: Throwable -> L65
        goto L40
    L31:
        if (StringsKt.contains$default(r118, HTTP.URL_DEFAULT, false, 2, null) == true) goto L33;
        r120 = true;
        goto L34
    L28:
        r119 = false;
        goto L29
    L12:
        r105 = null;
    L65:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L67
    L72:
        return r101.a(g(), r210);
    L5:
        r101 = null;
        goto L6
    }

    public static List e(VFSPath r100) {
        List<FileSystemFactory> r101 = f444807c.get(r100.getRealPath());
        if (r101 == null) goto L5;
        return r101;
    L5:
        VFSPath r102 = r100.getParent();
        if (r102 != null) goto L8;
        return null;
    L8:
        return e(r102);
    }

    @JvmStatic
    public static final synchronized void f(c r100) {
        monitor-enter(FileSystemManager.class);
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);     // Catch: Throwable -> L10
        ConcurrentHashMap<String, c> r101 = f444808d;     // Catch: Throwable -> L10
        if (r101.contains(r100.scheme()) == true) goto L7;
        r101.put(r100.scheme(), r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(FileSystemManager.class);
        return;
    L7:
        Log.w("FileSystemManager", "scheme provider already registered, scheme : " + r100.scheme() + "， name: " + r100.getName());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Deprecated(message = "please use edit() replace")
    @JvmStatic
    public static final synchronized void c(Uri r100, KAFileEncryptFileSystem.KAFileEncryptFileSystemFactory r101) {
        monitor-enter(FileSystemManager.class);
        Intrinsics.checkNotNullParameter(r100, "uri");     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r101, "factory");     // Catch: Throwable -> L7
        a r102 = a();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r100, "uri");     // Catch: Throwable -> L7
        r102.f444811b.add(r100);     // Catch: Throwable -> L7
        r102.a(r101);     // Catch: Throwable -> L7
        r102.b(true);     // Catch: Throwable -> L7
        monitor-exit(FileSystemManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void d(VFSPath r100, List r101, boolean r102) {
        ConcurrentHashMap<String, List<FileSystemFactory>> r103 = f444807c;
        List<FileSystemFactory> r104 = r103.get(r100.getRealPath());
        if (r104 == null) goto L7;
        if (r102 == true) goto L7;
        Log.w("FileSystemManager", "already exist filesystem on path, ignore:" + r100.getRealPath() + ", " + r104);
        return;
    L7:
        r103.put(r100.getRealPath(), r101);
        Log.w("FileSystemManager", "mount filesystem on path:" + r100.getRealPath() + ", " + r104);
    }
}
