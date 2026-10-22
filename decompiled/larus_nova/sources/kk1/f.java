package kk1;

import com.bytedance.android.live.core.utils.h0;
import com.bytedance.android.livehostapi.platform.depend.FpsMonitorCallback;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements FpsMonitorCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f503764a;

    public f(h r100) {
        this.f503764a = r100;
    }

    @Override // com.bytedance.android.livehostapi.platform.depend.FpsMonitorCallback
    public final void onDataReady(double r210, JSONObject r211) {
        h r100 = this.f503764a;
        r100.f503767b = r211;
        r100.f503768c = Double.valueOf(r210);
        h r101 = this.f503764a;
        JSONObject r102 = r101.f503767b;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101.f503768c != null) goto L8;
        return;
    L8:
        if (r101.f503771f == true) goto L10;
        r101.f503767b = null;
        r101.f503768c = null;
        return;
    L10:
        float r103 = h0.a();
        Iterator<String> r104 = r102.keys();
        int r105 = 0;
        float r106 = 0.0f;
        float r107 = 0.0f;
        float r110 = 0.0f;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
    L12:
        if (r104.hasNext() == false) goto L38;
        String r116 = r104.next();
        int r117 = CastIntegerProtector.parseInt(r116);
        int r118 = r102.optInt(r116);
        if (r117 != 0) goto L17;
        r105 = r105 + r118;
    L37:
        r111 = Math.max(r111, r117);
        goto L12
    L17:
        if (1 > r117) goto L23;
        if (2 < r117) goto L23;
        r112 = r112 + r118;
    L23:
        if (3 > r117) goto L29;
        if (6 < r117) goto L29;
        r113 = r113 + r118;
        r106 = r106 + ((r118 * r117) * r103);
    L29:
        if (7 > r117) goto L35;
        if (13 < r117) goto L35;
        r114 = r114 + r118;
        r107 = r107 + ((r118 * r117) * r103);
    L35:
        if (r117 < 14) goto L37;
        r115 = r115 + r118;
        r110 = r110 + ((r118 * r117) * r103);
        goto L37
    L38:
        int r108 = (r113 + r114) + r115;
        Double r109 = r101.f503768c;
        if (r109 == null) goto L41;
        double r119 = r109.doubleValue();
    L42:
        com.bytedance.android.livesdk.utils.landscape.a r120 = new com.bytedance.android.livesdk.utils.landscape.a(r108, r119, r101.f503770e - r101.f503769d, (((r105 + r112) + r113) + r114) + r115, r111, r112, r113, r114, r115, (r106 + r107) + r110, r101.f503776k);
        LandscapeLiveMonitor.Companion.getClass();
        Intrinsics.checkNotNullParameter(r120, "fluencyInfo");
        LandscapeLiveMonitor r121 = LandscapeLiveMonitor.a.b();
        if (r121 == null) goto L45;
        LandscapeLiveMonitor.access$reportFluency(r121, r120);
    L45:
        r101.f503767b = null;
        r101.f503768c = null;
        return;
    L41:
        r119 = 0.0f;
        goto L42
    }
}
