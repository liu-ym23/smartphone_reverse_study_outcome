package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace(com.alipay.sdk.m.k.b.f25406k)
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static NetworkChangeNotifier sInstance;
    private NetworkChangeNotifierAutoDetect mAutoDetector;
    private final ObserverList<ConnectionTypeObserver> mConnectionTypeObservers;
    private int mCurrentConnectionCost;
    private int mCurrentConnectionType;
    private final ArrayList<Long> mNativeChangeNotifiers;

    /* JADX INFO: loaded from: classes6.dex */
    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int r100);
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface Natives {
        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyConnectionCostChanged(long r100, NetworkChangeNotifier r101, int r102);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyConnectionTypeChanged(long r100, NetworkChangeNotifier r101, int r102, long r103);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyMaxBandwidthChanged(long r100, NetworkChangeNotifier r101, int r102);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkConnect(long r100, NetworkChangeNotifier r101, long r102, boolean r103, int r104);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkDisconnect(long r100, NetworkChangeNotifier r101, boolean r102, long r103);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkSoonToDisconnect(long r100, NetworkChangeNotifier r101, long r102);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyPurgeActiveNetworkList(long r100, NetworkChangeNotifier r101, long[] r102);
    }

    private void destroyAutoDetector() {
        NetworkChangeNotifierAutoDetect r100 = this.mAutoDetector;
        if (r100 == null) goto L6;
        r100.destroy();
        this.mAutoDetector = null;
        return;
    }

    private void forceUpdateNetworkType() {
        NetworkChangeNotifierAutoDetect r100 = this.mAutoDetector;
        if (r100 == null) goto L8;
        NetworkChangeNotifierAutoDetect.NetworkState r101 = r100.getCurrentNetworkState();
        if (this.mCurrentConnectionType == r101.getConnectionType()) goto L9;
        this.mCurrentConnectionType = r101.getConnectionType();
        this.mAutoDetector.runOnThread(new AnonymousClass2(this));
        return;
    L9:
        return;
    }

    public static NetworkChangeNotifier init() {
        if (sInstance != null) goto L6;
        sInstance = new NetworkChangeNotifier();
    L6:
        return sInstance;
    }

    public static boolean isInitialized() {
        if (sInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int getCurrentConnectionSubtype() {
        NetworkChangeNotifierAutoDetect r100 = this.mAutoDetector;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getCurrentNetworkState().getConnectionSubtype();
    }

    public long getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect r100 = this.mAutoDetector;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getDefaultNetId();
    }

    public long[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect r100 = this.mAutoDetector;
        if (r100 != null) goto L6;
        return new long[0];
    L6:
        return r100.getNetworksAndTypes();
    }

    public long getCurrentVpnNetId() {
        NetworkChangeNotifierAutoDetect r100 = this.mAutoDetector;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getVpnNetId();
    }

    public boolean registerNetworkCallbackFailed() {
        NetworkChangeNotifierAutoDetect r100 = this.mAutoDetector;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.registerNetworkCallbackFailed();
    }

    public NetworkChangeNotifier() {
        this.mCurrentConnectionType = 0;
        this.mCurrentConnectionCost = 0;
        this.mNativeChangeNotifiers = new ArrayList();
        this.mConnectionTypeObservers = new ObserverList();
    }

    public static void forceUpdateNetworkTypeInfo() {
        getInstance().forceUpdateNetworkType();
    }

    public static NetworkChangeNotifierAutoDetect getAutoDetectorForTest() {
        return getInstance().mAutoDetector;
    }

    public static boolean isOnline() {
        if (getInstance().getCurrentConnectionType() == 6) goto L5;
        return true;
    L5:
        return false;
    }

    public static void registerToReceiveNotificationsAlways() {
        getInstance().setAutoDetectConnectivityStateInternal(true, new RegistrationPolicyAlwaysRegister());
    }

    static {
    }

    public static NetworkChangeNotifier getInstance() {
        return sInstance;
    }

    public int getCurrentConnectionCost() {
        return this.mCurrentConnectionCost;
    }

    public int getCurrentConnectionType() {
        return this.mCurrentConnectionType;
    }

    public static /* synthetic */ int access$100(NetworkChangeNotifier r100) {
        return r100.mCurrentConnectionType;
    }

    public static void addConnectionTypeObserver(ConnectionTypeObserver r100) {
        getInstance().addConnectionTypeObserverInternal(r100);
    }

    private void addConnectionTypeObserverInternal(ConnectionTypeObserver r100) {
        this.mConnectionTypeObservers.addObserver(r100);
    }

    public static void fakeConnectionCostChanged(int r100) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionCostChange(r100);
    }

    public static void fakeConnectionSubtypeChanged(int r100) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionSubtypeChange(r100);
    }

    public static void fakeNetworkDisconnected(long r100) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkDisconnect(r100, false);
    }

    public static void fakeNetworkSoonToBeDisconnected(long r100) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkSoonToDisconnect(r100);
    }

    public static void fakePurgeActiveNetworkList(long[] r100) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversToPurgeActiveNetworkList(r100);
    }

    public static void forceConnectivityState(boolean r100) {
        setAutoDetectConnectivityState(false);
        getInstance().forceConnectivityStateInternal(r100);
    }

    private void forceConnectivityStateInternal(boolean r100) {
        int r101 = 0;
        if (this.mCurrentConnectionType == 6) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == r100) goto L12;
        if (r100 == true) goto L10;
        r101 = 6;
    L10:
        updateCurrentConnectionType(r101);
        notifyObserversOfConnectionSubtypeChange(!r100 ? 1 : 0);
        return;
    L12:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static void removeConnectionTypeObserver(ConnectionTypeObserver r100) {
        getInstance().removeConnectionTypeObserverInternal(r100);
    }

    private void removeConnectionTypeObserverInternal(ConnectionTypeObserver r100) {
        this.mConnectionTypeObservers.removeObserver(r100);
    }

    public static void resetInstanceForTests(NetworkChangeNotifier r100) {
        sInstance = r100;
    }

    public static void setAutoDetectConnectivityState(boolean r100) {
        getInstance().setAutoDetectConnectivityStateInternal(r100, new RegistrationPolicyApplicationStatus());
    }

    private void updateCurrentConnectionCost(int r100) {
        this.mCurrentConnectionCost = r100;
        notifyObserversOfConnectionCostChange(r100);
    }

    private void updateCurrentConnectionType(int r100) {
        this.mCurrentConnectionType = r100;
        notifyObserversOfConnectionTypeChange(r100);
    }

    public void addNativeObserver(long r100) {
        this.mNativeChangeNotifiers.add(Long.valueOf(r100));
    }

    public void notifyObserversOfConnectionCostChange(int r100) {
        Iterator<Long> r101 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Long r102 = r101.next();
        NetworkChangeNotifierJni.get().notifyConnectionCostChanged(r102.longValue(), this, r100);
        goto L4
    }

    public void notifyObserversOfConnectionSubtypeChange(int r100) {
        Iterator<Long> r101 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Long r102 = r101.next();
        NetworkChangeNotifierJni.get().notifyMaxBandwidthChanged(r102.longValue(), this, r100);
        goto L4
    }

    public void notifyObserversOfConnectionTypeChange(int r100) {
        notifyObserversOfConnectionTypeChange(r100, getCurrentDefaultNetId());
    }

    public void notifyObserversOfNetworkSoonToDisconnect(long r100) {
        Iterator<Long> r101 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Long r102 = r101.next();
        NetworkChangeNotifierJni.get().notifyOfNetworkSoonToDisconnect(r102.longValue(), this, r100);
        goto L4
    }

    public void notifyObserversToPurgeActiveNetworkList(long[] r100) {
        Iterator<Long> r101 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Long r102 = r101.next();
        NetworkChangeNotifierJni.get().notifyPurgeActiveNetworkList(r102.longValue(), this, r100);
        goto L4
    }

    public void removeNativeObserver(long r100) {
        this.mNativeChangeNotifiers.remove(Long.valueOf(r100));
    }

    public static void setAutoDetectConnectivityState(NetworkChangeNotifierAutoDetect.RegistrationPolicy r100) {
        getInstance().setAutoDetectConnectivityStateInternal(true, r100);
    }

    public static /* synthetic */ void access$000(NetworkChangeNotifier r100, int r101) {
        r100.updateCurrentConnectionType(r101);
    }

    public static void fakeDefaultNetwork(long r100, int r101) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionTypeChange(r101, r100);
    }

    public static void fakeNetworkConnected(long r100, int r101) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkConnect(r100, r101, false);
    }

    private void notifyObserversOfConnectionTypeChange(int r110, long r111) {
        Iterator<Long> r100 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Long r101 = r100.next();
        NetworkChangeNotifierJni.get().notifyConnectionTypeChanged(r101.longValue(), this, r110, r111);
        goto L4
    L6:
        Iterator<ConnectionTypeObserver> r112 = this.mConnectionTypeObservers.iterator();
    L8:
        if (r112.hasNext() == false) goto L10;
        r112.next().onConnectionTypeChanged(r110);
        goto L8
    }

    private void setAutoDetectConnectivityStateInternal(boolean r100, NetworkChangeNotifierAutoDetect.RegistrationPolicy r101) {
        if (r100 == true) goto L4;
        destroyAutoDetector();
        return;
    L4:
        if (this.mAutoDetector != null) goto L8;
        NetworkChangeNotifierAutoDetect r102 = new NetworkChangeNotifierAutoDetect(new AnonymousClass1(this), r101);
        this.mAutoDetector = r102;
        NetworkChangeNotifierAutoDetect.NetworkState r103 = r102.getCurrentNetworkState();
        updateCurrentConnectionType(r103.getConnectionType());
        updateCurrentConnectionCost(r103.getConnectionCost());
        notifyObserversOfConnectionSubtypeChange(r103.getConnectionSubtype());
        return;
    }

    public void mockConnectionTypeChangeForTesting(int r100, long r101) {
        if (BuildConfig.DCHECK_IS_ON == false) goto L6;
        notifyObserversOfConnectionTypeChange(r100, r101);
        return;
    }

    public void notifyObserversOfNetworkDisconnect(long r110, boolean r111) {
        Iterator<Long> r100 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Long r101 = r100.next();
        NetworkChangeNotifierJni.get().notifyOfNetworkDisconnect(r101.longValue(), this, r111, r110);
        goto L4
    }

    public void notifyObserversOfNetworkConnect(long r110, int r111, boolean r112) {
        Iterator<Long> r100 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Long r101 = r100.next();
        NetworkChangeNotifierJni.get().notifyOfNetworkConnect(r101.longValue(), this, r110, r112, r111);
        goto L4
    }
}
