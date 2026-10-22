package com.bytedance.bdlocation.nmea;

import android.content.Context;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Handler;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.sensor.DopInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class NMEAInfoManager {
    private static volatile NMEAInfoManager sInstance;
    private IBPEALocal mBPEAManager;
    private Context mContext;
    private volatile DopInfo mCurrentDopInfo;
    private Handler mHandler;
    private LocationManager mLocationManager;
    private final Object mLock;
    private OnNmeaMessageListener mNmeaListener;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.nmea.NMEAInfoManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class NmeaMessageListener implements OnNmeaMessageListener {
        final /* synthetic */ NMEAInfoManager this$0;

        private NmeaMessageListener(NMEAInfoManager r1) {
            this.this$0 = r1;
        }

        private double parseDouble(String r4) {
            if (r4 != null) goto L5;
            return 0.0d;
        L5:
            if (r4.trim().isEmpty() == true) goto L13;
            return CastDoubleProtector.parseDouble(r4.trim());
        L14:
            return 0.0d;
        L13:
            return 0.0d;
        }

        private DopInfo parseGsa(String r11) {
            DopInfo r1 = new DopInfo();
            r1.pdop = 0.0d;
            r1.hdop = 0.0d;
            r1.vdop = 0.0d;
            r1.timestampMs = System.currentTimeMillis();
            String[] r12 = r11.split("\\*");     // Catch: Exception -> L17
            if (r12.length != 0) goto L6;
            return r1;
        L6:
            String[] r13 = r12[0].split(",");     // Catch: Exception -> L17
            if (r13.length >= 4) goto L9;
            return r1;
        L9:
            double r4 = parseDouble(r13[r13.length - 3]);     // Catch: Exception -> L17
            double r6 = parseDouble(r13[r13.length - 2]);     // Catch: Exception -> L17
            double r8 = parseDouble(r13[r13.length - 1]);     // Catch: Exception -> L17
            if (r4 <= 0.0d) goto L12;
        L15:
            r1.pdop = r4;     // Catch: Exception -> L17
            r1.hdop = r6;     // Catch: Exception -> L17
            r1.vdop = r8;     // Catch: Exception -> L17
            Logger.i("NMEAInfoManager: parsed DOP - pdop=" + r4 + ", hdop=" + r6 + ", vdop=" + r8);     // Catch: Exception -> L17
        L19:
            return r1;
        L12:
            if (r6 > 0.0d) goto L15;
            if (r8 <= 0.0d) goto L19;
        L17:
            e = move-exception;
            Logger.e("NMEAInfoManager: parseGsa error", e);
            goto L19
        }

        public /* synthetic */ NmeaMessageListener(NMEAInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.location.OnNmeaMessageListener
        public void onNmeaMessage(String r1, long r2) {
            if (r1 != null) goto L4;
            return;
        L4:
            if (r1.isEmpty() == true) goto L24;
            int r3 = r1.indexOf(",");
            if (r3 < 0) goto L9;
            String r4 = r1.substring(0, r3);
        L11:
            if (r4.endsWith("GSA") == true) goto L13;
            return;
        L13:
            DopInfo r5 = parseGsa(r1);
            Object r6 = NMEAInfoManager.access$100(this.this$0);
            monitor-enter(r6);
            NMEAInfoManager.access$202(this.this$0, r5);     // Catch: Throwable -> L18
            monitor-exit(r6);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;
        L9:
            r4 = r1;
            goto L11
        }
    }

    public synchronized DopInfo getCurrentDopInfo() {
        monitor-enter(this);
        DopInfo r0 = this.mCurrentDopInfo;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void unregisterNmeaListener() {
        monitor-enter(this);
        LocationManager r1 = this.mLocationManager;     // Catch: Throwable -> L14 Exception -> L16
        if (r1 == null) goto L12;
        OnNmeaMessageListener r2 = this.mNmeaListener;     // Catch: Throwable -> L14 Exception -> L16
        if (r2 == null) goto L12;
        if (Build.VERSION.SDK_INT < 24) goto L11;
        this.mBPEAManager.removeNmeaListener(r1, r2);     // Catch: Throwable -> L14 Exception -> L16
    L11:
        Logger.i("NMEAInfoManager: unregisterNmeaListener success");     // Catch: Throwable -> L14 Exception -> L16
    L12:
        this.mNmeaListener = null;     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        e = move-exception;
        Logger.e("NMEAInfoManager: unregisterNmeaListener error", e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mNmeaListener = null;     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public static NMEAInfoManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(NMEAInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NMEAInfoManager(BDLocationConfig.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(NMEAInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private NMEAInfoManager(Context r2) {
        this.mLock = new Object();
        this.mContext = r2;
        if (r2 != null) goto L6;
        Logger.i("NMEAInfoManager: Context is null!");
        return;
    L6:
        this.mLocationManager = (LocationManager) r2.getSystemService(LocationMonitorConst.LOCATION);
        this.mHandler = new Handler(ThreadLooperManager.getSensorCollectWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    public static /* synthetic */ Object access$100(NMEAInfoManager r0) {
        return r0.mLock;
    }

    public synchronized void registerNmeaListener(Object r8) {
        monitor-enter(this);
        StringBuilder r2 = new StringBuilder("NMEAInfoManager: registerNmeaListener start, collectDopEnabled=");     // Catch: Throwable -> L37 Exception -> L39
        r2.append(BDLocationConfig.isSensorDopEnabled());     // Catch: Throwable -> L37 Exception -> L39
        r2.append(", hasFineLocation=");     // Catch: Throwable -> L37 Exception -> L39
        r2.append(PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}));     // Catch: Throwable -> L37 Exception -> L39
        r2.append(", locationManager=");     // Catch: Throwable -> L37 Exception -> L39
        boolean r3 = true;
        if (this.mLocationManager == null) goto L7;
        boolean r1 = true;
    L8:
        r2.append(r1);     // Catch: Throwable -> L37 Exception -> L39
        r2.append(", sdkInt=");     // Catch: Throwable -> L37 Exception -> L39
        int r4 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L37 Exception -> L39
        r2.append(r4);     // Catch: Throwable -> L37 Exception -> L39
        Logger.i(r2.toString());     // Catch: Throwable -> L37 Exception -> L39
        if (BDLocationConfig.isSensorDopEnabled() == true) goto L14;
        Logger.i("NMEAInfoManager: registerNmeaListener skipped (collectContinueDopInfo disabled)");     // Catch: Throwable -> L37 Exception -> L39
        monitor-exit(this);
        return;
    L14:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L19;
        Logger.i("NMEAInfoManager: registerNmeaListener skipped (no ACCESS_FINE_LOCATION permission)");     // Catch: Throwable -> L37 Exception -> L39
        monitor-exit(this);
        return;
    L19:
        if (this.mLocationManager != null) goto L24;
        Logger.i("NMEAInfoManager: registerNmeaListener skipped (LocationManager is null)");     // Catch: Throwable -> L37 Exception -> L39
        monitor-exit(this);
        return;
    L24:
        if (r4 >= 24) goto L29;
        Logger.i("NMEAInfoManager: registerNmeaListener skipped (requires Android N+)");     // Catch: Throwable -> L37 Exception -> L39
        monitor-exit(this);
        return;
    L29:
        if (this.mNmeaListener != null) goto L31;
        this.mNmeaListener = new NmeaMessageListener(this, null);     // Catch: Throwable -> L37 Exception -> L39
    L31:
        this.mBPEAManager.addNmeaListener(this.mLocationManager, this.mNmeaListener, this.mHandler, r8);     // Catch: Throwable -> L37 Exception -> L39
        StringBuilder r9 = new StringBuilder("NMEAInfoManager: registerNmeaListener success (handler=");     // Catch: Throwable -> L37 Exception -> L39
        if (this.mHandler != null) goto L35;
        r3 = false;
    L35:
        r9.append(r3);     // Catch: Throwable -> L37 Exception -> L39
        r9.append(")");     // Catch: Throwable -> L37 Exception -> L39
        Logger.i(r9.toString());     // Catch: Throwable -> L37 Exception -> L39
    L41:
        monitor-exit(this);
        return;
    L7:
        r1 = false;
    L39:
        e = move-exception;
        Logger.e("NMEAInfoManager: registerNmeaListener error", e);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ DopInfo access$202(NMEAInfoManager r0, DopInfo r1) {
        r0.mCurrentDopInfo = r1;
        return r1;
    }
}
