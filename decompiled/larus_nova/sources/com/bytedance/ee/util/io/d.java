package com.bytedance.ee.util.io;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.libarchive.Archive;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f243145a = null;

    public d() {
    }

    static {
        f243145a = d.class.getSimpleName();
    }

    public static int a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L14:
        return -1;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
    L12:
        e = move-exception;
        tt5.a.d(f243145a, "extractAll fails : " + e + "  message:" + e.getMessage());
        goto L14
    L8:
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L10;
        r101 = r101 + File.separator;     // Catch: IOException -> L12
    L10:
        return Archive.extractAll(r100, r101, null, 0);
    }
}
