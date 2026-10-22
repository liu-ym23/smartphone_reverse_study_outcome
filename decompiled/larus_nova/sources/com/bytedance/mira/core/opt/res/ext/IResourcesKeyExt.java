package com.bytedance.mira.core.opt.res.ext;

import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.ResourcesKey;

/* JADX INFO: loaded from: classes3.dex */
public interface IResourcesKeyExt {
    ResourcesKey buildNewKey(int r100, String r101, String[] r102, String[] r103, String[] r104, int r105, Configuration r106, CompatibilityInfo r107, Object r108);

    CompatibilityInfo getCompatInfo(ResourcesKey r100);

    int getDisplayId(ResourcesKey r100);

    String[] getLibDirs(ResourcesKey r100);

    Object getLoaders(ResourcesKey r100);

    String[] getOverlayDirs(ResourcesKey r100);

    Configuration getOverrideConfiguration(ResourcesKey r100);

    String getResDir(ResourcesKey r100);

    String[] getSplitResDirs(ResourcesKey r100);

    int getTokenIdentify(ResourcesKey r100);

    void init();
}
