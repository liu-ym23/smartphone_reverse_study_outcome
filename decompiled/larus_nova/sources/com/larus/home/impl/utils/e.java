package com.larus.home.impl.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f346348a = 0;

    static {
    }

    @JvmStatic
    public static final void a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("app_init_data_file.txt", "fileName");
        Intrinsics.checkNotNullParameter(r101, "data");
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getFilesDir(), "app_init_data_file.txt");     // Catch: Exception -> L29
        if (r102.exists() == true) goto L6;
        r102.createNewFile();     // Catch: Exception -> L29
    L6:
        RandomAccessFile r103 = new RandomAccessFile(r102, "rw");     // Catch: Exception -> L29
        FileChannel r104 = r103.getChannel();     // Catch: Throwable -> L24
        FileLock r105 = r104.lock();     // Catch: Throwable -> L19
        r104.truncate(0);     // Catch: Throwable -> L16
        r103.write(r101.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L16
        r103.getFD().sync();     // Catch: Throwable -> L16
        r105.release();     // Catch: Throwable -> L19
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r103, null);     // Catch: Exception -> L29
        return;
    L16:
        th = move-exception;
        r105.release();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Exception -> L29
        throw th;     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.toString();
    }
}
