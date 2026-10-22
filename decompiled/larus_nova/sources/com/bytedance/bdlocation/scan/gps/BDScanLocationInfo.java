package com.bytedance.bdlocation.scan.gps;

import android.os.SystemClock;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
public class BDScanLocationInfo {
    private volatile BDLocation aMapLocation;
    private final boolean gpsUseContinuous;
    private final String locateId;
    private final List<BDGnssInfo> mGnssInfoList;
    private final List<BDGpsInfo> mGpsInfoList;
    private final List<Long> mGpsInfoReportClocks;
    private final List<BDLocation> mGpsLocationList;
    private volatile BDLocation sysLocation;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.gps.BDScanLocationInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy = null;

        static {
            int[] r100 = new int[TakeStrategy.values().length];
            $SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy = r100;
            r100[TakeStrategy.firstResult.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy[TakeStrategy.lastResult.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum TakeStrategy extends Enum<TakeStrategy> {
        private static final /* synthetic */ TakeStrategy[] $VALUES = null;
        public static final TakeStrategy firstResult = null;
        public static final TakeStrategy lastResult = null;

        static {
            TakeStrategy r100 = new TakeStrategy("firstResult", 0);
            firstResult = r100;
            TakeStrategy r101 = new TakeStrategy("lastResult", 1);
            lastResult = r101;
            $VALUES = new TakeStrategy[]{r100, r101};
        }

        public static TakeStrategy[] values() {
            return (TakeStrategy[]) $VALUES.clone();
        }

        public static TakeStrategy valueOf(String r100) {
            return (TakeStrategy) a.a(TakeStrategy.class, r100);
        }

        private TakeStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void cleanGnssInfo() {
        List<BDGnssInfo> r100 = this.mGnssInfoList;
        monitor-enter(r100);
        this.mGnssInfoList.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanGpsInfo() {
        List<BDGpsInfo> r100 = this.mGpsInfoList;
        monitor-enter(r100);
        this.mGpsInfoList.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void cleanGpsLocation() {
        List<BDLocation> r100 = this.mGpsLocationList;
        monitor-enter(r100);
        this.mGpsLocationList.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public List<BDGnssInfo> getGnssInfoList() {
        List<BDGnssInfo> r100 = this.mGnssInfoList;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mGnssInfoList);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public List<BDGpsInfo> getGpsInfo() {
        List<BDGpsInfo> r100 = this.mGpsInfoList;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mGpsInfoList);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public List<Long> getGpsInfoReportClocks() {
        List<Long> r100 = this.mGpsInfoReportClocks;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mGpsInfoReportClocks);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public List<BDLocation> getGpsLocation() {
        List<BDLocation> r100 = this.mGpsLocationList;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mGpsLocationList);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public BDLocation getAMapLocation() {
        return this.aMapLocation;
    }

    public String getLocateId() {
        return this.locateId;
    }

    public BDLocation getSysLocation() {
        return this.sysLocation;
    }

    public boolean isContinuousGps() {
        return this.gpsUseContinuous;
    }

    public void addGnssInfo(BDGnssInfo r100) {
        List<BDGnssInfo> r101 = this.mGnssInfoList;
        monitor-enter(r101);
        this.mGnssInfoList.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addGpsInfo(BDGpsInfo r100) {
        List<BDGpsInfo> r101 = this.mGpsInfoList;
        monitor-enter(r101);
        this.mGpsInfoList.add(r100);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        List<Long> r102 = this.mGpsInfoReportClocks;
        monitor-enter(r102);
        this.mGpsInfoReportClocks.add(Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    public void addGpsLocation(BDLocation r100) {
        List<BDLocation> r101 = this.mGpsLocationList;
        monitor-enter(r101);
        this.mGpsLocationList.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public BDGnssInfo findNearbyGnssInfo(BDGpsInfo r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        List<BDGnssInfo> r100 = this.mGnssInfoList;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(this.mGnssInfoList);     // Catch: Throwable -> L19
        monitor-exit(r100);     // Catch: Throwable -> L19
        if (r101.isEmpty() == false) goto L12;
        return null;
    L12:
        BDGnssInfo r102 = (BDGnssInfo) ListProtector.get(r101, 0);
        int r103 = r101.size() - 1;
    L13:
        if (r103 < 0) goto L26;
        BDGnssInfo r104 = (BDGnssInfo) ListProtector.get(r101, r103);
        if (r110.callbackClock > r104.callbackClock) goto L18;
        r103 = r103 - 1;
        goto L13
    L18:
        return r104;
    L26:
        return r102;
    L19:
        th = move-exception;
        throw th;
    }

    public void setAMapLocation(BDLocation r100) {
        this.aMapLocation = r100;
    }

    public void setSysLocation(BDLocation r100) {
        this.sysLocation = r100;
    }

    public BDGpsInfo takeGpsInfo(TakeStrategy r100) {
        List<BDGpsInfo> r101 = this.mGpsInfoList;
        monitor-enter(r101);
        BDGpsInfo r102 = (BDGpsInfo) takeFromSequence(this.mGpsInfoList, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public BDLocation takeGpsLocation(TakeStrategy r100) {
        List<BDLocation> r101 = this.mGpsLocationList;
        monitor-enter(r101);
        BDLocation r102 = (BDLocation) takeFromSequence(this.mGpsLocationList, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public BDScanLocationInfo(String r100, boolean r101) {
        this.mGpsInfoList = new ArrayList(8);
        this.mGpsLocationList = new ArrayList(8);
        this.mGnssInfoList = new ArrayList(16);
        this.mGpsInfoReportClocks = new ArrayList(8);
        this.locateId = r100;
        this.gpsUseContinuous = r101;
    }

    private <T> T takeFromSequence(List<T> r100, TakeStrategy r101) {
        if (r100.isEmpty() == true) goto L12;
        int r102 = AnonymousClass1.$SwitchMap$com$bytedance$bdlocation$scan$gps$BDScanLocationInfo$TakeStrategy[r101.ordinal()];
        int r103 = 0;
        if (r102 == 1) goto L11;
        if (r102 != 2) goto L11;
        r103 = r100.size() - 1;
    L11:
        return (T) ListProtector.get(r100, r103);
    L12:
        return null;
    }
}
