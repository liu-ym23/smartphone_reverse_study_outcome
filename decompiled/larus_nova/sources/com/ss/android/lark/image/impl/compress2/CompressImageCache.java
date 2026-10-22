package com.ss.android.lark.image.impl.compress2;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.diskmanage.storage.d;
import java.io.File;

/* JADX INFO: loaded from: classes36.dex */
class CompressImageCache {
    private String cacheDir;
    private final Context context;

    private void checkCacheDir() {
        if (TextUtils.isEmpty(this.cacheDir) == false) goto L5;
        this.cacheDir = d.h(this.context);
        return;
    L5:
        FileUtils.t(this.cacheDir);
    }

    public File createCacheFile(String r100) {
        return new PolarisFileWrapper(this.cacheDir, r100);
    }

    public File getCacheFile(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.cacheDir, r100);
        if (r101.exists() == false) goto L5;
        return r101;
    L5:
        return null;
    }

    public CompressImageCache(Context r100, String r101) {
        this.context = r100;
        this.cacheDir = r101;
        checkCacheDir();
    }
}
