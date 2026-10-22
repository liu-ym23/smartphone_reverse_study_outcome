package com.bytedance.mira.core.opt.res.ext;

import android.app.ResourcesManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.ResourcesImpl;
import android.content.res.ResourcesKey;
import android.util.ArrayMap;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.ArrayUtils;
import com.bytedance.mira.util.ReflectUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.Reference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes21.dex */
public class ResourcesManagerExtApi24Impl extends ResourcesManagerExtImpl {
    private static final String TAG = "ResourcesManagerExtApi24Impl";
    private static final Map<Object, Object> sActivityResourceReferences = null;
    private static final Field sActivityResourceReferencesField = null;
    private static final Field sActivityResourcesFiled = null;
    private static final Method sFindOrCreateResourcesImplForKeyLockedMethod = null;
    private static final Object sLock = null;
    private static final ArrayMap<ResourcesKey, Reference<ResourcesImpl>> sResourceImpls = null;
    private static final Field sResourceImplsFiled = null;
    private static final ArrayList<Reference<Resources>> sResourceReferences = null;
    private static final Field sResourceReferencesField = null;
    private IResourcesKeyExt mResourcesKeyExt;

    static {
        Field r100 = ReflectUtils.findDeclaredField(ResourcesManager.class, "mResourceImpls");
        sResourceImplsFiled = r100;
        Field r101 = ReflectUtils.findDeclaredField(ResourcesManager.class, "mResourceReferences");
        sResourceReferencesField = r101;
        Field r102 = ReflectUtils.findDeclaredField(ResourcesManager.class, "mActivityResourceReferences");
        sActivityResourceReferencesField = r102;
        sFindOrCreateResourcesImplForKeyLockedMethod = ReflectUtils.findDeclaredMethod(ResourcesManager.class, "findOrCreateResourcesImplForKeyLocked", new Class[]{ResourcesKey.class});
        sLock = ResourcesManager.getInstance();
        sResourceImpls = (ArrayMap) ReflectUtils.readDeclaredField(r100, ResourcesManager.getInstance());
        sResourceReferences = (ArrayList) ReflectUtils.readDeclaredField(r101, ResourcesManager.getInstance());
        sActivityResourceReferences = (Map) ReflectUtils.readDeclaredField(r102, ResourcesManager.getInstance());
        Field r103 = ReflectUtils.findDeclaredField(Class.forName("android.app.ResourcesManager$ActivityResources"), "activityResources");     // Catch: Exception -> L5
    L6:
        sActivityResourcesFiled = r103;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public ResourcesManagerExtApi24Impl() {
    }

    private List<Reference<Resources>> getActivityResourcesList(Object r100) {
        if (r100 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi24Impl >>> getActivityResources err, activityResources=" + r100, null);
        return null;
    L6:
        Field r101 = sActivityResourcesFiled;
        if (r101 != null) goto L13;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi24Impl >>> getActivityResources err, sActivityResourcesFiled=" + r101, null);
        return null;
    L13:
        return (List) r101.get(r100);
    L12:
        return null;
    }

    private void redirectResourcesToNewImplLocked(ArrayMap<ResourcesImpl, ResourcesKey> r100) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        int r101 = sResourceReferences.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L13;
        Resources r103 = (Resources) ((Reference) ListProtector.get(sResourceReferences, r102)).get();
        if (r103 == null) goto L12;
        ResourcesKey r104 = r100.get(getImpl(r103));
        if (r104 == null) goto L12;
        setImpl(r103, findOrCreateResourcesImplForKeyLocked(ResourcesManager.getInstance(), r104));
    L12:
        r102 = r102 + 1;
        goto L6
    L13:
        Iterator<Object> r105 = sActivityResourceReferences.values().iterator();
    L15:
        if (r105.hasNext() == false) goto L28;
        List<Reference<Resources>> r106 = getActivityResourcesList(r105.next());
        if (r106 != null) goto L19;
        int r107 = 0;
    L20:
        int r108 = 0;
    L21:
        if (r108 >= r107) goto L15;
        Resources r109 = (Resources) ((Reference) ListProtector.get(r106, r108)).get();
        if (r109 == null) goto L27;
        ResourcesKey r110 = r100.get(getImpl(r109));
        if (r110 == null) goto L27;
        setImpl(r109, findOrCreateResourcesImplForKeyLocked(ResourcesManager.getInstance(), r110));
    L27:
        r108 = r108 + 1;
        goto L21
    L19:
        r107 = r106.size();
        goto L20
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public boolean appendSplitAsset(Collection<String> r100) {
        if (r100 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi24Impl >>> appendSplitAsset err, paths=" + r100, null);
        return false;
    L6:
        Object r101 = sLock;
        if (r101 != null) goto L9;
    L29:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi24Impl >>> appendSplitAsset err, sLock=" + r101 + ", sResourceImplsFiled=" + sResourceImplsFiled + ", sResourceImpls=" + sResourceImpls + ", sResourceReferencesField=" + sResourceReferencesField + ", sResourceReferences=" + sResourceReferences + ", sActivityResourceReferencesField=" + sActivityResourceReferencesField + ", sActivityResourceReferences=" + sActivityResourceReferences, null);
        return false;
    L9:
        if (sResourceImplsFiled == null) goto L29;
        if (sResourceImpls == null) goto L29;
        if (sResourceReferencesField == null) goto L29;
        if (sResourceReferences == null) goto L29;
        if (sActivityResourceReferencesField == null) goto L29;
        if (sActivityResourceReferences == null) goto L29;
        String[] r102 = getWebViewPath();
        if (r102 != null) goto L26;
        Object r103 = getProviderLock();
        if (r103 == null) goto L26;
        collectAndRedirectResourcesToNewImplWithProviderLock(r100, r103);
        return true;
    L26:
        collectAndRedirectResourcesToNewImplWithoutProviderLock(r100, r102);
        return true;
    }

    private void collectAndRedirectResourcesToNewImplWithProviderLock(Collection<String> r100, Object r101) {
        Object r102 = sLock;
        if (r102 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi24Impl >>> appendSplitAsset err, sLock=null", null);
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
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi24Impl >>> appendSplitAsset err, sLock=null", null);
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

    private ArrayMap<ResourcesImpl, ResourcesKey> collectUpdateResourcesKeysLocked(Collection<String> r210, String[] r211) {
        ArrayMap<ResourcesImpl, ResourcesKey> r100 = new ArrayMap();
        int r101 = sResourceImpls.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L24;
        ArrayMap<ResourcesKey, Reference<ResourcesImpl>> r103 = sResourceImpls;
        ResourcesImpl r104 = r103.valueAt(r102).get();
        ResourcesKey r105 = r103.keyAt(r102);
        if (r104 == null) goto L23;
        if (Objects.equals(this.mResourcesKeyExt.getResDir(r105), this.mContext.getApplicationInfo().sourceDir) == false) goto L23;
        String[] r106 = this.mResourcesKeyExt.getLibDirs(r105);
        if (r104 != getImpl(this.mContext.getResources())) goto L17;
        if (r211 == null) goto L17;
        int r107 = r211.length;
        int r110 = 0;
    L12:
        if (r110 >= r107) goto L17;
        String r111 = r211[r110];
        if (r111 == null) goto L16;
        r106 = (String[]) ArrayUtils.appendElement(String.class, r106, r111);
    L16:
        r110 = r110 + 1;
    L17:
        String[] r112 = (String[]) r210.toArray(new String[0]);
        if (Arrays.equals(this.mResourcesKeyExt.getSplitResDirs(r105), r112) == true) goto L20;
    L21:
        IResourcesKeyExt r113 = this.mResourcesKeyExt;
        String[] r114 = r106;
        r100.put(r104, r113.buildNewKey(r113.getTokenIdentify(r105), this.mResourcesKeyExt.getResDir(r105), r112, this.mResourcesKeyExt.getOverlayDirs(r105), r114, this.mResourcesKeyExt.getDisplayId(r105), this.mResourcesKeyExt.getOverrideConfiguration(r105), this.mResourcesKeyExt.getCompatInfo(r105), null));
        goto L23
    L20:
        if (Arrays.equals(this.mResourcesKeyExt.getLibDirs(r105), r106) == false) goto L21;
    L23:
        r102 = r102 + 1;
        goto L3
    L24:
        return r100;
    }

    private ResourcesImpl findOrCreateResourcesImplForKeyLocked(ResourcesManager r100, ResourcesKey r101) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        Method r102 = sFindOrCreateResourcesImplForKeyLockedMethod;
        if (r102 != null) goto L18;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi24Impl >>> findOrCreateResourcesImplForKeyLocked err, sFindOrCreateResourcesImplForKeyLockedMethod=" + r102, null);
        return null;
    L18:
        return (ResourcesImpl) r102.invoke(r100, new Object[]{r101});
    L13:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi24Impl >>> findOrCreateResourcesImplForKeyLocked err.", th);
        return null;
    L16:
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesManagerExtApi24Impl >>> findOrCreateResourcesImplForKeyLocked err, manager=" + r100 + ", key=" + r101, null);
        return null;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.ResourcesManagerExtImpl, com.bytedance.mira.core.opt.res.ext.IResourcesManagerExt
    public void init(IWebViewExt r100, IAssetManagerExt r101, IResourcesExt r102, IResourcesKeyExt r103, Context r104) {
        super.init(r100, r101, r102, r103, r104);
        this.mResourcesKeyExt = r103;
    }
}
