package com.ss.android.lark.imageqrcode.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.p;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.lark.android.encryption.CipherManager;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f426671a = 0;

    static {
    }

    public static Bitmap a(String r100) {
        VFSFiles r101 = VFSFiles.f444819b;     // Catch: Throwable -> L8
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        CipherManager.e(r101.i(r102), true).getPath();     // Catch: Throwable -> L8
        Bitmap r103 = p.d(r100);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r103, SimplayerImageStrategy.RESULT_BITMAP);     // Catch: Throwable -> L8
        Lazy r104 = ImageQRCodeSettings.f426670b;     // Catch: Throwable -> L8
        return p.b(r103, ((ImageQRCodeSettings.ImageQRCodeConfig) r104.getValue()).getSuperSizeSmallSide(), ((ImageQRCodeSettings.ImageQRCodeConfig) r104.getValue()).getSuperSizeBigSide());
    L5:
        r102 = r100;
    L8:
        th = move-exception;
        Log.e("ImageQRCodeUtils", "decodeBitmap failed, path:" + r100 + ", msg:" + th.getMessage());
        StringBuilder r105 = new StringBuilder("decodeBitmap failed, path:");
        r105.append(r100);
        Log.e("ImageQRCodeUtils", r105.toString());
        return null;
    }

    public static boolean b(Activity r100) {
        if (r100 != null) goto L4;
    L9:
        boolean r101 = true;
    L10:
        Log.i("ImageQRCodeUtils", "is activity inValid:" + r101);
        return r101;
    L4:
        if (r100.isDestroyed() == true) goto L9;
        if (r100.isFinishing() == true) goto L9;
        r101 = false;
        goto L10
    }

    public static boolean c(Bitmap r100) {
        if (r100 != null) goto L4;
    L11:
        boolean r101 = true;
    L12:
        Log.i("ImageQRCodeUtils", "is bitmap inValid:" + r101);
        return r101;
    L4:
        if (r100.isRecycled() == true) goto L11;
        if (r100.getWidth() == 0) goto L11;
        if (r100.getHeight() == 0) goto L11;
        r101 = false;
        goto L12
    }
}
