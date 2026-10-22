package com.obric.cae.libs.useraware;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import com.obric.cae.libs.utils.SmartBindService;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes33.dex */
public class UserAwareAdapter {
    public static final int ENTER_COMPANY_GEOFENCE_EVENT = 3;
    public static final int ENTER_HOME_GEOFENCE_EVENT = 1;
    public static final int EXIT_COMPANY_GEOFENCE_EVENT = 4;
    public static final int EXIT_HOEM_GEOFENCE_EVENT = 2;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile UserAwareAdapter f395965f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeUserAware f395966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f395967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f395968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SmartBindService f395969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f395970e;

    public interface ServiceConnectionListener {
        void onServiceConnected(UserAwareAdapter r100);

        void onServiceDisconnected();
    }

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserAwareAdapter f395971a;

        public a(UserAwareAdapter r100) {
            this.f395971a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            r100.getPackageName();
            monitor-enter(UserAwareAdapter.class);
            UserAwareAdapter r101 = this.f395971a;     // Catch: Throwable -> L15
            r101.f395966a = null;     // Catch: Throwable -> L15
            monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L15
            Iterator r102 = r101.f395968c.iterator();
        L8:
            if (r102.hasNext() == false) goto L14;
            ServiceConnectionListener r103 = (ServiceConnectionListener) r102.next();
            if (r103 == null) goto L8;
            r103.onServiceDisconnected();     // Catch: Exception -> L13
            goto L8
        L14:
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            r100.getPackageName();
            monitor-enter(UserAwareAdapter.class);
            UserAwareAdapter r102 = this.f395971a;     // Catch: Throwable -> L15
            r102.f395966a = ICaeUserAware.Stub.asInterface(r101);     // Catch: Throwable -> L15
            monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L15
            Iterator r103 = this.f395971a.f395968c.iterator();
        L8:
            if (r103.hasNext() == false) goto L14;
            ServiceConnectionListener r104 = (ServiceConnectionListener) r103.next();
            if (r104 == null) goto L8;
            r104.onServiceConnected(this.f395971a);     // Catch: Exception -> L13
            goto L8
        L14:
            return;
        L15:
            th = move-exception;
            throw th;
        }
    }

    public boolean isServiceConnected() {
        if (this.f395966a != null) goto L6;
        this.f395969d.smartBindToService();
    L6:
        if (this.f395966a == null) goto L8;
        return true;
    L8:
        return false;
    }

    public void release() {
        if (this.f395966a == null) goto L5;
        this.f395967b.unbindService(this.f395970e);
        this.f395966a = null;
    L5:
        f395965f = null;
    }

    public void clearHomeWifiBssids() {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.clearHomeWifiBssids();     // Catch: RemoteException -> L7
        return;
    }

    public UserAwareAdapter(Context r100) {
        this.f395968c = new CopyOnWriteArrayList();
        a r101 = new a(this);
        this.f395970e = r101;
        Context r102 = r100.getApplicationContext();
        this.f395967b = r102;
        SmartBindService r103 = new SmartBindService(r102, r101, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.f395969d = r103;
        r103.smartBindToService();
    }

    public static UserAwareAdapter getInstance(Context r100) {
        if (f395965f != null) goto L15;
        monitor-enter(UserAwareAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f395965f != null) goto L9;
        f395965f = new UserAwareAdapter(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L11
    L15:
        return f395965f;
    }

    public void addBssidsToAvoidRomingScan(List<String> r100) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.addBssidsToAvoidRomingScan(r100);     // Catch: RemoteException -> L7
        return;
    }

    public void addHomeWifiBssids(List<String> r100) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.addHomeWifiBssids(r100);     // Catch: RemoteException -> L7
        return;
    }

    public boolean checkLocationPermission(Context r100) {
        if (com_obric_cae_libs_useraware_UserAwareAdapter_android_content_Context_checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L7;
        return true;
    L7:
        throw new SecurityException("Your app must grant ACCESS_FINE_LOCATION permission to use this SDK");
    }

    public void notifyGeofenceChanged(int r100) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.notifyGeofenceChanged(r100);     // Catch: RemoteException -> L7
        return;
    }

    public void notifyHarEvent(HarEventData r100) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.notifyHarEvent(r100);     // Catch: RemoteException -> L7
        return;
    }

    public void notifyLearningSuccess(boolean r100) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.notifyLearningSuccess(r100);     // Catch: RemoteException -> L7
        return;
    }

    public void notifyRoomChangedPredicted(int r100) {
        ICaeUserAware r101 = this.f395966a;
        if (r101 == null) goto L9;
        r101.notifyRoomChangedPredicted(r100);     // Catch: RemoteException -> L6
        return;
    L10:
        return;
    }

    public void registerCallback(ICaeUserAwareCallback r100) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.registerCallback(r100);     // Catch: RemoteException -> L7
        return;
    }

    public void registerConnectionListener(ServiceConnectionListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f395968c.contains(r100) == true) goto L10;
        this.f395968c.add(r100);
        if (this.f395966a == null) goto L11;
        r100.onServiceConnected(this);
        return;
    L11:
        return;
    }

    public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r100) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.registerSmartBluetoothEvent(r100);     // Catch: RemoteException -> L7
        return;
    }

    public void setHarMonitorParams(HarMonitorParams r100) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.setHarMonitorParams(r100);     // Catch: RemoteException -> L7
        return;
    }

    public void unregisterCallback(ICaeUserAwareCallback r100) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.unregisterCallback(r100);     // Catch: RemoteException -> L7
        return;
    }

    public void unregisterConnectionListener(ServiceConnectionListener r100) {
        this.f395968c.remove(r100);
    }

    public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r100) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.unregisterSmartBluetoothEvent(r100);     // Catch: RemoteException -> L7
        return;
    }

    public UserAwareAdapter(Context r100, ServiceConnectionListener r101) {
        CopyOnWriteArrayList r102 = new CopyOnWriteArrayList();
        this.f395968c = r102;
        this.f395970e = new a(this);
        this.f395967b = r100.getApplicationContext();
        if (r101 != null) goto L5;
    L10:
        SmartBindService r103 = new SmartBindService(this.f395967b, this.f395970e, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.f395969d = r103;
        r103.smartBindToService();
        return;
    L5:
        if (r102.contains(r101) == true) goto L8;
        r102.add(r101);
    L8:
        if (this.f395966a == null) goto L10;
        r101.onServiceConnected(this);     // Catch: Exception -> L12
        goto L10
    }

    private static int com_obric_cae_libs_useraware_UserAwareAdapter_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_obric_cae_libs_useraware_UserAwareAdapter_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static UserAwareAdapter getInstance(Context r100, ServiceConnectionListener r101) {
        if (f395965f != null) goto L15;
        monitor-enter(UserAwareAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f395965f != null) goto L9;
        f395965f = new UserAwareAdapter(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L11
    L15:
        return f395965f;
    }

    public void setHarState(int r100, long r101, int r102) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.setHarState(r100, r101, r102);     // Catch: RemoteException -> L7
        return;
    }

    public void setLevel2DataCollection(List<HarLevel2DataReq> r100, int r101, HarLevel2DataResp r102) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.f395966a.setLevel2DataCollection(r100, r101, r102);     // Catch: RemoteException -> L7
        return;
    }
}
