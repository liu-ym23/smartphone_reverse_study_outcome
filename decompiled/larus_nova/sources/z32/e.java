package z32;

import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeValueNode;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f569870b = null;

    static {
        f569870b = new e();
    }

    public e() {
    }

    @JvmStatic
    public static final void c(PSRealtimeValueNode r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.f(f569870b.f569864a, r100.getValueNodeName(), 1);
    }

    @JvmStatic
    public static final void a(PSRealtimeIndicatorNode r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "indicator");
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.e(f569870b.f569864a, r100.getIndicatorNodeName(), r101);
    }

    @JvmStatic
    public static final void b(PSRealtimeIndicatorNode r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "indicator");
        EventName r102 = f569870b.f569864a;
        String r103 = r100.getIndicatorNodeName();
        if (r101 == false) goto L5;
        long r104 = 1;
    L6:
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.e(r102, r103, r104);
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
