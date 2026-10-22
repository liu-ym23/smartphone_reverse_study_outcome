package com.bytedance.realx.base;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes21.dex */
public class NetworkMonitor {
    private static final String TAG = "NetworkMonitor";
    private String cellularIfName;
    private Network cellularNetwork;
    private Boolean cellularNetworkRequested;
    private long cellularRequestCallback;
    private ConnectivityManager connectivityManager;
    private NetworkMonitoCallback networkMonitorCallback;
    private Boolean shouldEmitAvailable;

    public class NetworkMonitoCallback extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ NetworkMonitor this$0;

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            NetworkMonitor r100 = this.this$0;
            monitor-enter(r100);
            RXLogging.w(NetworkMonitor.TAG, "on unavailable");     // Catch: Throwable -> L9
            if (NetworkMonitor.access$200(this.this$0) == 0) goto L7;
            NativeNetworkFunctions.nativeOnNetworkUnavailable(NetworkMonitor.access$200(this.this$0));     // Catch: Throwable -> L9
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public NetworkMonitoCallback(NetworkMonitor r100) {
            this.this$0 = r100;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r100) {
            NetworkMonitor r101 = this.this$0;
            monitor-enter(r101);
            RXLogging.w(NetworkMonitor.TAG, "on available, network: " + r100.toString());     // Catch: Throwable -> L9
            if (NetworkMonitor.access$000(this.this$0) != null) goto L7;
            NetworkMonitor.access$002(this.this$0, r100);     // Catch: Throwable -> L9
            NetworkMonitor.access$102(this.this$0, Boolean.TRUE);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r101);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r100) {
            NetworkMonitor r101 = this.this$0;
            monitor-enter(r101);
            RXLogging.w(NetworkMonitor.TAG, "on lost, network: " + r100.toString());     // Catch: Throwable -> L13
            if (r100.equals(NetworkMonitor.access$000(this.this$0)) == false) goto L11;
            NetworkMonitor.access$002(this.this$0, null);     // Catch: Throwable -> L13
            if (NetworkMonitor.access$200(this.this$0) == 0) goto L11;
            if (NetworkMonitor.access$300(this.this$0) == null) goto L11;
            NativeNetworkFunctions.nativeOnNetworkLost(NetworkMonitor.access$300(this.this$0), NetworkMonitor.access$200(this.this$0));     // Catch: Throwable -> L13
        L11:
            monitor-exit(r101);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network r100, boolean r101) {
            NetworkMonitor r102 = this.this$0;
            monitor-enter(r102);
            RXLogging.w(NetworkMonitor.TAG, "on network block status changed, network: " + r100.toString() + ", blocked: " + r101);     // Catch: Throwable -> L13
            if (r100.equals(NetworkMonitor.access$000(this.this$0)) == true) goto L7;
        L11:
            monitor-exit(r102);     // Catch: Throwable -> L13
            return;
        L7:
            if (NetworkMonitor.access$200(this.this$0) == 0) goto L11;
            if (NetworkMonitor.access$300(this.this$0) == null) goto L11;
            NativeNetworkFunctions.nativeOnBlockedStatusChanged(NetworkMonitor.access$300(this.this$0), r101, NetworkMonitor.access$200(this.this$0));     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
            NetworkMonitor r102 = this.this$0;
            monitor-enter(r102);
            RXLogging.w(NetworkMonitor.TAG, "on capabilities changed, network: " + r100.toString() + ", capabilities: " + r101.toString());     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r100, LinkProperties r101) {
            NetworkMonitor r102 = this.this$0;
            monitor-enter(r102);
            RXLogging.w(NetworkMonitor.TAG, "on link properties changed, network: " + r100.toString() + ", capabilities: " + r101.toString());     // Catch: Throwable -> L15
            if (r100.equals(NetworkMonitor.access$000(this.this$0)) == false) goto L13;
            NetworkMonitor.access$302(this.this$0, r101.getInterfaceName());     // Catch: Throwable -> L15
            if (NetworkMonitor.access$200(this.this$0) == 0) goto L13;
            if (NetworkMonitor.access$100(this.this$0).booleanValue() == false) goto L13;
            if (NetworkMonitor.access$300(this.this$0) == null) goto L13;
            NativeNetworkFunctions.nativeOnNetworkAvailable(NetworkMonitor.access$300(this.this$0), NetworkMonitor.access$200(this.this$0));     // Catch: Throwable -> L15
            NetworkMonitor.access$102(this.this$0, Boolean.FALSE);     // Catch: Throwable -> L15
        L13:
            monitor-exit(r102);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }
    }

    public static NetworkMonitor create() {
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return null;
    L7:
        return new NetworkMonitor();
    }

    public void cancelRequestCellularNetwork() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.cellularNetworkRequested.booleanValue() == true) goto L15;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L15:
        this.connectivityManager.unregisterNetworkCallback(this.networkMonitorCallback);     // Catch: Exception -> L8 Throwable -> L12
        this.cellularNetwork = null;     // Catch: Exception -> L8 Throwable -> L12
        this.cellularRequestCallback = 0;     // Catch: Exception -> L8 Throwable -> L12
        this.cellularNetworkRequested = Boolean.FALSE;     // Catch: Exception -> L8 Throwable -> L12
    L8:
        e = move-exception;
        RXLogging.w(TAG, "Cancel request cellular network exception: " + e.toString());     // Catch: Throwable -> L12
        goto L10
    }

    public NetworkMonitor() {
        this.connectivityManager = null;
        this.cellularNetwork = null;
        this.cellularRequestCallback = 0;
        Boolean r100 = Boolean.FALSE;
        this.cellularNetworkRequested = r100;
        this.shouldEmitAvailable = r100;
        this.networkMonitorCallback = null;
        this.connectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
    }

    public static /* synthetic */ Network access$000(NetworkMonitor r100) {
        return r100.cellularNetwork;
    }

    public static /* synthetic */ Boolean access$100(NetworkMonitor r100) {
        return r100.shouldEmitAvailable;
    }

    public static /* synthetic */ long access$200(NetworkMonitor r100) {
        return r100.cellularRequestCallback;
    }

    public static /* synthetic */ String access$300(NetworkMonitor r100) {
        return r100.cellularIfName;
    }

    public void requestCellularNetwork(long r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.cellularNetworkRequested.booleanValue() == false) goto L17;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L17:
        this.cellularRequestCallback = r100;     // Catch: Exception -> L8 Throwable -> L12
        NetworkRequest r101 = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();     // Catch: Exception -> L8 Throwable -> L12
        NetworkMonitoCallback r102 = new NetworkMonitoCallback(this);     // Catch: Exception -> L8 Throwable -> L12
        this.networkMonitorCallback = r102;     // Catch: Exception -> L8 Throwable -> L12
        this.connectivityManager.requestNetwork(r101, r102);     // Catch: Exception -> L8 Throwable -> L12
        this.cellularNetworkRequested = Boolean.TRUE;     // Catch: Exception -> L8 Throwable -> L12
    L8:
        e = move-exception;
        RXLogging.w(TAG, "Request cellular network exception: " + e.toString());     // Catch: Throwable -> L12
        goto L10
    }

    public static /* synthetic */ Network access$002(NetworkMonitor r100, Network r101) {
        r100.cellularNetwork = r101;
        return r101;
    }

    public static /* synthetic */ Boolean access$102(NetworkMonitor r100, Boolean r101) {
        r100.shouldEmitAvailable = r101;
        return r101;
    }

    public static /* synthetic */ String access$302(NetworkMonitor r100, String r101) {
        r100.cellularIfName = r101;
        return r101;
    }

    public int bindSocketToCellularNetwork(int r100, String r101) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.cellularNetwork != null) goto L7;
    L13:
        int r102 = -1;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r102;
    L7:
        if (r101.equals(this.cellularIfName) == false) goto L13;
        RXLogging.w(TAG, "bind socket to network, fd: " + r100);     // Catch: Throwable -> L16
        ParcelFileDescriptor r103 = ParcelFileDescriptor.fromFd(r100);     // Catch: Exception -> L11 Throwable -> L16
        this.cellularNetwork.bindSocket(r103.getFileDescriptor());     // Catch: Exception -> L11 Throwable -> L16
        r103.detachFd();     // Catch: Exception -> L11 Throwable -> L16
        r103.close();     // Catch: Exception -> L11 Throwable -> L16
        r102 = 0;
        goto L14
    L11:
        e = move-exception;
        RXLogging.w(TAG, "bind socket to network exception: " + e.toString());     // Catch: Throwable -> L16
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L13
    }
}
