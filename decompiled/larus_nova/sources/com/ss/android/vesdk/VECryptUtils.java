package com.ss.android.vesdk;

import java.io.FileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: classes40.dex */
public final class VECryptUtils {
    private static final String TAG = "VECryptUtils";

    public VECryptUtils() {
    }

    private static native String nativeQueryCryptJson(String r100);

    public static String queryCryptJson(String r100) {
        return nativeQueryCryptJson(r100);
    }

    public static InputStream cryptGetInputStream(FileDescriptor r100, String r101) {
        return new TECryptStream(r100, r101);
    L4:
        th = move-exception;
        VELogUtil.e(TAG, th.getLocalizedMessage());
        return null;
    }

    public static InputStream cryptGetInputStream(String r100, String r101) {
        return new TECryptStream(r100, r101);
    L4:
        th = move-exception;
        VELogUtil.e(TAG, th.getLocalizedMessage());
        return null;
    }
}
