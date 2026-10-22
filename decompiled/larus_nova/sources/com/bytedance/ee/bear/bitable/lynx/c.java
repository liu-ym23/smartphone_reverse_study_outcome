package com.bytedance.ee.bear.bitable.lynx;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends io4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f214625b;

    public static final class a extends com.bytedance.ies.xbridge.model.params.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f214626c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f214627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f214628b;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.lynx.c$a$a, reason: collision with other inner class name */
        public static final class C3065a {
        }

        static {
        }

        @Override // com.bytedance.ies.xbridge.model.params.a
        public final List<String> provideParamList() {
            return CollectionsKt.listOf(new String[]{"bridgeName", "callbackId", "params"});
        }

        public a(String r100, String r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "bridgeName");
            Intrinsics.checkNotNullParameter(r101, "callbackId");
            Intrinsics.checkNotNullParameter(r102, "params");
            this.f214627a = r100;
            this.f214628b = r102;
        }
    }

    public c() {
        this.f214625b = "ccm.executeJSBridgeCallback";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f214625b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        int r103 = a.f214626c;
        Intrinsics.checkNotNullParameter(r100, "xParams");
        String r104 = s.f(r100, "bridgeName", "");
        String r105 = s.f(r100, "callbackId", "");
        XReadableMap r106 = s.e(r100, "params");
        String r107 = null;
        if (r106 == null) goto L5;
        Map<String, Object> r108 = r106.toMap();
    L7:
        if (r108 != null) goto L9;
        r108 = new LinkedHashMap();
    L9:
        a r109 = new a(r104, r105, r108);
        String r110 = r109.f214627a;
        h r111 = (h) getBridgeService(h.class);
        if (r111 == null) goto L13;
        r107 = r111.Hk();
    L13:
        if (Intrinsics.areEqual(r110, r107) == false) goto L18;
        h r112 = (h) getBridgeService(h.class);
        if (r112 == null) goto L17;
        r112.Gu(r109.f214628b);
    L17:
        XCoreBridgeMethod.onSuccess$default(this, r101, new LinkedHashMap(), null, 4, null);
        return;
    L18:
        tt5.a.d("BitableLynxToJSBridgeMethod", "bridgeName not match");
        return;
    L5:
        r108 = null;
        goto L7
    }
}
