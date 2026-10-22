package n4a;

import android.os.Bundle;
import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: classes32.dex */
public final class b4 {
    public static void a(AMapLocation r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Bundle r101 = r100.getExtras();
        if (r101 != null) goto L9;
        Bundle r102 = new Bundle();
        r102.putInt(AMapLocation.LBS_REAL_LOCATION_TYPE, r100.getLocationType());
        r100.setExtras(r102);
        return;
    L9:
        if (r101.containsKey(AMapLocation.LBS_REAL_LOCATION_TYPE) == true) goto L12;
        r101.putInt(AMapLocation.LBS_REAL_LOCATION_TYPE, r100.getLocationType());
        return;
    }
}
