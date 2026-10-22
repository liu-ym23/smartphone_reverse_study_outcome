package n4a;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import com.amap.api.location.AMapLocation;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class p4 implements GpsStatus.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q4 f517588a;

    public p4(q4 r100) {
        this.f517588a = r100;
    }

    @Override // android.location.GpsStatus.Listener
    public final void onGpsStatusChanged(int r100) {
        q4 r101 = this.f517588a;     // Catch: Throwable -> L37
        LocationManager r102 = r101.f517604c;     // Catch: Throwable -> L37
        if (r102 != null) goto L6;
        return;
    L6:
        r101.f517619r = r102.getGpsStatus(r101.f517619r);     // Catch: Throwable -> L37
        if (r100 == 1) goto L35;
        int r103 = 0;
        if (r100 != 2) goto L11;
        this.f517588a.f517618q = 0;     // Catch: Throwable -> L37
        return;
    L11:
        if (r100 != 3) goto L13;
        AMapLocation r104 = q4.D;     // Catch: Throwable -> L37
        return;
    L13:
        if (r100 != 4) goto L49;
        q4 r105 = this.f517588a;     // Catch: Throwable -> L37
        r105.getClass();     // Catch: Throwable -> L37
        GpsStatus r106 = r105.f517619r;     // Catch: Throwable -> L27
        if (r106 == null) goto L29;
        Iterable<GpsSatellite> r107 = r106.getSatellites();     // Catch: Throwable -> L27
        if (r107 == null) goto L29;
        Iterator<GpsSatellite> r108 = r107.iterator();     // Catch: Throwable -> L27
        int r109 = r105.f517619r.getMaxSatellites();     // Catch: Throwable -> L27
    L22:
        if (r108.hasNext() == false) goto L29;
        if (r103 >= r109) goto L29;
        if (r108.next().usedInFix() == false) goto L22;
        r103 = r103 + 1;
        goto L22
    L29:
        r105.f517618q = r103;     // Catch: Throwable -> L37
        return;
    L27:
        th = move-exception;
        c4.g(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");     // Catch: Throwable -> L37
        goto L29
    L49:
        return;
    L35:
        AMapLocation r110 = q4.D;     // Catch: Throwable -> L37
        return;
    L37:
        th = move-exception;
        new StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th.getMessage());
        c4.g(th, "GpsLocation", "onGpsStatusChanged");
    }
}
