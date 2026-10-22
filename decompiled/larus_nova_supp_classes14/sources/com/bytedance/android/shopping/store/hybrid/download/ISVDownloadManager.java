package com.bytedance.android.shopping.store.hybrid.download;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.utils.d;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.event.ECIsvComponentPredownloadEvent;
import com.bytedance.android.shopping.store.utils.e;
import com.bytedance.android.shopping.store.utils.h;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.io.File;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ISVDownloadManager {
    public static String a;
    public static String b;
    public static final h c = null;
    public static final JSONObject d = null;

    public ISVDownloadManager() {
    }

    static {
        a = "";
        b = "";
        JSONObject r0 = new JSONObject();
        r0.put("net_lib_strategy", 5);
        d = r0;
        Context r1 = ECAppInfoService.e.getApplicationContext();
        if (r1 == null) goto L9;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r1.getFilesDir(), "ecommerce");
        b = r2.toString();
        if (r2.exists() == true) goto L7;
        r2.mkdir();
    L7:
        c = new h(b + "/ec_isv");
        return;
    }

    public static void e(List r19) {
        Intrinsics.checkNotNullParameter(r19, "preLoadInfoList");
        final Context r1 = ECAppInfoService.e.getApplicationContext();
        PageFinder r11 = null;
        String r12 = "ISVDownloadManager";
        if (r1 != null) goto L6;
        dm.a.a("ISVDownloadManager").b("preDownload failed as app context is null", null);
        return;
    L6:
        PolarisFileWrapper r2 = new PolarisFileWrapper(r1.getFilesDir(), "ecommerce");
        b = r2.toString();
        if (r2.exists() == true) goto L9;
        r2.mkdir();
    L9:
        File r13 = new PolarisFileWrapper(b, "ec_isv");
        Iterator r0 = r19.iterator();
    L11:
        if (r0.hasNext() == false) goto L17;
        c r3 = (c) r0.next();
        final long r14 = System.currentTimeMillis();
        final String r10 = r3.a;
        final String r4 = r3.b;
        final ECIsvComponentPredownloadEvent r9 = new ECIsvComponentPredownloadEvent();
        r9.setCdnUrl(r10);
        r9.setVersion(r4);
        String r8 = UriProtector.parse(r10).buildUpon().clearQuery().build().toString();
        final String r5 = c(r8, r4);
        PolarisFileWrapper r6 = new PolarisFileWrapper(r13, r5 + ".js");
        if (d(r1, r6, r5, r4) == true) goto L15;
        dm.a.a(r12).i("already preDownload, skip url: " + r10);
        r9.setHasCache(1);
        r9.setSuccess(Boolean.TRUE);
        r9.setTimeCost(Long.valueOf(System.currentTimeMillis() - r14));
        r9.post(r11, r11);
    L16:
        r0 = r0;
        r12 = r12;
        r13 = r13;
        r11 = null;
        goto L11
    L15:
        r9.setHasCache(0);
        final File r15 = r13;
        b(r8, r6, r1, new ISVDownloadManager$preDownload$$inlined$forEach$lambda$1(r5, r4, r10, r14, r9, r15, r1), new ISVDownloadManager$preDownload$1$2(r10, r14, r9));
        goto L16
    }

    public static String c(String r6, String r7) {
        byte[] r8 = (r6 + r7).getBytes();     // Catch: Exception -> L13
        MessageDigest r9 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r9.update(r8);     // Catch: Exception -> L10
        byte[] r10 = r9.digest();     // Catch: Exception -> L10
        char[] r11 = new char[32];     // Catch: Exception -> L10
        int r0 = 0;
        int r1 = 0;
    L6:
        if (r0 >= 16) goto L8;
        byte r2 = r10[r0];     // Catch: Exception -> L10
        int r3 = r1 + 1;     // Catch: Exception -> L10
        char[] r4 = d.a;     // Catch: Exception -> L10
        r11[r1] = r4[(r2 >>> 4) & 15];     // Catch: Exception -> L10
        r1 = r3 + 1;     // Catch: Exception -> L10
        r11[r3] = r4[r2 & 15];     // Catch: Exception -> L10
        r0 = r0 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
    L21:
        return new String(r11);
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L13
    L15:
        return null;
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L15
    }

    public static final void a(String r3, String r4, Context r5) {
        SharedPrefHelper r6 = SharedPrefHelper.c(r5, "ec_isv_predownload");
        JSONObject r0 = new JSONObject();
        r0.put("version", r4);
        r0.put("time", System.currentTimeMillis());
        r6.l(r3, r0.toString());
        r6.a();
        h r7 = c;
        if (r7 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "element");
        r7.f.remove(r3);
        r7.f.add(r3);
        r7.c = true;
        return;
    }

    public static boolean d(Context r2, PolarisFileWrapper r3, String r4, String r5) {
        if (r3.exists() == true) goto L5;
        return true;
    L5:
        SharedPrefHelper r6 = SharedPrefHelper.c(r2, "ec_isv_predownload");
        String r7 = r6.j(r4, "{}");
        r6.a();
        if (r7 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
    L29:
        return true;
    L14:
        if (r7.equals("{}") == true) goto L29;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L24
        String r9 = new JSONObject(r7).optString("version", "");     // Catch: Throwable -> L24
        if (k.c(r9) == true) goto L20;
        r9 = null;
    L20:
        if (r9 == null) goto L22;
        a = r9;     // Catch: Throwable -> L24
        boolean r10 = Intrinsics.areEqual(r9, r5);     // Catch: Throwable -> L24
    L27:
        if (r10 == false) goto L29;
        return false;
    L22:
        Result.constructor-impl(null);     // Catch: Throwable -> L24
    L26:
        r10 = false;
    L24:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L8:
        if (r7.length() == 0) goto L11;
        r1 = false;
        goto L12
    }

    public static void b(String r7, PolarisFileWrapper r8, Context r9, Function1 r10, Function1 r11) {
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r8, "$this$deleteIfExists");
        if (r8.exists() == false) goto L5;
        r8.delete();
    L5:
        a r1 = new a(r8, r10, r11, r7, r9);
        Downloader.with(r9).url(r7).name(r8.getName()).savePath(r8.getParent()).addListenerToSameTask(true).deleteCacheIfCheckFailed(true).retryCount(3).autoSetHashCodeForSameTask(true).ttnetProtectTimeout(20000).expiredRedownload(true).expiredHttpCheck(true).downloadSetting(d).force(true).subThreadListener(r1).download();
    }
}
