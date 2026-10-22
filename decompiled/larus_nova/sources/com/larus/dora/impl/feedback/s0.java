package com.larus.dora.impl.feedback;

import android.content.Context;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f335673a = 0;

    static {
    }

    public static String a(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        InputStream r102 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        if (r102 == null) goto L22;
        File r103 = File.createTempFile("temp_video_", ".mp4", r100.getCacheDir());     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        ByteStreamsKt.copyTo$default(r102, r104, 0, 2, null);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r102, null);     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r104, null);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        pk4.j.d("UriToPathUtil", "URI content copied to cache: " + r103.getAbsolutePath() + ", size=" + r103.length());     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        return r103.getAbsolutePath();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        throw th;     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L22:
        pk4.j.b("UriToPathUtil", "openInputStream returned null, uri=" + r101);     // Catch: Exception -> L24 IOException -> L26 SecurityException -> L28
        return null;
    L26:
        e = move-exception;
        pk4.j.c("UriToPathUtil", "IOException: failed to copy URI content, uri=" + r101, e);
        return null;
    L28:
        e = move-exception;
        pk4.j.c("UriToPathUtil", "SecurityException: URI permission denied or expired, uri=" + r101, e);
        return null;
    L24:
        e = move-exception;
        pk4.j.c("UriToPathUtil", "Unexpected error copying URI content, uri=" + r101, e);
        return null;
    }
}
