package com.bytedance.mira.core.opt.res.ext;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.ResourcesImpl;
import com.bytedance.mira.log.MiraLogger;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public class ResourcesExtApi21Impl extends ResourcesExtImpl {
    private static final String TAG = "ResourcesExtApi21Impl";

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public ResourcesImpl getImpl(Resources r100) {
        return null;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public boolean setImpl(Resources r100, ResourcesImpl r101) {
        return false;
    }

    public ResourcesExtApi21Impl() {
    }

    private boolean addAssetPath(AssetManager r100, String r101) {
        IAssetManagerExt r102 = this.mAssetManagerExt;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.addAssetPath(r100, r101) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public boolean addAssetPaths(Context r100, Resources r101, Collection<String> r102, boolean r103) {
        if (r101 == null) goto L27;
        if (r102 == null) goto L27;
        String[] r104 = getWebViewPath();
        if (r104 != null) goto L9;
    L16:
        Iterator<String> r105 = r102.iterator();
        boolean r106 = true;
    L18:
        if (r105.hasNext() == false) goto L26;
        String r107 = r105.next();
        if (r106 == true) goto L22;
    L24:
        r106 = false;
    L25:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi21Impl installAssetManager method, addAssetPath result=" + r106 + " ,path=" + r107);
        goto L18
    L22:
        if (addAssetPath(r101.getAssets(), r107) == false) goto L24;
        r106 = true;
        goto L25
    L26:
        return r106;
    L9:
        if (r104.length == 0) goto L16;
        int r108 = r104.length;
        int r109 = 0;
    L11:
        if (r109 >= r108) goto L16;
        String r110 = r104[r109];
        if (r110 == null) goto L15;
        r102.add(r110);
    L15:
        r109 = r109 + 1;
    L27:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi21Impl >>> addAssetPaths err, resources=" + r101 + ", paths=" + r102, null);
        return false;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.ResourcesExtImpl, com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public void init(IWebViewExt r100, IAssetManagerExt r101, IResourcesKeyExt r102, Context r103) {
        super.init(r100, r101, r102, r103);
    }
}
