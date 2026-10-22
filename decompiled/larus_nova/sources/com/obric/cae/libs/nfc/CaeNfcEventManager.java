package com.obric.cae.libs.nfc;

import android.os.Bundle;
import android.os.RemoteException;
import com.obric.cae.libs.utils.LogUtil;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes33.dex */
public class CaeNfcEventManager {
    public static final int TRANSIT_AID_TYPE_ALL = 0;
    public static final int TRANSIT_AID_TYPE_BANK_CARD = 4;
    public static final int TRANSIT_AID_TYPE_CAR_KEY = 1;
    public static final int TRANSIT_AID_TYPE_TRANSIT_CARD = 2;
    public static final int TRANSIT_EVENT_SOURCE_BINDER = 2;
    public static final int TRANSIT_EVENT_SOURCE_BROADCAST = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICaeNfcEventManager f395906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f395907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f395908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f395909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f395910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f395911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap f395912g;

    public static class DndConfigCallbackWrapper extends ICaeNfcDndConfigCallback.Stub {
        private final CaeNfcDndConfigCallback mCallback;

        public DndConfigCallbackWrapper(CaeNfcDndConfigCallback r100) {
            this.mCallback = r100;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcDndConfigCallback
        public void onDndConfigChanged(boolean r100, int r101) {
            this.mCallback.onDndConfigChanged(r100, r101);
        }
    }

    public static class ForceFwCallbackWrapper extends ICaeNfcForceFwEventCallback.Stub {
        private final CaeNfcForceFwEventCallback mCallback;

        @Override // com.obric.cae.libs.nfc.ICaeNfcForceFwEventCallback
        public void onForceFwDownload() {
            this.mCallback.onForceFwDownload();
        }

        public ForceFwCallbackWrapper(CaeNfcForceFwEventCallback r100) {
            this.mCallback = r100;
        }
    }

    public static class PaymentChangeCallbackWrapper extends ICaeNfcPaymentChangeCallback.Stub {
        private final CaeNfcPaymentChangeCallback mCallback;

        public PaymentChangeCallbackWrapper(CaeNfcPaymentChangeCallback r100) {
            this.mCallback = r100;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcPaymentChangeCallback
        public void onPaymentChanged(String r100) {
            this.mCallback.onPaymentChanged(r100);
        }
    }

    public static class TransitCallbackWrapper extends ICaeNfcTransitEventCallback.Stub {
        private final CaeNfcTransitEventCallback mCallback;

        public TransitCallbackWrapper(CaeNfcTransitEventCallback r100) {
            this.mCallback = r100;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcTransitEventCallback
        public void onTransitEvent(Bundle r100) {
            this.mCallback.onTransitEvent(r100);
        }
    }

    public static class VendorNciCallbackWrapper extends ICaeNfcVendorNciEventCallback.Stub {
        private final CaeNfcVendorNciEventCallback mCallback;

        public VendorNciCallbackWrapper(CaeNfcVendorNciEventCallback r100) {
            this.mCallback = r100;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcVendorNciEventCallback
        public void onVendorNciEvent(Bundle r100) {
            this.mCallback.onVendorNciEvent(r100);
        }
    }

    public int getTransitEventAllowedAidTypes() {
        ICaeNfcEventManager r100 = this.f395906a;
        if (r100 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "getTransitEventAllowedAidTypes: service is null");
        return 0;
    L11:
        return r100.getTransitEventAllowedAidTypes();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return 0;
    }

    public int getTransitEventSource() {
        ICaeNfcEventManager r100 = this.f395906a;
        if (r100 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "getTransitEventSource: service is null");
        return 1;
    L11:
        return r100.getTransitEventSource();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return 1;
    }

    public boolean isTransitEventFilterEnabled() {
        ICaeNfcEventManager r100 = this.f395906a;
        if (r100 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "isTransitEventFilterEnabled: service is null");
        return true;
    L11:
        return r100.isTransitEventFilterEnabled();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return true;
    }

    public CaeNfcEventManager(ICaeNfcEventManager r100) {
        this.f395907b = new ConcurrentHashMap();
        this.f395908c = new ConcurrentHashMap();
        this.f395909d = new ConcurrentHashMap();
        this.f395910e = new ConcurrentHashMap();
        this.f395911f = new ConcurrentHashMap();
        this.f395912g = new ConcurrentHashMap();
        this.f395906a = r100;
    }

    public boolean notifyTransitEvent(Bundle r100) {
        ICaeNfcEventManager r101 = this.f395906a;
        if (r101 != null) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "notifyTransitEvent: service is null");
        return false;
    L12:
        r101.notifyTransitEvent(r100);     // Catch: RemoteException -> L9
        return true;
    L9:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerCloudConfigCallback(ICaeNfcCloudConfigCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerCloudConfigCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerCloudConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcCloudConfigCallback r101 = (ICaeNfcCloudConfigCallback) this.f395907b.get(r100);
        if (r101 != null) goto L13;
        this.f395907b.put(r100, r100);
    L20:
        this.f395906a.registerCloudConfigCallback(r100);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    L13:
        r100 = r101;
        goto L20
    }

