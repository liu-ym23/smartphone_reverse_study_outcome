package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import java.util.Random;

/* JADX INFO: loaded from: classes35.dex */
public class SessionIDGenerator {
    public SessionIDGenerator() {
    }

    public static String generateSessionID(String r100) {
        String r101 = new String();
        if (r100 == null) goto L6;
        r101 = r101.concat(r100);
    L6:
        return Base64.encodeToString(((r101 + new Random().nextInt()) + System.currentTimeMillis()).getBytes(), 2);
    }

    public static String generateTrackID(String r100) {
        StringBuilder r101 = new StringBuilder();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r101.append(r100);
        r101.append(ExifInterface.GPS_DIRECTION_TRUE);
    L5:
        r101.append(Long.toString(System.currentTimeMillis()));
        r101.append(ExifInterface.GPS_DIRECTION_TRUE);
        r101.append(Integer.toString((int) (Math.random() * 65535.0d)));
        return r101.toString();
    }
}
