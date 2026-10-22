package com.bytedance.mira.core.opt.res.ext;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.ResourcesImpl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ResourcesManagerExtImpl implements IResourcesManagerExt {
    protected Context mContext;
    protected IResourcesExt mResourcesExt;
    protected IWebViewExt mWebViewExt;

    public ResourcesManagerExtImpl() {
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public Object getProviderLock() {
        IWebViewExt r100 = this.mWebViewExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getProviderLock();
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public String[] getWebViewPath() {
        IWebViewExt r100 = this.mWebViewExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getWebViewPath();
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public ResourcesImpl getImpl(Resources r100) {
        IResourcesExt r101 = this.mResourcesExt;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getImpl(r100);
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public boolean setImpl(Resources r100, ResourcesImpl r101) {
        IResourcesExt r102 = this.mResourcesExt;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.setImpl(r100, r101) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public void init(IWebViewExt r100, IAssetManagerExt r101, IResourcesExt r102, IResourcesKeyExt r103, Context r104) {
        this.mWebViewExt = r100;
        this.mContext = r104;
        this.mResourcesExt = r102;
    }
}
