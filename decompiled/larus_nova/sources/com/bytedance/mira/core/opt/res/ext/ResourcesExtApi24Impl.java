package com.bytedance.mira.core.opt.res.ext;

import android.app.ResourcesManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.ResourcesImpl;
import android.content.res.ResourcesKey;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.ArrayUtils;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ResourcesExtApi24Impl extends ResourcesExtImpl {
    private static final String TAG = "ResourcesExtApi24Impl";
    private static final Method sFindKeyForResourceImplLockedMethod = null;
    private static final Method sFindOrCreateResourcesImplForKeyLockedMethod = null;
    private static final Method sFindOrCreateResourcesImplForKeyLockedMethodCompat = null;
    private static final Method sGetImplMethod = null;
    private static final Object sLock = null;
    private static final Method sSetImplMethod = null;
    private final WeakHashMap<Context, ResourcesKey> mOldResourcesKeyCaches;
    private String mPackageName;
    private IResourcesKeyExt mResourcesKeyExt;

    static {
        sFindKeyForResourceImplLockedMethod = ReflectUtils.findDeclaredMethod(ResourcesManager.class, "findKeyForResourceImplLocked", new Class[]{ResourcesImpl.class});
        if (OSUtil.isAndroidSHigher() == false) goto L5;
        sLock = ReflectUtils.readDeclaredField(ReflectUtils.findDeclaredField(ResourcesManager.class, "mLock"), ResourcesManager.getInstance());
    L6:
        sGetImplMethod = ReflectUtils.findDeclaredMethod(Resources.class, "getImpl", new Class[0]);
        sSetImplMethod = ReflectUtils.findDeclaredMethod(Resources.class, "setImpl", new Class[]{ResourcesImpl.class});
        Method r100 = ReflectUtils.findDeclaredMethod(ResourcesManager.class, "findOrCreateResourcesImplForKeyLocked", new Class[]{ResourcesKey.class});
        sFindOrCreateResourcesImplForKeyLockedMethod = r100;
        if (r100 != null) goto L9;
        sFindOrCreateResourcesImplForKeyLockedMethodCompat = ReflectUtils.findDeclaredMethod(ResourcesManager.class, "findOrCreateResourcesImplForKeyLocked", new Class[]{String.class, ResourcesKey.class});
        return;
    L9:
        sFindOrCreateResourcesImplForKeyLockedMethodCompat = null;
        return;
    L5:
        sLock = ResourcesManager.getInstance();
        goto L6
    }

    public ResourcesExtApi24Impl() {
        this.mOldResourcesKeyCaches = new WeakHashMap();
    }

    private ResourcesKey findKeyForResourceImplLocked(ResourcesImpl r100) {
        if (r100 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> findKeyForResourceImplLocked err, impl=" + r100, null);
        return null;
    L6:
        Method r101 = sFindKeyForResourceImplLockedMethod;
        if (r101 != null) goto L15;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> findKeyForResourceImplLocked err, sFindKeyForResourceImplLockedMethod=null", null);
        return null;
    L15:
        return (ResourcesKey) r101.invoke(ResourcesManager.getInstance(), new Object[]{r100});
    L12:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> findKeyForResourceImplLocked err.", th);
        return null;
    }

    private ResourcesImpl findOrCreateResourcesImplForKeyLocked(ResourcesKey r100) {
        if (r100 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> findOrCreateResourcesImplForKeyLocked err, key=" + r100, null);
        return null;
    L6:
        Method r101 = sFindOrCreateResourcesImplForKeyLockedMethod;
        if (r101 != null) goto L23;
        Method r102 = sFindOrCreateResourcesImplForKeyLockedMethodCompat;
        if (r102 != null) goto L23;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> findOrCreateResourcesImplForKeyLocked err, sFindOrCreateResourcesImplForKeyLockedMethod=" + r101 + "sFindOrCreateResourcesImplForKeyLockedMethodCompat=" + r102, null);
        return null;
    L23:
        Method r103 = sFindOrCreateResourcesImplForKeyLockedMethodCompat;     // Catch: Throwable -> L20
        if (r103 == null) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L19;
        return (ResourcesImpl) r103.invoke(ResourcesManager.getInstance(), new Object[]{this.mPackageName, r100});
    L19:
        return (ResourcesImpl) r101.invoke(ResourcesManager.getInstance(), new Object[]{r100});
    L15:
        r104 = false;
    L20:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> findOrCreateResourcesImplForKeyLocked err.", th);
        return null;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public ResourcesImpl getImpl(Resources r100) {
        if (r100 == null) goto L13;
        Method r101 = sGetImplMethod;
        if (r101 == null) goto L13;
        return (ResourcesImpl) r101.invoke(r100, new Object[0]);
    L10:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Implres=" + r100 + ", getImpl err!", th);
        return null;
    L13:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> getImpl err, resources=" + r100 + ", sGetImplMethod=" + sGetImplMethod, null);
        return null;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public boolean setImpl(Resources r100, ResourcesImpl r101) {
        if (r100 == null) goto L13;
        Method r102 = sSetImplMethod;
        if (r102 == null) goto L13;
        r102.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Implres=" + r100 + ", setImpl err!", th);
        return false;
    L13:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> setImpl err, resources=" + r100 + ", sSetImplMethod=" + sSetImplMethod, null);
        return false;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public boolean addAssetPaths(Context r110, Resources r111, Collection<String> r112, boolean r113) {
        if (r111 == null) goto L13;
        if (r112 == null) goto L13;
        String[] r100 = getWebViewPath();
        if (r100 != null) goto L12;
        Object r101 = getProviderLock();
        if (r101 == null) goto L12;
        return addAssetPathsWithProviderLock(r110, r111, r112, r101, r113);
    L12:
        return addAssetPathsWithoutProviderLock(r110, r111, r112, r100, r113);
    L13:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err, resources=" + r111 + ", paths=" + r112, null);
        return false;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.ResourcesExtImpl, com.bytedance.mira.core.opt.res.ext.IResourcesExt
    public void init(IWebViewExt r100, IAssetManagerExt r101, IResourcesKeyExt r102, Context r103) {
        super.init(r100, r101, r102, r103);
        this.mPackageName = r103.getPackageName();
        this.mResourcesKeyExt = r102;
    }

    private boolean addAssetPathsWithProviderLock(Context r110, Resources r111, Collection<String> r112, Object r113, boolean r114) {
        Object r100 = sLock;
        if (r100 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v2, sLock=null", null);
        return false;
    L6:
        monitor-enter(r113);
        monitor-enter(r100);     // Catch: Throwable -> L55
        ResourcesImpl r101 = getImpl(r111);     // Catch: Throwable -> L52
        if (r101 != null) goto L14;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v3, oldImpl=null", null);     // Catch: Throwable -> L52
        monitor-exit(r100);     // Catch: Throwable -> L52
        monitor-exit(r113);     // Catch: Throwable -> L55
        return false;
    L14:
        ResourcesKey r102 = findKeyForResourceImplLocked(r101);     // Catch: Throwable -> L52
        if (r102 == null) goto L20;
        if (r114 == false) goto L20;
        monitor-exit(r100);     // Catch: Throwable -> L52
        monitor-exit(r113);     // Catch: Throwable -> L55
        return true;
    L20:
        if (r102 != null) goto L25;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v4.1, oldKey=null", null);     // Catch: Throwable -> L52
        if (r114 == false) goto L24;
        r102 = this.mOldResourcesKeyCaches.get(r110);     // Catch: Throwable -> L52
    L24:
        Configuration r103 = r111.getConfiguration();     // Catch: Throwable -> L52
    L26:
        ResourcesKey r115 = r102;
        if (r115 != null) goto L32;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v4.2, oldKey=null", null);     // Catch: Throwable -> L52
        monitor-exit(r100);     // Catch: Throwable -> L52
        monitor-exit(r113);     // Catch: Throwable -> L55
        return false;
    L32:
        this.mOldResourcesKeyCaches.put(r110, r115);     // Catch: Throwable -> L52
        String[] r104 = (String[]) r112.toArray(new String[0]);     // Catch: Throwable -> L52
        if (r111 != this.mContext.getResources()) goto L35;
        boolean r105 = true;
    L36:
        ResourcesKey r116 = buildNewResourcesKeySafe(r115, r104, r105, getWebViewPath(), r103);     // Catch: Throwable -> L52
        if (r116 != null) goto L42;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v5, newKey=null", null);     // Catch: Throwable -> L52
        monitor-exit(r100);     // Catch: Throwable -> L52
        monitor-exit(r113);     // Catch: Throwable -> L55
        return false;
    L42:
        ResourcesImpl r117 = findOrCreateResourcesImplForKeyLocked(r116);     // Catch: Throwable -> L52
        if (r117 != null) goto L48;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v6, newImpl=null", null);     // Catch: Throwable -> L52
        monitor-exit(r100);     // Catch: Throwable -> L52
        monitor-exit(r113);     // Catch: Throwable -> L55
        return false;
    L48:
        boolean r118 = setImpl(r111, r117);     // Catch: Throwable -> L52
        monitor-exit(r100);     // Catch: Throwable -> L52
        monitor-exit(r113);     // Catch: Throwable -> L55
        return r118;
    L35:
        r105 = false;
        goto L36
    L25:
        r103 = null;
    L52:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        throw th;
    }

    private boolean addAssetPathsWithoutProviderLock(Context r110, Resources r111, Collection<String> r112, String[] r113, boolean r114) {
        Object r100 = sLock;
        if (r100 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v2, sLock=null", null);
        return false;
    L6:
        monitor-enter(r100);
        ResourcesImpl r101 = getImpl(r111);     // Catch: Throwable -> L45
        if (r101 != null) goto L12;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v3, oldImpl=null", null);     // Catch: Throwable -> L45
        monitor-exit(r100);     // Catch: Throwable -> L45
        return false;
    L12:
        ResourcesKey r102 = findKeyForResourceImplLocked(r101);     // Catch: Throwable -> L45
        if (r102 == null) goto L17;
        if (r114 == false) goto L17;
        monitor-exit(r100);     // Catch: Throwable -> L45
        return true;
    L17:
        if (r102 != null) goto L22;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v4.1, oldKey=null", null);     // Catch: Throwable -> L45
        if (r114 == false) goto L21;
        r102 = this.mOldResourcesKeyCaches.get(r110);     // Catch: Throwable -> L45
    L21:
        Configuration r103 = r111.getConfiguration();     // Catch: Throwable -> L45
    L23:
        ResourcesKey r115 = r102;
        if (r115 != null) goto L28;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v4.2, oldKey=null", null);     // Catch: Throwable -> L45
        monitor-exit(r100);     // Catch: Throwable -> L45
        return false;
    L28:
        this.mOldResourcesKeyCaches.put(r110, r115);     // Catch: Throwable -> L45
        String[] r104 = (String[]) r112.toArray(new String[0]);     // Catch: Throwable -> L45
        if (r111 != this.mContext.getResources()) goto L31;
        boolean r105 = true;
    L32:
        ResourcesKey r116 = buildNewResourcesKeySafe(r115, r104, r105, r113, r103);     // Catch: Throwable -> L45
        if (r116 != null) goto L37;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v5, newKey=null", null);     // Catch: Throwable -> L45
        monitor-exit(r100);     // Catch: Throwable -> L45
        return false;
    L37:
        ResourcesImpl r117 = findOrCreateResourcesImplForKeyLocked(r116);     // Catch: Throwable -> L45
        if (r117 != null) goto L42;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> addAssetPaths err v6, newImpl=null", null);     // Catch: Throwable -> L45
        monitor-exit(r100);     // Catch: Throwable -> L45
        return false;
    L42:
        boolean r118 = setImpl(r111, r117);     // Catch: Throwable -> L45
        monitor-exit(r100);     // Catch: Throwable -> L45
        return r118;
    L31:
        r105 = false;
        goto L32
    L22:
        r103 = null;
    L45:
        th = move-exception;
        throw th;
    }

    private ResourcesKey buildNewResourcesKey(ResourcesKey r110, String[] r111, boolean r112, String[] r113, Configuration r114) throws Throwable {
        if (r110 == null) goto L22;
        if (r111 == null) goto L22;
        String[] r100 = this.mResourcesKeyExt.getLibDirs(r110);
        if (r112 == false) goto L15;
        if (r113 == null) goto L15;
        int r101 = r113.length;
        int r102 = 0;
    L10:
        if (r102 >= r101) goto L15;
        String r103 = r113[r102];
        if (r103 == null) goto L14;
        r100 = (String[]) ArrayUtils.appendElement(String.class, r100, r103);
    L14:
        r102 = r102 + 1;
    L15:
        String[] r104 = r100;
        Configuration r105 = this.mResourcesKeyExt.getOverrideConfiguration(r110);
        if (r114 == null) goto L19;
        if (r105 == null) goto L19;
        Configuration r106 = r114;
    L20:
        IResourcesKeyExt r107 = this.mResourcesKeyExt;
        return r107.buildNewKey(r107.getTokenIdentify(r110), this.mResourcesKeyExt.getResDir(r110), r111, this.mResourcesKeyExt.getOverlayDirs(r110), r104, this.mResourcesKeyExt.getDisplayId(r110), r106, this.mResourcesKeyExt.getCompatInfo(r110), this.mResourcesKeyExt.getLoaders(r110));
    L19:
        r106 = r105;
    L22:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> buildNewResourcesKey err, oldKey=" + r110 + ", newSplitDirs=" + Arrays.toString(r111), null);
        return r110;
    }

    private ResourcesKey buildNewResourcesKeySafe(ResourcesKey r100, String[] r101, boolean r102, String[] r103, Configuration r104) {
        return buildNewResourcesKey(r100, r101, r102, r103, r104);
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesExtApi24Impl >>> buildNewResourcesKeySafe err.", th);
        return r100;
    }
}
