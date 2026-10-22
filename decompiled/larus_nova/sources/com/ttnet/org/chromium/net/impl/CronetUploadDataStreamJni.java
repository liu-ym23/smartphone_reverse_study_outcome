package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes5.dex */
class CronetUploadDataStreamJni implements CronetUploadDataStream.Natives {
    public static final JniStaticTestMocker<CronetUploadDataStream.Natives> TEST_HOOKS = null;
    private static CronetUploadDataStream.Natives testInstance;

    public CronetUploadDataStreamJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static CronetUploadDataStream.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetUploadDataStream.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUploadDataStreamJni();
    }

    public static /* synthetic */ CronetUploadDataStream.Natives access$002(CronetUploadDataStream.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long createAdapterForTesting(CronetUploadDataStream r100) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createAdapterForTesting(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void destroy(long r100) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_destroy(r100);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void onRewindSucceeded(long r100, CronetUploadDataStream r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onRewindSucceeded(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long attachUploadDataToRequest(CronetUploadDataStream r100, long r101, long r102) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_attachUploadDataToRequest(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public long createUploadDataStreamForTesting(CronetUploadDataStream r100, long r101, long r102) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_createUploadDataStreamForTesting(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUploadDataStream.Natives
    public void onReadSucceeded(long r100, CronetUploadDataStream r101, int r102, boolean r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUploadDataStream_onReadSucceeded(r100, r101, r102, r103);
    }
}
