package com.larus.bmhome.upload;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
public final class UploadImageMetaResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UploadImageMetaResolver f314744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f314745b = 0.0f;

    public UploadImageMetaResolver() {
    }

    static {
        f314744a = new UploadImageMetaResolver();
        f314745b = c7.b(Float.valueOf(286.0f)) / c7.c(Float.valueOf(390.0f));
    }

    public final Object b(mr9.j r100, Continuation<? super mr9.d> r101) {
        if ((r101 instanceof UploadImageMetaResolver$resolveLocalImageResult$1) == false) goto L7;
        UploadImageMetaResolver$resolveLocalImageResult$1 r102 = (UploadImageMetaResolver$resolveLocalImageResult$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L20:
        Pair r107 = (Pair) r104;
        int r108 = ((Number) r107.component1()).intValue();
        return new mr9.d(((Number) r107.component2()).intValue(), r108);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Context r109 = r100.getContext();
        if (r109 != null) goto L17;
        gd9.i r110 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r110);
        r109 = r110.getApplication();
    L17:
        String r111 = r100.f514999a;
        boolean r112 = r100.f515005g;
        r102.label = 1;
        r104 = BuildersKt.withContext(Dispatchers.getIO(), new UploadImageMetaResolver$resolveLocalImageSize$2(r112, r111, r109, null), r102);
        if (r104 != r105) goto L20;
        return r105;
    L7:
        r102 = new UploadImageMetaResolver$resolveLocalImageResult$1(this, r101);
        goto L8
    }

    public static final boolean a(UploadImageMetaResolver r100, Context r101, Uri r102) {
        r100.getClass();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L22
        InputStream r104 = ContentResolverWrapper.openInputStream(r101.getContentResolver(), r102);     // Catch: Throwable -> L22
        boolean r105 = false;
        if (r104 != null) goto L30;
    L20:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L22
    L24:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L29;
        FLogger.f375446a.e("UploadImageMetaResolver", "[needSwapWidthHeight] parse exif failed", r107);
        r106 = Boolean.FALSE;
    L29:
        return ((Boolean) r106).booleanValue();
    L30:
        int r108 = new ExifInterface(r104).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);     // Catch: Throwable -> L15
    L8:
        if (r108 != 6) goto L10;
    L11:
        r105 = true;
    L13:
        CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L22
        goto L20
    L10:
        if (r108 != 8) goto L13;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }
}
