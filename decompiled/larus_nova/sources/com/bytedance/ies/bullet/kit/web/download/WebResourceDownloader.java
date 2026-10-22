package com.bytedance.ies.bullet.kit.web.download;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.kit.resourceloader.j;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class WebResourceDownloader {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f246954c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<WebResourceDownloader> f246955d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f246956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f246957b;

    public static final class a {
    }

    static {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(DownloadTask.class.getDeclaredMethod("setCacheLifeTimeMax", new Class[]{Long.TYPE}));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        f246954c = (Method) r101;
        f246955d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, WebResourceDownloader$Companion$instance$2.INSTANCE);
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public WebResourceDownloader() {
        Application r100 = i.f246825b;
        this.f246956a = r100;
        if (r100 == null) goto L5;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getCacheDir(), "bullet_web_resource_offline");
        r101.mkdirs();
    L6:
        this.f246957b = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Uri r101 = UriProtector.parse(r100);
        if (r101.isHierarchical() == true) goto L6;
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.k("WebResourceDownloader: url=" + r100 + " isn't hierarchical", null, "XPreload", 2);
        return null;
    L6:
        j.f246830a.getClass();
        String r103 = j.g(r100);
        if (r101.isHierarchical() == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L22;
        String r104 = r101.getEncodedPath();
        if (r104 == null) goto L23;
        String r105 = FilesKt.getExtension(new PolarisFileWrapper(r104));
        if (r105 != null) goto L16;
        return null;
    L16:
        if ((!TextUtils.isEmpty(r105)) == true) goto L19;
        r105 = null;
    L19:
        if (r105 != null) goto L21;
        return null;
    L21:
        return r103 + '.' + r105;
    L23:
        return null;
    L22:
        return null;
    }

    public final WebResourceResponse a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        PolarisFileWrapper r100 = this.f246957b;
        if (r100 == null) goto L34;
        String r101 = b(r110);
        if (r101 == null) goto L35;
        DownloadInfo r102 = Downloader.getInstance(this.f246956a).getDownloadInfo(r110, r100.getPath());
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100, r101);
        if (r103.exists() == true) goto L9;
        return null;
    L9:
        if (r103.isDirectory() == true) goto L37;
        if (r102 != null) goto L12;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == true) goto L38;
        ExecutorService r105 = BulletLogger.f247763a;
        BulletLogger.k("WebResourceDownloader: get cache of url=" + r110 + " from destination=" + r103, null, "XPreload", 2);
        j r111 = j.f246830a;
        String r106 = r103.getPath();
        r111.getClass();
        String r112 = j.c(r106);
        if (TextUtils.isEmpty(r112) == false) goto L24;
        if (r102 == null) goto L24;
        String r107 = r102.getMimeType();
        if (r107 == null) goto L24;
        String r108 = r107;
    L25:
        PolarisFileInputStreamWrapper r113 = new PolarisFileInputStreamWrapper(r103);
        HashMap r114 = new HashMap();     // Catch: Exception -> L31
        r114.put("Access-Control-Allow-Origin", "*");     // Catch: Exception -> L31
        if (Intrinsics.areEqual("font/ttf", r108) == false) goto L29;
        WebResourceResponse r115 = new WebResourceResponse(r108, "", 200, "OK", r114, r113);     // Catch: Exception -> L31
    L39:
        return r115;
    L29:
        r115 = new WebResourceResponse(r108, "", r113);     // Catch: Exception -> L31
        r115.setResponseHeaders(r114);     // Catch: Exception -> L31
    L31:
        BulletLogger.k("WebResourceDownloader: translate input to response failed", null, "XPreload", 2);
        return null;
    L24:
        r108 = r112;
        goto L25
    L38:
        return null;
    L12:
        if (r102.getCacheExpiredTime() <= 0) goto L16;
        if (System.currentTimeMillis() <= r102.getCacheExpiredTime()) goto L16;
        r104 = true;
        goto L17
    L37:
        return null;
    L35:
        return null;
    L34:
        return null;
    }
}
