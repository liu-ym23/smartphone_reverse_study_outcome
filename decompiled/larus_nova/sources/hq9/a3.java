package hq9;

import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;

/* JADX INFO: loaded from: classes4.dex */
public interface a3 {

    public static final class a {
        public static /* synthetic */ void a(a3 r100, LocationResult r101, Integer r102, GeoLocationInfo r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = 0;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = null;
        L8:
            r100.a(r101, r102, r103);
        }
    }

    void a(LocationResult r100, Integer r101, GeoLocationInfo r102);
}
