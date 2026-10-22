package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes40.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f461637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadPoolExecutor f461638b;

    static {
        f461638b = new PThreadPoolExecutor(5, 9, 1, TimeUnit.SECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory("ensdk/utils/b"));
    }

    public static int a(ContentResolver r100, Uri r101) {
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (r100 == null) goto L37;
        if (r101 == null) goto L37;
        InputStream r102 = null;
        InputStream r103 = ContentResolverWrapper.openInputStream(r100, r101);     // Catch: Throwable -> L21 Exception -> L23
        if (r103 != null) goto L15;
        if (r103 != null) goto L42;
    L14:
        return 0;
    L42:
        r103.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        Log.e("MicroMsg.SDK.Util", "getFileSize exception: " + e.getMessage());
        goto L14
    L15:
        int r104 = r103.available();     // Catch: Throwable -> L21 Exception -> L23
    L47:
        r103.close();     // Catch: IOException -> L18
    L20:
        return r104;
    L18:
        e = move-exception;
        Log.e("MicroMsg.SDK.Util", "getFileSize exception: " + e.getMessage());
    L21:
        th = move-exception;
        if (0 != 0) goto L40;
    L36:
        throw th;
    L40:
        r102.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        Log.e("MicroMsg.SDK.Util", "getFileSize exception: " + e.getMessage());
    L23:
        e = move-exception;
        Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e.getMessage());     // Catch: Throwable -> L21
        if (0 != 0) goto L44;
    L30:
        return 0;
    L44:
        r102.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        Log.e("MicroMsg.SDK.Util", "getFileSize exception: " + e.getMessage());
    L37:
        Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
        return 0;
    }

    public static int a(String r100) {
        if (r100 != null) goto L5;
    L18:
        return 0;
    L5:
        if (r100.length() == 0) goto L18;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L17;
        if (f461637a != null) goto L12;
    L15:
        return 0;
    L12:
        if (r100.startsWith("content") == false) goto L15;
        return a(f461637a.getContentResolver(), UriProtector.parse(r100));
    L17:
        return (int) r101.length();
    }

    public static int a(String r100, int r101) {
        if (r100 == null) goto L11;
        if (r100.length() <= 0) goto L12;
        return CastIntegerProtector.parseInt(r100);
    L12:
        return r101;
    L13:
        return r101;
    L11:
        return r101;
    }

    public static boolean a(int r100) {
        if (r100 != 36) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 46) goto L8;
        return false;
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.length() <= 0) goto L10;
        return false;
    L10:
        return true;
    }
}
