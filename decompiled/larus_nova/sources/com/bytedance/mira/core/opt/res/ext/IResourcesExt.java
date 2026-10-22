package com.bytedance.mira.core.opt.res.ext;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.ResourcesImpl;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface IResourcesExt {
    boolean addAssetPaths(Context r100, Resources r101, Collection<String> r102, boolean r103);

    ResourcesImpl getImpl(Resources r100);

    Object getProviderLock();

    String[] getWebViewPath();

    void init(IWebViewExt r100, IAssetManagerExt r101, IResourcesKeyExt r102, Context r103);

    boolean setImpl(Resources r100, ResourcesImpl r101);
}
