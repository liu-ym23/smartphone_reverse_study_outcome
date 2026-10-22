package com.larksuite.framework.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;

/* JADX INFO: loaded from: classes24.dex */
public final class m {
    public static Uri a(Context r100, File r101) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return FileProvider.getUriForFile(r100, r100.getPackageName() + ".common.fileprovider", r101);
    L6:
        return Uri.fromFile(r101);
    }
}
