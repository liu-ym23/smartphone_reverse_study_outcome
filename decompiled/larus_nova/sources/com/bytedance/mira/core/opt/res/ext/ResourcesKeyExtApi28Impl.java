package com.bytedance.mira.core.opt.res.ext;

import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.ResourcesKey;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class ResourcesKeyExtApi28Impl extends ResourcesKeyExtImpl {
    private static final String TAG = "ResourcesKeyExtApi28Impl";
    private static final Field sLoadersField = null;
    private static final Field sOverlayPathsField = null;
    private static final Constructor<?> sResourcesKeyCons = null;
    private static final Field sTokenIdentityField = null;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.reflect.Constructor] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.reflect.Constructor<?>] */
    static {
        if (OSUtil.isAndroidSHigher() == false) goto L5;
        sOverlayPathsField = ReflectUtils.findDeclaredField(ResourcesKey.class, "mOverlayPaths");
    L7:
        if (OSUtil.isAndroidRHigher() == false) goto L9;
        sLoadersField = ReflectUtils.findDeclaredField(ResourcesKey.class, "mLoaders");
    L11:
        if (OSUtil.isAndroidBHigher() == false) goto L13;
        sTokenIdentityField = ReflectUtils.findDeclaredField(ResourcesKey.class, "mTokenIdentity");
    L14:
        ?? r100 = 6;
    L26:
        Class[] r101 = new Class[7];
        r101[0] = String.class;
        r101[1] = String[].class;
        r101[2] = String[].class;
        r101[3] = String[].class;
        r101[4] = Integer.TYPE;
        r101[5] = Configuration.class;
        r101[r100] = CompatibilityInfo.class;
        r100 = ReflectUtils.findDeclaredConstructor(ResourcesKey.class, r101);
    L27:
        sResourcesKeyCons = r100;
        return;
    L17:
        if (sTokenIdentityField == null) goto L22;
        if (sLoadersField == null) goto L22;
        Class<?> r102 = Class.forName("[Landroid.content.res.loader.ResourcesLoader;");     // Catch: Throwable -> L26
        Class r110 = Integer.TYPE;     // Catch: Throwable -> L26
        r100 = ReflectUtils.findDeclaredConstructor(ResourcesKey.class, new Class[]{r110, String.class, String[].class, String[].class, String[].class, r110, Configuration.class, CompatibilityInfo.class, r102});     // Catch: Throwable -> L26
    L29:
    L22:
        if (sLoadersField == null) goto L24;
        r100 = ReflectUtils.findDeclaredConstructor(ResourcesKey.class, new Class[]{String.class, String[].class, String[].class, String[].class, Integer.TYPE, Configuration.class, CompatibilityInfo.class, Class.forName("[Landroid.content.res.loader.ResourcesLoader;")});     // Catch: Throwable -> L26
        goto L29
    L24:
        r100 = ReflectUtils.findDeclaredConstructor(ResourcesKey.class, new Class[]{String.class, String[].class, String[].class, String[].class, Integer.TYPE, Configuration.class, CompatibilityInfo.class});     // Catch: Throwable -> L26
        goto L29
    L13:
        sTokenIdentityField = null;
        goto L14
    L9:
        sLoadersField = null;
        goto L11
    L5:
        sOverlayPathsField = ReflectUtils.findDeclaredField(ResourcesKey.class, "mOverlayDirs");
        goto L7
    }

    public ResourcesKeyExtApi28Impl() {
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public CompatibilityInfo getCompatInfo(ResourcesKey r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.mCompatInfo;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public int getDisplayId(ResourcesKey r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.mDisplayId;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public String[] getLibDirs(ResourcesKey r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.mLibDirs;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public Object getLoaders(ResourcesKey r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Field r101 = sLoadersField;
        if (r101 != null) goto L9;
        return null;
    L9:
        return ReflectUtils.readDeclaredField(r101, r100);
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public String[] getOverlayDirs(ResourcesKey r100) {
        if (r100 == null) goto L8;
        Field r101 = sOverlayPathsField;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (String[]) ReflectUtils.readDeclaredField(r101, r100);
    L8:
        return null;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public Configuration getOverrideConfiguration(ResourcesKey r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
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
    public int getTokenIdentify(ResourcesKey r100) {
        if (r100 == null) goto L12;
        Field r101 = sTokenIdentityField;
        if (r101 == null) goto L13;
        Object r102 = ReflectUtils.readDeclaredField(r101, r100);
        if (r102 != null) goto L11;
        return 0;
    L11:
        return ((Integer) r102).intValue();
    L13:
        return 0;
    L12:
        return 0;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IResourcesKeyExt
    public ResourcesKey buildNewKey(int r110, String r111, String[] r112, String[] r113, String[] r114, int r115, Configuration r116, CompatibilityInfo r210, Object r211) {
    L14:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "ResourcesKeyExtApi28Impl >>> buildNewKey err.", th);
        return null;
    L3:
        if (sTokenIdentityField == null) goto L9;
        if (sLoadersField == null) goto L9;
        return (ResourcesKey) sResourcesKeyCons.newInstance(new Object[]{Integer.valueOf(r110), r111, r112, r113, r114, Integer.valueOf(r115), r116, r210, r211});
    L9:
        if (sLoadersField == null) goto L13;
        return (ResourcesKey) sResourcesKeyCons.newInstance(new Object[]{r111, r112, r113, r114, Integer.valueOf(r115), r116, r210, r211});
    L13:
        return (ResourcesKey) sResourcesKeyCons.newInstance(new Object[]{r111, r112, r113, r114, Integer.valueOf(r115), r116, r210});
    }
}
