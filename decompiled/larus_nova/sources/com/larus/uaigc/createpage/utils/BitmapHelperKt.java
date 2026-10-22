package com.larus.uaigc.createpage.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.image.entity.LoadParams;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes31.dex */
public final class BitmapHelperKt {
    public static String b() {
        Intrinsics.checkNotNullParameter(LoadParams.ImageFormat.JPEG, "formatSuffix");
        String r100 = "image_" + UUID.randomUUID() + '.' + LoadParams.ImageFormat.JPEG;
        return AppHost.f326268a.getApplication().getExternalFilesDir(null) + "_gen_image" + r100;
    }

    public static final PolarisFileWrapper a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "formatSuffix");
        return (PolarisFileWrapper) aa9.a.f2357a.d("ai_beautify", "image_" + UUID.randomUUID() + '.' + r100);
    }

    public static final Bitmap g(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = RangesKt.coerceAtMost(r100.getWidth(), r100.getHeight()) / 2;
        int r102 = r101 * 2;
        Bitmap r103 = Bitmap.createBitmap(r102, r102, Bitmap.Config.ARGB_8888);
        Canvas r104 = new Canvas(r103);
        Paint r105 = new Paint();
        r105.setAntiAlias(true);
        Path r106 = new Path();
        float r107 = r101;
        r106.addCircle(r107, r107, r107, Path.Direction.CW);
        r104.drawPath(r106, r105);
        r105.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r104.drawBitmap(r100, r101 - (r100.getWidth() / 2), r101 - (r100.getHeight() / 2), r105);
        return r103;
    }

    public static final void c(Activity r100, Uri r101, Uri r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "sourceUri");
        Intrinsics.checkNotNullParameter(r102, "destinationUri");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L34
        ContentResolver r104 = r100.getContentResolver();     // Catch: Throwable -> L34
        Unit r105 = null;
        if (r104 == null) goto L32;
        InputStream r106 = ContentResolverWrapper.openInputStream(r104, r101);     // Catch: Throwable -> L34
        if (r106 == null) goto L32;
        ContentResolver r107 = r100.getContentResolver();     // Catch: Throwable -> L27
        if (r107 == null) goto L24;
        OutputStream r108 = ContentResolverWrapper.openOutputStream(r107, r102);     // Catch: Throwable -> L27
        if (r108 == null) goto L24;
        byte[] r109 = new byte[4096];     // Catch: Throwable -> L19
    L13:
        int r110 = r106.read(r109);     // Catch: Throwable -> L19
        if (r110 == (-1)) goto L16;
        r108.write(r109, 0, r110);     // Catch: Throwable -> L19
        goto L13
    L16:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r108, null);     // Catch: Throwable -> L27
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L27
    L25:
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L34
        r105 = r112;
        goto L32
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L24:
        r112 = null;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L32:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L34
        return;
    L34:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final Object f(Bitmap r100, String r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$saveBitmapToCleanableDir$2(r101, r100, null), r102);
    }

    public static final Object d(Context r100, Bitmap r101, String r102, Continuation<? super File> r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$saveBitMapToFile$2(r100, r102, r101, null), r103);
    }

    public static final Object e(Bitmap r100, String r101, int r102, Continuation<? super Boolean> r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$saveBitMapToFile$4(r101, r100, r102, null), r103);
    }
}
