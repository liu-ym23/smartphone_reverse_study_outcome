package n48;

import com.larus.api.LocationService;
import com.larus.platform.model.GeoLocationInfo;

/* JADX INFO: loaded from: classes24.dex */
public final class d {
    public d() {
    }

    public final String a() {
        GeoLocationInfo r100 = LocationService.f286873a.m();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCityCode();
    }
}
