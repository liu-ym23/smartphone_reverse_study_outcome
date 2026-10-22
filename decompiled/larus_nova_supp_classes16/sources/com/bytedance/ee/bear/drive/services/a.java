package com.bytedance.ee.bear.drive.services;

import com.ss.android.lark.diskmanage.storage.KAFileEncryptFileSystem;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.lark.android.encryption.CipherManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.services.a$a, reason: collision with other inner class name */
    public static final class C0168a {
        @JvmStatic
        public static void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "path");
            StringBuilder r1 = new StringBuilder("addCipherPath path=");
            if ((r4 instanceof Object) == false) goto L5;
            String r2 = r4;
        L6:
            r1.append(du5.b.f(r2));
            tt5.a.h("DriveCipherManager", r1.toString());
            if (CipherManager.d() != 1) goto L9;
            boolean r0 = true;
        L10:
            if (r0 == true) goto L13;
            tt5.a.h("DriveCipherManager", "addCipherPath fail, because cipher is close");
            return;
        L13:
            KAFileEncryptFileSystem.KAFileEncryptFileSystemFactory r3 = new KAFileEncryptFileSystem.KAFileEncryptFileSystemFactory(false, 1, null);
            FileSystemManager r5 = FileSystemManager.a;
            monitor-enter(FileSystemManager.class);
            Intrinsics.checkNotNullParameter(r4, "path");     // Catch: Throwable -> L18
            Intrinsics.checkNotNullParameter(r3, "factory");     // Catch: Throwable -> L18
            FileSystemManager.c(com.ss.android.lark.vfs.j.a(r4), r3);     // Catch: Throwable -> L18
            monitor-exit(FileSystemManager.class);
            return;
        L18:
            th = move-exception;
            throw th;
        L9:
            r0 = false;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }
}
