package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@JNINamespace("net")
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static NetworkChangeNotifier sInstance;
    private NetworkChangeNotifierAutoDetect mAutoDetector;
    private final ObserverList<ConnectionTypeObserver> mConnectionTypeObservers;
    private int mCurrentConnectionCost;
    private int mCurrentConnectionType;
    private final ArrayList<Long> mNativeChangeNotifiers;

    private void destroyAutoDetector() {
        NetworkChangeNotifierAutoDetect r0 = this.mAutoDetector;
        if (r0 == null) goto L6;
        r0.destroy();
        this.mAutoDetector = null;
        return;
    }

    private void forceUpdateNetworkType() {
        NetworkChangeNotifierAutoDetect r0 = this.mAutoDetector;
        if (r0 == null) goto L8;
        NetworkChangeNotifierAutoDetect.NetworkState r1 = r0.getCurrentNetworkState();
        if (this.mCurrentConnectionType == r1.getConnectionType()) goto L9;
        this.mCurrentConnectionType = r1.getConnectionType();
        this.mAutoDetector.runOnThread(new 2(this));
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
        NetworkChangeNotifierAutoDetect r0 = this.mAutoDetector;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getCurrentNetworkState().getConnectionSubtype();
    }

    public long getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect r0 = this.mAutoDetector;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getDefaultNetId();
    }

    public long[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect r0 = this.mAutoDetector;
        if (r0 != null) goto L6;
        return new long[0];
    L6:
        return r0.getNetworksAndTypes();
    }

    public long getCurrentVpnNetId() {
        NetworkChangeNotifierAutoDetect r0 = this.mAutoDetector;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getVpnNetId();
    }

    public boolean registerNetworkCallbackFailed() {
        NetworkChangeNotifierAutoDetect r0 = this.mAutoDetector;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.registerNetworkCallbackFailed();
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

    public static /* synthetic */ int access$100(NetworkChangeNotifier r0) {
        return r0.mCurrentConnectionType;
    }

    public static void addConnectionTypeObserver(ConnectionTypeObserver r1) {
        getInstance().addConnectionTypeObserverInternal(r1);
    }

    private void addConnectionTypeObserverInternal(ConnectionTypeObserver r2) {
        this.mConnectionTypeObservers.addObserver(r2);
    }

    public static void fakeConnectionCostChanged(int r1) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionCostChange(r1);
    }

    public static void fakeConnectionSubtypeChanged(int r1) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionSubtypeChange(r1);
    }

    public static void fakeNetworkDisconnected(long r2) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkDisconnect(r2, false);
    }

    public static void fakeNetworkSoonToBeDisconnected(long r1) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkSoonToDisconnect(r1);
    }

    public static void fakePurgeActiveNetworkList(long[] r1) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversToPurgeActiveNetworkList(r1);
    }

    public static void forceConnectivityState(boolean r1) {
        setAutoDetectConnectivityState(false);
        getInstance().forceConnectivityStateInternal(r1);
    }

    private void forceConnectivityStateInternal(boolean r5) {
        int r2 = 0;
        if (this.mCurrentConnectionType == 6) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == r5) goto L12;
        if (r5 == true) goto L10;
        r2 = 6;
    L10:
        updateCurrentConnectionType(r2);
        notifyObserversOfConnectionSubtypeChange(!r5 ? 1 : 0);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void removeConnectionTypeObserver(ConnectionTypeObserver r1) {
        getInstance().removeConnectionTypeObserverInternal(r1);
    }

    private void removeConnectionTypeObserverInternal(ConnectionTypeObserver r2) {
        this.mConnectionTypeObservers.removeObserver(r2);
    }

    public static void resetInstanceForTests(NetworkChangeNotifier r0) {
        sInstance = r0;
    }

    public static void setAutoDetectConnectivityState(boolean r2) {
        getInstance().setAutoDetectConnectivityStateInternal(r2, new RegistrationPolicyApplicationStatus());
    }

    private void updateCurrentConnectionCost(int r1) {
        this.mCurrentConnectionCost = r1;
        notifyObserversOfConnectionCostChange(r1);
    }

    private void updateCurrentConnectionType(int r1) {
        this.mCurrentConnectionType = r1;
        notifyObserversOfConnectionTypeChange(r1);
    }

    public void addNativeObserver(long r2) {
        this.mNativeChangeNotifiers.add(Long.valueOf(r2));
    }

    public void notifyObserversOfConnectionCostChange(int r6) {
        Iterator<Long> r0 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = r0.next();
        NetworkChangeNotifierJni.get().notifyConnectionCostChanged(r1.longValue(), this, r6);
        goto L4
    }

    public void notifyObserversOfConnectionSubtypeChange(int r6) {
        Iterator<Long> r0 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = r0.next();
        NetworkChangeNotifierJni.get().notifyMaxBandwidthChanged(r1.longValue(), this, r6);
        goto L4
    }

    public void notifyObserversOfConnectionTypeChange(int r3) {
        notifyObserversOfConnectionTypeChange(r3, getCurrentDefaultNetId());
    }

    public void notifyObserversOfNetworkSoonToDisconnect(long r9) {
        Iterator<Long> r0 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = r0.next();
        NetworkChangeNotifierJni.get().notifyOfNetworkSoonToDisconnect(r1.longValue(), this, r9);
        goto L4
    }

    public void notifyObserversToPurgeActiveNetworkList(long[] r6) {
        Iterator<Long> r0 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = r0.next();
        NetworkChangeNotifierJni.get().notifyPurgeActiveNetworkList(r1.longValue(), this, r6);
        goto L4
    }

    public void removeNativeObserver(long r2) {
        this.mNativeChangeNotifiers.remove(Long.valueOf(r2));
    }

    public static void setAutoDetectConnectivityState(NetworkChangeNotifierAutoDetect.RegistrationPolicy r2) {
        getInstance().setAutoDetectConnectivityStateInternal(true, r2);
    }

    public static /* synthetic */ void access$000(NetworkChangeNotifier r0, int r1) {
        r0.updateCurrentConnectionType(r1);
    }

    public static void fakeDefaultNetwork(long r1, int r3) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionTypeChange(r3, r1);
    }

    public static void fakeNetworkConnected(long r2, int r4) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkConnect(r2, r4, false);
    }

    private void notifyObserversOfConnectionTypeChange(int r10, long r11) {
        Iterator<Long> r0 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = r0.next();
        NetworkChangeNotifierJni.get().notifyConnectionTypeChanged(r1.longValue(), this, r10, r11);
        goto L4
    L6:
        Iterator r12 = this.mConnectionTypeObservers.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((ConnectionTypeObserver) r12.next()).onConnectionTypeChanged(r10);
        goto L8
    }

    private void setAutoDetectConnectivityStateInternal(boolean r2, NetworkChangeNotifierAutoDetect.RegistrationPolicy r3) {
        if (r2 == true) goto L4;
        destroyAutoDetector();
        return;
    L4:
        if (this.mAutoDetector != null) goto L8;
        NetworkChangeNotifierAutoDetect r4 = new NetworkChangeNotifierAutoDetect(new AnonymousClass1(this), r3);
        this.mAutoDetector = r4;
        NetworkChangeNotifierAutoDetect.NetworkState r5 = r4.getCurrentNetworkState();
        updateCurrentConnectionType(r5.getConnectionType());
        updateCurrentConnectionCost(r5.getConnectionCost());
        notifyObserversOfConnectionSubtypeChange(r5.getConnectionSubtype());
        return;
    }

    public void mockConnectionTypeChangeForTesting(int r2, long r3) {
        if (BuildConfig.DCHECK_IS_ON == false) goto L6;
        notifyObserversOfConnectionTypeChange(r2, r3);
        return;
    }

    public void notifyObserversOfNetworkDisconnect(long r10, boolean r12) {
        Iterator<Long> r0 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = r0.next();
        NetworkChangeNotifierJni.get().notifyOfNetworkDisconnect(r1.longValue(), this, r12, r10);
        goto L4
    }

    public void notifyObserversOfNetworkConnect(long r11, int r13, boolean r14) {
        Iterator<Long> r0 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Long r1 = r0.next();
        NetworkChangeNotifierJni.get().notifyOfNetworkConnect(r1.longValue(), this, r11, r14, r13);
        goto L4
    }
}
