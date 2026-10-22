package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
class CronetWebsocketConnectionJni implements CronetWebsocketConnection.Natives {
    public static final JniStaticTestMocker<CronetWebsocketConnection.Natives> TEST_HOOKS = null;
    private static CronetWebsocketConnection.Natives testInstance;

    public CronetWebsocketConnectionJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static CronetWebsocketConnection.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetWebsocketConnection.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetWebsocketConnectionJni();
    }

    public static /* synthetic */ CronetWebsocketConnection.Natives access$002(CronetWebsocketConnection.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public long createWebsocketConnectionAdapter(CronetWebsocketConnection r100, long r101) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_createWebsocketConnectionAdapter(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void destroy(long r100, CronetWebsocketConnection r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_destroy(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void stop(long r100, CronetWebsocketConnection r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_stop(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addUrl(long r100, CronetWebsocketConnection r101, String r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addUrl(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void sendBinary(long r100, CronetWebsocketConnection r101, ByteBuffer r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendBinary(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void sendText(long r100, CronetWebsocketConnection r101, String r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_sendText(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void startWithWSChannel(long r100, CronetWebsocketConnection r101, boolean r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithWSChannel(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addGetParam(long r100, CronetWebsocketConnection r101, String r102, String r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addGetParam(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void addHeader(long r100, CronetWebsocketConnection r101, String r102, String r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_addHeader(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetWebsocketConnection.Natives
    public void startWithFrontier(long r100, CronetWebsocketConnection r101, int r102, String r103, long r104, int r105, long r106, String r110, int r111, String r112, boolean r113) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetWebsocketConnection_startWithFrontier(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113);
    }
}
