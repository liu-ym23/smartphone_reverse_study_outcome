package com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge;

import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends MethodFinder {

    public static class a implements IDLXBridgeMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final XBridgeMethod f202629a;

        /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C2935a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f202630a = null;

            static {
                int[] r100 = new int[XBridgeMethod.Access.values().length];
                r100[XBridgeMethod.Access.PUBLIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[XBridgeMethod.Access.PRIVATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[XBridgeMethod.Access.PROTECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[XBridgeMethod.Access.SECURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f202630a = r100;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.bridge.b$a$b, reason: collision with other inner class name */
        public static final class C2936b implements XBridgeMethod.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IDLXBridgeMethod.a f202631a;

            public C2936b(IDLXBridgeMethod.a r100) {
                this.f202631a = r100;
            }

            @Override // com.bytedance.ies.xbridge.XBridgeMethod.Callback
            public final void invoke(Map<String, Object> r100) {
                Intrinsics.checkNotNullParameter(r100, "data");
                this.f202631a.invoke(r100);
            }
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final boolean canRunInBackground() {
            XBridgeMethod r100 = this.f202629a;
            if ((r100 instanceof XCoreBridgeMethod) == true) goto L5;
            return false;
        L5:
            return ((XCoreBridgeMethod) r100).canRunInBackground();
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final IDLXBridgeMethod.Access getAccess() {
            XBridgeMethod.Access r100 = this.f202629a.getAccess();
            int r101 = C2935a.f202630a[r100.ordinal()];
            if (r101 != 1) goto L5;
            IDLXBridgeMethod.Access r102 = IDLXBridgeMethod.Access.PUBLIC;
        L15:
            if (r102 == null) goto L17;
            return r102;
        L17:
            return IDLXBridgeMethod.Access.PRIVATE;
        L5:
            if (r101 != 2) goto L7;
            r102 = IDLXBridgeMethod.Access.PRIVATE;
            goto L15
        L7:
            if (r101 != 3) goto L9;
            r102 = IDLXBridgeMethod.Access.PROTECT;
            goto L15
        L9:
            if (r101 == 4) goto L11;
            r102 = null;
            goto L15
        L11:
            r102 = IDLXBridgeMethod.Access.SECURE;
            goto L15
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final String getName() {
            return this.f202629a.getName();
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final IDLXBridgeMethod.Compatibility getCompatibility() {
            return IDLXBridgeMethod.Compatibility.Compatible;
        }

        public a(XBridgeMethod r100) {
            Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
            this.f202629a = r100;
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
        public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
            Intrinsics.checkNotNullParameter(r100, "bridgeContext");
            Intrinsics.checkNotNullParameter(r101, "params");
            Intrinsics.checkNotNullParameter(r102, "callback");
            C2936b r103 = new C2936b(r102);     // Catch: Throwable -> L5
            XBridgeMethod r104 = this.f202629a;     // Catch: Throwable -> L5
            int r105 = com.bytedance.ies.xbridge.platform.web.a.f249528a;     // Catch: Throwable -> L5
            Intrinsics.checkNotNullParameter(r101, "map");     // Catch: Throwable -> L5
            r104.handle(new o66.d(com.bytedance.ies.xbridge.platform.web.a.d(r101)), r103, XBridgePlatformType.ALL);     // Catch: Throwable -> L5
            return;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "xbridge";
    }

    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Class<?> r101 = c(r100);     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        return null;
    L6:
        Method r102 = r101.getDeclaredMethod("create", new Class[0]);     // Catch: Throwable -> L8
        r102.setAccessible(true);     // Catch: Throwable -> L8
        Object r103 = r102.invoke(null, new Object[0]);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ies.xbridge.XBridgeMethod");     // Catch: Throwable -> L8
        return new c((XBridgeMethod) r103);
    L8:
        th = move-exception;
        ve4.a.f554342a.getClass();
        ALogService r104 = (ALogService) ve4.a.a(ALogService.class);
        if (r104 == null) goto L12;
        r104.e("XBridgeFinder", "### Load method by reflect failed, method name: " + r100 + ", error_info: " + th.getMessage() + Typography.quote);
    L12:
        return null;
    }
}
