package com.larus.utils;

import android.content.Context;
import android.os.Environment;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f375427a = 0;

    static {
    }

    @JvmStatic
    public static final long a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return (r.r(r100.getCacheDir()) + 0) + c(r100);
    }

    @JvmStatic
    public static final long b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        File r101 = r100.getFilesDir().getParentFile();
        long r102 = 0;
        if (r101 != null) goto L26;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L12;
        r102 = 0 + r.t(new File[]{r101});     // Catch: Exception -> L7
    L12:
        File r104 = r100.getExternalCacheDir();     // Catch: Exception -> L7
        if (r104 == null) goto L15;
        File r105 = r104.getParentFile();     // Catch: Exception -> L7
    L16:
        if (r105 != null) goto L18;
    L20:
        boolean r106 = false;
    L21:
        if (r106 == false) goto L28;
        return r102 + r.t(new File[]{r105});
    L7:
        e = move-exception;
        FLogger.f375446a.e("DiskUtil", "getAppUsedSize error " + e);
        return r102;
    L28:
        return r102;
    L18:
        if (r105.exists() != true) goto L20;
        r106 = true;
        goto L21
    L15:
        r105 = null;
        goto L16
    L26:
        if (r101.exists() != true) goto L9;
        r103 = true;
        goto L10
    }

    @JvmStatic
    public static final long c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted") == false) goto L15;
        File r101 = r100.getExternalCacheDir();
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.exists() != true) goto L9;
    L10:
        if (r102 == true) goto L12;
        return 0;
    L12:
        if (r101.canRead() == true) goto L14;
        return 0;
    L14:
        return r.r(r101);
    L9:
        r102 = false;
        goto L10
    L15:
        return 0;
    }

    public static void d(File r100, long r101, List r102) {
        if (r100.exists() == true) goto L6;
        return;
    L6:
        if (r100.isDirectory() == false) goto L15;
        if (r100.canRead() == false) goto L15;
        File[] r103 = r100.listFiles();
        if (r103 == null) goto L21;
        int r104 = r103.length;
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L24;
        File r106 = r103[r105];
        Intrinsics.checkNotNull(r106);
        d(r106, r101, r102);
        r105 = r105 + 1;
        goto L12
    L24:
        return;
    L21:
        return;
    L15:
        if (r100.isFile() == true) goto L17;
        return;
    L17:
        if (r100.length() <= r101) goto L23;
        ArrayList r107 = (ArrayList) r102;
        r107.add(r100.getAbsolutePath());
        return;
    }
}
