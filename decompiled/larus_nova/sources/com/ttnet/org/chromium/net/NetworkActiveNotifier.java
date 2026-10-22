package com.ttnet.org.chromium.net;

import android.net.ConnectivityManager;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace(com.alipay.sdk.m.k.b.f25406k)
public class NetworkActiveNotifier implements ConnectivityManager.OnNetworkActiveListener {
    private boolean mAreNotificationsEnabled;
    private final ConnectivityManager mConnectivityManager;
    private final long mNativeNetworkActiveObserver;

    /* JADX INFO: loaded from: classes6.dex */
    public interface Natives {
        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfDefaultNetworkActive(long r100);
    }

    public void disableNotifications() {
        this.mAreNotificationsEnabled = false;
        this.mConnectivityManager.removeDefaultNetworkActiveListener(this);
    }

    public void enableNotifications() {
        this.mAreNotificationsEnabled = true;
        this.mConnectivityManager.addDefaultNetworkActiveListener(this);
    }

    public void fakeDefaultNetworkActive() {
        if (this.mAreNotificationsEnabled == false) goto L6;
        onNetworkActive();
        return;
    }

    public boolean isDefaultNetworkActive() {
        return this.mConnectivityManager.isDefaultNetworkActive();
    }

    @Override // android.net.ConnectivityManager.OnNetworkActiveListener
    public void onNetworkActive() {
        NetworkActiveNotifierJni.get().notifyOfDefaultNetworkActive(this.mNativeNetworkActiveObserver);
    }

    private NetworkActiveNotifier(long r100) {
        this.mNativeNetworkActiveObserver = r100;
        this.mConnectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
    }

    public static NetworkActiveNotifier build(long r100) {
        return new NetworkActiveNotifier(r100);
    }
}
