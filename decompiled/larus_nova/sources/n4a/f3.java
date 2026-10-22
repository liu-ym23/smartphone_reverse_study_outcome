package n4a;

import android.os.SystemClock;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.loc.es;

/* JADX INFO: loaded from: classes32.dex */
public final class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public es f517278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f517279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f517280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f517281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f517282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f517283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AMapLocation f517284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f517285h;

    public f3() {
        this.f517278a = null;
        this.f517279b = 0;
        this.f517280c = 0;
        this.f517281d = true;
        this.f517282e = 0;
        this.f517283f = 0;
        this.f517284g = null;
        this.f517285h = 0;
    }

    public final void b() {
        this.f517278a = null;
        this.f517279b = 0;
        this.f517280c = 0;
        this.f517284g = null;
        this.f517285h = 0;
    }

    public final void c(es r100) {
        if (j4.m(r100) == true) goto L5;
        return;
    L5:
        if (this.f517281d == true) goto L7;
    L13:
        int r101 = this.f517282e;
    L14:
        r100.setLocationType(r101);
        return;
    L7:
        if (com.loc.h.e(r100.getTime()) == false) goto L13;
        if (r100.getLocationType() != 5) goto L11;
    L12:
        r101 = 4;
        goto L14
    L11:
        if (r100.getLocationType() == 6) goto L12;
    }

    public final AMapLocation a(AMapLocation r100) {
        if (j4.l(r100) == true) goto L5;
        return r100;
    L5:
        long r101 = SystemClock.elapsedRealtime() - this.f517285h;
        this.f517285h = SystemClock.elapsedRealtime();
        if (r101 <= 5000) goto L8;
        return r100;
    L8:
        AMapLocation r102 = this.f517284g;
        if (r102 != null) goto L13;
        this.f517284g = r100;
        return r100;
    L13:
        if (1 == r102.getLocationType()) goto L19;
        if (GeocodeSearch.GPS.equalsIgnoreCase(this.f517284g.getProvider()) == true) goto L19;
        this.f517284g = r100;
        return r100;
    L19:
        if (this.f517284g.getAltitude() == r100.getAltitude()) goto L21;
    L24:
        long r103 = Math.abs(r100.getTime() - this.f517284g.getTime());
        if (30000 >= r103) goto L29;
        this.f517284g = r100;
        return r100;
    L29:
        if (j4.a(r100, this.f517284g) > (((((this.f517284g.getSpeed() + r100.getSpeed()) * r103) / 2000.0f) + ((this.f517284g.getAccuracy() + r100.getAccuracy()) * 2.0f)) + 3000.0f)) goto L31;
        this.f517284g = r100;
        return r100;
    L31:
        return this.f517284g;
    L21:
        if (this.f517284g.getLongitude() != r100.getLongitude()) goto L24;
        this.f517284g = r100;
        return r100;
    }
}
