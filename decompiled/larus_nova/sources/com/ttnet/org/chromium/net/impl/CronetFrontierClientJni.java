package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes41.dex */
class CronetFrontierClientJni implements CronetFrontierClient.Natives {
    public static final JniStaticTestMocker<CronetFrontierClient.Natives> TEST_HOOKS = null;
    private static CronetFrontierClient.Natives testInstance;

    public CronetFrontierClientJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static CronetFrontierClient.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetFrontierClient.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetFrontierClientJni();
    }

    public static /* synthetic */ CronetFrontierClient.Natives access$002(CronetFrontierClient.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public long createFrontierClientAdapter(CronetFrontierClient r100) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_createFrontierClientAdapter(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void destroy(long r100, CronetFrontierClient r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_destroy(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void addServiceId(long r100, CronetFrontierClient r101, int r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_addServiceId(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public boolean isServiceReady(long r100, CronetFrontierClient r101, int r102) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_isServiceReady(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void reportAppStateChange(long r100, CronetFrontierClient r101, boolean r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_reportAppStateChange(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void unregisterService(long r100, CronetFrontierClient r101, int r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_unregisterService(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void addHeader(long r100, CronetFrontierClient r101, String r102, String r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_addHeader(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void sendMessage(long r100, CronetFrontierClient r101, int r102, String[] r103, ByteBuffer r104) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_sendMessage(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void registerService(long r100, CronetFrontierClient r101, String[] r102, ByteBuffer r103, int r104, int r105, boolean r106) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_registerService(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.Natives
    public void configParams(long r100, CronetFrontierClient r101, int r102, int r103, String r104, int r105, String r106, String r107, String r110, String r111, int r112, int r113, int r114, boolean r115, String r116, String r117) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetFrontierClient_configParams(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
