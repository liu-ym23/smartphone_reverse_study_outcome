package z00;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l implements LocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f569600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f569601b;

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
    }

    @Override // android.location.LocationListener
    @Deprecated(message = "Deprecated in Java")
    public final void onStatusChanged(String r100, int r101, Bundle r102) {
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location r210) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r210};
        f06.b r112 = new f06.b();
        g06.a r100 = ApiHookConfig.f245611b.get(100038);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r113 = r104;
        int r114 = r103;
        f06.a[] r115 = r102;
        f06.d r106 = r105.preInvoke(100038, "com/bytedance/android/live/broadcast/widget/PreviewLocationWidgetHelper$readLocationForSaas$1", "onLocationChanged", this, r111, "void", r112);     // Catch: Exception -> L21
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L21
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        Intrinsics.checkNotNullParameter(r210, "location");
        int r107 = m.f569602a;
        m.b(this.f569600a, r210, this.f569601b);
        return;
    L14:
        r104 = r113 + 1;
        r103 = r114;
        r102 = r115;
        goto L8
    L15:
        r106 = new f06.d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }

    public l(Context r100, Function1 r101) {
        this.f569600a = r100;
        this.f569601b = r101;
    }
}
