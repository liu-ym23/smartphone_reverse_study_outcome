package com.bytedance.ee.bear.drive.services;

import com.ss.android.lark.diskmanage.storage.KAFileEncryptFileSystem;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.lark.android.encryption.CipherManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f224601a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.services.a$a, reason: collision with other inner class name */
    public static final class C3224a {
        @JvmStatic
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            StringBuilder r101 = new StringBuilder("addCipherPath path=");
            if ((r100 instanceof Object) == false) goto L5;
            String r102 = r100;
        L6:
            r101.append(du5.b.f(r102));
            tt5.a.h("DriveCipherManager", r101.toString());
            if (CipherManager.d() != 1) goto L9;
            boolean r103 = true;
        L10:
            if (r103 == true) goto L13;
            tt5.a.h("DriveCipherManager", "addCipherPath fail, because cipher is close");
            return;
        L13:
            KAFileEncryptFileSystem.KAFileEncryptFileSystemFactory r104 = new KAFileEncryptFileSystem.KAFileEncryptFileSystemFactory(false, 1, null);
            FileSystemManager r105 = FileSystemManager.f444805a;
            monitor-enter(FileSystemManager.class);
            Intrinsics.checkNotNullParameter(r100, "path");     // Catch: Throwable -> L18
            Intrinsics.checkNotNullParameter(r104, "factory");     // Catch: Throwable -> L18
            FileSystemManager.c(com.ss.android.lark.vfs.j.a(r100), r104);     // Catch: Throwable -> L18
            monitor-exit(FileSystemManager.class);
            return;
        L18:
            th = move-exception;
            throw th;
        L9:
            r103 = false;
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }
}
