package com.larus.navigation.impl.baidu.notification;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f359810a = null;

    static {
        f359810a = new h();
    }

    public h() {
    }

    public static boolean a() {
        AppHost.Companion r100 = AppHost.f326268a;
        f09.a r101 = r100.a();
        if (r101 == null) goto L8;
        Activity r102 = r101.getCurrentActivity();
        if (r102 == null) goto L8;
        Resources r103 = r102.getResources();
        if (r103 == null) goto L8;
    L16:
        if ((r103.getConfiguration().uiMode & 48) != 32) goto L19;
        return true;
    L19:
        return false;
    L8:
        Application r104 = r100.getApplication();
        if (r104 == null) goto L11;
        Resources r105 = r104.getResources();
    L12:
        r103 = r105;
        if (r103 != null) goto L16;
        return false;
    L11:
        r105 = null;
        goto L12
    }

    public static Bitmap b(int r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = -1;
    L5:
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("nav_icon_tinter", "tintInternal resId=" + r100 + " nightMode=" + r101 + " color=" + String.format("%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r102)}, 1)));
        Application r104 = AppHost.f326268a.getApplication();
        if (r104 == null) goto L20;
        Resources r105 = r104.getResources();
        if (r105 == null) goto L20;
        Bitmap r106 = BitmapFactory.decodeResource(r105, r100);     // Catch: OutOfMemoryError -> L19
        if (r106 != null) goto L21;
        com.larus.navigation.api.c.b("nav_icon_tinter", "decodeResource returned null for resId=" + r100);
        return null;
    L21:
        Bitmap r107 = Bitmap.createBitmap(r106.getWidth(), r106.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: OutOfMemoryError -> L17
        Intrinsics.checkNotNull(r107);
        Canvas r108 = new Canvas(r107);
        Paint r109 = new Paint();
        r109.setColorFilter(new PorterDuffColorFilter(r102, PorterDuff.Mode.SRC_IN));
        Unit r110 = Unit.INSTANCE;
        r108.drawBitmap(r106, 0.0f, 0.0f, r109);
        r106.recycle();
        return r107;
    L17:
        int r111 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("nav_icon_tinter", "createBitmap OOM " + r106.getWidth() + Permission.EXECUTE + r106.getHeight(), null);
        r106.recycle();
        return null;
    L19:
        int r112 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("nav_icon_tinter", "decode OOM for resId=" + r100, null);
    L20:
        return null;
    L4:
        r102 = -15790321;
        goto L5
    }

    public static String c(int r110, boolean r111) {
        Application r100 = AppHost.f326268a.getApplication();
        String r101 = null;
        if (r100 != null) goto L6;
        com.larus.navigation.api.c.b("nav_icon_tinter", "tintToFileUri: AppHost.application null");
        return null;
    L6:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getCacheDir(), "nav_tint");
        if (r102.exists() == false) goto L9;
    L12:
        StringBuilder r103 = new StringBuilder("tint_");
        r103.append(r110);
        r103.append('_');
        if (r111 == false) goto L15;
        String r104 = "dark";
    L16:
        r103.append(r104);
        r103.append(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT);
        PolarisFileWrapper r105 = new PolarisFileWrapper(r102, r103.toString());
        if (r105.exists() == true) goto L19;
    L22:
        Bitmap r112 = b(r110, r111);
        if (r112 != null) goto L43;
        return null;
    L43:
        PolarisFileOutputStreamWrapper r113 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L34 IOException -> L36
        r112.compress(Bitmap.CompressFormat.PNG, 100, r113);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r113, null);     // Catch: Throwable -> L34 IOException -> L36
        int r114 = com.larus.navigation.api.c.f359656a;     // Catch: Throwable -> L34 IOException -> L36
        com.larus.navigation.api.c.d("nav_icon_tinter", "tintToFileUri: wrote " + r105.getAbsolutePath() + " (" + r105.length() + " bytes)");     // Catch: Throwable -> L34 IOException -> L36
        StringBuilder r115 = new StringBuilder(MSkiaImageRegionDecoder.FILE_PREFIX);     // Catch: Throwable -> L34 IOException -> L36
        r115.append(r105.getAbsolutePath());     // Catch: Throwable -> L34 IOException -> L36
        r101 = r115.toString();     // Catch: Throwable -> L34 IOException -> L36
    L38:
        r112.recycle();
        return r101;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);     // Catch: Throwable -> L34 IOException -> L36
        throw th;     // Catch: Throwable -> L34 IOException -> L36
    L36:
        e = move-exception;
        int r106 = com.larus.navigation.api.c.f359656a;     // Catch: Throwable -> L34
        com.larus.navigation.api.c.c("nav_icon_tinter", "tintToFileUri write error: " + e.getMessage(), e);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r112.recycle();
        throw th;
    L19:
        if (r105.length() <= 0) goto L22;
        return MSkiaImageRegionDecoder.FILE_PREFIX + r105.getAbsolutePath();
    L15:
        r104 = "light";
        goto L16
    L9:
        if (r102.mkdirs() == true) goto L12;
        int r116 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b("nav_icon_tinter", "tintToFileUri: mkdir failed " + r102.getAbsolutePath());
        return null;
    }
}
