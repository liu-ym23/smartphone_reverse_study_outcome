package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes41.dex */
class CronetBidirectionalStreamJni implements CronetBidirectionalStream.Natives {
    public static final JniStaticTestMocker<CronetBidirectionalStream.Natives> TEST_HOOKS = null;
    private static CronetBidirectionalStream.Natives testInstance;

    public CronetBidirectionalStreamJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static CronetBidirectionalStream.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetBidirectionalStream.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetBidirectionalStreamJni();
    }

    public static /* synthetic */ CronetBidirectionalStream.Natives access$002(CronetBidirectionalStream.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public void sendRequestHeaders(long r100, CronetBidirectionalStream r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_sendRequestHeaders(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public void destroy(long r100, CronetBidirectionalStream r101, boolean r102) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_destroy(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public boolean readData(long r100, CronetBidirectionalStream r101, ByteBuffer r102, int r103, int r104) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_readData(r100, r101, r102, r103, r104);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public boolean writevData(long r100, CronetBidirectionalStream r101, ByteBuffer[] r102, int[] r103, int[] r104, boolean r105) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_writevData(r100, r101, r102, r103, r104, r105);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public int start(long r100, CronetBidirectionalStream r101, String r102, int r103, String r104, String[] r105, boolean r106) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_start(r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetBidirectionalStream.Natives
    public long createBidirectionalStream(CronetBidirectionalStream r100, long r101, boolean r102, boolean r103, int r104, boolean r105, int r106, long r107) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream_createBidirectionalStream(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
