package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
class HttpUtilJni implements HttpUtil.Natives {
    public static final JniStaticTestMocker<HttpUtil.Natives> TEST_HOOKS = null;
    private static HttpUtil.Natives testInstance;

    public HttpUtilJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static HttpUtil.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        HttpUtil.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.HttpUtil.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new HttpUtilJni();
    }

    public static /* synthetic */ HttpUtil.Natives access$002(HttpUtil.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.HttpUtil.Natives
    public boolean isAllowedHeader(String r100, String r101) {
        return GEN_JNI.com_ttnet_org_chromium_net_HttpUtil_isAllowedHeader(r100, r101);
    }
}
