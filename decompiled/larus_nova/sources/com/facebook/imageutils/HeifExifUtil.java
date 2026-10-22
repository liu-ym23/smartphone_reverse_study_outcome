package com.facebook.imageutils;

import android.media.ExifInterface;
import android.os.Build;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.facebook.common.logging.FLog;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import f06.b;
import f06.d;
import g06.a;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public class HeifExifUtil {
    public static final String TAG = "HeifExifUtil";

    public static class HeifExifUtilAndroidN {
        private HeifExifUtilAndroidN() {
        }

        public static int getOrientation(InputStream r100) {
            return com_facebook_imageutils_HeifExifUtil$HeifExifUtilAndroidN_android_media_ExifInterface_getAttributeInt(new ExifInterface(r100), androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        L8:
            e = move-exception;
            FLog.d(HeifExifUtil.TAG, "Failed reading Heif Exif orientation -> ignoring", e);
            return 0;
        L5:
            th = move-exception;
            FLog.d(HeifExifUtil.TAG, "System api err, Failed reading Heif Exif orientation -> ignoring", th);
            return 0;
        }

        private static int com_facebook_imageutils_HeifExifUtil$HeifExifUtilAndroidN_android_media_ExifInterface_getAttributeInt(ExifInterface r110, String r111, int r210) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111, Integer.valueOf(r210)};
            b r112 = new b();
            a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
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
            d r107 = r106.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r110, r101, "int", r112);     // Catch: Exception -> L22
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
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    public HeifExifUtil() {
    }

    public static int getOrientation(InputStream r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        FLog.d(TAG, "Trying to read Heif Exif information before Android N -> ignoring");
        return 0;
    L5:
        return HeifExifUtilAndroidN.getOrientation(r100);
    }
}
