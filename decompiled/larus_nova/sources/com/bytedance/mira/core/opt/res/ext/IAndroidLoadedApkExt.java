package com.bytedance.mira.core.opt.res.ext;

import android.content.res.Resources;

/* JADX INFO: loaded from: classes3.dex */
public interface IAndroidLoadedApkExt {
    Resources buildResources(Object r100, Object r101);

    String[] getSplitDirsByLoadedApk(Object r100);

    void init();

    boolean injectLoadedApk(Object r100, Object r101);
}
