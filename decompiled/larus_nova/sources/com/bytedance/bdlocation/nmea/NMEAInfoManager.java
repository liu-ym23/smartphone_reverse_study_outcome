package com.bytedance.bdlocation.nmea;

import android.content.Context;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Handler;
import androidx.camera.video.AudioStats;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.sensor.DopInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;

/* JADX INFO: loaded from: classes10.dex */
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

        private NmeaMessageListener(NMEAInfoManager r100) {
            this.this$0 = r100;
        }

        private double parseDouble(String r100) {
            if (r100 != null) goto L5;
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L5:
            if (r100.trim().isEmpty() == true) goto L13;
            return CastDoubleProtector.parseDouble(r100.trim());
        L14:
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        L13:
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        private DopInfo parseGsa(String r110) {
            DopInfo r100 = new DopInfo();
            r100.pdop = AudioStats.AUDIO_AMPLITUDE_NONE;
            r100.hdop = AudioStats.AUDIO_AMPLITUDE_NONE;
            r100.vdop = AudioStats.AUDIO_AMPLITUDE_NONE;
            r100.timestampMs = System.currentTimeMillis();
            String[] r111 = r110.split("\\*");     // Catch: Exception -> L17
            if (r111.length != 0) goto L6;
            return r100;
        L6:
            String[] r112 = r111[0].split(",");     // Catch: Exception -> L17
            if (r112.length >= 4) goto L9;
            return r100;
        L9:
            double r101 = parseDouble(r112[r112.length - 3]);     // Catch: Exception -> L17
            double r102 = parseDouble(r112[r112.length - 2]);     // Catch: Exception -> L17
            double r103 = parseDouble(r112[r112.length - 1]);     // Catch: Exception -> L17
            if (r101 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        L15:
            r100.pdop = r101;     // Catch: Exception -> L17
            r100.hdop = r102;     // Catch: Exception -> L17
            r100.vdop = r103;     // Catch: Exception -> L17
            Logger.i("NMEAInfoManager: parsed DOP - pdop=" + r101 + ", hdop=" + r102 + ", vdop=" + r103);     // Catch: Exception -> L17
        L19:
            return r100;
        L12:
            if (r102 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L15;
            if (r103 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        L17:
            e = move-exception;
            Logger.e("NMEAInfoManager: parseGsa error", e);
            goto L19
        }

        public /* synthetic */ NmeaMessageListener(NMEAInfoManager r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.location.OnNmeaMessageListener
        public void onNmeaMessage(String r100, long r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (r100.isEmpty() == true) goto L24;
            int r102 = r100.indexOf(",");
            if (r102 < 0) goto L9;
            String r103 = r100.substring(0, r102);
        L11:
            if (r103.endsWith("GSA") == true) goto L13;
            return;
        L13:
            DopInfo r104 = parseGsa(r100);
            Object r105 = NMEAInfoManager.access$100(this.this$0);
            monitor-enter(r105);
            NMEAInfoManager.access$202(this.this$0, r104);     // Catch: Throwable -> L18
            monitor-exit(r105);     // Catch: Throwable -> L18
            return;
        L18:
            th = move-exception;
            throw th;
        L9:
            r103 = r100;
            goto L11
        }
    }

    public synchronized DopInfo getCurrentDopInfo() {
        monitor-enter(this);
        DopInfo r100 = this.mCurrentDopInfo;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void unregisterNmeaListener() {
        monitor-enter(this);
        LocationManager r100 = this.mLocationManager;     // Catch: Throwable -> L14 Exception -> L16
        if (r100 == null) goto L12;
        OnNmeaMessageListener r101 = this.mNmeaListener;     // Catch: Throwable -> L14 Exception -> L16
        if (r101 == null) goto L12;
        if (Build.VERSION.SDK_INT < 24) goto L11;
        this.mBPEAManager.removeNmeaListener(r100, r101);     // Catch: Throwable -> L14 Exception -> L16
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

    private NMEAInfoManager(Context r100) {
        this.mLock = new Object();
        this.mContext = r100;
        if (r100 != null) goto L6;
        Logger.i("NMEAInfoManager: Context is null!");
        return;
    L6:
        this.mLocationManager = (LocationManager) r100.getSystemService("location");
        this.mHandler = new Handler(ThreadLooperManager.getSensorCollectWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    public static /* synthetic */ Object access$100(NMEAInfoManager r100) {
        return r100.mLock;
    }

    public synchronized void registerNmeaListener(Object r100) {
        monitor-enter(this);
        StringBuilder r101 = new StringBuilder("NMEAInfoManager: registerNmeaListener start, collectDopEnabled=");     // Catch: Throwable -> L37 Exception -> L39
        r101.append(BDLocationConfig.isSensorDopEnabled());     // Catch: Throwable -> L37 Exception -> L39
        r101.append(", hasFineLocation=");     // Catch: Throwable -> L37 Exception -> L39
        r101.append(PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}));     // Catch: Throwable -> L37 Exception -> L39
        r101.append(", locationManager=");     // Catch: Throwable -> L37 Exception -> L39
        boolean r102 = true;
        if (this.mLocationManager == null) goto L7;
        boolean r103 = true;
    L8:
        r101.append(r103);     // Catch: Throwable -> L37 Exception -> L39
        r101.append(", sdkInt=");     // Catch: Throwable -> L37 Exception -> L39
        int r104 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L37 Exception -> L39
        r101.append(r104);     // Catch: Throwable -> L37 Exception -> L39
        Logger.i(r101.toString());     // Catch: Throwable -> L37 Exception -> L39
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
        if (r104 >= 24) goto L29;
        Logger.i("NMEAInfoManager: registerNmeaListener skipped (requires Android N+)");     // Catch: Throwable -> L37 Exception -> L39
        monitor-exit(this);
        return;
    L29:
        if (this.mNmeaListener != null) goto L31;
        this.mNmeaListener = new NmeaMessageListener(this, null);     // Catch: Throwable -> L37 Exception -> L39
    L31:
        this.mBPEAManager.addNmeaListener(this.mLocationManager, this.mNmeaListener, this.mHandler, r100);     // Catch: Throwable -> L37 Exception -> L39
        StringBuilder r105 = new StringBuilder("NMEAInfoManager: registerNmeaListener success (handler=");     // Catch: Throwable -> L37 Exception -> L39
        if (this.mHandler != null) goto L35;
        r102 = false;
    L35:
        r105.append(r102);     // Catch: Throwable -> L37 Exception -> L39
        r105.append(")");     // Catch: Throwable -> L37 Exception -> L39
        Logger.i(r105.toString());     // Catch: Throwable -> L37 Exception -> L39
    L41:
        monitor-exit(this);
        return;
    L7:
        r103 = false;
    L39:
        e = move-exception;
        Logger.e("NMEAInfoManager: registerNmeaListener error", e);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ DopInfo access$202(NMEAInfoManager r100, DopInfo r101) {
        r100.mCurrentDopInfo = r101;
        return r101;
    }
}
