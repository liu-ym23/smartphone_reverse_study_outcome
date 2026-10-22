package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothCallbackExporter;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter;
import com.obric.cae.libs.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes33.dex */
public class CaeBluetoothDeviceManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile CaeBluetoothDeviceManager f395853e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f395854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ICaeBluetoothExporter f395855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f395856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f395857d;

    public interface CaeBluetoothServiceListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeBluetoothDeviceManager f395858a;

        public a(CaeBluetoothDeviceManager r100) {
            this.f395858a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            LogUtil.d("CaeBluetoothDeviceManager", "onServiceDisconnected: " + r100);
            CaeBluetoothDeviceManager r101 = this.f395858a;
            r101.f395855b = null;
            ArrayList r102 = r101.f395856c;
            monitor-enter(r102);
            Iterator r103 = this.f395858a.f395856c.iterator();     // Catch: Throwable -> L10
        L6:
            if (r103.hasNext() == false) goto L8;
            ((CaeBluetoothServiceListener) r103.next()).onServiceDisconnected();     // Catch: Throwable -> L10
            goto L6
        L8:
            monitor-exit(r102);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            LogUtil.d("CaeBluetoothDeviceManager", "onServiceConnected: " + r100);
            this.f395858a.f395855b = ICaeBluetoothExporter.Stub.asInterface(r101);
            ArrayList r102 = this.f395858a.f395856c;
            monitor-enter(r102);
            Iterator r103 = this.f395858a.f395856c.iterator();     // Catch: Throwable -> L10
        L6:
            if (r103.hasNext() == false) goto L8;
            ((CaeBluetoothServiceListener) r103.next()).onServiceConnected();     // Catch: Throwable -> L10
            goto L6
        L8:
            monitor-exit(r102);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public boolean bindService() {
        a r100 = this.f395857d;
        monitor-enter(r100);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.f395855b == null) goto L9;
        LogUtil.d("CaeBluetoothDeviceManager", "Service is already connected.");     // Catch: Throwable -> L26
        monitor-exit(r100);     // Catch: Throwable -> L26
        return true;
    L9:
        LogUtil.d("CaeBluetoothDeviceManager", "Binding cae bluetooth service...");     // Catch: Throwable -> L26
        Intent r101 = new Intent();     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        r101.setComponent(new ComponentName("com.obric.cae", "com.obric.cae.smartBluetooth.SmartBluetoothService"));     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        r101.setAction("com.obric.cae.libs.bluetooth.ICaeBluetoothExporter");     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        if (this.f395854a.bindService(r101, this.f395857d, 1) == true) goto L16;
        LogUtil.e("CaeBluetoothDeviceManager", "Fail to bind to: " + r101);     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        monitor-exit(r100);     // Catch: Throwable -> L26
        return false;
    L16:
        monitor-exit(r100);     // Catch: Throwable -> L26
        return true;
    L22:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Fail to bind to: " + e);     // Catch: Throwable -> L26
        return false;
    L18:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Exception: " + e);     // Catch: Throwable -> L26
        return false;
    }

    public void unbindService() {
        a r100 = this.f395857d;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f395855b == null) goto L12;
        LogUtil.d("CaeBluetoothDeviceManager", "Unbinding cae bluetooth service...");     // Catch: Throwable -> L14
        this.f395854a.unbindService(this.f395857d);     // Catch: Exception -> L9 Throwable -> L14
    L11:
        this.f395855b = null;     // Catch: Throwable -> L14
        goto L12
    L9:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Exception during unbind: " + e);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
    }

    public CaeBluetoothDeviceManager(Context r100) {
        this.f395856c = new ArrayList();
        this.f395857d = new a(this);
        this.f395854a = r100.getApplicationContext();
    }

    public static CaeBluetoothDeviceManager getInstance(Context r100) {
        if (f395853e != null) goto L15;
        monitor-enter(CaeBluetoothDeviceManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f395853e != null) goto L9;
        f395853e = new CaeBluetoothDeviceManager(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeBluetoothDeviceManager.class);     // Catch: Throwable -> L11
    L15:
        return f395853e;
    }

    public void addServiceListener(CaeBluetoothServiceListener r100) {
        if (r100 == null) goto L15;
        ArrayList r101 = this.f395856c;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (this.f395856c.contains(r100) == true) goto L8;
        this.f395856c.add(r100);     // Catch: Throwable -> L12
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L12
        if (this.f395855b == null) goto L18;
        r100.onServiceConnected();
        return;
    L18:
        return;
    }

    public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r100) {
        ICaeBluetoothExporter r101 = this.f395855b;
        if (r101 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "getDeviceType: Service is not connected");
    L10:
        return new BtDeviceInfoExtEvent(r100, 0);
    L11:
        return r101.getDeviceType(r100);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        goto L10
    }

    public int getProductId(BluetoothDevice r100) {
        ICaeBluetoothExporter r101 = this.f395855b;
        if (r101 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "getProductId: Service is not connected");
        return 0;
    L11:
        return r101.getProductId(r100);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return 0;
    }

    public void registerEventCallback(ICaeBluetoothCallbackExporter r100) {
        ICaeBluetoothExporter r101 = this.f395855b;
        if (r101 != null) goto L10;
        LogUtil.w("CaeBluetoothDeviceManager", "registerEventCallback: Service is not connected");
        return;
    L10:
        r101.registerEventCallback(r100);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
    }

    public void removeServiceListener(CaeBluetoothServiceListener r100) {
        if (r100 == null) goto L11;
        ArrayList r101 = this.f395856c;
        monitor-enter(r101);
        this.f395856c.remove(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregisterEventCallback(ICaeBluetoothCallbackExporter r100) {
        ICaeBluetoothExporter r101 = this.f395855b;
        if (r101 != null) goto L10;
        LogUtil.w("CaeBluetoothDeviceManager", "unregisterEventCallback: Service is not connected");
        return;
    L10:
        r101.unregisterEventCallback(r100);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
    }
}
