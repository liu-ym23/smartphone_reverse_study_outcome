package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes6.dex */
class ProxyChangeListenerJni implements ProxyChangeListener.Natives {
    public static final JniStaticTestMocker<ProxyChangeListener.Natives> TEST_HOOKS = null;
    private static ProxyChangeListener.Natives testInstance;

    public ProxyChangeListenerJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static ProxyChangeListener.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        ProxyChangeListener.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.ProxyChangeListener.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new ProxyChangeListenerJni();
    }

    public static /* synthetic */ ProxyChangeListener.Natives access$002(ProxyChangeListener.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChanged(long r100, ProxyChangeListener r101) {
        GEN_JNI.com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChanged(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.ProxyChangeListener.Natives
    public void proxySettingsChangedTo(long r100, ProxyChangeListener r101, String r102, int r103, String r104, String[] r105) {
        GEN_JNI.com_ttnet_org_chromium_net_ProxyChangeListener_proxySettingsChangedTo(r100, r101, r102, r103, r104, r105);
    }
}
