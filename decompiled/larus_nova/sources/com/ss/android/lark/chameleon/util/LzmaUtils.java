package com.ss.android.lark.chameleon.util;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.libarchive.Archive;
import com.ss.android.lark.chameleon.idependency.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public class LzmaUtils {
    private static final String TAG = null;

    public LzmaUtils() {
    }

    static {
        TAG = "LzmaUtils";
    }

    public static int extract7z(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L14:
        return -1;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
    L12:
        e = move-exception;
        Log.e(TAG, "extractAll fails : " + e + "  message:" + e.getMessage());
        goto L14
    L8:
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L10;
        r101 = r101 + File.separator;     // Catch: IOException -> L12
    L10:
        return Archive.extractAll(r100, r101, null, 0);
    }

    public static String extract7zEntry(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L11:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return Archive.extractEntryToString(r100, r101, null);
    L9:
        e = move-exception;
        Log.e(TAG, "extractEntry :" + r101 + " fails : " + e + " message:" + e.getMessage());
        goto L11
    }
}
