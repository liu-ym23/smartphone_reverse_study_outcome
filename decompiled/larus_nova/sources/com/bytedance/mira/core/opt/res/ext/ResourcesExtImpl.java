package com.bytedance.mira.core.opt.res.ext;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ResourcesExtImpl implements IResourcesExt {
    protected IAssetManagerExt mAssetManagerExt;
    protected Context mContext;
    protected IWebViewExt mWebViewExt;

    public ResourcesExtImpl() {
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public Object getProviderLock() {
        IWebViewExt r100 = this.mWebViewExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getProviderLock();
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public String[] getWebViewPath() {
        IWebViewExt r100 = this.mWebViewExt;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getWebViewPath();
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public void init(IWebViewExt r100, IAssetManagerExt r101, IResourcesKeyExt r102, Context r103) {
        this.mWebViewExt = r100;
        this.mAssetManagerExt = r101;
        this.mContext = r103;
    }
}
