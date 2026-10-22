package com.ss.android.lark.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.media.ExifInterface;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larksuite.framework.utils.FileUtils;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.lark.android.encryption.CipherManager;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class p {
    public static int a(ExifInterface r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r104[r106];
        int r111 = r106;
        int r112 = r105;
        f06.a[] r113 = r104;
        f06.d r108 = r107.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r108.f474982a == true) goto L17;
        r100.add(r107);     // Catch: Exception -> L22
    L17:
        if (r108.f474982a == false) goto L21;
        return ((Integer) r108.f474983b).intValue();
    L21:
        return r210.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
    L14:
        r106 = r111 + 1;
        r105 = r112;
        r104 = r113;
        goto L8
    L15:
        r108 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Bitmap d(String r100) {
        BitmapFactory.Options r101 = new BitmapFactory.Options();
        r101.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100, r101);
        r101.inSampleSize = 1;
        r101.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(r100, r101);
    L5:
        Log.e("BitmapUtils", "Error: OOM file path " + r100);
        return null;
    }

    public static Bitmap f(View r100) {
        Bitmap r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        r100.setDrawingCacheEnabled(true);
        Bitmap r102 = r100.getDrawingCache();
        if (r102 != null) goto L10;
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r100.layout(0, 0, r100.getMeasuredWidth(), r100.getMeasuredHeight());
        r100.buildDrawingCache();
        Bitmap r103 = r100.getDrawingCache();
        if (r103 == null) goto L11;
        r101 = Bitmap.createBitmap(r103);
    L11:
        r100.setDrawingCacheEnabled(false);
        return r101;
    L10:
        r101 = Bitmap.createBitmap(r102);
        goto L11
    }

    public static int[] g(String r100) {
        int r101 = h(r100);
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100, r102);
        int[] r103 = {r102.outWidth, r102.outHeight};
        if (Math.abs(r101) != 90) goto L5;
    L6:
        int r104 = r103[0];
        r103[0] = r103[1];
        r103[1] = r104;
    L8:
        return new int[]{r103[0], r103[1]};
    L5:
        if (Math.abs(r101) != 270) goto L8;
        goto L6
    }

    public static int h(String r100) {
        int r101 = a(new ExifInterface(r100));     // Catch: Exception -> L13
        if (r101 != 3) goto L6;
        return 180;
    L6:
        if (r101 != 6) goto L8;
        return 90;
    L8:
        if (r101 != 8) goto L15;
        return 270;
    L15:
        return 0;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static Bitmap c(Context r100, int r101) {
        Drawable r102 = AppCompatResources.getDrawable(r100, r101);
        if ((r102 instanceof VectorDrawable) == false) goto L10;
        VectorDrawable r103 = (VectorDrawable) r102;
        if (r103 != null) goto L7;
        return null;
    L7:
        Drawable r104 = r103.mutate();
        Bitmap r105 = Bitmap.createBitmap(r104.getIntrinsicWidth(), r104.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r106 = new Canvas(r105);
        r104.setBounds(0, 0, r106.getWidth(), r106.getHeight());
        r104.draw(r106);
        return r105;
    L10:
        return BitmapFactory.decodeResource(r100.getResources(), r101);
    }

    public static Bitmap b(Bitmap r100, int r101, int r102) {
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        int r105 = r103 * r104;
        int r106 = r101 * r102;
        if (r105 <= r106) goto L8;
        if (r101 <= 0) goto L8;
        if (r102 <= 0) goto L8;
        float r107 = (float) Math.sqrt(r105 / r106);
        int r108 = (int) (r103 / r107);
        int r109 = (int) (r104 / r107);
        Bitmap r110 = Bitmap.createScaledBitmap(r100, r108, r109, false);
        Log.i("BitmapUtils", "compressBitmapIfNeed, originWidth:" + r103 + ",originHeight:" + r104 + ",targetWidth:" + r108 + ",targetHeight:" + r109);
        return r110;
    L8:
        Log.i("BitmapUtils", "use origin bitmap, originWidth:" + r103 + ", originHeight:" + r104);
        return r100;
    }

    public static Bitmap e(String r100, int r101, int r102) {
        if (FileUtils.r(r100) == false) goto L15;
        if (r101 <= 0) goto L16;
        if (r102 <= 0) goto L17;
        return b(BitmapFactory.decodeFile(CipherManager.e(VFSFiles.f444819b.i(r100), true).getPath()), r101, r102);
    L9:
        th = move-exception;
        Log.e("BitmapUtils", "decodeBitmapWithLimit error:" + th.getMessage());
        return null;
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    }

    public static boolean i(Bitmap r110, String r111, Bitmap.CompressFormat r112, int r113) {
        if (r110 != null) goto L5;
    L43:
        return false;
    L5:
        if (r110.isRecycled() == true) goto L43;
        OutputStream r100 = null;
        VFSFiles r101 = VFSFiles.f444819b;     // Catch: Throwable -> L27 Exception -> L29
        VFSFile r114 = r101.i(r111);     // Catch: Throwable -> L27 Exception -> L29
        if (r114.exists() == false) goto L12;
        Log.i("BitmapUtils", "saveBitmapToFile, file has existed");     // Catch: Throwable -> L27 Exception -> L29
        return true;
    L12:
        String r102 = r114.getParent();     // Catch: Throwable -> L27 Exception -> L29
        if (r102 != null) goto L15;
    L17:
        OutputStream r103 = r114.newOutputStream();     // Catch: Throwable -> L27 Exception -> L29
        boolean r115 = r110.compress(r112, r113, r103);     // Catch: Throwable -> L27 Exception -> L29
        if (r115 == false) goto L20;
        r103.flush();     // Catch: Throwable -> L27 Exception -> L29
    L20:
        Log.i("BitmapUtils", "save result:" + r115);     // Catch: Throwable -> L27 Exception -> L29
        if (r103 != null) goto L49;
    L26:
        return r115;
    L49:
        r103.close();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.e("BitmapUtils", "close fos error: " + e.getMessage());
        goto L26
    L15:
        if (FileUtils.r(r102) == true) goto L17;
        Log.i("BitmapUtils", "make parent dir isSuccess: " + r101.i(r102).mkdirs());     // Catch: Throwable -> L27 Exception -> L29
    L27:
        th = move-exception;
        if (0 != 0) goto L44;
    L42:
        throw th;
    L44:
        r100.close();     // Catch: Exception -> L40
    L40:
        e = move-exception;
        Log.e("BitmapUtils", "close fos error: " + e.getMessage());
    L29:
        e = move-exception;
        Log.e("BitmapUtils", "saveBitmapToFile error: " + e.getMessage());     // Catch: Throwable -> L27
        if (0 != 0) goto L47;
    L36:
        return false;
    L47:
        r100.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        Log.e("BitmapUtils", "close fos error: " + e.getMessage());
        goto L36
    }
}
