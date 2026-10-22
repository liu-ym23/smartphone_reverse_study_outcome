package com.bytedance.thanos.hdiff;

import android.text.TextUtils;
import com.bytedance.librarian.a;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class HDifferHelper {
    public HDifferHelper() {
    }

    private static native int patch(String r100, String r101, String r102);

    static {
        Intrinsics.checkNotNullParameter("hdiffpatch", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> hdiffpatch");
        a.c("hdiffpatch");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> hdiffpatch");
    }

    public static synchronized int a(String r100, String r101, String r102) {
        monitor-enter(HDifferHelper.class);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
    L24:
        monitor-exit(HDifferHelper.class);
        return 301;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L24;
        if (TextUtils.isEmpty(r102) == true) goto L24;
        if (new PolarisFileWrapper(r100).exists() == true) goto L17;
        monitor-exit(HDifferHelper.class);
        return 302;
    L17:
        if (new PolarisFileWrapper(r101).exists() == true) goto L21;
        monitor-exit(HDifferHelper.class);
        return 303;
    L21:
        int r103 = patch(r100, r101, r102);     // Catch: Throwable -> L27
        monitor-exit(HDifferHelper.class);
        return r103;
    }
}
