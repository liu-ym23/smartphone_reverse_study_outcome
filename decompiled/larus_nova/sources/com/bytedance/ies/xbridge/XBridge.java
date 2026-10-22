package com.bytedance.ies.xbridge;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xbridge.utils.ThreadPool;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010'J,\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007J,\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007J0\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0007\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007J'\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u000f*\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0017J.\u0010\u0019\u001a\u00020\u00152\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007J.\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0004J.\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0004J.\u0010\u001c\u001a\u00020\u00152\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007R\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u0004\u0012\u00020\u000e0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006("}, d2 = {"Lcom/bytedance/ies/xbridge/XBridge;", "", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", Keys.API_PARAM_KEY_PLATFORM_TYPE, "", "name", "namespace", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "findMethodClass", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;", "findIDLMethodClass", "", "getIDLMethodList", "Lcom/bytedance/ies/xbridge/o;", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "getPlatform", "(Ljava/lang/Class;)Lcom/bytedance/ies/xbridge/o;", "Lcom/bytedance/ies/xbridge/q;", "registry", "", "registerRegistry", "Lcom/bytedance/ies/xbridge/g;", "scope", "registerMethod", "getMethodList", "getStandardMethodList", "registerIDLMethod", "DEFAULT_NAMESPACE", "Ljava/lang/String;", "", "platformMap", "Ljava/util/Map;", "Ljava/util/concurrent/ConcurrentHashMap;", "registryMap", "Ljava/util/concurrent/ConcurrentHashMap;", "idlRegistryMap", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class XBridge {
    public static final String DEFAULT_NAMESPACE = "DEFAULT";
    public static final XBridge INSTANCE = null;
    private static final ConcurrentHashMap<String, g> idlRegistryMap = null;
    private static final Map<Class<o>, o> platformMap = null;
    private static final ConcurrentHashMap<String, q> registryMap = null;

    private XBridge() {
    }

    @JvmStatic
    public static final Class<? extends IDLXBridgeMethod> findIDLMethodClass(XBridgePlatformType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        Intrinsics.checkNotNullParameter(r101, "name");
        return findIDLMethodClass$default(r100, r101, null, 4, null);
    }

    @JvmStatic
    public static final Class<? extends XBridgeMethod> findMethodClass(XBridgePlatformType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        Intrinsics.checkNotNullParameter(r101, "name");
        return findMethodClass$default(r100, r101, null, 4, null);
    }

    @JvmStatic
    public static final Map<String, Class<? extends IDLXBridgeMethod>> getIDLMethodList(XBridgePlatformType r100) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        return getIDLMethodList$default(r100, null, 2, null);
    }

    public final void registerIDLMethod(Class<? extends IDLXBridgeMethod> r100) {
        registerIDLMethod$default(this, r100, null, null, 6, null);
    }

    public final void registerIDLMethod(Class<? extends IDLXBridgeMethod> r100, XBridgePlatformType r101) {
        Intrinsics.checkNotNullParameter(r101, "scope");
        registerIDLMethod$default(this, r100, r101, null, 4, null);
    }

    public final void registerMethod(Class<? extends XBridgeMethod> r100) {
        registerMethod$default(this, r100, null, null, 6, null);
    }

    public final void registerMethod(Class<? extends XBridgeMethod> r100, XBridgePlatformType r101) {
        Intrinsics.checkNotNullParameter(r101, "scope");
        registerMethod$default(this, r100, r101, null, 4, null);
    }

    static {
        INSTANCE = new XBridge();
        platformMap = new LinkedHashMap();
        registryMap = new ConcurrentHashMap();
        idlRegistryMap = new ConcurrentHashMap();
    }

    public final <T extends o> T getPlatform(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Map<Class<o>, o> r101 = platformMap;
        T r102 = (T) r101.get(r100);
        if (r102 != null) goto L11;
        T r103 = r100.newInstance();     // Catch: Exception -> L7
        r101.put(r100, r103);     // Catch: Exception -> L7
        return r103;
    L8:
        return null;
    L11:
        return r102;
    }

    public final void registerRegistry(g r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        ConcurrentHashMap<String, g> r101 = idlRegistryMap;
        if (r101.get(r100.f249497a) != null) goto L6;
        r101.put(r100.f249497a, r100);
        return;
    }

    public final void registerRegistry(q r100) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        ConcurrentHashMap<String, q> r101 = registryMap;
        if (r101.get(r100.f249529a) != null) goto L6;
        r101.put(r100.f249529a, r100);
        return;
    }

    @JvmStatic
    public static final Map<String, Class<? extends IDLXBridgeMethod>> getIDLMethodList(XBridgePlatformType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        Intrinsics.checkNotNullParameter(r101, "namespace");
        ConcurrentHashMap<String, g> r102 = idlRegistryMap;
        if (r102.get(r101) != null) goto L5;
        return null;
    L5:
        g r103 = r102.get(r101);
        if (r103 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        if (r100 != XBridgePlatformType.NONE) goto L11;
        return null;
    L11:
        return (Map) ((LinkedHashMap) r103.f249498b).get(r100);
    L12:
        return null;
    }

    public final Map<String, Class<? extends XBridgeMethod>> getMethodList(XBridgePlatformType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        Intrinsics.checkNotNullParameter(r101, "namespace");
        ConcurrentHashMap<String, q> r102 = registryMap;
        if (r102.get(r101) != null) goto L5;
        return null;
    L5:
        q r103 = r102.get(r101);
        if (r103 != null) goto L8;
        return null;
    L8:
        return r103.a(r100);
    }

    public final Map<String, Class<? extends XBridgeMethod>> getStandardMethodList(XBridgePlatformType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        Intrinsics.checkNotNullParameter(r101, "namespace");
        ConcurrentHashMap<String, q> r102 = registryMap;
        LinkedHashMap r103 = null;
        if (r102.get(r101) != null) goto L5;
        return null;
    L5:
        q r104 = r102.get(r101);
        if (r104 == null) goto L15;
        Map<String, Class<? extends XBridgeMethod>> r105 = r104.a(r100);
        if (r105 == null) goto L15;
        r103 = new LinkedHashMap();
        Iterator<Map.Entry<String, Class<? extends XBridgeMethod>>> r106 = r105.entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L15;
        Map.Entry<String, Class<? extends XBridgeMethod>> r107 = r106.next();
        Set<String> r108 = m.f249505a;
        if (m.f249505a.contains(r107.getKey()) == false) goto L11;
        r103.put(r107.getKey(), r107.getValue());
    L15:
        return r103;
    }

    @JvmStatic
    public static final Class<? extends IDLXBridgeMethod> findIDLMethodClass(XBridgePlatformType r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "namespace");
        ConcurrentHashMap<String, g> r103 = idlRegistryMap;
        if (r103.get(r102) != null) goto L5;
        return null;
    L5:
        g r104 = r103.get(r102);
        if (r104 == null) goto L14;
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100 == XBridgePlatformType.NONE) goto L16;
        ConcurrentHashMap r105 = (ConcurrentHashMap) ((LinkedHashMap) r104.f249498b).get(r100);
        if (r105 != null) goto L13;
        return null;
    L13:
        return (Class) r105.get(r101);
    L16:
        return null;
    L14:
        return null;
    }

    @JvmStatic
    public static final Class<? extends XBridgeMethod> findMethodClass(XBridgePlatformType r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "namespace");
        ConcurrentHashMap<String, q> r103 = registryMap;
        if (r103.get(r102) != null) goto L5;
        return null;
    L5:
        q r104 = r103.get(r102);
        if (r104 == null) goto L14;
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100 == XBridgePlatformType.NONE) goto L16;
        ConcurrentHashMap r105 = (ConcurrentHashMap) ((LinkedHashMap) r104.f249530b).get(r100);
        if (r105 != null) goto L13;
        return null;
    L13:
        return (Class) r105.get(r101);
    L16:
        return null;
    L14:
        return null;
    }

    public final void registerIDLMethod(Class<? extends IDLXBridgeMethod> r100, XBridgePlatformType r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "scope");
        Intrinsics.checkNotNullParameter(r111, "namespace");
        if (r100 == null) goto L31;
        ConcurrentHashMap<String, g> r101 = idlRegistryMap;
        if (r101.get(r111) != null) goto L7;
        r101.put(r111, new g());
    L7:
        g r112 = r101.get(r111);
        if (r112 == null) goto L40;
        int r102 = g.f249496c;
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r110, "scope");
        XBridgePlatformType r103 = XBridgePlatformType.ALL;
        if (r110 != r103) goto L12;
        List r113 = CollectionsKt.listOf(new XBridgePlatformType[]{r103, XBridgePlatformType.WEB, XBridgePlatformType.LYNX, XBridgePlatformType.RN});
    L13:
        Iterator r114 = r113.iterator();
    L15:
        if (r114.hasNext() == false) goto L41;
        XBridgePlatformType r104 = (XBridgePlatformType) r114.next();
        ConcurrentHashMap<String, Class<? extends IDLXBridgeMethod>> r105 = (ConcurrentHashMap) ((LinkedHashMap) r112.f249498b).get(r104);
        if (r105 != null) goto L19;
        r105 = new ConcurrentHashMap();
    L19:
        Map<Class<? extends IDLXBridgeMethod>, String> r106 = i.f249500a;
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Map<Class<? extends IDLXBridgeMethod>, String> r107 = i.f249500a;     // Catch: Throwable -> L32
        String r108 = (String) ((LinkedHashMap) r107).get(r100);     // Catch: Throwable -> L32
        if (r108 != null) goto L23;
        ThreadPool.a(new h(r100));     // Catch: Throwable -> L32
        String r109 = r107.put(r100, r100.newInstance().getName());     // Catch: Throwable -> L32
        r108 = (String) ((LinkedHashMap) r107).get(r100);     // Catch: Throwable -> L32
        int r115 = com.bytedance.ies.xbridge.utils.i.f249562a;     // Catch: Throwable -> L32
        com.bytedance.ies.xbridge.utils.i.a("Register local idl_bridge named :" + r108);     // Catch: Throwable -> L32
    L23:
        if (r108 == null) goto L24;
    L26:
        if (r108.length() <= 0) goto L28;
        boolean r116 = true;
    L29:
        if (r116 == false) goto L15;
        r105.put(r108, r100);
        r112.f249498b.put(r104, r105);
        goto L15
    L28:
        r116 = false;
    L24:
        r108 = "";
        goto L26
    L41:
        return;
    L12:
        r113 = CollectionsKt.listOf(r110);
        goto L13
    L40:
        return;
    }

    public final void registerMethod(Class<? extends XBridgeMethod> r100, XBridgePlatformType r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "namespace");
        if (r100 == null) goto L11;
        ConcurrentHashMap<String, q> r103 = registryMap;
        if (r103.get(r102) != null) goto L7;
        r103.put(r102, new q());
    L7:
        q r104 = r103.get(r102);
        if (r104 == null) goto L12;
        q.b(r104, r100, r101, 4);
        return;
    L12:
        return;
    }

    public static /* synthetic */ Map getIDLMethodList$default(XBridgePlatformType r100, String r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = "DEFAULT";
    L6:
        return getIDLMethodList(r100, r101);
    }

    public static /* synthetic */ Class findIDLMethodClass$default(XBridgePlatformType r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = "DEFAULT";
    L6:
        return findIDLMethodClass(r100, r101, r102);
    }

    public static /* synthetic */ Class findMethodClass$default(XBridgePlatformType r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = "DEFAULT";
    L6:
        return findMethodClass(r100, r101, r102);
    }

    public static /* synthetic */ Map getMethodList$default(XBridge r100, XBridgePlatformType r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = "DEFAULT";
    L6:
        return r100.getMethodList(r101, r102);
    }

    public static /* synthetic */ Map getStandardMethodList$default(XBridge r100, XBridgePlatformType r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = "DEFAULT";
    L6:
        return r100.getStandardMethodList(r101, r102);
    }

    public static /* synthetic */ void registerIDLMethod$default(XBridge r100, Class r101, XBridgePlatformType r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = XBridgePlatformType.ALL;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = "DEFAULT";
    L8:
        r100.registerIDLMethod(r101, r102, r103);
    }

    public static /* synthetic */ void registerMethod$default(XBridge r100, Class r101, XBridgePlatformType r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = XBridgePlatformType.ALL;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = "DEFAULT";
    L8:
        r100.registerMethod(r101, r102, r103);
    }
}
