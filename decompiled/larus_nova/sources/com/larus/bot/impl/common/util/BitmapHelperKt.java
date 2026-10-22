package com.larus.bot.impl.common.util;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class BitmapHelperKt {
    public static final Object c(String r100, Continuation<? super Bitmap> r101) {
        if ((r101 instanceof BitmapHelperKt$getBitmapFromUrl$1) == false) goto L7;
        BitmapHelperKt$getBitmapFromUrl$1 r102 = (BitmapHelperKt$getBitmapFromUrl$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L42:
        return r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L28:
        r102.label = 2;
        kotlinx.coroutines.j r107 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r107.C();
        ImageRequest r108 = ImageRequest.fromUri((Uri) r104);
        DataSource<CloseableReference<CloseableImage>> r109 = Fresco.getImagePipeline().fetchDecodedImage(r108, AppHost.f326268a.getApplication());
        r109.subscribe(new a(r107), CallerThreadExecutor.getInstance());     // Catch: Exception -> L31
    L37:
        r104 = r107.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L40:
        if (r104 != r105) goto L42;
        return r105;
    L31:
        e = move-exception;
        FLogger.f375446a.e("getBitmapFromUrl", "error", e);
        if (r107.isActive() == false) goto L35;
        r107.resumeWith(Result.m9449constructorimpl(null));
    L35:
        if (r109 == null) goto L37;
        Boxing.boxBoolean(r109.close());
        goto L37
    L16:
        ResultKt.throwOnFailure(r104);
        if (r100 != null) goto L19;
    L22:
        boolean r110 = true;
    L23:
        if (r110 == false) goto L25;
        return null;
    L25:
        r102.label = 1;
        r104 = ImageLoaderKt.r(r100, "bitmap_helper", r102);
        if (r104 != r105) goto L28;
        return r105;
    L19:
        if (StringsKt.isBlank(r100) == true) goto L22;
        r110 = false;
    L7:
        r102 = new BitmapHelperKt$getBitmapFromUrl$1(r101);
        goto L8
    }

    public static final Object e(String r100, Continuation<? super Unit> r101) {
        Object r102 = BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$prefetchBitmap$2(r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object f(List<String> r100, Continuation<? super List<Unit>> r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$prefetchBitmap$4(r100, null), r101);
    }

    public static final Object b(FragmentActivity r100, Uri r101, Uri r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "sourceUri");
        Intrinsics.checkNotNullParameter(r102, "destinationUri");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L34
        ContentResolver r104 = r100.getContentResolver();     // Catch: Throwable -> L34
        Unit r105 = null;
        if (r104 == null) goto L46;
        InputStream r106 = ContentResolverWrapper.openInputStream(r104, r101);     // Catch: Throwable -> L34
        if (r106 == null) goto L46;
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
        goto L46
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
    L46:
        return Result.m9449constructorimpl(r105);
    L34:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final Object d(FragmentActivity r100, Uri r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$getImageFormat$2(r100, r101, null), r102);
    }

    public static final Object a(FragmentActivity r100, Uri r101, PolarisFileWrapper r102, Continuation r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$convertImageToJpeg$2(r100, r101, r102, null), r103);
    }

    public static final Object g(Context r100, Bitmap r101, String r102, Continuation<? super File> r103) {
        return BuildersKt.withContext(Dispatchers.getIO(), new BitmapHelperKt$saveBitMapToFile$2(r100, r102, r101, null), r103);
    }
}
