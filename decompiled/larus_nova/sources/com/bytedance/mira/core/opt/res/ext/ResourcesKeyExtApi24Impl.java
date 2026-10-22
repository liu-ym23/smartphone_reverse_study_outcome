package com.bytedance.mira.core.opt.res.ext;

import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.ResourcesKey;

/* JADX INFO: loaded from: classes21.dex */
public class ResourcesKeyExtApi24Impl extends ResourcesKeyExtImpl {
    private static final String TAG = "ResourcesKeyExtApi24Impl";

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public Object getLoaders(ResourcesKey r100) {
        return null;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public int getTokenIdentify(ResourcesKey r100) {
        return 0;
    }

    public ResourcesKeyExtApi24Impl() {
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public CompatibilityInfo getCompatInfo(ResourcesKey r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mCompatInfo;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public int getDisplayId(ResourcesKey r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.mDisplayId;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public String[] getLibDirs(ResourcesKey r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mLibDirs;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public String[] getOverlayDirs(ResourcesKey r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mOverlayDirs;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public Configuration getOverrideConfiguration(ResourcesKey r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mOverrideConfiguration;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public String getResDir(ResourcesKey r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mResDir;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public String[] getSplitResDirs(ResourcesKey r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.mSplitResDirs;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public ResourcesKey buildNewKey(int r110, String r111, String[] r112, String[] r113, String[] r114, int r115, Configuration r116, CompatibilityInfo r117, Object r118) {
        return new ResourcesKey(r111, r112, r113, r114, r115, r116, r117);
    }
}
