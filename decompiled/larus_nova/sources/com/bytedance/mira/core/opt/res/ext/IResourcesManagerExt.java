package com.bytedance.mira.core.opt.res.ext;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.ResourcesImpl;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface IResourcesManagerExt {
    boolean appendSplitAsset(Collection<String> r100);

    ResourcesImpl getImpl(Resources r100);

    Object getProviderLock();

    String[] getWebViewPath();

    void init(IWebViewExt r100, IAssetManagerExt r101, IResourcesExt r102, IResourcesKeyExt r103, Context r104);

    boolean setImpl(Resources r100, ResourcesImpl r101);
}
