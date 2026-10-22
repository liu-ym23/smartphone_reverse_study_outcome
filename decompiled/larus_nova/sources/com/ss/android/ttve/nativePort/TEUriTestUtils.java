package com.ss.android.ttve.nativePort;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.vesdk.VEFileUtils;
import com.ss.android.vesdk.VELogUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public class TEUriTestUtils {
    private static final String TAG = "TEUriTestUtils";

    public TEUriTestUtils() {
    }

    public static native int checkVideo(String r100);

    public static native int decodeImageFile(String r100);

    public static native int getColorGamut(String r100);

    public static native int getImageInfo(String r100);

    public static native boolean isFileExistCompat(String r100);

    /* JADX WARN: Multi-variable type inference failed */
    public static int getRotation(ContentResolver r100, String r101) {
        ExifInterface r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        ParcelFileDescriptor r103 = 0;
        r102 = null;
        if (VEFileUtils.isAndroidUriPath(r101) == false) goto L74;
        if (r100 != null) goto L71;
        VELogUtil.e(TAG, "contentResolver should not be null after Android Q");
        return -1;
    L71:
        ParcelFileDescriptor r104 = com_ss_android_ttve_nativePort_TEUriTestUtils_android_content_ContentResolver_openFileDescriptor(r100, UriProtector.parse(r101), "r");     // Catch: Throwable -> L32 IOException -> L34 FileNotFoundException -> L40
        if (r104 != null) goto L78;
        if (r104 != null) goto L72;
    L19:
        return -1;
    L72:
        r104.close();     // Catch: IOException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L78:
    L30:
        e = e;
    L42:
        e.printStackTrace();     // Catch: Throwable -> L60
        if (r104 == null) goto L45;
        r104.close();     // Catch: IOException -> L26
    L68:
    L45:
        if (r102 == null) goto L59;
        int r105 = com_ss_android_ttve_nativePort_TEUriTestUtils_android_media_ExifInterface_getAttributeInt(r102, androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
        if (r105 != 3) goto L49;
        return 180;
    L49:
        if (r105 != 6) goto L51;
        return 90;
    L51:
        if (r105 == 8) goto L53;
        return 0;
    L53:
        return 270;
    L59:
        return -1;
    L28:
        e = e;
    L36:
        e.printStackTrace();     // Catch: Throwable -> L60
        if (r104 == null) goto L45;
        r104.close();     // Catch: IOException -> L26
        goto L68
    L21:
        if (Build.VERSION.SDK_INT < 24) goto L24;
        r102 = new ExifInterface(r104.getFileDescriptor());     // Catch: IOException -> L28 FileNotFoundException -> L30 Throwable -> L60
        goto L24
    L24:
        r104.close();     // Catch: IOException -> L26
        goto L68
    L26:
        e = move-exception;
        e.printStackTrace();
    L40:
        e = e;
        r104 = null;
    L34:
        e = e;
        r104 = null;
    L32:
        th = th;
    L62:
        if (r103 != 0) goto L76;
    L67:
        throw th;
    L76:
        r103.close();     // Catch: IOException -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L60:
        th = th;
        r103 = r100;
        goto L62
    L74:
        r102 = new ExifInterface(r101);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L45
    }

    private static ParcelFileDescriptor com_ss_android_ttve_nativePort_TEUriTestUtils_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r110, r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static int com_ss_android_ttve_nativePort_TEUriTestUtils_android_media_ExifInterface_getAttributeInt(ExifInterface r110, String r111, int r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.getAttributeInt(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
