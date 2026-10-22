package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import com.ss.android.lark.diskmanage.storage.KAFileEncryptFileSystem;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.VFSPath;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements UniPathProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f460641a = null;

    public static final class a {
    }

    public f() {
    }

    static {
        f460641a = new ConcurrentHashMap();
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final FileStorage b() {
        return UniPathProvider.a.a(this);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return com.ss.android.lark.diskmanage.storage.d.h(r100);
    }

    @Override // com.suite.lark.platform.component.storage.file.dirs.UniPathProvider
    public final VFSPath d(FileStorage r110) {
        Intrinsics.checkNotNullParameter(r110, "space");
        com.ss.android.lark.storage.f r100 = com.ss.android.lark.storage.f.f440958e;
        VFSPath r101 = r110.b(r100, new com.ss.android.lark.storage.d(new String[]{"image_compressed"}));
        ConcurrentHashMap<String, Object> r102 = f460641a;
        if (r102.contains(r101.getRealPath()) == true) goto L6;
        FileSystemManager.a r103 = FileSystemManager.a();
        r103.c(r101.getRealPath());
        r103.a(new KAFileEncryptFileSystem.KAFileEncryptFileSystemFactory(false, 1, null));
        r103.b(false);
        r102.put(r101.getRealPath(), 0);
        return r110.b(r100, new com.ss.android.lark.storage.d(new String[]{"image_compressed"}));
    L6:
        return r101;
    }
}
