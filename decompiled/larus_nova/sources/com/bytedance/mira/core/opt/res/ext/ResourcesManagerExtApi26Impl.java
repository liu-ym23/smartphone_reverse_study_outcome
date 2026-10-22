package com.bytedance.mira.core.opt.res.ext;

import android.app.ResourcesManager;
import android.content.Context;
import android.content.res.ResourcesImpl;
import android.content.res.ResourcesKey;
import android.util.ArrayMap;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.ArrayUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.ref.Reference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ResourcesManagerExtApi26Impl extends ResourcesManagerExtImpl {
    private static final String TAG = "ResourcesManagerExtApi26Impl";
    private static final Object sLock = null;
    private static final Method sRedirectResourcesToNewImplLockedMethod = null;
    private static final ArrayMap<ResourcesKey, Reference<ResourcesImpl>> sResourceImpls = null;
    private static final Field sResourceImplsFiled = null;
    private IResourcesKeyExt mResourcesKeyExt;

    static {
        Field r100 = ReflectUtils.findDeclaredField(ResourcesManager.class, "mResourceImpls");
        sResourceImplsFiled = r100;
        sRedirectResourcesToNewImplLockedMethod = ReflectUtils.findDeclaredMethod(ResourcesManager.class, "redirectResourcesToNewImplLocked", new Class[]{ArrayMap.class});
        if (OSUtil.isAndroidSHigher() == false) goto L5;
        sLock = ReflectUtils.readDeclaredField(ReflectUtils.findDeclaredField(ResourcesManager.class, "mLock"), ResourcesManager.getInstance());
    L6:
        sResourceImpls = (ArrayMap) ReflectUtils.readDeclaredField(r100, ResourcesManager.getInstance());
        return;
    L5:
        sLock = ResourcesManager.getInstance();
        goto L6
    }

    public ResourcesManagerExtApi26Impl() {
    }

    private void redirectResourcesToNewImplLocked(ArrayMap<ResourcesImpl, ResourcesKey> r100) {
        Method r101 = sRedirectResourcesToNewImplLockedMethod;
        if (r101 != null) goto L11;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi26Impl >>> redirectResourcesToNewImplLocked err, sRedirectResourcesToNewImplLockedMethod=" + r101, null);
        return;
    L11:
        r101.invoke(ResourcesManager.getInstance(), new Object[]{r100});     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi26Impl >>> redirectResourcesToNewImplLocked err.", th);
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public boolean appendSplitAsset(Collection<String> r100) {
        if (r100 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi26Impl >>> appendSplitAsset err, paths=" + r100, null);
        return false;
    L6:
        Object r101 = sLock;
        if (r101 != null) goto L9;
    L21:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi26Impl >>> appendSplitAsset err, sLock=" + r101 + ", sResourceImplsFiled=" + sResourceImplsFiled + ", sResourceImpls=" + sResourceImpls, null);
        return false;
    L9:
        if (sResourceImplsFiled == null) goto L21;
        if (sResourceImpls == null) goto L21;
        String[] r102 = getWebViewPath();
        if (r102 != null) goto L18;
        Object r103 = getProviderLock();
        if (r103 == null) goto L18;
        collectAndRedirectResourcesToNewImplWithProviderLock(r100, r103);
        return true;
    L18:
        collectAndRedirectResourcesToNewImplWithoutProviderLock(r100, r102);
        return true;
    }

    private void collectAndRedirectResourcesToNewImplWithProviderLock(Collection<String> r100, Object r101) {
        Object r102 = sLock;
        if (r102 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi26Impl >>> appendSplitAsset err, sLock=null", null);
        return;
    L6:
        monitor-enter(r101);
        monitor-enter(r102);     // Catch: Throwable -> L15
        redirectResourcesToNewImplLocked(collectUpdateResourcesKeysLocked(r100, getWebViewPath()));     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private void collectAndRedirectResourcesToNewImplWithoutProviderLock(Collection<String> r100, String[] r101) {
        Object r102 = sLock;
        if (r102 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi26Impl >>> appendSplitAsset err, sLock=null", null);
        return;
    L6:
        monitor-enter(r102);
        redirectResourcesToNewImplLocked(collectUpdateResourcesKeysLocked(r100, r101));     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private ArrayMap<ResourcesImpl, ResourcesKey> collectUpdateResourcesKeysLocked(Collection<String> r110, String[] r111) {
        ArrayMap<ResourcesImpl, ResourcesKey> r100 = new ArrayMap();
        ArrayMap<ResourcesKey, Reference<ResourcesImpl>> r101 = sResourceImpls;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L27;
        ArrayMap<ResourcesKey, Reference<ResourcesImpl>> r104 = sResourceImpls;
        ResourcesImpl r105 = r104.valueAt(r103).get();
        ResourcesKey r106 = r104.keyAt(r103);
        if (r105 == null) goto L26;
        if (Objects.equals(this.mResourcesKeyExt.getResDir(r106), this.mContext.getApplicationInfo().sourceDir) == false) goto L26;
        String[] r107 = this.mResourcesKeyExt.getLibDirs(r106);
        if (r105 != getImpl(this.mContext.getResources())) goto L21;
        if (r111 == null) goto L21;
        int r108 = r111.length;
        int r109 = 0;
    L16:
        if (r109 >= r108) goto L21;
        String r112 = r111[r109];
        if (r112 == null) goto L20;
        r107 = (String[]) ArrayUtils.appendElement(String.class, r107, r112);
    L20:
        r109 = r109 + 1;
    L21:
        String[] r113 = (String[]) r110.toArray(new String[0]);
        if (Arrays.equals(this.mResourcesKeyExt.getSplitResDirs(r106), r113) == true) goto L24;
    L25:
        r100.put(r105, buildNewResourcesKeySafe(r106, r113, r107));
        goto L26
    L24:
        if (Arrays.equals(this.mResourcesKeyExt.getLibDirs(r106), r107) == false) goto L25;
    L26:
        r103 = r103 + 1;
        goto L7
    L27:
        return r100;
    L5:
        r102 = r101.size();
        goto L6
    }

    private ResourcesKey buildNewResourcesKey(ResourcesKey r110, String[] r111, String[] r112) throws Throwable {
        if (r110 == null) goto L7;
        if (r111 == null) goto L7;
        IResourcesKeyExt r100 = this.mResourcesKeyExt;
        return r100.buildNewKey(r100.getTokenIdentify(r110), this.mResourcesKeyExt.getResDir(r110), r111, this.mResourcesKeyExt.getOverlayDirs(r110), r112, this.mResourcesKeyExt.getDisplayId(r110), this.mResourcesKeyExt.getOverrideConfiguration(r110), this.mResourcesKeyExt.getCompatInfo(r110), this.mResourcesKeyExt.getLoaders(r110));
    L7:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi26Impl >>> buildNewResourcesKey err, oldKey=" + r110 + ", newSplitDirs=" + Arrays.toString(r111), null);
        return r110;
    }

    private ResourcesKey buildNewResourcesKeySafe(ResourcesKey r100, String[] r101, String[] r102) {
        return buildNewResourcesKey(r100, r101, r102);
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi26Impl >>> buildNewResourcesKeySafe err.", th);
        return r100;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.ResourcesManagerExtImpl, com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public void init(IWebViewExt r100, IAssetManagerExt r101, IResourcesExt r102, IResourcesKeyExt r103, Context r104) {
        super.init(r100, r101, r102, r103, r104);
        this.mResourcesKeyExt = r103;
    }
}
