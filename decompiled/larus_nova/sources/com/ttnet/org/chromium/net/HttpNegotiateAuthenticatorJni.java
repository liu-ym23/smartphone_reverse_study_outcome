package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes41.dex */
class HttpNegotiateAuthenticatorJni implements HttpNegotiateAuthenticator.Natives {
    public static final JniStaticTestMocker<HttpNegotiateAuthenticator.Natives> TEST_HOOKS = null;
    private static HttpNegotiateAuthenticator.Natives testInstance;

    public HttpNegotiateAuthenticatorJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static HttpNegotiateAuthenticator.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        HttpNegotiateAuthenticator.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new HttpNegotiateAuthenticatorJni();
    }

    public static /* synthetic */ HttpNegotiateAuthenticator.Natives access$002(HttpNegotiateAuthenticator.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.HttpNegotiateAuthenticator.Natives
    public void setResult(long r100, HttpNegotiateAuthenticator r101, int r102, String r103) {
        GEN_JNI.com_ttnet_org_chromium_net_HttpNegotiateAuthenticator_setResult(r100, r101, r102, r103);
    }
}