    public boolean registerDndConfigCallback(CaeNfcDndConfigCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerDndConfigCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerDndConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcDndConfigCallback r101 = (ICaeNfcDndConfigCallback) this.f395908c.get(r100);
        if (r101 != null) goto L19;
        r101 = new DndConfigCallbackWrapper(r100);
        this.f395908c.put(r100, r101);
    L19:
        this.f395906a.registerDndConfigCallback(r101);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerForceFwCallback(CaeNfcForceFwEventCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerForceFwCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerForceFwCallback: service is null");
        return false;
    L10:
        ICaeNfcForceFwEventCallback r101 = (ICaeNfcForceFwEventCallback) this.f395909d.get(r100);
        if (r101 != null) goto L19;
        r101 = new ForceFwCallbackWrapper(r100);
        this.f395909d.put(r100, r101);
    L19:
        this.f395906a.registerForceFwEventCallback(r101);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerPaymentChangeCallback(CaeNfcPaymentChangeCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerPaymentChangeCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerPaymentChangeCallback: service is null");
        return false;
    L10:
        ICaeNfcPaymentChangeCallback r101 = (ICaeNfcPaymentChangeCallback) this.f395912g.get(r100);
        if (r101 != null) goto L19;
        r101 = new PaymentChangeCallbackWrapper(r100);
        this.f395912g.put(r100, r101);
    L19:
        this.f395906a.registerPaymentChangeCallback(r101);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerTransitCallback(CaeNfcTransitEventCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerTransitCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerTransitCallback: service is null");
        return false;
    L10:
        ICaeNfcTransitEventCallback r101 = (ICaeNfcTransitEventCallback) this.f395910e.get(r100);
        if (r101 != null) goto L19;
        r101 = new TransitCallbackWrapper(r100);
        this.f395910e.put(r100, r101);
    L19:
        this.f395906a.registerTransitEventCallback(r101);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerVendorNciCallback(CaeNfcVendorNciEventCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerVendorNciCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerVendorNciCallback: service is null");
        return false;
    L10:
        ICaeNfcVendorNciEventCallback r101 = (ICaeNfcVendorNciEventCallback) this.f395911f.get(r100);
        if (r101 != null) goto L19;
        r101 = new VendorNciCallbackWrapper(r100);
        this.f395911f.put(r100, r101);
    L19:
        this.f395906a.registerVendorNciEventCallback(r101);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean setTransitEventAllowedAidTypes(int r100) {
        if (r100 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventAllowedAidTypes: invalid mask " + r100);
        return false;
    L12:
        ICaeNfcEventManager r102 = this.f395906a;
        if (r102 != null) goto L21;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventAllowedAidTypes: service is null");
        return false;
    L21:
        return r102.setTransitEventAllowedAidTypes(r100);
    L18:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    L5:
        if ((r100 & (-8)) != 0) goto L7;
        r101 = true;
        goto L9
    }

    public boolean setTransitEventFilterEnabled(boolean r100) {
        ICaeNfcEventManager r101 = this.f395906a;
        if (r101 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventFilterEnabled: service is null");
        return false;
    L11:
        return r101.setTransitEventFilterEnabled(r100);
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean setTransitEventSource(int r100) {
        boolean r101 = true;
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L9;
        r101 = false;
    L9:
        if (r101 == true) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventSource: invalid source " + r100);
        return false;
    L12:
        ICaeNfcEventManager r102 = this.f395906a;
        if (r102 != null) goto L21;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventSource: service is null");
        return false;
    L21:
        return r102.setTransitEventSource(r100);
    L18:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcCloudConfigCallback r101 = (ICaeNfcCloudConfigCallback) this.f395907b.remove(r100);
        if (r101 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: callback not found");
        return false;
    L20:
        this.f395906a.unregisterCloudConfigCallback(r101);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterDndConfigCallback(CaeNfcDndConfigCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcDndConfigCallback r101 = (ICaeNfcDndConfigCallback) this.f395908c.remove(r100);
        if (r101 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: callback not found");
        return false;
    L20:
        this.f395906a.unregisterDndConfigCallback(r101);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterForceFwCallback(CaeNfcForceFwEventCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: service is null");
        return false;
    L10:
        ICaeNfcForceFwEventCallback r101 = (ICaeNfcForceFwEventCallback) this.f395909d.remove(r100);
        if (r101 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: callback not found");
        return false;
    L20:
        this.f395906a.unregisterForceFwEventCallback(r101);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterPaymentChangeCallback(CaeNfcPaymentChangeCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: service is null");
        return false;
    L10:
        ICaeNfcPaymentChangeCallback r101 = (ICaeNfcPaymentChangeCallback) this.f395912g.remove(r100);
        if (r101 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: callback not found");
        return false;
    L20:
        this.f395906a.unregisterPaymentChangeCallback(r101);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterTransitCallback(CaeNfcTransitEventCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: service is null");
        return false;
    L10:
        ICaeNfcTransitEventCallback r101 = (ICaeNfcTransitEventCallback) this.f395910e.remove(r100);
        if (r101 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: callback not found");
        return false;
    L20:
        this.f395906a.unregisterTransitEventCallback(r101);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterVendorNciCallback(CaeNfcVendorNciEventCallback r100) {
        if (r100 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: callback is null");
        return false;
    L7:
        if (this.f395906a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: service is null");
        return false;
    L10:
        ICaeNfcVendorNciEventCallback r101 = (ICaeNfcVendorNciEventCallback) this.f395911f.remove(r100);
        if (r101 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: callback not found");
        return false;
    L20:
        this.f395906a.unregisterVendorNciEventCallback(r101);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }
}
