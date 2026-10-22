package com.bytedance.ug.sdk.luckycat.impl.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f271516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f271517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j.a f271518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f271519d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.bytedance.security.android.aopcheck.PolarisFileWrapper, java.io.File] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.FileOutputStream] */
    public final void a() {
        String r100 = "share_image_" + System.currentTimeMillis() + ".jpeg";
        if (Build.VERSION.SDK_INT < 29) goto L34;
        String r101 = this.f271516a;
        Context r102 = this.f271517b;
        j.a r103 = this.f271518c;
        boolean r104 = this.f271519d;
        a.c("ImageSaveHelper", "saveImageUpAndroid10, fileName=" + r100 + "isCached = " + r104);
        Uri r105 = m.d(r102, r100, Base64.decode(r101, 0));     // Catch: Exception -> L30
        if (r105 != null) goto L8;
        a.c("ImageSaveHelper", "localUri == null");     // Catch: Exception -> L30
        ((hj7.i.a) r103).a(false);     // Catch: Exception -> L30
        return;
    L8:
        r102.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r105));     // Catch: Exception -> L30
        if (r104 == false) goto L27;
        ContentResolver r106 = r102.getContentResolver();     // Catch: Exception -> L30
        if (r106 != null) goto L75;
    L26:
        com.bytedance.ug.sdk.luckycat.impl.manager.m r107 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;     // Catch: Exception -> L30
        goto L27
    L75:
        String[] r108 = {"_data"};     // Catch: Exception -> L24
        Cursor r109 = m.a(r106, r105, r108);     // Catch: Exception -> L24
        if (r109 == null) goto L16;
        r109.moveToFirst();     // Catch: Exception -> L24
    L16:
        if (r109 == null) goto L18;
        int r110 = r109.getColumnIndex(r108[0]);     // Catch: Exception -> L24
    L19:
        if (r109 == null) goto L21;
        r109.getString(r110);     // Catch: Exception -> L24
    L21:
        if (r109 == null) goto L26;
        r109.close();     // Catch: Exception -> L24
    L18:
        r110 = -1;
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L30
    L27:
        if (r103 == null) goto L80;
        ((hj7.i.a) r103).a(true);     // Catch: Exception -> L30
        return;
    L80:
        return;
    L30:
        e = move-exception;
        e.printStackTrace();
        if (r103 == null) goto L81;
        ((hj7.i.a) r103).a(false);
        return;
    L81:
        return;
    L34:
        String r111 = this.f271516a;
        Context r112 = this.f271517b;
        boolean r113 = this.f271519d;
        j.a r114 = this.f271518c;
        a.c("ImageSaveHelper", "saveImageUnderAndroid10, fileName=" + r100 + "isCached = " + r113);
        StringBuilder r115 = new StringBuilder();
        r115.append(Environment.getExternalStorageDirectory());
        String r116 = File.separator;
        r115.append(r116);
        r115.append(Environment.DIRECTORY_DCIM);
        r115.append(r116);
        r115.append("Camera");
        r115.append(r116);
        ?? r117 = new PolarisFileWrapper(r115.toString());
        if (r117.exists() == true) goto L37;
        r117.mkdir();
    L37:
        PolarisFileWrapper r118 = new PolarisFileWrapper(r117, r100);
        byte[] r119 = Base64.decode(r111, 0);     // Catch: Throwable -> L49 IOException -> L51
        PolarisFileOutputStreamWrapper r120 = new PolarisFileOutputStreamWrapper(r118);     // Catch: Throwable -> L49 IOException -> L51
        r120.write(r119);     // Catch: Throwable -> L45 IOException -> L47
        r120.flush();     // Catch: Throwable -> L45 IOException -> L47
        r112.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(r118)));     // Catch: Throwable -> L45 IOException -> L47
        if (r113 == false) goto L42;
        com.bytedance.ug.sdk.luckycat.impl.manager.m r121 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;     // Catch: Throwable -> L45 IOException -> L47
        r118.getAbsolutePath();     // Catch: Throwable -> L45 IOException -> L47
    L42:
        if (r114 == null) goto L73;
        ((hj7.i.a) r114).a(true);     // Catch: Throwable -> L45 IOException -> L47
    L73:
        r120.close();     // Catch: IOException -> L59
        return;
    L59:
        e = move-exception;
        e.printStackTrace();
        return;
    L47:
        IOException e100 = e;
    L53:
        e100.printStackTrace();     // Catch: Throwable -> L45
        if (r114 == null) goto L56;
        ((hj7.i.a) r114).a(false);     // Catch: Throwable -> L45
    L56:
        if (r120 != null) goto L73;
        return;
    L45:
        Throwable th10 = th;
    L62:
        if (r117 != 0) goto L68;
    L67:
        throw th10;
    L68:
        r117.close();     // Catch: IOException -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L51:
        e = move-exception;
        r120 = null;
        e100 = e;
    L49:
        th = move-exception;
        r117 = 0;
        th10 = th;
        goto L62
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(String r100, Context r101, hj7.i.a r102, boolean r103) {
        this.f271516a = r100;
        this.f271517b = r101;
        this.f271518c = r102;
        this.f271519d = r103;
    }
}
