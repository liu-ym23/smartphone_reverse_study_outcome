package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.d;
import com.tencent.open.utils.m;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public class a {
    public static final Bitmap a(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100, r102);     // Catch: OutOfMemoryError -> L8
    L10:
        int r103 = r102.outWidth;
        int r104 = r102.outHeight;
        if (r102.mCancel == false) goto L13;
    L40:
        return null;
    L13:
        if (r103 == (-1)) goto L40;
        if (r104 == (-1)) goto L40;
        if (r103 > r104) goto L19;
        r103 = r104;
    L19:
        r102.inPreferredConfig = Bitmap.Config.RGB_565;
        if (r103 <= r101) goto L22;
        r102.inSampleSize = a(r102, -1, r101 * r101);
    L22:
        r102.inJustDecodeBounds = false;
        Bitmap r105 = BitmapFactory.decodeFile(r100, r102);     // Catch: OutOfMemoryError -> L25 Exception -> L27
    L30:
        if (r105 != null) goto L33;
        SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap return null");
        return null;
    L33:
        int r106 = r102.outWidth;
        int r107 = r102.outHeight;
        if (r106 > r107) goto L37;
        r106 = r107;
    L37:
        if (r106 > r101) goto L39;
        return r105;
    L39:
        return a(r105, r101);
    L27:
        e = move-exception;
        SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception2:", e);
    L29:
        r105 = null;
    L25:
        e = move-exception;
        SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap OutOfMemoryError:", e);
    L8:
        e = move-exception;
        SLog.e("openSDK_LOG.AsynScaleCompressImage", "scaleBitmap exception1:", e);
        goto L10
    }

    private static Bitmap a(Bitmap r100, int r101) {
        Matrix r102 = new Matrix();
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        if (r103 > r104) goto L6;
        r103 = r104;
    L6:
        float r105 = r101 / r103;
        r102.postScale(r105, r105);
        return Bitmap.createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r102, true);
    }

    public static final String a(Bitmap r100, String r101, String r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == true) goto L5;
        r103.mkdirs();
    L5:
        StringBuffer r104 = new StringBuffer(r101);
        r104.append(r102);
        String r105 = r104.toString();
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105);
        if (r106.exists() == false) goto L8;
        r106.delete();
    L8:
        if (r100 == null) goto L19;
        PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(r106);     // Catch: IOException -> L11 FileNotFoundException -> L13
        r100.compress(Bitmap.CompressFormat.JPEG, 80, r107);     // Catch: IOException -> L11 FileNotFoundException -> L13
        r107.flush();     // Catch: IOException -> L11 FileNotFoundException -> L13
        r107.close();     // Catch: IOException -> L11 FileNotFoundException -> L13
        r100.recycle();     // Catch: IOException -> L11 FileNotFoundException -> L13
        return r105;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L19:
        return null;
    }

    private static final boolean b(String r100, int r101, int r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100, r103);     // Catch: OutOfMemoryError -> L8
    L10:
        int r104 = r103.outWidth;
        int r105 = r103.outHeight;
        if (r103.mCancel == false) goto L13;
    L28:
        return false;
    L13:
        if (r104 == (-1)) goto L28;
        if (r105 == (-1)) goto L28;
        if (r104 <= r105) goto L18;
        int r106 = r104;
    L19:
        if (r104 < r105) goto L22;
        r104 = r105;
    L22:
        SLog.d("openSDK_LOG.AsynScaleCompressImage", "longSide=" + r106 + "shortSide=" + r104);
        r103.inPreferredConfig = Bitmap.Config.RGB_565;
        if (r106 > r102) goto L27;
        if (r104 > r101) goto L27;
        return false;
    L27:
        return true;
    L18:
        r106 = r105;
    L8:
        e = move-exception;
        SLog.e("openSDK_LOG.AsynScaleCompressImage", "isBitMapNeedToCompress exception:", e);
        goto L10
    }

    public static final void a(final Context r100, final String r101, final d r102) {
        SLog.i("openSDK_LOG.AsynScaleCompressImage", "scaleCompressImage()");
        if (TextUtils.isEmpty(r101) == false) goto L7;
        r102.a(1, null);
        return;
    L7:
        if (m.a() == true) goto L10;
        r102.a(2, null);
        return;
    L10:
        final Looper r103 = r100.getMainLooper();
        final Handler r104 = new AnonymousClass1(r103, r102);
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass2(r101, r104, r100), "nnect/share/a"));
    }

    private static int b(BitmapFactory.Options r100, int r110, int r111) {
        double r101 = r100.outWidth;
        double r102 = r100.outHeight;
        if (r111 != (-1)) goto L5;
        int r103 = 1;
    L6:
        if (r110 != (-1)) goto L8;
        int r104 = 128;
    L9:
        if (r104 >= r103) goto L11;
        return r103;
    L11:
        if (r111 != (-1)) goto L14;
        if (r110 != (-1)) goto L14;
        return 1;
    L14:
        if (r110 != (-1)) goto L16;
        return r103;
    L16:
        return r104;
    L8:
        double r105 = r110;
        r104 = (int) Math.min(Math.floor(r101 / r105), Math.floor(r102 / r105));
        goto L9
    L5:
        r103 = (int) Math.ceil(Math.sqrt((r101 * r102) / ((double) r111)));
        goto L6
    }

    public static final int a(BitmapFactory.Options r100, int r101, int r102) {
        int r103 = b(r100, r101, r102);
        if (r103 > 8) goto L8;
        int r104 = 1;
    L5:
        if (r104 >= r103) goto L10;
        r104 = r104 << 1;
        goto L5
    L10:
        return r104;
    L8:
        return ((r103 + 7) / 8) * 8;
    }

    public static /* synthetic */ boolean a(String r100, int r101, int r102) {
        return b(r100, r101, r102);
    }
}
