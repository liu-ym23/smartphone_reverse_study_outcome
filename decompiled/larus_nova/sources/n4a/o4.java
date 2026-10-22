package n4a;

import android.location.GnssStatus;
import android.os.Build;
import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: classes32.dex */
public final class o4 extends GnssStatus.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q4 f517577a;

    public o4(q4 r100) {
        this.f517577a = r100;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onFirstFix(int r100) {
        AMapLocation r101 = q4.D;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onStarted() {
        AMapLocation r100 = q4.D;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onStopped() {
        this.f517577a.f517618q = 0;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onSatelliteStatusChanged(GnssStatus r100) {
        q4 r101 = this.f517577a;
        r101.getClass();
        int r102 = 0;
        if (r100 != null) goto L22;
    L18:
        r101.f517618q = r102;
        return;
    L22:
    L16:
        th = th;
    L17:
        c4.g(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
        goto L18
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L18;
        int r103 = r100.getSatelliteCount();     // Catch: Throwable -> L16
        int r104 = 0;
    L8:
        if (r102 >= r103) goto L15;
        if (r100.usedInFix(r102) == false) goto L12;
        r104 = r104 + 1;
    L12:
        r102 = r102 + 1;
    L13:
        th = th;
        r102 = r104;
        goto L17
    L15:
        r102 = r104;
        goto L18
    }
}
