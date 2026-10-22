package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
class TTCronetNetExpRequestJni implements TTCronetNetExpRequest.Natives {
    public static final JniStaticTestMocker<TTCronetNetExpRequest.Natives> TEST_HOOKS = null;
    private static TTCronetNetExpRequest.Natives testInstance;

    public TTCronetNetExpRequestJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static TTCronetNetExpRequest.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        TTCronetNetExpRequest.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new TTCronetNetExpRequestJni();
    }

    public static /* synthetic */ TTCronetNetExpRequest.Natives access$002(TTCronetNetExpRequest.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void destroy(long r100, TTCronetNetExpRequest r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_destroy(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void start(long r100, TTCronetNetExpRequest r101) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_start(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public void doExtraCommand(long r100, TTCronetNetExpRequest r101, String r102, String r103) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_doExtraCommand(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.impl.TTCronetNetExpRequest.Natives
    public long createRequestAdapter(TTCronetNetExpRequest r100, long r101, int r102, String[] r103, int r104, int r105, int r106) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_TTCronetNetExpRequest_createRequestAdapter(r100, r101, r102, r103, r104, r105, r106);
    }
}
