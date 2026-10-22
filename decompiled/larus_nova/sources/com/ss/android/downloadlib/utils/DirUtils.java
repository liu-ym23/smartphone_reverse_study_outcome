package com.ss.android.downloadlib.utils;

import android.content.Context;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/downloadlib/utils/DirUtils;", "", "()V", "EXT_PRIVATE_DIR", "", "TAG", "getBusinessPrivatePath", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class DirUtils {
    private static final String EXT_PRIVATE_DIR = "BusinessTTDownload";
    public static final DirUtils INSTANCE = null;
    private static final String TAG = "TTDownload_DirUtils";

    private DirUtils() {
    }

    @JvmStatic
    public static final String getBusinessPrivatePath() {
        Context r100 = GlobalInfo.getContext();     // Catch: Exception -> L13
        if (r100 == null) goto L15;
        File r101 = r100.getExternalFilesDir(EXT_PRIVATE_DIR);     // Catch: Exception -> L13
        if (r101 != null) goto L8;
    L10:
        if (r101 == null) goto L18;
        return r101.getAbsolutePath();
    L18:
        return null;
    L8:
        if (r101.exists() == true) goto L10;
        r101.mkdirs();     // Catch: Exception -> L13
    L15:
        return null;
    L13:
        e = move-exception;
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "getBusinessPrivatePath", "Error:" + e);
        goto L15
    }

    static {
        INSTANCE = new DirUtils();
    }
}
