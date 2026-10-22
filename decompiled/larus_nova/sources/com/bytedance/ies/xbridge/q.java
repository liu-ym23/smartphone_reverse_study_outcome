package com.bytedance.ies.xbridge;

import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f249529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<XBridgePlatformType, ConcurrentHashMap<String, Class<? extends XBridgeMethod>>> f249530b;

    public static final class a {
    }

    static {
    }

    public q() {
        this.f249529a = "DEFAULT";
        this.f249530b = new LinkedHashMap();
    }

    public final Map<String, Class<? extends XBridgeMethod>> a(XBridgePlatformType r100) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        if (r100 != XBridgePlatformType.NONE) goto L7;
        return null;
    L7:
        return (Map) ((LinkedHashMap) this.f249530b).get(r100);
    }

    public static void b(q r100, Class r101, XBridgePlatformType r102, int r110) {
        if ((r110 & 2) == 0) goto L5;
        r102 = XBridgePlatformType.ALL;
    L5:
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "scope");
        XBridgePlatformType r103 = XBridgePlatformType.ALL;
        if (r102 != r103) goto L8;
        List r104 = CollectionsKt.listOf(new XBridgePlatformType[]{r103, XBridgePlatformType.WEB, XBridgePlatformType.LYNX, XBridgePlatformType.RN});
    L9:
        Iterator r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L27;
        XBridgePlatformType r106 = (XBridgePlatformType) r105.next();
        ConcurrentHashMap<String, Class<? extends XBridgeMethod>> r107 = (ConcurrentHashMap) ((LinkedHashMap) r100.f249530b).get(r106);
        if (r107 != null) goto L15;
        r107 = new ConcurrentHashMap();
    L15:
        Map<Class<? extends XBridgeMethod>, String> r108 = r.f249531a;
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Map<Class<? extends XBridgeMethod>, String> r109 = r.f249531a;     // Catch: Exception -> L28
        String r111 = (String) ((LinkedHashMap) r109).get(r101);     // Catch: Exception -> L28
        if (r111 != null) goto L19;
        String r112 = r109.put(r101, ((XBridgeMethod) r101.newInstance()).getName());     // Catch: Exception -> L28
        r111 = (String) ((LinkedHashMap) r109).get(r101);     // Catch: Exception -> L28
        int r113 = com.bytedance.ies.xbridge.utils.i.f249562a;     // Catch: Exception -> L28
        com.bytedance.ies.xbridge.utils.i.a("Register local bridge named :" + r111);     // Catch: Exception -> L28
    L19:
        if (r111 == null) goto L20;
    L22:
        if (r111.length() <= 0) goto L24;
        boolean r114 = true;
    L25:
        if (r114 == false) goto L11;
        r107.put(r111, r101);
        r100.f249530b.put(r106, r107);
        goto L11
    L24:
        r114 = false;
    L20:
        r111 = "";
        goto L22
    L27:
        return;
    L8:
        r104 = CollectionsKt.listOf(r102);
        goto L9
    }
}
