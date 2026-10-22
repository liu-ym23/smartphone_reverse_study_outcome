package com.larus.vesdk.impl.camera;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z0;
import java.io.File;
import java.util.UUID;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f375536a = null;

    static {
        f375536a = new c();
    }

    public c() {
    }

    public static String b() {
        StringBuilder r100 = new StringBuilder();
        pq9.k.f530291a.getClass();
        r100.append(pq9.k.f530296f);
        r100.append('/');
        r100.append(System.currentTimeMillis());
        r100.append('_');
        r100.append(UUID.randomUUID().toString().substring(0, 8));
        r100.append(".jpg");
        return r100.toString();
    }

    public static boolean c(Bitmap r100, String r101, pq9.h r110) {
        Intrinsics.checkNotNullParameter(r101, "path");
        if (r100 != null) goto L5;
        return false;
    L5:
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L31 Exception -> L33
        File r104 = r103.getParentFile();     // Catch: Throwable -> L31 Exception -> L33
        if (r104 == null) goto L10;
        r104.mkdirs();     // Catch: Throwable -> L31 Exception -> L33
    L10:
        if (r103.exists() == true) goto L12;
        r103.createNewFile();     // Catch: Throwable -> L31 Exception -> L33
    L12:
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L31 Exception -> L33
    L29:
        e = e;
        r102 = r105;
    L34:
        FLogger.f375446a.e("VeCameraHelper", "saveBitMapToFile failed:" + e + " path:" + r101);     // Catch: Throwable -> L31
        if (r110 == null) goto L37;
        r110.a(1002, e.getMessage());     // Catch: Throwable -> L31
    L37:
        if (r102 != null) goto L53;
    L42:
        return false;
    L53:
        r102.close();     // Catch: Exception -> L40
    L40:
        e = move-exception;
        FLogger.f375446a.e("VeCameraHelper", "close failed:" + e);
    L27:
        th = th;
    L44:
        if (r105 != null) goto L57;
    L49:
        throw th;
    L57:
        r105.close();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        FLogger.f375446a.e("VeCameraHelper", "close failed:" + e);
        goto L49
    L14:
        if (r100.compress(Bitmap.CompressFormat.JPEG, 100, r105) == false) goto L55;
        r105.flush();     // Catch: Throwable -> L27 Exception -> L29
        FLogger.f375446a.i("VeCameraHelper", "saveBitMapToFile success, path:" + r101);     // Catch: Throwable -> L27 Exception -> L29
        r105.close();     // Catch: Exception -> L18
        return true;
    L18:
        e = move-exception;
        FLogger.f375446a.e("VeCameraHelper", "close failed:" + e);
        return true;
    L55:
        r105.close();     // Catch: Exception -> L24
    L26:
        return false;
    L24:
        e = move-exception;
        FLogger.f375446a.e("VeCameraHelper", "close failed:" + e);
    L31:
        th = th;
        r105 = null;
    L33:
        e = e;
        goto L34
    }

    public static Bitmap a(Bitmap r110, int r111, int r112, pq9.h r113) {
        Intrinsics.checkNotNullParameter(r110, SimplayerImageStrategy.RESULT_BITMAP);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L12
        FLogger.f375446a.i("VeCameraHelper", "[bitmap] width:" + r110.getWidth() + " height:" + r110.getHeight());     // Catch: Throwable -> L12
        Bitmap r101 = r110.copy(z0.b(r110.getConfig()), true);     // Catch: Throwable -> L12
        Matrix r102 = new Matrix();     // Catch: Throwable -> L12
        r102.postRotate((float) r111);     // Catch: Throwable -> L12
        if (r112 >= 0) goto L6;
    L9:
        int r103 = 0;
    L10:
        return Bitmap.createBitmap(r101, 0, r103, r101.getWidth(), r101.getHeight() - r103, r102, true);
    L6:
        if ((r110.getWidth() * 4) == (r110.getHeight() * 3)) goto L9;
        r103 = r112;
    L12:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Throwable r115 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r115 == null) goto L21;
        FLogger.f375446a.e("VeCameraHelper", "cropBitmap failed:" + r115);
        if (r113 == null) goto L24;
        r113.a(1001, r115.getMessage());
        return null;
    L24:
        return null;
    L21:
        throw new KotlinNothingValueException();
    }
}
