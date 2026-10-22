package l84;

import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ d0 a;

    public /* synthetic */ v(d0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();
        Logger.i("outerBackgroundTask upload info");
        LocationUtil.uploadDeviceStatus("bdlocation_background_switch", 0);
    }
}
