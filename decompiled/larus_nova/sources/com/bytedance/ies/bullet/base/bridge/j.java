package com.bytedance.ies.bullet.base.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f246289a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f246290b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f246291c = null;

        static {
            int[] r100 = new int[IBridgeMethod.Access.values().length];
            r100[IBridgeMethod.Access.PUBLIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L42:
            r100[IBridgeMethod.Access.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L56:
            r100[IBridgeMethod.Access.PROTECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L44:
            r100[IBridgeMethod.Access.SECURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L10:
            f246289a = r100;
            int[] r101 = new int[XBridgeMethod.Access.values().length];
            r101[XBridgeMethod.Access.PUBLIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L48:
            r101[XBridgeMethod.Access.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L34:
            r101[XBridgeMethod.Access.PROTECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L46:
            r101[XBridgeMethod.Access.SECURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L15:
            f246290b = r101;
            int[] r102 = new int[IDLXBridgeMethod.Access.values().length];
            r102[IDLXBridgeMethod.Access.PUBLIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L40:
            r102[IDLXBridgeMethod.Access.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L50:
            r102[IDLXBridgeMethod.Access.PROTECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L38:
            r102[IDLXBridgeMethod.Access.SECURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L20:
            f246291c = r102;
        }
    }

    public static final com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.Access a(IBridgeMethod.Access r100) {
        Intrinsics.checkNotNullParameter(r100, "privilege");
        int r101 = a.f246289a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 == 4) goto L17;
        return null;
    L17:
        return com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.Access.SECURE;
    L18:
        return com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.Access.PROTECT;
    L19:
        return com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.Access.PRIVATE;
    L15:
        return com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod.Access.PUBLIC;
    }

    public static final XBridgePlatformType b(IBDXBridgeContext r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        if (r100.getPlatformType() != PlatformType.LYNX) goto L7;
        return XBridgePlatformType.LYNX;
    L7:
        if (r100.getPlatformType() != PlatformType.WEB) goto L11;
        return XBridgePlatformType.WEB;
    L11:
        return XBridgePlatformType.ALL;
    }
}
