package com.bytedance.mira.core.opt.res.ext;

import android.app.ResourcesManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.ArrayMap;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.ref.Reference;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public class ResourcesManagerExtApi21Impl extends ResourcesManagerExtImpl {
    private static final String TAG = "ResourcesManagerExtApi21Impl";
    private static final ArrayMap<Object, Reference<Resources>> sActiveResources = null;
    private static final Field sActiveResourcesFiled = null;
    private static final Object sLock = null;
    private IAssetManagerExt mAssetManagerExt;

    static {
        Field r100 = ReflectUtils.findDeclaredField(ResourcesManager.class, "mActiveResources");
        sActiveResourcesFiled = r100;
        sLock = ResourcesManager.getInstance();
        sActiveResources = (ArrayMap) ReflectUtils.readDeclaredField(r100, ResourcesManager.getInstance());
    }

    public ResourcesManagerExtApi21Impl() {
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public boolean appendSplitAsset(Collection<String> r110) {
        if (r110 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi21Impl >>> appendSplitAsset err, paths=" + r110, null);
        return false;
    L6:
        Object r100 = sLock;
        if (r100 != null) goto L9;
    L52:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi21Impl >>> appendSplitAsset err, sLock=" + r100 + ", sActiveResourcesFiled=" + sActiveResourcesFiled + ", sActiveResources=" + sActiveResources, null);
        return false;
    L9:
        if (sActiveResourcesFiled == null) goto L52;
        if (sActiveResources == null) goto L52;
        String[] r101 = getWebViewPath();
        if (r101 != null) goto L16;
    L23:
        Object r102 = sLock;
        monitor-enter(r102);
        Iterator<Reference<Resources>> r103 = sActiveResources.values().iterator();     // Catch: Throwable -> L49
    L26:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L47;
        Reference<Resources> r105 = r103.next();     // Catch: Throwable -> L49
        if (r105 == null) goto L31;
        Resources r106 = r105.get();     // Catch: Throwable -> L49
    L32:
        if (r106 == null) goto L34;
        AssetManager r107 = r106.getAssets();     // Catch: Throwable -> L49
    L35:
        if (r107 == null) goto L26;
        Iterator<String> r108 = r110.iterator();     // Catch: Throwable -> L49
    L39:
        if (r108.hasNext() == false) goto L44;
        String r109 = r108.next();     // Catch: Throwable -> L49
        boolean r111 = addAssetPath(r107, r109);     // Catch: Throwable -> L49
        if (r111 == false) goto L42;
        r104 = r111;
        goto L39
    L42:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi21Impl appendSplitAsset err, addAssetPath result=false ,path=" + r109);     // Catch: Throwable -> L49
        r104 = r111;
    L44:
        if (r104 == true) goto L26;
        monitor-exit(r102);     // Catch: Throwable -> L49
        return false;
    L34:
        r107 = null;
        goto L35
    L31:
        r106 = null;
        goto L32
    L47:
        monitor-exit(r102);     // Catch: Throwable -> L49
        return true;
    L49:
        th = move-exception;
        throw th;
    L16:
        if (r101.length == 0) goto L23;
        int r112 = r101.length;
        int r113 = 0;
    L18:
        if (r113 >= r112) goto L23;
        String r114 = r101[r113];
        if (r114 == null) goto L22;
        r110.add(r114);
    L22:
        r113 = r113 + 1;
        goto L18
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

    @Override // com.bytedance.mira.core.opt.res.ext.ResourcesManagerExtImpl, com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public void init(IWebViewExt r100, IAssetManagerExt r101, IResourcesExt r102, IResourcesKeyExt r103, Context r104) {
        super.init(r100, r101, r102, r103, r104);
        this.mAssetManagerExt = r101;
    }
}
