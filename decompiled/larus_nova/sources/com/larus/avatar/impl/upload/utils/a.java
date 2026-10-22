package com.larus.avatar.impl.upload.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f291325a = 0;

    static {
    }

    public a() {
    }

    public static float a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        InputStream r101 = ContentResolverWrapper.openInputStream(AppHost.f326268a.getApplication().getContentResolver(), r100);
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r101, null, r102);
        return Math.max(1.0f, (r102.outWidth * r102.outHeight) / (9000000 * 1.0f));
    }

    public static Bitmap b(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        AppHost.Companion r100 = AppHost.f326268a;
        InputStream r101 = ContentResolverWrapper.openInputStream(r100.getApplication().getContentResolver(), r110);
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        boolean r103 = true;
        r102.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r101, null, r102);
        if (r101 == null) goto L5;
        r101.close();
    L5:
        float r104 = 1 / Math.max(1.0f, (r102.outWidth * r102.outHeight) / (9000000 * 1.0f));
        Matrix r111 = new Matrix();
        r111.setScale(r104, r104);
        r102.inJustDecodeBounds = false;
        InputStream r112 = ContentResolverWrapper.openInputStream(r100.getApplication().getContentResolver(), r110);
        Bitmap r105 = BitmapFactory.decodeStream(r112, null, r102);
        if (r112 == null) goto L9;
        r112.close();
    L9:
        if (r104 == 1.0f) goto L12;
        r103 = false;
    L12:
        if (r103 == true) goto L17;
        if (r105 == null) goto L18;
        FLogger.f375446a.i("ImageUtil", "getBitmapFromUri: called, new bitmap size outWidth is " + r102.outWidth + " outHeight is " + r102.outHeight);
        return Bitmap.createBitmap(r105, 0, 0, r105.getWidth(), r105.getHeight(), r111, true);
    L18:
        return r105;
    L17:
        return r105;
    }
}
