package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
public class ApkAssets {
    private static final String LOGTAG = "ApkAssets";

    public ApkAssets() {
    }

    public static long[] open(String r100, String r101) {
        AssetFileDescriptor r102 = null;
        Context r103 = ContextUtils.getApplicationContext();     // Catch: Throwable -> L11 IOException -> L13
        if (TextUtils.isEmpty(r101) == false) goto L6;
    L8:
        r102 = r103.getAssets().openNonAssetFd(r100);     // Catch: Throwable -> L11 IOException -> L13
        long[] r104 = {r102.getParcelFileDescriptor().detachFd(), r102.getStartOffset(), r102.getLength()};     // Catch: Throwable -> L11 IOException -> L13
    L33:
        r102.close();     // Catch: IOException -> L26
    L10:
        return r104;
    L6:
        if (BundleUtils.isIsolatedSplitInstalled(r103, r101) == false) goto L8;
        r103 = BundleUtils.createIsolatedSplitContext(r103, r101);     // Catch: Throwable -> L11 IOException -> L13
    L13:
        e = move-exception;
        if (e.getMessage().equals("") == false) goto L17;
    L19:
        long[] r105 = {-1, -1, -1};     // Catch: Throwable -> L11
        if (r102 != null) goto L35;
    L22:
        return r105;
    L35:
        r102.close();     // Catch: IOException -> L28
        goto L22
    L17:
        if (e.getMessage().equals(r100) == true) goto L19;
        e.toString();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        if (r102 != null) goto L29;
    L25:
        throw th;
    L29:
        r102.close();     // Catch: IOException -> L27
        goto L25
    }
}
