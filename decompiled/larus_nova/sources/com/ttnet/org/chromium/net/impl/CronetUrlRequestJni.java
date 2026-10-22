package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
class CronetUrlRequestJni implements CronetUrlRequest.Natives {
    public static final JniStaticTestMocker<CronetUrlRequest.Natives> TEST_HOOKS = null;
    private static CronetUrlRequest.Natives testInstance;

    public CronetUrlRequestJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static CronetUrlRequest.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetUrlRequest.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUrlRequestJni();
    }

    public static /* synthetic */ CronetUrlRequest.Natives access$002(CronetUrlRequest.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void abortWhenUploadException(long r100, CronetUrlRequest r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_abortWhenUploadException(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void appTimeout(long r100, CronetUrlRequest r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_appTimeout(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void followDeferredRedirect(long r100, CronetUrlRequest r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_followDeferredRedirect(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void removeRequestCookieHeader(long r100, CronetUrlRequest r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_removeRequestCookieHeader(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void start(long r100, CronetUrlRequest r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_start(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void destroy(long r100, CronetUrlRequest r101, boolean r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_destroy(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void getStatus(long r100, CronetUrlRequest r101, VersionSafeCallbacks.UrlRequestStatusListener r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_getStatus(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean setHttpMethod(long r100, CronetUrlRequest r101, String r102) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setHttpMethod(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setRequestTimeout(long r100, CronetUrlRequest r101, int r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTimeout(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setRequestTypeFlags(long r100, CronetUrlRequest r101, int r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setRequestTypeFlags(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setThrottleNetSpeed(long r100, CronetUrlRequest r101, long r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setThrottleNetSpeed(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void addRequestCookieHeader(long r100, CronetUrlRequest r101, String r102, String r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestCookieHeader(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean addRequestHeader(long r100, CronetUrlRequest r101, String r102, String r103) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_addRequestHeader(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setAuthCredentials(long r100, CronetUrlRequest r101, String r102, String r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setAuthCredentials(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public boolean readData(long r100, CronetUrlRequest r101, ByteBuffer r102, int r103, int r104) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_readData(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public void setSocketTimeout(long r100, CronetUrlRequest r101, int r102, int r103, int r104) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_setSocketTimeout(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequest.Natives
    public long createRequestAdapter(CronetUrlRequest r100, long r101, String r102, int r103, int r104, boolean r105, boolean r106, boolean r107, int r110, boolean r111, int r112, int r113, long r114) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequest_createRequestAdapter(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114);
    }
}
