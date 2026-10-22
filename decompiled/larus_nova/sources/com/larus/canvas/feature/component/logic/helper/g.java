package com.larus.canvas.feature.component.logic.helper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.common.apphost.AppHost;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class g {
    public static final Pair<Integer, Integer> c(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L31
        AppHost.Companion r103 = AppHost.f326268a;     // Catch: Throwable -> L31
        InputStream r104 = ContentResolverWrapper.openInputStream(r103.getApplication().getContentResolver(), r100);     // Catch: Throwable -> L31
        BitmapFactory.Options r105 = new BitmapFactory.Options();     // Catch: Throwable -> L31
        boolean r106 = true;
        r105.inJustDecodeBounds = true;     // Catch: Throwable -> L31
        BitmapFactory.decodeStream(r104, null, r105);     // Catch: Throwable -> L31
        if (r104 == null) goto L6;
        r104.close();     // Catch: Throwable -> L31
    L6:
        InputStream r107 = ContentResolverWrapper.openInputStream(r103.getApplication().getContentResolver(), r100);     // Catch: Throwable -> L31
        if (r107 == null) goto L9;
        ExifInterface r108 = new ExifInterface(r107);     // Catch: Throwable -> L31
    L10:
        if (r108 == null) goto L12;
        Integer r109 = Integer.valueOf(r108.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1));     // Catch: Throwable -> L31
    L13:
        if (r107 == null) goto L15;
        r107.close();     // Catch: Throwable -> L31
    L15:
        if (r109 != null) goto L18;
    L19:
        if (r109 != null) goto L22;
    L24:
        r106 = false;
    L25:
        int r110 = r105.outWidth;     // Catch: Throwable -> L31
        int r111 = r105.outHeight;     // Catch: Throwable -> L31
        if (r106 == false) goto L28;
        Pair r112 = TuplesKt.to(Integer.valueOf(r111), Integer.valueOf(r110));     // Catch: Throwable -> L31
    L29:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L31
    L34:
        if (Result.m9455isFailureimpl(r113) == true) goto L38;
        r101 = r113;
    L38:
        return (Pair) r101;
    L28:
        r112 = TuplesKt.to(Integer.valueOf(r110), Integer.valueOf(r111));     // Catch: Throwable -> L31
        goto L29
    L22:
        if (r109.intValue() != 8) goto L24;
    L18:
        if (r109.intValue() == 6) goto L25;
    L12:
        r109 = null;
        goto L13
    L9:
        r108 = null;
    L31:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    }

    public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static final Object b(Context r100, String r101, ContinuationImpl r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageUtilsKt$downloadImageUrlToLocalPath$2(r101, r100, null), r102);
    }
}
