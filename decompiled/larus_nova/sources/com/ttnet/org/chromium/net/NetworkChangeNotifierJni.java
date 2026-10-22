package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.natives.GEN_JNI;

/* JADX INFO: loaded from: classes5.dex */
class NetworkChangeNotifierJni implements NetworkChangeNotifier.Natives {
    public static final JniStaticTestMocker<NetworkChangeNotifier.Natives> TEST_HOOKS = null;
    private static NetworkChangeNotifier.Natives testInstance;

    public NetworkChangeNotifierJni() {
    }

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    public static NetworkChangeNotifier.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        NetworkChangeNotifier.Natives r100 = testInstance;
        if (r100 == null) goto L8;
        return r100;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new NetworkChangeNotifierJni();
    }

    public static /* synthetic */ NetworkChangeNotifier.Natives access$002(NetworkChangeNotifier.Natives r100) {
        testInstance = r100;
        return r100;
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyConnectionCostChanged(long r100, NetworkChangeNotifier r101, int r102) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionCostChanged(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyMaxBandwidthChanged(long r100, NetworkChangeNotifier r101, int r102) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyMaxBandwidthChanged(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkSoonToDisconnect(long r100, NetworkChangeNotifier r101, long r102) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkSoonToDisconnect(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyPurgeActiveNetworkList(long r100, NetworkChangeNotifier r101, long[] r102) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyPurgeActiveNetworkList(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyConnectionTypeChanged(long r100, NetworkChangeNotifier r101, int r102, long r103) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyConnectionTypeChanged(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkDisconnect(long r100, NetworkChangeNotifier r101, boolean r102, long r103) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkDisconnect(r100, r101, r102, r103);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifier.Natives
    public void notifyOfNetworkConnect(long r100, NetworkChangeNotifier r101, long r102, boolean r103, int r104) {
        GEN_JNI.com_ttnet_org_chromium_net_NetworkChangeNotifier_notifyOfNetworkConnect(r100, r101, r102, r103, r104);
    }
}
